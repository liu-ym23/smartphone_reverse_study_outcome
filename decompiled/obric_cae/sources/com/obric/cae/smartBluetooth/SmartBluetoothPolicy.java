package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.res.XmlResourceParser;
import com.obric.cae.R;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.log.CaeLog;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothPolicy {
    private static final String TAG = "SmartBluetoothPolicy";
    private static final String XML_ATTRIBUTE_DETAIL_MESSAGE = "detail_message";
    private static final String XML_ATTRIBUTE_ERROR_CODE = "error_code";
    private static final String XML_ATTRIBUTE_SOLUTION = "solution";
    private static final String XML_TAG_POLICY = "policy";
    private Context mContext;
    private final Map<String, PolicyProperties> mPolicies;

    public class PolicyProperties {
        private String mDetailMessage;
        private String mErrorCode;
        private String mSolution;
        final /* synthetic */ SmartBluetoothPolicy this$0;

        public PolicyProperties(SmartBluetoothPolicy r8, String r10, String r11, String r12) {
            this.this$0 = r8;
            this.mDetailMessage = r10;
            this.mErrorCode = r11;
            this.mSolution = r12;
        }

        public String getDetailMessage() {
            return this.mDetailMessage;
        }

        public String getErrorCode() {
            return this.mErrorCode;
        }

        public String getSolution() {
            return this.mSolution;
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("PolicyProperties{, detailMessage='");
            r8.append(this.mDetailMessage);
            r8.append("', errorCode='");
            r8.append(this.mErrorCode);
            r8.append("', solution='");
            return android.aimedia.a.i(r8, this.mSolution, "'}");
        }
    }

    public SmartBluetoothPolicy(Context r8) {
        this.mContext = r8;
        this.mPolicies = new ConcurrentHashMap();
        parseSmartBluetoothPolicy();
    }

    private void addToInteropDatabase(String r8, BluetoothDevice r10) {
        SmartBluetoothBinderClient r11 = SmartBluetoothManager.getInstance(this.mContext).getBluetoothBinderClient();
        if (r11 == null) goto L6;
        r11.addDeviceToDatabase(r8, r10);
        return;
    }

    private PolicyProperties getPolicy(String r8) {
        if (this.mPolicies.containsKey(r8) == true) goto L5;
        return null;
    L5:
        return this.mPolicies.get(r8);
    }

    private void parseSmartBluetoothPolicy() {
        XmlResourceParser r8 = this.mContext.getResources().getXml(R.xml.smart_bluetooth_policy);
        int r10 = r8.getDepth();
    L23:
        int r11 = r8.next();     // Catch: XmlPullParserException -> L17 IOException -> L19
        if (r11 == 1) goto L36;
        if (r11 == 3) goto L8;
    L9:
        if (r11 == 3) goto L23;
        if (r11 == 4) goto L23;
        if (XML_TAG_POLICY.equals(r8.getName()) == false) goto L23;
        String r12 = r8.getAttributeValue(null, XML_ATTRIBUTE_DETAIL_MESSAGE);     // Catch: XmlPullParserException -> L17 IOException -> L19
        PolicyProperties r13 = new PolicyProperties(this, r12, r8.getAttributeValue(null, "error_code"), r8.getAttributeValue(null, "solution"));     // Catch: XmlPullParserException -> L17 IOException -> L19
        this.mPolicies.put(r12, r13);     // Catch: XmlPullParserException -> L17 IOException -> L19
        CaeLog.d(TAG, "policyProperties: " + r13);     // Catch: XmlPullParserException -> L17 IOException -> L19
        goto L23
    L8:
        if (r8.getDepth() > r10) goto L9;
        return;
    L36:
        return;
    L19:
        e = e;
        String r14 = TAG;
        StringBuilder r15 = new StringBuilder("");
    L21:
        r15.append(e);
        CaeLog.e(r14, r15.toString());
        return;
    L17:
        e = e;
        r14 = TAG;
        r15 = new StringBuilder("");
        goto L21
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        Map<String, PolicyProperties> r8 = this.mPolicies;
        if (r8 == null) goto L6;
        r8.clear();
        return;
    }

    public void performPolicyVerification(CaeBluetoothEvent r8) {
        String r10 = TAG;
        CaeLog.d(r10, "performPolicyVerification");
        PolicyProperties r11 = getPolicy(r8.getDetailMessage());
        CaeLog.d(r10, "policyProperties = " + r11);
        if (r11 == null) goto L6;
        CaeLog.d(r10, "smart bluetooth policy matched.");
        addToInteropDatabase(r11.getSolution(), r8.getBluetoothDevice());
        SmartBluetoothManager.getInstance(this.mContext).getDatabase().updateCaePolicyInfoToDB(r8, r11);
        SmartBluetoothManager.getInstance(this.mContext).getCloudSyncer().postCaeEventToCloud(r8);
        return;
    }
}

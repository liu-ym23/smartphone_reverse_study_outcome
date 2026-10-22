package c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class u extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f1086b = null;

    static {
        f1085a = new String[]{"android.permission.RECEIVE_SMS"};
        f1086b = new ArrayList();
    }

    public u() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r18, Intent r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        m.i("SmsBroadcastReceiver", "onReceive intent=" + r19.getAction());
        if ("android.provider.Telephony.SMS_RECEIVED".equals(r19.getAction()) == false) goto L8;
    L9:
        StringBuilder r5 = new StringBuilder();
        ArrayList r10 = new ArrayList();
        String r11 = r19.getStringExtra("format");
        Object[] r12 = (Object[]) r19.getExtras().get("pdus");
        int r13 = r12.length;
        int r14 = 0;
        long r15 = 0;
        String r16 = "";
        String r17 = null;
    L10:
        if (r14 >= r13) goto L16;
        SmsMessage r20 = SmsMessage.createFromPdu((byte[]) r12[r14], r11);
        if (r20 == null) goto L14;
        long r21 = r20.getTimestampMillis();
        String r22 = r20.getServiceCenterAddress();
        r5.append(r20.getMessageBody());
        r17 = r20.getOriginatingAddress();
        r15 = r21;
        r16 = r22;
    L14:
        r14 = r14 + 1;
        goto L10
    L16:
        if (TextUtils.isEmpty(r17) == true) goto L40;
        if (r17.contains("@") == true) goto L40;
        if (r17.startsWith("9") == true) goto L34;
        if (r17.startsWith("10") == true) goto L34;
        if (r17.startsWith("11") == true) goto L34;
        if (r17.startsWith("12") == true) goto L34;
        if (r17.startsWith("4") == true) goto L34;
        if (r17.startsWith("00") == false) goto L40;
    L34:
        if (TextUtils.isEmpty(r17) == false) goto L36;
    L38:
        m.n("SmsBroadcastReceiver", "onReceive sms data not right. ");
        goto L40
    L36:
        if (TextUtils.isEmpty(r5.toString()) == true) goto L38;
        r10.add(new o0(r17, r15, r16, r5.toString()));
    L40:
        if (r10.isEmpty() == true) goto L52;
        ArrayList r23 = f1086b;
        if (r23.isEmpty() == true) goto L53;
        Iterator r24 = r23.iterator();
    L45:
        if (r24.hasNext() == false) goto L54;
        ((n0) r24.next()).a(r10);
        goto L45
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L8:
        if ("com.android.internal.telephony.VERIFY_CODE_SMS_RECEIVED".equals(r19.getAction()) == true) goto L9;
    }
}

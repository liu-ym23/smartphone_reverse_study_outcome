package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.SerializeFactory;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleInfo implements Serializable {
    private static final String FILE_NAME = "locale.inf";
    private static final String KEY_LOC_NETWORK_ACCESS = "access";
    private static final String KEY_LOC_TIMEZONE = "timezone";
    private static final String UNKNOWN = "unknown";
    private static final long serialVersionUID = 1;
    public final String mNetworkAccessType;
    public final int mTimeZone;

    private LocaleInfo() {
        this.mNetworkAccessType = getNetworkAccessType();
        this.mTimeZone = getTimeZone();
    }

    public static void dump(File r2) {
        SerializeFactory.store(new File(r2, FILE_NAME), new LocaleInfo());
    }

    public static String getNetworkAccessType() {
        String r0 = Net.getNetworkAccessTypeName();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "unknown";
    L6:
        return r0;
    }

    public static int getTimeZone() {
        int r0 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r0 < (-12)) goto L8;
        if (r0 > 12) goto L7;
        return r0;
    L7:
        return 12;
    L8:
        return -12;
    }

    public static LocaleInfo load(File r2) {
        return (LocaleInfo) ZeusTransformUtils.preCheckCast(SerializeFactory.load(new File(r2, FILE_NAME)), LocaleInfo.class, "com.obric.memorydata.plugin");
    }

    public static void putTo(JSONObject r1) {
        putTo(r1, null);
    }

    public static void putTo(JSONObject r2, File r3) {
        if (r3 == null) goto L4;
        LocaleInfo r4 = load(r3);
    L5:
        if (r4 == null) goto L11;
        r2.put("access", r4.mNetworkAccessType);     // Catch: JSONException -> L8
        r2.put("timezone", r4.mTimeZone);     // Catch: JSONException -> L8
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r4 = new LocaleInfo();
        goto L5
    }
}

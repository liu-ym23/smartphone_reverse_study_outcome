package com.bytedance.crash.dumper;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.SerializeFactory;
import java.io.File;
import java.io.Serializable;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
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

    public static void dump(File r10) {
        SerializeFactory.store(new File(r10, FILE_NAME), new LocaleInfo());
    }

    @NonNull
    public static String getNetworkAccessType() {
        String r10 = Net.getNetworkAccessTypeName();
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "unknown";
    L6:
        return r10;
    }

    public static int getTimeZone() {
        int r10 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r10 < (-12)) goto L8;
        if (r10 > 12) goto L7;
        return r10;
    L7:
        return 12;
    L8:
        return -12;
    }

    public static LocaleInfo load(File r10) {
        return (LocaleInfo) SerializeFactory.load(new File(r10, FILE_NAME));
    }

    public static void putTo(JSONObject r10) {
        putTo(r10, null);
    }

    public static void putTo(JSONObject r10, File r11) {
        if (r11 == null) goto L4;
        LocaleInfo r12 = load(r11);
    L5:
        if (r12 == null) goto L11;
        r10.put("access", r12.mNetworkAccessType);     // Catch: JSONException -> L8
        r10.put("timezone", r12.mTimeZone);     // Catch: JSONException -> L8
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r12 = new LocaleInfo();
        goto L5
    }
}

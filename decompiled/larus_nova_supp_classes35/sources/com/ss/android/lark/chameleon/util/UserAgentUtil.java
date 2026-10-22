package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/util/UserAgentUtil;", BuildConfig.FLAVOR, "()V", "getUserAgent", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UserAgentUtil {
    public static final UserAgentUtil INSTANCE = null;

    static {
        INSTANCE = new UserAgentUtil();
    }

    private UserAgentUtil() {
    }

    public final String getUserAgent(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String r9 = WebSettings.getDefaultUserAgent(r8.getApplicationContext());     // Catch: Exception -> L5
    L6:
        StringBuffer r0 = new StringBuffer();
        if (r9 == null) goto L19;
        int r1 = r9.length();
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L19;
        char r4 = r9.charAt(r3);
        if (Intrinsics.compare(r4, 31) > 0) goto L13;
    L16:
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r0.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r4)}, 1)));
    L17:
        r3 = r3 + 1;
        goto L9
    L13:
        if (Intrinsics.compare(r4, 127) >= 0) goto L16;
        r0.append(r4);
    L19:
        return r0.toString();
    L5:
        r9 = System.getProperty("http.agent");
        goto L6
    }
}

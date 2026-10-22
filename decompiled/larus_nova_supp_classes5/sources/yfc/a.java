package yfc;

import com.bytedance.common.support.PushCommonSupport;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static String a;

    public a() {
    }

    public static String a(String r3) {
        StringBuilder r0 = new StringBuilder();
        if (a == null) goto L5;
    L14:
        r0.append(a);
        r0.append(r3);
        return r0.toString();
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mHost;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }
}

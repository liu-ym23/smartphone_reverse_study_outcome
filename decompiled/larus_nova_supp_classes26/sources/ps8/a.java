package ps8;

import com.larus.platform.api.IVideoController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: ps8.a$a, reason: collision with other inner class name */
    public static final class C0129a {
        public static /* synthetic */ IVideoController a(a r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L5;
            r4 = "default";
        L5:
            String r1 = null;
            if ((r5 & 2) == 0) goto L8;
            String r0 = "";
        L10:
            if ((r5 & 4) == 0) goto L13;
            r1 = "";
        L13:
            return r3.a(r4, r0, r1);
        L8:
            r0 = null;
            goto L10
        }
    }

    IVideoController a(String r1, String r2, String r3);

    void b(String r1);

    IVideoController c(String r1, Integer r2, String r3);
}

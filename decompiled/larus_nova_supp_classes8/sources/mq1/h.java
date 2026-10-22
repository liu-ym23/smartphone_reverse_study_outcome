package mq1;

import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void a(h r2, boolean r3, int r4, int r5) {
            if ((r5 & 2) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r5 & 4) == 0) goto L8;
            String r6 = "default";
        L9:
            r2.a(r3, r4, r6, false);
            return;
        L8:
            r6 = LiveEndPageData.TAG_REPLAY;
            goto L9
        }
    }

    public interface b {
        void p8(boolean r1, int r2, String r3);
    }

    void a(boolean r1, int r2, String r3, boolean r4);

    void c(b r1);

    void d(b r1);
}

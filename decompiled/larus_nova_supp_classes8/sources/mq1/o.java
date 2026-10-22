package mq1;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ void a(o r8, int r9, int r10, int r11, String r12, int r13) {
            if ((r13 & 2) == 0) goto L5;
            int r4 = 0;
        L7:
            if ((r13 & 4) == 0) goto L9;
            int r5 = 0;
        L11:
            if ((r13 & 8) == 0) goto L13;
            r12 = "";
        L13:
            r8.h3(r9, r4, r5, r12, null);
            return;
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }
    }

    void Sa(Episode r1, String r2, String r3, String r4, String r5, String r6, String r7, boolean r8);

    void T5(long r1);

    void a(long r1, String r3, Bundle r4);

    void h3(int r1, int r2, int r3, String r4, Object r5);

    void onInputStateChange(boolean r1);
}

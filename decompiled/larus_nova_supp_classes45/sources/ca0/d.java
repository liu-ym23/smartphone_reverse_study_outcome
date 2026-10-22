package ca0;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface d extends dy0.c {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable a(d r12, Context r13, long r14, String r16, int r17, String r18, String r19, Map r21, int r22) {
            if ((r22 & 16) == 0) goto L5;
            int r6 = 0;
        L7:
            if ((r22 & 32) == 0) goto L9;
            String r7 = "";
        L11:
            if ((r22 & 64) == 0) goto L13;
            String r8 = "";
        L15:
            if ((r22 & 256) == 0) goto L17;
            String r11 = "";
        L19:
            if ((r22 & 512) == 0) goto L21;
            Map r15 = null;
        L23:
            return r12.n(r13, r14, 1, r16, r6, r7, r8, 0, r11, r15);
        L21:
            r15 = r21;
            goto L23
        L17:
            r11 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r7 = null;
            goto L11
        L5:
            r6 = r17;
            goto L7
        }
    }

    Observable<p2> n(Context r1, long r2, int r4, String r5, int r6, String r7, String r8, int r9, String r11, Map<String, String> r12);
}

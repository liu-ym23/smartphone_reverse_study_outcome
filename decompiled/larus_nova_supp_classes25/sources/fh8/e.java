package fh8;

import android.widget.LinearLayout;
import com.larus.im.bean.message.block.Block;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(vg8.m r14, LinearLayout r15, String r16, t r17, l r18, Function1 r19, Function1 r20, Function1 r21, Map r22, f r23, Block r24, r r25, int r26) {
        if ((r26 & 2) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r26 & 128) == 0) goto L9;
        Map r10 = null;
    L11:
        if ((r26 & 512) == 0) goto L13;
        Block r12 = null;
    L15:
        if ((r26 & 1024) == 0) goto L17;
        r r13 = null;
    L18:
        r14.e(r15, r4, r17, r18, r19, r20, r21, r10, r23, r12, r13);
        return;
    L17:
        r13 = r25;
        goto L18
    L13:
        r12 = r24;
        goto L15
    L9:
        r10 = r22;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }
}

package zb8;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.input.s;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e$a {
    public static /* synthetic */ void a(e r1, f r2, s r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r3 = new c();
    L6:
        if ((r4 & 4) == 0) goto L8;
        Function0 r5 = new d();
    L9:
        r1.mQ(r2, r3, r5);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public static /* synthetic */ void b(e r10, String r11, HashMap r12, a r13, CameraResultRoute r14, CameraOutputContext r15, boolean r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        a r5 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        CameraResultRoute r7 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        CameraOutputContext r8 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        boolean r9 = false;
    L18:
        r10.L40(r11, r12, r5, null, r7, r8, r9);
        return;
    L17:
        r9 = r16;
        goto L18
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}

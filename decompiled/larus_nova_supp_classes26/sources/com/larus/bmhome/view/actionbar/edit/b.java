package com.larus.bmhome.view.actionbar.edit;

import android.content.Intent;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.instruction.t0;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r14, r r15, LinearLayout r16, c r17, ActivityResultLauncher r18, ActivityResultLauncher r19, n r20, d r21, List r22, boolean r23, t0 r24, int r25) {
            if ((r25 & 2) == 0) goto L5;
            LinearLayout r5 = null;
        L7:
            if ((r25 & 4) == 0) goto L9;
            c r6 = null;
        L11:
            if ((r25 & 8) == 0) goto L13;
            ActivityResultLauncher r7 = null;
        L15:
            if ((r25 & 16) == 0) goto L17;
            ActivityResultLauncher r8 = null;
        L19:
            if ((r25 & 32) == 0) goto L21;
            n r9 = null;
        L23:
            if ((r25 & 64) == 0) goto L25;
            d r10 = null;
        L27:
            if ((r25 & 128) == 0) goto L29;
            List r11 = CollectionsKt.mutableListOf(new Integer[]{15});
        L31:
            if ((r25 & 256) == 0) goto L33;
            boolean r12 = false;
        L35:
            if ((r25 & 512) == 0) goto L37;
            t0 r13 = null;
        L38:
            r14.f(r15, r5, r6, r7, r8, r9, r10, r11, r12, r13);
            return;
        L37:
            r13 = r24;
            goto L38
        L33:
            r12 = r23;
            goto L35
        L29:
            r11 = r22;
            goto L31
        L25:
            r10 = r21;
            goto L27
        L21:
            r9 = r20;
            goto L23
        L17:
            r8 = r19;
            goto L19
        L13:
            r7 = r18;
            goto L15
        L9:
            r6 = r17;
            goto L11
        L5:
            r5 = r16;
            goto L7
        }
    }

    Pair<Boolean, Boolean> F7();

    void T1();

    boolean a();

    List<u> b();

    List<u> c();

    Long d();

    List<u> e();

    void f(r r1, LinearLayout r2, c r3, ActivityResultLauncher<String> r4, ActivityResultLauncher<Intent> r5, n r6, d r7, List<Integer> r8, boolean r9, Function1<? super up8.b, Unit> r10);

    LiveData<Map<String, Object>> g();

    void h(Uri r1);

    void i(int r1);

    Integer j();

    void k();

    boolean l();

    void m();

    void onViewShow();

    void requestFocus();
}

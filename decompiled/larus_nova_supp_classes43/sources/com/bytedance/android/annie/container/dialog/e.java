package com.bytedance.android.annie.container.dialog;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements com.bytedance.android.livesdk.pannel.e {
    public final /* synthetic */ BaseDialogFragment a;

    public final boolean a() {
        PopupHybridParamVoNew r0 = this.a.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L31;
        BaseDialogFragment r10 = this.a;
        if (r10.l == false) goto L32;
        HybridFragment r11 = r10.f;
        if ((r11 instanceof AnnieFragment) == false) goto L14;
        AnnieFragment r12 = (AnnieFragment) r11;
    L15:
        if (r12 == null) goto L27;
        WeakReference<View> r13 = r12.S;
        if (r13 == null) goto L23;
        View r14 = r13.get();
        if (r14 == null) goto L23;
        if (r14.canScrollVertically(-1) != true) goto L23;
        boolean r15 = true;
    L25:
        if ((!r15) != true) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == false) goto L33;
        return true;
    L33:
        return false;
    L23:
        r15 = false;
    L27:
        r16 = false;
        goto L28
    L14:
        r12 = null;
        goto L15
    L32:
        return false;
    L31:
        return this.a.l;
    L5:
        if (r0.c() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean b() {
        PopupHybridParamVoNew r0 = this.a.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.R2() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean c() {
        return this.a.k;
    }

    public final boolean d() {
        return this.a.j;
    }

    public final boolean e() {
        if (com.bytedance.android.annie.ng.g.b().b.c == true) goto L13;
        PopupHybridParamVoNew r0 = this.a.e;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.S2() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public e(BaseDialogFragment r1) {
        this.a = r1;
    }

    public final boolean f(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        HybridFragment r0 = this.a.f;
        if ((r0 instanceof AnnieFragment) == false) goto L5;
        AnnieFragment r1 = (AnnieFragment) r0;
    L6:
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.inIgnoreArea(r10);
    L5:
        r1 = null;
        goto L6
    }
}

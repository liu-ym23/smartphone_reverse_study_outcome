package com.bytedance.android.annie.debug.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.debug.controller.BaseActionControl$bindScanAction$1;
import com.bytedance.android.annie.util.p;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/BaseDebugDialogFragment;", "Lcom/bytedance/android/annie/debug/ui/BaseCommonDialogFragment;", "Lcom/bytedance/android/annie/debug/controller/f;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class BaseDebugDialogFragment extends BaseCommonDialogFragment implements com.bytedance.android.annie.debug.controller.f {
    @Override // com.bytedance.android.annie.debug.controller.f
    public final View Eg() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364806);
    }

    @Override // com.bytedance.android.annie.debug.controller.f
    public final View Tn() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364709);
    }

    @Override // com.bytedance.android.annie.debug.controller.f
    public final View fv() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364822);
    }

    @Override // com.bytedance.android.annie.debug.controller.f
    public final View nx() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364782);
    }

    @Override // com.bytedance.android.annie.debug.ui.BaseCommonDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setLayout((int) (((double) p.a.e()) * 0.7d), -2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.annie.debug.controller.f
    public final View qh() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131364693);
    }

    public BaseDebugDialogFragment() {
    }

    @Override // com.bytedance.android.annie.debug.controller.f
    public final AnnieCard ac() {
        return this.d;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Context r12 = getContext();
        if (r12 == null) goto L25;
        AnnieCard r0 = this.d;
        if (r0 == null) goto L8;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L8;
    L9:
        final com.bytedance.android.annie.debug.controller.e r13 = new com.bytedance.android.annie.debug.controller.e(r12, this, r1);
        View r14 = r13.b.nx();
        if (r14 == null) goto L12;
        r14.setOnClickListener(new com.bytedance.android.annie.debug.controller.c(r13));
    L12:
        View r15 = r13.b.Eg();
        if (r15 == null) goto L15;
        r15.setOnClickListener(new com.bytedance.android.annie.debug.controller.d(r13));
    L15:
        View r16 = r13.b.fv();
        if (r16 == null) goto L18;
        r16.setOnClickListener(new BaseActionControl$bindScanAction$1(r13));
    L18:
        View r17 = r13.b.Tn();
        if (r17 == null) goto L21;
        r17.setOnClickListener(new com.bytedance.android.annie.debug.controller.b(r13));
    L21:
        View r18 = r13.b.qh();
        if (r18 == null) goto L26;
        r18.setOnClickListener(new com.bytedance.android.annie.debug.controller.a(r13));
        return;
    L26:
        return;
    L8:
        r1 = "host";
        goto L9
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        return r10.inflate(2131558767, r11, false);
    }
}

package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftDialogViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            UgcGiftDialogViewModel r2 = this.a.a.x;
            if (r2 == null) goto L6;
            r2.c();
            return;
        }
    }

    public o(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        UgcGiftSaleDialog r8 = this.a;
        UgcGiftDialogViewModel r0 = r8.x;
        if (r0 == null) goto L7;
        PropertyOwner r1 = r0.d;
        if (r1 == null) goto L7;
        PanelOperationState r2 = (PanelOperationState) r1.a;
    L8:
        int r3 = 0;
        if (r2 != PanelOperationState.Top) goto L12;
        f2.c(s1.B(2131922995), 0);
        return;
    L12:
        FragmentActivity r9 = r8.getActivity();
        if (r9 == null) goto L19;
        int r4 = UgcGiftPoolDialog.r;
        UgcGiftSaleDialog r5 = this.a;
        int r6 = r5.d;
        String r10 = r5.e;
        Function0<Unit> r11 = r5.f;
        a r13 = new a(this);
        Intrinsics.checkNotNullParameter(r10, "clickFrom");
        UgcGiftPoolDialog r14 = new UgcGiftPoolDialog();
        r14.d = r6;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r14.e = r10;
        r14.f = r11;
        r14.n = r13;
        FragmentManager r15 = r9.getSupportFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "InteractGiftPoolDialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r14, r16) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L18:
        r14.show(r15, "InteractGiftPoolDialog");
    L19:
        com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
        com.bytedance.android.livesdk.gift.platform.core.preview.a r17 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r18 = this.a.m;
        if (r18 == null) goto L22;
        r3 = r18.getItemCount();
    L22:
        UgcGiftSaleDialog r19 = this.a;
        int r20 = r19.d;
        String r21 = r19.e;
        r17.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.a.a(r3, r20, r21, "add");
        return;
    L7:
        r2 = null;
        goto L8
    }
}

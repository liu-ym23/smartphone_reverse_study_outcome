package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftDialogViewModel;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleDialog;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSaleDialog extends BaseUgcGiftDialog {
    public static final /* synthetic */ int z = 0;
    public View p;
    public View q;
    public Long r;
    public View s;
    public View t;
    public View u;
    public View v;
    public boolean w;
    public UgcGiftDialogViewModel x;
    public com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g y;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90() {
        RecyclerView r0 = this.g;
        Context r1 = getContext();
        UgcGiftDialogViewModel r2 = this.x;
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return new UgcGiftSaleAdapter(r1, r0, r2);
    L7:
        return null;
    }

    public UgcGiftSaleDialog() {
    }

    public final void T90(PanelOperationState r3) {
        UgcGiftDialogViewModel r0 = this.x;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "state");
        r0.c.a(r3);
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        DialogInterface.OnDismissListener r3 = this.n;
        if (r3 == null) goto L6;
        r3.onDismiss(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        r0.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g r5 = new com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r5, "scope");
        String r1 = this.e;
        Intrinsics.checkNotNullParameter(r1, "value");
        r5.g = r1;
        r5.f = this.r;
        Integer r2 = Integer.valueOf(this.d);
        r5.e = r2;
        Object r3 = e33.k.a;
        if (r2 != r3) goto L6;
        String r6 = "sourceFrom";
    L12:
        if (r6 != null) goto L25;
        com.bytedance.android.scope.l.a(r5);
        Unit r7 = Unit.INSTANCE;
        this.y = r5;
        Intrinsics.checkNotNull(r5);
        UgcGiftDialogViewModel r8 = (UgcGiftDialogViewModel) r0.d(r5, UgcGiftDialogViewModel.class);
        this.x = r8;
        if (r8 == null) goto L20;
        PropertyOwner r9 = r8.b;
        if (r9 == null) goto L20;
        Observable r10 = RxUtilKt.h(r9);
        if (r10 == null) goto L20;
        r10.subscribe(new r(this));
    L20:
        View r11 = this.k;
        if (r11 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r11);
        return;
    L26:
        return;
    L25:
        throw new UninitializedPropertyAccessException(r6);
    L6:
        if (r5.f != r3) goto L9;
        r6 = "locationGiftId";
        goto L12
    L9:
        if (r5.g != r3) goto L11;
        r6 = "clickFrom";
        goto L12
    L11:
        r6 = null;
        goto L12
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L16
        super.onDismiss(r2);     // Catch: Throwable -> L16
        View r3 = this.k;     // Catch: Throwable -> L16
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r3);     // Catch: Throwable -> L16
    L5:
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.g r4 = this.y;     // Catch: Throwable -> L16
        if (r4 != null) goto L8;
    L13:
        com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();     // Catch: Throwable -> L16
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        if (com.bytedance.android.scope.l.b(r4) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        com.bytedance.android.scope.l.c(r4);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        View r9 = r7.findViewById(2131362241);
        TextView r1 = null;
        if (r9 == null) goto L5;
        r9.setVisibility(0);
        Unit r2 = Unit.INSTANCE;
    L6:
        this.p = r9;
        View r10 = r7.findViewById(2131385968);
        if (r10 == null) goto L9;
        r10.setVisibility(0);
        Unit r3 = Unit.INSTANCE;
    L10:
        this.s = r10;
        View r11 = r7.findViewById(2131385092);
        int r4 = 8;
        if (r11 == null) goto L13;
        r11.setVisibility(8);
        Unit r5 = Unit.INSTANCE;
    L14:
        this.q = r11;
        View r13 = r7.findViewById(2131381019);
        if (r13 != null) goto L17;
        r13 = null;
    L22:
        this.t = r13;
        View r14 = r7.findViewById(2131384219);
        if (r14 != null) goto L25;
        r14 = null;
    L29:
        this.v = r14;
        TextView r15 = (TextView) r7.findViewById(2131388772);
        if (r15 == null) goto L32;
        r15.setText(getString(2131917632));
        Unit r16 = Unit.INSTANCE;
    L32:
        TextView r17 = (TextView) r7.findViewById(2131381026);
        if (r17 == null) goto L35;
        r17.setText((String) u.b.getValue(null, u.a[0]));
        Unit r18 = Unit.INSTANCE;
    L35:
        View r19 = r7.findViewById(2131381018);
        if (r19 == null) goto L38;
        r19.setOnClickListener(new l(this));
        Unit r6 = Unit.INSTANCE;
    L39:
        this.u = r19;
        TextView r20 = (TextView) r7.findViewById(2131387553);
        if (r20 == null) goto L47;
        r20.setVisibility(0);
        Object[] r21 = new Object[1];
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r23 = this.m;
        if (r23 == null) goto L45;
        String r24 = String.valueOf(r23.getItemCount());
        if (r24 == null) goto L45;
    L46:
        r21[0] = r24;
        r20.setText(getString(2131917631, r21));
        Unit r0 = Unit.INSTANCE;
        r1 = r20;
    L45:
        r24 = "0";
    L47:
        this.h = r1;
        View r25 = r7.findViewById(2131367009);
        r25.setOnClickListener(new m(this));
        Unit r26 = Unit.INSTANCE;
        this.j = r25;
        View r27 = r7.findViewById(2131363762);
        r27.setOnClickListener(new n(this));
        this.i = r27;
        View r28 = this.p;
        if (r28 == null) goto L50;
        r28.setOnClickListener(new o(this));
    L50:
        View r29 = this.s;
        if (r29 == null) goto L53;
        r29.setOnClickListener(new p(this));
    L53:
        View r30 = this.q;
        if (r30 == null) goto L56;
        r30.setOnClickListener(new q(this));
    L56:
        T90(PanelOperationState.Remove);
        return;
    L38:
        r19 = null;
        goto L39
    L25:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.preview.j.b.getValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.a[0])).booleanValue() == false) goto L27;
        r4 = 0;
    L27:
        r14.setVisibility(r4);
        Unit r31 = Unit.INSTANCE;
        goto L29
    L17:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.preview.j.c.getValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.a[1])).booleanValue() == false) goto L19;
        int r33 = 0;
    L20:
        r13.setVisibility(r33);
        Unit r34 = Unit.INSTANCE;
        goto L22
    L19:
        r33 = 8;
        goto L20
    L13:
        r11 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }
}

package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftPoolViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftPoolDialog;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftDialog;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftPoolDialog extends BaseUgcGiftDialog {
    public static final /* synthetic */ int r = 0;
    public UgcGiftPoolViewModel p;
    public com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> S90() {
        RecyclerView r0 = this.g;
        UgcGiftPoolViewModel r1 = this.p;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        return new UgcGiftPoolAdapter(r0, r1);
    L6:
        return null;
    }

    public final void T90() {
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f r0 = this.q;
        if (r0 != null) goto L5;
    L10:
        com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
        DialogInterface.OnDismissListener r1 = this.n;
        if (r1 == null) goto L14;
        r1.onDismiss(null);
        return;
    L14:
        return;
    L5:
        if (com.bytedance.android.scope.l.b(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        com.bytedance.android.scope.l.c(r0);
        goto L10
    }

    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L8:
        T90();
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public UgcGiftPoolDialog() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setStyle(1, 2131954830);
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        r0.getClass();
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f r5 = new com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.f(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r5, "scope");
        String r1 = this.e;
        Intrinsics.checkNotNullParameter(r1, "value");
        r5.f = r1;
        Integer r2 = Integer.valueOf(this.d);
        r5.e = r2;
        Object r3 = e33.k.a;
        if (r2 != r3) goto L6;
        String r6 = "sourceFrom";
    L9:
        if (r6 != null) goto L19;
        com.bytedance.android.scope.l.a(r5);
        Unit r7 = Unit.INSTANCE;
        this.q = r5;
        Intrinsics.checkNotNull(r5);
        UgcGiftPoolViewModel r8 = (UgcGiftPoolViewModel) r0.d(r5, UgcGiftPoolViewModel.class);
        this.p = r8;
        if (r8 == null) goto L20;
        PropertyOwner r9 = r8.b;
        if (r9 == null) goto L21;
        Observable r10 = RxUtilKt.h(r9);
        if (r10 == null) goto L22;
        r10.subscribe(new f(this));
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        throw new UninitializedPropertyAccessException(r6);
    L6:
        if (r5.f != r3) goto L8;
        r6 = "clickFrom";
        goto L9
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftDialog
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        TextView r7 = (TextView) r5.findViewById(2131387553);
        if (r7 == null) goto L5;
        r7.setVisibility(0);
        r7.setText((String) g.b.getValue(null, g.a[0]));
        Unit r0 = Unit.INSTANCE;
    L6:
        this.h = r7;
        TextView r8 = (TextView) r5.findViewById(2131388772);
        if (r8 == null) goto L9;
        r8.setText(getString(2131917637));
        Unit r9 = Unit.INSTANCE;
    L9:
        View r10 = r5.findViewById(2131363762);
        r10.setOnClickListener(new c(this));
        Unit r1 = Unit.INSTANCE;
        this.i = r10;
        View r11 = r5.findViewById(2131367009);
        r11.setOnClickListener(new d(this));
        this.j = r11;
        View r13 = this.k;
        if (r13 == null) goto L13;
        r13.setVisibility(8);
    L13:
        if (this.f == null) goto L15;
        r5.postDelayed(new e(r5, this), 500);
    L15:
        RecyclerView r14 = this.g;
        if (r14 == null) goto L19;
        r14.addOnScrollListener(new UgcGiftPoolDialog$initView$$inlined$run$lambda$4(this));
        return;
    L19:
        return;
    L5:
        r7 = null;
        goto L6
    }
}

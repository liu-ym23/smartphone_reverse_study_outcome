package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.container.HybridDialog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class HybridDialogImpl extends BaseHybridComponentContainer<HybridDialog> implements zy0.d {
    public final bz0.e e;

    public static final class a implements HybridDialog.a {
        public final /* synthetic */ HybridDialogImpl a;

        public final /* synthetic */ void onScroll(int r1) {
        }

        public final void onDismiss() {
            HybridDialogImpl r0 = this.a;
            r0.e.f.c(new Object[]{r0.d.getDialog()});
            if (((Boolean) f.b.getValue(null, f.a[0])).booleanValue() == false) goto L6;
            HybridDialogImpl.e(this.a);
            return;
        }

        public final void onShow() {
            HybridDialogImpl r0 = this.a;
            r0.e.e.c(new Object[]{r0.d.getDialog()});
        }

        public a(HybridDialogImpl r1) {
            this.a = r1;
        }
    }

    @Override // zy0.d
    public final void i() {
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        ((ArrayList) this.c).clear();
        this.d.close();
    }

    @Override // zy0.d
    public final DialogFragment p1() {
        return this.d;
    }

    public static final void e(HybridDialogImpl r0) {
        ((ArrayList) r0.c).clear();
    }

    public final void j(Function1<? super DialogInterface, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.e.e.a(r2);
    }

    @Override // zy0.d
    public final void j0(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.e.g.a(r2);
    }

    @Override // zy0.d
    public final void m1(Function1<? super DialogInterface, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.e.f.a(r2);
    }

    public HybridDialogImpl(bz0.e r2, HybridDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "originalDialog");
        super(r3, r2);
        this.e = r2;
        this.d.T90(new a(this));
        this.d.X90(new AnonymousClass2(this));
    }
}

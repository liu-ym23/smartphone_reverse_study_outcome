package com.larus.dora.impl.dynamic.viewholder;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoReconnectLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoReconnectViewHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoReconnectLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoReconnectLayoutBinding;)V", "rotateAnimation", "Landroid/view/animation/Animation;", "currentUIState", "Lcom/larus/dora/impl/dynamic/event/DeviceUIState;", "deviceMac", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "shouldShowLoading", "", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "updateUIByConnectionState", "state", "updateUIState", "newState", "startLoadingAnimation", "stopLoadingAnimation", "onViewAttached", "onViewDetached", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfoReconnectViewHolder extends BaseViewHolder<d59.c> {
    public static final /* synthetic */ int g = 0;
    public final LarusDoraDeviceInfoReconnectLayoutBinding b;
    public Animation c;
    public e59.c d;
    public String e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void onViewRecycled() {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void U3() {
        if (this.f == false) goto L6;
        X3();
        return;
    }

    public final void X3() {
        if (this.c != null) goto L7;
        Animation r0 = AnimationUtils.loadAnimation(((RecyclerView.ViewHolder) this).itemView.getContext(), 2130772365);
        this.c = r0;
        if (r0 == null) goto L7;
        r0.setInterpolator(new LinearInterpolator());
    L7:
        this.b.d.clearAnimation();
        e1.x(this.b.d);
        this.b.d.startAnimation(this.c);
    }

    public final void Y3() {
        this.b.d.clearAnimation();
        e1.o(this.b.d);
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void V3() {
        Y3();
        this.c = null;
    }

    public DeviceInfoReconnectViewHolder(LarusDoraDeviceInfoReconnectLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.d = e59.c.d.a;
    }

    public final void Z3(e59.c r5) {
        if (Intrinsics.areEqual(this.d, r5) == false) goto L5;
        return;
    L5:
        this.d = r5;
        if (Intrinsics.areEqual(r5, e59.c.d.a) == false) goto L9;
        this.b.c.setText(2131902419);
        this.b.b.setEnabled(true);
        e1.x(this.b.b);
        this.f = false;
        Y3();
        return;
    L9:
        if (Intrinsics.areEqual(r5, e59.c.C0126c.a) == false) goto L12;
        e1.x(this.b.d);
        this.f = true;
        this.b.c.setText(2131902420);
        this.b.b.setEnabled(false);
        e1.x(this.b.b);
        X3();
        return;
    L12:
        if (Intrinsics.areEqual(r5, e59.c.a.a) == false) goto L15;
        this.b.c.setText(2131902419);
        this.b.b.setEnabled(true);
        e1.x(this.b.b);
        this.f = false;
        Y3();
        return;
    L15:
        if (Intrinsics.areEqual(r5, e59.c.b.a) == false) goto L19;
        e1.o(this.b.b);
        Y3();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r2, e59.b r3, d59.b r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "connectionState");
        if (r4 == null) goto L7;
        z49.b r5 = r4.a;
        if (r5 == null) goto L7;
        String r6 = r5.c();
    L8:
        this.e = r6;
        e1.d(this.b.b, new d(this));
        if ((r3 instanceof e59.b.d) == false) goto L12;
        Z3(e59.c.d.a);
        return;
    L12:
        if ((r3 instanceof e59.b.C0125b) == false) goto L18;
        if (Intrinsics.areEqual(((e59.b.C0125b) r3).a, this.e) == false) goto L16;
        Z3(e59.c.C0126c.a);
        return;
    L16:
        Z3(e59.c.d.a);
        return;
    L18:
        if ((r3 instanceof e59.b.a) == false) goto L24;
        if (Intrinsics.areEqual(((e59.b.a) r3).a, this.e) == false) goto L22;
        Z3(e59.c.b.a);
        return;
    L22:
        Z3(e59.c.d.a);
        return;
    L24:
        if ((r3 instanceof e59.b.c) == false) goto L30;
        if (Intrinsics.areEqual(((e59.b.c) r3).a, this.e) == false) goto L36;
        Z3(e59.c.d.a);
        return;
    L36:
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    L7:
        r6 = null;
        goto L8
    }
}

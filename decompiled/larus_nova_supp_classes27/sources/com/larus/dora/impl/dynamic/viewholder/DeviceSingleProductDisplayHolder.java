package com.larus.dora.impl.dynamic.viewholder;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceSingleProductDisplayBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.a1;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.t1;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceSingleProductDisplayBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceSingleProductDisplayBinding;)V", "showBattery", "", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceBatteryLayoutBinding;", "isCharging", "", "progress", "", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceSingleProductDisplayHolder extends BaseViewHolder<d59.c> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraDeviceSingleProductDisplayBinding b;

    public static final class a {
    }

    static {
    }

    public DeviceSingleProductDisplayHolder(LarusDoraDeviceSingleProductDisplayBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r10, e59.b r11, d59.b r12) {
        d59.c r13 = r10;
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r11, "connectionState");
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: this=" + hashCode() + ", data=" + r13 + ", cardContext=" + r12 + ", connectionState=" + r11);
        LarusDoraDeviceSingleProductDisplayBinding r14 = this.b;
        d59.j r1 = r13.e;
        t1 r3 = null;
        if ((r1 instanceof d59.l) == false) goto L5;
        d59.l r2 = (d59.l) r1;
    L6:
        if (r2 == null) goto L49;
        int r4 = n1.a;
        if (r12 == null) goto L11;
        z49.b r15 = r12.a;
    L12:
        DoraDevice r16 = n1.j(r15);
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: device=" + r16);
        if (r2.c() == null) goto L23;
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: imageLink=" + r2.c());
        SimpleDraweeView r5 = r14.f;
        if (r16 == null) goto L17;
        Integer r6 = Integer.valueOf(r16.productId);
    L18:
        DoraSKU.a r7 = DoraSKU.Companion;
        if (r16 == null) goto L21;
        Integer r8 = Integer.valueOf(r16.sku);
    L22:
        DoraSKU r9 = DoraSKU.BLACK;
        r7.getClass();
        a1.b(r5, r2.c(), r6, DoraSKU.a.a(r8, r9), 8);
    L24:
        if (r16 != null) goto L26;
    L45:
        e1.o(r14.b);
        e1.x(r14.e);
        return;
    L26:
        if (r13.f == false) goto L45;
        e1.x(r14.b);
        e1.o(r14.e);
        com.larus.dora.impl.dynamic.b r17 = r2.b();
        if (r17 == null) goto L30;
        r3 = r17.a();
    L30:
        if (r3 == null) goto L32;
        SimpleDraweeView r18 = r14.d;
        int r0 = r16.productId;
        DoraSKU.a r20 = DoraSKU.Companion;
        Integer r21 = Integer.valueOf(r16.sku);
        DoraSKU r22 = DoraSKU.BLACK;
        r20.getClass();
        a1.b(r18, r3, Integer.valueOf(r0), DoraSKU.a.a(r21, r22), 8);
    L33:
        LarusDoraDeviceBatteryLayoutBinding r110 = r14.c;
        boolean r23 = false;
        if (o59.a.b(r16)[0] != 1) goto L36;
        boolean r111 = true;
    L37:
        int r112 = o59.a.a(r16)[0];
        r110.a.setAlpha(1.0f);
        if (r112 >= 0) goto L40;
    L42:
        if (r23 == false) goto L44;
        e1.o(r110.d);
        LottieAdapterView r24 = r110.c;
        Intrinsics.checkNotNull(r24);
        e1.x(r24);
        q69.d.b(r24, r112, r111);
        AppCompatTextView r113 = r110.e;
        Intrinsics.checkNotNull(r113);
        e1.x(r113);
        StringBuilder r114 = new StringBuilder();
        r114.append(r112);
        r114.append('%');
        r113.setText(r114.toString());
        Intrinsics.checkNotNull(r113);
        return;
    L44:
        ImageView r115 = r110.d;
        Intrinsics.checkNotNull(r115);
        e1.x(r115);
        r115.setImageResource(2131240508);
        int r116 = j0.a;
        r115.setColorFilter(j0.a(2131103140), PorterDuff.Mode.SRC_IN);
        e1.o(r110.c);
        e1.o(r110.e);
        return;
    L40:
        if (r112 >= 101) goto L42;
        r23 = true;
        goto L42
    L36:
        r111 = false;
        goto L37
    L32:
        g49.d.b("DeviceSingleProductDisplayHolder", "connectedImageLink is null");
        goto L33
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L23:
        g49.d.b("DeviceSingleProductDisplayHolder", "bind: imageLink is null");
        goto L24
    L11:
        r15 = null;
        goto L12
    L49:
        return;
    L5:
        r2 = null;
        goto L6
    }
}

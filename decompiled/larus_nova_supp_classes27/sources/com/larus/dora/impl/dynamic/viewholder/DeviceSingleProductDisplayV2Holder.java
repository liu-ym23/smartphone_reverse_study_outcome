package com.larus.dora.impl.dynamic.viewholder;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceSingleProductDisplayV2Binding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0003J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceSingleProductDisplayV2Binding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceSingleProductDisplayV2Binding;)V", "showBattery", "", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceBatteryLayoutBinding;", "isCharging", "", "progress", "", "isBox", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceSingleProductDisplayV2Holder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int c = 0;
    public final LarusDoraDeviceSingleProductDisplayV2Binding b;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.DeviceSingleProductDisplayV2Holder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslBatteryInfo;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0071a {

            @SerializedName("image_link")
            private final c59.u imageLink;

            @SerializedName("title")
            private final c59.t title;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0071a) == true) goto L8;
                return false;
            L8:
                C0071a r6 = (C0071a) r5;
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.t r0 = this.title;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.u r4 = this.imageLink;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslBatteryInfo(title=" + this.title + ", imageLink=" + this.imageLink + ')';
            }

            public C0071a() {
                this.title = null;
                this.imageLink = null;
            }

            public final c59.u a() {
                return this.imageLink;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslSingleProductDisplayV2Entity;", "", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "batteryInfo", "Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslBatteryInfo;", "boxBatteryInfo", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslBatteryInfo;Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslBatteryInfo;)V", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getBatteryInfo", "()Lcom/larus/dora/impl/dynamic/viewholder/DeviceSingleProductDisplayV2Holder$Companion$DslBatteryInfo;", "getBoxBatteryInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b {

            @SerializedName("battery_info")
            private final C0071a batteryInfo;

            @SerializedName("box_battery_info")
            private final C0071a boxBatteryInfo;

            @SerializedName("image_link")
            private final c59.u imageLink;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.batteryInfo, r6.batteryInfo) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.boxBatteryInfo, r6.boxBatteryInfo) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                c59.u r0 = this.imageLink;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                C0071a r4 = this.batteryInfo;
                if (r4 != null) goto L9;
                int r5 = 0;
            L10:
                int r6 = (r3 + r5) * 31;
                C0071a r7 = this.boxBatteryInfo;
                if (r7 == null) goto L15;
                r1 = r7.hashCode();
            L15:
                return r6 + r1;
            L9:
                r5 = r4.hashCode();
                goto L10
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslSingleProductDisplayV2Entity(imageLink=" + this.imageLink + ", batteryInfo=" + this.batteryInfo + ", boxBatteryInfo=" + this.boxBatteryInfo + ')';
            }

            public b() {
                this.imageLink = null;
                this.batteryInfo = null;
                this.boxBatteryInfo = null;
            }

            public final C0071a a() {
                return this.batteryInfo;
            }

            public final C0071a b() {
                return this.boxBatteryInfo;
            }

            public final c59.u c() {
                return this.imageLink;
            }
        }
    }

    static {
    }

    public DeviceSingleProductDisplayV2Holder(LarusDoraDeviceSingleProductDisplayV2Binding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r11, e59.b r12, d59.b r13) {
        c59.i r14 = r11;
        Intrinsics.checkNotNullParameter(r14, "data");
        Intrinsics.checkNotNullParameter(r12, "connectionState");
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: this=" + hashCode() + ", data=" + r14 + ", cardContext=" + r13 + ", connectionState=" + r12);
        LarusDoraDeviceSingleProductDisplayV2Binding r0 = this.b;
        Lazy r2 = c59.s.a;
        a.b r15 = (a.b) c59.s.c(r14.b, a.b.class);
        int r3 = n1.a;
        c59.u r4 = null;
        if (r13 == null) goto L5;
        z49.b r16 = r13.a;
    L6:
        DoraDevice r17 = n1.j(r16);
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: device=" + r17);
        DoraSKU.a r5 = DoraSKU.Companion;
        if (r17 == null) goto L9;
        Integer r6 = Integer.valueOf(r17.sku);
    L10:
        DoraSKU r7 = DoraSKU.BLACK;
        r5.getClass();
        String r8 = DoraSKU.a.a(r6, r7).getSkuName();
        if (r15 == null) goto L13;
        c59.u r9 = r15.c();
    L15:
        if (r9 == null) goto L21;
        g49.d.d("DeviceSingleProductDisplayHolder", "bind: imageLink=" + r15.c());
        SimpleDraweeView r10 = r0.i;
        c59.u r18 = r15.c();
        Map r20 = MapsKt.mapOf(TuplesKt.to("sku", r8));
        if (r17 == null) goto L19;
        Integer r21 = Integer.valueOf(r17.productId);
    L20:
        c59.p.d(r10, r18, r20, r21);
    L22:
        boolean r110 = r12 instanceof e59.b.a;
        if (r110 == true) goto L25;
        r0.i.setAlpha(0.3f);
    L26:
        if (r17 == null) goto L70;
        if (r110 == false) goto L70;
        e1.x(r0.d);
        e1.o(r0.g);
        if (r15 == null) goto L33;
        a.C0071a r111 = r15.a();
        if (r111 == null) goto L33;
        c59.u r112 = r111.a();
    L35:
        if (r112 == null) goto L37;
        c59.p.d(r0.f, r112, MapsKt.mapOf(TuplesKt.to("sku", r8)), Integer.valueOf(r17.productId));
    L38:
        int r113 = t69.b.c;
        g49.d.d("DeviceSingleProductDisplayHolder", "Current headphone mode: " + r113);
        boolean r22 = false;
        if (r113 != 1) goto L41;
        boolean r114 = true;
    L42:
        AppCompatTextView r23 = r0.h;
        if (r114 == false) goto L45;
        int r115 = 0;
    L46:
        r23.setVisibility(r115);
        LarusDoraDeviceBatteryLayoutBinding r116 = r0.e;
        if (o59.a.b(r17)[0] != 1) goto L49;
        boolean r24 = true;
    L50:
        X3(r116, r24, o59.a.a(r17)[0], false);
        if (o59.a.a(r17).length >= 3) goto L53;
    L69:
        e1.o(r0.c);
        e1.o(r0.b.b);
        return;
    L53:
        if (o59.a.a(r17)[2] > 100) goto L69;
        if (o59.a.a(r17)[2] < 0) goto L69;
        e1.x(r0.c);
        e1.x(r0.b.b);
        if (r15 == null) goto L62;
        a.C0071a r117 = r15.b();
        if (r117 == null) goto L62;
        r4 = r117.a();
    L62:
        if (r4 == null) goto L64;
        c59.p.d(r0.c, r4, MapsKt.mapOf(TuplesKt.to("sku", r8)), Integer.valueOf(r17.productId));
    L65:
        LarusDoraDeviceBatteryLayoutBinding r118 = r0.b;
        if (o59.a.b(r17)[2] != 1) goto L68;
        r22 = true;
    L68:
        X3(r118, r22, o59.a.a(r17)[2], true);
        return;
    L64:
        g49.d.b("DeviceSingleProductDisplayHolder", "connectedImageLink is null");
        goto L65
    L49:
        r24 = false;
        goto L50
    L45:
        r115 = 8;
        goto L46
    L41:
        r114 = false;
        goto L42
    L37:
        g49.d.b("DeviceSingleProductDisplayHolder", "connectedImageLink is null");
    L33:
        r112 = null;
    L70:
        e1.o(r0.h);
        e1.o(r0.d);
        e1.x(r0.g);
        return;
    L25:
        r0.i.setAlpha(1.0f);
        goto L26
    L19:
        r21 = null;
        goto L20
    L21:
        g49.d.b("DeviceSingleProductDisplayHolder", "bind: imageLink is null");
        goto L22
    L13:
        r9 = null;
        goto L15
    L9:
        r6 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public static void X3(LarusDoraDeviceBatteryLayoutBinding r2, boolean r3, int r4, boolean r5) {
        r2.a.setAlpha(1.0f);
        if (r4 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        e1.o(r2.d);
        LottieAdapterView r6 = r2.c;
        Intrinsics.checkNotNull(r6);
        e1.x(r6);
        q69.d.b(r6, r4, r3);
        AppCompatTextView r7 = r2.e;
        Intrinsics.checkNotNull(r7);
        e1.x(r7);
        StringBuilder r8 = new StringBuilder();
        r8.append(r4);
        r8.append('%');
        r7.setText(r8.toString());
        Intrinsics.checkNotNull(r7);
        return;
    L10:
        if (r5 == false) goto L12;
        e1.o(r2.d);
        e1.o(r2.b);
    L13:
        e1.o(r2.c);
        e1.o(r2.e);
        return;
    L12:
        ImageView r9 = r2.d;
        Intrinsics.checkNotNull(r9);
        e1.x(r9);
        r9.setImageResource(2131240508);
        int r10 = j0.a;
        r9.setColorFilter(j0.a(2131103140), PorterDuff.Mode.SRC_IN);
        Intrinsics.checkNotNull(r9);
        goto L13
    L5:
        if (r4 >= 101) goto L7;
        r0 = true;
        goto L8
    }
}

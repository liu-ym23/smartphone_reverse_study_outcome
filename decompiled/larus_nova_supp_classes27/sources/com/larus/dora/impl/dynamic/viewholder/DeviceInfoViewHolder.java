package com.larus.dora.impl.dynamic.viewholder;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutV2Binding;
import com.larus.dora.impl.device.battery.DoraDeviceBoxBattery;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010\u000f\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u0010\u0014\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0017\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\n\u0010\u0018\u001a\u00020\n*\u00020\u0010J\u0012\u0010\u0019\u001a\u00020\n*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012J\"\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoViewHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoLayoutV2Binding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoLayoutV2Binding;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "show", "", "device", "Lcom/bytedance/dora/device/DoraDevice;", "config", "Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoViewHolder$Companion$DslDeviceInfo;", "updateBoxBattery", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceBatteryLayoutBinding;", "isDarkMode", "", "isCharging", "updateBoxBatteryProgress", "progress", "", "showBattery", "showDisconnected", "showOrHide", "visible", "bind", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfoViewHolder extends BaseViewHolder<c59.i> {
    public static final /* synthetic */ int d = 0;
    public final LarusDoraDeviceInfoLayoutV2Binding b;
    public final CoroutineScope c;

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.DeviceInfoViewHolder$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoViewHolder$Companion$DslDeviceInfo;", "", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "batteryInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;)V", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getBatteryInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0069a {

            @SerializedName("battery_info")
            private final c59.t batteryInfo;

            @SerializedName("image_link")
            private final c59.u imageLink;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0069a) == true) goto L8;
                return false;
            L8:
                C0069a r6 = (C0069a) r5;
                if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.batteryInfo, r6.batteryInfo) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                c59.u r0 = this.imageLink;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                c59.t r4 = this.batteryInfo;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "DslDeviceInfo(imageLink=" + this.imageLink + ", batteryInfo=" + this.batteryInfo + ')';
            }

            public C0069a() {
                this.imageLink = null;
                this.batteryInfo = null;
            }

            public final c59.u a() {
                return this.imageLink;
            }
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void onViewRecycled() {
        DoraDeviceBoxBattery.c = -1;
        DoraDeviceBoxBattery.c();
        DoraDeviceBoxBattery.e = null;
    }

    public DeviceInfoViewHolder(LarusDoraDeviceInfoLayoutV2Binding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.b = r2;
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        r2.b.setReferencedIds(new int[]{2131369474, 2131369475});
    }

    public static void Y3(LarusDoraDeviceBatteryLayoutBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.a.setAlpha(0.3f);
        e1.x(r2.d);
        e1.o(r2.c);
        AppCompatTextView r3 = r2.e;
        int r0 = j0.a;
        r3.setText(j0.d(2131903646));
    }

    public static void Z3(LarusDoraDeviceBatteryLayoutBinding r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LinearLayoutCompat r3 = r1.b;
        if (r2 == false) goto L5;
        int r4 = 0;
    L6:
        r3.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(c59.i r210, e59.b r30, d59.b r31) {
        c59.i r3 = r210;
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r30, "connectionState");
        LarusDoraDeviceInfoLayoutV2Binding r4 = this.b;
        if (r4 == null) goto L261;
        int r5 = n1.a;
        if (r31 == null) goto L7;
        z49.b r2 = r31.a;
    L8:
        final DoraDevice r6 = n1.j(r2);
        Lazy r7 = c59.s.a;
        a.C0069a r8 = (a.C0069a) c59.s.c(r3.b, a.C0069a.class);
        CoroutineScope r9 = this.c;
        Intrinsics.checkNotNullParameter(r9, "scope");
        final LarusDoraDeviceInfoLayoutV2Binding r10 = this.b;
        String r11 = "DeviceInfoViewHolder_Hash:";
        if (r10 == null) goto L242;
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = new int[]{-1, -1, -1};
        int[] r15 = {0, 0, 0};
        if (r6 == null) goto L27;
        r13.element = o59.a.a(r6);
        r15 = o59.a.b(r6);
        g49.d.d("DoraDeviceInfoViewHolder", "DeviceInfoViewHolder_Hash: " + r10.hashCode() + ", device!=null, left:" + ((int[]) r13.element)[0] + ", right:" + ((int[]) r13.element)[1] + ", box:" + ((int[]) r13.element)[2] + ", chargeLeft:" + r15[0] + ", chargeRight:" + r15[1] + ", chargeBox:" + r15[2]);
        int[] r12 = (int[]) r13.element;
        int r14 = r12[0];
        if (1 > r14) goto L16;
        if (r14 >= 101) goto L16;
        boolean r16 = true;
    L17:
        int r17 = r12[1];
        if (1 > r17) goto L21;
        if (r17 >= 101) goto L21;
        boolean r18 = true;
    L22:
        int r20 = r12[2];
        if (1 > r20) goto L26;
        if (r20 >= 101) goto L26;
        boolean r21 = true;
    L28:
        boolean r110 = v19.h.a;
        boolean r111 = v19.h.b(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r6 != null) goto L31;
    L33:
        boolean r1 = false;
    L35:
        if (r1 == false) goto L37;
        int r22 = ((int[]) r13.element)[0];
    L45:
        if (r16 == false) goto L51;
        LarusDoraDeviceBatteryLayoutBinding r23 = r10.d;
        if (r15[0] != 1) goto L49;
        boolean r24 = true;
    L50:
        X3(r23, r111, r24, r22);
    L52:
        if (r6 != null) goto L54;
    L56:
        boolean r25 = false;
    L57:
        if (r25 == false) goto L59;
        int r26 = ((int[]) r13.element)[1];
    L66:
        g49.d.d("DoraDeviceInfoViewHolder", "hash:" + r10.hashCode() + ", isLeftConnected " + r16 + " , isBoxConnected: " + r21 + " , isRightConnected:" + r18 + '}');
        if (r18 == false) goto L73;
        LarusDoraDeviceBatteryLayoutBinding r27 = r10.e;
        int r28 = 1;
        if (r15[1] != 1) goto L71;
        boolean r32 = true;
    L72:
        X3(r27, r111, r32, r26);
    L74:
        if (r6 == null) goto L105;
        if (r21 == true) goto L77;
    L83:
        String r33 = r6.mac;
        if (r33 != null) goto L86;
        r33 = r6.sn;
    L86:
        if (r33 != null) goto L88;
    L91:
        boolean r34 = true;
    L93:
        if (r34 == false) goto L95;
        int r35 = -1;
    L96:
        if (r35 >= 0) goto L98;
    L100:
        boolean r36 = false;
    L101:
        if (r36 == false) goto L103;
        e1.x(r10.c.a);
        g49.d.d("DoraDeviceInfoViewHolder", "show cached box battery: " + r35);
        X3(r10.c, r111, false, r35);
    L104:
        c59.u r37 = null;
    L144:
        String r38 = l59.a.b(r6);
        if (r6 != null) goto L147;
    L149:
        boolean r40 = false;
    L150:
        if (r40 == false) goto L152;
        String r41 = l59.a.c(r6);
    L157:
        int r42 = n1.c(r6);
        if (r42 != ProductNameType.H_DOLPHIN.id) goto L160;
        boolean r43 = true;
    L162:
        if (r42 != ProductNameType.H_GUITAR.id) goto L164;
        boolean r44 = true;
    L165:
        if (r43 == false) goto L167;
        int r45 = 2131242899;
    L170:
        if (r43 == false) goto L172;
        int r112 = 2131242901;
    L175:
        if (r43 == true) goto L179;
        if (r44 == true) goto L179;
        ScalingUtils.ScaleType r46 = ScalingUtils.ScaleType.CENTER;
    L180:
        SimpleDraweeView r113 = r10.l;
        GenericDraweeHierarchyBuilder r114 = GenericDraweeHierarchyBuilder.newInstance(((RecyclerView.ViewHolder) this).itemView.getContext().getResources());
        r114.setPlaceholderImage(r45);
        r114.setPlaceholderImageScaleType(r46);
        r113.setHierarchy(r114.build());
        Intrinsics.checkNotNull(r113);
        if (r8 == 0) goto L183;
        c59.u r115 = r8.a();
    L184:
        Pair[] r116 = new Pair[3];
        r116[0] = TuplesKt.to("product", r38);
        r116[1] = TuplesKt.to("sku", r41);
        String r211 = "device_left";
        if (r6 == null) goto L191;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (o59.a.r(r6) == false) goto L189;
        Object r212 = "device_left";
    L190:
        Object r47 = r212;
    L192:
        r116[2] = TuplesKt.to("device_component", r47);
        c59.p.d(r113, r115, MapsKt.mapOf(r116), Integer.valueOf(r42));
        SimpleDraweeView r48 = r10.j;
        GenericDraweeHierarchyBuilder r117 = GenericDraweeHierarchyBuilder.newInstance(((RecyclerView.ViewHolder) this).itemView.getContext().getResources());
        r117.setPlaceholderImage(r45);
        r117.setPlaceholderImageScaleType(r46);
        r48.setHierarchy(r117.build());
        Intrinsics.checkNotNull(r48);
        if (r8 == 0) goto L195;
        c59.u r50 = r8.a();
    L196:
        Pair[] r118 = new Pair[3];
        r118[0] = TuplesKt.to("product", r38);
        r118[1] = TuplesKt.to("sku", r41);
        if (r6 == null) goto L203;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (o59.a.r(r6) == true) goto L202;
        r211 = "left";
    L202:
        String r119 = r211;
    L204:
        r118[2] = TuplesKt.to("device_component", r119);
        c59.p.d(r48, r50, MapsKt.mapOf(r118), Integer.valueOf(r42));
        SimpleDraweeView r51 = r10.m;
        GenericDraweeHierarchyBuilder r52 = GenericDraweeHierarchyBuilder.newInstance(((RecyclerView.ViewHolder) this).itemView.getContext().getResources());
        int r120 = r112;
        r52.setPlaceholderImage(r120);
        r52.setPlaceholderImageScaleType(r46);
        r51.setHierarchy(r52.build());
        Intrinsics.checkNotNull(r51);
        if (r8 == 0) goto L207;
        c59.u r53 = r8.a();
    L208:
        Pair[] r121 = new Pair[3];
        r121[0] = TuplesKt.to("product", r38);
        r121[1] = TuplesKt.to("sku", r41);
        String r213 = "right";
        if (r6 == null) goto L215;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (o59.a.r(r6) == false) goto L213;
        Object r214 = "device_right";
    L214:
        Object r122 = r214;
    L216:
        r121[2] = TuplesKt.to("device_component", r122);
        c59.p.d(r51, r53, MapsKt.mapOf(r121), Integer.valueOf(r42));
        SimpleDraweeView r54 = r10.k;
        GenericDraweeHierarchyBuilder r55 = GenericDraweeHierarchyBuilder.newInstance(((RecyclerView.ViewHolder) this).itemView.getContext().getResources());
        r55.setPlaceholderImage(r120);
        r55.setPlaceholderImageScaleType(r46);
        r54.setHierarchy(r55.build());
        Intrinsics.checkNotNull(r54);
        if (r8 == 0) goto L219;
        c59.u r56 = r8.a();
    L220:
        Pair[] r123 = new Pair[3];
        r123[0] = TuplesKt.to("product", r38);
        r123[1] = TuplesKt.to("sku", r41);
        if (r6 == null) goto L226;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (o59.a.r(r6) == false) goto L225;
        r213 = "device_right";
    L225:
        String r57 = r213;
    L227:
        r123[2] = TuplesKt.to("device_component", r57);
        c59.p.d(r54, r56, MapsKt.mapOf(r123), Integer.valueOf(r42));
        SimpleDraweeView r58 = r10.i;
        GenericDraweeHierarchyBuilder r60 = GenericDraweeHierarchyBuilder.newInstance(((RecyclerView.ViewHolder) this).itemView.getContext().getResources());
        if (r43 == true) goto L230;
        r60.setPlaceholderImage(2131240445);
        r60.setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER);
    L230:
        r58.setHierarchy(r60.build());
        Intrinsics.checkNotNull(r58);
        if (r8 == 0) goto L233;
        c59.u r61 = r8.a();
    L234:
        Pair[] r62 = new Pair[3];
        r62[0] = TuplesKt.to("product", r38);
        r62[1] = TuplesKt.to("sku", r41);
        if (r6 == null) goto L240;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (o59.a.r(r6) == false) goto L239;
        String r63 = "device_box";
    L241:
        r62[2] = TuplesKt.to("device_component", r63);
        c59.p.d(r58, r61, MapsKt.mapOf(r62), Integer.valueOf(r42));
    L243:
        StringBuilder r64 = new StringBuilder(r11);
        r64.append(r4.hashCode());
        r64.append(", onStateChanged device ");
        r64.append(r6);
        r64.append(", connectionState:");
        r64.append(r30);
        r64.append(", device connect:");
        if (r6 != null) goto L247;
    L249:
        boolean r65 = false;
    L250:
        r64.append(r65);
        g49.d.d("DoraDeviceInfoViewHolder", r64.toString());
        if ((r30 instanceof e59.b.a) == false) goto L256;
        LarusDoraDeviceInfoLayoutV2Binding r66 = r4;
        e1.x(r66.f);
        e1.o(r66.g);
        LarusDoraDeviceBatteryLayoutBinding r67 = r66.d;
        if (r67 == null) goto L255;
        Z3(r67, true);
    L255:
        Z3(r66.e, true);
        e1.o(r66.h);
        return;
    L256:
        LarusDoraDeviceInfoLayoutV2Binding r68 = r4;
        e1.o(r68.f);
        e1.x(r68.g);
        LarusDoraDeviceBatteryLayoutBinding r70 = r68.d;
        if (r70 == null) goto L259;
        Z3(r70, false);
    L259:
        Z3(r68.c, false);
        Z3(r68.e, false);
        e1.x(r68.h);
        return;
    L247:
        if (kj4.a.g().getDoraLinkState(r6) != 2) goto L249;
        r65 = true;
        goto L250
    L239:
        r63 = "box";
        goto L241
    L240:
        r63 = null;
        goto L241
    L233:
        r61 = null;
        goto L234
    L226:
        r57 = null;
        goto L227
    L219:
        r56 = null;
        goto L220
    L213:
        r214 = "right";
        goto L214
    L215:
        r122 = null;
        goto L216
    L207:
        r53 = null;
        goto L208
    L203:
        r119 = null;
        goto L204
    L195:
        r50 = null;
        goto L196
    L189:
        r212 = "left";
        goto L190
    L191:
        r47 = null;
        goto L192
    L183:
        r115 = r37;
    L179:
        r46 = ScalingUtils.ScaleType.CENTER_INSIDE;
        goto L180
    L172:
        if (r44 == false) goto L174;
        r112 = 2131240451;
        goto L175
    L174:
        r112 = 2131240450;
        goto L175
    L167:
        if (r44 == false) goto L169;
        r45 = 2131240449;
        goto L170
    L169:
        r45 = 2131240448;
        goto L170
    L164:
        r44 = false;
        goto L165
    L160:
        r43 = false;
        goto L162
    L152:
        DoraSKU.a r71 = DoraSKU.Companion;
        if (r6 == null) goto L155;
        Integer r72 = Integer.valueOf(r6.sku);
    L156:
        r41 = DoraSKU.a.b(r71, r72).getSkuName();
        goto L157
    L155:
        r72 = r37;
        goto L156
    L147:
        if (r6.vendorId != 4096) goto L149;
        r40 = true;
        goto L150
    L103:
        DoraDeviceBoxBattery.c = -1;
        DoraDeviceBoxBattery.c();
        DoraDeviceBoxBattery.e = null;
        e1.o(r10.c.a);
        goto L104
    L98:
        if (r35 >= 101) goto L100;
        r36 = true;
        goto L101
    L95:
        Lazy r73 = com.larus.dora.impl.device.battery.k.a;
        r35 = com.larus.dora.impl.device.battery.k.g(r33);
        goto L96
    L88:
        if (r33.length() == 0) goto L91;
        r34 = false;
        goto L93
    L77:
        if (r15[0] == r28) goto L105;
        if (r15[r28] == r28) goto L105;
        if (r15[2] != r28) goto L83;
    L105:
        e1.x(r10.c.a);
        if (r21 == false) goto L143;
        LarusDoraDeviceBatteryLayoutBinding r74 = r10.c;
        if (r15[2] != 1) goto L110;
        boolean r75 = true;
    L111:
        LarusDoraDeviceInfoLayoutV2Binding r76 = this.b;
        if (r76 == null) goto L137;
        r76.a.setAlpha(1.0f);
        LottieAdapterView r77 = r74.c;
        Intrinsics.checkNotNull(r77);
        e1.x(r77);
        if (r111 == false) goto L118;
        if (r75 == false) goto L117;
        String r78 = "charging_dark";
    L122:
        if (r77.getComposition() == null) goto L131;
        String r80 = r77.getImageAssetsFolder();
        r37 = null;
        if (r80 != null) goto L126;
    L128:
        boolean r81 = false;
    L129:
        if (r81 == true) goto L132;
    L136:
        e1.o(r74.d);
    L138:
        Job r82 = DoraDeviceBoxBattery.a;
        int r83 = ((int[]) r13.element)[2];
        if (r15[2] != 1) goto L141;
        boolean r84 = true;
    L142:
        DoraDeviceBoxBattery.b(r9, r83, r84, new e(this, r10, r6, r13));
        goto L144
    L141:
        r84 = false;
    L132:
        if (r75 == false) goto L134;
        String r85 = "charging";
    L135:
        r77.setContentDescription(r85);
        r77.setAnimation(r78.concat("/data.json"));
        goto L136
    L134:
        r85 = "not charging";
        goto L135
    L126:
        if (StringsKt.contains$default(r80, r78, false, 2, null) == true) goto L128;
        r81 = true;
        goto L129
    L131:
        r37 = null;
        goto L132
    L117:
        r78 = "default_dark";
        goto L122
    L118:
        if (r75 == false) goto L120;
        r78 = "charging_light";
        goto L122
    L120:
        r78 = "default_light";
        goto L122
    L137:
        r37 = null;
        goto L138
    L110:
        r75 = false;
        goto L111
    L143:
        r37 = null;
        Y3(r10.c);
        goto L144
    L71:
        r32 = false;
        goto L72
    L73:
        r28 = 1;
        Y3(r10.e);
        goto L74
    L59:
        Lazy r86 = com.larus.dora.impl.device.battery.k.a;
        if (r6 == null) goto L62;
        String r87 = r6.sn;
    L63:
        if (r87 != null) goto L65;
        r87 = "";
    L65:
        r26 = com.larus.dora.impl.device.battery.k.f(r87, (int[]) r13.element, r15, "UI");
        goto L66
    L62:
        r87 = null;
        goto L63
    L54:
        if (r6.vendorId != 4096) goto L56;
        r25 = true;
        goto L57
    L49:
        r24 = false;
        goto L50
    L51:
        Y3(r10.d);
        goto L52
    L37:
        Lazy r88 = com.larus.dora.impl.device.battery.k.a;
        if (r6 == null) goto L40;
        String r90 = r6.sn;
    L42:
        if (r90 != null) goto L44;
        r90 = "";
    L44:
        r22 = com.larus.dora.impl.device.battery.k.d(r90, (int[]) r13.element, r15, "UI");
        goto L45
    L40:
        r90 = null;
        goto L42
    L31:
        if (r6.vendorId != 4096) goto L33;
        r1 = true;
    L26:
        r21 = false;
    L21:
        r18 = false;
    L16:
        r16 = false;
        goto L17
    L27:
        g49.d.d("DoraDeviceInfoViewHolder", "DeviceInfoViewHolder_Hash:" + r10.hashCode() + ", device==null");
        r21 = false;
        r18 = false;
        r16 = false;
        goto L28
    L242:
        r4 = r4;
        r11 = "DeviceInfoViewHolder_Hash:";
        goto L243
    L7:
        r2 = null;
        goto L8
    }

    public static void X3(LarusDoraDeviceBatteryLayoutBinding r2, boolean r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.a.setAlpha(1.0f);
        e1.o(r2.d);
        r2.c.cancelAnimation();
        LottieAdapterView r0 = r2.c;
        Intrinsics.checkNotNull(r0);
        e1.x(r0);
        if (r4 == false) goto L5;
        String r1 = "charging";
    L6:
        r0.setContentDescription(r1);
        if (r3 == false) goto L11;
        if (r4 == false) goto L10;
        String r6 = "charging_dark";
    L14:
        r0.setAnimation(r6.concat("/data.json"));
        float r7 = r5 / 100.0f;
        r0.setMinAndMaxProgress(r7, r7);
        r0.playAnimation();
        AppCompatTextView r8 = r2.e;
        StringBuilder r9 = new StringBuilder();
        r9.append(r5);
        r9.append('%');
        r8.setText(r9.toString());
        return;
    L10:
        r6 = "default_dark";
        goto L14
    L11:
        if (r4 == false) goto L13;
        r6 = "charging_light";
        goto L14
    L13:
        r6 = "default_light";
        goto L14
    L5:
        r1 = "not charging";
        goto L6
    }
}

package com.larus.dora.impl.dynamic.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoBannerLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoDuoGroupLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoGeneraGroupLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutV2Binding;
import com.larus.dora.impl.databinding.LarusDoraDeviceReconnectAndUnbindLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceSingleProductDisplayV2Binding;
import com.larus.dora.impl.databinding.LarusDoraDynamicListItemBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import com.larus.dora.impl.view.DoraTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    static {
    }

    public static BaseViewHolder a(ViewGroup r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "parent");
        if (r21 != DslTemplateType.SINGLE_DEVICE_PRODUCT_DISPLAY.ordinal()) goto L25;
        int r1 = DeviceSingleProductDisplayV2Holder.c;
        Intrinsics.checkNotNullParameter(r20, "parent");
        ConstraintLayout r0 = LayoutInflater.from(r20.getContext()).inflate(2131562160, r20, false);
        int r2 = 2131369459;
        View r3 = ViewBindings.findChildViewById(r0, 2131369459);
        if (r3 == null) goto L23;
        LarusDoraDeviceBatteryLayoutBinding r7 = LarusDoraDeviceBatteryLayoutBinding.a(r3);
        r2 = 2131369460;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r0, 2131369460);
        if (r8 == null) goto L23;
        r2 = 2131369463;
        LinearLayoutCompat r9 = ViewBindings.findChildViewById(r0, 2131369463);
        if (r9 == null) goto L23;
        r2 = 2131369464;
        View r4 = ViewBindings.findChildViewById(r0, 2131369464);
        if (r4 == null) goto L23;
        LarusDoraDeviceBatteryLayoutBinding r10 = LarusDoraDeviceBatteryLayoutBinding.a(r4);
        r2 = 2131369465;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r0, 2131369465);
        if (r11 == null) goto L23;
        r2 = 2131369470;
        DoraTextView r12 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369470);
        if (r12 == null) goto L23;
        r2 = 2131369478;
        DoraTextView r13 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131369478);
        if (r13 == null) goto L23;
        r2 = 2131369479;
        SimpleDraweeView r14 = ViewBindings.findChildViewById(r0, 2131369479);
        if (r14 == null) goto L23;
        return new DeviceSingleProductDisplayV2Holder(new LarusDoraDeviceSingleProductDisplayV2Binding(r0, r7, r8, r9, r10, r11, r12, r13, r14));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    L25:
        if (r21 != DslTemplateType.PRODUCT_DISPLAY.ordinal()) goto L57;
        int r5 = DeviceInfoViewHolder.d;
        Intrinsics.checkNotNullParameter(r20, "parent");
        NestedScrollView r6 = LayoutInflater.from(r20.getContext()).inflate(2131562155, r20, false);
        int r15 = 2131363972;
        Barrier r16 = ViewBindings.findChildViewById(r6, 2131363972);
        if (r16 == null) goto L55;
        r15 = 2131369454;
        View r17 = ViewBindings.findChildViewById(r6, 2131369454);
        if (r17 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r18 = LarusDoraDeviceBatteryLayoutBinding.a(r17);
        r15 = 2131369455;
        View r22 = ViewBindings.findChildViewById(r6, 2131369455);
        if (r22 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r23 = LarusDoraDeviceBatteryLayoutBinding.a(r22);
        r15 = 2131369456;
        View r24 = ViewBindings.findChildViewById(r6, 2131369456);
        if (r24 == null) goto L55;
        LarusDoraDeviceBatteryLayoutBinding r110 = LarusDoraDeviceBatteryLayoutBinding.a(r24);
        r15 = 2131369468;
        if (ViewBindings.findChildViewById(r6, 2131369468) == null) goto L55;
        r15 = 2131369474;
        ConstraintLayout r111 = ViewBindings.findChildViewById(r6, 2131369474);
        if (r111 == null) goto L55;
        r15 = 2131369475;
        ConstraintLayout r112 = ViewBindings.findChildViewById(r6, 2131369475);
        if (r112 == null) goto L55;
        r15 = 2131369477;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131369477);
        if (r113 == null) goto L55;
        r15 = 2131369480;
        SimpleDraweeView r114 = ViewBindings.findChildViewById(r6, 2131369480);
        if (r114 == null) goto L55;
        r15 = 2131369481;
        SimpleDraweeView r115 = ViewBindings.findChildViewById(r6, 2131369481);
        if (r115 == null) goto L55;
        r15 = 2131369482;
        SimpleDraweeView r116 = ViewBindings.findChildViewById(r6, 2131369482);
        if (r116 == null) goto L55;
        r15 = 2131369483;
        SimpleDraweeView r117 = ViewBindings.findChildViewById(r6, 2131369483);
        if (r117 == null) goto L55;
        r15 = 2131369484;
        SimpleDraweeView r118 = ViewBindings.findChildViewById(r6, 2131369484);
        if (r118 == null) goto L55;
        NestedScrollView r119 = r6;
        return new DeviceInfoViewHolder(new LarusDoraDeviceInfoLayoutV2Binding(r119, r16, r18, r23, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119));
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r15)));
    L57:
        if (r21 != DslTemplateType.BANNER.ordinal()) goto L71;
        int r25 = DeviceInfoBannerHolder.d;
        Intrinsics.checkNotNullParameter(r20, "parent");
        ItemGroup r26 = LayoutInflater.from(r20.getContext()).inflate(2131562148, r20, false);
        int r27 = 2131369635;
        LinearLayoutCompat r28 = ViewBindings.findChildViewById(r26, 2131369635);
        if (r28 == null) goto L69;
        r27 = 2131370008;
        ImageView r30 = (ImageView) ViewBindings.findChildViewById(r26, 2131370008);
        if (r30 == null) goto L69;
        r27 = 2131370009;
        AppCompatTextView r31 = ViewBindings.findChildViewById(r26, 2131370009);
        if (r31 == null) goto L69;
        r27 = 2131370010;
        DoraTextView r120 = (DoraTextView) ViewBindings.findChildViewById(r26, 2131370010);
        if (r120 == null) goto L69;
        return new DeviceInfoBannerHolder(new LarusDoraDeviceInfoBannerLayoutBinding(r26, r28, r30, r31, r120));
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r26.getResources().getResourceName(r27)));
    L71:
        if (r21 != DslTemplateType.GENERAL_GROUP.ordinal()) goto L75;
        int r32 = GeneralGroupHolder.e;
        Intrinsics.checkNotNullParameter(r20, "parent");
        return new GeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r20.getContext()), r20));
    L75:
        if (r21 != DslTemplateType.DUO_GROUP.ordinal()) goto L83;
        int r33 = DuoGroupHolder.e;
        Intrinsics.checkNotNullParameter(r20, "parent");
        View r34 = LayoutInflater.from(r20.getContext()).inflate(2131562149, r20, false);
        if (r34 == null) goto L81;
        GridLayout r35 = (GridLayout) r34;
        return new DuoGroupHolder(new LarusDoraDeviceInfoDuoGroupLayoutBinding(r35, r35));
    L81:
        throw new NullPointerException("rootView");
    L83:
        if (r21 != DslTemplateType.FUNCTION_INTRODUCTION_SET.ordinal()) goto L91;
        int r36 = FunctionIntroductionSetHolder.c;
        Intrinsics.checkNotNullParameter(r20, "parent");
        View r37 = LayoutInflater.from(r20.getContext()).inflate(2131562152, r20, false);
        LinearLayout r38 = (LinearLayout) r37;
        if (((DoraTextView) ViewBindings.findChildViewById(r37, 2131373378)) == null) goto L89;
        return new FunctionIntroductionSetHolder(new LarusDoraDeviceInfoFunctionIntroductionSetLayoutBinding(r38, r38));
    L89:
        throw new NullPointerException("Missing required view with ID: ".concat(r37.getResources().getResourceName(2131373378)));
    L91:
        if (r21 != DslTemplateType.PRODUCT_ITEM.ordinal()) goto L95;
        int r40 = ProductItemHolder.b;
        Intrinsics.checkNotNullParameter(r20, "parent");
        return new ProductItemHolder(LarusDoraDynamicListItemBinding.a(LayoutInflater.from(r20.getContext()), r20));
    L95:
        if (r21 != DslTemplateType.RECONNECT_UNBIND_PANEL.ordinal()) goto L108;
        int r41 = DeviceReConnectAndUnbindHolder.e;
        Intrinsics.checkNotNullParameter(r20, "parent");
        View r42 = LayoutInflater.from(r20.getContext()).inflate(2131562157, r20, false);
        int r43 = 2131369467;
        LinearLayout r44 = (LinearLayout) ViewBindings.findChildViewById(r42, 2131369467);
        if (r44 == null) goto L107;
        r43 = 2131369469;
        AppCompatTextView r45 = ViewBindings.findChildViewById(r42, 2131369469);
        if (r45 == null) goto L107;
        r43 = 2131369509;
        AppCompatTextView r46 = ViewBindings.findChildViewById(r42, 2131369509);
        if (r46 == null) goto L107;
        LinearLayout r47 = (LinearLayout) r42;
        r43 = 2131379075;
        ProgressBar r121 = (ProgressBar) ViewBindings.findChildViewById(r42, 2131379075);
        if (r121 == null) goto L107;
        return new DeviceReConnectAndUnbindHolder(new LarusDoraDeviceReconnectAndUnbindLayoutBinding(r47, r44, r45, r46, r121));
    L107:
        throw new NullPointerException("Missing required view with ID: ".concat(r42.getResources().getResourceName(r43)));
    L108:
        int r48 = GeneralGroupHolder.e;
        Intrinsics.checkNotNullParameter(r20, "parent");
        return new GeneralGroupHolder(LarusDoraDeviceInfoGeneraGroupLayoutBinding.a(LayoutInflater.from(r20.getContext()), r20));
    }
}

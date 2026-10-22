package com.larus.dora.impl.guide;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraBatteryGuideToastBinding;
import com.larus.dora.impl.device.manage.DoraGDeviceManagementActivity;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.dora.impl.onboarding.DoraOnboardingActivity;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraBatteryGuide implements t39.l {
    public static final /* synthetic */ int d = 0;
    public volatile int a;
    public t39.m b;
    public Balloon c;

    public static final class Companion {
        public static void a(Activity r10) {
            g49.d.d("DoraBatteryGuide", "showDirectly called, activity: " + r10);
            if (r10 != null) goto L5;
        L31:
            g49.d.d("DoraBatteryGuide", "showDirectly: activity is null or onboarding, skip");
            return;
        L5:
            if ((r10 instanceof DoraOnboardingActivity) == true) goto L31;
            if ((r10 instanceof DoraGDeviceManagementActivity) == false) goto L10;
            DoraDevice r0 = kj4.a.g().c.a(false);
        L11:
            Integer r3 = null;
            if (h.a(r0) == false) goto L22;
            StringBuilder r11 = new StringBuilder("showDirectly: skip Dora G, DoraWearStatusManager handles wear popup, productId=");
            if (r0 == null) goto L16;
            Integer r2 = Integer.valueOf(r0.productId);
        L17:
            r11.append(r2);
            r11.append(", type=");
            if (r0 == null) goto L20;
            r3 = Integer.valueOf(r0.type);
        L20:
            r11.append(r3);
            g49.d.d("DoraBatteryGuide", r11.toString());
            return;
        L16:
            r2 = null;
            goto L17
        L22:
            DoraBatteryGuide r1 = new DoraBatteryGuide("direct_popup");
            if ((r10 instanceof LifecycleOwner) == false) goto L25;
            LifecycleOwner r4 = (LifecycleOwner) r10;
        L26:
            if (r4 == null) goto L33;
            LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r4);
            if (r5 == null) goto L34;
            BuildersKt.launch$default(r5, Dispatchers.getIO(), null, new DoraBatteryGuide$Companion$showDirectly$1(r1, r10, null), 2, null);
            return;
        L34:
            return;
        L33:
            return;
        L25:
            r4 = null;
            goto L26
        L10:
            r0 = kj4.a.g().c();
            goto L11
        }
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraBatteryGuide", "startGuide()");
        if (h() == true) goto L5;
        k(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraBatteryGuide.getGuideId();
    }

    public final boolean h() {
        IDoraGuideService r0 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == false) goto L8;
        g49.d.d("DoraBatteryGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final String toString() {
        return "DoraBatteryGuide(state=" + this.a + ')';
    }

    public DoraBatteryGuide(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextView] */
    public static LarusDoraBatteryGuideToastBinding g(final Context r33) {
        boolean r0 = v19.h.a;
        boolean r1 = v19.h.b(r33);
        ConstraintLayout r2 = LayoutInflater.from(r33).inflate(2131562143, null, false);
        int r3 = 2131377251;
        if (ViewBindings.findChildViewById(r2, 2131377251) == null) goto L204;
        r3 = 2131377252;
        if (ViewBindings.findChildViewById(r2, 2131377252) == null) goto L204;
        r3 = 2131377253;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r2, 2131377253);
        if (r8 == null) goto L204;
        r3 = 2131377254;
        ?? r5 = (DoraTextView) ViewBindings.findChildViewById(r2, 2131377254);
        if (r5 == 0) goto L204;
        r3 = 2131377255;
        if (ViewBindings.findChildViewById(r2, 2131377255) == null) goto L204;
        r3 = 2131377256;
        LinearLayoutCompat r17 = ViewBindings.findChildViewById(r2, 2131377256);
        if (r17 == null) goto L204;
        r3 = 2131377257;
        if (((ImageView) ViewBindings.findChildViewById(r2, 2131377257)) == null) goto L204;
        r3 = 2131377258;
        LottieAdapterView r15 = ViewBindings.findChildViewById(r2, 2131377258);
        if (r15 == null) goto L204;
        r3 = 2131377259;
        ?? r14 = (DoraTextView) ViewBindings.findChildViewById(r2, 2131377259);
        if (r14 == 0) goto L204;
        r3 = 2131377260;
        LinearLayoutCompat r18 = ViewBindings.findChildViewById(r2, 2131377260);
        if (r18 == null) goto L204;
        r3 = 2131377261;
        if (((ImageView) ViewBindings.findChildViewById(r2, 2131377261)) == null) goto L204;
        r3 = 2131377262;
        LottieAdapterView r13 = ViewBindings.findChildViewById(r2, 2131377262);
        if (r13 == null) goto L204;
        r3 = 2131377263;
        ?? r12 = (DoraTextView) ViewBindings.findChildViewById(r2, 2131377263);
        if (r12 == 0) goto L204;
        r3 = 2131377264;
        Barrier r11 = ViewBindings.findChildViewById(r2, 2131377264);
        if (r11 == null) goto L204;
        ConstraintLayout r4 = r2;
        final LarusDoraBatteryGuideToastBinding r6 = new LarusDoraBatteryGuideToastBinding(r4, r8, r5, r17, r15, r14, r18, r13, r12, r11);
        r11.setReferencedIds(new int[]{2131377254, 2131377251});
        DoraDevice r7 = DoraAdapterExtKt.h(kj4.a.g());
        if (r7 == null) goto L34;
        int[] r9 = o59.a.a(r7);
        if (r9 == null) goto L34;
    L35:
        if (r7 == null) goto L38;
        int[] r10 = o59.a.b(r7);
        if (r10 == null) goto L38;
    L39:
        if (r7 == null) goto L43;
        String r16 = o59.a.d(r7);
        if (r16 == null) goto L43;
    L44:
        r5.setText(r16);
        SimpleDraweeView r20 = r6.b;
        if (r7 == null) goto L47;
        int r21 = r7.productId;
    L49:
        if (r21 != ProductNameType.H_FREE_BUDS_PRO_5.id) goto L52;
        String r22 = DoraObricDeviceHomeViewModel.PRODUCT_CODE_SAX;
    L64:
        String r23 = "larus_image_guide_battery_" + l59.a.c(r7) + '_' + r22;
        Application r24 = AppHost.a.getApplication();
        boolean r25 = r1;
        int r26 = r24.getResources().getIdentifier(r23, "drawable", r24.getPackageName());
        int[] r27 = r10;
        g49.d.d("DoraBatteryGuide", "getDeviceIconRes: resName=" + r23 + ", resId=" + r26);
        if (r26 == 0) goto L67;
    L91:
        if (r26 != 0) goto L94;
        r26 = 2131242877;
    L94:
        if (r7 != null) goto L96;
        g49.d.d("DoraBatteryGuide", "loadBatteryGuideDeviceImage: device is null, use local fallback");
        r20.setImageResource(r26);
    L97:
        e1.o(r17);
        e1.o(r18);
        if (r7 != null) goto L100;
    L102:
        boolean r28 = false;
    L103:
        int r30 = -1;
        if (r28 == false) goto L114;
        Integer r31 = ArraysKt.getOrNull(r9, 0);
        if (r31 == null) goto L108;
        int r32 = r31.intValue();
    L109:
        Integer r34 = ArraysKt.getOrNull(r9, 1);
        if (r34 == null) goto L112;
        int r35 = r34.intValue();
    L113:
        g49.d.d("DoraBatteryGuide", "createBalloonLayout: H device raw battery L:" + r32 + ", R:" + r35);
        int[] r36 = r27;
    L128:
        if (r32 < 0) goto L131;
        if (r32 >= 101) goto L131;
        boolean r37 = true;
    L132:
        if (r37 == true) goto L172;
        if (r35 < 0) goto L136;
        if (r35 >= 101) goto L136;
        boolean r38 = true;
    L137:
        if (r38 == true) goto L172;
        com.larus.dora.impl.util.b0 r40 = com.larus.dora.impl.util.b0.a;
        if (r7 == null) goto L142;
        String r110 = r7.mac;
        if (r110 == null) goto L142;
    L148:
        r40.getClass();
        Intrinsics.checkNotNullParameter(r110, "mac");
        String r210 = com.larus.dora.impl.util.b0.j().getString("dora_earbud_battery_cache_".concat(r110), "");
        long r111 = com.larus.dora.impl.util.b0.j().getLong("dora_earbud_battery_cache_time_".concat(r110), 0);
        if (r210 != null) goto L151;
    L154:
        boolean r41 = true;
    L155:
        if (r41 == false) goto L157;
        Triple r42 = new Triple(-1, -1, 0L);
    L169:
        int r43 = ((Number) r42.component1()).intValue();
        int r44 = ((Number) r42.component2()).intValue();
        if ((System.currentTimeMillis() - ((Number) r42.component3()).longValue()) >= j0.G2_OTA_MANUAL_REARM_DELAY_MS) goto L172;
        g49.d.d("DoraBatteryGuide", "Using cached battery: L:" + r43 + ", R:" + r44);
        r32 = r43;
        r35 = r44;
        goto L172
    L157:
        List r45 = StringsKt.split$default(r210, new String[]{","}, false, 0, 6, null);
        String r46 = (String) CollectionsKt.getOrNull(r45, 0);
        if (r46 == null) goto L162;
        Integer r47 = StringsKt.toIntOrNull(r46);
        if (r47 == null) goto L162;
        int r48 = r47.intValue();
    L163:
        String r50 = (String) CollectionsKt.getOrNull(r45, 1);
        if (r50 == null) goto L168;
        Integer r51 = StringsKt.toIntOrNull(r50);
        if (r51 == null) goto L168;
        r30 = r51.intValue();
    L168:
        r42 = new Triple(Integer.valueOf(r48), Integer.valueOf(r30), Long.valueOf(r111));
    L162:
        r48 = -1;
        goto L163
    L151:
        if (r210.length() == 0) goto L154;
        r41 = false;
    L142:
        if (r7 == null) goto L144;
        String r211 = r7.sn;
    L145:
        if (r211 != null) goto L147;
        r110 = "";
        goto L148
    L147:
        r110 = r211;
        goto L148
    L144:
        r211 = null;
    L136:
        r38 = false;
    L172:
        if (1 > r32) goto L175;
        if (r32 >= 101) goto L175;
        boolean r52 = true;
    L177:
        if (r52 == false) goto L186;
        e1.x(r17);
        StringBuilder r53 = new StringBuilder();
        r53.append(r32);
        r53.append('%');
        r14.setText(r53.toString());
        Integer r54 = ArraysKt.getOrNull(r36, 0);
        if (r54 != null) goto L182;
    L184:
        boolean r55 = false;
    L185:
        j(r15, r32, r55, r25);
    L187:
        if (1 > r35) goto L190;
        if (r35 >= 101) goto L190;
        boolean r56 = true;
    L191:
        if (r56 == false) goto L200;
        e1.x(r18);
        StringBuilder r57 = new StringBuilder();
        r57.append(r35);
        r57.append('%');
        r12.setText(r57.toString());
        Integer r58 = ArraysKt.getOrNull(r36, 1);
        if (r58 != null) goto L196;
    L198:
        boolean r60 = false;
    L199:
        j(r13, r35, r60, r25);
    L201:
        e1.d(r4, new f(r33, r6));
        return r6;
    L196:
        if (r58.intValue() != 1) goto L198;
        r60 = true;
        goto L199
    L200:
        e1.o(r18);
    L190:
        r56 = false;
        goto L191
    L182:
        if (r54.intValue() != 1) goto L184;
        r55 = true;
        goto L185
    L186:
        r25 = r25;
        e1.o(r17);
    L175:
        r52 = false;
    L131:
        r37 = false;
        goto L132
    L112:
        r35 = -1;
        goto L113
    L108:
        r32 = -1;
        goto L109
    L114:
        Lazy r61 = com.larus.dora.impl.device.battery.k.a;
        if (r7 == null) goto L117;
        String r62 = r7.sn;
    L118:
        if (r62 != null) goto L120;
        r62 = "";
    L120:
        r36 = r27;
        r32 = com.larus.dora.impl.device.battery.k.d(r62, r9, r36, "DoraBatteryGuide");
        if (r7 == null) goto L123;
        String r63 = r7.sn;
    L124:
        if (r63 != null) goto L126;
        r63 = "";
    L126:
        r35 = com.larus.dora.impl.device.battery.k.f(r63, r9, r36, "DoraBatteryGuide");
        g49.d.d("DoraBatteryGuide", "createBalloonLayout: Lite device optimized battery L:" + r32 + ", R:" + r35);
        goto L128
    L123:
        r63 = null;
        goto L124
    L117:
        r62 = null;
        goto L118
    L100:
        if (o59.a.r(r7) != true) goto L102;
        r28 = true;
        goto L103
    L96:
        String r64 = l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/h/guide/battery/${product}/image_${sku}.png", r7, "light");
        g49.d.d("DoraBatteryGuide", "loadBatteryGuideDeviceImage: imageUrl=" + r64 + ", fallbackResId=" + r26);
        GenericDraweeHierarchyBuilder r65 = GenericDraweeHierarchyBuilder.newInstance(r20.getResources());
        r65.setPlaceholderImage(r26);
        r65.setFailureImage(r26);
        ScalingUtils.ScaleType r66 = ScalingUtils.ScaleType.CENTER_INSIDE;
        r65.setPlaceholderImageScaleType(r66);
        r65.setFailureImageScaleType(r66);
        r65.setActualImageScaleType(r66);
        r20.setHierarchy(r65.build());
        ImageLoaderKt.u(r20, r64, "dora_battery_guide_device_image");
        goto L97
    L67:
        switch(r22.hashCode()) {
            case -1234870134: goto L86;
            case -548425806: goto L82;
            case 113642: goto L78;
            case 3322030: goto L76;
            case 108685738: goto L74;
            case 1837070814: goto L70;
            default: goto L89;
        };
    L76:
        r22.equals(DoraObricDeviceHomeViewModel.PRODUCT_CODE_LITE);
    L89:
        String r67 = "larus_image_guide_battery_black_lite";
    L90:
        int r68 = r24.getResources().getIdentifier(r67, "drawable", r24.getPackageName());
        g49.d.d("DoraBatteryGuide", "getDeviceIconRes fallback: resName=" + r67 + ", resId=" + r68);
        r26 = r68;
        goto L91
    L70:
        if (r22.equals("dolphin") == false) goto L89;
        r67 = "larus_image_guide_battery_white_dolphin";
        goto L90
    L74:
        if (r22.equals(DoraObricDeviceHomeViewModel.PRODUCT_CODE_ROBIN) == false) goto L89;
    L84:
        r67 = "larus_image_guide_battery_white_robin";
        goto L90
    L78:
        if (r22.equals(DoraObricDeviceHomeViewModel.PRODUCT_CODE_SAX) == false) goto L89;
        r67 = "larus_image_guide_battery_gold_sax";
        goto L90
    L82:
        if (r22.equals("robin_he") == true) goto L84;
    L86:
        if (r22.equals("guitar") == false) goto L89;
        r67 = "larus_image_guide_battery_white_guitar";
        goto L90
    L52:
        if (r21 != ProductNameType.H_FREE_CLIP_2.id) goto L55;
        r22 = DoraObricDeviceHomeViewModel.PRODUCT_CODE_ROBIN;
        goto L64
    L55:
        if (r21 != ProductNameType.H_FREE_CLIP_2_HE.id) goto L58;
        r22 = "robin_he";
        goto L64
    L58:
        if (r21 != ProductNameType.H_GUITAR.id) goto L61;
        r22 = "guitar";
        goto L64
    L61:
        if (r21 != ProductNameType.H_DOLPHIN.id) goto L63;
        r22 = "dolphin";
        goto L64
    L63:
        int r70 = ProductNameType.DORA_LITE.id;
        r22 = DoraObricDeviceHomeViewModel.PRODUCT_CODE_LITE;
        goto L64
    L47:
        r21 = ProductNameType.DORA_LITE.id;
    L43:
        r16 = DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME;
    L38:
        r10 = new int[]{0, 0, 0};
    L34:
        r9 = new int[]{-1, -1, -1};
    L204:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r7) {
        g49.d.d("DoraBatteryGuide", "isGuideConditionMet(), checking battery guide prerequisites");
        if (ObricFeatureServiceDelegate.b.b() == false) goto L7;
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: suppress on Obric OS");
        return Boxing.boxBoolean(false);
    L7:
        if (AccountService.a.isLogin().booleanValue() == true) goto L11;
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L11:
        if (h() == false) goto L15;
        return Boxing.boxBoolean(false);
    L15:
        if (this.a != 2) goto L18;
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: already showing");
        return Boxing.boxBoolean(false);
    L18:
        DoraDevice r0 = DoraAdapterExtKt.h(kj4.a.g());
        if (r0 != null) goto L21;
    L49:
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: no connected device");
        return Boxing.boxBoolean(false);
    L21:
        if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L49;
        if (h.a(r0) == false) goto L27;
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: Dora G device, productId=" + r0.productId + ", type=" + r0.type);
        return Boxing.boxBoolean(false);
    L27:
        int[] r1 = o59.a.a(r0);
        Integer r2 = ArraysKt.getOrNull(r1, 0);
        int r3 = -1;
        if (r2 == null) goto L30;
        int r4 = r2.intValue();
    L31:
        Integer r5 = ArraysKt.getOrNull(r1, 1);
        if (r5 == null) goto L35;
        r3 = r5.intValue();
    L35:
        if (1 > r4) goto L38;
        if (r4 >= 101) goto L38;
        boolean r6 = true;
    L39:
        if (r6 == true) goto L48;
        if (1 > r3) goto L43;
        if (r3 >= 101) goto L43;
        boolean r8 = true;
    L44:
        if (r8 == true) goto L48;
        g49.d.d("DoraBatteryGuide", "Battery guide condition not met: invalid earbud battery (L:" + r4 + ", R:" + r3 + ')');
        return Boxing.boxBoolean(false);
    L43:
        r8 = false;
    L48:
        return Boxing.boxBoolean(true);
    L38:
        r6 = false;
        goto L39
    L30:
        r4 = -1;
        goto L31
    }

    public final void k(int r4) {
        if (this.a != r4) goto L5;
        return;
    L5:
        int r0 = this.a;
        this.a = r4;
        g49.d.d("DoraBatteryGuide", "Guide state changed: prev=" + r0 + ", new=" + r4);
        t39.m r1 = this.b;
        if (r1 == null) goto L9;
        r1.b(this, r4, r0);
        return;
    }

    @Override // t39.l
    public final Object d(Fragment r2, View r3, Continuation<? super Unit> r4) {
        g49.d.d("DoraBatteryGuide", "dismissGuide() called");
        Balloon r5 = this.c;     // Catch: Exception -> L10
        if (r5 == null) goto L6;
        r5.h();     // Catch: Exception -> L10
    L6:
        this.c = null;     // Catch: Exception -> L10
        k(3);     // Catch: Exception -> L10
        t39.m r6 = this.b;     // Catch: Exception -> L10
        if (r6 == null) goto L15;
        r6.a(this);     // Catch: Exception -> L10
    L15:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        g49.d.c("DoraBatteryGuide", "dismissGuide() exception: " + e.getMessage(), e);
        k(404);
        t39.m r7 = this.b;
        if (r7 == null) goto L15;
        r7.a(this);
        goto L15
    }

    @Override // t39.l
    public final Object e(Fragment r3, View r4, Continuation<? super Unit> r5) {
        g49.d.d("DoraBatteryGuide", "showGuide() called");
        if (h() == true) goto L5;
        if (r3 == null) goto L9;
        Context r0 = r3.getContext();
        if (r0 == null) goto L9;
    L10:
        Object r6 = i(r0, r3, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r6;
    L14:
        return Unit.INSTANCE;
    L9:
        r0 = AppHost.a.getApplication();
        goto L10
    L5:
        return Unit.INSTANCE;
    }

    public static void j(LottieAdapterView r0, int r1, boolean r2, boolean r3) {
        if (r3 == false) goto L6;
        if (r2 == false) goto L5;
        String r4 = "charging_dark";
    L9:
        r0.setAnimation(r4.concat("/data.json"));
        r0.setImageAssetsFolder(r4.concat("/images/"));
        float r5 = RangesKt.coerceIn(r1 / 100.0f, 0.0f, 1.0f);
        r0.setMinAndMaxProgress(r5, r5);
        r0.playAnimation();
        return;
    L5:
        r4 = "default_dark";
        goto L9
    L6:
        if (r2 == false) goto L8;
        r4 = "charging_light";
        goto L9
    L8:
        r4 = "default_light";
        goto L9
    }

    public final Object i(Context r15, Fragment r16, View r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof DoraBatteryGuide$showGuideInternal$1) == false) goto L7;
        DoraBatteryGuide$showGuideInternal$1 r3 = (DoraBatteryGuide$showGuideInternal$1) r18;
        int r5 = r3.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r5 - Integer.MIN_VALUE;
    L8:
        DoraBatteryGuide$showGuideInternal$1 r8 = r3;
        Object r2 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L16;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L13
    L49:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r2);
        DoraDevice r6 = DoraAdapterExtKt.h(kj4.a.g());
        if (h.a(r6) == false) goto L31;
        StringBuilder r0 = new StringBuilder("showGuideInternal: skip Dora G, productId=");
        Integer r1 = null;
        if (r6 == null) goto L22;
        Integer r7 = Boxing.boxInt(r6.productId);
    L23:
        r0.append(r7);
        r0.append(", type=");
        if (r6 == null) goto L26;
        r1 = Boxing.boxInt(r6.type);
    L26:
        r0.append(r1);
        g49.d.d("DoraBatteryGuide", r0.toString());
        k(3);
        t39.m r10 = this.b;
        if (r10 == null) goto L30;
        r10.a(this);
    L30:
        return Unit.INSTANCE;
    L22:
        r7 = null;
        goto L23
    L31:
        k(2);
        LarusDoraBatteryGuideToastBinding r11 = g(r15);     // Catch: Exception -> L13
        Balloon.a r12 = new Balloon.a(r15);     // Catch: Exception -> L13
        r12.n(Integer.MIN_VALUE);     // Catch: Exception -> L13
        r12.j(Integer.MIN_VALUE);     // Catch: Exception -> L13
        r12.e(ArrowPositionRules.ALIGN_BALLOON);     // Catch: Exception -> L13
        r12.f(0);     // Catch: Exception -> L13
        r12.p = 0.5f;     // Catch: Exception -> L13
        r12.v = 0;     // Catch: Exception -> L13
        r12.g(BalloonAnimation.FADE);     // Catch: Exception -> L13
        r12.g0 = false;     // Catch: Exception -> L13
        if (r16 == null) goto L36;
        r12.W = r16;     // Catch: Exception -> L13
    L38:
        r12.V = 7000;     // Catch: Exception -> L13
        r12.h(false);     // Catch: Exception -> L13
        r12.k(r11);     // Catch: Exception -> L13
        r12.l(new e(this));     // Catch: Exception -> L13
        Balloon r13 = r12.b();     // Catch: Exception -> L13
        this.c = r13;     // Catch: Exception -> L13
        r11.a.setTag(r13);     // Catch: Exception -> L13
        if (Intrinsics.areEqual(this.c, r13) == false) goto L41;
        Lazy r14 = com.larus.dora.impl.device.battery.k.a;     // Catch: Exception -> L13
        com.larus.dora.impl.device.battery.k.c = System.currentTimeMillis();     // Catch: Exception -> L13
        DoraBuryPointManager r20 = DoraBuryPointManager.a;     // Catch: Exception -> L13
        r20.getClass();     // Catch: Exception -> L13
        g49.d.d(DoraBuryPointManager.b, "reportBatteryToastShow");     // Catch: Exception -> L13
        r20.L("dora_device_battery_toast_show", MapsKt.emptyMap());     // Catch: Exception -> L13
        MainCoroutineDispatcher r110 = Dispatchers.getMain();     // Catch: Exception -> L13
        DoraBatteryGuide$showGuideInternal$2 r111 = new DoraBatteryGuide$showGuideInternal$2(r17, r13, r15, this, null);     // Catch: Exception -> L13
        r8.label = 1;     // Catch: Exception -> L13
        if (BuildersKt.withContext(r110, r111, r8) != r9) goto L49;
        return r9;
    L41:
        return Unit.INSTANCE;
    L36:
        if ((r15 instanceof LifecycleOwner) == false) goto L38;
        r12.W = (LifecycleOwner) r15;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        g49.d.c("DoraBatteryGuide", "showGuide() exception: " + e.getMessage(), e);
        k(404);
        t39.m r21 = this.b;
        if (r21 == null) goto L49;
        r21.a(this);
    L7:
        r3 = new DoraBatteryGuide$showGuideInternal$1(this, r18);
        goto L8
    }
}

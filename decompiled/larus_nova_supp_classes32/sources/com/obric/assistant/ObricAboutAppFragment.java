package com.obric.assistant;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.base.databinding.PageSettingAboutObricPageBinding;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001c\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J+\u0010\u001f\u001a\u00020\u00142!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00140!H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\nH\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000f\u0010*\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006/"}, d2 = {"Lcom/obric/assistant/ObricAboutAppFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "binding", "Lcom/obric/assistant/base/databinding/PageSettingAboutObricPageBinding;", "isManualCheckingUpdate", NameKeys.UnloadStrategy_No_Strategy, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", NameKeys.UnloadStrategy_No_Strategy, "getCurrentPageName", "autoLogEnterPage", "onViewCreated", "view", "setupEcommerce", "setupLocalLife", "obricUpdateListener", "com/obric/assistant/ObricAboutAppFragment$obricUpdateListener$1", "Lcom/obric/assistant/ObricAboutAppFragment$obricUpdateListener$1;", "setupWithdrawPrivacyAgreement", "handleWithdrawPrivacyAgreementClick", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "userConfirmWithdraw", "setupCheckUpdate", "clickCheckAppUpdate", "toastDownloading", "context", "Landroid/content/Context;", "setupModelDetail", "()Lkotlin/Unit;", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "enterSystemPermissionSetting", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAboutAppFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public final String e;
    public PageSettingAboutObricPageBinding f;
    public volatile boolean g;
    public final ObricAboutAppFragment$obricUpdateListener$1 h;

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "about_app";
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.ObricAboutAppFragment$obricUpdateListener$1] */
    public ObricAboutAppFragment() {
        this.e = "ObricAboutAppFragment";
        this.h = new ObricAboutAppFragment$obricUpdateListener$1(this);
    }

    public final boolean U90() {
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L11;
        FLogger.a.i(this.e, "CheckAppUpdate, net not available");
        t19.s r0 = t19.s.a;
        Context r4 = getContext();
        Context r5 = getContext();
        if (r5 == null) goto L8;
        String r6 = r5.getString(2131908080);
        if (r6 == null) goto L8;
    L9:
        r0.getClass();
        t19.s.k(r4, 2131244520, r6, 1000);
        return false;
    L8:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L9
    L11:
        IObricUpdateService r1 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r1 == null) goto L34;
        int r7 = r1.l();
        if (r7 == (-1)) goto L16;
        int r8 = 1;
    L17:
        IObricUpdateService r9 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r9 == null) goto L21;
        JSONObject r10 = new JSONObject();
        r10.put("has_upgrade_package", r8);
        Unit r11 = Unit.INSTANCE;
        r9.h("obric_upgrade_manual_check", r10);
    L21:
        if (r7 != 2) goto L33;
        IObricBannerService r2 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r2 == null) goto L25;
        r2.a();
    L25:
        Context r3 = getContext();
        if (r3 != null) goto L29;
    L32:
        return false;
    L29:
        if (NetworkUtils.isWifi(r3) == false) goto L31;
        t19.s r12 = t19.s.a;
        String r13 = AppHost.a.getApplication().getString(2131912672);
        r12.getClass();
        t19.s.k(r3, 2131244520, r13, 1000);
        goto L32
    L31:
        t19.s r14 = t19.s.a;
        String r15 = AppHost.a.getApplication().getString(2131912671);
        r14.getClass();
        t19.s.k(r3, 2131244520, r15, 1000);
        goto L32
    L33:
        r1.f(this.h);
        r1.d(false, "obric_about_app");
        goto L34
    L16:
        r8 = 0;
    L34:
        return true;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L5;
        r0.i(this.h);
    L5:
        this.f = null;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        PageSettingAboutObricPageBinding r14 = this.f;
        Boolean r15 = null;
        if (r14 == null) goto L5;
        NovaTitleBarEx r3 = r14.G;
        NovaTitleBarEx.Y5(r3, getString(2131909247, new Object[]{getString(2131894309)}), null, null, 6);
        NovaTitleBarEx.b6(r3, 2131241477, false, null, null, new e0(this), 14);
    L5:
        PageSettingAboutObricPageBinding r16 = this.f;
        if (r16 != null) goto L8;
    L29:
        PageSettingAboutObricPageBinding r17 = this.f;
        if (r17 == null) goto L166;
        r17.I.setOnClickListener(new p(this));
        r17.C.setVisibility(8);
        r17.B.setOnClickListener(new k0(this));
        AppHost.Companion r4 = AppHost.a;
        if (r4.isOversea() == false) goto L34;
        r17.E.setVisibility(8);
    L36:
        if (r4.isOversea() == false) goto L72;
        PageSettingAboutObricPageBinding r5 = this.f;
        if (r5 == null) goto L42;
        ItemTextArrow r6 = r5.q;
        if (r6 == null) goto L42;
        e1.o(r6);
    L42:
        PageSettingAboutObricPageBinding r7 = this.f;
        if (r7 == null) goto L47;
        ItemTextArrow r8 = r7.j;
        if (r8 == null) goto L47;
        e1.o(r8);
    L47:
        PageSettingAboutObricPageBinding r9 = this.f;
        if (r9 == null) goto L52;
        ItemTextArrow r10 = r9.h;
        if (r10 == null) goto L52;
        e1.o(r10);
    L52:
        PageSettingAboutObricPageBinding r11 = this.f;
        if (r11 == null) goto L57;
        ItemTextArrow r18 = r11.i;
        if (r18 == null) goto L57;
        e1.o(r18);
    L57:
        PageSettingAboutObricPageBinding r19 = this.f;
        if (r19 == null) goto L62;
        ItemTextArrow r20 = r19.f;
        if (r20 == null) goto L62;
        e1.o(r20);
    L62:
        PageSettingAboutObricPageBinding r21 = this.f;
        if (r21 == null) goto L67;
        ItemTextArrow r22 = r21.D;
        if (r22 == null) goto L67;
        e1.o(r22);
    L67:
        PageSettingAboutObricPageBinding r23 = this.f;
        if (r23 == null) goto L156;
        TextView r24 = r23.l;
        if (r24 == null) goto L156;
        e1.o(r24);
    L156:
        r17.E.setOnClickListener(new r(this));
        r17.k.setOnClickListener(new s(this));
        r17.H.setOnClickListener(new a0(this));
        if (r4.isOversea() == false) goto L159;
        r17.g.setBackgroundResource(2131239215);
    L159:
        r17.g.setOnClickListener(new i0(this));
        if (r4.isOversea() == false) goto L162;
        r17.c.setVisibility(8);
    L164:
        if (r4.isOversea() == false) goto L166;
        r17.p.setVisibility(8);
        goto L166
    L162:
        r17.c.setText(getString(2131909247, new Object[]{getString(2131909746)}));
        r17.c.setOnClickListener(new j0(this));
        goto L164
    L72:
        PageSettingAboutObricPageBinding r25 = this.f;
        if (r25 == null) goto L77;
        ItemTextArrow r26 = r25.H;
        if (r26 == null) goto L77;
        e1.o(r26);
    L77:
        PageSettingAboutObricPageBinding r27 = this.f;
        if (r27 == null) goto L82;
        ItemTextArrow r28 = r27.q;
        if (r28 == null) goto L82;
        e1.x(r28);
    L82:
        PageSettingAboutObricPageBinding r29 = this.f;
        if (r29 == null) goto L87;
        ItemTextArrow r30 = r29.j;
        if (r30 == null) goto L87;
        e1.x(r30);
    L87:
        PageSettingAboutObricPageBinding r31 = this.f;
        if (r31 == null) goto L92;
        ItemTextArrow r32 = r31.h;
        if (r32 == null) goto L92;
        e1.x(r32);
    L92:
        PageSettingAboutObricPageBinding r33 = this.f;
        if (r33 == null) goto L97;
        ItemTextArrow r34 = r33.i;
        if (r34 == null) goto L97;
        e1.x(r34);
    L97:
        PageSettingAboutObricPageBinding r35 = this.f;
        if (r35 == null) goto L102;
        ItemTextArrow r36 = r35.f;
        if (r36 == null) goto L102;
        e1.x(r36);
    L102:
        PageSettingAboutObricPageBinding r37 = this.f;
        if (r37 == null) goto L107;
        ItemTextArrow r38 = r37.D;
        if (r38 == null) goto L107;
        e1.x(r38);
    L107:
        PageSettingAboutObricPageBinding r39 = this.f;
        if (r39 == null) goto L112;
        TextView r40 = r39.l;
        if (r40 == null) goto L112;
        e1.x(r40);
    L112:
        PageSettingAboutObricPageBinding r41 = this.f;
        if (r41 == null) goto L117;
        ItemTextArrow r42 = r41.q;
        if (r42 == null) goto L117;
        e1.d(r42, new l0(this));
    L117:
        PageSettingAboutObricPageBinding r43 = this.f;
        if (r43 == null) goto L122;
        ItemTextArrow r44 = r43.j;
        if (r44 == null) goto L122;
        e1.d(r44, new m0(this));
    L122:
        e10 r45 = e10.a;
        Boolean r46 = e10.r().b();
        Boolean r47 = Boolean.TRUE;
        if (Intrinsics.areEqual(r46, r47) == false) goto L129;
        PageSettingAboutObricPageBinding r48 = this.f;
        if (r48 == null) goto L137;
        ItemTextArrow r49 = r48.h;
        if (r49 == null) goto L137;
        e1.d(r49, new n0(this));
    L137:
        if (Intrinsics.areEqual(e10.r().a(), r47) == false) goto L143;
        PageSettingAboutObricPageBinding r50 = this.f;
        if (r50 == null) goto L150;
        ItemTextArrow r51 = r50.i;
        if (r51 == null) goto L150;
        e1.d(r51, new o0(this));
    L150:
        PageSettingAboutObricPageBinding r52 = this.f;
        if (r52 == null) goto L155;
        ItemTextArrow r53 = r52.f;
        if (r53 == null) goto L155;
        e1.d(r53, new p0(this));
    L155:
        r17.D.setOnClickListener(new q(this));
        goto L156
    L143:
        PageSettingAboutObricPageBinding r54 = this.f;
        if (r54 == null) goto L150;
        ItemTextArrow r55 = r54.i;
        if (r55 == null) goto L150;
        ImageView r56 = r55.getArrowView();
        if (r56 == null) goto L150;
        e1.o(r56);
        goto L150
    L129:
        PageSettingAboutObricPageBinding r57 = this.f;
        if (r57 == null) goto L137;
        ItemTextArrow r58 = r57.h;
        if (r58 == null) goto L137;
        ImageView r59 = r58.getArrowView();
        if (r59 == null) goto L137;
        e1.o(r59);
        goto L137
    L34:
        r17.g.setVisibility(8);
    L166:
        final PageSettingAboutObricPageBinding r110 = this.f;
        if (r110 == null) goto L169;
        r110.b.setVisibility(0);
        r110.b.setText(getString(2131909270));
        e1.a(r110.b, 2000, new u(r110, this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricAboutAppFragment$setupCheckUpdate$1$2(this, r110, null), 2, null);
    L169:
        PageSettingAboutObricPageBinding r111 = this.f;
        if (r111 == null) goto L176;
        ItemTextToggle r112 = r111.d;
        if (r112 == null) goto L176;
        CustomSwitchCompat r113 = r112.getToggleView();
        if (r113 == null) goto L176;
        r113.setChecked(ObricUpdateSettingDelegate.a.a());
    L176:
        PageSettingAboutObricPageBinding r114 = this.f;
        if (r114 == null) goto L183;
        ItemTextToggle r115 = r114.d;
        if (r115 == null) goto L183;
        CustomSwitchCompat r116 = r115.getToggleView();
        if (r116 == null) goto L183;
        r116.setOnCheckedChangeListener(new v(this));
    L183:
        Bundle r117 = getArguments();
        if (r117 == null) goto L187;
        r15 = Boolean.valueOf(r117.getBoolean("obric_auto_check_update", false));
    L187:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L193;
        PageSettingAboutObricPageBinding r118 = this.f;
        if (r118 == null) goto L193;
        ItemTextArrow r119 = r118.b;
        if (r119 == null) goto L193;
        r119.postDelayed(new w(this), 500);
    L193:
        PageSettingAboutObricPageBinding r120 = this.f;
        if (r120 == null) goto L196;
        r120.e.setVisibility(0);
        r120.e.setText(getString(2131923735));
        e1.b(r120.e, new t(this));
    L196:
        AppHost.Companion r121 = AppHost.a;
        if (r121.isOversea() == false) goto L208;
        PageSettingAboutObricPageBinding r122 = this.f;
        if (r122 == null) goto L203;
        LinearLayout r123 = r122.m;
        if (r123 == null) goto L203;
        e1.o(r123);
    L203:
        PageSettingAboutObricPageBinding r124 = this.f;
        if (r124 == null) goto L239;
        LinearLayout r125 = r124.z;
        if (r125 == null) goto L239;
        e1.o(r125);
    L239:
        if (r121.isOversea() == false) goto L245;
        PageSettingAboutObricPageBinding r126 = this.f;
        if (r126 == null) goto L275;
        LinearLayout r127 = r126.s;
        if (r127 == null) goto L275;
        e1.o(r127);
    L275:
        PageSettingAboutObricPageBinding r128 = this.f;
        if (r128 == null) goto L281;
        ItemGroup r129 = r128.r;
        if (r129 == null) goto L282;
        r129.c();
        return;
    L282:
        return;
    L281:
        return;
    L245:
        PageSettingAboutObricPageBinding r130 = this.f;
        if (r130 == null) goto L250;
        LinearLayout r131 = r130.s;
        if (r131 == null) goto L250;
        e1.x(r131);
    L250:
        PageSettingAboutObricPageBinding r132 = this.f;
        if (r132 == null) goto L255;
        ItemTextArrow r133 = r132.v;
        if (r133 == null) goto L255;
        e1.d(r133, new z(this));
    L255:
        PageSettingAboutObricPageBinding r134 = this.f;
        if (r134 == null) goto L260;
        ItemTextArrow r135 = r134.x;
        if (r135 == null) goto L260;
        e1.d(r135, new b0(this));
    L260:
        PageSettingAboutObricPageBinding r136 = this.f;
        if (r136 == null) goto L265;
        ItemTextArrow r137 = r136.u;
        if (r137 == null) goto L265;
        e1.d(r137, new c0(this));
    L265:
        PageSettingAboutObricPageBinding r138 = this.f;
        if (r138 == null) goto L270;
        ItemTextArrow r139 = r138.w;
        if (r139 == null) goto L270;
        e1.d(r139, new d0(this));
    L270:
        PageSettingAboutObricPageBinding r140 = this.f;
        if (r140 == null) goto L275;
        ItemGroup r141 = r140.t;
        if (r141 == null) goto L275;
        r141.c();
        goto L275
    L208:
        PageSettingAboutObricPageBinding r142 = this.f;
        if (r142 == null) goto L213;
        LinearLayout r143 = r142.m;
        if (r143 == null) goto L213;
        e1.x(r143);
    L213:
        PageSettingAboutObricPageBinding r144 = this.f;
        if (r144 == null) goto L218;
        LinearLayout r145 = r144.z;
        if (r145 == null) goto L218;
        e1.x(r145);
    L218:
        PageSettingAboutObricPageBinding r146 = this.f;
        if (r146 == null) goto L223;
        ItemTextArrow r147 = r146.o;
        if (r147 == null) goto L223;
        e1.d(r147, new x(this));
    L223:
        PageSettingAboutObricPageBinding r148 = this.f;
        if (r148 == null) goto L228;
        ItemTextArrow r149 = r148.F;
        if (r149 == null) goto L228;
        e1.d(r149, new y(this));
    L228:
        PageSettingAboutObricPageBinding r150 = this.f;
        if (r150 == null) goto L233;
        ItemGroup r151 = r150.n;
        if (r151 == null) goto L233;
        r151.c();
    L233:
        PageSettingAboutObricPageBinding r152 = this.f;
        if (r152 == null) goto L239;
        ItemGroup r153 = r152.A;
        if (r153 == null) goto L239;
        r153.c();
        goto L239
    L8:
        if (AppHost.a.isOversea() == false) goto L10;
        e1.o(r16.y);
    L28:
        Unit r154 = Unit.INSTANCE;
        goto L29
    L10:
        String r60 = t9a.b.a().d();
        int r61 = r60.hashCode();
        if (r61 == (-1048984789)) goto L24;
        if (r61 == (-807117175)) goto L21;
        if (r61 == 1328894480) goto L18;
    L25:
        int r62 = 2131912603;
    L27:
        e1.x(r16.y);
        r16.y.setText(r62);
        goto L28
    L18:
        if (r60.equals("nerida-lite") == false) goto L25;
    L26:
        r62 = 2131912602;
        goto L27
    L21:
        if (r60.equals("pacific") == false) goto L25;
    L24:
        if (r60.equals("nerida") == true) goto L26;
        goto L25
    }

    public final View onCreateView(LayoutInflater r40, ViewGroup r41, Bundle r42) {
        Intrinsics.checkNotNullParameter(r40, "inflater");
        View r0 = r40.inflate(2131564161, r41, false);
        int r1 = 2131361949;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r0, 2131361949);
        if (r5 == null) goto L85;
        r1 = 2131361951;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r0, 2131361951);
        if (r6 == null) goto L85;
        r1 = 2131361952;
        if (ViewBindings.findChildViewById(r0, 2131361952) == null) goto L85;
        r1 = 2131361953;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r0, 2131361953);
        if (r7 == null) goto L85;
        r1 = 2131361954;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r0, 2131361954);
        if (r8 == null) goto L85;
        r1 = 2131363105;
        ItemTextArrow r9 = ViewBindings.findChildViewById(r0, 2131363105);
        if (r9 == null) goto L85;
        r1 = 2131364944;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r0, 2131364944);
        if (r10 == null) goto L85;
        r1 = 2131364959;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r0, 2131364959);
        if (r11 == null) goto L85;
        r1 = 2131364960;
        ItemTextArrow r12 = ViewBindings.findChildViewById(r0, 2131364960);
        if (r12 == null) goto L85;
        r1 = 2131364963;
        ItemTextArrow r13 = ViewBindings.findChildViewById(r0, 2131364963);
        if (r13 == null) goto L85;
        r1 = 2131367592;
        ItemTextArrow r14 = ViewBindings.findChildViewById(r0, 2131367592);
        if (r14 == null) goto L85;
        r1 = 2131368752;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131368752)) == null) goto L85;
        r1 = 2131368753;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131368753);
        if (r15 == null) goto L85;
        r1 = 2131371369;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131371369);
        if (r16 == null) goto L85;
        r1 = 2131371370;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131371370)) == null) goto L85;
        r1 = 2131371371;
        ItemGroup r17 = ViewBindings.findChildViewById(r0, 2131371371);
        if (r17 == null) goto L85;
        r1 = 2131371372;
        ItemTextArrow r18 = ViewBindings.findChildViewById(r0, 2131371372);
        if (r18 == null) goto L85;
        r1 = 2131374549;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131374549);
        if (r19 == null) goto L85;
        r1 = 2131374811;
        ItemTextArrow r20 = ViewBindings.findChildViewById(r0, 2131374811);
        if (r20 == null) goto L85;
        r1 = 2131375769;
        ItemGroup r21 = ViewBindings.findChildViewById(r0, 2131375769);
        if (r21 == null) goto L85;
        r1 = 2131379103;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131379103);
        if (r22 == null) goto L85;
        r1 = 2131379104;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131379104)) == null) goto L85;
        r1 = 2131379105;
        ItemGroup r23 = ViewBindings.findChildViewById(r0, 2131379105);
        if (r23 == null) goto L85;
        r1 = 2131379110;
        ItemTextArrow r24 = ViewBindings.findChildViewById(r0, 2131379110);
        if (r24 == null) goto L85;
        r1 = 2131379111;
        ItemTextArrow r25 = ViewBindings.findChildViewById(r0, 2131379111);
        if (r25 == null) goto L85;
        r1 = 2131379112;
        ItemTextArrow r26 = ViewBindings.findChildViewById(r0, 2131379112);
        if (r26 == null) goto L85;
        r1 = 2131379113;
        ItemTextArrow r27 = ViewBindings.findChildViewById(r0, 2131379113);
        if (r27 == null) goto L85;
        r1 = 2131380245;
        TextView r28 = (TextView) ViewBindings.findChildViewById(r0, 2131380245);
        if (r28 == null) goto L85;
        r1 = 2131381726;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131381726);
        if (r29 == null) goto L85;
        r1 = 2131381727;
        if (((TextView) ViewBindings.findChildViewById(r0, 2131381727)) == null) goto L85;
        r1 = 2131381731;
        ItemGroup r30 = ViewBindings.findChildViewById(r0, 2131381731);
        if (r30 == null) goto L85;
        r1 = 2131383040;
        ItemTextArrow r31 = ViewBindings.findChildViewById(r0, 2131383040);
        if (r31 == null) goto L85;
        r1 = 2131383041;
        ItemTextArrow r32 = ViewBindings.findChildViewById(r0, 2131383041);
        if (r32 == null) goto L85;
        r1 = 2131383401;
        ItemTextArrow r33 = ViewBindings.findChildViewById(r0, 2131383401);
        if (r33 == null) goto L85;
        r1 = 2131385238;
        if (ViewBindings.findChildViewById(r0, 2131385238) == null) goto L85;
        r1 = 2131385936;
        ItemTextArrow r34 = ViewBindings.findChildViewById(r0, 2131385936);
        if (r34 == null) goto L85;
        r1 = 2131386345;
        ItemTextArrow r35 = ViewBindings.findChildViewById(r0, 2131386345);
        if (r35 == null) goto L85;
        r1 = 2131388772;
        NovaTitleBarEx r36 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r36 == null) goto L85;
        r1 = 2131389407;
        ItemTextArrow r37 = ViewBindings.findChildViewById(r0, 2131389407);
        if (r37 == null) goto L85;
        r1 = 2131391989;
        ItemTextArrow r38 = ViewBindings.findChildViewById(r0, 2131391989);
        if (r38 == null) goto L85;
        LinearLayout r2 = (LinearLayout) r0;
        this.f = new PageSettingAboutObricPageBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
        return r2;
    L85:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}

package com.obric.assistant.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.common.ui.item.ObricItemTextArrowSubTitle;
import com.obric.assistant.impl.databinding.ObricFragmentChatSettingBinding;
import com.obric.assistant.settings.config.ModelSettingsConfig;
import com.obric.assistant.settings.config.ModelSettingsItem;
import com.obric.assistant.t1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010(\u001a\u00020)H\u0016J\u000f\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010+J\u000f\u0010,\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010+J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\u000f\u00100\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u0010+R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/settings/OrionChatSettingComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/settings/IOrionChatSettingAbility;", "<init>", "()V", "settingBinding", "Lcom/larus/bmhome/setting/ICommonSettingBinding;", "getSettingBinding", "()Lcom/larus/bmhome/setting/ICommonSettingBinding;", "settingBinding$delegate", "Lkotlin/Lazy;", "settingData", "Lcom/larus/bmhome/setting/SettingsData;", "getSettingData", "()Lcom/larus/bmhome/setting/SettingsData;", "settingData$delegate", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentChatSettingBinding;", "ac", "Landroidx/fragment/app/FragmentActivity;", "getAc", "()Landroidx/fragment/app/FragmentActivity;", "ac$delegate", "parentView", "Landroid/widget/LinearLayout;", "getParentView", "()Landroid/widget/LinearLayout;", "parentView$delegate", "isNonReleaseEnv", "", "uiMode", "", "Ljava/lang/Integer;", "density", "isSetDefaultAssistantDialogShowing", "isSetDefaultAssistantRequesting", "modelSettingsConfig", "Lcom/obric/assistant/settings/config/ModelSettingsConfig;", "currentModel", "", "onParentViewCreated", "", "setupObricSetting", "()Lkotlin/Unit;", "setupSetDefaultAssistantEntry", "showSetDefaultAssistantConfirmDialog", "setDefaultAssistant", "showSetDefaultAssistantFailedToast", "setupSelectModelSettings", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatSettingComponent extends BaseContentWidget implements k {
    public static final /* synthetic */ int x = 0;
    public final Lazy m;
    public final Lazy n;
    public ObricFragmentChatSettingBinding o;
    public final Lazy p;
    public final Lazy q;
    public Integer r;
    public Integer s;
    public boolean t;
    public boolean u;
    public final ModelSettingsConfig v;
    public String w;

    public static final class a {
    }

    public static final class b implements Function0<com.larus.bmhome.setting.c> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(com.larus.bmhome.setting.c.class));
        }
    }

    public static final class c implements Function0<com.larus.bmhome.setting.k> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(com.larus.bmhome.setting.k.class));
        }
    }

    static {
    }

    public final void B2() {
        com.larus.bmhome.setting.c r1 = (com.larus.bmhome.setting.c) this.m.getValue();
        int r2 = 8;
        if (r1 == null) goto L11;
        ItemTextView r3 = r1.d0();
        if (r3 == null) goto L11;
        if (t9a.b.a().b() == true) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        goto L11
    L9:
        r4 = 8;
    L11:
        com.larus.bmhome.setting.k r5 = (com.larus.bmhome.setting.k) this.n.getValue();
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        FragmentActivity r7 = Y2();
        if (r7 == null) goto L22;
        Intent r8 = r7.getIntent();
        if (r8 == null) goto L22;
        Bundle r9 = r8.getExtras();
    L23:
        if (r9 == null) goto L25;
        Integer r10 = Integer.valueOf(r9.getInt("setting_bot_cvs_type", 2));
    L26:
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        FLogger r12 = FLogger.a;
        r12.i("OrionChatSettingComponent", "onParentViewCreated isAppSettings = " + r6 + ",isMainBot = " + r11);
        if (r6 == true) goto L36;
        if (r11 == true) goto L36;
        return;
    L36:
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r13 = IObricAvailableManager.a.a();
        if (r13 != null) goto L39;
    L41:
        boolean r14 = false;
    L42:
        com.obric.assistant.common.utils.m.a.getClass();
        boolean r15 = com.obric.assistant.common.utils.m.a();
        r12.i("OrionChatSettingComponent", "onParentViewCreated isDefaultAssistant=" + r14 + ", isHK=" + r15);
        r12.i("OrionChatSettingComponent", "setupViews: ");
        if (this.o == null) goto L54;
        Integer r16 = this.r;
        int r17 = getContext().getResources().getConfiguration().uiMode;
        if (r16 == null) goto L54;
        if (r16.intValue() != r17) goto L54;
        Integer r18 = this.s;
        int r19 = getContext().getResources().getConfiguration().densityDpi;
        if (r18 == null) goto L54;
        if (r18.intValue() != r19) goto L54;
    L65:
        ObricFragmentChatSettingBinding r20 = this.o;
        if (r20 == null) goto L76;
        LinearLayout r21 = r20.a;
        if (r21 == null) goto L76;
        ViewParent r22 = r21.getParent();
        if (r22 == null) goto L76;
        ViewGroup r23 = (ViewGroup) r22;
        ObricFragmentChatSettingBinding r110 = this.o;
        if (r110 == null) goto L74;
        LinearLayout r111 = r110.a;
    L75:
        r23.removeView(r111);
        goto L76
    L74:
        r111 = null;
    L76:
        int r24 = getContext().getResources().getConfiguration().densityDpi;
        if (AppHost.a.isTestChannel() == true) goto L86;
        com.larus.platform.service.s r25 = com.larus.platform.service.s.a;
        if (r25.h() == true) goto L86;
        if (Intrinsics.areEqual(r25.getBuildChannel(), "auto_test") == true) goto L83;
    L85:
        boolean r26 = false;
    L87:
        if (r26 == true) goto L114;
        com.larus.bmhome.setting.c r27 = (com.larus.bmhome.setting.c) this.m.getValue();
        if (r27 == null) goto L91;
        ItemGroup r28 = r27.t0();
    L92:
        if (r28 != null) goto L94;
    L96:
        boolean r112 = false;
    L97:
        if (r112 == true) goto L100;
        r28 = null;
    L100:
        if (r28 != null) goto L105;
        com.larus.bmhome.setting.c r29 = (com.larus.bmhome.setting.c) this.m.getValue();
        if (r29 == null) goto L104;
        r28 = r29.m0();
        goto L105
    L104:
        r28 = null;
    L105:
        if (r28 == null) goto L107;
        ViewGroup.LayoutParams r113 = r28.getLayoutParams();
    L109:
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L111;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
    L112:
        if (r114 == null) goto L114;
        r114.topMargin = i5.r0();
        r28.setLayoutParams(r114);
        r12.i("OrionChatSettingComponent", Reflection.getOrCreateKotlinClass(ItemGroup.class).getSimpleName() + " margin top = " + r114.topMargin);
        goto L114
    L111:
        r114 = null;
        goto L112
    L107:
        r113 = null;
        goto L109
    L94:
        if (r28.getVisibility() != 8) goto L96;
        r112 = true;
        goto L97
    L91:
        r28 = null;
    L114:
        LinearLayout r30 = (LinearLayout) this.q.getValue();
        if (r30 == null) goto L130;
        com.larus.bmhome.setting.c r115 = (com.larus.bmhome.setting.c) this.m.getValue();
        if (r115 == null) goto L119;
        RelativeLayout r116 = r115.d1();
    L120:
        int r31 = r30.indexOfChild(r116);
        LinearLayout r117 = (LinearLayout) this.q.getValue();
        if (r117 == null) goto L130;
        ObricFragmentChatSettingBinding r118 = this.o;
        if (r118 == null) goto L125;
        LinearLayout r119 = r118.a;
    L126:
        if (r31 < 0) goto L128;
        int r32 = r31 + 1;
    L129:
        r117.addView(r119, r32);
        goto L130
    L128:
        r32 = 0;
        goto L129
    L125:
        r119 = null;
        goto L126
    L119:
        r116 = null;
    L130:
        if (r14 == true) goto L135;
        if (r15 == false) goto L135;
        ObricFragmentChatSettingBinding r33 = this.o;
        if (r33 == null) goto L153;
        r33.c.setVisibility(0);
        r33.f.setVisibility(8);
        r33.b.setVisibility(8);
        r33.e.setVisibility(0);
        r33.e.setText(getContext().getString(2131912403));
        r33.e.setTextColor(ContextCompat.getColor(getContext(), 2131105539));
        r33.e.getTextView().setGravity(17);
        r33.e.getTextView().setTextAlignment(4);
        r33.e.setClickable(true);
        r33.e.setOnClickListener(new r0(this));
        r33.c.c();
        r12.i("OrionChatSettingComponent", "setupSetDefaultAssistantEntry");
        Unit r34 = Unit.INSTANCE;
        return;
    L153:
        return;
    L135:
        ObricFragmentChatSettingBinding r35 = this.o;
        if (r35 == null) goto L138;
        r35.c.setVisibility(0);
        r35.f.setVisibility(0);
        r35.e.setVisibility(8);
        r35.f.setClickable(true);
        r35.f.setOnClickListener(new v0(this));
        r35.c.c();
        r12.i("OrionChatSettingComponent", "setupObricSetting");
        Unit r36 = Unit.INSTANCE;
    L138:
        ObricFragmentChatSettingBinding r37 = this.o;
        if (r37 == null) goto L155;
        ItemGroup r38 = r37.b;
        if (this.v.isModelSettingsEnable() == false) goto L143;
        r2 = 0;
    L143:
        r38.setVisibility(r2);
        ModelSettingsItem r39 = this.v.getModel(this.w);
        if (r39 == null) goto L149;
        ItemTextArrow r40 = r37.d;
        String r41 = r39.getName();
        if (r41 != null) goto L148;
        r41 = "";
    L148:
        int r42 = ItemTextArrow.k;
        r40.Z5(r41, null);
    L149:
        r37.d.setOnClickListener(new s0(this));
        Unit r43 = Unit.INSTANCE;
        return;
    L155:
        return;
    L83:
        if (r25.a() == false) goto L85;
    L86:
        r26 = true;
    L54:
        View r44 = LayoutInflater.from(Y2()).inflate(2131563997, (LinearLayout) this.q.getValue(), false);
        int r120 = 2131373982;
        ItemGroup r121 = ViewBindings.findChildViewById(r44, 2131373982);
        if (r121 == null) goto L152;
        r120 = 2131373992;
        ItemGroup r122 = ViewBindings.findChildViewById(r44, 2131373992);
        if (r122 == null) goto L152;
        r120 = 2131375807;
        ItemTextArrow r123 = ViewBindings.findChildViewById(r44, 2131375807);
        if (r123 == null) goto L152;
        r120 = 2131381243;
        ItemTextView r124 = ViewBindings.findChildViewById(r44, 2131381243);
        if (r124 == null) goto L152;
        r120 = 2131381244;
        ObricItemTextArrowSubTitle r125 = ViewBindings.findChildViewById(r44, 2131381244);
        if (r125 == null) goto L152;
        this.o = new ObricFragmentChatSettingBinding((LinearLayout) r44, r121, r122, r123, r124, r125);
        this.r = Integer.valueOf(getContext().getResources().getConfiguration().uiMode);
        this.s = Integer.valueOf(getContext().getResources().getConfiguration().densityDpi);
    L152:
        throw new NullPointerException("Missing required view with ID: ".concat(r44.getResources().getResourceName(r120)));
    L39:
        if (r13.a() != true) goto L41;
        r14 = true;
        goto L42
    L29:
        if (r10.intValue() != 1) goto L31;
        r11 = true;
        goto L32
    L25:
        r10 = null;
    L22:
        r9 = null;
        goto L23
    L14:
        if (r5.a != true) goto L16;
        r6 = true;
        goto L17
    }

    public final FragmentActivity Y2() {
        return (FragmentActivity) this.p.getValue();
    }

    public OrionChatSettingComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new t0(this));
        this.q = LazyKt.lazy(new u0(this));
        t1 r0 = t1.a;
        this.v = r0.Y0();
        this.w = r0.Z();
    }
}

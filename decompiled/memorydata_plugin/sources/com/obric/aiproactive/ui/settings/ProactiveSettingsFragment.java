package com.obric.aiproactive.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.databinding.ActivityProactiveSettingsBinding;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020'H\u0016J\b\u0010+\u001a\u00020'H\u0002J\b\u0010,\u001a\u00020'H\u0002J\u0016\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001cH\u0002J\u0017\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J\u001a\u0010:\u001a\u00020'*\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020'0=H\u0002J\u001c\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020@H\u0002J$\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/obric/aiproactive/ui/databinding/ActivityProactiveSettingsBinding;", "binding", "getBinding", "()Lcom/obric/aiproactive/ui/databinding/ActivityProactiveSettingsBinding;", "initiativeStore", "Lcom/obric/aiproactive/ui/settings/InitiativeLevelStore;", "getInitiativeStore", "()Lcom/obric/aiproactive/ui/settings/InitiativeLevelStore;", "initiativeStore$delegate", "Lkotlin/Lazy;", "initiativeViewModel", "Lcom/obric/aiproactive/ui/settings/ProactiveSettingsViewModel;", "getInitiativeViewModel", "()Lcom/obric/aiproactive/ui/settings/ProactiveSettingsViewModel;", "initiativeViewModel$delegate", "shortcutCoordinator", "Lcom/obric/aiproactive/ui/settings/ProactiveShortcutCoordinator;", "featureSwitchCoordinator", "Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchCoordinator;", "getFeatureSwitchCoordinator", "()Lcom/obric/aiproactive/ui/settings/ProactiveFeatureSwitchCoordinator;", "featureSwitchCoordinator$delegate", "syncingFeatureSwitch", "", "featureSwitchUpdateInProgress", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "bindFeatureSwitch", "refreshFeatureSwitch", "updateFeatureSwitch", "targetEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportFeatureSwitchClick", "applyFeatureSwitchState", "enabled", "(Ljava/lang/Boolean;)V", "bindInitiativeEntry", "refreshInitiativeLevel", "bindShortcutSwitch", "switchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "bindEntries", "setEntryClickListener", "Lcom/obric/oui/lisitem/OCardListItem;", "action", "Lkotlin/Function0;", "openHostActivity", "className", "", "fallbackTitle", "openPlaceholder", "title", "openIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", TypedValues.AttributesType.S_TARGET, "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveSettingsFragment extends Fragment {
    private static final String ACTION_MEMORY_SETTINGS = "com.obric.memorydata.ACTION_MEMORY_SETTINGS";
    private static final String BACK_STACK_NAME = "proactive_settings";
    private static final String CONTEXT_AWARENESS_SETTINGS_ACTIVITY = "com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity";
    public static final a Companion = null;
    private static final String HOST_LOCAL_DATA_SEARCH_ACTIVITY = "com.obric.assistant.settings.memory.ObricPersonalContextSettingActivity";
    private static final String HOST_LOCKED_SCREEN_USE_ASSISTANT_ACTIVITY = "com.obric.assistant.settings.lockeduse.ObricLockedUseManagementActivity";
    private static final String HOST_PHONE_OPERATION_ACTIVITY = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsActivity";
    private static final String HOST_SKILL_SHOP_ACTIVITY = "com.obric.aiagent.skill.manager.impl.ui.SkillShopStarterActivity";
    private static final String TAG = "ProactiveSettings";
    private ActivityProactiveSettingsBinding _binding;
    private final Lazy featureSwitchCoordinator$delegate;
    private boolean featureSwitchUpdateInProgress;
    private final Lazy initiativeStore$delegate;
    private final Lazy initiativeViewModel$delegate;
    private i shortcutCoordinator;
    private final CompoundButton.OnCheckedChangeListener switchListener;
    private boolean syncingFeatureSwitch;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveSettingsFragment$Companion;", "", "<init>", "()V", "TAG", "", "BACK_STACK_NAME", "ACTION_MEMORY_SETTINGS", "CONTEXT_AWARENESS_SETTINGS_ACTIVITY", "HOST_LOCAL_DATA_SEARCH_ACTIVITY", "HOST_PHONE_OPERATION_ACTIVITY", "HOST_SKILL_SHOP_ACTIVITY", "HOST_LOCKED_SCREEN_USE_ASSISTANT_ACTIVITY", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(FragmentManager r10) {
            Intrinsics.checkNotNullParameter(r10, "fragmentManager");
            Fragment r9 = r10.findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
            ProactiveSettingsFragment r2 = new ProactiveSettingsFragment();
            FragmentTransaction r11 = r10.beginTransaction().setReorderingAllowed(true).setCustomAnimations(ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_enter, "anim", "proactive_activity_open_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_exit, "anim", "proactive_activity_open_exit"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_enter, "anim", "proactive_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_exit, "anim", "proactive_activity_close_exit"));
            Intrinsics.checkNotNullExpressionValue(r11, "setCustomAnimations(...)");
            if (r9 == null) goto L5;
            r11.hide(r9);
            r11.setMaxLifecycle(r9, Lifecycle.State.STARTED);
        L5:
            r11.add(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"), (Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).setPrimaryNavigationFragment((Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).addToBackStack(ProactiveSettingsFragment.BACK_STACK_NAME).commit();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.settings.ProactiveSettingsFragment$updateFeatureSwitch$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.settings.ProactiveSettingsFragment", f = "ProactiveSettingsFragment.kt", i = {0}, l = {114}, m = "updateFeatureSwitch", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProactiveSettingsFragment this$0;

        AnonymousClass1(ProactiveSettingsFragment r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ProactiveSettingsFragment.access$updateFeatureSwitch(this.this$0, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveSettingsFragment() {
        this.initiativeStore$delegate = LazyKt.lazy(new $$Lambda$ProactiveSettingsFragment$uSLSc28defEJ7E0P_y0KjtUOEjc(this));
        this.initiativeViewModel$delegate = LazyKt.lazy(new $$Lambda$ProactiveSettingsFragment$E9bqnUXR8v1X1AZOO8Jk0SZONEU(this));
        this.featureSwitchCoordinator$delegate = LazyKt.lazy($$Lambda$ProactiveSettingsFragment$M8KsUusIzWsdQV0C2bxQdvQNtbY.INSTANCE);
        this.switchListener = new $$Lambda$ProactiveSettingsFragment$PGJai0CZEQ_NPZ8358psVAUaoJc(this);
    }

    public static final /* synthetic */ Object access$updateFeatureSwitch(ProactiveSettingsFragment r2, boolean r3, Continuation r4) {
        return r2.updateFeatureSwitch(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final void applyFeatureSwitchState(Boolean r5) {
        OSwitch r0 = getBinding().proactiveFeatureSwitch.getEndSwitch();
        if (r0 != null) goto L5;
        return;
    L5:
        this.syncingFeatureSwitch = true;
        if (r5 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.setEnabled(r3);
        r0.setChecked(Intrinsics.areEqual(r5, true));
        this.syncingFeatureSwitch = false;
        return;
    L8:
        r3 = false;
        goto L9
    }

    private final void bindEntries() {
        OCardListItem r0 = getBinding().localDataSearch;
        Intrinsics.checkNotNullExpressionValue(r0, "localDataSearch");
        setEntryClickListener(r0, new $$Lambda$ProactiveSettingsFragment$zT7RVyqkucg3DnG72ElVzf0CMM(this));
        OCardListItem r1 = getBinding().globalMemory;
        Intrinsics.checkNotNullExpressionValue(r1, "globalMemory");
        setEntryClickListener(r1, new $$Lambda$ProactiveSettingsFragment$O87jpvOX5FYQg9twBltkAeUk20c(this));
        OCardListItem r2 = getBinding().contextAwareness;
        Intrinsics.checkNotNullExpressionValue(r2, "contextAwareness");
        setEntryClickListener(r2, new $$Lambda$ProactiveSettingsFragment$e0YcMXRvWITrps8Xivxnxb25a4(this));
        OCardListItem r3 = getBinding().phoneOperation;
        Intrinsics.checkNotNullExpressionValue(r3, "phoneOperation");
        setEntryClickListener(r3, new $$Lambda$ProactiveSettingsFragment$6QQt3_yZcG78cJm3mfudwCqvnww(this));
        OCardListItem r4 = getBinding().allSkills;
        Intrinsics.checkNotNullExpressionValue(r4, "allSkills");
        setEntryClickListener(r4, new $$Lambda$ProactiveSettingsFragment$fba24ukptw52VWMcqQpEISbygA4(this));
        OCardListItem r5 = getBinding().lockedScreenUseAssistant;
        Intrinsics.checkNotNullExpressionValue(r5, "lockedScreenUseAssistant");
        setEntryClickListener(r5, new $$Lambda$ProactiveSettingsFragment$UG0kmoHSx0JJ7TuDZUjvNUQ_Hv0(this));
        OCardListItem r6 = getBinding().allTools;
        Intrinsics.checkNotNullExpressionValue(r6, "allTools");
        setEntryClickListener(r6, new $$Lambda$ProactiveSettingsFragment$BegChMninDrHpR2eW7C__XjBCPE(this));
    }

    private static final Unit bindEntries$lambda$14(ProactiveSettingsFragment r3) {
        openHostActivity$default(r3, HOST_LOCAL_DATA_SEARCH_ACTIVITY, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$15(ProactiveSettingsFragment r9) {
        Intent r4 = new Intent(ACTION_MEMORY_SETTINGS).setPackage(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName()).putExtra("com.obric.memorydata.extra.RETURN_TO_PROACTIVE_SETTINGS", true);
        Intrinsics.checkNotNullExpressionValue(r4, "putExtra(...)");
        openIntent$default(r9, r4, "global_memory", null, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$16(ProactiveSettingsFragment r3) {
        openHostActivity$default(r3, CONTEXT_AWARENESS_SETTINGS_ACTIVITY, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$17(ProactiveSettingsFragment r3) {
        openHostActivity$default(r3, HOST_PHONE_OPERATION_ACTIVITY, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$18(ProactiveSettingsFragment r3) {
        r3.openHostActivity(HOST_SKILL_SHOP_ACTIVITY, r3.getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_all_skills, TypedValues.Custom.S_STRING, "proactive_settings_all_skills")));
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$19(ProactiveSettingsFragment r3) {
        openHostActivity$default(r3, HOST_LOCKED_SCREEN_USE_ASSISTANT_ACTIVITY, null, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit bindEntries$lambda$20(ProactiveSettingsFragment r3) {
        String r0 = r3.getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_all_tools, TypedValues.Custom.S_STRING, "proactive_settings_all_tools"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        r3.openPlaceholder(r0);
        return Unit.INSTANCE;
    }

    private final void bindFeatureSwitch() {
        OSwitch r0 = getBinding().proactiveFeatureSwitch.getEndSwitch();
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(new $$Lambda$ProactiveSettingsFragment$TaOgWwphEY72R6ju_53ex4b0jQ(this));
    L5:
        OCardListItem r1 = getBinding().proactiveFeatureSwitch;
        Intrinsics.checkNotNullExpressionValue(r1, "proactiveFeatureSwitch");
        setEntryClickListener(r1, new $$Lambda$ProactiveSettingsFragment$VCrAqoESDCBxGX6x_oqMZigB3s(this));
        refreshFeatureSwitch();
    }

    private static final void bindFeatureSwitch$lambda$5(ProactiveSettingsFragment r8, CompoundButton r9, boolean r10) {
        if (r8.syncingFeatureSwitch == false) goto L5;
        return;
    L5:
        LifecycleOwner r11 = r8.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r11, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r11), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveSettingsFragment$bindFeatureSwitch$1$1(r8, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit bindFeatureSwitch$lambda$6(ProactiveSettingsFragment r2) {
        OSwitch r0 = r2.getBinding().proactiveFeatureSwitch.getEndSwitch();
        if (r0 != null) goto L7;
        return Unit.INSTANCE;
    L7:
        if (r0.isEnabled() == false) goto L12;
        if (r2.featureSwitchUpdateInProgress == true) goto L12;
        r0.setChecked(!r0.isChecked());
    L12:
        return Unit.INSTANCE;
    }

    private final void bindInitiativeEntry() {
        OCardListItem r0 = getBinding().initiativeLevel;
        Intrinsics.checkNotNullExpressionValue(r0, "initiativeLevel");
        setEntryClickListener(r0, new $$Lambda$ProactiveSettingsFragment$QWobbtIWhSx7mewwkBKFCcgUi6Y(this));
    }

    private static final Unit bindInitiativeEntry$lambda$7(ProactiveSettingsFragment r2) {
        ProactiveInitiativeLevelFragment.a r0 = ProactiveInitiativeLevelFragment.Companion;
        FragmentManager r3 = r2.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r3, "getParentFragmentManager(...)");
        r0.a(r3);
        return Unit.INSTANCE;
    }

    private final void bindShortcutSwitch() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        LifecycleOwner r2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r2, "getViewLifecycleOwner(...)");
        i r0 = new i(r1, r2);
        this.shortcutCoordinator = r0;
        r0.a(new $$Lambda$ProactiveSettingsFragment$KYl5DA0u_VA9PDmFOT69XD9ESJU(this));
        r0.a();
        OSwitch r3 = getBinding().desktopShortcut.getEndSwitch();
        if (r3 == null) goto L5;
        r3.setOnCheckedChangeListener(this.switchListener);
    L5:
        OCardListItem r4 = getBinding().desktopShortcut;
        Intrinsics.checkNotNullExpressionValue(r4, "desktopShortcut");
        setEntryClickListener(r4, new $$Lambda$ProactiveSettingsFragment$wsX3i9e9LVWAJ_gMIzRzLmpB4NY(this));
    }

    private static final Unit bindShortcutSwitch$lambda$12(ProactiveSettingsFragment r1) {
        OSwitch r2 = r1.getBinding().desktopShortcut.getEndSwitch();
        if (r2 == null) goto L6;
        r2.setChecked(!r2.isChecked());
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit bindShortcutSwitch$lambda$9(ProactiveSettingsFragment r2, boolean r3) {
        OSwitch r0 = r2.getBinding().desktopShortcut.getEndSwitch();
        if (r0 == null) goto L6;
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(r3);
        r0.setOnCheckedChangeListener(r2.switchListener);
    L6:
        return Unit.INSTANCE;
    }

    private static final d featureSwitchCoordinator_delegate$lambda$3() {
        return new d((e) ZeusTransformUtils.preCheckCast(new f(null, 1, null), e.class, "com.obric.memorydata.plugin"));
    }

    private final ActivityProactiveSettingsBinding getBinding() {
        ActivityProactiveSettingsBinding r1 = this._binding;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final d getFeatureSwitchCoordinator() {
        return (d) ZeusTransformUtils.preCheckCast(this.featureSwitchCoordinator$delegate.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    private final b getInitiativeStore() {
        return (b) ZeusTransformUtils.preCheckCast(this.initiativeStore$delegate.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    private final ProactiveSettingsViewModel getInitiativeViewModel() {
        return (ProactiveSettingsViewModel) ZeusTransformUtils.preCheckCast(this.initiativeViewModel$delegate.getValue(), ProactiveSettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final b initiativeStore_delegate$lambda$0(ProactiveSettingsFragment r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireContext(...)");
        return new b(r4);
    }

    private static final ProactiveSettingsViewModel initiativeViewModel_delegate$lambda$2(ProactiveSettingsFragment r3) {
        ProactiveSettingsViewModel r0 = new ProactiveSettingsViewModel();
        ProactiveSettingsViewModel.bind$default(r0, (com.obric.aiproactive.ui.settings.a) ZeusTransformUtils.preCheckCast(r3.getInitiativeStore(), com.obric.aiproactive.ui.settings.a.class, "com.obric.memorydata.plugin"), null, 2, null);
        return r0;
    }

    public static /* synthetic */ Unit lambda$6QQt3_yZcG78cJm3mfudwCqvnww(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$17(r0);
    }

    public static /* synthetic */ void lambda$8yej5s3N6bK0uDdsh8KTHaAI8o4(Function0 r0, View r1) {
        setEntryClickListener$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit lambda$BegChMninDrHpR2eW7C__XjBCPE(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$20(r0);
    }

    public static /* synthetic */ ProactiveSettingsViewModel lambda$E9bqnUXR8v1X1AZOO8Jk0SZONEU(ProactiveSettingsFragment r0) {
        return initiativeViewModel_delegate$lambda$2(r0);
    }

    public static /* synthetic */ Unit lambda$KYl5DA0u_VA9PDmFOT69XD9ESJU(ProactiveSettingsFragment r0, boolean r1) {
        return bindShortcutSwitch$lambda$9(r0, r1);
    }

    public static /* synthetic */ d lambda$M8KsUusIzWsdQV0C2bxQdvQNtbY() {
        return featureSwitchCoordinator_delegate$lambda$3();
    }

    public static /* synthetic */ Unit lambda$O87jpvOX5FYQg9twBltkAeUk20c(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$15(r0);
    }

    public static /* synthetic */ void lambda$PGJai0CZEQ_NPZ8358psVAUaoJc(ProactiveSettingsFragment r0, CompoundButton r1, boolean r2) {
        switchListener$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$QWobbtIWhSx7mewwkBKFCcgUi6Y(ProactiveSettingsFragment r0) {
        return bindInitiativeEntry$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$TaOgWwphEY72R6ju_53ex-4b0jQ, reason: not valid java name */
    public static /* synthetic */ void m344lambda$TaOgWwphEY72R6ju_53ex4b0jQ(ProactiveSettingsFragment r0, CompoundButton r1, boolean r2) {
        bindFeatureSwitch$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$UG0kmoHSx0JJ7TuDZUjvNUQ_Hv0(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$19(r0);
    }

    /* JADX INFO: renamed from: lambda$VCrAqoESDCBxGX6x-_oqMZigB3s, reason: not valid java name */
    public static /* synthetic */ Unit m345lambda$VCrAqoESDCBxGX6x_oqMZigB3s(ProactiveSettingsFragment r0) {
        return bindFeatureSwitch$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$e0YcMXRvWITrps8Xiv-xnxb25a4, reason: not valid java name */
    public static /* synthetic */ Unit m346lambda$e0YcMXRvWITrps8Xivxnxb25a4(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$16(r0);
    }

    public static /* synthetic */ Unit lambda$fba24ukptw52VWMcqQpEISbygA4(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$18(r0);
    }

    /* JADX INFO: renamed from: lambda$tLr9KrOh9AwVc7ko-E1kEWDU-O8, reason: not valid java name */
    public static /* synthetic */ void m347lambda$tLr9KrOh9AwVc7koE1kEWDUO8(Function0 r0, View r1) {
        setEntryClickListener$lambda$22(r0, r1);
    }

    public static /* synthetic */ b lambda$uSLSc28defEJ7E0P_y0KjtUOEjc(ProactiveSettingsFragment r0) {
        return initiativeStore_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$wsX3i9e9LVWAJ_gMIzRzLmpB4NY(ProactiveSettingsFragment r0) {
        return bindShortcutSwitch$lambda$12(r0);
    }

    /* JADX INFO: renamed from: lambda$zT7RVyqkucg3DnG7-2ElVzf0CMM, reason: not valid java name */
    public static /* synthetic */ Unit m348lambda$zT7RVyqkucg3DnG72ElVzf0CMM(ProactiveSettingsFragment r0) {
        return bindEntries$lambda$14(r0);
    }

    private final void openHostActivity(String r5, String r6) {
        Intent r0 = new Intent().setClassName(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName(), r5);
        Intrinsics.checkNotNullExpressionValue(r0, "setClassName(...)");
        openIntent(r0, StringsKt.substringAfterLast$default(r5, '.', null, 2, null), r6);
    }

    static /* synthetic */ void openHostActivity$default(ProactiveSettingsFragment r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.openHostActivity(r1, r2);
    }

    private final void openIntent(Intent r11, String r12, String r13) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        ZeusTransformUtils.startActivity((ProactiveSettingsFragment) ZeusTransformUtils.preCheckCast(this, ProactiveSettingsFragment.class, "com.obric.memorydata.plugin"), r11, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r14) == false) goto L10;
        Unit r2 = (Unit) ZeusTransformUtils.preCheckCast(r14, Unit.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ui.h r3 = com.obric.memorydata.ui.h.f13009a;
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        r3.a((Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.memorydata.plugin"));
    L10:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 == null) goto L19;
        RunLog.INSTANCE.warn(TAG, "open proactive settings entry failed target=" + r12, r15);
        if (r13 != null) goto L15;
        com.obric.oui.toast.a.C0786a r5 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r16 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r16, "requireActivity(...)");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r16, Context.class, "com.obric.memorydata.plugin");
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_open_failed, TypedValues.Custom.S_STRING, "proactive_settings_open_failed"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r5, r6, r7, 0, 4, null);
        return;
    L15:
        openPlaceholder(r13);
        return;
    L19:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    static /* synthetic */ void openIntent$default(ProactiveSettingsFragment r0, Intent r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.openIntent(r1, r2, r3);
    }

    private final void openPlaceholder(String r3) {
        ProactiveSettingsPlaceholderFragment.a r0 = ProactiveSettingsPlaceholderFragment.Companion;
        FragmentManager r2 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r2, "getParentFragmentManager(...)");
        r0.a(r2, r3);
    }

    private final void refreshFeatureSwitch() {
        applyFeatureSwitchState(getFeatureSwitchCoordinator().a());
    }

    private final void refreshInitiativeLevel() {
        getInitiativeViewModel().refresh();
        InitiativeLevel r0 = (InitiativeLevel) ZeusTransformUtils.preCheckCast(getInitiativeViewModel().getInitiativeLevel().c(), InitiativeLevel.class, "com.obric.memorydata.plugin");
        OCardListItem.a(getBinding().initiativeLevel, (CharSequence) ZeusTransformUtils.preCheckCast(getString(r0.getLabelRes()), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
    }

    private final void reportFeatureSwitchClick(boolean r3) {
        com.obric.aiproactive.ui.util.h r2 = com.obric.aiproactive.ui.util.h.f6884a;
        if (r3 == false) goto L5;
        String r4 = "wake_up_doubao";
    L6:
        r2.b(BACK_STACK_NAME, "unlock_screen", r4);
        return;
    L5:
        r4 = "disable_proactive";
        goto L6
    }

    private final void setEntryClickListener(OCardListItem r2, Function0<Unit> r3) {
        final Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        r2.setOnClickListener(new $$Lambda$ProactiveSettingsFragment$8yej5s3N6bK0uDdsh8KTHaAI8o4(r1));
        r2.getContentContainer().setOnClickListener(new $$Lambda$ProactiveSettingsFragment$tLr9KrOh9AwVc7koE1kEWDUO8(r1));
    }

    private static final void setEntryClickListener$lambda$21(Function0 r1, View r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final void setEntryClickListener$lambda$22(Function0 r1, View r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final void switchListener$lambda$13(ProactiveSettingsFragment r2, CompoundButton r3, boolean r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireActivity(...)");
        i r6 = r2.shortcutCoordinator;
        if (r6 != null) goto L5;
        return;
    L5:
        r6.a((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.memorydata.plugin"), r4);
    }

    private final Object updateFeatureSwitch(boolean r9, Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r11, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        ProactiveSettingsFragment this = (ProactiveSettingsFragment) ZeusTransformUtils.preCheckCast(r0.L$0, ProactiveSettingsFragment.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
    L33:
        g r13 = (g) ZeusTransformUtils.preCheckCast(r12, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.featureSwitchUpdateInProgress = false;
        this.applyFeatureSwitchState(r13.a());
        if (r13.b() == true) goto L38;
        com.obric.oui.toast.a.C0786a r4 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r14 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r14, "requireActivity(...)");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.memorydata.plugin");
        String r6 = this.getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_feature_switch_failed, TypedValues.Custom.S_STRING, "proactive_settings_feature_switch_failed"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r4, r5, r6, 0, 4, null);
    L38:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        if (this.featureSwitchUpdateInProgress == true) goto L21;
        this.featureSwitchUpdateInProgress = true;
        OSwitch r15 = getBinding().proactiveFeatureSwitch.getEndSwitch();
        if (r15 == null) goto L25;
        r15.setEnabled(false);
    L25:
        reportFeatureSwitchClick(r9);
        d r16 = getFeatureSwitchCoordinator();     // Catch: Throwable -> L14
        if (r9 == false) goto L29;
        boolean r17 = true;
    L30:
        r0.L$0 = this;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r12 = r16.a(r17, r0);     // Catch: Throwable -> L14
        if (r12 != r2) goto L33;
        return r2;
    L29:
        r17 = false;
        goto L30
    L21:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        this.featureSwitchUpdateInProgress = false;
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r11);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ActivityProactiveSettingsBinding r4 = ActivityProactiveSettingsBinding.inflate(r1, r2, false);
        this._binding = r4;
        FrameLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.shortcutCoordinator = null;
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshFeatureSwitch();
        refreshInitiativeLevel();
        i r0 = this.shortcutCoordinator;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity r0 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r13, AppCompatActivity.class, "com.obric.memorydata.plugin");
        FrameLayout r14 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(r14, "getRoot(...)");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
        OFloatingTitleBar r2 = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar");
        ONestedScrollView r15 = getBinding().contentScroll;
        Intrinsics.checkNotNullExpressionValue(r15, "contentScroll");
        c.a(r0, r1, r2, (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"), null, 36.0f, null, 16, 32, null);
        bindFeatureSwitch();
        bindInitiativeEntry();
        bindShortcutSwitch();
        bindEntries();
    }
}

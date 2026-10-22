package com.larus.setting.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.network.HttpConst;
import com.larus.platform.IFlowSdkDepend;
import com.larus.search.api.IBrowserService;
import com.larus.setting.api.FlowSocialSettingsProvider;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.impl.databinding.LarusBottomSheetDataPermissonBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.training.IObricPrivacyModelTrainingService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Arrays;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f*\u0005#&),/\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\n\u00101\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00102\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00103\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00104\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00105\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00106\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00107\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u00109\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020=H\u0002J\n\u0010>\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010?\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\b\u0010D\u001a\u00020\u001bH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020=H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006I"}, d2 = {"Lcom/larus/setting/impl/DataPermissionBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/setting/impl/databinding/LarusBottomSheetDataPermissonBinding;", "permissionType", "", "provider", "Lcom/larus/setting/api/FlowSocialSettingsProvider;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroy", "initView", "initViewModel", "resetSwitchStatus", "observeSwitchChange", "privacyModelTrainingLegalLinkListener", "com/larus/setting/impl/DataPermissionBottomSheet$privacyModelTrainingLegalLinkListener$1", "Lcom/larus/setting/impl/DataPermissionBottomSheet$privacyModelTrainingLegalLinkListener$1;", "privacyModelTrainingLegalSpecificLinkListener", "com/larus/setting/impl/DataPermissionBottomSheet$privacyModelTrainingLegalSpecificLinkListener$1", "Lcom/larus/setting/impl/DataPermissionBottomSheet$privacyModelTrainingLegalSpecificLinkListener$1;", "privacyRealTimeDenoiseClickListener", "com/larus/setting/impl/DataPermissionBottomSheet$privacyRealTimeDenoiseClickListener$1", "Lcom/larus/setting/impl/DataPermissionBottomSheet$privacyRealTimeDenoiseClickListener$1;", "privacyFaceMemoryLinkClickListener", "com/larus/setting/impl/DataPermissionBottomSheet$privacyFaceMemoryLinkClickListener$1", "Lcom/larus/setting/impl/DataPermissionBottomSheet$privacyFaceMemoryLinkClickListener$1;", "privacyLinkClickListener", "com/larus/setting/impl/DataPermissionBottomSheet$privacyLinkClickListener$1", "Lcom/larus/setting/impl/DataPermissionBottomSheet$privacyLinkClickListener$1;", "initConversationTrainSwitch", "initVoiceInputTrainSwitch", "initVideoConversationTrainSwitch", "initObricPrivacyModelTrainingSwitchIfNeeded", "initMultimediaTrainSwitch", "initAllowTrainingSwitch", "initFindMyWaySettingsGroup", "initAddMyWaySettingsGroup", "initVoiceRecognizeSwitch", "initAdvancedAudioSwitch", "mobVoiceFeatureAuthClick", "isOpen", "", "initFaceMemorySwitch", "initPersonalRecommendSwitch", "initPictureLocationSwitch", "openPrivacyLink", "openModelTrainingLegalLink", "openModelTrainingLegalSpecificLink", "openRealtimeDenoisePrivacyLink", "openFaceMemoryPrivacyLink", "isOnOrOffString", "isChecked", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DataPermissionBottomSheet extends BottomSheetDialogFragment {
    public static final /* synthetic */ int m = 0;
    public final Lazy d;
    public LarusBottomSheetDataPermissonBinding e;
    public String f;
    public final FlowSocialSettingsProvider g;
    public final d h;
    public final e i;
    public final f j;
    public final b k;
    public final c l;

    public static final class a {
        public static DataPermissionBottomSheet a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "permissionType");
            DataPermissionBottomSheet r0 = new DataPermissionBottomSheet();
            r0.f = r1;
            return r0;
        }
    }

    public static final class b implements UrlSpanTextView.a {
        public final /* synthetic */ DataPermissionBottomSheet a;

        public b(DataPermissionBottomSheet r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            LarusBottomSheetDataPermissonBinding r6 = this.a.e;
            if (r6 == null) goto L13;
            LinearLayout r7 = r6.a;
            if (r7 == null) goto L14;
            IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
            if (r0 == null) goto L15;
            HttpConst.a.getClass();
            r0.i(r7, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.R)}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class c implements UrlSpanTextView.a {
        public final /* synthetic */ DataPermissionBottomSheet a;

        public c(DataPermissionBottomSheet r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            LarusBottomSheetDataPermissonBinding r6 = this.a.e;
            if (r6 == null) goto L13;
            LinearLayout r7 = r6.a;
            if (r7 == null) goto L14;
            IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
            if (r0 == null) goto L15;
            HttpConst.a.getClass();
            r0.i(r7, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.M)}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class d implements UrlSpanTextView.a {
        public final /* synthetic */ DataPermissionBottomSheet a;

        public d(DataPermissionBottomSheet r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            LarusBottomSheetDataPermissonBinding r6 = this.a.e;
            if (r6 == null) goto L13;
            LinearLayout r7 = r6.a;
            if (r7 == null) goto L14;
            IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
            if (r0 == null) goto L15;
            HttpConst.a.getClass();
            r0.i(r7, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.Q)}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class e implements UrlSpanTextView.a {
        public final /* synthetic */ DataPermissionBottomSheet a;

        public e(DataPermissionBottomSheet r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            LarusBottomSheetDataPermissonBinding r6 = this.a.e;
            if (r6 == null) goto L13;
            LinearLayout r7 = r6.a;
            if (r7 == null) goto L14;
            IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
            if (r0 == null) goto L15;
            HttpConst.a.getClass();
            r0.i(r7, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.S)}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class f implements UrlSpanTextView.a {
        public final /* synthetic */ DataPermissionBottomSheet a;

        public f(DataPermissionBottomSheet r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "url");
            if (Intrinsics.areEqual(r5, "pp") == false) goto L12;
            LarusBottomSheetDataPermissonBinding r6 = this.a.e;
            if (r6 == null) goto L13;
            LinearLayout r7 = r6.a;
            if (r7 == null) goto L14;
            IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r0 == null) goto L15;
            r0.e0();
            com.larus.home.impl.sdk.f1 r1 = com.larus.home.impl.sdk.f1.a;
            Context r8 = r7.getContext();
            HttpConst.a.getClass();
            r1.e(r8, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", HttpConst.b0)}), null);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    public static final class g implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public g(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public static String U90(boolean r0) {
        if (r0 == false) goto L4;
        return "on";
    L4:
        return "off";
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final SettingModel T90() {
        return (SettingModel) this.d.getValue();
    }

    public DataPermissionBottomSheet() {
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new DataPermissionBottomSheet$special$$inlined$activityViewModels$default$1(this), new DataPermissionBottomSheet$special$$inlined$activityViewModels$default$2(this));
        this.g = FlowSocialSettingsProvider.a;
        this.h = new d(this);
        this.i = new e(this);
        this.j = new f(this);
        this.k = new b(this);
        this.l = new c(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.e = null;
    }

    public static void S90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusBottomSheetDataPermissonBinding r13 = this.e;
        if (r13 == null) goto L49;
        String r8 = this.f;
        if (r8 == null) goto L49;
        switch(r8.hashCode()) {
            case -1770819293: goto L46;
            case -1599458858: goto L42;
            case -1584322796: goto L38;
            case -1412013699: goto L34;
            case -503039728: goto L30;
            case 83429562: goto L26;
            case 284297403: goto L22;
            case 1379353977: goto L18;
            case 1386471748: goto L14;
            case 2009957196: goto L10;
            default: goto L49;
        };
    L10:
        if (r8.equals("conversation_train") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isAllowTrainByText());
        goto L49
    L14:
        if (r8.equals("video_train") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isAllowTrainByVideo());
        goto L49
    L18:
        if (r8.equals("advanced_audio") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isOptOutVoiceEnabled());
        goto L49
    L22:
        if (r8.equals("voice_train") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isOptOutVoiceEnabled());
        goto L49
    L26:
        if (r8.equals("realtime_noise_reduction") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isRealtimeVoiceFeatureTrainAuthorize());
        goto L49
    L30:
        if (r8.equals("allow_training") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isAllowTraining());
        goto L49
    L34:
        if (r8.equals("personal_recommend") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isPersonalizedRecommendEnabled());
        goto L49
    L38:
        if (r8.equals("multimedia_train") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isAllowTrainByUpload());
        goto L49
    L42:
        if (r8.equals("picture_location") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().isPictureLocationEnabled());
        goto L49
    L46:
        if (r8.equals("face_memory") == false) goto L49;
        r13.f.getToggleView().setChecked(T90().getFaceMemoryEnabled());
    L49:
        String r14 = this.f;
        if (r14 != null) goto L52;
    L90:
        boolean r15 = v19.h.a;
        if (v19.h.b(requireContext()) == false) goto L103;
        LarusBottomSheetDataPermissonBinding r16 = this.e;
        if (r16 == null) goto L97;
        View r17 = r16.b;
        if (r17 == null) goto L97;
        r17.setBackground(ContextCompat.getDrawable(requireContext(), 2131103162));
    L97:
        LarusBottomSheetDataPermissonBinding r18 = this.e;
        if (r18 == null) goto L104;
        CardView r19 = r18.c;
        if (r19 == null) goto L105;
        r19.setCardBackgroundColor(ContextCompat.getColor(requireContext(), 2131103162));
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L52:
        switch(r14.hashCode()) {
            case -1770819293: goto L87;
            case -1599458858: goto L83;
            case -1584322796: goto L79;
            case -1412013699: goto L75;
            case -503039728: goto L71;
            case 284297403: goto L67;
            case 1379353977: goto L63;
            case 1386471748: goto L59;
            case 2009957196: goto L55;
            default: goto L90;
        };
    L55:
        if (r14.equals("conversation_train") == false) goto L90;
        T90().getAllowTrainByText().observe(getViewLifecycleOwner(), new g(new com.larus.setting.impl.f(this)));
        goto L90
    L59:
        if (r14.equals("video_train") == false) goto L90;
        T90().getAllowTrainByVideo().observe(getViewLifecycleOwner(), new g(new com.larus.setting.impl.g(this)));
        goto L90
    L63:
        if (r14.equals("advanced_audio") == false) goto L90;
        T90().getOptOutVoice().observe(getViewLifecycleOwner(), new g(new com.larus.setting.impl.d(this)));
        goto L90
    L67:
        if (r14.equals("voice_train") == false) goto L90;
        T90().getOptOutVoice().observe(getViewLifecycleOwner(), new g(new com.larus.setting.impl.e(this)));
        goto L90
    L71:
        if (r14.equals("allow_training") == false) goto L90;
        T90().getAllowTraining().observe(getViewLifecycleOwner(), new g(new com.larus.setting.impl.c(this)));
        goto L90
    L75:
        if (r14.equals("personal_recommend") == false) goto L90;
        T90().getPersonalizedRecommend().observe(getViewLifecycleOwner(), new g(new j(this)));
        goto L90
    L79:
        if (r14.equals("multimedia_train") == false) goto L90;
        T90().getAllowTrainByUpload().observe(getViewLifecycleOwner(), new g(new h(this)));
        goto L90
    L83:
        if (r14.equals("picture_location") == false) goto L90;
        T90().getPictureLocation().observe(getViewLifecycleOwner(), new g(new k(this)));
        goto L90
    L87:
        if (r14.equals("face_memory") == false) goto L90;
        T90().getFaceMemoryEnableLiveData().observe(getViewLifecycleOwner(), new g(new i(this)));
        goto L90
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131561852, r11, false);
        int r14 = 2131370209;
        View r3 = ViewBindings.findChildViewById(r13, 2131370209);
        if (r3 == null) goto L148;
        r14 = 2131370210;
        CardView r4 = ViewBindings.findChildViewById(r13, 2131370210);
        if (r4 == null) goto L148;
        LinearLayout r2 = (LinearLayout) r13;
        r14 = 2131382157;
        UrlSpanTextView r5 = ViewBindings.findChildViewById(r13, 2131382157);
        if (r5 == null) goto L148;
        r14 = 2131382165;
        ItemGroup r6 = ViewBindings.findChildViewById(r13, 2131382165);
        if (r6 == null) goto L148;
        r14 = 2131382166;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r13, 2131382166);
        if (r7 == null) goto L148;
        r14 = 2131382176;
        CardView r8 = ViewBindings.findChildViewById(r13, 2131382176);
        if (r8 == null) goto L148;
        this.e = new LarusBottomSheetDataPermissonBinding(r2, r3, r4, r5, r6, r7, r8);
        String r15 = this.f;
        if (r15 == null) goto L134;
        String r1 = "";
        switch(r15.hashCode()) {
            case -1770819293: goto L124;
            case -1599458858: goto L118;
            case -1584322796: goto L104;
            case -1412013699: goto L92;
            case -503039728: goto L86;
            case 83429562: goto L80;
            case 284297403: goto L66;
            case 820127522: goto L60;
            case 1379353977: goto L54;
            case 1386471748: goto L40;
            case 1892355898: goto L34;
            case 2009957196: goto L20;
            default: goto L134;
        };
    L20:
        if (r15.equals("conversation_train") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r16 = this.e;
        if (r16 == null) goto L142;
        int r17 = lt9.a.a;
        Context r18 = getContext();
        if (r18 == null) goto L32;
        String r9 = r18.getString(2131908496);
        if (r9 == null) goto L32;
        String r19 = String.format(r9, Arrays.copyOf(new Object[]{lt9.a.a(r18)}, 1));
        if (r19 == null) goto L32;
        r1 = r19;
    L32:
        r16.d.setUrlSpannedText(r1);
        r16.d.setOnClickListener(this.i);
        r16.f.setText(getString(2131908505));
        r16.f.getToggleView().setChecked(T90().isAllowTrainByText());
        r16.f.getToggleView().setOnCheckedChangeListener(new v(this));
    L142:
        LarusBottomSheetDataPermissonBinding r110 = this.e;
        if (r110 != null) goto L149;
        return null;
    L149:
        return r110.a;
    L34:
        if (r15.equals("add_my_way") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r111 = this.e;
        if (r111 == null) goto L142;
        com.larus.utils.e1.o(r111.g);
        com.larus.utils.e1.o(r111.d);
        this.g.a(getActivity(), FlowSettingsScene.ADD_MY_WAY, new m(r111));
        goto L142
    L40:
        if (r15.equals("video_train") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r112 = this.e;
        if (r112 == null) goto L142;
        int r113 = lt9.a.a;
        Context r114 = getContext();
        if (r114 == null) goto L52;
        String r20 = r114.getString(2131908500);
        if (r20 == null) goto L52;
        String r115 = String.format(r20, Arrays.copyOf(new Object[]{lt9.a.a(r114)}, 1));
        if (r115 == null) goto L52;
        r1 = r115;
    L52:
        r112.d.setUrlSpannedText(r1);
        r112.d.setOnClickListener(this.i);
        r112.f.setText(getString(2131908507));
        r112.f.getToggleView().setChecked(T90().isAllowTrainByVideo());
        r112.f.getToggleView().setOnCheckedChangeListener(new s(this));
        goto L142
    L54:
        if (r15.equals("advanced_audio") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r116 = this.e;
        if (r116 == null) goto L142;
        r116.f.getToggleView().setChecked(T90().isOptOutVoiceEnabled());
        r116.f.getToggleView().setOnCheckedChangeListener(new w(this));
        r116.f.setText(getString(2131908471));
        r116.d.setUrlSpannedText(getResources().getString(2131910010));
        r116.d.setOnClickListener(this.l);
        goto L142
    L60:
        if (r15.equals("find_my_way") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r117 = this.e;
        if (r117 == null) goto L142;
        com.larus.utils.e1.o(r117.g);
        com.larus.utils.e1.o(r117.d);
        this.g.a(getActivity(), FlowSettingsScene.FIND_MY_WAY, new x(r117));
        goto L142
    L66:
        if (r15.equals("voice_train") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r118 = this.e;
        if (r118 == null) goto L142;
        int r119 = lt9.a.a;
        Context r120 = getContext();
        if (r120 == null) goto L78;
        String r21 = r120.getString(2131908494);
        if (r21 == null) goto L78;
        String r121 = String.format(r21, Arrays.copyOf(new Object[]{lt9.a.a(r120)}, 1));
        if (r121 == null) goto L78;
        r1 = r121;
    L78:
        r118.d.setUrlSpannedText(r1);
        r118.d.setOnClickListener(this.i);
        r118.f.setText(getString(2131908504));
        r118.f.getToggleView().setChecked(T90().isOptOutVoiceEnabled());
        r118.f.getToggleView().setOnCheckedChangeListener(new y(this));
        goto L142
    L80:
        if (r15.equals("realtime_noise_reduction") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r122 = this.e;
        if (r122 == null) goto L142;
        FLogger.a.i("DataPermissionBottomSheet", "initVoiceRecognizeSwitch isChecked=" + T90().isRealtimeVoiceFeatureTrainAuthorize());
        String r123 = getString(2131908473);
        UrlSpanTextView r124 = r122.d;
        StringBuilder r0 = new StringBuilder();
        r0.append(r123);
        int r125 = lt9.a.a;
        r0.append(lt9.a.a(getContext()));
        r124.setUrlSpannedText(r0.toString());
        r122.d.setOnClickListener(this.j);
        r122.f.setText(getString(2131908469));
        r122.f.getToggleView().setOnClickListener(new z(r122, this));
        goto L142
    L86:
        if (r15.equals("allow_training") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r126 = this.e;
        if (r126 == null) goto L142;
        String r127 = getResources().getString(2131900705);
        UrlSpanTextView r128 = r126.d;
        StringBuilder r22 = new StringBuilder();
        r22.append(r127);
        int r129 = lt9.a.a;
        r22.append(lt9.a.a(getContext()));
        r128.setUrlSpannedText(r22.toString());
        r126.d.setOnClickListener(this.h);
        r126.f.setText(getString(2131900706));
        r126.f.getToggleView().setChecked(T90().isAllowTraining());
        r126.f.getToggleView().setOnCheckedChangeListener(new u(this, r126));
        goto L142
    L92:
        if (r15.equals("personal_recommend") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r130 = this.e;
        if (r130 == null) goto L142;
        r130.f.getToggleView().setChecked(T90().isPersonalizedRecommendEnabled());
        r130.f.getToggleView().setOnCheckedChangeListener(new com.larus.setting.impl.b(r130, this));
        int r131 = lt9.a.a;
        Context r132 = getContext();
        if (r132 == null) goto L102;
        String r133 = r132.getString(2131905993);
        if (r133 == null) goto L102;
        r1 = r133;
    L102:
        r130.f.setText(getString(2131910233));
        r130.d.setUrlSpannedText(r1 + lt9.a.a(getContext()));
        r130.d.setOnClickListener(this.l);
        goto L142
    L104:
        if (r15.equals("multimedia_train") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r134 = this.e;
        if (r134 == null) goto L142;
        int r135 = lt9.a.a;
        Context r136 = getContext();
        if (r136 == null) goto L116;
        String r23 = r136.getString(2131908498);
        if (r23 == null) goto L116;
        String r137 = String.format(r23, Arrays.copyOf(new Object[]{lt9.a.a(r136)}, 1));
        if (r137 == null) goto L116;
        r1 = r137;
    L116:
        r134.d.setUrlSpannedText(r1);
        r134.d.setOnClickListener(this.i);
        r134.f.setText(getString(2131908506));
        r134.f.getToggleView().setChecked(T90().isAllowTrainByUpload());
        r134.f.getToggleView().setOnCheckedChangeListener(new l(this));
        goto L142
    L118:
        if (r15.equals("picture_location") == false) goto L134;
        LarusBottomSheetDataPermissonBinding r138 = this.e;
        if (r138 == null) goto L142;
        r138.f.getToggleView().setChecked(T90().isPictureLocationEnabled());
        r138.f.setText(getString(2131908339));
        r138.f.getToggleView().setOnCheckedChangeListener(new t(this));
        r138.d.setUrlSpannedText(getResources().getString(2131908338));
        goto L142
    L124:
        if (r15.equals("face_memory") == false) goto L134;
        final LarusBottomSheetDataPermissonBinding r139 = this.e;
        if (r139 == null) goto L142;
        r139.f.getToggleView().setChecked(T90().getFaceMemoryEnabled());
        r139.f.getToggleView().setOnCheckedChangeListener(new n(this, r139));
        r139.f.setText(getString(2131905614));
        r139.d.setUrlSpannedText(getResources().getString(2131905615));
        r139.d.setOnClickListener(this.k);
        boolean r140 = T90().getFaceMemoryEnabled();
        by7.a r141 = new by7.a("setting_face_memory_button_show");
        if (r140 == false) goto L131;
        String r142 = "on";
    L132:
        r141.d("status", r142);
        r141.b();
        goto L142
    L131:
        r142 = "off";
    L134:
        if (this.e == null) goto L142;
        if (this.f == null) goto L142;
        IObricPrivacyModelTrainingService r143 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r143 == null) goto L142;
        r143.b();
    L148:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}

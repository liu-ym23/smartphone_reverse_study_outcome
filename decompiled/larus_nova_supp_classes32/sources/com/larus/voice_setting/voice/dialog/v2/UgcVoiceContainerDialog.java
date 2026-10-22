package com.larus.voice_setting.voice.dialog.v2;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceViewModel;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0002J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020&2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u000bH\u0002J\u000e\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0006RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceContainerDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "voiceCheckSuccess", "Lkotlin/Function2;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "filePath", "freeTalkContent", NameKeys.UnloadStrategy_No_Strategy, "getVoiceCheckSuccess", "()Lkotlin/jvm/functions/Function2;", "setVoiceCheckSuccess", "(Lkotlin/jvm/functions/Function2;)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogUgcVoiceContainerBinding;", "viewModel", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "getViewModel", "()Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "showAuthorizeDialog", NameKeys.UnloadStrategy_No_Strategy, "disableAnimation", "enterMethod", "logTraceId", "authorizeFragment", "Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceAuthorizeFragment;", "createFragment", "Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceCreateFragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initParams", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "handleLandingFragment", "initObservers", "onStart", "getTheme", NameKeys.UnloadStrategy_No_Strategy, "setupBottomSheetDialog", "goToAuthorize", "caller", "gotoCreate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceContainerDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public Function2<? super String, ? super String, Unit> d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public String h;
    public String i;
    public final UgcVoiceAuthorizeFragment j;
    public final UgcVoiceCreateFragment k;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(d r2) {
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

    public final int getTheme() {
        return 2131951931;
    }

    public UgcVoiceContainerDialog() {
        final Function0<Fragment> r0 = new UgcVoiceContainerDialog$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(UgcVoiceViewModel.class), new UgcVoiceContainerDialog$special$$inlined$viewModels$default$2(r0), new UgcVoiceContainerDialog$special$$inlined$viewModels$default$3(r0, this));
        this.h = NameKeys.UnloadStrategy_No_Strategy;
        this.i = NameKeys.UnloadStrategy_No_Strategy;
        this.j = new UgcVoiceAuthorizeFragment();
        this.k = new UgcVoiceCreateFragment();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        if (this.g == false) goto L10;
        f2a.c r0 = com.larus.voice_setting.voice.utils.k.a.b("disable window animations");
        r0.c.d = "UgcVoiceContainerDialog.onStart";
        List r1 = CollectionsKt.listOf(new String[]{this.i, "VoiceCreate"});
        f2a.g r2 = r0.c;
        r2.b = r1;
        r2.e = this.h;
        f2a.c.c(r0, null, 15);
        Dialog r3 = getDialog();
        if (r3 == null) goto L11;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L12;
        r4.setWindowAnimations(0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void S90(String r6) {
        Intrinsics.checkNotNullParameter(r6, "caller");
        f2a.c r1 = com.larus.voice_setting.voice.utils.k.a.b("goToAuthorize");
        r1.c.d = "UgcVoiceContainerDialog.goToAuthorize";
        r1.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(new f2a.f("caller"), r6)}));
        List r7 = CollectionsKt.listOf(new String[]{this.i, "VoiceCreate"});
        f2a.g r0 = r1.c;
        r0.b = r7;
        r0.e = this.h;
        f2a.c.c(r1, null, 15);
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        UgcVoiceAuthorizeFragment r2 = this.j;
        r2.setArguments(getArguments());
        Unit r3 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372709) == true) goto L6;
        r8 = r8.replace(2131372709, r2);
    L6:
        r8.commitAllowingStateLoss();
    }

    public final void T90(String r6) {
        Intrinsics.checkNotNullParameter(r6, "caller");
        f2a.c r1 = com.larus.voice_setting.voice.utils.k.a.b("gotoCreate");
        r1.c.d = "UgcVoiceContainerDialog.gotoCreate";
        r1.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(new f2a.f("caller"), r6)}));
        List r7 = CollectionsKt.listOf(new String[]{this.i, "VoiceCreate"});
        f2a.g r0 = r1.c;
        r0.b = r7;
        r0.e = this.h;
        f2a.c.c(r1, null, 15);
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        UgcVoiceCreateFragment r2 = this.k;
        r2.setArguments(getArguments());
        Unit r3 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131372709) == true) goto L6;
        r8 = r8.replace(2131372709, r2);
    L6:
        r8.commitAllowingStateLoss();
    }

    public final void onCreate(Bundle r5) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L12;
        this.f = r6.getBoolean("key_start_show_authorize_dialog", false);
        this.g = r6.getBoolean("key_disable_animation", false);
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        String r1 = r6.getString("key_enter_method", NameKeys.UnloadStrategy_No_Strategy);
        if (r1 != null) goto L7;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        this.h = r1;
        String r7 = r6.getString("key_log_trace_id", NameKeys.UnloadStrategy_No_Strategy);
        if (r7 == null) goto L11;
        r2 = r7;
    L11:
        this.i = r2;
    L12:
        f2a.c r8 = com.larus.voice_setting.voice.utils.k.a.b("UgcVoiceContainerDialog onCreate");
        r8.c.d = "UgcVoiceContainerDialog.onCreate";
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put(new f2a.f("show_authorize_dialog"), Boolean.valueOf(this.f));
        r3.put(new f2a.f("disable_animation"), Boolean.valueOf(this.g));
        r8.d(r3);
        List r0 = CollectionsKt.listOf(new String[]{this.i, "VoiceCreate"});
        f2a.g r4 = r8.c;
        r4.b = r0;
        r4.e = this.h;
        f2a.c.c(r8, null, 15);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voice_setting.voice.dialog.v2.d] */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        BottomSheetDialog r6 = getDialog();
        if ((r6 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r7 = r6;
    L6:
        if (r7 == null) goto L8;
        View r8 = r7.findViewById(2131368870);
    L9:
        int r9 = m0.a;
        int r10 = m0.a(getContext());
        i0.a.getClass();
        int r11 = ((r10 - i0.g()) - i0.e()) - i5.c0();
        if (r8 == null) goto L13;
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        r1.height = r11;
        r8.setLayoutParams(r1);
        BottomSheetBehavior r2 = BottomSheetBehavior.from(r8);
        r8.setBackgroundResource(R.color.transparent);
        r2.setState(3);
        r2.setPeekHeight(r11);
    L13:
        if (this.f == false) goto L15;
        S90("onViewCreated");
    L16:
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new UgcVoiceContainerDialog$initObservers$1(this, null));
        ((UgcVoiceViewModel) this.e.getValue()).getVoiceCheckSuccess().observe(getViewLifecycleOwner(), new b(new d(this)));
        return;
    L15:
        T90("onViewCreated");
        goto L16
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562106, r3, false);
        if (r5 == null) goto L7;
        return (FrameLayout) r5;
    L7:
        throw new NullPointerException("rootView");
    }
}

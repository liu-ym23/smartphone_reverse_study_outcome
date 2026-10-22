package com.obric.assistant.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricFragmentSettingBinding;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001JB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u00010.J\b\u00103\u001a\u00020\u001eH\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u000e\u00106\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\u001eH\u0002J\u0016\u00109\u001a\u00020\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\b\u0010=\u001a\u00020\u001eH\u0002J\u0018\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020AH\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u00020(2\u0006\u0010C\u001a\u00020\u0019H\u0002J\u000f\u0010D\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010EJ\n\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020\u001eH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006K"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentSettingBinding;", "settingAdapter", "Lcom/obric/assistant/settings/ObricSettingAdapter;", "viewModel", "Lcom/obric/assistant/settings/ObricSettingViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/ObricSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bluetoothListenersRegistered", "", "btListenerUuid", "Ljava/util/UUID;", "refreshSettingsJob", "Lkotlinx/coroutines/Job;", "hasSyncedReferenceMemoryCloudConfig", "pendingScrollToBottom", "pendingHighlightItemId", "", "isAccessoryVoicePrintEntryEnabled", "autoLogEnterPage", "getCurrentPageName", "refreshSettings", "", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onStart", "onStop", "hostContext", "Landroid/content/Context;", "getHostContext", "()Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateNavigationRequest", "extras", "onDestroyView", "onDestroy", "onResume", "syncReferenceMemoryCloudConfigIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeObricSettings", "handlePendingNavigationEffects", "items", "", "Lcom/obric/assistant/settings/GroupUiModel;", "scheduleHighlightIfNeeded", "tryHighlightTargetItem", "itemId", "retryCount", "", "findViewWithTagRecursively", "tag", "setTopBar", "()Lkotlin/Unit;", "setupObricSettings", "Landroidx/recyclerview/widget/RecyclerView;", "registerBluetoothListeners", "unregisterBluetoothListeners", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingFragment extends TraceFragment implements com.obric.assistant.settings.spi.b, t {
    public static final /* synthetic */ int n = 0;
    public ObricFragmentSettingBinding e;
    public ObricSettingAdapter f;
    public final Lazy g;
    public boolean h;
    public final UUID i;
    public Job j;
    public boolean k;
    public boolean l;
    public String m;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(d0 r2) {
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

    /* JADX INFO: renamed from: com.obric.assistant.settings.ObricSettingFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.ObricSettingFragment$onResume$1", f = "ObricSettingFragment.kt", i = {}, l = {ApWakeEvent.OTHER_START, ApWakeEvent.OTHER_END}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSettingFragment this$0;

        public AnonymousClass1(ObricSettingFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L22:
            this.this$0.kW();
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L19:
            this.label = 2;
            if (DelayKt.delay(500, this) != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            ObricSettingFragment r6 = this.this$0;
            this.label = 1;
            if (r6.k == false) goto L13;
            Object r7 = Unit.INSTANCE;
        L17:
            if (r7 != r0) goto L19;
            return r0;
        L13:
            r6.k = true;
            r7 = BuildersKt.withContext(Dispatchers.getIO(), new ObricSettingFragment$syncReferenceMemoryCloudConfigIfNeeded$2(null), this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
            r7 = Unit.INSTANCE;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.ObricSettingFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.ObricSettingFragment$onViewCreated$1", f = "ObricSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C00791(Continuation<? super C00791> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C00791(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            VoiceEnrollServiceDelegate.c.p();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_setting";
    }

    public final void W90() {
        final String r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        ObricFragmentSettingBinding r1 = this.e;
        if (r1 == null) goto L11;
        RecyclerView r2 = r1.b;
        if (r2 == null) goto L12;
        r2.post(new f0(this, r0));
        return;
    L12:
        return;
    }

    @Override // com.obric.assistant.settings.spi.b
    public final void kW() {
        FLogger.a.d("ObricSettingFragment", "refreshSettings");
        ((ObricSettingViewModel) this.g.getValue()).refreshSettings(this);
    }

    public final void onDestroy() {
        if (this.h == false) goto L8;
        IBluetoothHeadSetAPI r0 = tha.c.a();
        if (r0 == null) goto L7;
        r0.c(this.i);
    L7:
        this.h = false;
    L8:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onDestroyView() {
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        this.f = null;
    }

    public final void onStop() {
        if (this.h == false) goto L8;
        IBluetoothHeadSetAPI r0 = tha.c.a();
        if (r0 == null) goto L7;
        r0.c(this.i);
    L7:
        this.h = false;
    L8:
        super/*androidx.fragment.app.Fragment*/.onStop();
    }

    public ObricSettingFragment() {
        final Function0<Fragment> r0 = new ObricSettingFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricSettingViewModel.class), new ObricSettingFragment$special$$inlined$viewModels$default$2(r0), new ObricSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = UUID.randomUUID();
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (t9a.b.a().b() == true) goto L5;
        return null;
    L5:
        ObricFragmentSettingBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.c;
    }

    @Override // com.obric.assistant.settings.spi.b
    public final Context getHostContext() {
        return getContext();
    }

    public final void onResume() {
        super.onResume();
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        FLogger.a.d("ObricSettingFragment", "onResume, refresh settings immediately and again after 500ms");
        kW();
        this.j = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
    }

    public final void V90(final List<j> r3) {
        if (r3.isEmpty() == false) goto L6;
        return;
    L6:
        if (this.l == false) goto L13;
        this.l = false;
        ObricFragmentSettingBinding r0 = this.e;
        if (r0 == null) goto L15;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L16;
        r1.post(new e0(this, r3));
        return;
    L16:
        return;
    L15:
        return;
    L13:
        W90();
    }

    public final void Y90(Bundle r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        this.l = r0;
        if (r4 == null) goto L10;
        String r5 = r4.getString("extra_highlight_item_id");
    L11:
        this.m = r5;
        if (getView() == null) goto L22;
        W90();
        if (this.l == false) goto L23;
        ObricSettingAdapter r6 = this.f;
        if (r6 == null) goto L19;
        List<j> r7 = r6.getCurrentList();
        if (r7 == null) goto L19;
    L20:
        V90(r7);
        return;
    L19:
        r7 = CollectionsKt.emptyList();
        goto L20
    L23:
        return;
    L22:
        return;
    L10:
        r5 = null;
        goto L11
    L5:
        if (r4.getBoolean("extra_scroll_to_bottom", false) != true) goto L7;
        r0 = true;
        goto L7
    }

    public static View U90(View r4, String r5) {
        if (Intrinsics.areEqual(r5, r4.getTag()) == false) goto L6;
        return r4;
    L6:
        if ((r4 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        View r3 = r6.getChildAt(r2);
        Intrinsics.checkNotNull(r3);
        View r7 = U90(r3, r5);
        if (r7 != null) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r7;
    L14:
        return null;
    }

    public final void X90(final String r3, final int r4) {
        ObricFragmentSettingBinding r0 = this.e;
        if (r0 == null) goto L15;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L16;
        View r2 = U90(r1, r3);
        if (r2 == null) goto L11;
        this.m = null;
        p0.d(r2);
        return;
    L11:
        if (r4 > 0) goto L13;
        return;
    L13:
        r1.postDelayed(new j0(this, r3, r4), 50);
        return;
    L16:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.settings.d0] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Y90(getArguments());
        ObricFragmentSettingBinding r12 = this.e;
        if (r12 != null) goto L5;
    L9:
        ObricFragmentSettingBinding r13 = this.e;
        if (r13 == null) goto L12;
        this.f = new ObricSettingAdapter(getActivity());
        RecyclerView r14 = r13.b;
        r14.setLayoutManager(new LinearLayoutManager(r14.getContext()));
        r14.setAdapter(this.f);
        r14.setItemAnimator(null);
    L12:
        ((ObricSettingViewModel) this.g.getValue()).getSettingItems().observe(getViewLifecycleOwner(), new b(new d0(this)));
        return;
    L5:
        if (t9a.b.a().b() == true) goto L7;
        int r0 = rda.a.a;
        NovaTitleBarEx r2 = rda.a.b(r12.c);
        NovaTitleBarEx.Y5(r2, getString(2131912414), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new g0(this), 14);
    L8:
        Unit r15 = Unit.INSTANCE;
        goto L9
    L7:
        OFloatingTitleBar r16 = r12.c;
        OFloatingTitleBar.k(r16, new h0(this), 2);
        r16.setCenterTitle(getString(2131912414));
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131564008, r3, false);
        int r6 = 2131384076;
        RecyclerView r7 = ViewBindings.findChildViewById(r5, 2131384076);
        if (r7 == null) goto L12;
        r6 = 2131389118;
        OFloatingTitleBar r0 = ViewBindings.findChildViewById(r5, 2131389118);
        if (r0 == null) goto L12;
        FrameLayout r8 = (FrameLayout) r5;
        this.e = new ObricFragmentSettingBinding(r8, r7, r0);
        if (r8 == null) goto L9;
        r8.setTag(2131377847, this);
        return r8;
    L9:
        return null;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}

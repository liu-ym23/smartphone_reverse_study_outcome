package com.obric.assistant.settings.experience;

import android.os.Bundle;
import android.os.Handler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.impl.databinding.ObricFragmentUserExperiencePlanBinding;
import com.obric.assistant.settings.p0;
import com.obric.assistant.settings.t;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0017\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b(J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J$\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0/H\u0002J \u00100\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002J \u00100\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J4\u0010=\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0/H\u0002J\u001a\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010>\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020!H\u0002J\b\u0010B\u001a\u00020!H\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u000eH\u0002J\f\u0010E\u001a\u00020\u0013*\u000204H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentUserExperiencePlanBinding;", "doubaoTitleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "switchListeners", "", "Lcom/obric/oui/oswitch/OSwitch;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "lastDisabledToastTime", "", "", "pendingHighlightItemId", "", "isObricOS", "", "autoLogEnterPage", "getCurrentPageName", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initTopBar", "updateNavigationRequest", "extras", "updateNavigationRequest$impl_mainlandRelease", "scheduleHighlightIfNeeded", "bindSwitches", "bindSwitchClick", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "update", "Lkotlin/Function1;", "bindItem", "titleRes", "subtitleRes", "subtitle", "", "buildPlanSummary", "updateAll", "enabled", "updateVoice", "updateModel", "render", "state", "Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$State;", "renderChildSwitch", "checked", "updateSwitch", "switch", "showNetworkError", "showEnableMasterFirst", "performDisabledFeedbackAndToast", "itemId", "hasClickableSpan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUserExperiencePlanFragment extends TraceFragment implements t {
    public static final /* synthetic */ int j = 0;
    public ObricFragmentUserExperiencePlanBinding e;
    public final Map<OSwitch, CompoundButton.OnCheckedChangeListener> f;
    public final Map<Integer, Long> g;
    public String h;
    public final boolean i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onResume$1", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricUserExperiencePlanFragment this$0;

        public AnonymousClass1(ObricUserExperiencePlanFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ObricUserExperiencePlanFragment r2 = (ObricUserExperiencePlanFragment) this.L$0;
            ResultKt.throwOnFailure(r4);
        L12:
            int r3 = ObricUserExperiencePlanFragment.j;
            r2.X90((ObricUserExperiencePlanManager.a) r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricUserExperiencePlanFragment r5 = this.this$0;
            ObricUserExperiencePlanManager r6 = ObricUserExperiencePlanManager.a;
            this.L$0 = r5;
            this.label = 1;
            Object r7 = r6.f(this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r5;
            r4 = r7;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricUserExperiencePlanFragment this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ObricUserExperiencePlanFragment this$0;

            /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1$a */
            public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
                public final /* synthetic */ ObricUserExperiencePlanFragment a;

                public a(ObricUserExperiencePlanFragment r1) {
                    this.a = r1;
                }

                public final boolean equals(Object r3) {
                    if ((r3 instanceof FlowCollector) == true) goto L5;
                    return false;
                L5:
                    if ((r3 instanceof FunctionAdapter) == true) goto L7;
                    return false;
                L7:
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
                }

                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.a, ObricUserExperiencePlanFragment.class, "render", "render(Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$State;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                public final Object emit(Object r2, Continuation r3) {
                    ObricUserExperiencePlanFragment r0 = this.a;
                    Object r4 = AnonymousClass1.access$invokeSuspend$render(r0, (ObricUserExperiencePlanManager.a) r2, r3);
                    if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r4;
                L6:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(ObricUserExperiencePlanFragment r1, Continuation<? super AnonymousClass1> r2) {
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
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                StateFlowImpl r6 = ObricUserExperiencePlanManager.e;
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r6.collect(r3, this) != r0) goto L12;
                return r0;
            }

            public static final /* synthetic */ Object access$invokeSuspend$render(ObricUserExperiencePlanFragment r0, ObricUserExperiencePlanManager.a r1, Continuation r2) {
                int r3 = ObricUserExperiencePlanFragment.j;
                r0.X90(r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ObricUserExperiencePlanFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_user_experience_plan";
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.i == true) goto L5;
        return null;
    L5:
        ObricFragmentUserExperiencePlanBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.e;
    }

    public final void onDestroyView() {
        ((LinkedHashMap) this.f).clear();
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public ObricUserExperiencePlanFragment() {
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.i = t9a.b.a().b();
    }

    public final void onResume() {
        super.onResume();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void U90(ObricUserExperiencePlanFragment r2) {
        FragmentActivity r0 = r2.getActivity();
        if (r0 == null) goto L7;
        Handler r1 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r0, r2.getString(2131908080));
        return;
    }

    public final void X90(ObricUserExperiencePlanManager.a r6) {
        ObricFragmentUserExperiencePlanBinding r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        aa0(r0.c.getEndSwitch(), r6.b());
        Y90(r0.f, r6.a, r6.b(), new ObricUserExperiencePlanFragment$render$1(this));
        Y90(r0.d, r6.b, r6.b(), new ObricUserExperiencePlanFragment$render$2(this));
    }

    public final void Z90(Bundle r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getString("extra_highlight_item_id");
    L6:
        this.h = r4;
        if (getView() != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.h, "voice_wakeup_audio_upload") == false) goto L32;
        ObricFragmentUserExperiencePlanBinding r5 = this.e;
        if (r5 == null) goto L28;
        OCardListItem r6 = r5.f;
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.isLaidOut() == true) goto L18;
    L25:
        r6.addOnLayoutChangeListener(new f(this));
        return;
    L18:
        if (r6.isLayoutRequested() == true) goto L25;
        ObricFragmentUserExperiencePlanBinding r7 = this.e;
        if (r7 == null) goto L30;
        OCardListItem r8 = r7.f;
        if (r8 == null) goto L33;
        this.h = null;
        p0.d(r8);
        return;
    L33:
        return;
    L30:
        return;
    L28:
        return;
    L32:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void W90(OCardListItem r4, final Function1<? super Boolean, Unit> r5) {
        final OSwitch r6 = r4.getEndSwitch();
        if (r6 != null) goto L5;
        return;
    L5:
        final Ref.LongRef r0 = new Ref.LongRef();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        CompoundButton.OnCheckedChangeListener r2 = new b(r0, r6, r1, r5);
        r1.element = r2;
        this.f.put(r6, r2);
        r6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) r1.element);
    }

    public final void aa0(OSwitch r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isChecked() == r4) goto L9;
        CompoundButton.OnCheckedChangeListener r0 = (CompoundButton.OnCheckedChangeListener) ((LinkedHashMap) this.f).get(r3);
        r3.setOnCheckedChangeListener(null);
        r3.setCheckedNoAnim(r4);
        r3.setOnCheckedChangeListener(r0);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        ObricFragmentUserExperiencePlanBinding r12 = this.e;
        if (r12 == null) goto L11;
        OFloatingTitleBar r13 = r12.e;
        if (r13 == null) goto L11;
        if (this.i == false) goto L10;
        r13.setCenterTitle(2131912691);
        OFloatingTitleBar.k(r13, new c(this), 2);
        goto L11
    L10:
        NovaTitleBarEx r2 = rda.a.b(r13);
        NovaTitleBarEx.Y5(r2, getString(2131912691), null, null, 6);
        NovaTitleBarEx.b6(r2, 2131241477, false, null, null, new d(this), 14);
    L11:
        ObricFragmentUserExperiencePlanBinding r14 = this.e;
        if (r14 == null) goto L16;
        OSectionTitleBar r15 = r14.b;
        if (r15 == null) goto L16;
        r15.setTitleText(getString(2131912683));
        r15.setTitleTextSize(12.0f);
        r15.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104363));
        r15.a(false);
        r15.b(false);
    L16:
        ObricFragmentUserExperiencePlanBinding r16 = this.e;
        if (r16 == null) goto L19;
        V90(r16.c, 2131912686, com.obric.assistant.settings.experience.a.a(requireContext(), 2131912690, 2131104819));
        V90(r16.f, 2131912504, getString(2131912692));
        V90(r16.d, 2131912688, getString(2131912689));
        OCardListItem.h(r16.c, 0);
        OCardListItem.h(r16.f, 1);
        OCardListItem.h(r16.d, 3);
        W90(r16.c, new ObricUserExperiencePlanFragment$bindSwitches$1$1(this));
    L19:
        Z90(getArguments());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final void V90(OCardListItem r6, int r7, CharSequence r8) {
        r6.setCardType(0);
        r6.p(false);
        r6.setTitle(getString(r7));
        r6.s(true);
        r6.setSubTitle(r8);
        r6.q(true);
        r6.getSubTitleView().setMaxLines(6);
        r6.getSubTitleView().setHighlightColor(0);
        OTextView r1 = r6.getSubTitleView();
        MovementMethod r3 = null;
        if ((r8 instanceof Spanned) == false) goto L5;
        Spanned r2 = (Spanned) r8;
    L6:
        if (r2 == null) goto L16;
        ClickableSpan[] r9 = (ClickableSpan[]) r2.getSpans(0, r8.length(), ClickableSpan.class);
        if (r9 == null) goto L16;
        if (r9.length != 0) goto L12;
        boolean r10 = true;
    L14:
        if ((!r10) != true) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L19;
        r3 = LinkMovementMethod.getInstance();
    L19:
        r1.setMovementMethod(r3);
        r6.setDefaultCustomEndView(1);
        r6.m(true);
        r6.r(false);
        return;
    L12:
        r10 = false;
    L16:
        r11 = false;
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131564010, r9, false);
        int r12 = 2131373385;
        OSectionTitleBar r2 = ViewBindings.findChildViewById(r11, 2131373385);
        if (r2 == null) goto L15;
        r12 = 2131379676;
        OCardListItem r3 = ViewBindings.findChildViewById(r11, 2131379676);
        if (r3 == null) goto L15;
        r12 = 2131380249;
        OCardListItem r4 = ViewBindings.findChildViewById(r11, 2131380249);
        if (r4 == null) goto L15;
        r12 = 2131389118;
        OFloatingTitleBar r5 = ViewBindings.findChildViewById(r11, 2131389118);
        if (r5 == null) goto L15;
        r12 = 2131392766;
        OCardListItem r6 = ViewBindings.findChildViewById(r11, 2131392766);
        if (r6 == null) goto L15;
        ConstraintLayout r13 = r11;
        this.e = new ObricFragmentUserExperiencePlanBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public final void Y90(final OCardListItem r5, boolean r6, boolean r7, Function1<? super Boolean, Unit> r8) {
        OSwitch r1 = r5.findViewById(2131369124);
        if (r7 == false) goto L13;
        if (r1 == null) goto L6;
        r5.setDefaultCustomEndView(1);
        r5.m(true);
    L6:
        OSwitch r0 = r5.getEndSwitch();
        if (r0 != null) goto L9;
    L11:
        aa0(r0, r6);
    L24:
        if (r7 == false) goto L26;
        float r9 = 1.0f;
    L27:
        r5.getTitleView().setAlpha(r9);
        r5.getSubTitleView().setAlpha(r9);
        return;
    L26:
        r9 = 0.3f;
        goto L27
    L9:
        if (((LinkedHashMap) this.f).get(r0) != null) goto L11;
        W90(r5, r8);
        goto L11
    L13:
        if (r1 != null) goto L18;
        OSwitch r2 = r5.getEndSwitch();
        if (r2 == null) goto L17;
        r2.setOnCheckedChangeListener(null);
        CompoundButton.OnCheckedChangeListener r3 = this.f.remove(r2);
    L17:
        r5.setCustomEndView(2131561650);
        r5.m(true);
    L18:
        OSwitch r4 = r5.findViewById(2131369124);
        if (r4 == null) goto L21;
        r4.setOnCheckedChangeListener(null);
        r4.setChecked(r6);
        r4.setEnabled(false);
    L21:
        View r10 = r5.findViewById(2131369125);
        if (r10 == null) goto L24;
        r10.setOnClickListener(new e(this, r5));
        goto L24
    }
}

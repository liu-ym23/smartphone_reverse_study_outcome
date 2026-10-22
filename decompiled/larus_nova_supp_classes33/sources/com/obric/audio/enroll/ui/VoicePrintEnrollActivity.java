package com.obric.audio.enroll.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.t1;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.audio.enroll.VoiceEnrollServiceImpl;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import com.obric.audio.enroll.trace.VoiceEnrollTrace;
import com.obric.audio.enroll.ui.fragment.EnrollGuideFragment;
import com.obric.audio.enroll.ui.fragment.EnrollResultFragment;
import com.obric.audio.enroll.ui.fragment.EnrollingFragment;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaVoicePrintEnrollActivityBinding;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.dialog.v2.alert.g;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import mia.h;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u000e\u0010 \u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u0016H\u0014J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0014J\b\u0010&\u001a\u00020\u0016H\u0014J\b\u0010'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0014J\b\u0010)\u001a\u00020\u0016H\u0014J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000fH\u0002J\u0006\u0010,\u001a\u00020\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lcom/obric/audio/enroll/ui/VoicePrintEnrollActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/audio/impl/databinding/SvaVoicePrintEnrollActivityBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "getViewModel", "()Lcom/obric/audio/enroll/vm/EnrollViewModel;", "setViewModel", "(Lcom/obric/audio/enroll/vm/EnrollViewModel;)V", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "earlyExit", "", "helpImproveVoiceWakeupRefresh", "Lkotlinx/coroutines/Deferred;", "needAcquireAudioFocus", "getNeedAcquireAudioFocus", "()Z", "keepScreenOn", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "deactiveAssistantIfAlive", "createEnrollHandle", WindowEvent.Params.REASON, "", "rebuildEnrollHandle", "activeAssistantIfAlive", "awaitHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDrawWhiteBoard", "onStop", "onBackPressed", "onUserLeaveHint", "onDestroy", "finish", "onResume", "onStart", "acquireAudioFocus", "acquire", "showQuitDialog", "adjustRootWidth", "isExpanded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoicePrintEnrollActivity extends AppCompatActivity {
    public static final /* synthetic */ int f = 0;
    public SvaVoicePrintEnrollActivityBinding a;
    public EnrollViewModel b;
    public AudioFocusRequest c;
    public boolean d;
    public Deferred<Boolean> e;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "DORA_BT", "THIRD_PARTY_BT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum EnrollDeviceType extends Enum<EnrollDeviceType> {
            public static final a Companion = null;
            public static final EnrollDeviceType DEFAULT = null;
            public static final EnrollDeviceType DORA_BT = null;
            public static final EnrollDeviceType THIRD_PARTY_BT = null;
            public static final /* synthetic */ EnrollDeviceType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a {
                public a() {
                }
            }

            public static EnumEntries<EnrollDeviceType> getEntries() {
                return b;
            }

            static {
                EnrollDeviceType r0 = new EnrollDeviceType("DEFAULT", 0, 0);
                DEFAULT = r0;
                EnrollDeviceType r1 = new EnrollDeviceType("DORA_BT", 1, 1);
                DORA_BT = r1;
                EnrollDeviceType r3 = new EnrollDeviceType("THIRD_PARTY_BT", 2, 2);
                THIRD_PARTY_BT = r3;
                EnrollDeviceType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new a();
            }

            public static EnrollDeviceType[] values() {
                return (EnrollDeviceType[]) a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static EnrollDeviceType valueOf(String r1) {
                return (EnrollDeviceType) r27.a.a(EnrollDeviceType.class, r1);
            }

            public EnrollDeviceType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.VoicePrintEnrollActivity$finish$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity$finish$1", f = "VoicePrintEnrollActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VoicePrintEnrollActivity this$0;

        public AnonymousClass1(VoicePrintEnrollActivity r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (this.this$0.C1().isEnrollSuccess() == false) goto L8;
            ObricEnrollInteropDelegate.b.l(this.this$0.C1().getLockVoiceprintSwitch(), this.this$0.C1().getCurrentSettingItems());
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onCreate$2", f = "VoicePrintEnrollActivity.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricEnrollInteropDelegate r5 = ObricEnrollInteropDelegate.b;
            this.label = 1;
            r4 = r5.q(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onCreate$3", f = "VoicePrintEnrollActivity.kt", i = {}, l = {ErrorCode.PRIVACY_STATEMENT_NOT_AGREE_ERROR}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WindowInfoTracker $windowInfoTracker;
        int label;
        final /* synthetic */ VoicePrintEnrollActivity this$0;

        /* JADX INFO: renamed from: com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onCreate$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ VoicePrintEnrollActivity a;

            public a(VoicePrintEnrollActivity r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                List r7 = ((WindowLayoutInfo) r5).getDisplayFeatures();
                boolean r0 = false;
                if ((r7 instanceof Collection) == true) goto L5;
            L7:
                Iterator<T> r8 = r7.iterator();
            L9:
                if (r8.hasNext() == false) goto L22;
                FoldingFeature r9 = (DisplayFeature) r8.next();
                if ((r9 instanceof FoldingFeature) == false) goto L19;
                FoldingFeature r10 = r9;
                if (Intrinsics.areEqual(r10.getOrientation(), FoldingFeature.Orientation.VERTICAL) == false) goto L19;
                if (Intrinsics.areEqual(r10.getState(), FoldingFeature.State.HALF_OPENED) == false) goto L17;
            L18:
                boolean r11 = true;
            L20:
                if (r11 == false) goto L9;
                r0 = true;
                goto L22
            L17:
                if (Intrinsics.areEqual(r10.getState(), FoldingFeature.State.FLAT) == true) goto L18;
            L19:
                r11 = false;
            L22:
                VoicePrintEnrollActivity r12 = this.a;
                if (r0 == false) goto L25;
                int r13 = VoicePrintEnrollActivity.f;
                Resources r1 = r12.getResources();
                int r14 = (int) (504 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
            L26:
                SvaVoicePrintEnrollActivityBinding r2 = r12.a;
                SvaVoicePrintEnrollActivityBinding r3 = null;
                if (r2 != null) goto L29;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r2 = null;
            L29:
                r2.b.getLayoutParams().width = r14;
                SvaVoicePrintEnrollActivityBinding r4 = r12.a;
                if (r4 != null) goto L32;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r4 = null;
            L32:
                r4.c.getLayoutParams().width = r14;
                SvaVoicePrintEnrollActivityBinding r15 = r12.a;
                if (r15 != null) goto L35;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L36:
                r3.b.requestLayout();
                WindowCompat.setDecorFitsSystemWindows(this.a.getWindow(), r0);
                return Unit.INSTANCE;
            L35:
                r3 = r15;
                goto L36
            L25:
                r14 = -1;
                goto L26
            L5:
                if (r7.isEmpty() == false) goto L7;
                goto L7
            }
        }

        public AnonymousClass3(WindowInfoTracker r1, VoicePrintEnrollActivity r2, Continuation<? super AnonymousClass3> r3) {
            this.$windowInfoTracker = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$windowInfoTracker, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            Flow r6 = this.$windowInfoTracker.windowLayoutInfo(this.this$0);
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.VoicePrintEnrollActivity$onDestroy$1", f = "VoicePrintEnrollActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VoicePrintEnrollActivity this$0;

        public C00861(VoicePrintEnrollActivity r1, Continuation<? super C00861> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00861(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r3);
            FLogger.a.i("VoicePrintEnrollActivity", "voiceWakeupSwitch = " + this.this$0.C1().getVoiceWakeupSwitch() + ", helpImproveVoiceWakeupSwitch = " + this.this$0.C1().getHelpImproveVoiceWakeupSwitch());
            if (this.this$0.C1().getVoiceWakeupSwitch() == true) goto L7;
        L9:
            t1 r4 = t1.a;
            r4.k();
            if (this.this$0.C1().getHelpImproveVoiceWakeupInitiallyEnabled() == false) goto L12;
        L16:
            r4.h(ObricEnrollInteropDelegate.b.t());
            if (Intrinsics.areEqual(this.this$0.C1().enterFrom(), EnrollViewModel.SET_UP_WIZARD) == true) goto L20;
            r4.X0();
        L20:
            return Unit.INSTANCE;
        L12:
            if (this.this$0.C1().getHelpImproveVoiceWakeupSwitch() == false) goto L16;
            if (this.this$0.C1().getHasClickFinishButton() == false) goto L16;
            ObricEnrollInteropDelegate.b.s();
            goto L16
        L7:
            if (this.this$0.C1().getHasClickFinishButton() == false) goto L9;
            ObricEnrollInteropDelegate.b.f(true);
            goto L9
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final EnrollViewModel C1() {
        EnrollViewModel r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F1() {
        boolean r0 = VoiceEnrollServiceDelegate.c.f();
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        g r2 = new g(this);
        r2.w = false;
        String r4 = getString(2131914219);
        r2.j = false;
        r2.h = r4;
        if (r0 == false) goto L5;
        String r3 = "";
    L6:
        r2.i = r3;
        g.c(r2);
        r2.e(getString(2131914194), new b(r1));
        r2.g(getString(2131914218), new c(r1), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r5 = r2.a();
        r5.setOnDismissListener(new d(r1, this));
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L5:
        r3 = getString(2131914212);
        goto L6
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VoicePrintEnrollActivity.class.getName()));
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C00861(this, null), 3, null);
        CoroutineScope r2 = VoiceEnrollTrace.a;
        String r4 = "off";
        if (C1().getVoiceWakeupSwitch() == true) goto L8;
    L10:
        String r3 = "off";
    L12:
        if (C1().getHelpImproveVoiceWakeupSwitch() == true) goto L14;
    L16:
        String r5 = "off";
    L17:
        String r7 = "yes";
        if (C1().isEnrollSuccess() == false) goto L20;
        String r6 = "yes";
    L21:
        String r9 = C1().enterFrom();
        Intrinsics.checkNotNullParameter(r3, "voiceWakeupSwitch");
        Intrinsics.checkNotNullParameter(r5, "audioCollectSwitch");
        Intrinsics.checkNotNullParameter(r6, "isSuccess");
        FLogger r13 = FLogger.a;
        r13.i("VoiceEnrollTrace", "trackEnrollResult, voiceWakeupSwitch = " + r3 + ", audioCollectSwitch = " + r5 + ", isSuccess = " + r6 + ", enterFrom = " + r9);
        if (VoiceEnrollTrace.c == true) goto L26;
        VoiceEnrollTrace.b("obric_record_voice_result", r3, r5, r6, r9);
    L26:
        if (C1().getVoiceWakeupSwitch() == true) goto L28;
    L30:
        String r8 = "off";
    L32:
        if (C1().getHelpImproveVoiceWakeupSwitch() == false) goto L37;
        if (C1().getHasClickFinishButton() == false) goto L37;
        r4 = "on";
    L37:
        if (C1().isEnrollSuccess() == true) goto L40;
        r7 = "no";
    L40:
        String r10 = C1().enterFrom();
        Intrinsics.checkNotNullParameter(r8, "voiceWakeupSwitch");
        Intrinsics.checkNotNullParameter(r4, "audioCollectSwitch");
        Intrinsics.checkNotNullParameter(r7, "isSuccess");
        if (VoiceEnrollTrace.c == false) goto L44;
        r13.i("VoiceEnrollTrace", "trackEnhancedEnrollResult, voiceWakeupSwitch = " + r8 + ", audioCollectSwitch = " + r4 + ", audioCollectSwitch = isSuccess = " + r7 + ", enterFrom = " + r10);
        VoiceEnrollTrace.b("obric_record_enhanced_voice_result", r8, r4, r7, r10);
    L44:
        r13.i("VoicePrintEnrollActivity", "onDestroy earlyExit=" + this.d);
        if (this.d == false) goto L47;
        super.onDestroy();
        return;
    L47:
        oia.a.c(false);
        ObricEnrollInteropDelegate r11 = ObricEnrollInteropDelegate.b;
        r11.w(false);
        r11.x(false);
        super.onDestroy();
        h.a = null;
        C1().release();
        r13.i("VoicePrintEnrollActivity", "release enroll handle deviceType=" + C1().getEnrollDeviceType());
        IEnrollService.a.getClass();
        IEnrollService r1 = IEnrollService.a.a();
        if (r1 == null) goto L50;
        r1.release();
    L50:
        ria.c.b = null;
        SoundPool r12 = ria.c.g;
        if (r12 == null) goto L53;
        r12.release();
    L53:
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content), null);
        return;
    L28:
        if (C1().getHasClickFinishButton() == false) goto L30;
        r8 = "on";
        goto L32
    L20:
        r6 = "no";
        goto L21
    L14:
        if (C1().getHasClickFinishButton() == false) goto L16;
        r5 = "on";
        goto L17
    L8:
        if (C1().getHasClickFinishButton() == false) goto L10;
        r3 = "on";
        goto L12
    }

    public final void onResume() {
        FLogger r0 = FLogger.a;
        r0.i("VoicePrintEnrollActivity", "onResume earlyExit=" + this.d);
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.d == false) goto L5;
        return;
    L5:
        C1().setLeaveFromPrivacy(false);
        oia.a.c(true);
        ObricEnrollInteropDelegate r4 = ObricEnrollInteropDelegate.b;
        r4.w(true);
        r4.x(true);
        Fragment r1 = getSupportFragmentManager().findFragmentById(2131373275);
        if ((r1 instanceof EnrollResultFragment) == false) goto L10;
        r0.i("VoicePrintEnrollActivity", "onResume keep result fragment state=" + C1().getEnrollState().getValue() + " isAlreadyEnroll=" + C1().isAlreadyEnroll());
        return;
    L10:
        if (C1().isRequestingRecordPermission() == false) goto L13;
        C1().setRequestingRecordPermission(false);
        return;
    L13:
        if (Intrinsics.areEqual(C1().getStartFrom(), EnrollViewModel.SET_UP_WIZARD) == true) goto L17;
        if (Intrinsics.areEqual(C1().getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == true) goto L17;
    L24:
        if (C1().isAlreadyEnroll() == false) goto L26;
        return;
    L26:
        if ((r1 instanceof EnrollGuideFragment) == true) goto L36;
        FragmentTransaction r2 = getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772654, 2130772653);
        EnrollGuideFragment r3 = new EnrollGuideFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L31;
        r2 = r2.replace(2131373275, r3);
    L31:
        r2.commit();
        CoroutineScope r5 = VoiceEnrollTrace.a;
        VoiceEnrollTrace.c(EnrollViewModel.GUIDE_PAGE, VoiceEnrollTrace.b, C1().enterFrom());
        VoiceEnrollTrace.b = EnrollViewModel.GUIDE_PAGE;
        return;
    L36:
        return;
    L17:
        if (C1().isAlreadyEnroll() == true) goto L24;
        FragmentTransaction r6 = getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772654, 2130772653);
        EnrollingFragment r7 = new EnrollingFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L22;
        r6 = r6.replace(2131373275, r7);
    L22:
        r6.commit();
    }

    public final void onStart() {
        FLogger.a.i("VoicePrintEnrollActivity", "onStart earlyExit=" + this.d);
        super.onStart();
        if (this.d == false) goto L5;
        return;
    L5:
        z1(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        FLogger.a.i("VoicePrintEnrollActivity", "onStop earlyExit=" + this.d);
        if (this.d == false) goto L5;
        super.onStop();
        z1(false);
    L13:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L19;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L19:
        return;
    L5:
        C1().stop();
        oia.a.c(false);
        ObricEnrollInteropDelegate r0 = ObricEnrollInteropDelegate.b;
        r0.w(false);
        r0.x(false);
        super.onStop();
        z1(false);
        if (Intrinsics.areEqual(C1().getStartFrom(), EnrollViewModel.SET_UP_WIZARD) == true) goto L10;
        if (Intrinsics.areEqual(C1().getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L13;
    L10:
        if (C1().isAlreadyEnroll() == true) goto L13;
        finish();
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onUserLeaveHint() {
        FLogger.a.i("VoicePrintEnrollActivity", "onUserLeaveHint earlyExit=" + this.d);
        if (this.d == false) goto L7;
        super/*android.app.Activity*/.onUserLeaveHint();
        return;
    L7:
        if (C1().getEnrollState().getValue() != EnrollState.ENROLLED_SUCCESS) goto L9;
    L13:
        super/*android.app.Activity*/.onUserLeaveHint();
        return;
    L9:
        if (C1().isLeaveFromPrivacy() == true) goto L13;
        if (C1().isRequestingRecordPermission() == true) goto L13;
        Toast.makeText(this, getString(2131914213), 0).show();
        goto L13
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0146 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        setResult(100, new Intent().putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("VoicePrintEnrollActivity", "VoicePrintEnrollActivity")})));
        if (this.d == true) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    L5:
        super.finish();
        overridePendingTransition(2130772653, 2130772655);
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VoicePrintEnrollActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L53;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public VoicePrintEnrollActivity() {
    }

    public final void onBackPressed() {
        F1();
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final Object A1(Continuation<? super Boolean> r5) {
        if ((r5 instanceof VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1) == false) goto L7;
        VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1 r0 = (VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        Boolean r7 = (Boolean) r6;
        if (r7 == null) goto L20;
        boolean r8 = r7.booleanValue();
    L21:
        C1().setHelpImproveVoiceWakeupInitiallyEnabled(r8);
        C1().setHelpImproveVoiceWakeupSwitch(r8);
        return Boxing.boxBoolean(r8);
    L20:
        r8 = ObricEnrollInteropDelegate.b.t();
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1 r9 = new VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$enabled$1(this, null);
        r0.label = 1;
        r6 = TimeoutKt.c(1500, r9, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new VoicePrintEnrollActivity$awaitHelpImproveVoiceWakeupEnabled$1(this, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(String r7) {
        Intrinsics.checkNotNullParameter(r7, WindowEvent.Params.REASON);
        Companion.EnrollDeviceType r0 = C1().getEnrollDeviceType();
        String r1 = C1().getEnrollDeviceSn();
        boolean r3 = true;
        if ((!StringsKt.isBlank(r1)) == true) goto L6;
        r1 = null;
    L6:
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("createEnrollHandle reason=");
        r4.append(r7);
        r4.append(" deviceType=");
        r4.append(r0);
        r4.append(" snLen=");
        if (r1 == null) goto L9;
        int r5 = r1.length();
    L10:
        r4.append(r5);
        r2.i("VoicePrintEnrollActivity", r4.toString());
        if (r0 != Companion.EnrollDeviceType.DEFAULT) goto L16;
        IEnrollService.a.getClass();
        IEnrollService r8 = IEnrollService.a.a();
        if (r8 == null) goto L24;
        r8.c(getApplicationContext());
        return;
    L24:
        return;
    L16:
        VoiceEnrollTrace.c = true;
        if (r0 == Companion.EnrollDeviceType.DORA_BT) goto L20;
        r3 = false;
    L20:
        IEnrollService.a.getClass();
        IEnrollService r9 = IEnrollService.a.a();
        if (r9 == null) goto L25;
        r9.b(getApplicationContext(), r1, r3);
        return;
    L25:
        return;
    L9:
        r5 = 0;
        goto L10
    }

    public final void D1(String r4) {
        Intrinsics.checkNotNullParameter(r4, WindowEvent.Params.REASON);
        FLogger.a.i("VoicePrintEnrollActivity", "rebuildEnrollHandle reason=".concat(r4));
        IEnrollService.a.getClass();
        IEnrollService r0 = IEnrollService.a.a();
        if (r0 == null) goto L5;
        r0.release();
    L5:
        B1(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r17) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        f.a(getTheme());
        FLogger.a.i("VoicePrintEnrollActivity", "onCreate");
        nia.a.a.i(getApplicationContext());
        boolean r0 = getIntent().getBooleanExtra("IS_DARK_MODE", false);
        AppCompatDelegate r2 = getDelegate();
        if (r0 == false) goto L14;
        int r6 = 2;
    L15:
        r2.setLocalNightMode(r6);
        overridePendingTransition(2130772654, 2130772653);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r17);
        ActionBar r3 = getSupportActionBar();
        if (r3 == null) goto L18;
        r3.hide();
    L18:
        int r4 = getIntent().getIntExtra("enroll_device_type", 0);
        Companion.EnrollDeviceType.Companion.getClass();
        Iterator r7 = Companion.EnrollDeviceType.getEntries().iterator();
    L20:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        if (((Companion.EnrollDeviceType) r8).getValue() != r4) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L20;
    L28:
        Companion.EnrollDeviceType r10 = (Companion.EnrollDeviceType) r8;
        if (r10 != null) goto L31;
        r10 = Companion.EnrollDeviceType.DEFAULT;
    L31:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content), new a());
        WindowCompat.getInsetsController(getWindow(), y1(getWindow())).setAppearanceLightStatusBars(!r0);
        VoiceEnrollTrace.b = null;
        VoiceEnrollTrace.c = false;
        ConstraintLayout r1 = getLayoutInflater().inflate(2131564917, null, false);
        ConstraintLayout r5 = r1;
        int r11 = 2131373275;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131373275);
        if (r12 == null) goto L97;
        r11 = 2131380633;
        View r13 = ViewBindings.findChildViewById(r1, 2131380633);
        if (r13 == null) goto L97;
        this.a = new SvaVoicePrintEnrollActivityBinding(r5, r12, r13);
        setContentView(r5);
        EnrollViewModel r14 = (EnrollViewModel) new ViewModelProvider(this).get(EnrollViewModel.class);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.b = r14;
        String r15 = getIntent().getStringExtra("device_sn");
        if (r15 == null) goto L38;
    L41:
        String r16 = getIntent().getStringExtra("device_name");
        if (r16 == null) goto L44;
    L47:
        boolean r18 = getIntent().hasExtra("blue_device_type");
        boolean r19 = getIntent().hasExtra("blue_product_id");
        int r110 = getIntent().getIntExtra("blue_device_type", 0);
        int r111 = getIntent().getIntExtra("blue_product_id", 0);
        Companion.EnrollDeviceType r112 = Companion.EnrollDeviceType.DEFAULT;
        if (r10 == r112) goto L57;
        if (r15 != null) goto L51;
    L54:
        boolean r113 = true;
    L55:
        if (r113 == false) goto L57;
        FLogger.a.i("VoicePrintEnrollActivity", "deviceSn is blank, fallback enrollDeviceType to DEFAULT type=" + r10);
        r10 = r112;
        goto L57
    L51:
        if (StringsKt.isBlank(r15) == true) goto L54;
        r113 = false;
    L57:
        if (r10 == r112) goto L61;
        SamiEnrollEngine.a.getClass();
        if (SamiEnrollEngine.s() == true) goto L61;
        FLogger.a.i("VoicePrintEnrollActivity", "bt headset enroll model not ready, trigger download and finish type=" + r10);
        SamiEnrollEngine.D("activity_model_not_ready");
        Toast.makeText(this, getString(2131914196), 0).show();
        this.d = true;
        finish();
        return;
    L61:
        if (r10 == r112) goto L82;
        if (r15 != null) goto L64;
    L67:
        boolean r20 = true;
    L68:
        if (r20 == true) goto L82;
        if (r18 == false) goto L82;
        if (r19 == false) goto L82;
        VoiceEnrollServiceImpl.k.getClass();
        Intrinsics.checkNotNullParameter(r15, "sn");
        VoiceEnrollServiceImpl.a r21 = new VoiceEnrollServiceImpl.a();
        Intrinsics.checkNotNullParameter(r15, "sn");
        if (StringsKt.isBlank(r15) == false) goto L74;
        FLogger.a.i("BluetoothDeviceStore", "updateDeviceBluetoothInfo ignore blank sn");
        goto L82
    L74:
        Object r22 = r21.a;
        monitor-enter(r22);
        JSONObject r114 = r21.e();     // Catch: Throwable -> L79
        JSONObject r115 = VoiceEnrollServiceImpl.a.b(r114, r15);     // Catch: Throwable -> L79
        r115.put("blue_device_type", r110);     // Catch: Throwable -> L79
        r115.put("blue_product_id", r111);     // Catch: Throwable -> L79
        FLogger.a.i("BluetoothDeviceStore", "updateDeviceBluetoothInfo sn=" + r15 + " blueDeviceType=" + r110 + " blueProductId=" + r111);     // Catch: Throwable -> L79
        r21.g(r114);     // Catch: Throwable -> L79
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L79
        monitor-exit(r22);
    L79:
        th = move-exception;
        throw th;
    L64:
        if (StringsKt.isBlank(r15) == true) goto L67;
        r20 = false;
    L82:
        C1().init(this, r10);
        C1().setEnrollDeviceInfo(r15, r16);
        B1("activity_onCreate");
        EnrollViewModel r24 = C1();
        String r25 = getIntent().getStringExtra("start_from");
        if (r25 != null) goto L85;
        r25 = "";
    L85:
        r24.setStartFrom(r25);
        C1().setLockVoiceprintSwitch(false);
        EnrollViewModel r26 = C1();
        ObricEnrollInteropDelegate r27 = ObricEnrollInteropDelegate.b;
        r26.setVoiceWakeupSwitch(r27.b());
        C1().setHelpImproveVoiceWakeupSwitch(r27.t());
        this.e = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
        EnrollViewModel r28 = C1();
        List<String> r29 = getIntent().getStringArrayListExtra(EnrollViewModel.CURRENT_SETTING_ITEMS);
        if (r29 != null) goto L88;
        r29 = CollectionsKt.emptyList();
    L88:
        r28.setCurrentSettingItems(r29);
        FLogger.a.i("VoicePrintEnrollActivity", "startFrom = " + C1().getStartFrom());
        Context r30 = h.a;
        Intrinsics.checkNotNullParameter(this, "ctx");
        h.a = this;
        getWindow().getAttributes().flags |= 128;
        SvaVoicePrintEnrollActivityBinding r31 = this.a;
        if (r31 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L91:
        r31.a.setBackgroundResource(2131106564);
        ria.c r32 = ria.c.a;
        Intrinsics.checkNotNullParameter(this, "context");
        ria.c.b = this;
        SoundPool r33 = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(16).setContentType(2).build()).build();
        ria.c.g = r33;
        if (r33 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("soundPool");
        r33 = null;
    L94:
        r33.setOnLoadCompleteListener(ria.c.h);
        ((LinkedHashMap) ria.c.f).clear();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(WindowInfoTracker.Companion.getOrCreate(this), this, null), 3, null);
        oia.a.c(true);
        r27.w(true);
        r27.x(true);
        return;
    L44:
        if (r10 == Companion.EnrollDeviceType.DEFAULT) goto L46;
        sia.b r34 = sia.b.a;
        Context r35 = getApplicationContext();
        r34.getClass();
        r16 = sia.b.a(r35);
        goto L47
    L46:
        r16 = null;
        goto L47
    L38:
        if (r10 == Companion.EnrollDeviceType.DEFAULT) goto L40;
        sia.b r36 = sia.b.a;
        Context r37 = getApplicationContext();
        r36.getClass();
        r15 = sia.b.c(r37);
        goto L41
    L40:
        r15 = null;
    L97:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r11)));
    L24:
        r9 = false;
        goto L25
    L27:
        r8 = null;
        goto L28
    L14:
        r6 = 1;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(boolean r8) {
        Object r0 = getSystemService("audio");
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        String r2 = t9a.b.a().d();
        FLogger r3 = FLogger.a;
        r3.i("VoicePrintEnrollActivity", "#platform name# is " + r2);
        boolean r4 = Intrinsics.areEqual(r2.toLowerCase(Locale.ROOT), "genesis-r") ^ true;
        r3.i("VoicePrintEnrollActivity", "needAcquireAudioFocus is " + r4);
        if (r4 == true) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L36;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        if (r8 == false) goto L19;
        AudioFocusRequest r6 = new AudioFocusRequest.Builder(4).setOnAudioFocusChangeListener(new e()).build();     // Catch: Throwable -> L25
        AudioFocusRequest r7 = this.c;     // Catch: Throwable -> L25
        if (r7 == null) goto L18;
        r1.abandonAudioFocusRequest(r7);     // Catch: Throwable -> L25
    L18:
        this.c = r6;     // Catch: Throwable -> L25
        Integer r9 = Integer.valueOf(r1.requestAudioFocus(r6));     // Catch: Throwable -> L25
    L23:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L25
    L28:
        if (Result.isSuccess-impl(r10) == false) goto L30;
        FLogger.a.i("VoicePrintEnrollActivity", "acquireAudioFocus success with acquire ? " + r8);
    L30:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L37;
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("acquireAudioFocus failed with acquire ? ");
        r13.append(r8);
        r13.append(" , tr ");
        r11.printStackTrace();
        r13.append(Unit.INSTANCE);
        r12.i("VoicePrintEnrollActivity", r13.toString());
        return;
    L37:
        return;
    L19:
        AudioFocusRequest r14 = this.c;     // Catch: Throwable -> L25
        if (r14 == null) goto L22;
        r1.abandonAudioFocusRequest(r14);     // Catch: Throwable -> L25
    L22:
        this.c = null;     // Catch: Throwable -> L25
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L36:
        return;
    L5:
        r1 = null;
        goto L6
    }
}

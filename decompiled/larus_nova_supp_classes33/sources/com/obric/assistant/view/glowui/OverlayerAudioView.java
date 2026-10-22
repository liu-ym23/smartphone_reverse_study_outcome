package com.obric.assistant.view.glowui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.bmhome.utils.b0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0001=\u0018\u0000 \u008b\u00012\u00020\u0001:\u0006\u008b\u0001\u008c\u0001\u008d\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\"\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0002J\u001a\u0010T\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)J\u001c\u0010V\u001a\u00020W2\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010)J\u0006\u0010X\u001a\u00020WJ\u001c\u0010Y\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0)H\u0002J\u0016\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*J\u001e\u0010]\u001a\u00020W2\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020`0_j\b\u0012\u0004\u0012\u00020``aJ\b\u0010b\u001a\u00020WH\u0014J\b\u0010c\u001a\u00020WH\u0014J\u0016\u0010d\u001a\u00020W2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007J\u0006\u0010g\u001a\u00020WJ\u0006\u0010h\u001a\u00020WJ\u000e\u0010i\u001a\u00020W2\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u00020W2\u0006\u0010m\u001a\u00020\u0007H\u0016J\b\u0010n\u001a\u00020WH\u0002J\b\u0010o\u001a\u00020WH\u0002J\u0010\u0010p\u001a\u00020W2\u0006\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020WH\u0002J\u0018\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020\u001bH\u0002J\u0010\u0010v\u001a\u00020\u001b2\u0006\u0010u\u001a\u00020\u001bH\u0002J\b\u0010w\u001a\u00020WH\u0002J\b\u0010x\u001a\u00020WH\u0002J\b\u0010y\u001a\u00020WH\u0002J\u0010\u0010z\u001a\u00020W2\b\b\u0002\u0010{\u001a\u00020\u001bJ\b\u0010|\u001a\u00020WH\u0002J\u001e\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020W0,H\u0002J\u001f\u0010\u0080\u0001\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020W0,H\u0002J\t\u0010\u0081\u0001\u001a\u00020WH\u0002J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0019\u0010\u0084\u0001\u001a\u00020W2\u0006\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020*H\u0002J&\u0010\u0085\u0001\u001a\u00020W2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0087\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u001b2\u0007\u0010\u0088\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u008a\u0001\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001a\u0010\u001cR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001e\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u001b\u0010?\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u001e\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u001e\u001a\u0004\bD\u0010AR\u001b\u0010F\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bG\u0010AR\u001b\u0010I\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u001e\u001a\u0004\bJ\u0010AR\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u001e\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u001e\u001a\u0004\bR\u0010O¨\u0006\u008e\u0001"}, d2 = {"Lcom/obric/assistant/view/glowui/OverlayerAudioView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "glowView", "Lcom/obric/assistant/view/glowui/GlowView;", "audioVisualizerView", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "getAudioVisualizerView", "()Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "tvTips", "Landroid/widget/TextView;", "root", "Landroid/view/ViewGroup;", "getRoot", "()Landroid/view/ViewGroup;", "sharedListeningView", "Lcom/obric/assistant/activation/presentation/ui/ObricListeningVisualView;", "legacyVisualSnapshot", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$LegacyVisualSnapshot;", "isWindow", "", "()Z", "isWindow$delegate", "Lkotlin/Lazy;", "isCameraActivity", "isCameraActivity$delegate", "isAiPress", "findActivity", "Landroid/app/Activity;", "gestureState", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$GestureState;", "blurInsideRect", "Landroid/graphics/Rect;", "lastTouchPosition", "Lkotlin/Pair;", "", "isChatClickSpeakingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setChatClickSpeakingCallback", "(Lkotlin/jvm/functions/Function0;)V", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "uiScope$delegate", "glowUpdateJob", "Lkotlinx/coroutines/Job;", "audioAnimationRequestId", "navigationBarBottom", "imeBottom", "bottomMenuHeight", "basePaddingBottom", "insetsAnimationCallback", "com/obric/assistant/view/glowui/OverlayerAudioView$insetsAnimationCallback$1", "Lcom/obric/assistant/view/glowui/OverlayerAudioView$insetsAnimationCallback$1;", "cancelBaseColor", "getCancelBaseColor", "()I", "cancelBaseColor$delegate", "cancelCoverColor", "getCancelCoverColor", "cancelCoverColor$delegate", "cancelTintColor", "getCancelTintColor", "cancelTintColor$delegate", "tipsDefaultColor", "getTipsDefaultColor", "tipsDefaultColor$delegate", "gradientDefaultColors", "", "getGradientDefaultColors", "()[I", "gradientDefaultColors$delegate", "gradientCancelColors", "getGradientCancelColors", "gradientCancelColors$delegate", "shouldCancel", "xy", "updateTouchPosition", "", "notifyPositionChanged", "refreshGestureState", "updateGestureState", "x", "y", "setAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onAttachedToWindow", "onDetachedFromWindow", "updateBottomMenuHeight", "curHeight", "normalHeight", "onAiKeyLongPress", "onAiKeyShortClick", "renderListening", "state", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "setVisibility", "visibility", "observeWindowInsets", "syncCurrentWindowInsets", "updateWindowInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "updateTranslationY", "updateWindowRootSafeBottomPadding", "isAttachedToWindowRoot", "isDecorViewPaddingHost", "allowGlowDrawIntoHostPadding", "startAudioAnimationWhenDisplayed", "cancelPendingAudioAnimation", "showAudioAnimation", "playWelcomeAnimation", "prepareAudioAnimation", "runAfterNextDraw", "requestId", "action", "runIfAudioAnimationValid", "stopAudioAnimation", "ensureGlowAnimationStarted", "applyGestureStyle", "showHighlightAtScreen", "updateTips", "toCancel", "visible", "isShortClick", "isClickTalk", "isIntercom", "Companion", "GestureState", "LegacyVisualSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverlayerAudioView extends FrameLayout {
    public static final float[] B = null;
    public final Lazy A;
    public final GlowView a;
    public final AudioContinueGradientView b;
    public final TextView c;
    public final ViewGroup d;
    public final ObricListeningVisualView e;
    public b f;
    public final Lazy g;
    public final Lazy h;
    public boolean i;
    public GestureState j;
    public final Rect k;
    public Pair<Float, Float> l;
    public Function0<Boolean> m;
    public final Lazy n;
    public Job o;
    public int p;
    public int q;
    public int r;
    public int s;
    public final int t;
    public final OverlayerAudioView$insetsAnimationCallback$1 u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/glowui/OverlayerAudioView$GestureState;", "", "<init>", "(Ljava/lang/String;I)V", "INSIDE", "OUTSIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GestureState extends Enum<GestureState> {
        public static final GestureState INSIDE = null;
        public static final GestureState OUTSIDE = null;
        public static final /* synthetic */ GestureState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<GestureState> getEntries() {
            return b;
        }

        static {
            GestureState r0 = new GestureState("INSIDE", 0);
            INSIDE = r0;
            GestureState r1 = new GestureState("OUTSIDE", 1);
            OUTSIDE = r1;
            GestureState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static GestureState[] values() {
            return (GestureState[]) a.clone();
        }

        public static GestureState valueOf(String r1) {
            return (GestureState) r27.a.a(GestureState.class, r1);
        }

        public GestureState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "LegacyVisualSnapshot(glowVisibility=" + this.a + ", audioVisualizerVisibility=" + this.b + ", tipsVisibility=" + this.c + ')';
        }

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureState.values().length];
            r0[GestureState.INSIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GestureState.OUTSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.glowui.OverlayerAudioView$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.glowui.OverlayerAudioView$setAudioData$1", f = "OverlayerAudioView.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Double> $sampleData;
        int label;
        final /* synthetic */ OverlayerAudioView this$0;

        public AnonymousClass1(OverlayerAudioView r1, ArrayList<Double> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$sampleData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$sampleData, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            OverlayerAudioView r7 = this.this$0;
            float[] r3 = OverlayerAudioView.B;
            r7.b();
            GlowView r8 = this.this$0.a;
            ArrayList<Double> r4 = this.$sampleData;
            this.label = 1;
            if (r8.d.d != 0) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == false) goto L14;
        L17:
            if (r2 == true) goto L19;
            Object r9 = Unit.INSTANCE;
        L23:
            if (r9 != r0) goto L26;
            return r0;
        L19:
            r9 = r8.c.update(r4, this);
            if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
            r9 = Unit.INSTANCE;
            goto L23
        L14:
            if (r8.e == true) goto L17;
            r2 = false;
            goto L17
        L11:
            r5 = false;
            goto L12
        }
    }

    public OverlayerAudioView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OverlayerAudioView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewCompat.setWindowInsetsAnimationCallback(this, null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        super.onDetachedFromWindow();
        this.p++;
        Job r1 = this.o;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.o = null;
    }

    static {
        B = new float[]{0.0f, 0.167f, 0.833f, 1.0f};
    }

    private final int getCancelBaseColor() {
        return ((Number) this.v.getValue()).intValue();
    }

    private final int getCancelCoverColor() {
        return ((Number) this.w.getValue()).intValue();
    }

    private final int getCancelTintColor() {
        return ((Number) this.x.getValue()).intValue();
    }

    private final int[] getGradientCancelColors() {
        return (int[]) this.A.getValue();
    }

    private final int[] getGradientDefaultColors() {
        return (int[]) this.z.getValue();
    }

    private final int getTipsDefaultColor() {
        return ((Number) this.y.getValue()).intValue();
    }

    private final CoroutineScope getUiScope() {
        return (CoroutineScope) this.n.getValue();
    }

    public final void a() {
        GestureState r0 = this.j;
        int r1 = c.a[r0.ordinal()];
        float[] r2 = B;
        if (r1 != 1) goto L5;
        this.a.setEffectShow(true);
        this.a.setBaseColor(ContextCompat.getColor(getContext(), 2131105539));
        this.a.setCoverColor(-6562561);
        this.b.c(getGradientDefaultColors(), r2);
        return;
    L5:
        if (r1 != 2) goto L8;
        this.a.setEffectShow(false);
        this.a.setBaseColor(getCancelBaseColor());
        this.a.setCoverColor(getCancelCoverColor());
        this.a.a();
        this.b.c(getGradientCancelColors(), r2);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void b() {
        final GlowView r0 = this.a;
        boolean r2 = false;
        if (r0.d.d != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L9:
        r2 = true;
    L11:
        if (r2 == false) goto L13;
    L22:
        FLogger.a.i("GlowView", "startWaveAnim already anim");
        r0.e();
        return;
    L13:
        if (r0.e == true) goto L22;
        FLogger.a.i("GlowView", "startWaveAnim start anim");
        if (r0.getWidth() != 0) goto L18;
    L21:
        r0.e = true;
        return;
    L18:
        if (r0.getHeight() == 0) goto L21;
        r0.d.a(new d(r0));
        r0.postInvalidateOnAnimation();
        return;
    L8:
        if (r0.e == false) goto L11;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean c() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final void d() {
        if (this.l != null) goto L5;
        return;
    L5:
        if (isShown() == false) goto L10;
        post(new h(this));
        return;
    }

    public final void j() {
        float r0 = getTranslationY();
        boolean r3 = true;
        if (getParent() != getRootView()) goto L5;
        boolean r1 = true;
    L7:
        if (c() == true) goto L12;
        if (r1 == false) goto L12;
        if (getRootView().getPaddingBottom() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        setClipChildren(false);
        setClipToPadding(false);
        this.d.setClipChildren(false);
        this.d.setClipToPadding(false);
    L15:
        if (r2 == true) goto L17;
    L19:
        boolean r5 = false;
    L21:
        if (c() == true) goto L27;
        if (r1 == false) goto L27;
        if (((Boolean) this.h.getValue()).booleanValue() == true) goto L27;
        if (r5 == true) goto L27;
        int r6 = this.q;
    L28:
        int r7 = this.t + r6;
        GlowView r8 = this.a;
        float r9 = 0.0f;
        if (r2 == false) goto L31;
        float r10 = r6;
    L32:
        r8.setTranslationY(r10);
        if (getPaddingBottom() == r7) goto L37;
        setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), r7);
    L37:
        if (c() == false) goto L39;
    L41:
        float r11 = 0.0f;
    L43:
        if (c() == false) goto L60;
        int r12 = this.s;
        if (r12 <= 0) goto L47;
        float r13 = (-r12) - this.q;
    L52:
        if (r13 <= 0.0f) goto L54;
    L57:
        if (r3 == false) goto L59;
        r9 = -this.q;
    L59:
        this.b.setTranslationY(r9);
        this.c.setTranslationY(r9);
        setTranslationY(r13);
    L79:
        FLogger.a.i("OverlayerAudioView", "updateTranslationY: isWindowContext=" + c() + ", navigationBarBottom=" + this.q + ", imeBottom=" + this.r + ", bottomMenuHeight=" + this.s + ", isAttachedToWindowRoot=" + r1 + ", isCameraActivity=" + ((Boolean) this.h.getValue()).booleanValue() + ", isDecorViewPaddingHost=" + r2 + ", cameraOverlayOffset=" + r11 + ", paddingBottom=" + getPaddingBottom() + ", currentTranslationY=" + r0 + ", targetTranslationY=" + r13);
        if (b0.a(r0, r13 - r11) == true) goto L83;
        d();
        return;
    L83:
        return;
    L54:
        if (b0.a(r13, 0.0f) == true) goto L57;
        r3 = false;
        goto L57
    L47:
        int r14 = this.r;
        if (r14 <= 0) goto L50;
        r13 = -r14;
        goto L52
    L50:
        r13 = 0.0f;
        goto L52
    L60:
        int r15 = this.s;
        if (r15 <= 0) goto L63;
        r13 = -r15;
    L70:
        if (r13 <= 0.0f) goto L72;
    L75:
        if (r3 == false) goto L78;
        if (r2 == true) goto L78;
        r9 = -r13;
    L78:
        this.b.setTranslationY(r9);
        this.c.setTranslationY(r9);
        setTranslationY(r13 - r11);
        goto L79
    L72:
        if (b0.a(r13, 0.0f) == true) goto L75;
        r3 = false;
        goto L75
    L63:
        int r16 = this.r;
        if (r16 <= 0) goto L68;
        if (r1 == false) goto L67;
        r13 = this.q - r16;
        goto L70
    L67:
        r13 = 0.0f;
        goto L70
    L68:
        r13 = this.q;
        goto L70
    L39:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L41;
        r11 = this.q;
        goto L43
    L31:
        r10 = 0.0f;
    L27:
        r6 = 0;
        goto L28
    L17:
        if (this.r <= this.q) goto L19;
        r5 = true;
    L12:
        r2 = false;
        goto L13
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, new l(this));
        ViewCompat.setWindowInsetsAnimationCallback(this, this.u);
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this);
        if (r0 == null) goto L5;
        k(r0);
    L5:
        j();
        ViewCompat.requestApplyInsets(this);
    }

    public final AudioContinueGradientView getAudioVisualizerView() {
        return this.b;
    }

    public final ViewGroup getRoot() {
        return this.d;
    }

    public final boolean e(Pair<Float, Float> r8) {
        ((Number) r8.getFirst()).floatValue();
        float r0 = ((Number) r8.getSecond()).floatValue();
        this.d.getGlobalVisibleRect(this.k);
        if (r0 < (this.k.bottom - c7.a(2131166561))) goto L5;
        GestureState r1 = GestureState.INSIDE;
    L7:
        if (r1 == this.j) goto L10;
        this.j = r1;
        a();
    L10:
        if (r1 != GestureState.OUTSIDE) goto L12;
        boolean r2 = true;
    L14:
        if (this.j != GestureState.INSIDE) goto L17;
        float r3 = ((Number) r8.getFirst()).floatValue();
        float r9 = ((Number) r8.getSecond()).floatValue();
        int[] r4 = new int[2];
        this.a.getLocationOnScreen(r4);
        this.a.d(r3 - r4[0], r9 - r4[1]);
        this.a.invalidate();
    L17:
        if (this.i == true) goto L19;
        i(r2, false);
    L19:
        return r2;
    L12:
        r2 = false;
        goto L14
    L5:
        r1 = GestureState.OUTSIDE;
        goto L7
    }

    public final void f(ObricListeningViewState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (r5.b() == true) goto L10;
        this.e.e(ObricListeningViewState.d);
        b r6 = this.f;
        if (r6 != null) goto L7;
        return;
    L7:
        this.f = null;
        this.a.setVisibility(r6.a);
        this.b.setVisibility(r6.b);
        this.c.setVisibility(r6.c);
        return;
    L10:
        if (this.f != null) goto L12;
        this.f = new b(this.a.getVisibility(), this.b.getVisibility(), this.c.getVisibility());
    L12:
        this.e.e(r5);
        this.a.setVisibility(4);
        this.b.setVisibility(4);
        this.c.setVisibility(4);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.assistant.view.glowui.j] */
    public final void h(final boolean r3) {
        if (this.f == null) goto L5;
        return;
    L5:
        final int r0 = this.p + 1;
        this.p = r0;
        b();
        final ?? r1 = new j(this, r3);
        if (isShown() == true) goto L8;
    L12:
        OneShotPreDrawListener.add(this, new u(this, this, r0, r1));
        return;
    L8:
        if (getWidth() <= 0) goto L12;
        if (getHeight() <= 0) goto L12;
        postOnAnimation(new k(this, r0, r1));
    }

    public final void k(WindowInsetsCompat r2) {
        this.q = r2.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        this.r = r2.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        j();
    }

    public final void setAudioData(ArrayList<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "sampleData");
        if (this.f == null) goto L5;
        return;
    L5:
        this.b.setAudioData(r10);
        Job r0 = this.o;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.o = BuildersKt.launch$default(getUiScope(), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, r10, null), 2, null);
    }

    public final void setChatClickSpeakingCallback(Function0<Boolean> r1) {
        this.m = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r4) {
        int r0 = getVisibility();
        super.setVisibility(r4);
        if (r4 == 0) goto L5;
        this.l = null;
        this.i = false;
        int r2 = this.p + 1;
        this.p = r2;
        if (r0 != 0) goto L23;
        this.p = r2 + 1;
        Job r1 = this.o;
        if (r1 == null) goto L20;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L20:
        this.o = null;
        this.a.f();
        this.b.a();
        return;
    L23:
        return;
    L5:
        if (this.f == null) goto L8;
        this.a.setVisibility(4);
        this.b.setVisibility(4);
        this.c.setVisibility(4);
        return;
    L8:
        this.j = GestureState.INSIDE;
        a();
        if (r0 == 0) goto L14;
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(this);
        if (r5 == null) goto L13;
        k(r5);
    L13:
        j();
        ViewCompat.requestApplyInsets(this);
        this.p++;
        this.b.a();
        b();
    L14:
        i(false, false);
    }

    public final void g(int r2, Function0<Unit> r3) {
        if (r2 == this.p) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (getWidth() > 0) goto L9;
        return;
    L9:
        if (getHeight() <= 0) goto L15;
        b();
        r3.invoke();
        return;
    }

    public final void i(boolean r7, boolean r8) {
        if (this.f == null) goto L6;
        this.c.setVisibility(4);
        return;
    L6:
        boolean r1 = false;
        this.c.setVisibility(0);
        TextView r0 = this.c;
        ObricInteractDelegate r2 = ObricInteractDelegate.b;
        Boolean r3 = r2.isAiKeyLongPress();
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        String r9 = getContext().getString(2131912177);
    L33:
        r0.setText(r9);
        TextView r10 = this.c;
        if (r7 == true) goto L36;
    L39:
        int r11 = getTipsDefaultColor();
    L40:
        r10.setTextColor(r11);
        return;
    L36:
        if (Intrinsics.areEqual(r2.isAiKeyShortPress(), r4) == true) goto L39;
        r11 = getCancelTintColor();
        goto L40
    L16:
        if (Intrinsics.areEqual(r2.isAiKeyPressing(), r4) == true) goto L25;
        if (r8 == true) goto L25;
        Function0<Boolean> r12 = this.m;
        if (r12 != null) goto L21;
    L23:
        boolean r13 = false;
    L24:
        if (r13 == true) goto L25;
    L26:
        if (r1 == false) goto L28;
        r9 = getContext().getString(2131912030);
        goto L33
    L28:
        Context r14 = getContext();
        if (r7 == false) goto L31;
        int r6 = 2131908758;
    L32:
        r9 = r14.getString(r6);
        goto L33
    L31:
        r6 = 2131906286;
        goto L32
    L21:
        if (((Boolean) r12.invoke()).booleanValue() != true) goto L23;
        r13 = true;
    L25:
        r1 = true;
        goto L26
    L9:
        if (this.i == true) goto L12;
        r5 = false;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [com.obric.assistant.view.glowui.OverlayerAudioView$insetsAnimationCallback$1] */
    public OverlayerAudioView(final Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.g = LazyKt.lazy(new m(r4));
        this.h = LazyKt.lazy(new n(this, r4));
        this.j = GestureState.INSIDE;
        this.k = new Rect();
        this.n = LazyKt.lazy(new o(this));
        this.t = getPaddingBottom();
        this.u = new OverlayerAudioView$insetsAnimationCallback$1(this);
        this.v = LazyKt.lazy(new p(r4));
        this.w = LazyKt.lazy(new q(r4));
        this.x = LazyKt.lazy(new r(r4));
        this.y = LazyKt.lazy(new s(r4));
        this.z = LazyKt.lazy(new t(r4));
        this.A = LazyKt.lazy(new i(r4));
        FrameLayout.inflate(r4, 2131564048, this);
        this.a = (GlowView) findViewById(2131373830);
        this.c = (TextView) findViewById(2131391601);
        ViewGroup r7 = (ViewGroup) findViewById(2131381768);
        this.d = r7;
        AudioContinueGradientView r8 = (AudioContinueGradientView) findViewById(2131363514);
        this.b = r8;
        FrameLayout r0 = r8.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        r1.width = j19.c.c(210);
        r1.height = j19.c.c(24);
        r0.setLayoutParams(r1);
        r8.b.setBarCount(36);
        r8.b.setBarGapDp(3.6f);
        r8.b.setBarWidthDp(2.4f);
        r8.b.setMinBarHeightDp(7.0f);
        ObricListeningVisualView r9 = new ObricListeningVisualView(r4, false);
        this.e = r9;
        r7.addView(r9, new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r4), 81));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public /* synthetic */ OverlayerAudioView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

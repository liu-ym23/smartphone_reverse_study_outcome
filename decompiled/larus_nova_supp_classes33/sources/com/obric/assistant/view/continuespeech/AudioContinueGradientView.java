package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J \u0010-\u001a\u00020\u00142\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3H\u0016J&\u00104\u001a\u00020\u00142\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0014H\u0014J\u000e\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020%J\u0010\u00109\u001a\u00020\u00142\b\b\u0002\u0010:\u001a\u00020%J\"\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0010\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010AJ\u000e\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020\u0014J\u0006\u0010E\u001a\u00020\u0014J\u0016\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\f\u0010K\u001a\u00020H*\u00020HH\u0002J\b\u0010L\u001a\u00020\u0014H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "Landroid/widget/FrameLayout;", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "voiceBarFrame", "audioSpectrumView", "Lcom/obric/assistant/view/continuespeech/AudioSpectrumView;", "voiceGradientView", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "animDelegate", "Lcom/obric/assistant/view/continuespeech/AudioContinueAnimDelegate;", "value", "Lkotlin/Function0;", "", "timeOutCallback", "getTimeOutCallback", "()Lkotlin/jvm/functions/Function0;", "setTimeOutCallback", "(Lkotlin/jvm/functions/Function0;)V", "mode", "getMode", "()I", "setMode", "(I)V", "density", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "isRecognizing", "", "lastAmplitude", "", "Ljava/lang/Float;", "audioUpdateJob", "Lkotlinx/coroutines/Job;", "isWindowMode", "createVoiceGradientView", "setAudioData", "data", "", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setAudioDataInner", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDetachedFromWindow", "setRecognizing", "recognizing", "showVoiceView", "forceWelcome", "onRealtimeCallLifeStateUpdate", "state", "Lcom/obric/assistant/view/continuespeech/RealtimeCallLifeState;", "onAnimationEnd", "addInputGradientView", "inputGradientView", "Landroid/view/View;", "setUseShimmerThinkingAnimation", "useShimmer", "onChatWindowShow", "adaptWindowStyle", "setVoiceGradientPureColor", "colors", "", "positions", "", "toOpaqueColors", "resetUi", "optAmplitude", "before", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioContinueGradientView extends FrameLayout implements iga.a {
    public final FrameLayout a;
    public final AudioSpectrumView b;
    public final AudioGradientView c;
    public final u d;
    public Function0<Unit> e;
    public int f;
    public final int g;
    public boolean h;
    public Float i;
    public Job j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$1", f = "AudioContinueGradientView.kt", i = {}, l = {108, 109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        int label;
        final /* synthetic */ AudioContinueGradientView this$0;

        public AnonymousClass1(byte[] r1, AudioContinueGradientView r2, Continuation<? super AnonymousClass1> r3) {
            this.$data = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$data, this.this$0, r4);
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
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L13:
            AudioContinueGradientView r2 = this.this$0;
            this.label = 2;
            if (AudioContinueGradientView.b(r2, (ArrayList) r5, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            int r6 = com.larus.common_ui.widget.input.a.a;
            byte[] r7 = this.$data;
            int r3 = this.this$0.g;
            this.label = 1;
            r5 = com.larus.common_ui.widget.input.a.a(r7, r3, this);
            if (r5 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$2", f = "AudioContinueGradientView.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Double> $sampleData;
        int label;
        final /* synthetic */ AudioContinueGradientView this$0;

        public AnonymousClass2(AudioContinueGradientView r1, ArrayList<Double> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$sampleData = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$sampleData, r4);
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
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            AudioContinueGradientView r5 = this.this$0;
            ArrayList<Double> r2 = this.$sampleData;
            this.label = 1;
            if (AudioContinueGradientView.b(r5, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public AudioContinueGradientView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AudioContinueGradientView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // iga.a
    public final void a() {
        this.h = false;
        AudioShimmerGradientView r1 = null;
        this.i = null;
        u r2 = this.d;
        r2.c.setAlpha(1.0f);
        AudioSpectrumView r3 = r2.b;
        r3.setSpeakIntensity(0.0f);
        r3.setPauseIntensity(0.0f);
        r3.setPauseProgress(0.0f);
        r3.setPauseSlope(0.15f);
        r3.setWaveIntensity(0.0f);
        r3.setWavePlayProgress(0.0f);
        r2.q = null;
        r2.o = true;
        r2.t.clear();
        Animator r4 = r2.s;
        if (r4 == null) goto L5;
        r4.cancel();
    L5:
        AudioGradientView r5 = r2.c;
        if ((r5 instanceof AudioShimmerGradientView) == false) goto L8;
        r1 = (AudioShimmerGradientView) r5;
    L8:
        if (r1 == null) goto L10;
        r1.d();
    L10:
        r2.c.setAnimating(false);
        r2.c.setAlpha(1.0f);
        r2.c.setGrayRatio(0.0f);
        r2.c.setVisibility(0);
    }

    public final void setUseShimmerThinkingAnimation(boolean r1) {
    }

    private final CoroutineScope getLifecycleScope() {
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this);
        if (r0 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r0 = this.j;
        AudioShimmerGradientView r2 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.j = null;
        this.h = false;
        this.i = null;
        u r3 = this.d;
        Iterator r4 = r3.t.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        u.b(((com.obric.assistant.view.continuespeech.a) r4.next()).a);
        goto L7
    L9:
        r3.t.clear();
        Animator r5 = r3.s;
        if (r5 == null) goto L12;
        r3.s = null;
        r3.r = null;
        u.b(r5);
    L12:
        r3.v.clear();
        r3.w = 0;
        r3.q = null;
        r3.o = true;
        AudioGradientView r1 = r3.a;
        if (r1 == null) goto L15;
        r1.setAnimating(false);
    L15:
        AudioGradientView r6 = r3.c;
        if ((r6 instanceof AudioShimmerGradientView) == false) goto L18;
        r2 = (AudioShimmerGradientView) r6;
    L18:
        if (r2 == null) goto L20;
        r2.d();
    L20:
        r3.c.setAnimating(false);
    }

    public final int getMode() {
        return this.f;
    }

    public final Function0<Unit> getTimeOutCallback() {
        return this.e;
    }

    public final void d(boolean r10) {
        final u r0 = this.d;
        r0.t.clear();
        Animator r1 = r0.s;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        AudioGradientView r2 = r0.c;
        if ((r2 instanceof AudioShimmerGradientView) == false) goto L8;
        AudioShimmerGradientView r3 = (AudioShimmerGradientView) r2;
    L9:
        if (r3 == null) goto L11;
        r3.d();
    L11:
        r0.c.setAnimating(false);
        r0.c.setAlpha(1.0f);
        r0.c.setGrayRatio(0.0f);
        r0.c.setVisibility(0);
        AudioSpectrumView r4 = r0.b;
        r4.setSpeakIntensity(0.0f);
        r4.setPauseIntensity(0.0f);
        r4.setPauseProgress(0.0f);
        r4.setPauseSlope(0.15f);
        r4.setWaveIntensity(0.0f);
        r4.setWavePlayProgress(0.0f);
        if (r10 == false) goto L14;
    L17:
        boolean r11 = true;
    L18:
        FLogger.a.i("AudioContinueAnimDelegate", "createWelcomeAnimation first:" + r11);
        ArrayList r5 = new ArrayList();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r0.c, View.ALPHA, new float[]{1.0f});
        r6.setDuration(r0.h);
        r6.addListener(new y(r0));
        Intrinsics.checkNotNull(r6);
        r5.add(r6);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r0.b, View.ALPHA, new float[]{1.0f});
        r7.setDuration(r0.h);
        r7.addListener(new x(r0));
        Intrinsics.checkNotNull(r7);
        r5.add(r7);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(r0.j);
        r8.setInterpolator(r0.n);
        r8.addUpdateListener(new h(r0));
        Intrinsics.checkNotNull(r8);
        r5.add(r8);
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r9.setDuration(r0.j);
        r9.setInterpolator(r0.n);
        r9.addUpdateListener(new i(r0));
        Intrinsics.checkNotNull(r9);
        r5.add(r9);
        if (r11 == true) goto L21;
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(r5);
        Pair r13 = new Pair(r12, Boolean.FALSE);
    L22:
        r0.e((Animator) r13.getFirst(), ((Boolean) r13.getSecond()).booleanValue(), null, null);
        if (r0.p == false) goto L26;
        r0.p = false;
        return;
    L26:
        return;
    L21:
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setDuration(r0.i);
        r14.setInterpolator(r0.l);
        r14.addUpdateListener(new j(r0));
        Intrinsics.checkNotNull(r14);
        r5.add(r14);
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setDuration(r0.k);
        r15.setInterpolator(r0.n);
        r15.addUpdateListener(new k(r0));
        Intrinsics.checkNotNull(r15);
        r5.add(r15);
        AnimatorSet r16 = new AnimatorSet();
        r16.playTogether(r5);
        r13 = new Pair(r16, Boolean.FALSE);
        goto L22
    L14:
        if (r0.p == true) goto L17;
        r11 = false;
        goto L18
    L8:
        r3 = null;
        goto L9
    }

    public void setAudioData(ArrayList<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "sampleData");
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CoroutineScope r3 = getLifecycleScope();
        if (r3 != null) goto L8;
        return;
    L8:
        this.j = BuildersKt.launch$default(r3, Dispatchers.getDefault(), null, new AnonymousClass2(this, r10, null), 2, null);
    }

    public final void setMode(int r1) {
        this.f = r1;
    }

    public final void setRecognizing(boolean r3) {
        boolean r0 = this.h;
        this.h = r3;
        if (r0 == true) goto L13;
        if (r3 == false) goto L14;
        Float r4 = this.i;
        if (r4 == null) goto L15;
        float r5 = r4.floatValue();
        u r1 = this.d;
        if (this.f != 0) goto L10;
        boolean r2 = true;
    L11:
        r1.g(r5, r2);
        return;
    L10:
        r2 = false;
        goto L11
    L15:
        return;
    L14:
        return;
    }

    public final void setTimeOutCallback(Function0<Unit> r2) {
        this.e = r2;
        this.d.u = r2;
    }

    @Override // iga.a
    public void setAudioData(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CoroutineScope r3 = getLifecycleScope();
        if (r3 != null) goto L8;
        return;
    L8:
        this.j = BuildersKt.launch$default(r3, Dispatchers.getDefault(), null, new AnonymousClass1(r10, this, null), 2, null);
    }

    public final void c(int[] r17, float[] r18) {
        Intrinsics.checkNotNullParameter(r17, "colors");
        Intrinsics.checkNotNullParameter(r18, "positions");
        AudioGradientView r3 = this.c;
        int r4 = r17.length;
        int[] r5 = new int[r4];
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r7 >= r4) goto L5;
        int r8 = r17[r7];
        r5[r7] = Color.argb(255, Color.red(r8), Color.green(r8), Color.blue(r8));
        r7 = r7 + 1;
        goto L3
    L5:
        r3.getClass();
        if (r4 != 0) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == false) goto L11;
        r3.j = false;
        r3.k = 0;
        r3.invalidate();
        return;
    L11:
        int r10 = Math.min(r4, 8);
        if (r18.length >= r10) goto L14;
        r3.j = false;
        r3.k = 0;
        r3.invalidate();
        return;
    L14:
        float r11 = 0.0f;
    L16:
        if (r6 >= r10) goto L18;
        int r12 = r5[r6];
        int r13 = r6 * 4;
        r3.l[r13] = Color.red(r12) / 255.0f;
        r3.l[r13 + 1] = Color.green(r12) / 255.0f;
        r3.l[r13 + 2] = Color.blue(r12) / 255.0f;
        r3.l[r13 + 3] = Color.alpha(r12) / 255.0f;
        r11 = RangesKt.coerceAtLeast(RangesKt.coerceIn(r18[r6], 0.0f, 1.0f), r11);
        r3.m[r6] = r11;
        r6 = r6 + 1;
        goto L16
    L18:
        int r0 = r10;
    L19:
        if (r0 >= 8) goto L21;
        int r1 = r0 * 4;
        float[] r14 = r3.l;
        r14[r1] = 0.0f;
        r14[r1 + 1] = 0.0f;
        r14[r1 + 2] = 0.0f;
        r14[r1 + 3] = 0.0f;
        r3.m[r0] = 1.0f;
        r0 = r0 + 1;
        goto L19
    L21:
        r3.j = true;
        r3.k = r10;
        r3.invalidate();
        return;
    L8:
        r9 = false;
        goto L9
    }

    public AudioContinueGradientView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.g = 45;
        TypedArray r8 = r5.obtainStyledAttributes(r6, new int[]{2130968867}, r7, 0);
        boolean r9 = r8.getBoolean(0, false);     // Catch: Throwable -> L10
        r8.recycle();
        FrameLayout.inflate(r5, 2131563930, this);
        AudioSpectrumView r10 = (AudioSpectrumView) findViewById(2131392651);
        this.b = r10;
        FrameLayout r11 = (FrameLayout) findViewById(2131392650);
        this.a = r11;
        if (r9 == false) goto L7;
        AudioGradientView r12 = new AudioShimmerGradientView(getContext(), null, 6, 0);
    L8:
        r12.setAutoExpand(false);
        r12.setBlurRadius(0.0f);
        r12.setCornerRadius(0.0f);
        r12.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r12.setVisibility(0);
        r11.addView(r12, 0);
        this.c = r12;
        this.d = new u(r10, r12);
        return;
    L7:
        r12 = new AudioGradientView(getContext(), null, 6, 0);
    L10:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    public static final Object b(AudioContinueGradientView r6, ArrayList r7, Continuation r8) {
        r6.getClass();
        Iterator r9 = r7.iterator();
        if (r9.hasNext() == true) goto L5;
        Double r10 = null;
    L10:
        if (r10 == null) goto L12;
        double r2 = r10.doubleValue();
    L14:
        if (r2 <= 0.5d) goto L16;
        double r3 = 1.0d;
    L17:
        Object r11 = BuildersKt.withContext(Dispatchers.getMain(), new AudioContinueGradientView$setAudioDataInner$2(r6, RangesKt.coerceAtMost(((float) r3) * 2.5f, 1.0f), null), r8);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r11;
    L21:
        return Unit.INSTANCE;
    L16:
        r3 = Math.sin(r2 * 3.141592653589793d);
        goto L17
    L12:
        r2 = 0.0d;
        goto L14
    L5:
        double r4 = Math.abs(((Number) r9.next()).doubleValue());
    L7:
        if (r9.hasNext() == false) goto L9;
        r4 = Math.max(r4, Math.abs(((Number) r9.next()).doubleValue()));
        goto L7
    L9:
        r10 = Boxing.boxDouble(r4);
        goto L10
    }

    public /* synthetic */ AudioContinueGradientView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

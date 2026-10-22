package com.obric.miniapp.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.databinding.MiniAppFragmentBinding;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MiniAppFragment$floatingSpeakerController$1 implements k2.t {
    public Integer a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public KeyBoardLayoutListener f;
    public Function1<? super Integer, Unit> g;
    public final /* synthetic */ MiniAppFragment h;

    public final class KeyBoardLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public final Job a;
        public final StateFlowImpl b;
        public final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 c;

        /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1", f = "MiniAppFragment.kt", i = {}, l = {881}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ KeyBoardLayoutListener this$0;
            final /* synthetic */ MiniAppFragment this$1;
            final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$2;

            /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "layoutBottom", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1", f = "MiniAppFragment.kt", i = {0, 0}, l = {885, 894}, m = "invokeSuspend", n = {"floatingSpeaker", "layoutBottom"}, s = {"L$0", "I$0"})
            public static final class C00491 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
                /* synthetic */ int I$0;
                Object L$0;
                int label;
                final /* synthetic */ MiniAppFragment this$0;
                final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$1;

                /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$floatingSpeakerController$1$KeyBoardLayoutListener$1$1$1", f = "MiniAppFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                public static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ FloatingSpeakerView $floatingSpeaker;
                    final /* synthetic */ int $layoutBottom;
                    int label;
                    final /* synthetic */ MiniAppFragment$floatingSpeakerController$1 this$0;
                    final /* synthetic */ MiniAppFragment this$1;

                    public C00501(FloatingSpeakerView r1, MiniAppFragment$floatingSpeakerController$1 r2, int r3, MiniAppFragment r4, Continuation<? super C00501> r5) {
                        this.$floatingSpeaker = r1;
                        this.this$0 = r2;
                        this.$layoutBottom = r3;
                        this.this$1 = r4;
                        super(2, r5);
                    }

                    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                        return new C00501(this.$floatingSpeaker, this.this$0, this.$layoutBottom, this.this$1, r8);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                        return invoke((CoroutineScope) r1, (Continuation) r2);
                    }

                    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object r10) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) goto L35;
                        ResultKt.throwOnFailure(r10);
                        int r11 = this.$floatingSpeaker.getBottom() - this.$floatingSpeaker.getMarginBottom();
                        int r0 = this.$floatingSpeaker.getMarginBottom();
                        MiniAppFragment$floatingSpeakerController$1 r1 = this.this$0;
                        r1.d += r1.b - this.$layoutBottom;
                        ViewGroup.LayoutParams r2 = this.$floatingSpeaker.getLayoutParams();
                        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
                        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
                    L8:
                        boolean r4 = true;
                        if (r3 == null) goto L25;
                        MiniAppFragment$floatingSpeakerController$1 r5 = this.this$0;
                        int r6 = this.$layoutBottom;
                        FloatingSpeakerView r7 = this.$floatingSpeaker;
                        int r8 = r5.b - r6;
                        int r9 = r5.d;
                        if (r9 > 0) goto L13;
                    L15:
                        if (r9 == 0) goto L17;
                    L19:
                        int r12 = r8 + (r11 - r5.c);
                        r3.bottomMargin += r12;
                        r5.c = (r7.getBottom() - r12) - r7.getMarginBottom();
                        FLogger.a.d("FloatingSpeaker", "floatingSpeaker.bottomMargin =  " + r3.bottomMargin);
                        if (r3.bottomMargin != 0) goto L24;
                        Function1<? super Integer, Unit> r13 = r5.g;
                        if (r13 == null) goto L24;
                        r13.invoke(Boxing.boxInt(r7.getMarginBottom()));
                    L24:
                        r7.requestLayout();
                        goto L25
                    L17:
                        if (r5.e == false) goto L19;
                        r5.e = false;
                        r8 = r8 + r0;
                        goto L19
                    L13:
                        if (r5.e == true) goto L15;
                        r5.e = true;
                        r8 = r8 - r0;
                    L25:
                        p r14 = this.this$1.E;
                        if (r14 != null) goto L28;
                    L32:
                        this.this$0.b = this.$layoutBottom;
                        return Unit.INSTANCE;
                    L28:
                        if (this.this$0.d > 0) goto L31;
                        r4 = false;
                    L31:
                        r14.invoke(Boxing.boxBoolean(r4), Boxing.boxInt(this.this$0.d));
                        goto L32
                    L7:
                        r3 = null;
                        goto L8
                    L35:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                public C00491(MiniAppFragment r1, MiniAppFragment$floatingSpeakerController$1 r2, Continuation<? super C00491> r3) {
                    this.this$0 = r1;
                    this.this$1 = r2;
                    super(2, r3);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    C00491 r0 = new C00491(this.this$0, this.this$1, r5);
                    r0.I$0 = ((Number) r4).intValue();
                    return r0;
                }

                public final Object invoke(int r1, Continuation<? super Unit> r2) {
                    return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke(((Number) r1).intValue(), (Continuation) r2);
                }

                public final Object invokeSuspend(Object r12) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L10;
                    if (r1 == 1) goto L9;
                    if (r1 != 2) goto L8;
                    ResultKt.throwOnFailure(r12);
                L34:
                    return Unit.INSTANCE;
                L8:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L9:
                    int r2 = this.I$0;
                    FloatingSpeakerView r3 = (FloatingSpeakerView) this.L$0;
                    ResultKt.throwOnFailure(r12);
                L25:
                    FLogger.a.i("FloatingSpeaker", "init GlobalLayout, layoutBottom =  " + r2);
                    MiniAppFragment$floatingSpeakerController$1 r13 = this.this$1;
                    r13.b = r2;
                    r13.c = r3.getBottom() - r3.getMarginBottom();
                    r3.setEnable(true);
                    return Unit.INSTANCE;
                L10:
                    ResultKt.throwOnFailure(r12);
                    int r8 = this.I$0;
                    if (r8 == 0) goto L13;
                    MiniAppFragmentBinding r14 = this.this$0.f;
                    if (r14 == null) goto L36;
                    FloatingSpeakerView r6 = r14.c;
                    if (r6 == null) goto L36;
                    int r15 = this.this$1.b;
                    if (r15 != 0) goto L27;
                    this.L$0 = r6;
                    this.I$0 = r8;
                    this.label = 1;
                    if (DelayKt.delay(500, this) != r0) goto L24;
                    return r0;
                L24:
                    r3 = r6;
                    r2 = r8;
                    goto L25
                L27:
                    if (r15 == r8) goto L29;
                    FLogger.a.i("FloatingSpeaker", "onGlobalLayoutChanged, layoutBottom =  " + r8);
                    MainCoroutineDispatcher r16 = Dispatchers.getMain();
                    C00501 r4 = new C00501(r6, this.this$1, r8, this.this$0, null);
                    this.label = 2;
                    if (BuildersKt.withContext(r16, r4, this) != r0) goto L34;
                    return r0;
                L29:
                    return Unit.INSTANCE;
                L36:
                    return Unit.INSTANCE;
                L13:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(KeyBoardLayoutListener r1, MiniAppFragment r2, MiniAppFragment$floatingSpeakerController$1 r3, Continuation<? super AnonymousClass1> r4) {
                this.this$0 = r1;
                this.this$1 = r2;
                this.this$2 = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass1(this.this$0, this.this$1, this.this$2, r5);
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
                StateFlowImpl r8 = this.this$0.b;
                C00491 r2 = new C00491(this.this$1, this.this$2, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L12;
                return r0;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Rect r0 = new Rect();
            Window r1 = (Window) this.c.h.Q.invoke();
            if (r1 == null) goto L12;
            View r2 = r1.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L9;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r3 = ThreadMethodProxy.currentThread();
            if (r3 == com.larus.home.impl.utils.c.a) goto L9;
            com.larus.home.impl.utils.c.a(r3, "getDecorView");
        L9:
            if (r2 == null) goto L12;
            r2.getWindowVisibleDisplayFrame(r0);
        L12:
            if (r0.bottom <= 0) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == true) goto L18;
            r0 = null;
        L18:
            if (r0 == null) goto L21;
            int r5 = r0.bottom;
            this.b.setValue(Integer.valueOf(r5));
            return;
        L21:
            return;
        L14:
            r4 = false;
            goto L15
        }

        public KeyBoardLayoutListener(MiniAppFragment$floatingSpeakerController$1 r8) {
            this.c = r8;
            this.b = j1.a(0);
            this.a = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.h), Dispatchers.getIO(), null, new AnonymousClass1(this, r8.h, r8, null), 2, null);
        }
    }

    public final void b() {
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == true) goto L5;
        return;
    L5:
        FLogger.a.i("FloatingSpeaker", "cancelTTS");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), zh8.a.a(), null, new MiniAppFragment$floatingSpeakerController$1$cancelTTS$1(this.h, null), 2, null);
    }

    public final void f() {
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == true) goto L5;
        return;
    L5:
        FLogger.a.i("FloatingSpeaker", "clearAppendQuery");
        MiniAppFragmentBinding r2 = this.h.f;
        if (r2 == null) goto L11;
        FloatingSpeakerView r3 = r2.c;
        if (r3 == null) goto L12;
        r3.f = null;
        return;
    L12:
        return;
    }

    public final String getBotId() {
        return this.h.h;
    }

    public final InputMode j() {
        MiniAppFragmentBinding r0 = this.h.f;
        if (r0 == null) goto L9;
        FloatingSpeakerView r1 = r0.c;
        if (r1 == null) goto L9;
        i1 r2 = r1.getInputModeFlow();
        if (r2 == null) goto L9;
        return (InputMode) r2.getValue();
    L9:
        return null;
    }

    public MiniAppFragment$floatingSpeakerController$1(MiniAppFragment r1) {
        this.h = r1;
    }

    public final void a(boolean r2) {
        this.h.B = r2;
    }

    public final void c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "content");
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MiniAppFragment$floatingSpeakerController$1$updateInputPlaceHolder$1(r8, this.h, null), 3, null);
    }

    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appendQuery");
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == true) goto L5;
        return;
    L5:
        FLogger.a.i("FloatingSpeaker", "setAppendQuery " + r4);
        MiniAppFragmentBinding r2 = this.h.f;
        if (r2 == null) goto L11;
        FloatingSpeakerView r3 = r2.c;
        if (r3 == null) goto L12;
        r3.setAppendQuery(r4);
        return;
    L12:
        return;
    }

    public final Object h(Continuation<? super Boolean> r11) {
        if ((r11 instanceof MiniAppFragment$floatingSpeakerController$1$clearContext$1) == false) goto L7;
        MiniAppFragment$floatingSpeakerController$1$clearContext$1 r0 = (MiniAppFragment$floatingSpeakerController$1$clearContext$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L25:
        boolean r4 = ub8.d.a((ub8.b) r12);
    L26:
        if (r4 == false) goto L34;
        com.bytedance.ai.model.widgets.c r13 = this.h.k;
        if (r13 == null) goto L32;
        AppletRuntime r14 = r13.getAppletRuntime();
        if (r14 == null) goto L32;
        r14.E(null, this.h.h);
    L32:
        AppletRuntimeManager r15 = AppletRuntimeManager.INSTANCE;
        String r5 = this.h.h;
        r15.getClass();
        AppletRuntimeManager.b(r5);
    L34:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        MiniAppFragment r16 = this.h;
        int r6 = MiniAppFragment.R;
        r4 = false;
        if (r16.X90() == false) goto L17;
        FLogger.a.i("FloatingSpeaker", "clearContext " + this.h.i);
        if (NetworkUtils.isNetworkAvailable(this.h.getContext()) == false) goto L26;
        String r17 = this.h.i;
        if (r17 == null) goto L26;
        IConversationRepoService r7 = zh8.a.b;
        IConversationRepoService.a.f(r7, r17, false, false, OmniBreakReason.OmniBreakReason_CLEAR_CONTEXT, 6);
        r0.label = 1;
        r12 = r7.n(r17, 3, "applet_fragment", r0);
        if (r12 != r2) goto L25;
        return r2;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new MiniAppFragment$floatingSpeakerController$1$clearContext$1(this, r11);
        goto L8
    }

    public final void i(int r8) {
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MiniAppFragment$floatingSpeakerController$1$updateInputOffset$1(r8, this, this.h, null), 3, null);
    }

    public final void m(boolean r2) {
        this.h.M = r2;
    }

    public final void o(InputMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        if (j() == r2) goto L10;
        MiniAppFragmentBinding r0 = this.h.f;
        if (r0 == null) goto L11;
        FloatingSpeakerView r1 = r0.c;
        if (r1 == null) goto L12;
        r1.R5(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "mode");
        FLogger.a.d("FloatingSpeaker", "updateInputText " + r4 + ' ' + r5);
        MiniAppFragmentBinding r0 = this.h.f;
        if (r0 == null) goto L8;
        FloatingSpeakerView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.S5(r4, r5);
        return;
    L9:
        return;
    }

    public final Object g(String r4, Continuation<? super Unit> r5) {
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == false) goto L5;
        FLogger.a.i("FloatingSpeaker", "updateBotId " + r4);
        Object r6 = MiniAppFragment.U90(this.h, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r6;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Unit k(String r8, boolean r9) {
        MiniAppFragment r0 = this.h;
        int r1 = MiniAppFragment.R;
        if (r0.X90() == false) goto L5;
        FLogger.a.i("FloatingSpeaker", "setTTSSwitch " + r8 + ' ' + r9);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), Dispatchers.getIO(), null, new MiniAppFragment$floatingSpeakerController$1$setTTSSwitch$2(r8, r9, this.h, null), 2, null);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object l(String r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof MiniAppFragment$floatingSpeakerController$1$startTTS$1) == false) goto L7;
        MiniAppFragment$floatingSpeakerController$1$startTTS$1 r0 = (MiniAppFragment$floatingSpeakerController$1$startTTS$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L25:
        Message r10 = (Message) r9;
        if (r10 == null) goto L29;
        MiniAppFragment r11 = this.h;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), zh8.a.a(), null, new MiniAppFragment$floatingSpeakerController$1$startTTS$2$1(r11, r10, null), 2, null);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        MiniAppFragment r12 = this.h;
        int r4 = MiniAppFragment.R;
        if (r12.X90() == false) goto L17;
        FLogger.a.i("FloatingSpeaker", "startTTS " + r7);
        if (StringsKt.isBlank(r7) == true) goto L21;
        IChatRepoService r13 = zh8.a.a;
        r0.label = 1;
        r9 = r13.E1(r7, r0);
        if (r9 != r2) goto L25;
        return r2;
    L21:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new MiniAppFragment$floatingSpeakerController$1$startTTS$1(this, r8);
        goto L8
    }

    public final void n(boolean r11, boolean r12) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.h), null, null, new MiniAppFragment$floatingSpeakerController$1$setChatInputVisible$1(r11, r12, this.h, this, null), 3, null);
    }
}

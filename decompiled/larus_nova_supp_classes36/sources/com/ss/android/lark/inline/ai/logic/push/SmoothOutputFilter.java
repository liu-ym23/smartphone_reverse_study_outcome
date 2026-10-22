package com.ss.android.lark.inline.ai.logic.push;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.space.doc.v1.InlineAITaskStatus;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.inline.ai.AbsInlineAIViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SmoothOutputFilter extends com.ss.android.lark.inline.ai.logic.push.a.AbstractC0106a {
    public static final /* synthetic */ int f = 0;
    public final AbsInlineAIViewModel b;
    public final Channel<b> c;
    public final ConcurrentHashMap<String, c> d;
    public InlineAITaskStatus e;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1", f = "SmoothOutputFilter.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmoothOutputFilter this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ SmoothOutputFilter a;

            public a(SmoothOutputFilter r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                ((Boolean) r5).booleanValue();
                Log.i("SmoothOutputFilter", "receive cancel, stop proceed");
                SmoothOutputFilter r7 = this.a;
                InlineAITaskStatus r0 = r7.e;
                if (r0 == null) goto L9;
                String r1 = r0.unique_task_id;
                if (r1 == null) goto L9;
                c r8 = r7.d.get(r1);
                if (r8 == null) goto L9;
                r8.c = true;
            L9:
                SmoothOutputFilter r9 = this.a;
                InlineAITaskStatus r2 = r9.e;
                if (r2 == null) goto L13;
                InlineAITaskStatus r3 = new InlineAITaskStatus.Builder().task_status("success").ai_message_id(r2.ai_message_id).seq_id(r2.seq_id).status_code(r2.status_code).session_id(r2.session_id).unique_task_id(r2.unique_task_id).content(r2.content).build();
                Log.i("SmoothOutputFilter", "receive cancel, directly print all");
                Intrinsics.checkNotNull(r3);
                r9.b(r3, true);
            L13:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(SmoothOutputFilter r1, Continuation<? super AnonymousClass1> r2) {
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
            d1<Boolean> r6 = this.this$0.b.getCancelFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    public static final class b {
        public InlineAITaskStatus a;
        public int b;
        public int c;
        public int d;
        public String e;

        public b() {
            this.a = new InlineAITaskStatus.Builder().build();
            this.e = "";
        }
    }

    public static final class c {
        public int a;
        public long b;
        public boolean c;

        public c() {
        }

        public final String toString() {
            return "TaskPrintParam(alreadyShowContentSize=" + this.a + ", firstDataReceiveTime=" + this.b + ')';
        }
    }

    static {
    }

    public SmoothOutputFilter(AbsInlineAIViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "inlineAIViewModel");
        this.b = r10;
        this.c = ChannelKt.Channel$default(0, null, null, 7, null);
        this.d = new ConcurrentHashMap();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r10), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // slb.d.a
    public final void a(InlineAITaskStatus r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        c r10 = this.d.get(r8.unique_task_id);
        boolean r0 = false;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (r11 == false) goto L12;
        Log.i("SmoothOutputFilter", "task canceled, return");
        return;
    L12:
        String r12 = r8.content;
        if (r12 != null) goto L15;
    L16:
        r0 = true;
    L18:
        if (r0 == true) goto L24;
        this.e = r8;
        String r1 = r8.unique_task_id;
        c r2 = this.d.get(r1);
        if (r2 != null) goto L23;
        r2 = new c();
        this.d.put(r1, r2);
    L23:
        Log.i("SmoothOutputFilter", "sendData data.unique_task_id is " + r8.unique_task_id + ", put it to map");
        b r3 = new b();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.a = r8;
        c(r3, r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.b), null, null, new SmoothOutputFilter$sendData$1(this, r3, null), 3, null);
    L24:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.b), null, null, new SmoothOutputFilter$receiveData$1(this, null), 3, null);
        return;
    L15:
        if (r12.length() != 0) goto L18;
    L5:
        if (r10.c != true) goto L7;
        r11 = true;
        goto L9
    }

    public final void c(b r8, c r9) {
        c r0 = this.d.get(r8.a.unique_task_id);
        if (r0 == null) goto L5;
        long r3 = r0.b;
    L7:
        if (r3 != 0) goto L9;
        r8.b = 20;
        r9.b = System.currentTimeMillis();
    L10:
        int r1 = r8.b * ((int) Math.exp(-((r8.a.content.length() - r9.a) / 100)));
        if (r1 >= 16) goto L15;
        if (r1 == 0) goto L15;
        r8.c = 16;
        r8.d = MathKt.roundToInt(((double) 16) / ((double) r1));
    L16:
        r8.c = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r8.c, 50), 16);
        Log.i("SmoothOutputFilter", "calculatePrintParams currentPrintDataCost : " + r8.c + "  currentPrintStepNum : " + r8.d);
        return;
    L15:
        r8.c = r8.b;
        r8.d = 1;
        goto L16
    L9:
        r8.b = (int) (((long) (r8.a.content.length() * AudioViewModel.ASR_SESSION_IDLE)) / (System.currentTimeMillis() - r3));
        goto L10
    L5:
        r3 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter, com.ss.android.lark.inline.ai.logic.push.a$a] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b] */
    /* JADX WARN: Type inference failed for: r14v8, types: [com.ss.android.lark.inline.ai.logic.push.SmoothOutputFilter$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final Object d(b r14, Continuation<? super Unit> r15) {
        String r0 = "success";
        if ((r15 instanceof SmoothOutputFilter$proceedResult$1) == false) goto L7;
        SmoothOutputFilter$proceedResult$1 r1 = (SmoothOutputFilter$proceedResult$1) r15;
        int r2 = r1.label;
        if ((r2 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r1.label = r2 - Target.SIZE_ORIGINAL;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L28;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L20;
        if (r4 != 3) goto L19;
        b r17 = (b) r1.L$1;
        ?? r5 = (b) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L16
        ?? r6 = r5;
        ?? r18 = r17;
    L60:
        ?? r7 = r18;
        r14 = r6;
    L62:
        Object r19 = Result.constructor-impl(r7);     // Catch: Throwable -> L64
        ?? r110 = r14;
    L67:
        Throwable r111 = Result.exceptionOrNull-impl(r19);
        if (r111 == null) goto L72;
        Log.i("SmoothOutputFilter", "proceedResult err " + r111.getMessage());
        b(r110.a, false);
    L72:
        return Unit.INSTANCE;
    L64:
        th = move-exception;
        ?? r112 = r14;
        th = th;
        r5 = r112;
    L66:
        Result.Companion r113 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        r110 = r5;
    L16:
        th = th;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        c r114 = (c) r1.L$3;
        b r8 = (b) r1.L$2;
        b r9 = (b) r1.L$1;
        b r10 = (b) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L26
        ?? r11 = r8;
        ?? r12 = r9;
        ?? r13 = r10;
    L54:
        c(r11, r114);     // Catch: Throwable -> L26
        if (r11.e.length() <= 0) goto L61;
        r1.L$0 = r13;     // Catch: Throwable -> L26
        r1.L$1 = r12;     // Catch: Throwable -> L26
        r1.L$2 = null;     // Catch: Throwable -> L26
        r1.L$3 = null;     // Catch: Throwable -> L26
        r1.label = 3;     // Catch: Throwable -> L26
        if (d(r11, r1) != r3) goto L59;
        return r3;
    L59:
        r18 = r12;
        r6 = r13;
        goto L60
    L61:
        r14 = r13;
        r7 = r12;
        goto L62
    L23:
        b r115 = (b) r1.L$2;
        b r20 = (b) r1.L$1;
        b r21 = (b) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L26
        ?? r22 = r20;
        ?? r23 = r21;
        ?? r116 = r115;
    L33:
        String r117 = r116.a.unique_task_id;     // Catch: Throwable -> L26
        c r24 = this.d.get(r117);     // Catch: Throwable -> L26
        if (r24 != null) goto L37;
        r24 = new c();     // Catch: Throwable -> L26
        this.d.put(r117, r24);     // Catch: Throwable -> L26
    L37:
        if (r24.c == false) goto L41;
        return Unit.INSTANCE;
    L41:
        if ((r24.a + r116.d) <= r116.a.content.length()) goto L43;
        int r118 = r116.a.content.length();     // Catch: Throwable -> L26
    L44:
        String r119 = r116.a.content.substring(0, r118);     // Catch: Throwable -> L26
        String r120 = r116.a.content.substring(r118);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r120, "<set-?>");     // Catch: Throwable -> L26
        r116.e = r120;     // Catch: Throwable -> L26
        r24.a += r116.d;     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r116.a.task_status, "success") == true) goto L47;
        r0 = r116.a.task_status;     // Catch: Throwable -> L26
    L50:
        InlineAITaskStatus r121 = new InlineAITaskStatus.Builder().task_status(r0).ai_message_id(r116.a.ai_message_id).seq_id(r116.a.seq_id).status_code(r116.a.status_code).session_id(r116.a.session_id).unique_task_id(r116.a.unique_task_id).content(r119).build();     // Catch: Throwable -> L26
        MainCoroutineDispatcher r25 = Dispatchers.getMain();     // Catch: Throwable -> L26
        SmoothOutputFilter$proceedResult$2$1$2 r122 = new SmoothOutputFilter$proceedResult$2$1$2(this, r121, null);     // Catch: Throwable -> L26
        r1.L$0 = r23;     // Catch: Throwable -> L26
        r1.L$1 = r22;     // Catch: Throwable -> L26
        r1.L$2 = r116;     // Catch: Throwable -> L26
        r1.L$3 = r24;     // Catch: Throwable -> L26
        r1.label = 2;     // Catch: Throwable -> L26
        if (BuildersKt.withContext(r25, r122, r1) != r3) goto L53;
        return r3;
    L53:
        r11 = r116;
        r114 = r24;
        r12 = r22;
        r13 = r23;
        goto L54
    L47:
        if (r116.e.length() <= 0) goto L50;
        r0 = "processing";
        goto L50
    L43:
        r118 = r24.a + r116.d;     // Catch: Throwable -> L26
        goto L44
    L28:
        ResultKt.throwOnFailure(r16);
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L64
        CoroutineDispatcher r124 = Dispatchers.getIO();     // Catch: Throwable -> L64
        SmoothOutputFilter$proceedResult$2$1$1 r26 = new SmoothOutputFilter$proceedResult$2$1$1(r14, null);     // Catch: Throwable -> L64
        r1.L$0 = r14;     // Catch: Throwable -> L64
        r1.L$1 = r14;     // Catch: Throwable -> L64
        r1.L$2 = r14;     // Catch: Throwable -> L64
        r1.label = 1;     // Catch: Throwable -> L64
        if (BuildersKt.withContext(r124, r26, r1) != r3) goto L32;
        return r3;
    L32:
        ?? r27 = r14;
        r23 = r27;
        r22 = r27;
        r116 = r14;
    L26:
        th = th;
        r5 = 1;
    L7:
        r1 = new SmoothOutputFilter$proceedResult$1(this, r15);
        goto L8
    }
}

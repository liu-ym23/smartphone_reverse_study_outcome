package com.larus.voicecall.impl.tracer;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class VoiceCallTraceLogger {
    public static final f2a.d l = null;
    public static final Set<String> m = null;
    public static final Set<String> n = null;
    public final CoroutineScope a;
    public final CoroutineScope b;
    public final Channel<Function0<Unit>> c;
    public long d;
    public long e;
    public boolean f;
    public String g;
    public p h;
    public final List<v> i;
    public final List<String> j;
    public Boolean k;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$1", f = "VoiceCallTraceLogger.kt", i = {0}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_TASK_FAILED}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ VoiceCallTraceLogger this$0;

        public AnonymousClass1(VoiceCallTraceLogger r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0041 -> B:13:0x0047). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ChannelIterator r2 = (ChannelIterator) this.L$1;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r4 = r3;
            ChannelIterator r5 = r2;
            Object r6 = r0;
            AnonymousClass1 r7 = this;
        L14:
            if (((Boolean) r8).booleanValue() == false) goto L22;
            Function0 r9 = (Function0) r5.next();
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
            r9.invoke();     // Catch: Throwable -> L18
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
        L20:
            AnonymousClass1 r11 = r7;
            r0 = r6;
            ChannelIterator r12 = r5;
            CoroutineScope r13 = r4;
        L9:
            r11.L$0 = r13;
            r11.L$1 = r12;
            r11.label = 1;
            Object r14 = r12.hasNext(r11);
            if (r14 != r0) goto L12;
            return r0;
        L12:
            Object r15 = r0;
            r7 = r11;
            r8 = r14;
            r4 = r13;
            r5 = r12;
            r6 = r15;
        L18:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            r12 = this.this$0.c.iterator();
            r13 = r17;
            r11 = this;
            goto L9
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0022a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[ReplyAudioPhase.values().length];
                r0[ReplyAudioPhase.BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[ReplyAudioPhase.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                a = r0;
                int[] r1 = new int[VoiceCallTraceReplyType.values().length];
                r1[VoiceCallTraceReplyType.REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r1[VoiceCallTraceReplyType.CHIME_IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                b = r1;
            }
        }

        public a() {
        }

        public static final ReplyAudioEventType a(VoiceCallTraceReplyType r1) {
            f2a.d r0 = VoiceCallTraceLogger.l;
            int r2 = C0022a.b[r1.ordinal()];
            if (r2 == 1) goto L10;
            if (r2 != 2) goto L8;
            return ReplyAudioEventType.CHIME_IN_END;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return ReplyAudioEventType.REPLY_END;
        }

        public static final Map b(String r4, String r5, long r6, long r8, String r10, Boolean r11, String r12, String r13) {
            f2a.d r0 = VoiceCallTraceLogger.l;
            boolean r1 = false;
            LinkedHashMap r7 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("SID", r4), TuplesKt.to("call_round", Long.valueOf(r6)), TuplesKt.to("trace_round", Long.valueOf(r8)), TuplesKt.to("timestamp_ms", Long.valueOf(System.currentTimeMillis()))});
            if (r11 == null) goto L6;
            r7.put("is_model_proactive_speak", Integer.valueOf(r11.booleanValue() ? 1 : 0));
        L6:
            if (r10.length() <= 0) goto L8;
            boolean r9 = true;
        L9:
            if (r9 == false) goto L22;
            r7.put("trace_message_id", r10);
            if (r8 > 0) goto L14;
        L20:
            r7.put("trace_key", r10);
            goto L22
        L14:
            if (r10.length() != 0) goto L16;
            boolean r14 = true;
        L17:
            if (r14 == false) goto L19;
            r10 = String.valueOf(r8);
            goto L20
        L19:
            r10 = r8 + '_' + r10;
            goto L20
        L16:
            r14 = false;
        L22:
            if (r5.length() <= 0) goto L24;
            boolean r15 = true;
        L25:
            if (r15 == false) goto L27;
            r7.put("room_id", r5);
        L27:
            if (r12 != null) goto L29;
        L32:
            boolean r16 = true;
        L33:
            if (r16 == true) goto L35;
            r7.put("last_asr_task_id", r12);
        L35:
            if (r13 != null) goto L37;
        L38:
            r1 = true;
        L39:
            if (r1 == true) goto L41;
            r7.put("last_tts_task_id", r13);
        L41:
            return r7;
        L37:
            if (r13.length() != 0) goto L39;
        L29:
            if (r12.length() == 0) goto L32;
            r16 = false;
            goto L33
        L24:
            r15 = false;
            goto L25
        L8:
            r9 = false;
            goto L9
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReplyAudioPhase.values().length];
            r0[ReplyAudioPhase.BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReplyAudioPhase.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        new a();
        l = new f2a.d("flow-call", "VoiceCallTraceLogger");
        m = SetsKt.setOf(new String[]{"player_status_end", "reply_end_pushed", "check_reply_status", "auto_end_on_new_begin", "auto_end_on_drain", "auto_end_on_release"});
        n = SetsKt.setOf(new String[]{"player_status_end", "inner_play_tail", "outer_play_tail", "check_reply_status", "auto_end_on_new_begin", "auto_end_on_drain", "auto_end_on_release"});
    }

    public VoiceCallTraceLogger() {
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().limitedParallelism(1).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.a = r3;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(this, null), 3, null);
        this.g = NameKeys.UnloadStrategy_No_Strategy;
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    public final void d(z r7) {
        p r1 = this.h;
        if (r1 == null) goto L6;
        b(r1, System.currentTimeMillis(), r7, "auto_end_on_drain");
    L6:
        if (((ArrayList) this.i).isEmpty() == false) goto L8;
        return;
    L8:
        e("reply.round", f(r7));
        ((ArrayList) this.i).clear();
    }

    public final Map<String, Object> f(z r12) {
        String r0 = r12.c;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = this.g;
    L8:
        String r2 = r12.a;
        String r3 = r12.b;
        long r4 = this.d;
        long r5 = this.e;
        return a.b(r2, r3, r4, r5, r0, Boolean.valueOf(this.f), r12.d, r12.e);
    L5:
        r1 = false;
        goto L6
    }

    public final void h(Function0<Unit> r2) {
        this.c.trySend-JP2dKIU(r2);
    }

    public static void e(String r4, Map r5) {
        f2a.c r6 = l.b(r4);
        Set r7 = r5.entrySet();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r8.next();
        Pair r2 = TuplesKt.to(new f2a.f((String) r0.getKey()), r0.getValue());
        r1.put(r2.getFirst(), r2.getSecond());
        goto L4
    L6:
        r6.d(r1);
        f2a.c.c(r6, null, 15);
    }

    public final void a(final ReplyAudioEventType r8, final String r9, final z r10, final String r11) {
        Intrinsics.checkNotNullParameter(r8, "eventType");
        Intrinsics.checkNotNullParameter(r9, "endType");
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        Intrinsics.checkNotNullParameter(r11, "source");
        h(new a0(this, r8, r9, r10, r11));
    }

    public final void b(p r8, long r9, z r11, String r12) {
        ReplyAudioEventType r1 = a.a(r8.a);
        this.h = null;
        g(r1, r9, "interrupt", r11, r12);
    }

    public final void c(ReplyAudioEventType r10, String r11, z r12, String r13) {
        long r6 = System.currentTimeMillis();
        ReplyAudioPhase r0 = r10.getPhase();
        int r1 = b.a[r0.ordinal()];
        boolean r8 = true;
        if (r1 != 1) goto L5;
        p r2 = this.h;
        if (r2 == null) goto L19;
        b(r2, r6, r12, "auto_end_on_new_begin");
    L19:
        this.h = new p(r10.getKind(), r6);
    L20:
        if (r8 == true) goto L22;
        return;
    L22:
        g(r10, r6, r11, r12, r13);
        return;
    L5:
        if (r1 != 2) goto L15;
        VoiceCallTraceReplyType r3 = r10.getKind();
        p r4 = this.h;
        if (r4 != null) goto L10;
    L12:
        r8 = false;
        goto L20
    L10:
        if (r4.a == r3) goto L13;
        b(r4, r6, r12, "auto_end_on_new_begin");
        goto L12
    L13:
        this.h = null;
        goto L20
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(ReplyAudioEventType r3, long r4, String r6, z r7, String r8) {
        List<v> r0 = this.i;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new v(r3, r4, r6));
        Map<String, Object> r5 = f(r7);
        r5.put("event_type", r3.getEventType());
        r5.put("end_type", r6);
        r5.put("source", r8);
        ReplyAudioPhase r9 = r3.getPhase();
        int r10 = a.C0022a.a[r9.ordinal()];
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L18;
        VoiceCallTraceReplyType r11 = r3.getKind();
        VoiceCallTraceReplyType r12 = VoiceCallTraceReplyType.REPLY;
        if (r11 != r12) goto L9;
        Set<String> r13 = m;
    L11:
        if (r13.contains(r8) == false) goto L14;
        String r14 = "playback_end";
    L26:
        r5.put("semantic_stage", r14);
        e(r3.getWhat(), r5);
        return;
    L14:
        if (r3.getKind() != r12) goto L16;
        r14 = "reply_end";
        goto L26
    L16:
        r14 = "chime_in_end";
        goto L26
    L9:
        r13 = n;
        goto L11
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (Intrinsics.areEqual(r8, "audio_first_frame") == false) goto L23;
        r14 = "playback_start";
        goto L26
    L23:
        if (r3.getKind() != VoiceCallTraceReplyType.REPLY) goto L25;
        r14 = "reply_begin";
        goto L26
    L25:
        r14 = "chime_in_begin";
        goto L26
    }
}

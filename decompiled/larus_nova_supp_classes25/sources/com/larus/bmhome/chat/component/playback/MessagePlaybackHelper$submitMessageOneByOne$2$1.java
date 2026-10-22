package com.larus.bmhome.chat.component.playback;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.page.datasource.event.c;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.stream.StreamChannel;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1", f = "MessagePlaybackHelper.kt", i = {1, 1, 2, 6, 6, 7, 7}, l = {75, 91, 109, 116, 125, DoraCallStateCode.DOUBAO_VUI_ERROR, 138, DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION}, m = "invokeSuspend", n = {"event", "message", "event", "event", "message", "event", "message"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1"})
final class MessagePlaybackHelper$submitMessageOneByOne$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessagePlaybackHelper this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1$1", f = "MessagePlaybackHelper.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MessagePlaybackHelper this$0;

        public AnonymousClass1(MessagePlaybackHelper r1, Continuation<? super AnonymousClass1> r2) {
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
            ResultKt.throwOnFailure(r4);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Function1 r5 = this.this$0.m;
            if (r5 == null) goto L14;
            this.label = 1;
            if (r5.invoke(this) != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$submitMessageOneByOne$2$1$5", f = "MessagePlaybackHelper.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MessagePlaybackHelper this$0;

        public AnonymousClass5(MessagePlaybackHelper r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Function1 r5 = this.this$0.m;
            if (r5 == null) goto L14;
            this.label = 1;
            if (r5.invoke(this) != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    public MessagePlaybackHelper$submitMessageOneByOne$2$1(MessagePlaybackHelper r1, Continuation<? super MessagePlaybackHelper$submitMessageOneByOne$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessagePlaybackHelper$submitMessageOneByOne$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x0248 -> B:150:0x024c). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r14);
        MessagePlaybackHelper$submitMessageOneByOne$2$1 r15 = this;
    L181:
        r15.this$0.c = false;
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r14);
        Object r1 = r0;
        MessagePlaybackHelper$submitMessageOneByOne$2$1 r2 = this;
    L151:
        if (((Unit) r14) != null) goto L154;
    L143:
        r15 = r2;
        goto L181
    L154:
        if (r2.this$0.c() == true) goto L158;
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass5 r3 = new AnonymousClass5(r2.this$0, null);
        r2.label = 6;
        if (BuildersKt.withContext(r16, r3, r2) != r1) goto L143;
        return r1;
    L158:
        c r8 = MessagePlaybackHelper.a(r2.this$0);
        if (r8 == null) goto L165;
        List r17 = r8.a;
        if (r17 == null) goto L165;
        b r18 = (b) CollectionsKt.first(r17);
        if (r18 == null) goto L165;
        Message r19 = r18.getMessage();
    L166:
        if (r19 != null) goto L168;
    L170:
        boolean r9 = false;
    L171:
        if (r9 == false) goto L175;
        r2.L$0 = r8;
        r2.L$1 = r19;
        r2.label = 7;
        if (DelayKt.delay(700, r2) != r1) goto L178;
        return r1;
    L178:
        Object r12 = r1;
        Message r4 = r19;
        r15 = r2;
        r0 = r12;
    L76:
        if (r4 == null) goto L181;
        if (r15.this$0.g == true) goto L181;
        if (JobKt.getJob(r15.getContext()).isCancelled() == true) goto L180;
        if (d.G0(r4) != true) goto L84;
        boolean r10 = true;
    L85:
        String r11 = "";
        if (r10 == false) goto L95;
        if (o0.d(r15.this$0.f) == false) goto L90;
        IAIChatService.a.i8(r15.this$0.f);
    L90:
        IAIChatService.a.b8(r4.getMessageId());
        MessagePlaybackHelper r13 = r15.this$0;
        String r110 = r4.getMessageId();
        if (r110 != null) goto L93;
        r110 = "";
    L93:
        r13.f = r110;
    L95:
        if (d.G0(r4) != true) goto L97;
        boolean r20 = true;
    L98:
        if (r20 == false) goto L100;
    L110:
        boolean r21 = false;
    L111:
        if (r21 == false) goto L144;
        MessagePlaybackHelper r5 = r15.this$0;
        r5.e = r4;
        int r6 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r7 = com.larus.im.internal.stream.b.a;
        if (r5.i == false) goto L124;
        Map r22 = r4.getBusinessExt();
        if (r22 == null) goto L124;
        StringBuilder r23 = new StringBuilder();
        e r24 = (e) AuthModelDelegate.b.y().getValue();
        if (r24 == null) goto L119;
        String r25 = r24.a;
    L120:
        if (r25 == null) goto L123;
        r11 = r25;
    L123:
        r23.append(r11);
        r23.append("::case");
        r23.append(r5.j);
        String r26 = (String) r22.put("case_conversation_id", r23.toString());
        goto L124
    L119:
        r25 = null;
    L124:
        Map r27 = r4.getBusinessExt();
        if (r27 == null) goto L127;
        String r28 = (String) r27.put("message_playback_mode", "1");
    L127:
        r15.L$0 = r8;
        r15.L$1 = null;
        r15.label = 3;
        StreamChannel.a.getClass();
        Object r29 = StreamChannel.d(r4, null, false, r15);
        if (r29 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L131;
        r29 = Unit.INSTANCE;
    L131:
        if (r29 != r0) goto L133;
        return r0;
    L133:
        c r30 = r8;
    L134:
        if (r30 == null) goto L181;
        MessagePlaybackHelper r31 = r15.this$0;
        MainCoroutineDispatcher r32 = Dispatchers.getMain();
        MessagePlaybackHelper$submitMessageOneByOne$2$1$3$1 r33 = new MessagePlaybackHelper$submitMessageOneByOne$2$1$3$1(r31, r30, null);
        r15.L$0 = null;
        r15.label = 4;
        Object r34 = BuildersKt.withContext(r32, r33, r15);
        if (r34 != r0) goto L138;
        return r0;
    L138:
        r2 = r15;
        r14 = r34;
    L140:
        if (((Unit) r14) == null) goto L143;
        r2.this$0.d++;
        goto L143
    L144:
        MessagePlaybackHelper r35 = r15.this$0;
        r35.d++;
        if (r8 == null) goto L181;
        MainCoroutineDispatcher r36 = Dispatchers.getMain();
        MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1 r111 = new MessagePlaybackHelper$submitMessageOneByOne$2$1$4$1(r35, r8, null);
        r15.L$0 = null;
        r15.L$1 = null;
        r15.label = 5;
        Object r37 = BuildersKt.withContext(r36, r111, r15);
        if (r37 != r0) goto L149;
        return r0;
    L149:
        Object r112 = r0;
        r2 = r15;
        r14 = r37;
        r1 = r112;
        goto L151
    L100:
        if (r4.getContentType() != 1) goto L102;
        boolean r38 = true;
    L103:
        if (r38 == false) goto L105;
    L109:
        r21 = true;
        goto L111
    L105:
        if (r4.getContentType() != 2022) goto L107;
        boolean r39 = true;
    L108:
        if (r39 == false) goto L110;
    L107:
        r39 = false;
        goto L108
    L102:
        r38 = false;
        goto L103
    L97:
        r20 = false;
        goto L98
    L84:
        r10 = false;
        goto L85
    L180:
        throw new CancellationException();
    L175:
        r2.L$0 = r8;
        r2.L$1 = r19;
        r2.label = 8;
        if (DelayKt.delay(700, r2) != r1) goto L178;
        return r1;
    L168:
        if (d.G0(r19) != true) goto L170;
        r9 = true;
    L165:
        r19 = null;
        goto L166
    L8:
        ResultKt.throwOnFailure(r14);
        r2 = this;
        goto L140
    L9:
        r30 = (c) this.L$0;
        ResultKt.throwOnFailure(r14);
        r15 = this;
        goto L134
    L10:
        r4 = (Message) this.L$1;
        r8 = (c) this.L$0;
        ResultKt.throwOnFailure(r14);
    L75:
        r15 = this;
        goto L76
    L11:
        ResultKt.throwOnFailure(r14);
    L31:
        this.this$0.c = false;
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r14);
        ((ArrayList) this.this$0.h).add(JobKt.getJob(getContext()));
        MessagePlaybackHelper r113 = this.this$0;
        if (r113.c == true) goto L184;
        if (r113.g == true) goto L184;
        r113.c = true;
        Message r114 = r113.e;
        if (r114 == null) goto L20;
        String r115 = r114.getMessageId();
    L21:
        if (r115 == null) goto L27;
        int r40 = com.larus.im.d.a;
        if (com.larus.im.internal.stream.b.a.c(r115) == null) goto L27;
        this.this$0.c = false;
        return Unit.INSTANCE;
    L27:
        if (this.this$0.c() == true) goto L33;
        MainCoroutineDispatcher r116 = Dispatchers.getMain();
        AnonymousClass1 r41 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r116, r41, this) != r0) goto L31;
        return r0;
    L33:
        r8 = MessagePlaybackHelper.a(this.this$0);
        if (r8 == null) goto L40;
        List r117 = r8.a;
        if (r117 == null) goto L40;
        b r118 = (b) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L40;
        r4 = r118.getMessage();
    L41:
        if (r4 != null) goto L44;
        this.this$0.c = false;
        return Unit.INSTANCE;
    L44:
        if (r8 == null) goto L50;
        List r119 = r8.a;
        if (r119 == null) goto L50;
        b r120 = (b) CollectionsKt.getOrNull(r119, 1);
        if (r120 == null) goto L50;
        Message r121 = r120.getMessage();
    L51:
        if (r121 != null) goto L53;
    L55:
        boolean r42 = false;
    L56:
        if (r42 == true) goto L70;
        if (r121 != null) goto L59;
    L61:
        boolean r43 = false;
    L62:
        if (r43 == true) goto L69;
        if (r121 != null) goto L65;
    L67:
        boolean r122 = false;
    L68:
        if (r122 == false) goto L70;
    L65:
        if (r121.getContentType() != 2022) goto L67;
        r122 = true;
    L69:
        boolean r123 = true;
    L71:
        if (r123 == false) goto L75;
        this.L$0 = r8;
        this.L$1 = r4;
        this.label = 2;
        if (DelayKt.delay(700, this) != r0) goto L75;
        return r0;
    L59:
        if (r121.getContentType() != 1) goto L61;
        r43 = true;
    L70:
        r123 = false;
        goto L71
    L53:
        if (d.G0(r121) != true) goto L55;
        r42 = true;
    L50:
        r121 = null;
    L40:
        r4 = null;
        goto L41
    L20:
        r115 = null;
    L184:
        return Unit.INSTANCE;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

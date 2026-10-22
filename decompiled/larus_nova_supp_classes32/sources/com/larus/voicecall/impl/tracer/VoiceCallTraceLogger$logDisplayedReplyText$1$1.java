package com.larus.voicecall.impl.tracer;

import android.app.Application;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.m0;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$logDisplayedReplyText$1$1", f = "VoiceCallTraceLogger.kt", i = {0}, l = {412, 426}, m = "invokeSuspend", n = {"context"}, s = {"L$0"})
final class VoiceCallTraceLogger$logDisplayedReplyText$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z $baseContext;
    final /* synthetic */ String $messageId;
    final /* synthetic */ long $snapshotCallRound;
    final /* synthetic */ Boolean $snapshotIsBlockData;
    final /* synthetic */ boolean $snapshotIsModelProactiveSpeak;
    final /* synthetic */ ArrayList<String> $snapshotReplyData;
    final /* synthetic */ String $snapshotTraceMessageId;
    final /* synthetic */ long $snapshotTraceRound;
    final /* synthetic */ String $taskId;
    Object L$0;
    int label;
    final /* synthetic */ VoiceCallTraceLogger this$0;

    public VoiceCallTraceLogger$logDisplayedReplyText$1$1(Boolean r1, ArrayList<String> r2, VoiceCallTraceLogger r3, z r4, long r5, long r7, String r9, boolean r10, String r11, String r12, Continuation<? super VoiceCallTraceLogger$logDisplayedReplyText$1$1> r13) {
        this.$snapshotIsBlockData = r1;
        this.$snapshotReplyData = r2;
        this.this$0 = r3;
        this.$baseContext = r4;
        this.$snapshotCallRound = r5;
        this.$snapshotTraceRound = r7;
        this.$snapshotTraceMessageId = r9;
        this.$snapshotIsModelProactiveSpeak = r10;
        this.$messageId = r11;
        this.$taskId = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        return new VoiceCallTraceLogger$logDisplayedReplyText$1$1(this.$snapshotIsBlockData, this.$snapshotReplyData, this.this$0, this.$baseContext, this.$snapshotCallRound, this.$snapshotTraceRound, this.$snapshotTraceMessageId, this.$snapshotIsModelProactiveSpeak, this.$messageId, this.$taskId, r18);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r69) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r69);
        Object r1 = r69;
    L40:
        String r4 = (String) r1;
    L47:
        final String r18 = r4;
        final VoiceCallTraceLogger r2 = this.this$0;
        final z r10 = this.$baseContext;
        final long r11 = this.$snapshotCallRound;
        final long r13 = this.$snapshotTraceRound;
        final String r15 = this.$snapshotTraceMessageId;
        final boolean r3 = this.$snapshotIsModelProactiveSpeak;
        final String r5 = this.$messageId;
        final String r6 = this.$taskId;
        Function0<Unit> r7 = new l0(r10, r11, r13, r15, r3, r2, r18, r5, r6);
        f2a.d r8 = VoiceCallTraceLogger.l;
        r2.h(r7);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Application r12 = (Application) this.L$0;
        ResultKt.throwOnFailure(r69);
        Application r14 = r12;
        Object r16 = r69;
    L25:
        List r17 = (List) r16;
        if (r17 == null) goto L42;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r17.iterator();
    L28:
        r4 = null;
        if (r20.hasNext() == false) goto L35;
        String r110 = (String) r20.next();
        gw8.c.a.getClass();
        gw8.c r111 = gw8.c.a.b();
        if (r111 == null) goto L33;
        Application r112 = r14;
        r4 = gw8.c.b.a(r111, r112, m0.b(r14), r110, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, new CodeBlockConfig(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, Boxing.boxBoolean(true), false, false, 117440511, null), null, null, null, null, null, null, null, -2097153, 31), null, null, 224);
    L33:
        if (r4 == null) goto L28;
        r19.add(r4);
        goto L28
    L35:
        s0 r21 = ILegacyChatUiServiceDelegate.b.X8();
        if (r21 == null) goto L47;
        this.L$0 = null;
        this.label = 2;
        r1 = r21.b(r19, this);
        if (r1 != r9) goto L40;
        return r9;
    L42:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r69);
        Boolean r22 = this.$snapshotIsBlockData;
        if (Intrinsics.areEqual(r22, Boxing.boxBoolean(true)) == false) goto L44;
        Ref.ObjectRef r23 = new Ref.ObjectRef();
        Iterator<T> r24 = this.$snapshotReplyData.iterator();
    L14:
        if (r24.hasNext() == false) goto L16;
        String r25 = (String) r24.next();
        List r26 = (List) r23.element;
        Intrinsics.checkNotNull(r25);
        r23.element = com.larus.voicecall.impl.subtitle.b.a(r26, r25);
        goto L14
    L16:
        Application r113 = AppHost.a.getApplication();
        s0 r27 = ILegacyChatUiServiceDelegate.b.X8();
        if (r27 == null) goto L42;
        List r28 = (List) r23.element;
        if (r28 != null) goto L21;
        r28 = CollectionsKt.emptyList();
    L21:
        this.L$0 = r113;
        this.label = 1;
        r16 = s0.a.a(r27, r28, true, null, false, null, this, 28);
        if (r16 != r9) goto L24;
        return r9;
    L24:
        r14 = r113;
        goto L25
    L44:
        if (Intrinsics.areEqual(r22, Boxing.boxBoolean(false)) == false) goto L46;
        r4 = CollectionsKt.joinToString$default(this.$snapshotReplyData, NameKeys.UnloadStrategy_No_Strategy, null, null, 0, null, null, 62, null);
        goto L47
    L46:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
        goto L47
    }
}

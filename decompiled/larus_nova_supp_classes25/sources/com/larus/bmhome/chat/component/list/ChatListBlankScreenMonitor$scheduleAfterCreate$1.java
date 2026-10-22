package com.larus.bmhome.chat.component.list;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import nf8.d;
import org.json.JSONObject;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListBlankScreenMonitor$scheduleAfterCreate$1", f = "ChatListBlankScreenMonitor.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class ChatListBlankScreenMonitor$scheduleAfterCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    int label;
    final /* synthetic */ c this$0;

    public ChatListBlankScreenMonitor$scheduleAfterCreate$1(long r1, c r3, Continuation<? super ChatListBlankScreenMonitor$scheduleAfterCreate$1> r4) {
        this.$delayMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListBlankScreenMonitor$scheduleAfterCreate$1(this.$delayMs, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r2 = 1;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        c r11 = this.this$0;
        if (r11.d == false) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r11.a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L18;
        MessageAdapter r12 = this.this$0.j;
        if (r12 == null) goto L22;
        int r13 = r12.getItemCount();
    L23:
        if (r13 > 1) goto L25;
        String r3 = null;
        if (r13 != 1) goto L37;
        MessageAdapter r4 = this.this$0.j;
        if (r4 == null) goto L33;
        List<b> r5 = r4.z2();
        if (r5 == null) goto L33;
        b r6 = (b) CollectionsKt.singleOrNull(r5);
    L35:
        if ((r6 instanceof d) == false) goto L37;
        int r7 = 1;
    L38:
        c r8 = this.this$0;
        r8.d = true;
        com.larus.bmhome.chat.component.cvs.y r9 = r8.b;
        if (r9 == null) goto L41;
        String r14 = r9.Y1();
    L42:
        wc9.e r15 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r15 == null) goto L45;
        String r16 = r15.a;
    L46:
        if (r14 != null) goto L48;
    L51:
        boolean r17 = true;
    L52:
        if (r17 == true) goto L65;
        if (r16 != null) goto L55;
    L58:
        boolean r18 = true;
    L59:
        if (r18 == true) goto L65;
        if (Intrinsics.areEqual(r14, r16) == true) goto L66;
        r2 = 0;
    L66:
        Pair r19 = this.this$0.c.getCurrentMessageListCountsForMonitor();
        int r20 = ((Number) r19.component1()).intValue();
        int r21 = ((Number) r19.component2()).intValue();
        JSONObject r22 = new JSONObject();
        c r23 = this.this$0;
        r22.put("conversation_id", r14);
        r22.put("is_main_bot", r2);
        com.larus.bmhome.chat.component.cvs.y r24 = r23.b;
        if (r24 == null) goto L69;
        r3 = r24.getBotId();
    L69:
        r22.put("bot_id", r3);
        r22.put("message_list_count", r20);
        r22.put("wcb_msg_count", r21);
        r22.put("ui_list_count", r13);
        r22.put("is_only_big_avatar", r7);
        r22.put("conversation_ready", r23.e ? 1 : 0);
        r22.put("conversation_ready_time", r23.f);
        r22.put("bot_ready", r23.g ? 1 : 0);
        r22.put("bot_ready_time", r23.h);
        int r110 = c.k;
        r22.put("enter_chat_times", c.k);
        r22.put("enter_duration", RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r23.i, 0));
        FLogger.a.w("ChatListBlankScreenMonitor", "reportEvent: " + r22);
        o.a.reportEvent("dev_chat_list_blank_screen", r22);
        return Unit.INSTANCE;
    L55:
        if (r16.length() == 0) goto L58;
        r18 = false;
    L65:
        r2 = -1;
        goto L66
    L48:
        if (r14.length() == 0) goto L51;
        r17 = false;
        goto L52
    L45:
        r16 = null;
        goto L46
    L41:
        r14 = null;
    L33:
        r6 = null;
    L37:
        r7 = 0;
        goto L38
    L25:
        return Unit.INSTANCE;
    L22:
        r13 = -1;
        goto L23
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r25 = this.$delayMs;
        this.label = 1;
        if (DelayKt.delay(r25, this) != r0) goto L11;
        return r0;
    }
}

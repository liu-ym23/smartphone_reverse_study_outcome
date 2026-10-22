package com.obric.assistant.card.list.cell.block;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.d;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.ThinkingBlock;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.complextask.ComplexTaskFoldStatus;
import com.obric.assistant.spi.complextask.IComplexTaskService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J$\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J \u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010,\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001bH\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\t*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0016\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/assistant/card/list/cell/block/ObricComplexTaskServiceImpl;", "Lcom/obric/assistant/spi/complextask/IComplexTaskService;", "<init>", "()V", "isComplexTaskMessage", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/message/Message;", "(Lcom/larus/im/bean/message/Message;)Z", "taskState", NameKeys.UnloadStrategy_No_Strategy, "getTaskState", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/String;", "isTaskCancel", "thinkingStartTime", NameKeys.UnloadStrategy_No_Strategy, "getThinkingStartTime", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Long;", "thinkingEndTime", "getThinkingEndTime", "isLinkType", "linkNewMsgId", "getLinkNewMsgId", "isAsyncMsgType", "isAskingUser", "messageFinishedStates", "Landroidx/collection/LruCache;", "messageHeaderClickStatus", "Lcom/obric/assistant/spi/complextask/ComplexTaskFoldStatus;", "taskStateMap", "shouldDelayUpdate", "message", "block", "Lcom/larus/im/bean/message/block/Block;", "getUpdateDelayTime", "isComplexTask", "appendLoadingTitle", "isDeepThinkingTyping", "thinkingBlock", "Lcom/larus/im/bean/message/block/ThinkingBlock;", "updateComplexTaskHeaderStatus", "status", "isHideExpandAllThinkViewStreaming", "getComplexTaskLinkMsgId", "shouldUpdateClickTargetFoldStatus", "getClickTargetFoldStatus", "defaultFoldStatus", "needForceShowDivider", "isNotShowStreamingAnimation", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskServiceImpl implements IComplexTaskService {
    public final LruCache<String, Boolean> a;
    public final LruCache<String, ComplexTaskFoldStatus> b;
    public final LruCache<String, String> c;

    public static final class a {
    }

    static {
    }

    public final boolean d(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return true;
    }

    public final boolean i(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return true;
    }

    public final long j(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        return 1000;
    }

    public ObricComplexTaskServiceImpl() {
        this.a = new LruCache(50);
        this.b = new LruCache(50);
        this.c = new LruCache(50);
    }

    public static String l(Message r1) {
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("o_task_state");
    }

    public static boolean m(Message r1) {
        if (n(r1) == false) goto L11;
        Map r2 = r1.getExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("o_complex_task_async_msg");
    L9:
        if (Intrinsics.areEqual(r3, "1") == false) goto L11;
        return true;
    L7:
        r3 = null;
    L11:
        return false;
    }

    public static boolean n(Message r1) {
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("o_task_type");
    L7:
        return Intrinsics.areEqual(r3, "complex_task");
    L5:
        r3 = null;
        goto L7
    }

    public static boolean o(Message r1) {
        if (n(r1) == false) goto L11;
        Map r2 = r1.getExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("o_msg_type");
    L9:
        if (Intrinsics.areEqual(r3, "link") == false) goto L11;
        return true;
    L7:
        r3 = null;
    L11:
        return false;
    }

    public static boolean p(Message r1) {
        if (n(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(l(r1), "cancel_complex_task") == false) goto L7;
        return true;
    }

    public final boolean f(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        FLogger.a.i("ObricComplexTaskServiceImpl", "isComplexTask, isComplexTaskMessage: " + n(r4));
        return n(r4);
    }

    public final boolean a(Message r4, Block r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "block");
        FLogger.a.i("ObricComplexTaskServiceImpl", "shouldDelayUpdate, isFinished: " + d.j0(r4) + ", isFinish: " + r5.isFinish());
        String r0 = r4.getMessageId();
        boolean r1 = false;
        if (r0 == null) goto L7;
        Boolean r2 = (Boolean) this.a.get(r0);
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L9:
        if (r3 == false) goto L11;
    L14:
        r1 = true;
    L15:
        String r6 = r4.getMessageId();
        if (r6 == null) goto L19;
        Boolean r7 = (Boolean) this.a.put(r6, Boolean.valueOf(r1));
    L19:
        return !r1;
    L11:
        if (d.j0(r4) == true) goto L14;
        if (r5.isFinish() == false) goto L15;
    L7:
        r3 = false;
        goto L9
    }

    public final boolean b(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        if (n(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(l(r2), "clarify_complex_task") == false) goto L7;
        return true;
    }

    public final boolean c(Message r2, Block r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "block");
        return f(r2);
    }

    public final String e(Message r3, Block r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "block");
        Map r5 = r3.getExt();
        if (r5 == null) goto L5;
        String r6 = (String) r5.get("o_reply_new_msg_id");
    L7:
        if (o(r3) == false) goto L11;
        if (r6 == null) goto L11;
        FLogger.a.i("ObricComplexTaskServiceImpl", "getComplexTaskLinkMsgId, newMsgId: ".concat(r6));
        return r6;
    L11:
        return null;
    L5:
        r6 = null;
        goto L7
    }

    public final ComplexTaskFoldStatus g(ComplexTaskFoldStatus r4, Message r5, Block r6) {
        Intrinsics.checkNotNullParameter(r4, "status");
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "block");
        String r7 = r5.getMessageId();
        if (r7 == null) goto L15;
        String r0 = (String) this.c.get(r7);
        String r1 = l(r5);
        if (r1 == null) goto L8;
        this.c.put(r7, r1);
    L8:
        if (Intrinsics.areEqual(r1, "cancel_complex_task") == false) goto L12;
        if (Intrinsics.areEqual(r0, r1) == true) goto L12;
    L13:
        LruCache<String, ComplexTaskFoldStatus> r8 = this.b;
        ComplexTaskFoldStatus r9 = ComplexTaskFoldStatus.CompleteFold;
        r8.put(r7, r9);
        return r9;
    L12:
        if (o(r5) == true) goto L13;
    L15:
        String r10 = r5.getMessageId();
        if (r10 == null) goto L20;
        ComplexTaskFoldStatus r11 = (ComplexTaskFoldStatus) this.b.get(r10);
        if (r11 == null) goto L20;
        return r11;
    L20:
        if (p(r5) == false) goto L24;
        if (r6.isFinish() == false) goto L24;
    L29:
        FLogger.a.i("ObricComplexTaskServiceImpl", "updateComplexTaskHeaderStatus, isTaskCancel: " + p(r5) + ", isAsyncMsgType: " + m(r5) + ", isFinish: " + r6.isFinish());
        return ComplexTaskFoldStatus.CompleteFold;
    L24:
        if (m(r5) == true) goto L29;
        if (o(r5) == true) goto L29;
        return ComplexTaskFoldStatus.HalfFold;
    }

    public final String k(Message r8, boolean r9, ThinkingBlock r10) {
        Intrinsics.checkNotNullParameter(r8, "message");
        Map r11 = r8.getExt();
        String r12 = null;
        if (r11 == null) goto L7;
        String r13 = (String) r11.get("o_complex_task_thinking_start_timestamp");
        if (r13 == null) goto L7;
        Long r14 = StringsKt.toLongOrNull(r13);
    L9:
        if (n(r8) == true) goto L11;
    L36:
        return r12;
    L11:
        if (o(r8) == true) goto L36;
        if (r14 == null) goto L36;
        Map r0 = r8.getExt();
        if (r0 == null) goto L18;
        String r1 = (String) r0.get("o_complex_task_thinking_end_timestamp");
        if (r1 == null) goto L18;
        Long r2 = StringsKt.toLongOrNull(r1);
    L19:
        if (r2 == null) goto L21;
    L22:
        Map r15 = r8.getExt();
        if (r15 == null) goto L27;
        String r16 = (String) r15.get("o_complex_task_thinking_end_timestamp");
        if (r16 == null) goto L27;
        Long r17 = StringsKt.toLongOrNull(r16);
    L28:
        if (r17 == null) goto L30;
        long r3 = r17.longValue();
    L31:
        long r18 = ((Number) RangesKt.coerceIn(Long.valueOf(r3 - r14.longValue()), 0L, null)).longValue();
        if (r18 <= 60) goto L34;
        long r4 = 60;
        r12 = AppHost.a.getApplication().getApplicationContext().getString(2131911973, new Object[]{Long.valueOf(r18 / r4), Long.valueOf(r18 % r4)});
    L35:
        Intrinsics.checkNotNull(r12);
        FLogger.a.i("ObricComplexTaskServiceImpl", "appendLoadingTitle, timeCosts: " + r18 + ", timerText: " + r12);
        goto L36
    L34:
        r12 = AppHost.a.getApplication().getApplicationContext().getString(2131911974, new Object[]{Long.valueOf(r18)});
        goto L35
    L30:
        r3 = AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000);
    L27:
        r17 = null;
        goto L28
    L21:
        if (d.j0(r8) == true) goto L36;
    L18:
        r2 = null;
    L7:
        r14 = null;
        goto L9
    }

    public final ComplexTaskFoldStatus h(ComplexTaskFoldStatus r3, Message r4, Block r5, ComplexTaskFoldStatus r6) {
        Intrinsics.checkNotNullParameter(r3, "status");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "block");
        Intrinsics.checkNotNullParameter(r6, "defaultFoldStatus");
        FLogger.a.i("ObricComplexTaskServiceImpl", "getClickTargetFoldStatus, status: " + r3);
        if (p(r4) == false) goto L5;
    L11:
        r6 = ComplexTaskFoldStatus.CompleteExpand;
        if (r3 != r6) goto L14;
        r6 = ComplexTaskFoldStatus.CompleteFold;
    L14:
        String r7 = r4.getMessageId();
        if (r7 == null) goto L17;
        this.b.put(r7, r6);
    L17:
        return r6;
    L5:
        if (m(r4) == true) goto L11;
        ComplexTaskFoldStatus r8 = ComplexTaskFoldStatus.CompleteExpand;
        if (r3 == r8) goto L14;
        r6 = r8;
        goto L14
    }
}

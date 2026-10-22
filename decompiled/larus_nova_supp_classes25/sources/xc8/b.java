package xc8;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.cell.ComponentCellStateType;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class b implements wq8.a {
    public Message a;
    public final Lazy b;
    public boolean c;
    public final ComponentCellStateType d;

    public int d() {
        return -1;
    }

    public final int e() {
        return ((Number) this.b.getValue()).intValue();
    }

    public final Message a() {
        return getMessage();
    }

    public ComponentCellStateType f() {
        return this.d;
    }

    public Message getMessage() {
        return this.a;
    }

    public b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.d = ComponentCellStateType.DEFAULT;
    }

    public static String g(Message r2) {
        if (com.larus.im.bean.message.a.r0(r2) == false) goto L12;
        Map r0 = r2.getExt();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("message_id");
    L9:
        if (o0.d(r1) == false) goto L12;
        return r1;
    L7:
        r1 = null;
    L12:
        return r2.getMessageId();
    }

    public boolean b(wq8.a r10) {
        Intrinsics.checkNotNullParameter(r10, "newItem");
        Message r1 = getMessage();
        Message r11 = r10.a();
        Intrinsics.checkNotNullParameter(r1, "oldItem");
        Intrinsics.checkNotNullParameter(r11, "newItem");
        Map r0 = r11.getBusinessExt();
        Integer r2 = null;
        if (r0 == null) goto L5;
        String r3 = (String) r0.get("loading");
    L7:
        if (Intrinsics.areEqual(r3, "1") == false) goto L17;
        Map r4 = r11.getBusinessExt();
        if (r4 == null) goto L13;
        String r5 = (String) r4.get("progress");
        if (r5 == null) goto L13;
        int r6 = CastIntegerProtector.parseInt(r5);
    L15:
        if (r6 >= 100) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        FLogger.a.i("chatDiff", "force update msg. localMsgId=" + r1.getLocalMessageId() + " oldMsgId=" + r1.getMessageId() + " newMsgId=" + r11.getMessageId() + ' ');
    L77:
        return false;
    L20:
        Integer r8 = b0.c(r1);
        if (r8 != null) goto L24;
    L79:
    L75:
        e = move-exception;
        FLogger.a.e("MessageAdapterExt", "messageSame e=" + e.getMessage());
        g.a.ensureNotReachHere(e);
        goto L77
    L34:
        if (r1.getContentType() != r11.getContentType()) goto L77;
        if (Intrinsics.areEqual(r1.getContent(), r11.getContent()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getContentBlock(), r11.getContentBlock()) == false) goto L77;
        if (r1.getMessageStatus() != r11.getMessageStatus()) goto L77;
        if (r1.getMessageStatusLocal() != r11.getMessageStatusLocal()) goto L77;
        if (r1.getLocalIndex() != r11.getLocalIndex()) goto L77;
        if (r1.getServerIndex() != r11.getServerIndex()) goto L77;
        if (Intrinsics.areEqual(r1.getFeedback(), r11.getFeedback()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getSectionId(), r11.getSectionId()) == false) goto L77;
        if (r11.getContentType() != 2) goto L63;
        List r9 = r1.getSuggestQuestions();     // Catch: Exception -> L75
        if (r9 == null) goto L56;
        Integer r12 = Integer.valueOf(r9.size());     // Catch: Exception -> L75
    L57:
        List r13 = r11.getSuggestQuestions();     // Catch: Exception -> L75
        if (r13 == null) goto L61;
        r2 = Integer.valueOf(r13.size());     // Catch: Exception -> L75
    L61:
        if (Intrinsics.areEqual(r12, r2) == false) goto L77;
    L56:
        r12 = null;
    L63:
        if (Intrinsics.areEqual(r1.getBusinessExt(), r11.getBusinessExt()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getSectionName(), r11.getSectionName()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getExt(), r11.getExt()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getSubList(), r11.getSubList()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getSubListGroup(), r11.getSubListGroup()) == false) goto L77;
        if (Intrinsics.areEqual(r1.getThinkingContent(), r11.getThinkingContent()) == false) goto L77;
        return true;
    L24:
        if (r8.intValue() != 0) goto L79;
        Integer r14 = b0.c(r11);
        if (r14 == null) goto L79;
        if (r14.intValue() != 0) goto L79;
        if (r1.getMessageStatusLocal() != r11.getMessageStatusLocal()) goto L79;
        return true;
    L13:
        r6 = 0;
    L17:
        r7 = false;
        goto L18
    L5:
        r3 = null;
        goto L7
    }

    public boolean c(wq8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "newItem");
        if (Intrinsics.areEqual(getClass(), r4.getClass()) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(getMessage().getLocalMessageId(), r4.a().getLocalMessageId()) == true) goto L19;
        Message r0 = getMessage();
        Message r5 = r4.a();
        if (r0 == null) goto L16;
        if (r5 == null) goto L16;
        if (com.larus.im.bean.message.a.r0(r0) == false) goto L14;
    L17:
        boolean r6 = Intrinsics.areEqual(g(r0), g(r5));
    L18:
        if (r6 == true) goto L19;
        return false;
    L14:
        if (com.larus.im.bean.message.a.r0(r5) == true) goto L17;
    L16:
        r6 = false;
    L19:
        return true;
    }

    public void h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}

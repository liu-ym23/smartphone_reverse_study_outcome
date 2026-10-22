package xd8;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements td8.c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // td8.c
    public final boolean a(int r8, xc8.b r9, xc8.b r10, List<? extends xc8.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "current");
        Intrinsics.checkNotNullParameter(r11, "input");
        Message r12 = r10.getMessage();
        String r13 = null;
        if (r9 == null) goto L5;
        Message r14 = r9.getMessage();
    L6:
        boolean r15 = false;
        if (r12 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L30;
        if (r14 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L30;
        if (r12.getContentType() != 9) goto L24;
        if (r14.getContentType() != 1) goto L24;
    L28:
        if (Math.abs(r12.getCreateTime() - r14.getCreateTime()) >= TimeUnit.SECONDS.toMillis(30)) goto L30;
        r15 = true;
    L24:
        if (r12.getContentType() != 1) goto L30;
        if (r14.getContentType() != 9) goto L30;
    L15:
        if (com.larus.bmhome.chat.bean.d.W0(r14) != true) goto L17;
        r2 = true;
    L30:
        if (r15 == false) goto L71;
        FLogger r0 = FLogger.a;
        StringBuilder r3 = new StringBuilder("RecommendDivider match: pre={msgId=");
        if (r14 == null) goto L34;
        String r4 = r14.getMessageId();
    L35:
        r3.append(r4);
        r3.append(", localMsgId=");
        if (r14 == null) goto L38;
        String r5 = r14.getLocalMessageId();
    L39:
        r3.append(r5);
        r3.append(", ct=");
        if (r14 == null) goto L42;
        Integer r6 = Integer.valueOf(r14.getContentType());
    L43:
        r3.append(r6);
        r3.append(", create=");
        if (r14 == null) goto L46;
        Long r7 = Long.valueOf(r14.getCreateTime());
    L47:
        r3.append(r7);
        r3.append(", section=");
        if (r14 == null) goto L50;
        String r16 = r14.getSectionId();
    L51:
        r3.append(r16);
        r3.append("} current={msgId=");
        if (r12 == null) goto L54;
        String r17 = r12.getMessageId();
    L55:
        r3.append(r17);
        r3.append(", localMsgId=");
        if (r12 == null) goto L58;
        String r18 = r12.getLocalMessageId();
    L59:
        r3.append(r18);
        r3.append(", ct=");
        if (r12 == null) goto L62;
        Integer r19 = Integer.valueOf(r12.getContentType());
    L63:
        r3.append(r19);
        r3.append(", create=");
        if (r12 == null) goto L66;
        Long r20 = Long.valueOf(r12.getCreateTime());
    L67:
        r3.append(r20);
        r3.append(", section=");
        if (r12 == null) goto L70;
        r13 = r12.getSectionId();
    L70:
        r3.append(r13);
        r3.append('}');
        r0.i("Pipeline_List_RecommendDividerTask", r3.toString());
        goto L71
    L66:
        r20 = null;
        goto L67
    L62:
        r19 = null;
        goto L63
    L58:
        r18 = null;
        goto L59
    L54:
        r17 = null;
        goto L55
    L50:
        r16 = null;
        goto L51
    L46:
        r7 = null;
        goto L47
    L42:
        r6 = null;
        goto L43
    L38:
        r5 = null;
        goto L39
    L34:
        r4 = null;
    L71:
        return r15;
    L9:
        if (com.larus.bmhome.chat.bean.d.W0(r12) != true) goto L11;
        r1 = true;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    @Override // td8.c
    public final List<xc8.b> b(int r49, xc8.b r50, xc8.b r51, List<xc8.b> r52) {
        Intrinsics.checkNotNullParameter(r51, "current");
        Intrinsics.checkNotNullParameter(r52, "input");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("RecommendDivider added in pre: messageId is >>>");
        Integer r3 = null;
        if (r50 == null) goto L7;
        Message r4 = r50.getMessage();
        if (r4 == null) goto L7;
        String r5 = r4.getMessageId();
    L8:
        r2.append(r5);
        r2.append(", contentType is >>> ");
        if (r50 == null) goto L13;
        Message r6 = r50.getMessage();
        if (r6 == null) goto L13;
        r3 = Integer.valueOf(r6.getContentType());
    L13:
        r2.append(r3);
        r2.append(" and current: messageId is >>>");
        r2.append(r51.getMessage().getMessageId());
        r2.append(", contentType is >>> ");
        r2.append(r51.getMessage().getContentType());
        r1.i("Pipeline_List_RecommendDividerTask", r2.toString());
        String r24 = r51.getMessage().getSectionId();
        Message r7 = r51.getMessage();
        String r12 = com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.a.getApplication().getString(2131898625), null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null), TextContent.Companion.serializer());
        return CollectionsKt.mutableListOf(new xc8.b[]{r51, new cg8.c(b0.j(new Message(r7.getConversationId(), null, null, 0, 21, null, 1001, false, null, r12, null, null, null, null, null, r7.getMessageId() + "-welcome-back", r7.getLocalIndex() - 1, 0, false, r24, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 4))});
    L7:
        r5 = null;
        goto L8
    }
}

package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements td8.c {
    public static final /* synthetic */ int c = 0;
    public final td8.d a;
    public final Lazy b;

    public static final class a {
        public static cg8.c a(Message r59, String r60, String r61, boolean r62) {
            Intrinsics.checkNotNullParameter(r59, "current");
            Intrinsics.checkNotNullParameter(r61, "from");
            if (com.larus.bmhome.chat.bean.d.W0(r59) == false) goto L5;
            String r1 = com.larus.bmhome.chat.bean.d.x(r59).getWcbTitle();
        L7:
            if (com.larus.bmhome.chat.bean.d.Y0(r59) == false) goto L9;
            String r3 = (String) com.larus.bmhome.chat.bean.d.x(r59).get("z_lottery_title");
        L10:
            boolean r4 = true;
            if (r3 != null) goto L13;
        L16:
            boolean r6 = true;
        L17:
            if (r6 == true) goto L20;
            String r5 = r3;
        L29:
            String r24 = com.larus.im.internal.core.message.converter.a.a(new TextContent(r5, null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null), TextContent.Companion.serializer());
            cg8.c r2 = new cg8.c(b0.j(new Message(r59.getConversationId(), null, null, 0, 21, null, 1001, false, null, r24, null, null, null, null, null, r59.getMessageId() + "-clear-context", r59.getLocalIndex() + 1, 0, false, r60, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 3));
            FLogger r7 = FLogger.a;
            StringBuilder r8 = new StringBuilder("createClearContextMessage, current:");
            int r9 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.c;
            r8.append(com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.a.a(r59));
            r8.append(", sectionId:");
            r8.append(r60);
            r8.append(", from:");
            r8.append(r61);
            r7.i("Pipeline_List_ClearContextTask", r8.toString());
            return r2;
        L20:
            if (r1.length() > 0) goto L23;
            r4 = false;
        L23:
            if (r4 == true) goto L28;
            if (r62 == false) goto L27;
            r1 = AppHost.a.getApplication().getString(2131898625);
            Intrinsics.checkNotNull(r1);
            goto L28
        L27:
            r1 = AppHost.a.getApplication().getString(2131910018);
            Intrinsics.checkNotNull(r1);
        L28:
            r5 = r1;
            goto L29
        L13:
            if (r3.length() == 0) goto L16;
            r6 = false;
            goto L17
        L9:
            r3 = null;
            goto L10
        L5:
            r1 = "";
            goto L7
        }
    }

    static {
    }

    public j(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        this.a = r2;
        this.b = LazyKt.lazy(new i(this));
    }

    @Override // td8.c
    public final boolean a(int r8, xc8.b r9, xc8.b r10, List<? extends xc8.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "current");
        Intrinsics.checkNotNullParameter(r11, "input");
        if (AppHost.a.isPlugin() == false) goto L9;
        if (td8.c.a.a((e) this.b.getValue(), 0, null, null, r11, 7) == false) goto L9;
        return ((e) this.b.getValue()).a(r8, r9, r10, r11);
    L9:
        if ((this.a.l() instanceof z) == false) goto L11;
    L13:
        return false;
    L11:
        if ((this.a.l() instanceof com.larus.bmhome.social.userchat.model.b) == true) goto L13;
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r7, xc8.b r8, xc8.b r9, List<xc8.b> r10) {
        Intrinsics.checkNotNullParameter(r9, "current");
        Intrinsics.checkNotNullParameter(r10, "input");
        if (AppHost.a.isPlugin() == true) goto L5;
    L8:
        xc8.b r11 = (xc8.b) CollectionsKt.firstOrNull(r10);
        String r12 = null;
        if (r11 == null) goto L11;
        Message r13 = r11.getMessage();
    L12:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("start ClearContextTask, start input size is ");
        r1.append(r10.size());
        r1.append(", lastMessage:");
        if (r13 == null) goto L15;
        int r14 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.c;
        r12 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.a.a(r13);
    L15:
        r1.append(r12);
        r0.i("Pipeline_List_ClearContextTask", r1.toString());
        if (r13 != null) goto L18;
    L20:
        boolean r2 = false;
    L22:
        if (r2 == true) goto L24;
        if (r13 == null) goto L55;
        String r3 = this.a.p();
        if (Intrinsics.areEqual(r13.getSectionId(), r3) == false) goto L39;
    L43:
        boolean r4 = false;
    L44:
        if (r4 == false) goto L55;
        if (com.larus.bmhome.chat.bean.d.j0(r13) == true) goto L50;
        if (com.larus.bmhome.chat.bean.d.G0(r13) == false) goto L55;
    L50:
        if (com.larus.bmhome.chat.bean.d.Q0(r13) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.x(r13).getLocalSubCoCoMsg() == true) goto L55;
        r0.i("Pipeline_List_ClearContextTask", "clearContextDivider added for message id: " + r13.getMessageId() + '_' + r13.getLocalMessageId() + ", index: " + r13.getLocalIndex() + ",sectionId:" + this.a.p() + "->" + r13.getSectionId());
        ListProtector.add(r10, 0, a.a(r13, this.a.p(), "last_msg", com.larus.bmhome.chat.bean.d.X(r13)));
        goto L55
    L39:
        if (o0.d(r13.getSectionId()) == false) goto L43;
        if (o0.d(r3) == false) goto L43;
        r4 = true;
    L55:
        if (r10.size() >= 2) goto L57;
    L68:
        r0.i("Pipeline_List_ClearContextTask", "end ClearContextTask, end input size is " + r10.size());
        return r10;
    L57:
        if (com.larus.bmhome.chat.bean.d.Y(((xc8.b) ListProtector.get(r10, 0)).getMessage()) == false) goto L68;
        if (((xc8.b) ListProtector.get(r10, 1)).getMessage().getContentType() != 2) goto L66;
        if (com.larus.bmhome.chat.bean.d.k0(((xc8.b) ListProtector.get(r10, 1)).getMessage()) == true) goto L66;
        if (((xc8.b) ListProtector.get(r10, 1)).getMessage().getLocalIndex() != Long.MAX_VALUE) goto L66;
        r0.i("Pipeline_List_ClearContextTask", "input[1] removed");
        ListProtector.remove(r10, 1);
    L66:
        if (com.larus.bmhome.chat.bean.d.Y(((xc8.b) ListProtector.get(r10, 1)).getMessage()) == false) goto L68;
        r0.i("Pipeline_List_ClearContextTask", "input[1] removed again");
        ListProtector.remove(r10, 1);
        goto L68
    L24:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r13).get("wcb_render_status"), WcbRenderStatus.DEPRECATED) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.W(r13) == true) goto L55;
        Integer r5 = com.larus.bmhome.chat.bean.d.x(r13).getNextPulseType();
        if (r5 != null) goto L31;
    L34:
        r0.i("Pipeline_List_ClearContextTask", "clearContextDivider added for wcb id: " + r13.getMessageId() + ", index: " + r13.getLocalIndex());
        ListProtector.add(r10, 1, a.a(r13, this.a.p(), "last_msg_show_topic", com.larus.bmhome.chat.bean.d.X(r13)));
        goto L55
    L31:
        if (r5.intValue() != 1) goto L34;
        if (com.larus.bmhome.chat.bean.d.x(r13).getWcbTitleStyle() == 1) goto L55;
    L18:
        if (com.larus.bmhome.chat.bean.d.x(r13).isWelcomeBackMessageHidden() != true) goto L20;
        r2 = true;
        goto L22
    L11:
        r13 = null;
        goto L12
    L5:
        if (td8.c.a.a((e) this.b.getValue(), 0, null, null, r10, 7) == false) goto L8;
        return td8.c.a.b((e) this.b.getValue(), 0, r10, 7);
    }
}

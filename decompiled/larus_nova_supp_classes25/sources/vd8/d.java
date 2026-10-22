package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    public d(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return Intrinsics.areEqual(this.a.extraInfo().get("show_ai_generated_footer"), Boolean.TRUE);
    }

    @Override // td8.c
    public final List<xc8.b> b(int r62, xc8.b r63, xc8.b r64, List<xc8.b> r65) {
        Intrinsics.checkNotNullParameter(r64, "current");
        Intrinsics.checkNotNullParameter(r65, "input");
        Iterator<T> r1 = r65.iterator();
    L3:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if ((!b0.f(((xc8.b) r2).getMessage())) == false) goto L3;
    L9:
        xc8.b r4 = (xc8.b) r2;
        if (r4 == null) goto L30;
        Message r5 = r4.getMessage();
        if (r5 == null) goto L30;
        if (com.larus.bmhome.chat.bean.d.G0(r5) == false) goto L17;
    L27:
        r3 = false;
    L28:
        if (r3 == false) goto L30;
        FLogger.a.i("Pipeline_List_AiDisclaimerTask", "add ai disclaimer for message id: " + r5.getMessageId());
        String r26 = com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.a.getApplication().getString(2131899692), null, null, null, null, null, null, null, DoraCallStateCode.DOUBAO_STOP_CALL_BY_SPRING_DEGRADE, null), TextContent.Companion.serializer());
        ListProtector.add(r65, 0, new cg8.c(b0.j(new Message(r5.getConversationId(), null, null, 0, 21, null, 1001, false, null, r26, null, null, null, null, null, r5.getMessageId() + "-ai-disclaimer", r5.getLocalIndex() - 1, 0, false, r5.getSectionId(), null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 13)));
        goto L30
    L17:
        if (com.larus.bmhome.chat.bean.d.W0(r5) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.k0(r5) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.z0(r5) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.j0(r5) == false) goto L27;
        if (com.larus.bmhome.chat.bean.d.Q0(r5) == true) goto L27;
    L30:
        return r65;
    L8:
        r2 = null;
        goto L9
    }
}

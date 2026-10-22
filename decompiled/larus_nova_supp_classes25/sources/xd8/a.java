package xd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.z2;
import com.larus.platform.service.n0;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements td8.c {
    public final td8.d a;

    /* JADX INFO: renamed from: xd8.a$a, reason: collision with other inner class name */
    public static final class C0095a {
    }

    static {
    }

    public a(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r5, xc8.b r6, xc8.b r7, List<? extends xc8.b> r8) {
        Intrinsics.checkNotNullParameter(r7, "current");
        Intrinsics.checkNotNullParameter(r8, "input");
        Message r9 = r7.getMessage();
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L9;
        z2 r11 = r10.O();
        if (r11 == null) goto L9;
        if (r11.a(r9) != true) goto L9;
        boolean r12 = true;
    L11:
        if (r12 == false) goto L15;
        FLogger.a.i("Pipeline_List_FilterTask", "filter message by outer filter type=" + r9.getContentType());
        return true;
    L15:
        if (com.larus.bmhome.chat.bean.d.i0(r9) == false) goto L20;
        if (com.larus.bmhome.chat.bean.d.w(r9) == true) goto L20;
    L39:
        boolean r13 = false;
    L41:
        if (r13 == true) goto L44;
        FLogger.a.i("Pipeline_List_FilterTask", "hide invisible message, messageId = " + r9.getMessageId() + ", localMessageId = " + r9.getLocalMessageId());
        return true;
    L44:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (com.larus.bmhome.chat.bean.d.z0(r9) == true) goto L47;
    L49:
        boolean r14 = false;
    L50:
        if (r14 == false) goto L69;
        if (n0.a.b() == false) goto L56;
        if (com.larus.bmhome.chat.bean.d.k0(r9) == false) goto L56;
    L66:
        FLogger.a.i("Pipeline_List_FilterTask", "hide firstMet message, messageId = " + r9.getMessageId() + ", localMessageId = " + r9.getLocalMessageId());
        return true;
    L56:
        if (com.larus.bmhome.chat.bean.d.Y0(r9) == true) goto L69;
        if (IAIChatUgcAIGCService.a.y0() == false) goto L69;
        wc9.e r15 = this.a.g();
        if (r15 != null) goto L62;
    L64:
        boolean r16 = false;
    L65:
        if (r16 == true) goto L69;
    L62:
        if (n.v(r15) == true) goto L64;
        r16 = true;
    L69:
        if (com.larus.bmhome.chat.bean.d.W0(r9) == false) goto L81;
        if (com.larus.bmhome.chat.bean.d.x(r9).isWelcomeBackMessageHidden() == false) goto L81;
        if (com.larus.bmhome.chat.bean.d.O0(r9) == true) goto L76;
        FLogger.a.i("Pipeline_List_FilterTask", "hide wcb message, messageId = " + r9.getMessageId() + ", localMessageId = " + r9.getLocalMessageId());
        return true;
    L76:
        if (r5 <= 0) goto L79;
        FLogger.a.i("Pipeline_List_FilterTask", "hide history wcb message, messageId = " + r9.getMessageId() + ", localMessageId = " + r9.getLocalMessageId());
        return true;
    L79:
        FLogger.a.d("Pipeline_List_FilterTask", "not hide wcb message, localMessageId = " + r9.getLocalMessageId());
    L81:
        if (com.larus.bmhome.chat.bean.d.m0(r9) == false) goto L84;
        FLogger.a.i("Pipeline_List_FilterTask", "hide illegal asr loading, messageId = " + r9.getMessageId() + ", localMessageId = " + r9.getLocalMessageId());
        return true;
    L84:
        return false;
    L47:
        if (r9.getContentType() != 2) goto L49;
        r14 = true;
    L20:
        if (com.larus.bmhome.chat.bean.d.T(r9) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.p0(r9) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.C0(r9) == true) goto L27;
    L29:
        MessageStatus r17 = r9.getMessageStatus();
        if (r17 != null) goto L32;
    L34:
        boolean r18 = false;
    L35:
        if (r18 == false) goto L37;
    L38:
        r13 = true;
        goto L41
    L37:
        if (b0.f(r9) == false) goto L39;
    L32:
        if (r17.isVisible() != true) goto L34;
        r18 = true;
        goto L35
    L27:
        if (r9.getRegenVisible() == true) goto L29;
    L9:
        r12 = false;
        goto L11
    }

    @Override // td8.c
    public final List<xc8.b> b(int r1, xc8.b r2, xc8.b r3, List<xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return new ArrayList();
    }
}

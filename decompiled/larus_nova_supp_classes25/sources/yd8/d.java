package yd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements td8.c {
    public static String b;
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    public d(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final Message c(List<? extends xc8.b> r7) {
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L32;
        Object r0 = r8.next();
        Message r2 = ((xc8.b) r0).getMessage();
        boolean r4 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r2) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r2) == true) goto L11;
    L30:
        if (r4 == false) goto L4;
    L33:
        xc8.b r1 = (xc8.b) r0;
        if (r1 != null) goto L36;
        return null;
    L36:
        return r1.getMessage();
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r2) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r2) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r2) == true) goto L18;
    L20:
        MessageStatus r3 = r2.getMessageStatus();
        if (r3 != null) goto L23;
    L25:
        boolean r5 = false;
    L26:
        if (r5 == false) goto L28;
    L29:
        r4 = true;
        goto L30
    L28:
        if (b0.f(r2) == false) goto L30;
    L23:
        if (r3.isVisible() != true) goto L25;
        r5 = true;
        goto L26
    L18:
        if (r2.getRegenVisible() == true) goto L20;
    L32:
        r0 = null;
        goto L33
    }

    @Override // td8.c
    public final boolean a(int r3, xc8.b r4, xc8.b r5, List<? extends xc8.b> r6) {
        Intrinsics.checkNotNullParameter(r5, "current");
        Intrinsics.checkNotNullParameter(r6, "input");
        Message r7 = c(r6);
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("lastMessage = ");
        Boolean r10 = null;
        if (r7 == null) goto L5;
        String r0 = r7.getMessageId();
    L6:
        r9.append(r0);
        r9.append(", initCheckMessageId = ");
        r9.append(b);
        r9.append(", pushContentId = ");
        r9.append(this.a.m());
        r9.append(", contentType = ");
        if (r7 == null) goto L9;
        Integer r1 = Integer.valueOf(r7.getContentType());
    L10:
        r9.append(r1);
        r9.append(", isWelcomeBackMessage = ");
        if (r7 == null) goto L13;
        r10 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r7));
    L13:
        r9.append(r10);
        r8.i("Pipeline_List_Update_PromptLoading_Task", r9.toString());
        if (r7 != null) goto L17;
        r8.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  lastMessage == null");
        return false;
    L17:
        String r2 = b;
        if (r2 != null) goto L20;
    L23:
        String r11 = this.a.m();
        if (r11 != null) goto L26;
    L29:
        boolean r12 = true;
    L30:
        if (r12 == false) goto L34;
        r8.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  pushContentId is null");
        return false;
    L34:
        if (com.larus.bmhome.chat.bean.d.W0(r7) == true) goto L38;
        r8.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not welcome back message");
        return false;
    L38:
        if (z2.a.enablePromptLoading() == true) goto L41;
        r8.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not enablePromptLoading");
        return false;
    L41:
        String r13 = b;
        if (r13 != null) goto L44;
        r13 = r7.getMessageId();
    L44:
        b = r13;
        return true;
    L26:
        if (r11.length() == 0) goto L29;
        r12 = false;
        goto L30
    L20:
        if (Intrinsics.areEqual(r2, r7.getMessageId()) == true) goto L23;
        r8.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not first check");
        return false;
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // td8.c
    public final List<xc8.b> b(int r1, xc8.b r2, xc8.b r3, List<xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        Message r5 = c(r4);
        if (r5 == null) goto L7;
        Map r6 = r5.getBusinessExt();
        if (r6 == null) goto L7;
        String r7 = (String) r6.put("ui_prompt_type", "loading");
    L7:
        return r4;
    }
}

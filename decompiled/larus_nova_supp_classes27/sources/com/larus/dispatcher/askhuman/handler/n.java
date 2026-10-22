package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.taskskill.k2;
import com.larus.bmhome.taskskill.l2;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public static final Set<Integer> a = null;
    public static final List<IQuickReplyClickInterceptor> b = null;
    public static final g c = null;

    static {
        a = SetsKt.setOf(new Integer[]{Integer.valueOf(ActionType.CUA_ASK_REPLY.getValue()), Integer.valueOf(ActionType.CUA_ASK_SKIP.getValue()), Integer.valueOf(ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue()), Integer.valueOf(ActionType.CUA_REQUEST_ACTION_SKIP.getValue()), Integer.valueOf(ActionType.CUA_WARN_ALLOW.getValue()), Integer.valueOf(ActionType.CUA_WARN_REFUSE.getValue()), Integer.valueOf(ActionType.CUA_ALWAYS_ALLOW.getValue()), Integer.valueOf(ActionType.CUA_AUTHORIZE_FOLDER_ALLOW.getValue()), Integer.valueOf(ActionType.CUA_AUTHORIZE_FOLDER_SELECT.getValue()), Integer.valueOf(ActionType.CUA_AUTHORIZE_FOLDER_REFUSE.getValue()), Integer.valueOf(ActionType.CUA_REQUEST_ACTION_PIP_OPERATION.getValue()), Integer.valueOf(ActionType.CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT.getValue())});
        b = new ArrayList();
        c = new g();
        b(new i());
        b(new a());
        b(new b());
        b(new RequestActionBrowserOperationInterceptor());
        b(new s());
        b(new q());
        b(new r());
        b(new v());
        b(new w());
        b(new c());
        b(new e());
        b(new d());
    }

    public static boolean a(k r25) {
        Intrinsics.checkNotNullParameter(r25, "interceptorContext");
        Iterator r1 = ((ArrayList) b).iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        IQuickReplyClickInterceptor r2 = (IQuickReplyClickInterceptor) r1.next();
        if (r2.e(r25) == false) goto L4;
        t r11 = h.f(r25);
        List r3 = l2.a;
        String r12 = l2.d(r25.e.b, null);
        FLogger.a.i("QuickReplyClickInterceptorManager", "[handleClick] handle with interceptor(" + r2.getClass().getSimpleName() + "), messageId: " + r25.d + ", actionType: " + r25.b.getActionType() + ", text: " + r25.b.getText() + ", toolCallId: " + r11.a + ", sandboxId: " + r11.b + ", pcDeviceId: " + r12);
        QuickReplyItem r8 = r25.b;
        bs8.h r9 = r25.e;
        FragmentActivity r10 = r25.f;
        com.larus.platform.service.o r4 = com.larus.platform.service.o.a;
        if (r2.g(new o(r8, r9, r10, r11, r12, r4.getDeviceId(), r25.d, r25.a, r25.c, r25.g, r25.h, r25.i, r25.j, r25.k, r25.l)).b == false) goto L12;
        k r0 = r25;
        if (r0.i == false) goto L13;
        String r5 = r0.d;
        String r6 = r0.a;
        int r7 = r0.c;
        Intrinsics.checkNotNullParameter(r5, "messageId");
        zh8.a.a.r1(r5, new l(r6, r7));
    L13:
        int r13 = k2.a;
        String r14 = r0.b.getText();
        String r15 = r2.c();
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        JSONObject r16 = new JSONObject();
        r16.put("current_page", "chat");
        r16.put("button_name", r14);
        r16.put("request_type", r15);
        Unit r17 = Unit.INSTANCE;
        r4.reportEvent("in_task_share_folder_permission_option_click", r16);
        return true;
    L12:
        r0 = r25;
        goto L13
    L16:
        g r18 = c;
        if (r18.e(r25) == false) goto L19;
        QuickReplyItem r20 = r25.b;
        bs8.h r21 = r25.e;
        FragmentActivity r22 = r25.f;
        t r110 = h.f(r25);
        List r23 = l2.a;
        r18.g(new o(r20, r21, r22, r110, l2.d(r25.e.b, null), com.larus.platform.service.o.a.getDeviceId(), r25.d, r25.a, r25.g, r25.h, r25.i, r25.j, r25.k, r25.l, 256));
        return true;
    L19:
        FLogger.a.i("QuickReplyClickInterceptorManager", "[handleClick] no interceptor can handle, actionType=" + r25.b.getActionType());
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r24 = r25.h;
        if (r24 == null) goto L28;
        r24.invoke(com.larus.bmhome.taskskill.service.k.i.a);
        return false;
    L28:
        return false;
    }

    public static void b(IQuickReplyClickInterceptor r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ArrayList r0 = (ArrayList) b;
        if (r0.contains(r2) == false) goto L5;
        return;
    L5:
        r0.add(r2);
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        zh8.a.a.r1(r2, new m());
    }
}

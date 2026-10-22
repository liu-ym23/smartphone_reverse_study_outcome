package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.AuthScene;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ x(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r15) {
        ChatListComponent r0 = this.a;
        Message r7 = (Message) r15;
        int r16 = ChatListComponent.W3;
        if (r7 == null) goto L61;
        if (Intrinsics.areEqual(r0.G4(), r7.getConversationId()) == false) goto L61;
        if (VoiceCallConfigServiceDelegate.b.l() == true) goto L65;
        if (r0.U5().isInDoraCallAndMsgFromVUI(d.G(r7)) == true) goto L65;
        String r17 = d.G(r7);
        if (r17 == null) goto L63;
        JSONObject r1 = new JSONObject(r17);     // Catch: JSONException -> L56
        String r9 = r7.getMessageId();     // Catch: JSONException -> L56
        String r10 = r1.optString("popup_text");     // Catch: JSONException -> L56
        String r13 = r1.optString("jump_url");     // Catch: JSONException -> L56
        String r11 = r1.optString("plugin_id");     // Catch: JSONException -> L56
        com.larus.bmhome.chat.component.cvs.y r18 = r0.u0();     // Catch: JSONException -> L56
        String r2 = null;
        if (r18 == null) goto L19;
        String r19 = r18.getBotId();     // Catch: JSONException -> L56
    L21:
        if (r19 != null) goto L23;
        String r12 = "";
    L24:
        com.larus.platform.api.g r110 = new com.larus.platform.api.g(r9, r10, r11, r12, r13);     // Catch: JSONException -> L56
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: JSONException -> L56
        if (r3 == null) goto L29;
        r3.K0();     // Catch: JSONException -> L56
        com.larus.platform.api.f r4 = com.larus.music.i.a.g(r110);     // Catch: JSONException -> L56
    L31:
        if (r4.e != AuthScene.LocalLife) goto L35;
        IAiChatOpenDouyinAuthService r5 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);     // Catch: JSONException -> L56
        if (r5 == null) goto L64;
        r5.n(r4.a, r4.b, r4.c, r4.d, new e6(r0, r110, r4));     // Catch: JSONException -> L56
    L64:
        return Unit.INSTANCE;
    L35:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: JSONException -> L56
        if (r6 == null) goto L64;
        r6.K0();     // Catch: JSONException -> L56
        com.larus.music.i r14 = com.larus.music.i.a;
        String r8 = r110.d;     // Catch: JSONException -> L56
        if (r8 != null) goto L42;
        r8 = "";
    L42:
        IAiChatOpenDouyinAuthService r20 = r0.V4();     // Catch: JSONException -> L56
        if (r20 == null) goto L47;
        Message r21 = r20.i();     // Catch: JSONException -> L56
        if (r21 == null) goto L47;
        r2 = r21.getMessageId();     // Catch: JSONException -> L56
    L47:
        if (r2 != null) goto L49;
        String r22 = "";
    L50:
        String r111 = r110.e;     // Catch: JSONException -> L56
        if (r111 != null) goto L53;
        String r23 = "";
    L54:
        r14.j(new com.larus.platform.api.j5(r8, false, true, r22, r23, r7, r4.e, null, null, 384));     // Catch: JSONException -> L56
        goto L64
    L53:
        r23 = r111;
        goto L54
    L49:
        r22 = r2;
        goto L50
    L29:
        r4 = new com.larus.platform.api.f(null, null, 31);     // Catch: JSONException -> L56
        goto L31
    L23:
        r12 = r19;
        goto L24
    L19:
        r19 = null;
    L56:
        e = move-exception;
        FLogger.a.e(r0.n, "fails to handle auth_info", e);
        goto L64
    L63:
        return Unit.INSTANCE;
    L65:
        return Unit.INSTANCE;
    L61:
        return Unit.INSTANCE;
    }
}

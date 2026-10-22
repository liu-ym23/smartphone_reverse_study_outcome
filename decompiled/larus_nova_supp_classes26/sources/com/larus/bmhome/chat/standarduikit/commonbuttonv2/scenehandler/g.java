package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g extends c {
    public final String a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/standarduikit/commonbuttonv2/scenehandler/CreateAvatarSceneHandler$needHideButton$relyInfo$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<wj8.b> {
        public b() {
        }
    }

    static {
    }

    public g() {
        this.a = "create_avatar_with_reply_blocked_creation";
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        Message r2 = r6.i;
        if (r2 == null) goto L5;
        String r3 = r2.getMessageId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        r1.put("button_style", "button");
        r1.put("button_type", "create_replica");
        String r7 = r6.a;
        if (r7 == null) goto L13;
        r4 = r7;
    L13:
        r1.put("button_content", r4);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("chat_ai_creation_button_click", r1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void b(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Intrinsics.checkNotNullParameter(r5, "vmData");
        Message r0 = r5.i;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("common_button_v2_scene_create_avatar");
    L8:
        if (r3 != null) goto L20;
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[onBindData]: identify message(");
        Message r7 = r5.i;
        if (r7 == null) goto L12;
        String r8 = r7.getMessageId();
    L13:
        r6.append(r8);
        r6.append(") as Create Avatar Button Message");
        r4.i("CreateAvatarSceneHandler", r6.toString());
        IChatRepoService r9 = zh8.a.a;
        Message r10 = r5.i;
        if (r10 == null) goto L16;
        r1 = r10.getLocalMessageId();
    L16:
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        r9.r1(r1, new f());
        return;
    L12:
        r8 = null;
        goto L13
    L20:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r9) {
        Intrinsics.checkNotNullParameter(r9, "vmData");
        Message r0 = r9.i;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("common_button_v2_hidden");
    L8:
        boolean r4 = Intrinsics.areEqual(r3, "true");
        Message r5 = r9.i;
        if (r5 == null) goto L13;
        Map r6 = r5.getBusinessExt();
        if (r6 == null) goto L13;
        String r7 = (String) r6.get("button_create_avatar_hidden");
    L14:
        boolean r8 = Intrinsics.areEqual(r7, "true");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L21
        Gson r11 = new Gson();     // Catch: Throwable -> L21
        Map<String, String> r12 = r9.h;     // Catch: Throwable -> L21
        if (r12 == null) goto L18;
        String r13 = r12.get("creation_btn_rely_info");     // Catch: Throwable -> L21
    L19:
        Object r14 = Result.constructor-impl((wj8.b) r11.fromJson(r13, new b().getType()));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r14) == false) goto L26;
        r14 = null;
    L26:
        wj8.b r15 = (wj8.b) r14;
        Function1<String, Boolean> r16 = r9.n;
        if (r16 == null) goto L36;
        if (r15 == null) goto L32;
        Long r17 = r15.c();
        if (r17 == null) goto L32;
        String r18 = r17.toString();
    L34:
        if (((Boolean) r16.invoke(r18)).booleanValue() != true) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == true) goto L52;
        Function1<String, Boolean> r20 = r9.n;
        if (r20 == null) goto L49;
        if (r15 == null) goto L47;
        List<Long> r21 = r15.a();
        if (r21 == null) goto L47;
        Long r22 = (Long) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L47;
        r1 = r22.toString();
    L47:
        if (((Boolean) r20.invoke(r1)).booleanValue() != true) goto L49;
        boolean r23 = true;
    L50:
        if (r23 == true) goto L52;
        boolean r24 = true;
    L53:
        if (r4 == true) goto L56;
        if (r8 == true) goto L56;
        if (r24 == true) goto L56;
        return false;
    L56:
        return true;
    L49:
        r23 = false;
    L52:
        r24 = false;
    L32:
        r18 = null;
    L36:
        r19 = false;
        goto L37
    L18:
        r13 = null;
    L21:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        Message r2 = r6.i;
        if (r2 == null) goto L5;
        String r3 = r2.getMessageId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        r1.put("button_style", "button");
        r1.put("button_type", "create_replica");
        String r7 = r6.a;
        if (r7 == null) goto L13;
        r4 = r7;
    L13:
        r1.put("button_content", r4);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("chat_ai_creation_button_show", r1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void h(com.bytedance.router.i r6, com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r7) {
        Intrinsics.checkNotNullParameter(r6, "route");
        Intrinsics.checkNotNullParameter(r7, "vmData");
        Bundle r0 = new Bundle();
        Map<String, String> r1 = r7.h;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.get("creation_btn_rely_info");
    L6:
        r0.putString("creation_btn_rely_info", r3);
        wc9.e r4 = r7.k;
        if (r4 == null) goto L9;
        String r5 = r4.a;
    L10:
        r0.putString("argConversationId", r5);
        Message r8 = r7.i;
        if (r8 == null) goto L13;
        String r9 = r8.getLocalMessageId();
    L14:
        r0.putString("local_message_id", r9);
        r0.putString("enter_method", "chat_avatar2video_button");
        r0.putString("scene", "video_gen_request_after_avatar");
        r6.g(r0);
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("appendRouteParams: ");
        Map<String, String> r12 = r7.h;
        if (r12 == null) goto L17;
        r2 = r12.get("creation_btn_rely_info");
    L17:
        r11.append(r2);
        r10.i("CreateAvatarSceneHandler", r11.toString());
        return;
    L13:
        r9 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}

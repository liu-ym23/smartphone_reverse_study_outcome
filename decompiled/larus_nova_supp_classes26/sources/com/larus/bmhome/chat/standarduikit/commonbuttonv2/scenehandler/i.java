package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

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
public final class i extends c {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/standarduikit/commonbuttonv2/scenehandler/GenVideoSceneHandler$needHideButton$relyInfo$1$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/CreationBtnReplayInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<wj8.b> {
        public b() {
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return "gen_video_by_downgraded_model";
    }

    public i() {
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        Integer r0 = r6.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 3) goto L23;
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        Message r3 = r6.i;
        if (r3 == null) goto L10;
        String r4 = r3.getMessageId();
    L11:
        String r5 = "";
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r2.put(MusicAppletPage.KEY_MESSAGE_ID, r4);
        r2.put("button_style", "button");
        int r7 = wj8.a.a;
        String r8 = wj8.a.a(r6.g);
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r2.put("button_type", r8);
        String r9 = r6.a;
        if (r9 == null) goto L21;
        r5 = r9;
    L21:
        r2.put("button_content", r5);
        Unit r10 = Unit.INSTANCE;
        r1.reportEvent("chat_ai_creation_button_click", r2);
        return;
    L10:
        r4 = null;
        goto L11
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
        String r3 = (String) r2.get("common_button_v2_scene_gen_video");
    L8:
        if (r3 != null) goto L20;
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[onBindData]: identify message(");
        Message r7 = r5.i;
        if (r7 == null) goto L12;
        String r8 = r7.getMessageId();
    L13:
        r6.append(r8);
        r6.append(") as Gen Video Button Message");
        r4.i("GenVideoSceneHandler", r6.toString());
        IChatRepoService r9 = zh8.a.a;
        Message r10 = r5.i;
        if (r10 == null) goto L16;
        r1 = r10.getLocalMessageId();
    L16:
        if (r1 != null) goto L18;
        r1 = "";
    L18:
        r9.r1(r1, new h());
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
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r10) {
        Intrinsics.checkNotNullParameter(r10, "vmData");
        Message r0 = r10.i;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("common_button_v2_clicked");
    L8:
        boolean r4 = Intrinsics.areEqual(r3, "true");
        Message r5 = r10.i;
        if (r5 == null) goto L13;
        Map r6 = r5.getBusinessExt();
        if (r6 == null) goto L13;
        String r7 = (String) r6.get("common_button_v2_hidden");
    L14:
        boolean r8 = Intrinsics.areEqual(r7, "true");
        Message r9 = r10.i;
        if (r9 == null) goto L19;
        Map r11 = r9.getBusinessExt();
        if (r11 == null) goto L19;
        String r12 = (String) r11.get("button_gen_video_hidden");
    L20:
        boolean r13 = Intrinsics.areEqual(r12, "true");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L27
        Gson r15 = new Gson();     // Catch: Throwable -> L27
        Map<String, String> r16 = r10.h;     // Catch: Throwable -> L27
        if (r16 == null) goto L24;
        String r17 = r16.get("creation_btn_rely_info");     // Catch: Throwable -> L27
    L25:
        Object r18 = Result.constructor-impl((wj8.b) r15.fromJson(r17, new b().getType()));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r18) == false) goto L32;
        r18 = null;
    L32:
        wj8.b r19 = (wj8.b) r18;
        Function1<String, Boolean> r20 = r10.n;
        if (r20 == null) goto L42;
        if (r19 == null) goto L38;
        Long r21 = r19.c();
        if (r21 == null) goto L38;
        String r22 = r21.toString();
    L40:
        if (((Boolean) r20.invoke(r22)).booleanValue() != true) goto L42;
        boolean r23 = true;
    L43:
        if (r23 == true) goto L58;
        Function1<String, Boolean> r110 = r10.n;
        if (r110 == null) goto L55;
        if (r19 == null) goto L53;
        List<Long> r24 = r19.a();
        if (r24 == null) goto L53;
        Long r25 = (Long) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L53;
        r1 = r25.toString();
    L53:
        if (((Boolean) r110.invoke(r1)).booleanValue() != true) goto L55;
        boolean r111 = true;
    L56:
        if (r111 == true) goto L58;
        boolean r112 = true;
    L59:
        if (r4 == true) goto L63;
        if (r8 == true) goto L63;
        if (r13 == true) goto L63;
        if (r112 == true) goto L63;
        return false;
    L63:
        return true;
    L55:
        r111 = false;
    L58:
        r112 = false;
    L38:
        r22 = null;
    L42:
        r23 = false;
        goto L43
    L24:
        r17 = null;
    L27:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        r12 = null;
    L13:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "vmData");
        Integer r0 = r6.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 3) goto L23;
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        Message r3 = r6.i;
        if (r3 == null) goto L10;
        String r4 = r3.getMessageId();
    L11:
        String r5 = "";
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r2.put(MusicAppletPage.KEY_MESSAGE_ID, r4);
        r2.put("button_style", "button");
        int r7 = wj8.a.a;
        String r8 = wj8.a.a(r6.g);
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r2.put("button_type", r8);
        String r9 = r6.a;
        if (r9 == null) goto L21;
        r5 = r9;
    L21:
        r2.put("button_content", r5);
        Unit r10 = Unit.INSTANCE;
        r1.reportEvent("chat_ai_creation_button_show", r2);
        return;
    L10:
        r4 = null;
        goto L11
    }
}

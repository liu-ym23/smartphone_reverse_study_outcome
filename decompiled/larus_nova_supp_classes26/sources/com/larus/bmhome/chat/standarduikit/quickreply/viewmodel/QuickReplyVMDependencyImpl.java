package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.commercemembership.api.ICommerceMembershipService$b;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class QuickReplyVMDependencyImpl implements c {
    public static final LruCache<String, String> b = null;
    public final CoroutineScope a;

    public static final class a {
    }

    static {
        b = new LruCache(100);
    }

    public QuickReplyVMDependencyImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.b(r2);
    }

    public static String f(QuickReplyItem r5, boolean r6) {
        String r7 = r5.getSchemaPayload();
        String r0 = null;
        if (r7 == null) goto L5;
        String r8 = StringsKt.trim(r7).toString();
    L6:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r1 = ICommerceMembershipService.a.a();
        if (r1 == null) goto L45;
        String r9 = r1.A(r8);
        if (r9 == null) goto L45;
        if (r6 == true) goto L48;
        String r10 = b.get(r9);
        if (r10 == null) goto L48;
        return r10;
    L48:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        Object r3 = Result.constructor-impl(UriProtector.parse(r9));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r3) == false) goto L22;
        r3 = null;
    L22:
        Uri r4 = (Uri) r3;
        if (r4 != null) goto L46;
    L42:
        String r11 = r9;
    L43:
        b.put(r9, r11);
        return r11;
    L46:
        Object r12 = Result.constructor-impl(UriProtector.getQueryParameter(r4, "subs_purchase_id"));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == false) goto L32;
        r12 = null;
    L32:
        String r13 = (String) r12;
        if (r13 == null) goto L42;
        if (r13.length() <= 0) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L40;
        r0 = r13;
    L40:
        if (r0 == null) goto L42;
        r11 = y0.g(r4, "subs_purchase_id", r0 + "_mills" + System.currentTimeMillis()).toString();
        goto L43
    L37:
        r14 = false;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        return null;
    L5:
        r8 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final Object e(b r18, Continuation<? super ReferenceInfo> r19) {
        if ((r19 instanceof QuickReplyVMDependencyImpl$buildReferenceInfo$1) == false) goto L7;
        QuickReplyVMDependencyImpl$buildReferenceInfo$1 r1 = (QuickReplyVMDependencyImpl$buildReferenceInfo$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        String r5 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        ?? r6 = r5;
    L43:
        ReferenceInfo r7 = ((ReferenceMessage) r0).getReferenceInfo();
        if (r7 != null) goto L53;
        ?? r9 = r6;
    L48:
        if (r9 != 0) goto L50;
        return null;
    L50:
        return new ReferenceInfo(null, null, r9, 0, null, null, null, null, 251, null);
    L53:
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r8 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L18
        r4 = r8;
    L30:
        Object r10 = Result.constructor-impl((Message) r0);     // Catch: Throwable -> L18
        ?? r11 = r4;
    L34:
        if (Result.isFailure-impl(r10) == false) goto L36;
        r10 = null;
    L36:
        Message r12 = (Message) r10;
        ?? r13 = r11;
    L38:
        if (r12 == null) goto L47;
        ReferenceMessage.Companion r14 = ReferenceMessage.Companion;
        r1.L$0 = r13;
        r1.label = 2;
        r0 = r14.b(r12, null, r1);
        if (r0 != r3) goto L42;
        return r3;
    L42:
        r6 = r13;
        goto L43
    L47:
        r9 = r13;
        goto L48
    L20:
        ResultKt.throwOnFailure(r0);
        String r15 = r18.b;
        if (r15 != null) goto L23;
    L25:
        String r16 = null;
    L26:
        if (r16 == null) goto L37;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L18
        IChatRepoService r20 = zh8.a.a;     // Catch: Throwable -> L18
        r1.L$0 = r16;     // Catch: Throwable -> L18
        r1.label = 1;     // Catch: Throwable -> L18
        r0 = r20.E1(r16, r1);     // Catch: Throwable -> L18
        r4 = r16;
        if (r0 != r3) goto L30;
        return r3;
    L37:
        r12 = null;
        r13 = r16;
        goto L38
    L23:
        if ((!StringsKt.isBlank(r15)) == false) goto L25;
        r16 = r15;
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        r11 = r4;
    L7:
        r1 = new QuickReplyVMDependencyImpl$buildReferenceInfo$1(this, r19);
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void a(b r25, QuickReplyItem r26, int r27) {
        Intrinsics.checkNotNullParameter(r25, "vmData");
        Intrinsics.checkNotNullParameter(r26, "item");
        int r4 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.a;
        Intrinsics.checkNotNullParameter(r25, "vmData");
        Intrinsics.checkNotNullParameter(r26, "item");
        JSONObject r2 = new JSONObject();
        String r3 = r25.b;
        String r5 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        String r6 = r25.c;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r2.put("bot_id", r6);
        r2.put("sug_card_type", "inner_message_button");
        long r7 = r25.e;
        long r8 = 0;
        if (r7 <= 0) goto L12;
        r8 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r7, 0);
    L12:
        r2.put("load_sug_time", String.valueOf(r8));
        Map r9 = r26.getExtraParams();
        String r10 = null;
        if (r9 == null) goto L15;
        String r11 = (String) r9.get("item_id");
    L16:
        r2.put("item_id", r11);
        String r12 = r26.getText();
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r2.put("item_content", r12);
        r2.put("prompt_position", r27);
        String r13 = r25.d;
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        boolean r14 = false;
        if (r13.length() != 0) goto L25;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L29;
        r13 = "chat";
    L29:
        r2.put("current_page", r13);
        Map r16 = r26.getExtraParams();
        if (r16 == null) goto L44;
        String r17 = (String) r16.get(MusicAppletPage.KEY_SOURCE);
        if (r17 == null) goto L44;
        String r18 = StringsKt.trim(r17).toString();
        if (r18 == null) goto L44;
        if (r18.length() <= 0) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == true) goto L42;
        r18 = null;
    L42:
        if (r18 == null) goto L44;
        r2.put("suggested_type", r18);
        goto L44
    L38:
        r19 = false;
    L44:
        o r20 = o.a;
        r20.reportEvent("show_suggested_prompt_single_question", r2);
        String r110 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.a(r25);
        if (r110 == null) goto L59;
        String r0 = r26.getText();
        if (r0 == null) goto L57;
        String r1 = StringsKt.trim(r0).toString();
        if (r1 == null) goto L57;
        if (r1.length() <= 0) goto L54;
        boolean r21 = true;
    L55:
        if (r21 == false) goto L57;
        String r111 = r1;
    L58:
        x1.f(r110, "query_suggest", "query_suggest_button", r111, null, null, 112);
        goto L59
    L54:
        r21 = false;
    L57:
        r111 = null;
    L59:
        Map r22 = r26.getExtraParams();
        if (r22 == null) goto L62;
        String r23 = (String) r22.get(MusicAppletPage.KEY_SOURCE);
    L64:
        if (Intrinsics.areEqual(r23, "cta_button") == false) goto L113;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r112 = ICommerceMembershipService.a.a();
        if (r112 == null) goto L113;
        String r24 = f(r26, true);
        if (r24 == null) goto L113;
        uz8.c r28 = r112.z(r24);
        if (r28 == null) goto L75;
        String r29 = r28.a;
    L77:
        if (o0.d(r29) == false) goto L81;
        if (r28 == null) goto L80;
        String r30 = r28.a;
    L82:
        String r113 = r30;
    L84:
        if (r28 == null) goto L86;
        String r114 = r28.b;
    L87:
        if (r28 == null) goto L89;
        String r115 = r28.c;
    L90:
        if (r28 == null) goto L92;
        String r116 = r28.d;
    L93:
        if (r28 == null) goto L95;
        String r117 = r28.f;
    L97:
        if (r28 == null) goto L99;
        String r118 = r28.e;
    L100:
        if (r28 == null) goto L102;
        String r119 = r28.j;
    L103:
        if (r28 == null) goto L105;
        String r210 = r28.k;
    L106:
        if (r28 == null) goto L108;
        String r211 = r28.l;
    L109:
        if (r28 == null) goto L111;
        String r212 = r28.m;
    L112:
        ICommerceMembershipService$b.b(r112, r113, "chat", r114, r115, r116, r117, null, r118, r119, r210, r211, r212, 64);
        goto L113
    L111:
        r212 = null;
        goto L112
    L108:
        r211 = null;
        goto L109
    L105:
        r210 = null;
        goto L106
    L102:
        r119 = null;
        goto L103
    L99:
        r118 = null;
        goto L100
    L95:
        r117 = null;
        goto L97
    L92:
        r116 = null;
        goto L93
    L89:
        r115 = null;
        goto L90
    L86:
        r114 = null;
        goto L87
    L80:
        r113 = null;
        goto L84
    L81:
        r30 = "answer_quota_limit";
        goto L82
    L75:
        r29 = null;
    L113:
        Integer r31 = r26.getActionType();
        int r32 = ActionType.CUA_ASK_REPLY.getValue();
        if (r31 != null) goto L117;
    L118:
        int r33 = ActionType.CUA_ASK_SKIP.getValue();
        if (r31 != null) goto L122;
    L124:
        int r34 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        if (r31 != null) goto L128;
    L129:
        int r35 = ActionType.CUA_REQUEST_ACTION_SKIP.getValue();
        if (r31 != null) goto L133;
    L134:
        int r36 = ActionType.CUA_REQUEST_ACTION_PIP_OPERATION.getValue();
        if (r31 != null) goto L138;
    L139:
        int r37 = ActionType.CUA_REQUEST_ACTION_PIP_SANDBOX_ENV_INIT.getValue();
        if (r31 != null) goto L143;
    L145:
        int r38 = ActionType.CUA_WARN_ALLOW.getValue();
        if (r31 != null) goto L149;
    L150:
        int r39 = ActionType.CUA_WARN_REFUSE.getValue();
        if (r31 != null) goto L154;
    L155:
        int r40 = ActionType.CUA_ALWAYS_ALLOW.getValue();
        if (r31 != null) goto L159;
    L161:
        int r41 = ActionType.CUA_AUTHORIZE_FOLDER_ALLOW.getValue();
        if (r31 != null) goto L165;
    L166:
        int r42 = ActionType.CUA_AUTHORIZE_FOLDER_SELECT.getValue();
        if (r31 != null) goto L170;
    L171:
        int r43 = ActionType.CUA_AUTHORIZE_FOLDER_REFUSE.getValue();
        if (r31 != null) goto L175;
    L181:
        if (r5.length() <= 0) goto L183;
        r14 = true;
    L183:
        if (r14 == false) goto L185;
        r10 = r5;
    L185:
        if (r10 == null) goto L189;
        JSONObject r44 = new JSONObject();
        r44.put("current_page", "chat");
        r44.put("button_name", r26.getText());
        r44.put("request_type", r10);
        Unit r45 = Unit.INSTANCE;
        r20.reportEvent("in_task_share_folder_permission_option_show", r44);
        return;
    L189:
        return;
    L175:
        if (r31.intValue() != r43) goto L181;
    L176:
        r5 = "interaction.authorize_folder";
        goto L181
    L170:
        if (r31.intValue() == r42) goto L176;
    L165:
        if (r31.intValue() == r41) goto L176;
    L159:
        if (r31.intValue() != r40) goto L161;
    L177:
        r5 = "interaction.warn";
        goto L181
    L154:
        if (r31.intValue() == r39) goto L177;
    L149:
        if (r31.intValue() == r38) goto L177;
    L143:
        if (r31.intValue() != r37) goto L145;
    L178:
        r5 = "interaction.request_action";
        goto L181
    L138:
        if (r31.intValue() == r36) goto L178;
    L133:
        if (r31.intValue() == r35) goto L178;
    L128:
        if (r31.intValue() == r34) goto L178;
    L122:
        if (r31.intValue() != r33) goto L124;
    L179:
        r5 = "interaction.ask";
        goto L181
    L117:
        if (r31.intValue() == r32) goto L179;
    L62:
        r23 = null;
        goto L64
    L25:
        r15 = false;
        goto L27
    L15:
        r11 = null;
        goto L16
    }

    public static final Object d(QuickReplyVMDependencyImpl r25, b r26, QuickReplyItem r27, Continuation r28) {
        b r1 = r26;
        r25.getClass();
        if ((r28 instanceof QuickReplyVMDependencyImpl$sendQuickReply$1) == false) goto L7;
        QuickReplyVMDependencyImpl$sendQuickReply$1 r3 = (QuickReplyVMDependencyImpl$sendQuickReply$1) r28;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r0 = r3.I$0;
        MessageStatus r7 = (MessageStatus) r3.L$6;
        Map r8 = (Map) r3.L$5;
        String r9 = (String) r3.L$4;
        String r10 = (String) r3.L$3;
        String r11 = (String) r3.L$2;
        u1 r12 = (u1) r3.L$1;
        b r13 = (b) r3.L$0;
        ResultKt.throwOnFailure(r2);
        MessageStatus r14 = r7;
        r1 = r13;
        Map r15 = r8;
        String r16 = r9;
        String r17 = r10;
        u1 r18 = r12;
    L59:
        if (r0 == 0) goto L61;
        boolean r19 = true;
    L62:
        u1.a.f(r18, r11, r17, r16, r15, null, r14, null, r19, (ReferenceInfo) r2, "sendFuncChannel", null, r1.j, null, false, 27048);
        return Unit.INSTANCE;
    L61:
        r19 = false;
        goto L62
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        String r20 = r27.getText();
        if (r20 == null) goto L65;
        String r21 = StringsKt.trim(r20).toString();
        if (r21 == null) goto L65;
        if (r21.length() <= 0) goto L21;
        boolean r22 = true;
    L22:
        Integer r23 = null;
        if (r22 == false) goto L25;
        r11 = r21;
    L26:
        if (r11 == null) goto L65;
        String r24 = r1.a;
        if (r24 == null) goto L67;
        if ((!StringsKt.isBlank(r24)) == true) goto L34;
        r24 = null;
    L34:
        if (r24 == null) goto L67;
        u1 r110 = zh8.a.a.u1();
        Map r29 = r27.getExtraParams();
        if (r29 != null) goto L39;
        r29 = MapsKt.emptyMap();
    L39:
        Map r30 = MapsKt.toMutableMap(r29);
        QuickReplyBlock r111 = r1.i;
        if (r111 == null) goto L42;
        r23 = r111.getScene();
    L42:
        int r112 = QuickReplyScene.SCENE_ANSWER_POST_OPTION.getValue();
        if (r23 != null) goto L46;
    L48:
        int r113 = QuickReplyScene.SCENE_ASWEER_INNER_OPTION.getValue();
        if (r23 != null) goto L52;
    L54:
        MessageStatus r31 = MessageStatus.MessageStatus_AVAILABLE;
        r3.L$0 = r1;
        r3.L$1 = r110;
        r3.L$2 = r11;
        r3.L$3 = r24;
        r16 = "quick_reply";
        r3.L$4 = "quick_reply";
        r3.L$5 = r30;
        r3.L$6 = r31;
        r3.I$0 = 0;
        r3.label = 1;
        Object r32 = r25.e(r1, r3);
        if (r32 == r5) goto L68;
        r15 = r30;
        r14 = r31;
        r18 = r110;
        r17 = r24;
        r2 = r32;
        r0 = 0;
        goto L59
    L68:
        return r5;
    L52:
        if (r23.intValue() != r113) goto L54;
        r30.put("is_from_click_softlink", "true");
        goto L54
    L46:
        if (r23.intValue() != r112) goto L48;
        r30.put("is_from_click_option", "true");
    L67:
        return Unit.INSTANCE;
    L25:
        r11 = null;
        goto L26
    L21:
        r22 = false;
    L65:
        return Unit.INSTANCE;
    L7:
        r3 = new QuickReplyVMDependencyImpl$sendQuickReply$1(r25, r28);
        goto L8
    }

    @Override // com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c
    public final void b(b r10, QuickReplyItem r11, int r12, Context r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "vmData");
        Intrinsics.checkNotNullParameter(r11, "item");
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.c(r10, r11, r12);
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r1 = r10.g;
        if (r1 == null) goto L5;
        Boolean r15 = (Boolean) r1.invoke(r10.b, r10.i, r10.k, r11, Integer.valueOf(r12), Integer.valueOf(r14));
    L7:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L9;
        return;
    L9:
        Integer r16 = r11.getActionType();
        boolean r17 = false;
        if (r16 == null) goto L25;
        int r18 = r16.intValue();
        String r2 = r11.getSchemaPayload();
        if (r2 == null) goto L14;
        String r3 = StringsKt.trim(r2).toString();
    L16:
        if (r18 < ActionType.OPERATION.getValue()) goto L25;
        if (r3 != null) goto L19;
    L22:
        boolean r19 = true;
    L23:
        if (r19 == true) goto L25;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L64;
        String r111 = r11.getSchemaPayload();
        if (r111 == null) goto L31;
        String r112 = StringsKt.trim(r111).toString();
    L32:
        if (r112 != null) goto L34;
    L37:
        boolean r4 = true;
    L39:
        if (r4 == true) goto L59;
        if (r13 == null) goto L59;
        Map r5 = r11.getExtraParams();
        if (r5 == null) goto L45;
        String r6 = (String) r5.get(MusicAppletPage.KEY_SOURCE);
    L47:
        if (Intrinsics.areEqual(r6, "cta_button") == false) goto L56;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r7 = ICommerceMembershipService.a.a();
        if (r7 == null) goto L56;
        String r8 = f(r11, false);
        if (r8 == null) goto L56;
        SmartRouter.buildRoute(r13, r8).d();
        r7.w(r8, null);
        r17 = true;
    L56:
        if (r17 == false) goto L58;
        FLogger.a.i("QuickReplyVMDependency", "open membership url, msgId=" + r10.b + ", actionType=" + r11.getActionType());
        return;
    L58:
        FLogger.a.i("QuickReplyVMDependency", "open url, msgId=" + r10.b + ", actionType=" + r11.getActionType());
        SmartRouter.buildRoute(r13, r112).d();
        return;
    L45:
        r6 = null;
    L59:
        FLogger r113 = FLogger.a;
        StringBuilder r0 = new StringBuilder("skip open url, msgId=");
        r0.append(r10.b);
        r0.append(", actionType=");
        r0.append(r11.getActionType());
        r0.append(", hasContext=");
        if (r13 == null) goto L62;
        r17 = true;
    L62:
        r0.append(r17);
        r113.i("QuickReplyVMDependency", r0.toString());
        return;
    L34:
        if (r112.length() == 0) goto L37;
        r4 = false;
        goto L39
    L31:
        r112 = null;
        goto L32
    L64:
        Integer r114 = r11.getActionType();
        int r115 = ActionType.SEND_NEW_MSG.getValue();
        if (r114 != null) goto L68;
    L69:
        int r116 = ActionType.SEND_NEW_MSG_WITH_REPLY.getValue();
        if (r114 != null) goto L73;
    L75:
        FLogger.a.i("QuickReplyVMDependency", "unsupported actionType=" + r11.getActionType());
        return;
    L73:
        if (r114.intValue() != r116) goto L75;
    L76:
        BuildersKt.launch$default(this.a, null, null, new QuickReplyVMDependencyImpl$onItemClick$1(this, r10, r11, null), 3, null);
        return;
    L68:
        if (r114.intValue() == r115) goto L76;
    L19:
        if (r3.length() == 0) goto L22;
        r19 = false;
        goto L23
    L14:
        r3 = null;
    L25:
        r110 = false;
        goto L27
    L5:
        r15 = null;
        goto L7
    }
}

package com.larus.community.impl.detail.bottomtools;

import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.s3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsComponent$handleLikeAction$1", f = "CreationDetailBottomToolsComponent.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailBottomToolsComponent$handleLikeAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $doubleTap;
    int label;
    final /* synthetic */ CreationDetailBottomToolsComponent this$0;

    public CreationDetailBottomToolsComponent$handleLikeAction$1(CreationDetailBottomToolsComponent r1, boolean r2, Continuation<? super CreationDetailBottomToolsComponent$handleLikeAction$1> r3) {
        this.this$0 = r1;
        this.$doubleTap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDetailBottomToolsComponent$handleLikeAction$1(this.this$0, this.$doubleTap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r46) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r46);
    L274:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r46);
        CreationDetailBottomToolsComponent r1 = this.this$0;
        int r4 = CreationDetailBottomToolsComponent.v;
        String r23 = "double_tap";
        if (((CreationLikeState) r1.p3().getState()).getLiked() == false) goto L137;
        j29.a r3 = this.this$0.Y2();
        if (r3 == null) goto L15;
        zp9.g r5 = r3.a;
        if (r5 == null) goto L15;
        String r6 = r5.c;
    L16:
        j29.a r10 = this.this$0.Y2();
        if (r10 == null) goto L21;
        zp9.g r11 = r10.a;
        if (r11 == null) goto L21;
        String r12 = r11.j;
    L22:
        j29.a r13 = this.this$0.Y2();
        if (r13 == null) goto L27;
        zp9.g r14 = r13.a;
        if (r14 == null) goto L27;
        String r15 = r14.a;
    L28:
        j29.a r16 = this.this$0.Y2();
        if (r16 == null) goto L33;
        zp9.g r17 = r16.a;
        if (r17 == null) goto L33;
        String r28 = r17.h;
    L34:
        j29.a r18 = this.this$0.Y2();
        if (r18 == null) goto L39;
        zp9.g r110 = r18.a;
        if (r110 == null) goto L39;
        String r111 = r110.f;
    L40:
        j29.a r112 = this.this$0.Y2();
        if (r112 == null) goto L45;
        zp9.g r113 = r112.a;
        if (r113 == null) goto L45;
        String r30 = r113.d;
    L46:
        UserCreation r114 = this.this$0.m3();
        if (r114 == null) goto L49;
        String r115 = r114.a;
    L50:
        UserCreation r116 = this.this$0.m3();
        if (r116 == null) goto L53;
        String r32 = zp9.d.d(r116);
    L54:
        UserCreation r117 = this.this$0.m3();
        if (r117 == null) goto L59;
        UserCreationTrackParams r118 = r117.n;
        if (r118 == null) goto L59;
        String r119 = r118.a;
    L60:
        UserCreation r120 = this.this$0.m3();
        if (r120 == null) goto L63;
        String r34 = zp9.d.b(r120);
    L64:
        UserCreation r121 = this.this$0.m3();
        if (r121 == null) goto L69;
        Long r122 = r121.f;
        if (r122 == null) goto L69;
        Integer r123 = Boxing.boxInt((int) r122.longValue());
    L70:
        UserCreation r124 = this.this$0.m3();
        if (r124 == null) goto L75;
        UserCreationTrackParams r125 = r124.n;
        if (r125 == null) goto L75;
        Integer r126 = r125.b;
    L76:
        UserCreation r127 = this.this$0.m3();
        if (r127 == null) goto L81;
        AuthorInfo r128 = r127.g;
        if (r128 == null) goto L81;
        String r129 = r128.b;
    L82:
        j29.a r130 = this.this$0.Y2();
        if (r130 == null) goto L87;
        zp9.g r131 = r130.a;
        if (r131 == null) goto L87;
        String r132 = r131.i;
    L89:
        if (this.$doubleTap == true) goto L92;
        r23 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L92:
        UserCreation r133 = this.this$0.m3();
        if (r133 == null) goto L95;
        String r134 = zp9.d.c(r133);
    L96:
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.putOpt("template_sub_type", r134);     // Catch: JSONException -> L134
        r7.putOpt("template_show_enter_method", r132);     // Catch: JSONException -> L134
        if (r129 == null) goto L100;
        r7.put("creator_id", r129);     // Catch: JSONException -> L134
    L100:
        if (r126 == null) goto L102;
        r7.put("page_index", r126.intValue());     // Catch: JSONException -> L134
    L102:
        if (r119 == null) goto L104;
        r7.put("template_rec_req_id", r119);     // Catch: JSONException -> L134
    L104:
        if (r12 == null) goto L106;
        r7.put("recommend_from", r12);     // Catch: JSONException -> L134
    L106:
        if (r6 == null) goto L108;
        r7.put("bot_id", r6);     // Catch: JSONException -> L134
    L108:
        if (r115 == 0) goto L110;
        r7.put("template_id", r115);     // Catch: JSONException -> L134
    L110:
        if (r111 == 0) goto L112;
        r7.put("chat_type", r111);     // Catch: JSONException -> L134
    L112:
        if (r32 == null) goto L114;
        r7.put("template_type", r32);     // Catch: JSONException -> L134
    L114:
        if (r15 == 0) goto L116;
        r7.put("current_page", r15);     // Catch: JSONException -> L134
    L116:
        if (r28 == null) goto L118;
        r7.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r28);     // Catch: JSONException -> L134
    L118:
        if (r123 == 0) goto L120;
        r7.put("use_template_uv", r123.intValue());     // Catch: JSONException -> L134
    L120:
        if (r30 == null) goto L122;
        r7.put("conversation_id", r30);     // Catch: JSONException -> L134
    L122:
        r7.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r23);     // Catch: JSONException -> L134
        if (r34 != null) goto L125;
    L128:
        boolean r8 = true;
    L129:
        if (r8 == false) goto L131;
        String r9 = "default";
    L132:
        r7.put("template_source", r9);     // Catch: JSONException -> L134
    L136:
        TrackParams r20 = new TrackParams().merge(r7);
        by7.a r21 = new by7.a("unlike_ai_creation");
        r21.a.merge(r20);
        r21.b();
    L265:
        if (i3.a.f() == false) goto L267;
    L272:
        s3.a.a(null, 3);
        goto L274
    L267:
        if (AccountService.a.isLogin().booleanValue() == false) goto L272;
        CreationDetailBottomToolsViewModel r22 = this.this$0.p3();
        this.label = 1;
        if (r22.handleLikeAction(this) != r2) goto L274;
        return r2;
    L131:
        r9 = r34;
        goto L132
    L125:
        if (r34.length() == 0) goto L128;
        r8 = false;
    L134:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobEnterAIGenerateTabCategoryPage " + e.getLocalizedMessage());
        goto L136
    L95:
        r134 = null;
    L87:
        r132 = null;
    L81:
        r129 = null;
    L75:
        r126 = null;
    L69:
        r123 = null;
        goto L70
    L63:
        r34 = null;
    L59:
        r119 = null;
        goto L60
    L53:
        r32 = null;
        goto L54
    L49:
        r115 = null;
    L45:
        r30 = null;
    L39:
        r111 = null;
    L33:
        r28 = null;
    L27:
        r15 = null;
    L21:
        r12 = null;
    L15:
        r6 = null;
        goto L16
    L137:
        j29.a r135 = this.this$0.Y2();
        if (r135 == null) goto L142;
        zp9.g r136 = r135.a;
        if (r136 == null) goto L142;
        String r137 = r136.c;
    L143:
        j29.a r138 = this.this$0.Y2();
        if (r138 == null) goto L148;
        zp9.g r139 = r138.a;
        if (r139 == null) goto L148;
        String r140 = r139.j;
    L149:
        j29.a r141 = this.this$0.Y2();
        if (r141 == null) goto L154;
        zp9.g r142 = r141.a;
        if (r142 == null) goto L154;
        String r143 = r142.a;
    L155:
        j29.a r144 = this.this$0.Y2();
        if (r144 == null) goto L160;
        zp9.g r145 = r144.a;
        if (r145 == null) goto L160;
        String r146 = r145.h;
    L161:
        j29.a r147 = this.this$0.Y2();
        if (r147 == null) goto L166;
        zp9.g r148 = r147.a;
        if (r148 == null) goto L166;
        String r149 = r148.f;
    L167:
        j29.a r150 = this.this$0.Y2();
        if (r150 == null) goto L172;
        zp9.g r151 = r150.a;
        if (r151 == null) goto L172;
        String r24 = r151.d;
    L173:
        UserCreation r152 = this.this$0.m3();
        if (r152 == null) goto L176;
        String r153 = r152.a;
    L177:
        UserCreation r154 = this.this$0.m3();
        if (r154 == null) goto L180;
        String r25 = zp9.d.d(r154);
    L181:
        UserCreation r155 = this.this$0.m3();
        if (r155 == null) goto L186;
        UserCreationTrackParams r156 = r155.n;
        if (r156 == null) goto L186;
        String r157 = r156.a;
    L187:
        UserCreation r158 = this.this$0.m3();
        if (r158 == null) goto L190;
        String r210 = zp9.d.b(r158);
    L191:
        UserCreation r159 = this.this$0.m3();
        if (r159 == null) goto L196;
        Long r160 = r159.f;
        if (r160 == null) goto L196;
        Integer r161 = Boxing.boxInt((int) r160.longValue());
    L197:
        UserCreation r162 = this.this$0.m3();
        if (r162 == null) goto L202;
        UserCreationTrackParams r163 = r162.n;
        if (r163 == null) goto L202;
        Integer r164 = r163.b;
    L203:
        UserCreation r165 = this.this$0.m3();
        if (r165 == null) goto L208;
        AuthorInfo r166 = r165.g;
        if (r166 == null) goto L208;
        String r167 = r166.b;
    L210:
        if (this.$doubleTap == true) goto L213;
        r23 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L213:
        j29.a r168 = this.this$0.Y2();
        if (r168 == null) goto L218;
        zp9.g r169 = r168.a;
        if (r169 == null) goto L218;
        String r170 = r169.i;
    L219:
        UserCreation r26 = this.this$0.m3();
        if (r26 == null) goto L222;
        String r27 = zp9.d.c(r26);
    L223:
        JSONObject r31 = new JSONObject();
        Intrinsics.checkNotNullParameter(r31, "params");
        r31.put("template_sub_type", r27);     // Catch: JSONException -> L261
        r31.putOpt("template_show_enter_method", r170);     // Catch: JSONException -> L261
        if (r167 == null) goto L227;
        r31.put("creator_id", r167);     // Catch: JSONException -> L261
    L227:
        if (r164 == null) goto L229;
        r31.put("page_index", r164.intValue());     // Catch: JSONException -> L261
    L229:
        if (r157 == null) goto L231;
        r31.put("template_rec_req_id", r157);     // Catch: JSONException -> L261
    L231:
        if (r140 == null) goto L233;
        r31.put("recommend_from", r140);     // Catch: JSONException -> L261
    L233:
        if (r137 == null) goto L235;
        r31.put("bot_id", r137);     // Catch: JSONException -> L261
    L235:
        if (r153 == 0) goto L237;
        r31.put("template_id", r153);     // Catch: JSONException -> L261
    L237:
        if (r149 == 0) goto L239;
        r31.put("chat_type", r149);     // Catch: JSONException -> L261
    L239:
        if (r25 == null) goto L241;
        r31.put("template_type", r25);     // Catch: JSONException -> L261
    L241:
        if (r143 == 0) goto L243;
        r31.put("current_page", r143);     // Catch: JSONException -> L261
    L243:
        if (r146 == null) goto L245;
        r31.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r146);     // Catch: JSONException -> L261
    L245:
        if (r161 == 0) goto L247;
        r31.put("use_template_uv", r161.intValue());     // Catch: JSONException -> L261
    L247:
        if (r24 == null) goto L249;
        r31.put("conversation_id", r24);     // Catch: JSONException -> L261
    L249:
        r31.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r23);     // Catch: JSONException -> L261
        if (r210 != null) goto L252;
    L255:
        boolean r33 = true;
    L256:
        if (r33 == false) goto L258;
        String r35 = "default";
    L259:
        r31.put("template_source", r35);     // Catch: JSONException -> L261
    L263:
        TrackParams r36 = new TrackParams().merge(r31);
        by7.a r37 = new by7.a("like_ai_creation");
        r37.a.merge(r36);
        r37.b();
        goto L265
    L258:
        r35 = r210;
        goto L259
    L252:
        if (r210.length() == 0) goto L255;
        r33 = false;
    L261:
        e = move-exception;
        FLogger.a.e("CommunityEventHelper", "error in CommunityEventHelper mobEnterAIGenerateTabCategoryPage " + e.getLocalizedMessage());
        goto L263
    L222:
        r27 = null;
    L218:
        r170 = null;
    L208:
        r167 = null;
    L202:
        r164 = null;
    L196:
        r161 = null;
        goto L197
    L190:
        r210 = null;
    L186:
        r157 = null;
        goto L187
    L180:
        r25 = null;
        goto L181
    L176:
        r153 = null;
    L172:
        r24 = null;
    L166:
        r149 = null;
    L160:
        r146 = null;
    L154:
        r143 = null;
    L148:
        r140 = null;
    L142:
        r137 = null;
        goto L143
    }
}

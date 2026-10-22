package com.larus.canvas.feature.component.logic;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CanvasMsgInfo;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageUIActionReceiverComponent$bindObservers$2", f = "GenImageUIActionReceiverComponent.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
final class GenImageUIActionReceiverComponent$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImageUIActionReceiverComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageUIActionReceiverComponent a;

        public a(GenImageUIActionReceiverComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r50, Continuation r51) {
            com.larus.canvas.feature.component.resultdisplay.image.s r0 = (com.larus.canvas.feature.component.resultdisplay.image.s) r50;
            GenImageUIActionReceiverComponent r2 = this.a;
            int r3 = GenImageUIActionReceiverComponent.y;
            r2.getClass();
            String r11 = "image_edit_function_id";
            String r12 = "is_image_edit";
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.e) == false) goto L209;
            com.larus.canvas.feature.component.resultdisplay.image.y r1 = ((com.larus.canvas.feature.component.resultdisplay.image.s.e) r0).a;
            int r4 = r1.f;
            if (r4 != 0) goto L7;
            com.larus.bmhome.instruction.helper.f r5 = r2.x;
            if (r5 == null) goto L179;
            String r9 = null;
            com.larus.bmhome.instruction.helper.f.a.a(r5, null, 7);
        L180:
            my8.q r6 = r2.p3();
            if (r6 == null) goto L183;
            Intrinsics.checkNotNullParameter("image_generate_page", "<set-?>");
            r6.v = "image_generate_page";
        L183:
            my8.q r7 = r2.p3();
            if (r7 == null) goto L186;
            String r10 = r7.b();
        L187:
            my8.q r8 = r2.p3();
            if (r8 == null) goto L190;
            String r17 = r8.a();
        L191:
            my8.q r13 = r2.p3();
            if (r13 == null) goto L194;
            String r14 = r13.c();
        L195:
            my8.q r15 = r2.p3();
            if (r15 == null) goto L198;
            String r16 = r15.q;
        L199:
            my8.q r18 = r2.p3();
            if (r18 == null) goto L202;
            String r19 = r18.t;
        L203:
            my8.q r20 = r2.p3();
            if (r20 == null) goto L206;
            String r110 = r20.d();
        L207:
            tx9.c0.H(r10, "image_generate_page", r16, null, r14, r19, r110, r17, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554184);
        L298:
            return Unit.INSTANCE;
        L206:
            r110 = r9;
            goto L207
        L202:
            r19 = r9;
            goto L203
        L198:
            r16 = r9;
            goto L199
        L194:
            r14 = r9;
            goto L195
        L190:
            r17 = r9;
            goto L191
        L186:
            r10 = r9;
            goto L187
        L179:
            r9 = null;
            goto L180
        L7:
            if (r4 != 4) goto L298;
            com.larus.canvas.feature.component.resultdisplay.image.r r21 = r2.D3();
            if (r21 == null) goto L14;
            kotlinx.coroutines.flow.b1 r22 = r21.OP();
            if (r22 == null) goto L14;
            Integer r23 = (Integer) r22.getValue();
        L15:
            n2 r24 = r2.B3();
            if (r24 == null) goto L24;
            kotlinx.coroutines.flow.i1<ky8.g> r25 = r24.bt();
            if (r25 == null) goto L24;
            ky8.g r26 = (ky8.g) r25.getValue();
            if (r26 == null) goto L24;
            Map<String, ky8.h> r27 = r26.a;
            if (r27 == null) goto L24;
            Collection<ky8.h> r28 = r27.values();
        L25:
            if (r28 != null) goto L27;
        L30:
            boolean r111 = true;
        L31:
            if (r111 == true) goto L298;
            if (r23 == null) goto L298;
            if (r23.intValue() < 0) goto L298;
            if (r23.intValue() >= r28.size()) goto L298;
            ArrayList r29 = new ArrayList();
            Iterator<T> r30 = r28.iterator();
            int r31 = -1;
            ky8.h r112 = null;
            int r113 = 0;
        L41:
            if (r30.hasNext() == false) goto L111;
            T r210 = r30.next();
            int r40 = r113 + 1;
            if (r113 >= 0) goto L45;
            CollectionsKt.throwIndexOverflow();
        L45:
            Iterator<T> r41 = r30;
            ky8.h r32 = (ky8.h) r210;
            String r42 = r11;
            if ((r32 instanceof ky8.k) == false) goto L53;
            if (Intrinsics.areEqual(r1.a, "origin") == false) goto L50;
            r112 = r32;
            r31 = r113;
        L50:
            ky8.k r114 = (ky8.k) r32;
            r29.add(new ky8.a("origin", null, null, null, null, GenImageUIActionReceiverComponent.E3(r114), GenImageUIActionReceiverComponent.E3(r114), null, null, null, r113, null, null, null, null, null));
        L53:
            if ((r32 instanceof ky8.f) == false) goto L110;
            ky8.f r115 = (ky8.f) r32;
            if (r115.l() == false) goto L110;
            if (Intrinsics.areEqual(r1.a, r115.a) == false) goto L59;
            r31 = r113;
        L60:
            String r33 = r115.a;
            Long r211 = r115.d();
            String r212 = r115.j();
            String r213 = r115.e();
            List<CanvasBlock> r116 = r115.b;
            if (r116 == null) goto L69;
            CanvasBlock r117 = (CanvasBlock) CollectionsKt.firstOrNull(r116);
            if (r117 == null) goto L69;
            CanvasImageBlock r118 = r117.content;
            if (r118 == null) goto L69;
            CanvasInfo r119 = r118.canvasInfo;
            if (r119 == null) goto L69;
            Long r214 = r119.canvasSubId;
        L70:
            ImageData r120 = r115.h();
            if (r120 == null) goto L75;
            ImageObj r121 = r120.imageThumb;
            if (r121 == null) goto L75;
            String r122 = r121.url;
        L76:
            if (r122 != null) goto L78;
            String r34 = "";
        L79:
            String r123 = r115.i();
            if (r123 != null) goto L82;
            String r35 = "";
        L83:
            String r124 = r115.g();
            if (r124 != null) goto L86;
            String r215 = "";
        L87:
            ImageData r125 = r115.h();
            if (r125 == null) goto L92;
            ImageObj r126 = r125.imageOrigin;
            if (r126 == null) goto L92;
            Integer r36 = Integer.valueOf(r126.width);
        L93:
            ImageData r127 = r115.h();
            if (r127 == null) goto L98;
            ImageObj r128 = r127.imageOrigin;
            if (r128 == null) goto L98;
            Integer r37 = Integer.valueOf(r128.height);
        L99:
            ky8.i r129 = r115.e;
            ky8.h r130 = r32;
            int r45 = r31;
            long r38 = r129.g;
            String r39 = r129.a();
            String r310 = r2.C3(r115);
            UserCreationFromIM r311 = r115.f();
            CanvasMsgInfo r131 = r115.m();
            if (r131 == null) goto L102;
            String r312 = r131.replyMsgId;
        L103:
            r29.add(new ky8.a(r33, r211, r212, r214, r213, r215, r35, r34, r36, r37, r113, r310, Long.valueOf(r38), r39, r311, r312));
            UserCreationFromIM r43 = r115.f();
            if (r43 == null) goto L108;
            String r44 = r43.getCreationId();
            if (r44 == null) goto L108;
            r2.z3().f.put(r115.a, r44);
        L108:
            r112 = r130;
            r31 = r45;
            goto L110
        L102:
            r312 = null;
        L98:
            r37 = null;
        L92:
            r36 = null;
            goto L93
        L86:
            r215 = r124;
            goto L87
        L82:
            r35 = r123;
            goto L83
        L78:
            r34 = r122;
        L75:
            r122 = null;
        L69:
            r214 = null;
            goto L70
        L59:
            r32 = r112;
        L110:
            r113 = r40;
            r30 = r41;
            r11 = r42;
            r12 = r12;
            r1 = r1;
            goto L41
        L111:
            String r46 = r11;
            String r47 = r12;
            if (r112 == null) goto L298;
            boolean r48 = z2.a.getNewPreviewConfig().b.a;
            com.larus.canvas.feature.component.logic.provider.j r49 = r2.z3();
            r49.a = r31;
            r49.b = r29.size();
            r49.g = r48;
            ky8.b r52 = new ky8.b(r29);
            GalleryBuilder r53 = new GalleryBuilder(r2.getContext());
            Intrinsics.checkNotNullParameter(r52, "dataSource");
            r53.b = r52;
            Intrinsics.checkNotNullParameter("CanvasGalleryDialog", "tag");
            r53.m = "CanvasGalleryDialog";
            if (r31 < 0) goto L117;
            r53.c = r31;
        L117:
            com.larus.gallery.api.b r54 = new com.larus.gallery.api.b(null, r48, null, 0, false, false, false, null, null, false, 32765);
            Intrinsics.checkNotNullParameter(r54, "displayConfig");
            r53.d = r54;
            r53.a(ProviderType.BOTTOM, new com.larus.canvas.feature.component.logic.provider.i(r2.z3()));
            r53.a(ProviderType.RIGHT_SIDE, new com.larus.canvas.feature.component.logic.provider.v(r2.z3()));
            ProviderType r55 = ProviderType.TOP;
            if (r48 == false) goto L120;
            com.larus.gallery.api.t r56 = new com.larus.canvas.feature.component.logic.provider.z(r2.z3());
        L121:
            r53.a(r55, r56);
            r53.a(ProviderType.NON_UI, new com.larus.canvas.feature.component.logic.provider.w(r2.z3()));
            Intrinsics.checkNotNullParameter(r2, "<this>");
            FragmentActivity r57 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getActivity();
            if (r57 == null) goto L124;
            FragmentManager r58 = r57.getSupportFragmentManager();
        L125:
            r53.b(r58);
            my8.q r59 = r2.p3();
            if (r59 == null) goto L129;
            String r60 = r59.b();
            if (r60 == null) goto L129;
        L135:
            my8.q r61 = r2.p3();
            if (r61 == null) goto L138;
            String r62 = r61.w;
        L139:
            boolean r63 = r112 instanceof ky8.f;
            if (r63 == false) goto L142;
            String r132 = ((ky8.f) r112).j();
        L143:
            if (r63 == false) goto L147;
            Long r133 = ((ky8.f) r112).d();
            if (r133 == null) goto L147;
            String r134 = r133.toString();
        L148:
            my8.q r135 = r2.p3();
            if (r135 == null) goto L151;
            String r64 = r135.c();
        L152:
            my8.q r136 = r2.p3();
            if (r136 == null) goto L155;
            String r137 = r136.t;
        L156:
            Integer r65 = Integer.valueOf(r31);
            int r216 = 1;
            if (r63 == true) goto L159;
            Integer r410 = null;
        L164:
            if (r63 == false) goto L166;
            String r66 = r2.C3((ky8.f) r112);
        L167:
            if (r63 == false) goto L169;
            String r67 = ((ky8.f) r112).e();
        L170:
            Integer r68 = Integer.valueOf(r31);
            JSONObject r138 = new JSONObject();
            r138.putOpt("bot_id", r60);     // Catch: JSONException -> L173
            r138.putOpt("ai_create_show_mode", r62);     // Catch: JSONException -> L173
            r138.putOpt("creation_task_id", r132);     // Catch: JSONException -> L173
            r138.putOpt(MusicAppletPage.KEY_CONVERSATION_ID, r134);     // Catch: JSONException -> L173
            r138.putOpt("chat_type", r64);     // Catch: JSONException -> L173
            r138.putOpt("current_page", r137);     // Catch: JSONException -> L173
            r138.putOpt("enter_from", "image_generate_canvas");     // Catch: JSONException -> L173
            r138.putOpt("enter_method", "click");     // Catch: JSONException -> L173
            r138.putOpt("index", r65);     // Catch: JSONException -> L173
            r138.putOpt("is_creation", 1);     // Catch: JSONException -> L173
            r138.putOpt("is_deep_thinking", 0);     // Catch: JSONException -> L173
            r138.putOpt(r47, r410);     // Catch: JSONException -> L173
            r138.putOpt(r46, r66);     // Catch: JSONException -> L173
            r138.putOpt("is_replica_gen", 0);     // Catch: JSONException -> L173
            r138.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r67);     // Catch: JSONException -> L173
            r138.putOpt("position", r68);     // Catch: JSONException -> L173
            r138.putOpt("slide_status", "left");     // Catch: JSONException -> L173
            r138.putOpt("user_type", "user");     // Catch: JSONException -> L173
        L175:
            TrackParams r69 = new TrackParams().merge(r138);
            by7.a r70 = new by7.a("enter_picture_detail");
            r70.a.merge(r69);
            r70.b();
        L173:
            e = move-exception;
            FLogger.a.e("GenImageUIActionReceiverComponent", "error in GenImageUIActionReceiverComponent reportEnterPictureDetail " + e.getLocalizedMessage());
            goto L175
        L169:
            r67 = null;
            goto L170
        L166:
            r66 = null;
            goto L167
        L159:
            if (((ky8.f) r112).c() != null) goto L162;
            r216 = 0;
        L162:
            r410 = Integer.valueOf(r216);
            goto L164
        L155:
            r137 = null;
            goto L156
        L151:
            r64 = null;
        L147:
            r134 = null;
            goto L148
        L142:
            r132 = null;
            goto L143
        L138:
            r62 = null;
        L129:
            com.larus.bmhome.chat.api.e0 r71 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r71 == null) goto L134;
            LaunchInfo r72 = r71.a;
            if (r72 == null) goto L134;
            r60 = r72.W();
        L134:
            r60 = null;
            goto L135
        L124:
            r58 = null;
            goto L125
        L120:
            r56 = new com.larus.canvas.feature.component.logic.provider.b0(r2.z3());
            goto L121
        L27:
            if (r28.isEmpty() == true) goto L30;
            r111 = false;
        L24:
            r28 = null;
        L14:
            r23 = null;
            goto L15
        L209:
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.f) == false) goto L251;
            n2 r73 = r2.B3();
            if (r73 == null) goto L215;
            kotlinx.coroutines.flow.b1 r74 = r73.tx();
            if (r74 == null) goto L215;
            Pair r75 = (Pair) r74.getValue();
        L216:
            if (r75 == null) goto L218;
            Integer r76 = (Integer) r75.getFirst();
        L219:
            if (r75 == null) goto L221;
            ky8.h r77 = (ky8.h) r75.getSecond();
        L222:
            if (r77 == null) goto L241;
            Integer r139 = r76;
            if ((r77 instanceof ky8.f) == false) goto L241;
            IFlowSdkDepend r78 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r78 == null) goto L231;
            r78.D0();
            com.larus.home.impl.sdk.b1 r79 = com.larus.home.impl.sdk.b1.a;
            r79.c("photoshop_page_image_long_press");
            String r80 = ((ky8.f) r77).g();
            if (r80 != null) goto L230;
            r80 = "";
        L230:
            r79.d(r80);
        L231:
            ShareServiceDelegate r81 = ShareServiceDelegate.b;
            JSONObject r82 = new JSONObject();
            r82.putOpt("bot_id", r2.z3().i.get("bot_id"));
            r82.putOpt("ai_create_show_mode", r2.z3().i.get("ai_create_show_mode"));
            r82.putOpt("click_method", "overview_long_press");
            ky8.f r83 = (ky8.f) r77;
            r82.putOpt("creation_task_id", r83.j());
            r82.putOpt(MusicAppletPage.KEY_CONVERSATION_ID, r83.d());
            r82.putOpt("current_page", r2.z3().i.get("current_page"));
            r82.putOpt("enter_picture_method", r2.z3().i.get("enter_picture_method"));
            r82.putOpt("is_deep_thinking", 0);
            UserCreationFromIM r84 = r83.f();
            if (r84 == null) goto L239;
            Integer r85 = r84.getCreationType();
            if (r85 == null) goto L239;
            if (r85.intValue() != 4) goto L239;
            int r86 = 1;
        L240:
            r82.putOpt("is_image_edit", Integer.valueOf(r86));
            r82.putOpt("is_replica_gen", 0);
            r82.putOpt("enter_method", r2.z3().i.get("enter_method"));
            r82.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r83.e());
            r82.putOpt("image_edit_function_id", r2.C3(r83));
            r82.putOpt("position", r139);
            r82.putOpt("user_type", r2.z3().i.get("user_type"));
            r81.w(r82);
        L239:
            r86 = 0;
        L241:
            o2 r87 = (o2) r2.r.getValue();
            if (r87 == null) goto L298;
            my8.q r88 = r2.p3();
            if (r88 == null) goto L246;
            String r89 = r88.t;
        L247:
            if (r89 != null) goto L249;
            r89 = "";
        L249:
            r87.OX("detail_long_press", "detail_long_press", r89);
            goto L298
        L246:
            r89 = null;
            goto L247
        L221:
            r77 = null;
            goto L222
        L218:
            r76 = null;
        L215:
            r75 = null;
            goto L216
        L251:
            if (Intrinsics.areEqual(r0, com.larus.canvas.feature.component.resultdisplay.image.s.g.a) == false) goto L256;
            n2 r90 = r2.B3();
            if (r90 == null) goto L298;
            r90.gu();
            goto L298
        L256:
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.b) == false) goto L261;
            n2 r91 = r2.B3();
            if (r91 == null) goto L298;
            r91.lH(((com.larus.canvas.feature.component.resultdisplay.image.s.b) r0).a.a);
            goto L298
        L261:
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.a) == false) goto L290;
            n2 r92 = r2.B3();
            if (r92 == null) goto L269;
            kotlinx.coroutines.flow.b1 r93 = r92.tx();
            if (r93 == null) goto L269;
            Pair r94 = (Pair) r93.getValue();
            if (r94 == null) goto L269;
            ky8.h r95 = (ky8.h) r94.getSecond();
        L271:
            if ((r95 instanceof ky8.f) == false) goto L273;
            ky8.f r96 = (ky8.f) r95;
        L274:
            if (r96 == null) goto L298;
            String r97 = r96.j();
            Long r98 = r96.d();
            if (r98 == null) goto L278;
            String r99 = r98.toString();
        L279:
            CanvasInfo r100 = r96.a();
            if (r100 == null) goto L282;
            String r101 = r100.replySubId;
        L283:
            String r102 = ((com.larus.canvas.feature.component.resultdisplay.image.s.a) r0).b;
            JSONObject r103 = new JSONObject();
            Intrinsics.checkNotNullParameter(r103, "params");
            r103.putOpt("canvas_id", r99);     // Catch: JSONException -> L286
            r103.putOpt("canvas_sub_id", r101);     // Catch: JSONException -> L286
            r103.putOpt("click_from", r102);     // Catch: JSONException -> L286
            r103.putOpt("creation_task_id", r97);     // Catch: JSONException -> L286
        L288:
            TrackParams r104 = new TrackParams().merge(r103);
            by7.a r105 = new by7.a("click_ai_generate_compare");
            r105.a.merge(r104);
            r105.b();
        L286:
            e = move-exception;
            FLogger.a.e("mobClickAiGenerateCompare", "error: " + e.getLocalizedMessage());
            goto L288
        L282:
            r101 = null;
            goto L283
        L278:
            r99 = null;
            goto L279
        L273:
            r96 = null;
        L269:
            r95 = null;
            goto L271
        L290:
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.c) == false) goto L293;
            r2.H3(((com.larus.canvas.feature.component.resultdisplay.image.s.c) r0).a.a);
            goto L298
        L293:
            if ((r0 instanceof com.larus.canvas.feature.component.resultdisplay.image.s.d) == false) goto L300;
            n2 r106 = r2.B3();
            if (r106 == null) goto L298;
            com.larus.canvas.feature.component.resultdisplay.image.s.d r107 = (com.larus.canvas.feature.component.resultdisplay.image.s.d) r0;
            r106.IQ(r107.a.a, r107.b);
            goto L298
        L300:
            throw new NoWhenBranchMatchedException();
        }
    }

    public GenImageUIActionReceiverComponent$bindObservers$2(GenImageUIActionReceiverComponent r1, Continuation<? super GenImageUIActionReceiverComponent$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImageUIActionReceiverComponent$bindObservers$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GenImageUIActionReceiverComponent r6 = this.this$0;
        int r2 = GenImageUIActionReceiverComponent.y;
        com.larus.canvas.feature.component.resultdisplay.image.r r7 = r6.D3();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.a1 r8 = r7.U4();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}

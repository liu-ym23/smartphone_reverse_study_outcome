package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.AudioFileDetail;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.UploadFile;
import com.larus.im.bean.message.block.UploadLarkDoc;
import com.larus.platform.model.office.AiFilePreviewScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.larus.utils.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import qy8.b;
import v19.m5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class NestedFileClickHelper {
    public static final NestedFileClickHelper a = null;
    public static final Lazy b = null;

    public NestedFileClickHelper() {
    }

    static {
        a = new NestedFileClickHelper();
        b = LazyKt.lazy(new d());
    }

    public static void i(lr8.f r44) {
        Intrinsics.checkNotNullParameter(r44, "params");
        String r10 = r44.a;
        View r15 = r44.b;
        Message r13 = r44.c;
        NestedFileContent r11 = r44.d;
        int r14 = r44.e;
        BaseResourceViewHolder.a r0 = r44.f;
        lr8.a r12 = r44.g;
        Function3 r2 = r44.h;
        Boolean r9 = r44.i;
        Context r18 = r15.getContext();
        if (r18 == null) goto L459;
        List r3 = r11.getEntities();
        if (r3 == null) goto L14;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r5).getFileIdentifier(), r10) == false) goto L8;
    L13:
        UplinkFileEntity r7 = (UplinkFileEntity) r5;
    L15:
        long r6 = System.currentTimeMillis() / ((long) 1000);
        if (r7 == null) goto L22;
        ExpiredInfo r8 = r7.getExpiredInfo();
        if (r8 == null) goto L22;
        Long r16 = r8.getExpireTime();
        if (r16 == null) goto L22;
        long r17 = r16.longValue();
    L24:
        if (r6 < r17) goto L38;
        r12.a();
        FLogger r1 = FLogger.a;
        StringBuilder r19 = new StringBuilder("pic expired, need refresh, ");
        if (r7 == null) goto L30;
        ExpiredInfo r20 = r7.getExpiredInfo();
        if (r20 == null) goto L30;
        Long r21 = r20.getExpireTime();
    L31:
        r19.append(r21);
        r19.append(", ");
        if (r7 == null) goto L36;
        ExpiredInfo r22 = r7.getExpiredInfo();
        if (r22 == null) goto L36;
        Long r23 = r22.getTtl();
    L37:
        r19.append(r23);
        r1.i("dora_e_pic", r19.toString());
        r2.invoke(r13, r11, r0);
        return;
    L36:
        r23 = null;
    L30:
        r21 = null;
        goto L31
    L38:
        NestedFileClickHelper r24 = a;
        if (r7 == null) goto L43;
        UplinkEntityContent r25 = r7.getUplinkEntityContent();
        if (r25 == null) goto L43;
        UplinkFileInfo r26 = r25.getUplinkFileInfo();
    L44:
        r24.getClass();
        UploadLarkDoc r27 = a(r13, r10, r26);
        String r28 = "<this>";
        if (r27 == null) goto L83;
        String r29 = r27.getToken();
        if (r29 == null) goto L83;
        if ((!StringsKt.isBlank(r29)) == false) goto L51;
        String r30 = r29;
    L52:
        if (r30 == null) goto L83;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L55
        Intrinsics.checkNotNullParameter(r15, "<this>");     // Catch: Throwable -> L55
        Object r32 = Result.constructor-impl(FragmentManager.findFragment(r15));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r32) == false) goto L60;
        r32 = null;
    L60:
        ChatFragment r33 = (ChatFragment) r32;
        if (r33 == null) goto L83;
        sd8.a r34 = r33.WF().getAbility(sd8.a.class);
        if (r34 == null) goto L83;
        qy8.a r35 = r34.yu();
        if (r35 == null) goto L83;
        b r36 = r35.d;
        if (r36 == null) goto L83;
        Object r37 = Result.constructor-impl(Boolean.valueOf(r36.a(r33, r30)));     // Catch: Throwable -> L71
    L73:
        Throwable r38 = Result.exceptionOrNull-impl(r37);
        if (r38 == null) goto L77;
        FLogger r39 = FLogger.a;
        StringBuilder r40 = new StringBuilder("chat host artifact interceptor failed, resourceId=");
        a.getClass();
        r40.append(k(r30));
        r39.w("NestedFileClickHelper", r40.toString(), r38);
    L77:
        Boolean r41 = Boolean.FALSE;
        if (Result.isFailure-impl(r37) == false) goto L80;
        r37 = r41;
    L80:
        boolean r42 = ((Boolean) r37).booleanValue();
        if (r42 == false) goto L84;
        FLogger.a.i("NestedFileClickHelper", "chat host artifact interceptor consumed resourceId=" + k(r30));
    L84:
        if (r42 == true) goto L466;
        int r43 = MultimodalSendCostTrace.a;
        String r45 = r13.getConversationId();
        String r46 = r13.getLocalMessageId();
        AttachmentAreaType r47 = AttachmentAreaType.MULTI_ATTACHMENT;
        if (r7 == null) goto L89;
        String r48 = l1.e(r7);
    L91:
        if (r7 == null) goto L96;
        String r49 = l1.f(r7);
        if (r49 == null) goto L96;
        String r110 = r49;
        FragmentActivity r50 = null;
    L101:
        String r51 = r28;
        FragmentActivity r111 = r50;
        UplinkFileEntity r210 = r7;
        MultimodalSendCostTrace.b(r10, r46, r45, null, r47, null, r48, r110);
        FLogger r52 = FLogger.a;
        StringBuilder r53 = new StringBuilder("[openResourceOnClick] hasEntity=");
        if (r210 == null) goto L104;
        boolean r54 = true;
    L105:
        r53.append(r54);
        r53.append(", hasRemoteIdentity=");
        if (r210 == null) goto L112;
        UplinkEntityContent r55 = r210.getUplinkEntityContent();
        if (r55 == null) goto L112;
        UplinkFileInfo r56 = r55.getUplinkFileInfo();
        if (r56 == null) goto L112;
        FragmentActivity r57 = r56.getTosKey();
    L113:
        if (r57 != null) goto L115;
    L118:
        boolean r58 = true;
        boolean r59 = true;
    L119:
        r53.append(!r59);
        r52.i("NestedFileClickHelper", r53.toString());
        if (r210 != null) goto L122;
    L124:
        boolean r60 = false;
    L125:
        if (r60 == true) goto L141;
        if (r210 != null) goto L128;
    L130:
        boolean r61 = false;
    L131:
        if (r61 == true) goto L141;
        if (r210 != null) goto L135;
    L137:
        boolean r62 = false;
    L138:
        if (r62 == false) goto L140;
        NestedFileClickHelper r63 = a;
        boolean r64 = r44.j;
        r63.getClass();
        e(r10, r13, r18, r210, r12, r64);
        return;
    L140:
        NestedFileClickHelper r65 = a;
        boolean r66 = r44.j;
        r65.getClass();
        e(r10, r13, r18, r210, r12, r66);
        return;
    L135:
        if (n1.a(r210) != r58) goto L137;
        r62 = true;
        goto L138
    L128:
        if (n1.e(r210) != r58) goto L130;
        r61 = true;
    L141:
        String r67 = "";
        if (IChatGalleryService.a.h(r12.i0()) == false) goto L211;
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L211;
        if (n1.d(r210) == false) goto L154;
        NestedFileClickHelper r68 = a;
        BotModel r69 = r12.i();
        Image r70 = l1.c(r210);
        if (r70 == null) goto L153;
        String r71 = r70.key;
        if (r71 == null) goto L153;
        r67 = r71;
    L153:
        r68.getClass();
        j(r69, r13, r67);
    L154:
        a.getClass();
        Gson r72 = (Gson) b.getValue();
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L161
        Map r74 = r13.getExt();     // Catch: Throwable -> L161
        if (r74 == null) goto L158;
        FragmentActivity r75 = (String) r74.get("white_tee_index_list");     // Catch: Throwable -> L161
    L159:
        Object r76 = Result.constructor-impl((ArrayList) r72.fromJson(r75, new i().getType()));     // Catch: Throwable -> L161
    L163:
        Object r77 = r76;
        if (Result.isFailure-impl(r77) == false) goto L166;
        r77 = r111;
    L166:
        ArrayList r78 = (ArrayList) r77;
        if (r78 != null) goto L169;
        r78 = new ArrayList();
    L169:
        List r79 = r11.getEntities();
        if (r79 == null) goto L205;
        ArrayList r80 = new ArrayList();
        Iterator r81 = r79.iterator();
        int r82 = 0;
    L173:
        if (r81.hasNext() == false) goto L188;
        Object r83 = r81.next();
        int r84 = r82 + 1;
        if (r82 >= 0) goto L177;
        CollectionsKt.throwIndexOverflow();
    L177:
        UplinkFileEntity r85 = (UplinkFileEntity) r83;
        if (r78.contains(Integer.valueOf(r82)) == false) goto L180;
    L184:
        boolean r86 = false;
    L185:
        if (r86 == false) goto L187;
        r80.add(r83);
    L187:
        r82 = r84;
        goto L173
    L180:
        if (n1.d(r85) == false) goto L182;
    L183:
        r86 = true;
        goto L185
    L182:
        if (n1.e(r85) == false) goto L184;
    L188:
        Iterator r87 = r80.iterator();
        int r88 = 0;
    L190:
        if (r87.hasNext() == false) goto L195;
        if (Intrinsics.areEqual(((UplinkFileEntity) r87.next()).getFileIdentifier(), r10) == true) goto L196;
        r88 = r88 + 1;
    L196:
        FragmentActivity r89 = Integer.valueOf(r88);
        if (r89.intValue() < 0) goto L199;
        boolean r90 = true;
    L200:
        if (r90 == true) goto L203;
        r89 = r111;
    L203:
        if (r89 == null) goto L205;
        int r112 = r89.intValue();
    L206:
        IChatGalleryService.Companion r91 = IChatGalleryService.a;
        FragmentManager r92 = r12.getFragmentManager();
        BotModel r93 = r12.i();
        q0 r113 = r12.getAdapter();
        com.larus.trace.tracknode.a r114 = r12.f();
        GlobalScope r94 = r12.c();
        if (r94 != null) goto L209;
        r94 = GlobalScope.INSTANCE;
    L209:
        r91.i(r92, new ty8.a(r93, r13, r114, r94, r113, r112, r18, r15, r14, 15872));
        return;
    L199:
        r90 = false;
        goto L200
    L195:
        r88 = -1;
    L205:
        r112 = 0;
        goto L206
    L158:
        r75 = r111;
    L161:
        th = move-exception;
        Result.Companion r95 = Result.Companion;
        r76 = Result.constructor-impl(ResultKt.createFailure(th));
    L211:
        if (n1.d(r210) == false) goto L327;
        a.getClass();
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L324
        List r97 = r11.getEntities();     // Catch: Throwable -> L324
        if (r97 == null) goto L230;
        Iterator r99 = r97.iterator();     // Catch: Throwable -> L324
    L217:
        if (r99.hasNext() == false) goto L221;
        Object r100 = r99.next();     // Catch: Throwable -> L324
        if (Intrinsics.areEqual(((UplinkFileEntity) r100).getFileIdentifier(), r10) == false) goto L217;
    L222:
        UplinkFileEntity r101 = (UplinkFileEntity) r100;     // Catch: Throwable -> L324
        if (r101 == null) goto L230;
        Image r102 = l1.c(r101);     // Catch: Throwable -> L324
        if (r102 == null) goto L230;
        String r103 = r102.key;     // Catch: Throwable -> L324
        if (r103 == null) goto L230;
        String r104 = r103;
    L231:
        j(r12.i(), r13, r104);     // Catch: Throwable -> L324
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L324
        Gson r106 = (Gson) b.getValue();     // Catch: Throwable -> L324
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L238
        Map r108 = r13.getExt();     // Catch: Throwable -> L238
        if (r108 == null) goto L235;
        FragmentActivity r109 = (String) r108.get("white_tee_index_list");     // Catch: Throwable -> L238
    L236:
        Object r115 = Result.constructor-impl((ArrayList) r106.fromJson(r109, new h().getType()));     // Catch: Throwable -> L238
    L241:
        if (Result.exceptionOrNull-impl(r115) == null) goto L244;
        r115 = new ArrayList();     // Catch: Throwable -> L324
    L244:
        ArrayList r116 = (ArrayList) r115;     // Catch: Throwable -> L324
        if (r116 != null) goto L247;
        r116 = new ArrayList();     // Catch: Throwable -> L324
    L247:
        List r117 = r11.getEntities();     // Catch: Throwable -> L324
        if (r117 == null) goto L310;
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L324
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
    L251:
        if (r118.hasNext() == false) goto L309;
        Object r122 = r118.next();     // Catch: Throwable -> L324
        int r123 = r120 + 1;     // Catch: Throwable -> L324
        if (r120 >= 0) goto L255;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L324
    L255:
        UplinkFileEntity r124 = (UplinkFileEntity) r122;     // Catch: Throwable -> L324
        if (n1.d(r124) == false) goto L306;
        Integer r125 = r124.getFileReviewStatus();     // Catch: Throwable -> L324
        int r126 = FileReviewState.NOT_COMPLIANT.getValue();     // Catch: Throwable -> L324
        if (r125 != null) goto L260;
        Iterator r410 = r118;
    L263:
        if (r116.contains(Integer.valueOf(r120)) == true) goto L307;
        String r127 = r124.getFileIdentifier();     // Catch: Throwable -> L324
        if (r127 != null) goto L267;
        r127 = r67;
    L267:
        String r128 = com.larus.bmhome.chat.sendimage.e.h(r13, r127);     // Catch: Throwable -> L324
        Image r129 = l1.c(r124);     // Catch: Throwable -> L324
        if (r129 == null) goto L279;
        ImageObj r130 = r129.previewImage;     // Catch: Throwable -> L324
        if (r130 == null) goto L279;
        FragmentActivity r131 = r130.url;     // Catch: Throwable -> L324
        if (r131 == null) goto L279;
        if (r131.length() <= 0) goto L276;
        boolean r132 = true;
    L277:
        if (r132 == false) goto L279;
    L280:
        if (r129 == null) goto L282;
        boolean r133 = Intrinsics.areEqual(r129.aiCreationImage, Boolean.TRUE);     // Catch: Throwable -> L324
    L283:
        if (r133 == false) goto L288;
        if (o0.d(r131) == false) goto L288;
        Uri r134 = y0.h(r131);     // Catch: Throwable -> L324
    L301:
        r105.add(new com.larus.bmhome.bigimg.n1(r134.toString()));     // Catch: Throwable -> L324
        if (Intrinsics.areEqual(r124.getFileIdentifier(), r10) == false) goto L304;
        r119 = r121;
    L308:
        r118 = r410;
        r120 = r123;
        r116 = r116;
        r67 = r67;
        goto L251
    L304:
        r121 = r121 + 1;     // Catch: Throwable -> L324
    L288:
        if (m5.c(r128) == true) goto L290;
        if (r131 != null) goto L299;
        if (r129 == null) goto L298;
        ImageObj r135 = r129.imageOri;     // Catch: Throwable -> L324
        if (r135 == null) goto L298;
        FragmentActivity r136 = r135.url;     // Catch: Throwable -> L324
    L300:
        r134 = y0.h(r136);     // Catch: Throwable -> L324
    L298:
        r136 = r111;
        goto L300
    L299:
        r136 = r131;
        goto L300
    L290:
        if (r128 != null) goto L292;
        r128 = r67;
    L292:
        r134 = Uri.fromFile(new PolarisFileWrapper(r128));     // Catch: Throwable -> L324
        goto L301
    L282:
        r133 = false;
        goto L283
    L276:
        r132 = false;
    L279:
        r131 = r111;
    L307:
        r67 = r67;
        goto L308
    L260:
        r410 = r118;
        if (r125.intValue() == r126) goto L307;
    L306:
        r410 = r118;
        goto L307
    L309:
        String r137 = r67;
    L311:
        Context r211 = r15.getContext();     // Catch: Throwable -> L324
        Pair[] r138 = new Pair[7];     // Catch: Throwable -> L324
        r138[0] = TuplesKt.to("source", "send_img_holder");     // Catch: Throwable -> L324
        r138[1] = TuplesKt.to("user_type", "user");     // Catch: Throwable -> L324
        r138[2] = TuplesKt.to("enter_picture_method", "chat");     // Catch: Throwable -> L324
        r138[3] = TuplesKt.to("enter_from", "chat");     // Catch: Throwable -> L324
        String r139 = r13.getMessageId();     // Catch: Throwable -> L324
        if (r139 != null) goto L314;
        r139 = r137;
    L314:
        r138[4] = TuplesKt.to("message_id", r139);     // Catch: Throwable -> L324
        String r140 = r13.getConversationId();     // Catch: Throwable -> L324
        if (r140 != null) goto L317;
        r140 = r137;
    L317:
        r138[5] = TuplesKt.to("conversation_id", r140);     // Catch: Throwable -> L324
        BotModel r141 = r12.i();     // Catch: Throwable -> L324
        if (r141 == null) goto L321;
        String r142 = r141.getBotId();     // Catch: Throwable -> L324
        if (r142 == null) goto L321;
    L322:
        r138[6] = TuplesKt.to("bot_id", r142);     // Catch: Throwable -> L324
        new BigImagePhotoViewerDialog(r211, r105, null, new uo8.k(MapsKt.mapOf(r138), CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.to("pic_id", r104)))), false, null, r13.getMessageId(), null, null, null, null, false, false, false, 32688).v(r119, r15, "NestedFileCell");     // Catch: Throwable -> L324
        Object r143 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L324
    L326:
        Result.box-impl(r143);
        return;
    L321:
        r142 = r137;
        goto L322
    L310:
        r137 = "";
        r119 = 0;
        goto L311
    L235:
        r109 = r111;
    L238:
        th = move-exception;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L324
        r115 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L324
        goto L241
    L221:
        r100 = r111;
    L230:
        r104 = "";
    L324:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        r143 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L326
    L327:
        a.getClass();
        BotModel r146 = r12.i();
        if (r146 == null) goto L330;
        FragmentActivity r212 = r146.getBotId();
    L331:
        c4 r147 = new c4(r212, r13.getMessageId(), "chat", r12.i(), r12.h(), "click_message_video", "1", null, null, null, null, null, null, null, 16256);
        FragmentActivity r148 = AppHost.a.a().getCurrentActivity();
        if ((r148 instanceof FragmentActivity) == false) goto L334;
        FragmentActivity r149 = r148;
    L335:
        if (r149 == null) goto L465;
        com.larus.bmhome.video.fragment.b0 r150 = com.larus.bmhome.video.fragment.b0.a;
        FragmentManager r151 = r149.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r210, r51);
        UplinkEntityContent r152 = r210.getUplinkEntityContent();
        if (r152 == null) goto L343;
        UplinkFileInfo r153 = r152.getUplinkFileInfo();
        if (r153 == null) goto L343;
        VideoExtension r154 = r153.getVideo();
        if (r154 == null) goto L343;
        FragmentActivity r155 = r154.getVid();
    L344:
        UplinkEntityContent r156 = r210.getUplinkEntityContent();
        if (r156 == null) goto L351;
        UplinkFileInfo r157 = r156.getUplinkFileInfo();
        if (r157 == null) goto L351;
        VideoExtension r158 = r157.getVideo();
        if (r158 == null) goto L351;
        FragmentActivity r213 = r158.getDownloadUrl();
    L352:
        UplinkEntityContent r159 = r210.getUplinkEntityContent();
        if (r159 == null) goto L359;
        UplinkFileInfo r160 = r159.getUplinkFileInfo();
        if (r160 == null) goto L359;
        VideoExtension r161 = r160.getVideo();
        if (r161 == null) goto L359;
        FragmentActivity r214 = r161.getDownloadFilehash();
    L360:
        UplinkEntityContent r162 = r210.getUplinkEntityContent();
        if (r162 == null) goto L369;
        UplinkFileInfo r163 = r162.getUplinkFileInfo();
        if (r163 == null) goto L369;
        VideoExtension r164 = r163.getVideo();
        if (r164 == null) goto L369;
        Float r165 = r164.getDuration();
        if (r165 == null) goto L369;
        FragmentActivity r215 = Double.valueOf(r165.floatValue());
    L370:
        UplinkEntityContent r166 = r210.getUplinkEntityContent();
        if (r166 == null) goto L377;
        UplinkFileInfo r167 = r166.getUplinkFileInfo();
        if (r167 == null) goto L377;
        VideoExtension r168 = r167.getVideo();
        if (r168 == null) goto L377;
        FragmentActivity r216 = r168.getFormat();
    L378:
        UplinkEntityContent r169 = r210.getUplinkEntityContent();
        if (r169 == null) goto L385;
        UplinkFileInfo r170 = r169.getUplinkFileInfo();
        if (r170 == null) goto L385;
        VideoExtension r171 = r170.getVideo();
        if (r171 == null) goto L385;
        FragmentActivity r217 = r171.getPath();
    L386:
        UplinkEntityContent r172 = r210.getUplinkEntityContent();
        if (r172 == null) goto L397;
        UplinkFileInfo r173 = r172.getUplinkFileInfo();
        if (r173 == null) goto L397;
        VideoExtension r174 = r173.getVideo();
        if (r174 == null) goto L397;
        Image r175 = r174.getCover();
        if (r175 == null) goto L397;
        ImageObj r176 = r175.imageOri;
        if (r176 == null) goto L397;
        FragmentActivity r218 = r176.url;
    L398:
        UplinkEntityContent r177 = r210.getUplinkEntityContent();
        if (r177 == null) goto L407;
        UplinkFileInfo r178 = r177.getUplinkFileInfo();
        if (r178 == null) goto L407;
        VideoExtension r179 = r178.getVideo();
        if (r179 == null) goto L407;
        Image r180 = r179.getCover();
        if (r180 == null) goto L407;
        FragmentActivity r310 = r180.key;
    L408:
        UplinkEntityContent r181 = r210.getUplinkEntityContent();
        if (r181 == null) goto L419;
        UplinkFileInfo r182 = r181.getUplinkFileInfo();
        if (r182 == null) goto L419;
        VideoExtension r183 = r182.getVideo();
        if (r183 == null) goto L419;
        Image r184 = r183.getCover();
        if (r184 == null) goto L419;
        ImageObj r185 = r184.imageOri;
        if (r185 == null) goto L419;
        int r186 = r185.height;
    L420:
        Integer r311 = Integer.valueOf(r186);
        UplinkEntityContent r187 = r210.getUplinkEntityContent();
        if (r187 == null) goto L431;
        UplinkFileInfo r188 = r187.getUplinkFileInfo();
        if (r188 == null) goto L431;
        VideoExtension r189 = r188.getVideo();
        if (r189 == null) goto L431;
        Image r190 = r189.getCover();
        if (r190 == null) goto L431;
        ImageObj r191 = r190.imageOri;
        if (r191 == null) goto L431;
        int r192 = r191.width;
    L432:
        os8.b.c r193 = new os8.b.c(new nr9.g(r155, null, r213, r214, r215, r216, new nr9.f(null, r218, r310, r311, Integer.valueOf(r192), null, 33), r217, l1.g(r210), null, 514), r147, false);
        r150.getClass();
        com.larus.bmhome.video.fragment.b0.a(r151, r193);
        return;
    L431:
        r192 = 0;
    L419:
        r186 = 0;
    L407:
        r310 = r111;
    L397:
        r218 = r111;
    L385:
        r217 = r111;
    L377:
        r216 = r111;
    L369:
        r215 = r111;
    L359:
        r214 = r111;
    L351:
        r213 = r111;
    L343:
        r155 = r111;
        goto L344
    L465:
        return;
    L334:
        r149 = r111;
        goto L335
    L330:
        r212 = r111;
        goto L331
    L122:
        if (n1.d(r210) != r58) goto L124;
        r60 = true;
        goto L125
    L115:
        if (StringsKt.isBlank(r57) == true) goto L118;
        r58 = true;
        r59 = false;
    L112:
        r57 = r111;
        goto L113
    L104:
        r54 = false;
    L96:
        if (r7 == null) goto L100;
        String r194 = l1.a(r7);
        if (r194 == null) goto L100;
        r50 = null;
        r110 = StringsKt.substringAfterLast$default(r194, '.', null, 2, null);
    L100:
        r50 = null;
        r110 = null;
        goto L101
    L89:
        r48 = null;
        goto L91
    L466:
        return;
    L71:
        th = move-exception;
        Result.Companion r195 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        th = move-exception;
        Result.Companion r196 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L51:
        r30 = null;
    L83:
        r28 = "<this>";
        r42 = false;
    L43:
        r26 = null;
    L22:
        r17 = Long.MAX_VALUE;
        goto L24
    L12:
        r5 = null;
        goto L13
    L14:
        r7 = null;
        goto L15
    }

    public static String k(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L14;
        if (r2 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r2.length() + ",hash=" + r2.hashCode();
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final Object d(String r7, Continuation<? super ic8.g> r8) {
        if ((r8 instanceof NestedFileClickHelper$getAudioParseResult$1) == false) goto L7;
        NestedFileClickHelper$getAudioParseResult$1 r0 = (NestedFileClickHelper$getAudioParseResult$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        ic8.g r10 = (ic8.g) r9;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[getAudioParseResult] hasDocUrl:");
        String r6 = null;
        if (r10 == null) goto L20;
        String r11 = r10.b();
    L21:
        boolean r12 = false;
        if (r11 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        r5.append(!r13);
        r5.append(", hasDetailUrl:");
        if (r10 == null) goto L31;
        r6 = r10.a();
    L31:
        if (r6 != null) goto L33;
    L34:
        r12 = true;
    L35:
        r5.append(!r12);
        r4.i("NestedFileClickHelper", r5.toString());
        return r9;
    L33:
        if (StringsKt.isBlank(r6) == false) goto L35;
    L24:
        if (StringsKt.isBlank(r11) == true) goto L27;
        r13 = false;
        goto L28
    L20:
        r11 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        AttachmentUtil r14 = AttachmentUtil.a;
        List<String> r15 = CollectionsKt.listOf(r7);
        r0.label = 1;
        r9 = r14.b(r15, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new NestedFileClickHelper$getAudioParseResult$1(this, r8);
        goto L8
    }

    public static UploadLarkDoc a(Message r7, String r8, UplinkFileInfo r9) {
        List r10 = r7.getContentBlock();
        if (r10 == null) goto L11;
        Sequence r11 = CollectionsKt.asSequence(r10);
        if (r11 == null) goto L11;
        Sequence r12 = SequencesKt.mapNotNull(r11, new c());
        if (r12 == null) goto L11;
        Sequence r13 = SequencesKt.flattenSequenceOfIterable(r12);
        if (r13 == null) goto L11;
        List r14 = SequencesKt.toList(r13);
    L12:
        if (r14 != null) goto L15;
        r14 = CollectionsKt.emptyList();
    L15:
        if (r8 != null) goto L17;
    L39:
        if (r9 == null) goto L81;
        String r15 = r9.getTosKey();
        if (r15 != null) goto L43;
        return null;
    L43:
        if ((!StringsKt.isBlank(r15)) == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L84;
        Iterator r16 = r14.iterator();
    L50:
        if (r16.hasNext() == false) goto L66;
        Object r17 = r16.next();
        UploadLarkDoc r3 = ((AttachmentItem) r17).getLarkDoc();
        if (r3 != null) goto L54;
    L63:
        boolean r4 = false;
    L64:
        if (r4 == false) goto L50;
    L67:
        AttachmentItem r18 = (AttachmentItem) r17;
        if (r18 != null) goto L70;
        return null;
    L70:
        return r18.getLarkDoc();
    L54:
        if (Intrinsics.areEqual(r3.getToken(), r15) == true) goto L62;
        String r5 = r3.getUrl();
        if (r5 != null) goto L58;
    L60:
        boolean r6 = false;
    L61:
        if (r6 == false) goto L63;
    L58:
        if (StringsKt.contains$default(r5, r15, false, 2, null) != true) goto L60;
        r6 = true;
    L62:
        r4 = true;
        goto L64
    L66:
        r17 = null;
        goto L67
    L84:
        return null;
    L81:
        return null;
    L17:
        if ((!StringsKt.isBlank(r8)) == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L39;
        Iterator r19 = r14.iterator();
    L23:
        if (r19.hasNext() == false) goto L32;
        Object r20 = r19.next();
        AttachmentItem r21 = (AttachmentItem) r20;
        if (Intrinsics.areEqual(r21.getIdentifier(), r8) == true) goto L27;
    L29:
        boolean r22 = false;
    L30:
        if (r22 == false) goto L23;
    L33:
        AttachmentItem r23 = (AttachmentItem) r20;
        if (r23 == null) goto L36;
        UploadLarkDoc r24 = r23.getLarkDoc();
    L37:
        if (r24 == null) goto L39;
        return r24;
    L36:
        r24 = null;
        goto L37
    L27:
        if (r21.getLarkDoc() == null) goto L29;
        r22 = true;
        goto L30
    L32:
        r20 = null;
    L11:
        r14 = null;
        goto L12
    }

    public static void j(BotModel r3, Message r4, String r5) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        if (r3 == null) goto L5;
        Object r6 = r3.getBotId();
    L6:
        r1.put("bot_id", r6);
        r1.put("message_id", r4.getMessageId());
        r1.put("conversation_id", r4.getConversationId());
        r1.put("user_type", "user");
        r1.put("pic_position", "0");
        r1.put("pic_id", r5);
        r1.put("is_onboarding", com.larus.bmhome.chat.bean.d.z0(r4) ? 1 : 0);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("picture_message_click", r1);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final Object b(String r5, String r6, Continuation<? super String> r7) {
        if ((r7 instanceof NestedFileClickHelper$getAudioDetailUrlByResourceId$1) == false) goto L7;
        NestedFileClickHelper$getAudioDetailUrlByResourceId$1 r0 = (NestedFileClickHelper$getAudioDetailUrlByResourceId$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        String r9 = (String) r8;
        FLogger r10 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[getAudioDetailUrlByResourceId] resourceId:");
        a.getClass();
        r4.append(k(r6));
        r4.append(", hasUrl:");
        if (r9 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        r4.append(!r11);
        r10.i("NestedFileClickHelper", r4.toString());
        return r9;
    L24:
        if (StringsKt.isBlank(r9) == true) goto L27;
        r11 = false;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 == null) goto L29;
        String r12 = p0.a(r6);
        if (r12 == null) goto L29;
        ResourceCenter r13 = ResourceCenter.a;
        r0.L$0 = r6;
        r0.label = 1;
        r8 = r13.e(r12, r5, r0);
        if (r8 != r2) goto L21;
        return r2;
    L29:
        return null;
    L7:
        r0 = new NestedFileClickHelper$getAudioDetailUrlByResourceId$1(this, r7);
        goto L8
    }

    public final Object c(String r7, String r8, Continuation<? super String> r9) {
        if ((r9 instanceof NestedFileClickHelper$getAudioDetailUrlByTosKey$1) == false) goto L7;
        NestedFileClickHelper$getAudioDetailUrlByTosKey$1 r0 = (NestedFileClickHelper$getAudioDetailUrlByTosKey$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        HashMap r11 = (HashMap) r10;
        if (r11 == null) goto L29;
        if (r8 == null) goto L26;
        r4 = r8;
    L26:
        AudioFileDetail r12 = (AudioFileDetail) r11.get(r4);
        if (r12 == null) goto L29;
        String r13 = r12.a();
    L30:
        FLogger r14 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[getAudioDetailUrlByTosKey] tosKey:");
        r5.append(k(r8));
        r5.append(", hasUrl:");
        if (r13 != null) goto L33;
    L36:
        boolean r15 = true;
    L37:
        r5.append(!r15);
        r14.i("NestedFileClickHelper", r5.toString());
        return r13;
    L33:
        if (StringsKt.isBlank(r13) == true) goto L36;
        r15 = false;
    L29:
        r13 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        AttachmentUtil r16 = AttachmentUtil.a;
        String r6 = AccountService.a.getUserId();
        if (r8 != null) goto L17;
        String r17 = "";
    L18:
        List<String> r18 = CollectionsKt.listOf(r17);
        r0.L$0 = r8;
        r0.label = 1;
        r10 = r16.a(r7, r6, r18, r0);
        if (r10 != r2) goto L21;
        return r2;
    L17:
        r17 = r8;
    L7:
        r0 = new NestedFileClickHelper$getAudioDetailUrlByTosKey$1(this, r9);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.list.cell.nested_file.e, kotlin.jvm.functions.Function0] */
    public static void e(final String r27, final Message r28, final Context r29, final UplinkFileEntity r30, final lr8.a r31, final boolean r32) {
        final String r4 = com.larus.bmhome.chat.sendimage.e.h(r28, r27);
        String r14 = null;
        if (r30 == null) goto L7;
        UplinkEntityContent r0 = r30.getUplinkEntityContent();
        if (r0 == null) goto L7;
        UplinkFileInfo r15 = r0.getUplinkFileInfo();
    L8:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("open file, localId=");
        r2.append(k(r28.getLocalMessageId()));
        r2.append(", hasLocalPath=");
        boolean r16 = false;
        if (r4 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        r2.append(!r3);
        r2.append(", hasRemoteIdentity=");
        if (r15 == null) goto L18;
        String r5 = r15.getTosKey();
    L19:
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        r2.append(!r6);
        r1.i("NestedFileClickHelper", r2.toString());
        List r7 = r28.getContentBlock();
        if (r7 == null) goto L70;
        Sequence r8 = CollectionsKt.asSequence(r7);
        if (r8 == null) goto L70;
        Sequence r9 = SequencesKt.mapNotNull(r8, new f());
        if (r9 == null) goto L70;
        Sequence r10 = SequencesKt.flattenSequenceOfIterable(r9);
        if (r10 == null) goto L70;
        Iterator r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L39;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((AttachmentItem) r12).getIdentifier(), r27) == false) goto L35;
    L40:
        AttachmentItem r13 = (AttachmentItem) r12;
        if (r13 == null) goto L70;
        UploadFile r17 = r13.getFile();
        if (r17 == null) goto L70;
        String r18 = r17.getUrl();
        if (r18 == null) goto L70;
        String r19 = p0.a(r18);
        if (r19 == null) goto L70;
        a.getClass();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L55
        String r21 = UriProtector.getQueryParameter(UriProtector.parse(r19), "x-expires");     // Catch: Throwable -> L55
        if (r21 == null) goto L52;
        Long r22 = StringsKt.toLongOrNull(r21);     // Catch: Throwable -> L55
    L53:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r23) == false) goto L60;
        r23 = null;
    L60:
        Long r24 = (Long) r23;
        if (r24 != null) goto L63;
    L65:
        boolean r25 = false;
    L66:
        if (r25 == true) goto L68;
        FLogger.a.i("NestedFileClickHelper", "readonly forward file url expired or invalid, fallback to sign by uri");
    L68:
        if (r25 == false) goto L70;
        String r26 = r19;
    L71:
        if (r32 == false) goto L73;
        final String r110 = r26;
    L74:
        final UplinkFileInfo r33 = r15;
        ?? r34 = new e(r30, r27, r4, r28, r29, r33, r31, r32, r110);
        CoroutineScope r35 = r31.c();
        UploadLarkDoc r36 = a(r28, r27, r15);
        if (r30 == null) goto L82;
        Integer r37 = r30.getUpLinkStatus();
        int r38 = UpLinkState.SUCCESS.getValue();
        if (r37 == null) goto L82;
        if (r37.intValue() != r38) goto L82;
        boolean r111 = true;
    L83:
        if (r30 == null) goto L87;
        Map r39 = r30.getExtra();
        if (r39 == null) goto L87;
        String r40 = (String) r39.get("drive_uplink_info");
    L88:
        if (r40 != null) goto L90;
    L93:
        boolean r41 = true;
    L94:
        if (r41 == true) goto L108;
        FlowDriveSdkService r42 = FlowDriveSdkService.a;
        String r43 = r28.getConversationId();
        if (r43 != null) goto L101;
        wc9.e r44 = r31.h();
        if (r44 == null) goto L100;
        r43 = r44.a;
        goto L101
    L100:
        r43 = null;
    L101:
        BotModel r45 = r31.i();
        if (r45 == null) goto L104;
        r14 = r45.getBotId();
    L104:
        r42.getClass();
        if (FlowDriveSdkService.B(r29, r40, r43, r14) == true) goto L191;
        r34.invoke();
        return;
    L191:
        return;
    L108:
        if (r15 == null) goto L130;
        String r46 = r15.getTosKey();
        if (r46 == null) goto L130;
        if (r111 == true) goto L113;
    L127:
        boolean r112 = false;
    L128:
        if (r112 == false) goto L130;
        String r113 = r46;
    L131:
        if (r35 == null) goto L184;
        if (r113 == null) goto L184;
        wc9.e r47 = r31.h();
        if (r47 != null) goto L137;
    L139:
        if (r16 == false) goto L141;
        AiFilePreviewScene r48 = AiFilePreviewScene.P2P_CHAT;
    L142:
        AiFilePreviewScene r114 = r48;
        FlowDriveSdkService r49 = FlowDriveSdkService.a;
        if (r36 == null) goto L146;
        String r50 = r36.getTitle();
        if (r50 == null) goto L146;
    L147:
        String r210 = r50;
        String r51 = r15.getMimeType();
        if (r51 != null) goto L153;
        String r52 = r15.getFileName();
        if (r52 == null) goto L152;
        r51 = StringsKt.substringAfterLast(r52, '.', "");
        goto L153
    L152:
        String r211 = null;
    L154:
        String r212 = r15.getResourceId();
        String r53 = r28.getConversationId();
        if (r53 != null) goto L157;
    L161:
        if (r47 == null) goto L167;
        r53 = r47.a;
        if (r53 == null) goto L167;
        if ((!StringsKt.isBlank(r53)) == false) goto L167;
    L166:
        String r213 = r53;
    L168:
        BotModel r54 = r31.i();
        if (r54 == null) goto L175;
        String r55 = r54.getBotId();
        if (r55 == null) goto L175;
        if ((!StringsKt.isBlank(r55)) == false) goto L175;
        String r214 = r55;
    L176:
        String r56 = r28.getMessageId();
        if (r56 != null) goto L179;
    L181:
        String r215 = null;
    L182:
        r49.j(r29, r35, new cr9.a(r113, r114, r210, r211, r26, r212, r213, r214, r215), r34);
        return;
    L179:
        if ((!StringsKt.isBlank(r56)) == false) goto L181;
        r215 = r56;
    L175:
        r214 = null;
    L167:
        r213 = null;
        goto L168
    L157:
        if ((!StringsKt.isBlank(r53)) == true) goto L160;
        r53 = null;
    L160:
        if (r53 != null) goto L166;
    L153:
        r211 = r51;
    L146:
        r50 = r15.getFileName();
        goto L147
    L141:
        r48 = AiFilePreviewScene.AI_CHAT;
        goto L142
    L137:
        if (ve8.c.a(r47) != true) goto L139;
        r16 = true;
    L184:
        r34.invoke();
        return;
    L113:
        if (CollectionsKt.contains(SetsKt.setOf(new Integer[]{Integer.valueOf(FileType.FileTypeFile.getValue()), Integer.valueOf(FileType.FileTypeAudio.getValue())}), r15.getFileType()) == false) goto L127;
        if ((!StringsKt.isBlank(r46)) == false) goto L127;
        if (r36 == null) goto L118;
        String r57 = r36.getToken();
    L119:
        if (r57 != null) goto L121;
    L124:
        boolean r115 = true;
    L125:
        if (r115 == false) goto L127;
        r112 = true;
        goto L128
    L121:
        if (StringsKt.isBlank(r57) == true) goto L124;
        r115 = false;
        goto L125
    L118:
        r57 = null;
    L130:
        r113 = null;
        goto L131
    L90:
        if (StringsKt.isBlank(r40) == true) goto L93;
        r41 = false;
    L87:
        r40 = null;
    L82:
        r111 = false;
        goto L83
    L73:
        r110 = null;
        goto L74
    L63:
        if (r24.longValue() <= (AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000))) goto L65;
        r25 = true;
        goto L66
    L52:
        r22 = null;
    L55:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L39:
        r12 = null;
    L70:
        r26 = null;
        goto L71
    L21:
        if (StringsKt.isBlank(r5) == true) goto L24;
        r6 = false;
        goto L25
    L18:
        r5 = null;
        goto L19
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r3 = false;
    L7:
        r15 = null;
        goto L8
    }

    public static void f(String r13, String r14, Message r15, Context r16, UplinkFileInfo r17, String r18, lr8.a r19) {
        Intrinsics.checkNotNullParameter(r15, "message");
        Intrinsics.checkNotNullParameter(r16, "cxt");
        Intrinsics.checkNotNullParameter(r19, "delegate");
        if (r13 != null) goto L5;
        String r4 = UUID.randomUUID().toString();
    L6:
        String r0 = null;
        if (r17 == null) goto L11;
        String r5 = r17.getTosKey();
        if (r5 == null) goto L11;
        String r6 = p0.a(r5);
    L13:
        if (NetworkUtils.isNetworkAvailable(r16) == true) goto L19;
        t19.s.a.g(r16, 2131907052, false);
        int r1 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r2 = r15.getMessageId();
        if (r17 == null) goto L17;
        r0 = r17.getResourceId();
    L17:
        com.larus.bmhome.chat.trace.multimodal.a.d(r4, r2, false, "message_file_open_no_net_work", r6, r0);
        return;
    L19:
        CoroutineScope r9 = r19.c();
        if (r9 == null) goto L23;
        BuildersKt.launch$default(r9, null, null, new NestedFileClickHelper$openAudio$1(r16, r4, r15, r6, r17, r14, r18, null), 3, null);
        return;
    L23:
        return;
    L11:
        r6 = null;
        goto L13
    L5:
        r4 = r13;
        goto L6
    }

    public static void h(Context r14, String r15, String r16, UplinkFileInfo r17, Message r18, String r19, com.larus.office.base.w.a r20) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r20, "delegate");
        CoroutineScope r10 = r20.a;
        if (r10 == null) goto L6;
        BuildersKt.launch$default(r10, null, null, new NestedFileClickHelper$openFileAfterSign$1(r17, r15, r14, r16, null, r18, r19, r20, null), 3, null);
        return;
    }

    public static void g(Context r14, String r15, UplinkFileInfo r16, String r17, Message r18, lr8.g r19, String r20, lr8.a r21) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r21, "delegate");
        if (r17 != null) goto L5;
        String r3 = UUID.randomUUID().toString();
    L7:
        if (r15 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        String r6 = null;
        if (r5 == false) goto L15;
        String r7 = r15;
    L19:
        if (r7 == null) goto L44;
        ImFileUtil r4 = ImFileUtil.a;
        if (r16 == null) goto L24;
        String r8 = r16.getFileName();
        if (r8 == null) goto L24;
    L25:
        r4.getClass();
        if (ImFileUtil.B(r14, r7, r8, null) == false) goto L35;
        int r1 = MultimodalSendCostTrace.a;
        if (r16 == null) goto L30;
        String r2 = r16.getTosKey();
    L31:
        String r9 = r18.getMessageId();
        if (r16 == null) goto L34;
        r6 = r16.getResourceId();
    L34:
        MultimodalSendCostTrace.f(r3, r2, r9, true, r6);
        return;
    L30:
        r2 = null;
        goto L31
    L35:
        int r0 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r10 = r18.getMessageId();
        if (r16 == null) goto L38;
        String r11 = r16.getTosKey();
    L39:
        if (r16 == null) goto L41;
        String r12 = r16.getResourceId();
    L42:
        com.larus.bmhome.chat.trace.multimodal.a.d(r3, r10, true, "message_file_open_third_party_error", r11, r12);
        return;
    L41:
        r12 = null;
        goto L42
    L38:
        r11 = null;
    L24:
        r8 = "";
        goto L25
    L44:
        if (NetworkUtils.isNetworkAvailable(r14) == true) goto L53;
        t19.s.a.g(r14, 2131908080, false);
        int r13 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r22 = r18.getMessageId();
        if (r16 == null) goto L48;
        String r23 = r16.getTosKey();
    L49:
        if (r16 == null) goto L51;
        String r24 = r16.getResourceId();
    L52:
        com.larus.bmhome.chat.trace.multimodal.a.d(r3, r22, false, "message_file_open_no_net_work", r23, r24);
        return;
    L51:
        r24 = null;
        goto L52
    L48:
        r23 = null;
        goto L49
    L53:
        if (r16 == null) goto L63;
        CoroutineScope r25 = r21.c();
        if (r25 == null) goto L62;
        BuildersKt.launch$default(r25, null, null, new NestedFileClickHelper$loadFileFromTos$1(r14, r18, r3, r16, r19, r20, r21, null), 3, null);
        return;
    L62:
        return;
    L63:
        return;
    L15:
        r7 = ChatInputService.b.f().d() + r20;
        if (m5.c(r7) == true) goto L19;
        r7 = null;
        goto L19
    L9:
        if (m5.c(r15) != true) goto L11;
        r5 = true;
        goto L12
    L5:
        r3 = r17;
        goto L7
    }
}

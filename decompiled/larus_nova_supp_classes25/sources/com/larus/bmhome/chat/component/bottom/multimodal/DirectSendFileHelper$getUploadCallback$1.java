package com.larus.bmhome.chat.component.bottom.multimodal;

import ai8.f;
import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DirectSendFileHelper$getUploadCallback$1 extends com.larus.bmhome.chat.component.bottom.multimodal.upload.a {
    public final /* synthetic */ String A;
    public final /* synthetic */ String B;
    public final /* synthetic */ String C;
    public final /* synthetic */ ReferenceInfo D;
    public final /* synthetic */ boolean E;
    public final /* synthetic */ List<UplinkFileEntity> F;
    public final /* synthetic */ Message G;
    public final /* synthetic */ boolean H;
    public final /* synthetic */ wc9.e I;
    public final /* synthetic */ ChatPageContext J;
    public final /* synthetic */ DirectSendData K;
    public final /* synthetic */ String y;
    public final /* synthetic */ UplinkFileEntity z;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ String a;
        public final /* synthetic */ List<UplinkFileEntity> b;
        public final /* synthetic */ UplinkFileEntity c;
        public final /* synthetic */ DirectSendFileHelper$getUploadCallback$1 d;
        public final /* synthetic */ String e;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            FLogger.a.e("DirectSendFileHelper", "[IM Callback] notify message fail: " + this.a + "(file-" + this.b.indexOf(this.c) + "), errorCode = " + r5.getCode() + ", errorMsg = " + r5.getTips());
            this.d.i(this.e);
        }

        public final void onSuccess(Object r4) {
            Intrinsics.checkNotNullParameter((Message) r4, "result");
            FLogger.a.i("DirectSendFileHelper", "[IM Callback] notify message success: " + this.a + "(file-" + this.b.indexOf(this.c) + ')');
            this.d.i(this.e);
        }

        public a(String r1, List<UplinkFileEntity> r2, UplinkFileEntity r3, DirectSendFileHelper$getUploadCallback$1 r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ String a;

        public final boolean mustInMain() {
            return true;
        }

        public b(String r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.i("DirectSendFileHelper", "========== Send message fail(msg-" + this.a + "), errorCode = " + r4.getCode() + ", errorMsg = " + r4.getTips() + " ==========");
        }

        public final void onSuccess(Object r3) {
            Intrinsics.checkNotNullParameter((List) r3, "result");
            FLogger.a.i("DirectSendFileHelper", "========== Send message success(msg-" + this.a + ") ==========");
        }
    }

    public final void g() {
        this.F.remove(this.z);
        if (this.E == false) goto L5;
        h("delete file");
    L7:
        if (this.F.isEmpty() == true) goto L9;
        return;
    L9:
        if (this.E == true) goto L11;
        return;
    L11:
        if (this.G == null) goto L16;
        FLogger.a.i("DirectSendFileHelper", "[Update DB] all files preprocess failed, delete this message");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DirectSendFileHelper$getUploadCallback$1$deleteFile$1(this.G, null), 3, null);
        return;
    L16:
        return;
    L5:
        i("");
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void c(boolean r1) {
        if (r1 == false) goto L5;
        g();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public final void d(ic8.n0 r5) {
        Intrinsics.checkNotNullParameter(r5, "processResult");
        super.d(r5);
        ProcessFileResultCode r0 = r5.b;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isSuccess() != true) goto L7;
    L9:
        if (r1 == true) goto L11;
        FLogger.a.i("DirectSendFileHelper", "Preprocess file failed by " + r5.b + ", delete file item in this message");
        g();
        return;
    L11:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("Preprocess ");
        ic8.m0 r6 = r5.a;
        if (r6 == null) goto L14;
        String r7 = r6.d;
    L15:
        r3.append(r7);
        r3.append(" file success");
        r2.i("DirectSendFileHelper", r3.toString());
        if (this.E == false) goto L20;
        h("preprocess success");
        return;
    L20:
        return;
    L14:
        r7 = null;
    L7:
        r1 = false;
        goto L9
    }

    public final void h(String r12) {
        FLogger r0 = FLogger.a;
        r0.i("DirectSendFileHelper", "[Update DB] notify message changed: " + r12 + "(file-" + this.z.getFileIdentifier() + ')');
        NestedFileContent r1 = new NestedFileContent(this.F, null, false, null, 14, null);
        boolean r4 = true;
        if (this.H == false) goto L5;
        String r2 = DirectSendFileHelper.d.incrementAndGet() + '-' + r12 + "-file" + this.F.indexOf(this.z);
    L6:
        String r10 = r2;
        if (this.H == false) goto L26;
        e r3 = DirectSendFileHelper.c.get(this.y);
        if (r3 == null) goto L22;
        monitor-enter(r3);
        Intrinsics.checkNotNullParameter(r10, "taskId");     // Catch: Throwable -> L19
        if (r3.b == false) goto L15;
        monitor-exit(r3);
        boolean r5 = false;
    L17:
        if (r5 != true) goto L22;
    L23:
        if (r4 == true) goto L29;
        r0.i("DirectSendFileHelper", "Ignore task after message sent: " + r10);
        return;
    L29:
        r0.i("DirectSendFileHelper", "Add task: " + r10);
        u1$a.g(zh8.a.a.getSender(), this.I.a, this.y, r1, new a(r12, this.F, this.z, this, r10));
        return;
    L15:
        r5 = r3.a.add(r10);     // Catch: Throwable -> L19
        monitor-exit(r3);
    L19:
        th = move-exception;
        throw th;
    L22:
        r4 = false;
        goto L23
    L26:
        List r6 = (List) ((LinkedHashMap) DirectSendFileHelper.a).get(this.y);
        if (r6 == null) goto L29;
        r6.add(r10);
        goto L29
    L5:
        StringBuilder r7 = new StringBuilder();
        int r8 = DirectSendFileHelper.b + 1;
        DirectSendFileHelper.b = r8;
        r7.append(r8);
        r7.append('-');
        r7.append(r12);
        r7.append("-file");
        r7.append(this.F.indexOf(this.z));
        r2 = r7.toString();
        goto L6
    }

    public final void i(String r24) {
        if (this.H == false) goto L63;
        List<UplinkFileEntity> r2 = this.F;
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (l1.l((UplinkFileEntity) r3.next()) == true) goto L11;
        boolean r4 = false;
    L16:
        if (r4 == false) goto L37;
        List<UplinkFileEntity> r5 = this.F;
        if ((r5 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L34;
        Integer r7 = ((UplinkFileEntity) r6.next()).getUpLinkStatus();
        int r8 = UpLinkState.SUCCESS.getValue();
        if (r7 != null) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == false) goto L24;
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
        boolean r11 = true;
    L38:
        e r12 = DirectSendFileHelper.c.get(this.y);
        if (r12 == null) goto L115;
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter(r24, "taskId");     // Catch: Throwable -> L60
        if (r24.length() <= 0) goto L44;
        boolean r13 = true;
    L45:
        if (r13 == false) goto L48;
        r12.a.remove(r24);     // Catch: Throwable -> L60
    L48:
        if (r12.b == true) goto L56;
        if (r11 == false) goto L56;
        if ((!r12.a.isEmpty()) == true) goto L56;
        r12.b = true;     // Catch: Throwable -> L60
        monitor-exit(r12);
        boolean r14 = true;
    L58:
        if (r14 != true) goto L115;
    L114:
        boolean r15 = true;
    L117:
        if (this.H == true) goto L119;
    L124:
        if (r15 == false) goto L298;
        FLogger.a.i("DirectSendFileHelper", "[Update DB] send message(" + this.y + ')');
        ArrayList r16 = new ArrayList();
        Map r17 = MapsKt.toMutableMap(ILegacyChatUiServiceDelegate.b.S8(new Pair[0]));
        String r0 = this.C;
        DirectSendData r18 = this.K;
        if (r0 != null) goto L128;
        r0 = "";
    L128:
        r17.put("enter_method_trace", r0);
        if (r18 == null) goto L133;
        Map r1 = r18.getMsgExtMap();
        if (r1 == null) goto L133;
        r17.putAll(r1);
    L133:
        NestedFileContent r19 = new NestedFileContent(this.F, null, false, null, 14, null);
        String r110 = this.y;
        ReferenceInfo r111 = this.D;
        LinkedHashMap r20 = new LinkedHashMap();
        List<UplinkFileEntity> r21 = this.F;
        DirectSendData r22 = this.K;
        r20.putAll(r17);
        UplinkFileEntity r23 = (UplinkFileEntity) CollectionsKt.firstOrNull(r21);
        if (r23 == null) goto L140;
        Uri r25 = r23.getUri();
        if (r25 == null) goto L140;
        int r26 = com.larus.utils.p0.a;
        String r27 = com.larus.utils.p0.a(sr9.b.b.f(r25.toString()));
        if (r27 == null) goto L140;
        String r28 = (String) r20.put("content_source", r27);
    L140:
        if (r22 == null) goto L147;
        Map r29 = r22.getEventExtra();
        if (r29 == null) goto L147;
        String r30 = (String) r29.get("content_source");
        if (r30 == null) goto L147;
        String r31 = (String) r20.put("content_source", r30);
    L147:
        if (IBachDetectCenterAbility.a.b() == false) goto L174;
        Iterator<T> r32 = r21.iterator();
    L150:
        if (r32.hasNext() == false) goto L174;
        UplinkFileEntity r33 = (UplinkFileEntity) r32.next();
        if (n1.d(r33) == false) goto L150;
        UplinkEntityContent r34 = r33.getUplinkEntityContent();
        if (r34 == null) goto L150;
        Image r35 = r34.getUplinkImageInfo();
        if (r35 == null) goto L150;
        String r36 = r35.localResPath;
        if (r36 == null) goto L150;
        PolarisFileWrapper r37 = new PolarisFileWrapper(r36);
        if (r37.exists() == true) goto L267;
    L173:
        Unit r38 = Unit.INSTANCE;
        goto L150
    L267:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L163
        Object r40 = Result.constructor-impl(Uri.fromFile(r37));     // Catch: Throwable -> L163
    L166:
        if (Result.isSuccess-impl(r40) == false) goto L173;
        Uri r41 = (Uri) r40;
        IBachDetectCenterAbility.Companion r42 = IBachDetectCenterAbility.a;
        Intrinsics.checkNotNull(r41);
        Boolean r43 = r42.c(r41, true);
        if (r43 == null) goto L173;
        if (r43.booleanValue() == false) goto L172;
        r20.put(IAIChatUgcAIGCService.a.F0(), "1");
    L172:
        Unit r44 = Unit.INSTANCE;
    L163:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L174:
        Unit r46 = Unit.INSTANCE;
        r16.add(new f(r19, r110, null, r111, r20, null, false, null, this.J, null, 740));
        DirectSendData r47 = this.K;
        if (r47 != null) goto L177;
    L240:
        DirectSendData r48 = this.K;
        if (r48 == null) goto L246;
        Map r49 = r48.getEventExtra();
        if (r49 == null) goto L246;
        String r50 = (String) r49.get("scene");
        if (r50 == null) goto L246;
    L247:
        String r112 = r50;
        DirectSendData r51 = this.K;
        if (r51 == null) goto L251;
        String r52 = r51.getSceneForText();
        if (r52 == null) goto L251;
    L252:
        String r53 = r52;
        DirectSendData r54 = this.K;
        if (r54 == null) goto L257;
        t1a.b r55 = r54.getVContext();
        if (r55 == null) goto L257;
        gd8.g r56 = (gd8.g) r55.getAbility(gd8.g.class);
    L258:
        gd8.g r57 = r56;
        if (r57 == null) goto L261;
        gd8.g.a.a(r57, this.I, r53, r16, r112, null, null, 48);
    L262:
        Map<String, List<String>> r58 = DirectSendFileHelper.a;
        String r59 = this.y;
        if (this.H == false) goto L265;
        DirectSendFileHelper.c.remove(r59);
        return;
    L265:
        DirectSendFileHelper.a.remove(r59);
        return;
    L261:
        u1 r60 = zh8.a.a.getSender();
        wc9.e r61 = this.I;
        u1$a.e(r60, r61, r61.a, r53, r16, r112, new b(this.y), false, false, null, 448);
    L257:
        r56 = null;
    L251:
        r52 = this.B;
    L246:
        r50 = this.B;
        goto L247
    L177:
        if (com.larus.utils.o0.d(r47.getDisplayName()) == false) goto L240;
        int r62 = wf9.b.a;
        String r63 = com.flow.kmp.common.util.i.a();
        String r64 = this.K.getDisplayName();
        if (r64 != null) goto L181;
        r64 = "";
    L181:
        r16.add(new ai8.h(r64, r63, null, this.D, r17, null, false, false, this.J, null, 740));
        Map r65 = this.K.getEventExtra();
        if (r65 == null) goto L240;
        String r66 = this.y;
        wc9.e r67 = this.I;
        LruCache r68 = ko8.a.a;
        String r69 = (String) r65.get("onboarding_item_id");
        Intrinsics.checkNotNullParameter(r66, "msgId");
        IAIChatControlTraceService.Companion r70 = IAIChatControlTraceService.a;
        r70.qb(r66, r69);
        String r71 = (String) r65.get("item_type");
        Intrinsics.checkNotNullParameter(r66, "msgId");
        r70.Ga(r66, r71);
        String r72 = (String) r65.get("reco_request_id");
        Intrinsics.checkNotNullParameter(r66, "msgId");
        r70.Oa(r66, r72);
        String r73 = (String) r65.get("onboarding_item_id");
        Intrinsics.checkNotNullParameter(r63, "msgId");
        r70.qb(r63, r73);
        String r74 = (String) r65.get("item_type");
        Intrinsics.checkNotNullParameter(r63, "msgId");
        r70.Ga(r63, r74);
        String r75 = (String) r65.get("reco_request_id");
        Intrinsics.checkNotNullParameter(r63, "msgId");
        r70.Oa(r63, r75);
        LinkedHashMap r76 = new LinkedHashMap();
        String r77 = (String) r65.get("original_content_source");
        if (r77 == null) goto L186;
        r70.Ab(r77, r63);
        r76.put("original_content_source_wcb", r77);
    L186:
        String r78 = (String) r65.get("template_rec_req_id");
        if (r78 == null) goto L189;
        r76.put("template_rec_req_id", r78);
    L189:
        String r79 = (String) r65.get("prompt_type");
        if (r79 == null) goto L192;
        r76.put("prompt_type", r79);
    L192:
        String r80 = (String) r65.get("prompt_from");
        if (r80 == null) goto L195;
        r76.put("prompt_from", r80);
    L195:
        String r81 = (String) r65.get("visual_size");
        if (r81 == null) goto L198;
        r76.put("visual_size", r81);
    L198:
        String r82 = (String) r65.get("ai_creation_recommend_from");
        if (r82 == null) goto L201;
        r76.put("ai_creation_recommend_from", r82);
    L201:
        String r83 = (String) r65.get("from_template_id");
        if (r83 == null) goto L204;
        r76.put("from_template_id", r83);
    L204:
        String r84 = (String) r65.get("from_template_sub_type");
        if (r84 == null) goto L207;
        r76.put("from_template_sub_type", r84);
    L207:
        String r85 = (String) r65.get("tag_code");
        if (r85 == null) goto L210;
        r76.put("tag_code", r85);
    L210:
        String r86 = (String) r65.get("item_id");
        if (r86 == null) goto L213;
        r76.put("item_id", r86);
    L213:
        String r87 = (String) r65.get("upload_pic_cnt");
        if (r87 == null) goto L216;
        r76.put("upload_pic_cnt", r87);
    L216:
        String r88 = (String) r65.get("content_source_entrance_to_record");
        if (r88 == null) goto L219;
        ko8.a.k(r67.a, r88);
    L219:
        String r89 = (String) r65.get("content_source_to_record");
        if (r89 == null) goto L222;
        r76.put("content_source_to_record", r89);
    L222:
        String r90 = (String) r65.get("content_source");
        if (r90 == null) goto L225;
        r76.put("content_source", r90);
    L225:
        String r91 = (String) r65.get("content_source_entrance");
        if (r91 == null) goto L228;
        r76.put("content_source_entrance", r91);
    L228:
        String r92 = (String) r65.get("picture_source_message_id");
        if (r92 == null) goto L231;
        r76.put("picture_source_message_id", r92);
    L231:
        String r93 = (String) r65.get("source_message_id");
        if (r93 == null) goto L234;
        r76.put("source_message_id", r93);
    L234:
        String r94 = (String) r65.get("source_creation_task_id");
        if (r94 == null) goto L238;
        r76.put("source_creation_task_id", r94);
    L238:
        if ((!r76.isEmpty()) == false) goto L240;
        IAIChatRenderTraceService.a.c(r67.a, r76);
        goto L240
    L298:
        return;
    L119:
        if (r24.length() <= 0) goto L121;
        boolean r95 = true;
    L122:
        if (r95 == false) goto L124;
        FLogger.a.i("DirectSendFileHelper", "Remove task: ".concat(r24));
        goto L124
    L121:
        r95 = false;
    L56:
        monitor-exit(r12);
        r14 = false;
        goto L58
    L44:
        r13 = false;
    L60:
        th = move-exception;
        throw th;
    L115:
        r15 = false;
        goto L117
    L29:
        if (r7.intValue() != r8) goto L31;
        r9 = true;
    L34:
        r10 = false;
        goto L35
    L20:
        if (r5.isEmpty() == false) goto L22;
    L37:
        r11 = false;
    L15:
        r4 = true;
        goto L16
    L7:
        if (r2.isEmpty() == false) goto L9;
    L63:
        List r96 = (List) ((LinkedHashMap) DirectSendFileHelper.a).get(this.y);
        if (r24.length() <= 0) goto L66;
        boolean r97 = true;
    L67:
        if (r97 == false) goto L71;
        if (r96 == null) goto L70;
        r96.remove(r24);
    L70:
        FLogger.a.i("DirectSendFileHelper", "Remove task: ".concat(r24));
    L71:
        List<UplinkFileEntity> r99 = this.F;
        if ((r99 instanceof Collection) == true) goto L74;
    L76:
        Iterator<T> r100 = r99.iterator();
    L78:
        if (r100.hasNext() == false) goto L82;
        if (l1.l((UplinkFileEntity) r100.next()) == true) goto L78;
        boolean r101 = false;
    L83:
        if (r101 == false) goto L93;
        List r102 = r96;
        if (r102 != null) goto L87;
    L90:
        boolean r103 = true;
    L91:
        if (r103 == false) goto L93;
        boolean r104 = true;
    L94:
        List<UplinkFileEntity> r105 = this.F;
        if ((r105 instanceof Collection) == true) goto L97;
    L99:
        Iterator<T> r106 = r105.iterator();
    L101:
        if (r106.hasNext() == false) goto L111;
        Integer r107 = ((UplinkFileEntity) r106.next()).getUpLinkStatus();
        int r108 = UpLinkState.SUCCESS.getValue();
        if (r107 != null) goto L106;
    L108:
        boolean r109 = false;
    L109:
        if (r109 == false) goto L101;
        boolean r113 = true;
    L112:
        if (r104 == false) goto L115;
        if (r113 == false) goto L115;
    L106:
        if (r107.intValue() != r108) goto L108;
        r109 = true;
    L111:
        r113 = false;
        goto L112
    L97:
        if (r105.isEmpty() == false) goto L99;
    L87:
        if (r102.isEmpty() == true) goto L90;
        r103 = false;
    L93:
        r104 = false;
    L82:
        r101 = true;
        goto L83
    L74:
        if (r99.isEmpty() == false) goto L76;
    L66:
        r97 = false;
        goto L67
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void a(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        super.a(r2, r4);
        if (this.E == false) goto L6;
        h("progress update" + r2 + "%]");
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void b(mr9.l r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uploadResult");
        Intrinsics.checkNotNullParameter(r11, "fileIdentifier");
        super.b(r10, r11);
        if (this.E == false) goto L5;
        h("upload success");
    L6:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DirectSendFileHelper$getUploadCallback$1$requestPreParse$1(this.z, this.I, this.A, this.y, null), 2, null);
        return;
    L5:
        i("");
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public final void e(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        super.e(r2, r3, r4);
        if (this.E == false) goto L5;
        h("upload fail");
        return;
    L5:
        i("");
    }

    public DirectSendFileHelper$getUploadCallback$1(String r26, UplinkFileEntity r27, String r28, boolean r29, String r30, String r31, String r32, String r33, String r34, String r35, ReferenceInfo r36, boolean r37, List<UplinkFileEntity> r38, Message r39, boolean r40, wc9.e r41, ChatPageContext r42, DirectSendData r43, String r44, Boolean r45, Boolean r46, String r47, String r48) {
        this.y = r26;
        this.z = r27;
        this.A = r28;
        this.B = r30;
        this.C = r32;
        this.D = r36;
        this.E = r37;
        this.F = r38;
        this.G = r39;
        this.H = r40;
        this.I = r41;
        this.J = r42;
        this.K = r43;
        super(r26, r27, r44, r28, r29, r30, r31, r32, r33, r34, r45, r46, r35, r36, r47, r48, null, null, null, null, null, 2031616);
    }
}

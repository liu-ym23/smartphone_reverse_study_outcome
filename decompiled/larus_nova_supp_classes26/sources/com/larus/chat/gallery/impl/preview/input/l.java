package com.larus.chat.gallery.impl.preview.input;

import android.app.Application;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.bmhome.chat.component.bottom.multimodal.h1;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.action.PromptReplacementCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements e0 {
    public final com.larus.chat.gallery.impl.preview.p.a a;
    public Function1<? super Boolean, Unit> b;
    public boolean c;
    public long d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final SuggestedAction i() {
        q0 r0 = this.a.e;
        if (r0 == null) goto L9;
        q0.a r1 = r0.getProvider();
        if (r1 == null) goto L9;
        zb8.e r2 = r1.P8();
        if (r2 == null) goto L9;
        return r2.Pc();
    L9:
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean d() {
        return this.c;
    }

    public l(com.larus.chat.gallery.impl.preview.p.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void a(com.larus.chat.gallery.impl.preview.provider.a0 r5) {
        this.b = r5;
        if (r5 != null) goto L6;
        this.d++;
        this.c = false;
        return;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void c(boolean r4) {
        FLogger.a.i("ChatMessageSendStrategy", "enableChatCameraResult: enable=" + r4);
        q0 r0 = this.a.e;
        if (r0 == null) goto L10;
        q0.a r1 = r0.getProvider();
        if (r1 == null) goto L11;
        zb8.e r2 = r1.P8();
        if (r2 == null) goto L12;
        r2.kL(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Map<String, String> k(List<OutputParam> r4) {
        boolean r0 = false;
        if (r4 == null) goto L22;
        List<OutputParam> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        OutputParam r1 = (OutputParam) r6.next();
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L11;
        boolean r7 = true;
    L20:
        if (r7 != true) goto L22;
        r0 = true;
        goto L22
    L15:
        if (r1.isImageMarked() != true) goto L17;
        r2 = true;
    L8:
        r7 = false;
        goto L20
    L7:
        if (r5.isEmpty() == false) goto L9;
    L22:
        FLogger.a.i("ChatMessageSendStrategy", "buildMarkMessageExt: hasPaintMark=" + r0);
        if (r0 == false) goto L25;
        String r8 = "1";
    L27:
        return MapsKt.mapOf(TuplesKt.to("ref_img_paint_mark", r8));
    L25:
        r8 = TriggerSendLoading.NO_LOADING;
        goto L27
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean h(String r2, xy8.d r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r3, "data");
        FLogger.a.w("ChatMessageSendStrategy", "navigateToChat called on ChatMessage source, unexpected");
        return false;
    }

    public final void l(long r4, boolean r6) {
        if (r4 == this.d) goto L5;
        return;
    L5:
        this.c = false;
        if (r6 == true) goto L8;
        t19.s r5 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.b(r0, 2131908080, false);
    L8:
        Function1<? super Boolean, Unit> r7 = this.b;
        if (r7 == null) goto L12;
        r7.invoke(Boolean.valueOf(r6));
        return;
    }

    public static DirectSendData j(String r16, ChatPageContext r17, zy8.s r18) {
        s0 r2 = null;
        if (r18 != null) goto L5;
        return null;
    L5:
        Map r3 = MapsKt.toMutableMap(r18.a());
        r3.put("direct_use_text_message_event_ext", "true");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) r4.next();
        if (r5.getValue() == null) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L7;
        r11.put(r5.getKey(), r5.getValue());
        goto L7
    L11:
        r6 = false;
        goto L12
    L14:
        String r8 = r18.a.a;
        if (r17 == null) goto L18;
        r2 = new s0();
        r2.i(r17, Reflection.getOrCreateKotlinClass(ChatPageContext.class));
    L18:
        return new DirectSendData(r16, r8, null, "router_auto_send", r11, r2, false, 68, null);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean b(SuggestedAction r1, xy8.d r2, String r3) {
        return e0.a.a(this, r1, r2);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean e(final String r22, xy8.d r23, final zy8.s r24) {
        Intrinsics.checkNotNullParameter(r22, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r23, "data");
        FLogger r2 = FLogger.a;
        r2.i("ChatMessageSendStrategy", "sendInChat, sourceType=" + r23.a + ", text.length=" + r22.length());
        String r8 = null;
        boolean r9 = false;
        if (r23.a == SourceType.CREATION_CARD) goto L5;
        Map r3 = MapsKt.emptyMap();
    L37:
        Map r4 = MapsKt.toMutableMap(r3);
        GalleryType r5 = r23.e;
        GalleryType r11 = GalleryType.Image;
        if (r5 != r11) goto L41;
        r4.put("content_source_to_record", "chat_upload");
        r4.put("content_source_entrance_to_record", "chat");
    L41:
        if ((!r4.isEmpty()) == false) goto L44;
        IAIChatRenderTraceService.a.e(this.a.b, r4);
    L44:
        if (r23.a == SourceType.BOT_RESP) goto L46;
    L53:
        boolean r6 = false;
    L54:
        if (r6 == false) goto L71;
        xy8.b r1 = r23.c;
        if (r1 == null) goto L58;
        r8 = r1.a;
    L58:
        String r12 = r8;
        if (r12 != null) goto L61;
    L64:
        boolean r7 = true;
    L65:
        if (r7 == false) goto L68;
        r2.e("ChatMessageSendStrategy", "sendMainBotImage: imageUri is empty");
        return false;
    L68:
        if (this.c == true) goto L153;
        r2.i("ChatMessageSendStrategy", "sendMainBotImage: saving image for share");
        this.c = true;
        final long r10 = this.d + 1;
        this.d = r10;
        Function1 r13 = new j(r10, this, r22, r24);
        ImageSave r14 = ImageSave.a;
        final WeakReference r0 = new WeakReference(r13);
        ImageSave.z(r14, r12, null, null, null, false, false, null, new k(r0), 126);
        return false;
    L153:
        return false;
    L61:
        if (r12.length() == 0) goto L64;
        r7 = false;
        goto L65
    L71:
        xy8.f r15 = r23.l;
        if (r15 == null) goto L78;
        String r16 = r15.a;
        if (r16 == null) goto L78;
        if (o0.d(r16) != true) goto L78;
        boolean r17 = true;
    L79:
        if (r17 == false) goto L81;
        r2.i("ChatMessageSendStrategy", "sendInChat: skipUpload path");
        return m(r22, r23, r24);
    L81:
        xy8.f r18 = r23.l;
        if (r18 != null) goto L147;
        r2.e("ChatMessageSendStrategy", "checkNeedReUpload: sendMetadata is null, keep preview for retry");
        return false;
    L147:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L137
        Integer r20 = r18.c;     // Catch: Throwable -> L137
        int r110 = UpLinkState.SUCCESS.getValue();     // Catch: Throwable -> L137
        if (r20 != null) goto L88;
    L90:
        String r21 = r18.d;     // Catch: Throwable -> L137
        if (r21 != null) goto L94;
        r21 = "";
    L94:
        if (r21.length() != 0) goto L96;
        boolean r25 = true;
    L97:
        if (r25 == false) goto L99;
    L134:
        r2.e("ChatMessageSendStrategy", "checkNeedReUpload: local resource unavailable");     // Catch: Throwable -> L137
    L135:
        Object r26 = Result.constructor-impl(Boolean.valueOf(r9));     // Catch: Throwable -> L137
    L139:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L142;
        FLogger.a.e("ChatMessageSendStrategy", "checkNeedReUpload error", r27);
    L142:
        Boolean r28 = Boolean.FALSE;
        if (Result.isFailure-impl(r26) == false) goto L146;
        r26 = r28;
    L146:
        return ((Boolean) r26).booleanValue();
    L99:
        if (new PolarisFileWrapper(r21).exists() == false) goto L134;
        Uri r29 = Uri.fromFile(new PolarisFileWrapper(r21));     // Catch: Throwable -> L137
        String r30 = "picture_detail";
        if (r23.e != r11) goto L105;
        String r31 = "picture_detail";
    L106:
        if (r24 == null) goto L108;
        ChatPageContext r32 = r24.c;     // Catch: Throwable -> L137
    L109:
        DirectSendData r111 = j(r22, r32, r24);     // Catch: Throwable -> L137
        q0 r33 = this.a.e;     // Catch: Throwable -> L137
        if (r33 == null) goto L135;
        q0.a r34 = r33.getProvider();     // Catch: Throwable -> L137
        if (r34 == null) goto L135;
        com.larus.bmhome.chat.component.bottom.multimodal.g r35 = r34.r5();     // Catch: Throwable -> L137
        if (r35 == null) goto L135;
        List r36 = CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r29, null, 2));     // Catch: Throwable -> L137
        g1 r112 = new g1(false, MultimodalBizScene.ChatSendImagePreviewPage, false);     // Catch: Throwable -> L137
        if (r111 == null) goto L120;
        h1 r37 = com.larus.bmhome.chat.component.bottom.multimodal.o.d(r111);     // Catch: Throwable -> L137
    L121:
        Pair[] r38 = new Pair[2];     // Catch: Throwable -> L137
        r38[0] = TuplesKt.to("scene", "album");     // Catch: Throwable -> L137
        if (r24 == null) goto L129;
        zy8.a r39 = r24.a;     // Catch: Throwable -> L137
        if (r39 == null) goto L129;
        String r40 = r39.a;     // Catch: Throwable -> L137
        if (r40 == null) goto L129;
        r30 = r40;
    L129:
        r38[1] = TuplesKt.to("enter_method", r30);     // Catch: Throwable -> L137
        Map r41 = MapsKt.mutableMapOf(r38);     // Catch: Throwable -> L137
        if (r111 == null) goto L133;
        r8 = new com.larus.bmhome.chat.component.bottom.multimodal.m(null, r111, null, null, false, null, 123);     // Catch: Throwable -> L137
    L133:
        r35.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r36, r112, r37, r41, r8));     // Catch: Throwable -> L137
        r9 = true;
        goto L135
    L120:
        r8 = null;
        r37 = new h1(r22, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", r31)}), 2);     // Catch: Throwable -> L137
        goto L121
    L108:
        r32 = null;
        goto L109
    L105:
        r31 = "video_detail";
        goto L106
    L96:
        r25 = false;
        goto L97
    L88:
        if (r20.intValue() != r110) goto L90;
        r2.i("ChatMessageSendStrategy", "checkNeedReUpload: upLinkState SUCCESS, skipUpload");     // Catch: Throwable -> L137
        r9 = m(r22, r23, r24);     // Catch: Throwable -> L137
    L137:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L78:
        r17 = false;
        goto L79
    L46:
        if (r23.e != r11) goto L53;
        xy8.b r43 = r23.c;
        if (r43 == null) goto L50;
        String r44 = r43.a;
    L51:
        if (r44 == null) goto L53;
        r6 = true;
        goto L54
    L50:
        r44 = null;
        goto L51
    L5:
        xy8.e r45 = r23.m;
        if (r45 == null) goto L9;
        String r46 = r45.c;
        if (r46 == null) goto L9;
    L13:
        if (r45 == null) goto L16;
        String r113 = r45.e;
        if (r113 == null) goto L16;
    L19:
        Map r47 = MapsKt.createMapBuilder();
        if (r46 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L28;
        r47.put("pic_source_message_id", r46);
    L28:
        if (r113 != null) goto L30;
    L33:
        boolean r48 = true;
    L34:
        if (r48 == true) goto L36;
        r47.put("source_creation_task_id", r113);
    L36:
        r3 = MapsKt.build(r47);
        goto L37
    L30:
        if (r113.length() == 0) goto L33;
        r48 = false;
        goto L34
    L22:
        if (r46.length() == 0) goto L25;
        r114 = false;
    L16:
        if (r45 == null) goto L18;
        r113 = r45.a;
        goto L19
    L18:
        r113 = null;
    L9:
        xy8.f r49 = r23.l;
        if (r49 == null) goto L12;
        r46 = r49.a;
        goto L13
    L12:
        r46 = null;
        goto L13
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean f(String r28, CameraOutputContext r29, Map<String, String> r30) {
        Intrinsics.checkNotNullParameter(r28, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r29, "outputContext");
        List<OutputParam> r2 = r29.getOutputParamList();
        List<OutputParam> r4 = r2;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithInputContent: outputParamList is empty");
        return false;
    L13:
        List<OutputParam> r6 = r2;
        ArrayList r10 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L14:
        com.larus.bmhome.chat.component.bottom.multimodal.a.a r8 = null;
        if (r7.hasNext() == false) goto L32;
        OutputParam r9 = (OutputParam) r7.next();
        if (r9 == null) goto L19;
        String r11 = r9.getPath();
    L20:
        if (r11 != null) goto L22;
    L25:
        boolean r12 = true;
    L26:
        if (r12 == false) goto L28;
        FLogger.a.w("ChatMessageSendStrategy", "sendWithInputContent: outputParam path is null, skip");
    L29:
        if (r8 == null) goto L14;
        r10.add(r8);
        goto L14
    L28:
        r8 = new com.larus.bmhome.chat.component.bottom.multimodal.a.a(Uri.fromFile(new PolarisFileWrapper(r11)), null, 2);
        goto L29
    L22:
        if (r11.length() == 0) goto L25;
        r12 = false;
        goto L26
    L19:
        r11 = null;
        goto L20
    L32:
        if (r10.isEmpty() == false) goto L35;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithInputContent: no valid attachments extracted");
        return false;
    L35:
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r6.iterator();
    L37:
        if (r14.hasNext() == false) goto L51;
        Object r15 = r14.next();
        OutputParam r16 = (OutputParam) r15;
        if (r16 == null) goto L41;
        String r17 = r16.getPath();
    L42:
        if (r17 != null) goto L44;
    L47:
        boolean r18 = true;
    L49:
        if ((!r18) == false) goto L37;
        r13.add(r15);
        goto L37
    L44:
        if (r17.length() == 0) goto L47;
        r18 = false;
        goto L49
    L41:
        r17 = null;
        goto L42
    L51:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r20 = r13.iterator();
    L53:
        if (r20.hasNext() == false) goto L63;
        OutputParam r21 = (OutputParam) r20.next();
        if (r21 == null) goto L61;
        ImageParam r22 = r21.getImageParam();
        if (r22 == null) goto L61;
        if (r22.isAiCreation() != true) goto L61;
        boolean r23 = true;
    L62:
        r19.add(Boolean.valueOf(r23));
    L61:
        r23 = false;
        goto L62
    L63:
        List<OutputParam> r3 = r29.getOutputParamList();
        if (r3 == null) goto L70;
        OutputParam r24 = (OutputParam) CollectionsKt.firstOrNull(r3);
        if (r24 == null) goto L70;
        Pair<String, Integer> r25 = r24.getInputContent();
        if (r25 == null) goto L70;
        Integer r26 = (Integer) r25.getSecond();
    L71:
        if (r26 != null) goto L74;
    L76:
        if (r26 != null) goto L79;
    L82:
        String r27 = null;
    L83:
        Map<String, String> r31 = k(r2);
        DirectSendData r110 = new DirectSendData(r28, "picture_mark_page", r31, r27, r30, null, false, 96, null);
        FLogger r32 = FLogger.a;
        r32.i("ChatMessageSendStrategy", "sendWithInputContent: attachments=" + r10.size() + ", text.length=" + r28.length());
        q0 r33 = this.a.e;
        if (r33 == null) goto L88;
        q0.a r34 = r33.getProvider();
        if (r34 == null) goto L88;
        com.larus.bmhome.chat.component.bottom.multimodal.g r35 = r34.r5();
    L89:
        if (r35 != null) goto L105;
        r32.e("ChatMessageSendStrategy", "sendWithInputContent: multimodalInputAbility is null");
        return false;
    L105:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L95
        r35.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r10, new g1(false, MultimodalBizScene.ChatInputCamera, false), new h1(r28, r31, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "picture_mark_page")})), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "album"), TuplesKt.to("enter_method", "picture_mark_page")}), new com.larus.bmhome.chat.component.bottom.multimodal.m(null, r110, new com.larus.bmhome.chat.component.bottom.multimodal.i(r19, 3), null, false, null, 115)));     // Catch: Throwable -> L95
        Object r0 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L95
    L97:
        Throwable r37 = Result.exceptionOrNull-impl(r0);
        if (r37 == null) goto L100;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithInputContent: hand-off failed", r37);
    L100:
        Boolean r38 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L104;
        r0 = r38;
    L104:
        return ((Boolean) r0).booleanValue();
    L95:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L88:
        r35 = null;
        goto L89
    L79:
        if (r26.intValue() != 2) goto L82;
        String r40 = "speak";
    L81:
        r27 = r40;
        goto L83
    L74:
        if (r26.intValue() != 1) goto L76;
        r40 = "keyboard";
    L70:
        r26 = null;
        goto L71
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = false;
        goto L10
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean g(SuggestedAction r27, CameraOutputContext r28, Map<String, String> r29) {
        Intrinsics.checkNotNullParameter(r27, "suggestedAction");
        Intrinsics.checkNotNullParameter(r28, "outputContext");
        List<OutputParam> r2 = r28.getOutputParamList();
        List<OutputParam> r4 = r2;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithCameraOutput: outputParamList is empty");
        return false;
    L13:
        List<OutputParam> r6 = r2;
        ArrayList r9 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L14:
        com.larus.bmhome.chat.component.bottom.multimodal.a.a r11 = null;
        if (r8.hasNext() == false) goto L32;
        OutputParam r10 = (OutputParam) r8.next();
        if (r10 == null) goto L19;
        String r12 = r10.getPath();
    L20:
        if (r12 != null) goto L22;
    L25:
        boolean r13 = true;
    L26:
        if (r13 == false) goto L28;
        FLogger.a.w("ChatMessageSendStrategy", "sendWithCameraOutput: outputParam path is null, skip");
    L29:
        if (r11 == null) goto L14;
        r9.add(r11);
        goto L14
    L28:
        r11 = new com.larus.bmhome.chat.component.bottom.multimodal.a.a(Uri.fromFile(new PolarisFileWrapper(r12)), null, 2);
        goto L29
    L22:
        if (r12.length() == 0) goto L25;
        r13 = false;
        goto L26
    L19:
        r12 = null;
        goto L20
    L32:
        if (r9.isEmpty() == false) goto L35;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithCameraOutput: no valid attachments extracted");
        return false;
    L35:
        ArrayList r14 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L37:
        if (r7.hasNext() == false) goto L51;
        Object r15 = r7.next();
        OutputParam r16 = (OutputParam) r15;
        if (r16 == null) goto L41;
        String r17 = r16.getPath();
    L42:
        if (r17 != null) goto L44;
    L47:
        boolean r18 = true;
    L49:
        if ((!r18) == false) goto L37;
        r14.add(r15);
        goto L37
    L44:
        if (r17.length() == 0) goto L47;
        r18 = false;
        goto L49
    L41:
        r17 = null;
        goto L42
    L51:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r20 = r14.iterator();
    L53:
        if (r20.hasNext() == false) goto L63;
        OutputParam r110 = (OutputParam) r20.next();
        if (r110 == null) goto L61;
        ImageParam r111 = r110.getImageParam();
        if (r111 == null) goto L61;
        if (r111.isAiCreation() != true) goto L61;
        boolean r112 = true;
    L62:
        r19.add(Boolean.valueOf(r112));
    L61:
        r112 = false;
        goto L62
    L63:
        OutputParam r21 = (OutputParam) CollectionsKt.firstOrNull(r2);
        if (r21 == null) goto L69;
        HashMap<String, String> r22 = r21.getExt();
        if (r22 == null) goto L69;
        Map r23 = MapsKt.toMutableMap(r22);
        if (r23 == null) goto L69;
    L70:
        Map r113 = r27.getMsgExt();
        if (r113 == null) goto L73;
        r23.putAll(r113);
    L73:
        PromptReplacementCfg r114 = r27.getPromptReplacementCfg();
        if (r114 == null) goto L78;
        String r115 = r114.getReplacementKey();
        if (r115 == null) goto L78;
        r23.put("prompt_modification", r115);
    L78:
        Map<String, String> r3 = k(r2);
        if (r3 == null) goto L81;
        r23.putAll(r3);
    L81:
        Map r24 = r27.getEventExtra();
        if (r24 == null) goto L85;
        Map r25 = MapsKt.toMutableMap(r24);
        if (r25 == null) goto L85;
    L86:
        if (r29 == null) goto L89;
        r25.putAll(r29);
    L89:
        if (r25.containsKey("scene") == true) goto L91;
        r25.put("scene", "album");
    L91:
        String r116 = r27.getDisplayName();
        Map r117 = r27.getEventExtra();
        if (r117 == null) goto L95;
        String r118 = (String) r117.get("sug_scene");
        if (r118 == null) goto L95;
    L96:
        DirectSendData r119 = new DirectSendData(r116, "picture_mark_page", r23, r118, r25, null, false, 96, null);
        FLogger r26 = FLogger.a;
        StringBuilder r30 = new StringBuilder("sendWithCameraOutput: attachments=");
        r30.append(r9.size());
        r30.append(", text.length=");
        String r31 = r27.getDisplayName();
        if (r31 == null) goto L99;
        int r32 = r31.length();
    L100:
        r30.append(r32);
        r26.i("ChatMessageSendStrategy", r30.toString());
        q0 r33 = this.a.e;
        if (r33 == null) goto L105;
        q0.a r34 = r33.getProvider();
        if (r34 == null) goto L105;
        com.larus.bmhome.chat.component.bottom.multimodal.g r35 = r34.r5();
    L106:
        if (r35 != null) goto L121;
        r26.e("ChatMessageSendStrategy", "sendWithCameraOutput: multimodalInputAbility is null");
        return false;
    L121:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L111
        r35.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r9, new g1(false, MultimodalBizScene.ChatInputCamera, false), com.larus.bmhome.chat.component.bottom.multimodal.o.d(r119), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", "album"), TuplesKt.to("enter_method", "picture_mark_page")}), new com.larus.bmhome.chat.component.bottom.multimodal.m(null, r119, new com.larus.bmhome.chat.component.bottom.multimodal.i(r19, 3), null, false, null, 115)));     // Catch: Throwable -> L111
        Object r0 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L111
    L113:
        Throwable r37 = Result.exceptionOrNull-impl(r0);
        if (r37 == null) goto L116;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithCameraOutput: hand-off failed", r37);
    L116:
        Boolean r38 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L120;
        r0 = r38;
    L120:
        return ((Boolean) r0).booleanValue();
    L111:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L105:
        r35 = null;
        goto L106
    L99:
        r32 = 0;
    L95:
        r118 = "attachment_suggest";
    L85:
        r25 = new LinkedHashMap();
    L69:
        r23 = new LinkedHashMap();
        goto L70
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = false;
        goto L10
    }

    public final boolean m(String r61, xy8.d r62, zy8.s r63) {
        q0 r3 = this.a.e;
        ChatPageContext r4 = null;
        if (r3 == null) goto L7;
        q0.a r5 = r3.getProvider();
        if (r5 == null) goto L7;
        ICoreInputAbility r6 = r5.v0();
    L9:
        if (r6 != null) goto L12;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithSkipUpload: ICoreInputAbility is null");
        return false;
    L12:
        xy8.f r7 = r62.l;
        if (r7 != null) goto L16;
        CustomMultiAttachmentInfo r50 = null;
    L20:
        if (r50 == null) goto L24;
        NestedFileContent r8 = r50.getNestedFileContent();
        if (r8 == null) goto L24;
        List r9 = r8.getEntities();
    L25:
        List r10 = r9;
        if (r10 != null) goto L28;
    L31:
        boolean r11 = true;
    L32:
        if (r11 == false) goto L36;
        FLogger.a.e("ChatMessageSendStrategy", "sendWithSkipUpload: reusable attachment identity is empty");
        return false;
    L36:
        if (r62.e != GalleryType.Image) goto L38;
        String r43 = "picture_detail";
    L39:
        if (r63 == null) goto L41;
        Map<String, String> r54 = r63.a();
    L42:
        if (r63 == null) goto L44;
        Map<String, String> r55 = r63.b();
    L45:
        if (r63 == null) goto L47;
        r4 = r63.c;
    L47:
        r6.E0(new ICoreInputAbility.OnSendParams(r61, "", null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, r43, null, null, null, null, null, null, r50, null, null, r4, r54, r55, null, 469237472, 1, null));
        return true;
    L44:
        r55 = null;
        goto L45
    L41:
        r54 = null;
        goto L42
    L38:
        r43 = "video_detail";
        goto L39
    L28:
        if (r10.isEmpty() == true) goto L31;
        r11 = false;
    L24:
        r9 = null;
        goto L25
    L16:
        if (r62.e != GalleryType.Image) goto L18;
        String r14 = "picture_detail";
    L19:
        FLogger.a.i("ChatMessageSendStrategy", "generateAttachment, contentType=" + r7.b);
        r50 = new CustomMultiAttachmentInfo("album", r14, new NestedFileContent(CollectionsKt.toMutableList(r7.f), null, false, null, 14, null), true, false, false, false, null, 240, null);
        goto L20
    L18:
        r14 = "video_detail";
    L7:
        r6 = null;
        goto L9
    }
}

package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.c4;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.v1;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DownloadAction implements o {
    public static final /* synthetic */ int c = 0;
    public final AwemeImageFilter a;
    public boolean b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.CREATION_CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[SourceType.CREATION_RECORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[SourceType.USER_SEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SourceType.BOT_RESP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[SourceType.ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[SourceType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[SourceType.CAMERA_RESULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[SourceType.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public DownloadAction() {
        this.a = new AwemeImageFilter();
    }

    public static void d(l0 r2) {
        PreviewToolbarView r3 = r2.f;
        if (r3 == null) goto L6;
        r3.a(ToolbarButtonType.DOWNLOAD, false);
        return;
    }

    public static void e(JSONObject r1, xy8.d r2) {
        if (r2.j.get("_mixed_richmedia_download_trace") == null) goto L6;
        b2.c(r1);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put("_mixed_richmedia_download_suppress", 1);
        return;
    }

    public static String f(xy8.d r5, String r6) {
        xy8.b r0 = r5.c;
        String r7 = r5.j.get("share_download_url");
        boolean r1 = false;
        String r3 = null;
        if (r7 != null) goto L5;
    L10:
        r7 = null;
    L11:
        if (r0 == null) goto L19;
        String r2 = r0.c;
        if (r2 == null) goto L19;
        if (r2.length() <= 0) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        r3 = r2;
    L19:
        if (r7 != null) goto L24;
        if (r3 != null) goto L25;
        return r6;
    L25:
        return r3;
    L24:
        return r7;
    L5:
        if (r7.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
    L7:
        r4 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r7v17, types: [com.larus.chat.gallery.impl.preview.toolbar.action.k] */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.chat.gallery.impl.preview.toolbar.action.l] */
    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(final l0 r96, Continuation<? super Unit> r97) {
        FLogger.a.i("DownloadAction", "execute: sourceType=" + r96.a.a);
        final xy8.d r1 = r96.a;
        if (r1.e != GalleryType.Video) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        String r4 = "video_download";
    L9:
        String r11 = "detail_click";
        if (r96.i == false) goto L12;
        Object r7 = "more_panel_click";
    L13:
        if (r2 == false) goto L15;
        String r3 = "video_detail";
    L16:
        String r14 = "user";
        if (r1.a != SourceType.USER_SEND) goto L19;
        Object r12 = "user";
    L20:
        xy8.e r13 = r1.m;
        if (r13 == null) goto L24;
        String r5 = r13.e;
        if (r5 == null) goto L24;
    L27:
        if (r13 == null) goto L30;
        String r15 = r13.c;
        if (r15 == null) goto L30;
    L34:
        JSONObject r6 = new JSONObject();
        String r18 = "more_panel_click";
        Iterator<Map.Entry<String, Object>> r10 = r1.f.entrySet().iterator();
    L36:
        if (r10.hasNext() == false) goto L38;
        Map.Entry<String, Object> r19 = r10.next();
        r6.put(r19.getKey(), r19.getValue());
        r11 = r11;
        r10 = r10;
        goto L36
    L38:
        String r20 = r11;
        if (r5 != null) goto L41;
    L44:
        boolean r16 = true;
    L45:
        if (r16 == true) goto L51;
        r6.put("creation_task_id", r5);
        if (IAIChatUgcAIGCService.a.U() == false) goto L49;
        String r8 = "no_ai_watermark";
    L50:
        r6.put("watermark_status", r8);
        goto L51
    L49:
        r8 = "ai_watermark";
    L51:
        if (r15 != null) goto L53;
    L56:
        boolean r9 = true;
    L57:
        if (r9 == true) goto L59;
        r6.put(MusicAppletPage.KEY_MESSAGE_ID, r15);
    L59:
        r6.put("position", r1.q);
        r6.put("user_type", r12);
        r6.put("click_method", r7);
        r6.put("current_page", r3);
        r6.put("click_from", "click_download");
        r6.put("download_method", "click_icon");
        SourceType r17 = r1.a;
        SourceType r21 = SourceType.USER_SEND;
        if (r17 != r21) goto L62;
        int r22 = 0;
    L63:
        r6.put("is_ai_creation", r22);
        xy8.e r23 = r1.m;
        String r110 = "";
        if (r23 == null) goto L67;
        String r24 = r23.a;
        if (r24 == null) goto L67;
    L68:
        r6.put("creation_id", r24);
        String r25 = r1.j.get("_mixed_richmedia_download_trace");
        if (r25 == null) goto L71;
        r6.put("_mixed_richmedia_download_trace", r25);
    L71:
        b2.f(r6, true);
        FLogger r26 = FLogger.a;
        r26.i("DownloadAction", "reportDownloadEvent: " + r4 + ", params=" + r6);
        com.larus.platform.service.o.a.reportEvent(r4, r6);
        PreviewToolbarView r27 = r96.f;
        if (r27 == null) goto L74;
        boolean r111 = true;
        r27.a(ToolbarButtonType.DOWNLOAD, true);
    L76:
        if (r1.e != GalleryType.Video) goto L185;
        if (this.b == false) goto L80;
        d(r96);
        Object r0 = Unit.INSTANCE;
    L180:
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L183;
        return r0;
    L183:
        return Unit.INSTANCE;
    L80:
        this.b = r111;
        final xy8.d r112 = r96.a;
        xy8.g r28 = r112.d;
        if (r28 != null) goto L83;
        this.b = false;
        d(r96);
        r0 = Unit.INSTANCE;
        goto L180
    L83:
        String r29 = r28.f;
        if (r29 != null) goto L86;
    L88:
        String r210 = null;
    L89:
        String r30 = r28.a;
        String r31 = r28.b;
        String r113 = r28.c;
        String r32 = r28.d;
        if (r32 == null) goto L92;
        nr9.f r211 = new nr9.f(r32, r32, null, null, null, null, 60);
    L93:
        final nr9.g r114 = new nr9.g(r30, null, r31, r113, null, null, r211, r210, null, null, 818);
        StringBuilder r33 = new StringBuilder("downloadVideo: sourceType=");
        r33.append(r112.a);
        r33.append(", itemKey=");
        r33.append(r112.b);
        r33.append(", hasDownloadUrl=");
        String r34 = r114.c;
        if (r34 != null) goto L96;
    L99:
        boolean r115 = true;
    L100:
        r33.append(!r115);
        r33.append(", hasLocalPath=");
        String r35 = r114.h;
        if (r35 != null) goto L103;
    L106:
        boolean r116 = true;
    L107:
        r33.append(!r116);
        r33.append(", context=");
        if (r96.getContext() == null) goto L110;
        boolean r36 = true;
    L111:
        r33.append(r36);
        r26.i("DownloadAction", r33.toString());
        final String r37 = "1";
        switch(b.a[r112.a.ordinal()]) {
            case 1: goto L143;
            case 2: goto L124;
            case 3: goto L120;
            case 4: goto L119;
            case 5: goto L115;
            case 6: goto L115;
            case 7: goto L115;
            case 8: goto L115;
            default: goto L114;
        };
    L115:
        r0 = c(r96, r112, r114, r97);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L180;
        r0 = Unit.INSTANCE;
        goto L180
    L119:
        this.b = false;
        d(r96);
        r26.w("DownloadAction", "downloadVideo: BOT_RESP should not have video");
    L178:
        r0 = Unit.INSTANCE;
        goto L180
    L120:
        r0 = c(r96, r112, r114, r97);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L180;
        r0 = Unit.INSTANCE;
        goto L180
    L124:
        xy8.e r38 = r112.m;
        if (r38 == null) goto L127;
        final String r117 = r38.a;
    L128:
        if (r38 == null) goto L130;
        final String r118 = r38.e;
    L131:
        if (r38 == null) goto L133;
        final String r119 = r38.c;
    L135:
        if (r96.i == true) goto L139;
        r18 = r20;
    L139:
        if (r112.a == r21) goto L142;
        r37 = TriggerSendLoading.NO_LOADING;
    L142:
        r26.i("DownloadAction", "downloadVideoViaCreationRecord: creationId=" + r117);
        final String r39 = r119;
        final String r40 = r18;
        final String r41 = r117;
        IUgcAIGCService.a.c(IUgcAIGCService.a, r96.getContext(), null, r114, r96.b, new h(r114, r39, r40, r37, r112, r41, this), z2.a.Q3(), r112.n, new i(this, r96), new j(r96, r117, r118, r119), 1090);
        goto L178
    L133:
        r119 = null;
        goto L135
    L130:
        r118 = null;
        goto L131
    L127:
        r117 = null;
        goto L128
    L143:
        xy8.e r42 = r112.m;
        if (r42 == null) goto L146;
        String r43 = r42.c;
    L147:
        if (r42 == null) goto L149;
        String r44 = r42.e;
    L150:
        Map r310 = IUgcAIGCService.a.B(r112.n, r44);
        if (r96.i == true) goto L155;
        r18 = r20;
    L155:
        if (r112.a != r21) goto L157;
        String r212 = "1";
    L158:
        StringBuilder r45 = new StringBuilder("downloadVideoViaCreationCard: messageId=");
        r45.append(r43);
        r45.append(", metaDataMap=");
        if (r310 == null) goto L161;
        boolean r46 = true;
    L162:
        r45.append(r46);
        r26.i("DownloadAction", r45.toString());
        IFlowSdkDepend r47 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r47 == null) goto L169;
        r47.D0();
        b1 r48 = b1.a;
        r48.c("creation_gallery_download");
        String r49 = r114.c;
        if (r49 == null) goto L168;
        r110 = r49;
    L168:
        r48.d(r110);
    L169:
        IAIChatUgcAIGCService.Companion r50 = IAIChatUgcAIGCService.a;
        Context r51 = r96.getContext();
        int r52 = r112.q;
        JSONObject r53 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r54 = r112.f.entrySet().iterator();
    L171:
        if (r54.hasNext() == false) goto L174;
        Map.Entry<String, Object> r120 = r54.next();
        r53.put(r120.getKey(), r120.getValue());
        goto L171
    L174:
        if (r112.a == SourceType.USER_SEND) goto L177;
        r14 = "bot";
    L177:
        r53.put("user_type", r14);
        e(r53, r112);
        Unit r55 = Unit.INSTANCE;
        IAIChatUgcAIGCService.a.e(r50, r51, r114, new c4(null, r43, null, null, null, null, r212, r44, Integer.valueOf(r52), null, null, null, r53, null, 11837), r18, r96.b, null, r310, null, true, new n(this, r96), 672);
        goto L178
    L161:
        r46 = false;
        goto L162
    L157:
        r212 = TriggerSendLoading.NO_LOADING;
        goto L158
    L149:
        r44 = null;
        goto L150
    L146:
        r43 = null;
        goto L147
    L114:
        throw new NoWhenBranchMatchedException();
    L110:
        r36 = false;
        goto L111
    L103:
        if (StringsKt.isBlank(r35) == true) goto L106;
        r116 = false;
        goto L107
    L96:
        if (StringsKt.isBlank(r34) == true) goto L99;
        r115 = false;
        goto L100
    L92:
        r211 = null;
        goto L93
    L86:
        if (com.larus.utils.r.k(r29) == false) goto L88;
        r210 = r29;
        goto L89
    L185:
        switch(b.a[r1.a.ordinal()]) {
            case 1: goto L272;
            case 2: goto L205;
            case 3: goto L200;
            case 4: goto L192;
            case 5: goto L188;
            case 6: goto L188;
            case 7: goto L188;
            case 8: goto L188;
            default: goto L187;
        };
    L188:
        Unit r56 = b(r96, r1);
        if (r56 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L359;
        r56 = Unit.INSTANCE;
    L359:
        if (r56 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L362;
        return r56;
    L362:
        return Unit.INSTANCE;
    L192:
        xy8.b r57 = r1.c;
        if (r57 == null) goto L198;
        String r121 = r57.a;
        if (r121 == null) goto L198;
        r26.i("DownloadAction", "downloadImageViaBotResp: imageUrl=".concat(r121));
        ImageSave.x(ImageSave.a, r121, null, new f(this, r96), null, false, 58);
    L357:
        r56 = Unit.INSTANCE;
    L198:
        d(r96);
        goto L357
    L200:
        r56 = b(r96, r1);
        if (r56 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L359;
        r56 = Unit.INSTANCE;
        goto L359
    L205:
        xy8.b r58 = r1.c;
        if (r58 == null) goto L271;
        String r59 = r58.a;
        if (r59 == null) goto L271;
        xy8.e r60 = r1.m;
        if (r60 == null) goto L213;
        String r61 = r60.a;
    L214:
        if (r60 == null) goto L216;
        Integer r62 = r60.b;
    L217:
        r26.i("DownloadAction", "downloadImageViaCreationRecord: creationId=" + r61 + ", creationType=" + r62);
        String r63 = f(r1, r59);
        String r64 = r1.j.get("share_preview_url");
        if (r64 == null) goto L221;
        r59 = r64;
    L221:
        String r65 = r1.j.get("share_raw_url");
        if (Intrinsics.areEqual(r1.j.get("share_disable_puzzle"), "true") == false) goto L224;
        String r122 = null;
    L225:
        String r123 = r1.j.get("share_image_origin_width");
        if (r123 == null) goto L230;
        Long r124 = StringsKt.toLongOrNull(r123);
        if (r124 == null) goto L230;
        long r125 = r124.longValue();
    L231:
        String r126 = r1.j.get("share_image_origin_height");
        if (r126 == null) goto L236;
        Long r127 = StringsKt.toLongOrNull(r126);
        if (r127 == null) goto L236;
        long r128 = r127.longValue();
    L237:
        v1 r129 = z2.a.getCreationShareSettings().a();
        if (r129 == null) goto L242;
        FLogger r213 = r26;
        String r214 = "DownloadAction";
        if (r129.b() != true) goto L243;
        boolean r66 = true;
    L244:
        if (r66 == true) goto L247;
        boolean r130 = false;
    L251:
        if (r130 == false) goto L257;
        d(r96);
        com.larus.bmhome.share.panel.h r67 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "creation_detail", null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r61, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -25, -4097, 1023);
        ShareScene r215 = ShareScene.IMAGE_VIEWER_REPORT;
        sq9.i r68 = new sq9.i("download", null, r61, 2);
        Map<String, String> r69 = r1.k;
        xy8.b r70 = r1.c;
        if (r70 == null) goto L255;
        String r311 = r70.h;
    L256:
        m3.a.Z0(r96.c, new sq9.j(r61, r59, r63, r65, r122, null, r67, r215, r125, r128, r68, r69, 0, null, null, null, r311, 61472));
        goto L357
    L255:
        r311 = null;
        goto L256
    L257:
        r213.i(r214, "downloadImageViaCreationRecord: saveImage directly");
        IFlowSdkDepend r71 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r71 == null) goto L260;
        r71.D0();
        b1 r72 = b1.a;
        r72.c("chat_thumbnail_download");
        r72.d(r63);
    L260:
        if (r62 == null) goto L262;
        String r73 = DataConverterKt.h(r62.intValue());
    L263:
        if (r73 != null) goto L265;
        String r131 = "";
    L266:
        xy8.b r74 = r1.c;
        if (r74 == null) goto L269;
        String r75 = r74.h;
    L270:
        ImageDownloadLoadingMgr r76 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.c(r63, r1.k, new m(this, r96), true, new DownloadAction$downloadImageViaCreationRecord$3(r63, r131, r75, null), 4);
        goto L357
    L269:
        r75 = null;
        goto L270
    L265:
        r131 = r73;
        goto L266
    L262:
        r73 = null;
        goto L263
    L247:
        if (r129.f() == false) goto L249;
        boolean r77 = CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{2, 5, 4}), r62);
    L250:
        r130 = r77;
        goto L251
    L249:
        r77 = CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{5, 4}), r62);
    L243:
        r66 = false;
        goto L244
    L242:
        r213 = r26;
        r214 = "DownloadAction";
    L236:
        r128 = -1;
    L230:
        r125 = -1;
        goto L231
    L224:
        r122 = r1.j.get("share_ref_url");
        goto L225
    L216:
        r62 = null;
        goto L217
    L213:
        r61 = null;
    L271:
        d(r96);
        goto L357
    L272:
        boolean r132 = false;
        xy8.b r78 = r1.c;
        if (r78 == null) goto L356;
        String r79 = r78.a;
        if (r79 == null) goto L356;
        xy8.e r80 = r1.m;
        if (r80 == null) goto L280;
        String r81 = r80.a;
    L281:
        if (r80 == null) goto L283;
        Integer r133 = r80.b;
    L284:
        if (r80 == null) goto L286;
        String r82 = r80.c;
    L287:
        if (r80 == null) goto L289;
        String r216 = r80.e;
    L290:
        r26.i("DownloadAction", "downloadImageViaCreationCard: creationId=" + r81 + ", creationType=" + r133);
        String r83 = f(r1, r79);
        String r84 = r1.j.get("share_preview_url");
        if (r84 == null) goto L294;
        r79 = r84;
    L294:
        String r85 = r1.j.get("share_raw_url");
        if (Intrinsics.areEqual(r1.j.get("share_disable_puzzle"), "true") == true) goto L302;
        if (r133 != null) goto L299;
    L301:
        String r86 = r1.j.get("share_ref_url");
    L303:
        v1 r134 = z2.a.getCreationShareSettings().a();
        if (r134 != null) goto L306;
    L308:
        boolean r135 = false;
    L309:
        if (r135 == true) goto L312;
    L328:
        boolean r136 = false;
    L329:
        if (r136 == false) goto L336;
        d(r96);
        com.larus.bmhome.share.panel.h r87 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "creation_detail", null, null, r82, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r81, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -153, -4097, 1023);
        ShareScene r217 = ShareScene.IMAGE_VIEWER_REPORT;
        sq9.i r88 = new sq9.i("download", r82, null, 4);
        Map<String, String> r89 = r1.k;
        xy8.b r90 = r1.c;
        if (r90 == null) goto L333;
        String r312 = r90.h;
    L334:
        m3.a.Z0(r96.c, new sq9.j(r81, r79, r83, r85, r86, null, r87, r217, 0, 0, r88, r89, 0, null, null, null, r312, 62240));
        goto L357
    L333:
        r312 = null;
        goto L334
    L336:
        Integer r91 = null;
        final DownloadAction$downloadImageViaCreationCard$checkBlock$1 r92 = new DownloadAction$downloadImageViaCreationCard$checkBlock$1(r81, r216, r82, null);
        IFlowSdkDepend r93 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r93 == null) goto L339;
        r93.D0();
        b1.a.c("profile_private_creation_gallery_download");
    L339:
        xy8.b r94 = r1.c;
        if (r94 != null) goto L342;
    L344:
        if (r132 == false) goto L346;
        r26.i("DownloadAction", "downloadImageViaCreationCard: save download image directly");
        g(r96, r1, r83, r92);
        goto L357
    L346:
        final ?? r95 = new k(this, r96, r1, r92);
        final ?? r98 = new l(this, r96);
        String r137 = r1.j.get("watermark_source_from");
        if (r137 == null) goto L349;
        r91 = StringsKt.toIntOrNull(r137);
    L349:
        int r138 = SourceFrom.DouYin.value;
        if (r91 != null) goto L353;
    L354:
        r26.i("DownloadAction", "downloadImageViaCreationCard: saveImage downloadUrl");
        g(r96, r1, r83, r92);
        Unit r99 = Unit.INSTANCE;
        goto L357
    L353:
        if (r91.intValue() != r138) goto L354;
        this.a.a(r1.j.get("watermark_item_id"), r1.j.get("watermark_image_uri"), r1.j.get("watermark_short_id"), new c(r95), new d(r98));
        goto L357
    L342:
        if (r94.f != true) goto L344;
        r132 = true;
        goto L344
    L312:
        if (r134.f() == false) goto L319;
        if (r133 != null) goto L316;
    L327:
        r136 = true;
        goto L329
    L316:
        if (r133.intValue() == 3) goto L328;
    L319:
        if (r133 != null) goto L322;
    L323:
        if (r133 == null) goto L327;
        if (r133.intValue() == 2) goto L328;
    L322:
        if (r133.intValue() == 3) goto L328;
    L306:
        if (r134.b() != true) goto L308;
        r135 = true;
        goto L309
    L299:
        if (r133.intValue() != 3) goto L301;
    L302:
        r86 = null;
        goto L303
    L289:
        r216 = null;
        goto L290
    L286:
        r82 = null;
        goto L287
    L283:
        r133 = null;
        goto L284
    L280:
        r81 = null;
    L356:
        d(r96);
        goto L357
    L187:
        throw new NoWhenBranchMatchedException();
    L74:
        r111 = true;
    L67:
        r24 = "";
        goto L68
    L62:
        r22 = 1;
        goto L63
    L53:
        if (r15.length() == 0) goto L56;
        r9 = false;
        goto L57
    L41:
        if (r5.length() == 0) goto L44;
        r16 = false;
    L30:
        xy8.f r139 = r1.l;
        if (r139 == null) goto L33;
        r15 = r139.a;
        goto L34
    L33:
        r15 = null;
    L24:
        if (r13 == null) goto L26;
        r5 = r13.a;
        goto L27
    L26:
        r5 = null;
        goto L27
    L19:
        r12 = "bot";
        goto L20
    L15:
        r3 = "picture_detail";
        goto L16
    L12:
        r7 = "detail_click";
        goto L13
    L8:
        r4 = "picture_download";
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    public final Unit b(final l0 r11, xy8.d r12) {
        xy8.b r0 = r12.c;
        if (r0 == null) goto L36;
        String r1 = r0.a;
        if (r1 == null) goto L36;
        String r2 = r0.c;
        if (r2 != null) goto L10;
    L19:
        String r4 = r1;
    L20:
        xy8.e r3 = r12.m;
        if (r3 == null) goto L23;
        String r5 = r3.a;
    L24:
        if (r3 == null) goto L26;
        String r6 = r3.e;
    L27:
        xy8.f r13 = r12.l;
        if (r13 == null) goto L31;
        String r14 = r13.a;
        if (r14 == null) goto L31;
    L34:
        FLogger.a.i("DownloadAction", "downloadImageViaUserSend: downloadUrl=" + r4 + ", displayUrl=" + r1);
        ImageSave.x(ImageSave.a, r4, null, new g(this, r11), new DownloadAction$downloadImageViaUserSend$checkBlock$1(r5, r6, r14, null), false, 50);
        return Unit.INSTANCE;
    L31:
        if (r3 == null) goto L33;
        r14 = r3.c;
        goto L34
    L33:
        r14 = null;
        goto L34
    L26:
        r6 = null;
        goto L27
    L23:
        r5 = null;
        goto L24
    L10:
        if (r2.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L19;
        r4 = r2;
        goto L20
    L12:
        r7 = false;
    L36:
        d(r11);
        return Unit.INSTANCE;
    }

    public final Object c(l0 r25, xy8.d r26, nr9.g r27, Continuation<? super Unit> r28) {
        final l0 r1 = r25;
        xy8.d r2 = r26;
        nr9.g r3 = r27;
        if ((r28 instanceof DownloadAction$downloadVideoViaUserSend$1) == false) goto L7;
        DownloadAction$downloadVideoViaUserSend$1 r5 = (DownloadAction$downloadVideoViaUserSend$1) r28;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        DownloadAction$downloadVideoViaUserSend$1 r10 = r5;
        Object r4 = r10.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r10.label;
        String r12 = null;
        boolean r13 = true;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        String r9 = (String) r10.L$4;
        String r11 = (String) r10.L$3;
        r3 = (nr9.g) r10.L$2;
        xy8.d r14 = (xy8.d) r10.L$1;
        l0 r15 = (l0) r10.L$0;
        ResultKt.throwOnFailure(r4);
        String r17 = r9;
        r1 = r15;
        Object r16 = r4;
        String r18 = r11;
        r2 = r14;
    L45:
        GetVideoModelResultItem r19 = (GetVideoModelResultItem) r16;
        if (r19 == null) goto L50;
        VideoUrlResult r20 = r19.getVideoUrlResult();
        if (r20 == null) goto L50;
        String r21 = r20.getVideoUrl();
    L51:
        if (r21 != null) goto L53;
    L56:
        if (r13 == false) goto L59;
        FLogger.a.e("DownloadAction", "downloadVideoViaUserSend: ResourceCenter returned empty url");
        this.b = false;
        d(r1);
        t19.s r22 = t19.s.a;
        Context r23 = r1.getContext();
        r22.getClass();
        t19.s.b(r23, 2131908982, false);
        return Unit.INSTANCE;
    L59:
        r3.c = r21;
        if (r19 == null) goto L64;
        VideoUrlResult r24 = r19.getVideoUrlResult();
        if (r24 == null) goto L64;
        r12 = r24.getDownloadFilehash();
    L64:
        r3.d = r12;
        FLogger.a.i("DownloadAction", "downloadVideoViaUserSend: resolved downloadUrl=" + r21);
    L66:
        nr9.g r29 = r3;
        String r30 = r18;
        String r210 = r17;
        IAIChatUgcAIGCService.Companion r31 = IAIChatUgcAIGCService.a;
        Context r32 = r1.getContext();
        int r33 = r2.q;
        JSONObject r110 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r34 = r2.f.entrySet().iterator();
    L68:
        if (r34.hasNext() == false) goto L70;
        Map.Entry<String, Object> r35 = r34.next();
        r110.put(r35.getKey(), r35.getValue());
        goto L68
    L70:
        r110.put("user_type", "user");
        e(r110, r2);
        Unit r36 = Unit.INSTANCE;
        IAIChatUgcAIGCService.a.e(r31, r32, r29, new c4(null, r30, null, null, null, null, "1", null, Boxing.boxInt(r33), null, null, null, r110, null, 11965), r210, r1.b, null, null, null, false, new com.larus.chat.gallery.impl.preview.toolbar.action.b(this, r1), 1984);
        return Unit.INSTANCE;
    L53:
        if (r21.length() == 0) goto L56;
        r13 = false;
    L50:
        r21 = null;
        goto L51
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        xy8.f r37 = r2.l;
        if (r37 == null) goto L18;
        r18 = r37.a;
        if (r18 == null) goto L18;
    L23:
        if (r1.i == false) goto L25;
        String r38 = "more_panel_click";
    L26:
        String r111 = r38;
        FLogger r39 = FLogger.a;
        r39.i("DownloadAction", "downloadVideoViaUserSend: messageId=" + r18);
        String r40 = r3.c;
        if (r40 != null) goto L29;
    L32:
        boolean r41 = true;
    L33:
        if (r41 == false) goto L65;
        String r42 = r3.h;
        if (r42 != null) goto L37;
    L40:
        boolean r43 = true;
    L41:
        if (r43 == false) goto L65;
        r39.i("DownloadAction", "downloadVideoViaUserSend: downloadUrl and localPath both empty, resolving via ResourceCenter");
        ResourceCenter r44 = ResourceCenter.a;
        String r45 = r3.a;
        r10.L$0 = r1;
        r10.L$1 = r2;
        r10.L$2 = r3;
        r10.L$3 = r18;
        r10.L$4 = r111;
        r10.label = 1;
        r17 = r111;
        r16 = ResourceCenter.i(r44, null, r45, false, r10, 5);
        if (r16 != r7) goto L45;
        return r7;
    L37:
        if (r42.length() == 0) goto L40;
        r43 = false;
    L65:
        r17 = r111;
        goto L66
    L29:
        if (r40.length() == 0) goto L32;
        r41 = false;
        goto L33
    L25:
        r38 = "detail_click";
    L18:
        xy8.e r46 = r2.m;
        if (r46 == null) goto L21;
        r18 = r46.c;
        goto L23
    L21:
        r18 = null;
    L7:
        r5 = new DownloadAction$downloadVideoViaUserSend$1(this, r28);
        goto L8
    }

    public final void g(final l0 r11, xy8.d r12, String r13, Function1<? super Continuation<? super Unit>, ? extends Object> r14) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r1 = "";
        if (r0 == null) goto L9;
        r0.D0();
        b1 r2 = b1.a;
        r2.c("chat_thumbnail_download");
        if (r13 != null) goto L7;
        String r3 = "";
    L8:
        r2.d(r3);
        goto L9
    L7:
        r3 = r13;
    L9:
        xy8.e r4 = r12.m;
        if (r4 == null) goto L14;
        Integer r5 = r4.b;
        if (r5 == null) goto L14;
        String r6 = DataConverterKt.h(r5.intValue());
    L15:
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        xy8.b r7 = r12.c;
        if (r7 == null) goto L21;
        String r8 = r7.h;
    L22:
        ImageDownloadLoadingMgr r9 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.b(r13, r12.k, r14, new e(this, r11), true, new DownloadAction$saveCreationCardImage$3(r13, r1, r8, null));
        return;
    L21:
        r8 = null;
    L14:
        r6 = null;
        goto L15
    }
}

package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.bigimg.AwemeImageFilter;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.IVideoShareService;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.bean.VideoType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a5;
import hq9.v1;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.c2;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ShareAction implements o {
    public static final Map<String, String> b = null;
    public final AwemeImageFilter a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L4:
            a = r0;
            int[] r1 = new int[SourceType.values().length];
            r1[SourceType.CREATION_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L28:
            r1[SourceType.USER_SEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L40:
            r1[SourceType.BOT_RESP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L24:
            r1[SourceType.CREATION_CARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[SourceType.ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L26:
            r1[SourceType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L32:
            r1[SourceType.CAMERA_RESULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L36:
            r1[SourceType.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L13:
            b = r1;
        }
    }

    static {
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(ShareChannel.PUBLISH, "publish_creation"), TuplesKt.to(ShareChannel.SET_PRIVATE, "go_private_creation")});
    }

    public ShareAction() {
        this.a = new AwemeImageFilter();
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.chat.gallery.impl.preview.toolbar.action.z, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.chat.gallery.impl.preview.toolbar.action.y, java.lang.Object] */
    public static yy8.a b(final l0 r9) {
        if (AppHost.a.isOversea() == false) goto L7;
        FLogger.a.i("ShareAction", "buildPublishCallback: Dola 不支持发布, 返回 null");
        return null;
    L7:
        if (r9.g == true) goto L11;
        FLogger.a.i("ShareAction", "buildPublishCallback: publishInSharePanel=false, 返回 null");
        return null;
    L11:
        if (com.larus.platform.service.n0.a.b() == false) goto L14;
        FLogger.a.i("ShareAction", "buildPublishCallback: 企业版模式, 不展示发布/设为私密, 返回 null");
        return null;
    L14:
        xy8.a r4 = r9.h;
        if (r4 != null) goto L18;
        FLogger.a.w("ShareAction", "buildPublishCallback: toolbarCapability=null, 返回 null");
        return null;
    L18:
        FLogger.a.i("ShareAction", "buildPublishCallback: 创建 clickInterceptor");
        int r0 = yy8.b.a;
        ?? r8 = new y();
        ?? r5 = new z(r9);
        Intrinsics.checkNotNullParameter(r4, "toolbarCapability");
        Intrinsics.checkNotNullParameter(r8, "onDismissAction");
        Intrinsics.checkNotNullParameter(r5, "onStatusChanged");
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        return new yy8.a(r4, r5, new Ref.BooleanRef(), r7, r8);
    }

    public static JSONObject d(xy8.d r4) {
        JSONObject r0 = new JSONObject();
        Iterator r1 = c2.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) r1.next();
        Object r3 = r4.f.get(r2);
        if (r3 == null) goto L4;
        r0.putOpt(r2, r3);
        goto L4
    L9:
        if (r4.a != SourceType.USER_SEND) goto L11;
    L15:
        String r5 = r4.j.get("_mixed_richmedia_download_trace");
        if (r5 == null) goto L19;
        r0.put("_mixed_richmedia_download_trace", r5);
    L19:
        if (r0.length() <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L31;
        return null;
    L31:
        return r0;
    L21:
        r6 = false;
        goto L22
    L11:
        if (IAIChatUgcAIGCService.a.U() == false) goto L13;
        String r7 = "no_ai_watermark";
    L14:
        r0.put("watermark_status", r7);
        goto L15
    L13:
        r7 = "ai_watermark";
        goto L14
    }

    public static com.larus.bmhome.share.panel.k f(l0 r6) {
        if (AppHost.a.isOversea() == false) goto L7;
        FLogger.a.i("ShareAction", "resolvePublishInsert: Dola 不支持发布, 返回 None");
        return com.larus.bmhome.share.panel.k.a.a;
    L7:
        if (r6.g == true) goto L11;
        FLogger.a.i("ShareAction", "resolvePublishInsert: publishInSharePanel=false, 返回 None");
        return com.larus.bmhome.share.panel.k.a.a;
    L11:
        if (com.larus.platform.service.n0.a.b() == false) goto L14;
        FLogger.a.i("ShareAction", "resolvePublishInsert: 企业版模式, 不展示发布/设为私密, 返回 None");
        return com.larus.bmhome.share.panel.k.a.a;
    L14:
        xy8.d r7 = r6.a;
        UserCreation r0 = r7.n;
        Boolean r2 = null;
        if (r0 == null) goto L17;
        Integer r1 = r0.d;
    L18:
        if (r1 == null) goto L24;
        boolean r3 = true;
        if (r1.intValue() == 1) goto L23;
        r3 = false;
    L23:
        r2 = Boolean.valueOf(r3);
    L27:
        if (r2 != null) goto L31;
        FLogger.a.i("ShareAction", "resolvePublishInsert: privateStatus=null 且 publishMetadata=null, 返回 None");
        return com.larus.bmhome.share.panel.k.a.a;
    L31:
        if (r2.booleanValue() == false) goto L33;
        com.larus.bmhome.share.panel.k r8 = com.larus.bmhome.share.panel.k.c.a;
    L34:
        FLogger.a.i("ShareAction", "resolvePublishInsert: privateStatus=" + r1 + ", isPublished=" + r2 + ", 返回 " + r8);
        return r8;
    L33:
        r8 = com.larus.bmhome.share.panel.k.b.a;
        goto L34
    L24:
        xy8.e r9 = r7.m;
        if (r9 == null) goto L27;
        r2 = Boolean.valueOf(r9.k);
        goto L27
    L17:
        r1 = null;
        goto L18
    }

    public static String i(xy8.d r1) {
        Object r2 = r1.f.get("chat_id");
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
        return r3;
    L9:
        return null;
    }

    public static com.larus.bmhome.share.panel.d e(yy8.a r5, com.larus.bmhome.share.panel.d r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mergeClickListeners: primary=");
        boolean r2 = false;
        if (r5 == null) goto L5;
        boolean r4 = true;
    L6:
        r1.append(r4);
        r1.append(", secondary=");
        if (r6 == null) goto L9;
        r2 = true;
    L9:
        r1.append(r2);
        r0.i("ShareAction", r1.toString());
        if (r5 != null) goto L12;
        return r6;
    L12:
        if (r6 != null) goto L15;
        return r5;
    L15:
        return new i0(r5, r6);
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v29, types: [com.larus.chat.gallery.impl.preview.toolbar.action.b0] */
    /* JADX WARN: Type inference failed for: r8v25, types: [com.larus.chat.gallery.impl.preview.toolbar.action.c0] */
    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(final l0 r99, Continuation<? super Unit> r100) {
        FLogger.a.i("ShareAction", "execute: publishInSharePanel=" + r99.g);
        final xy8.d r7 = r99.a;
        if (r99.i == false) goto L5;
        String r1 = "more_panel_click";
    L6:
        xy8.e r2 = r7.m;
        if (r2 == null) goto L10;
        String r5 = r2.e;
        if (r5 == null) goto L10;
    L14:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (r2 == null) goto L19;
        String r3 = r2.c;
        if (r3 == null) goto L19;
    L23:
        if (r3 != null) goto L25;
        r3 = "";
    L25:
        int r9 = r7.q;
        SourceType r10 = r7.a;
        SourceType r11 = SourceType.USER_SEND;
        if (r10 != r11) goto L28;
        String r12 = "user";
    L30:
        if (r7.e == GalleryType.Video) goto L32;
        String r13 = "ShareAction";
        JSONObject r14 = new JSONObject();
        r14.put("creation_task_id", r5);
        r14.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        r14.put("position", r9);
        r14.put("user_type", r12);
        r14.put("click_method", r1);
        r14.put("current_page", "picture_detail");
        r14.put("share_content", "picture");
        Iterator<Map.Entry<String, Object>> r0 = r7.f.entrySet().iterator();
    L52:
        if (r0.hasNext() == false) goto L56;
        Map.Entry<String, Object> r4 = r0.next();
        String r6 = r4.getKey();
        Object r8 = r4.getValue();
        if (r14.has(r6) == true) goto L52;
        r14.put(r6, r8);
        goto L52
    L56:
        FLogger.a.i(r13, "reportClickShare: click_share, params=" + r14);
        com.larus.platform.service.o.a.reportEvent("click_share", r14);
    L58:
        if (b.a[r7.e.ordinal()] != 1) goto L64;
        Object r15 = h(r99, r7, r100);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L63;
        return r15;
    L63:
        return Unit.INSTANCE;
    L64:
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r16 == null) goto L75;
        r16.D0();
        b1 r17 = b1.a;
        r17.c("profile_private_creation_gallery_share");
        xy8.b r18 = r7.c;
        if (r18 == null) goto L69;
        String r19 = r18.a;
    L70:
        if (r19 != null) goto L72;
        String r20 = "";
    L73:
        r17.d(r20);
        goto L75
    L72:
        r20 = r19;
        goto L73
    L69:
        r19 = null;
    L75:
        switch(b.b[r7.a.ordinal()]) {
            case 1: goto L160;
            case 2: goto L159;
            case 3: goto L159;
            case 4: goto L79;
            case 5: goto L78;
            case 6: goto L78;
            case 7: goto L78;
            case 8: goto L78;
            default: goto L77;
        };
    L78:
        g(r99, r7);
    L284:
        return Unit.INSTANCE;
    L79:
        xy8.b r21 = r7.c;
        if (r21 == null) goto L284;
        String r22 = r21.a;
        if (r22 == null) goto L284;
        xy8.e r23 = r7.m;
        if (r23 == null) goto L87;
        String r24 = r23.a;
    L88:
        if (r23 == null) goto L90;
        Integer r25 = r23.b;
    L91:
        if (r23 == null) goto L93;
        String r26 = r23.c;
    L94:
        FLogger.a.i(r13, "shareImageViaCreationCard: creationId=" + r24 + ", creationType=" + r25);
        String r27 = r7.j.get("share_preview_url");
        if (r27 != null) goto L97;
        r27 = r22;
    L97:
        final String r28 = r7.j.get("share_download_url");
        if (r28 != null) goto L100;
        r28 = r22;
    L100:
        String r29 = r7.j.get("share_raw_url");
        if (Intrinsics.areEqual(r7.j.get("share_disable_puzzle"), "true") == true) goto L108;
        if (r25 != null) goto L105;
    L107:
        String r30 = r7.j.get("share_ref_url");
    L109:
        final com.larus.bmhome.share.panel.d r31 = e(b(r99), c(r24, r26, r99.c));
        v1 r110 = z2.a.getCreationShareSettings().a();
        if (r110 != null) goto L112;
    L114:
        boolean r111 = false;
    L115:
        if (r111 == true) goto L118;
    L125:
        boolean r112 = false;
    L126:
        if (r112 == false) goto L140;
        xy8.e r32 = r7.m;
        if (r32 == null) goto L133;
        String r33 = r32.e;
        if (r33 == null) goto L133;
        String r49 = r33;
    L134:
        String r210 = r26;
        com.larus.bmhome.share.panel.h r113 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "creation_detail", null, null, r210, d(r7), null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r49, Integer.valueOf(r7.q), null, null, null, null, null, null, null, null, null, null, null, r24, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, i(r7), f(r99), b, false, null, null, null, null, 1073741415, -4097, 995);
        ShareScene r211 = ShareScene.IMAGE_VIEWER_REPORT;
        sq9.i r34 = new sq9.i(ShareChannel.SHARE, r26, null, 4);
        Map<String, String> r35 = r7.k;
        xy8.b r36 = r7.c;
        if (r36 == null) goto L137;
        String r39 = r36.h;
    L138:
        m3.a.Z0(r99.c, new sq9.j(r24, r27, r28, r29, r30, r31, r113, r211, 0, 0, r34, r35, 0, null, null, null, r39, 62208));
        goto L284
    L137:
        r39 = null;
    L133:
        r49 = r24;
        goto L134
    L140:
        xy8.e r37 = r7.m;
        if (r37 == null) goto L146;
        String r38 = r37.e;
        if (r38 == null) goto L146;
        String r410 = r38;
    L147:
        String r212 = r26;
        final com.larus.bmhome.share.panel.h r40 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "picture_detail", null, null, r212, d(r7), null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r410, Integer.valueOf(r7.q), null, null, null, null, null, null, null, null, null, null, null, r24, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, i(r7), f(r99), b, false, null, null, null, null, 1073741415, -4097, 995);
        final ?? r41 = new b0(r99, r31, r40, r7);
        ?? r42 = new c0(r28, r99, r31, r40, r7);
        String r43 = r7.j.get("watermark_source_from");
        if (r43 == null) goto L150;
        Integer r114 = StringsKt.toIntOrNull(r43);
    L151:
        int r44 = SourceFrom.DouYin.value;
        if (r114 != null) goto L155;
    L156:
        r42.invoke();
        goto L284
    L155:
        if (r114.intValue() != r44) goto L156;
        this.a.a(r7.j.get("watermark_item_id"), r7.j.get("watermark_image_uri"), r7.j.get("watermark_short_id"), new e0(r41), new f0());
        goto L284
    L150:
        r114 = null;
    L146:
        r410 = r24;
        goto L147
    L118:
        if (r110.f() == true) goto L124;
        if (r25 == null) goto L124;
        if (r25.intValue() == 2) goto L125;
    L124:
        r112 = true;
        goto L126
    L112:
        if (r110.e() != true) goto L114;
        r111 = true;
        goto L115
    L105:
        if (r25.intValue() != 3) goto L107;
    L108:
        r30 = null;
        goto L109
    L93:
        r26 = null;
        goto L94
    L90:
        r25 = null;
        goto L91
    L87:
        r24 = null;
        goto L88
    L159:
        g(r99, r7);
        goto L284
    L160:
        xy8.b r45 = r7.c;
        if (r45 == null) goto L284;
        String r46 = r45.a;
        if (r46 == null) goto L284;
        xy8.e r47 = r7.m;
        if (r47 == null) goto L168;
        String r48 = r47.a;
    L169:
        if (r47 == null) goto L171;
        Integer r50 = r47.b;
    L172:
        FLogger r51 = FLogger.a;
        r51.i(r13, "shareImageViaCreationRecord: creationId=" + r48 + ", creationType=" + r50);
        UserCreation r52 = r7.n;
        String r53 = r7.j.get("share_preview_url");
        if (r53 != null) goto L175;
        r53 = r46;
    L175:
        String r54 = r7.j.get("share_download_url");
        if (r54 != null) goto L178;
        r54 = r46;
    L178:
        String r55 = r7.j.get("share_raw_url");
        boolean r115 = Intrinsics.areEqual(r7.j.get("share_disable_puzzle"), "true");
        if (Intrinsics.areEqual(r7.j.get("share_author_uid"), AccountService.a.getUserId()) == false) goto L187;
        if (r115 == true) goto L187;
        if (r50 != null) goto L184;
    L186:
        String r116 = r7.j.get("share_ref_url");
    L188:
        String r117 = r7.j.get("share_image_origin_width");
        if (r117 == null) goto L193;
        Long r118 = StringsKt.toLongOrNull(r117);
        if (r118 == null) goto L193;
        long r119 = r118.longValue();
    L194:
        String r120 = r7.j.get("share_image_origin_height");
        if (r120 == null) goto L199;
        Long r121 = StringsKt.toLongOrNull(r120);
        if (r121 == null) goto L199;
        long r122 = r121.longValue();
    L200:
        LruCache<String, wc9.e> r213 = ko8.a.a;
        long r214 = ko8.a.e;
        String r215 = ko8.a.h(r214);
        String r216 = ko8.a.e(r214);
        if (r50 != null) goto L203;
        FLogger r96 = r51;
        String r97 = r13;
    L206:
        boolean r310 = false;
    L207:
        xy8.e r56 = r7.m;
        if (r56 == null) goto L211;
        String r57 = r56.e;
        if (r57 == null) goto L211;
    L213:
        String r58 = r57;
    L215:
        int r59 = r7.q;
        String r85 = i(r7);
        if (r52 == null) goto L218;
        String r311 = r52.a;
    L219:
        if (r52 == null) goto L221;
        String r312 = zp9.d.d(r52);
    L222:
        if (r52 == null) goto L224;
        String r313 = zp9.d.b(r52);
    L225:
        if (r52 == null) goto L229;
        UserCreationTrackParams r123 = r52.n;
        if (r123 == null) goto L229;
        String r314 = r123.a;
    L230:
        if (r52 == null) goto L234;
        UserCreationTrackParams r124 = r52.n;
        if (r124 == null) goto L234;
        String r411 = r124.d;
    L235:
        if (r52 == null) goto L239;
        UserCreationTrackParams r125 = r52.n;
        if (r125 == null) goto L239;
        String r412 = r125.f;
    L240:
        if (r52 == null) goto L244;
        UserCreationTrackParams r126 = r52.n;
        if (r126 == null) goto L244;
        String r413 = r126.e;
    L245:
        if (r52 == null) goto L249;
        UserCreationTrackParams r127 = r52.n;
        if (r127 == null) goto L249;
        String r217 = r127.g;
    L250:
        if (r52 == null) goto L252;
        String r63 = r52.a;
    L253:
        com.larus.bmhome.share.panel.h r128 = new com.larus.bmhome.share.panel.h(null, null, r215, "creation_detail", r216, r217, null, d(r7), null, r310, r50, r311, r312, r313, r314, null, null, null, null, r411, r413, r412, null, null, null, null, null, null, r58, Integer.valueOf(r59), null, null, null, null, null, null, null, null, null, null, null, r63, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r85, f(r99), b, false, null, null, null, null, 1058932359, -4097, 995);
        v1 r60 = z2.a.getCreationShareSettings().a();
        if (r60 == null) goto L258;
        UserCreation r218 = r52;
        long r315 = r122;
        if (r60.e() != true) goto L259;
        boolean r61 = true;
    L260:
        if (r61 == true) goto L263;
        boolean r62 = false;
    L266:
        if (r62 == false) goto L275;
        yy8.a r64 = b(r99);
        xy8.e r65 = r7.m;
        if (r65 == null) goto L270;
        String r66 = r65.c;
    L271:
        com.larus.bmhome.share.panel.d r219 = e(r64, c(r48, r66, r99.c));
        ShareScene r220 = ShareScene.IMAGE_VIEWER_REPORT;
        String r67 = null;
        sq9.i r68 = new sq9.i(ShareChannel.SHARE, null, null, 6);
        Map<String, String> r69 = r7.k;
        xy8.b r70 = r7.c;
        if (r70 == null) goto L274;
        r67 = r70.h;
    L274:
        m3.a.Z0(r99.c, new sq9.j(r48, r53, r54, r55, r116, r219, r128, r220, r119, r315, r68, r69, 0, null, null, null, r67, 61440));
        goto L284
    L270:
        r66 = null;
        goto L271
    L275:
        String r71 = null;
        r96.i(r97, "shareImageViaCreationRecord: showShareImagePanel");
        xy8.e r72 = r7.m;
        if (r72 == null) goto L278;
        String r129 = r72.c;
    L279:
        com.larus.bmhome.share.panel.d r221 = e(b(r99), c(r48, r129, r99.c));
        IUgcAIGCService.Companion r222 = IUgcAIGCService.a;
        Context r223 = r99.getContext();
        ShareScene r224 = ShareScene.IMAGE_VIEWER_REPORT;
        xy8.b r73 = r7.c;
        if (r73 == null) goto L282;
        r71 = r73.h;
    L282:
        IUgcAIGCService.a.d(r222, r223, r54, r224, r221, r128, null, r218, r71, 352);
        goto L284
    L278:
        r129 = null;
        goto L279
    L263:
        if (r60.f() == false) goto L265;
        r62 = CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{2, 5, 4, 3}), r50);
        goto L266
    L265:
        r62 = CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{5, 4, 3}), r50);
    L259:
        r61 = false;
        goto L260
    L258:
        r218 = r52;
        r315 = r122;
        goto L259
    L252:
        r63 = null;
    L249:
        r217 = null;
    L244:
        r413 = null;
    L239:
        r412 = null;
    L234:
        r411 = null;
    L229:
        r314 = null;
        goto L230
    L224:
        r313 = null;
        goto L225
    L221:
        r312 = null;
        goto L222
    L218:
        r311 = null;
    L211:
        if (r52 == null) goto L214;
        r57 = r52.a;
        goto L213
    L214:
        r58 = null;
        goto L215
    L203:
        r96 = r51;
        r97 = r13;
        if (r50.intValue() != 3) goto L206;
        r310 = true;
    L199:
        r122 = -1;
    L193:
        r119 = -1;
        goto L194
    L184:
        if (r50.intValue() != 3) goto L186;
    L187:
        r116 = null;
        goto L188
    L171:
        r50 = null;
        goto L172
    L168:
        r48 = null;
        goto L169
    L77:
        throw new NoWhenBranchMatchedException();
    L32:
        if (r10 == SourceType.CREATION_RECORD) goto L34;
        r13 = "ShareAction";
        goto L58
    L34:
        if (r10 != r11) goto L36;
        String r130 = "1";
    L37:
        xy8.g r131 = r7.d;
        if (r131 == null) goto L40;
        String r132 = r131.a;
    L41:
        if (r132 != null) goto L43;
        r132 = "";
    L43:
        JSONObject r133 = new JSONObject();
        r133.put("video_id", r132);
        r133.put("creation_task_id", r5);
        r133.put(MusicAppletPage.KEY_MESSAGE_ID, r3);
        r133.put("position", r9);
        r133.put("user_type", r12);
        r133.put("click_method", r1);
        r133.put("current_page", "video_detail");
        r133.put("is_upload_video", r130);
        Iterator<Map.Entry<String, Object>> r74 = r7.f.entrySet().iterator();
    L45:
        if (r74.hasNext() == false) goto L49;
        Map.Entry<String, Object> r75 = r74.next();
        String r76 = r75.getKey();
        Object r77 = r75.getValue();
        if (r133.has(r76) == true) goto L45;
        r133.put(r76, r77);
        goto L45
    L49:
        r13 = "ShareAction";
        FLogger.a.i(r13, "reportClickShare: ai_video_click_share, params=" + r133);
        com.larus.platform.service.o.a.reportEvent("ai_video_click_share", r133);
        goto L58
    L40:
        r132 = null;
        goto L41
    L36:
        r130 = TriggerSendLoading.NO_LOADING;
        goto L37
    L28:
        r12 = "bot";
    L19:
        xy8.f r78 = r7.l;
        if (r78 == null) goto L22;
        r3 = r78.a;
        goto L23
    L22:
        r3 = null;
    L10:
        if (r2 == null) goto L12;
        r5 = r2.a;
        goto L14
    L12:
        r5 = null;
        goto L14
    L5:
        r1 = "detail_click";
        goto L6
    }

    public final void g(final l0 r12, final xy8.d r13) {
        xy8.b r0 = r13.c;
        if (r0 == null) goto L16;
        String r2 = r0.a;
        if (r2 == null) goto L17;
        xy8.f r1 = r13.l;
        if (r1 == null) goto L10;
        final String r3 = r1.a;
    L11:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("shareImageViaSystemShare: hasImageUrl=");
        r5.append(!StringsKt.isBlank(r2));
        r5.append(", messageId=");
        r5.append(r3);
        r4.i("ShareAction", r5.toString());
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L14;
        r6.D0();
        b1 r7 = b1.a;
        r7.c("chat_long_press_share_save");
        r7.d(r2);
    L14:
        ImageSave.z(ImageSave.a, r2, null, null, null, false, true, null, new d0(this, r13, r3, r12), 94);
        return;
    L10:
        r3 = null;
        goto L11
    L17:
        return;
    }

    public static g0 c(String r3, String r4, FragmentManager r5) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L19;
        if (r4 != null) goto L12;
    L15:
        if (r0 == false) goto L19;
        return null;
    L12:
        if (r4.length() == 0) goto L15;
        r0 = false;
    L19:
        return new g0(r3, r4, r5, new Ref.ObjectRef());
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final Object h(l0 r104, xy8.d r105, Continuation<? super Unit> r106) {
        l0 r0 = r104;
        xy8.d r1 = r105;
        if ((r106 instanceof ShareAction$shareVideo$1) == false) goto L7;
        ShareAction$shareVideo$1 r3 = (ShareAction$shareVideo$1) r106;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        ShareAction$shareVideo$1 r9 = r3;
        Object r2 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        boolean r11 = true;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        nr9.g r7 = (nr9.g) r9.L$3;
        View r8 = (View) r9.L$2;
        xy8.d r10 = (xy8.d) r9.L$1;
        l0 r12 = (l0) r9.L$0;
        ResultKt.throwOnFailure(r2);
        nr9.g r13 = r7;
        r0 = r12;
        Object r14 = r2;
        View r15 = r8;
        r1 = r10;
    L72:
        GetVideoModelResultItem r16 = (GetVideoModelResultItem) r14;
        if (r16 == null) goto L77;
        VideoUrlResult r17 = r16.getVideoUrlResult();
        if (r17 == null) goto L77;
        String r18 = r17.getVideoUrl();
    L78:
        if (r18 != null) goto L80;
    L83:
        boolean r19 = true;
    L84:
        if (r19 == true) goto L92;
        r13.c = r18;
        if (r16 == null) goto L90;
        VideoUrlResult r20 = r16.getVideoUrlResult();
        if (r20 == null) goto L90;
        String r21 = r20.getDownloadFilehash();
    L91:
        r13.d = r21;
        FLogger.a.i("ShareAction", "shareVideo: resolved download url");
    L93:
        View r22 = r15;
        xy8.e r23 = r1.m;
        if (r23 == null) goto L97;
        String r24 = r23.e;
        if (r24 == null) goto L97;
    L101:
        if (r24 != null) goto L103;
        String r36 = "";
    L104:
        if (r23 == null) goto L107;
        String r25 = r23.c;
        if (r25 == null) goto L107;
    L111:
        if (r25 != null) goto L113;
        String r30 = "";
    L114:
        SourceType r26 = r1.a;
        SourceType r27 = SourceType.USER_SEND;
        if (r26 != r27) goto L117;
        String r28 = "1";
    L118:
        String r35 = r28;
        if (r0.i == false) goto L121;
        String r29 = "more_panel_click";
    L122:
        if (r26 != r27) goto L124;
        String r31 = "user";
    L125:
        JSONObject r32 = new JSONObject();
        r32.put("click_method", r29);
        r32.put("user_type", r31);
        Iterator<Map.Entry<String, Object>> r33 = r1.f.entrySet().iterator();
    L127:
        if (r33.hasNext() == false) goto L131;
        Map.Entry<String, Object> r34 = r33.next();
        String r37 = r34.getKey();
        Object r38 = r34.getValue();
        if (r32.has(r37) == true) goto L127;
        r32.put(r37, r38);
        goto L127
    L131:
        c4 r39 = new c4(null, r30, null, null, null, null, r35, r36, Integer.valueOf(r1.q), null, null, null, r32, "video_detail", 3645);
        String r40 = r13.h;
        if (r40 != null) goto L134;
        r40 = r13.c;
    L134:
        if (r40 != null) goto L136;
    L139:
        boolean r41 = true;
    L140:
        if (r41 == true) goto L145;
        IFlowSdkDepend r42 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r42 == null) goto L145;
        r42.D0();
        b1.a.d(r40);
    L145:
        if (b.b[r1.a.ordinal()] != 1) goto L213;
        xy8.e r43 = r1.m;
        if (r43 == null) goto L149;
        String r44 = r43.a;
    L150:
        if (r43 == null) goto L152;
        Integer r45 = r43.b;
    L153:
        if (r43 == null) goto L155;
        String r46 = r43.c;
    L156:
        if (r46 != null) goto L158;
        r46 = "";
    L158:
        if (r43 == null) goto L163;
        String r47 = r43.e;
        if (r47 == null) goto L163;
        String r57 = r47;
    L164:
        String r310 = r46;
        com.larus.bmhome.share.panel.h r48 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "video_detail", null, null, r310, d(r1), null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r57, Integer.valueOf(r1.q), null, null, null, null, null, null, null, null, null, null, null, r44, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, f(r0), b, false, null, null, null, null, 1073741415, -4097, GuideTipType.OTHER);
        FLogger.a.i("ShareAction", "shareVideoViaCreationRecord: creationId=" + r44 + ", creationType=" + r45);
        a5 r49 = z2.a.getCreationShareSettings().c();
        if (r49 != null) goto L167;
    L169:
        boolean r50 = false;
    L171:
        if (r50 == false) goto L176;
        if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{6, 7, 10, 11, 12}), r45) == false) goto L176;
    L177:
        if (r11 == false) goto L210;
        IVideoShareService r110 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r110 == null) goto L181;
        com.larus.bmhome.share.panel.d r51 = IVideoShareService.a.a(r110, r22, r0.b, null, r13, r46, ShareScene.VIDEO_VIEWER, r48, r39, r44, r1.k, 768);
    L182:
        com.larus.bmhome.share.panel.d r311 = e(b(r0), r51);
        nr9.f r52 = r13.g;
        if (r52 == null) goto L185;
        String r53 = r52.b;
    L186:
        if (r53 != null) goto L188;
        String r312 = "";
    L189:
        String r54 = r13.c;
        if (r54 != null) goto L192;
        String r313 = "";
    L193:
        Double r55 = r13.e;
        if (r55 == null) goto L196;
        int r410 = (int) r55.doubleValue();
    L197:
        String r56 = r13.d;
        ShareScene r314 = ShareScene.VIDEO_VIEWER;
        nr9.f r58 = r13.g;
        if (r58 == null) goto L202;
        Integer r59 = r58.e;
        if (r59 == null) goto L202;
        long r315 = r59.intValue();
    L203:
        nr9.f r60 = r13.g;
        if (r60 == null) goto L208;
        Integer r61 = r60.d;
        if (r61 == null) goto L208;
        long r316 = r61.intValue();
    L209:
        m3.a.Z0(r0.c, new sq9.j(r44, r312, r313, null, null, r311, r48, r314, r315, r316, new sq9.i(ShareChannel.SHARE, null, r44, 2), r1.k, r410, r56, null, r13.a, null, 81920));
    L248:
        return Unit.INSTANCE;
    L208:
        r316 = -1;
    L202:
        r315 = -1;
        goto L203
    L196:
        r410 = 0;
        goto L197
    L192:
        r313 = r54;
        goto L193
    L188:
        r312 = r53;
        goto L189
    L185:
        r53 = null;
        goto L186
    L181:
        r51 = null;
        goto L182
    L210:
        IVideoShareService r210 = (IVideoShareService) ServiceManager.get().getService(IVideoShareService.class);
        if (r210 == null) goto L248;
        IVideoShareService.a.b(r210, r22, r0.b, null, r13, r46, ShareScene.VIDEO_VIEWER, r48, r39, r44, r1.k, null, 2048);
    L176:
        r11 = false;
        goto L177
    L167:
        if (r49.a() != true) goto L169;
        r50 = true;
    L163:
        r57 = r44;
        goto L164
    L155:
        r46 = null;
        goto L156
    L152:
        r45 = null;
        goto L153
    L149:
        r44 = null;
        goto L150
    L213:
        xy8.e r62 = r1.m;
        if (r62 == null) goto L216;
        String r63 = r62.a;
    L217:
        xy8.f r64 = r1.l;
        if (r64 == null) goto L221;
        String r65 = r64.a;
        if (r65 == null) goto L221;
    L224:
        if (r62 == null) goto L229;
        String r66 = r62.e;
        if (r66 == null) goto L229;
        String r510 = r66;
    L230:
        String r211 = r65;
        com.larus.bmhome.share.panel.h r111 = new com.larus.bmhome.share.panel.h(null, null, "preview_gallery", "video_detail", null, null, r211, d(r1), null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r510, Integer.valueOf(r1.q), null, null, null, null, null, null, null, null, null, null, null, r63, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, f(r0), b, false, null, null, null, null, 1073741415, -4097, GuideTipType.OTHER);
        a5 r67 = z2.a.getCreationShareSettings().c();
        if (r67 == null) goto L233;
        Boolean r68 = Boolean.valueOf(r67.a());
    L234:
        FLogger r69 = FLogger.a;
        StringBuilder r70 = new StringBuilder("shareVideoViaGallery: creationId=");
        r70.append(r63);
        r70.append(", messageId=");
        r70.append(r65);
        r70.append(", vid=");
        xy8.g r71 = r1.d;
        if (r71 == null) goto L237;
        String r72 = r71.a;
    L238:
        r70.append(r72);
        r70.append(", playUrl=");
        xy8.g r73 = r1.d;
        if (r73 == null) goto L241;
        String r74 = r73.b;
    L242:
        r70.append(r74);
        r70.append(", videoShareEnable=");
        r70.append(r68);
        r70.append(", sendMetadata=");
        xy8.f r75 = r1.l;
        if (r75 == null) goto L245;
        String r112 = r75.a;
    L246:
        r70.append(r112);
        r69.i("ShareAction", r70.toString());
        IUgcAIGCService.a.o(new com.larus.uaigc.creation.f(r111, r0.b, r13, r39, r22, r1.o, b(r0)));
        goto L248
    L245:
        r112 = null;
        goto L246
    L241:
        r74 = null;
        goto L242
    L237:
        r72 = null;
        goto L238
    L233:
        r68 = null;
    L229:
        r510 = r63;
    L221:
        if (r62 == null) goto L223;
        r65 = r62.c;
        goto L224
    L223:
        r65 = null;
        goto L224
    L216:
        r63 = null;
        goto L217
    L136:
        if (r40.length() == 0) goto L139;
        r41 = false;
        goto L140
    L124:
        r31 = "bot";
        goto L125
    L121:
        r29 = "detail_click";
        goto L122
    L117:
        r28 = TriggerSendLoading.NO_LOADING;
        goto L118
    L113:
        r30 = r25;
    L107:
        xy8.f r76 = r1.l;
        if (r76 == null) goto L110;
        r25 = r76.a;
        goto L111
    L110:
        r25 = null;
        goto L111
    L103:
        r36 = r24;
    L97:
        if (r23 == null) goto L99;
        r24 = r23.a;
        goto L101
    L99:
        r24 = null;
    L90:
        r21 = null;
        goto L91
    L92:
        FLogger.a.e("ShareAction", "shareVideo: ResourceCenter returned empty url");
        goto L93
    L80:
        if (r18.length() == 0) goto L83;
        r19 = false;
    L77:
        r18 = null;
        goto L78
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        IFlowSdkDepend r77 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r77 == null) goto L17;
        r77.D0();
        b1.a.c("profile_private_creation_gallery_share");
    L17:
        r15 = r0.f;
        if (r15 == null) goto L20;
        xy8.g r78 = r1.d;
        if (r78 == null) goto L24;
        FLogger r79 = FLogger.a;
        StringBuilder r80 = new StringBuilder("shareVideo: hasPlayUrl=");
        String r81 = r78.b;
        if (r81 != null) goto L28;
    L31:
        boolean r82 = true;
    L32:
        r80.append(!r82);
        r80.append(", hasLocalPath=");
        String r83 = r78.f;
        if (r83 != null) goto L35;
    L38:
        boolean r84 = true;
    L39:
        r80.append(!r84);
        r80.append(", sourceType=");
        r80.append(r1.a);
        r79.i("ShareAction", r80.toString());
        String r85 = r78.f;
        if (r85 != null) goto L42;
    L44:
        String r212 = null;
    L45:
        String r86 = r78.a;
        String r87 = r78.g;
        if (r212 != null) goto L48;
        String r113 = r78.b;
    L49:
        String r114 = r78.c;
        Double r213 = Boxing.boxDouble(r78.l);
        String r115 = r78.d;
        if (r115 == null) goto L52;
        nr9.f r214 = new nr9.f(r115, r115, null, Boxing.boxInt(r78.k), Boxing.boxInt(r78.j), null, 36);
    L53:
        r13 = new nr9.g(r86, r87, r113, r114, r213, VideoType.MP4, r214, r212, null, null, 768);
        String r88 = r13.c;
        if (r88 != null) goto L56;
    L59:
        boolean r89 = true;
    L60:
        if (r89 == false) goto L93;
        String r90 = r13.h;
        if (r90 != null) goto L64;
    L67:
        boolean r91 = true;
    L68:
        if (r91 == false) goto L93;
        r79.i("ShareAction", "shareVideo: downloadUrl and localPath both empty, resolving via ResourceCenter");
        ResourceCenter r92 = ResourceCenter.a;
        String r93 = r13.a;
        r9.L$0 = r0;
        r9.L$1 = r1;
        r9.L$2 = r15;
        r9.L$3 = r13;
        r9.label = 1;
        r14 = ResourceCenter.i(r92, null, r93, true, r9, 1);
        if (r14 != r5) goto L72;
        return r5;
    L64:
        if (r90.length() == 0) goto L67;
        r91 = false;
        goto L68
    L56:
        if (r88.length() == 0) goto L59;
        r89 = false;
        goto L60
    L52:
        r214 = null;
        goto L53
    L48:
        r113 = r212;
        goto L49
    L42:
        if (m5.c(r85) == false) goto L44;
        r212 = r85;
        goto L45
    L35:
        if (StringsKt.isBlank(r83) == true) goto L38;
        r84 = false;
        goto L39
    L28:
        if (StringsKt.isBlank(r81) == true) goto L31;
        r82 = false;
        goto L32
    L24:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L7:
        r3 = new ShareAction$shareVideo$1(this, r106);
        goto L8
    }
}

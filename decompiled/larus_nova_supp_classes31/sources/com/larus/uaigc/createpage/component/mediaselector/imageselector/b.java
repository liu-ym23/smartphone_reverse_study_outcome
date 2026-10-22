package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import java.io.File;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceType.AVATAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean b(Image r3) {
        String r0 = r3.key;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L23;
        String r2 = r3.localResPath;
        if (r2 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        return true;
    L19:
        if (c(r3) != null) goto L25;
        return false;
    L25:
        return true;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r4 = false;
        goto L17
    L23:
        return true;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static String c(Image r3) {
        if (r3 == null) goto L13;
        ImageObj r1 = r3.imageOri;
        if (r1 == null) goto L13;
        String r2 = r1.url;
        if (r2 == null) goto L13;
        if ((!StringsKt.isBlank(r2)) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L13;
    L32:
        return r2;
    L13:
        if (r3 == null) goto L21;
        ImageObj r4 = r3.imageThumb;
        if (r4 == null) goto L21;
        r2 = r4.url;
        if (r2 == null) goto L21;
        if ((!StringsKt.isBlank(r2)) == false) goto L21;
    L22:
        if (r2 != null) goto L32;
        if (r3 == null) goto L33;
        ImageObj r5 = r3.previewImage;
        if (r5 == null) goto L34;
        String r6 = r5.url;
        if (r6 != null) goto L29;
        return null;
    L29:
        if ((!StringsKt.isBlank(r6)) == true) goto L37;
        return null;
    L37:
        return r6;
    L34:
        return null;
    L33:
        return null;
    L21:
        r2 = null;
        goto L22
    }

    public static UplinkFileEntity a(ResourceItemBean r60, ry9.j r61, MediaAttachment r62, String r63, com.larus.bmhome.resource.access.f0 r64, com.larus.bmhome.resource.access.j0 r65, Map r66, String r67, boolean r68) {
        Intrinsics.checkNotNullParameter(r60, "resourceItem");
        Intrinsics.checkNotNullParameter(r63, "identifier");
        Intrinsics.checkNotNullParameter(r66, "videoPreprocessAttributes");
        int r3 = a.a[r60.getResourceType().ordinal()];
        int r17 = 100;
        String r10 = "";
        if (r3 == 1) goto L373;
        if (r3 == 2) goto L373;
        if (r3 == 3) goto L8;
        return null;
    L8:
        boolean r4 = r61 instanceof ry9.j.c;
        if (r4 == false) goto L11;
        ry9.j.c r0 = (ry9.j.c) r61;
    L12:
        if (r0 == null) goto L14;
        ry9.i r1 = r0.b;
    L16:
        if ((r1 instanceof ry9.i.b) == false) goto L18;
        ry9.i.b r2 = (ry9.i.b) r1;
    L19:
        if (r2 == null) goto L21;
        MediaAttachment r5 = r2.a;
    L22:
        if (r5 != null) goto L24;
        r5 = r62;
    L24:
        mt8.b r11 = r60.getVideo();
        if (r64 == null) goto L27;
        mr9.l r12 = com.larus.bmhome.resource.access.s.c(r64);
    L28:
        if (r64 == null) goto L30;
        com.larus.bmhome.resource.access.j0 r6 = r64.b;
    L32:
        if ((r6 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L34;
        com.larus.bmhome.resource.access.j0.b r7 = (com.larus.bmhome.resource.access.j0.b) r6;
    L35:
        if (r7 == null) goto L45;
        String r8 = r7.b;
        if (r8 == null) goto L45;
        if ((!StringsKt.isBlank(r8)) == true) goto L42;
        r8 = null;
    L42:
        if (r8 == null) goto L45;
    L70:
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L72;
        com.larus.bmhome.resource.access.j0.a r9 = (com.larus.bmhome.resource.access.j0.a) r65;
    L73:
        if (r9 == null) goto L82;
        String r13 = r9.b;
        if (r13 == null) goto L82;
        if ((!StringsKt.isBlank(r13)) == true) goto L80;
        r13 = null;
    L80:
        if (r13 == null) goto L82;
    L88:
        if (r5 == null) goto L90;
        VideoUploadInfo r14 = r5.getVideoUploadInfo();
    L91:
        if (r12 == null) goto L101;
        mr9.n r15 = r12.e;
        if (r15 == null) goto L101;
        String r16 = r15.a;
        if (r16 == null) goto L101;
        if ((!StringsKt.isBlank(r16)) == true) goto L100;
        r16 = null;
    L100:
        if (r16 == null) goto L101;
    L114:
        String r20 = r16;
    L115:
        if (r12 == null) goto L123;
        String r18 = r12.a;
        if (r18 == null) goto L123;
        if ((!StringsKt.isBlank(r18)) == true) goto L122;
        r18 = null;
    L122:
        if (r18 == null) goto L123;
    L132:
        r10 = r18;
    L133:
        if (r12 == null) goto L143;
        String r19 = r12.c;
        if (r19 == null) goto L143;
        if ((!StringsKt.isBlank(r19)) == true) goto L140;
        r19 = null;
    L140:
        if (r19 == null) goto L143;
        String r21 = r19;
    L155:
        if ((!StringsKt.isBlank(r8)) == false) goto L157;
        String r22 = r8;
    L158:
        if (r22 == null) goto L162;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r22);
        if (r110.exists() == false) goto L162;
    L164:
        if ((!StringsKt.isBlank(r20)) == false) goto L166;
    L169:
        boolean r23 = true;
    L170:
        if (r110 == null) goto L172;
    L175:
        boolean r111 = false;
    L176:
        if (r12 != null) goto L182;
        if (r4 == false) goto L179;
        if (r23 == true) goto L182;
    L179:
        if (r111 == true) goto L182;
        boolean r24 = false;
    L183:
        if (r12 == null) goto L187;
        mr9.n r25 = r12.e;
        if (r25 == null) goto L187;
        mr9.e r26 = r25.c;
    L188:
        mr9.e r112 = com.larus.bmhome.upload.h.a.query(r63);
        if (r26 == null) goto L192;
        Integer r113 = r26.j();
        if (r113 == null) goto L192;
    L210:
        Integer r28 = r113;
    L211:
        if (r26 == null) goto L214;
        Integer r114 = r26.h();
        if (r114 == null) goto L214;
    L232:
        Integer r27 = r114;
    L233:
        if (r14 == null) goto L247;
        com.larus.bmhome.actionbar.model.f2 r115 = r14.getCover();
        if (r115 == null) goto L247;
        String r29 = r115.a;
        String r30 = r115.b;
        String r116 = "upload";
        String r31 = r115.a;
        boolean r69 = r24;
        Integer r32 = r115.d;
        if (r32 == null) goto L239;
        int r50 = r32.intValue();
    L240:
        Integer r33 = r115.c;
        if (r33 == null) goto L243;
        int r51 = r33.intValue();
    L244:
        Image r34 = new Image(r29, null, null, new ImageObj(r31, r50, r51, null, null, 24, null), null, r30, null, null, null, null, null, null, null, null, 16342, null);
        if (b(r34) == true) goto L249;
    L248:
        r34 = null;
    L249:
        if (r34 != null) goto L300;
        if (r26 == null) goto L256;
        r34 = r26.a;
        if (r34 == null) goto L256;
        if (b(r34) == false) goto L256;
    L257:
        if (r34 != null) goto L300;
        r34 = com.larus.uaigc.createpage.component.sendmessage.u0.a(r66);
        if (r34 != null) goto L261;
    L263:
        r34 = null;
    L264:
        if (r34 != null) goto L300;
        if (r112 == null) goto L271;
        r34 = r112.a;
        if (r34 == null) goto L271;
        if (b(r34) == false) goto L271;
    L272:
        if (r34 != null) goto L300;
        if (r11 == null) goto L279;
        r34 = r11.a;
        if (r34 == null) goto L279;
        if (b(r34) == false) goto L279;
    L280:
        if (r34 != null) goto L300;
        if (r28 == null) goto L283;
        int r36 = r28.intValue();
    L284:
        if (r27 == null) goto L286;
        int r37 = r27.intValue();
    L288:
        if ((!StringsKt.isBlank(r13)) == false) goto L290;
        String r35 = r13;
    L291:
        if (r35 != null) goto L299;
        if (r110 == null) goto L296;
        Uri r38 = Uri.fromFile(r110);
        if (r38 == null) goto L296;
        r35 = r38.toString();
    L297:
        if (r35 != null) goto L299;
        Image r210 = null;
    L301:
        Integer r39 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        int r40 = FileType.FileTypeVideo.getValue();
        if (r110 == null) goto L304;
        Long r41 = Long.valueOf(r110.length());
    L312:
        if (r26 == null) goto L316;
        Long r42 = r26.d();
        if (r42 == null) goto L316;
        Float r43 = Float.valueOf(r42.longValue() / 1000.0f);
    L336:
        Float r211 = r43;
    L338:
        if (Intrinsics.areEqual(r60.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L340;
        String r212 = r116;
    L341:
        String r213 = r10;
        UplinkEntityContent r44 = new UplinkEntityContent(new UplinkFileInfo(null, r213, null, Integer.valueOf(r40), r41, r21, new VideoExtension(r20, r8, r210, null, null, null, r211, r27, r28, r212, 56, null), null, r8, null, 645, null), null, 2, null);
        Integer r45 = Integer.valueOf(FileReviewState.DEFAULT.getValue());
        if (r69 == false) goto L344;
        int r46 = FileParseState.SUCCESS.getValue();
    L345:
        Integer r47 = Integer.valueOf(r46);
        if (r69 == true) goto L349;
        r17 = 0;
    L349:
        Integer r48 = Integer.valueOf(r17);
        if (r69 == false) goto L352;
        int r49 = UpLinkState.SUCCESS.getValue();
    L353:
        Integer r117 = Integer.valueOf(r49);
        if ((!StringsKt.isBlank(r13)) == true) goto L357;
        r13 = null;
    L357:
        if (r13 == null) goto L360;
        Uri r52 = UriProtector.parse(r13);
        if (r52 == null) goto L360;
    L371:
        Uri r118 = r52;
    L687:
        return new UplinkFileEntity(r39, r44, r63, null, r45, r47, r48, r117, null, false, r118, null, null, null, 15112, null);
    L360:
        if (r110 == null) goto L362;
        r52 = Uri.fromFile(r110);
    L363:
        if (r52 != null) goto L371;
        if ((!StringsKt.isBlank(r10)) == true) goto L368;
        r10 = null;
    L368:
        if (r10 == null) goto L370;
        r52 = UriProtector.parse(r10);
        goto L371
    L370:
        r118 = null;
        goto L687
    L362:
        r52 = null;
        goto L363
    L352:
        r49 = UpLinkState.PROCESSING.getValue();
        goto L353
    L344:
        r46 = FileParseState.PROCESSING.getValue();
        goto L345
    L340:
        r212 = null;
    L316:
        String r53 = (String) r66.get("video_duration_ms");
        if (r53 == null) goto L321;
        Long r54 = StringsKt.toLongOrNull(r53);
        if (r54 == null) goto L321;
        r43 = Float.valueOf(r54.longValue() / 1000.0f);
    L321:
        if (r112 == null) goto L325;
        Long r55 = r112.d();
        if (r55 == null) goto L325;
        r43 = Float.valueOf(r55.longValue() / 1000.0f);
    L326:
        if (r43 != null) goto L336;
        if (r14 == null) goto L331;
        Double r56 = r14.getDuration();
        if (r56 == null) goto L331;
        r43 = Float.valueOf((float) r56.doubleValue());
    L332:
        if (r43 != null) goto L336;
        if (r11 == null) goto L335;
        r43 = Float.valueOf(r11.b);
        goto L336
    L335:
        r211 = null;
    L331:
        r43 = null;
    L325:
        r43 = null;
        goto L326
    L304:
        if (r26 == null) goto L306;
        r41 = r26.i();
    L307:
        if (r41 != null) goto L312;
        if (r112 == null) goto L310;
        r41 = r112.i();
        goto L312
    L310:
        r41 = null;
        goto L312
    L306:
        r41 = null;
    L296:
        r35 = null;
    L299:
        r34 = new Image(r35, null, null, new ImageObj(null, r36, r37, null, null, 25, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
        goto L300
    L290:
        r35 = null;
        goto L291
    L286:
        r37 = 0;
        goto L288
    L283:
        r36 = 0;
    L279:
        r34 = null;
    L271:
        r34 = null;
        goto L272
    L261:
        if (b(r34) == false) goto L263;
    L256:
        r34 = null;
    L300:
        r210 = r34;
        goto L301
    L243:
        r51 = 0;
        goto L244
    L239:
        r50 = 0;
    L247:
        r69 = r24;
        r116 = "upload";
    L214:
        String r119 = (String) r66.get("video_height");
        if (r119 == null) goto L217;
        r114 = StringsKt.toIntOrNull(r119);
    L218:
        if (r114 != null) goto L232;
        if (r112 == null) goto L221;
        r114 = r112.h();
    L222:
        if (r114 != null) goto L232;
        if (r14 == null) goto L227;
        com.larus.bmhome.actionbar.model.f2 r120 = r14.getCover();
        if (r120 == null) goto L227;
        r114 = r120.c;
    L228:
        if (r114 != null) goto L232;
        if (r11 == null) goto L231;
        r114 = Integer.valueOf(r11.d);
        goto L232
    L231:
        r27 = null;
    L227:
        r114 = null;
        goto L228
    L221:
        r114 = null;
        goto L222
    L217:
        r114 = null;
    L192:
        String r121 = (String) r66.get("video_width");
        if (r121 == null) goto L195;
        r113 = StringsKt.toIntOrNull(r121);
    L196:
        if (r113 != null) goto L210;
        if (r112 == null) goto L199;
        r113 = r112.j();
    L200:
        if (r113 != null) goto L210;
        if (r14 == null) goto L205;
        com.larus.bmhome.actionbar.model.f2 r122 = r14.getCover();
        if (r122 == null) goto L205;
        r113 = r122.d;
    L206:
        if (r113 != null) goto L210;
        if (r11 == null) goto L209;
        r113 = Integer.valueOf(r11.c);
        goto L210
    L209:
        r28 = null;
    L205:
        r113 = null;
        goto L206
    L199:
        r113 = null;
        goto L200
    L195:
        r113 = null;
    L187:
        r26 = null;
    L182:
        r24 = true;
        goto L183
    L172:
        if (StringsKt.isBlank(r13) == false) goto L175;
        if (r23 == false) goto L175;
        r111 = true;
        goto L176
    L166:
        if ((!StringsKt.isBlank(r10)) == true) goto L169;
        r23 = false;
    L162:
        r110 = null;
        goto L164
    L157:
        r22 = null;
    L143:
        if (r5 == null) goto L149;
        r21 = r5.getResourceId();
        if (r21 == null) goto L149;
        if ((!StringsKt.isBlank(r21)) == false) goto L149;
    L150:
        if (r21 != null) goto L155;
        if (r11 == null) goto L153;
        r21 = r11.g;
        goto L155
    L153:
        r21 = null;
    L149:
        r21 = null;
    L123:
        if (r5 == null) goto L129;
        r18 = r5.getUri();
        if (r18 == null) goto L129;
        if ((!StringsKt.isBlank(r18)) == false) goto L129;
    L130:
        if (r18 != null) goto L132;
    L129:
        r18 = null;
    L101:
        if (r14 == null) goto L107;
        r16 = r14.getVid();
        if (r16 == null) goto L107;
        if ((!StringsKt.isBlank(r16)) == false) goto L107;
    L108:
        if (r16 != null) goto L114;
        if (r11 == null) goto L111;
        r16 = r11.f;
    L112:
        if (r16 != null) goto L114;
        r20 = "";
        goto L115
    L111:
        r16 = null;
    L107:
        r16 = null;
        goto L108
    L90:
        r14 = null;
    L82:
        Object r57 = r60.getExt().get("ext_video_local_uri");
        if ((r57 instanceof String) == false) goto L85;
        r13 = (String) r57;
    L86:
        if (r13 != null) goto L88;
        r13 = "";
        goto L88
    L85:
        r13 = null;
        goto L86
    L72:
        r9 = null;
    L45:
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L47;
        com.larus.bmhome.resource.access.j0.b r58 = (com.larus.bmhome.resource.access.j0.b) r65;
    L48:
        if (r58 == null) goto L54;
        r8 = r58.b;
        if (r8 == null) goto L54;
        if ((!StringsKt.isBlank(r8)) == false) goto L54;
    L55:
        if (r8 != null) goto L70;
        if (r5 == null) goto L62;
        r8 = r5.getLocalFilePath();
        if (r8 == null) goto L62;
        if ((!StringsKt.isBlank(r8)) == false) goto L62;
    L63:
        if (r8 != null) goto L70;
        if (r11 == null) goto L66;
        r8 = r11.e;
    L67:
        if (r8 != null) goto L70;
        r8 = "";
        goto L70
    L66:
        r8 = null;
    L62:
        r8 = null;
    L54:
        r8 = null;
        goto L55
    L47:
        r58 = null;
        goto L48
    L34:
        r7 = null;
        goto L35
    L30:
        r6 = null;
        goto L32
    L27:
        r12 = null;
        goto L28
    L21:
        r5 = null;
        goto L22
    L18:
        r2 = null;
        goto L19
    L14:
        r1 = null;
        goto L16
    L11:
        r0 = null;
    L373:
        String r123 = "upload";
        if ((r61 instanceof ry9.j.c) == false) goto L376;
        ry9.j.c r59 = (ry9.j.c) r61;
    L377:
        if (r59 == null) goto L379;
        ry9.i r70 = r59.b;
    L381:
        if ((r70 instanceof ry9.i.a) == false) goto L383;
        ry9.i.a r71 = (ry9.i.a) r70;
    L384:
        if (r71 == null) goto L386;
        MediaAttachment r72 = r71.a;
    L387:
        if (r72 != null) goto L389;
        r72 = r62;
    L389:
        Image r73 = r60.getImage();
        if (r64 == null) goto L392;
        mr9.l r74 = com.larus.bmhome.resource.access.s.c(r64);
    L393:
        if (r64 == null) goto L395;
        com.larus.bmhome.resource.access.j0 r75 = r64.b;
    L397:
        if ((r75 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L399;
        com.larus.bmhome.resource.access.j0.b r76 = (com.larus.bmhome.resource.access.j0.b) r75;
    L400:
        if (r76 == null) goto L410;
        String r77 = r76.b;
        if (r77 == null) goto L410;
        if ((!StringsKt.isBlank(r77)) == true) goto L407;
        r77 = null;
    L407:
        if (r77 == null) goto L410;
    L434:
        String r78 = r77;
    L436:
        if ((!StringsKt.isBlank(r78)) == false) goto L438;
        String r79 = r78;
    L439:
        if (r79 == null) goto L443;
        File r80 = new PolarisFileWrapper(r79);
        if (r80.exists() == false) goto L443;
        File r214 = r80;
    L444:
        if (r73 == null) goto L450;
        String r81 = r73.md5;
        if (r81 == null) goto L450;
        if ((!StringsKt.isBlank(r81)) == false) goto L450;
        String r215 = r81;
    L451:
        if (r72 == null) goto L460;
        String r82 = r72.getUrl();
        if (r82 == null) goto L460;
        if ((!StringsKt.isBlank(r82)) == true) goto L458;
        r82 = null;
    L458:
        if (r82 == null) goto L460;
    L472:
        String r310 = r82;
        if (r74 == null) goto L481;
        String r83 = r74.a;
        if (r83 == null) goto L481;
        if ((!StringsKt.isBlank(r83)) == true) goto L480;
        r83 = null;
    L480:
        if (r83 == null) goto L481;
    L502:
        r10 = r83;
    L503:
        String r311 = r10;
        if (r74 == null) goto L514;
        String r84 = r74.c;
        if (r84 == null) goto L514;
        if ((!StringsKt.isBlank(r84)) == true) goto L511;
        r84 = null;
    L511:
        if (r84 == null) goto L514;
    L526:
        String r312 = r84;
    L527:
        if (r73 == null) goto L530;
        ImageObj r85 = r73.imageOri;
        if (r85 == null) goto L530;
    L537:
        if (r74 == null) goto L542;
        mr9.d r86 = r74.d;
        if (r86 == null) goto L542;
        int r87 = r86.b;
    L541:
        int r216 = r87;
    L563:
        if (r74 == null) goto L567;
        mr9.d r88 = r74.d;
        if (r88 == null) goto L567;
        int r89 = r88.a;
    L587:
        int r217 = r89;
    L589:
        if (r74 == null) goto L591;
        boolean r313 = true;
    L592:
        if (r73 != null) goto L594;
        Image r90 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L595:
        if (r73 == null) goto L598;
        ImageObj r91 = r73.imageOri;
        if (r91 == null) goto L598;
    L599:
        ImageObj r218 = ImageObj.copy$default(r91, r310, r216, r217, null, null, 24, null);
        if (r68 == true) goto L607;
        if (r73 == null) goto L603;
        boolean r92 = Intrinsics.areEqual(r73.aiCreationImage, Boolean.TRUE);
    L604:
        if (r92 == true) goto L607;
        boolean r93 = false;
    L609:
        if (Intrinsics.areEqual(r60.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L612;
        r123 = null;
    L612:
        String r610 = r78;
        mr9.l r510 = r74;
        Image r94 = Image.copy$default(r90, r311, r215, null, r218, r312, r78, r63, null, null, null, Boolean.valueOf(r93), null, null, r123, 7044, null);
        Integer r95 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        UplinkEntityContent r96 = new UplinkEntityContent(null, r94, 1, null);
        if (r313 == false) goto L615;
        int r97 = FileReviewState.ACCESS.getValue();
    L616:
        Integer r98 = Integer.valueOf(r97);
        if (r313 == false) goto L619;
        int r99 = FileParseState.SUCCESS.getValue();
    L620:
        Integer r100 = Integer.valueOf(r99);
        if (r313 == true) goto L624;
        r17 = 0;
    L624:
        Integer r101 = Integer.valueOf(r17);
        if (r313 == false) goto L627;
        int r102 = UpLinkState.SUCCESS.getValue();
    L628:
        Integer r103 = Integer.valueOf(r102);
        if (r214 == null) goto L633;
        Uri r104 = Uri.fromFile(r214);
        if (r104 == null) goto L633;
    L675:
        Uri r124 = r104;
    L676:
        if (r67 == null) goto L678;
        String r125 = r67;
    L685:
        return new UplinkFileEntity(r95, r96, r63, null, r98, r100, r101, r103, null, false, r124, r125, null, null, 13064, null);
    L678:
        if (r510 == null) goto L682;
        ResourceUploadInstantInfo r105 = r510.g;
        if (r105 == null) goto L682;
        zd9.h.a.getClass();
        r125 = zd9.h.c(r105);
    L682:
        r125 = null;
    L633:
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.a) == false) goto L635;
        com.larus.bmhome.resource.access.j0.a r106 = (com.larus.bmhome.resource.access.j0.a) r65;
    L636:
        if (r106 == null) goto L645;
        String r107 = r106.b;
        if (r107 == null) goto L645;
        if ((!StringsKt.isBlank(r107)) == true) goto L643;
        r107 = null;
    L643:
        if (r107 == null) goto L645;
        r104 = UriProtector.parse(r107);
    L646:
        if (r104 != null) goto L675;
        String r126 = r610;
        boolean r127 = false;
        if (StringsKt.startsWith$default(r126, "content://", false, 2, null) == false) goto L650;
    L651:
        r127 = true;
    L652:
        if (r127 == true) goto L655;
        r126 = null;
    L655:
        if (r126 == null) goto L657;
        r104 = UriProtector.parse(r126);
    L658:
        if (r104 != null) goto L675;
        if ((!StringsKt.isBlank(r311)) == true) goto L663;
        r311 = null;
    L663:
        if (r311 == null) goto L665;
        r104 = UriProtector.parse(r311);
    L666:
        if (r104 != null) goto L675;
        if (r310 != null) goto L669;
    L674:
        r124 = null;
        goto L676
    L669:
        if ((!StringsKt.isBlank(r310)) == true) goto L672;
        r310 = null;
    L672:
        if (r310 == null) goto L674;
        r104 = UriProtector.parse(r310);
        goto L675
    L665:
        r104 = null;
        goto L666
    L657:
        r104 = null;
        goto L658
    L650:
        if (StringsKt.startsWith$default(r126, "file://", false, 2, null) == false) goto L652;
    L645:
        r104 = null;
        goto L646
    L635:
        r106 = null;
        goto L636
    L627:
        r102 = UpLinkState.PROCESSING.getValue();
        goto L628
    L619:
        r99 = FileParseState.PROCESSING.getValue();
        goto L620
    L615:
        r97 = FileReviewState.DEFAULT.getValue();
        goto L616
    L603:
        r92 = false;
    L607:
        r93 = true;
    L598:
        r91 = new ImageObj(null, 0, 0, null, null, 31, null);
        goto L599
    L594:
        r90 = r73;
        goto L595
    L591:
        r313 = false;
    L567:
        if (r72 == null) goto L573;
        ImageUploadInfo r108 = r72.getImageUploadInfo();
        if (r108 == null) goto L573;
        Long r109 = r108.getHeight();
        if (r109 == null) goto L573;
        r217 = (int) r109.longValue();
    L573:
        if (r64 == null) goto L579;
        Map r128 = r64.f;
        if (r128 == null) goto L579;
        String r129 = (String) r128.get("height");
        if (r129 == null) goto L579;
        Integer r130 = StringsKt.toIntOrNull(r129);
    L580:
        if (r130 != null) goto L586;
        if (r85 == null) goto L584;
        r130 = Integer.valueOf(r85.height);
    L585:
        if (r130 != null) goto L586;
        r217 = 0;
        goto L589
    L584:
        r130 = null;
    L586:
        r89 = r130.intValue();
    L579:
        r130 = null;
    L542:
        if (r72 == null) goto L548;
        ImageUploadInfo r131 = r72.getImageUploadInfo();
        if (r131 == null) goto L548;
        Long r132 = r131.getWidth();
        if (r132 == null) goto L548;
        r87 = (int) r132.longValue();
    L548:
        if (r64 == null) goto L554;
        Map r133 = r64.f;
        if (r133 == null) goto L554;
        String r134 = (String) r133.get("width");
        if (r134 == null) goto L554;
        Integer r135 = StringsKt.toIntOrNull(r134);
    L555:
        if (r135 != null) goto L561;
        if (r85 == null) goto L559;
        r135 = Integer.valueOf(r85.width);
    L560:
        if (r135 != null) goto L561;
        r216 = 0;
        goto L563
    L559:
        r135 = null;
    L561:
        r87 = r135.intValue();
    L554:
        r135 = null;
    L530:
        if (r73 == null) goto L532;
        r85 = r73.imageThumb;
    L533:
        if (r85 != null) goto L537;
        if (r73 == null) goto L536;
        r85 = r73.previewImage;
        goto L537
    L536:
        r85 = null;
        goto L537
    L532:
        r85 = null;
    L514:
        if (r72 == null) goto L521;
        r84 = r72.getResourceId();
        if (r84 == null) goto L521;
        if ((!StringsKt.isBlank(r84)) == false) goto L521;
    L522:
        if (r84 != null) goto L526;
        if (r73 == null) goto L525;
        r84 = r73.resourceId;
        goto L526
    L525:
        r312 = null;
    L521:
        r84 = null;
    L481:
        if (r72 == null) goto L487;
        r83 = r72.getUri();
        if (r83 == null) goto L487;
        if ((!StringsKt.isBlank(r83)) == false) goto L487;
    L488:
        if (r83 != null) goto L502;
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.d) == false) goto L492;
        com.larus.bmhome.resource.access.j0.d r136 = (com.larus.bmhome.resource.access.j0.d) r65;
    L493:
        if (r136 == null) goto L499;
        r83 = r136.b;
        if (r83 == null) goto L499;
        if ((!StringsKt.isBlank(r83)) == false) goto L499;
    L500:
        if (r83 != null) goto L502;
    L499:
        r83 = null;
        goto L500
    L492:
        r136 = null;
    L487:
        r83 = null;
    L460:
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L462;
        com.larus.bmhome.resource.access.j0.c r137 = (com.larus.bmhome.resource.access.j0.c) r65;
    L463:
        if (r137 == null) goto L469;
        r82 = r137.b;
        if (r82 == null) goto L469;
        if ((!StringsKt.isBlank(r82)) == false) goto L469;
    L470:
        if (r82 != null) goto L472;
        r82 = c(r73);
    L469:
        r82 = null;
        goto L470
    L462:
        r137 = null;
    L450:
        r215 = null;
    L443:
        r214 = null;
        goto L444
    L438:
        r79 = null;
    L410:
        if ((r65 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L412;
        com.larus.bmhome.resource.access.j0.b r138 = (com.larus.bmhome.resource.access.j0.b) r65;
    L413:
        if (r138 == null) goto L419;
        r77 = r138.b;
        if (r77 == null) goto L419;
        if ((!StringsKt.isBlank(r77)) == false) goto L419;
    L420:
        if (r77 != null) goto L434;
        if (r72 == null) goto L427;
        r77 = r72.getLocalFilePath();
        if (r77 == null) goto L427;
        if ((!StringsKt.isBlank(r77)) == false) goto L427;
    L428:
        if (r77 != null) goto L434;
        if (r73 == null) goto L431;
        r77 = r73.localResPath;
    L432:
        if (r77 != null) goto L434;
        r78 = "";
        goto L436
    L431:
        r77 = null;
    L427:
        r77 = null;
    L419:
        r77 = null;
        goto L420
    L412:
        r138 = null;
        goto L413
    L399:
        r76 = null;
        goto L400
    L395:
        r75 = null;
        goto L397
    L392:
        r74 = null;
        goto L393
    L386:
        r72 = null;
        goto L387
    L383:
        r71 = null;
        goto L384
    L379:
        r70 = null;
        goto L381
    L376:
        r59 = null;
        goto L377
    }
}

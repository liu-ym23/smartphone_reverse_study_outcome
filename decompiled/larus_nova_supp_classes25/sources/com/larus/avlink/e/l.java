package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.model.AudioSide;
import com.larus.avlink.n1;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.avlink.plugins.DoraETracer;
import com.larus.avlink.rtc.DoraRtcManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static final l a = null;
    public static r b;
    public static final CopyOnWriteArraySet<s> c = null;
    public static final x d = null;
    public static final q e = null;
    public static Integer f;
    public static com.larus.avlink.model.a g;

    public static final class a implements h49.d {
        public a() {
        }

        public final void a(int r4) {
            FLogger.a.i("DoraE_Camera", "onTakeImageHotWordIDReceived hotWordId: " + r4);
        }

        public final void d(final b49.g r15) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onDataFrame scene: ");
            String r2 = null;
            if (r15 == null) goto L5;
            Integer r3 = Integer.valueOf(r15.b);
        L6:
            r1.append(r3);
            r1.append(" stage: ");
            if (r15 == null) goto L9;
            Integer r4 = Integer.valueOf(r15.a);
        L10:
            r1.append(r4);
            r1.append(" id: ");
            if (r15 == null) goto L13;
            Integer r5 = Integer.valueOf(r15.h);
        L14:
            r1.append(r5);
            r1.append(" id: ");
            if (r15 == null) goto L17;
            Integer r6 = Integer.valueOf(r15.c);
        L18:
            r1.append(r6);
            r0.i("DoraE_Camera", r1.toString());
            if (r15 != null) goto L22;
            return;
        L22:
            if (r15.b != 1) goto L69;
            final x r7 = l.d;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r15, "frame");
            int r8 = r15.h;
            int r9 = r15.a;
            if (r9 != 1) goto L26;
            DoraImageManager.c(r8, new t());
            Lazy r16 = ia8.m.a;
            DoraEvent r17 = DoraEvent.OCRStart;
            r17.setExtra("imageUuid: " + r8);
            ia8.m.b(r17);
            return;
        L26:
            if (r9 != 3) goto L71;
            byte[] r10 = r15.g;
            Charset r11 = Charsets.UTF_8;
            final String r12 = new String(r10, r11);
            Map<String, com.larus.avlink.model.a> r13 = DoraImageManager.a;
            com.larus.avlink.model.a r14 = DoraImageManager.a(Integer.valueOf(r8));
            StringBuilder r18 = new StringBuilder("onDataFrame FINISH: imageModel: ");
            r18.append(r14);
            r18.append(", mode: ");
            if (r14 == null) goto L31;
            Integer r19 = r14.n;
        L32:
            r18.append(r19);
            r0.i("DoraVision_OCRProcessor", r18.toString());
            if (r14 == null) goto L58;
            DoraImageManager.c(r8, new u(r12, r7, r15));
            if (z98.g.a(r14) == false) goto L58;
            f98.r r20 = new f98.r();
            r20.c(1);
            r20.a(r12);
            f98.s r110 = new f98.s();
            r110.a(String.valueOf(r8));
            r110.b(2);
            r20.d(r110);
            List<f98.r> r21 = CollectionsKt.listOf(r20);
            l r111 = l.a;
            r r112 = l.b;
            int r113 = 0;
            if (r112 != null) goto L39;
        L41:
            boolean r114 = false;
        L42:
            if (r114 == false) goto L57;
            r r115 = l.b;
            if (r115 == null) goto L46;
            r113 = r115.q();
        L46:
            if (r113 != 2) goto L57;
            Long r22 = r14.o;
            if (r22 != null) goto L52;
            r22 = r14.u;
            if (r22 != null) goto L52;
            long r23 = 0;
        L54:
            we9.e r116 = new we9.e(true, r12, r23);
            Intrinsics.checkNotNullParameter(r116, "ocrData");
            r r24 = l.b;
            if (r24 == null) goto L58;
            r24.P0(r116);
        L52:
            r23 = r22.longValue();
        L57:
            r7.b(r8, r21, (Map) GsonProtectorUtils.fromJson(new Gson(), new String(r15.i, r11), new w().getType()));
            goto L58
        L39:
            if (r112.E() != true) goto L41;
            r114 = true;
        L58:
            DoraImageMode.a r117 = DoraImageMode.Companion;
            if (r14 == null) goto L61;
            Integer r25 = Integer.valueOf(r14.m);
        L62:
            r117.getClass();
            if (DoraImageMode.a.b(r25) == true) goto L66;
            r2 = r12;
        L66:
            Lazy r118 = ia8.m.a;
            DoraEvent r119 = DoraEvent.OCREnd;
            r119.setExtra("imageUuid: " + r8 + ", ocrData: " + r2);
            ia8.m.b(r119);
            r0.i("DoraVision_OCRProcessor", "onDataFrame FINISH: ocrResult: ".concat(r12));
            return;
        L61:
            r25 = null;
            goto L62
        L31:
            r19 = null;
            goto L32
        L71:
            return;
        L69:
            return;
        L17:
            r6 = null;
            goto L18
        L13:
            r5 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        public final void w(b49.k r4) {
            Intrinsics.checkNotNullParameter(r4, "trackInfo");
            FLogger.a.i("DoraE_Camera", "onRtosQueryTrackInfo trackInfo: " + r4);
            Iterator<s> r0 = l.c.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().w(r4);
            goto L4
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void c(final b49.h r21, b49.d r22) {
            Intrinsics.checkNotNullParameter(r21, "imageInfo");
            Map<String, com.larus.avlink.model.a> r2 = DoraImageManager.a;
            com.larus.avlink.model.a r3 = DoraImageManager.a(Integer.valueOf(r21.a));
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("onCameraCompleteImage imageInfo: ");
            r5.append(r21);
            r5.append(". errorCode: ");
            if (r22 == null) goto L5;
            Integer r6 = Integer.valueOf(r22.a);
        L6:
            r5.append(r6);
            r5.append(", imageModel: ");
            r5.append(r3);
            r4.i("DoraE_Camera", r5.toString());
            if (r3 == null) goto L9;
            List<byte[]> r7 = r3.l;
        L10:
            if (r3 == null) goto L12;
            Integer r8 = Integer.valueOf(r3.k);
        L13:
            if (r3 == null) goto L15;
            Integer r9 = Integer.valueOf(r3.m);
        L17:
            if (r7 == null) goto L116;
            if (r8 != null) goto L21;
        L22:
            if (r9 == null) goto L116;
            if (r21.b == null) goto L116;
            if (r22 != null) goto L29;
        L32:
            StringBuilder r11 = new StringBuilder("onCameraCompleteImage. ImageUUID: ");
            r11.append(r21.a);
            r11.append(", side: ");
            r11.append(r21.f);
            r11.append(", size:");
            byte[] r12 = r21.b;
            if (r12 == null) goto L35;
            Integer r13 = Integer.valueOf(r12.length);
        L36:
            r11.append(r13);
            r11.append(", width:");
            r11.append(r21.c);
            r11.append(", height:");
            r11.append(r21.d);
            r4.i("DoraE_Camera", r11.toString());
            DoraImageManager.c(r21.a, new h(r21));
        L37:
            q r14 = l.e;
            int r15 = r9.intValue();
            r14.getClass();
            q.b(r21, r15, r22);
            if (r3.l.size() < r3.k) goto L40;
            boolean r16 = true;
        L41:
            if (r16 == false) goto L111;
            Pair<String, Boolean> r10 = DoraETracer.a;
            int r17 = r21.a;
            if (r3.l.size() < r3.k) goto L45;
            boolean r18 = true;
        L46:
            if (r18 == false) goto L49;
            int r19 = 0;
        L52:
            if (r22 == null) goto L54;
            int r1 = r22.a;
        L55:
            long r110 = System.currentTimeMillis();
            com.larus.avlink.model.a r111 = DoraImageManager.a(Integer.valueOf(r17));
            n1.d("DoraETracer", "reportDoraVisionImageTransferResult picModel: " + r111);
            if (r111 == null) goto L69;
            Long r112 = r111.b(DoraImageEvent.IMAGE_TAKE_START);
            if (r112 == null) goto L61;
            long r113 = r112.longValue();
        L62:
            Long r20 = r111.b(DoraImageEvent.IMAGE_TRANS_START);
            if (r20 == null) goto L65;
            long r114 = r20.longValue();
        L66:
            LinkedHashMap r23 = new LinkedHashMap();
            r23.put("duration", Long.valueOf(r110 - r113));
            r23.put("status", Integer.valueOf(r19));
            r23.put("error_code", Integer.valueOf(r1));
            r23.put("take_pic_duration", Long.valueOf(r114 - r113));
            r23.put("pic_trans_duration", Long.valueOf(r110 - r114));
            DoraETracer.a(r23, r111);
            IDoraService r24 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r24 == null) goto L69;
            r24.A0("flow_dora_vision_image_transfer_result", r23);
            goto L69
        L65:
            r114 = r110;
            goto L66
        L61:
            r113 = r110;
        L69:
            DoraImageEvent r25 = DoraImageEvent.IMAGE_TRANS_FINISH;
            r3.c(r25, true, System.currentTimeMillis());
            l r26 = l.a;
            Iterator<s> r27 = l.c.iterator();
        L71:
            if (r27.hasNext() == false) goto L74;
            s r28 = r27.next();
            Intrinsics.checkNotNull(r28);
            Intrinsics.checkNotNullParameter(r28, "it");
            r28.p1(r3, DoraImageEvent.IMAGE_TRANS_FINISH);
            Unit r29 = Unit.INSTANCE;
            goto L71
        L74:
            if ((!CollectionsKt.filterNotNull(r7).isEmpty()) == false) goto L87;
            r4.i("DoraE_Camera", "start dealWithCaptureResult, imageUUID: " + r21.a + ", receivedCount:" + r7.size());
            int r30 = r9.intValue();
            List<b49.h> r31 = r3.a();
            int r32 = r21.a;
            if (z98.g.a(DoraImageManager.a(Integer.valueOf(r32))) == false) goto L86;
            r4.i("DoraE_Camera", "upload file directly");
            List<b49.h> r33 = r31;
            ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
            Iterator<T> r35 = r33.iterator();
        L79:
            if (r35.hasNext() == false) goto L85;
            b49.h r36 = (b49.h) r35.next();
            if (r36 == null) goto L83;
            f98.l r37 = f98.g.b(r36, r30);
        L84:
            r34.add(r37);
            goto L79
        L83:
            r37 = null;
            goto L84
        L85:
            r26.b(r21, r30, r34);
        L112:
            t39.j r0 = (t39.j) ServiceManager.get().getService(t39.j.class);
            if (r0 == null) goto L122;
            r0.a();
            return;
        L122:
            return;
        L86:
            r4.i("DoraE_Camera", "PreCapture - cache update, imageUUID: " + r32 + ", images count: " + r31.size());
            goto L112
        L87:
            r4.e("DoraE_Camera", "[IMAGE_ERROR] skip send: no valid contents. imageId: " + r21.a + ", mode: " + r21.i);
            Integer r38 = Integer.valueOf(r21.a);
            if (r38 == null) goto L97;
            r38.intValue();
            com.larus.avlink.model.a r39 = DoraImageManager.a(r38);
            if (r39 != null) goto L92;
        L94:
            boolean r40 = false;
        L95:
            if (r40 == false) goto L97;
            boolean r41 = true;
        L98:
            if (r41 == false) goto L100;
            l.a(Integer.valueOf(r21.a));
        L100:
            DoraImageMode.Companion.getClass();
            if (DoraImageMode.a.b(r9) == false) goto L109;
            Integer r42 = r3.n;
            if (r42 == null) goto L109;
            if (DoraImageMode.a.c(r42) == true) goto L109;
            r r43 = l.b;
            if (r43 == null) goto L109;
            boolean r44 = false;
            r43.T(TriggerMode.CLIENT_SUMMON_NOTICE, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("notice_key", "trans_client_fail")}));
        L110:
            r3.c(r25, r44, System.currentTimeMillis());
        L109:
            r44 = false;
            goto L110
        L92:
            if (r39.G != true) goto L94;
            r40 = true;
        L97:
            r41 = false;
            goto L98
        L54:
            r1 = 0;
            goto L55
        L49:
            if (r3.l.size() != 1) goto L51;
            r19 = 1;
            goto L52
        L51:
            r19 = 2;
            goto L52
        L45:
            r18 = false;
            goto L46
        L111:
            r4.i("DoraE_Camera", "image has not received all. receivedCount:" + r7.size() + ", imageCount: " + r3.k);
            goto L112
        L40:
            r16 = false;
            goto L41
        L35:
            r13 = null;
            goto L36
        L29:
            if (r22.a == 1) goto L32;
            r3.l.add(null);
            r4.e("DoraE_Camera", "onCameraCompleteImage error. Error: " + r22.a + ", message: " + r22.b);
            goto L37
        L21:
            if (r8.intValue() != 0) goto L22;
        L116:
            l.e.getClass();
            q.b(r21, 0, r22);
            r4.e("DoraE_Camera", "[IMAGE_ERROR] onCameraCompleteImage error, imageID: " + r21.a + ", images: " + r7 + ", imageCount: " + r8 + ", imageMode: " + r9 + ", imageInfo.data: " + r21.b);
            return;
        L15:
            r9 = null;
            goto L17
        L12:
            r8 = null;
            goto L13
        L9:
            r7 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }

        public final void j(boolean r7, int r8, byte r9) {
            l.d.getClass();
            Map<String, com.larus.avlink.model.a> r0 = DoraImageManager.a;
            com.larus.avlink.model.a r1 = DoraImageManager.a(Integer.valueOf(r8));
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("onImageOcrResultUpdate imageUuid: ");
            r3.append(r8);
            r3.append(" result: ");
            r3.append(r7);
            r3.append(" imageMode == null: ");
            boolean r4 = true;
            int r5 = 0;
            if (r1 != null) goto L5;
            boolean r6 = true;
        L6:
            r3.append(r6);
            r2.i("DoraVision_OCRProcessor", r3.toString());
            if (r1 == null) goto L26;
            r1.q = Boolean.valueOf(r7);
            l r10 = l.a;
            r r11 = l.b;
            if (r11 != null) goto L12;
        L14:
            r4 = false;
        L15:
            if (r4 == false) goto L22;
            r r12 = l.b;
            if (r12 == null) goto L20;
            r5 = r12.q();
        L20:
            if (r5 == 2) goto L26;
        L22:
            if (r7 == true) goto L26;
            if (z98.g.a(r1) == false) goto L26;
            x.a(r8);
            goto L26
        L12:
            if (r11.E() != true) goto L14;
        L26:
            Iterator<s> r13 = l.c.iterator();
        L28:
            if (r13.hasNext() == false) goto L30;
            s r14 = r13.next();
            Intrinsics.checkNotNull(r14);
            Intrinsics.checkNotNullParameter(r14, "it");
            r14.j(r7, r8, r9);
            Unit r15 = Unit.INSTANCE;
            goto L28
        L30:
            return;
        L5:
            r6 = false;
            goto L6
        }

        public final void b(int r36, final int r37, final int r38, int r39, final int r40, final int r41, final int r42, int r43, final int r44, final int r45, final int r46, final int r47, final int r48, final int r49, final long r50, final int r52, final int r53, final int r54) {
            l.e.getClass();
            String r2 = GsonProtectorUtils.toJson(new Gson(), new z98.i());
            int r10 = 1;
            if (r36 == 1) goto L9;
            if (r36 == 2) goto L8;
            if (r36 == 3) goto L7;
            DoraEvent r3 = DoraEvent.Unknown;
            r3.setExtra("takeCameraDoraTraceGenerate");
        L11:
            l r5 = l.a;
            if (l.c() == true) goto L16;
            DoraImageMode.a r6 = DoraImageMode.Companion;
            Integer r7 = Integer.valueOf(r42);
            r6.getClass();
            if (DoraImageMode.a.b(r7) == false) goto L16;
            ia8.m.b(r3);
        L16:
            FLogger r9 = FLogger.a;
            r9.i("DoraE_Camera", "onTakeImageState. imageState: " + r36 + ", imageUuid: " + r37 + ", imageCount: " + r40 + ", side: " + r41 + ", mode: " + r42 + ", transmitResult: " + r43 + ", quality: " + r47 + ", hasOcr: " + r49 + ", obsSubMode: " + r54);
            int r4 = z98.c.a;
            if (r36 == 1) goto L41;
            if (r36 != 2) goto L20;
            DoraImageManager.c(r37, new j(r50, r52, r53, r49));
            Iterator<s> r0 = l.c.iterator();
        L39:
            if (r0.hasNext() == false) goto L99;
            s r1 = r0.next();
            Intrinsics.checkNotNull(r1);
            Intrinsics.checkNotNullParameter(r1, "it");
            Map<String, com.larus.avlink.model.a> r8 = DoraImageManager.a;
            r1.p1(DoraImageManager.a(Integer.valueOf(r37)), DoraImageEvent.IMAGE_TRANS_START);
            Unit r11 = Unit.INSTANCE;
            goto L39
        L99:
            return;
        L20:
            if (r36 != 3) goto L97;
            if (r43 == 1) goto L24;
            r9.e("DoraE_Camera", "[IMAGE_ERROR] transmitResult error. imageId: " + r37 + ", mode: " + r42 + ", transmitResult: " + r43);
            l.a(Integer.valueOf(r37));
            DoraImageManager.c(r37, new k());
        L24:
            if (r43 == 2) goto L34;
            switch(r43) {
                case 8: goto L31;
                case 9: goto L31;
                case 10: goto L27;
                default: goto L98;
            };
        L27:
            Map<String, com.larus.avlink.model.a> r12 = DoraImageManager.a;
            com.larus.avlink.model.a r13 = DoraImageManager.a(Integer.valueOf(r37));
            if (r13 == null) goto L92;
            r13.I = true;
            l.j(r13);
            return;
        L92:
            return;
        L98:
            return;
        L31:
            if (r41 != 1) goto L33;
            r10 = 0;
        L33:
            l.f(r42, r37, r10, 3, r47);
            return;
        L34:
            if (r41 != 1) goto L36;
            r10 = 0;
        L36:
            l.f(r42, r37, r10, 2, r47);
            return;
        L97:
            return;
        L41:
            final long r17 = System.currentTimeMillis();
            Map<String, com.larus.avlink.model.a> r14 = DoraImageManager.a;
            com.larus.avlink.model.a r15 = DoraImageManager.a(l.f);
            DoraImageMode.a r16 = DoraImageMode.Companion;
            if (r15 == null) goto L44;
            Integer r18 = Integer.valueOf(r15.m);
        L45:
            r16.getClass();
            if (DoraImageMode.a.c(r18) == false) goto L51;
            if (r15 == null) goto L51;
            List<byte[]> r19 = r15.l;
            if (r19 == null) goto L51;
            r19.clear();
        L51:
            l.f = Integer.valueOf(r37);
            com.larus.avlink.model.a r20 = l.g;
            if (r20 != null) goto L54;
        L56:
            r20 = new com.larus.avlink.model.a(null, 0, 0, 0, 0, null, null, null, -1, 63);
            String r21 = String.valueOf(r37);
            Intrinsics.checkNotNullParameter(r21, "imageId");
            Intrinsics.checkNotNullParameter(r20, "model");
            DoraImageManager.a.put(r21, r20);
        L57:
            com.larus.avlink.model.a r22 = r20;
            DoraImageManager.c(r37, new i(r37, r44, r45, r46, r47, r38, r40, r42, r48, r52, r53, r54, r41, r17));
            Pair<String, Boolean> r23 = DoraETracer.a;
            com.larus.avlink.model.a r24 = DoraImageManager.a(Integer.valueOf(r37));
            n1.d("DoraETracer", "reportDoraVisionImageBeginShoot picModel: " + r24);
            if (r24 == null) goto L63;
            LinkedHashMap r25 = new LinkedHashMap();
            DoraETracer.a(r25, r24);
            IDoraService r26 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r26 == null) goto L63;
            r26.A0("flow_dora_vision_image_begin_shoot", r25);
        L63:
            t39.j r27 = (t39.j) ServiceManager.get().getService(t39.j.class);
            if (r27 == null) goto L66;
            r27.b();
        L66:
            r9.i("DoraE_Camera", "action isn't null， action: " + l.b + ", mode: " + r42);
            Integer r28 = r22.n;
            if (r28 == null) goto L69;
            int r110 = r28.intValue();
        L70:
            Iterator<s> r29 = l.c.iterator();
        L71:
            boolean r111 = false;
        L73:
            if (r29.hasNext() == false) goto L78;
            if (r29.next().D0(r37, r40, r42, r41, r47) == true) goto L77;
            if (r111 == false) goto L71;
        L77:
            r111 = true;
            goto L73
        L78:
            if (r111 == false) goto L80;
        L85:
            FLogger.a.i("DoraE_Camera", "dispatchSendImageEvent not send image event imageUuid: " + r37 + " mode: " + r42 + ", intentMode: " + r110);
            return;
        L80:
            if (r42 == 6) goto L82;
            boolean r112 = true;
        L83:
            if (r112 == false) goto L85;
            l r30 = l.a;
            l.h(r37, r40, r110, r41, r47);
            return;
        L82:
            r112 = false;
            goto L83
        L69:
            r110 = r42;
            goto L70
        L54:
            if (r42 != r20.m) goto L56;
            String r31 = String.valueOf(r37);
            Intrinsics.checkNotNullParameter(r31, "imageId");
            Intrinsics.checkNotNullParameter(r20, "model");
            DoraImageManager.a.put(r31, r20);
            l.g = null;
            goto L57
        L44:
            r18 = null;
            goto L45
        L7:
            DoraEvent r32 = DoraEvent.EndTransmitImage;
            r32.setExtra(r2);
        L10:
            r3 = r32;
            goto L11
        L8:
            r32 = DoraEvent.StartTransmitImage;
            r32.setExtra(r2);
            goto L10
        L9:
            r32 = DoraEvent.StartTakeImage;
            r32.setExtra(r2);
            goto L10
        }
    }

    public l() {
    }

    static {
        a = new l();
        c = new CopyOnWriteArraySet();
        d = new x();
        e = new q();
        a r0 = new a();
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L7;
        com.larus.dora.impl.serviceimpl.h r2 = r1.debug();
        if (r2 == null) goto L7;
        int r3 = r2.e();
    L8:
        if (r3 == 0) goto L10;
        com.larus.avlink.e.mock.e.b(com.larus.avlink.e.mock.e.a);
        FLogger.a.i("DoraE_Camera", "📹 CameraMockManager initialized (visionMockMode=" + r3 + ')');
    L10:
        com.larus.avlink.e.mock.e r4 = com.larus.avlink.e.mock.e.a;
        Intrinsics.checkNotNullParameter(r0, "originalListener");
        com.larus.avlink.e.mock.a r5 = new com.larus.avlink.e.mock.a(r0, com.larus.avlink.e.mock.e.b, com.larus.avlink.e.mock.e.c);
        com.larus.avlink.e.mock.f r6 = com.larus.avlink.e.mock.e.c;
        if (r6 == null) goto L13;
        r6.b = r0;
        FLogger.a.i("CameraMockPlayer", "Listener set: true");
    L13:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L19;
        VisionService r8 = r7.V();
        if (r8 == null) goto L20;
        r8.s(r5);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public static boolean c() {
        int r0 = o.a;
        AndroidPlatformKt.a();
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L9;
        VisionService r2 = r1.V();
        if (r2 == null) goto L9;
        boolean r3 = true;
        if (r2.h() != true) goto L9;
    L10:
        FLogger.a.i("DoraE_Camera", "enableBurstMode: " + r3);
        return r3;
    L9:
        r3 = false;
        goto L10
    }

    public static final void a(Integer r11) {
        if (r11 == null) goto L8;
        r11.intValue();
        com.larus.avlink.model.a r0 = DoraImageManager.a(r11);
        if (r0 == null) goto L9;
        int r2 = r0.m;
        List<b49.h> r4 = r0.a();
        FLogger.a.i("DoraE_Camera", "cancelUploadFile. imageId: " + r11 + ", mode: " + r2);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraECameraDelegate$cancelUploadFile$1(r11, r2, 2, r4, null), 3, null);
        return;
    L9:
        return;
    }

    public static int d(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L11:
        if (r2 != null) goto L14;
    L16:
        return 10;
    L14:
        if (r2.intValue() != 17) goto L16;
    L17:
        return 11;
    L10:
        if (r2.intValue() == 2) goto L17;
    L5:
        if (r2.intValue() != 20) goto L7;
        return 13;
    }

    public static void g(int r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("type", Integer.valueOf(r2));
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L6;
        r3.A0("dora_e_pre_shoot_type", r0);
        return;
    }

    public static boolean j(com.larus.avlink.model.a r7) {
        Intrinsics.checkNotNullParameter(r7, "imageModel");
        if (r7.I == true) goto L5;
    L26:
        return false;
    L5:
        if (r7.J == false) goto L26;
        DoraImageMode.a r0 = DoraImageMode.Companion;
        Integer r2 = r7.n;
        r0.getClass();
        if (r2 == null) goto L13;
        r2.intValue();
        if (r2.intValue() != 7) goto L11;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L26;
        if (r7.K == true) goto L25;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("SendLedBlockedTrigger imageId: ");
        r5.append(r7.a);
        r5.append(", action is null: ");
        if (b != null) goto L20;
        boolean r6 = true;
    L21:
        r5.append(r6);
        r4.i("DoraE_Camera", r5.toString());
        r r8 = b;
        if (r8 == null) goto L24;
        r8.T(TriggerMode.CLIENT_SUMMON_NOTICE, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("notice_starling_key", "dora_server_led_blocked_notice_cn")}));
    L24:
        r7.K = true;
        goto L25
    L20:
        r6 = false;
    L25:
        return true;
    L11:
        if (r2.intValue() == 1) goto L12;
    L13:
        r3 = false;
        goto L14
    }

    public static void i(int r6, String r7) {
        boolean r0 = o.a();
        FLogger r1 = FLogger.a;
        r1.i("DoraE_Camera", "enableTakeImage: " + r0);
        if (r0 == true) goto L5;
    L29:
        boolean r4 = false;
    L30:
        r1.i("DoraE_Camera", "canPreCapture, res: " + r4 + ", doraSessionMode: " + r6);
        if (r4 == false) goto L33;
        r1.i("DoraE_Camera", "PreCapture - start pre-capture.");
        e(10, 0, r7);
        return;
    L33:
        r1.i("DoraE_Camera", "PreCapture - not enable.");
        return;
    L5:
        if (c() == true) goto L29;
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        r4 = true;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L29;
        if (v88.a.c(Integer.valueOf(r6)) == true) goto L29;
        if (v88.a.f(Integer.valueOf(r6)) == true) goto L29;
        if (v88.a.e(Integer.valueOf(r6)) == true) goto L29;
        if (r6 == 11) goto L29;
        r r5 = b;
        if (r5 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == true) goto L29;
    L24:
        if (r5.A() != true) goto L26;
        r8 = true;
        goto L27
    L9:
        if (r2.v() != true) goto L11;
        r3 = true;
        goto L12
    }

    public static void e(@DoraImageMode int r7, int r8, String r9) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.w() != 2) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraECameraDelegate$notifyDoraTakePicture$1(r7, r8, r9, null), 3, null);
        return;
    L12:
        FLogger.a.e("DoraE_Camera", "notifyDoraTakePicture, take picture skipped by HFP occupied..");
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void b(b49.h r11, int r12, List<f98.l> r13) {
        Intrinsics.checkNotNullParameter(r11, "imageInfo");
        Intrinsics.checkNotNullParameter(r13, "images");
        Map<String, com.larus.avlink.model.a> r1 = DoraImageManager.a;
        com.larus.avlink.model.a r2 = DoraImageManager.a(Integer.valueOf(r11.a));
        if (r2 != null) goto L6;
        FLogger.a.e("DoraE_Camera", "doUploadFile cancel imageModel is null.");
        return;
    L6:
        DoraImageEvent r3 = DoraImageEvent.IMAGE_UPLOAD_START;
        Intrinsics.checkNotNullParameter(r3, "event");
        int r5 = 0;
        if (r2.M.get(r3) == null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        FLogger.a.i("DoraE_Camera", "doUploadFile imageModel has Uploaded: " + r2);
        return;
    L13:
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "event");     // Catch: Throwable -> L79
        if (r2.M.get(r3) == null) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L22;
        FLogger.a.i("DoraE_Camera", "doUploadFile imageModel has Uploaded in synchronized: " + r2);     // Catch: Throwable -> L79
        monitor-exit(this);
        return;
    L22:
        r2.c(r3, true, System.currentTimeMillis());     // Catch: Throwable -> L79
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L79
        monitor-exit(this);
        if (DoraRtcManager.f() == false) goto L34;
        r r7 = b;
        if (r7 != null) goto L29;
    L31:
        boolean r8 = false;
    L32:
        if (r8 == false) goto L34;
        boolean r9 = true;
    L35:
        r r10 = b;
        if (r10 != null) goto L38;
    L40:
        final boolean r14 = false;
    L41:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("doUploadFile imageUploadByRTC: ");
        r16.append(r9);
        r16.append(", imageUploadByMMT: ");
        r16.append(r14);
        r16.append(", action?.isRTCSession(): ");
        r r17 = b;
        if (r17 == null) goto L44;
        Boolean r18 = Boolean.valueOf(r17.x());
    L45:
        r16.append(r18);
        r15.i("DoraE_Camera", r16.toString());
        Iterator<s> r19 = c.iterator();
    L47:
        if (r19.hasNext() == false) goto L49;
        s r20 = r19.next();
        Intrinsics.checkNotNull(r20);
        Intrinsics.checkNotNullParameter(r20, "it");
        Map<String, com.larus.avlink.model.a> r21 = DoraImageManager.a;
        r20.p1(DoraImageManager.a(Integer.valueOf(r11.a)), DoraImageEvent.IMAGE_UPLOAD_START);
        Unit r22 = Unit.INSTANCE;
        goto L47
    L49:
        if (r9 == true) goto L53;
        if (r14 == true) goto L53;
        DoraImageManager.c(r11.a, new b());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraECameraDelegate$doUploadFileByHttp$1(r11, r12, r13, null), 3, null);
        return;
    L53:
        DoraImageManager.c(r11.a, new com.larus.avlink.e.a(r14));
        StringBuilder r23 = new StringBuilder();
        r23.append(r11.a);
        r23.append('_');
        r23.append(r11.f);
        final String r24 = r23.toString();
        DoraImageManager.c(r11.a, new c(r24));
        StringBuilder r25 = new StringBuilder("doUploadFileByRTC imageInfo: ");
        r25.append(r11);
        r25.append(", uploadId: ");
        r25.append(r24);
        r25.append(", action == null: ");
        if (b != null) goto L56;
        boolean r26 = true;
    L57:
        r25.append(r26);
        r15.i("DoraE_Camera", r25.toString());
        r r27 = b;
        if (r27 == null) goto L60;
        r27.E2(r11, r24);
    L60:
        q r28 = e;
        int r29 = r11.a;
        f98.e r30 = new f98.e();
        r30.c(a98.a.a);
        r30.e(a98.a.b);
        List<f98.l> r110 = r13;
        if ((r110 instanceof Collection) == true) goto L63;
    L65:
        Iterator<T> r31 = r110.iterator();
        int r32 = 0;
    L67:
        if (r31.hasNext() == false) goto L76;
        if (((f98.l) r31.next()) == null) goto L71;
        boolean r33 = true;
    L72:
        if (r33 == false) goto L67;
        r32 = r32 + 1;
        if (r32 >= 0) goto L67;
        CollectionsKt.throwCountOverflow();
        goto L67
    L71:
        r33 = false;
        goto L72
    L76:
        r5 = r32;
    L77:
        r30.a = r5;
        r30.b = r12;
        r30.i(d(Integer.valueOf(r12)));
        r30.d(CollectionsKt.filterNotNull(r110));
        r30.h(o.b());
        f98.m r111 = new f98.m();
        r111.a(r11.e);
        r30.g(r111);
        r28.getClass();
        q.a(r29, r12, r30);
        return;
    L63:
        if (r110.isEmpty() == false) goto L65;
    L56:
        r26 = false;
        goto L57
    L44:
        r18 = null;
        goto L45
    L38:
        if (r10.E() != true) goto L40;
        r14 = true;
        goto L41
    L29:
        if (r7.x() != true) goto L31;
        r8 = true;
    L34:
        r9 = false;
        goto L35
    L17:
        r6 = false;
    L79:
        th = move-exception;
        throw th;
    L9:
        r4 = false;
        goto L10
    }

    public final void k(@DoraImageMode int r17, int r18, String r19) {
        FLogger r3 = FLogger.a;
        r3.i("DoraE_Camera", "tryTakePictureCompat, mode: " + r17 + ", quality: " + r18 + ", messageId: " + r19);
        int r4 = 3;
        if (r18 != 1) goto L6;
        g(3);
        e(r17, 1, r19);
        return;
    L6:
        r3.i("DoraE_Camera", "isImageTransferring: messageId is " + r19);
        if (r19 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L20;
        com.larus.avlink.model.a r9 = DoraImageManager.b(r19);
        if (r9 == null) goto L20;
        if (r9.N.compareTo(DoraImageEvent.TAKE_PHOTO_CMD_SEND) < 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L23;
        com.larus.avlink.model.a r11 = DoraImageManager.b(r19);
    L45:
        com.larus.avlink.model.a r12 = r11;
    L46:
        if (r12 == null) goto L103;
        r3.i("DoraE_Camera", "PreCapture - Pre-capture transferring or pending.");
        Integer r13 = r12.a;
        r12.n = Integer.valueOf(r17);
        r12.H = r19;
        if (j(r12) == true) goto L102;
        if (r13 == null) goto L101;
        x r2 = d;
        int r14 = r13.intValue();
        r2.getClass();
        Map<String, com.larus.avlink.model.a> r15 = DoraImageManager.a;
        com.larus.avlink.model.a r16 = DoraImageManager.a(Integer.valueOf(r14));
        if (r16 != null) goto L54;
        r3.e("DoraVision_OCRProcessor", "checkOcrDataStatus. imageModel is null. imageId: " + r14);
    L74:
        if (r12.G == true) goto L92;
        int r5 = r13.intValue();
        AudioSide.a r110 = AudioSide.Companion;
        Integer r111 = Integer.valueOf(r12.k);
        Integer r112 = Integer.valueOf(r12.h);
        r110.getClass();
        if (r111 != null) goto L79;
    L81:
        if (r112 != null) goto L84;
    L86:
        if (r112 != null) goto L89;
    L91:
        f(r17, r5, r4, 0, r18);
        goto L92
    L89:
        if (r112.intValue() != 2) goto L91;
        r4 = 1;
        goto L91
    L84:
        if (r112.intValue() != 1) goto L86;
        r4 = 0;
        goto L91
    L79:
        if (r111.intValue() != 2) goto L81;
        r4 = 2;
    L92:
        b49.h r1 = (b49.h) CollectionsKt.firstOrNull(r12.a());
        r3.i("DoraE_Camera", "PreCapture - upload use pre-capture: " + r13 + " , imageInfo: " + r1);
        if (r1 == null) goto L102;
        List<b49.h> r6 = r12.a();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r20 = r6.iterator();
    L96:
        if (r20.hasNext() == false) goto L98;
        r7.add(f98.g.b((b49.h) r20.next(), r17));
        goto L96
    L98:
        b(r1, r17, r7);
        goto L102
    L54:
        Boolean r113 = r16.q;
        if (r113 != null) goto L58;
        r3.i("DoraVision_OCRProcessor", "checkOcrDataStatus. ocrDetectionRes is null. imageId: " + r14);
        goto L74
    L58:
        if (Intrinsics.areEqual(r113, Boolean.FALSE) == false) goto L61;
        x.a(r14);
        goto L74
    L61:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L100;
        String r114 = r16.x;
        if (r114 != null) goto L65;
    L72:
        r3.i("DoraVision_OCRProcessor", "checkOcrDataStatus. ocrData not upload. imageModel.hasOcr: " + Boolean.valueOf(r16.p) + ", imageModel.ocrUploaded:" + Boolean.valueOf(r16.z) + ". ocrData: " + r114 + ", ");
        goto L74
    L65:
        if (r16.z == true) goto L72;
        if (r16.p == false) goto L72;
        r3.i("DoraVision_OCRProcessor", "checkOcrDataStatus. has ocrData and not upload.");
        f98.r r115 = new f98.r();
        r115.c(1);
        r115.a(r114);
        f98.s r116 = new f98.s();
        r116.a(String.valueOf(r14));
        r116.b(2);
        r115.d(r116);
        List<f98.r> r117 = CollectionsKt.listOf(r115);
        Map<String, ? extends Object> r118 = r16.y;
        if (r118 != null) goto L71;
        r118 = MapsKt.emptyMap();
    L71:
        r2.b(r14, r117, r118);
        goto L74
    L100:
        throw new NoWhenBranchMatchedException();
    L101:
        r3.i("DoraE_Camera", "PreCapture - intentMode set, waiting for image callback. intentMode: " + r17);
    L102:
        g(2);
        return;
    L103:
        r3.i("DoraE_Camera", "not trans or not preCapture");
        e(r17, r18, r19);
        return;
    L23:
        Integer r21 = f;
        r3.i("DoraE_Camera", "isImageTransferring: imageId is " + r21);
        r12 = null;
        Integer r22 = null;
        r12 = null;
        if (r21 == null) goto L30;
        r21.intValue();
        com.larus.avlink.model.a r23 = DoraImageManager.a(r21);
        DoraImageMode.a r119 = DoraImageMode.Companion;
        if (r23 == null) goto L28;
        Integer r120 = Integer.valueOf(r23.m);
    L29:
        r119.getClass();
        boolean r121 = DoraImageMode.a.c(r120);
        r3.i("DoraE_Camera", "isImageTransferring: res: " + r121 + ". imageModel: " + r23);
    L31:
        if (r121 == false) goto L34;
        Map<String, com.larus.avlink.model.a> r24 = DoraImageManager.a;
        r11 = DoraImageManager.a(f);
        goto L45
    L34:
        if (g == null) goto L46;
        DoraImageMode.a r25 = DoraImageMode.Companion;
        com.larus.avlink.model.a r122 = g;
        if (r122 == null) goto L38;
        Integer r123 = Integer.valueOf(r122.m);
    L39:
        r25.getClass();
        if (DoraImageMode.a.c(r123) == false) goto L46;
        StringBuilder r26 = new StringBuilder("PreCapture - found localPicModel, imageMode: ");
        com.larus.avlink.model.a r124 = g;
        if (r124 == null) goto L44;
        r22 = Integer.valueOf(r124.m);
    L44:
        r26.append(r22);
        r3.i("DoraE_Camera", r26.toString());
        r11 = g;
        goto L45
    L38:
        r123 = null;
        goto L39
    L28:
        r120 = null;
        goto L29
    L30:
        r121 = false;
    L20:
        r10 = false;
        goto L21
    L9:
        if (r19.length() == 0) goto L12;
        r8 = false;
        goto L13
    }

    public static void f(int r6, int r7, int r8, int r9, int r10) {
        int r0 = z98.c.a;
        boolean r1 = false;
        if (r6 != 1) goto L5;
    L13:
        int r2 = 2;
    L14:
        FLogger.a.i("DoraE_Camera", "realSendAudioSendImage: " + r7 + ", server mode: " + r2 + ", client mode: " + r6);
        Map<String, com.larus.avlink.model.a> r3 = DoraImageManager.a;
        com.larus.avlink.model.a r4 = DoraImageManager.a(Integer.valueOf(r7));
        if (r4 != null) goto L17;
    L19:
        if (r1 == true) goto L32;
        DoraImageMode.a r5 = DoraImageMode.Companion;
        Integer r11 = Integer.valueOf(r6);
        r5.getClass();
        if (DoraImageMode.a.b(r11) == true) goto L23;
        return;
    L23:
        if (r6 == 20) goto L25;
    L26:
        r r12 = b;
        if (r12 == null) goto L29;
        f98.a r13 = new f98.a();
        String r14 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.a = r14;
        r13.b = r8;
        r13.c = r2;
        r13.d = r9;
        r13.e = r10;
        r12.u0(r13);
    L29:
        if (r4 == null) goto L35;
        r4.G = true;
        return;
    L35:
        return;
    L25:
        if (b98.b.b(1) == false) goto L26;
        return;
    L32:
        return;
    L17:
        if (r4.G != true) goto L19;
        r1 = true;
        goto L19
    L5:
        if (r6 == 10) goto L13;
        if (r6 != 6) goto L9;
        r2 = 4;
        goto L14
    L9:
        if (r6 == 7) goto L11;
        r2 = 0;
        goto L14
    L11:
        r2 = 3;
        goto L14
    }

    public static void h(int r3, int r4, int r5, int r6, int r7) {
        Iterator<s> r0 = c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        s r1 = r0.next();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "it");
        r1.M();
        Unit r2 = Unit.INSTANCE;
        goto L4
    L6:
        int r8 = 2;
        if (r4 == 2) goto L12;
        r8 = 1;
        if (r6 != 1) goto L12;
        r8 = 0;
    L12:
        f(r5, r3, r8, 0, r7);
    }
}

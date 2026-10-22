package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.avlink.annoatation.DoraImageMode;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.n1;
import com.larus.avlink.plugins.DoraETracePlugin;
import com.larus.avlink.plugins.DoraETracer;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public q() {
    }

    public static void a(int r6, int r7, f98.e r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        List<f98.l> r9 = r8.a();
        long r0 = 0;
        if (r9 == null) goto L13;
        Iterator<T> r10 = r9.iterator();
        long r2 = 0;
    L6:
        if (r10.hasNext() == false) goto L12;
        f98.l r4 = (f98.l) r10.next();
        if (r4 == null) goto L10;
        long r5 = r4.c();
    L11:
        r2 = r2 + r5;
        goto L6
    L10:
        r5 = 0;
        goto L11
    L12:
        r0 = r2;
    L13:
        Pair<String, Boolean> r11 = DoraETracer.a;
        Map<String, com.larus.avlink.model.a> r12 = DoraImageManager.a;
        com.larus.avlink.model.a r13 = DoraImageManager.a(Integer.valueOf(r6));
        n1.a("DoraETracer", "reportUploadImageStart picId: " + r6 + ", picModel: " + r13);
        if (r13 == null) goto L19;
        r13.i = r0;
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("upload_channel", Integer.valueOf(r13.r));
        DoraETracePlugin r1 = DoraETracePlugin.p;
        r14.put("av_session_type", Integer.valueOf(DoraETracePlugin.a.a()));
        DoraETracer.a(r14, r13);
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L19;
        r15.A0("flow_dora_vision_image_begin_upload", r14);
    L19:
        z98.m r16 = new z98.m();
        DoraEvent r17 = DoraEvent.StartUploadImage;
        r17.setExtra(GsonProtectorUtils.toJson(new Gson(), r16));
        l r18 = l.a;
        if (l.c() == true) goto L28;
        DoraImageMode.a r19 = DoraImageMode.Companion;
        Integer r20 = Integer.valueOf(r7);
        r19.getClass();
        if (DoraImageMode.a.b(r20) == false) goto L29;
        ia8.m.b(r17);
        return;
    L29:
        return;
    }

    public static void b(b49.h r1, @DoraImageMode int r2, b49.d r3) {
        Intrinsics.checkNotNullParameter(r1, "imageInfo");
        String r4 = GsonProtectorUtils.toJson(new Gson(), new z98.l());
        if (r3 != null) goto L6;
        if (r2 == 0) goto L6;
        DoraEvent r5 = DoraEvent.CameraCompleteImage;
    L7:
        r5.setExtra(r4);
        ia8.m.b(r5);
        return;
    L6:
        r5 = DoraEvent.CameraCompleteImageFailed;
        goto L7
    }

    public static void c(Integer r12, int r13, f98.q r14, boolean r15) {
        com.larus.avlink.model.a r0 = DoraImageManager.a(r12);
        if (r12 == null) goto L42;
        if (r0 == null) goto L42;
        r0.c(DoraImageEvent.IMAGE_UPLOAD_FINISH, r15, System.currentTimeMillis());
        Long r16 = r0.b(DoraImageEvent.IMAGE_UPLOAD_START);
        if (r16 == null) goto L9;
        long r2 = r16.longValue();
    L10:
        long r4 = System.currentTimeMillis() - r2;
        Pair<String, Boolean> r17 = DoraETracer.a;
        int r18 = r12.intValue();
        int r1 = !r15 ? 1 : 0;
        long r3 = 0;
        if (r14 == null) goto L15;
        Long r6 = r14.d();
        if (r6 == null) goto L15;
        long r7 = r6.longValue();
    L16:
        if (r14 == null) goto L20;
        Long r8 = r14.a();
        if (r8 == null) goto L20;
        long r9 = r8.longValue();
    L21:
        if (r14 == null) goto L25;
        Long r19 = r14.c();
        if (r19 == null) goto L25;
        r3 = r19.longValue();
    L25:
        com.larus.avlink.model.a r110 = DoraImageManager.a(Integer.valueOf(r18));
        n1.a("DoraETracer", "reportUploadImageEnd picId: " + r18 + ", picModel: " + r110);
        if (r110 == null) goto L37;
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("duration", Long.valueOf(r4));
        r10.put("status", Integer.valueOf(r1));
        r10.put("error_code", 0);
        r10.put("upload_duration", Long.valueOf(r7));
        r10.put("occlusion_duration", Long.valueOf(r9));
        r10.put("server_total_duration", Long.valueOf(r3));
        DoraETracePlugin r5 = DoraETracePlugin.p;
        r10.put("av_session_type", Integer.valueOf(DoraETracePlugin.a.a()));
        DoraETracer.a(r10, r110);
        Integer r11 = r110.A;
        if (r11 == null) goto L31;
        r10.put("ocr_status", Integer.valueOf(r11.intValue()));
    L31:
        Long r20 = r110.B;
        if (r20 == null) goto L34;
        r10.put("ocr_duration", Long.valueOf(r20.longValue()));
    L34:
        r10.put("upload_channel", Integer.valueOf(r110.r));
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L37;
        r111.A0("flow_dora_vision_image_upload_result", r10);
    L37:
        DoraImageManager.c(r12.intValue(), new p());
        if (r15 == false) goto L40;
        DoraEvent r112 = DoraEvent.EndUploadImage;
        r112.setExtra(GsonProtectorUtils.toJson(new Gson(), new z98.n(0)));
        ia8.m.b(r112);
        return;
    L40:
        DoraEvent r113 = DoraEvent.UploadImageFailed;
        r113.setExtra(GsonProtectorUtils.toJson(new Gson(), new z98.n()));
        ia8.m.b(r113);
        FLogger.a.e("DoraVision_DoraImageTracer", "[IMAGE_ERROR] upload image Error " + r12);
        return;
    L20:
        r9 = 0;
    L15:
        r7 = 0;
        goto L16
    L9:
        r2 = System.currentTimeMillis();
    L42:
        FLogger.a.i("DoraVision_DoraImageTracer", "traceUploadFinish imageId is null. imageId: " + r12 + ", mode: " + r13);
    }
}

package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final Object r16, final ImageRequest r17, final Object r18) {
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.d.getValue()).booleanValue() == false) goto L59;
        ECImageTrackHandler r0 = ECImageTrackHandler.b;
        r0.getClass();
        final long r10 = System.currentTimeMillis();
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.m() == false) goto L58;
        String r11 = "";
        if (r17 == null) goto L12;
        Uri r12 = r17.getSourceUri();
        if (r12 == null) goto L12;
        String r13 = r12.toString();
        if (r13 == null) goto L12;
    L13:
        HashMap r14 = new HashMap();
        r14.put("editedUrl", r13);
        if (r18 != null) goto L17;
        String r15 = "null";
    L20:
        FirstScreenStatistic.S.getClass();
        Intrinsics.checkNotNullParameter(r15, "callerContextState");
        JSONObject r19 = new JSONObject();
        r19.put("callerContext", r15);
        int r110 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_record_caller_context", r19, null, null);
        if ((r18 instanceof u) == false) goto L23;
        u r20 = (u) r18;
    L25:
        if (r20 != null) goto L27;
        FirstScreenStatistic.n("onFinalImageSet", "callerContext null", null, r14);
        FirstScreenStatistic.l(r13, "", "", "", r15);
        goto L58
    L27:
        String r111 = r20.p();
        if (r111 == null) goto L31;
        r11 = r111;
    L31:
        String r112 = FirstScreenStatistic.k(r11);
        String r21 = r20.g;
        String r22 = r20.f;
        r14.put("originUrl", r11);
        r14.put("cleanUrl", r112);
        r14.put("sceneTag", r21);
        r14.put("bizTag", r22);
        r14.put("callerContext", r15);
        FirstScreenStatistic.l(r13, r11, r112, r21, r15);
        if (r112 != null) goto L34;
    L37:
        boolean r23 = true;
    L38:
        if (r23 == false) goto L41;
        FirstScreenStatistic.n("onFinalImageSet", "cleanUrl empty", null, r14);
        goto L58
    L41:
        if ((r16 instanceof CloseableImage) == true) goto L43;
        FirstScreenStatistic.n("onFinalImageSet", "image type error", null, r14);
        goto L58
    L43:
        if (StringsKt.contains$default(r21, "ec_na_mall", false, 2, null) == false) goto L58;
        int r24 = d.a;
        CloseableImage r25 = (CloseableImage) r16;
        int r26 = d.a(r25);
        Intrinsics.checkNotNullParameter(r112, "cleanUrl");
        Intrinsics.checkNotNullParameter(r21, "sceneTag");
        if (FirstScreenStatistic.m == false) goto L56;
        if (r17 == null) goto L51;
        Uri r27 = r17.getSourceUri();
        if (r27 == null) goto L51;
        String r113 = r27.toString();
    L52:
        dm.a.a("FirstScreenStatistic").a("recordImageLoadEnd: " + ThreadMethodProxy.currentThread().getName() + ' ' + r112 + ' ' + r113);
        if (FirstScreenStatistic.l.contains(r21) == true) goto L55;
        r21 = "ec_na_mall_other";
    L55:
        FirstScreenStatistic.i(r112, r21, r26);
    L51:
        r113 = null;
    L56:
        FirstScreenStatistic.d(FirstScreenStatistic.f(r112, r25, r14), r17, r112, r14, "normal_fresco");
        goto L58
    L34:
        if (r112.length() == 0) goto L37;
        r23 = false;
        goto L38
    L23:
        r20 = r0.b(r18);
        goto L25
    L17:
        if ((r18 instanceof u) == false) goto L19;
        r15 = "wrapper";
        goto L20
    L19:
        r15 = "callerContext";
    L12:
        r13 = "";
    L58:
        AsyncWorker.d.b(true, false, new ECImageTrackHandler$onFinalImageSet$1(r18, r16, r17, r10));
    L59:
        ECImageMultiSizeReuseOpt.e.getClass();
        if (ECImageMultiSizeReuseOpt.g() == true) goto L62;
        return;
    L62:
        if ((r16 instanceof ImageInfo) == false) goto L69;
        if (r17 != null) goto L65;
        return;
    L65:
        if ((r18 instanceof u) == false) goto L71;
        ECImageMultiSizeReuseOpt.e.m((u) r18, r17, (ImageInfo) r16);
        return;
    L71:
        return;
    }
}

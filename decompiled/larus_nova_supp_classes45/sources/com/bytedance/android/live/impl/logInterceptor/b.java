package com.bytedance.android.live.impl.logInterceptor;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.TimeUtils;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemHelper;
import com.bytedance.android.live.impl.utils.json.JsonItemType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements Runnable {
    public final /* synthetic */ boolean a;

    public b(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        String r1 = PreviewFeedFeatureInterceptor.j.e().d("preview_click_count", r0.toString());
        if (r1 == null) goto L46;
        SimpleDateFormat r2 = TimeUtils.a;
        String r3 = TimeUtils.b(PreviewFeedFeatureInterceptor.b);
        int r4 = JsonHelper.a;
        List r5 = JsonHelper.e(r1, JsonItemType.PREVIEW_CLICK_PV_ITEM);
        if ((r5 instanceof List) == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L47;
        int r6 = 0;
        if (this.a == true) goto L19;
        Iterator r7 = r5.iterator();
        int r8 = 0;
        int r9 = 0;
    L12:
        if (r7.hasNext() == false) goto L17;
        JsonItemHelper.PreviewClickPvItem r11 = (JsonItemHelper.PreviewClickPvItem) r7.next();
        if (Intrinsics.areEqual(r11.getDate(), r3) == true) goto L15;
        r8 = r8 + r11.getPreviewClickCount();
        r0.add(JsonHelper.f(r11));
        goto L12
    L15:
        r11.setPreviewClickCount(r11.getPreviewClickCount() + 1);
        r0.add(JsonHelper.f(r11));
        r9 = r11.getPreviewClickCount();
        r8 = r8 + r11.getPreviewClickCount();
        r6 = 1;
        goto L12
    L17:
        if (r6 != 0) goto L33;
        int r12 = JsonHelper.a;
        r0.add(JsonHelper.f(new JsonItemHelper.PreviewClickPvItem(r3, 1)));
        r8 = r8 + 1;
        r9 = 1;
    L33:
        FeatureManager r13 = FeatureManager.u;
        Integer r14 = Integer.valueOf(r9);
        FeatureType r15 = FeatureType.DYNAMIC;
        r13.i("preview_click_pv_today", r14, r15);
        r13.i("preview_click_pv_week_avg", Integer.valueOf(r8 / FeatureManager.j), r15);
        PreviewFeedFeatureInterceptor.j.e().e("preview_click_count", r0.toString());
        return;
    L19:
        Iterator r16 = r5.iterator();
        int r17 = 0;
    L21:
        if (r16.hasNext() == false) goto L32;
        JsonItemHelper.PreviewClickPvItem r18 = (JsonItemHelper.PreviewClickPvItem) r16.next();
        String r19 = r18.getDate();
        if (r19 == null) goto L25;
        long r21 = TimeUtils.c(r19);
    L26:
        SimpleDateFormat r22 = TimeUtils.a;
        LiveFeatureConfig r23 = PreviewFeedFeatureInterceptor.c;
        long r24 = TimeUtils.a(r21, PreviewFeedFeatureInterceptor.b);
        FeatureManager.u.getClass();
        if (r24 >= FeatureManager.j) goto L30;
        r0.add(JsonHelper.f(r18));
        r6 = r6 + r18.getPreviewClickCount();
    L30:
        if (TimeUtils.a(r21, PreviewFeedFeatureInterceptor.b) > 1) goto L21;
        r17 = r18.getPreviewClickCount();
        goto L21
    L25:
        r21 = 0;
        goto L26
    L32:
        r9 = r17;
        r8 = r6;
        goto L33
    L47:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

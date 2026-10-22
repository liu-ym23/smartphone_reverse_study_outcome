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
public final class c implements Runnable {
    public final /* synthetic */ boolean a;

    public c(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        ArrayList r1 = new ArrayList();
        String r2 = PreviewFeedFeatureInterceptor.j.e().d("preview_show_count", r1.toString());
        if (r2 == null) goto L50;
        SimpleDateFormat r3 = TimeUtils.a;
        String r4 = TimeUtils.b(PreviewFeedFeatureInterceptor.b);
        int r5 = JsonHelper.a;
        List r6 = JsonHelper.e(r2, JsonItemType.PREVIEW_SHOW_PV_ITEM);
        if ((r6 instanceof List) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L51;
        int r11 = 0;
        if (this.a == true) goto L20;
        Iterator r7 = r6.iterator();
        int r8 = 0;
        int r12 = 0;
    L12:
        if (r7.hasNext() == false) goto L17;
        JsonItemHelper.PreviewShowPvItem r13 = (JsonItemHelper.PreviewShowPvItem) r7.next();
        if (Intrinsics.areEqual(r13.getDate(), r4) == true) goto L15;
        r8 = r8 + r13.getPreviewShowCount();
        r1.add(JsonHelper.f(r13));
        goto L12
    L15:
        r13.setPreviewShowCount(r13.getPreviewShowCount() + 1);
        r1.add(JsonHelper.f(r13));
        r12 = r13.getPreviewShowCount();
        r8 = r8 + r13.getPreviewShowCount();
        r11 = 1;
        goto L12
    L17:
        if (r11 != 0) goto L19;
        int r9 = JsonHelper.a;
        r1.add(JsonHelper.f(new JsonItemHelper.PreviewShowPvItem(r4, 1)));
        r8 = r8 + 1;
        long r14 = 0;
        r12 = 1;
    L34:
        FeatureManager r15 = FeatureManager.u;
        Integer r16 = Integer.valueOf(r12);
        FeatureType r17 = FeatureType.DYNAMIC;
        r15.i("preview_show_pv_today", r16, r17);
        r15.i("preview_show_pv_week_avg", Integer.valueOf(r8 / FeatureManager.j), r17);
        PreviewFeedFeatureInterceptor r18 = PreviewFeedFeatureInterceptor.j;
        r18.e().e("preview_show_count", r1.toString());
        long r19 = Math.max(r14, r18.e().c("key_live_preview_show_total_count"));
        if (this.a == false) goto L37;
        r18.e().e("key_live_preview_show_total_count", Long.valueOf(r19));
        z90.a.C0301a.a(r15, "live_preview_show_total_count", Long.valueOf(r19));
        return;
    L37:
        long r21 = r19 + 1;
        r18.e().e("key_live_preview_show_total_count", Long.valueOf(r21));
        z90.a.C0301a.a(r15, "live_preview_show_total_count", Long.valueOf(r21));
        return;
    L19:
        r14 = 0;
        goto L34
    L20:
        Iterator r22 = r6.iterator();
        int r23 = 0;
        long r110 = 0;
    L22:
        if (r22.hasNext() == false) goto L33;
        JsonItemHelper.PreviewShowPvItem r24 = (JsonItemHelper.PreviewShowPvItem) r22.next();
        r110 = r110 + ((long) r24.getPreviewShowCount());
        String r111 = r24.getDate();
        if (r111 == null) goto L26;
        long r112 = TimeUtils.c(r111);
    L27:
        SimpleDateFormat r113 = TimeUtils.a;
        LiveFeatureConfig r114 = PreviewFeedFeatureInterceptor.c;
        long r25 = TimeUtils.a(r112, PreviewFeedFeatureInterceptor.b);
        FeatureManager.u.getClass();
        if (r25 >= FeatureManager.j) goto L31;
        r1.add(JsonHelper.f(r24));
        r11 = r11 + r24.getPreviewShowCount();
    L31:
        if (TimeUtils.a(r112, PreviewFeedFeatureInterceptor.b) > 1) goto L22;
        r23 = r24.getPreviewShowCount();
        goto L22
    L26:
        r112 = 0;
        goto L27
    L33:
        r8 = r11;
        r14 = r110;
        r12 = r23;
        goto L34
    L51:
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

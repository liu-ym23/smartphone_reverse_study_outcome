package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import com.bytedance.live.richcontent.resource.cache.ResourceCache;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiveNinePatchResourceLoader implements hk6.a<ob2.f>, hk6.c<ob2.f> {
    public final com.bytedance.live.richcontent.resource.cache.b a;

    public LiveNinePatchResourceLoader() {
        int r5 = (com.bytedance.android.livesdk.interactivity.service.richcontent.a.f * 1024) * 1024;
        LiveNinePatchResourceLoader$bitmapCacheManager$1 r6 = LiveNinePatchResourceLoader$bitmapCacheManager$1.INSTANCE;
        int r0 = com.bytedance.live.richcontent.resource.cache.f.a;
        Intrinsics.checkNotNullParameter("LiveNinePatchResourceLoader", "tag");
        Intrinsics.checkNotNullParameter(r6, "getEntitySize");
        this.a = new com.bytedance.live.richcontent.resource.cache.b("LiveNinePatchResourceLoader", ResourceCache.CacheType.MaxMemorySize, ResourceCache.ReferenceType.StrongReference, r5, r6);
    }

    public static float d(ek6.d r3) {
        ImageStyle.AdjustType r1 = null;
        if ((r3 instanceof fk6.a) == true) goto L5;
        ek6.d r0 = null;
    L6:
        fk6.a r2 = (fk6.a) r0;
        if (r2 == null) goto L12;
        ImageStyle r4 = r2.e();
        if (r4 == null) goto L12;
        r1 = r4.a;
    L12:
        if (r1 != ImageStyle.AdjustType.SCALE) goto L16;
        ImageStyle r5 = ((fk6.a) r3).e();
        if (r5 == null) goto L16;
        float r6 = r5.d;
    L18:
        if (r6 > 0.0f) goto L21;
        Resources r7 = s1.getResources();
        return WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density / 3.0f;
    L21:
        return r6;
    L16:
        r6 = 0.0f;
        goto L18
    L5:
        r0 = r3;
        goto L6
    }

    public static String c(ob2.f r1, ek6.d r2) {
        String r3 = (String) CollectionsKt.firstOrNull(r1.a);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3 + '&' + d(r2);
    }

    public final NinePatchDrawable e(ob2.f r6, ek6.d r7) {
        String r8 = c(r6, r7);
        if (r8 != null) goto L5;
        return null;
    L5:
        Triple r9 = (Triple) this.a.b(r8);
        if (r9 != null) goto L8;
        return null;
    L8:
        a3 r1 = new a3();
        FlexData r2 = (FlexData) r9.getSecond();
        Rect r3 = (Rect) r9.getThird();
        Intrinsics.checkNotNullParameter(r2, "flexData");
        Intrinsics.checkNotNullParameter(r3, "padding");
        r1.a = r2;
        r1.b = r3;
        return r1.a((Bitmap) r9.getFirst(), null, d(r7), false);
    }

    public final Drawable b(ek6.b r6, ak6.f r7, ek6.d r8) {
        ob2.f r9 = (ob2.f) r6;
        Intrinsics.checkNotNullParameter(r9, "resourceInfo");
        Intrinsics.checkNotNullParameter(r7, "loadConfig");
        Intrinsics.checkNotNullParameter(r8, "content");
        boolean r0 = r7 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b;
        NinePatchDrawable r1 = null;
        if (r0 == true) goto L5;
        ak6.f r2 = null;
    L6:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r3 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r2;
        if (r3 == null) goto L9;
        boolean r4 = r3.e;
    L10:
        if (r4 == false) goto L12;
        NinePatchDrawable r5 = e(r9, r8);
    L13:
        if (r5 != null) goto L51;
        if (r0 == true) goto L16;
        ak6.f r10 = null;
    L17:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r11 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r10;
        if (r11 == null) goto L20;
        boolean r13 = r11.f;
    L21:
        if (r13 == false) goto L52;
        py.k r14 = vh7.f.c(py.k.class);
        r14.setUrls(r9.a);
        IHostFrescoHelper r15 = jc1.k.f(IHostFrescoHelper.class);
        if (r15 == null) goto L25;
        String r16 = r15.getImageFilePath(r14);
    L27:
        if (TextUtils.isEmpty(r16) == true) goto L50;
        a3 r17 = new a3();
        Pair r18 = r17.b(r16, d(r8), false);
        if (r18 == null) goto L50;
        r1 = (NinePatchDrawable) r18.getFirst();
        Bitmap r19 = ((Bitmap) r18.getSecond()).copy(Bitmap.Config.ARGB_8888, false);
        FlexData r20 = r17.a;
        Rect r21 = r17.b;
        if (r19 == null) goto L50;
        if (r20 == null) goto L50;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(r7) == false) goto L50;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.e == false) goto L50;
        String r23 = c(r9, r8);
        if (r23 == null) goto L50;
        int r24 = (r19.getWidth() * r19.getHeight()) * 8;
        if (r24 <= 0) goto L50;
        if (r24 > (com.bytedance.android.livesdk.interactivity.service.richcontent.a.g * 1024)) goto L50;
        this.a.a(r23, new Triple(r19, r20, r21));
    L50:
        return r1;
    L25:
        r16 = null;
        goto L27
    L52:
        return r5;
    L20:
        r13 = false;
        goto L21
    L16:
        r10 = r7;
        goto L17
    L51:
        return r5;
    L12:
        r5 = null;
        goto L13
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = r7;
        goto L6
    }

    public final void a(ek6.b r3, ak6.f r4, ek6.d r5, hk6.d r6) {
        ob2.f r7 = (ob2.f) r3;
        Intrinsics.checkNotNullParameter(r7, "resourceInfo");
        Intrinsics.checkNotNullParameter(r4, "loadConfig");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if ((r4 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r8 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r4;
        if (r8 == null) goto L8;
        boolean r9 = r8.g;
    L9:
        if (r9 == false) goto L11;
        NinePatchDrawable r10 = e(r7, r5);
    L12:
        if (r10 == null) goto L14;
        r6.b(r10);
        return;
    L14:
        py.k r11 = vh7.f.c(py.k.class);
        r11.setUrls(r7.a);
        int r13 = a3.d;
        a3.a.a(null, r11, new k(r6), d(r5));
        return;
    L11:
        r10 = null;
        goto L12
    L8:
        r9 = false;
        goto L9
    }
}

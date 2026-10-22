package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.s0;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import com.bytedance.live.richcontent.resource.cache.ResourceCache;
import io.reactivex.Observable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiveImageResourceLoader implements hk6.a<ob2.c>, hk6.c<ob2.c> {
    public final com.bytedance.live.richcontent.resource.cache.b a;

    public LiveImageResourceLoader() {
        int r5 = (com.bytedance.android.livesdk.interactivity.service.richcontent.a.c * 1024) * 1024;
        LiveImageResourceLoader$bitmapCacheManager$1 r6 = LiveImageResourceLoader$bitmapCacheManager$1.INSTANCE;
        int r0 = com.bytedance.live.richcontent.resource.cache.f.a;
        Intrinsics.checkNotNullParameter("LiveImageResourceLoader", "tag");
        Intrinsics.checkNotNullParameter(r6, "getEntitySize");
        this.a = new com.bytedance.live.richcontent.resource.cache.b("LiveImageResourceLoader", ResourceCache.CacheType.MaxMemorySize, ResourceCache.ReferenceType.StrongReference, r5, r6);
    }

    public static ImageStyle.AdjustType d(ek6.d r2) {
        if ((r2 instanceof fk6.a) == true) goto L5;
        r2 = null;
    L5:
        fk6.a r3 = (fk6.a) r2;
        if (r3 == null) goto L11;
        ImageStyle r4 = r3.e();
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.a;
    L11:
        return null;
    }

    public static Integer f(ek6.d r2) {
        if ((r2 instanceof fk6.a) == true) goto L5;
        r2 = null;
    L5:
        fk6.a r3 = (fk6.a) r2;
        if (r3 == null) goto L11;
        ImageStyle r4 = r3.e();
        if (r4 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r4.b);
    L11:
        return null;
    }

    public static Integer g(ek6.d r2) {
        if ((r2 instanceof fk6.a) == true) goto L5;
        r2 = null;
    L5:
        fk6.a r3 = (fk6.a) r2;
        if (r3 == null) goto L11;
        ImageStyle r4 = r3.e();
        if (r4 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r4.c);
    L11:
        return null;
    }

    public static String e(ob2.c r2, ek6.d r3) {
        String r4 = (String) CollectionsKt.firstOrNull(r2.a);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4 + '&' + d(r3) + '&' + f(r3) + '&' + g(r3);
    }

    public static Observable h(ob2.c r3, ek6.d r4) {
        py.k r0 = vh7.f.c(py.k.class);
        r0.setUrls(r3.a);
        int r1 = 0;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.a == true) goto L5;
    L13:
        int r5 = 0;
    L15:
        return Observable.create(new s0(r0, r1, r5));
    L5:
        if (d(r4) != ImageStyle.AdjustType.EXACTLY) goto L13;
        Integer r6 = f(r4);
        if (r6 == null) goto L9;
        r5 = r6.intValue();
    L10:
        Integer r7 = g(r4);
        if (r7 == null) goto L15;
        r1 = r7.intValue();
        goto L15
    L9:
        r5 = 0;
        goto L10
    }

    public final Drawable b(ek6.b r11, ak6.f r13, ek6.d r14) {
        ob2.c r15 = (ob2.c) r11;
        Intrinsics.checkNotNullParameter(r15, "resource");
        Intrinsics.checkNotNullParameter(r13, "loadConfig");
        Intrinsics.checkNotNullParameter(r14, "content");
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        List r1 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).convertRichContentImageUrls(r15.a);
        List r2 = r1;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r15 = new ob2.c(r1, r15.b);
    L11:
        boolean r5 = r13 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b;
        if (r5 == true) goto L14;
        ak6.f r6 = null;
    L15:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r7 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r6;
        if (r7 == null) goto L18;
        boolean r8 = r7.e;
    L19:
        if (r8 == false) goto L26;
        String r9 = e(r15, r14);
        if (r9 == null) goto L23;
        Bitmap r10 = (Bitmap) this.a.b(r9);
    L24:
        if (r10 == null) goto L27;
        boolean r16 = true;
    L28:
        if (r10 != null) goto L94;
        if (r5 == true) goto L31;
        ak6.f r17 = null;
    L32:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r18 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r17;
        if (r18 == null) goto L35;
        r3 = r18.f;
    L35:
        if (r3 == false) goto L94;
        py.k r19 = vh7.f.c(py.k.class);
        r19.setUrls(r15.a);
        IHostFrescoHelper r20 = jc1.k.f(IHostFrescoHelper.class);
        if (r20 == null) goto L39;
        String r21 = r20.getImageFilePath(r19);
    L40:
        if (r21 != null) goto L42;
    L93:
        r10 = null;
        goto L94
    L42:
        if (TextUtils.isEmpty(r21) == true) goto L93;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.a == false) goto L86;
        ImageStyle.AdjustType r23 = d(r14);
        if (r23 == null) goto L86;
        Integer r24 = f(r14);
        if (r24 == null) goto L86;
        int r25 = r24.intValue();
        Integer r26 = g(r14);
        if (r26 == null) goto L86;
        int r27 = r26.intValue();
        ImageStyle.AdjustType r28 = ImageStyle.AdjustType.EXACTLY;
        if (r23 != r28) goto L57;
    L61:
        BitmapFactory.Options r29 = new BitmapFactory.Options();
        r29.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r21, r29);
        int r30 = r29.outHeight;
        int r31 = r29.outWidth;
        if (r30 <= 0) goto L86;
        if (r31 <= 0) goto L86;
        if (r25 <= 0) goto L76;
        if (r23 != r28) goto L68;
    L69:
        if (r30 <= r25) goto L74;
        int r33 = 1;
    L72:
        if (((r30 / 2) / r33) < r25) goto L75;
        r33 = r33 * 2;
    L75:
        Integer r34 = Integer.valueOf(r33);
    L87:
        if (r34 != null) goto L89;
    L91:
        BitmapFactory.Options r35 = null;
    L92:
        r10 = BitmapFactory.decodeFile(r21, r35);
        goto L94
    L89:
        if (r34.intValue() <= 1) goto L91;
        r35 = new BitmapFactory.Options();
        r35.inSampleSize = r34.intValue();
        goto L92
    L74:
        r33 = 1;
        goto L75
    L68:
        if (r23 == ImageStyle.AdjustType.ADJUST_HEIGHT) goto L69;
    L76:
        if (r27 <= 0) goto L86;
        if (r23 != ImageStyle.AdjustType.ADJUST_WIDTH) goto L86;
        if (r31 <= r27) goto L84;
        int r36 = 1;
    L82:
        if (((r31 / 2) / r36) < r27) goto L85;
        r36 = r36 * 2;
    L85:
        r34 = Integer.valueOf(r36);
        goto L87
    L84:
        r36 = 1;
        goto L85
    L57:
        if (r23 == ImageStyle.AdjustType.ADJUST_WIDTH) goto L61;
        if (r23 == ImageStyle.AdjustType.ADJUST_HEIGHT) goto L61;
    L86:
        r34 = null;
        goto L87
    L39:
        r21 = null;
        goto L40
    L31:
        r17 = r13;
    L94:
        if (r10 == null) goto L99;
        if (r16 == true) goto L99;
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.config.c.a(r13) == false) goto L99;
        c(r10, r15, r14);
    L99:
        if (r10 != null) goto L101;
        return null;
    L101:
        return new BitmapDrawable(s1.getResources(), r10);
    L27:
        r16 = false;
        goto L28
    L23:
        r10 = null;
        goto L24
    L26:
        r10 = null;
        goto L27
    L18:
        r8 = false;
        goto L19
    L14:
        r6 = r13;
        goto L15
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void c(Bitmap r2, ob2.c r3, ek6.d r4) {
        if (com.bytedance.android.livesdk.interactivity.service.richcontent.a.b == true) goto L5;
        return;
    L5:
        String r5 = e(r3, r4);
        if (r5 != null) goto L8;
        return;
    L8:
        int r6 = r2.getAllocationByteCount();
        if (r6 > 0) goto L11;
        return;
    L11:
        if (r6 > (com.bytedance.android.livesdk.interactivity.service.richcontent.a.d * 1024)) goto L16;
        this.a.a(r5, r2);
        return;
    }

    public final void a(ek6.b r10, ak6.f r11, ek6.d r13, hk6.d r14) {
        ob2.c r15 = (ob2.c) r10;
        Intrinsics.checkNotNullParameter(r15, "resource");
        Intrinsics.checkNotNullParameter(r11, "loadConfig");
        Intrinsics.checkNotNullParameter(r13, "content");
        Intrinsics.checkNotNullParameter(r14, "callback");
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        List r1 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).convertRichContentImageUrls(r15.a);
        List r2 = r1;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r15 = new ob2.c(r1, r15.b);
    L11:
        Bitmap r5 = null;
        if ((r11 instanceof com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) == true) goto L14;
        ak6.f r6 = null;
    L15:
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.b r7 = (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) r6;
        if (r7 == null) goto L18;
        r3 = r7.g;
    L18:
        if (r3 == false) goto L22;
        String r8 = e(r15, r13);
        if (r8 == null) goto L22;
        r5 = (Bitmap) this.a.b(r8);
    L22:
        if (r5 == null) goto L25;
        r14.b(new BitmapDrawable(s1.getResources(), r5));
        return;
    L25:
        if (r15.b == null) goto L27;
        h(r15, r13).subscribe(new c(this, r11, r15, r13, r14), new d(r15, r14));
        return;
    L27:
        h(r15, r13).subscribe(new e(this, r11, r15, r13, r14), new f(r14));
        return;
    L14:
        r6 = r11;
        goto L15
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }
}

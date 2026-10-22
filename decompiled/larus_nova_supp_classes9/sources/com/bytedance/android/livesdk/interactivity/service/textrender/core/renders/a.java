package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import com.bytedance.common.utility.Logger;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends n {
    public static final a b = null;

    static {
        b = new a();
    }

    public a() {
        super(PieceType.GIFT);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r17, SpannableString r18, b5 r19, yb2.a r20, tb2.c r21, int r23, p r24) {
        Intrinsics.checkNotNullParameter(r17, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r18, "spannable");
        Intrinsics.checkNotNullParameter(r20, "parseConfig");
        Intrinsics.checkNotNullParameter(r21, "renderPiece");
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.a == false) goto L5;
        Logger.d("ttlive_render_engine", "gift img piece");
    L5:
        e5 r1 = r21.getGiftValue();
        if (r1 == null) goto L50;
        long r4 = r1.getGiftId();
        if (k.f(IGiftImageGetter.class) == null) goto L10;
        py.k r2 = ((IGiftImageGetter) k.n(IGiftImageGetter.class)).getGiftImage(r4);
        if (r2 == null) goto L46;
        int r10 = (int) s1.b(16);
        float r11 = r24.getScale();
        String r13 = k.n(IHostFrescoHelper.class).getImageFilePath(r2);
        int r3 = StringsKt.indexOf$default(r17, " . ", 0, false, 6, null) + r23;
        int r5 = r3 + 3;
        if (TextUtils.isEmpty(r13) == false) goto L21;
        wb2.g r14 = new wb2.g();
        r18.setSpan(r14, r3, r5, 33);
        return new com.bytedance.android.livesdk.interactivity.service.textrender.core.b(r3, r5, r21, r2, r10, r10, r11, r14);
    L21:
        Bitmap r6 = BitmapFactory.decodeFile(r13);
        if (r6 == null) goto L29;
        long r7 = (((long) r6.getWidth()) * 4) * ((long) r6.getHeight());
        if (r7 <= ((long) (1048576 * ((Float) com.bytedance.android.livesdk.interactivity.service.settings.a.a.getValue()).floatValue()))) goto L29;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b.j++;
        String r8 = (String) CollectionsKt.firstOrNull(r2.getUrls());
        LiveMonitor.a r9 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a("ttlive_text_render_engine_gift_all", null);
        r9.g("gift_giant_resource_size", r7);
        if (r8 != null) goto L28;
        r8 = "null";
    L28:
        r9.i("url", r8);
        r9.a().report();
    L29:
        int r15 = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r10, r11);
        if (r6 == null) goto L50;
        if (r6.isRecycled() == true) goto L50;
        if (r18.length() == 0) goto L50;
        if (r3 < 0) goto L50;
        if (r3 > r18.length()) goto L50;
        if (r3 > r5) goto L50;
        BitmapDrawable r16 = new BitmapDrawable(s1.getContext().getResources(), r6);
        r16.setBounds(0, 0, r15, r15);
        if ((r18 instanceof com.bytedance.android.livesdk.interactivity.service.textrender.core.d) == false) goto L43;
        Object r25 = new wb2.a(r16);
    L44:
        r18.setSpan(r25, r3, r5, 33);
        goto L50
    L43:
        r25 = new com.bytedance.android.livesdk.widget.a(r16);
        goto L44
    L46:
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.b == false) goto L50;
        pm0.a r0 = om0.c.c();
        if (r0 == null) goto L50;
        r0.i("ttlive_render_engine", "rend gift failed, gift is null, id : " + r4);
        goto L50
    L10:
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.b == false) goto L14;
        pm0.a r26 = om0.c.c();
        if (r26 == null) goto L14;
        r26.i("ttlive_render_engine", "rend gift faild, gif service null");
    L14:
        return null;
    L50:
        return null;
    }
}

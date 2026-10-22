package b62;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p22.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;

    static {
        a = s1.f(2.0f);
        b = s1.f(2.0f);
        c = s1.f(8.0f);
        d = s1.f(8.0f);
        e = s1.f(2.0f);
        f = s1.f(2.0f);
        g = s1.f(16.0f);
        h = s1.f(16.0f);
    }

    public static final Pair<Drawable, Rect> b(s3 r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        long r0 = r6.getStyle();
        int r7 = 2131248720;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L9;
        r7 = 2131248718;
        goto L12
    L9:
        if (r0 != 3) goto L12;
        r7 = 2131248726;
    L12:
        return new Pair(s1.m(r7), new Rect(c, a, d, b));
    }

    public static final Pair<Drawable, Rect> a(Context r7, s3 r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "message");
        if (r8.getSkin() == 1) goto L5;
        return null;
    L5:
        long r3 = r8.getStyle();
        if (r3 != 1) goto L9;
        int r10 = 2131248721;
    L14:
        int r0 = k.h;
        if (r9 == k.m) goto L17;
        Resources r11 = r7.getResources();
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inScaled = false;
        Unit r4 = Unit.INSTANCE;
        Bitmap r13 = BitmapFactory.decodeResource(r11, r10, r1);
        if (r13 != null) goto L22;
        return null;
    L22:
        if (r13.getWidth() != 0) goto L24;
    L33:
        return null;
    L24:
        if (r13.getHeight() == 0) goto L33;
        float r14 = r9 / r13.getHeight();
        NinePatchDrawable r15 = a1.g(r13, r14, true, true);
        if (r15 == null) goto L33;
        if (r13.isRecycled() == true) goto L31;
        r13.recycle();
    L31:
        float r16 = Math.max(1.0f, r14);
        return new Pair(r15, new Rect((int) (g * r16), e, (int) (h * r16), f));
    L17:
        return new Pair(s1.m(r10), new Rect(g, e, h, f));
    L9:
        if (r3 != 2) goto L12;
        r10 = 2131248719;
        goto L14
    L12:
        if (r3 != 3) goto L33;
        r10 = 2131248727;
        goto L14
    }
}

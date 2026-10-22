package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T, R> implements Function {
    public final /* synthetic */ z a;
    public final /* synthetic */ ILinkPlayerInfoBridge b;
    public final /* synthetic */ Ref.ObjectRef c;

    public w(z r1, ILinkPlayerInfoBridge r2, ti6.f r3, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object apply(Object r18) {
        Bitmap r1 = (Bitmap) r18;
        Intrinsics.checkNotNullParameter(r1, "it");
        z r2 = this.a;
        ILinkPlayerInfoBridge r3 = this.b;
        v.a r4 = (v.a) this.c.element;
        r2.getClass();
        int r5 = r4.a;
        int r6 = r4.b;
        Bitmap r7 = Bitmap.createBitmap(r5 - (r5 % 16), r6 - (r6 % 16), Bitmap.Config.ARGB_8888);
        Canvas r8 = new Canvas(r7);
        int r9 = r4.a;
        int r10 = r4.b;
        Bitmap r11 = Bitmap.createScaledBitmap(r1, r9 - (r9 % 16), r10 - (r10 % 16), false);
        NativeBlurFilter.iterativeBoxBlur(r11, 4, 30);
        int r12 = r4.a;
        int r13 = r4.b;
        r8.drawBitmap(r11, null, new Rect(0, 0, r12 - (r12 % 16), r13 - (r13 % 16)), r2.a);
        int r14 = r4.a;
        int r15 = r14 - (r14 % 16);
        int r16 = r4.b;
        int r17 = r16 - (r16 % 16);
        if (r15 <= r17) goto L5;
        int r19 = r17;
    L6:
        float r110 = r19 * r4.c;
        float r111 = 2;
        float r20 = (r15 - r110) / r111;
        float r21 = (r17 - r110) / r111;
        Rect r112 = new Rect((int) r20, (int) r21, (int) (r110 + r20), (int) (r110 + r21));
        Bitmap r22 = Bitmap.createBitmap(r1.getWidth(), r1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r23 = new Canvas(r22);
        Paint r113 = new Paint();
        Rect r114 = new Rect(0, 0, r1.getWidth(), r1.getHeight());
        r113.setAntiAlias(true);
        r23.drawARGB(0, 0, 0, 0);
        r113.setColor(-12434878);
        r23.drawCircle(r1.getWidth() / 2, r1.getHeight() / 2, r1.getWidth() / 2, r113);
        r113.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r23.drawBitmap(r1, r114, r114, r113);
        r8.drawBitmap(r22, null, r112, r2.a);
        if (r3.getSilenceStatus() == 0) goto L10;
        int r24 = r4.a;
        int r25 = r4.a;
        r8.drawBitmap(r2.i, null, new Rect((r24 - (r24 % 16)) - 40, 5, (r25 - (r25 % 16)) - 5, 40), r2.a);
    L10:
        if (r2.h != null) goto L16;
        int r26 = r4.a;
        int r27 = r26 - (r26 % 16);
        Drawable r28 = s1.m(2131249208);     // Catch: Exception -> L14
        Bitmap r29 = Bitmap.createBitmap(r27, 16, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L14
        Canvas r30 = new Canvas(r29);     // Catch: Exception -> L14
        r28.setBounds(0, 0, r30.getWidth(), r30.getHeight());     // Catch: Exception -> L14
        r28.draw(r30);     // Catch: Exception -> L14
    L15:
        r2.h = r29;
    L14:
        r29 = null;
    L16:
        Bitmap r31 = r2.h;
        if (r31 == null) goto L19;
        int r32 = r4.b;
        int r33 = r32 - (r32 % 16);
        int r34 = r4.a;
        r8.drawBitmap(r31, null, new Rect(0, r33 - 32, (r34 - (r34 % 16)) * 2, r33 * 2), r2.a);
    L19:
        r2.a.setTextSize(20.0f);
        r2.a.setColor(-1);
        IBaseUser r35 = r3.getUser();
        Intrinsics.checkNotNull(r35);
        String r36 = r35.getNickName();
        if (r36 == null) goto L22;
        int r115 = r36.length();
    L24:
        if (r115 < 10) goto L30;
        StringBuilder r37 = new StringBuilder();
        IBaseUser r38 = r3.getUser();
        Intrinsics.checkNotNull(r38);
        String r39 = r38.getNickName();
        if (r39 == null) goto L29;
        r37.append(r39.substring(0, 9));
        r37.append("...");
        r36 = r37.toString();
        goto L30
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L30:
        Intrinsics.checkNotNull(r36);
        int r40 = r4.b;
        r8.drawText(r36, 6.0f, (r40 - (r40 % 16)) - 10.0f, r2.a);
        return r7;
    L22:
        r115 = 0;
        goto L24
    L5:
        r19 = r15;
        goto L6
    }
}

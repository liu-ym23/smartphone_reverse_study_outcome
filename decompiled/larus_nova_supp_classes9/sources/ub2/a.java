package ub2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import com.bytedance.android.livesdk.utils.m4;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements i {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final boolean c(ITextPieceImage r2) {
        Intrinsics.checkNotNullParameter(r2, "image");
        if (r2.getResourceType() != ITextPieceImage.ResourceType.Local) goto L5;
        return true;
    L5:
        return false;
    }

    public static Drawable d(ITextPieceImage r9, float r10) {
        Context r0 = s1.getContext();
        int r1 = r9.getLocalResId();
        int r2 = r9.getWidth();
        int r3 = r9.getHeight();
        WeakHashMap r4 = m4.a;
        Bitmap r5 = (Bitmap) r4.get(Integer.valueOf(r1));
        if (r5 != null) goto L5;
    L7:
        Bitmap r6 = BitmapFactory.decodeResource(r0.getResources(), r1);
        if (r6 == null) goto L16;
        if (r2 > 0) goto L12;
        r2 = r6.getWidth();
    L12:
        if (r3 > 0) goto L14;
        r3 = r6.getHeight();
    L14:
        r5 = Bitmap.createScaledBitmap(r6, r2, r3, false);
        if (r5 == null) goto L16;
        r4.put(Integer.valueOf(r1), r5);
    L18:
        if (r5 != null) goto L21;
        return null;
    L21:
        if (r9.getWidth() > 0) goto L23;
        int r7 = r5.getWidth();
    L25:
        if (r9.getHeight() > 0) goto L27;
        int r11 = r5.getHeight();
    L28:
        int r8 = (int) f.a(r7, r10);
        int r13 = (int) f.a(r11, r10);
        BitmapDrawable r14 = new BitmapDrawable(s1.getResources(), r5);
        r14.setBounds(0, 0, r8, r13);
        return r14;
    L27:
        r11 = r9.getHeight();
        goto L28
    L23:
        r7 = r9.getWidth();
    L16:
        r5 = null;
        goto L18
    L5:
        if (r5.isRecycled() == true) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final Drawable a(ITextPieceImage r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "image");
        return d(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final void b(ITextPieceImage r2, float r3, Function1<? super Drawable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.invoke(d(r2, r3));
    }
}

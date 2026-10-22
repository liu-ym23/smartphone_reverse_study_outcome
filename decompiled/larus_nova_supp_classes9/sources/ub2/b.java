package ub2;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.e;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements i {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final boolean c(ITextPieceImage r4) {
        Intrinsics.checkNotNullParameter(r4, "image");
        if (r4.getResourceType() != ITextPieceImage.ResourceType.NetWork) goto L11;
        k r5 = r4.getImageModel();
        if (r5 == null) goto L7;
        boolean r6 = r5.isAnimated();
    L8:
        if (r6 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r6 = false;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final Drawable a(ITextPieceImage r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "image");
        k r7 = r5.getImageModel();
        Drawable r0 = a1.e(r7, true);     // Catch: RuntimeException -> L23
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r7 == null) goto L8;
        int r2 = r7.getWidth();     // Catch: RuntimeException -> L23
    L9:
        if (r2 <= 0) goto L30;
        if (r7 == null) goto L12;
        int r3 = r7.getHeight();     // Catch: RuntimeException -> L23
    L13:
        if (r3 <= 0) goto L31;
        float r4 = 0.0f;
        if (r7 == null) goto L17;
        float r8 = r7.getWidth();     // Catch: RuntimeException -> L23
    L18:
        float r9 = f.a(g.a(r8), r6);     // Catch: RuntimeException -> L23
        if (r7 == null) goto L21;
        r4 = r7.getHeight();     // Catch: RuntimeException -> L23
    L21:
        r0.setBounds(0, 0, (int) r9, (int) f.a(g.a(r4), r6));     // Catch: RuntimeException -> L23
        return r0;
    L17:
        r8 = 0.0f;
        goto L18
    L31:
        return null;
    L12:
        r3 = 0;
        goto L13
    L30:
        return null;
    L8:
        r2 = 0;
    L23:
        e = move-exception;
        e.c("NetWorkGifImageLoader", r7, e);
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final void b(ITextPieceImage r2, float r3, Function1<? super Drawable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "image");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.invoke(a(r2, r3));
    }
}

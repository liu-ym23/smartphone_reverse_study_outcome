package xb2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;
import wb2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(c r5, Drawable r6) {
        Intrinsics.checkNotNullParameter(r5, "renderPiece");
        if (r5.getType() != PieceType.IMAGE.getPieceType()) goto L13;
        ITextPieceImage r7 = r5.getImageValue();
        if ((r7 instanceof h5) == true) goto L8;
        r7 = null;
    L8:
        h5 r8 = (h5) r7;
        if (r8 == null) goto L13;
        if (r8.getTextType() != 5) goto L13;
    L14:
        if (r8 != null) goto L17;
        return null;
    L17:
        if ((r6 instanceof NinePatchDrawable) == true) goto L19;
        r6 = null;
    L19:
        NinePatchDrawable r9 = (NinePatchDrawable) r6;
        if (r9 != null) goto L23;
        return null;
    L23:
        return CollectionsKt.listOf(new f(r9, r8.getTextContent(), r8.getTextColor(), r9.getMinimumHeight() * r8.getTextSizeRate()));
    L13:
        r8 = null;
        goto L14
    }
}

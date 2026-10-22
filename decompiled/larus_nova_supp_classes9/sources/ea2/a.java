package ea2;

import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(tb2.c r5, Drawable r6) {
        Intrinsics.checkNotNullParameter(r5, "renderPiece");
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r5.getType() == PieceType.IMAGE.getPieceType()) goto L9;
        return null;
    L9:
        if ((r5.getImageValue() instanceof h5) == true) goto L11;
        return null;
    L11:
        h5 r7 = r5.getImageValue();
        if (r7 == null) goto L28;
        h5 r8 = r7;
        ArrayList r0 = new ArrayList();
        int r1 = r8.getTextType();
        if (r1 != 1) goto L16;
        r0.add(new b(r8.getTextContent(), r8.getTextColor(), false, r6));
    L26:
        return r0;
    L16:
        if (r1 != 2) goto L18;
        r0.add(new c(r8.getTextContent(), r8.getTextColor(), r6));
        goto L26
    L18:
        if (r1 != 3) goto L20;
        r0.add(new d(r8.getTextContent(), r8.getTextColor(), r6));
        goto L26
    L20:
        if (r1 != 4) goto L26;
        r0.add(new b(r8.getTextContent(), r8.getTextColor(), true, r6));
        goto L26
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    }
}

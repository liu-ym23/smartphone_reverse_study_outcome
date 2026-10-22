package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public final Map<Integer, n> a;

    public x() {
        this.a = new HashMap();
    }

    public final void b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "pieceRender");
        Map<Integer, n> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r3.a.getPieceType()), r3);
    }

    public static List a(SpannableString r6, tb2.c r7, Drawable r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r6, "spannable");
        Intrinsics.checkNotNullParameter(r7, "renderPiece");
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((HashSet) r.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L22;
        List<CharacterStyle> r2 = ((e) r1.next()).a(r7, r8);
        if (r2 == null) goto L4;
        r0.addAll(r2);
        Iterator<CharacterStyle> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L4;
        com.bytedance.android.livesdk.widget.a r4 = (CharacterStyle) r3.next();
        if ((r4 instanceof com.bytedance.android.livesdk.widget.a) == false) goto L21;
        com.bytedance.android.livesdk.widget.a r5 = r4;
        ITextPieceImage r11 = r7.getImageValue();
        if (r11 == null) goto L19;
        py.k r13 = r11.getImageModel();
        if (r13 == null) goto L19;
        py.k.b r14 = r13.getImageContent();
        if (r14 == null) goto L19;
        String r15 = r14.getAccessibilityText();
    L20:
        r5.a = r15;
    L19:
        r15 = null;
    L21:
        r6.setSpan(r4, r9, r10, 33);
        goto L9
    L22:
        return r0;
    }
}

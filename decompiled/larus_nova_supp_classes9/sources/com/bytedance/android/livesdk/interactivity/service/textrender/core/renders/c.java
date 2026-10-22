package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends n {
    public static final int b = 0;
    public static final c c = null;

    public static final class a implements tb2.e {
        public final /* synthetic */ m6 a;

        public a(m6 r1) {
            this.a = r1;
        }

        @Override // tb2.e
        public final m6 a() {
            return this.a;
        }
    }

    static {
        c = new c();
        b = s1.f(20.0f);
    }

    public c() {
        super(PieceType.IMAGE);
    }

    /* JADX WARN: Type inference failed for: r14v0, types: [com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.ImagePieceRenderV2$appendSpan$1] */
    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r16, final SpannableString r17, b5 r18, yb2.a r19, final tb2.c r20, final int r21, p r23) {
        Intrinsics.checkNotNullParameter(r16, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r17, "spannable");
        Intrinsics.checkNotNullParameter(r19, "parseConfig");
        Intrinsics.checkNotNullParameter(r20, "renderPiece");
        if (r20.getImageValue() != null) goto L5;
        return null;
    L5:
        ITextPieceImage r0 = r20.getImageValue();
        if (r0 == null) goto L8;
        ITextPieceImage.ResourceType r1 = r0.getResourceType();
    L9:
        if (r1 != null) goto L11;
        return null;
    L11:
        ITextPieceImage r2 = r20.getImageValue();
        if (r2 == null) goto L58;
        m6 r3 = r20.getConvertedSchema();
        m6 r4 = r20.getConvertedSchema();
        if (r4 == null) goto L16;
        String r5 = r4.a();
    L17:
        if (r3 == null) goto L20;
        if (r5 == null) goto L20;
        r20.setClickAction(new a(r3));
    L20:
        boolean r10 = true;
        if (r2.isNeedExtraSpace() == false) goto L23;
        int r6 = r16.length() - 1;
    L24:
        float r11 = r23.getScale();
        c.getClass();
        if (r2.getResourceType() != ITextPieceImage.ResourceType.Local) goto L27;
    L30:
        boolean r7 = true;
    L31:
        if (r7 == false) goto L35;
        x r8 = r.b;
        i r9 = r.b(r2);
        if (r9 == null) goto L35;
        Drawable r13 = r9.a(r2, r11);
    L36:
        if (r13 == null) goto L56;
        final int r14 = r21 + r6;
        final Drawable r15 = r13;
        ?? r110 = new ImagePieceRenderV2$appendSpan$1(r17, r15, r21, r14, r20);
        ITextPieceImage r24 = r20.getImageValue();
        if (r24 == null) goto L40;
        ITextPieceImage.ExtraOpt r25 = r24.getExtraOpt();
    L42:
        if (r25 == ITextPieceImage.ExtraOpt.NONE) goto L54;
        r.b.getClass();
        ArrayList r26 = (ArrayList) x.a(r17, r20, r13, r21, r14);
        if (r26.isEmpty() == true) goto L52;
        Iterator r27 = r26.iterator();
    L48:
        if (r27.hasNext() == false) goto L52;
        if ((((CharacterStyle) r27.next()) instanceof DynamicDrawableSpan) == false) goto L48;
        r10 = false;
    L52:
        if (r10 == false) goto L55;
        r110.m919invoke();
    L55:
        return null;
    L54:
        r110.m919invoke();
        goto L55
    L40:
        r25 = null;
        goto L42
    L56:
        wb2.g r28 = new wb2.g();
        r17.setSpan(r28, r21, r16.length() + r21, 33);
        return new com.bytedance.android.livesdk.interactivity.service.textrender.core.b(r21, r6 + r21, r20, null, -1, -1, r11, r28);
    L35:
        r13 = null;
        goto L36
    L27:
        if (r23.b() == true) goto L30;
        r7 = false;
        goto L31
    L23:
        r6 = r16.length();
        goto L24
    L16:
        r5 = null;
        goto L17
    L58:
        return null;
    L8:
        r1 = null;
        goto L9
    }
}

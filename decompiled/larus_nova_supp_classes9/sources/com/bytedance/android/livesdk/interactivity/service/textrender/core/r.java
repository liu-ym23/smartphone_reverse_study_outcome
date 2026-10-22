package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements f {
    public static final x b = null;
    public static final Set<e> c = null;
    public static final a d = null;
    public static final List<i> e = null;
    public static final o f = null;
    public static final r g = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements h {
        public final b0 a;
        public final g b;
        public final p c;

        public final p getContext() {
            return this.c;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.h
        public final void a(Queue<m> r14) {
            Intrinsics.checkNotNullParameter(r14, "img");
            if (this.b != null) goto L5;
            return;
        L5:
            p r0 = this.c;
            if (r0 != null) goto L8;
        L10:
            SpannableString r1 = this.a.a;
        L11:
            List<com.bytedance.android.livesdk.interactivity.service.textrender.core.b> r2 = this.a.b;
            if (r2.size() == r14.size()) goto L15;
            return;
        L15:
            if (r14.size() <= 0) goto L77;
            m r3 = r14.poll();
            if (r3 == null) goto L15;
            if (r3.b >= r2.size()) goto L15;
            com.bytedance.android.livesdk.interactivity.service.textrender.core.b r4 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r2, r3.b);
            if (r3.a != null) goto L23;
            ITextPieceImage r5 = r4.c.getImageValue();
            if (r5 == null) goto L15;
            if (r5.getEnableTextWhenFailed() != true) goto L15;
            wb2.g r6 = r4.h;
            if (r6 == null) goto L15;
            r1.removeSpan(r6);
            goto L15
        L23:
            x r7 = r.b;
            Iterator r8 = ((HashSet) r.c).iterator();
            boolean r9 = false;
        L24:
            String r10 = null;
            if (r8.hasNext() == false) goto L44;
            List<CharacterStyle> r11 = ((e) r8.next()).a(r4.c, r3.a);
            if (r11 == null) goto L24;
            Iterator<CharacterStyle> r13 = r11.iterator();
        L30:
            if (r13.hasNext() == false) goto L43;
            com.bytedance.android.livesdk.widget.a r15 = (CharacterStyle) r13.next();
            if ((r15 instanceof com.bytedance.android.livesdk.widget.a) == false) goto L42;
            com.bytedance.android.livesdk.widget.a r16 = r15;
            ITextPieceImage r17 = r4.c.getImageValue();
            if (r17 == null) goto L40;
            py.k r18 = r17.getImageModel();
            if (r18 == null) goto L40;
            py.k.b r19 = r18.getImageContent();
            if (r19 == null) goto L40;
            String r110 = r19.getAccessibilityText();
        L41:
            r16.a = r110;
            x r20 = r.b;
            r9 = true;
        L40:
            r110 = null;
        L42:
            r1.setSpan(r15, r4.a, r4.b, 33);
            goto L30
        L43:
            x r21 = r.b;
            goto L24
        L44:
            r1.removeSpan(r4.h);
            if (r9 == true) goto L15;
            ITextPieceImage r23 = r4.c.getImageValue();
            if (r23 == null) goto L50;
            ITextPieceImage.ScaleType r24 = r23.getScaleType();
        L52:
            if (r24 != ITextPieceImage.ScaleType.FIT_TEXT_SIZE) goto L54;
            com.bytedance.android.livesdk.widget.a r25 = new wb2.c(r3.a);
        L62:
            ITextPieceImage r26 = r4.c.getImageValue();
            if (r26 == null) goto L69;
            py.k r27 = r26.getImageModel();
            if (r27 == null) goto L69;
            py.k.b r28 = r27.getImageContent();
            if (r28 == null) goto L69;
            r10 = r28.getAccessibilityText();
        L69:
            r25.a = r10;
            r1.setSpan(r25, r4.a, r4.b, 33);
            goto L15
        L54:
            ITextPieceImage r29 = r4.c.getImageValue();
            if (r29 == null) goto L57;
            ITextPieceImage.ScaleType r30 = r29.getScaleType();
        L59:
            if (r30 != ITextPieceImage.ScaleType.FIT_TEXT_SIZE_CENTER_CANVAS) goto L61;
            r25 = new wb2.b(r3.a);
            goto L62
        L61:
            r25 = new com.bytedance.android.livesdk.widget.a(r3.a);
            goto L62
        L57:
            r30 = null;
            goto L59
        L50:
            r24 = null;
            goto L52
        L77:
            this.b.b(r1);
            return;
        L8:
            if (r0.a() != true) goto L10;
            r1 = new SpannableString(this.a.a);
            goto L11
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.h
        public final void b(py.k r2) {
            g r0 = this.b;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        public b(b0 r2, c r3, p r4) {
            Intrinsics.checkNotNullParameter(r2, "toLoadSpan");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c implements g {
        public final /* synthetic */ q a;

        public c(q r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.g
        public final void a(py.k r2) {
            if (r2 == null) goto L5;
            this.a.a(r2);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.g
        public final void b(SpannableString r4) {
            Intrinsics.checkNotNullParameter(r4, "updated");
            q r0 = this.a;
            q.a r1 = new q.a();
            Unit r2 = Unit.INSTANCE;
            r0.b(r4, r1);
        }
    }

    public r() {
    }

    static {
        g = new r();
        HashSet r0 = new HashSet();
        c = r0;
        r0.add(new xb2.a());
        r0.add(new xb2.b());
        x r1 = new x();
        b = r1;
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.a.b);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.b.b);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.c.c);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.d.b);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.e.b);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.f.b);
        r1.b(com.bytedance.android.livesdk.interactivity.service.textrender.core.renders.g.b);
        d = new a();
        ArrayList r2 = new ArrayList();
        e = r2;
        r2.add(new ub2.a());
        r2.add(new ub2.b());
        r2.add(new ub2.d());
        r2.add(new ub2.c());
        f = new o();
    }

    public static i b(ITextPieceImage r6) {
        Intrinsics.checkNotNullParameter(r6, "imagePiece");
        Iterator r0 = ((ArrayList) e).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        i r1 = (i) r0.next();
        if (r1.c(r6) == false) goto L4;
        return r1;
    L8:
        LiveTracingMonitor.EventModule r2 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a;
        py.k r7 = r6.getImageModel();
        StringBuilder r3 = new StringBuilder("image error, unknown loader, image type is ");
        if (r7 == null) goto L11;
        Integer r4 = r7.getImageType();
    L12:
        r3.append(r4);
        r3.append(", urls is ");
        if (r7 == null) goto L17;
        List r8 = r7.getUrls();
        if (r8 == null) goto L17;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
    L18:
        r3.append(r9);
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b(r3.toString());
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b.g++;
        return null;
    L17:
        r9 = null;
        goto L18
    L11:
        r4 = null;
        goto L12
    }

    public static tb2.d a(a5 r8, yb2.a r9) {
        long r0 = System.currentTimeMillis();
        tb2.d r10 = a0.a(r8, r9);
        LiveTracingMonitor.EventModule r2 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a;
        long r3 = System.currentTimeMillis() - r0;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a r1 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b;
        r1.a++;
        r1.b += r3;
        if (r10.a.isEmpty() == false) goto L5;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b("text decode empty, patternKey is " + r8.getKey());
        r1.c = r1.c + 1;
    L5:
        return r10;
    }

    public final void c(tb2.d r24, p r25, q r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r24, "renderText");
        Intrinsics.checkNotNullParameter(r25, "rendConfig");
        Intrinsics.checkNotNullParameter(r26, "callBack");
        long r11 = System.currentTimeMillis();
        x r13 = b;
        r13.getClass();
        if (r24.a.size() != 0) goto L5;
        b0 r1 = new b0(new SpannableString(BuildConfig.FLAVOR), new ArrayList());
    L54:
        LiveTracingMonitor.EventModule r2 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a;
        long r3 = System.currentTimeMillis() - r11;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.a r4 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b;
        r4.d++;
        r4.e += r3;
        if (r1.a.length() != 0) goto L57;
        boolean r5 = true;
    L58:
        if (r5 == false) goto L61;
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.e.b("span create empty");
        r4.f++;
    L61:
        if (r1.b.isEmpty() == false) goto L76;
        SpannableString r6 = r1.a;
        q.a r7 = new q.a();
        List<tb2.c> r0 = r24.a;
        if ((r0 instanceof Collection) == true) goto L65;
    L67:
        Iterator<T> r8 = r0.iterator();
    L69:
        if (r8.hasNext() == false) goto L75;
        if (((tb2.c) r8.next()).getImageValue() == null) goto L73;
        boolean r9 = true;
    L74:
        if (r9 == false) goto L69;
    L73:
        r9 = false;
    L75:
        Unit r10 = Unit.INSTANCE;
        r26.b(r6, r7);
        return;
    L65:
        if (r0.isEmpty() == false) goto L67;
    L76:
        c r14 = new c(r26);
        Intrinsics.checkNotNullParameter(r1, "toLoadSpan");
        if ((!r1.b.isEmpty()) == false) goto L121;
        b r15 = new b(r1, r14, r25);
        a r16 = d;
        List<com.bytedance.android.livesdk.interactivity.service.textrender.core.b> r17 = r1.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "asyncInfo");
        final j r18 = new j(r17);
        Intrinsics.checkNotNullParameter(r15, "listener");
        if (r18.d.isEmpty() == true) goto L122;
        r18.b = r15;
        int r19 = r18.d.size();
        final int r20 = 0;
    L82:
        if (r20 >= r19) goto L123;
        int r21 = ((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r18.d, r20)).c.getType();
        if (r21 != PieceType.GIFT.getPieceType()) goto L93;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r23 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r18.d, r20);
        if (((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r18.d, r20)).c.getGiftValue() != null) goto L88;
    L91:
        r18.b(r20, null);
    L102:
        r20 = r20 + 1;
        goto L82
    L88:
        if (r23.d == null) goto L91;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r23.d, new k(r18, r20, r23));
        goto L102
    L93:
        if (r21 != PieceType.IMAGE.getPieceType()) goto L101;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r28 = (com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r18.d, r20);
        ITextPieceImage r29 = ((com.bytedance.android.livesdk.interactivity.service.textrender.core.b) ListProtector.get(r18.d, r20)).c.getImageValue();
        if (r29 != null) goto L97;
        r18.b(r20, null);
        goto L102
    L97:
        i r30 = b(r29);
        if (r30 != null) goto L100;
        r18.b(r20, null);
        goto L102
    L100:
        r30.b(r29, r28.g, new ImagePiecesAsyncLoader$loadImage$1(r18, r20));
        goto L102
    L101:
        r18.b(r20, null);
        goto L102
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L57:
        r5 = false;
        goto L58
    L5:
        b5 r110 = r24.c;
        yb2.a r31 = r24.b;
        if (r31 == null) goto L8;
        Intrinsics.checkNotNull(r31);
    L9:
        yb2.a r111 = r31;
        StringBuilder r33 = new StringBuilder();
        Iterator<tb2.c> r34 = r24.a.iterator();
    L11:
        if (r34.hasNext() == false) goto L13;
        r33.append(r34.next().getText());
        goto L11
    L13:
        if (r27 == false) goto L15;
        SpannableString r35 = new d(r33.toString());
    L16:
        SpannableString r36 = r35;
        r36.setSpan(new ForegroundColorSpan(w.b(PieceType.STRING.getPieceType(), null, r110, r111)), 0, r36.length(), 18);
        ArrayList r37 = new ArrayList();
        Iterator<tb2.c> r112 = r24.a.iterator();
        int r38 = 0;
    L18:
        if (r112.hasNext() == false) goto L50;
        tb2.c r39 = r112.next();
        String r40 = r39.getText();
        n r41 = (n) ((HashMap) r13.a).get(Integer.valueOf(r39.getType()));
        if (r41 == null) goto L30;
        Intrinsics.checkNotNullParameter(r40, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r36, "spannable");
        Intrinsics.checkNotNullParameter(r111, "parseConfig");
        Intrinsics.checkNotNullParameter(r39, "renderPiece");
        Intrinsics.checkNotNullParameter(r37, "asyncInfos");
        boolean r113 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.a;
        if (r113 == false) goto L25;
        Logger.d("ttlive_render_engine", "start rend " + r41.a.getTag());
    L25:
        String r114 = r40;
        tb2.c r115 = r39;
        b5 r43 = r110;
        x r210 = r13;
        yb2.a r44 = r111;
        int r211 = r38;
        b5 r212 = r110;
        ArrayList r116 = r37;
        yb2.a r213 = r111;
        SpannableString r117 = r36;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.b r45 = r41.a(r40, r36, r43, r44, r115, r211, r25);
        if (r113 == false) goto L28;
        Logger.d("ttlive_render_engine", "async : " + r45);
    L28:
        if (r45 == null) goto L31;
        r116.add(r45);
    L31:
        r115.getFormat();
        b5 r46 = r115.getFormat();
        if (r46 == null) goto L48;
        int r47 = r46.getWeight();
        if (r47 >= 700) goto L36;
        int r48 = r211;
        if (r47 > 0) goto L42;
    L45:
        int r49 = r46.getFontSize();
        if (r49 <= 0) goto L49;
        r117.setSpan(new AbsoluteSizeSpan((int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.f.a(r49, r25.getScale()), true), r48, r114.length() + r48, 33);
    L49:
        r38 = r48 + r114.length();
        r37 = r116;
        r36 = r117;
        r13 = r210;
        r110 = r212;
        r111 = r213;
        goto L18
    L42:
        if (r46.isItalic() == false) goto L44;
        r117.setSpan(new StyleSpan(2), r48, r114.length() + r48, 33);
        goto L45
    L44:
        r117.setSpan(new StyleSpan(0), r48, r114.length() + r48, 33);
        goto L45
    L36:
        if (r46.isItalic() == false) goto L38;
        r48 = r211;
        r117.setSpan(new StyleSpan(3), r48, r114.length() + r48, 33);
        goto L45
    L38:
        r48 = r211;
        r117.setSpan(new StyleSpan(1), r48, r114.length() + r48, 33);
        goto L45
    L48:
        r48 = r211;
        goto L49
    L30:
        r114 = r40;
        r115 = r39;
        r211 = r38;
        r210 = r13;
        r212 = r110;
        r213 = r111;
        r116 = r37;
        r117 = r36;
        goto L31
    L50:
        ArrayList r118 = r37;
        SpannableString r119 = r36;
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.a == false) goto L53;
        Logger.d("ttlive_render_engine", "rend async info size : " + r118.size());
    L53:
        r1 = new b0(r119, r118);
        goto L54
    L15:
        r35 = new SpannableString(r33.toString());
        goto L16
    L8:
        r31 = w.a();
        goto L9
    }

    public final void d(a5 r2, yb2.a r3, p r4, q r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r4, "rendConfig");
        Intrinsics.checkNotNullParameter(r5, "callBack");
        c(a(r2, r3), r4, r5, false);
    }
}

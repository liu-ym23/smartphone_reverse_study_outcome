package rbb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IconShape.values().length];
            r0[IconShape.CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IconShape.SQUARE_OUTLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public d() {
    }

    @Override // rbb.g
    public final Bitmap c(obb.b r1, IconShape r2, obb.a r3) {
        return g.a.b(this, r1, r2, r3);
    }

    @Override // rbb.g
    public final Bitmap a(int r5, String r6, IconShape r7, obb.a r8) {
        Intrinsics.checkNotNullParameter(r7, "shape");
        Log.i("DOCS_ICON_FileIconProducer", "loadShortCutIcon " + r7);
        int r0 = a.a[r7.ordinal()];
        if (r0 != 1) goto L5;
        kac.a.b(2131256255);
        return rbb.a.e(g.a.a(this, r5, r6, r7, r8));
    L5:
        if (r0 != 2) goto L159;
        if (r6 == null) goto L9;
        r6 = r6.toLowerCase();
    L9:
        mbb.g r9 = mbb.c.c;
        if (r9 == null) goto L14;
        Integer r10 = r9.a(r6);
        if (r10 == null) goto L14;
        Integer r11 = Integer.valueOf(kac.a.b(r10.intValue()));
    L15:
        if (r11 != null) goto L17;
    L19:
        String[] r12 = e.a;
        int r13 = r12.length;
        int r1 = 0;
        int r2 = 0;
    L20:
        if (r2 >= r13) goto L25;
        if (TextUtils.equals(r12[r2], r6) == true) goto L23;
        r2 = r2 + 1;
        goto L20
    L23:
        int r14 = kac.a.b(2131254510);
    L126:
        int r15 = rbb.a.a;
        if (r8 == null) goto L131;
        Integer r16 = r8.d;
        if (r16 == null) goto L131;
        int r17 = r16.intValue();
    L160:
        return rbb.a.b(r14, Integer.valueOf(r17));
    L131:
        r17 = 2131102419;
        goto L160
    L25:
        String[] r18 = e.b;
        int r19 = r18.length;
        int r3 = 0;
    L26:
        if (r3 >= r19) goto L31;
        if (TextUtils.equals(r18[r3], r6) == true) goto L29;
        r3 = r3 + 1;
        goto L26
    L29:
        r14 = kac.a.b(2131254544);
        goto L126
    L31:
        String[] r20 = e.c;
        int r21 = r20.length;
        int r4 = 0;
    L32:
        if (r4 >= r21) goto L38;
        if (TextUtils.equals(r20[r4], r6) == true) goto L35;
        r4 = r4 + 1;
        goto L32
    L35:
        r14 = kac.a.b(2131254488);
        goto L126
    L38:
        if (TextUtils.equals("pdf", r6) == false) goto L40;
        r14 = kac.a.b(2131254522);
        goto L126
    L40:
        String[] r22 = e.d;
        int r23 = r22.length;
        int r24 = 0;
    L41:
        if (r24 >= r23) goto L46;
        if (TextUtils.equals(r22[r24], r6) == true) goto L44;
        r24 = r24 + 1;
        goto L41
    L44:
        r14 = kac.a.b(2131254537);
        goto L126
    L46:
        String[] r25 = e.e;
        int r26 = r25.length;
        int r27 = 0;
    L48:
        if (r27 >= r26) goto L53;
        if (TextUtils.equals(r25[r27], r6) == true) goto L51;
        r27 = r27 + 1;
        goto L48
    L51:
        r14 = kac.a.b(2131254417);
        goto L126
    L53:
        String[] r28 = e.f;
        int r29 = r28.length;
        int r30 = 0;
    L54:
        if (r30 >= r29) goto L59;
        if (TextUtils.equals(r28[r30], r6) == true) goto L57;
        r30 = r30 + 1;
        goto L54
    L57:
        r14 = kac.a.b(2131254549);
        goto L126
    L59:
        String[] r31 = e.g;
        int r32 = r31.length;
        int r33 = 0;
    L60:
        if (r33 >= r32) goto L65;
        if (TextUtils.equals(r31[r33], r6) == true) goto L63;
        r33 = r33 + 1;
        goto L60
    L63:
        r14 = kac.a.b(2131254506);
        goto L126
    L65:
        String[] r34 = e.h;
        int r35 = r34.length;
        int r36 = 0;
    L66:
        if (r36 >= r35) goto L72;
        if (TextUtils.equals(r34[r36], r6) == true) goto L69;
        r36 = r36 + 1;
        goto L66
    L69:
        r14 = kac.a.b(2131254525);
        goto L126
    L72:
        if (TextUtils.equals("pages", r6) == false) goto L75;
        r14 = kac.a.b(2131254590);
        goto L126
    L75:
        if (TextUtils.equals("numbers", r6) == false) goto L77;
        r14 = kac.a.b(2131254583);
        goto L126
    L77:
        String[] r37 = e.i;
        int r38 = r37.length;
        int r39 = 0;
    L78:
        if (r39 >= r38) goto L83;
        if (TextUtils.equals(r37[r39], r6) == true) goto L81;
        r39 = r39 + 1;
        goto L78
    L81:
        r14 = kac.a.b(2131254476);
        goto L126
    L83:
        String[] r40 = e.j;
        int r41 = r40.length;
        int r42 = 0;
    L84:
        if (r42 >= r41) goto L89;
        if (TextUtils.equals(r40[r42], r6) == true) goto L87;
        r42 = r42 + 1;
        goto L84
    L87:
        r14 = kac.a.b(2131254553);
        goto L126
    L89:
        String[] r43 = e.k;
        int r44 = r43.length;
        int r45 = 0;
    L90:
        if (r45 >= r44) goto L95;
        if (TextUtils.equals(r43[r45], r6) == true) goto L93;
        r45 = r45 + 1;
        goto L90
    L93:
        r14 = kac.a.b(2131254417);
        goto L126
    L95:
        String[] r46 = e.l;
        int r47 = r46.length;
    L96:
        if (r1 >= r47) goto L102;
        if (TextUtils.equals(r46[r1], r6) == true) goto L99;
        r1 = r1 + 1;
        goto L96
    L99:
        r14 = kac.a.b(2131254605);
        goto L126
    L102:
        if (TextUtils.equals("ipa", r6) == false) goto L105;
        r14 = kac.a.b(2131254469);
        goto L126
    L105:
        if (TextUtils.equals("apk", r6) == false) goto L108;
        r14 = kac.a.b(2131254389);
        goto L126
    L108:
        if (TextUtils.equals("aep", r6) == false) goto L111;
        r14 = kac.a.b(2131254377);
        goto L126
    L111:
        if (TextUtils.equals("ai", r6) == false) goto L114;
        r14 = kac.a.b(2131254383);
        goto L126
    L114:
        if (TextUtils.equals("sketch", r6) == false) goto L117;
        r14 = kac.a.b(2131254703);
        goto L126
    L117:
        if (TextUtils.equals("csv", r6) == false) goto L120;
        r14 = kac.a.b(2131254425);
        goto L126
    L120:
        if (TextUtils.equals("eml", r6) == false) goto L123;
        r14 = kac.a.b(2131254439);
        goto L126
    L123:
        if (TextUtils.equals("msg", r6) == false) goto L125;
        r14 = kac.a.b(2131254568);
        goto L126
    L125:
        r14 = kac.a.b(2131254517);
        goto L126
    L17:
        if (r11.intValue() == 0) goto L19;
        r14 = r11.intValue();
    L14:
        r11 = null;
        goto L15
    L159:
        return rbb.a.e(g.a.c(this, r5, r6, r7, r8));
    }

    @Override // rbb.g
    public final Bitmap b(int r1, String r2, IconShape r3, obb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        Log.i("DOCS_ICON_FileIconProducer", "loadSquareOutlineIcon " + r2);
        int r5 = b.f(r2);
        int r6 = rbb.a.a;
        if (r4 == null) goto L7;
        Integer r7 = r4.d;
        if (r7 == null) goto L7;
        int r8 = r7.intValue();
    L9:
        return rbb.a.b(r5, Integer.valueOf(r8));
    L7:
        r8 = 2131102419;
        goto L9
    }

    @Override // rbb.g
    public final Bitmap d(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        int r6 = b.e(r2);
        int r7 = rbb.a.a;
        return rbb.a.c(r6, b.b(r2), null);
    }

    @Override // rbb.g
    public final Bitmap e(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        Log.i("DOCS_ICON_FileIconProducer", "loadSquareIcon " + r2);
        return rbb.a.b(b.e(r2), null);
    }
}

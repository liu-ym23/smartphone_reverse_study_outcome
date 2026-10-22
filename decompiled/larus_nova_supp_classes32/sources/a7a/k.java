package a7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import i8a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class k implements Drawable.Callback {
    public final List<d> a;
    public final List<h> b;
    public final List<Integer> c;
    public final List<Integer> d;
    public final List<BackgroundRepeat> e;
    public final List<j> f;
    public final LynxContext g;
    public final Drawable h;
    public Bitmap.Config i;
    public boolean j;
    public final ILynxImageService k;
    public final ILynxImageServiceExtension l;

    public abstract boolean c();

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
    }

    public final int b() {
        if (((ArrayList) this.d).isEmpty() == false) goto L6;
        return 1;
    L6:
        if (((ArrayList) this.a).isEmpty() == true) goto L8;
        int r0 = ((ArrayList) this.a).size() - 1;
        List<Integer> r1 = this.d;
        return ((Integer) ListProtector.get(r1, r0 % ((ArrayList) r1).size())).intValue();
    L8:
        return ((Integer) ListProtector.get(this.d, 0)).intValue();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        this.h.invalidateSelf();
    }

    public k(LynxContext r3, Drawable r4) {
        ILynxImageServiceExtension r0 = null;
        this.i = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        ILynxImageService r5 = (ILynxImageService) n.c().a(ILynxImageService.class);
        this.k = r5;
        if ((r5 instanceof ILynxImageServiceExtension) == false) goto L5;
        r0 = (ILynxImageServiceExtension) r5;
    L5:
        this.l = r0;
    }

    public void d(ReadableArray r8, LynxBaseUI r9) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).e();
        goto L4
    L6:
        ((ArrayList) this.a).clear();
        if (r8 != null) goto L9;
        return;
    L9:
        Rect r1 = this.h.getBounds();
        int r2 = r8.size();
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L37;
        int r4 = (int) r8.getLong(r3);
        if (r4 != 1) goto L23;
        r3 = r3 + 1;
        if (this.l == null) goto L36;
        if (this.g.isEnginePoolEnabled() == true) goto L36;
        d r5 = this.l.createBackgroundImageDrawable(this.g, r8.getString(r3));
        if (r5 == null) goto L36;
        r5.j(r9);
        r5.setCallback(this);
        ((ArrayList) this.a).add(r5);
    L34:
        if (r1.isEmpty() == true) goto L36;
        List<d> r6 = this.a;
        ((d) ListProtector.get(r6, ((ArrayList) r6).size() - 1)).g(r1.width(), r1.height());
    L36:
        r3 = r3 + 1;
        goto L10
    L23:
        if (r4 != 2) goto L26;
        r3 = r3 + 1;
        List<d> r7 = this.a;
        ArrayList r10 = (ArrayList) r7;
        r10.add(new f(r8.getArray(r3)));
        goto L34
    L26:
        if (r4 != 3) goto L29;
        r3 = r3 + 1;
        List<d> r11 = this.a;
        ArrayList r12 = (ArrayList) r11;
        r12.add(new i(r8.getArray(r3)));
        goto L34
    L29:
        if (r4 != 4) goto L31;
        r3 = r3 + 1;
        List<d> r13 = this.a;
        ArrayList r14 = (ArrayList) r13;
        r14.add(new a(r8.getArray(r3)));
        goto L34
    L31:
        if (r4 != 0) goto L34;
        List<d> r15 = this.a;
        ArrayList r16 = (ArrayList) r15;
        r16.add(new g());
        goto L34
    }

    public void a(Canvas r23, RectF r24, RectF r25, RectF r26, RectF r27, Path r28, Path r29, boolean r30) {
        k r0 = this;
        Canvas r1 = r23;
        if (((ArrayList) r0.a).isEmpty() == false) goto L5;
        return;
    L5:
        int r5 = 1;
        int r6 = ((ArrayList) r0.a).size() - 1;
        RectF r4 = r27;
    L6:
        if (r6 < 0) goto L173;
        if (((d) ListProtector.get(r0.a, r6)).c() == true) goto L11;
        Canvas r8 = r1;
        r6 = r6;
    L172:
        r6 = r6 - 1;
        r0 = this;
        r1 = r8;
        r5 = 1;
        goto L6
    L11:
        if (c() == false) goto L13;
        RectF r7 = r24;
    L15:
        if (((ArrayList) r0.c).isEmpty() == true) goto L25;
        int r9 = ((Integer) ListProtector.get(r0.c, r6 % ((ArrayList) r0.c).size())).intValue();
        if (r9 == 0) goto L23;
        if (r9 == r5) goto L22;
        if (r9 != 2) goto L25;
        r7 = r26;
        goto L25
    L22:
        r7 = r24;
        goto L25
    L23:
        r7 = r25;
    L25:
        if (((ArrayList) r0.d).isEmpty() == true) goto L40;
        int r10 = ((Integer) ListProtector.get(r0.d, r6 % ((ArrayList) r0.d).size())).intValue();
        if (r10 == 0) goto L39;
        if (r10 == 2) goto L38;
        if (r10 == 4) goto L32;
        RectF r12 = r24;
        Path r11 = r28;
    L31:
        int r13 = r10;
        r4 = r12;
    L41:
        d r14 = (d) ListProtector.get(r0.a, r6);
        r14.d();
        boolean r15 = r14 instanceof b;
        if (r15 == false) goto L44;
        float r16 = r7.width();
        float r17 = r7.height();
    L46:
        if (((ArrayList) r0.f).isEmpty() == false) goto L48;
    L102:
        float r18 = r17;
    L104:
        if (Double.valueOf(r18).isNaN() == false) goto L106;
    L170:
        r8 = r1;
        RectF r19 = r4;
        r6 = r6;
    L171:
        r4 = r19;
        goto L172
    L106:
        if (Double.valueOf(r16).isNaN() == true) goto L170;
        if (r16 < 1.0f) goto L170;
        if (r18 < 1.0f) goto L170;
        float r3 = r7.left;
        float r20 = r7.top;
        if (c() == false) goto L119;
        if (((ArrayList) r0.b).size() >= 2) goto L119;
        float r21 = (float) (((double) r3) + (((double) (r7.width() - r16)) * 0.5d));
        r20 = (float) (((double) r20) + (((double) (r7.height() - r18)) * 0.5d));
        r3 = r21;
    L119:
        if (((ArrayList) r0.b).size() < 2) goto L122;
        int r22 = r6 % (((ArrayList) r0.b).size() / 2);
        float r110 = r7.width() - r16;
        float r31 = r7.height() - r18;
        int r32 = r22 * 2;
        h r2 = (h) ListProtector.get(r0.b, r32);
        h r33 = (h) ListProtector.get(r0.b, r32 + 1);
        r3 = r3 + r2.a.b(r110);
        r20 = r20 + r33.a.b(r31);
    L122:
        BackgroundRepeat r34 = BackgroundRepeat.REPEAT;
        if (((ArrayList) r0.e).size() < 2) goto L125;
        int r35 = (r6 % (((ArrayList) r0.e).size() / 2)) * 2;
        BackgroundRepeat r36 = (BackgroundRepeat) ListProtector.get(r0.e, r35);
        BackgroundRepeat r37 = (BackgroundRepeat) ListProtector.get(r0.e, r35 + 1);
    L126:
        r14.i(r0.j);
        int r111 = Math.round(r16);
        int r38 = Math.round(r18);
        r14.setBounds(new Rect(0, 0, r111, r38));
        if (r28 == null) goto L131;
        if (r15 == false) goto L131;
        if (r30 == true) goto L131;
        r14.a = r28;
    L131:
        int r112 = r23.save();
        if (r11 == null) goto L137;
        if (r30 == false) goto L135;
    L136:
        r8 = r23;
        r8.clipPath(r11);
        r19 = r4;
    L138:
        BackgroundRepeat r113 = BackgroundRepeat.NO_REPEAT;
        if (r36 != r113) goto L142;
        if (r37 != r113) goto L142;
        r23.save();
        r8.translate(r3, r20);
        r14.draw(r8);
        r23.restore();
        r6 = r6;
    L169:
        r8.restoreToCount(r112);
    L142:
        RectF r114 = r7;
        float r39 = (int) Math.max(r114.right, r19.right);
        float r115 = (int) Math.max(r114.bottom, r19.bottom);
        if (r36 != r34) goto L145;
    L148:
        BackgroundRepeat r116 = r36;
        r3 = r3 - (((int) Math.ceil(((double) r3) / ((double) r111))) * r111);
    L149:
        if (r37 != r34) goto L151;
    L152:
        r20 = r20 - (((int) Math.ceil(((double) r20) / ((double) r38))) * r38);
    L153:
        r23.save();
        r8.clipRect(r19);
        float r40 = Math.round(r3);
        float r41 = Math.round(r20);
    L155:
        if (r40 >= r39) goto L168;
        float r42 = r41;
    L158:
        if (r42 >= r115) goto L163;
        r23.save();
        r8.translate(r40, r42);
        d r117 = r14;
        r117.draw(r8);
        r23.restore();
        if (r37 == BackgroundRepeat.NO_REPEAT) goto L164;
        r42 = r42 + r38;
        r14 = r117;
    L164:
        BackgroundRepeat r43 = r116;
        if (r43 == BackgroundRepeat.NO_REPEAT) goto L168;
        r40 = r40 + r111;
        r116 = r43;
        r14 = r117;
        goto L155
    L163:
        r117 = r14;
    L168:
        r23.restore();
        goto L169
    L151:
        if (r37 != BackgroundRepeat.REPEAT_Y) goto L153;
    L145:
        if (r36 == BackgroundRepeat.REPEAT_X) goto L148;
        r116 = r36;
        goto L149
    L135:
        if (r13 == 4) goto L136;
    L137:
        r8 = r23;
        r19 = r4;
        r8.clipRect(r19);
        goto L138
    L125:
        r37 = r34;
        r36 = r37;
        goto L126
    L48:
        if (((ArrayList) r0.f).size() < 2) goto L102;
        int r44 = r6 * 2;
        if (r44 < ((ArrayList) r0.f).size()) goto L52;
        List<j> r45 = r0.f;
        j r46 = (j) ListProtector.get(r45, ((ArrayList) r45).size() - 2);
        List<j> r47 = r0.f;
        j r48 = (j) ListProtector.get(r47, ((ArrayList) r47).size() - 1);
        j r49 = r46;
    L53:
        float r118 = r7.width();
        float r119 = r7.height();
        float r120 = r16 / r17;
        float r210 = r17;
        if (r49.a.a() != (-33.0f)) goto L56;
        boolean r50 = true;
    L57:
        if (r50 == false) goto L63;
        float r51 = r118 / r120;
        if (r51 < r119) goto L69;
    L61:
        r18 = r51;
        r16 = r118;
    L69:
        r16 = r120 * r119;
        r18 = r119;
        goto L104
    L63:
        if (r49.a.a() != (-34.0f)) goto L65;
        boolean r52 = true;
    L66:
        if (r52 == false) goto L72;
        r51 = r118 / r120;
        if (r51 <= r119) goto L61;
    L72:
        if (r49.a.a() != (-32.0f)) goto L74;
        boolean r53 = true;
    L75:
        if (r53 == true) goto L79;
        r16 = r49.a.b(r118);
    L79:
        if (r48.a.a() != (-32.0f)) goto L81;
        boolean r54 = true;
    L82:
        if (r54 == false) goto L84;
        r18 = r210;
    L86:
        if (r49.a.a() != (-32.0f)) goto L88;
        boolean r55 = true;
    L89:
        if (r55 == false) goto L95;
        if (r15 == false) goto L92;
        float r56 = r7.width();
    L93:
        r16 = r56;
        goto L95
    L92:
        r56 = r120 * r18;
    L95:
        if (r48.a.a() != (-32.0f)) goto L97;
        boolean r57 = true;
    L98:
        if (r57 == false) goto L104;
        if (r15 == false) goto L101;
        r18 = r7.height();
        goto L104
    L101:
        r18 = r16 / r120;
        goto L104
    L97:
        r57 = false;
        goto L98
    L88:
        r55 = false;
        goto L89
    L84:
        r18 = r48.a.b(r119);
        goto L86
    L81:
        r54 = false;
        goto L82
    L74:
        r53 = false;
        goto L75
    L65:
        r52 = false;
        goto L66
    L56:
        r50 = false;
        goto L57
    L52:
        j r58 = (j) ListProtector.get(r0.f, r44);
        r48 = (j) ListProtector.get(r0.f, r44 + 1);
        r49 = r58;
        goto L53
    L44:
        float r59 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        r16 = ((d) ListProtector.get(r0.a, r6)).b() * r59;
        r17 = r59 * ((d) ListProtector.get(r0.a, r6)).a();
        goto L46
    L32:
        Path r60 = new Path();
        r60.setFillType(Path.FillType.EVEN_ODD);
        if (r28 == null) goto L36;
        if (r29 == 0) goto L36;
        r60.addPath(r28);
        r60.addPath(r29);
        r12 = r24;
    L37:
        r11 = r60;
    L36:
        r12 = r24;
        r60.addRect(r12, Path.Direction.CW);
        r60.addRect(r25, Path.Direction.CCW);
        goto L37
    L38:
        r11 = r29;
        r13 = r10;
        r4 = r26;
        goto L41
    L39:
        r11 = r29;
        r13 = r10;
        r4 = r25;
        goto L41
    L40:
        r11 = r28;
        r13 = 1;
        goto L41
    L13:
        r7 = r25;
        goto L15
    }
}

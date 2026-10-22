package an;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import java.util.ArrayList;
import java.util.Iterator;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f346c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public final LynxContext g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.utils.f f347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap.Config f348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILynxImageService f350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ILynxImageServiceExtension f351l;

    public j(LynxContext r5, com.lynx.tasm.behavior.ui.utils.f r10) {
        ILynxImageServiceExtension r11 = null;
        this.f348i = null;
        this.f349j = false;
        this.f351l = null;
        this.g = r5;
        this.f347h = r10;
        this.f344a = new ArrayList();
        this.f345b = new ArrayList();
        this.f346c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        ILynxImageService r12 = (ILynxImageService) r.g().e(ILynxImageService.class);
        this.f350k = r12;
        if ((r12 instanceof ILynxImageServiceExtension) == false) goto L5;
        r11 = (ILynxImageServiceExtension) r12;
    L5:
        this.f351l = r11;
    }

    public void a(Canvas r28, RectF r29, RectF r30, RectF r31, RectF r32, Path r33, Path r34, boolean r35) {
        j r5 = this;
        ArrayList r10 = r5.f344a;
        if (r10.isEmpty() == true) goto L147;
        int r11 = 1;
        int r12 = r10.size() - 1;
        RectF r13 = r32;
    L6:
        if (r12 < 0) goto L155;
        if (((c) r10.get(r12)).g() == true) goto L11;
        ArrayList r19 = r10;
        r12 = r12;
    L146:
        r12 = r12 - 1;
        r11 = 1;
        r5 = this;
        r10 = r19;
        goto L6
    L11:
        if (c() == false) goto L13;
        RectF r14 = r29;
    L14:
        ArrayList r15 = r5.f346c;
        if (r15.isEmpty() == true) goto L24;
        int r16 = ((Integer) r15.get(r12 % r15.size())).intValue();
        if (r16 == 0) goto L23;
        if (r16 == r11) goto L22;
        if (r16 != 2) goto L24;
        r14 = r31;
        goto L24
    L22:
        r14 = r29;
        goto L24
    L23:
        r14 = r30;
    L24:
        ArrayList r17 = r5.d;
        if (r17.isEmpty() == true) goto L34;
        int r18 = ((Integer) r17.get(r12 % r17.size())).intValue();
        if (r18 == 0) goto L35;
        if (r18 == r11) goto L33;
        if (r18 == 2) goto L31;
        Path r20 = null;
    L36:
        c r21 = (c) r10.get(r12);
        r21.h();
        boolean r110 = r21 instanceof a;
        if (r110 == false) goto L39;
        float r111 = r14.width();
        float r112 = r14.height();
    L40:
        ArrayList r113 = r5.f;
        if (r113.isEmpty() == false) goto L43;
    L80:
        r19 = r10;
        float r114 = r112;
    L81:
        double r22 = r114;
        if (Double.valueOf(r22).isNaN() == true) goto L89;
        double r23 = r111;
        if (Double.valueOf(r23).isNaN() == true) goto L89;
        if (r111 < 1.0f) goto L89;
        if (r114 < 1.0f) goto L89;
        float r115 = r14.left;
        float r116 = r14.top;
        boolean r117 = c();
        ArrayList r24 = r5.f345b;
        if (r117 == false) goto L97;
        if (r24.size() >= 2) goto L97;
        r115 = (float) ((((double) (r14.width() - r111)) * 0.5d) + r115);
        r116 = (float) ((((double) (r14.height() - r114)) * 0.5d) + ((double) r116));
    L97:
        if (r24.size() < 2) goto L100;
        int r25 = r12 % (r24.size() / 2);
        float r118 = r14.width() - r111;
        float r119 = r14.height() - r114;
        int r26 = r25 * 2;
        g r27 = (g) r24.get(r26);
        g r36 = (g) r24.get(r26 + 1);
        com.lynx.tasm.behavior.ui.utils.k r37 = r27.f331a;
        r115 = r115 + com.lynx.tasm.behavior.ui.utils.k.b(r37.f10754c, r37.f10753b, r37.f10752a, r118);
        com.lynx.tasm.behavior.ui.utils.k r38 = r36.f331a;
        r116 = r116 + com.lynx.tasm.behavior.ui.utils.k.b(r38.f10754c, r38.f10753b, r38.f10752a, r119);
    L100:
        BackgroundRepeat r39 = BackgroundRepeat.f10424a;
        ArrayList r40 = r5.e;
        if (r40.size() < 2) goto L103;
        int r41 = (r12 % (r40.size() / 2)) * 2;
        BackgroundRepeat r42 = (BackgroundRepeat) r40.get(r41);
        BackgroundRepeat r43 = (BackgroundRepeat) r40.get(r41 + 1);
    L104:
        r21.d(r5.f349j);
        r21.setBounds(new Rect(0, 0, Math.round(r111), Math.round(r114)));
        if (r33 == null) goto L109;
        if (r110 == false) goto L109;
        if (r35 == true) goto L109;
        r21.f328a = r33;
    L109:
        int r44 = r28.save();
        if (r20 == null) goto L113;
        if (r35 == false) goto L113;
        r28.clipPath(r20);
        r13 = r13;
    L114:
        BackgroundRepeat r45 = BackgroundRepeat.f10425b;
        if (r42 != r45) goto L118;
        if (r43 != r45) goto L118;
        r28.save();
        r28.translate(r115, r116);
        r21.draw(r28);
        r28.restore();
        r12 = r12;
    L144:
        r28.restoreToCount(r44);
    L145:
        r13 = r13;
    L118:
        RectF r46 = r14;
        float r120 = (int) Math.max(r46.right, r13.right);
        float r47 = (int) Math.max(r46.bottom, r13.bottom);
        if (r42 == r39) goto L124;
        if (r42 == BackgroundRepeat.f10426c) goto L124;
    L125:
        if (r43 != r39) goto L127;
    L128:
        r116 = r116 - (((int) Math.ceil(((double) r116) / r22)) * r114);
    L129:
        r28.save();
        r28.clipRect(r13);
    L131:
        if (r115 >= r120) goto L143;
        float r48 = r116;
    L134:
        if (r48 >= r47) goto L139;
        r28.save();
        r28.translate(r115, r48);
        r21.draw(r28);
        r28.restore();
        if (r43 == BackgroundRepeat.f10425b) goto L139;
        r48 = r48 + r114;
    L139:
        BackgroundRepeat r49 = r42;
        if (r49 == BackgroundRepeat.f10425b) goto L143;
        r115 = r115 + r111;
        r42 = r49;
    L143:
        r28.restore();
        goto L144
    L127:
        if (r43 != BackgroundRepeat.d) goto L129;
    L124:
        r115 = r115 - (((int) Math.ceil(((double) r115) / r23)) * r111);
    L113:
        r13 = r13;
        r28.clipRect(r13);
        goto L114
    L103:
        r43 = r39;
        r42 = r43;
    L89:
        r12 = r12;
        goto L145
    L43:
        if (r113.size() < 2) goto L80;
        int r121 = r12 * 2;
        if (r121 < r113.size()) goto L47;
        i r50 = (i) androidx.constraintlayout.motion.widget.a.h(r113, 2);
        i r122 = (i) androidx.constraintlayout.motion.widget.a.h(r113, 1);
    L48:
        float r123 = r14.width();
        float r124 = r14.height();
        float r125 = r111 / r112;
        r19 = r10;
        if (r50.f343a.a() != (-33.0f)) goto L54;
        float r51 = r123 / r125;
        if (r51 < r124) goto L58;
    L53:
        r114 = r51;
        r111 = r123;
    L58:
        r111 = r125 * r124;
        r114 = r124;
        goto L81
    L54:
        com.lynx.tasm.behavior.ui.utils.k r52 = r50.f343a;
        if (r52.a() != (-34.0f)) goto L61;
        r51 = r123 / r125;
        if (r51 <= r124) goto L53;
    L61:
        if (r52.a() == (-32.0f)) goto L64;
        r111 = com.lynx.tasm.behavior.ui.utils.k.b(r52.f10754c, r52.f10753b, r52.f10752a, r123);
    L64:
        float r53 = r122.f343a.a();
        com.lynx.tasm.behavior.ui.utils.k r126 = r122.f343a;
        if (r53 != (-32.0f)) goto L67;
        r114 = r112;
    L69:
        if (r52.a() != (-32.0f)) goto L75;
        if (r110 == false) goto L73;
        float r54 = r14.width();
    L72:
        r111 = r54;
        goto L75
    L73:
        r54 = r125 * r114;
    L75:
        if (r126.a() != (-32.0f)) goto L81;
        if (r110 == false) goto L79;
        r114 = r14.height();
        goto L81
    L79:
        r114 = r111 / r125;
        goto L81
    L67:
        r114 = com.lynx.tasm.behavior.ui.utils.k.b(r126.f10754c, r126.f10753b, r126.f10752a, r124);
        goto L69
    L47:
        r50 = (i) r113.get(r121);
        r122 = (i) r113.get(r121 + 1);
        goto L48
    L39:
        float r127 = com.lynx.tasm.utils.g.a(1.0f, 0.0f);
        float r128 = ((c) r10.get(r12)).f() * r127;
        r112 = r127 * ((c) r10.get(r12)).e();
        r111 = r128;
        goto L40
    L31:
        r13 = r31;
    L32:
        r20 = r34;
        goto L36
    L33:
        r13 = r29;
        goto L34
    L35:
        r13 = r30;
    L34:
        r20 = r33;
        goto L36
    L13:
        r14 = r30;
        goto L14
    L155:
        return;
    }

    public void b(ReadableArray r10, LynxBaseUI r11) {
        ArrayList r5 = this.f344a;
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((c) r12.next()).i();
        goto L4
    L6:
        r5.clear();
        if (r10 == null) goto L31;
        Rect r13 = this.f347h.getBounds();
        int r14 = r10.size();
        int r15 = 0;
    L10:
        if (r15 >= r14) goto L38;
        int r16 = (int) r10.getLong(r15);
        if (r16 != 1) goto L20;
        r15 = r15 + 1;
        ILynxImageServiceExtension r17 = this.f351l;
        if (r17 == null) goto L30;
        LynxContext r18 = this.g;
        r18.getClass();
        c r19 = r17.createBackgroundImageDrawable(r18, r10.getString(r15));
        if (r19 == null) goto L30;
        r19.c(r11);
        r19.setCallback(this);
        r5.add(r19);
    L28:
        if (r13.isEmpty() == true) goto L30;
        ((c) androidx.constraintlayout.motion.widget.a.h(r5, 1)).a(r13.width(), r13.height());
    L30:
        r15 = r15 + 1;
        goto L10
    L20:
        if (r16 != 2) goto L23;
        r15 = r15 + 1;
        r5.add(new e(r10.getArray(r15)));
        goto L28
    L23:
        if (r16 != 3) goto L25;
        r15 = r15 + 1;
        r5.add(new h(r10.getArray(r15)));
        goto L28
    L25:
        if (r16 != 0) goto L28;
        r15 = r15 + 1;
        r5.add(new f());
        goto L28
    L38:
        return;
    }

    public abstract boolean c();

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        this.f347h.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
    }
}

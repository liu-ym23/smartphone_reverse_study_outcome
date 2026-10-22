package com.bytedance.android.live.ktv.common.midi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\tB'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/KSongToneLinesView;", "Landroid/view/View;", "Landroid/graphics/Paint;", "a", "Lkotlin/Lazy;", "getLinePaint", "()Landroid/graphics/Paint;", "linePaint", "Landroid/graphics/Path;", "b", "getLinePath", "()Landroid/graphics/Path;", "linePath", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KSongToneLinesView extends View {
    public static final int r = 0;
    public static final int s = 0;
    public static final float t = 0.0f;
    public final Lazy a;
    public final Lazy b;
    public final Map<Path, Paint> c;
    public int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public long i;
    public long j;
    public final b k;
    public float l;
    public float m;
    public int n;
    public Pair<String, String> o;
    public final int p;
    public final int q;

    public static final class a {
    }

    public static final class b {
        public int a;
        public int b;

        public b() {
        }
    }

    public KSongToneLinesView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KSongToneLinesView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getLinePaint() {
        return (Paint) this.a.getValue();
    }

    private final Path getLinePath() {
        return (Path) this.b.getValue();
    }

    static {
        r = ColorProtector.parseColor("#FF4BE8");
        s = ColorProtector.parseColor("#FF386B");
        t = s1.f(4.0f);
    }

    public final void b() {
        if ((!((LinkedHashMap) this.c).keySet().isEmpty()) == false) goto L11;
        Iterator r0 = ((LinkedHashMap) this.c).keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Path) r0.next()).reset();
        goto L6
    L8:
        ((LinkedHashMap) this.c).clear();
        return;
    }

    public final void a() {
        getLinePath().reset();
        b();
        setWillNotDraw(false);
        requestLayout();
    }

    public final int f(int r3) {
        int r0 = this.h;
        if (r3 >= r0) goto L12;
        int r1 = this.g;
        if (r3 != r1) goto L9;
        int r4 = this.p;
        int r2 = this.n;
    L13:
        return r4 + r2;
    L9:
        if (r3 < r1) goto L14;
        r4 = (int) (this.m * (r0 - r3));
        r2 = this.p;
        goto L13
    L14:
        return this.q;
    L12:
        return this.p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        r4.drawPath(getLinePath(), getLinePaint());
        if ((!this.c.isEmpty()) == false) goto L8;
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r0.next();
        r4.drawPath((Path) r1.getKey(), (Paint) r1.getValue());
        goto L6
    L10:
        return;
    }

    public final void c(cb0.a r11, long r12) {
        b r0 = this.k;
        Long r1 = Long.valueOf(r11.a - r12);
        boolean r4 = true;
        int r7 = 0;
        if (r1.longValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        Long r3 = null;
        if (r2 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        int r5 = (int) (r1.longValue() * this.l);
    L13:
        r0.a = r5;
        b r6 = this.k;
        Long r13 = Long.valueOf(r11.b - r12);
        if (r13.longValue() > 0) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L19;
        r3 = r13;
    L19:
        if (r3 == null) goto L21;
        r7 = (int) (r3.longValue() * this.l);
    L21:
        r6.b = r7;
        return;
    L12:
        r5 = 0;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public final void d(long r17, List<cb0.c> r19) {
        Intrinsics.checkNotNullParameter(r19, "list");
        if (this.j <= 0) goto L48;
        long r3 = r17 - this.i;
        getLinePath().reset();
        b();
        Iterator<cb0.c> r1 = r19.iterator();
    L7:
        if (r1.hasNext() == false) goto L48;
        cb0.c r2 = r1.next();
        c(r2.a, r3);
        int r5 = f(r2.b);
        b r6 = this.k;
        if (r6.a >= r6.b) goto L12;
        float r8 = r5;
        getLinePath().moveTo(this.k.a, r8);
        getLinePath().lineTo(this.k.b, r8);
    L12:
        if (r2.a.a > (r17 - ((long) this.f))) goto L7;
        List<cb0.a> r4 = r2.c;
        if (r4 == null) goto L7;
        Path r7 = new Path();
        Iterator<T> r9 = r4.iterator();
        float r11 = 0.0f;
        float r12 = 0.0f;
    L18:
        if (r9.hasNext() == false) goto L25;
        c((cb0.a) r9.next(), r3);
        if (r11 != 0.0f) goto L22;
        r11 = this.k.a;
    L22:
        r12 = Math.max(this.k.b, r12);
        b r13 = this.k;
        int r14 = r13.a;
        if (r14 >= r13.b) goto L18;
        float r15 = r14;
        float r16 = r5;
        r7.moveTo(r15, r16);
        r7.lineTo(this.k.b, r16);
        goto L18
    L25:
        Map<Path, Paint> r18 = this.c;
        float r110 = r5;
        Paint r21 = new Paint(1);
        r21.setStyle(Paint.Style.STROKE);
        r21.setStrokeCap(Paint.Cap.ROUND);
        r21.setStrokeWidth(s1.f(4.0f));
        Pair<String, String> r22 = this.o;
        String r111 = null;
        if (r22 == null) goto L28;
        String r23 = (String) r22.getFirst();
    L30:
        if (TextUtils.isEmpty(r23) == true) goto L35;
        Pair<String, String> r24 = this.o;
        if (r24 == null) goto L34;
        String r25 = (String) r24.getFirst();
    L36:
        int r112 = ColorProtector.parseColor(r25);
        Pair<String, String> r26 = this.o;
        if (r26 == null) goto L39;
        String r27 = (String) r26.getSecond();
    L41:
        if (TextUtils.isEmpty(r27) == true) goto L46;
        Pair<String, String> r28 = this.o;
        if (r28 == null) goto L45;
        r111 = (String) r28.getSecond();
    L45:
        int r29 = ColorProtector.parseColor(r111);
    L47:
        r21.setShader(new LinearGradient(r11, r110, r12, r110, r112, r29, Shader.TileMode.CLAMP));
        r18.put(r7, r21);
        goto L7
    L46:
        r29 = ColorProtector.parseColor("#FF386B");
        goto L47
    L39:
        r27 = null;
        goto L41
    L34:
        r25 = null;
        goto L36
    L35:
        r25 = "#FF4BE8";
        goto L36
    L28:
        r23 = null;
    L48:
        postInvalidate();
    }

    public final void e(long r1, long r3) {
        this.i = r1;
        long r2 = r1 + r3;
        this.j = r2;
        float r4 = this.d / r2;
        this.l = r4;
        this.f = (int) (this.e / r4);
    }

    public KSongToneLinesView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = InfraKotlinExtsKt.mainThreadLazy(KSongToneLinesView$linePaint$2.INSTANCE);
        this.b = InfraKotlinExtsKt.mainThreadLazy(KSongToneLinesView$linePath$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = s1.y();
        this.e = s1.f(7.0f);
        this.g = 58;
        this.h = 90;
        this.i = 1180;
        this.j = 5900;
        this.k = new b();
        this.n = s1.f(40.0f);
        new Pair(Integer.valueOf(r), Integer.valueOf(s));
        this.p = s1.f(5.0f);
        this.q = this.n + s1.f(5.0f);
    }

    public /* synthetic */ KSongToneLinesView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

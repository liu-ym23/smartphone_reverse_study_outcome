package com.ss.android.lark.feed.cardcomponent.teams;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0003FGHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170*J\b\u0010+\u001a\u00020(H\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J(\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0002J6\u00107\u001a\u00020(2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0*2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J(\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\u001a2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 H\u0002J.\u0010?\u001a\u00020(2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a0*2\u0006\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0014J\u001c\u0010C\u001a\u00020(*\u00020$2\u0006\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020 H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0016j\b\u0012\u0004\u0012\u00020\u001a`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0016j\b\u0012\u0004\u0012\u00020\"`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconSize", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "iconDrawable$delegate", "Lkotlin/Lazy;", "nameStartMargin", "namePaint", "Landroid/text/TextPaint;", "separatorPaint", "nameList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/biz/im/api/FeedTeamInfo;", "Lkotlin/collections/ArrayList;", "nameItems", "Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView$NameItem;", "allNameWidth", "separatorWidth", "separatorHeight", "separatorSpace", "separatorLeft", BuildConfig.FLAVOR, "textElements", "Lcom/ss/android/lark/feed/cardcomponent/teams/FeedTeamView$TextElement;", "separatorPath", "Landroid/graphics/Path;", "minNameWidth", "ellipsisWidth", "setTeams", BuildConfig.FLAVOR, "list", BuildConfig.FLAVOR, "refreshItems", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "calcElements", "width", "height", "addBreakItems", "items", "nameSpace", "textStartX", "textY", "separatorTop", "addSingleItem", "item", "addFullyItems", "onDraw", "canvas", "Landroid/graphics/Canvas;", "addSeparator", "left", "top", "NameItem", "TextElement", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedTeamView extends View {
    public final int a;
    public final Lazy b;
    public final int c;
    public final TextPaint d;
    public final TextPaint e;
    public final ArrayList<FeedTeamInfo> f;
    public final ArrayList<b> g;
    public int h;
    public final int i;
    public final int j;
    public final int k;
    public final float l;
    public final ArrayList<c> m;
    public final Path n;
    public final float o;
    public final float p;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final float b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "NameItem(text=" + this.a + ", width=" + this.b + ')';
        }

        public b(String r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final String a;
        public final float b;
        public final float c;

        public c(String r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public FeedTeamView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FeedTeamView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Drawable getIconDrawable() {
        return (Drawable) this.b.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        getIconDrawable().draw(r6);
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        c r1 = (c) r0.next();
        r6.drawText(r1.a, r1.b, r1.c, this.d);
        goto L4
    L7:
        if (this.n.isEmpty() == true) goto L11;
        r6.drawPath(this.n, this.e);
        return;
    }

    public final void setTeams(List<FeedTeamInfo> r7) {
        Intrinsics.checkNotNullParameter(r7, "list");
        if (Intrinsics.areEqual(this.f, r7) == false) goto L5;
        return;
    L5:
        this.f.clear();
        this.f.addAll(r7);
        this.g.clear();
        Iterator<FeedTeamInfo> r8 = this.f.iterator();
        float r0 = 0.0f;
        int r1 = 0;
    L7:
        if (r8.hasNext() == false) goto L13;
        FeedTeamInfo r2 = r8.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        String r4 = r2.teamName;
        float r5 = this.d.measureText(r4);
        r0 = r0 + r5;
        this.g.add(new b(r4, r5));
        r1 = r3;
        goto L7
    L13:
        if (this.g.size() <= 1) goto L15;
        r0 = r0 + ((this.g.size() - 1) * this.k);
    L15:
        this.h = MathKt.roundToInt(r0);
        int r9 = getWidth();
        int r6 = getHeight();
        if (r9 <= 0) goto L19;
        if (r6 <= 0) goto L19;
        b(r9, r6);
    L19:
        requestLayout();
    }

    public final void b(int r20, int r21) {
        this.m.clear();
        this.n.reset();
        int r2 = getPaddingLeft();
        int r5 = 0;
        int r3 = RangesKt.coerceAtLeast((int) ((r21 - this.a) / 2.0f), 0);
        int r6 = this.a + r2;
        getIconDrawable().setBounds(r2, r3, r6, this.a + r3);
        if (this.g.isEmpty() == false) goto L5;
        return;
    L5:
        Paint.FontMetrics r4 = this.d.getFontMetrics();
        float r7 = r4.bottom;
        float r8 = r4.top;
        float r9 = ((r21 - (r7 - r8)) / 2.0f) - r8;
        float r10 = r6 + this.c;
        float r11 = (r20 - getPaddingRight()) - r10;
        if (this.g.size() != 1) goto L13;
        b r1 = (b) CollectionsKt.first(this.g);
        if (r1.b <= r11) goto L10;
        String r12 = r1.a.substring(0, this.d.breakText(r1.a, true, r11 - this.p, null)) + 8230;
    L11:
        this.m.add(new c(r12, r10, r9));
        return;
    L10:
        r12 = r1.a;
        goto L11
    L13:
        float r13 = (r21 - this.j) / 2.0f;
        if (this.h > r11) goto L27;
        ArrayList<b> r14 = this.g;
        Iterator<T> r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L26;
        Object r16 = r15.next();
        int r17 = r5 + 1;
        if (r5 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        b r18 = (b) r16;
        this.m.add(new c(r18.a, r10, r9));
        if (r5 == CollectionsKt.getLastIndex(r14)) goto L25;
        float r19 = r10 + r18.b;
        a(this.n, this.l + r19, r13);
        r10 = r19 + this.k;
    L25:
        r5 = r17;
        goto L17
    L26:
        return;
    L27:
        ArrayList<b> r22 = this.g;
        ArrayList r23 = new ArrayList();
        float r110 = this.k + this.p;
        Iterator<T> r111 = r22.iterator();
        float r112 = 0.0f;
        float r113 = r11;
        int r24 = 0;
        float r114 = 0.0f;
        int r115 = 0;
    L29:
        if (r111.hasNext() == false) goto L46;
        Object r116 = r111.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        b r25 = (b) r116;
        float r118 = r112 + RangesKt.coerceAtMost(r25.b, this.o);
        if (r118 > r11) goto L46;
        if (r115 != CollectionsKt.getLastIndex(r22)) goto L39;
    L41:
        float r26 = r25.b;
        if (r26 <= this.o) goto L44;
        r23.add(Integer.valueOf(r115));
        r114 = r114 + r25.b;
    L45:
        r112 = r118 + this.k;
        r24 = r115;
        r115 = r117;
        goto L29
    L44:
        r113 = r113 - r26;
        goto L45
    L39:
        if ((r118 + r110) < r11) goto L41;
    L46:
        float r119 = r113 - (this.k * r24);
        if (r24 >= CollectionsKt.getLastIndex(r22)) goto L50;
        r119 = r119 - r110;
    L50:
        if (r23.size() <= 1) goto L52;
        CollectionsKt.sortWith(r23, new com.ss.android.lark.feed.cardcomponent.teams.a(r22));
    L52:
        SparseArrayCompat r27 = new SparseArrayCompat(r23.size());
        Iterator r28 = r23.iterator();
        int r29 = 0;
    L54:
        if (r28.hasNext() == false) goto L66;
        Object r120 = r28.next();
        int r121 = r29 + 1;
        if (r29 >= 0) goto L58;
        CollectionsKt.throwIndexOverflow();
    L58:
        int r122 = ((Number) r120).intValue();
        b r123 = (b) ListProtector.get(r22, r122);
        float r124 = RangesKt.coerceAtLeast((r123.b / r114) * r119, this.o);
        float r125 = r123.b;
        if (r124 >= r125) goto L63;
        String r126 = r123.a.substring(0, this.d.breakText(r123.a, true, r124 - this.p, null)) + 8230;
        r125 = this.d.measureText(r126);
        Intrinsics.checkNotNullParameter(r126, "text");
        r27.put(r122, new b(r126, r125));
    L63:
        if (r29 == CollectionsKt.getLastIndex(r23)) goto L67;
        r114 = r114 - r123.b;
        r119 = r119 - r125;
        r28 = r28;
        r29 = r121;
        r10 = r10;
    L67:
        Iterator<T> r30 = r22.iterator();
        float r31 = r10;
        int r32 = 0;
    L69:
        if (r30.hasNext() == false) goto L93;
        Object r33 = r30.next();
        int r127 = r32 + 1;
        if (r32 >= 0) goto L73;
        CollectionsKt.throwIndexOverflow();
    L73:
        b r34 = (b) r27.get(r32, (b) r33);
        this.m.add(new c(r34.a, r31, r9));
        float r35 = r31 + r34.b;
        if (r32 == r24) goto L76;
        a(this.n, this.l + r35, r13);
        r31 = r35 + this.k;
        r32 = r127;
        goto L69
    L76:
        if (r32 >= CollectionsKt.getLastIndex(r22)) goto L79;
        a(this.n, this.l + r35, r13);
        this.m.add(new c("…", r35 + this.k, r9));
        return;
    L79:
        return;
    L93:
        return;
    L66:
        r10 = r10;
        goto L67
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = this.h;
        if (View.MeasureSpec.getMode(r4) != 1073741824) goto L6;
        r0 = View.MeasureSpec.getSize(r4);
    L6:
        if (View.MeasureSpec.getMode(r5) != 1073741824) goto L9;
        int r6 = View.MeasureSpec.getSize(r5);
    L12:
        setMeasuredDimension(r0, r6);
        return;
    L9:
        if (this.g.isEmpty() == false) goto L11;
        r6 = 0;
        goto L12
    L11:
        Paint.FontMetrics r7 = this.d.getFontMetrics();
        r6 = (MathKt.roundToInt(r7.bottom - r7.top) + getPaddingTop()) + getPaddingBottom();
        goto L12
    }

    public FeedTeamView(final Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = zz7.b.g(r4, 12);
        this.b = LazyKt.lazy(new FeedTeamView$iconDrawable$2(r4));
        this.c = zz7.b.g(r4, 8);
        TextPaint r7 = new TextPaint(1);
        r7.setColor(UDColorUtils.getColor(r4, 2131106622));
        r7.setTextSize(zz7.b.h(r4, 14));
        w08.a.a(r7, r4, 0);
        this.d = r7;
        TextPaint r1 = new TextPaint(1);
        r1.setColor(UDColorUtils.getColor(r4, 2131103353));
        this.e = r1;
        this.f = new ArrayList();
        this.g = new ArrayList();
        int r0 = zz7.b.g(r4, 1);
        this.i = r0;
        this.j = zz7.b.g(r4, 8);
        int r8 = zz7.b.g(r4, 17);
        this.k = r8;
        this.l = (r8 - r0) / 2.0f;
        this.m = new ArrayList();
        this.n = new Path();
        this.o = zz7.b.h(r4, 56);
        this.p = r7.measureText("…");
    }

    public final void a(Path r8, float r9, float r10) {
        r8.addRect(r9, r10, r9 + this.i, r10 + this.j, Path.Direction.CCW);
    }

    public /* synthetic */ FeedTeamView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b(r1, r2);
    }
}

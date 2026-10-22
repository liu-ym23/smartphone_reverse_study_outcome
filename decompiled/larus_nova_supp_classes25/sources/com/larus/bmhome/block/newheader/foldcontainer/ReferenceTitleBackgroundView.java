package com.larus.bmhome.block.newheader.foldcontainer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010'\u001a\u00020\u0001H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/block/newheader/foldcontainer/ReferenceTitleBackgroundView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titlePaint", "Landroid/graphics/Paint;", "fallbackBackgroundPaint", "titleRect", "Landroid/graphics/RectF;", "titlePath", "Landroid/graphics/Path;", "locationInWindow", "", "hostLocationInWindow", "topCornerRadius", "", "enableTopRoundCorner", "", "showTitleBackground", "backgroundHost", "backgroundSource", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "updateTitleBackground", "", "clearTitleBackground", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawOuterBackground", "drawTitleSurface", "findListBackgroundHost", "copyBackgroundDrawableIfNeeded", "host", "refreshPaintColors", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ReferenceTitleBackgroundView extends View {
    public final Paint a;
    public final Paint b;
    public final RectF c;
    public final Path d;
    public final int[] e;
    public final int[] f;
    public final float g;
    public boolean h;
    public boolean i;
    public View j;
    public Drawable k;
    public Drawable l;

    public ReferenceTitleBackgroundView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReferenceTitleBackgroundView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.a.setColor(ContextCompat.getColor(getContext(), c.b(2130970533, getContext(), 2131102542)));
        this.b.setColor(ContextCompat.getColor(getContext(), c.b(2130970529, getContext(), 2131102529)));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        if (this.i == true) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() > 0) goto L10;
        return;
    L10:
        if (this.h == false) goto L49;
        boolean r3 = false;
        View r0 = this;
    L12:
        Drawable r4 = null;
        if (r0 == null) goto L29;
        if ((r0 instanceof RecyclerView) == false) goto L17;
        r3 = true;
    L17:
        if (r3 == true) goto L19;
    L25:
        Object r1 = r0.getParent();
        if ((r1 instanceof View) == true) goto L27;
        r0 = null;
        goto L12
    L27:
        r0 = (View) r1;
        goto L12
    L19:
        if (r0.getBackground() == null) goto L25;
        if (r0.getWidth() <= 0) goto L25;
        if (r0.getHeight() <= 0) goto L25;
    L30:
        if (r0 == null) goto L45;
        Drawable r5 = r0.getBackground();
        if (r5 == null) goto L45;
        if (this.j == r0) goto L37;
    L38:
        this.j = r0;
        this.k = r5;
        Drawable.ConstantState r6 = r5.getConstantState();
        if (r6 == null) goto L43;
        Drawable r7 = r6.newDrawable(r0.getResources());
        if (r7 == null) goto L43;
        r4 = r7.mutate();
    L43:
        this.l = r4;
    L44:
        r4 = this.l;
        goto L45
    L37:
        if (this.k == r5) goto L44;
    L45:
        if (r0 == null) goto L48;
        if (r4 == null) goto L48;
        getLocationInWindow(this.e);
        r0.getLocationInWindow(this.f);
        int[] r8 = this.f;
        int r9 = r8[0];
        int[] r10 = this.e;
        int r11 = r9 - r10[0];
        int r12 = r8[1] - r10[1];
        r4.setBounds(r11, r12, r0.getWidth() + r11, r0.getHeight() + r12);
        r4.draw(r14);
    L48:
        r14.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.b);
        goto L49
    L29:
        r0 = null;
    L49:
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        if (this.h == true) goto L52;
        r14.drawRect(this.c, this.a);
        return;
    L52:
        this.d.reset();
        Path r2 = this.d;
        RectF r13 = this.c;
        float r15 = this.g;
        r2.addRoundRect(r13, new float[]{r15, r15, r15, r15, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        r14.drawPath(this.d, this.a);
    }

    public ReferenceTitleBackgroundView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.c = new RectF();
        this.d = new Path();
        this.e = new int[2];
        this.f = new int[2];
        this.g = r3.getResources().getDimension(c.b(2130971208, r3, 2131166786));
        this.h = true;
        this.i = true;
        setWillNotDraw(false);
        a();
    }

    public /* synthetic */ ReferenceTitleBackgroundView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

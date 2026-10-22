package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowDragIndicatorView;", "Landroid/view/View;", "Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowLayoutManager;", "layoutManager", "", "setLayoutManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LittleWindowDragIndicatorView extends View {
    public final Paint a;
    public final Paint b;
    public final float c;
    public LittleWindowLayoutManager d;
    public final List<RectF> e;
    public final Path f;
    public final RectF g;

    public LittleWindowDragIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LittleWindowDragIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        LittleWindowLayoutManager r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        LittleWindowPos[] r1 = LittleWindowPos.values();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        LittleWindowPos r4 = r1[r3];
        Rect r5 = r0.a(LittleWindowLayoutManager.LayoutMode.DragIndicator, r4, 0.0f, 0.0f);
        RectF r6 = (RectF) ListProtector.get(this.e, r4.ordinal());
        r6.left = r5.left;
        r6.top = r5.top;
        r6.right = r5.right;
        r6.bottom = r5.bottom;
        r3 = r3 + 1;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        RectF r0 = (RectF) ListProtector.get(this.e, LittleWindowPos.TOP.ordinal());
        RectF r1 = (RectF) ListProtector.get(this.e, LittleWindowPos.LEFT.ordinal());
        RectF r2 = (RectF) ListProtector.get(this.e, LittleWindowPos.RIGHT.ordinal());
        RectF r3 = (RectF) ListProtector.get(this.e, LittleWindowPos.RIGHT_BOTTOM.ordinal());
        this.g.setEmpty();
        this.g.union(r0);
        this.g.union(r1);
        this.g.union(r2);
        RectF r4 = this.g;
        float r5 = this.c;
        r8.drawRoundRect(r4, r5, r5, this.b);
        a(r8, r0);
        a(r8, r1);
        a(r8, r2);
        float r6 = this.c;
        r8.drawRoundRect(r3, r6, r6, this.b);
    }

    public final void setLayoutManager(LittleWindowLayoutManager r1) {
        this.d = r1;
        b();
    }

    public final void a(Canvas r4, RectF r5) {
        this.f.reset();
        Path r0 = this.f;
        float r1 = this.c;
        r0.addRoundRect(r5, r1, r1, Path.Direction.CW);
        r4.drawPath(this.f, this.a);
    }

    public LittleWindowDragIndicatorView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        Paint r9 = new Paint();
        this.a = r9;
        Paint r11 = new Paint();
        this.b = r11;
        float r0 = t6.a(r6, 1.0f);
        float r1 = t6.a(r6, 6.0f);
        this.c = t6.a(r6, 3.0f);
        r9.setColor(-1);
        r9.setAlpha(178);
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeWidth(r0);
        int r3 = 0;
        r9.setPathEffect(new DashPathEffect(new float[]{r1, r1}, r1));
        r9.setAntiAlias(true);
        r11.setColor(-1);
        r11.setAlpha(77);
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
        LittleWindowPos[] r12 = LittleWindowPos.values();
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
    L4:
        if (r3 >= r14) goto L6;
        LittleWindowPos r2 = r12[r3];
        r13.add(new RectF(0.0f, 0.0f, 0.0f, 0.0f));
        r3 = r3 + 1;
        goto L4
    L6:
        this.e = r13;
        this.f = new Path();
        this.g = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ LittleWindowDragIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        b();
    }
}

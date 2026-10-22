package com.larus.contextwindow.impl.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/ui/MembershipQuotaProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "bounds", "Landroid/graphics/RectF;", "trackColor", "tierColors", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaBarTier;", "percent", "", "tier", "setQuota", "", "", "unlimited", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resolveColor", "attr", "fallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaProgressView extends View {
    public final Paint a;
    public final Path b;
    public final RectF c;
    public final int d;
    public final Map<MembershipQuotaBarTier, Integer> e;
    public float f;
    public MembershipQuotaBarTier g;

    public MembershipQuotaProgressView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MembershipQuotaProgressView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L13;
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        float r0 = getHeight() / 2.0f;
        this.b.reset();
        this.b.addRoundRect(this.c, r0, r0, Path.Direction.CW);
        int r1 = r10.save();
        r10.clipPath(this.b);
        this.a.setColor(this.d);
        r10.drawRect(this.c, this.a);
        if (this.f <= 0.0f) goto L10;
        this.a.setColor(((Number) MapsKt.getValue(this.e, this.g)).intValue());
        r10.drawRect(0.0f, 0.0f, (getWidth() * this.f) / 100.0f, getHeight(), this.a);
    L10:
        r10.restoreToCount(r1);
        return;
    }

    public MembershipQuotaProgressView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new Paint(1);
        this.b = new Path();
        this.c = new RectF();
        int r8 = v19.c.a(2130972086, getContext(), 2131103159);
        this.d = r8;
        MembershipQuotaBarTier r0 = MembershipQuotaBarTier.EMPTY;
        this.e = MapsKt.mapOf(new Pair[]{TuplesKt.to(r0, Integer.valueOf(r8)), TuplesKt.to(MembershipQuotaBarTier.PRIMARY, Integer.valueOf(v19.c.a(2130972123, getContext(), 2131103203))), TuplesKt.to(MembershipQuotaBarTier.WARNING, Integer.valueOf(v19.c.a(2130972354, getContext(), 2131103335))), TuplesKt.to(MembershipQuotaBarTier.DANGER, Integer.valueOf(v19.c.a(2130970996, getContext(), 2131102650))), TuplesKt.to(MembershipQuotaBarTier.NEUTRAL, Integer.valueOf(v19.c.a(2130972081, getContext(), 2131103143)))});
        this.g = r0;
    }

    public /* synthetic */ MembershipQuotaProgressView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

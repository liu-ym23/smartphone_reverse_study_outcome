package com.obric.oui.badge;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ OBadgeDrawable $badge;
    final /* synthetic */ View $host;

    OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1(OBadgeDrawable r1, View r2, View r3) {
        this.$badge = r1;
        this.$anchor = r2;
        this.$host = r3;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$badge.a(this.$anchor, this.$host);
        Rect r0 = this.$badge.getBounds();
        Intrinsics.checkNotNullExpressionValue(r0, "badge.bounds");
        int r1 = this.$host.getHeight();
        int r2 = Math.max(RangesKt.coerceAtLeast(-r0.top, 0), RangesKt.coerceAtLeast(r0.bottom - r1, 0));
        if (r2 <= 0) goto L6;
        OBadgeDrawable r3 = this.$badge;
        r3.b(r3.b() + r2);
        this.$badge.a(this.$anchor, this.$host);
        return;
    }
}

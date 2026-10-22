package com.obric.oui.badge;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ b $badge;
    final /* synthetic */ View $host;

    public OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1(b r5, View r10, View r11) {
        this.$badge = r5;
        this.$anchor = r10;
        this.$host = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$badge.f(this.$anchor, this.$host);
        Rect r5 = this.$badge.getBounds();
        int r10 = this.$host.getHeight();
        int r11 = Math.max(RangesKt.coerceAtLeast(-r5.top, 0), RangesKt.coerceAtLeast(r5.bottom - r10, 0));
        if (r11 <= 0) goto L10;
        b r12 = this.$badge;
        int r13 = r12.B;
        int r14 = r11 + r13;
        if (r13 == r14) goto L8;
        r12.B = r14;
        r12.a();
    L8:
        this.$badge.f(this.$anchor, this.$host);
        return;
    }
}

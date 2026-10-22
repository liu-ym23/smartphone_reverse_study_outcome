package com.obric.oui.common.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "exception", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$2 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ List<q> $newShadow;
    final /* synthetic */ l $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$2(l r1, List<q> r2) {
        this.$ouiLayout = r1;
        this.$newShadow = r2;
        super(2);
    }

    public final void invoke(boolean r4, Throwable r5) {
        this.$ouiLayout.A((q) CollectionsKt.getOrNull(this.$newShadow, 0), (q) CollectionsKt.getOrNull(this.$newShadow, 1), false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Boolean) r1).booleanValue(), (Throwable) r2);
        return Unit.INSTANCE;
    }
}

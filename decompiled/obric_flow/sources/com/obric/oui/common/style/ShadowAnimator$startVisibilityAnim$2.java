package com.obric.oui.common.style;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuccess", "", "exception", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ShadowAnimator$startVisibilityAnim$2 extends Lambda implements Function2<Boolean, Throwable, Unit> {
    final /* synthetic */ List<m> $newShadow;
    final /* synthetic */ i $ouiLayout;

    public ShadowAnimator$startVisibilityAnim$2(i r5, List<m> r10) {
        this.$ouiLayout = r5;
        this.$newShadow = r10;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(Boolean r5, Throwable r10) {
        invoke(r5.booleanValue(), r10);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r5, Throwable r10) {
        this.$ouiLayout.l((m) CollectionsKt.getOrNull(this.$newShadow, 0), (m) CollectionsKt.getOrNull(this.$newShadow, 1), false);
    }
}

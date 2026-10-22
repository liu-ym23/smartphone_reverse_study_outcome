package com.bytedance.android.bst.api.claymore;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.bst.api.ab.EmptyBstAbPageControlService;
import com.bytedance.android.bst.api.ab.IBstAbPageControl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class ClayMoreInjects$injectInit$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ yc.a $loader;

    public ClayMoreInjects$injectInit$3(yc.a r1) {
        this.$loader = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m563invoke() {
        this.$loader.getClass();
        yc.a.b(IBstAbPageControl.class, EmptyBstAbPageControlService.class);
        this.$loader.getClass();
        yc.a.c(IBstAbPageControl.class, "com.bytedance.android.bst.impl.ab.BstAbPageControlService");
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m563invoke();
        return Unit.INSTANCE;
    }
}

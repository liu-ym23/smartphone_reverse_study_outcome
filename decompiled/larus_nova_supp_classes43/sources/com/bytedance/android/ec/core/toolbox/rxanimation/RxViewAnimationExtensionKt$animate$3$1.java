package com.bytedance.android.ec.core.toolbox.rxanimation;

import io.reactivex.CompletableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxViewAnimationExtensionKt$animate$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CompletableEmitter $it;

    public RxViewAnimationExtensionKt$animate$3$1(CompletableEmitter r1) {
        this.$it = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1418invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1418invoke() {
        this.$it.onComplete();
    }
}

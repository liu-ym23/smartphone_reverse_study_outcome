package com.bytedance.android.live.revlink.impl.multianchor.feed.wm;

import com.bytedance.android.live.revlink.impl.multianchor.dynamic.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/k;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/k;)Z", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedMultiWindowManager$setBreakThroughBar$layoutState$1 extends FunctionReferenceImpl implements Function1<k, Boolean> {
    public FeedMultiWindowManager$setBreakThroughBar$layoutState$1(FeedMultiWindowManager r8) {
        super(1, r8, FeedMultiWindowManager.class, "localLoadCheck", "localLoadCheck(Lcom/bytedance/android/live/revlink/impl/multianchor/dynamic/MultiLocalComponent;)Z", 0);
    }

    public final boolean invoke(k r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        return ((FeedMultiWindowManager) ((CallableReference) this).receiver).b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((k) r1));
    }
}

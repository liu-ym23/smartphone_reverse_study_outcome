package com.bytedance.ai.resource;

import com.bytedance.android.ec.core.utils.FontWeight;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {695, FontWeight.WEIGHT_700, 709}, m = "cleanPackagesToDelete", n = {"customInit", "exclusionList", "customInit", "exclusionList", "fileListToDelete", "customInit", "fileListToDelete"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class AIPackageManager$cleanPackagesToDelete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageManager this$0;

    public AIPackageManager$cleanPackagesToDelete$1(AIPackageManager r1, Continuation<? super AIPackageManager$cleanPackagesToDelete$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIPackageManager.a(this.this$0, null, null, this);
    }
}

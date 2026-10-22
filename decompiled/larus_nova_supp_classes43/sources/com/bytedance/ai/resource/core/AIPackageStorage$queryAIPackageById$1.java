package com.bytedance.ai.resource.core;

import com.byted.cast.sink.api.CastInfo;
import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageStorage", f = "AIPackageStorage.kt", i = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 9, IAPI.OPTION_USE_BYTE_LINK_PLAYER, IAPI.OPTION_USE_BYTE_LINK_PLAYER, IAPI.OPTION_USE_BYTE_LINK_PLAYER, IAPI.OPTION_RESET_PLAYER_WHEN_MIRROR}, l = {100, 103, CastInfo.TYPE_CAST_RESUME, 111, 114, 116, 123, 124, 127, 128, 130, 131}, m = "queryAIPackageById", n = {"item", "item", "item", "item", "item", "item", "item", "versionCode", "item", "item", "installStatus", "item", "item", "installStatus", "versionCode", "item"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "J$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "J$0", "L$0"})
public final class AIPackageStorage$queryAIPackageById$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageStorage this$0;

    public AIPackageStorage$queryAIPackageById$1(AIPackageStorage r1, Continuation<? super AIPackageStorage$queryAIPackageById$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIPackageStorage r0 = this.this$0;
        AIPackageStorage r11 = AIPackageStorage.a;
        return r0.g(null, null, null, false, 0, this);
    }
}

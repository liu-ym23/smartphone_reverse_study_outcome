package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.feed.app.entity.RankConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatLaunchParamDataBundleTransform", f = "ChatLaunchParamDataBundleTransform.kt", i = {0, 1, 1}, l = {RankConstants.PRIORITY_FILTER_ITEM, 43}, m = "transform-0E7RQCE", n = {"baseBundle", "baseBundle", "chat"}, s = {"L$0", "L$0", "L$1"})
public final class ChatLaunchParamDataBundleTransform$transform$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatLaunchParamDataBundleTransform this$0;

    public ChatLaunchParamDataBundleTransform$transform$1(ChatLaunchParamDataBundleTransform r1, Continuation<? super ChatLaunchParamDataBundleTransform$transform$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = this.this$0.c(null, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}

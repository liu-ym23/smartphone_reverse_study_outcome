package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin$Companion", f = "MarkdownPlugin.kt", i = {0, 0}, l = {DocErrorCode.ERRCODE_NOT_RENDER}, m = "parseAndCacheDocument", n = {"renderKey", "markdownNode"}, s = {"L$0", "L$1"})
public final class MarkdownPlugin$Companion$parseAndCacheDocument$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MarkdownPlugin.Companion this$0;

    public MarkdownPlugin$Companion$parseAndCacheDocument$1(MarkdownPlugin.Companion r1, Continuation<? super MarkdownPlugin$Companion$parseAndCacheDocument$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.c(null, null, null, this);
    }
}

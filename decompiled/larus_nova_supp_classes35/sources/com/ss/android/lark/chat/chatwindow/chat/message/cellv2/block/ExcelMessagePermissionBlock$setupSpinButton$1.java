package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock", f = "ExcelMessagePermissionBlock.kt", i = {0, 0, 0}, l = {222}, m = "setupSpinButton", n = {"blockView", "item", "spinButton"}, s = {"L$0", "L$1", "L$2"})
final class ExcelMessagePermissionBlock$setupSpinButton$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExcelMessagePermissionBlock this$0;

    public ExcelMessagePermissionBlock$setupSpinButton$1(ExcelMessagePermissionBlock r1, Continuation<? super ExcelMessagePermissionBlock$setupSpinButton$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return ExcelMessagePermissionBlock.h(this.this$0, null, null, this);
    }
}

package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveMenuItemKt", f = "SaveMenuItem.kt", i = {}, l = {489}, m = "requireDownloadFileUrlByTosKey", n = {}, s = {})
public final class SaveMenuItemKt$requireDownloadFileUrlByTosKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public SaveMenuItemKt$requireDownloadFileUrlByTosKey$1(Continuation<? super SaveMenuItemKt$requireDownloadFileUrlByTosKey$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SaveMenuItemKt.c(null, this);
    }
}

package com.larus.avlink.env.diary.settings;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DiaryImageSwitchManager", f = "DiaryImageSwitchManager.kt", i = {}, l = {MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY}, m = "fetchFromNetwork", n = {}, s = {})
final class DiaryImageSwitchManager$fetchFromNetwork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiaryImageSwitchManager this$0;

    public DiaryImageSwitchManager$fetchFromNetwork$1(DiaryImageSwitchManager r1, Continuation<? super DiaryImageSwitchManager$fetchFromNetwork$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DiaryImageSwitchManager.a(this.this$0, this);
    }
}

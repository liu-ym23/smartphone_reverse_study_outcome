package com.larus.avlink.env.diary.settings;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DiaryImageSwitchManager", f = "DiaryImageSwitchManager.kt", i = {0}, l = {149}, m = "syncToNetwork", n = {"enabled"}, s = {"Z$0"})
final class DiaryImageSwitchManager$syncToNetwork$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiaryImageSwitchManager this$0;

    public DiaryImageSwitchManager$syncToNetwork$1(DiaryImageSwitchManager r1, Continuation<? super DiaryImageSwitchManager$syncToNetwork$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DiaryImageSwitchManager.b(this.this$0, false, this);
    }
}

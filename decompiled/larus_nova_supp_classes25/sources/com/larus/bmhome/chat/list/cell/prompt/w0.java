package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class w0 extends xc8.b {
    public List<PromptContent.SuggestItem> e;

    @Override // xc8.b
    public int d() {
        return 0;
    }

    public w0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "promptMessage");
        super(r2);
        this.e = CollectionsKt.emptyList();
    }
}

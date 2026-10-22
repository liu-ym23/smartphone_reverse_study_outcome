package com.larus.bmhome.view;

import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.list.cell.search.SearchListCell;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w0 extends SearchListCell.b {
    public final /* synthetic */ SearchListCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ Ref.ObjectRef<SearchListCell.b> c;

    public final void a() {
        if (this.a.f == false) goto L7;
        FLogger.a.d("ChatMessageList", "SearchListHolder setHolderFullVisibleStatus false,  message_id: " + this.b.getMessageId());
        SearchListCell r0 = this.a;
        r0.f = false;
        r0.g = 0.0f;
        SearchListBox r1 = r0.e;
        if (r1 == null) goto L7;
        r1.setFullVisibleStatus(false);
    L7:
        SearchListCell r2 = this.a;
        SearchListCell.b r3 = (SearchListCell.b) this.c.element;
        if (r3 != null) goto L10;
        r2.getClass();
        return;
    L10:
        r2.n.remove(r3);
    }

    public w0(SearchListCell r1, Message r2, Ref.ObjectRef<SearchListCell.b> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

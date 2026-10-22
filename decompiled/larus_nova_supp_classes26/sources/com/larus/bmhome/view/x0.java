package com.larus.bmhome.view;

import com.larus.bmhome.chat.layout.item.ExpertCardBox;
import com.larus.bmhome.chat.list.cell.expert.ExpertCardCell;
import com.larus.bmhome.chat.list.cell.search.SearchListCell;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x0 extends SearchListCell.b {
    public final /* synthetic */ ExpertCardCell a;
    public final /* synthetic */ Ref.ObjectRef<SearchListCell.b> b;

    public final void a() {
        FLogger.a.d("ChatMessageList", "ExpertCardHolder setHolderFullVisibleStatus false");
        ExpertCardBox r0 = this.a.e;
        if (r0 == null) goto L5;
        r0.setFullVisibleStatus(false);
    L5:
        ExpertCardCell r1 = this.a;
        SearchListCell.b r2 = (SearchListCell.b) this.b.element;
        if (r2 != null) goto L8;
        r1.getClass();
        return;
    L8:
        r1.f.remove(r2);
    }

    public x0(ExpertCardCell r1, Ref.ObjectRef<SearchListCell.b> r2) {
        this.a = r1;
        this.b = r2;
    }
}

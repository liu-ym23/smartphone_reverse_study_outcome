package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.service.z1;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m0 implements Function1 {
    public final /* synthetic */ Message a;

    public /* synthetic */ m0(Message r1) {
        this.a = r1;
    }

    public final Object invoke(Object r20) {
        Message r1 = this.a;
        boolean r2 = ((Boolean) r20).booleanValue();
        int r3 = ChatListComponent.W3;
        if (z1.a.d() == false) goto L10;
        if (r2 == false) goto L7;
        a r12 = new com.larus.network.http.y(new CancelCollectionResponse(null, null, null, 7, null), null, 14);
    L8:
        ICollectionReport.a.b(CollectionReportDelegate.b, r12, CollectionsKt.listOf(r1), "cancel_like", null, null, null, 120);
        goto L10
    L7:
        r12 = null;
    L10:
        return Unit.INSTANCE;
    }
}

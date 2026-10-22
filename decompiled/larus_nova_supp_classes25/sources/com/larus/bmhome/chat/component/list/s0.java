package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.model.SaveCollectionResponse;
import com.larus.platform.service.z1;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s0 implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ s0(Message r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r15) {
        Message r0 = this.a;
        Function1 r1 = this.b;
        boolean r16 = ((Boolean) r15).booleanValue();
        int r2 = ChatListComponent.W3;
        if (z1.a.d() == true) goto L5;
    L9:
        r1.invoke(Boolean.valueOf(r16));
        return Unit.INSTANCE;
    L5:
        if (r16 == false) goto L7;
        a r7 = new com.larus.network.http.y(new SaveCollectionResponse(null, null, 3, null), null, 14);
    L8:
        ICollectionReport.a.a(CollectionReportDelegate.b, r7, CollectionsKt.listOf(r0), "like", null, null, null, 48);
        goto L9
    L7:
        r7 = null;
        goto L8
    }
}

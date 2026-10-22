package com.larus.bmhome.chat.model;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.database.entity.simple.ConversationSimpleEntity;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t0 implements IIMCallback<List<? extends ConversationSimpleEntity>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<gr9.b>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public t0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ConversationListModel", r4.getCode() + "; " + r4.getTips(), r4.getException());
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r15) {
        List r16 = (List) r15;
        ConversationListModel r0 = ConversationListModel.a;
        CopyOnWriteArrayList<gr9.b> r1 = new CopyOnWriteArrayList();
        ConversationListModel.u = r1;
        if (r16 == null) goto L33;
        ArrayList r2 = new ArrayList();
        Iterator r17 = r16.iterator();
    L6:
        if (r17.hasNext() == false) goto L10;
        Object r3 = r17.next();
        Lazy r4 = com.larus.im.j.a;
        if ((!com.larus.im.j.f(((ConversationSimpleEntity) r3).getConversationId())) == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L32;
        ConversationSimpleEntity r6 = (ConversationSimpleEntity) r5.next();
        String r7 = r6.getConversationId();
        String r8 = r6.getName();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        String r9 = r8;
        Long r10 = r6.getVersion();
        long r11 = 0;
        if (r10 == null) goto L19;
        long r12 = r10.longValue();
    L20:
        long r13 = r12 / ((long) 1000000);
        Long r14 = r6.getVersion();
        if (r14 == null) goto L23;
        r11 = r14.longValue();
    L23:
        long r19 = r11;
        Integer r20 = r6.getBadgeCount();
        if (r20 == null) goto L26;
        int r110 = r20.intValue();
    L27:
        Integer r21 = r6.getReadBadgeCount();
        if (r21 == null) goto L30;
        int r22 = r21.intValue();
    L31:
        r18.add(new gr9.b(r7, r9, r13, r19, r110, r22));
        goto L12
    L30:
        r22 = 0;
        goto L31
    L26:
        r110 = 0;
        goto L27
    L19:
        r12 = 0;
        goto L20
    L32:
        r1.addAll(r18);
    L33:
        kotlinx.coroutines.i<List<gr9.b>> r111 = this.a;
        Result.Companion r23 = Result.Companion;
        r111.resumeWith(Result.constructor-impl(ConversationListModel.u));
    }
}

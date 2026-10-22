package com.obric.flow.cardlistpage.domain.usecase;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import obric.flow.miniappwidget.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.domain.repository.b f11517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fq.a f11518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f11519c;

    public c(com.obric.flow.cardlistpage.domain.repository.b r5, fq.a r10, l r11) {
        this.f11517a = r5;
        this.f11518b = r10;
        this.f11519c = r11;
    }

    public final Object a(ArrayList r10, Continuation r11) {
        com.obric.flow.cardlistpage.domain.repository.b r5 = this.f11517a;
        if (r5 == null) goto L18;
        fq.a r12 = this.f11518b;
        if (r12 == null) goto L8;
        b r13 = new b(r12);
    L9:
        l r14 = this.f11519c;
        if (r14 == null) goto L12;
        d r15 = new d(r14);
    L13:
        List r16 = CollectionsKt.listOfNotNull(new g[]{r13, r15});
        if (r16.isEmpty() == false) goto L17;
        return r10;
    L17:
        return BuildersKt.withContext(Dispatchers.getIO(), new CheckWidgetProvidersUseCase$invoke$2(r10, r16, r5, null), r11);
    L12:
        r15 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    L18:
        return r10;
    }
}

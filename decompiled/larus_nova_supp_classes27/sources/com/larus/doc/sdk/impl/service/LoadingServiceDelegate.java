package com.larus.doc.sdk.impl.service;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/doc/sdk/impl/service/LoadingServiceDelegate;", "Lcom/larus/office/base/page/ILoadingService;", "<init>", "()V", "getRealImpl", "id", "", "loadingServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addLoadingService", "", "loadingService", "removeLoadingService", "getLoadingView", "Lcom/larus/office/base/page/IHostLoadingAndErrorLayout;", "onLoadFailed", "errorCode", "", "notifyHasReportLoadResultEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingServiceDelegate implements vm9.c {
    private CopyOnWriteArrayList<vm9.c> loadingServices;

    public Function0<String> getIdGetter() {
        return null;
    }

    public vm9.b getLoadingView() {
        vm9.c r0 = (vm9.c) CollectionsKt.lastOrNull(this.loadingServices);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLoadingView();
    }

    public void notifyHasReportLoadResultEvent() {
        Iterator<T> r0 = this.loadingServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((vm9.c) r0.next()).notifyHasReportLoadResultEvent();
        goto L4
    }

    public LoadingServiceDelegate() {
        this.loadingServices = new CopyOnWriteArrayList();
    }

    public final void addLoadingService(vm9.c r2) {
        this.loadingServices.add(r2);
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public vm9.c m50getRealImpl(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        CopyOnWriteArrayList<vm9.c> r0 = this.loadingServices;
        ListIterator<vm9.c> r1 = r0.listIterator(r0.size());
    L3:
        String r2 = null;
        if (r1.hasPrevious() == false) goto L12;
        String r3 = r1.previous();
        Function0 r4 = ((vm9.c) r3).getIdGetter();
        if (r4 == null) goto L9;
        r2 = (String) r4.invoke();
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = r3;
    L12:
        return (vm9.c) r2;
    }

    public void onLoadFailed(int r3) {
        Iterator<T> r0 = this.loadingServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((vm9.c) r0.next()).onLoadFailed(r3);
        goto L4
    }

    public final void removeLoadingService(vm9.c r2) {
        this.loadingServices.remove(r2);
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r1) {
        return m50getRealImpl(r1);
    }
}

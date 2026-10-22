package com.larus.doc.sdk.impl.service;

import com.larus.doc.sdk.api.SyncedDocInfoSource;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/doc/sdk/impl/service/OperationServiceDelegate;", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "<init>", "()V", "getRealImpl", "id", "", "operationServices", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addOperationService", "", "operationService", "removeOperationService", "notifyDocLoadSuccess", "notifyInterruptConversation", "onSyncedDocInfo", "source", "Lcom/larus/doc/sdk/api/SyncedDocInfoSource;", "getCreateDocResp", "notifyOfflineCreateState", "state", "", "offlineCreateFail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperationServiceDelegate implements n39.d {
    private CopyOnWriteArrayList<n39.d> operationServices;

    public Function0<String> getIdGetter() {
        return null;
    }

    @Override // n39.d
    public String getCreateDocResp() {
        n39.d r0 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCreateDocResp();
    }

    @Override // n39.d
    public void notifyDocLoadSuccess() {
        Iterator<T> r0 = this.operationServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.d) r0.next()).notifyDocLoadSuccess();
        goto L4
    }

    @Override // n39.d
    public void notifyInterruptConversation() {
        Iterator<T> r0 = this.operationServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((n39.d) r0.next()).notifyInterruptConversation();
        goto L4
    }

    @Override // n39.d
    public void offlineCreateFail() {
        n39.d r0 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r0 == null) goto L6;
        r0.offlineCreateFail();
        return;
    }

    public OperationServiceDelegate() {
        this.operationServices = new CopyOnWriteArrayList();
    }

    public final void addOperationService(n39.d r2) {
        this.operationServices.add(r2);
    }

    /* JADX INFO: renamed from: getRealImpl, reason: collision with other method in class */
    public n39.d m51getRealImpl(String r5) {
        Intrinsics.checkNotNullParameter(r5, "id");
        CopyOnWriteArrayList<n39.d> r0 = this.operationServices;
        ListIterator<n39.d> r1 = r0.listIterator(r0.size());
    L3:
        Object r2 = null;
        if (r1.hasPrevious() == false) goto L12;
        n39.d r3 = r1.previous();
        Function0 r4 = r3.getIdGetter();
        if (r4 == null) goto L9;
        r2 = (String) r4.invoke();
    L9:
        if (Intrinsics.areEqual(r2, r5) == false) goto L3;
        r2 = r3;
    L12:
        return (n39.d) r2;
    }

    @Override // n39.d
    public void notifyOfflineCreateState(int r2) {
        n39.d r0 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r0 == null) goto L6;
        r0.notifyOfflineCreateState(r2);
        return;
    }

    @Override // n39.d
    public void onSyncedDocInfo(SyncedDocInfoSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        n39.d r0 = (n39.d) CollectionsKt.lastOrNull(this.operationServices);
        if (r0 == null) goto L6;
        r0.onSyncedDocInfo(r2);
        return;
    }

    public final void removeOperationService(n39.d r2) {
        this.operationServices.remove(r2);
    }

    public /* bridge */ /* synthetic */ Object getRealImpl(String r1) {
        return m51getRealImpl(r1);
    }
}

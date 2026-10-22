package com.bytedance.ies.abmock.datacenter.precise;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0011\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0014\u0010\u0015\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler;", "", "vidStorage", "Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler$IVidStorage;", "(Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler$IVidStorage;)V", "cacheExposureVids", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "addVidList", "", "vidList", "", "filterVidList", "", "predicate", "Lkotlin/Function1;", "", "getExposureVids", "", "()[Ljava/lang/String;", "refreshToStorage", "removeVidList", "IVidStorage", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0136a f2693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f2694b;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.precise.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/precise/ExposureHandler$IVidStorage;", "", "loadVids", "", "", "()[Ljava/lang/String;", "saveVids", "", "vids", "([Ljava/lang/String;)V", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface InterfaceC0136a {
        void a(String[] r1);

        String[] a();
    }

    public a(InterfaceC0136a r4) {
        InterfaceC0136a r5 = (InterfaceC0136a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0136a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "vidStorage");
        this.f2693a = r5;
        CopyOnWriteArrayList<String> r0 = new CopyOnWriteArrayList();
        this.f2694b = r0;
        String[] r3 = r5.a();
        if (r3.length != 0) goto L5;
        boolean r6 = true;
    L7:
        if ((!r6) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L13;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), r3);
        return;
    L13:
        return;
    L5:
        r6 = false;
        goto L7
    }

    private final Set<String> a(List<String> r5, Function1<? super String, Boolean> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r1 = r10.next();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L4;
        r9.add(r1);
        goto L4
    L9:
        return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ CopyOnWriteArrayList a(a r0) {
        return r0.f2694b;
    }

    private final void b() {
        InterfaceC0136a r0 = this.f2693a;
        Object[] r3 = ((Collection) ZeusTransformUtils.preCheckCast(this.f2694b, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r0.a((String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.memorydata.plugin"));
    }

    public final void a(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "vidList");
        Set<String> r6 = a(r5, (Function1) ZeusTransformUtils.preCheckCast(new ExposureHandler$removeVidList$1(this), Function1.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L9;
        this.f2694b.removeAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        b();
        return;
    }

    public final String[] a() {
        Object[] r2 = ((Collection) ZeusTransformUtils.preCheckCast(this.f2694b, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.memorydata.plugin");
    }
}

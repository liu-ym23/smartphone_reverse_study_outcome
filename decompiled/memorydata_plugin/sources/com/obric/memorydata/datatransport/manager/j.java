package com.obric.memorydata.datatransport.manager;

import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolver;", "", "<init>", "()V", "resolve", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution;", "userId", "", "isLogin", "", "provider", "Lkotlin/Function0;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9778a = null;

    static {
        f9778a = new j();
    }

    private j() {
    }

    public static /* synthetic */ i a(j r1, String r2, boolean r3, Function0 r4, int r5, Object r6) {
        Function0<? extends h> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = $$Lambda$j$gXc_kU9CZx1sTa80NsmmnSwS40Y.INSTANCE;
    L6:
        return r1.a(r2, r3, r7);
    }

    private static final z a() {
        IStore r0 = StoreManager.INSTANCE.getPersonalStore();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new z(r0);
    }

    public static /* synthetic */ z lambda$gXc_kU9CZx1sTa80NsmmnSwS40Y() {
        return a();
    }

    public final i a(String r6, boolean r7, Function0<? extends h> r8) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r5, "provider");
        if (r7 == false) goto L22;
        Long r9 = StringsKt.toLongOrNull(r6);
        boolean r10 = true;
        if (r9 != null) goto L7;
    L12:
        r10 = false;
    L13:
        if (r10 == false) goto L22;
        h r11 = (h) ZeusTransformUtils.preCheckCast(r5.invoke(), h.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L18;
        Object r12 = ZeusTransformUtils.preCheckCast(new i.a(r11), i.class, "com.obric.memorydata.plugin");
    L20:
        return (i) r12;
    L18:
        r12 = ZeusTransformUtils.preCheckCast(i.c.f9777a, i.class, "com.obric.memorydata.plugin");
        goto L20
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r13 = true;
    L10:
        if (r13 != true) goto L12;
    L9:
        r13 = false;
    L22:
        return (i) ZeusTransformUtils.preCheckCast(i.b.f9776a, i.class, "com.obric.memorydata.plugin");
    }
}

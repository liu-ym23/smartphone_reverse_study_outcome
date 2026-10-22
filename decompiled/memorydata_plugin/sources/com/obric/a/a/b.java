package com.obric.a.a;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/callandsms/common/CallSmsEntityChangeObserver;", "", "()V", "delegate", "Lcom/obric/callandsms/common/CallSmsEntityChangeCallBack;", "bulkDelete", "", "entityIds", "", "", "entityType", "", "bulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "setDelegate", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f5864b;

    static {
        f5863a = new b();
    }

    private b() {
    }

    public final void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "delegate");
        f5864b = r1;
    }

    public final void a(List<? extends AppEntity> r2) {
        List<? extends AppEntity> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entities");
        a r3 = f5864b;
        if (r3 == null) goto L6;
        r3.a(r1);
        return;
    }

    public final void a(List<String> r2, int r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entityIds");
        a r4 = f5864b;
        if (r4 == null) goto L6;
        r4.a(r1, r3);
        return;
    }
}

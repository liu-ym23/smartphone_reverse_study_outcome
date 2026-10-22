package com.bytedance.applog.priority;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applog/priority/NativePriorityEventMetaFactoryImpl;", "Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "metaInjector", "(Lcom/bytedance/applog/priority/PriorityEventMetaFactory;)V", "getMetaInjector", "()Lcom/bytedance/applog/priority/PriorityEventMetaFactory;", "abSdkVersion", "", "eventId", "", "eventIndex", "nt", "", "sentryStainedValue", "eventName", "user", "Lcom/bytedance/applog/priority/PriorityUser;", "userUid", "userUserId", "userUserIsAuth", "userUserIsLogin", "userUserType", "userUuid", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativePriorityEventMetaFactoryImpl implements PriorityEventMetaFactory {
    private final PriorityEventMetaFactory metaInjector;

    public NativePriorityEventMetaFactoryImpl(PriorityEventMetaFactory r3) {
        PriorityEventMetaFactory r4 = (PriorityEventMetaFactory) ZeusTransformUtils.wrapperContextForParams(r3, PriorityEventMetaFactory.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "metaInjector");
        this.metaInjector = r4;
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public String abSdkVersion() {
        return this.metaInjector.abSdkVersion();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public long eventId() {
        return this.metaInjector.eventId();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public long eventIndex() {
        return this.metaInjector.eventIndex();
    }

    public final PriorityEventMetaFactory getMetaInjector() {
        return this.metaInjector;
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public int nt() {
        return this.metaInjector.nt();
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public int sentryStainedValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return this.metaInjector.sentryStainedValue(r2);
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public i user() {
        return this.metaInjector.user();
    }

    public final long userUid() {
        i r2 = this.metaInjector.user();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.f();
    }

    public final long userUserId() {
        i r2 = this.metaInjector.user();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.b();
    }

    public final int userUserIsAuth() {
        i r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    public final int userUserIsLogin() {
        i r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public final int userUserType() {
        i r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e();
    }

    public final String userUuid() {
        i r0 = this.metaInjector.user();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }
}

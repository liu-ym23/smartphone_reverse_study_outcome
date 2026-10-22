package com.bytedance.applog.priority;

import androidx.annotation.Keep;
import he.i;
import m4.e;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class NativePriorityEventMetaFactoryImpl implements PriorityEventMetaFactory {
    private final PriorityEventMetaFactory metaInjector;

    public NativePriorityEventMetaFactoryImpl(PriorityEventMetaFactory r8) {
        i.f(r8, "metaInjector");
        this.metaInjector = r8;
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
    public int sentryStainedValue(String r8) {
        i.f(r8, "eventName");
        return this.metaInjector.sentryStainedValue(r8);
    }

    @Override // com.bytedance.applog.priority.PriorityEventMetaFactory
    public e user() {
        return this.metaInjector.user();
    }

    public final long userUid() {
        this.metaInjector.user();
        return 0;
    }

    public final long userUserId() {
        this.metaInjector.user();
        return 0;
    }

    public final int userUserIsAuth() {
        this.metaInjector.user();
        return 0;
    }

    public final int userUserIsLogin() {
        this.metaInjector.user();
        return 0;
    }

    public final int userUserType() {
        this.metaInjector.user();
        return 0;
    }

    public final String userUuid() {
        this.metaInjector.user();
        return null;
    }
}

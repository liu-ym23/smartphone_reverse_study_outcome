package com.obric.memorydata.personalcontext.collector;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011H\u0016J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/ContactSmsEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "<init>", "()V", "TAG", "", "syncSupplierPermissionState", "Lcom/obric/memorydata/personalcontext/collector/ContactSmsEntitySupplier$SyncSupplierPermissionState;", "multiSyncDataSupplier", "Lcom/obric/memorydata/personalcontext/collector/MultiEntitySyncDataSupplier;", "getMultiSyncDataSupplier", "hasSmsPermission", "", "hasCallLogPermission", "hasContactsPermission", "getAllContactAndSmsData", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getAllCallHistoryData", "getAllContactAndCallHistoryData", "getAllSmsData", "provideAllEntities", "provideSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getWholeEntities", "idList", "type", "", "SyncSupplierPermissionState", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements EntitySupplier, EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C0652a f12051b;
    private static k c;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.collector.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/ContactSmsEntitySupplier$SyncSupplierPermissionState;", "", "hasContactsPermission", "", "hasCallLogPermission", "hasSmsPermission", "<init>", "(ZZZ)V", "getHasContactsPermission", "()Z", "getHasCallLogPermission", "getHasSmsPermission", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0652a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12053b;
        private final boolean c;

        public C0652a(boolean r1, boolean r2, boolean r3) {
            this.f12052a = r1;
            this.f12053b = r2;
            this.c = r3;
        }

        public final boolean a() {
            return this.f12052a;
        }

        public final boolean b() {
            return this.f12053b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0652a.class) == true) goto L8;
            return false;
        L8:
            C0652a r6 = (C0652a) ZeusTransformUtils.preCheckCast(r5, C0652a.class, "com.obric.memorydata.plugin");
            if (this.f12052a == r6.f12052a) goto L12;
            return false;
        L12:
            if (this.f12053b == r6.f12053b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f12052a) * 31) + Boolean.hashCode(this.f12053b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "SyncSupplierPermissionState(hasContactsPermission=" + this.f12052a + ", hasCallLogPermission=" + this.f12053b + ", hasSmsPermission=" + this.c + ')';
        }
    }

    static {
        f12050a = new a();
    }

    private a() {
    }

    private final synchronized k h() {
        monitor-enter(this);
        C0652a r0 = new C0652a(c(), b(), a());     // Catch: Throwable -> L24
        k r1 = c;     // Catch: Throwable -> L24
        if (r1 != null) goto L6;
    L12:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r0.a() == false) goto L16;
        r3.add(new b(201, (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new com.obric.contactsdk.f(r2), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
    L16:
        if (r0.b() == false) goto L19;
        r3.add(new b(202, (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new com.obric.contactsdk.b(r2), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
    L19:
        if (r0.c() == false) goto L21;
        r3.add(new b(101, (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(new com.obric.smssdk.b(r2), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L24
    L21:
        k r4 = new k(r3);     // Catch: Throwable -> L24
        c = r4;     // Catch: Throwable -> L24
        f12051b = r0;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r4;
    L6:
        if (Intrinsics.areEqual(f12051b, r0) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L12;
        monitor-exit(this);
        return r1;
    L24:
        th = move-exception;
        throw th;
    }

    public final boolean a() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_SMS") == 0) goto L5;
    L7:
        return false;
    L5:
        if (c() == false) goto L7;
        return true;
    }

    public final boolean b() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_CALL_LOG") == 0) goto L5;
    L7:
        return false;
    L5:
        if (c() == false) goto L7;
        return true;
    }

    public final boolean c() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_CONTACTS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<AppEntity> d() {
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L5;
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (c() == false) goto L10;
        List<AppEntity> r1 = new com.obric.contactsdk.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
        Intrinsics.checkNotNullExpressionValue(r1, "provideAllEntities(...)");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
    L10:
        if (b() == false) goto L13;
        List<AppEntity> r2 = new com.obric.contactsdk.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
        Intrinsics.checkNotNullExpressionValue(r2, "provideAllEntities(...)");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    L13:
        if (a() == false) goto L15;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(new com.obric.smssdk.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities(), Collection.class, "com.obric.memorydata.plugin"));
    L15:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> e() {
        if (AppContext.INSTANCE.isObricFlavor() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (b() == false) goto L10;
        List<AppEntity> r6 = new com.obric.contactsdk.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
        Intrinsics.checkNotNullExpressionValue(r6, "provideAllEntities(...)");
        return r6;
    L10:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContactSmsEntitySupplier", "no callLog permission", null, 4, null);
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> f() {
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L5;
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (c() == false) goto L9;
        List<AppEntity> r1 = new com.obric.contactsdk.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
        Intrinsics.checkNotNullExpressionValue(r1, "provideAllEntities(...)");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
    L11:
        if (b() == false) goto L13;
        List<AppEntity> r10 = new com.obric.contactsdk.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
        Intrinsics.checkNotNullExpressionValue(r10, "provideAllEntities(...)");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin"));
    L14:
        return r0;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContactSmsEntitySupplier", "no callLog permission", false, 4, null);
        goto L14
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContactSmsEntitySupplier", "no contacts permission", false, 4, null);
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> g() {
        if (AppContext.INSTANCE.isObricFlavor() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (a() == true) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContactSmsEntitySupplier", "no sms permission", null, 4, null);
        return CollectionsKt.emptyList();
    L9:
        return new com.obric.smssdk.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).provideAllEntities();
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "idList");
        return h().getWholeEntities(r5, r4);
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        return d();
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        return h().provideSampleEntities();
    }
}

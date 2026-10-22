package com.obric.memorydata.datatransport.manager;

import com.obric.memorydata.middleware.api.store.IStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/PersonalStoreDataExportTaskStore;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;", "personalStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "<init>", "(Lcom/obric/memorydata/middleware/api/store/IStore;)V", "read", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskSnapshot;", "write", "", "snapshot", "clear", "Companion", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IStore f9811b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/PersonalStoreDataExportTaskStore$Companion;", "", "<init>", "()V", "KEY_SNAPSHOT", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9810a = new a(null);
    }

    public z(IStore r3) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "personalStore");
        this.f9811b = r4;
    }

    @Override // com.obric.memorydata.datatransport.manager.h
    public d a() {
        String r0 = this.f9811b.getString("data_export_task_snapshot", "");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        d r1 = e.f9765a.a(r0);
        if (r1 != null) goto L12;
        ((z) ZeusTransformUtils.preCheckCast(this, z.class, "com.obric.memorydata.plugin")).b();
        return null;
    L12:
        return r1;
    }

    @Override // com.obric.memorydata.datatransport.manager.h
    public void a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        if (this.f9811b.syncSave("data_export_task_snapshot", e.f9765a.a(r2)) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("failed to persist data export task snapshot".toString());
    }

    @Override // com.obric.memorydata.datatransport.manager.h
    public void b() {
        this.f9811b.remove(new String[]{"data_export_task_snapshot"});
    }
}

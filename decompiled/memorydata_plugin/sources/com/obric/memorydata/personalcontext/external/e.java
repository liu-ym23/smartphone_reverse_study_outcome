package com.obric.memorydata.personalcontext.external;

import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.IndexTaskManager;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001c\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalDataChangeObserver;", "", "<init>", "()V", "CHUNK_SIZE", "", "TAG", "", "delegate", "Lcom/obric/memorydata/personalcontext/external/ExternalDataChangeCallback;", "bulkIndex", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "bulkDelete", "entityIds", "entityType", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f12122b;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/personalcontext/external/ExternalDataChangeObserver$delegate$1", "Lcom/obric/memorydata/personalcontext/external/ExternalDataChangeCallback;", "onBulkDelete", "", "entityIds", "", "", "entityType", "", "onBulkIndex", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements d {
        a() {
        }

        private static final void b(List r9, int r10) {
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 100), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            List r3 = (List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin");
            String r5 = g.f12138a.a(r10);
            IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), r3, r10, r5, null, 8, null);
            goto L4
        }

        /* JADX INFO: renamed from: lambda$o-r0WfQqHZhLr6_M70YG2B4gwb8, reason: not valid java name */
        public static /* synthetic */ void m1069lambda$or0WfQqHZhLr6_M70YG2B4gwb8(List r0, int r1) {
            b(r0, r1);
        }

        @Override // com.obric.memorydata.personalcontext.external.d
        public void a(List<? extends AppEntity> r5) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "entities");
            c r6 = c.f12108a;
            StringBuilder r1 = new StringBuilder().append("onBulkIndex entityType: ");
            AppEntity r0 = (AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r4), AppEntity.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            Integer r2 = Integer.valueOf(r0.getType());
        L6:
            r6.b("ExternalDataChangeObserver", r1.append(r2).append(" size: ").append(r4.size()).toString());
            EntityProvider.bulkIndex$default(EntityProvider.INSTANCE, r4, null, 2, null);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // com.obric.memorydata.personalcontext.external.d
        public void a(List<String> r3, final int r4) {
            final List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "entityIds");
            c.f12108a.b("ExternalDataChangeObserver", "onBulkDelete entityType: " + r4 + " ids: " + r2);
            IndexTaskManager.INSTANCE.runTask("external photo onBulkDelete", new $$Lambda$e$a$or0WfQqHZhLr6_M70YG2B4gwb8(r2, r4));
        }
    }

    static {
        f12121a = new e();
        f12122b = (d) ZeusTransformUtils.preCheckCast(new a(), d.class, "com.obric.memorydata.plugin");
    }

    private e() {
    }

    public final void a(List<? extends AppEntity> r2) {
        List<? extends AppEntity> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entities");
        d r3 = f12122b;
        if (r3 == null) goto L6;
        r3.a(r1);
        return;
    }

    public final void a(List<String> r2, int r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entityIds");
        d r4 = f12122b;
        if (r4 == null) goto L6;
        r4.a(r1, r3);
        return;
    }
}

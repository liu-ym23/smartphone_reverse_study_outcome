package com.obric.aiproactive.impl.aidb;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/DaoAiProactivePreferenceStore;", "Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceStore;", "dao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactivePreferenceDao;", "<init>", "(Lcom/obric/aiproactive/impl/aidb/dao/AiProactivePreferenceDao;)V", "insert", "", "entity", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "insertAll", "", "entities", "queryById", OaidModel.KEY_ID, BuildConfig.CHANNEL, "", "delete", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class m implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiproactive.impl.aidb.dao.f f6366a;

    public m(com.obric.aiproactive.impl.aidb.dao.f r3) {
        com.obric.aiproactive.impl.aidb.dao.f r4 = (com.obric.aiproactive.impl.aidb.dao.f) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiproactive.impl.aidb.dao.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f6366a = r4;
    }

    @Override // com.obric.aiproactive.impl.aidb.k
    public com.obric.aiproactive.impl.aidb.a.f a(long r1) {
        return (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(this.f6366a.queryById(r1), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.impl.aidb.k
    public List<Long> a(List<com.obric.aiproactive.impl.aidb.a.f> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "entities");
        return this.f6366a.insertAll(r4);
    }

    @Override // com.obric.aiproactive.impl.aidb.k
    public int delete(com.obric.aiproactive.impl.aidb.a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f6366a.delete(r2);
    }

    @Override // com.obric.aiproactive.impl.aidb.k
    public long insert(com.obric.aiproactive.impl.aidb.a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f6366a.insert(r2);
    }

    @Override // com.obric.aiproactive.impl.aidb.k
    public int update(com.obric.aiproactive.impl.aidb.a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f6366a.update(r2);
    }
}

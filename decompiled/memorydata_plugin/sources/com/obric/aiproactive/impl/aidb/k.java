package com.obric.aiproactive.impl.aidb;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactivePreferenceStore;", "", "insert", "", "entity", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "insertAll", "", "entities", "queryById", OaidModel.KEY_ID, BuildConfig.CHANNEL, "", "delete", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface k {
    com.obric.aiproactive.impl.aidb.a.f a(long r1);

    List<Long> a(List<com.obric.aiproactive.impl.aidb.a.f> r1);

    int delete(com.obric.aiproactive.impl.aidb.a.f r1);

    long insert(com.obric.aiproactive.impl.aidb.a.f r1);

    int update(com.obric.aiproactive.impl.aidb.a.f r1);
}

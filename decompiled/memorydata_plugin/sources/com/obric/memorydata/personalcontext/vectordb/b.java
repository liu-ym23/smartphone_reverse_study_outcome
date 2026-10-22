package com.obric.memorydata.personalcontext.vectordb;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrationRegistry;", "", "<init>", "()V", "staticSpecs", "", "Lcom/obric/memorydata/personalcontext/vectordb/PersonalVectorDbFileMigrationSpec;", "getStaticSpecs", "()Ljava/util/List;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<c> f12405b = null;

    static {
        f12404a = new b();
        f12405b = CollectionsKt.listOf(new c[]{new c("auto_memory_pro_text_vector_copilot"), new c("short_memory_entity_text_vector_copilot"), new c("episodic_topic_memory_text_vector_copilot"), new c("life_log_entity_text_vector_copilot"), new c("semantic_text_copilot"), new c("user_profile_entity_text_vector_copilot")});
    }

    private b() {
    }

    public final List<c> a() {
        return f12405b;
    }
}

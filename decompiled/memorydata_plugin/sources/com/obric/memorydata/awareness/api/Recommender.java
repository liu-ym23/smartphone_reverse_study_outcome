package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/api/Recommender;", "Lcom/obric/memorydata/awareness/api/IRecommender;", "<init>", "()V", "recommend", "", "data", "Lorg/json/JSONArray;", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Recommender implements IRecommender {
    public static final Recommender INSTANCE = null;
    private final /* synthetic */ IRecommender $$delegate_0;

    static {
        INSTANCE = new Recommender();
    }

    private Recommender() {
        IRecommender r0 = (IRecommender) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IRecommender.class)), IRecommender.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IRecommender) ZeusTransformUtils.preCheckCast(DefaultRecommender.INSTANCE, IRecommender.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.awareness.api.IRecommender
    public void recommend(JSONArray r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.recommend(r2);
    }
}

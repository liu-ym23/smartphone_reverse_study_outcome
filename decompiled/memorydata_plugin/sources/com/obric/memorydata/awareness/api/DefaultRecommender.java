package com.obric.memorydata.awareness.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/api/DefaultRecommender;", "Lcom/obric/memorydata/awareness/api/IRecommender;", "<init>", "()V", "recommend", "", "data", "Lorg/json/JSONArray;", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultRecommender implements IRecommender {
    public static final DefaultRecommender INSTANCE = null;

    static {
        INSTANCE = new DefaultRecommender();
    }

    private DefaultRecommender() {
    }

    @Override // com.obric.memorydata.awareness.api.IRecommender
    public void recommend(JSONArray r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }
}

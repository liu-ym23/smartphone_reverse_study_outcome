package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/o2;", "Lvh7/c;", BuildConfig.FLAVOR, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName$annotations", "()V", "name", BuildConfig.FLAVOR, "getRelatedTopicId", "()J", "setRelatedTopicId", "(J)V", "getRelatedTopicId$annotations", "relatedTopicId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getNameImage", "()Lpy/k;", "getNameImage$annotations", "nameImage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o2 extends vh7.c<o2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "name_image")
    py.k getNameImage();

    @FieldName(name = "related_topic_id")
    long getRelatedTopicId();

    @FieldName(name = "name#setter")
    void setName(String r1);

    @FieldName(name = "related_topic_id#setter")
    void setRelatedTopicId(long r1);
}

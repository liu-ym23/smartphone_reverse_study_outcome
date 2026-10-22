package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/base/model/message/h1;", "Lvh7/c;", "Lcom/google/gson/JsonObject;", "extra", "getExtra", "()Lcom/google/gson/JsonObject;", "", "getPosition", "()I", "position", "getOperationType", "operationType", "", "getH5Url", "()Ljava/lang/String;", "h5Url", "getLynxUrl", "lynxUrl", "getContainerType", "containerType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h1 extends vh7.c<h1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    JsonObject extra();

    int getContainerType();

    JsonObject getExtra();

    String getH5Url();

    String getLynxUrl();

    int getOperationType();

    int getPosition();
}

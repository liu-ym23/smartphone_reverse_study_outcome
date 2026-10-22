package com.bytedance.android.live.revlink.impl.settings.pk;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import d51.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/pk/PkAnimalMoveDistanceSerializableObjectImpl;", "Ld51/d;", "", "pkStart", "F", "getPkStart", "()F", "pkEnd", "getPkEnd", "multiPkStart", "getMultiPkStart", "multiPkend", "getMultiPkend", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkAnimalMoveDistanceSerializableObjectImpl implements d {

    @SerializedName("multi_pk_start")
    private final float multiPkStart;

    @SerializedName("multi_pk_end")
    private final float multiPkend;

    @SerializedName("pk_end")
    private final float pkEnd;

    @SerializedName("pk_start")
    private final float pkStart;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/pk/PkAnimalMoveDistanceSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkAnimalMoveDistanceSerializableObjectImpl.class);
        }
    }

    public PkAnimalMoveDistanceSerializableObjectImpl() {
        this.pkStart = 20.0f;
        this.pkEnd = 70.0f;
        this.multiPkStart = 48.0f;
        this.multiPkend = 48.0f;
    }
}

package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/utils/SeiCheckConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/revlink/impl/utils/b0;", "", "delay", "J", "getDelay", "()J", "anchorVersion", "G2", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeiCheckConfigSerializableObjectImpl implements b0 {

    @SerializedName(Constants.Keys.VERSION)
    private final long anchorVersion;

    @SerializedName("delay")
    private final long delay;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/utils/SeiCheckConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SeiCheckConfigSerializableObjectImpl.class);
        }
    }

    public SeiCheckConfigSerializableObjectImpl() {
        this.delay = 3;
        this.anchorVersion = 2850;
    }

    @Override // com.bytedance.android.live.revlink.impl.utils.b0
    public final long G2() {
        return this.anchorVersion;
    }

    @Override // com.bytedance.android.live.revlink.impl.utils.b0
    public final long getDelay() {
        return this.delay;
    }
}

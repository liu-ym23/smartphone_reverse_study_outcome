package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/player/layoutmanager/IMultiBgMonitorConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/revlink/impl/multianchor/player/layoutmanager/a;", "", "timeThreshold", "J", "Z", "()J", "", "countThreshold", "I", "K7", "()I", "", "log", "l9", "()Z", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMultiBgMonitorConfigSerializableObjectImpl implements a {

    @SerializedName("count_threshold")
    private final int countThreshold;

    @SerializedName("log")
    private final boolean log;

    @SerializedName("time_threshold")
    private final long timeThreshold;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/player/layoutmanager/IMultiBgMonitorConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IMultiBgMonitorConfigSerializableObjectImpl.class);
        }
    }

    public IMultiBgMonitorConfigSerializableObjectImpl() {
        this.timeThreshold = 10000;
        this.countThreshold = 5;
        this.log = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a
    public final int K7() {
        return this.countThreshold;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a
    public final long Z() {
        return this.timeThreshold;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a
    public final boolean l9() {
        return this.log;
    }
}

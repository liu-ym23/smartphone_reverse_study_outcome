package com.bytedance.android.live.revlink.impl.settings.live.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w41.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiUnloadConfigSerializableObjectImpl;", "Lw41/d;", "", "pkSeiVersionSupportOpt", "Z", "getPkSeiVersionSupportOpt", "()Z", "", "unloadByVerTimeLimit", "I", "h9", "()I", "unloadByVerFrequencyTime", "A3", "unloadBySeiSourceCount", "b2", "unloadBySourceTimeLimit", "B5", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkSeiUnloadConfigSerializableObjectImpl implements d {

    @SerializedName("pk_sei_version_support_opt")
    private final boolean pkSeiVersionSupportOpt;

    @SerializedName("unload_by_sei_source_count")
    private final int unloadBySeiSourceCount;

    @SerializedName("unload_by_sei_source_time_limit")
    private final int unloadBySourceTimeLimit;

    @SerializedName("unload_by_sei_ver_frequency_time")
    private final int unloadByVerFrequencyTime;

    @SerializedName("unload_by_sei_ver_time_limit")
    private final int unloadByVerTimeLimit;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiUnloadConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkSeiUnloadConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkSeiUnloadConfigSerializableObjectImpl() {
        this.pkSeiVersionSupportOpt = true;
        this.unloadByVerTimeLimit = 8000;
        this.unloadByVerFrequencyTime = 2000;
        this.unloadBySeiSourceCount = 3;
        this.unloadBySourceTimeLimit = 8000;
    }

    @Override // w41.d
    public final int A3() {
        return this.unloadByVerFrequencyTime;
    }

    @Override // w41.d
    public final int B5() {
        return this.unloadBySourceTimeLimit;
    }

    @Override // w41.d
    public final int b2() {
        return this.unloadBySeiSourceCount;
    }

    @Override // w41.d
    public final int h9() {
        return this.unloadByVerTimeLimit;
    }
}

package com.bytedance.android.live.revlink.impl.settings.live.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w41.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiBackupOptConfigSerializableObjectImpl;", "Lw41/c;", "", "skipCheckOpt", "Z", "a8", "()Z", "closedChannelOpt", "c8", "seiLoadRefactor", "O7", "", "seiVerMaxCount", "I", "j9", "()I", "switchSceneSkipCheckTime", "z7", "pkBackupFirstSeiOpt", "F4", "multiBackupFirstSeiOpt", "k5", "unloadPkBySeiVer", "getUnloadPkBySeiVer", "unloadMultiBySeiVer", "a4", "unloadPkBySource", "getUnloadPkBySource", "unloadMultiBySource", "A4", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkSeiBackupOptConfigSerializableObjectImpl implements c {

    @SerializedName("closed_channel_opt")
    private final boolean closedChannelOpt;

    @SerializedName("multi_backup_first_sei_opt")
    private final boolean multiBackupFirstSeiOpt;

    @SerializedName("pk_backup_first_sei_opt")
    private final boolean pkBackupFirstSeiOpt;

    @SerializedName("sei_load_refactor")
    private final boolean seiLoadRefactor;

    @SerializedName("sei_ver_max_count")
    private final int seiVerMaxCount;

    @SerializedName("skip_check_opt")
    private final boolean skipCheckOpt;

    @SerializedName("switch_scene_skip_check_time")
    private final int switchSceneSkipCheckTime;

    @SerializedName("unload_multi_by_sei_ver")
    private final boolean unloadMultiBySeiVer;

    @SerializedName("unload_multi_by_source")
    private final boolean unloadMultiBySource;

    @SerializedName("unload_pk_by_sei_ver")
    private final boolean unloadPkBySeiVer;

    @SerializedName("unload_pk_by_source")
    private final boolean unloadPkBySource;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevLinkSeiBackupOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkSeiBackupOptConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkSeiBackupOptConfigSerializableObjectImpl() {
        this.skipCheckOpt = false;
        this.closedChannelOpt = false;
        this.seiLoadRefactor = false;
        this.seiVerMaxCount = 5;
        this.switchSceneSkipCheckTime = 15000;
        this.pkBackupFirstSeiOpt = false;
        this.multiBackupFirstSeiOpt = false;
        this.unloadPkBySeiVer = false;
        this.unloadMultiBySeiVer = false;
        this.unloadPkBySource = false;
        this.unloadMultiBySource = false;
    }

    @Override // w41.c
    public final boolean A4() {
        return this.unloadMultiBySource;
    }

    @Override // w41.c
    public final boolean F4() {
        return this.pkBackupFirstSeiOpt;
    }

    @Override // w41.c
    public final boolean O7() {
        return this.seiLoadRefactor;
    }

    @Override // w41.c
    public final boolean a4() {
        return this.unloadMultiBySeiVer;
    }

    @Override // w41.c
    public final boolean a8() {
        return this.skipCheckOpt;
    }

    @Override // w41.c
    public final boolean c8() {
        return this.closedChannelOpt;
    }

    @Override // w41.c
    public final int j9() {
        return this.seiVerMaxCount;
    }

    @Override // w41.c
    public final boolean k5() {
        return this.multiBackupFirstSeiOpt;
    }

    @Override // w41.c
    public final int z7() {
        return this.switchSceneSkipCheckTime;
    }
}

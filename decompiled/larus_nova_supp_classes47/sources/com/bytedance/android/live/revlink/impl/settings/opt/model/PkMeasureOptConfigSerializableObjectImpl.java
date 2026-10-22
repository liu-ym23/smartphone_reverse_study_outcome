package com.bytedance.android.live.revlink.impl.settings.opt.model;

import a51.a;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/PkMeasureOptConfigSerializableObjectImpl;", "La51/a;", "", "pkProgressBarOpt", "Z", "getPkProgressBarOpt", "()Z", "pkTitleOpt", "getPkTitleOpt", "voteBarOpt", "getVoteBarOpt", "pkLynxOpt", "P0", "enterRoomPkProgressNoAnim", "getEnterRoomPkProgressNoAnim", "", "pkTitleHeight", "I", "getPkTitleHeight", "()I", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkMeasureOptConfigSerializableObjectImpl implements a {

    @SerializedName("enter_room_pk_progress_no_anim")
    private final boolean enterRoomPkProgressNoAnim;

    @SerializedName("pk_lynx_opt")
    private final boolean pkLynxOpt;

    @SerializedName("pk_progress_bar_opt")
    private final boolean pkProgressBarOpt;

    @SerializedName("pk_title_container_height")
    private final int pkTitleHeight;

    @SerializedName("pk_title_opt")
    private final boolean pkTitleOpt;

    @SerializedName("vote_bar_opt")
    private final boolean voteBarOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/opt/model/PkMeasureOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PkMeasureOptConfigSerializableObjectImpl.class);
        }
    }

    public PkMeasureOptConfigSerializableObjectImpl() {
        this.pkProgressBarOpt = false;
        this.pkTitleOpt = false;
        this.voteBarOpt = false;
        this.pkLynxOpt = false;
        this.enterRoomPkProgressNoAnim = false;
        this.pkTitleHeight = 30;
    }

    @Override // a51.a
    public final boolean P0() {
        return this.pkLynxOpt;
    }
}

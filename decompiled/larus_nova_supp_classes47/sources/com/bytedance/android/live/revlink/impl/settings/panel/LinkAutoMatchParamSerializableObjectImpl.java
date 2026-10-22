package com.bytedance.android.live.revlink.impl.settings.panel;

import b51.a;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/panel/LinkAutoMatchParamSerializableObjectImpl;", "Lb51/a;", "", "enable", "Z", "getEnable", "()Z", "", "waitSec", "J", "getWaitSec", "()J", "", "accelerateLimit", "I", "getAccelerateLimit", "()I", "defaultWaitLimit", "getDefaultWaitLimit", "inviteLimitSec", "getInviteLimitSec", "pkAutoMatchIndex", "getPkAutoMatchIndex", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkAutoMatchParamSerializableObjectImpl implements a {

    @SerializedName("auto_acc_limite")
    private final int accelerateLimit;

    @SerializedName("auto_default_limite")
    private final int defaultWaitLimit;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("auto_invite_limite")
    private final int inviteLimitSec;

    @SerializedName("auto_pk_auto_index")
    private final int pkAutoMatchIndex;

    @SerializedName("auto_wait_sec")
    private final long waitSec;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/panel/LinkAutoMatchParamSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkAutoMatchParamSerializableObjectImpl.class);
        }
    }

    public LinkAutoMatchParamSerializableObjectImpl() {
        this.enable = true;
        this.waitSec = 15;
        this.accelerateLimit = 15;
        this.defaultWaitLimit = 60;
        this.inviteLimitSec = 10;
        this.pkAutoMatchIndex = 1;
    }

    @Override // b51.a
    public final int getAccelerateLimit() {
        return this.accelerateLimit;
    }

    @Override // b51.a
    public final int getDefaultWaitLimit() {
        return this.defaultWaitLimit;
    }

    @Override // b51.a
    public final int getInviteLimitSec() {
        return this.inviteLimitSec;
    }

    @Override // b51.a
    public final int getPkAutoMatchIndex() {
        return this.pkAutoMatchIndex;
    }

    @Override // b51.a
    public final long getWaitSec() {
        return this.waitSec;
    }
}

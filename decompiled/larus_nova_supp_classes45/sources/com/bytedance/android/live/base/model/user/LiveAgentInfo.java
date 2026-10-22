package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/base/model/user/LiveAgentInfo;", "", "", "opened", "", "toString", "Lpy/k;", "virtualAvatarImg", "Lpy/k;", "getVirtualAvatarImg", "()Lpy/k;", "setVirtualAvatarImg", "(Lpy/k;)V", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "", "agentStatus", "I", "getAgentStatus", "()I", "setAgentStatus", "(I)V", "<init>", "()V", "Companion", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAgentInfo implements vh7.h {
    public static final int AGENT_STATUS_OPEN = 1;
    public static final int AGENT_STATUS_UNKNOWN = 0;
    public static final a Companion = null;

    @SerializedName("agent_status")
    protected int agentStatus;

    @SerializedName("content")
    protected String content;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("virtual_avatar_img")
    protected py.k virtualAvatarImg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveAgentInfo() {
    }

    public final boolean opened() {
        if (this.agentStatus == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "LiveAgentInfo(virtualAvatarImg=" + this.virtualAvatarImg + ", schema=" + this.schema + ", content=" + this.content + ", agentStatus=" + this.agentStatus + ')';
    }

    public final int getAgentStatus() {
        return this.agentStatus;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final py.k getVirtualAvatarImg() {
        return this.virtualAvatarImg;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public LiveAgentInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.virtualAvatarImg = vh7.f.a(r5, py.k.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.schema = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.content = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.agentStatus = r5.i();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final void setAgentStatus(int r1) {
        this.agentStatus = r1;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setVirtualAvatarImg(py.k r1) {
        this.virtualAvatarImg = r1;
    }
}

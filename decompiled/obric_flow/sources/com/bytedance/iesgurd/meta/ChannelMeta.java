package com.bytedance.iesgurd.meta;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/iesgurd/meta/ChannelMeta;", "", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "updateTime", "getUpdateTime", "setUpdateTime", "", "forbidden", "Z", "getForbidden", "()Z", "setForbidden", "(Z)V", "Companion", "com/bytedance/iesgurd/meta/a", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class ChannelMeta {
    public static final a Companion = null;
    private boolean forbidden;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f6642id;
    private Long updateTime;

    static {
        Companion = new a();
    }

    public ChannelMeta() {
    }

    public final boolean getForbidden() {
        return this.forbidden;
    }

    public final Long getId() {
        return this.f6642id;
    }

    public final Long getUpdateTime() {
        return this.updateTime;
    }

    public final void setForbidden(boolean r5) {
        this.forbidden = r5;
    }

    public final void setId(Long r5) {
        this.f6642id = r5;
    }

    public final void setUpdateTime(Long r5) {
        this.updateTime = r5;
    }

    public String toString() {
        String r5 = "id," + this.f6642id + ",updateTime," + this.updateTime;
        if (this.forbidden == true) goto L5;
        return r5;
    L5:
        return io.reactivex.internal.observers.h.b(r5, ",forbidden,true");
    }
}

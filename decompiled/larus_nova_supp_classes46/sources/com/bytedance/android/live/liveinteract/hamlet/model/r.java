package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/r;", "Lcom/bytedance/android/live/liveinteract/hamlet/model/d;", "", "avatarID", "J", "getAvatarID", "()J", "b", "(J)V", "version", "getVersion", "d", "position", "Ljava/lang/Long;", "getPosition", "()Ljava/lang/Long;", "c", "(Ljava/lang/Long;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r extends d {

    @SerializedName("avatarID")
    private long avatarID;

    @SerializedName("position")
    private Long position;

    @SerializedName("version")
    private long version;

    public r() {
        super(0);
        this.position = 0L;
    }

    public final void b(long r1) {
        this.avatarID = r1;
    }

    public final void c(Long r1) {
        this.position = r1;
    }

    public final void d(long r1) {
        this.version = r1;
    }
}

package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "applyTime", "J", "a", "()J", "setApplyTime", "(J)V", "", "offset", "I", "d", "()I", "g", "(I)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/v;", "tags", "Ljava/util/List;", "e", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "eventInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "c", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "setEventInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c0;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c1 {
    public boolean a;

    @SerializedName("apply_time")
    private long applyTime;
    public long b;
    public transient boolean c;

    @SerializedName("event_info")
    private c0 eventInfo;

    @SerializedName("offset")
    private int offset;

    @SerializedName("tags")
    private List<? extends v> tags;

    @SerializedName("user")
    private IBaseUser user;

    public c1() {
    }

    public final long a() {
        return this.applyTime;
    }

    public final IBaseUser b() {
        return this.user;
    }

    public final c0 c() {
        return this.eventInfo;
    }

    public final int d() {
        return this.offset;
    }

    public final List<v> e() {
        return this.tags;
    }

    public final IBaseUser f() {
        return this.user;
    }

    public final void g(int r1) {
        this.offset = r1;
    }
}

package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/v;", "Lcom/bytedance/android/live/liveinteract/hamlet/model/d;", "", "", "uids", "Ljava/util/List;", "getUids", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "enlargeUids", "getEnlargeUids", "b", "normalUids", "getNormalUids", "d", "", "linkVersion", "J", "getLinkVersion", "()J", "c", "(J)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v extends d {

    @SerializedName("enlarge_uids")
    private List<String> enlargeUids;

    @SerializedName("linkVersion")
    private long linkVersion;

    @SerializedName("normal_uids")
    private List<String> normalUids;

    @SerializedName("uids")
    private List<String> uids;

    public v() {
        super(17);
    }

    public final void b(List<String> r1) {
        this.enlargeUids = r1;
    }

    public final void c(long r1) {
        this.linkVersion = r1;
    }

    public final void d(List<String> r1) {
        this.normalUids = r1;
    }

    public final void e(List<String> r1) {
        this.uids = r1;
    }
}

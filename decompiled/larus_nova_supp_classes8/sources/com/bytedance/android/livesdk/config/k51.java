package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/k51;", "", "", "", "track", "Ljava/util/List;", "c", "()Ljava/util/List;", "setTrack", "(Ljava/util/List;)V", "", "avatarSize", "I", "a", "()I", "setAvatarSize", "(I)V", "", "scale", "D", "b", "()D", "setScale", "(D)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k51 {

    @SerializedName("avatar_size")
    private int avatarSize;

    @SerializedName("scale")
    private double scale;

    @SerializedName("track")
    private List<Float> track;

    public k51() {
        this.track = CollectionsKt.listOf(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.35f), Float.valueOf(0.39f), Float.valueOf(0.42f)});
        this.avatarSize = 50;
        this.scale = 0.88d;
    }

    public final int a() {
        return this.avatarSize;
    }

    public final double b() {
        return this.scale;
    }

    public final List<Float> c() {
        return this.track;
    }
}

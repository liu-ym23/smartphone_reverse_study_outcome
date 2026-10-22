package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR*\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/h41;", "", "", "autoSlide", "Z", "b", "()Z", "setAutoSlide", "(Z)V", "autoFetch", "a", "setAutoFetch", "", "loadingOffset", "I", "d", "()I", "setLoadingOffset", "(I)V", "slideOffset", "f", "setSlideOffset", "slideVelocity", "g", "setSlideVelocity", "shunDrag", "e", "setShunDrag", "checkFrame", "c", "setCheckFrame", "", "", "supportEntrances", "Ljava/util/List;", "h", "()Ljava/util/List;", "setSupportEntrances", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h41 {

    @SerializedName("auto_fetch")
    private boolean autoFetch;

    @SerializedName("auto_slide")
    private boolean autoSlide;

    @SerializedName("check_frame")
    private boolean checkFrame;

    @SerializedName("loading_distance")
    private int loadingOffset;

    @SerializedName("shun_drag")
    private boolean shunDrag;

    @SerializedName("slide_offset")
    private int slideOffset;

    @SerializedName("slide_velocity")
    private int slideVelocity;

    @SerializedName("support_entrances")
    private List<String> supportEntrances;

    public h41() {
        this.loadingOffset = 60;
        this.slideOffset = 60;
        this.slideVelocity = 180;
        this.supportEntrances = CollectionsKt.listOf(new String[]{"homepage_hot_live_cell", "homepage_hot_video_head"});
    }

    public final boolean a() {
        return this.autoFetch;
    }

    public final boolean b() {
        return this.autoSlide;
    }

    public final boolean c() {
        return this.checkFrame;
    }

    public final int d() {
        return this.loadingOffset;
    }

    public final boolean e() {
        return this.shunDrag;
    }

    public final int f() {
        return this.slideOffset;
    }

    public final int g() {
        return this.slideVelocity;
    }

    public final List<String> h() {
        return this.supportEntrances;
    }
}

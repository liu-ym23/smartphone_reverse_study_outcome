package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/config/jb1;", "", "", "isEnable", "Z", "d", "()Z", "setEnable", "(Z)V", "", "", "uiLayoutList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setUiLayoutList", "(Ljava/util/List;)V", "", "invalidateDuration", "J", "b", "()J", "setInvalidateDuration", "(J)V", "ignoreTest", "a", "setIgnoreTest", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class jb1 {

    @SerializedName("ignore_anchor_test")
    private boolean ignoreTest;

    @SerializedName("invalidate_duration")
    private long invalidateDuration;

    @SerializedName("is_enable")
    private boolean isEnable;

    @SerializedName("support_ui_layout")
    private List<Integer> uiLayoutList;

    public jb1() {
        this.isEnable = true;
        this.uiLayoutList = CollectionsKt.mutableListOf(new Integer[]{30, 21, 22, 24, 25, 26, 27, 28, 29});
        this.invalidateDuration = 300;
        this.ignoreTest = true;
    }

    public final boolean a() {
        return this.ignoreTest;
    }

    public final long b() {
        return this.invalidateDuration;
    }

    public final List<Integer> c() {
        return this.uiLayoutList;
    }

    public final boolean d() {
        return this.isEnable;
    }
}

package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/c6;", "", "", "enable", "Z", "b", "()Z", "", "", "screenShotRoomConfig", "Ljava/util/List;", "d", "()Ljava/util/List;", "normalGameRoomConfig", "c", "delayLoadConfig", "a", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c6 {

    @SerializedName("delay_load_config")
    private final List<String> delayLoadConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("normal_room_forbid_config")
    private final List<String> normalGameRoomConfig;

    @SerializedName("screen_shot_forbid_config")
    private final List<String> screenShotRoomConfig;

    public c6() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c6) == false) goto L14;
        c6 r4 = (c6) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.screenShotRoomConfig, r4.screenShotRoomConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.normalGameRoomConfig, r4.normalGameRoomConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.delayLoadConfig, r4.delayLoadConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.screenShotRoomConfig;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<String> r7 = this.normalGameRoomConfig;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.delayLoadConfig;
        if (r10 == null) goto L17;
        r4 = r10.hashCode();
    L17:
        return r9 + r4;
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "GameEnterRoomWidgetOptConfig(enable=" + this.enable + ", screenShotRoomConfig=" + this.screenShotRoomConfig + ", normalGameRoomConfig=" + this.normalGameRoomConfig + ", delayLoadConfig=" + this.delayLoadConfig + ')';
    }

    public final List<String> a() {
        return this.delayLoadConfig;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.normalGameRoomConfig;
    }

    public final List<String> d() {
        return this.screenShotRoomConfig;
    }

    public c6(Object r4) {
        ArrayList r5 = new ArrayList();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        this.enable = false;
        this.screenShotRoomConfig = r5;
        this.normalGameRoomConfig = r0;
        this.delayLoadConfig = r1;
    }
}

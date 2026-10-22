package com.bytedance.android.livesdk.chatroom.utils.pngloader;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J1\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/pngloader/FlexData;", "", "flexSetting", "", "textSetting", "width", "", "height", "([F[FII)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FlexData {

    @SerializedName("flex_setting")
    public final float[] flexSetting;

    @SerializedName("height")
    public final int height;

    @SerializedName("text_setting")
    public final float[] textSetting;

    @SerializedName("width")
    public final int width;

    public FlexData() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ FlexData copy$default(FlexData r0, float[] r1, float[] r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.flexSetting;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.textSetting;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.width;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.height;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final float[] component1() {
        return this.flexSetting;
    }

    public final float[] component2() {
        return this.textSetting;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final FlexData copy(float[] r2, float[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "flexSetting");
        Intrinsics.checkNotNullParameter(r3, "textSetting");
        return new FlexData(r2, r3, r4, r5);
    }

    public String toString() {
        return "FlexData(flexSetting=" + Arrays.toString(this.flexSetting) + ", textSetting=" + Arrays.toString(this.textSetting) + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public int hashCode() {
        return (((((Arrays.hashCode(this.flexSetting) * 31) + Arrays.hashCode(this.textSetting)) * 31) + this.width) * 31) + this.height;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(FlexData.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L27;
        FlexData r6 = (FlexData) r5;
        if (Arrays.equals(this.flexSetting, r6.flexSetting) == true) goto L17;
        return false;
    L17:
        if (Arrays.equals(this.textSetting, r6.textSetting) == true) goto L20;
        return false;
    L20:
        if (this.width == r6.width) goto L23;
        return false;
    L23:
        if (this.height == r6.height) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.utils.pngloader.FlexData");
    L8:
        r2 = null;
        goto L10
    }

    public FlexData(float[] r2, float[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "flexSetting");
        Intrinsics.checkNotNullParameter(r3, "textSetting");
        this.flexSetting = r2;
        this.textSetting = r3;
        this.width = r4;
        this.height = r5;
    }

    public /* synthetic */ FlexData(float[] r2, float[] r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = new float[4];
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = new float[4];
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}

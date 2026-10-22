package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0006\u0010'\u001a\u00020(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "Landroid/os/Parcelable;", "scale", "", "onlyAppWindow", "", "delay", "", "cacheStrategy", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "excludeLayerPackages", "", "", "useHardwareBuffer", "heifOutput", "Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "<init>", "(FZJLcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;Ljava/util/List;ZLcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;)V", "getScale", "()F", "getOnlyAppWindow", "()Z", "getDelay", "()J", "getCacheStrategy", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "getExcludeLayerPackages", "()Ljava/util/List;", "getUseHardwareBuffer", "getHeifOutput", "()Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenshotOption implements Parcelable {
    public static final Parcelable.Creator<ScreenshotOption> CREATOR = null;
    public final float a;
    public final boolean b;
    public final long c;
    public final ScreenshotCacheStrategy d;
    public final List<String> e;
    public final boolean f;
    public final HeifOutputOption g;

    public static final class a implements Parcelable.Creator<ScreenshotOption> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            float r2 = r12.readFloat();
            if (r12.readInt() == 0) goto L5;
            boolean r5 = true;
        L6:
            long r6 = r12.readLong();
            ScreenshotCacheStrategy r8 = ScreenshotCacheStrategy.CREATOR.createFromParcel(r12);
            ArrayList<String> r9 = r12.createStringArrayList();
            if (r12.readInt() == 0) goto L9;
            boolean r10 = true;
        L11:
            if (r12.readInt() != 0) goto L13;
            HeifOutputOption r13 = null;
        L14:
            boolean r3 = r5;
            boolean r11 = r10;
            return new ScreenshotOption(r2, r3, r6, r8, r9, r11, r13);
        L13:
            r13 = HeifOutputOption.CREATOR.createFromParcel(r12);
            goto L14
        L9:
            r10 = false;
            goto L11
        L5:
            r5 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenshotOption[] newArray(int r1) {
            return new ScreenshotOption[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ScreenshotOption) == true) goto L8;
        return false;
    L8:
        ScreenshotOption r9 = (ScreenshotOption) r8;
        if (Float.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = Float.floatToIntBits(this.a) * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        long r4 = this.c;
        int r3 = (((((r0 + r1) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        List<String> r5 = this.e;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r3 + r7) * 31;
        if (this.f == true) goto L14;
        r2 = 1237;
    L14:
        int r9 = (r8 + r2) * 31;
        HeifOutputOption r10 = this.g;
        if (r10 == null) goto L19;
        r6 = r10.hashCode();
    L19:
        return r9 + r6;
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenshotOption(scale=" + this.a + ", onlyAppWindow=" + this.b + ", delay=" + this.c + ", cacheStrategy=" + this.d + ", excludeLayerPackages=" + this.e + ", useHardwareBuffer=" + this.f + ", heifOutput=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeFloat(this.a);
        r3.writeInt(this.b ? 1 : 0);
        r3.writeLong(this.c);
        this.d.writeToParcel(r3, r4);
        r3.writeStringList(this.e);
        r3.writeInt(this.f ? 1 : 0);
        HeifOutputOption r0 = this.g;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
    }

    public ScreenshotOption() {
        this(1.0f, false, 0, new ScreenshotCacheStrategy(CacheStrategy.CACHE_WITH_ROOT_NODE, null), null, false, null);
    }

    public ScreenshotOption(float r2, boolean r3, long r4, ScreenshotCacheStrategy r6, List<String> r7, boolean r8, HeifOutputOption r9) {
        Intrinsics.checkNotNullParameter(r6, "cacheStrategy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        boolean r5 = false;
        if (r8 == false) goto L7;
        if (r9 == null) goto L7;
        boolean r10 = false;
    L8:
        if (r10 == false) goto L30;
        if (r3 == false) goto L13;
        if (r9 == null) goto L13;
        boolean r11 = false;
    L14:
        if (r11 == false) goto L28;
        if (r7 != null) goto L17;
    L19:
        boolean r12 = false;
    L20:
        if (r12 == false) goto L22;
        if (r9 == null) goto L22;
    L23:
        if (r5 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("heifOutput is incompatible with excludeLayerPackages".toString());
    L22:
        r5 = true;
        goto L23
    L17:
        if ((!r7.isEmpty()) != true) goto L19;
        r12 = true;
        goto L20
    L28:
        throw new IllegalArgumentException("heifOutput is incompatible with onlyAppWindow".toString());
    L13:
        r11 = true;
        goto L14
    L30:
        throw new IllegalArgumentException("heifOutput is incompatible with useHardwareBuffer".toString());
    L7:
        r10 = true;
        goto L8
    }
}

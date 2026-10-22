package com.obric.memorydata.sdk.screencapture;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JI\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020)HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "Landroid/os/Parcelable;", "screenshot", "Landroid/graphics/Bitmap;", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "heifScreenshotPath", "", "isVertical", "", "viewTree", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "<init>", "(Landroid/graphics/Bitmap;Landroid/hardware/HardwareBuffer;Ljava/lang/String;ZLjava/util/List;)V", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "setHardwareBuffer", "(Landroid/hardware/HardwareBuffer;)V", "getHeifScreenshotPath", "()Ljava/lang/String;", "setHeifScreenshotPath", "(Ljava/lang/String;)V", "()Z", "setVertical", "(Z)V", "getViewTree", "()Ljava/util/List;", "setViewTree", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenData implements Parcelable {
    public static final Parcelable.Creator<ScreenData> CREATOR = null;
    private HardwareBuffer hardwareBuffer;
    private String heifScreenshotPath;
    private boolean isVertical;
    private Bitmap screenshot;
    private List<ViewTreeNode> viewTree;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ScreenData> {
        public a() {
        }

        public final ScreenData a(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            Bitmap r3 = (Bitmap) ZeusTransformUtils.preCheckCast(r9.readParcelable(ScreenData.class.getClassLoader()), Bitmap.class, "com.obric.memorydata.plugin");
            HardwareBuffer r4 = (HardwareBuffer) ZeusTransformUtils.preCheckCast(r9.readParcelable(ScreenData.class.getClassLoader()), HardwareBuffer.class, "com.obric.memorydata.plugin");
            String r5 = r9.readString();
            int r0 = 0;
            if (r9.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            if (r9.readInt() != 0) goto L9;
            ArrayList r8 = null;
        L14:
            return new ScreenData(r3, r4, r5, r6, (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));
        L9:
            int r10 = r9.readInt();
            ArrayList r2 = new ArrayList(r10);
        L10:
            if (r0 == r10) goto L12;
            r2.add(ViewTreeNode.CREATOR.createFromParcel(r9));
            r0 = r0 + 1;
            goto L10
        L12:
            r8 = r2;
            goto L14
        L5:
            r6 = false;
            goto L7
        }

        public final ScreenData[] a(int r1) {
            return new ScreenData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ScreenData() {
        this(null, null, null, false, null, 31, null);
    }

    public ScreenData(Bitmap r3, HardwareBuffer r4, String r5, boolean r6, List<ViewTreeNode> r7) {
        List<ViewTreeNode> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.screenshot = r3;
        this.hardwareBuffer = r4;
        this.heifScreenshotPath = r5;
        this.isVertical = r6;
        this.viewTree = r8;
    }

    public /* synthetic */ ScreenData(Bitmap r8, HardwareBuffer r9, String r10, boolean r11, List r12, int r13, DefaultConstructorMarker r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        Bitmap r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        HardwareBuffer r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r11 = false;
    L17:
        boolean r5 = r11;
        if ((r13 & 16) == 0) goto L20;
        List r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r15;
        goto L21
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ ScreenData copy$default(ScreenData r6, Bitmap r7, HardwareBuffer r8, String r9, boolean r10, List r11, int r12, Object r13) {
        List<ViewTreeNode> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.screenshot;
    L5:
        Bitmap r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.hardwareBuffer;
    L8:
        HardwareBuffer r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.heifScreenshotPath;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.isVertical;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.viewTree;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final Bitmap component1() {
        return this.screenshot;
    }

    public final HardwareBuffer component2() {
        return this.hardwareBuffer;
    }

    public final String component3() {
        return this.heifScreenshotPath;
    }

    public final boolean component4() {
        return this.isVertical;
    }

    public final List<ViewTreeNode> component5() {
        return this.viewTree;
    }

    public final ScreenData copy(Bitmap r7, HardwareBuffer r8, String r9, boolean r10, List<ViewTreeNode> r11) {
        return new ScreenData(r7, r8, r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenData.class) == true) goto L8;
        return false;
    L8:
        ScreenData r6 = (ScreenData) ZeusTransformUtils.preCheckCast(r5, ScreenData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.screenshot, r6.screenshot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hardwareBuffer, r6.hardwareBuffer) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.heifScreenshotPath, r6.heifScreenshotPath) == true) goto L18;
        return false;
    L18:
        if (this.isVertical == r6.isVertical) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.viewTree, r6.viewTree) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final HardwareBuffer getHardwareBuffer() {
        return this.hardwareBuffer;
    }

    public final String getHeifScreenshotPath() {
        return this.heifScreenshotPath;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final List<ViewTreeNode> getViewTree() {
        return this.viewTree;
    }

    public int hashCode() {
        Bitmap r0 = this.screenshot;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HardwareBuffer r4 = this.hardwareBuffer;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.heifScreenshotPath;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + Boolean.hashCode(this.isVertical)) * 31;
        List<ViewTreeNode> r10 = this.viewTree;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setHardwareBuffer(HardwareBuffer r1) {
        this.hardwareBuffer = r1;
    }

    public final void setHeifScreenshotPath(String r1) {
        this.heifScreenshotPath = r1;
    }

    public final void setScreenshot(Bitmap r1) {
        this.screenshot = r1;
    }

    public final void setVertical(boolean r1) {
        this.isVertical = r1;
    }

    public final void setViewTree(List<ViewTreeNode> r3) {
        this.viewTree = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "ScreenData(screenshot=" + this.screenshot + ", hardwareBuffer=" + this.hardwareBuffer + ", heifScreenshotPath=" + this.heifScreenshotPath + ", isVertical=" + this.isVertical + ", viewTree=" + this.viewTree + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.screenshot, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.hardwareBuffer, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeString(this.heifScreenshotPath);
        r4.writeInt(this.isVertical ? 1 : 0);
        List<ViewTreeNode> r3 = this.viewTree;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r3.size());
        Iterator<ViewTreeNode> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        ((ViewTreeNode) ZeusTransformUtils.preCheckCast(r6.next(), ViewTreeNode.class, "com.obric.memorydata.plugin")).writeToParcel(r4, r5);
        goto L7
    }
}

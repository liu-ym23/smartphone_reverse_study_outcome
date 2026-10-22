package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.ImageData;
import com.larus.platform.api.creation.UserCreationFromIM;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasImageBlock;", "Ljava/io/Serializable;", "canvasInfo", "Lcom/larus/canvas/service/bean/CanvasInfo;", "image", "Lcom/larus/im/bean/message/ImageData;", "creation", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "generateData", "Lcom/larus/canvas/service/bean/CanvasGenerateData;", "msgInfo", "Lcom/larus/canvas/service/bean/CanvasMsgInfo;", "<init>", "(Lcom/larus/canvas/service/bean/CanvasInfo;Lcom/larus/im/bean/message/ImageData;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/canvas/service/bean/CanvasGenerateData;Lcom/larus/canvas/service/bean/CanvasMsgInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasImageBlock implements Serializable {

    @SerializedName("canvas")
    public final CanvasInfo canvasInfo;

    @SerializedName("creation")
    public final UserCreationFromIM creation;

    @SerializedName("generate_data")
    public final CanvasGenerateData generateData;

    @SerializedName("image")
    public final ImageData image;

    @SerializedName("msg_info")
    public final CanvasMsgInfo msgInfo;

    public CanvasImageBlock() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CanvasImageBlock copy$default(CanvasImageBlock r3, CanvasInfo r4, ImageData r5, UserCreationFromIM r6, CanvasGenerateData r7, CanvasMsgInfo r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.canvasInfo;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.image;
    L8:
        ImageData r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.creation;
    L11:
        UserCreationFromIM r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.generateData;
    L14:
        CanvasGenerateData r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.msgInfo;
    L17:
        CanvasInfo r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final CanvasInfo component1() {
        return this.canvasInfo;
    }

    public final ImageData component2() {
        return this.image;
    }

    public final UserCreationFromIM component3() {
        return this.creation;
    }

    public final CanvasGenerateData component4() {
        return this.generateData;
    }

    public final CanvasMsgInfo component5() {
        return this.msgInfo;
    }

    public final CanvasImageBlock copy(CanvasInfo r8, ImageData r9, UserCreationFromIM r10, CanvasGenerateData r11, CanvasMsgInfo r12) {
        return new CanvasImageBlock(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CanvasImageBlock) == true) goto L8;
        return false;
    L8:
        CanvasImageBlock r6 = (CanvasImageBlock) r5;
        if (Intrinsics.areEqual(this.canvasInfo, r6.canvasInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.image, r6.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creation, r6.creation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.generateData, r6.generateData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.msgInfo, r6.msgInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        CanvasInfo r0 = this.canvasInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImageData r4 = this.image;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        UserCreationFromIM r7 = this.creation;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        CanvasGenerateData r10 = this.generateData;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CanvasMsgInfo r13 = this.msgInfo;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public String toString() {
        return "CanvasImageBlock(canvasInfo=" + this.canvasInfo + ", image=" + this.image + ", creation=" + this.creation + ", generateData=" + this.generateData + ", msgInfo=" + this.msgInfo + ')';
    }

    public CanvasImageBlock(CanvasInfo r1, ImageData r2, UserCreationFromIM r3, CanvasGenerateData r4, CanvasMsgInfo r5) {
        this.canvasInfo = r1;
        this.image = r2;
        this.creation = r3;
        this.generateData = r4;
        this.msgInfo = r5;
    }

    public /* synthetic */ CanvasImageBlock(CanvasInfo r5, ImageData r6, UserCreationFromIM r7, CanvasGenerateData r8, CanvasMsgInfo r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        CanvasInfo r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        ImageData r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        UserCreationFromIM r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        CanvasGenerateData r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        CanvasMsgInfo r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}

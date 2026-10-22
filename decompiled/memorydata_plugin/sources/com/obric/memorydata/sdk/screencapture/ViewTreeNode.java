package com.obric.memorydata.sdk.screencapture;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "Landroid/os/Parcelable;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "contentDescription", OaidModel.KEY_ID, "className", "rect", "Landroid/graphics/Rect;", "visible", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;Z)V", "getText", "()Ljava/lang/String;", "getContentDescription", "getId", "getClassName", "getRect", "()Landroid/graphics/Rect;", "getVisible", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewTreeNode implements Parcelable {
    public static final Parcelable.Creator<ViewTreeNode> CREATOR = null;
    private final String className;
    private final String contentDescription;
    private final String id;
    private final Rect rect;
    private final String text;
    private final boolean visible;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ViewTreeNode> {
        public a() {
        }

        public final ViewTreeNode a(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r1 = r8.readString();
            String r2 = r8.readString();
            String r3 = r8.readString();
            String r4 = r8.readString();
            Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(r8.readParcelable(ViewTreeNode.class.getClassLoader()), Rect.class, "com.obric.memorydata.plugin");
            if (r8.readInt() == 0) goto L5;
            boolean r9 = true;
        L7:
            return new ViewTreeNode(r1, r2, r3, r4, r5, r9);
        L5:
            r9 = false;
            goto L7
        }

        public final ViewTreeNode[] a(int r1) {
            return new ViewTreeNode[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ViewTreeNode createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ViewTreeNode[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ViewTreeNode(String r2, String r3, String r4, String r5, Rect r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r3, "contentDescription");
        Intrinsics.checkNotNullParameter(r4, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r5, "className");
        Intrinsics.checkNotNullParameter(r6, "rect");
        this.text = r2;
        this.contentDescription = r3;
        this.id = r4;
        this.className = r5;
        this.rect = r6;
        this.visible = r7;
    }

    public static /* synthetic */ ViewTreeNode copy$default(ViewTreeNode r4, String r5, String r6, String r7, String r8, Rect r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.text;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.contentDescription;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.id;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.className;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.rect;
    L17:
        Rect r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.visible;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.contentDescription;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.className;
    }

    public final Rect component5() {
        return this.rect;
    }

    public final boolean component6() {
        return this.visible;
    }

    public final ViewTreeNode copy(String r8, String r9, String r10, String r11, Rect r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r9, "contentDescription");
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r11, "className");
        Intrinsics.checkNotNullParameter(r12, "rect");
        return new ViewTreeNode(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewTreeNode.class) == true) goto L8;
        return false;
    L8:
        ViewTreeNode r6 = (ViewTreeNode) ZeusTransformUtils.preCheckCast(r5, ViewTreeNode.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contentDescription, r6.contentDescription) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.className, r6.className) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rect, r6.rect) == true) goto L24;
        return false;
    L24:
        if (this.visible == r6.visible) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getId() {
        return this.id;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return (((((((((this.text.hashCode() * 31) + this.contentDescription.hashCode()) * 31) + this.id.hashCode()) * 31) + this.className.hashCode()) * 31) + this.rect.hashCode()) * 31) + Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "ViewTreeNode(text=" + this.text + ", contentDescription=" + this.contentDescription + ", id=" + this.id + ", className=" + this.className + ", rect=" + this.rect + ", visible=" + this.visible + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.text);
        r4.writeString(this.contentDescription);
        r4.writeString(this.id);
        r4.writeString(this.className);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.rect, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeInt(this.visible ? 1 : 0);
    }
}

package com.obric.capabilitykit.common;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/TaskStateInfo;", "Landroid/os/Parcelable;", "state", "Lcom/obric/capabilitykit/common/TaskState;", Params.CONTENT, "", "screenshot", "Landroid/graphics/Bitmap;", "ext", "", "(Lcom/obric/capabilitykit/common/TaskState;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/util/Map;)V", "getContent", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getState", "()Lcom/obric/capabilitykit/common/TaskState;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskStateInfo implements Parcelable {
    public static final Parcelable.Creator<TaskStateInfo> CREATOR = null;
    private final String content;
    private Map<String, String> ext;
    private Bitmap screenshot;
    private final TaskState state;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskStateInfo> {
        public a() {
        }

        public final TaskStateInfo a(Parcel r10) {
            int r9 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            TaskState r0 = TaskState.valueOf(r10.readString());
            String r1 = r10.readString();
            Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r10.readParcelable(TaskStateInfo.class.getClassLoader()), Bitmap.class, "com.obric.memorydata.plugin");
            if (r10.readInt() != 0) goto L5;
            LinkedHashMap r3 = null;
        L9:
            TaskStateInfo r5 = new TaskStateInfo(r0, r1, r2, r3);
            int r4 = Math.min(r9, 0);
            ClassLoader r6 = a.class.getClassLoader();
            int r7 = 1;
        L10:
            if (r7 > r4) goto L12;
            r7 = r7 + 1;
        L12:
            if (r7 > r9) goto L14;
            com.obric.b.a.a(r10, r6);
            r7 = r7 + 1;
            goto L12
        L14:
            return r5;
        L5:
            int r8 = r10.readInt();
            LinkedHashMap r11 = new LinkedHashMap(r8);
            int r12 = 0;
        L6:
            if (r12 == r8) goto L8;
            r11.put(r10.readString(), r10.readString());
            r12 = r12 + 1;
            goto L6
        L8:
            r3 = r11;
            goto L9
        }

        public final TaskStateInfo[] a(int r1) {
            return new TaskStateInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TaskStateInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TaskStateInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskStateInfo(TaskState r3, String r4, Bitmap r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.state = r3;
        this.content = r4;
        this.screenshot = r5;
        this.ext = r7;
    }

    public /* synthetic */ TaskStateInfo(TaskState r2, String r3, Bitmap r4, Map r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r8 = null;
    L11:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ TaskStateInfo copy$default(TaskStateInfo r1, TaskState r2, String r3, Bitmap r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.state;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.content;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.screenshot;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.ext;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public final TaskState component1() {
        return this.state;
    }

    public final String component2() {
        return this.content;
    }

    public final Bitmap component3() {
        return this.screenshot;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final TaskStateInfo copy(TaskState r2, String r3, Bitmap r4, Map<String, String> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "state");
        return new TaskStateInfo(r2, r3, r4, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskStateInfo.class) == true) goto L8;
        return false;
    L8:
        TaskStateInfo r6 = (TaskStateInfo) ZeusTransformUtils.preCheckCast(r5, TaskStateInfo.class, "com.obric.memorydata.plugin");
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.screenshot, r6.screenshot) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    public final TaskState getState() {
        return this.state;
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        String r1 = this.content;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Bitmap r5 = this.screenshot;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.ext;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setExt(Map<String, String> r3) {
        this.ext = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void setScreenshot(Bitmap r1) {
        this.screenshot = r1;
    }

    public String toString() {
        return "TaskStateInfo(state=" + this.state + ", content=" + this.content + ", screenshot=" + this.screenshot + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeString(this.state.name());
        r4.writeString(this.content);
        r4.writeParcelable(this.screenshot, r5);
        Map<String, String> r3 = this.ext;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r3.size());
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin"));
        r4.writeString((String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    }
}

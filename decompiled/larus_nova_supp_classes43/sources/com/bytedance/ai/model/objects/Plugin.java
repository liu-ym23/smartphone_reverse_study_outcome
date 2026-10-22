package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/ai/model/objects/Plugin;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "getName", "setName", "tools", "", "Lcom/bytedance/ai/model/objects/Tool;", "getTools", "()Ljava/util/List;", "setTools", "(Ljava/util/List;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Plugin implements Parcelable {
    public static final a CREATOR = null;
    private String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f11id;
    private String name;
    private List<Tool> tools;

    public static final class a implements Parcelable.Creator<Plugin> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Plugin createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Plugin(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Plugin[] newArray(int r1) {
            return new Plugin[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Plugin() {
        this.description = "";
        this.f11id = "";
        this.name = "";
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f11id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Tool> getTools() {
        return this.tools;
    }

    public Plugin(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this();
        this.description = r10.readString();
        this.f11id = r10.readString();
        this.name = r10.readString();
        this.tools = r10.createTypedArrayList(Tool.CREATOR);
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }

    public final void setId(String r1) {
        this.f11id = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setTools(List<Tool> r1) {
        this.tools = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.description);
        r1.writeString(this.f11id);
        r1.writeString(this.name);
        r1.writeTypedList(this.tools);
    }
}

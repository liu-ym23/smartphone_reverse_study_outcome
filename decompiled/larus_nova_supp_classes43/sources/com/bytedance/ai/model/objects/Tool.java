package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\""}, d2 = {"Lcom/bytedance/ai/model/objects/Tool;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", "input", "getInput", "setInput", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "getName", "setName", "output", "getOutput", "setOutput", "type", "getType", "setType", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Tool implements Parcelable {
    public static final a CREATOR = null;
    private String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f13id;
    private String input;
    private String name;
    private String output;
    private String type;

    public static final class a implements Parcelable.Creator<Tool> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Tool createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Tool(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Tool[] newArray(int r1) {
            return new Tool[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Tool() {
        this.description = "";
        this.f13id = "";
        this.input = "";
        this.name = "";
        this.output = "";
        this.type = "";
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f13id;
    }

    public final String getInput() {
        return this.input;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOutput() {
        return this.output;
    }

    public final String getType() {
        return this.type;
    }

    public Tool(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this();
        this.description = r10.readString();
        this.f13id = r10.readString();
        this.input = r10.readString();
        this.name = r10.readString();
        this.output = r10.readString();
        this.type = r10.readString();
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }

    public final void setId(String r1) {
        this.f13id = r1;
    }

    public final void setInput(String r1) {
        this.input = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setOutput(String r1) {
        this.output = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.description);
        r1.writeString(this.f13id);
        r1.writeString(this.input);
        r1.writeString(this.name);
        r1.writeString(this.output);
        r1.writeString(this.type);
    }
}

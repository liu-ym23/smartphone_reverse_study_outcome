package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.p;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R$\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/ai/model/objects/Tool;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", Constant.DESCRIPTION, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", "input", "getInput", "setInput", "name", "getName", "setName", "output", "getOutput", "setOutput", "type", "getType", "setType", "CREATOR", "w2/p", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Tool implements Parcelable {
    public static final p CREATOR = null;
    private String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2291id;
    private String input;
    private String name;
    private String output;
    private String type;

    static {
        CREATOR = new p();
    }

    public Tool() {
        this.description = "";
        this.f2291id = "";
        this.input = "";
        this.name = "";
        this.output = "";
        this.type = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f2291id;
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

    public final void setDescription(String r5) {
        this.description = r5;
    }

    public final void setId(String r5) {
        this.f2291id = r5;
    }

    public final void setInput(String r5) {
        this.input = r5;
    }

    public final void setName(String r5) {
        this.name = r5;
    }

    public final void setOutput(String r5) {
        this.output = r5;
    }

    public final void setType(String r5) {
        this.type = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.description);
        r5.writeString(this.f2291id);
        r5.writeString(this.input);
        r5.writeString(this.name);
        r5.writeString(this.output);
        r5.writeString(this.type);
    }

    public Tool(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        this.description = r5.readString();
        this.f2291id = r5.readString();
        this.input = r5.readString();
        this.name = r5.readString();
        this.output = r5.readString();
        this.type = r5.readString();
    }
}

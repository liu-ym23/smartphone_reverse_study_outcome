package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.l;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u0015R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u0015R$\u0010,\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010\u0015R$\u0010/\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u0015¨\u00064"}, d2 = {"Lcom/bytedance/ai/model/objects/Page;", "Landroid/os/Parcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "pageId", "()Ljava/lang/String;", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", Constant.DESCRIPTION, "Ljava/lang/String;", "getDescription", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", "", "input", "Ljava/lang/Object;", "getInput", "()Ljava/lang/Object;", "setInput", "(Ljava/lang/Object;)V", "name", "getName", "setName", "output", "getOutput", "setOutput", "entry", "getEntry", "setEntry", Constant.TITLE, "getTitle", "setTitle", "digest", "getDigest", "setDigest", "renderType", "getRenderType", "setRenderType", "CREATOR", "w2/l", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Page implements Parcelable {
    public static final l CREATOR = null;
    private String description;
    private String digest;
    private String entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2285id;
    private Object input;
    private String name;
    private Object output;
    private String renderType;
    private String title;

    static {
        CREATOR = new l();
    }

    public Page() {
        this.description = "";
        this.f2285id = "";
        this.name = "";
        this.entry = "";
        this.title = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final String getId() {
        return this.f2285id;
    }

    public final Object getInput() {
        return this.input;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getOutput() {
        return this.output;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String pageId() {
        if (c.l(this.f2285id) == false) goto L7;
        String r5 = this.f2285id;
        Intrinsics.checkNotNull(r5);
        return r5;
    L7:
        return this.name;
    }

    public final void setDescription(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.description = r5;
    }

    public final void setDigest(String r5) {
        this.digest = r5;
    }

    public final void setEntry(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.entry = r5;
    }

    public final void setId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f2285id = r5;
    }

    public final void setInput(Object r5) {
        this.input = r5;
    }

    public final void setName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.name = r5;
    }

    public final void setOutput(Object r5) {
        this.output = r5;
    }

    public final void setRenderType(String r5) {
        this.renderType = r5;
    }

    public final void setTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.title = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.description);
        r5.writeString(this.f2285id);
        r5.writeString(this.name);
        r5.writeString(this.entry);
        r5.writeString(this.title);
        r5.writeString(this.digest);
        r5.writeString(this.renderType);
    }

    public Page(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        String r10 = r5.readString();
        String r11 = "";
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        this.description = r10;
        String r12 = r5.readString();
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        this.f2285id = r12;
        String r13 = r5.readString();
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        this.name = r13;
        String r14 = r5.readString();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        this.entry = r14;
        String r15 = r5.readString();
        if (r15 == null) goto L18;
        r11 = r15;
    L18:
        this.title = r11;
        this.digest = r5.readString();
        this.renderType = r5.readString();
        this.input = null;
        this.output = null;
    }
}

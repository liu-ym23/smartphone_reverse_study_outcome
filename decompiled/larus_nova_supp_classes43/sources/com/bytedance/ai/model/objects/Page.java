package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.utils.g;
import com.google.gson.annotations.JsonAdapter;
import h5.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u00102\u001a\u00020\bJ\u0018\u00103\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR \u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00069"}, d2 = {"Lcom/bytedance/ai/model/objects/Page;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "getId", "setId", "input", "", "getInput", "()Ljava/lang/Object;", "setInput", "(Ljava/lang/Object;)V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "getName", "setName", "output", "getOutput", "setOutput", "entry", "getEntry", "setEntry", "title", "getTitle", "setTitle", "digest", "getDigest", "setDigest", "renderType", "getRenderType", "setRenderType", "path", "getPath", "setPath", "chat", "getChat", "setChat", "chatConfig", "Lcom/bytedance/ai/model/objects/PageChatConfig;", "getChatConfig", "()Lcom/bytedance/ai/model/objects/PageChatConfig;", "pageId", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Page implements Parcelable {
    public static final a CREATOR = null;

    @JsonAdapter(ChatConfigStringAdapter.class)
    private String chat;
    private String description;
    private String digest;
    private String entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f10id;
    private Object input;
    private String name;
    private Object output;
    private String path;
    private String renderType;
    private String title;

    public static final class a implements Parcelable.Creator<Page> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Page createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new Page(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final Page[] newArray(int r1) {
            return new Page[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final PageChatConfig getChatConfig() {
        f r0 = f.a;
        String r1 = this.chat;
        r0.getClass();
        return (PageChatConfig) f.a(r1, PageChatConfig.class);
    }

    public final String pageId() {
        if (com.bytedance.ai.utils.f.g(this.f10id) == false) goto L7;
        String r0 = this.f10id;
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        return this.name;
    }

    public Page() {
        this.description = "";
        this.f10id = "";
        this.name = "";
        this.entry = "";
        this.title = "";
    }

    public final String getChat() {
        return this.chat;
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
        return this.f10id;
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

    public final String getPath() {
        return this.path;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public final String getTitle() {
        return this.title;
    }

    public Page(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this();
        String r0 = r10.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.description = r0;
        String r11 = r10.readString();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        this.f10id = r11;
        String r12 = r10.readString();
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        this.name = r12;
        String r13 = r10.readString();
        if (r13 != null) goto L14;
        r13 = "";
    L14:
        this.entry = r13;
        String r14 = r10.readString();
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        this.title = r14;
        this.digest = r10.readString();
        this.renderType = r10.readString();
        String r15 = null;
        this.input = null;
        this.output = null;
        String r16 = r10.readString();     // Catch: Exception -> L22
        if (r16 == null) goto L24;
        r1 = r16;
    L24:
        this.path = r1;
        r15 = r10.readString();     // Catch: Exception -> L28
    L26:
        this.chat = r15;
        return;
    L22:
        e = move-exception;
        g.a.d("AIPackage", "read path from parcel exception: " + e);
        goto L24
    }

    public final void setChat(String r1) {
        this.chat = r1;
    }

    public final void setDescription(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.description = r10;
    }

    public final void setDigest(String r1) {
        this.digest = r1;
    }

    public final void setEntry(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.entry = r10;
    }

    public final void setId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f10id = r10;
    }

    public final void setInput(Object r1) {
        this.input = r1;
    }

    public final void setName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.name = r10;
    }

    public final void setOutput(Object r1) {
        this.output = r1;
    }

    public final void setPath(String r1) {
        this.path = r1;
    }

    public final void setRenderType(String r1) {
        this.renderType = r1;
    }

    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.title = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.description);
        r1.writeString(this.f10id);
        r1.writeString(this.name);
        r1.writeString(this.entry);
        r1.writeString(this.title);
        r1.writeString(this.digest);
        r1.writeString(this.renderType);
        r1.writeString(this.path);
        r1.writeString(this.chat);
    }
}

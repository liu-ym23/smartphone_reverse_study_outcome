package com.obric.aiagent.assistant.idl.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/TextContent;", "Ljava/io/Serializable;", "text", "", "imCmd", "", "title", "desc", "images", "Lorg/json/JSONArray;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)V", "getImCmd", "()Ljava/lang/Integer;", "setImCmd", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "getDesc", "getImages", "()Lorg/json/JSONArray;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)Lcom/obric/aiagent/assistant/idl/bean/TextContent;", "equals", "", "other", "", "hashCode", "toString", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TextContent implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("description")
    private final String desc;

    @SerializedName("im_cmd")
    private Integer imCmd;

    @SerializedName("images")
    private final JSONArray images;

    @SerializedName("text")
    public String text;

    @SerializedName("title")
    private final String title;

    static {
        Companion = new a();
    }

    public TextContent() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ TextContent copy$default(TextContent r3, String r4, Integer r5, String r6, String r7, JSONArray r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.text;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.imCmd;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.title;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.desc;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.images;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.imCmd;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.desc;
    }

    public final JSONArray component5() {
        return this.images;
    }

    public final TextContent copy(String r8, Integer r9, String r10, String r11, JSONArray r12) {
        return new TextContent(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextContent) == true) goto L8;
        return false;
    L8:
        TextContent r6 = (TextContent) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imCmd, r6.imCmd) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.images, r6.images) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.imCmd;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.title;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.desc;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        JSONArray r13 = this.images;
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
        return "TextContent(text=" + this.text + ", imCmd=" + this.imCmd + ", title=" + this.title + ", desc=" + this.desc + ", images=" + this.images + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getImCmd() {
        return this.imCmd;
    }

    public final JSONArray getImages() {
        return this.images;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setImCmd(Integer r1) {
        this.imCmd = r1;
    }

    public TextContent(String r1, Integer r2, String r3, String r4, JSONArray r5) {
        this.text = r1;
        this.imCmd = r2;
        this.title = r3;
        this.desc = r4;
        this.images = r5;
    }

    public /* synthetic */ TextContent(String r5, Integer r6, String r7, String r8, JSONArray r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r6 = -1;
    L9:
        Integer r1 = r6;
        if ((r10 & 4) == 0) goto L12;
        String r2 = null;
    L14:
        if ((r10 & 8) == 0) goto L16;
        String r3 = null;
    L18:
        if ((r10 & 16) == 0) goto L20;
        JSONArray r13 = null;
    L21:
        this(r12, r1, r2, r3, r13);
        return;
    L20:
        r13 = r9;
        goto L21
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L5:
        r12 = r5;
        goto L7
    }
}

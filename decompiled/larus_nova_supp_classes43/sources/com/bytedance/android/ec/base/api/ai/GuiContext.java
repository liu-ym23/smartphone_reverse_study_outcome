package com.bytedance.android.ec.base.api.ai;

import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/GuiContext;", "", "artifactType", "", "artifactSource", "originMessageId", "uri", "view", "Lcom/bytedance/android/ec/base/api/ai/GuiView;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/base/api/ai/GuiView;)V", "getArtifactSource", "()Ljava/lang/String;", "getArtifactType", "getOriginMessageId", "getUri", "getView", "()Lcom/bytedance/android/ec/base/api/ai/GuiView;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class GuiContext {

    @SerializedName("artifact_source")
    private final String artifactSource;

    @SerializedName("artifact_type")
    private final String artifactType;

    @SerializedName(ConversationConstants.KEY_ORIGIN_MESSAGE_ID)
    private final String originMessageId;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("view")
    private final GuiView view;

    public GuiContext() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GuiContext copy$default(GuiContext r10, String r11, String r12, String r13, String r14, GuiView r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.artifactType;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.artifactSource;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.originMessageId;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.uri;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.view;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.artifactType;
    }

    public final String component2() {
        return this.artifactSource;
    }

    public final String component3() {
        return this.originMessageId;
    }

    public final String component4() {
        return this.uri;
    }

    public final GuiView component5() {
        return this.view;
    }

    public final GuiContext copy(String r10, String r11, String r12, String r13, GuiView r14) {
        return new GuiContext(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof GuiContext) == false) goto L16;
        GuiContext r11 = (GuiContext) r10;
        if (Intrinsics.areEqual(this.artifactType, r11.artifactType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.artifactSource, r11.artifactSource) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originMessageId, r11.originMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r11.uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.view, r11.view) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.artifactType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.artifactSource;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.originMessageId;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.uri;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        GuiView r21 = this.view;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "GuiContext(artifactType=" + this.artifactType + ", artifactSource=" + this.artifactSource + ", originMessageId=" + this.originMessageId + ", uri=" + this.uri + ", view=" + this.view + ")";
    }

    public final String getArtifactSource() {
        return this.artifactSource;
    }

    public final String getArtifactType() {
        return this.artifactType;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final GuiView getView() {
        return this.view;
    }

    public GuiContext(String r1, String r10, String r11, String r12, GuiView r13) {
        this.artifactType = r1;
        this.artifactSource = r10;
        this.originMessageId = r11;
        this.uri = r12;
        this.view = r13;
    }

    public /* synthetic */ GuiContext(String r10, String r11, String r12, String r13, GuiView r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r18 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        GuiView r110 = null;
    L22:
        this(r17, r1, r18, r19, r110);
        return;
    L21:
        r110 = r14;
        goto L22
    L17:
        r19 = r13;
        goto L19
    L13:
        r18 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}

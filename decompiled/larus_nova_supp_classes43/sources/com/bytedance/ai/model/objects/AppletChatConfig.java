package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/model/objects/AppletChatConfig;", "", "features", "Lcom/bytedance/ai/model/objects/AppletChatFeatures;", "inputHint", "", "speakHint", "<init>", "(Lcom/bytedance/ai/model/objects/AppletChatFeatures;Ljava/lang/String;Ljava/lang/String;)V", "getFeatures", "()Lcom/bytedance/ai/model/objects/AppletChatFeatures;", "getInputHint", "()Ljava/lang/String;", "getSpeakHint", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletChatConfig {
    private final AppletChatFeatures features;
    private final String inputHint;
    private final String speakHint;

    public AppletChatConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AppletChatConfig copy$default(AppletChatConfig r0, AppletChatFeatures r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.features;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.inputHint;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.speakHint;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final AppletChatFeatures component1() {
        return this.features;
    }

    public final String component2() {
        return this.inputHint;
    }

    public final String component3() {
        return this.speakHint;
    }

    public final AppletChatConfig copy(AppletChatFeatures r10, String r11, String r12) {
        return new AppletChatConfig(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppletChatConfig) == true) goto L8;
        return false;
    L8:
        AppletChatConfig r11 = (AppletChatConfig) r10;
        if (Intrinsics.areEqual(this.features, r11.features) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputHint, r11.inputHint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.speakHint, r11.speakHint) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        AppletChatFeatures r0 = this.features;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.inputHint;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.speakHint;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletChatConfig(features=" + this.features + ", inputHint=" + this.inputHint + ", speakHint=" + this.speakHint + ')';
    }

    public final AppletChatFeatures getFeatures() {
        return this.features;
    }

    public final String getInputHint() {
        return this.inputHint;
    }

    public final String getSpeakHint() {
        return this.speakHint;
    }

    public AppletChatConfig(AppletChatFeatures r1, String r10, String r11) {
        this.features = r1;
        this.inputHint = r10;
        this.speakHint = r11;
    }

    public /* synthetic */ AppletChatConfig(AppletChatFeatures r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}

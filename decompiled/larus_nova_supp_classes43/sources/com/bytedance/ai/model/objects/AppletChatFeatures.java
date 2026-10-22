package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/model/objects/AppletChatFeatures;", "", "camera", "Lcom/bytedance/ai/model/objects/AppletChatFeature;", "extraActions", "<init>", "(Lcom/bytedance/ai/model/objects/AppletChatFeature;Lcom/bytedance/ai/model/objects/AppletChatFeature;)V", "getCamera", "()Lcom/bytedance/ai/model/objects/AppletChatFeature;", "getExtraActions", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletChatFeatures {
    private final AppletChatFeature camera;
    private final AppletChatFeature extraActions;

    public AppletChatFeatures() {
        AppletChatFeature r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ AppletChatFeatures copy$default(AppletChatFeatures r0, AppletChatFeature r1, AppletChatFeature r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.camera;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.extraActions;
    L9:
        return r0.copy(r1, r10);
    }

    public final AppletChatFeature component1() {
        return this.camera;
    }

    public final AppletChatFeature component2() {
        return this.extraActions;
    }

    public final AppletChatFeatures copy(AppletChatFeature r10, AppletChatFeature r11) {
        return new AppletChatFeatures(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppletChatFeatures) == true) goto L8;
        return false;
    L8:
        AppletChatFeatures r11 = (AppletChatFeatures) r10;
        if (Intrinsics.areEqual(this.camera, r11.camera) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraActions, r11.extraActions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AppletChatFeature r0 = this.camera;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        AppletChatFeature r12 = this.extraActions;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletChatFeatures(camera=" + this.camera + ", extraActions=" + this.extraActions + ')';
    }

    public final AppletChatFeature getCamera() {
        return this.camera;
    }

    public final AppletChatFeature getExtraActions() {
        return this.extraActions;
    }

    public AppletChatFeatures(AppletChatFeature r1, AppletChatFeature r10) {
        this.camera = r1;
        this.extraActions = r10;
    }

    public /* synthetic */ AppletChatFeatures(AppletChatFeature r10, AppletChatFeature r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}

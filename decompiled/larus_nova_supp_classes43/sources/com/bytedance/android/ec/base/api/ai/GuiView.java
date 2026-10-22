package com.bytedance.android.ec.base.api.ai;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/GuiView;", "", "bizPayload", "", "(Ljava/lang/String;)V", "getBizPayload", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class GuiView {

    @SerializedName("payload")
    private final String bizPayload;

    public GuiView() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ GuiView copy$default(GuiView r0, String r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = r0.bizPayload;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.bizPayload;
    }

    public final GuiView copy(String r10) {
        return new GuiView(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof GuiView) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.bizPayload, ((GuiView) r10).bizPayload) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.bizPayload;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "GuiView(bizPayload=" + this.bizPayload + ")";
    }

    public final String getBizPayload() {
        return this.bizPayload;
    }

    public GuiView(String r1) {
        this.bizPayload = r1;
    }

    public /* synthetic */ GuiView(String r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}

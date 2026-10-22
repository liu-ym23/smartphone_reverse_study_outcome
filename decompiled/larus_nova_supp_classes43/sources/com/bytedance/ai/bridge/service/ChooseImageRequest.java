package com.bytedance.ai.bridge.service;

import e3.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/service/ChooseImageRequest;", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "bridgeName", "", "count", "", "sizeType", "", "sourceType", "<init>", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getBridgeContext", "()Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "getBridgeName", "()Ljava/lang/String;", "getCount", "()I", "getSizeType", "()Ljava/util/List;", "getSourceType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseImageRequest {
    private final d bridgeContext;
    private final String bridgeName;
    private final int count;
    private final List<String> sizeType;
    private final List<String> sourceType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChooseImageRequest copy$default(ChooseImageRequest r10, d r11, String r12, int r13, List r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.bridgeContext;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.bridgeName;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.count;
    L11:
        int r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.sizeType;
    L14:
        List r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.sourceType;
    L17:
        d r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final d component1() {
        return this.bridgeContext;
    }

    public final String component2() {
        return this.bridgeName;
    }

    public final int component3() {
        return this.count;
    }

    public final List<String> component4() {
        return this.sizeType;
    }

    public final List<String> component5() {
        return this.sourceType;
    }

    public final ChooseImageRequest copy(d r10, String r11, int r12, List<String> r13, List<String> r14) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r13, "sizeType");
        Intrinsics.checkNotNullParameter(r14, "sourceType");
        return new ChooseImageRequest(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ChooseImageRequest) == true) goto L8;
        return false;
    L8:
        ChooseImageRequest r11 = (ChooseImageRequest) r10;
        if (Intrinsics.areEqual(this.bridgeContext, r11.bridgeContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bridgeName, r11.bridgeName) == true) goto L15;
        return false;
    L15:
        if (this.count == r11.count) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sizeType, r11.sizeType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceType, r11.sourceType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.bridgeContext.hashCode() * 31) + this.bridgeName.hashCode()) * 31) + this.count) * 31) + this.sizeType.hashCode()) * 31) + this.sourceType.hashCode();
    }

    public String toString() {
        return "ChooseImageRequest(bridgeContext=" + this.bridgeContext + ", bridgeName=" + this.bridgeName + ", count=" + this.count + ", sizeType=" + this.sizeType + ", sourceType=" + this.sourceType + ')';
    }

    public final d getBridgeContext() {
        return this.bridgeContext;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final int getCount() {
        return this.count;
    }

    public final List<String> getSizeType() {
        return this.sizeType;
    }

    public final List<String> getSourceType() {
        return this.sourceType;
    }

    public ChooseImageRequest(d r10, String r11, int r12, List<String> r13, List<String> r14) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r13, "sizeType");
        Intrinsics.checkNotNullParameter(r14, "sourceType");
        this.bridgeContext = r10;
        this.bridgeName = r11;
        this.count = r12;
        this.sizeType = r13;
        this.sourceType = r14;
    }
}

package com.larus.common.venue.impl.venue.component;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003Jk\u0010!\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/LynxPageData;", "", "pocketPageData", "", "", "inputTopToBottomHeight", "", "clickActionBarTimeMs", "", "schemaHandleTimeMs", "traceInfo", "sourceSchema", "stage", "<init>", "(Ljava/util/Map;IJJLjava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getPocketPageData", "()Ljava/util/Map;", "getInputTopToBottomHeight", "()I", "getClickActionBarTimeMs", "()J", "getSchemaHandleTimeMs", "getTraceInfo", "getSourceSchema", "()Ljava/lang/String;", "getStage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxPageData {
    private final long clickActionBarTimeMs;
    private final int inputTopToBottomHeight;
    private final Map<String, Object> pocketPageData;
    private final long schemaHandleTimeMs;
    private final String sourceSchema;
    private final String stage;
    private final Map<String, Object> traceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxPageData copy$default(LynxPageData r10, Map r11, int r12, long r13, long r15, Map r17, String r18, String r110, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Map r1 = r10.pocketPageData;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r2 = r10.inputTopToBottomHeight;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r3 = r10.clickActionBarTimeMs;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.schemaHandleTimeMs;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Map r7 = r10.traceInfo;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = r10.sourceSchema;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.stage;
    L31:
        return r10.copy(r1, r2, r3, r5, r7, r8, r9);
    L29:
        r9 = r110;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final Map<String, Object> component1() {
        return this.pocketPageData;
    }

    public final int component2() {
        return this.inputTopToBottomHeight;
    }

    public final long component3() {
        return this.clickActionBarTimeMs;
    }

    public final long component4() {
        return this.schemaHandleTimeMs;
    }

    public final Map<String, Object> component5() {
        return this.traceInfo;
    }

    public final String component6() {
        return this.sourceSchema;
    }

    public final String component7() {
        return this.stage;
    }

    public final LynxPageData copy(Map<String, ? extends Object> r12, int r13, long r14, long r16, Map<String, ? extends Object> r18, String r110, String r20) {
        Intrinsics.checkNotNullParameter(r12, "pocketPageData");
        Intrinsics.checkNotNullParameter(r18, "traceInfo");
        Intrinsics.checkNotNullParameter(r110, "sourceSchema");
        Intrinsics.checkNotNullParameter(r20, "stage");
        return new LynxPageData(r12, r13, r14, r16, r18, r110, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LynxPageData) == true) goto L8;
        return false;
    L8:
        LynxPageData r9 = (LynxPageData) r8;
        if (Intrinsics.areEqual(this.pocketPageData, r9.pocketPageData) == true) goto L12;
        return false;
    L12:
        if (this.inputTopToBottomHeight == r9.inputTopToBottomHeight) goto L15;
        return false;
    L15:
        if (this.clickActionBarTimeMs == r9.clickActionBarTimeMs) goto L18;
        return false;
    L18:
        if (this.schemaHandleTimeMs == r9.schemaHandleTimeMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceInfo, r9.traceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourceSchema, r9.sourceSchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.stage, r9.stage) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.pocketPageData.hashCode() * 31) + this.inputTopToBottomHeight) * 31;
        long r1 = this.clickActionBarTimeMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.schemaHandleTimeMs;
        return ((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.traceInfo.hashCode()) * 31) + this.sourceSchema.hashCode()) * 31) + this.stage.hashCode();
    }

    public String toString() {
        return "LynxPageData(pocketPageData=" + this.pocketPageData + ", inputTopToBottomHeight=" + this.inputTopToBottomHeight + ", clickActionBarTimeMs=" + this.clickActionBarTimeMs + ", schemaHandleTimeMs=" + this.schemaHandleTimeMs + ", traceInfo=" + this.traceInfo + ", sourceSchema=" + this.sourceSchema + ", stage=" + this.stage + ')';
    }

    public final long getClickActionBarTimeMs() {
        return this.clickActionBarTimeMs;
    }

    public final int getInputTopToBottomHeight() {
        return this.inputTopToBottomHeight;
    }

    public final Map<String, Object> getPocketPageData() {
        return this.pocketPageData;
    }

    public final long getSchemaHandleTimeMs() {
        return this.schemaHandleTimeMs;
    }

    public final String getSourceSchema() {
        return this.sourceSchema;
    }

    public final String getStage() {
        return this.stage;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public LynxPageData(Map<String, ? extends Object> r2, int r3, long r4, long r6, Map<String, ? extends Object> r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "pocketPageData");
        Intrinsics.checkNotNullParameter(r8, "traceInfo");
        Intrinsics.checkNotNullParameter(r9, "sourceSchema");
        Intrinsics.checkNotNullParameter(r10, "stage");
        this.pocketPageData = r2;
        this.inputTopToBottomHeight = r3;
        this.clickActionBarTimeMs = r4;
        this.schemaHandleTimeMs = r6;
        this.traceInfo = r8;
        this.sourceSchema = r9;
        this.stage = r10;
    }

    public /* synthetic */ LynxPageData(Map r12, int r13, long r14, long r16, Map r18, String r110, String r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        Map r2 = MapsKt.emptyMap();
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r21 & 4) == 0) goto L13;
        long r6 = 0;
    L15:
        if ((r21 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r21 & 16) == 0) goto L21;
        Map r0 = MapsKt.emptyMap();
    L22:
        this(r2, r3, r6, r8, r0, r110, r20);
        return;
    L21:
        r0 = r18;
        goto L22
    L17:
        r8 = r16;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }
}

package com.obric.memorydata.personalcontext.api;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/AIKModelRequest;", "", "biz_name", "", Params.PROMPT, "sync", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBiz_name", "()Ljava/lang/String;", "getPrompt", "getSync", "()Z", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIKModelRequest {
    private final String biz_name;
    private final String prompt;
    private final boolean sync;
    private final String version;

    public AIKModelRequest(String r2, String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "biz_name");
        Intrinsics.checkNotNullParameter(r3, Params.PROMPT);
        Intrinsics.checkNotNullParameter(r5, "version");
        this.biz_name = r2;
        this.prompt = r3;
        this.sync = r4;
        this.version = r5;
    }

    public /* synthetic */ AIKModelRequest(String r1, String r2, boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = "1.0";
    L8:
        this(r1, r2, r3, r4);
    }

    public static /* synthetic */ AIKModelRequest copy$default(AIKModelRequest r0, String r1, String r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.biz_name;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.prompt;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sync;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.version;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.biz_name;
    }

    public final String component2() {
        return this.prompt;
    }

    public final boolean component3() {
        return this.sync;
    }

    public final String component4() {
        return this.version;
    }

    public final AIKModelRequest copy(String r1, String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "biz_name");
        Intrinsics.checkNotNullParameter(r2, Params.PROMPT);
        Intrinsics.checkNotNullParameter(r4, "version");
        return new AIKModelRequest(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AIKModelRequest.class) == true) goto L8;
        return false;
    L8:
        AIKModelRequest r6 = (AIKModelRequest) ZeusTransformUtils.preCheckCast(r5, AIKModelRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.biz_name, r6.biz_name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L15;
        return false;
    L15:
        if (this.sync == r6.sync) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getBiz_name() {
        return this.biz_name;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final boolean getSync() {
        return this.sync;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.biz_name.hashCode() * 31) + this.prompt.hashCode()) * 31) + Boolean.hashCode(this.sync)) * 31) + this.version.hashCode();
    }

    public String toString() {
        return "AIKModelRequest(biz_name=" + this.biz_name + ", prompt=" + this.prompt + ", sync=" + this.sync + ", version=" + this.version + ')';
    }
}

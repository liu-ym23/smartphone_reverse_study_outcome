package com.larus.platform.model.action;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/action/RedirectionCfg;", "Ljava/io/Serializable;", "redirectionType", "", "redirectionTarget", "", "instructionConfig", "Lcom/larus/platform/model/action/InstructionConfig;", "<init>", "(ILjava/lang/String;Lcom/larus/platform/model/action/InstructionConfig;)V", "getRedirectionType", "()I", "getRedirectionTarget", "()Ljava/lang/String;", "getInstructionConfig", "()Lcom/larus/platform/model/action/InstructionConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RedirectionCfg implements Serializable {

    @SerializedName("instruction_config")
    private final InstructionConfig instructionConfig;

    @SerializedName("redirection_target")
    private final String redirectionTarget;

    @SerializedName("redirection_target_type")
    private final int redirectionType;

    public RedirectionCfg() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ RedirectionCfg copy$default(RedirectionCfg r0, int r1, String r2, InstructionConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.redirectionType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.redirectionTarget;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.instructionConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.redirectionType;
    }

    public final String component2() {
        return this.redirectionTarget;
    }

    public final InstructionConfig component3() {
        return this.instructionConfig;
    }

    public final RedirectionCfg copy(int r2, String r3, InstructionConfig r4) {
        return new RedirectionCfg(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RedirectionCfg) == true) goto L8;
        return false;
    L8:
        RedirectionCfg r6 = (RedirectionCfg) r5;
        if (this.redirectionType == r6.redirectionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.redirectionTarget, r6.redirectionTarget) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instructionConfig, r6.instructionConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.redirectionType * 31;
        String r1 = this.redirectionTarget;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        InstructionConfig r5 = this.instructionConfig;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RedirectionCfg(redirectionType=" + this.redirectionType + ", redirectionTarget=" + this.redirectionTarget + ", instructionConfig=" + this.instructionConfig + ')';
    }

    public final InstructionConfig getInstructionConfig() {
        return this.instructionConfig;
    }

    public final String getRedirectionTarget() {
        return this.redirectionTarget;
    }

    public final int getRedirectionType() {
        return this.redirectionType;
    }

    public RedirectionCfg(int r1, String r2, InstructionConfig r3) {
        this.redirectionType = r1;
        this.redirectionTarget = r2;
        this.instructionConfig = r3;
    }

    public /* synthetic */ RedirectionCfg(int r2, String r3, InstructionConfig r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}

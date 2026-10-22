package com.larus.platform.model.action;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/action/PromptReplacementCfg;", "Ljava/io/Serializable;", "replacementKey", "", "msgExt", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getReplacementKey", "()Ljava/lang/String;", "getMsgExt", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PromptReplacementCfg implements Serializable {

    @SerializedName("msg_ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> msgExt;

    @SerializedName("replacement_key")
    private final String replacementKey;

    /* JADX WARN: Multi-variable type inference failed */
    public PromptReplacementCfg() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromptReplacementCfg copy$default(PromptReplacementCfg r0, String r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.replacementKey;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.msgExt;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.replacementKey;
    }

    public final Map<String, String> component2() {
        return this.msgExt;
    }

    public final PromptReplacementCfg copy(String r2, Map<String, String> r3) {
        return new PromptReplacementCfg(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PromptReplacementCfg) == true) goto L8;
        return false;
    L8:
        PromptReplacementCfg r6 = (PromptReplacementCfg) r5;
        if (Intrinsics.areEqual(this.replacementKey, r6.replacementKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgExt, r6.msgExt) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.replacementKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.msgExt;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PromptReplacementCfg(replacementKey=" + this.replacementKey + ", msgExt=" + this.msgExt + ')';
    }

    public final Map<String, String> getMsgExt() {
        return this.msgExt;
    }

    public final String getReplacementKey() {
        return this.replacementKey;
    }

    public PromptReplacementCfg(String r1, Map<String, String> r2) {
        this.replacementKey = r1;
        this.msgExt = r2;
    }

    public /* synthetic */ PromptReplacementCfg(String r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new LinkedHashMap();
    L8:
        this(r1, r2);
    }
}

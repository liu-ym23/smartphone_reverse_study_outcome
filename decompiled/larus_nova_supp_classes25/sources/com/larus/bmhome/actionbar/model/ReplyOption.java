package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0001\u001dB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ReplyOption;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "model", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "modeId", "", "reasoningEffort", "", "<init>", "(Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;Ljava/lang/String;Ljava/lang/Integer;)V", "getModel", "()Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getModeId", "()Ljava/lang/String;", "getReasoningEffort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "copy", "(Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/actionbar/model/ReplyOption;", "toString", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ReplyOption implements Serializable {
    public static final a Companion = null;
    private final String modeId;
    private final ModelItemIdentity model;
    private final Integer reasoningEffort;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReplyOption copy$default(ReplyOption r0, ModelItemIdentity r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.model;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.modeId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.reasoningEffort;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ModelItemIdentity component1() {
        return this.model;
    }

    public final String component2() {
        return this.modeId;
    }

    public final Integer component3() {
        return this.reasoningEffort;
    }

    public final ReplyOption copy(ModelItemIdentity r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        return new ReplyOption(r2, r3, r4);
    }

    public String toString() {
        return "ReplyOption(model=" + this.model + ", modeId=" + this.modeId + ", reasoningEffort=" + this.reasoningEffort + ')';
    }

    public int hashCode() {
        String r0 = this.model.getKey();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.modeId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.reasoningEffort;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String getModeId() {
        return this.modeId;
    }

    public final ModelItemIdentity getModel() {
        return this.model;
    }

    public final Integer getReasoningEffort() {
        return this.reasoningEffort;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof ReplyOption) == true) goto L11;
        return false;
    L11:
        ReplyOption r6 = (ReplyOption) r5;
        if (Intrinsics.areEqual(this.model.getKey(), r6.model.getKey()) == true) goto L14;
    L18:
        return false;
    L14:
        if (Intrinsics.areEqual(this.modeId, r6.modeId) == false) goto L18;
        if (Intrinsics.areEqual(this.reasoningEffort, r6.reasoningEffort) == false) goto L18;
        return true;
    }

    public ReplyOption(ModelItemIdentity r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.model = r2;
        this.modeId = r3;
        this.reasoningEffort = r4;
    }
}

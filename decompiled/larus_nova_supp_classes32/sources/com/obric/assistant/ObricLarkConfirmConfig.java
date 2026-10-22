package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ObricLarkConfirmConfig;", NameKeys.UnloadStrategy_No_Strategy, "obricLarkConfirm", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(I)V", "getObricLarkConfirm", "()I", "component1", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLarkConfirmConfig {

    @SerializedName("obric_lark_confirm")
    private final int obricLarkConfirm;

    public ObricLarkConfirmConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ ObricLarkConfirmConfig copy$default(ObricLarkConfirmConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.obricLarkConfirm;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.obricLarkConfirm;
    }

    public final ObricLarkConfirmConfig copy(int r2) {
        return new ObricLarkConfirmConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricLarkConfirmConfig) == true) goto L9;
        return false;
    L9:
        if (this.obricLarkConfirm == ((ObricLarkConfirmConfig) r4).obricLarkConfirm) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.obricLarkConfirm;
    }

    public String toString() {
        return "ObricLarkConfirmConfig(obricLarkConfirm=" + this.obricLarkConfirm + ')';
    }

    public final int getObricLarkConfirm() {
        return this.obricLarkConfirm;
    }

    public ObricLarkConfirmConfig(int r1) {
        this.obricLarkConfirm = r1;
    }

    public /* synthetic */ ObricLarkConfirmConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }
}

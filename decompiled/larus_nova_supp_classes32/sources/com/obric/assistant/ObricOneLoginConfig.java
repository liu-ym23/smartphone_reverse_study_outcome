package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ObricOneLoginConfig;", NameKeys.UnloadStrategy_No_Strategy, "enableSafeOneLogin", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Z)V", "getEnableSafeOneLogin", "()Z", "component1", "copy", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginConfig {

    @SerializedName("enable_safe_one_login")
    private final boolean enableSafeOneLogin;

    public ObricOneLoginConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ ObricOneLoginConfig copy$default(ObricOneLoginConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.enableSafeOneLogin;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.enableSafeOneLogin;
    }

    public final ObricOneLoginConfig copy(boolean r2) {
        return new ObricOneLoginConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ObricOneLoginConfig) == true) goto L9;
        return false;
    L9:
        if (this.enableSafeOneLogin == ((ObricOneLoginConfig) r4).enableSafeOneLogin) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.enableSafeOneLogin == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "ObricOneLoginConfig(enableSafeOneLogin=" + this.enableSafeOneLogin + ')';
    }

    public final boolean getEnableSafeOneLogin() {
        return this.enableSafeOneLogin;
    }

    public ObricOneLoginConfig(boolean r1) {
        this.enableSafeOneLogin = r1;
    }

    public /* synthetic */ ObricOneLoginConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}

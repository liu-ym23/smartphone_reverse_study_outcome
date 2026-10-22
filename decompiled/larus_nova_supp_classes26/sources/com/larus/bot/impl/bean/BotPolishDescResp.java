package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bot/impl/bean/BotPolishDescResp;", "", "desc", "", "useInternet", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getUseInternet", "()Ljava/lang/Boolean;", "setUseInternet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bot/impl/bean/BotPolishDescResp;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotPolishDescResp {

    @SerializedName("desc")
    private String desc;

    @SerializedName("use_internet")
    private Boolean useInternet;

    /* JADX WARN: Multi-variable type inference failed */
    public BotPolishDescResp() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BotPolishDescResp copy$default(BotPolishDescResp r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.desc;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.useInternet;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.desc;
    }

    public final Boolean component2() {
        return this.useInternet;
    }

    public final BotPolishDescResp copy(String r2, Boolean r3) {
        return new BotPolishDescResp(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotPolishDescResp) == true) goto L8;
        return false;
    L8:
        BotPolishDescResp r6 = (BotPolishDescResp) r5;
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.useInternet, r6.useInternet) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.desc;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.useInternet;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BotPolishDescResp(desc=" + this.desc + ", useInternet=" + this.useInternet + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Boolean getUseInternet() {
        return this.useInternet;
    }

    public final void setDesc(String r1) {
        this.desc = r1;
    }

    public final void setUseInternet(Boolean r1) {
        this.useInternet = r1;
    }

    public BotPolishDescResp(String r1, Boolean r2) {
        this.desc = r1;
        this.useInternet = r2;
    }

    public /* synthetic */ BotPolishDescResp(String r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}

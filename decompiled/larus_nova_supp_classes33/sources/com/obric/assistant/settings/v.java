package com.obric.assistant.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005HÆ\u0003JV\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "", "mode", "", "softBlacklist", "", "Lcom/obric/assistant/settings/ObricAppBlacklistItem;", "hardBlacklist", "whitelist", "Lcom/obric/assistant/settings/ObricAppWhitelistItem;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSoftBlacklist", "()Ljava/util/List;", "getHardBlacklist", "getWhitelist", "resolvedMode", "Lcom/obric/assistant/settings/ObricAppListMode;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/obric/assistant/settings/ObricGetAppBlacklistResponse;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class v {

    @SerializedName("hard_blacklist")
    private final List<r> hardBlacklist;

    @SerializedName("mode")
    private final Integer mode;

    @SerializedName("soft_blacklist")
    private final List<r> softBlacklist;

    @SerializedName("whitelist")
    private final List<s> whitelist;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.softBlacklist, r6.softBlacklist) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hardBlacklist, r6.hardBlacklist) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.whitelist, r6.whitelist) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.mode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<r> r4 = this.softBlacklist;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<r> r7 = this.hardBlacklist;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<s> r10 = this.whitelist;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricGetAppBlacklistResponse(mode=" + this.mode + ", softBlacklist=" + this.softBlacklist + ", hardBlacklist=" + this.hardBlacklist + ", whitelist=" + this.whitelist + ')';
    }

    public final ObricAppListMode c() {
        ObricAppListMode.a r0 = ObricAppListMode.Companion;
        Integer r1 = this.mode;
        r0.getClass();
        ObricAppListMode r2 = ObricAppListMode.WHITE_LIST;
        int r3 = r2.getValue();
        if (r1 == null) goto L9;
        if (r1.intValue() != r3) goto L9;
        return r2;
    L9:
        return ObricAppListMode.BLACK_LIST;
    }

    public v() {
        this.mode = null;
        this.softBlacklist = null;
        this.hardBlacklist = null;
        this.whitelist = null;
    }

    public final List<r> a() {
        return this.softBlacklist;
    }

    public final List<s> b() {
        return this.whitelist;
    }
}

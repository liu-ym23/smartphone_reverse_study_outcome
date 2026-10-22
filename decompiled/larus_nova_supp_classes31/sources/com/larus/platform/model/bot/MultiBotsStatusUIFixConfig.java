package com.larus.platform.model.bot;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/bot/MultiBotsStatusUIFixConfig;", "", "enabled", "", "serviceBotLinkAllowlist", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getServiceBotLinkAllowlist", "()Ljava/util/List;", "isEnabled", "()Z", "isServiceBotLinkAllowed", "botId", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/model/bot/MultiBotsStatusUIFixConfig;", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiBotsStatusUIFixConfig {
    public static final a Companion = null;
    private static final List<String> DEFAULT_SERVICE_BOT_LINK_ALLOWLIST = null;

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("service_bot_link_allowlist")
    private final List<String> serviceBotLinkAllowlist;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiBotsStatusUIFixConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiBotsStatusUIFixConfig copy$default(MultiBotsStatusUIFixConfig r0, Boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enabled;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.serviceBotLinkAllowlist;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.enabled;
    }

    public final List<String> component2() {
        return this.serviceBotLinkAllowlist;
    }

    public final MultiBotsStatusUIFixConfig copy(Boolean r2, List<String> r3) {
        return new MultiBotsStatusUIFixConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultiBotsStatusUIFixConfig) == true) goto L8;
        return false;
    L8:
        MultiBotsStatusUIFixConfig r6 = (MultiBotsStatusUIFixConfig) r5;
        if (Intrinsics.areEqual(this.enabled, r6.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serviceBotLinkAllowlist, r6.serviceBotLinkAllowlist) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enabled;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.serviceBotLinkAllowlist;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MultiBotsStatusUIFixConfig(enabled=" + this.enabled + ", serviceBotLinkAllowlist=" + this.serviceBotLinkAllowlist + ')';
    }

    static {
        Companion = new a();
        DEFAULT_SERVICE_BOT_LINK_ALLOWLIST = CollectionsKt.listOf(new String[]{"7626957768951480347", "7612964097608597538"});
    }

    public final boolean isEnabled() {
        Boolean r0 = this.enabled;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getServiceBotLinkAllowlist() {
        return this.serviceBotLinkAllowlist;
    }

    public final boolean isServiceBotLinkAllowed(String r5) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        if (r5 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L32;
        List<String> r3 = this.serviceBotLinkAllowlist;
        if (r3 != null) goto L16;
        r3 = DEFAULT_SERVICE_BOT_LINK_ALLOWLIST;
    L16:
        List<String> r4 = r3;
        if ((r4 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r6 = r4.iterator();
    L23:
        if (r6.hasNext() == false) goto L34;
        if (Intrinsics.areEqual((String) r6.next(), r5) == false) goto L23;
        return true;
    L34:
        return false;
    L19:
        if (r4.isEmpty() == false) goto L21;
        return false;
    L32:
        return false;
    L7:
        if (StringsKt.isBlank(r5) == true) goto L10;
        r2 = false;
        goto L11
    }

    public MultiBotsStatusUIFixConfig(Boolean r1, List<String> r2) {
        this.enabled = r1;
        this.serviceBotLinkAllowlist = r2;
    }

    public /* synthetic */ MultiBotsStatusUIFixConfig(Boolean r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = DEFAULT_SERVICE_BOT_LINK_ALLOWLIST;
    L8:
        this(r1, r2);
    }
}

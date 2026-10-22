package au9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/bot/BotsOptimizeConfig;", "", "enableCreateBotGotoChatOpt", "", "enableEnterBotCreatePageOpt", "botsApiRetryCount", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getEnableCreateBotGotoChatOpt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableEnterBotCreatePageOpt", "getBotsApiRetryCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/settings/provider/bot/BotsOptimizeConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class i {
    public static final i a = null;
    public static final i b = null;

    @SerializedName("bots_api_retry_count")
    private final Integer botsApiRetryCount;

    @SerializedName("enable_create_bot_goto_chat_optimize")
    private final Boolean enableCreateBotGotoChatOpt;

    @SerializedName("enable_enter_bot_create_page_optimize")
    private final Boolean enableEnterBotCreatePageOpt;

    public static final class a {
    }

    public i() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.enableCreateBotGotoChatOpt, r6.enableCreateBotGotoChatOpt) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableEnterBotCreatePageOpt, r6.enableEnterBotCreatePageOpt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botsApiRetryCount, r6.botsApiRetryCount) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enableCreateBotGotoChatOpt;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableEnterBotCreatePageOpt;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.botsApiRetryCount;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotsOptimizeConfig(enableCreateBotGotoChatOpt=" + this.enableCreateBotGotoChatOpt + ", enableEnterBotCreatePageOpt=" + this.enableEnterBotCreatePageOpt + ", botsApiRetryCount=" + this.botsApiRetryCount + ')';
    }

    static {
        Boolean r1 = Boolean.TRUE;
        a = new i(r1, r1, 0);
        b = new i(0);
    }

    public final Integer a() {
        return this.botsApiRetryCount;
    }

    public final Boolean b() {
        return this.enableCreateBotGotoChatOpt;
    }

    public /* synthetic */ i(int r2) {
        Boolean r3 = Boolean.FALSE;
        this(r3, r3, 0);
    }

    public i(Boolean r1, Boolean r2, Integer r3) {
        this.enableCreateBotGotoChatOpt = r1;
        this.enableEnterBotCreatePageOpt = r2;
        this.botsApiRetryCount = r3;
    }
}

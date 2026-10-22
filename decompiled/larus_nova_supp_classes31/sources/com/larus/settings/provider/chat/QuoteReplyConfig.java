package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/chat/QuoteReplyConfig;", "", "group", "", "supportMainBot", "", "supportOfficialBot", "supportUserBot", "<init>", "(IZZZ)V", "getGroup", "()I", "getSupportMainBot", "()Z", "getSupportOfficialBot", "getSupportUserBot", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class QuoteReplyConfig {
    public static final a Companion = null;
    private static final QuoteReplyConfig DEFAULT = null;

    @SerializedName("group")
    private final int group;

    @SerializedName("support_coco_bot")
    private final boolean supportMainBot;

    @SerializedName("support_guanfang_bot")
    private final boolean supportOfficialBot;

    @SerializedName("support_user_bot")
    private final boolean supportUserBot;

    public static final class a {
        public a() {
        }
    }

    public QuoteReplyConfig() {
        this(0, false, false, false, 15, null);
    }

    public static /* synthetic */ QuoteReplyConfig copy$default(QuoteReplyConfig r0, int r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.group;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.supportMainBot;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.supportOfficialBot;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.supportUserBot;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.group;
    }

    public final boolean component2() {
        return this.supportMainBot;
    }

    public final boolean component3() {
        return this.supportOfficialBot;
    }

    public final boolean component4() {
        return this.supportUserBot;
    }

    public final QuoteReplyConfig copy(int r2, boolean r3, boolean r4, boolean r5) {
        return new QuoteReplyConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QuoteReplyConfig) == true) goto L8;
        return false;
    L8:
        QuoteReplyConfig r6 = (QuoteReplyConfig) r5;
        if (this.group == r6.group) goto L12;
        return false;
    L12:
        if (this.supportMainBot == r6.supportMainBot) goto L15;
        return false;
    L15:
        if (this.supportOfficialBot == r6.supportOfficialBot) goto L18;
        return false;
    L18:
        if (this.supportUserBot == r6.supportUserBot) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.group * 31;
        int r2 = 1231;
        if (this.supportMainBot == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.supportOfficialBot == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.supportUserBot == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "QuoteReplyConfig(group=" + this.group + ", supportMainBot=" + this.supportMainBot + ", supportOfficialBot=" + this.supportOfficialBot + ", supportUserBot=" + this.supportUserBot + ')';
    }

    static {
        Companion = new a();
        DEFAULT = new QuoteReplyConfig(2, true, true, true);
    }

    public static final /* synthetic */ QuoteReplyConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final int getGroup() {
        return this.group;
    }

    public final boolean getSupportMainBot() {
        return this.supportMainBot;
    }

    public final boolean getSupportOfficialBot() {
        return this.supportOfficialBot;
    }

    public final boolean getSupportUserBot() {
        return this.supportUserBot;
    }

    public QuoteReplyConfig(int r1, boolean r2, boolean r3, boolean r4) {
        this.group = r1;
        this.supportMainBot = r2;
        this.supportOfficialBot = r3;
        this.supportUserBot = r4;
    }

    public /* synthetic */ QuoteReplyConfig(int r2, boolean r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}

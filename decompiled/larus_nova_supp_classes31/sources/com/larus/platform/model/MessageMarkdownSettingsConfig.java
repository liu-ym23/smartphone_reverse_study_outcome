package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/MessageMarkdownSettingsConfig;", "", "enableUpstreamCellMarkdown", "", "<init>", "(Z)V", "getEnableUpstreamCellMarkdown", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MessageMarkdownSettingsConfig {
    public static final a Companion = null;

    @SerializedName("enable_upstream_cell_markdown")
    private final boolean enableUpstreamCellMarkdown;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MessageMarkdownSettingsConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ MessageMarkdownSettingsConfig copy$default(MessageMarkdownSettingsConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.enableUpstreamCellMarkdown;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.enableUpstreamCellMarkdown;
    }

    public final MessageMarkdownSettingsConfig copy(boolean r2) {
        return new MessageMarkdownSettingsConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MessageMarkdownSettingsConfig) == true) goto L9;
        return false;
    L9:
        if (this.enableUpstreamCellMarkdown == ((MessageMarkdownSettingsConfig) r4).enableUpstreamCellMarkdown) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.enableUpstreamCellMarkdown == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "MessageMarkdownSettingsConfig(enableUpstreamCellMarkdown=" + this.enableUpstreamCellMarkdown + ')';
    }

    public final boolean getEnableUpstreamCellMarkdown() {
        return this.enableUpstreamCellMarkdown;
    }

    public MessageMarkdownSettingsConfig(boolean r1) {
        this.enableUpstreamCellMarkdown = r1;
    }

    public /* synthetic */ MessageMarkdownSettingsConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}

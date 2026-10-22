package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003JO\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/model/SlashMentionConfig;", "", "enableSlash", "", "enableMention", "enableMessageRender", "slashContents", "", "", "mentionContents", "<init>", "(ZZZLjava/util/List;Ljava/util/List;)V", "getEnableSlash", "()Z", "getEnableMention", "getEnableMessageRender", "getSlashContents", "()Ljava/util/List;", "getMentionContents", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlashMentionConfig {
    public static final a Companion = null;
    public static final List<String> DEFAULT_MENTION_CONTENTS = null;
    public static final List<String> DEFAULT_SLASH_CONTENTS = null;
    public static final String MENTION_CONTENT_ADD = "add";
    public static final String MENTION_CONTENT_ATTACHMENT = "attachment";
    public static final String MENTION_CONTENT_CONTACT = "contact";
    public static final String MENTION_CONTENT_CONVERSATION = "conversation";
    public static final String MENTION_CONTENT_DRIVE = "drive";
    public static final String SLASH_CONTENT_PROJECT = "project";
    public static final String SLASH_CONTENT_QUOTA = "quota";
    public static final String SLASH_CONTENT_SKILL = "skill";

    @SerializedName("enable_mention")
    private final boolean enableMention;

    @SerializedName("enable_message_render")
    private final boolean enableMessageRender;

    @SerializedName("enable_slash")
    private final boolean enableSlash;

    @SerializedName("mention_contents")
    private final List<String> mentionContents;

    @SerializedName("slash_contents")
    private final List<String> slashContents;

    public static final class a {
        public a() {
        }
    }

    public SlashMentionConfig() {
        this(false, false, false, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlashMentionConfig copy$default(SlashMentionConfig r3, boolean r4, boolean r5, boolean r6, List r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableSlash;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enableMention;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.enableMessageRender;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.slashContents;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.mentionContents;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.enableSlash;
    }

    public final boolean component2() {
        return this.enableMention;
    }

    public final boolean component3() {
        return this.enableMessageRender;
    }

    public final List<String> component4() {
        return this.slashContents;
    }

    public final List<String> component5() {
        return this.mentionContents;
    }

    public final SlashMentionConfig copy(boolean r8, boolean r9, boolean r10, List<String> r11, List<String> r12) {
        return new SlashMentionConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SlashMentionConfig) == true) goto L8;
        return false;
    L8:
        SlashMentionConfig r6 = (SlashMentionConfig) r5;
        if (this.enableSlash == r6.enableSlash) goto L12;
        return false;
    L12:
        if (this.enableMention == r6.enableMention) goto L15;
        return false;
    L15:
        if (this.enableMessageRender == r6.enableMessageRender) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slashContents, r6.slashContents) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mentionContents, r6.mentionContents) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableSlash == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableMention == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableMessageRender == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        List<String> r6 = this.slashContents;
        int r7 = 0;
        if (r6 != null) goto L17;
        int r8 = 0;
    L18:
        int r9 = (r5 + r8) * 31;
        List<String> r10 = this.mentionContents;
        if (r10 == null) goto L23;
        r7 = r10.hashCode();
    L23:
        return r9 + r7;
    L17:
        r8 = r6.hashCode();
        goto L18
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "SlashMentionConfig(enableSlash=" + this.enableSlash + ", enableMention=" + this.enableMention + ", enableMessageRender=" + this.enableMessageRender + ", slashContents=" + this.slashContents + ", mentionContents=" + this.mentionContents + ')';
    }

    static {
        Companion = new a();
        DEFAULT_SLASH_CONTENTS = CollectionsKt.listOf(new String[]{SLASH_CONTENT_QUOTA, SLASH_CONTENT_PROJECT, SLASH_CONTENT_SKILL});
        DEFAULT_MENTION_CONTENTS = CollectionsKt.listOf(new String[]{MENTION_CONTENT_ADD, MENTION_CONTENT_ATTACHMENT, MENTION_CONTENT_CONTACT, MENTION_CONTENT_DRIVE, MENTION_CONTENT_CONVERSATION});
    }

    public final boolean getEnableMention() {
        return this.enableMention;
    }

    public final boolean getEnableMessageRender() {
        return this.enableMessageRender;
    }

    public final boolean getEnableSlash() {
        return this.enableSlash;
    }

    public final List<String> getMentionContents() {
        return this.mentionContents;
    }

    public final List<String> getSlashContents() {
        return this.slashContents;
    }

    public SlashMentionConfig(boolean r1, boolean r2, boolean r3, List<String> r4, List<String> r5) {
        this.enableSlash = r1;
        this.enableMention = r2;
        this.enableMessageRender = r3;
        this.slashContents = r4;
        this.mentionContents = r5;
    }

    public /* synthetic */ SlashMentionConfig(boolean r4, boolean r5, boolean r6, List r7, List r8, int r9, DefaultConstructorMarker r10) {
        boolean r0 = true;
        if ((r9 & 1) == 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r9 & 2) == 0) goto L9;
        boolean r1 = true;
    L11:
        if ((r9 & 4) != 0) goto L15;
        r0 = r6;
    L15:
        if ((r9 & 8) == 0) goto L17;
        r7 = DEFAULT_SLASH_CONTENTS;
    L17:
        List r2 = r7;
        if ((r9 & 16) == 0) goto L20;
        r8 = DEFAULT_MENTION_CONTENTS;
    L20:
        boolean r12 = r11;
        boolean r13 = r1;
        boolean r14 = r0;
        this(r12, r13, r14, r2, r8);
        return;
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}

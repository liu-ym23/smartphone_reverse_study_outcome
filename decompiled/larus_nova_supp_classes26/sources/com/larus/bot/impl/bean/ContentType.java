package com.larus.bot.impl.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/bean/ContentType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "NAME", "DESC", "PROLOGUE", "SUGGEST", "VOICE_ID", "LANGUAGE", "BOT_CATEGORY", "GENDER", "HEAD_IMG_PROMPT", "BG_IMG_PROMPT", "BIO", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentType extends Enum<ContentType> {
    public static final ContentType BG_IMG_PROMPT = null;
    public static final ContentType BIO = null;
    public static final ContentType BOT_CATEGORY = null;
    public static final a Companion = null;
    public static final ContentType DESC = null;
    public static final ContentType GENDER = null;
    public static final ContentType HEAD_IMG_PROMPT = null;
    public static final ContentType LANGUAGE = null;
    public static final ContentType NAME = null;
    public static final ContentType PROLOGUE = null;
    public static final ContentType SUGGEST = null;
    public static final ContentType UNKNOWN = null;
    public static final ContentType VOICE_ID = null;
    public static final /* synthetic */ ContentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static ContentType a(String r2) {
            ContentType r0 = ContentType.NAME;
            if (Intrinsics.areEqual(r2, r0.getValue()) == true) goto L37;
            ContentType r1 = ContentType.DESC;
            if (Intrinsics.areEqual(r2, r1.getValue()) == true) goto L38;
            ContentType r3 = ContentType.PROLOGUE;
            if (Intrinsics.areEqual(r2, r3.getValue()) == true) goto L39;
            ContentType r4 = ContentType.SUGGEST;
            if (Intrinsics.areEqual(r2, r4.getValue()) == true) goto L40;
            ContentType r5 = ContentType.VOICE_ID;
            if (Intrinsics.areEqual(r2, r5.getValue()) == true) goto L41;
            ContentType r6 = ContentType.LANGUAGE;
            if (Intrinsics.areEqual(r2, r6.getValue()) == true) goto L42;
            ContentType r7 = ContentType.BOT_CATEGORY;
            if (Intrinsics.areEqual(r2, r7.getValue()) == true) goto L43;
            ContentType r8 = ContentType.GENDER;
            if (Intrinsics.areEqual(r2, r8.getValue()) == true) goto L44;
            ContentType r9 = ContentType.HEAD_IMG_PROMPT;
            if (Intrinsics.areEqual(r2, r9.getValue()) == true) goto L45;
            ContentType r10 = ContentType.BG_IMG_PROMPT;
            if (Intrinsics.areEqual(r2, r10.getValue()) == true) goto L46;
            ContentType r11 = ContentType.BIO;
            if (Intrinsics.areEqual(r2, r11.getValue()) == false) goto L36;
            return r11;
        L36:
            return ContentType.UNKNOWN;
        L46:
            return r10;
        L45:
            return r9;
        L44:
            return r8;
        L43:
            return r7;
        L42:
            return r6;
        L41:
            return r5;
        L40:
            return r4;
        L39:
            return r3;
        L38:
            return r1;
        L37:
            return r0;
        }
    }

    public static EnumEntries<ContentType> getEntries() {
        return b;
    }

    static {
        ContentType r0 = new ContentType("UNKNOWN", 0, "");
        UNKNOWN = r0;
        ContentType r1 = new ContentType("NAME", 1, "Name");
        NAME = r1;
        ContentType r3 = new ContentType("DESC", 2, "Desc");
        DESC = r3;
        ContentType r5 = new ContentType("PROLOGUE", 3, "Prologue");
        PROLOGUE = r5;
        ContentType r7 = new ContentType("SUGGEST", 4, "Suggest");
        SUGGEST = r7;
        ContentType r9 = new ContentType("VOICE_ID", 5, "VoiceId");
        VOICE_ID = r9;
        ContentType r11 = new ContentType("LANGUAGE", 6, "Language");
        LANGUAGE = r11;
        ContentType r13 = new ContentType("BOT_CATEGORY", 7, "BotCategory");
        BOT_CATEGORY = r13;
        ContentType r12 = new ContentType("GENDER", 8, "Gender");
        GENDER = r12;
        ContentType r10 = new ContentType("HEAD_IMG_PROMPT", 9, "HeadImgPrompt");
        HEAD_IMG_PROMPT = r10;
        ContentType r8 = new ContentType("BG_IMG_PROMPT", 10, "BgImgPrompt");
        BG_IMG_PROMPT = r8;
        ContentType r6 = new ContentType("BIO", 11, "Bio");
        BIO = r6;
        ContentType[] r4 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static ContentType[] values() {
        return (ContentType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ContentType valueOf(String r1) {
        return (ContentType) r27.a.a(ContentType.class, r1);
    }

    public ContentType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

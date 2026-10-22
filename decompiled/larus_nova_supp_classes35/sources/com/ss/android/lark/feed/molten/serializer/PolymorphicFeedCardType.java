package com.ss.android.lark.feed.molten.serializer;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/PolymorphicFeedCardType;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UI_FEED_CARD", "FEED_PREVIEW", "DOC_FEED_PREVIEW", "CHAT_FEED_PREVIEW", "THREAD_FEED_PREVIEW", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PolymorphicFeedCardType extends Enum<PolymorphicFeedCardType> implements Serializable {
    public static final PolymorphicFeedCardType CHAT_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType DOC_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType THREAD_FEED_PREVIEW = null;
    public static final PolymorphicFeedCardType UI_FEED_CARD = null;
    public static final /* synthetic */ PolymorphicFeedCardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<PolymorphicFeedCardType> getEntries() {
        return b;
    }

    static {
        PolymorphicFeedCardType r0 = new PolymorphicFeedCardType("UI_FEED_CARD", 0, "UIFeedCard");
        UI_FEED_CARD = r0;
        PolymorphicFeedCardType r1 = new PolymorphicFeedCardType("FEED_PREVIEW", 1, "FeedPreview");
        FEED_PREVIEW = r1;
        PolymorphicFeedCardType r2 = new PolymorphicFeedCardType("DOC_FEED_PREVIEW", 2, "DocFeedPreview");
        DOC_FEED_PREVIEW = r2;
        PolymorphicFeedCardType r4 = new PolymorphicFeedCardType("CHAT_FEED_PREVIEW", 3, "ChatFeedPreview");
        CHAT_FEED_PREVIEW = r4;
        PolymorphicFeedCardType r6 = new PolymorphicFeedCardType("THREAD_FEED_PREVIEW", 4, "ThreadFeedPreview");
        THREAD_FEED_PREVIEW = r6;
        PolymorphicFeedCardType[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static PolymorphicFeedCardType[] values() {
        return (PolymorphicFeedCardType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PolymorphicFeedCardType valueOf(String r1) {
        return (PolymorphicFeedCardType) r27.a.a(PolymorphicFeedCardType.class, r1);
    }

    public PolymorphicFeedCardType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

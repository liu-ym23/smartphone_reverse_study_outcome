package com.larus.podcast.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/podcast/api/PodcastClickSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DeepResearch", "MessagePanelLongPress", "SuggestPrompt", "Doc", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum PodcastClickSource extends Enum<PodcastClickSource> {
    public static final PodcastClickSource DeepResearch = null;
    public static final PodcastClickSource Doc = null;
    public static final PodcastClickSource MessagePanelLongPress = null;
    public static final PodcastClickSource SuggestPrompt = null;
    public static final /* synthetic */ PodcastClickSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<PodcastClickSource> getEntries() {
        return b;
    }

    static {
        PodcastClickSource r0 = new PodcastClickSource("DeepResearch", 0, 0);
        DeepResearch = r0;
        PodcastClickSource r1 = new PodcastClickSource("MessagePanelLongPress", 1, 1);
        MessagePanelLongPress = r1;
        PodcastClickSource r3 = new PodcastClickSource("SuggestPrompt", 2, 2);
        SuggestPrompt = r3;
        PodcastClickSource r5 = new PodcastClickSource("Doc", 3, 3);
        Doc = r5;
        PodcastClickSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PodcastClickSource[] values() {
        return (PodcastClickSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PodcastClickSource valueOf(String r1) {
        return (PodcastClickSource) r27.a.a(PodcastClickSource.class, r1);
    }

    public PodcastClickSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

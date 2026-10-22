package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/api/InnerVideoPreloadScene;", "", "sceneValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneValue", "()Ljava/lang/String;", "Unknown", "SearchList", "RelatedVideo", "ChatFirstCard", "WCBFirstCard", "ChatFeed", "WCBFeed", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum InnerVideoPreloadScene extends Enum<InnerVideoPreloadScene> {
    public static final InnerVideoPreloadScene ChatFeed = null;
    public static final InnerVideoPreloadScene ChatFirstCard = null;
    public static final InnerVideoPreloadScene RelatedVideo = null;
    public static final InnerVideoPreloadScene SearchList = null;
    public static final InnerVideoPreloadScene Unknown = null;
    public static final InnerVideoPreloadScene WCBFeed = null;
    public static final InnerVideoPreloadScene WCBFirstCard = null;
    public static final /* synthetic */ InnerVideoPreloadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String sceneValue;

    public static EnumEntries<InnerVideoPreloadScene> getEntries() {
        return b;
    }

    static {
        InnerVideoPreloadScene r0 = new InnerVideoPreloadScene("Unknown", 0, "unknown");
        Unknown = r0;
        InnerVideoPreloadScene r1 = new InnerVideoPreloadScene("SearchList", 1, "search_list");
        SearchList = r1;
        InnerVideoPreloadScene r2 = new InnerVideoPreloadScene("RelatedVideo", 2, "related_video");
        RelatedVideo = r2;
        InnerVideoPreloadScene r4 = new InnerVideoPreloadScene("ChatFirstCard", 3, "chat_first_card");
        ChatFirstCard = r4;
        InnerVideoPreloadScene r6 = new InnerVideoPreloadScene("WCBFirstCard", 4, "wcb_first_card");
        WCBFirstCard = r6;
        InnerVideoPreloadScene r8 = new InnerVideoPreloadScene("ChatFeed", 5, "chat_feed");
        ChatFeed = r8;
        InnerVideoPreloadScene r10 = new InnerVideoPreloadScene("WCBFeed", 6, "wcb_feed");
        WCBFeed = r10;
        InnerVideoPreloadScene[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static InnerVideoPreloadScene[] values() {
        return (InnerVideoPreloadScene[]) a.clone();
    }

    public final String getSceneValue() {
        return this.sceneValue;
    }

    public static InnerVideoPreloadScene valueOf(String r1) {
        return (InnerVideoPreloadScene) r27.a.a(InnerVideoPreloadScene.class, r1);
    }

    public InnerVideoPreloadScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.sceneValue = r3;
    }
}

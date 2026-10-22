package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/video/SortScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Undefined", "InnerStream", "MessageListTab", "MessageListPull", "ConversationList", "DiscoveryTab", "WelcomeBack", "PreFetch", "Recommend", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortScene extends Enum<SortScene> {
    public static final a Companion = null;
    public static final SortScene ConversationList = null;
    public static final SortScene DiscoveryTab = null;
    public static final SortScene InnerStream = null;
    public static final SortScene MessageListPull = null;
    public static final SortScene MessageListTab = null;
    public static final SortScene PreFetch = null;
    public static final SortScene Recommend = null;
    public static final SortScene Undefined = null;
    public static final SortScene WelcomeBack = null;
    public static final /* synthetic */ SortScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SortScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bmhome.video.SortScene$a] */
    static {
        SortScene r0 = new SortScene("Undefined", 0, 0);
        Undefined = r0;
        SortScene r1 = new SortScene("InnerStream", 1, 1);
        InnerStream = r1;
        SortScene r3 = new SortScene("MessageListTab", 2, 2);
        MessageListTab = r3;
        SortScene r5 = new SortScene("MessageListPull", 3, 3);
        MessageListPull = r5;
        SortScene r7 = new SortScene("ConversationList", 4, 4);
        ConversationList = r7;
        SortScene r9 = new SortScene("DiscoveryTab", 5, 5);
        DiscoveryTab = r9;
        SortScene r11 = new SortScene("WelcomeBack", 6, 6);
        WelcomeBack = r11;
        SortScene r13 = new SortScene("PreFetch", 7, 7);
        PreFetch = r13;
        SortScene r15 = new SortScene("Recommend", 8, 8);
        Recommend = r15;
        SortScene[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new a();
    }

    public static SortScene[] values() {
        return (SortScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SortScene valueOf(String r1) {
        return (SortScene) r27.a.a(SortScene.class, r1);
    }

    public SortScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

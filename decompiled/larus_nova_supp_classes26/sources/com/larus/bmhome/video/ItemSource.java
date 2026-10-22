package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/video/ItemSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "DOUBAO", "DOUYIN", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemSource extends Enum<ItemSource> {
    public static final a Companion = null;
    public static final ItemSource DOUBAO = null;
    public static final ItemSource DOUYIN = null;
    public static final ItemSource UNDEFINED = null;
    public static final /* synthetic */ ItemSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ItemSource> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.video.ItemSource$a] */
    static {
        ItemSource r0 = new ItemSource("UNDEFINED", 0, 0);
        UNDEFINED = r0;
        ItemSource r1 = new ItemSource("DOUBAO", 1, 1);
        DOUBAO = r1;
        ItemSource r3 = new ItemSource("DOUYIN", 2, 2);
        DOUYIN = r3;
        ItemSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ItemSource[] values() {
        return (ItemSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemSource valueOf(String r1) {
        return (ItemSource) r27.a.a(ItemSource.class, r1);
    }

    public ItemSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

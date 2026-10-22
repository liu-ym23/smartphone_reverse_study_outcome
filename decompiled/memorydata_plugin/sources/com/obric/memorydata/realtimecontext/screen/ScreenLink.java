package com.obric.memorydata.realtimecontext.screen;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/realtimecontext/screen/ScreenLink;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCREEN_LINK_UNKNOWN", "SCREEN_LINK_VIEW_TREE", "SCREEN_LINK_OCR", "SCREEN_LINK_VIEW_TREE_2_OCR", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ScreenLink extends Enum<ScreenLink> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScreenLink[] $VALUES = null;
    public static final ScreenLink SCREEN_LINK_OCR = null;
    public static final ScreenLink SCREEN_LINK_UNKNOWN = null;
    public static final ScreenLink SCREEN_LINK_VIEW_TREE = null;
    public static final ScreenLink SCREEN_LINK_VIEW_TREE_2_OCR = null;
    private final int value;

    private static final /* synthetic */ ScreenLink[] $values() {
        return new ScreenLink[]{SCREEN_LINK_UNKNOWN, SCREEN_LINK_VIEW_TREE, SCREEN_LINK_OCR, SCREEN_LINK_VIEW_TREE_2_OCR};
    }

    static {
        SCREEN_LINK_UNKNOWN = new ScreenLink("SCREEN_LINK_UNKNOWN", 0, -1);
        SCREEN_LINK_VIEW_TREE = new ScreenLink("SCREEN_LINK_VIEW_TREE", 1, 0);
        SCREEN_LINK_OCR = new ScreenLink("SCREEN_LINK_OCR", 2, 1);
        SCREEN_LINK_VIEW_TREE_2_OCR = new ScreenLink("SCREEN_LINK_VIEW_TREE_2_OCR", 3, 2);
        ScreenLink[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ScreenLink(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<ScreenLink> getEntries() {
        return $ENTRIES;
    }

    public static ScreenLink valueOf(String r2) {
        return (ScreenLink) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScreenLink.class, r2), ScreenLink.class, "com.obric.memorydata.plugin");
    }

    public static ScreenLink[] values() {
        return (ScreenLink[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScreenLink[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}

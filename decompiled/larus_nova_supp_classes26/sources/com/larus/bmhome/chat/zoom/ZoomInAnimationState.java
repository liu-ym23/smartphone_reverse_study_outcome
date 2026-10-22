package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IDLE", "ZOOM_IN", "STAY", "ZOOM_OUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationState extends Enum<ZoomInAnimationState> {
    public static final ZoomInAnimationState IDLE = null;
    public static final ZoomInAnimationState STAY = null;
    public static final ZoomInAnimationState ZOOM_IN = null;
    public static final ZoomInAnimationState ZOOM_OUT = null;
    public static final /* synthetic */ ZoomInAnimationState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ZoomInAnimationState> getEntries() {
        return b;
    }

    static {
        ZoomInAnimationState r0 = new ZoomInAnimationState("IDLE", 0, 0);
        IDLE = r0;
        ZoomInAnimationState r1 = new ZoomInAnimationState("ZOOM_IN", 1, 1);
        ZOOM_IN = r1;
        ZoomInAnimationState r3 = new ZoomInAnimationState("STAY", 2, 2);
        STAY = r3;
        ZoomInAnimationState r5 = new ZoomInAnimationState("ZOOM_OUT", 3, 3);
        ZOOM_OUT = r5;
        ZoomInAnimationState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ZoomInAnimationState[] values() {
        return (ZoomInAnimationState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ZoomInAnimationState valueOf(String r1) {
        return (ZoomInAnimationState) a.a(ZoomInAnimationState.class, r1);
    }

    public ZoomInAnimationState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

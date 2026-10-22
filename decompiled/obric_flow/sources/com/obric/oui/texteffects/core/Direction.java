package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/core/Direction;", "", "LeftToRight", "RightToLeft", "TopToBottom", "BottomToTop", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Direction extends Enum<Direction> {
    public static final Direction BottomToTop = null;
    public static final Direction LeftToRight = null;
    public static final Direction RightToLeft = null;
    public static final Direction TopToBottom = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f14732a = null;

    static {
        Direction r5 = new Direction("LeftToRight", 0);
        LeftToRight = r5;
        Direction r10 = new Direction("RightToLeft", 1);
        RightToLeft = r10;
        Direction r11 = new Direction("TopToBottom", 2);
        TopToBottom = r11;
        Direction r12 = new Direction("BottomToTop", 3);
        BottomToTop = r12;
        f14732a = new Direction[]{r5, r10, r11, r12};
    }

    public static Direction valueOf(String r5) {
        return (Direction) Enum.valueOf(Direction.class, r5);
    }

    public static Direction[] values() {
        return (Direction[]) f14732a.clone();
    }
}

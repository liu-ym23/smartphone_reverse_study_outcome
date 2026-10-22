package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/texteffects/core/Direction;", "", "(Ljava/lang/String;I)V", "LeftToRight", "RightToLeft", "TopToBottom", "BottomToTop", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Direction extends Enum<Direction> {
    private static final /* synthetic */ Direction[] $VALUES = null;
    public static final Direction BottomToTop = null;
    public static final Direction LeftToRight = null;
    public static final Direction RightToLeft = null;
    public static final Direction TopToBottom = null;

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{LeftToRight, RightToLeft, TopToBottom, BottomToTop};
    }

    static {
        LeftToRight = new Direction("LeftToRight", 0);
        RightToLeft = new Direction("RightToLeft", 1);
        TopToBottom = new Direction("TopToBottom", 2);
        BottomToTop = new Direction("BottomToTop", 3);
        $VALUES = $values();
    }

    private Direction(String r1, int r2) {
        super(r1, r2);
    }

    public static Direction valueOf(String r2) {
        return (Direction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Direction.class, r2), Direction.class, "com.obric.memorydata.plugin");
    }

    public static Direction[] values() {
        return (Direction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Direction[].class, "com.obric.memorydata.plugin");
    }
}

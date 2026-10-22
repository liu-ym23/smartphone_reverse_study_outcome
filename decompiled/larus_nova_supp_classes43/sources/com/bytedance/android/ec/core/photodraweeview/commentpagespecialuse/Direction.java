package com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/Direction;", "", "", a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UP", "DOWN", "RIGHT", "LEFT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Direction extends Enum<Direction> {
    public static final Direction DOWN = null;
    public static final Direction LEFT = null;
    public static final Direction RIGHT = null;
    public static final Direction UP = null;
    public static final /* synthetic */ Direction[] a = null;
    private final String value;

    static {
        Direction r1 = new Direction("UP", 0, "up");
        UP = r1;
        Direction r10 = new Direction("DOWN", 1, "down");
        DOWN = r10;
        Direction r11 = new Direction("RIGHT", 2, "right");
        RIGHT = r11;
        Direction r12 = new Direction("LEFT", 3, "left");
        LEFT = r12;
        a = new Direction[]{r1, r10, r11, r12};
    }

    public static Direction valueOf(String r1) {
        return (Direction) r27.a.a(Direction.class, r1);
    }

    public static Direction[] values() {
        return (Direction[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Direction(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}

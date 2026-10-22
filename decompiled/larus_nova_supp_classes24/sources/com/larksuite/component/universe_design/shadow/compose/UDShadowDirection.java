package com.larksuite.component.universe_design.shadow.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/compose/UDShadowDirection;", "", "x", "", "y", "<init>", "(Ljava/lang/String;III)V", "getX$universe_ui_shadow_release", "()I", "getY$universe_ui_shadow_release", "None", "Up", "Down", "Left", "Right", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDShadowDirection extends Enum<UDShadowDirection> {
    public static final UDShadowDirection Down = null;
    public static final UDShadowDirection Left = null;
    public static final UDShadowDirection None = null;
    public static final UDShadowDirection Right = null;
    public static final UDShadowDirection Up = null;
    public static final /* synthetic */ UDShadowDirection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int x;
    private final int y;

    public static EnumEntries<UDShadowDirection> getEntries() {
        return b;
    }

    static {
        UDShadowDirection r0 = new UDShadowDirection("None", 0, 0, 0);
        None = r0;
        UDShadowDirection r1 = new UDShadowDirection("Up", 1, 0, -1);
        Up = r1;
        UDShadowDirection r3 = new UDShadowDirection("Down", 2, 0, 1);
        Down = r3;
        UDShadowDirection r6 = new UDShadowDirection("Left", 3, -1, 0);
        Left = r6;
        UDShadowDirection r5 = new UDShadowDirection("Right", 4, 1, 0);
        Right = r5;
        UDShadowDirection[] r8 = {r0, r1, r3, r6, r5};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static UDShadowDirection[] values() {
        return (UDShadowDirection[]) a.clone();
    }

    public final int getX$universe_ui_shadow_release() {
        return this.x;
    }

    public final int getY$universe_ui_shadow_release() {
        return this.y;
    }

    public static UDShadowDirection valueOf(String r1) {
        return (UDShadowDirection) r27.a.a(UDShadowDirection.class, r1);
    }

    public UDShadowDirection(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.x = r3;
        this.y = r4;
    }
}

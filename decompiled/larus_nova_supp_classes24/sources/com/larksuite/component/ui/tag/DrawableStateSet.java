package com.larksuite.component.ui.tag;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/ui/tag/DrawableStateSet;", "", "stateSet", "", "<init>", "(Ljava/lang/String;I[I)V", "getStateSet", "()[I", "EMPTY", "SELECTED", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum DrawableStateSet extends Enum<DrawableStateSet> {
    public static final DrawableStateSet EMPTY = null;
    public static final DrawableStateSet SELECTED = null;
    public static final /* synthetic */ DrawableStateSet[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int[] stateSet;

    public static EnumEntries<DrawableStateSet> getEntries() {
        return b;
    }

    static {
        DrawableStateSet r0 = new DrawableStateSet("EMPTY", 0, g.a);
        EMPTY = r0;
        DrawableStateSet r1 = new DrawableStateSet("SELECTED", 1, g.b);
        SELECTED = r1;
        DrawableStateSet[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static DrawableStateSet[] values() {
        return (DrawableStateSet[]) a.clone();
    }

    public final int[] getStateSet() {
        return this.stateSet;
    }

    public static DrawableStateSet valueOf(String r1) {
        return (DrawableStateSet) r27.a.a(DrawableStateSet.class, r1);
    }

    public DrawableStateSet(String r1, int r2, int[] r3) {
        super(r1, r2);
        this.stateSet = r3;
    }
}

package com.larus.dora.impl.device.settings.gesture;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LEFT", "BUTTON", "RIGHT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LastSwitchSide extends Enum<LastSwitchSide> {
    public static final LastSwitchSide BUTTON = null;
    public static final a Companion = null;
    public static final LastSwitchSide LEFT = null;
    public static final LastSwitchSide RIGHT = null;
    public static final Map<Integer, LastSwitchSide> a = null;
    public static final /* synthetic */ LastSwitchSide[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<LastSwitchSide> getEntries() {
        return c;
    }

    static {
        LastSwitchSide r0 = new LastSwitchSide("LEFT", 0, 0);
        LEFT = r0;
        LastSwitchSide r1 = new LastSwitchSide("BUTTON", 1, 1);
        BUTTON = r1;
        LastSwitchSide r3 = new LastSwitchSide("RIGHT", 2, 2);
        RIGHT = r3;
        LastSwitchSide[] r5 = {r0, r1, r3};
        b = r5;
        c = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
        EnumEntries<LastSwitchSide> r2 = getEntries();
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Object r7 = r6.next();
        r4.put(Integer.valueOf(((LastSwitchSide) r7).value), r7);
        goto L4
    L6:
        a = r4;
    }

    public static LastSwitchSide[] values() {
        return (LastSwitchSide[]) b.clone();
    }

    public static final /* synthetic */ Map access$getValues$cp() {
        return a;
    }

    public final int getValue() {
        return this.value;
    }

    public static LastSwitchSide valueOf(String r1) {
        return (LastSwitchSide) r27.a.a(LastSwitchSide.class, r1);
    }

    public LastSwitchSide(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

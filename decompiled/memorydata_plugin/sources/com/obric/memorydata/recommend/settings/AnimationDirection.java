package com.obric.memorydata.recommend.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/settings/AnimationDirection;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_TOP", "FROM_BOTTOM", "FROM_LEFT", "FROM_RIGHT", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AnimationDirection extends Enum<AnimationDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnimationDirection[] $VALUES = null;
    public static final AnimationDirection FROM_BOTTOM = null;
    public static final AnimationDirection FROM_LEFT = null;
    public static final AnimationDirection FROM_RIGHT = null;
    public static final AnimationDirection FROM_TOP = null;

    private static final /* synthetic */ AnimationDirection[] $values() {
        return new AnimationDirection[]{FROM_TOP, FROM_BOTTOM, FROM_LEFT, FROM_RIGHT};
    }

    static {
        FROM_TOP = new AnimationDirection("FROM_TOP", 0);
        FROM_BOTTOM = new AnimationDirection("FROM_BOTTOM", 1);
        FROM_LEFT = new AnimationDirection("FROM_LEFT", 2);
        FROM_RIGHT = new AnimationDirection("FROM_RIGHT", 3);
        AnimationDirection[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AnimationDirection(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AnimationDirection> getEntries() {
        return $ENTRIES;
    }

    public static AnimationDirection valueOf(String r2) {
        return (AnimationDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnimationDirection.class, r2), AnimationDirection.class, "com.obric.memorydata.plugin");
    }

    public static AnimationDirection[] values() {
        return (AnimationDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnimationDirection[].class, "com.obric.memorydata.plugin");
    }
}

package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterOrder;", "", "(Ljava/lang/String;I)V", "StartToEnd", "EndToStart", "CenterOut", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CharacterOrder extends Enum<CharacterOrder> {
    private static final /* synthetic */ CharacterOrder[] $VALUES = null;
    public static final CharacterOrder CenterOut = null;
    public static final CharacterOrder EndToStart = null;
    public static final CharacterOrder StartToEnd = null;

    private static final /* synthetic */ CharacterOrder[] $values() {
        return new CharacterOrder[]{StartToEnd, EndToStart, CenterOut};
    }

    static {
        StartToEnd = new CharacterOrder("StartToEnd", 0);
        EndToStart = new CharacterOrder("EndToStart", 1);
        CenterOut = new CharacterOrder("CenterOut", 2);
        $VALUES = $values();
    }

    private CharacterOrder(String r1, int r2) {
        super(r1, r2);
    }

    public static CharacterOrder valueOf(String r2) {
        return (CharacterOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(CharacterOrder.class, r2), CharacterOrder.class, "com.obric.memorydata.plugin");
    }

    public static CharacterOrder[] values() {
        return (CharacterOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CharacterOrder[].class, "com.obric.memorydata.plugin");
    }
}

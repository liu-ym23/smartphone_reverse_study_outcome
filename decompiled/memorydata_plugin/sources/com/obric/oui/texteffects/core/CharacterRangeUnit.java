package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/core/CharacterRangeUnit;", "", "(Ljava/lang/String;I)V", "Absolute", "TextWidthPercent", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CharacterRangeUnit extends Enum<CharacterRangeUnit> {
    private static final /* synthetic */ CharacterRangeUnit[] $VALUES = null;
    public static final CharacterRangeUnit Absolute = null;
    public static final CharacterRangeUnit TextWidthPercent = null;

    private static final /* synthetic */ CharacterRangeUnit[] $values() {
        return new CharacterRangeUnit[]{Absolute, TextWidthPercent};
    }

    static {
        Absolute = new CharacterRangeUnit("Absolute", 0);
        TextWidthPercent = new CharacterRangeUnit("TextWidthPercent", 1);
        $VALUES = $values();
    }

    private CharacterRangeUnit(String r1, int r2) {
        super(r1, r2);
    }

    public static CharacterRangeUnit valueOf(String r2) {
        return (CharacterRangeUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(CharacterRangeUnit.class, r2), CharacterRangeUnit.class, "com.obric.memorydata.plugin");
    }

    public static CharacterRangeUnit[] values() {
        return (CharacterRangeUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CharacterRangeUnit[].class, "com.obric.memorydata.plugin");
    }
}

package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/core/GradientBlurCurveType;", "", "(Ljava/lang/String;I)V", "Linear", "InOutQuad", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum GradientBlurCurveType extends Enum<GradientBlurCurveType> {
    private static final /* synthetic */ GradientBlurCurveType[] $VALUES = null;
    public static final GradientBlurCurveType InOutQuad = null;
    public static final GradientBlurCurveType Linear = null;

    private static final /* synthetic */ GradientBlurCurveType[] $values() {
        return new GradientBlurCurveType[]{Linear, InOutQuad};
    }

    static {
        Linear = new GradientBlurCurveType("Linear", 0);
        InOutQuad = new GradientBlurCurveType("InOutQuad", 1);
        $VALUES = $values();
    }

    private GradientBlurCurveType(String r1, int r2) {
        super(r1, r2);
    }

    public static GradientBlurCurveType valueOf(String r2) {
        return (GradientBlurCurveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GradientBlurCurveType.class, r2), GradientBlurCurveType.class, "com.obric.memorydata.plugin");
    }

    public static GradientBlurCurveType[] values() {
        return (GradientBlurCurveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GradientBlurCurveType[].class, "com.obric.memorydata.plugin");
    }
}

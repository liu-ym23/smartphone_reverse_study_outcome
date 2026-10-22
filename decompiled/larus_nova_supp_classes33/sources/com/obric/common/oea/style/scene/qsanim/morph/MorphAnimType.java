package com.obric.common.oea.style.scene.qsanim.morph;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/MorphAnimType;", "", "SCALE_UP", "SCALE_DOWN", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum MorphAnimType extends Enum<MorphAnimType> {
    public static final MorphAnimType SCALE_DOWN = null;
    public static final MorphAnimType SCALE_UP = null;
    public static final /* synthetic */ MorphAnimType[] a = null;

    static {
        MorphAnimType r1 = new MorphAnimType("SCALE_UP", 0);
        SCALE_UP = r1;
        MorphAnimType r2 = new MorphAnimType("SCALE_DOWN", 1);
        SCALE_DOWN = r2;
        a = new MorphAnimType[]{r1, r2};
    }

    public static MorphAnimType valueOf(String r1) {
        return (MorphAnimType) r27.a.a(MorphAnimType.class, r1);
    }

    public static MorphAnimType[] values() {
        return (MorphAnimType[]) a.clone();
    }

    public MorphAnimType(String r1, int r2) {
        super(r1, r2);
    }
}

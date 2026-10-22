package com.obric.common.oea.style.scene.qsanim.morph;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/MorphAnimType;", "", "SCALE_UP", "SCALE_DOWN", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum MorphAnimType extends Enum<MorphAnimType> {
    public static final MorphAnimType SCALE_DOWN = null;
    public static final MorphAnimType SCALE_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MorphAnimType[] f11371a = null;

    static {
        MorphAnimType r5 = new MorphAnimType("SCALE_UP", 0);
        SCALE_UP = r5;
        MorphAnimType r10 = new MorphAnimType("SCALE_DOWN", 1);
        SCALE_DOWN = r10;
        f11371a = new MorphAnimType[]{r5, r10};
    }

    public static MorphAnimType valueOf(String r5) {
        return (MorphAnimType) Enum.valueOf(MorphAnimType.class, r5);
    }

    public static MorphAnimType[] values() {
        return (MorphAnimType[]) f11371a.clone();
    }
}

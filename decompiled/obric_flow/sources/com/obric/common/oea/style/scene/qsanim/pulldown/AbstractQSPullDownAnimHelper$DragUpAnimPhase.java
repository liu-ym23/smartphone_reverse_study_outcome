package com.obric.common.oea.style.scene.qsanim.pulldown;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase", "", "Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "NONE", "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
final enum AbstractQSPullDownAnimHelper$DragUpAnimPhase extends Enum<AbstractQSPullDownAnimHelper$DragUpAnimPhase> {
    public static final AbstractQSPullDownAnimHelper$DragUpAnimPhase CLOSE = null;
    public static final AbstractQSPullDownAnimHelper$DragUpAnimPhase NONE = null;
    public static final AbstractQSPullDownAnimHelper$DragUpAnimPhase OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AbstractQSPullDownAnimHelper$DragUpAnimPhase[] f11375a = null;

    static {
        AbstractQSPullDownAnimHelper$DragUpAnimPhase r5 = new AbstractQSPullDownAnimHelper$DragUpAnimPhase("NONE", 0);
        NONE = r5;
        AbstractQSPullDownAnimHelper$DragUpAnimPhase r10 = new AbstractQSPullDownAnimHelper$DragUpAnimPhase("OPEN", 1);
        OPEN = r10;
        AbstractQSPullDownAnimHelper$DragUpAnimPhase r11 = new AbstractQSPullDownAnimHelper$DragUpAnimPhase("CLOSE", 2);
        CLOSE = r11;
        f11375a = new AbstractQSPullDownAnimHelper$DragUpAnimPhase[]{r5, r10, r11};
    }

    public static AbstractQSPullDownAnimHelper$DragUpAnimPhase valueOf(String r5) {
        return (AbstractQSPullDownAnimHelper$DragUpAnimPhase) Enum.valueOf(AbstractQSPullDownAnimHelper$DragUpAnimPhase.class, r5);
    }

    public static AbstractQSPullDownAnimHelper$DragUpAnimPhase[] values() {
        return (AbstractQSPullDownAnimHelper$DragUpAnimPhase[]) f11375a.clone();
    }
}

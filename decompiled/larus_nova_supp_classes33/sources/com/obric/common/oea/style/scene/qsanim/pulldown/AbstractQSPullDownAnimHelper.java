package com.obric.common.oea.style.scene.qsanim.pulldown;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class AbstractQSPullDownAnimHelper extends com.obric.common.oea.style.scene.qsanim.pulldown.a {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "", "NONE", "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DragUpAnimPhase extends Enum<DragUpAnimPhase> {
        public static final DragUpAnimPhase CLOSE = null;
        public static final DragUpAnimPhase NONE = null;
        public static final DragUpAnimPhase OPEN = null;
        public static final /* synthetic */ DragUpAnimPhase[] a = null;

        static {
            DragUpAnimPhase r1 = new DragUpAnimPhase("NONE", 0);
            NONE = r1;
            DragUpAnimPhase r2 = new DragUpAnimPhase("OPEN", 1);
            OPEN = r2;
            DragUpAnimPhase r3 = new DragUpAnimPhase("CLOSE", 2);
            CLOSE = r3;
            a = new DragUpAnimPhase[]{r1, r2, r3};
        }

        public static DragUpAnimPhase valueOf(String r1) {
            return (DragUpAnimPhase) r27.a.a(DragUpAnimPhase.class, r1);
        }

        public static DragUpAnimPhase[] values() {
            return (DragUpAnimPhase[]) a.clone();
        }

        public DragUpAnimPhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }
}

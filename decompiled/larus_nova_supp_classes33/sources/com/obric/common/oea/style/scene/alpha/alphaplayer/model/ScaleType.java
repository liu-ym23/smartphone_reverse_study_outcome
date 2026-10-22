package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "Companion", "a", "ScaleToFill", "ScaleAspectFitCenter", "ScaleAspectFill", "TopFill", "BottomFill", "LeftFill", "RightFill", "TopFit", "BottomFit", "LeftFit", "RightFit", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType BottomFill = null;
    public static final ScaleType BottomFit = null;
    public static final a Companion = null;
    public static final ScaleType LeftFill = null;
    public static final ScaleType LeftFit = null;
    public static final ScaleType RightFill = null;
    public static final ScaleType RightFit = null;
    public static final ScaleType ScaleAspectFill = null;
    public static final ScaleType ScaleAspectFitCenter = null;
    public static final ScaleType ScaleToFill = null;
    public static final ScaleType TopFill = null;
    public static final ScaleType TopFit = null;
    public static final /* synthetic */ ScaleType[] a = null;

    public static ScaleType valueOf(String r1) {
        return (ScaleType) r27.a.a(ScaleType.class, r1);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType$a] */
    static {
        ScaleType r1 = new ScaleType("ScaleToFill", 0);
        ScaleToFill = r1;
        ScaleType r2 = new ScaleType("ScaleAspectFitCenter", 1);
        ScaleAspectFitCenter = r2;
        ScaleType r3 = new ScaleType("ScaleAspectFill", 2);
        ScaleAspectFill = r3;
        ScaleType r4 = new ScaleType("TopFill", 3);
        TopFill = r4;
        ScaleType r5 = new ScaleType("BottomFill", 4);
        BottomFill = r5;
        ScaleType r6 = new ScaleType("LeftFill", 5);
        LeftFill = r6;
        ScaleType r7 = new ScaleType("RightFill", 6);
        RightFill = r7;
        ScaleType r8 = new ScaleType("TopFit", 7);
        TopFit = r8;
        ScaleType r9 = new ScaleType("BottomFit", 8);
        BottomFit = r9;
        ScaleType r10 = new ScaleType("LeftFit", 9);
        LeftFit = r10;
        ScaleType r11 = new ScaleType("RightFit", 10);
        RightFit = r11;
        a = new ScaleType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Companion = new a();
    }

    public ScaleType(String r1, int r2) {
        super(r1, r2);
    }
}

package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import kotlin.Metadata;
import vp.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "Companion", "vp/a", "ScaleToFill", "ScaleAspectFitCenter", "ScaleAspectFill", "TopFill", "BottomFill", "LeftFill", "RightFill", "TopFit", "BottomFit", "LeftFit", "RightFit", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScaleType[] f11351a = null;

    static {
        ScaleType r5 = new ScaleType("ScaleToFill", 0);
        ScaleToFill = r5;
        ScaleType r10 = new ScaleType("ScaleAspectFitCenter", 1);
        ScaleAspectFitCenter = r10;
        ScaleType r11 = new ScaleType("ScaleAspectFill", 2);
        ScaleAspectFill = r11;
        ScaleType r12 = new ScaleType("TopFill", 3);
        TopFill = r12;
        ScaleType r13 = new ScaleType("BottomFill", 4);
        BottomFill = r13;
        ScaleType r14 = new ScaleType("LeftFill", 5);
        LeftFill = r14;
        ScaleType r15 = new ScaleType("RightFill", 6);
        RightFill = r15;
        ScaleType r16 = new ScaleType("TopFit", 7);
        TopFit = r16;
        ScaleType r17 = new ScaleType("BottomFit", 8);
        BottomFit = r17;
        ScaleType r18 = new ScaleType("LeftFit", 9);
        LeftFit = r18;
        ScaleType r19 = new ScaleType("RightFit", 10);
        RightFit = r19;
        f11351a = new ScaleType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        Companion = new a();
    }

    public static ScaleType valueOf(String r5) {
        return (ScaleType) Enum.valueOf(ScaleType.class, r5);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) f11351a.clone();
    }
}

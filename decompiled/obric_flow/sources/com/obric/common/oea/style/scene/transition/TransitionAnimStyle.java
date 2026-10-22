package com.obric.common.oea.style.scene.transition;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/transition/TransitionAnimStyle;", "", "SubpageInOut", "SettingsInOut", "Standard", "Modal", "Search", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum TransitionAnimStyle extends Enum<TransitionAnimStyle> {
    public static final TransitionAnimStyle Modal = null;
    public static final TransitionAnimStyle Search = null;

    @Deprecated(message = "请使用 Modal")
    public static final TransitionAnimStyle SettingsInOut = null;
    public static final TransitionAnimStyle Standard = null;

    @Deprecated(message = "请使用 Standard")
    public static final TransitionAnimStyle SubpageInOut = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TransitionAnimStyle[] f11376a = null;

    static {
        TransitionAnimStyle r5 = new TransitionAnimStyle("SubpageInOut", 0);
        SubpageInOut = r5;
        TransitionAnimStyle r10 = new TransitionAnimStyle("SettingsInOut", 1);
        SettingsInOut = r10;
        TransitionAnimStyle r11 = new TransitionAnimStyle("Standard", 2);
        Standard = r11;
        TransitionAnimStyle r12 = new TransitionAnimStyle("Modal", 3);
        Modal = r12;
        TransitionAnimStyle r13 = new TransitionAnimStyle("Search", 4);
        Search = r13;
        f11376a = new TransitionAnimStyle[]{r5, r10, r11, r12, r13};
    }

    public static TransitionAnimStyle valueOf(String r5) {
        return (TransitionAnimStyle) Enum.valueOf(TransitionAnimStyle.class, r5);
    }

    public static TransitionAnimStyle[] values() {
        return (TransitionAnimStyle[]) f11376a.clone();
    }
}

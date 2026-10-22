package com.bytedance.ai.view.popup.anim;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/view/popup/anim/AnimationStyle;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AnimationStyle extends Enum<AnimationStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationStyle[] f2882a = null;

    static {
        AnimationStyle[] r5 = {new AnimationStyle("START", 0, "start"), new AnimationStyle("END", 1, "end"), new AnimationStyle("LEFT", 2, OpenPageMethod.ALIGN_LEFT), new AnimationStyle("RIGHT", 3, "right"), new AnimationStyle("ZOOM", 4, "zoom"), new AnimationStyle("SLIDE", 5, "slide"), new AnimationStyle("AUTO", 6, "auto"), new AnimationStyle("NONE", 7, "none")};
        f2882a = r5;
        EnumEntriesKt.enumEntries(r5);
    }

    public AnimationStyle(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static AnimationStyle valueOf(String r5) {
        return (AnimationStyle) Enum.valueOf(AnimationStyle.class, r5);
    }

    public static AnimationStyle[] values() {
        return (AnimationStyle[]) f2882a.clone();
    }
}

package com.ss.android.lark.keyboard.base.inputinner;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/InputInnerVisibilityMode;", "", "<init>", "(Ljava/lang/String;I)V", "DYNAMIC", "ALWAYS_VISIBLE", "ALWAYS_GONE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum InputInnerVisibilityMode extends Enum<InputInnerVisibilityMode> {
    public static final InputInnerVisibilityMode ALWAYS_GONE = null;
    public static final InputInnerVisibilityMode ALWAYS_VISIBLE = null;
    public static final InputInnerVisibilityMode DYNAMIC = null;
    public static final /* synthetic */ InputInnerVisibilityMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InputInnerVisibilityMode> getEntries() {
        return b;
    }

    static {
        InputInnerVisibilityMode r0 = new InputInnerVisibilityMode("DYNAMIC", 0);
        DYNAMIC = r0;
        InputInnerVisibilityMode r1 = new InputInnerVisibilityMode("ALWAYS_VISIBLE", 1);
        ALWAYS_VISIBLE = r1;
        InputInnerVisibilityMode r3 = new InputInnerVisibilityMode("ALWAYS_GONE", 2);
        ALWAYS_GONE = r3;
        InputInnerVisibilityMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static InputInnerVisibilityMode[] values() {
        return (InputInnerVisibilityMode[]) a.clone();
    }

    public static InputInnerVisibilityMode valueOf(String r1) {
        return (InputInnerVisibilityMode) a.a(InputInnerVisibilityMode.class, r1);
    }

    public InputInnerVisibilityMode(String r1, int r2) {
        super(r1, r2);
    }
}

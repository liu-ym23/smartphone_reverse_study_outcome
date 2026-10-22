package com.ss.android.lark.keyboard.event;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/event/ImeState;", "Lcom/ss/android/lark/keyboard/event/ITransformable;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "IME", "PANEL", "getTag", "", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ImeState extends Enum<ImeState> implements m {
    public static final ImeState IME = null;
    public static final ImeState NONE = null;
    public static final ImeState PANEL = null;
    public static final /* synthetic */ ImeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImeState> getEntries() {
        return b;
    }

    static {
        ImeState r0 = new ImeState("NONE", 0);
        NONE = r0;
        ImeState r1 = new ImeState("IME", 1);
        IME = r1;
        ImeState r3 = new ImeState("PANEL", 2);
        PANEL = r3;
        ImeState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ImeState[] values() {
        return (ImeState[]) a.clone();
    }

    @Override // com.ss.android.lark.keyboard.event.c
    public String getTag() {
        return name();
    }

    public static ImeState valueOf(String r1) {
        return (ImeState) r27.a.a(ImeState.class, r1);
    }

    public ImeState(String r1, int r2) {
        super(r1, r2);
    }
}

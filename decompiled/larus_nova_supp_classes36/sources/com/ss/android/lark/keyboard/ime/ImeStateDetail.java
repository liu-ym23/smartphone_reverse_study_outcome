package com.ss.android.lark.keyboard.ime;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "", "<init>", "(Ljava/lang/String;I)V", "Show", "Hide", "Enter", "Exit", "toString", "", "isEnterOrShow", "", "isHideOrExit", "isShowOrExit", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ImeStateDetail extends Enum<ImeStateDetail> {
    public static final ImeStateDetail Enter = null;
    public static final ImeStateDetail Exit = null;
    public static final ImeStateDetail Hide = null;
    public static final ImeStateDetail Show = null;
    public static final /* synthetic */ ImeStateDetail[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImeStateDetail> getEntries() {
        return b;
    }

    static {
        ImeStateDetail r0 = new ImeStateDetail("Show", 0);
        Show = r0;
        ImeStateDetail r1 = new ImeStateDetail("Hide", 1);
        Hide = r1;
        ImeStateDetail r3 = new ImeStateDetail("Enter", 2);
        Enter = r3;
        ImeStateDetail r5 = new ImeStateDetail("Exit", 3);
        Exit = r5;
        ImeStateDetail[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ImeStateDetail[] values() {
        return (ImeStateDetail[]) a.clone();
    }

    public final boolean isEnterOrShow() {
        if (this != Enter) goto L5;
    L8:
        return true;
    L5:
        if (this == Show) goto L8;
        return false;
    }

    public final boolean isHideOrExit() {
        if (this != Hide) goto L5;
    L8:
        return true;
    L5:
        if (this == Exit) goto L8;
        return false;
    }

    public final boolean isShowOrExit() {
        if (this != Show) goto L5;
    L8:
        return true;
    L5:
        if (this == Exit) goto L8;
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public static ImeStateDetail valueOf(String r1) {
        return (ImeStateDetail) r27.a.a(ImeStateDetail.class, r1);
    }

    public ImeStateDetail(String r1, int r2) {
        super(r1, r2);
    }
}

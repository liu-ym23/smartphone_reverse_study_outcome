package com.ss.android.lark.keyboard.base.inputinner;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/DirectionInParent;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum DirectionInParent extends Enum<DirectionInParent> {
    public static final DirectionInParent BOTTOM = null;
    public static final DirectionInParent TOP = null;
    public static final /* synthetic */ DirectionInParent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DirectionInParent> getEntries() {
        return b;
    }

    static {
        DirectionInParent r0 = new DirectionInParent("TOP", 0);
        TOP = r0;
        DirectionInParent r1 = new DirectionInParent("BOTTOM", 1);
        BOTTOM = r1;
        DirectionInParent[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DirectionInParent[] values() {
        return (DirectionInParent[]) a.clone();
    }

    public static DirectionInParent valueOf(String r1) {
        return (DirectionInParent) a.a(DirectionInParent.class, r1);
    }

    public DirectionInParent(String r1, int r2) {
        super(r1, r2);
    }
}

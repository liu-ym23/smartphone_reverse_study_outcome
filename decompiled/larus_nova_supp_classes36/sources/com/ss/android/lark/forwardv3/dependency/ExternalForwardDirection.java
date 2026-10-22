package com.ss.android.lark.forwardv3.dependency;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DOUBAO_TO_LARK", "LARK_TO_DOUBAO", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ExternalForwardDirection extends Enum<ExternalForwardDirection> {
    public static final ExternalForwardDirection DOUBAO_TO_LARK = null;
    public static final ExternalForwardDirection LARK_TO_DOUBAO = null;
    public static final /* synthetic */ ExternalForwardDirection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ExternalForwardDirection> getEntries() {
        return b;
    }

    static {
        ExternalForwardDirection r0 = new ExternalForwardDirection("DOUBAO_TO_LARK", 0, "doubao2lark");
        DOUBAO_TO_LARK = r0;
        ExternalForwardDirection r1 = new ExternalForwardDirection("LARK_TO_DOUBAO", 1, "lark2doubao");
        LARK_TO_DOUBAO = r1;
        ExternalForwardDirection[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ExternalForwardDirection[] values() {
        return (ExternalForwardDirection[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ExternalForwardDirection valueOf(String r1) {
        return (ExternalForwardDirection) a.a(ExternalForwardDirection.class, r1);
    }

    public ExternalForwardDirection(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

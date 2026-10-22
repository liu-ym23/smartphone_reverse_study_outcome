package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/ResultConfirmControlStyle;", "", "<init>", "(Ljava/lang/String;I)V", "GENERAL", "EDU", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultConfirmControlStyle extends Enum<ResultConfirmControlStyle> {
    public static final ResultConfirmControlStyle EDU = null;
    public static final ResultConfirmControlStyle GENERAL = null;
    public static final /* synthetic */ ResultConfirmControlStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResultConfirmControlStyle> getEntries() {
        return b;
    }

    static {
        ResultConfirmControlStyle r0 = new ResultConfirmControlStyle("GENERAL", 0);
        GENERAL = r0;
        ResultConfirmControlStyle r1 = new ResultConfirmControlStyle("EDU", 1);
        EDU = r1;
        ResultConfirmControlStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ResultConfirmControlStyle[] values() {
        return (ResultConfirmControlStyle[]) a.clone();
    }

    public static ResultConfirmControlStyle valueOf(String r1) {
        return (ResultConfirmControlStyle) r27.a.a(ResultConfirmControlStyle.class, r1);
    }

    public ResultConfirmControlStyle(String r1, int r2) {
        super(r1, r2);
    }
}

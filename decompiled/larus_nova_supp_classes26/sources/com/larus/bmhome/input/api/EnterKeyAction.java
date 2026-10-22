package com.larus.bmhome.input.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/input/api/EnterKeyAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SEND", "NEWLINE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnterKeyAction extends Enum<EnterKeyAction> {
    public static final EnterKeyAction NEWLINE = null;
    public static final EnterKeyAction SEND = null;
    public static final /* synthetic */ EnterKeyAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<EnterKeyAction> getEntries() {
        return b;
    }

    static {
        EnterKeyAction r0 = new EnterKeyAction("SEND", 0, 1);
        SEND = r0;
        EnterKeyAction r1 = new EnterKeyAction("NEWLINE", 1, 2);
        NEWLINE = r1;
        EnterKeyAction[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static EnterKeyAction[] values() {
        return (EnterKeyAction[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EnterKeyAction valueOf(String r1) {
        return (EnterKeyAction) a.a(EnterKeyAction.class, r1);
    }

    public EnterKeyAction(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

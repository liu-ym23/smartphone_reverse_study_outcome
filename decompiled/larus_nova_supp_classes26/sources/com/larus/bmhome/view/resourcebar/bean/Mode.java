package com.larus.bmhome.view.resourcebar.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/Mode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SHOW", "EDIT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Mode extends Enum<Mode> {
    public static final Mode EDIT = null;
    public static final Mode SHOW = null;
    public static final /* synthetic */ Mode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Mode> getEntries() {
        return b;
    }

    static {
        Mode r0 = new Mode("SHOW", 0, 0);
        SHOW = r0;
        Mode r1 = new Mode("EDIT", 1, 1);
        EDIT = r1;
        Mode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static Mode[] values() {
        return (Mode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Mode valueOf(String r1) {
        return (Mode) a.a(Mode.class, r1);
    }

    public Mode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

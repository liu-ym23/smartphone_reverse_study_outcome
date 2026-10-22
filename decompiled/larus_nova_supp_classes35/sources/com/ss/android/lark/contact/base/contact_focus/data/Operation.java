package com.ss.android.lark.contact.base.contact_focus.data;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_focus/data/Operation;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ADD", "DELETE", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Operation extends Enum<Operation> {
    public static final Operation ADD = null;
    public static final Operation DELETE = null;
    public static final /* synthetic */ Operation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Operation> getEntries() {
        return b;
    }

    static {
        Operation r0 = new Operation("ADD", 0, 0);
        ADD = r0;
        Operation r1 = new Operation("DELETE", 1, 1);
        DELETE = r1;
        Operation[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static Operation[] values() {
        return (Operation[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Operation valueOf(String r1) {
        return (Operation) a.a(Operation.class, r1);
    }

    public Operation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

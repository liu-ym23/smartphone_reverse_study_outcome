package com.larus.commercecredit.impl.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/commercecredit/impl/entity/ButtonStatus;", "", "status", "", "<init>", "(Ljava/lang/String;II)V", "getStatus", "()I", "BUTTON_STATUS_UNFINISHED", "BUTTON_STATUS_FINISHED", "BUTTON_STATUS_ONGOING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus BUTTON_STATUS_FINISHED = null;
    public static final ButtonStatus BUTTON_STATUS_ONGOING = null;
    public static final ButtonStatus BUTTON_STATUS_UNFINISHED = null;
    public static final /* synthetic */ ButtonStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int status;

    public static EnumEntries<ButtonStatus> getEntries() {
        return b;
    }

    static {
        ButtonStatus r0 = new ButtonStatus("BUTTON_STATUS_UNFINISHED", 0, 1);
        BUTTON_STATUS_UNFINISHED = r0;
        ButtonStatus r1 = new ButtonStatus("BUTTON_STATUS_FINISHED", 1, 2);
        BUTTON_STATUS_FINISHED = r1;
        ButtonStatus r4 = new ButtonStatus("BUTTON_STATUS_ONGOING", 2, 3);
        BUTTON_STATUS_ONGOING = r4;
        ButtonStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public static ButtonStatus valueOf(String r1) {
        return (ButtonStatus) a.a(ButtonStatus.class, r1);
    }

    public ButtonStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.status = r3;
    }
}

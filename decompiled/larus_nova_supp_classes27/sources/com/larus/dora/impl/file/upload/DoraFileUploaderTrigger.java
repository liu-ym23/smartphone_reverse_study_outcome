package com.larus.dora.impl.file.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/file/upload/DoraFileUploaderTrigger;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "APP_FOREGROUND", "APP_BACKGROUND_DORA_WAKEUP", "AFTER_FETCH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileUploaderTrigger extends Enum<DoraFileUploaderTrigger> {
    public static final DoraFileUploaderTrigger AFTER_FETCH = null;
    public static final DoraFileUploaderTrigger APP_BACKGROUND_DORA_WAKEUP = null;
    public static final DoraFileUploaderTrigger APP_FOREGROUND = null;
    public static final /* synthetic */ DoraFileUploaderTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String traceName;

    public static EnumEntries<DoraFileUploaderTrigger> getEntries() {
        return b;
    }

    static {
        DoraFileUploaderTrigger r0 = new DoraFileUploaderTrigger("APP_FOREGROUND", 0, "AppEnterForeground");
        APP_FOREGROUND = r0;
        DoraFileUploaderTrigger r1 = new DoraFileUploaderTrigger("APP_BACKGROUND_DORA_WAKEUP", 1, "AppBackgroundAndDoraWakeup");
        APP_BACKGROUND_DORA_WAKEUP = r1;
        DoraFileUploaderTrigger r2 = new DoraFileUploaderTrigger("AFTER_FETCH", 2, "AfterFetch");
        AFTER_FETCH = r2;
        DoraFileUploaderTrigger[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DoraFileUploaderTrigger[] values() {
        return (DoraFileUploaderTrigger[]) a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static DoraFileUploaderTrigger valueOf(String r1) {
        return (DoraFileUploaderTrigger) a.a(DoraFileUploaderTrigger.class, r1);
    }

    public DoraFileUploaderTrigger(String r1, int r2, String r3) {
        super(r1, r2);
        this.traceName = r3;
    }
}

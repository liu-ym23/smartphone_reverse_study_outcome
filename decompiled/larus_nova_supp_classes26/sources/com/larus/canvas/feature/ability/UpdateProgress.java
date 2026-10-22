package com.larus.canvas.feature.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/ability/UpdateProgress;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_START", "UPDATING", "UPDATE_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateProgress extends Enum<UpdateProgress> {
    public static final UpdateProgress UPDATE_END = null;
    public static final UpdateProgress UPDATE_START = null;
    public static final UpdateProgress UPDATING = null;
    public static final /* synthetic */ UpdateProgress[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UpdateProgress> getEntries() {
        return b;
    }

    static {
        UpdateProgress r0 = new UpdateProgress("UPDATE_START", 0);
        UPDATE_START = r0;
        UpdateProgress r1 = new UpdateProgress("UPDATING", 1);
        UPDATING = r1;
        UpdateProgress r3 = new UpdateProgress("UPDATE_END", 2);
        UPDATE_END = r3;
        UpdateProgress[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UpdateProgress[] values() {
        return (UpdateProgress[]) a.clone();
    }

    public static UpdateProgress valueOf(String r1) {
        return (UpdateProgress) a.a(UpdateProgress.class, r1);
    }

    public UpdateProgress(String r1, int r2) {
        super(r1, r2);
    }
}

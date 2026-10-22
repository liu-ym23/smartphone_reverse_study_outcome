package com.larus.bmhome.chat.standarduikit.generictool.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/generictool/view/GenericToolViewStage;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FINISHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GenericToolViewStage extends Enum<GenericToolViewStage> {
    public static final GenericToolViewStage FINISHED = null;
    public static final GenericToolViewStage LOADING = null;
    public static final /* synthetic */ GenericToolViewStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GenericToolViewStage> getEntries() {
        return b;
    }

    static {
        GenericToolViewStage r0 = new GenericToolViewStage("LOADING", 0);
        LOADING = r0;
        GenericToolViewStage r1 = new GenericToolViewStage("FINISHED", 1);
        FINISHED = r1;
        GenericToolViewStage[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static GenericToolViewStage[] values() {
        return (GenericToolViewStage[]) a.clone();
    }

    public static GenericToolViewStage valueOf(String r1) {
        return (GenericToolViewStage) a.a(GenericToolViewStage.class, r1);
    }

    public GenericToolViewStage(String r1, int r2) {
        super(r1, r2);
    }
}

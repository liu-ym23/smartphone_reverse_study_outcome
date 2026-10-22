package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "READY_TO_LOAD", "LOADING", "COMPLETE", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum LoadState extends Enum<LoadState> {
    public static final LoadState COMPLETE = null;
    public static final LoadState LOADING = null;
    public static final LoadState READY_TO_LOAD = null;
    public static final /* synthetic */ LoadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LoadState> getEntries() {
        return b;
    }

    static {
        LoadState r0 = new LoadState("READY_TO_LOAD", 0);
        READY_TO_LOAD = r0;
        LoadState r1 = new LoadState("LOADING", 1);
        LOADING = r1;
        LoadState r3 = new LoadState("COMPLETE", 2);
        COMPLETE = r3;
        LoadState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LoadState[] values() {
        return (LoadState[]) a.clone();
    }

    public static LoadState valueOf(String r1) {
        return (LoadState) r27.a.a(LoadState.class, r1);
    }

    public LoadState(String r1, int r2) {
        super(r1, r2);
    }
}

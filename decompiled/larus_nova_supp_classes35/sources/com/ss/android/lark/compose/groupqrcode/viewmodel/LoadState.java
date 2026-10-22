package com.ss.android.lark.compose.groupqrcode.viewmodel;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/compose/groupqrcode/viewmodel/LoadState;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "SUCCESS", "ERROR", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState ERROR = null;
    public static final LoadState IDLE = null;
    public static final LoadState LOADING = null;
    public static final LoadState SUCCESS = null;
    public static final /* synthetic */ LoadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LoadState> getEntries() {
        return b;
    }

    static {
        LoadState r0 = new LoadState("IDLE", 0);
        IDLE = r0;
        LoadState r1 = new LoadState("LOADING", 1);
        LOADING = r1;
        LoadState r3 = new LoadState("SUCCESS", 2);
        SUCCESS = r3;
        LoadState r5 = new LoadState("ERROR", 3);
        ERROR = r5;
        LoadState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
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

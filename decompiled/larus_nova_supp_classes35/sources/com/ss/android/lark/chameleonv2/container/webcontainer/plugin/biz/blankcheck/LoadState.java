package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/LoadState;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NONE", "START", "PAGE_STARTED", "SUCCESS", "FAIL", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState FAIL = null;
    public static final LoadState NONE = null;
    public static final LoadState PAGE_STARTED = null;
    public static final LoadState START = null;
    public static final LoadState SUCCESS = null;
    public static final /* synthetic */ LoadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<LoadState> getEntries() {
        return b;
    }

    static {
        LoadState r0 = new LoadState("NONE", 0, "none");
        NONE = r0;
        LoadState r1 = new LoadState("START", 1, "start");
        START = r1;
        LoadState r2 = new LoadState("PAGE_STARTED", 2, "page_start");
        PAGE_STARTED = r2;
        LoadState r4 = new LoadState("SUCCESS", 3, ChameleonOpenTracker.OpenResult.SUCCESS);
        SUCCESS = r4;
        LoadState r6 = new LoadState("FAIL", 4, "fail");
        FAIL = r6;
        LoadState[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static LoadState[] values() {
        return (LoadState[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static LoadState valueOf(String r1) {
        return (LoadState) r27.a.a(LoadState.class, r1);
    }

    public LoadState(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}

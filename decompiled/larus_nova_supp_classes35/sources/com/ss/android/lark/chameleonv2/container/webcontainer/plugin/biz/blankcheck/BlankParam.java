package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/BlankParam;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NORMAL", "BLANK", "TRANSPARENT", "ERROR", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlankParam extends Enum<BlankParam> {
    public static final BlankParam BLANK = null;
    public static final BlankParam ERROR = null;
    public static final BlankParam NORMAL = null;
    public static final BlankParam TRANSPARENT = null;
    public static final /* synthetic */ BlankParam[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<BlankParam> getEntries() {
        return b;
    }

    static {
        BlankParam r0 = new BlankParam("NORMAL", 0, 0);
        NORMAL = r0;
        BlankParam r1 = new BlankParam("BLANK", 1, 1);
        BLANK = r1;
        BlankParam r3 = new BlankParam("TRANSPARENT", 2, 2);
        TRANSPARENT = r3;
        BlankParam r5 = new BlankParam("ERROR", 3, -1);
        ERROR = r5;
        BlankParam[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static BlankParam[] values() {
        return (BlankParam[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static BlankParam valueOf(String r1) {
        return (BlankParam) r27.a.a(BlankParam.class, r1);
    }

    public BlankParam(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}

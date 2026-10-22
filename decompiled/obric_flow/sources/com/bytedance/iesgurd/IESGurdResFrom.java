package com.bytedance.iesgurd;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdResFrom;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum IESGurdResFrom extends Enum<IESGurdResFrom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IESGurdResFrom f6587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IESGurdResFrom f6588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IESGurdResFrom f6589c = null;
    public static final /* synthetic */ IESGurdResFrom[] d = null;

    static {
        IESGurdResFrom r5 = new IESGurdResFrom("NONE", 0);
        f6587a = r5;
        IESGurdResFrom r10 = new IESGurdResFrom("OFFLINE", 1);
        f6588b = r10;
        IESGurdResFrom r11 = new IESGurdResFrom("OFFLINE_FROM_CDN", 2);
        f6589c = r11;
        d = new IESGurdResFrom[]{r5, r10, r11};
    }

    public IESGurdResFrom(String r5, int r10) {
        super(r5, r10);
    }

    public static IESGurdResFrom valueOf(String r5) {
        return (IESGurdResFrom) Enum.valueOf(IESGurdResFrom.class, r5);
    }

    public static IESGurdResFrom[] values() {
        return (IESGurdResFrom[]) d.clone();
    }
}

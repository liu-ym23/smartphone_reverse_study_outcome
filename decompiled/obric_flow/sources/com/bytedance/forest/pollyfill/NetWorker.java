package com.bytedance.forest.pollyfill;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/pollyfill/NetWorker;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum NetWorker extends Enum<NetWorker> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetWorker f4465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NetWorker f4466b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ NetWorker[] f4467c = null;

    static {
        NetWorker r5 = new NetWorker("TTNet", 0);
        f4465a = r5;
        NetWorker r10 = new NetWorker("Downloader", 1);
        f4466b = r10;
        f4467c = new NetWorker[]{r5, r10};
    }

    public NetWorker(String r5, int r10) {
        super(r5, r10);
    }

    public static NetWorker valueOf(String r5) {
        return (NetWorker) Enum.valueOf(NetWorker.class, r5);
    }

    public static NetWorker[] values() {
        return (NetWorker[]) f4467c.clone();
    }
}

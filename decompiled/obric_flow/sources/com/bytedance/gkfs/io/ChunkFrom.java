package com.bytedance.gkfs.io;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/gkfs/io/ChunkFrom;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ChunkFrom extends Enum<ChunkFrom> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChunkFrom f4834b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ChunkFrom f4835c = null;
    public static final /* synthetic */ ChunkFrom[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4836a;

    static {
        ChunkFrom r5 = new ChunkFrom("Parallel", 0, "parallel_cache");
        f4834b = r5;
        ChunkFrom r10 = new ChunkFrom("Disk", 1, "disk");
        f4835c = r10;
        d = new ChunkFrom[]{r5, r10, new ChunkFrom("Global", 2, "global_cache")};
    }

    public ChunkFrom(String r5, int r10, String r11) {
        super(r5, r10);
        this.f4836a = r11;
    }

    public static ChunkFrom valueOf(String r5) {
        return (ChunkFrom) Enum.valueOf(ChunkFrom.class, r5);
    }

    public static ChunkFrom[] values() {
        return (ChunkFrom[]) d.clone();
    }
}

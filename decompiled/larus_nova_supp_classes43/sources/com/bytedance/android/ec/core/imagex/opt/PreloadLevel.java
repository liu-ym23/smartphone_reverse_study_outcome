package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/PreloadLevel;", "", "ParseUrl", "DiskCache", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum PreloadLevel extends Enum<PreloadLevel> {
    public static final PreloadLevel DiskCache = null;
    public static final PreloadLevel ParseUrl = null;
    public static final /* synthetic */ PreloadLevel[] a = null;

    static {
        PreloadLevel r1 = new PreloadLevel("ParseUrl", 0);
        ParseUrl = r1;
        PreloadLevel r10 = new PreloadLevel("DiskCache", 1);
        DiskCache = r10;
        a = new PreloadLevel[]{r1, r10};
    }

    public static PreloadLevel valueOf(String r1) {
        return (PreloadLevel) r27.a.a(PreloadLevel.class, r1);
    }

    public static PreloadLevel[] values() {
        return (PreloadLevel[]) a.clone();
    }

    public PreloadLevel(String r1, int r10) {
        super(r1, r10);
    }
}

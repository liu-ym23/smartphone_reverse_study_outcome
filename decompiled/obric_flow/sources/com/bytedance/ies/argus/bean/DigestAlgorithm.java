package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/DigestAlgorithm;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum DigestAlgorithm extends Enum<DigestAlgorithm> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DigestAlgorithm f5114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DigestAlgorithm[] f5115b = null;

    static {
        DigestAlgorithm r5 = new DigestAlgorithm();
        f5114a = r5;
        f5115b = new DigestAlgorithm[]{r5};
    }

    public DigestAlgorithm() {
        super("SHA256", 0);
    }

    public static DigestAlgorithm valueOf(String r5) {
        return (DigestAlgorithm) Enum.valueOf(DigestAlgorithm.class, r5);
    }

    public static DigestAlgorithm[] values() {
        return (DigestAlgorithm[]) f5115b.clone();
    }
}

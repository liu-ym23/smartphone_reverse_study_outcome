package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/EncryptAlgorithm;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum EncryptAlgorithm extends Enum<EncryptAlgorithm> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EncryptAlgorithm f5116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EncryptAlgorithm[] f5117b = null;

    static {
        EncryptAlgorithm r5 = new EncryptAlgorithm();
        f5116a = r5;
        f5117b = new EncryptAlgorithm[]{r5};
    }

    public EncryptAlgorithm() {
        super("RSA", 0);
    }

    public static EncryptAlgorithm valueOf(String r5) {
        return (EncryptAlgorithm) Enum.valueOf(EncryptAlgorithm.class, r5);
    }

    public static EncryptAlgorithm[] values() {
        return (EncryptAlgorithm[]) f5117b.clone();
    }
}

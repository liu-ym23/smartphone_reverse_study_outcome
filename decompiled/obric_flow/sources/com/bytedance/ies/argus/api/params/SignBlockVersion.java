package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/api/params/SignBlockVersion;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum SignBlockVersion extends Enum<SignBlockVersion> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SignBlockVersion f4964b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SignBlockVersion f4965c = null;
    public static final /* synthetic */ SignBlockVersion[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4966a;

    static {
        SignBlockVersion r5 = new SignBlockVersion("OLD", 0, "old");
        f4964b = r5;
        SignBlockVersion r10 = new SignBlockVersion("NEW", 1, "new");
        f4965c = r10;
        d = new SignBlockVersion[]{r5, r10};
    }

    public SignBlockVersion(String r5, int r10, String r11) {
        super(r5, r10);
        this.f4966a = r11;
    }

    public static SignBlockVersion valueOf(String r5) {
        return (SignBlockVersion) Enum.valueOf(SignBlockVersion.class, r5);
    }

    public static SignBlockVersion[] values() {
        return (SignBlockVersion[]) d.clone();
    }
}

package com.bytedance.android.live.profile.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/model/CompareOperation;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Nothing", "Create", "Update", "Remove", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CompareOperation extends Enum<CompareOperation> {
    public static final CompareOperation Create = null;
    public static final CompareOperation Nothing = null;
    public static final CompareOperation Remove = null;
    public static final CompareOperation Update = null;
    public static final /* synthetic */ CompareOperation[] a = null;
    private final String desc;

    static {
        CompareOperation r1 = new CompareOperation("Nothing", 0, "Nothing");
        Nothing = r1;
        CompareOperation r2 = new CompareOperation("Create", 1, "Create");
        Create = r2;
        CompareOperation r3 = new CompareOperation("Update", 2, "Update");
        Update = r3;
        CompareOperation r4 = new CompareOperation("Remove", 3, "Remove");
        Remove = r4;
        a = new CompareOperation[]{r1, r2, r3, r4};
    }

    public static CompareOperation valueOf(String r1) {
        return (CompareOperation) r27.a.a(CompareOperation.class, r1);
    }

    public static CompareOperation[] values() {
        return (CompareOperation[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public CompareOperation(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}

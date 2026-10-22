package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/permission/StorageScope;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVATE", "APPLET", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorageScope extends Enum<StorageScope> {
    public static final StorageScope APPLET = null;
    public static final StorageScope PRIVATE = null;
    public static final /* synthetic */ StorageScope[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StorageScope> getEntries() {
        return b;
    }

    static {
        StorageScope r0 = new StorageScope("PRIVATE", 0);
        PRIVATE = r0;
        StorageScope r1 = new StorageScope("APPLET", 1);
        APPLET = r1;
        StorageScope[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static StorageScope[] values() {
        return (StorageScope[]) a.clone();
    }

    public static StorageScope valueOf(String r1) {
        return (StorageScope) r27.a.a(StorageScope.class, r1);
    }

    public StorageScope(String r1, int r10) {
        super(r1, r10);
    }
}

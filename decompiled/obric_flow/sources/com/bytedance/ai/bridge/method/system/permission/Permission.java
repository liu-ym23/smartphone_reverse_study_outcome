package com.bytedance.ai.bridge.method.system.permission;

import f2.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/Permission;", "", "f2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Permission extends Enum<Permission> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Permission f2013c = null;
    public static final Permission d = null;
    public static final Permission e = null;
    public static final /* synthetic */ Permission[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2014a;

    static {
        Permission r5 = new Permission("CAMERA", 0, CollectionsKt.listOf("android.permission.CAMERA"));
        Permission r10 = new Permission("MICROPHONE", 1, CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        Permission r11 = new Permission("PHOTOALBUM", 2, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}));
        Permission r12 = new Permission("VIBRATE", 3, CollectionsKt.listOf("android.permission.VIBRATE"));
        Permission r13 = new Permission("READ_CALENDAR", 4, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        Permission r14 = new Permission("WRITE_CALENDAR", 5, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        Permission r15 = new Permission("CALENDAR", 6, CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
        Permission r16 = new Permission("NOTIFICATION", 7, CollectionsKt.listOf(""));
        f2013c = r16;
        Permission r17 = new Permission("LOCATION", 8, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        d = r17;
        Permission r18 = new Permission("UNKNOWN", 9, CollectionsKt.listOf(null));
        e = r18;
        Permission[] r19 = {r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        f = r19;
        EnumEntriesKt.enumEntries(r19);
        f2012b = new a();
    }

    public Permission(String r5, int r10, List r11) {
        super(r5, r10);
        this.f2014a = r11;
    }

    public static Permission valueOf(String r5) {
        return (Permission) Enum.valueOf(Permission.class, r5);
    }

    public static Permission[] values() {
        return (Permission[]) f.clone();
    }
}

package com.ss.android.lark.officesdk.di.core.deps;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/StorageVolume;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_FILES", "INTERNAL_CACHE", "INTERNAL_ROOT", "EXTERNAL_FILES", "EXTERNAL_CACHE", "PUBLIC_ROOT", "PUBLIC_PICTURES", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum StorageVolume extends Enum<StorageVolume> {
    public static final StorageVolume EXTERNAL_CACHE = null;
    public static final StorageVolume EXTERNAL_FILES = null;
    public static final StorageVolume INTERNAL_CACHE = null;
    public static final StorageVolume INTERNAL_FILES = null;
    public static final StorageVolume INTERNAL_ROOT = null;
    public static final StorageVolume PUBLIC_PICTURES = null;
    public static final StorageVolume PUBLIC_ROOT = null;
    public static final /* synthetic */ StorageVolume[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StorageVolume> getEntries() {
        return b;
    }

    static {
        StorageVolume r0 = new StorageVolume("INTERNAL_FILES", 0);
        INTERNAL_FILES = r0;
        StorageVolume r1 = new StorageVolume("INTERNAL_CACHE", 1);
        INTERNAL_CACHE = r1;
        StorageVolume r3 = new StorageVolume("INTERNAL_ROOT", 2);
        INTERNAL_ROOT = r3;
        StorageVolume r5 = new StorageVolume("EXTERNAL_FILES", 3);
        EXTERNAL_FILES = r5;
        StorageVolume r7 = new StorageVolume("EXTERNAL_CACHE", 4);
        EXTERNAL_CACHE = r7;
        StorageVolume r9 = new StorageVolume("PUBLIC_ROOT", 5);
        PUBLIC_ROOT = r9;
        StorageVolume r11 = new StorageVolume("PUBLIC_PICTURES", 6);
        PUBLIC_PICTURES = r11;
        StorageVolume[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static StorageVolume[] values() {
        return (StorageVolume[]) a.clone();
    }

    public static StorageVolume valueOf(String r1) {
        return (StorageVolume) a.a(StorageVolume.class, r1);
    }

    public StorageVolume(String r1, int r2) {
        super(r1, r2);
    }
}

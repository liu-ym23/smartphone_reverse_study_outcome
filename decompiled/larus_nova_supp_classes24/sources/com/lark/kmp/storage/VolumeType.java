package com.lark.kmp.storage;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/lark/kmp/storage/VolumeType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FILES", "CACHE", "PREFERENCE", "EXTERNAL_FILES", "EXTERNAL_CACHE", "lark-storage-kmp_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum VolumeType extends Enum<VolumeType> {
    public static final VolumeType CACHE = null;
    public static final VolumeType EXTERNAL_CACHE = null;
    public static final VolumeType EXTERNAL_FILES = null;
    public static final VolumeType FILES = null;
    public static final VolumeType PREFERENCE = null;
    public static final /* synthetic */ VolumeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<VolumeType> getEntries() {
        return b;
    }

    static {
        VolumeType r0 = new VolumeType("FILES", 0, "files");
        FILES = r0;
        VolumeType r1 = new VolumeType("CACHE", 1, "cache");
        CACHE = r1;
        VolumeType r2 = new VolumeType("PREFERENCE", 2, "preference");
        PREFERENCE = r2;
        VolumeType r4 = new VolumeType("EXTERNAL_FILES", 3, "external_files");
        EXTERNAL_FILES = r4;
        VolumeType r6 = new VolumeType("EXTERNAL_CACHE", 4, "external_cache");
        EXTERNAL_CACHE = r6;
        VolumeType[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static VolumeType[] values() {
        return (VolumeType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static VolumeType valueOf(String r1) {
        return (VolumeType) r27.a.a(VolumeType.class, r1);
    }

    public VolumeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}

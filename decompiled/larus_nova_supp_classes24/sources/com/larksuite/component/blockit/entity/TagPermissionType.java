package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum TagPermissionType extends Enum<TagPermissionType> {
    public static final TagPermissionType Default = null;
    public static final TagPermissionType Private = null;
    public static final TagPermissionType Public = null;
    public static final /* synthetic */ TagPermissionType[] a = null;
    int value;

    static {
        TagPermissionType r0 = new TagPermissionType("Default", 0, 0);
        Default = r0;
        TagPermissionType r1 = new TagPermissionType("Public", 1, 1);
        Public = r1;
        TagPermissionType r3 = new TagPermissionType("Private", 2, 2);
        Private = r3;
        a = new TagPermissionType[]{r0, r1, r3};
    }

    public static TagPermissionType[] values() {
        return (TagPermissionType[]) a.clone();
    }

    public int value() {
        return this.value;
    }

    public static TagPermissionType valueOf(String r1) {
        return (TagPermissionType) r27.a.a(TagPermissionType.class, r1);
    }

    public TagPermissionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

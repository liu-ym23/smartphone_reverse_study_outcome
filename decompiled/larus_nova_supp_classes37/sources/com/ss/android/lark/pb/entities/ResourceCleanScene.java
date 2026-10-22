package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ResourceCleanScene extends Enum<ResourceCleanScene> implements WireEnum {
    private static final /* synthetic */ ResourceCleanScene[] $VALUES = null;
    public static final ProtoAdapter<ResourceCleanScene> ADAPTER = null;
    public static final ResourceCleanScene CSAM_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
    public static final ResourceCleanScene UNKNOWN_RESOURCE_CLEAN_SCENE = null;
    private final int value;

    static {
        ResourceCleanScene r0 = new ResourceCleanScene("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
        UNKNOWN_RESOURCE_CLEAN_SCENE = r0;
        ResourceCleanScene r1 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
        UNIFIED_STORAGE_REGULARLY_DELETE = r1;
        ResourceCleanScene r3 = new ResourceCleanScene("CSAM_DELETE", 2, 2);
        CSAM_DELETE = r3;
        ResourceCleanScene r5 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
        UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r5;
        $VALUES = new ResourceCleanScene[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResourceCleanScene.class);
    }

    public static ResourceCleanScene[] values() {
        return (ResourceCleanScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceCleanScene fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
    L14:
        return CSAM_DELETE;
    L16:
        return UNIFIED_STORAGE_REGULARLY_DELETE;
    L18:
        return UNKNOWN_RESOURCE_CLEAN_SCENE;
    }

    public static ResourceCleanScene valueOf(String r1) {
        return (ResourceCleanScene) a.a(ResourceCleanScene.class, r1);
    }

    private ResourceCleanScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

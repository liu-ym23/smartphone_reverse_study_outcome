package com.ss.android.lark.image.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/image/entity/ResourceCleanScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_RESOURCE_CLEAN_SCENE", "UNIFIED_STORAGE_REGULARLY_DELETE", "CSAM_DELETE", "UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", "isCSAMDelete", "", "isPersonalDelete", "isUnifiedRegularDelete", "Companion", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ResourceCleanScene extends Enum<ResourceCleanScene> {
    public static final ResourceCleanScene CSAM_DELETE = null;
    public static final a Companion = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE = null;
    public static final ResourceCleanScene UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = null;
    public static final ResourceCleanScene UNKNOWN_RESOURCE_CLEAN_SCENE = null;
    public static final /* synthetic */ ResourceCleanScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static ResourceCleanScene a(com.bytedance.lark.pb.basic.v1.ResourceCleanScene r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            int r4 = r3.clean_resource_scene.getValue();
            ResourceCleanScene r0 = ResourceCleanScene.UNKNOWN_RESOURCE_CLEAN_SCENE;
            if (r4 == r0.getValue()) goto L19;
            ResourceCleanScene r1 = ResourceCleanScene.UNIFIED_STORAGE_REGULARLY_DELETE;
            if (r4 == r1.getValue()) goto L17;
            r1 = ResourceCleanScene.CSAM_DELETE;
            if (r4 == r1.getValue()) goto L17;
            r1 = ResourceCleanScene.UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER;
            if (r4 == r1.getValue()) goto L17;
            return r0;
        L17:
            return r1;
        L19:
            return r0;
        }

        public static HashMap b(Map r4) {
            if (r4 == null) goto L4;
            HashMap r0 = new HashMap();
            Iterator r5 = r4.entrySet().iterator();
        L7:
            if (r5.hasNext() == false) goto L11;
            Map.Entry r1 = (Map.Entry) r5.next();
            a r2 = ResourceCleanScene.Companion;
            com.bytedance.lark.pb.basic.v1.ResourceCleanScene r3 = (com.bytedance.lark.pb.basic.v1.ResourceCleanScene) r1.getValue();
            r2.getClass();
            ResourceCleanScene r6 = a(r3);
            if (r6 == null) goto L7;
            r0.put(r1.getKey(), r6);
            goto L7
        L11:
            return r0;
        L4:
            return new HashMap();
        }
    }

    public static EnumEntries<ResourceCleanScene> getEntries() {
        return b;
    }

    static {
        ResourceCleanScene r0 = new ResourceCleanScene("UNKNOWN_RESOURCE_CLEAN_SCENE", 0, 0);
        UNKNOWN_RESOURCE_CLEAN_SCENE = r0;
        ResourceCleanScene r1 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE", 1, 1);
        UNIFIED_STORAGE_REGULARLY_DELETE = r1;
        ResourceCleanScene r3 = new ResourceCleanScene("CSAM_DELETE", 2, 2);
        CSAM_DELETE = r3;
        ResourceCleanScene r5 = new ResourceCleanScene("UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER", 3, 3);
        UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER = r5;
        ResourceCleanScene[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static ResourceCleanScene[] values() {
        return (ResourceCleanScene[]) a.clone();
    }

    public final boolean isCSAMDelete() {
        if (this.value != CSAM_DELETE.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPersonalDelete() {
        if (this.value != UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUnifiedRegularDelete() {
        int r0 = this.value;
        if (r0 >= CSAM_DELETE.value) goto L5;
    L8:
        return true;
    L5:
        if (r0 == UNIFIED_STORAGE_REGULARLY_DELETE_BY_USER.value) goto L8;
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceCleanScene valueOf(String r1) {
        return (ResourceCleanScene) r27.a.a(ResourceCleanScene.class, r1);
    }

    public ResourceCleanScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}

package com.ss.android.lark.export.entity;

import com.bytedance.lark.pb.basic.v1.EngineEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J)\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003Ju\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R1\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "Ljava/io/Serializable;", "rootId", BuildConfig.FLAVOR, "elements", "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/CardComponent;", "Lkotlin/collections/HashMap;", "pbEngineEntityMap", "Lcom/bytedance/lark/pb/basic/v1/EngineEntity;", "widthMode", "Lcom/ss/android/lark/export/entity/WidthMode;", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/ss/android/lark/export/entity/WidthMode;)V", "getRootId", "()Ljava/lang/String;", "getElements", "()Ljava/util/HashMap;", "getPbEngineEntityMap", "getWidthMode", "()Lcom/ss/android/lark/export/entity/WidthMode;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderRouterEntity implements Serializable {
    private final HashMap<String, CardComponent> elements;
    private final HashMap<String, EngineEntity> pbEngineEntityMap;
    private final String rootId;
    private final WidthMode widthMode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RenderRouterEntity copy$default(RenderRouterEntity r0, String r1, HashMap r2, HashMap r3, WidthMode r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.rootId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.elements;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.pbEngineEntityMap;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.widthMode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.rootId;
    }

    public final HashMap<String, CardComponent> component2() {
        return this.elements;
    }

    public final HashMap<String, EngineEntity> component3() {
        return this.pbEngineEntityMap;
    }

    public final WidthMode component4() {
        return this.widthMode;
    }

    public final RenderRouterEntity copy(String r2, HashMap<String, CardComponent> r3, HashMap<String, EngineEntity> r4, WidthMode r5) {
        return new RenderRouterEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RenderRouterEntity) == true) goto L8;
        return false;
    L8:
        RenderRouterEntity r6 = (RenderRouterEntity) r5;
        if (Intrinsics.areEqual(this.rootId, r6.rootId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.elements, r6.elements) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pbEngineEntityMap, r6.pbEngineEntityMap) == true) goto L18;
        return false;
    L18:
        if (this.widthMode == r6.widthMode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.rootId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, CardComponent> r4 = this.elements;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, EngineEntity> r7 = this.pbEngineEntityMap;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        WidthMode r10 = this.widthMode;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RenderRouterEntity(rootId=" + this.rootId + ", elements=" + this.elements + ", pbEngineEntityMap=" + this.pbEngineEntityMap + ", widthMode=" + this.widthMode + ')';
    }

    public final HashMap<String, CardComponent> getElements() {
        return this.elements;
    }

    public final HashMap<String, EngineEntity> getPbEngineEntityMap() {
        return this.pbEngineEntityMap;
    }

    public final String getRootId() {
        return this.rootId;
    }

    public final WidthMode getWidthMode() {
        return this.widthMode;
    }

    public RenderRouterEntity(String r1, HashMap<String, CardComponent> r2, HashMap<String, EngineEntity> r3, WidthMode r4) {
        this.rootId = r1;
        this.elements = r2;
        this.pbEngineEntityMap = r3;
        this.widthMode = r4;
    }

    public /* synthetic */ RenderRouterEntity(String r1, HashMap r2, HashMap r3, WidthMode r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}

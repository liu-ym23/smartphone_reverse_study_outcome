package com.obric.capabilitykit.entity.search.global;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchEntity;", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", TrackerImpl.PARAMS, "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Ljava/util/List;)V", "getAppEntity", "()Lcom/obric/capabilitykit/entity/app/AppEntity;", "getParams", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchEntity {
    private final AppEntity appEntity;
    private final List<InAppSearchEntityParam> params;

    public GlobalSearchEntity(AppEntity r3, List<InAppSearchEntityParam> r4) {
        List<InAppSearchEntityParam> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "appEntity");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        this.appEntity = r3;
        this.params = r5;
    }

    public static /* synthetic */ GlobalSearchEntity copy$default(GlobalSearchEntity r1, AppEntity r2, List r3, int r4, Object r5) {
        List<InAppSearchEntityParam> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.appEntity;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.params;
    L9:
        return r1.copy(r2, r6);
    }

    public final AppEntity component1() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> component2() {
        return this.params;
    }

    public final GlobalSearchEntity copy(AppEntity r2, List<InAppSearchEntityParam> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "appEntity");
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        return new GlobalSearchEntity(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchEntity.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchEntity r6 = (GlobalSearchEntity) ZeusTransformUtils.preCheckCast(r5, GlobalSearchEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appEntity, r6.appEntity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.appEntity.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "GlobalSearchEntity(appEntity=" + this.appEntity + ", params=" + this.params + ')';
    }
}

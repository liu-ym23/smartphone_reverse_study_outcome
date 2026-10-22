package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StrategyCacheClearModel;", "", "management_cmd", "", "Lcom/ss/ugc/effectplatform/model/net/StrategyCacheClearCmd;", "(Ljava/util/List;)V", "getManagement_cmd", "()Ljava/util/List;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StrategyCacheClearModel {
    private final List<StrategyCacheClearCmd> management_cmd;

    public StrategyCacheClearModel() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StrategyCacheClearModel copy$default(StrategyCacheClearModel r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.management_cmd;
    L6:
        return r0.copy(r1);
    }

    public final List<StrategyCacheClearCmd> component1() {
        return this.management_cmd;
    }

    public final StrategyCacheClearModel copy(List<StrategyCacheClearCmd> r2) {
        return new StrategyCacheClearModel(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof StrategyCacheClearModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.management_cmd, ((StrategyCacheClearModel) r2).management_cmd) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        List<StrategyCacheClearCmd> r0 = this.management_cmd;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "StrategyCacheClearModel(management_cmd=" + this.management_cmd + ")";
    }

    public final List<StrategyCacheClearCmd> getManagement_cmd() {
        return this.management_cmd;
    }

    public StrategyCacheClearModel(List<StrategyCacheClearCmd> r1) {
        this.management_cmd = r1;
    }

    public /* synthetic */ StrategyCacheClearModel(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}

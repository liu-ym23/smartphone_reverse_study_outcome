package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019JD\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PreloadResponseModel;", "", "preload_resource_list", "", "Lcom/ss/ugc/effectplatform/model/net/PreloadResourceList;", "delete_cmd", "Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "busi_info", "Lcom/ss/ugc/effectplatform/model/net/Busi_info;", "protection_period", "", "(Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;Lcom/ss/ugc/effectplatform/model/net/Busi_info;Ljava/lang/Long;)V", "getBusi_info", "()Lcom/ss/ugc/effectplatform/model/net/Busi_info;", "setBusi_info", "(Lcom/ss/ugc/effectplatform/model/net/Busi_info;)V", "getDelete_cmd", "()Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "setDelete_cmd", "(Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;)V", "getPreload_resource_list", "()Ljava/util/List;", "setPreload_resource_list", "(Ljava/util/List;)V", "getProtection_period", "()Ljava/lang/Long;", "setProtection_period", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;Lcom/ss/ugc/effectplatform/model/net/Busi_info;Ljava/lang/Long;)Lcom/ss/ugc/effectplatform/model/net/PreloadResponseModel;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PreloadResponseModel {
    private Busi_info busi_info;
    private DeleteCmd delete_cmd;
    private List<PreloadResourceList> preload_resource_list;
    private Long protection_period;

    public PreloadResponseModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadResponseModel copy$default(PreloadResponseModel r0, List r1, DeleteCmd r2, Busi_info r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.preload_resource_list;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.delete_cmd;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.busi_info;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.protection_period;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<PreloadResourceList> component1() {
        return this.preload_resource_list;
    }

    public final DeleteCmd component2() {
        return this.delete_cmd;
    }

    public final Busi_info component3() {
        return this.busi_info;
    }

    public final Long component4() {
        return this.protection_period;
    }

    public final PreloadResponseModel copy(List<PreloadResourceList> r2, DeleteCmd r3, Busi_info r4, Long r5) {
        return new PreloadResponseModel(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PreloadResponseModel) == false) goto L14;
        PreloadResponseModel r4 = (PreloadResponseModel) r3;
        if (Intrinsics.areEqual(this.preload_resource_list, r4.preload_resource_list) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.delete_cmd, r4.delete_cmd) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.busi_info, r4.busi_info) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.protection_period, r4.protection_period) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<PreloadResourceList> r0 = this.preload_resource_list;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        DeleteCmd r4 = this.delete_cmd;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Busi_info r7 = this.busi_info;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.protection_period;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PreloadResponseModel(preload_resource_list=" + this.preload_resource_list + ", delete_cmd=" + this.delete_cmd + ", busi_info=" + this.busi_info + ", protection_period=" + this.protection_period + ")";
    }

    public final Busi_info getBusi_info() {
        return this.busi_info;
    }

    public final DeleteCmd getDelete_cmd() {
        return this.delete_cmd;
    }

    public final List<PreloadResourceList> getPreload_resource_list() {
        return this.preload_resource_list;
    }

    public final Long getProtection_period() {
        return this.protection_period;
    }

    public final void setBusi_info(Busi_info r1) {
        this.busi_info = r1;
    }

    public final void setDelete_cmd(DeleteCmd r1) {
        this.delete_cmd = r1;
    }

    public final void setPreload_resource_list(List<PreloadResourceList> r1) {
        this.preload_resource_list = r1;
    }

    public final void setProtection_period(Long r1) {
        this.protection_period = r1;
    }

    public PreloadResponseModel(List<PreloadResourceList> r1, DeleteCmd r2, Busi_info r3, Long r4) {
        this.preload_resource_list = r1;
        this.delete_cmd = r2;
        this.busi_info = r3;
        this.protection_period = r4;
    }

    public /* synthetic */ PreloadResponseModel(List r2, DeleteCmd r3, Busi_info r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0L;
    L14:
        this(r2, r3, r4, r5);
    }
}

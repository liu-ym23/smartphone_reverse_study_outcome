package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/DeleteCmd;", "", "busi_key_list", "", "", "resource_key_list", "(Ljava/util/List;Ljava/util/List;)V", "getBusi_key_list", "()Ljava/util/List;", "setBusi_key_list", "(Ljava/util/List;)V", "getResource_key_list", "setResource_key_list", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class DeleteCmd {
    private List<String> busi_key_list;
    private List<String> resource_key_list;

    public DeleteCmd() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteCmd copy$default(DeleteCmd r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.busi_key_list;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.resource_key_list;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.busi_key_list;
    }

    public final List<String> component2() {
        return this.resource_key_list;
    }

    public final DeleteCmd copy(List<String> r2, List<String> r3) {
        return new DeleteCmd(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DeleteCmd) == false) goto L10;
        DeleteCmd r4 = (DeleteCmd) r3;
        if (Intrinsics.areEqual(this.busi_key_list, r4.busi_key_list) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.resource_key_list, r4.resource_key_list) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.busi_key_list;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.resource_key_list;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "DeleteCmd(busi_key_list=" + this.busi_key_list + ", resource_key_list=" + this.resource_key_list + ")";
    }

    public final List<String> getBusi_key_list() {
        return this.busi_key_list;
    }

    public final List<String> getResource_key_list() {
        return this.resource_key_list;
    }

    public final void setBusi_key_list(List<String> r1) {
        this.busi_key_list = r1;
    }

    public final void setResource_key_list(List<String> r1) {
        this.resource_key_list = r1;
    }

    public DeleteCmd(List<String> r1, List<String> r2) {
        this.busi_key_list = r1;
        this.resource_key_list = r2;
    }

    public /* synthetic */ DeleteCmd(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}

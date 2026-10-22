package com.ss.android.lark.framework.assembly.diskmanage;

import android.content.Context;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/framework/assembly/diskmanage/RustResource;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/HasFilePath;", "userIds", "", "", "<init>", "(Ljava/util/List;)V", "getUserIds", "()Ljava/util/List;", "getBiz", "Lcom/ss/android/lark/diskmanage/Biz;", "getFilePaths", "context", "Landroid/content/Context;", "toString", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "diskmanage-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RustResource implements PersistentResource, voc.a {
    private final List<String> userIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RustResource copy$default(RustResource r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.userIds;
    L6:
        return r0.copy(r1);
    }

    public final List<String> component1() {
        return this.userIds;
    }

    public final RustResource copy(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        return new RustResource(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof RustResource) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userIds, ((RustResource) r4).userIds) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.userIds.hashCode();
    }

    @Override // com.suite.lark.platform.component.storage.clean.f
    public long progressWeight() {
        return 1;
    }

    public String toString() {
        return "(userIds=" + this.userIds + ", biz=" + Biz.RUST + ')';
    }

    public Biz getBiz() {
        return Biz.RUST;
    }

    public final List<String> getUserIds() {
        return this.userIds;
    }

    public RustResource(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "userIds");
        this.userIds = r2;
    }

    @Override // voc.a
    public List<String> getFilePaths(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.userIds.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(com.ss.android.lark.diskmanage.storage.d.p(r6) + s.c((String) r1.next()));
        goto L4
    L6:
        return r0;
    }
}

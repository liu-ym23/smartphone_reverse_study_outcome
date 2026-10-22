package com.suite.lark.platform.component.storage.clean.resource;

import android.content.Context;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import voc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/SPFileResource;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/HasFilePath;", "Lcom/suite/lark/platform/component/storage/clean/resource/HasKVWhitelist;", "spName", "", "biz", "Lcom/ss/android/lark/diskmanage/Biz;", "whitelistKeys", "", "Lcom/suite/lark/platform/component/storage/clean/resource/KVWhitelistItem;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/diskmanage/Biz;Ljava/util/List;)V", "getSpName", "()Ljava/lang/String;", "getWhitelistKeys", "()Ljava/util/List;", "getBiz", "progressWeight", "", "getFilePaths", "context", "Landroid/content/Context;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SPFileResource implements PersistentResource, a {
    private final Biz biz;
    private final String spName;
    private final List<Object> whitelistKeys;

    @Override // com.suite.lark.platform.component.storage.clean.f
    public long progressWeight() {
        return 1;
    }

    public int hashCode() {
        return (this.spName.hashCode() * 31) + this.biz.hashCode();
    }

    public String toString() {
        return "spName:" + this.spName + ", biz:" + this.biz + ", whitelistKeys:" + getWhitelistKeys() + ", weight:" + progressWeight();
    }

    public Biz getBiz() {
        return this.biz;
    }

    public final String getSpName() {
        return this.spName;
    }

    public List<Object> getWhitelistKeys() {
        return this.whitelistKeys;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SPFileResource) == true) goto L8;
        return false;
    L8:
        SPFileResource r6 = (SPFileResource) r5;
        if (Intrinsics.areEqual(this.spName, r6.spName) == true) goto L12;
        return false;
    L12:
        if (this.biz == r6.biz) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // voc.a
    public List<String> getFilePaths(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return CollectionsKt.listOf(r2.getFilesDir().getParent() + "/shared_prefs/" + this.spName + ".xml");
    }

    public SPFileResource(String r2, Biz r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "spName");
        Intrinsics.checkNotNullParameter(r3, "biz");
        Intrinsics.checkNotNullParameter(r4, "whitelistKeys");
        this.spName = r2;
        this.biz = r3;
        this.whitelistKeys = r4;
    }

    public /* synthetic */ SPFileResource(String r1, Biz r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        this(r1, r2, r3);
    }
}

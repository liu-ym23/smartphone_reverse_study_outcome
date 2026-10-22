package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshPropList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/l2;", "propList", "Ljava/util/List;", "getPropList", "()Ljava/util/List;", BuildConfig.FLAVOR, "update", "Z", "getUpdate", "()Z", "<init>", "(Ljava/util/List;Z)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RefreshPropList extends GiftRepoAction {

    @TraceExclude
    private final List<l2> propList;
    private final boolean update;

    public final List<l2> getPropList() {
        return this.propList;
    }

    public final boolean getUpdate() {
        return this.update;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RefreshPropList(List<? extends l2> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "propList");
        super("RefreshPropList");
        this.propList = r2;
        this.update = r3;
    }

    public /* synthetic */ RefreshPropList(List r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }
}

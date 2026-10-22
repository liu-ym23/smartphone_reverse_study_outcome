package com.ss.android.lark.officesdk.api.service.capacity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/api/service/capacity/NullAppBaseInfoImpl;", "Lcom/ss/android/lark/officesdk/api/service/capacity/IOfficeAppBaseInfo;", "<init>", "()V", "getAppIcon", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "getDouBaoIcon", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class NullAppBaseInfoImpl implements IOfficeAppBaseInfo {
    public NullAppBaseInfoImpl() {
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getAppIcon(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getDouBaoIcon(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public boolean isEnterpriseAccount() {
        return IOfficeAppBaseInfo.DefaultImpls.isEnterpriseAccount(this);
    }

    @Override // com.ss.android.lark.officesdk.api.service.capacity.IOfficeAppBaseInfo
    public Drawable getDouBaoLinearIcon(Context r1) {
        return IOfficeAppBaseInfo.DefaultImpls.getDouBaoLinearIcon(this, r1);
    }
}

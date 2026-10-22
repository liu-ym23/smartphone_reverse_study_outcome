package com.ss.android.lark.contact.base.common_ui;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/contact/base/common_ui/SimpleItemListAdapter;", "Lcom/ss/android/lark/contact/base/common_ui/BaseItemListAdapter;", "<init>", "()V", "dataList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/base/common_ui/ItemData;", "setItemDataList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "updateItemData", "item", "addItemData", "pos", BuildConfig.FLAVOR, "getItemData", BuildConfig.FLAVOR, "position", "getItemCount", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleItemListAdapter extends BaseItemListAdapter {
    public final List<e> c;

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public SimpleItemListAdapter() {
        this.c = new ArrayList();
    }

    @Override // com.ss.android.lark.contact.base.common_ui.BaseItemListAdapter
    public final Object y2(int r2) {
        if (r2 < getItemCount()) goto L7;
        return null;
    L7:
        return (e) ListProtector.get(this.c, r2);
    }
}

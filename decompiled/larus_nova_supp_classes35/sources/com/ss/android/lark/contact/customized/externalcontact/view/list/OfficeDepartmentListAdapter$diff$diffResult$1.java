package com.ss.android.lark.contact.customized.externalcontact.view.list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$diff$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getOldListSize", BuildConfig.FLAVOR, "getNewListSize", "areItemsTheSame", BuildConfig.FLAVOR, "oldItemPosition", "newItemPosition", "areContentsTheSame", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDepartmentListAdapter$diff$diffResult$1 extends DiffUtil.Callback {
    public final int getNewListSize() {
        throw null;
    }

    public final int getOldListSize() {
        throw null;
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(ListProtector.get(null, r2), ListProtector.get(null, r3));
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        if (((mtb.c) ListProtector.get(null, r2)).hashCode() != ((mtb.c) ListProtector.get(null, r3)).hashCode()) goto L5;
        return true;
    L5:
        return false;
    }
}

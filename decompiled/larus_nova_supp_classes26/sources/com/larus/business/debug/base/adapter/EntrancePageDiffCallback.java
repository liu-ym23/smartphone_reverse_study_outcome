package com.larus.business.debug.base.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.business.debug.base.register.EntranceGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntrancePageDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldEntranceGroupList", "", "Lcom/larus/business/debug/base/register/EntranceGroup;", "newEntranceGroupList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntrancePageDiffCallback extends DiffUtil.Callback {
    public final List<EntranceGroup> a;
    public final List<EntranceGroup> b;

    public final boolean areContentsTheSame(int r1, int r2) {
        return false;
    }

    public final boolean areItemsTheSame(int r1, int r2) {
        return false;
    }

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public EntrancePageDiffCallback(List<EntranceGroup> r2, List<EntranceGroup> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldEntranceGroupList");
        Intrinsics.checkNotNullParameter(r3, "newEntranceGroupList");
        this.a = r2;
        this.b = r3;
    }
}

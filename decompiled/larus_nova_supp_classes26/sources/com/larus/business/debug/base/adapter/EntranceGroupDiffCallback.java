package com.larus.business.debug.base.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntranceGroupDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/larus/business/debug/base/register/DebugEntrance;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceGroupDiffCallback extends DiffUtil.Callback {
    public final List<e> a;
    public final List<e> b;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntranceGroupDiffCallback(List<? extends e> r2, List<? extends e> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldList");
        Intrinsics.checkNotNullParameter(r3, "newList");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        e r4 = (e) ListProtector.get(this.a, r2);
        e r5 = (e) ListProtector.get(this.b, r3);
        return Intrinsics.areEqual(r4.toString(), r5.toString());
    }

    public final boolean areItemsTheSame(int r1, int r2) {
        return areContentsTheSame(r1, r2);
    }
}

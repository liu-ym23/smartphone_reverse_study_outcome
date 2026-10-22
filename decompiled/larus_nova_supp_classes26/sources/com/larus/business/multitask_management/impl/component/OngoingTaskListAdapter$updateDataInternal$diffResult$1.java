package com.larus.business.multitask_management.impl.component;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.multitask_management.api.data.TaskUITemplate;
import java.util.List;
import kl9.u;
import kl9.x;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/larus/business/multitask_management/impl/component/OngoingTaskListAdapter$updateDataInternal$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskListAdapter$updateDataInternal$diffResult$1 extends DiffUtil.Callback {
    public final /* synthetic */ List<u> a;
    public final /* synthetic */ List<u> b;
    public final /* synthetic */ OngoingTaskListAdapter c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;
    public final /* synthetic */ boolean g;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public final boolean areContentsTheSame(int r8, int r9) {
        u r0 = (u) CollectionsKt.getOrNull(this.a, r8);
        u r1 = (u) CollectionsKt.getOrNull(this.b, r9);
        if (r0 == null) goto L11;
        if (r1 == null) goto L14;
        OngoingTaskListAdapter r3 = this.c;
        int r4 = this.d;
        boolean r5 = this.e;
        int r6 = OngoingTaskListAdapter.m;
        boolean r10 = r3.B2(r8, r4, r5);
        boolean r11 = this.c.B2(r9, this.f, this.g);
        if (Intrinsics.areEqual(r0, r1) == false) goto L12;
        if (r10 != r11) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    L11:
        return false;
    }

    public final boolean areItemsTheSame(int r4, int r5) {
        u r6 = (u) CollectionsKt.getOrNull(this.a, r4);
        u r7 = (u) CollectionsKt.getOrNull(this.b, r5);
        if (r6 == null) goto L7;
        x r0 = r6.i;
        if (r0 == null) goto L7;
        int r1 = r0.h;
    L8:
        if (r7 == null) goto L12;
        x r2 = r7.i;
        if (r2 == null) goto L12;
        int r3 = r2.h;
    L13:
        String r8 = null;
        if (r6 == null) goto L16;
        String r9 = r6.a;
    L17:
        if (r7 == null) goto L20;
        r8 = r7.a;
    L20:
        if (Intrinsics.areEqual(r9, r8) == false) goto L23;
        if (r1 != r3) goto L23;
        return true;
    L23:
        return false;
    L16:
        r9 = null;
    L12:
        r3 = TaskUITemplate.DEFAULT.getValue();
    L7:
        r1 = TaskUITemplate.DEFAULT.getValue();
        goto L8
    }

    public OngoingTaskListAdapter$updateDataInternal$diffResult$1(List<u> r1, List<u> r2, OngoingTaskListAdapter r3, int r4, boolean r5, int r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}

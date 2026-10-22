package com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import qt0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/groupmember/GroupLiveMemberDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveMemberDiffCallback extends DiffUtil.Callback {
    public final List<a> a;
    public final List<a> b;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        List<a> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public GroupLiveMemberDiffCallback(List<a> r2, List<a> r3) {
        Intrinsics.checkNotNullParameter(r3, "newList");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r4, int r5) {
        List<a> r0 = this.a;
        Integer r1 = null;
        if (r0 == null) goto L9;
        a r2 = (a) ListProtector.get(r0, r4);
        if (r2 == null) goto L9;
        k r3 = r2.b;
        if (r3 == null) goto L9;
        String r6 = r3.getUri();
    L10:
        k r7 = ((a) ListProtector.get(this.b, r5)).b;
        if (r7 == null) goto L13;
        String r8 = r7.getUri();
    L15:
        if (Intrinsics.areEqual(r6, r8) == false) goto L32;
        List<a> r9 = this.a;
        if (r9 == null) goto L21;
        a r10 = (a) ListProtector.get(r9, r4);
        if (r10 == null) goto L21;
        String r12 = r10.c;
    L23:
        if (Intrinsics.areEqual(r12, ((a) ListProtector.get(this.b, r5)).c) == false) goto L32;
        List<a> r13 = this.a;
        if (r13 == null) goto L30;
        a r14 = (a) ListProtector.get(r13, r4);
        if (r14 == null) goto L30;
        r1 = r14.d;
    L30:
        if (Intrinsics.areEqual(r1, ((a) ListProtector.get(this.b, r5)).d) == false) goto L32;
        return true;
    L21:
        r12 = null;
    L32:
        return false;
    L13:
        r8 = null;
    L9:
        r6 = null;
        goto L10
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        List<a> r0 = this.a;
        if (r0 == null) goto L7;
        a r4 = (a) ListProtector.get(r0, r2);
        if (r4 == null) goto L7;
        String r5 = r4.a;
    L9:
        return Intrinsics.areEqual(r5, ((a) ListProtector.get(this.b, r3)).a);
    L7:
        r5 = null;
        goto L9
    }
}

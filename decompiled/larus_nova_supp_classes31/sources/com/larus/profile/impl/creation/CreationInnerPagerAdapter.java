package com.larus.profile.impl.creation;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.LoadingFragment;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/profile/impl/creation/CreationInnerPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "realList", "", "Lcom/larus/platform/api/creation/UserCreation;", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "initCreate", "", "getItemCount", "", "refreshData", "", "list", "createFragment", "position", "getItemId", "", "containsItem", "itemId", "DiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationInnerPagerAdapter extends FragmentStateAdapter {
    public final Fragment a;
    public List<UserCreation> b;
    public boolean c;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/profile/impl/creation/CreationInnerPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/platform/api/creation/UserCreation;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getHashCode", "", "pos", "list", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<UserCreation> a;
        public final List<UserCreation> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<UserCreation> r2, List<UserCreation> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final long a(int r2, List<UserCreation> r3) {
            if (r2 >= r3.size()) goto L5;
            String r4 = ((UserCreation) ListProtector.get(r3, r2)).a;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L11:
            return r5;
        L9:
            r5 = 0;
            goto L11
        L5:
            return 1544803905;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            if (a(r4, this.a) != a(r5, this.b)) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean areItemsTheSame(int r4, int r5) {
            if (a(r4, this.a) != a(r5, this.b)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public CreationInnerPagerAdapter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = r2;
        this.b = new ArrayList();
        this.c = true;
    }

    public final boolean containsItem(long r8) {
        List<UserCreation> r0 = this.b;
        ListIterator<UserCreation> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L14;
        UserCreation r2 = r1.previous();
        String r4 = r2.a;
        if (r4 != null) goto L9;
        r4 = "default";
    L9:
        if (r4.hashCode() != r8) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L4;
    L16:
        if (r2 != null) goto L25;
        return false;
    L25:
        return true;
    L11:
        r5 = false;
        goto L12
    L14:
        r2 = null;
        goto L16
    }

    public final Fragment createFragment(int r7) {
        UserCreation r0 = (UserCreation) ListProtector.get(this.b, r7);
        CreationPagerFragment r1 = this.a;
        CreationGroupFragment r3 = null;
        if ((r1 instanceof CreationPagerFragment) == false) goto L5;
        CreationPagerFragment r2 = r1;
    L6:
        if (r2 == null) goto L8;
        Integer r4 = Integer.valueOf(r2.ba0());
    L10:
        if (this.c == false) goto L16;
        if (r4 == null) goto L16;
        if (r7 != r4.intValue()) goto L16;
        boolean r5 = true;
    L17:
        Fragment r6 = js9.a.a.a(r0, this.a, r5, r7);
        if (r6 != null) goto L20;
        r6 = new LoadingFragment();
    L20:
        if (r5 == false) goto L22;
        this.c = false;
    L22:
        Fragment r8 = this.a;
        if ((r8 instanceof CreationGroupFragment) == false) goto L25;
        r3 = (CreationGroupFragment) r8;
    L25:
        if (r3 == null) goto L29;
        Map<Integer, Fragment> r9 = r3.k;
        if (r9 == null) goto L29;
        Fragment r10 = r9.put(Integer.valueOf(r7), r6);
    L29:
        return r6;
    L16:
        r5 = false;
        goto L17
    L8:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final long getItemId(int r3) {
        if (r3 >= this.b.size()) goto L5;
        String r4 = ((UserCreation) ListProtector.get(this.b, r3)).a;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L11:
        return r5;
    L9:
        r5 = 0;
        goto L11
    L5:
        return 1544803905;
    }

    public final void y2(List<UserCreation> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        DiffUtil.calculateDiff(new DiffCallback(this.b, r0)).dispatchUpdatesTo(this);     // Catch: Exception -> L8
    L10:
        this.b = r0;
        return;
    L8:
        e = move-exception;
        FLogger.a.e("CreationPagerFragment", "diffResult.dispatchUpdatesTo error e=" + e.getMessage());
        goto L10
    }
}

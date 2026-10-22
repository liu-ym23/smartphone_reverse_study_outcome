package com.larus.profile.impl.creation;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.community.api.ICommunityService;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/profile/impl/creation/CreationOutPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Lcom/larus/profile/impl/creation/CreationPagerFragment;", "<init>", "(Lcom/larus/profile/impl/creation/CreationPagerFragment;)V", "realList", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "initCreate", "", "hasCreateImageOrVideoAbility", "getHasCreateImageOrVideoAbility", "()Z", "hasCreateImageOrVideoAbility$delegate", "Lkotlin/Lazy;", "getItemCount", "", "refreshData", "", "list", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "getItemId", "", "containsItem", "itemId", "DiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationOutPagerAdapter extends FragmentStateAdapter {
    public static final /* synthetic */ int e = 0;
    public final CreationPagerFragment a;
    public List<UserCreationModel> b;
    public boolean c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/profile/impl/creation/CreationOutPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getHashCode", "", "pos", "list", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<UserCreationModel> a;
        public final List<UserCreationModel> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<UserCreationModel> r2, List<UserCreationModel> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final long a(int r2, List<UserCreationModel> r3) {
            if (r2 < r3.size()) goto L7;
            int r4 = 1544803905;
        L6:
            return r4;
        L7:
            String r5 = ((UserCreationModel) ListProtector.get(r3, r2)).d();
            if (r5 != null) goto L10;
            r5 = "default";
        L10:
            r4 = r5.hashCode();
            goto L6
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

    public CreationOutPagerAdapter(CreationPagerFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.a = r2;
        this.b = new ArrayList();
        this.c = true;
        this.d = LazyKt.lazy(new h1());
    }

    public final boolean containsItem(long r8) {
        List<UserCreationModel> r0 = this.b;
        ListIterator<UserCreationModel> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L14;
        UserCreationModel r2 = r1.previous();
        String r4 = r2.d();
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

    public final Fragment createFragment(int r10) {
        UserCreationModel r0 = (UserCreationModel) ListProtector.get(this.b, r10);
        CreationPagerFragment r1 = this.a;
        gs9.d r3 = null;
        if ((r1 instanceof CreationPagerFragment) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.ba0());
    L9:
        boolean r4 = true;
        if (this.c == false) goto L16;
        if (r2 == null) goto L16;
        if (r10 != r2.intValue()) goto L16;
        boolean r5 = true;
    L17:
        List<UserCreation> r6 = r0.b();
        if (r6 == null) goto L20;
        UserCreation r7 = (UserCreation) CollectionsKt.firstOrNull(r6);
    L21:
        if (r7 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == true) goto L28;
    L33:
        boolean r9 = true;
    L34:
        CreationGroupFragment r11 = new CreationGroupFragment();
        sq9.r r12 = com.larus.platform.service.z2.a.getCreationEditControlConfig().a();
        if (r12 == null) goto L42;
        Integer r13 = r12.b();
        if (r13 == null) goto L42;
        if (r13.intValue() != 1) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == false) goto L64;
        if (r9 == false) goto L64;
        if (r7 != null) goto L47;
    L49:
        boolean r15 = false;
    L50:
        if (r15 == true) goto L64;
        if (r7 != null) goto L53;
    L55:
        boolean r16 = false;
    L56:
        if (r16 == true) goto L64;
        if (ICommunityService.a.f1().c() == true) goto L64;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L64;
        if (this.a.r != 2) goto L64;
    L65:
        r11.r = r4;
        List<UserCreation> r17 = r0.b();
        if (r17 == null) goto L68;
        List<UserCreation> r18 = CollectionsKt.toMutableList(r17);
    L69:
        r11.m = r18;
        CreationPagerFragment r19 = this.a;
        if ((r19 instanceof CreationPagerFragment) == false) goto L72;
        CreationPagerFragment r20 = r19;
    L73:
        if (r20 == null) goto L75;
        int r21 = r20.r;
    L76:
        r11.o = r21;
        if ((r19 instanceof CreationPagerFragment) == true) goto L80;
        r19 = null;
    L80:
        if (r19 == null) goto L83;
        String r22 = r19.q;
        if (r22 == null) goto L83;
    L84:
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r11.n = r22;
        CreationPagerFragment r23 = this.a;
        if ((r23 instanceof CreationPagerFragment) == true) goto L88;
        r23 = null;
    L88:
        if (r23 == null) goto L90;
        r3 = r23.t;
    L90:
        r11.q = r3;
        if (r5 == false) goto L93;
        this.c = false;
    L93:
        FLogger.a.i("CreationPagerFragment", "createFragment" + r10);
        return r11;
    L83:
        r22 = "";
        goto L84
    L75:
        r21 = 0;
        goto L76
    L72:
        r20 = null;
        goto L73
    L68:
        r18 = null;
        goto L69
    L53:
        if (r7.b != 0) goto L55;
        r16 = true;
        goto L56
    L47:
        if (r7.b != 1) goto L49;
        r15 = true;
    L64:
        r4 = false;
    L42:
        r14 = false;
        goto L43
    L28:
        if (r7.b != 12) goto L30;
    L32:
        r9 = false;
        goto L34
    L30:
        if (com.larus.platform.service.z2.a.getCreationExtendVideoConfig().b() == false) goto L32;
    L23:
        if (zp9.d.f(r7) != true) goto L25;
        r8 = true;
        goto L26
    L20:
        r7 = null;
    L16:
        r5 = false;
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    public final long getItemId(int r3) {
        if (r3 < this.b.size()) goto L7;
        int r4 = 1544803905;
    L6:
        return r4;
    L7:
        String r5 = ((UserCreationModel) ListProtector.get(this.b, r3)).d();
        if (r5 != null) goto L10;
        r5 = "default";
    L10:
        r4 = r5.hashCode();
        goto L6
    }
}

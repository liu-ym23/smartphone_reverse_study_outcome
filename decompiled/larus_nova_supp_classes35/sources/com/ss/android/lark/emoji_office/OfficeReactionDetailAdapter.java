package com.ss.android.lark.emoji_office;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.detailwindow.pager.ReactionListFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionDetailAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "dataList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/reaction/widget/detailwindow/bean/ReactionDetailViewModel;", "onItemClicked", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemId", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "containsItem", BuildConfig.FLAVOR, "itemId", "getItemCount", "createFragment", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionDetailAdapter extends FragmentStateAdapter {
    public final List<ReactionDetailViewModel> a;
    public final Function1<String, Unit> b;

    public static final class a implements ReactionPopupFacade.c {
        public final /* synthetic */ OfficeReactionDetailAdapter a;

        public a(OfficeReactionDetailAdapter r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Function1<String, Unit> r0 = this.a.b;
            Intrinsics.checkNotNull(r2);
            r0.invoke(r2);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final boolean containsItem(long r7) {
        List<ReactionDetailViewModel> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        String r2 = ((ReactionDetailViewModel) r1.next()).getReactionKey();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L9;
        return true;
    L13:
        if (r2.hashCode() != r7) goto L15;
        r3 = true;
        goto L16
    L25:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final Fragment createFragment(int r2) {
        ReactionListFragment r3 = ReactionListFragment.S90((ReactionDetailViewModel) ListProtector.get(this.a, r2), false, 0);
        r3.h = new a(this);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public final long getItemId(int r3) {
        ReactionDetailViewModel r0 = (ReactionDetailViewModel) CollectionsKt.getOrNull(this.a, r3);
        if (r0 == null) goto L7;
        String r1 = r0.getReactionKey();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.hashCode());
    L8:
        if (r2 == null) goto L11;
        return r2.longValue();
    L11:
        return super.getItemId(r3);
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeReactionDetailAdapter(Fragment r2, List<? extends ReactionDetailViewModel> r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "dataList");
        Intrinsics.checkNotNullParameter(r4, "onItemClicked");
        super(r2);
        this.a = r3;
        this.b = r4;
    }
}

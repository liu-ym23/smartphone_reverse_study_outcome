package com.larus.showcase.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.showcase.Case;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/showcase/view/CaseListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/platform/model/showcase/Case;", "Lcom/larus/showcase/view/BaseCaseListItemHolder;", "callback", "Lcom/larus/showcase/view/CaseListHolderCallback;", "<init>", "(Lcom/larus/showcase/view/CaseListHolderCallback;)V", "getItemWithPosition", "position", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CaseListAdapter extends ListAdapter<Case, BaseCaseListItemHolder> {
    public static final CaseListAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final f a;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.showcase.view.CaseListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new CaseListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public CaseListAdapter(CaseListFragment$caseListCallback$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        BaseCaseListItemHolder r8 = (BaseCaseListItemHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        final Case r9 = (Case) getItem(r7);
        if ((r8 instanceof NormalCaseItemHolder) == false) goto L5;
        final NormalCaseItemHolder r10 = (NormalCaseItemHolder) r8;
    L6:
        if (r10 == null) goto L27;
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNullParameter(r9, "item");
        FLogger.a.i("NormalCollectionItemHolder", "bindData, item=" + r9 + ", absoluteAdapterPosition = " + r10.getAbsoluteAdapterPosition());
        if (r9.isLoading() == false) goto L10;
        r10.f.setVisibility(0);
        r10.g.setVisibility(8);
        return;
    L10:
        r10.f.setVisibility(8);
        r10.g.setVisibility(0);
        ImageLoaderKt.y(r10.c, r9.getIconUrl(), "collection_list_item_cover", new i(), 4);
        SimpleDraweeView r0 = r10.c;
        if (r0 == null) goto L13;
        r0.setColorFilter(ContextCompat.getColor(r10.a.getContext(), 2131103203));
    L13:
        e1.d(r10.a, new h(r10, r9));
        TextView r1 = r10.d;
        if (r1 == null) goto L16;
        r1.setText(r9.getTitle());
    L16:
        TextView r2 = r10.e;
        if (r2 == null) goto L19;
        r2.setText(r9.getBrief());
    L19:
        Integer r11 = r9.getStatus();
        if (r11 != null) goto L23;
    L25:
        r10.a.setAlpha(1.0f);
        return;
    L23:
        if (r11.intValue() != 1) goto L25;
        r10.a.setAlpha(0.4f);
        return;
    L27:
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562514, r3, false);
        int r6 = 2131368849;
        if (ViewBindings.findChildViewById(r5, 2131368849) == null) goto L19;
        r6 = 2131375138;
        if (ViewBindings.findChildViewById(r5, 2131375138) == null) goto L19;
        r6 = 2131375139;
        if (ViewBindings.findChildViewById(r5, 2131375139) == null) goto L19;
        r6 = 2131375310;
        if (((FrameLayout) ViewBindings.findChildViewById(r5, 2131375310)) == null) goto L19;
        r6 = 2131379011;
        if (ViewBindings.findChildViewById(r5, 2131379011) == null) goto L19;
        r6 = 2131383769;
        if (ViewBindings.findChildViewById(r5, 2131383769) == null) goto L19;
        r6 = 2131388772;
        if (ViewBindings.findChildViewById(r5, 2131388772) == null) goto L19;
        return new NormalCaseItemHolder(r5, this.a);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}

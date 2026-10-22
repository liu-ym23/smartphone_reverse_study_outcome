package com.larus.bmhome.chat.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/adapter/ItemCaseHolder;", "Lcom/larus/bmhome/chat/adapter/BaseCaseItemHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "coverContainer", "Landroid/view/ViewGroup;", "title", "Landroid/widget/TextView;", "description", "divider", "bindData", "", "item", "Lcom/larus/platform/model/showcase/Case;", "needDivider", "", "onItemClicked", "Lkotlin/Function0;", "setIconUrl", "coverUrl", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ItemCaseHolder extends BaseCaseItemHolder {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final SimpleDraweeView b;
    public final ViewGroup c;
    public final TextView d;
    public final TextView e;
    public final View f;

    public static final class a {
    }

    static {
    }

    public ItemCaseHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2;
        this.b = r2.findViewById(2131375138);
        this.c = (ViewGroup) r2.findViewById(2131375139);
        this.d = (TextView) r2.findViewById(2131388772);
        this.e = (TextView) r2.findViewById(2131368849);
        this.f = r2.findViewById(2131369197);
    }
}

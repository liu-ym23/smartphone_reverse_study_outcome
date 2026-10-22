package com.larus.showcase.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/showcase/view/NormalCaseItemHolder;", "Lcom/larus/showcase/view/BaseCaseListItemHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/showcase/view/CaseListHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/showcase/view/CaseListHolderCallback;)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "title", "Landroid/widget/TextView;", "description", "loadingContainer", "Landroid/view/ViewGroup;", "realContainer", "bindData", "", "item", "Lcom/larus/platform/model/showcase/Case;", "setIconUrl", "coverUrl", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class NormalCaseItemHolder extends BaseCaseListItemHolder {
    public static final /* synthetic */ int h = 0;
    public final View a;
    public final f b;
    public final SimpleDraweeView c;
    public final TextView d;
    public final TextView e;
    public final ViewGroup f;
    public final ViewGroup g;

    public static final class a {
    }

    static {
    }

    public NormalCaseItemHolder(ConstraintLayout r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r2.findViewById(2131375138);
        this.d = (TextView) r2.findViewById(2131388772);
        this.e = (TextView) r2.findViewById(2131368849);
        this.f = (ViewGroup) r2.findViewById(2131379011);
        this.g = (ViewGroup) r2.findViewById(2131383769);
    }
}

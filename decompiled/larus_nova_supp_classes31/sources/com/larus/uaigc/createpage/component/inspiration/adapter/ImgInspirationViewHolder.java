package com.larus.uaigc.createpage.component.inspiration.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/uaigc/createpage/component/inspiration/adapter/ImgInspirationViewHolderCallback;)V", "inspirePromptTextView", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImgInspirationViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final b a;
    public final TextView b;

    public ImgInspirationViewHolder(RoundConstraintLayout r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r3;
        this.b = (TextView) r2.findViewById(2131390788);
    }
}

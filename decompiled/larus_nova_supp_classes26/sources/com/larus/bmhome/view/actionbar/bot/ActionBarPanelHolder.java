package com.larus.bmhome.view.actionbar.bot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarPanelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/bot/ActionBarHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/bot/ActionBarHolderCallback;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "actionStar", "Landroid/widget/ImageView;", "getActionStar", "()Landroid/widget/ImageView;", "bindData", "", "templates", "Lcom/larus/im/bean/conversation/Templates;", "useSubscribedColor", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarPanelHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int d = 0;
    public final g a;
    public final TextView b;
    public final ImageView c;

    public ActionBarPanelHolder(View r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r3;
        this.b = (TextView) r2.findViewById(2131388315);
        this.c = (ImageView) r2.findViewById(2131362146);
    }
}

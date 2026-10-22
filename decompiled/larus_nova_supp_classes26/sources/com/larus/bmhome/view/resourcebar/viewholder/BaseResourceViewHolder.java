package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Landroid/view/View;)V", "getConfig", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "setConfig", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;)V", "bind", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "Callback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseResourceViewHolder extends RecyclerView.ViewHolder {
    public ResourceBarConfig a;

    public abstract void T3(ResourceItemBean r1, lt8.a r2);

    public BaseResourceViewHolder(ResourceBarConfig r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r2;
    }
}

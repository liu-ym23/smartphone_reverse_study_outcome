package com.larus.setting.impl.thirdpartyaccount.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.setting.impl.databinding.LarusItemAccountGroupBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JJ\u0010\u000e\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018Jb\u0010\u0019\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\r2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/view/ThirdPartyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "binding", "Lcom/larus/setting/impl/databinding/LarusItemAccountGroupBinding;", "<init>", "(Landroid/view/View;Lcom/larus/setting/impl/databinding/LarusItemAccountGroupBinding;)V", "getView", "()Landroid/view/View;", "getBinding", "()Lcom/larus/setting/impl/databinding/LarusItemAccountGroupBinding;", "itemSize", "", "bindData", "", "clickItemCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "scene", "", "thirdPartyKey", "renderData", "Lcom/larus/setting/impl/thirdpartyaccount/data/ThirdPartyAccountCollectionUiData;", "renderList", "itemGroup", "Landroid/view/ViewGroup;", "list", "", "Lcom/larus/setting/impl/thirdpartyaccount/data/ThirdPartyAccountUiData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ThirdPartyViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int d = 0;
    public final View a;
    public final LarusItemAccountGroupBinding b;
    public int c;

    public ThirdPartyViewHolder(View r2, LarusItemAccountGroupBinding r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "binding");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = -1;
    }
}

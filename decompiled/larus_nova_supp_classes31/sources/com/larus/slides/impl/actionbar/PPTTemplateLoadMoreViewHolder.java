package com.larus.slides.impl.actionbar;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemPptTemplateLoadMoreBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/slides/impl/actionbar/PPTTemplateLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemPptTemplateLoadMoreBinding;", "onRetryClick", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemPptTemplateLoadMoreBinding;Lkotlin/jvm/functions/Function0;)V", "bind", "state", "Lcom/larus/slides/impl/actionbar/PPTTemplateAdapter$LoadMoreState;", "showLoadingState", "showErrorState", "showEndState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PPTTemplateLoadMoreViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final LarusSlidesItemPptTemplateLoadMoreBinding a;
    public final Function0<Unit> b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PPTTemplateAdapter.LoadMoreState.values().length];
            r0[PPTTemplateAdapter.LoadMoreState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PPTTemplateAdapter.LoadMoreState.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PPTTemplateAdapter.LoadMoreState.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public PPTTemplateLoadMoreViewHolder(LarusSlidesItemPptTemplateLoadMoreBinding r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "onRetryClick");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        e1.d(r2.b, new m(this));
    }
}

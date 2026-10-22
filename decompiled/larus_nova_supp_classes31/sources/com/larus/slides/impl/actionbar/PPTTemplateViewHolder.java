package com.larus.slides.impl.actionbar;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemPptTemplateSelectorBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/slides/impl/actionbar/PPTTemplateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemPptTemplateSelectorBinding;", "callback", "Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;", "onItemSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "<init>", "(Lcom/larus/slides/biz/impl/databinding/LarusSlidesItemPptTemplateSelectorBinding;Lcom/larus/slides/impl/actionbar/PPTTemplateCallback;Lkotlin/jvm/functions/Function1;)V", "currentTemplate", "Lcom/larus/slides/impl/actionbar/model/PPTTemplate;", "currentPosition", "bind", "template", "isSelected", "", "bindTemplateImage", "imageUrl", "", "bindTemplateTitle", "title", "updateSelectionState", "updateSelectionStateOnly", "handleTemplateClick", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PPTTemplateViewHolder extends RecyclerView.ViewHolder {
    public final LarusSlidesItemPptTemplateSelectorBinding a;
    public final l b;
    public final Function1<Integer, Unit> c;
    public com.larus.slides.impl.actionbar.model.c d;
    public int e;

    /* JADX WARN: Multi-variable type inference failed */
    public PPTTemplateViewHolder(LarusSlidesItemPptTemplateSelectorBinding r2, l r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r4, "onItemSelected");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = -1;
    }
}

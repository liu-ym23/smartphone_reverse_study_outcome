package com.larus.bmhome.view.actionbar.edit.component;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.balloon.Balloon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001 \u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u00030\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!¨\u0006&"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderV2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;)V", "getCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "getViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "balloon", "Lcom/skydoves/balloon/Balloon;", "label", "Landroid/widget/TextView;", "selectedOption", "popupView", "kotlin.jvm.PlatformType", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "disMissTime", "", "spinnerLocation", "", "displayFrame", "Landroid/graphics/Rect;", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderV2$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderV2$itemSelectedCallback$1;", "bindData", "", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownSelectorHolderV2 extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int m = 0;
    public final b1 a;
    public final com.larus.bmhome.view.actionbar.edit.c b;
    public final com.larus.bmhome.actionbar.model.u c;
    public Balloon d;
    public final TextView e;
    public final TextView f;
    public final View g;
    public final RecyclerView h;
    public long i;
    public final int[] j;
    public final Rect k;
    public final f1 l;

    public DropdownSelectorHolderV2(ConstraintLayout r2, b1 r3, com.larus.bmhome.view.actionbar.edit.c r4, com.larus.bmhome.actionbar.model.u r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.e = (TextView) r2.findViewById(2131390536);
        this.f = (TextView) r2.findViewById(2131391380);
        View r6 = LayoutInflater.from(r2.getContext()).inflate(2131562465, null);
        this.g = r6;
        this.h = r6.findViewById(2131382753);
        this.j = new int[2];
        this.k = new Rect();
        this.l = new f1(this);
    }
}

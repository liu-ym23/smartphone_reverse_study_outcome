package com.larus.voicecall.impl.subtitle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/DropdownItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "dropdownBoxId", NameKeys.UnloadStrategy_No_Strategy, "callback", "Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;", "<init>", "(Landroid/view/View;Ljava/lang/Integer;Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;)V", "getItemView", "()Landroid/view/View;", "Ljava/lang/Integer;", "getCallback", "()Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;", "checkedIcon", "Landroid/widget/ImageView;", "divider", "titleTv", "Landroid/widget/TextView;", "itemIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "descTv", "bindData", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "getDisplayText", NameKeys.UnloadStrategy_No_Strategy, "selectedSpinnerItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final Integer b;
    public final e c;
    public final ImageView d;
    public final View e;
    public final TextView f;
    public final SimpleDraweeView g;
    public final TextView h;

    public DropdownItemHolder(ConstraintLayout r2, Integer r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = (ImageView) r2.findViewById(2131374691);
        this.e = r2.findViewById(2131375736);
        this.f = (TextView) r2.findViewById(2131390830);
        this.g = r2.findViewById(2131374690);
        this.h = (TextView) r2.findViewById(2131390825);
    }
}

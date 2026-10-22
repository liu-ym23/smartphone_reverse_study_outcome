package com.larus.bmhome.chat.feedback;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusItemTtsFeedbackBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/chat/feedback/TtsFeedbackHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;", "<init>", "(Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;)V", "getBinding", "()Lcom/larus/bmhome/databinding/LarusItemTtsFeedbackBinding;", "bindData", "", "item", "Lcom/larus/audio/bean/FeedbackItem;", "isAdd", "", "updateSelectStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TtsFeedbackHolder extends RecyclerView.ViewHolder {
    public final LarusItemTtsFeedbackBinding a;

    public TtsFeedbackHolder(LarusItemTtsFeedbackBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        super(r2.a);
        this.a = r2;
    }

    public final void T3(boolean r4) {
        Context r0 = null;
        if (r4 == false) goto L9;
        AppCompatImageView r5 = this.a.d;
        if (r5 == null) goto L15;
        if (r5 == null) goto L8;
        r0 = r5.getContext();
    L8:
        r5.setImageResource(v19.c.b(2130971883, r0, 2131242242));
        return;
    L15:
        return;
    L9:
        AppCompatImageView r6 = this.a.d;
        if (r6 == null) goto L17;
        if (r6 == null) goto L13;
        r0 = r6.getContext();
    L13:
        r6.setImageResource(v19.c.b(2130971882, r0, 2131242239));
        return;
    }
}

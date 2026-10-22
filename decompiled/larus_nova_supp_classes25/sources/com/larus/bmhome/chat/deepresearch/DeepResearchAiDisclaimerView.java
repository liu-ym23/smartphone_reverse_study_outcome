package com.larus.bmhome.chat.deepresearch;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepResearchAiDisclaimerView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepResearchAiDisclaimerView extends AppCompatTextView {
    /* JADX WARN: Multi-variable type inference failed */
    public DeepResearchAiDisclaimerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        RecyclerView.LayoutParams r0 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r0).topMargin = c7.b(46);
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = c7.b(10);
        setLayoutParams(r0);
        setGravity(17);
        setText(r4.getString(2131897491));
        setTextColor(c.a(2130972081, r4, 2131103143));
        setTextSize(0, getResources().getDimension(c.b(2130971163, null, 2131166696)));
    }
}

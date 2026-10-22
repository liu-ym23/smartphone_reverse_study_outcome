package com.larus.bmhome.chat.layout.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.HeaderAreaAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/BotBioImmersHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "bindData", "", "cvsId", "", "immerseBgColor", "", "adapter", "Lcom/larus/bmhome/chat/adapter/HeaderAreaAdapter;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/chat/adapter/HeaderAreaAdapter;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotBioImmersHolder extends RecyclerView.ViewHolder {
    public final View a;

    public static final class a {
    }

    static {
    }

    public BotBioImmersHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2;
    }

    public final void T3(String r11, Integer r12, HeaderAreaAdapter r13) {
        Intrinsics.checkNotNullParameter(r13, "adapter");
        if (r11 == null) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new BotBioImmersHolder$bindData$1$1(r11, this, r13, r12, null), 2, null);
        return;
    }
}

package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class ServiceBotCardHelper$onLongPress$messageAnchor$1$1 extends FunctionReferenceImpl implements Function1<Integer, View> {
    public ServiceBotCardHelper$onLongPress$messageAnchor$1$1(Object r8) {
        super(1, r8, RecyclerView.class, "getChildAt", "getChildAt(I)Landroid/view/View;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }

    public final View invoke(int r2) {
        return ((RecyclerView) ((CallableReference) this).receiver).getChildAt(r2);
    }
}

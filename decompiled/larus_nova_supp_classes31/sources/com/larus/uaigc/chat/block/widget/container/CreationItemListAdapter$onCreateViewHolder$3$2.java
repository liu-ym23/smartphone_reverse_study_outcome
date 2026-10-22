package com.larus.uaigc.chat.block.widget.container;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class CreationItemListAdapter$onCreateViewHolder$3$2 extends FunctionReferenceImpl implements Function3<CreationItemListAdapter, cz9.b, Float, Unit> {
    public static final CreationItemListAdapter$onCreateViewHolder$3$2 INSTANCE = null;

    static {
        INSTANCE = new CreationItemListAdapter$onCreateViewHolder$3$2();
    }

    public CreationItemListAdapter$onCreateViewHolder$3$2() {
        super(3, CreationItemListAdapter.class, "reportItemExposure", "reportItemExposure(Lcom/larus/uaigc/chat/block/widget/CreationItemData;F)V", 0);
    }

    public final void invoke(CreationItemListAdapter r2, cz9.b r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        r2.g.invoke(r3, Float.valueOf(r4));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((CreationItemListAdapter) r1, (cz9.b) r2, ((Number) r3).floatValue());
        return Unit.INSTANCE;
    }
}

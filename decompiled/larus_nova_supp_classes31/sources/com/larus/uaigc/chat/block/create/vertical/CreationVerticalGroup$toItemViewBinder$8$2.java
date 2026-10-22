package com.larus.uaigc.chat.block.create.vertical;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class CreationVerticalGroup$toItemViewBinder$8$2 extends FunctionReferenceImpl implements Function3<CreationVerticalGroup, cz9.b, Float, Unit> {
    public static final CreationVerticalGroup$toItemViewBinder$8$2 INSTANCE = null;

    static {
        INSTANCE = new CreationVerticalGroup$toItemViewBinder$8$2();
    }

    public CreationVerticalGroup$toItemViewBinder$8$2() {
        super(3, CreationVerticalGroup.class, "reportItemExposure", "reportItemExposure(Lcom/larus/uaigc/chat/block/widget/CreationItemData;F)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((CreationVerticalGroup) r1, (cz9.b) r2, ((Number) r3).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(CreationVerticalGroup r2, cz9.b r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        int r0 = CreationVerticalGroup.u;
        r2.i(r3, r4);
    }
}

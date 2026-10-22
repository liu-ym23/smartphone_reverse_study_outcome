package com.larus.bmhome.blockarch.impl;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepthink.IDeepThinkBlockService;
import com.larus.utils.logger.FLogger;
import fca.h;
import fh8.d;
import jc8.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016J \u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/blockarch/impl/DeepThinkBlockServiceImpl;", "Lcom/larus/bmhome/chat/deepthink/IDeepThinkBlockService;", "<init>", "()V", "isDeepThinkHalfFold", "", "T", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "baseBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "expandDeepThink", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkBlockServiceImpl implements IDeepThinkBlockService {

    public static final class a {
    }

    static {
    }

    public DeepThinkBlockServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.deepthink.IDeepThinkBlockService
    public final boolean a(h r4) {
        Intrinsics.checkNotNullParameter(r4, "baseBlockHolder");
        FLogger r0 = FLogger.a;
        r0.i("DeepThinkBlockServiceImpl", "isDeepThinkHalfFold");
        tb8.a r5 = (tb8.a) c.a(r4, tb8.a.class);
        if (r5 == null) goto L7;
        d r6 = r5.f;
        if (r6 == null) goto L7;
        return r6.b();
    L7:
        r0.w("DeepThinkBlockServiceImpl", "isDeepThinkHalfFold, null, return false");
        return false;
    }

    @Override // com.larus.bmhome.chat.deepthink.IDeepThinkBlockService
    public final void b(h r4) {
        Intrinsics.checkNotNullParameter(r4, "baseBlockHolder");
        FLogger r0 = FLogger.a;
        r0.i("DeepThinkBlockServiceImpl", "expandDeepThink");
        tb8.a r5 = (tb8.a) c.a(r4, tb8.a.class);
        if (r5 == null) goto L7;
        Function0<Unit> r6 = r5.d;
        if (r6 == null) goto L7;
        r6.invoke();
        return;
    L7:
        r0.w("DeepThinkBlockServiceImpl", "expandDeepThink, null");
    }
}

package com.larus.bmhome.chat.component.bottom.core;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.a;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class CoreInputAbility$initInputPopupMenuAction$action$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public CoreInputAbility$initInputPopupMenuAction$action$1(Object r8) {
        super(0, r8, CoreInputAbility.class, "setInputContentFromClipboard", "setInputContentFromClipboard()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m55invoke() {
        CoreInputAbility r1 = (CoreInputAbility) ((CallableReference) this).receiver;
        String r0 = CoreInputAbility.U;
        r1.getClass();
        int r2 = com.larus.bmhome.utils.p.a;
        com.larus.bmhome.utils.n.a r3 = com.larus.bmhome.utils.p.a(r1.h);
        FLogger.a.i("CoreInputAbility", "[setInputContentFromClipboard] clipboardContent:" + r3);
        if ((r3 instanceof com.larus.bmhome.utils.n.a) == false) goto L12;
        com.larus.bmhome.chat.component.bottom.multimodal.g r4 = r1.A().r5();
        if (r4 == null) goto L18;
        List r5 = r3.a;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(new a.C0050a((Uri) r7.next(), null, 2));
        goto L8
    L10:
        r4.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r6, new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ChatPasteUri, false), null, null, null, 28));
        return;
    L18:
        return;
    L12:
        if (Intrinsics.areEqual(r3, com.larus.bmhome.utils.n.b.a) == false) goto L14;
        return;
    L14:
        if ((r3 instanceof com.larus.bmhome.utils.n.c) == false) goto L17;
        ICoreInputAbility.b.d(r1, ((com.larus.bmhome.utils.n.c) r3).a, true, true, null, null, false, 56);
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m55invoke();
        return Unit.INSTANCE;
    }
}

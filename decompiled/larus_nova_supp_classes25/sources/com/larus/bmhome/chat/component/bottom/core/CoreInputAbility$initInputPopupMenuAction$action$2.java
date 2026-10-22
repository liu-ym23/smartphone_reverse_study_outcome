package com.larus.bmhome.chat.component.bottom.core;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.a;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
public /* synthetic */ class CoreInputAbility$initInputPopupMenuAction$action$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public CoreInputAbility$initInputPopupMenuAction$action$2(Object r8) {
        super(0, r8, CoreInputAbility.class, "sendContentFromClipboard", "sendContentFromClipboard()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m56invoke() {
        CoreInputAbility r1 = (CoreInputAbility) ((CallableReference) this).receiver;
        String r2 = CoreInputAbility.U;
        r1.getClass();
        long r14 = System.currentTimeMillis();
        int r3 = com.larus.bmhome.utils.p.a;
        com.larus.bmhome.utils.n.a r4 = com.larus.bmhome.utils.p.a(r1.h);
        FLogger r5 = FLogger.a;
        r5.i("CoreInputAbility", "[sendContentFromClipboard] clipboardContent:" + r4);
        boolean r10 = false;
        if ((r4 instanceof com.larus.bmhome.utils.n.a) == false) goto L12;
        com.larus.bmhome.chat.component.bottom.multimodal.g r6 = r1.A().r5();
        if (r6 == null) goto L36;
        List r7 = r4.a;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r8.add(new a.C0050a((Uri) r9.next(), null, 2));
        goto L8
    L10:
        r6.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r8, new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.ChatPasteUri, false), null, null, null, 28));
        return;
    L36:
        return;
    L12:
        if (Intrinsics.areEqual(r4, com.larus.bmhome.utils.n.b.a) == false) goto L14;
        return;
    L14:
        if ((r4 instanceof com.larus.bmhome.utils.n.c) == false) goto L35;
        com.larus.bmhome.utils.n.c r11 = (com.larus.bmhome.utils.n.c) r4;
        String r12 = r11.a;
        IObricChatUIService r13 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r13 != null) goto L19;
    L30:
        r10 = true;
    L31:
        if (r10 == false) goto L41;
        CoreInputAbility.t(r1, r11.a, false, null, null, "paste", null, null, null, null, null, false, r14, false, 6124);
        r1.f.xB();
        return;
    L41:
        return;
    L19:
        if (r13.p() == false) goto L30;
        int r15 = r13.J();
        if (r15 <= 0) goto L30;
        if (r12.length() <= r15) goto L30;
        r5.i("CoreInputAbility", "[canSendClipboardText] false: text length=" + r12.length() + ", maxLength=" + r15);
        String r16 = r13.t();
        if (r16 != null) goto L29;
        r16 = r1.h.getString(2131905565);
    L29:
        String r18 = r16;
        String r17 = r13.A(r12);
        t19.s.j(t19.s.a, r1.h, r18, null, false, 28);
        ICoreInputAbility.b.d(r1, r17, true, true, null, null, false, 56);
        r1.g2(3, true);
        goto L31
    L35:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m56invoke();
        return Unit.INSTANCE;
    }
}

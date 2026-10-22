package com.larus.bmhome.chat.headerinfo;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.bmhome.utils.z;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.a;
import ib8.c0;
import ib8.m;
import ib8.w0;
import ic8.t;
import java.util.Iterator;
import java.util.List;
import kc8.f;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ob8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/headerinfo/DeepThinkHeaderServiceImpl;", "Lcom/larus/bmhome/chat/headerinfo/IDeepThinkHeaderService;", "<init>", "()V", "getDeepThinkHeaderInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "message", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepThinkHeaderServiceImpl implements IDeepThinkHeaderService {
    public DeepThinkHeaderServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService
    public final t a(Message r25) {
        Intrinsics.checkNotNullParameter(r25, "message");
        List r0 = a.f(r25);
        Lazy r1 = b.a;
        Iterator r2 = b.a(r0, new f(r25, null, false, false, null, null, 510)).iterator();
    L3:
        String r4 = null;
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((jc8.a) r3).l() != j.A) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L13:
        if ((r3 instanceof gb8.b) == false) goto L15;
        gb8.b r13 = (gb8.b) r3;
    L16:
        if (r13 != null) goto L19;
        return null;
    L19:
        if (a.f0(r13.j()) == true) goto L21;
    L27:
        boolean r12 = false;
    L28:
        z.a.getClass();
        c0 r7 = z.a(null, r12, r13, null, null, false, null, null, true, null, null, null, false);
        boolean r6 = r7.e;
        m r8 = r7.c;
        if (r8 == null) goto L33;
        Function1<DeepThinkFoldStatus, String> r9 = r8.b;
        if (r9 == null) goto L33;
        r4 = (String) r9.invoke(DeepThinkFoldStatus.CompleteFold);
    L33:
        if (r4 != null) goto L35;
        String r10 = "";
    L36:
        w0 r11 = z.b(null, r6, r25, null, null, r10, r7, DeepThinkFoldStatus.CompleteFold, false);
        return new t(r11.b, r11.c, r11.d, r11.e, r25.getExt(), 0, 32);
    L35:
        r10 = r4;
        goto L36
    L21:
        if (r13.a.isFinish() == true) goto L27;
        if (r13.j().getMessageStatusLocal() == 23) goto L27;
        if (d.f0(r13.j()) == false) goto L27;
        r12 = true;
        goto L28
    L15:
        r13 = null;
        goto L16
    L8:
        r5 = false;
        goto L9
    L11:
        r3 = null;
        goto L13
    }
}

package com.obric.assistant.chat.menu.omnitask;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.utils.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OmniTaskAdditionMenuItemHandler extends a {
    public static final OmniTaskAdditionMenuItemHandler b = null;

    static {
        b = new OmniTaskAdditionMenuItemHandler();
    }

    public OmniTaskAdditionMenuItemHandler() {
        super(2131381218);
    }

    @Override // com.obric.assistant.chat.menu.a
    public final void a(Fragment r12, ot8.a r13) {
        Intrinsics.checkNotNullParameter(r12, "fragment");
        Intrinsics.checkNotNullParameter(r13, "item");
        FLogger r0 = FLogger.a;
        r0.i("OmniTaskAdditionMenuItemHandler", "handleMenuItemClick");
        if ((r13 instanceof l0) == false) goto L5;
        l0 r14 = (l0) r13;
    L6:
        if (r14 == null) goto L8;
        Object r15 = r14.l;
    L10:
        if ((r15 instanceof Pair) == false) goto L12;
        Pair r16 = (Pair) r15;
    L13:
        if (r16 != null) goto L16;
        r0.w("OmniTaskAdditionMenuItemHandler", "handleMenuItemClick: data is null");
        return;
    L16:
        Object r2 = r16.getFirst();
        if ((r2 instanceof Message) == false) goto L19;
        Message r3 = (Message) r2;
    L20:
        if (r3 != null) goto L23;
        r0.w("OmniTaskAdditionMenuItemHandler", "handleMenuItemClick: msg is null");
        return;
    L23:
        Object r17 = r16.getSecond();
        if ((r17 instanceof DMTaskState) == false) goto L26;
        DMTaskState r18 = (DMTaskState) r17;
    L27:
        if (r18 != null) goto L29;
        r0.i("OmniTaskAdditionMenuItemHandler", "no taskState");
    L29:
        a.b("obric_omni_supplement", r12, r3);
        String r4 = k.a(r3);
        boolean r6 = false;
        if (r4.length() != 0) goto L32;
        boolean r5 = true;
    L33:
        if (r5 == false) goto L39;
        r0.i("OmniTaskAdditionMenuItemHandler", "no refMsgId, use msg id as refMsgId");
        String r7 = r3.getMessageId();
        if (r7 != null) goto L37;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        r4 = r7;
    L39:
        if (r4.length() != 0) goto L41;
        r6 = true;
    L41:
        if (r6 == false) goto L43;
        r0.w("OmniTaskAdditionMenuItemHandler", "refMsgId is empty");
    L43:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OmniTaskAdditionMenuItemHandler$handleMenuItemClick$1(r4, r12, r18, null), 3, null);
        return;
    L32:
        r5 = false;
        goto L33
    L26:
        r18 = null;
        goto L27
    L19:
        r3 = null;
        goto L20
    L12:
        r16 = null;
        goto L13
    L8:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}

package com.obric.assistant.chat.menu.omnitask;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OmniTaskReplyMenuItemHandler extends a {
    public static final OmniTaskReplyMenuItemHandler b = null;

    static {
        b = new OmniTaskReplyMenuItemHandler();
    }

    public OmniTaskReplyMenuItemHandler() {
        super(2131381219);
    }

    @Override // com.obric.assistant.chat.menu.a
    public final void a(Fragment r11, ot8.a r12) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r12, "item");
        FLogger r0 = FLogger.a;
        r0.i("OmniTaskReplyMenuItemHandler", "handleMenuItemClick");
        if ((r12 instanceof l0) == false) goto L5;
        l0 r13 = (l0) r12;
    L6:
        if (r13 == null) goto L8;
        Object r14 = r13.l;
    L10:
        if ((r14 instanceof Pair) == false) goto L12;
        Pair r15 = (Pair) r14;
    L13:
        if (r15 != null) goto L16;
        r0.w("OmniTaskReplyMenuItemHandler", "handleMenuItemClick: data is null");
        return;
    L16:
        Object r2 = r15.getSecond();
        if ((r2 instanceof DMTaskState) == false) goto L19;
        DMTaskState r3 = (DMTaskState) r2;
    L20:
        if (r3 != null) goto L23;
        r0.w("OmniTaskReplyMenuItemHandler", "handleMenuItemClick: taskState is null");
        return;
    L23:
        Object r16 = r15.getFirst();
        if ((r16 instanceof Message) == false) goto L26;
        Message r17 = (Message) r16;
    L27:
        if (r17 == null) goto L29;
        b.getClass();
        a.b("obric_omni_reply", r11, r17);
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new OmniTaskReplyMenuItemHandler$handleMenuItemClick$2(r3, r11, null), 3, null);
        return;
    L26:
        r17 = null;
        goto L27
    L19:
        r3 = null;
        goto L20
    L12:
        r15 = null;
        goto L13
    L8:
        r14 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}

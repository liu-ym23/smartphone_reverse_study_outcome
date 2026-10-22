package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import kotlin.jvm.internal.Intrinsics;
import yya.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements r {
    public f() {
    }

    public final String getTAG() {
        return getPageType().name() + "_interceptor";
    }

    public final PageType getPageType() {
        return PageType.MERGE_FORWARD;
    }

    public final boolean a(MessageActionType r5, yya.a r6) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        if (r5 != MessageActionType.COPY) goto L21;
        Message.Type r7 = r6.m().getType();
        v5b.a r8 = r6.m().b();
        boolean r0 = com.ss.android.lark.message.card.b.a().getFgValue("messagecard.surpportcopy.enable");
        if ((r8 instanceof LynxCardContentVO) == false) goto L7;
        r0 = true;
    L7:
        if (r0 == false) goto L12;
        if (r7 != Message.Type.CARD) goto L12;
        return false;
    L12:
        if (r7 != Message.Type.TEXT) goto L14;
    L18:
        return false;
    L14:
        if (r7 == Message.Type.POST) goto L18;
        if (r7 == Message.Type.AUDIO) goto L18;
        return true;
    L21:
        if (r5 != MessageActionType.FLOW_MORE) goto L23;
    L43:
        return false;
    L23:
        if (r5 == MessageActionType.SELECT_TEXT) goto L43;
        if (r5 == MessageActionType.CREATE_DOC) goto L43;
        if (r5 == MessageActionType.FORWARD) goto L43;
        if (r5 != MessageActionType.COPY_IMAGE_AND_MEDIA) goto L33;
        return false;
    L33:
        if (r5 == MessageActionType.TRANSLATE) goto L43;
        if (r5 == MessageActionType.HYPER_TRANSLATE) goto L43;
        if (r5 == MessageActionType.SEARCH) goto L43;
        if (r5 == MessageActionType.SEARCH_EXTERNAL) goto L43;
        return true;
    }
}

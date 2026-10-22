package com.ss.android.lark.chat.message.menu.v2.popup;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupMenu$rootView$2$1$2 extends FunctionReferenceImpl implements Function3<Boolean, MessageActionType, Boolean, Unit> {
    public PopupMenu$rootView$2$1$2(Object r8) {
        super(3, r8, PopupMenu.class, "dismiss", "dismiss(ZLcom/ss/android/lark/biz/im/extension/message_action/MessageActionType;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), (MessageActionType) r2, ((Boolean) r3).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2, MessageActionType r3, boolean r4) {
        ((PopupMenu) ((CallableReference) this).receiver).d(r2, r3, r4);
    }
}

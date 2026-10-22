package qmb;

import com.ss.android.lark.biz.im.extension.message_action.FeatureScopeInterceptorType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements e {
    public final List<MessageActionType> a;

    public a() {
        this.a = CollectionsKt.listOf(new MessageActionType[]{MessageActionType.FLOW_LIKE, MessageActionType.FLOW_DISLIKE, MessageActionType.FLOW_FEEDBACK});
    }

    public final String getTAG() {
        return e.a.a(this);
    }

    public FeatureScopeInterceptorType getType() {
        return FeatureScopeInterceptorType.FLOW_COMMON;
    }

    public final boolean a(MessageActionType r5, yya.a r6) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        if (r6.m().getType() != Message.Type.DOUBAO) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        return false;
    L5:
        if (this.a.contains(r5) == false) goto L8;
        return true;
    }

    public final boolean b(MessageActionType r1, yya.a r2) {
        e.a.c(r1, r2);
        return false;
    }

    public final boolean c(MessageActionType r1, yya.a r2, boolean r3) {
        e.a.b(r1, r2);
        return false;
    }
}

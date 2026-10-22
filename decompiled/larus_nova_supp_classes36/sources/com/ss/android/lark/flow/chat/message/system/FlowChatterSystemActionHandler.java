package com.ss.android.lark.flow.chat.message.system;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import java.util.EnumSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatterSystemActionHandler implements e {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public FlowChatterSystemActionHandler() {
        this.a = LazyKt.lazy(FlowChatterSystemActionHandler$oneWayContactActionTypeSet$2.INSTANCE);
    }

    public final void x(ContentValue r5, com.ss.android.lark.biz.im.api.extension.message.system.a r6) {
        Intrinsics.checkNotNullParameter(r6, "actionContext");
        String r0 = null;
        if (r5 != null) goto L5;
    L16:
        StringBuilder r1 = new StringBuilder("click chatter, type is ");
        r1.append(r6.content().getType());
        r1.append(" contentValue is null:");
        if (r5 != null) goto L19;
        boolean r7 = true;
    L20:
        r1.append(r7);
        r1.append(", anonymous:");
        if (r5 == null) goto L23;
        Boolean r8 = r5.isAnonymous();
    L24:
        r1.append(r8);
        r1.append(", id:");
        if (r5 == null) goto L27;
        r0 = r5.getId();
    L27:
        r1.append(r0);
        r1.append(", suppress jump to profile");
        Log.w("System_FlowChatterActionHandler", r1.toString());
        return;
    L23:
        r8 = null;
        goto L24
    L19:
        r7 = false;
        goto L20
    L5:
        if (r5.isAnonymous().booleanValue() == true) goto L16;
        if (r5.getContentValueType() != ContentValueType.USER) goto L10;
    L11:
        MessageHitPoint r2 = MessageHitPoint.a;
        r2.a().sendEvent("join_or_leave_group_name_click", null);
        if (((EnumSet) this.a.getValue()).contains(r6.content().getType()) == false) goto L14;
        r2.a().sendEvent("chat_systemmessage_beadded_name_click", null);
    L14:
        b0 r3 = ChatCoreModule.a().getProfileDependency();
        FragmentActivity r4 = r6.context();
        ProfileSource.a r9 = new ProfileSource.a();
        r9.e = r5.getId();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r9.d = r6.message().getChatId();
        r9.b = 2;
        r3.e(r4, new ProfileSource(r9));
        return;
    L10:
        if (r5.getContentValueType() != ContentValueType.CHATTER) goto L14;
        goto L11
    }
}

package com.obric.assistant.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.n4;
import com.larus.bmhome.utils.i;
import com.larus.common.apphost.AppHost;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements a {
    static {
    }

    public b() {
    }

    public final boolean b(com.bytedance.router.c r2) {
        int r0 = k0.a;
        if (r2 == null) goto L7;
        Uri r3 = r2.d;
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r4), "//flow/chat_page");
    L7:
        r4 = null;
        goto L9
    }

    public final boolean a(Context r12, com.bytedance.router.c r13) {
        Activity r0 = null;
        if (r13 == null) goto L7;
        Intent r1 = r13.b;
        if (r1 == null) goto L7;
        Bundle r2 = r1.getExtras();
    L8:
        String r3 = "";
        if (r2 == null) goto L15;
        String r4 = r2.getString("argConversationId", "");
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        if (r2 == null) goto L17;
        Integer r5 = Integer.valueOf(r2.getInt("argBotConversationType", -1));
    L19:
        if (r5 != null) goto L22;
    L28:
        if (r5 == null) goto L33;
        if (r5.intValue() != 1) goto L33;
    L36:
        boolean r6 = true;
    L37:
        if (r13 == null) goto L43;
        Intent r7 = r13.b;
        if (r7 == null) goto L43;
        Bundle r8 = r7.getExtras();
        if (r8 == null) goto L43;
        String r9 = r8.getString("preview_collection_id");
    L44:
        FLogger r10 = FLogger.a;
        r10.i("ObricChatPageRouterInterceptor", "onInterceptRoute isMainBot = " + r6 + ", ConversaitonId = " + r3 + ", ConversaitonType = " + r5 + ", previewCollectionId = " + r9);
        if (r6 == false) goto L71;
        if (r13 == null) goto L50;
        Intent r11 = r13.b;
        if (r11 == null) goto L50;
        int r14 = r11.getFlags();
    L52:
        if ((r14 & 67108864) == 0) goto L71;
        if ((r12 instanceof Activity) == false) goto L56;
        r0 = (Activity) r12;
    L56:
        if (r0 == null) goto L71;
        r10.i("ObricChatPageRouterInterceptor", "mockClearTopForObricChatActivity");
        int r15 = r0.getTaskId();
        List r16 = AppHost.a.a().g();
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        int r18 = r16.size() - 1;
        if (r18 < 0) goto L68;
    L59:
        int r19 = r18 - 1;
        Activity r20 = (Activity) ListProtector.get(r16, r18);
        if (r20.getTaskId() == r15) goto L62;
    L64:
        if (r19 < 0) goto L68;
        r18 = r19;
        goto L59
    L62:
        if (n4.class.isAssignableFrom(r20.getClass()) == false) goto L64;
        r17.element = r20;
    L68:
        if (r17.element != null) goto L70;
        FLogger.a.i("ObricChatPageRouterInterceptor", "couldn't find target activity");
        goto L71
    L70:
        SoftReference r21 = y.a;
        a r22 = new a(r17, r15);
        Intrinsics.checkNotNullParameter(r22, "action");
        y.c(r22);
    L50:
        r14 = 0;
    L71:
        if (r6 == false) goto L87;
        if (r9 != null) goto L74;
    L77:
        boolean r110 = true;
    L78:
        if (r110 == false) goto L87;
        if (r13 == null) goto L83;
        Intent r111 = r13.b;
        if (r111 == null) goto L83;
        r111.putExtra("as_container", ObricInteractionServiceDelegate.b.a());
    L83:
        if (r13 == null) goto L87;
        Intent r112 = r13.b;
        if (r112 == null) goto L87;
        r112.putExtra("obric_allow_show_when_locked", true);
        goto L87
    L74:
        if (r9.length() == 0) goto L77;
        r110 = false;
    L87:
        return false;
    L43:
        r9 = null;
    L33:
        if (i.g(r3) == true) goto L36;
        r6 = false;
        goto L37
    L22:
        if (r5.intValue() != (-1)) goto L28;
        if (r3.length() != 0) goto L26;
        boolean r23 = true;
    L27:
        if (r23 == true) goto L36;
    L26:
        r23 = false;
        goto L27
    L17:
        r5 = null;
    L7:
        r2 = null;
        goto L8
    }
}

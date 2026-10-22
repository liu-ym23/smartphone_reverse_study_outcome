package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FrequentChatABHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(FrequentChatABHelper$config$2.INSTANCE);
    }

    public static boolean a(g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelBridges");
        CommentFlowContext r0 = r9.S();
        IBaseUser r1 = null;
        if (r0 == null) goto L7;
        CommentInputConfig r2 = r0.d;
        if (r2 == null) goto L7;
        CommentInputConfig.State r3 = r2.i;
    L8:
        boolean r4 = true;
        if (r3 != CommentInputConfig.State.ForceOpen) goto L13;
        int r10 = b.a;
        Intrinsics.checkNotNullParameter("config force use frequent chat", "msg");
        ALogger.i("FrequentChatEnable", "config force use frequent chat");
        return true;
    L13:
        if (r3 != CommentInputConfig.State.ForeClose) goto L16;
        int r11 = b.a;
        Intrinsics.checkNotNullParameter("config force close frequent chat", "msg");
        ALogger.i("FrequentChatEnable", "config force close frequent chat");
        return false;
    L16:
        DataCenter r5 = r9.R();
        if (r5 == null) goto L64;
        IRoom r6 = a0.n(r5);
        if (r6 == null) goto L64;
        IRoomAuthStatus r7 = r6.getRoomAuthStatus();
        if (r7 != null) goto L24;
    L60:
        int r13 = b.a;
        StringBuilder r14 = new StringBuilder("roomauth: ");
        IRoomAuthStatus r8 = r6.getRoomAuthStatus();
        if (r8 == null) goto L63;
        r1 = Boolean.valueOf(r8.isFrequentChatEnable());
    L63:
        r14.append(r1.booleanValue());
        r14.append(", setting value: ");
        r14.append(((ss1.d) a.getValue()).enable);
        String r15 = r14.toString();
        Intrinsics.checkNotNullParameter(r15, "msg");
        ALogger.i("FrequentChatUnable", r15);
        goto L64
    L24:
        if (r7.isFrequentChatEnable() != true) goto L60;
        if (((ss1.d) a.getValue()).enable == false) goto L60;
        IMiddlewareUserService r16 = k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L33;
        e r17 = r16.user();
        if (r17 == null) goto L33;
        r1 = r17.b();
    L33:
        String r18 = r6.getOwnerUserIdString();
        if (r1 == null) goto L41;
        if (r18 == null) goto L41;
        if ((!Intrinsics.areEqual(r18, "0")) == false) goto L41;
        if (TextUtils.equals(r1.getIdString(), r18) == false) goto L41;
        boolean r19 = true;
    L43:
        if (r9.k0() == true) goto L58;
        if (r19 == true) goto L58;
        IMiddlewareUserService r20 = k.f(IMiddlewareUserService.class);
        if (r20 == null) goto L53;
        e r21 = r20.user();
        if (r21 == null) goto L53;
        if (r21.isAdmin() != true) goto L53;
    L54:
        if (r4 == false) goto L56;
        int r23 = b.a;
        Intrinsics.checkNotNullParameter("is Admin", "msg");
        ALogger.i("FrequentChatEnable", "is Admin");
    L57:
        return r4;
    L56:
        int r24 = b.a;
        String r25 = "isAnchor: " + r9.k0() + ", is Anchor Audience: " + r19 + ", isAdmin: " + r4;
        Intrinsics.checkNotNullParameter(r25, "msg");
        ALogger.i("FrequentChatUnable", r25);
    L53:
        r4 = false;
    L58:
        int r26 = b.a;
        String r27 = "isAnchor: " + r9.k0() + ", is Anchor Audience: " + r19;
        Intrinsics.checkNotNullParameter(r27, "msg");
        ALogger.i("FrequentChatEnable", r27);
        return true;
    L41:
        r19 = false;
    L64:
        return false;
    L7:
        r3 = null;
        goto L8
    }
}

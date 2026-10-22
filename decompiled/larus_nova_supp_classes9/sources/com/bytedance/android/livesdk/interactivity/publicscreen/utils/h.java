package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.message.ChatMentionInfo;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r52.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(com.bytedance.android.livesdk.interactivity.api.entity.f r3) {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L38;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L38;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L38;
        String r4 = r2.getIdString();
        if (r4 == null) goto L38;
        IPublicAreaCommon r5 = r3.v();
        if (r5 == null) goto L20;
        ChatMentionInfo r6 = r5.getChatMentionInfo();
        if (r6 == null) goto L20;
        List r7 = r6.getMentionUserIds();
        if (r7 == null) goto L20;
        if (r7.contains(r4) != true) goto L20;
        return true;
    L20:
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L38;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L38;
        IBaseUser r10 = r9.b();
        if (r10 == null) goto L38;
        String r11 = r10.getWebcastUid();
        if (r11 == null) goto L38;
        IPublicAreaCommon r13 = r3.v();
        if (r13 == null) goto L38;
        ChatMentionInfo r14 = r13.getChatMentionInfo();
        if (r14 == null) goto L38;
        List r15 = r14.getMentionWebcastUserIds();
        if (r15 == null) goto L38;
        if (r15.contains(r11) != true) goto L38;
        return true;
    L38:
        return false;
    }

    public static boolean a(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        CommentFlowContext r4 = r2.S();
        if (r4 == null) goto L10;
        CommentInputConfig r5 = r4.d;
        if (r5 == null) goto L7;
        boolean r6 = r5.t;
    L8:
        if (r6 == true) goto L10;
        return false;
    L7:
        r6 = false;
    L10:
        if (r3 == null) goto L12;
        IRoomAuthStatus r7 = r3.getRoomAuthStatus();
    L14:
        if (r7 != null) goto L16;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L23;
        return false;
    L23:
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L27;
        return true;
    L27:
        return false;
    L16:
        if (r7.enableChatMentionV2() != true) goto L20;
        if (r7.getEnableUserCard() != true) goto L20;
        r8 = true;
        goto L21
    L12:
        r7 = null;
        goto L14
    }
}

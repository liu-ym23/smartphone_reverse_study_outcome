package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.biz.im.api.bundle.v2.biz.team.TeamBizData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.team.TeamUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TransformUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(TransformUtils$sp$2.INSTANCE);
    }

    @JvmStatic
    public static final ChatBundleV2 a(Chat r13, Chatter r14, BaseBundle r15) {
        Intrinsics.checkNotNullParameter(r13, "chat");
        Intrinsics.checkNotNullParameter(r15, "baseBundle");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        boolean r3 = true;
        if (r13.isAIBotChat() == false) goto L6;
        int r0 = 3;
    L9:
        r15.c.a = r0;
        Chat.ChatMode r5 = null;
        if (r13.isP2PChat() == false) goto L12;
        String r4 = r13.getP2pChatterId();
    L14:
        if (r0 == 2) goto L18;
        if (r0 == 3) goto L18;
        boolean r1 = false;
    L20:
        if (r1 == false) goto L22;
    L95:
        RealLaunchData r16 = new RealLaunchData(r13.getId(), r4, RealLaunchData.ChatDirection.MY_AI);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination AI");
        BaseBundle r17 = r15.E();
        r17.c.a = r0;
        return new ChatBundleV2(r16, r17);
    L22:
        if (r13.isAIChat() == true) goto L95;
        if (r13.getRole() == Chat.Role.MEMBER) goto L27;
        boolean r2 = true;
    L28:
        ChatTeamBundle r6 = r15.e.a;
        if (r6 == null) goto L31;
        TeamUtils.a(r13, Long.valueOf(r6.a));
    L31:
        if (r2 == true) goto L33;
    L38:
        ChatTeamBundle r7 = r15.e.a;
        if (r7 == null) goto L58;
        TeamChatType r8 = TeamChatType.OPEN;
        long r9 = r7.a;
        Lazy r10 = TeamUtils.a;
        List<ChatTeamInfo> r11 = r13.getBoundTeamInfos();
        if (r11 == null) goto L55;
        Iterator<T> r12 = r11.iterator();
    L44:
        if (r12.hasNext() == false) goto L51;
        Object r18 = r12.next();
        if (((ChatTeamInfo) r18).teamId != r9) goto L48;
        boolean r19 = true;
    L49:
        if (r19 == false) goto L44;
    L52:
        ChatTeamInfo r20 = (ChatTeamInfo) r18;
        if (r20 == null) goto L55;
        TeamChatType r21 = r20.teamChatType;
    L56:
        if (r8 != r21) goto L58;
        boolean r22 = true;
    L59:
        Chat.ChatMode r23 = r15.h.a;
        if (r23 == Chat.ChatMode.UNKNOWN) goto L63;
        r5 = r23;
    L63:
        if (r5 != null) goto L66;
        r5 = r13.getChatMode();
    L66:
        if (r5 != Chat.ChatMode.THREAD_V2) goto L68;
        boolean r24 = true;
    L70:
        if (r24 == false) goto L73;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "team visitor showPosition=-1, isThread=true");
        RealLaunchData r110 = new RealLaunchData(r13.getId(), r4, RealLaunchData.ChatDirection.THREAD);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination THREAD");
        BaseBundle r111 = r15.E();
        TeamBizData r112 = r111.e;
        r112.b = r22;
        r112.c = false;
        return new ChatBundleV2(r110, r111);
    L73:
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "team visitor showPosition=-1, isThread=false");
        if (r14 != null) goto L76;
    L78:
        boolean r113 = false;
    L80:
        if (StringsKt.contains(LarkContext.getApplication().getPackageName(), "com.ss.android.lark", true) == false) goto L82;
    L85:
        boolean r25 = true;
    L86:
        if (r25 == false) goto L88;
        r3 = ((KVRepo) a.getValue()).getBoolean("flow.chat.enter.debug.key", false);
    L88:
        if (r3 == false) goto L90;
        RealLaunchData.ChatDirection r114 = RealLaunchData.ChatDirection.FLOW_CHAT;
    L93:
        RealLaunchData r26 = new RealLaunchData(r13.getId(), r4, r114);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination CHAT");
        ChatBundleV2 r115 = new ChatBundleV2(r26, r15.E());
        ((BaseBundle) r115).b.c = r13.isSecret();
        TeamBizData r116 = ((BaseBundle) r115).e;
        r116.b = r22;
        r116.c = false;
        return r115;
    L90:
        if (r113 == false) goto L92;
        r114 = RealLaunchData.ChatDirection.NEXUS_BOT;
        goto L93
    L92:
        r114 = RealLaunchData.ChatDirection.CHAT;
        goto L93
    L82:
        if (StringsKt.contains(LarkContext.getApplication().getPackageName(), "com.larksuite.suite", true) == true) goto L85;
        r25 = false;
        goto L86
    L76:
        if (r14.isBotAgent() != true) goto L78;
        r113 = true;
        goto L80
    L68:
        r24 = false;
        goto L70
    L48:
        r19 = false;
        goto L49
    L51:
        r18 = null;
    L55:
        r21 = null;
    L58:
        r22 = false;
        goto L59
    L33:
        if (r15.f.a == false) goto L38;
        if (r13.isP2PChat() == true) goto L38;
        RealLaunchData r117 = new RealLaunchData(r13.getId(), r4, RealLaunchData.ChatDirection.GROUP_PROFILE);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination GROUP_PROFILE");
        return new ChatBundleV2(r117, r15.E());
    L27:
        r2 = false;
    L18:
        r1 = true;
        goto L20
    L12:
        r4 = null;
        goto L14
    L6:
        if (r13.isAIMainChat() == false) goto L8;
        r0 = 2;
        goto L9
    L8:
        r0 = 1;
        goto L9
    }
}

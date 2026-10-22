package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateShareHelper;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationShareService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a1 extends a {
    public a1() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.SHARE_VIDEO.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r93, View r94, ef8.b r95) {
        Intrinsics.checkNotNullParameter(r93, "item");
        Intrinsics.checkNotNullParameter(r94, "view");
        Intrinsics.checkNotNullParameter(r95, "menuContext");
        AiGenVideoContentData r1 = r95.j;
        if (r1 != null) goto L8;
        int r2 = com.larus.bmhome.chat.layout.holder.video.j.a;
        r1 = com.larus.bmhome.chat.layout.holder.video.j.a(r95.a.getContent());
        if (r1 != null) goto L8;
        return false;
    L8:
        if (x0.a(r95) == false) goto L10;
        return true;
    L10:
        Context r4 = r94.getContext();
        if (r4 == null) goto L65;
        com.larus.bmhome.chat.api.q0.a r5 = r95.b;
        if (r5 == null) goto L15;
        LifecycleCoroutineScope r6 = r5.F9();
    L16:
        if (r6 != null) goto L18;
    L20:
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L26;
        r7.D0();
        com.larus.home.impl.sdk.b1 r8 = com.larus.home.impl.sdk.b1.a;
        r8.c("chat_long_press_share_save");
        String r9 = r1.getDownloadUrl();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        r8.d(r9);
    L26:
        com.larus.bmhome.chat.api.q0.a r10 = r95.b;
        if (r10 == null) goto L33;
        com.larus.bmhome.chat.component.cvs.y r11 = r10.u0();
        if (r11 == null) goto L33;
        BotModel r12 = r11.j0();
        if (r12 == null) goto L33;
        String r13 = r12.getBotId();
    L34:
        String r14 = r95.a.getMessageId();
        JSONObject r15 = r95.l;
        if (r15 == null) goto L37;
        String r16 = r15.optString("creation_task_id");
    L38:
        JSONObject r17 = r95.l;
        if (r17 == null) goto L41;
        Integer r18 = Integer.valueOf(r17.optInt("position"));
    L42:
        wc9.e r19 = r95.c();
        BotModel r110 = r95.a();
        ChatControlTrace r111 = ChatControlTrace.b;
        r111.getClass();
        String r20 = r111.bb(ChatControlTrace.y);
        String r22 = r111.h(ChatControlTrace.y);
        String r48 = tz9.a.a(r95.a);
        boolean r3 = com.larus.im.bean.message.a.C0(r95.a);
        ICreationMetadataService.Companion r21 = ICreationMetadataService.a;
        UserCreationFromIM r23 = r21.I(r95.a, r16, String.valueOf(r18));
        if (r23 == null) goto L45;
        String r59 = r23.getCreationId();
    L46:
        com.larus.bmhome.share.panel.h r112 = new com.larus.bmhome.share.panel.h(r19, r110, r20, "chat", r22, r13, r14, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r16, r18, r48, Boolean.valueOf(r3), null, null, null, null, null, null, null, null, null, r59, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -4100, 1023);
        String r113 = "";
        com.larus.common_ui.dialog.l0 r24 = new com.larus.common_ui.dialog.l0(r4, 0.0f, false, 6);
        if (r6 == null) goto L65;
        Map r114 = r21.s(r21.I(r95.a, r16, String.valueOf(r18)), r16);
        VideoGenerateShareHelper r25 = VideoGenerateShareHelper.a;
        nr9.g r26 = ff8.a.a(r1);
        if (r14 == null) goto L52;
        r113 = r14;
    L52:
        LifecycleCoroutineScope r96 = r6;
        String r27 = r111.bb(ChatControlTrace.y);
        JSONObject r28 = r95.l;
        if (r28 == null) goto L55;
        String r30 = r28.optString("creation_task_id");
    L56:
        JSONObject r29 = r95.l;
        if (r29 == null) goto L59;
        Integer r31 = Integer.valueOf(r29.optInt("position"));
    L60:
        String r32 = tz9.a.a(r95.a);
        Boolean r33 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r95.a));
        Message r34 = r95.a;
        c4 r115 = new c4(r13, r14, r27, null, null, null, null, r30, r31, r32, r33, r34, r95.l, null, 8312);
        UserCreationFromIM r0 = r21.I(r34, r16, String.valueOf(r18));
        if (r0 == null) goto L63;
        String r116 = r0.getCreationId();
    L64:
        VideoGenerateShareHelper.j(r25, r94, r96, r24, r26, r113, null, r112, r115, null, r116, r114, r1.getTaskType(), 800);
        goto L65
    L63:
        r116 = null;
        goto L64
    L59:
        r31 = null;
        goto L60
    L55:
        r30 = null;
        goto L56
    L45:
        r59 = null;
        goto L46
    L41:
        r18 = null;
        goto L42
    L37:
        r16 = null;
    L33:
        r13 = null;
        goto L34
    L18:
        if (ICreationShareService.a.P(r4, r6, CollectionsKt.listOf(new String[]{r1.getLocalUrl(), r1.getDownloadUrl(), r1.getVideoModel()})) == false) goto L20;
        return true;
    L15:
        r6 = null;
    L65:
        return true;
    }
}

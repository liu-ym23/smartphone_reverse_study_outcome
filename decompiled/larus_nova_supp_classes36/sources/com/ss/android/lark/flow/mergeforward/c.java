package com.ss.android.lark.flow.mergeforward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.i;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.navigation.Navigation;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void c(Context r2, Message r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
        b(r2, r3.getChatId(), r3.getContent(), r3, r4);
    }

    @JvmStatic
    public static final void b(Context r7, String r8, MergeForwardContent r9, Message r10, i r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "chatId");
        Intrinsics.checkNotNullParameter(r9, "messageContent");
        a(Contexts.requireActivity(r7), r9, null, r10, r8, 4, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(Activity r6, MergeForwardContent r7, MergeForwardContent r8, Message r9, String r10, int r11, i r12) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "mergeForwardContent");
        Intrinsics.checkNotNullParameter(r10, "chatId");
        Intent r0 = new Intent(r6, FlowMergeForwardActivity.class);
        ChatBundle.a r1 = new ChatBundle.a();
        r1.a = r10;
        r0.putExtras(new ChatBundle(r1).l());
        if (r11 == (-1)) goto L5;
        r0.putExtra("serializable_from_type", r11);
    L5:
        String r13 = r7.getMessageId();
        boolean r2 = false;
        if (r13 != null) goto L8;
    L11:
        boolean r14 = true;
    L12:
        String r3 = null;
        if (r14 == false) goto L18;
        if (r9 == null) goto L16;
        String r15 = r9.getId();
    L17:
        r7.setMessageId(r15);
        goto L18
    L16:
        r15 = null;
    L18:
        String r16 = r7.getTitle();
        if (r16 != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L27;
        r7.setTitle(((IIMApi) ApiUtils.getApi(IIMApi.class)).getMergeForwardContentTitle(r7));
    L27:
        com.ss.android.lark.mergeforward.b.a r18 = com.ss.android.lark.mergeforward.b.a;
        String r19 = r7.getMessageId();
        if (r19 != null) goto L30;
        r19 = "";
    L30:
        Intrinsics.checkNotNullParameter(r19, "msgId");
        Intrinsics.checkNotNullParameter("", "favoriteId");
        com.ss.android.lark.mergeforward.b.d++;
        String r5 = com.ss.android.lark.mergeforward.b.b;
        if (r5 != null) goto L33;
    L36:
        boolean r20 = true;
    L37:
        if (r20 == false) goto L39;
        com.ss.android.lark.mergeforward.b.b = r19;
    L39:
        String r110 = com.ss.android.lark.mergeforward.b.c;
        if (r110 != null) goto L42;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == true) goto L48;
    L52:
        com.ss.android.lark.mergeforward.b.a = new com.ss.android.lark.mergeforward.b.a(r7, r8, r9);
        List<String> r21 = CollectionsKt.emptyList();
        if ((r6 instanceof FlowMergeForwardActivity) == false) goto L55;
        r21 = ((FlowMergeForwardActivity) r6).c;
    L55:
        List<String> r22 = r21;
        if ((!r22.isEmpty()) == false) goto L59;
        r0.putStringArrayListExtra("key_msg_id_path_list", new ArrayList(r22));
    L59:
        if (qyb.a.a(null) == false) goto L61;
        r0.putExtra("key_merge_forward_preview_id", null);
    L61:
        if (r12 == null) goto L63;
        String r23 = r12.a;
    L65:
        if (qyb.a.a(r23) == false) goto L69;
        if (r12 == null) goto L68;
        r3 = r12.a;
    L68:
        r0.putExtra("key_origin_doubao_msg_id", r3);
    L69:
        ForsetiConfig.b();
        Navigation.from(r6).openActivity(r0, -1);
        return;
    L63:
        r23 = null;
        goto L65
    L48:
        if ("".length() <= 0) goto L50;
        r2 = true;
    L50:
        if (r2 == false) goto L52;
        com.ss.android.lark.mergeforward.b.c = "";
        goto L52
    L42:
        if (StringsKt.isBlank(r110) == true) goto L45;
        r111 = false;
        goto L46
    L33:
        if (StringsKt.isBlank(r5) == true) goto L36;
        r20 = false;
        goto L37
    L21:
        if (r16.length() == 0) goto L24;
        r17 = false;
        goto L25
    L8:
        if (r13.length() == 0) goto L11;
        r14 = false;
        goto L12
    }
}

package com.ss.android.lark.chat.service.impl;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a1 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.text.SpannableStringBuilder] */
    public static pxa.a a(MergeForwardContent r11) {
        ArrayList r0 = new ArrayList();
        if (r11 == null) goto L23;
        String r1 = ((IIMApi) ApiUtils.getApi(IIMApi.class)).getMergeForwardContentTitle(r11);
        r11.setTitle(r1);
        ?? r2 = new SpannableStringBuilder();
        List<Message> r3 = r11.getMessages();
        if (CollectionUtils.isEmpty(r3) == true) goto L25;
        Map<String, ChatterInfo> r12 = r11.getChatters();
        int r4 = Math.min(r3.size(), 5);
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L25;
        pxa.b.a r6 = new pxa.b.a();
        Message r7 = (Message) ListProtector.get(r3, r5);
        ChatterInfo r8 = r12.get(r7.getFromId());
        if (r8 == null) goto L12;
        r2.append(r8.getName()).append(": ");
        String r9 = r8.getName();
        Intrinsics.checkNotNullParameter(r9, IPortraitService.NAME);
        ((com.ss.android.lark.biz.im.api.n0.a) r6).d = r9;
        String r10 = r8.getId();
        Intrinsics.checkNotNullParameter(r10, "senderId");
        ((com.ss.android.lark.biz.im.api.n0.a) r6).b = r10;
        String r13 = r8.getAvatarKey();
        Intrinsics.checkNotNullParameter(r13, "avatarKey");
        ((com.ss.android.lark.biz.im.api.n0.a) r6).c = r13;
    L12:
        if (com.ss.android.lark.chat.utils.h0.m(r7) == false) goto L14;
        r2.append(UIHelper.getString(2131892287));
    L14:
        CharSequence r14 = com.ss.android.lark.chat.utils.g0.b(ChatCoreModule.a().getContext(), r7, v2c.a.b(ChatCoreModule.a().getContext(), 2131106607));
        if (r7.getType() == Message.Type.DOUBAO) goto L17;
    L19:
        r2.append(r14);
        if (r5 == (r4 - 1)) goto L22;
        r2.append("\n");
    L22:
        Intrinsics.checkNotNullParameter(r14, "content");
        ((com.ss.android.lark.biz.im.api.n0.a) r6).e = r14;
        String r15 = r7.getId();
        Intrinsics.checkNotNullParameter(r15, "messageId");
        ((com.ss.android.lark.biz.im.api.n0.a) r6).a = r15;
        ((com.ss.android.lark.biz.im.api.n0.a) r6).f = r7.getPosition();
        r0.add(new pxa.b(r6));
        r5 = r5 + 1;
        goto L7
    L17:
        if (ChatCoreModule.a().isLarkPkg() == false) goto L19;
        r14 = UIHelper.getString(2131891057);
    L25:
        return new pxa.a(r1, r2, r0);
    L23:
        r1 = BuildConfig.FLAVOR;
        r2 = BuildConfig.FLAVOR;
        goto L25
    }
}

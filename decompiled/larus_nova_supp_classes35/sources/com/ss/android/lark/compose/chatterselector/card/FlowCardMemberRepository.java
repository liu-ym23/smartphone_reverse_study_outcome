package com.ss.android.lark.compose.chatterselector.card;

import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.contact.v1.MGetChattersRequest;
import com.lark.kmp.pb.contact.v1.MGetChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.c;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowCardMemberRepository {
    public final d a;

    public FlowCardMemberRepository(d r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public final Object a(List<String> r11, String r12, Continuation<? super List<ChatChatter>> r13) {
        if ((r13 instanceof FlowCardMemberRepository$fetchSelectedChatters$1) == false) goto L7;
        FlowCardMemberRepository$fetchSelectedChatters$1 r0 = (FlowCardMemberRepository$fetchSelectedChatters$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r12 = (String) r0.L$1;
        r11 = (List) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        Map r15 = ((MGetChattersResponse) ((k) r14).b).getEntity().getChatters();
        ArrayList r4 = new ArrayList();
        Iterator<T> r16 = r11.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        Chatter r5 = (Chatter) r15.get((String) r16.next());
        if (r5 == null) goto L23;
        r4.add(r5);
        goto L23
    L27:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r18 = r4.iterator();
    L29:
        if (r18.hasNext() == false) goto L56;
        Chatter r6 = (Chatter) r18.next();
        com.ss.android.lark.chat.entity.chatter.Chatter r7 = new com.ss.android.lark.chat.entity.chatter.Chatter();
        r7.setId(r6.getId());
        r7.setName(r6.getName());
        String r8 = r6.getLocalized_name();
        if (r8 != null) goto L33;
    L37:
        r8 = r6.getName();
    L38:
        r7.setLocalizedName(r8);
        String r9 = r6.getAlias();
        String r10 = BuildConfig.FLAVOR;
        if (r9 != null) goto L41;
        r9 = BuildConfig.FLAVOR;
    L41:
        r7.setAlias(r9);
        String r19 = r6.getAvatar_key();
        if (r19 == null) goto L45;
        r10 = r19;
    L45:
        r7.setAvatarKey(r10);
        r7.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.valueOf(r6.getType().getValue()));
        ChatChatter r20 = new ChatChatter(r7);
        if (r12 != null) goto L48;
    L51:
        boolean r21 = true;
    L52:
        if (r21 == true) goto L54;
        r20.setChatId(r12);
    L54:
        r17.add(r20);
        goto L29
    L48:
        if (StringsKt.isBlank(r12) == true) goto L51;
        r21 = false;
        goto L52
    L33:
        if (Boolean.valueOf(!StringsKt.isBlank(r8)).booleanValue() == true) goto L36;
        r8 = null;
    L36:
        if (r8 != null) goto L38;
    L56:
        return CollectionsKt.toMutableList(r17);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r11.isEmpty() == true) goto L17;
        MGetChattersRequest.a r22 = new MGetChattersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chatter_ids");
        com.lark.wire.internal.a.a(r11);
        r22.d = r11;
        r22.e = Boxing.boxBoolean(true);
        RustOutputKt$errorAsException$.inlined.map.1 r110 = i.a(this.a.b(new c(r22, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, 120)).a());
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.label = 1;
        r14 = e.s(r110, r0);
        if (r14 != r2) goto L21;
        return r2;
    L17:
        return new ArrayList();
    L7:
        r0 = new FlowCardMemberRepository$fetchSelectedChatters$1(this, r13);
        goto L8
    }
}

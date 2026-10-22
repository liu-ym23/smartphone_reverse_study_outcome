package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface h {
    Map<String, ChatChatter> A2(String r1, List<String> r2);

    void E9(String r1, List<String> r2, IGetDataCallback<Map<String, ChatChatter>> r3);

    void F5(Chatter r1);

    ChatChatter H5(String r1, String r2);

    ChatChatter He(String r1, String r2);

    Map I3(String r1, List r2);

    void L2(NewFriendBadgeRepository.getBadge.1 r1);

    void N7(String r1, IGetDataCallback<Boolean> r2);

    void W8(OfficeExternalContactViewModel.fetchSelfCardHeader.1 r1);

    Map<String, Chatter> a0(List<String> r1);

    void j1(String r1, IGetDataCallback<Chatter> r2);

    Map<String, Chatter> l0(List<String> r1);

    Chatter l7(String r1);

    Map<String, ChatChatter> ld(String r1, List<String> r2);

    void pd(String r1, IGetDataCallback<Chatter> r2);

    Pair<ChatChatter, OpenApp> qb(String r1, String r2);

    Chatter ue(String r1);

    void v3(List<String> r1, IGetDataCallback<Map<String, Chatter>> r2);

    ChatChatter x1(String r1);

    Chatter zb();
}

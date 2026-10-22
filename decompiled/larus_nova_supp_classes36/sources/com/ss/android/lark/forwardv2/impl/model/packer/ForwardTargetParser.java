package com.ss.android.lark.forwardv2.impl.model.packer;

import com.bytedance.lark.pb.basic.v1.Tag;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.dto.ThreadTarget;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForwardTargetParser {
    static {
    }

    @JvmStatic
    public static final ForwardTarget a(SearchBaseInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "searchBaseInfo");
        boolean r1 = false;
        if ((r8 instanceof SearchShieldP2PChatInfo) == false) goto L6;
        Chat r0 = new Chat();
        SearchShieldP2PChatInfo r2 = (SearchShieldP2PChatInfo) r8;
        r0.setName(r2.getTitle());
        r0.setId(r2.getId());
        r0.setAvatarKey(r2.getAvatarKey());
        r0.setCrossTenant(r8.isCrossTenant());
        SearchShieldP2PChatInfo r9 = (SearchShieldP2PChatInfo) r8;
        r0.setP2pChatterId(r9.getChatterId());
        r0.setTagData(r9.getTagData());
        r0.setTenantId(r9.getTenantId());
        r0.setType(Chat.Type.P2P);
        ForwardTarget r10 = new ForwardTarget(r0);
        r10.d = false;
        return r10;
    L6:
        if ((r8 instanceof SearchChatInfo) == false) goto L12;
        Chat r3 = new Chat();
        SearchChatInfo r4 = (SearchChatInfo) r8;
        r3.setName(r4.getTitle());
        r3.setId(r4.getId());
        r3.setAvatarKey(r4.getAvatarKey());
        r3.setType(r4.getChatType());
        r3.setPublic(r4.isPublic());
        r3.setIs_department(r4.isDepartment());
        r3.setCrossTenant(r8.isCrossTenant());
        SearchChatInfo r11 = (SearchChatInfo) r8;
        r3.setChatMode(Chat.ChatMode.valueOf(r11.getChatMode().getNumber()));
        r3.setUserCount(r11.getUserCount());
        r3.setMemberCount(r11.getMemberCount());
        r3.setTenant(r11.isTenant());
        r3.setTagData(r11.getTagData());
        ForwardTarget r5 = new ForwardTarget(r3);
        List r12 = r11.getTags();
        if (r12 == null) goto L10;
        r1 = r12.contains(Tag.BOT);
    L10:
        r5.d = r1;
        return r5;
    L12:
        if ((r8 instanceof SearchChatterInfo) == false) goto L15;
        Chatter r6 = new Chatter();
        SearchChatterInfo r13 = (SearchChatterInfo) r8;
        r6.setName(r13.getTitle());
        r6.setLocalizedName(r13.getTitle());
        r6.setId(r13.getId());
        r6.setAvatarKey(r13.getAvatarKey());
        r6.setCrossTenant(r13.isCrossTenant());
        r6.setType(Chatter.ChatterType.valueOf(r13.getChatterType().getNumber()));
        r6.setDescription(r13.getChatterDescription());
        r6.setRegistered(r13.isRegistered());
        r6.setInContacts(r13.isInContacts());
        r6.setCanJoinGroup(r13.isCanJoinGroup());
        r6.setTenantId(r13.getTenantId());
        r6.setZenModeEndTime(r13.getZenModeEndTime());
        r6.setTagData(r13.getTagData());
        ForwardTarget r14 = new ForwardTarget(r6);
        r14.d = r6.isBot();
        return r14;
    L15:
        if ((r8 instanceof SearchThreadInfo) == false) goto L23;
        SearchThreadInfo r15 = (SearchThreadInfo) r8;
        String r7 = r15.getId();
        String r16 = r15.getTitle();
        String r17 = r15.getAvatarKey();
        Channel r18 = r15.getChannel();
        if (r18 == null) goto L20;
        String r19 = r18.getId();
        if (r19 == null) goto L20;
    L21:
        ForwardTarget r20 = new ForwardTarget(new ThreadTarget(r7, r16, r17, r19));
    L31:
        return r20;
    L20:
        r19 = "";
        goto L21
    L23:
        if ((r8 instanceof SearchReplyInThreadInfo) == false) goto L26;
        SearchReplyInThreadInfo r21 = (SearchReplyInThreadInfo) r8;
        r20 = new ForwardTarget(new ThreadTarget(r21.getId(), r21.getTitle(), r21.getAvatarKey(), r21.getChatId(), true));
        goto L31
    L26:
        return null;
    }

    @JvmStatic
    public static final List<ForwardTarget> b(List<? extends SearchBaseInfo> r1) {
        Intrinsics.checkNotNullParameter(r1, "searchInfoList");
        return SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(SequencesKt.filterNotNull(CollectionsKt.asSequence(r1)), ForwardTargetParser$searchInfos2Targets$1.INSTANCE)));
    }
}

package com.ss.android.lark.forwardv2.impl.model.service;

import android.os.SystemClock;
import com.bytedance.lark.pb.feed.v1.GetRecentTransmitTargetsResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv3.ForwardImServices;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.keyboard.plugin.tool.face.Conf$StickerSetManagerPosition;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/forwardv2/impl/model/service/ForwardService$getRecentForwardDataList$innerCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/feed/v1/GetRecentTransmitTargetsResponse;", "onSuccess", "", "response", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardService$getRecentForwardDataList$innerCallback$1 implements IGetDataCallback<GetRecentTransmitTargetsResponse> {
    final /* synthetic */ IGetDataCallback<List<SearchBaseInfo>> $callback;
    final /* synthetic */ ForwardTemplate $forwardTemplate;
    final /* synthetic */ boolean $isLocal;
    final /* synthetic */ long $startRequestForward;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        this.$callback.onSuccess(new ArrayList());
        Log.e("Android_Recent_Forward", "from local: " + this.$isLocal + ", GetRecentTransmitTargetsResponse + " + r3, r3.getCause());
    }

    public void onSuccess(GetRecentTransmitTargetsResponse r11) {
        ArrayList r0 = new ArrayList();
        Log.i("Android_Recent_Forward", "load recent forward successful, sdk cost: " + (SystemClock.elapsedRealtime() - this.$startRequestForward) + ", from local: " + this.$isLocal);
        if (r11 == null) goto L5;
        List r3 = r11.targets;
    L6:
        if (r3 != null) goto L9;
        Log.i("Android_Recent_Forward", "target is null, from local: " + this.$isLocal);
        this.$callback.onSuccess(new ArrayList());
        return;
    L9:
        Iterable r12 = r11.targets;
        if (r12 != null) goto L12;
        r12 = new ArrayList();
    L12:
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L161;
        GetRecentTransmitTargetsResponse.RecentTransmitTarget r2 = (GetRecentTransmitTargetsResponse.RecentTransmitTarget) r13.next();
        com.ss.android.lark.forwardv3.utils.b.d();
        WeakReference<Message> r4 = ForwardDataUtils.a;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "pb");
        String r5 = r2.chatter_id;
        boolean r6 = true;
        boolean r7 = false;
        if (r5 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        String r9 = "";
        if (r8 == false) goto L97;
        ImSdkChatService r10 = (ImSdkChatService) ForwardImServices.a.getValue();
        if (r10 == null) goto L27;
        Chat r14 = r10.we(r2.chat_id);
    L28:
        SearchChatInfo r15 = new SearchChatInfo();
        r15.setScene(Scene.Type.TRANSMIT_MESSAGES);
        r15.setTitle(r2.name);
        r15.setAvatarKey(r2.avatar_key);
        r15.setTimeStamp(r2.timestamp.longValue());
        String r16 = r2.chat_id;
        if (r16 == null) goto L32;
        r9 = r16;
    L32:
        r15.setId(r9);
        r15.setChatType(Chat.Type.GROUP);
        if (r14 == null) goto L35;
        boolean r17 = r14.isPublic();
    L36:
        r15.setPublic(r17);
        if (r14 == null) goto L39;
        boolean r18 = r14.is_department();
    L40:
        r15.setDepartment(r18);
        if (r14 == null) goto L43;
        boolean r19 = r14.isCrossTenant();
    L44:
        r15.setCrossTenant(r19);
        if (r14 == null) goto L47;
        boolean r20 = r14.isCrossWithKa();
    L48:
        r15.setCrossWithKa(r20);
        if (r14 == null) goto L52;
        Chat.ChatMode r21 = r14.getChatMode();
        if (r21 == null) goto L52;
    L53:
        r15.setChatMode(r21);
        if (r14 == null) goto L56;
        int r22 = r14.getUserCount();
    L57:
        r15.setUserCount(r22);
        if (r14 == null) goto L60;
        boolean r23 = r14.isTenant();
    L61:
        r15.setTenant(r23);
        if (r14 == null) goto L64;
        TagData r24 = r14.getTagData();
    L65:
        r15.setTagData(r24);
        if (r14 == null) goto L68;
        List r25 = r14.getTags();
    L69:
        r15.setTags(r25);
        if (r14 == null) goto L72;
        boolean r26 = r14.isMeeting();
    L73:
        r15.setMeeting(r26);
        if (r14 == null) goto L76;
        boolean r27 = r14.isSecret();
    L77:
        r15.setSecretChat(r27);
        if (r14 == null) goto L80;
        boolean r28 = r14.isOfficialOncall();
    L81:
        r15.setOfficialOnCall(r28);
        r15.setCountLightStyle(true);
        if (r14 == null) goto L84;
        int r29 = r14.getLastMessagePosition();
    L85:
        r15.setLastMessagePosition(r29);
        if (r14 == null) goto L88;
        r7 = r14.isRemind();
    L88:
        r15.setRemind(r7);
        if (r14 == null) goto L92;
        ChatDisplayModeSetting r30 = r14.getChatDisplayModeSetting();
        if (r30 == null) goto L92;
    L93:
        r15.setChatDisplayModeSetting(r30);
        if (r14 == null) goto L96;
        r6 = r14.isUserCountVisible();
    L96:
        r15.setUserCountVisible(r6);
    L160:
        r0.add(r15);
    L92:
        r30 = ChatDisplayModeSetting.DEFAULT;
        goto L93
    L84:
        r29 = 0;
        goto L85
    L80:
        r28 = false;
        goto L81
    L76:
        r27 = false;
        goto L77
    L72:
        r26 = false;
        goto L73
    L68:
        r25 = null;
        goto L69
    L64:
        r24 = null;
        goto L65
    L60:
        r23 = false;
        goto L61
    L56:
        r22 = 0;
    L52:
        r21 = Chat.ChatMode.DEFAULT;
        goto L53
    L47:
        r20 = false;
        goto L48
    L43:
        r19 = false;
        goto L44
    L39:
        r18 = false;
        goto L40
    L35:
        r17 = false;
        goto L36
    L27:
        r14 = null;
        goto L28
    L97:
        h r31 = (h) ForwardImServices.b.getValue();
        if (r31 == null) goto L100;
        Chatter r32 = r31.ue(r2.chatter_id);
    L101:
        r15 = new SearchChatterInfo();
        r15.setScene(Scene.Type.TRANSMIT_MESSAGES);
        r15.setTitle(r2.name);
        r15.setAvatarKey(r2.avatar_key);
        r15.setTimeStamp(r2.timestamp.longValue());
        String r33 = r2.chatter_id;
        if (r33 != null) goto L104;
        r33 = "";
    L104:
        r15.setId(r33);
        r15.setType(1);
        String r34 = r2.chat_id;
        if (r34 == null) goto L108;
        r9 = r34;
    L108:
        r15.setP2pChatId(r9);
        if (r32 == null) goto L111;
        boolean r35 = r32.isRegistered();
    L112:
        r15.setRegistered(r35);
        if (r32 == null) goto L116;
        Chatter.ChatterType r36 = r32.getType();
        if (r36 == null) goto L116;
    L117:
        r15.setChatterType(r36);
        ChatterCustomStatus.a r37 = ChatterCustomStatus.Companion;
        if (r32 == null) goto L120;
        List r38 = r32.getCustomStatus();
    L121:
        r37.getClass();
        List r39 = ChatterCustomStatus.a.c(r38);
        if (r39 == null) goto L125;
        List r40 = CollectionsKt.toMutableList(r39);
        if (r40 == null) goto L125;
    L126:
        r15.setStatusList(r40);
        if (r32 == null) goto L129;
        long r41 = r32.getZenModeEndTime();
    L130:
        r15.setZenModeEndTime(r41);
        if (r32 == null) goto L134;
        ChatterDescription r42 = r32.getDescription();
        if (r42 == null) goto L134;
    L135:
        r15.setChatterDescription(r42);
        if (r32 == null) goto L138;
        boolean r43 = r32.isInContacts();
    L139:
        r15.setInContacts(r43);
        if (r32 == null) goto L142;
        boolean r44 = r32.isCanJoinGroup();
    L143:
        r15.setCanJoinGroup(r44);
        if (r32 == null) goto L147;
        String r45 = r32.getTenantId();
        if (r45 == null) goto L147;
    L148:
        r15.setTenantId(r45);
        if (r32 == null) goto L151;
        TagData r46 = r32.getTagData();
    L152:
        r15.setTagData(r46);
        if (r32 == null) goto L155;
        int r47 = r32.getBotExtraType();
    L156:
        r15.setBotExtType(r47);
        if (r32 == null) goto L159;
        r7 = r32.isAgent();
    L159:
        r15.setAgent(r7);
        goto L160
    L155:
        r47 = 0;
        goto L156
    L151:
        r46 = null;
    L147:
        r45 = Conf$StickerSetManagerPosition.STICKER_SET_CHAT_PANEL;
        goto L148
    L142:
        r44 = false;
        goto L143
    L138:
        r43 = false;
    L134:
        r42 = new ChatterDescription();
        goto L135
    L129:
        r41 = 0;
    L125:
        r40 = new ArrayList();
        goto L126
    L120:
        r38 = null;
    L116:
        r36 = Chatter.ChatterType.USER;
        goto L117
    L111:
        r35 = false;
        goto L112
    L100:
        r32 = null;
        goto L101
    L18:
        if (r5.length() == 0) goto L21;
        r8 = false;
        goto L22
    L161:
        com.ss.android.lark.forwardv3.utils.b.d();
        this.$callback.onSuccess(CollectionsKt.toMutableList(CollectionsKt.take(r0, 30)));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((GetRecentTransmitTargetsResponse) r1);
    }

    public ForwardService$getRecentForwardDataList$innerCallback$1(long r1, boolean r3, IGetDataCallback<List<SearchBaseInfo>> r4, ForwardTemplate r5) {
        this.$startRequestForward = r1;
        this.$isLocal = r3;
        this.$callback = r4;
        this.$forwardTemplate = r5;
    }
}

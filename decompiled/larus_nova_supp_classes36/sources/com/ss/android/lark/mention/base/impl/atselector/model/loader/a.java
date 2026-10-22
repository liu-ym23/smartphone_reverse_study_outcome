package com.ss.android.lark.mention.base.impl.atselector.model.loader;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.l;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.MentionUtils;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BottomSearchTipBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.GroupMemAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.UserGroupBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.WantAtMemBean;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final boolean a;
    public final Chat b;
    public final List<ChatChatter> c;
    public final List<ChatChatter> d;
    public final List<UserGroupEntity> e;
    public final Map<String, String> f;
    public final Locale g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public final List<BaseAtBean> a() {
        ArrayList r0 = new ArrayList();
        Chat r1 = this.b;
        if (r1 != null) goto L5;
        return r0;
    L5:
        b(r1, this.h, r0);
        Chat r2 = this.b;
        boolean r3 = this.i;
        int r5 = 0;
        if (r2.getType() == Chat.Type.GROUP) goto L8;
    L15:
        int r4 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_mention_top") == true) goto L18;
    L38:
        Chat r6 = this.b;
        List<ChatChatter> r7 = this.c;
        List<UserGroupEntity> r8 = this.e;
        if (r6.getType() == Chat.Type.GROUP) goto L43;
        if (r6.getType() == Chat.Type.TOPIC_GROUP) goto L43;
    L68:
        Chat r9 = this.b;
        List<ChatChatter> r10 = this.d;
        boolean r11 = this.a;
        if (r0.size() > 0) goto L71;
    L73:
        int r12 = com.ss.android.lark.mention.base.b.a;
        if (r10 == null) goto L76;
        okb.a r13 = m.a;
        Collections.sort(r10, new l());
    L76:
        ArrayList r14 = (ArrayList) r10;
        if (r5 >= r14.size()) goto L89;
        ChatChatter r15 = (ChatChatter) ListProtector.get(r14, r5);
        int r16 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_mention_top") == true) goto L81;
    L83:
        GroupMemAtBean r17 = new GroupMemAtBean(com.ss.android.lark.mention.base.impl.atselector.bean.b.a(r15));
        r17.setLetter(m.a(r15, this.g));
        r0.add(r17);
        if (r5 != (r14.size() - 1)) goto L88;
        r17.setHideDivider(true);
        if (r11 == false) goto L88;
        r17.showShadow(true);
    L88:
        r5 = r5 + 1;
        goto L76
    L81:
        if ("mention_ai_knowledge".equals(r15.getId()) == false) goto L83;
    L89:
        boolean r18 = this.a;
        if (CollectionUtils.isNotEmpty(r0) == false) goto L93;
        if (r18 == false) goto L93;
        r0.add(new BottomSearchTipBean());
    L93:
        return r0;
    L71:
        if (r9.getType() != Chat.Type.GROUP) goto L73;
        r0.add(new LabelAtBean(UIHelper.getString(2131891513)));
    L43:
        if (CollectionUtils.isEmpty(r7) == true) goto L58;
        r0.add(new LabelAtBean(UIHelper.getString(2131891450)));
        Iterator r19 = ((ArrayList) r7).iterator();
        int r20 = 1;
    L46:
        if (r19.hasNext() == false) goto L58;
        ChatChatter r110 = (ChatChatter) r19.next();
        int r111 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_mention_top") == false) goto L52;
        if ("mention_ai_knowledge".equals(r110.getId()) == true) goto L46;
    L52:
        com.ss.android.lark.mention.base.impl.atselector.bean.a r112 = com.ss.android.lark.mention.base.impl.atselector.bean.b.a(r110);
        WantAtMemBean r113 = new WantAtMemBean(r112);
        Map<String, String> r114 = this.f;
        HashMap r115 = (HashMap) r114;
        if (r115.containsKey(r112.a) == false) goto L55;
        Map<String, String> r116 = this.f;
        HashMap r117 = (HashMap) r116;
        String r118 = (String) r117.get(r112.a);
    L56:
        r113.setGuessType(r118);
        int r119 = r20 + 1;
        r113.setSearchLocation(String.valueOf(r20));
        r0.add(r113);
        r20 = r119;
        goto L46
    L55:
        r118 = "";
    L58:
        if (CollectionUtils.isEmpty(r8) == true) goto L67;
        StringBuilder r21 = new StringBuilder("mention userGroups size: ");
        ArrayList r22 = (ArrayList) r8;
        r21.append(r22.size());
        Log.i("Mention_DataComposer", r21.toString());
        if (CollectionUtils.isEmpty(r7) == false) goto L62;
        r0.add(new LabelAtBean(UIHelper.getString(2131891450)));
    L62:
        int r23 = MentionUtils.a;
        Intrinsics.checkNotNullParameter(r22, "origin");
        List r24 = CollectionsKt.take(r22, 3);
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L64:
        if (r26.hasNext() == false) goto L66;
        r25.add(new UserGroupBean((UserGroupEntity) r26.next()));
        goto L64
    L66:
        r0.addAll(r25);
        goto L68
    L67:
        Log.i("Mention_DataComposer", "mention userGroups is empty");
        goto L68
    L18:
        if (this.j == false) goto L38;
        if (CollectionUtils.isEmpty(r0) == true) goto L36;
        Iterator r27 = r0.iterator();
    L23:
        if (r27.hasNext() == false) goto L27;
        if ("mention_ai_knowledge".equals(((BaseAtBean) r27.next()).getId()) == false) goto L23;
    L27:
        int r28 = 0;
    L29:
        if (r28 >= r0.size()) goto L36;
        BaseAtBean r29 = (BaseAtBean) ListProtector.get(r0, r28);
        if ((r29 instanceof AllAtBean) == true) goto L37;
        Pattern r30 = o.a;
        if ("all".equals(r29.getId()) == true) goto L37;
        r28 = r28 + 1;
    L37:
        String r31 = UIHelper.getString(2131891028);
        int r32 = r28 + 1;
        ListProtector.add(r0, r32, new SearchBean(new com.ss.android.lark.mention.base.impl.atselector.bean.a(arb.a.b.a0(r31), UIHelper.getString(2131891203), Chatter.ChatterType.USER)));
    L36:
        r28 = -1;
        goto L37
    L8:
        if (MentionUtils.d(r2) == false) goto L10;
    L11:
        if (r3 == false) goto L13;
        int r33 = r2.getUserCount();
    L14:
        r0.add(new AllAtBean(r33));
        goto L15
    L13:
        r33 = 0;
        goto L14
    L10:
        if (r2.getAtAllPermission() != Chat.AtAllPermission.ALL_MEMBERS) goto L15;
        goto L11
    }

    public static void b(Chat r7, boolean r8, List r9) {
        Log.i("Mention_DataComposer", "customEnableMyAI: " + r8);
        if (r8 == true) goto L5;
        return;
    L5:
        if (arb.a.b.X() == false) goto L48;
        boolean r10 = r7.isSecret();
        boolean r11 = r7.isAIChat();
        boolean r1 = r7.isCrossTenant();
        boolean r2 = r7.isCrossWithKa();
        int r3 = MentionUtils.a;
        Intrinsics.checkNotNullParameter(r7, "chat");
        boolean r4 = false;
        if (r7.getHasVCChatPermission() == false) goto L10;
    L31:
        boolean r12 = false;
    L32:
        Log.i("Mention_DataComposer", "isSecret:" + r10 + ", isAIChat:" + r11 + ", isCrossTenant:" + r1 + ", isCrossWithKa:" + r2 + ", isTeamOpenChatVisitor:" + r12);
        if (r10 == true) goto L39;
        if (r11 == true) goto L39;
        if (r1 == true) goto L39;
        if (r2 == true) goto L39;
        if (r12 == true) goto L39;
        r4 = true;
    L39:
        if (r4 == false) goto L49;
        arb.a.b.W();
        return;
    L49:
        return;
    L10:
        if (Chat.Role.MEMBER == r7.getRole()) goto L31;
        List r13 = r7.getBoundTeamInfos();
        if (r13 == null) goto L31;
        List r14 = r13;
        if ((r14 instanceof Collection) == true) goto L17;
    L19:
        Iterator r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L28;
        if (TeamChatType.OPEN != ((ChatTeamInfo) r15.next()).teamChatType) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L21;
        boolean r16 = true;
    L29:
        if (r16 != true) goto L31;
        r12 = true;
        goto L32
    L25:
        r5 = false;
    L28:
        r16 = false;
        goto L29
    L17:
        if (r14.isEmpty() == false) goto L19;
    }

    public a(Chat r5, @Nullable List<ChatChatter> r6, List<ChatChatter> r7, Map<String, String> r8, @Nullable List<UserGroupEntity> r9, boolean r10, boolean r11, boolean r12, boolean r13) {
        ArrayList r0 = new ArrayList();
        this.c = r0;
        ArrayList r1 = new ArrayList();
        this.d = r1;
        ArrayList r2 = new ArrayList();
        this.e = r2;
        HashMap r3 = new HashMap();
        this.f = r3;
        this.b = r5;
        CollectionUtils.resetToList(r0, r6);
        CollectionUtils.resetToList(r1, r7);
        CollectionUtils.resetToList(r2, r9);
        if (CollectionUtils.isNotEmpty(r8) == false) goto L5;
        r3.putAll(r8);
    L5:
        this.a = r10;
        e.a().getClass();
        int r14 = com.ss.android.lark.language.service.impl.a.f;
        this.g = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        this.h = r11;
        this.i = r12;
        this.j = r13;
    }
}

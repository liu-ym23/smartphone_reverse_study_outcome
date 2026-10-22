package k7b;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.b;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q2c.c;
import q2c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {

    /* JADX INFO: renamed from: k7b.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0245a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChatterDescription.Type.values().length];
            a = r0;
            r0[ChatterDescription.Type.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ChatterDescription.Type.BUSINESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ChatterDescription.Type.LEAVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ChatterDescription.Type.MEETING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static List b(List r13) {
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(r13) == false) goto L5;
        return r0;
    L5:
        String r1 = ChatCoreModule.a().getLoginDependency().getUserId();
        ChatterNameDisplayRule r2 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Iterator r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L42;
        ReactionInfo r3 = (ReactionInfo) r14.next();
        ReactionDetailViewModel r4 = new ReactionDetailViewModel();
        r4.setReactionKey(r3.getReaction().getType());
        ArrayList r5 = new ArrayList();
        Map<String, ChatChatter> r6 = r3.getReactionChatters();
        List<String> r7 = r3.getReaction().getChatterIds();
        if (r7.contains(r1) == true) goto L11;
    L14:
        Iterator<String> r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L41;
        ChatChatter r9 = r6.get(r8.next());
        if (r9 == null) goto L16;
        DetailUserInfo r10 = new DetailUserInfo();
        r10.setAvatarKey(r9.getAvatarKey());
        r10.setUserName(m.b(r9, r2, true));
        r10.setUserId(r9.getId());
        r10.setRegistered(r9.getRegistered());
        ChatterDescription r11 = r9.getDescription();
        if (r11 == null) goto L36;
        r10.setDescription(r11.description);
        ChatterDescription.Type r12 = r11.type;
        int r15 = C0245a.a[r12.ordinal()];
        if (r15 != 1) goto L25;
        DetailUserInfo.DescriptionType r16 = DetailUserInfo.DescriptionType.DEFAULT;
    L35:
        r10.setDescType(r16);
        goto L36
    L25:
        if (r15 != 2) goto L27;
        r16 = DetailUserInfo.DescriptionType.BUSINESS;
        goto L35
    L27:
        if (r15 != 3) goto L29;
        r16 = DetailUserInfo.DescriptionType.LEAVE;
        goto L35
    L29:
        if (r15 == 4) goto L31;
        r16 = DetailUserInfo.DescriptionType.DEFAULT;
        goto L35
    L31:
        r16 = DetailUserInfo.DescriptionType.MEETING;
    L36:
        WorkStatus r17 = r9.getWorkStatus();
        if (WorkStatus.isInvalid(r17) == false) goto L39;
        r10.setWorkStatusDesc(BuildConfig.FLAVOR);
    L40:
        r5.add(r10);
        goto L16
    L39:
        r10.setWorkStatusDesc(r17.getDisplayTextNoDuration(UIHelper.getContext()));
        goto L40
    L41:
        r4.setTotalCount(r3.getReaction().getCount());
        r4.setUserInfoList(r5);
        r0.add(r4);
        goto L7
    L11:
        if ((r7 instanceof ArrayList) == true) goto L13;
        ArrayList r18 = new ArrayList(r7);
        r3.getReaction().setChatterIds(r18);
        r7 = r18;
    L13:
        r7.remove(r1);
        ListProtector.add(r7, 0, r1);
        goto L14
    L42:
        return r0;
    }

    public static List c(String r9, List r10) {
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(r10) == false) goto L5;
        return r0;
    L5:
        ArrayList r1 = new ArrayList(r10);
        Iterator r11 = r1.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        if (CollectionUtils.isEmpty(((ReactionInfo) r11.next()).getReaction().getChatterIds()) == false) goto L7;
        r11.remove();
        goto L7
    L12:
        if (CollectionUtils.isEmpty(r1) == false) goto L14;
        return r0;
    L14:
        Iterator r12 = r1.iterator();
    L16:
        if (r12.hasNext() == false) goto L40;
        ReactionInfo r2 = (ReactionInfo) r12.next();
        List<String> r3 = r2.getReaction().getChatterIds();
        Map<String, ChatChatter> r4 = r2.getReactionChatters();
        if (r3.contains(r9) == true) goto L20;
    L23:
        ArrayList r5 = new ArrayList();
        Iterator<String> r6 = r3.iterator();
    L25:
        if (r6.hasNext() == false) goto L31;
        String r7 = r6.next();
        ChatChatter r8 = r4.get(r7);
        if (r8 != null) goto L28;
        Log.i("reaction cannot find chatter: " + r7);
        goto L25
    L28:
        r5.add(r8);
        goto L25
    L31:
        if (r5.size() == 0) goto L16;
        ArrayList r13 = new ArrayList();
        ChatterNameDisplayRule r14 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Iterator r15 = r5.iterator();
    L35:
        if (r15.hasNext() == false) goto L39;
        Chatter r16 = (Chatter) r15.next();
        String r17 = m.b(r16, r14, true);
        if (TextUtils.isEmpty(r17) == true) goto L35;
        d r18 = new d();
        r18.a = r16.getId();
        r18.b = r17;
        r18.c = r16.getAvatarKey();
        r16.isAnonymous();
        r13.add(r18);
        goto L35
    L39:
        c r19 = new c();
        r19.a = r2.getReaction().getType();
        r19.b = Math.max(r2.getReaction().getCount(), r13.size());
        r19.c = r13;
        r0.add(r19);
        goto L16
    L20:
        if ((r3 instanceof ArrayList) == true) goto L22;
        ArrayList r20 = new ArrayList(r3);
        r2.getReaction().setChatterIds(r20);
        r3 = r20;
    L22:
        r3.remove(r9);
        ListProtector.add(r3, 0, r9);
        goto L23
    L40:
        return r0;
    }

    public static List<ReactionInfo> a(String r7, PushMessageReactions.Reactions r8, Entity r9) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r7) == true) goto L29;
        if (r8 == null) goto L29;
        if (r9 == null) goto L29;
        com.ss.android.lark.chat.entity.chatter.a r10 = b.d(r9, true);
        Iterator r11 = r8.reactions.iterator();
    L9:
        if (r11.hasNext() == false) goto L29;
        PushMessageReactions.Reactions.Reaction r1 = (PushMessageReactions.Reactions.Reaction) r11.next();
        if (r1 == null) goto L9;
        String r3 = r1.type;
        int r4 = r1.chatter_count.intValue();
        List r5 = r1.chatter_ids;
        if (r4 > 0) goto L21;
        if (r5 != null) goto L18;
    L20:
        r4 = 0;
        goto L21
    L18:
        if (r5.isEmpty() == true) goto L20;
        r4 = r5.size();
    L21:
        Reaction r2 = new Reaction(r3, r4, r1.chatter_ids);
        List<String> r6 = r2.getChatterIds();
        HashMap r12 = new HashMap();
        Iterator<String> r13 = r6.iterator();
    L23:
        if (r13.hasNext() == false) goto L28;
        String r14 = r13.next();
        ChatChatter r15 = r10.b(r7, r14);
        if (r15 != null) goto L26;
        Log.w("ReactionParser", "reactionChatter is null, chatId: " + r7 + ", reactionChatterId: " + r14);
        goto L23
    L26:
        r12.put(r15.getId(), r15);
        goto L23
    L28:
        r0.add(new ReactionInfo(r2, r12));
    L29:
        return r0;
    }
}

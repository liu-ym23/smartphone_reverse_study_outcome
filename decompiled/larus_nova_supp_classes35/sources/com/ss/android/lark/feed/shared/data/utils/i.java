package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.ChatTeamInfo;
import com.bytedance.lark.pb.basic.v1.Team;
import com.bytedance.lark.pb.feed.v1.ChatData;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((FeedTeamInfo) r1).orderWeight, ((FeedTeamInfo) r2).orderWeight);
        }
    }

    static {
    }

    @JvmStatic
    public static final List<FeedTeamInfo> a(ChatData r11) {
        List r0 = r11.joined_team_infos;
        if (r0 != null) goto L5;
        return null;
    L5:
        Map r12 = r11.joined_teams;
        if (r12 != null) goto L8;
        return null;
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L26;
        ChatTeamInfo r3 = (ChatTeamInfo) r1.next();
        Long r4 = r3.team_id;
        if (r4 != null) goto L14;
    L22:
        FeedTeamInfo r5 = null;
    L23:
        if (r5 == null) goto L10;
        r2.add(r5);
        goto L10
    L14:
        if (r3.team_chat_type == null) goto L22;
        Team r6 = (Team) r12.get(r4);
        if (r6 == null) goto L22;
        String r8 = r6.name;
        if (r8 == null) goto L22;
        long r7 = r3.team_id.longValue();
        TeamChatType.a r9 = TeamChatType.Companion;
        int r10 = r3.team_chat_type.getValue();
        r9.getClass();
        r5 = new FeedTeamInfo(r7, r8, TeamChatType.a.a(r10), r3.order_weight);
        goto L23
    L26:
        return CollectionsKt.sortedWith(r2, new a());
    }
}

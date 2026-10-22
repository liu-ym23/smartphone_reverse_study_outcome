package com.ss.android.lark.mention.base.impl.statistics;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MentionBoardHitPoint {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public MentionBoardHitPoint() {
    }

    public static String a(List r9, Function1 r10) {
        List r11 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r0.add(r10.invoke(r12.next()));
        goto L4
    L7:
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(r0), ",", null, null, 0, null, null, 62, null);
    }

    @JvmStatic
    public static final void b(boolean r4, List<? extends BaseAtBean> r5) {
        Intrinsics.checkNotNullParameter(r5, "entityList");
        if (CollectionUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (r4 == false) goto L8;
        String r6 = a(r5, MentionBoardHitPoint$sendIMMentionRefreshEvent$listType$1.INSTANCE);
        String r7 = a(r5, MentionBoardHitPoint$sendIMMentionRefreshEvent$entityType$1.INSTANCE);
        Statistics.sendEvent("im_mention_board_view", new JSONObject().put("mention_list_type", r6).put("entity_type", r7));
        return;
    L8:
        String r8 = a(r5, MentionBoardHitPoint$sendIMMentionRefreshEvent$listType$2.INSTANCE);
        String r9 = a(r5, MentionBoardHitPoint$sendIMMentionRefreshEvent$entityType$2.INSTANCE);
        Statistics.sendEvent("im_mention_board_view", new JSONObject().put("mention_list_type", r8).put("entity_type", r9));
    }
}

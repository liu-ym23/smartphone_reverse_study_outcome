package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.s;
import com.bytedance.android.live.broadcastgame.api.model.t;
import com.bytedance.android.live.broadcastgame.api.model.v;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"containId", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "id", "", "recentGroupType", "", "openFeatureCellMap", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class OpenFeatureListHandler$modifyRecentUsedList$1 extends Lambda implements Function3<String, Long, Map<String, InteractEntranceCell>, InteractEntranceCell> {
    public static final OpenFeatureListHandler$modifyRecentUsedList$1 INSTANCE = null;

    static {
        INSTANCE = new OpenFeatureListHandler$modifyRecentUsedList$1();
    }

    public OpenFeatureListHandler$modifyRecentUsedList$1() {
        super(3);
    }

    public final InteractEntranceCell invoke(String r24, long r25, Map<String, InteractEntranceCell> r27) {
        Intrinsics.checkNotNullParameter(r24, "id");
        Intrinsics.checkNotNullParameter(r27, "openFeatureCellMap");
        InteractEntranceCell r0 = r27.get(r24);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.groupType == r25) goto L11;
        int r4 = r0.interactType;
        String r5 = r0.title;
        String r6 = r0.desc;
        ImageModel r7 = r0.icon;
        List<String> r11 = r0.serverScenes;
        String r12 = r0.extra;
        List<v> r13 = r0.labels;
        k0 r14 = r0.rightButton;
        String r15 = r0.gameCardExtra;
        String r16 = r0.extendExtra;
        String r1 = r0.iconLabel;
        List<String> r2 = r0.selectKeys;
        String r8 = r0.titleLabel;
        List<t> r9 = r0.highlightLabel;
        List<s> r3 = r0.highlightDesc;
        String r17 = r0.highlightIcon;
        Intrinsics.checkNotNullParameter(r5, "title");
        return new InteractEntranceCell(r4, r5, r6, r7, r25, r11, r12, r13, r14, r15, r16, r1, r2, r8, r9, r3, r17);
    L11:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        return invoke((String) r3, ((Number) r4).longValue(), (Map) r5);
    }
}

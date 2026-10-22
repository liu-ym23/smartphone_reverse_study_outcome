package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "leftDiff", "", "rightDiff", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveOpenFeatureChooseListFragmentV3$processGroupListVisibleScroll$2 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ LiveOpenFeatureChooseListFragmentV3 this$0;

    public LiveOpenFeatureChooseListFragmentV3$processGroupListVisibleScroll$2(LiveOpenFeatureChooseListFragmentV3 r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(int r13, int r14) {
        if (r13 > 0) goto L5;
        r13 = 0;
    L5:
        AbsOpenFeaturePanelViewModel r0 = this.this$0.E;
        if (r0 == null) goto L51;
        LiveData<List<Object>> r1 = r0.getOpenFeatureGroupListData();
        if (r1 == null) goto L59;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L60;
    L11:
        if (r13 < 0) goto L61;
        if (r14 < r13) goto L62;
        if (r13 >= r2.size()) goto L63;
        String r5 = jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource();
        String r3 = "";
        Object r4 = null;
        if (TextUtils.equals(r5, "link_interact_panel_tab") == false) goto L19;
    L37:
        Object r6 = ListProtector.get(r2, r13);
        if ((r6 instanceof f10.f) == false) goto L41;
        r4 = r6;
    L41:
        f10.f r7 = (f10.f) r4;
        if (r7 == null) goto L50;
        int r8 = d20.a.a;
        com.bytedance.android.live.broadcastgame.api.model.r r9 = r7.D.e();
        if (r9 == null) goto L49;
        String r11 = r9.b();
        if (r11 == null) goto L49;
        r3 = r11;
    L49:
        InteractEntranceCell r12 = r7.D;
        String r15 = r12.title;
        InteractID.a r16 = InteractID.Companion;
        int r17 = r12.interactType;
        r16.getClass();
        InteractID r18 = InteractID.a.b(r17);
        InteractEntranceCell r19 = r7.D;
        d20.a.c(r3, r15, r18, r5, r19.groupType, r19.d, r19);
    L50:
        r13 = r13 + 1;
        goto L11
    L19:
        if (TextUtils.equals(r5, "link_setting_panel") == true) goto L37;
        if (TextUtils.equals(r5, "link_playmode_panel") == true) goto L37;
        Object r21 = ListProtector.get(r2, r13);
        if ((r21 instanceof f10.f) == false) goto L27;
        r4 = r21;
    L27:
        f10.f r22 = (f10.f) r4;
        if (r22 == null) goto L50;
        int r23 = d20.a.a;
        com.bytedance.android.live.broadcastgame.api.model.r r24 = r22.D.e();
        if (r24 == null) goto L35;
        String r25 = r24.b();
        if (r25 == null) goto L35;
        String r26 = r25;
    L36:
        InteractEntranceCell r27 = r22.D;
        String r28 = r27.title;
        InteractID.a r29 = InteractID.Companion;
        int r31 = r27.interactType;
        r29.getClass();
        InteractID r32 = InteractID.a.b(r31);
        InteractEntranceCell r110 = r22.D;
        d20.a.c(r26, r28, r32, "use_recently", r110.groupType, r110.d, r110);
    L35:
        r26 = "";
        goto L36
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}

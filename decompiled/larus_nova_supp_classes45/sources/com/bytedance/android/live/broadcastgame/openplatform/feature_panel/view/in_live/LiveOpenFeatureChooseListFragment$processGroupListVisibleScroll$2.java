package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.OpenFeatureRecentUsedListRecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "leftDiff", "", "rightDiff", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$2 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ LinearLayoutManager $lm;
    final /* synthetic */ LiveOpenFeatureChooseListFragment this$0;

    public LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$2(LiveOpenFeatureChooseListFragment r1, LinearLayoutManager r2) {
        this.this$0 = r1;
        this.$lm = r2;
        super(2);
    }

    public final void invoke(int r14, int r15) {
        if (r14 > 0) goto L5;
        r14 = 0;
    L5:
        AbsOpenFeaturePanelViewModel r0 = this.this$0.o;
        if (r0 == null) goto L77;
        LiveData<List<Object>> r1 = r0.getOpenFeatureGroupListData();
        if (r1 == null) goto L89;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L90;
    L11:
        if (r14 < 0) goto L91;
        if (r15 < r14) goto L92;
        if (r14 >= r2.size()) goto L93;
        String r5 = jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource();
        String r3 = "";
        Object r4 = null;
        if (TextUtils.equals(r5, "link_interact_panel_tab") == false) goto L19;
    L63:
        Object r6 = ListProtector.get(r2, r14);
        if ((r6 instanceof f10.f) == false) goto L67;
        r4 = r6;
    L67:
        f10.f r7 = (f10.f) r4;
        if (r7 == null) goto L76;
        int r8 = d20.a.a;
        com.bytedance.android.live.broadcastgame.api.model.r r9 = r7.D.e();
        if (r9 == null) goto L75;
        String r11 = r9.b();
        if (r11 == null) goto L75;
        r3 = r11;
    L75:
        InteractEntranceCell r12 = r7.D;
        String r13 = r12.title;
        InteractID.a r16 = InteractID.Companion;
        int r17 = r12.interactType;
        r16.getClass();
        InteractID r18 = InteractID.a.b(r17);
        InteractEntranceCell r19 = r7.D;
        d20.a.c(r3, r13, r18, r5, r19.groupType, r19.d, r19);
    L76:
        r14 = r14 + 1;
        goto L11
    L19:
        if (TextUtils.equals(r5, "link_setting_panel") == true) goto L63;
        if (TextUtils.equals(r5, "link_playmode_panel") == true) goto L63;
        Object r21 = ListProtector.get(r2, r14);
        if ((r21 instanceof f10.f) == true) goto L26;
        r21 = null;
    L26:
        f10.f r22 = (f10.f) r21;
        if (r22 == null) goto L36;
        int r23 = d20.a.a;
        com.bytedance.android.live.broadcastgame.api.model.r r24 = r22.D.e();
        if (r24 == null) goto L34;
        String r25 = r24.b();
        if (r25 == null) goto L34;
        String r26 = r25;
    L35:
        InteractEntranceCell r27 = r22.D;
        String r28 = r27.title;
        InteractID.a r29 = InteractID.Companion;
        int r31 = r27.interactType;
        r29.getClass();
        InteractID r32 = InteractID.a.b(r31);
        InteractEntranceCell r110 = r22.D;
        d20.a.c(r26, r28, r32, "use_recently", r110.groupType, r110.d, r110);
    L34:
        r26 = "";
    L36:
        Object r33 = ListProtector.get(r2, r14);
        if ((r33 instanceof f10.d) == true) goto L39;
        r33 = null;
    L39:
        f10.d r34 = (f10.d) r33;
        if (r34 == null) goto L76;
        Object r35 = this.$lm.findViewByPosition(r14);
        if ((r35 instanceof OpenFeatureRecentUsedListRecyclerView) == true) goto L44;
        r35 = null;
    L44:
        OpenFeatureRecentUsedListRecyclerView r36 = (OpenFeatureRecentUsedListRecyclerView) r35;
        if (r36 == null) goto L76;
        RecyclerView.LayoutManager r37 = r36.getLayoutManager();
        if ((r37 instanceof LinearLayoutManager) == false) goto L51;
        r4 = r37;
    L51:
        if (((LinearLayoutManager) r4) == null) goto L76;
        Iterator<T> r38 = r34.a.iterator();
    L54:
        if (r38.hasNext() == false) goto L76;
        f10.f r39 = (f10.f) r38.next();
        int r41 = d20.a.a;
        com.bytedance.android.live.broadcastgame.api.model.r r42 = r39.D.e();
        if (r42 == null) goto L61;
        String r43 = r42.b();
        if (r43 == null) goto L61;
        String r44 = r43;
    L62:
        InteractEntranceCell r45 = r39.D;
        String r46 = r45.title;
        InteractID.a r47 = InteractID.Companion;
        int r48 = r45.interactType;
        r47.getClass();
        InteractID r49 = InteractID.a.b(r48);
        InteractEntranceCell r111 = r39.D;
        d20.a.c(r44, r46, r49, "use_recently", r111.groupType, r111.d, r111);
    L61:
        r44 = "";
        goto L62
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}

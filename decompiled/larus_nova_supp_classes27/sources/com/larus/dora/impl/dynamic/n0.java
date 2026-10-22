package com.larus.dora.impl.dynamic;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.router.SmartRouter;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;
import com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget;
import com.larus.platform.model.NewcomerGuideItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n0 implements Function2<NewcomerGuideItem, String, Unit> {
    public final /* synthetic */ DoraDynamicFragment a;

    public n0(DoraDynamicFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r21, Object r22) {
        final NewcomerGuideItem r0 = (NewcomerGuideItem) r21;
        String r1 = (String) r22;
        Intrinsics.checkNotNullParameter(r0, "item");
        Intrinsics.checkNotNullParameter(r1, "text");
        final DoraDynamicFragment r3 = this.a;
        int r4 = DoraDynamicFragment.C;
        r3.getClass();
        String r5 = r0.getTitleKey();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        g49.d.d("DoraDynamicFragment", "handleGuideItemClick: id=" + r0.getId() + ", type=" + r0.getType() + ", titleKey=" + r5 + ", text=" + r1);
        DoraBuryPointManager r6 = DoraBuryPointManager.a;
        String r9 = r0.getId();
        String r10 = r0.getType();
        r6.getClass();
        g49.d.d(DoraBuryPointManager.b, "reportNewcomerGuideBannerClick: id=" + r9 + ", type=" + r10 + ", text=" + r1);
        Pair[] r7 = new Pair[3];
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        r7[0] = TuplesKt.to("item_id", r9);
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        r7[1] = TuplesKt.to("item_type", r10);
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        r7[2] = TuplesKt.to("guide_text", r1);
        r6.L("dora_guide_banner_click", MapsKt.mapOf(r7));
        String r2 = r0.getType();
        String r8 = null;
        if (r2 == null) goto L17;
        String r11 = r2.toLowerCase(Locale.ROOT);
    L19:
        if (Intrinsics.areEqual(r11, "query") == false) goto L41;
        List r12 = (List) r3.ba0().getNewcomerGuideConfigFlow().getValue();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        NewcomerGuideItem r15 = (NewcomerGuideItem) r14.next();
        r13.add(NewcomerGuideItem.copy$default(r15, null, null, null, null, null, Intrinsics.areEqual(r15.getId(), r0.getId()), 31, null));
        goto L22
    L24:
        r3.ba0().updateNewcomerGuideConfig(r13);
        LarusDoraPageDynamicListBinding r16 = r3.f;
        if (r16 == null) goto L33;
        NestedDynamicPageView r17 = r16.c;
        if (r17 == null) goto L33;
        NewcomerGuideWidget r18 = r17.getNewcomerGuideWidget();
        if (r18 == null) goto L33;
        Job r20 = r18.b;
        if (r20 == null) goto L33;
        Job.DefaultImpls.cancel$default(r20, null, 1, null);
    L33:
        r3.y = true;
        IDoraAVLinkService r23 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r23 == null) goto L36;
        r23.x(r5);
    L36:
        LarusDoraPageDynamicListBinding r24 = r3.f;
        if (r24 == null) goto L58;
        ConstraintLayout r25 = r24.a;
        if (r25 == null) goto L58;
        r25.postDelayed(new d0(r3, r0), 10000);
    L58:
        return Unit.INSTANCE;
    L41:
        String r26 = r0.getType();
        if (r26 == null) goto L45;
        r8 = r26.toLowerCase(Locale.ROOT);
    L45:
        if (Intrinsics.areEqual(r8, "switch") == false) goto L58;
        String r27 = r0.getActionValue();
        if (com.larus.utils.o0.d(r27) == false) goto L49;
        SmartRouter.buildRoute(r3.getContext(), r27).d();
    L49:
        r3.y = true;
        IDoraAVLinkService r28 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r28 == null) goto L52;
        r28.x(r5);
    L52:
        LarusDoraPageDynamicListBinding r30 = r3.f;
        if (r30 == null) goto L58;
        ConstraintLayout r31 = r30.a;
        if (r31 == null) goto L58;
        r31.postDelayed(new e0(r3), 10000);
        goto L58
    L17:
        r11 = null;
        goto L19
    }
}

package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.viewholder.InputSubButtonViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<a, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public a c;
    public View d;

    public final class a extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final int c;
        public final int d;
        public final int e;
        public final RecyclerView f;
        public String g;
        public final MultiTypeAdapter h;
        public final GridLayoutManager i;
        public final MoreSectionProvider$MorePanelController$itemDecoration$1 j;
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b k;

        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.interactivity.comment.newinput.provider.MoreSectionProvider$MorePanelController$itemDecoration$1] */
        public a(View r4, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r6) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "panelBridges");
            Intrinsics.checkNotNullParameter(r6, "manager");
            super(r4, r5);
            this.k = r6;
            this.c = 4;
            this.d = UtilityKotlinExtentionsKt.i(12);
            int r7 = UtilityKotlinExtentionsKt.i(72);
            int r0 = UtilityKotlinExtentionsKt.i(16);
            this.e = (((com.bytedance.android.live.core.utils.s1.y() - (r0 * 2)) - (r7 * 4)) / 3) / 4;
            this.f = r4.findViewById(2131373380);
            this.g = BuildConfig.FLAVOR;
            MultiTypeAdapter r8 = new MultiTypeAdapter();
            r8.z2(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a.class, new InputSubButtonViewBinder(new MoreSectionProvider$MorePanelController$buttonAdapter$1$1(this)));
            Unit r1 = Unit.INSTANCE;
            this.h = r8;
            this.i = new GridLayoutManager(r4.getContext(), 4, 1, false);
            this.j = new MoreSectionProvider$MorePanelController$itemDecoration$1(this);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.d;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.b;
        if (r3 == null) goto L12;
        int r4 = r3.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r4);
        goto L14
    L12:
        r4 = 0;
        goto L13
    L7:
        if (r2.W() != 0) goto L9;
        int r5 = InputPanelSectionContainer.m;
        r4 = InputPanelSectionContainer.m;
    L14:
        a r1 = this.c;
        if (r1 == null) goto L21;
        MultiTypeAdapter r6 = r1.h;
        Map<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r7 = r1.k.c;
        ArrayList r8 = new ArrayList(r7.size());
        Iterator r9 = ((LinkedHashMap) r7).entrySet().iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        r8.add((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r9.next()).getValue());
        goto L18
    L20:
        r6.a = r8;
        r1.h.notifyDataSetChanged();
    L21:
        a r10 = this.c;
        if (r10 == null) goto L29;
        HashMap r11 = new HashMap();
        r11.put("show_icon", r10.g.toString());
        r11.put("screen_type", "portrait");
        IInteractivityInjectService r13 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r13 == null) goto L26;
        r13.buildVsRoomLog(null, r11);
    L26:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_comment_expansion_module_show", r11, new Object[]{IRoom.class, am2.x.class});
        return;
    }

    public c1() {
        this.a = InputSectionType.MORE;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelBridge");
        Activity r0 = r9.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r9;
        View r1 = LayoutInflater.from(r0).inflate(2131566074, null);
        this.d = r1;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r2 = r9.z();
        if (r2 == null) goto L22;
        a r3 = new a(r1, r9, r2);
        r3.f.addItemDecoration(r3.j);
        r3.f.setLayoutManager(r3.i);
        r3.f.setAdapter(r3.h);
        Context r10 = r3.b.getContext();
        if (r10 == null) goto L21;
        fc2.d r4 = com.bytedance.android.livesdk.interactivity.comment.newinput.b.a;
        if (r4.a() == false) goto L16;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r5 = r3.b.z();
        if (r5 == null) goto L14;
        a72.a r6 = new a72.a(InputFunctionEnum.ChatInputCarrier_Interest, r10, InputSectionType.INTEREST);
        r6.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(4150));
        Unit r7 = Unit.INSTANCE;
        r5.d(r6);
    L14:
        r3.g = r3.g + InputFunctionEnum.ChatInputCarrier_Interest.getLogValue();
    L16:
        if (r4.b() == false) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b r8 = r3.b.z();
        if (r8 == null) goto L20;
        a72.b r11 = new a72.b(InputFunctionEnum.ChatInputCarrier_Truth, r10, InputSectionType.TRUTH);
        r11.a(new com.bytedance.android.livesdk.interactivity.comment.newinput.framework.h(4150));
        Unit r13 = Unit.INSTANCE;
        r8.d(r11);
    L20:
        r3.g = r3.g + '|' + InputFunctionEnum.ChatInputCarrier_Truth.getLogValue();
    L21:
        Unit r14 = Unit.INSTANCE;
        this.c = r3;
    L22:
        return r1;
    }
}

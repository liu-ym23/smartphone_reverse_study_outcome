package com.larus.canvas.feature.component.logic;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.canvas.feature.component.logic.provider.CanvasGallerySidebarItemType;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j2 implements com.larus.canvas.feature.component.logic.provider.c0 {
    public final /* synthetic */ GenImageUIActionReceiverComponent a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CanvasGallerySidebarItemType.values().length];
            r0[CanvasGallerySidebarItemType.EXPAND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[CanvasGallerySidebarItemType.ERASE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[CanvasGallerySidebarItemType.SHARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[CanvasGallerySidebarItemType.TO_VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[CanvasGallerySidebarItemType.EDIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[CanvasGallerySidebarItemType.SHAREPNESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public j2(GenImageUIActionReceiverComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.canvas.feature.component.logic.provider.c0
    public final void a(ky8.a r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (((BaseComponentFeatureInternal) this.a).a.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L5;
        return;
    L5:
        String r7 = r6.a;
        GenImageUIActionReceiverComponent r0 = this.a;
        int r1 = GenImageUIActionReceiverComponent.y;
        com.larus.canvas.feature.component.resultdisplay.image.r r2 = r0.D3();
        int r3 = -1;
        if (r2 == null) goto L22;
        kotlinx.coroutines.flow.i1<com.larus.canvas.feature.component.resultdisplay.image.u> r4 = r2.lb();
        if (r4 == null) goto L22;
        com.larus.canvas.feature.component.resultdisplay.image.u r5 = (com.larus.canvas.feature.component.resultdisplay.image.u) r4.getValue();
        if (r5 == null) goto L22;
        List<com.larus.canvas.feature.component.resultdisplay.image.y> r8 = r5.a;
        if (r8 == null) goto L22;
        Iterator<com.larus.canvas.feature.component.resultdisplay.image.y> r9 = r8.iterator();
        int r10 = 0;
    L15:
        if (r9.hasNext() == false) goto L20;
        if (Intrinsics.areEqual(r9.next().a, r7) == true) goto L21;
        r10 = r10 + 1;
    L21:
        Integer r11 = Integer.valueOf(r10);
    L23:
        if (r11 == null) goto L25;
        r3 = r11.intValue();
    L25:
        if (r3 < 0) goto L36;
        com.larus.canvas.feature.component.resultdisplay.image.r r12 = this.a.D3();
        if (r12 != null) goto L29;
        return;
    L29:
        if (r11 == null) goto L31;
        int r13 = r11.intValue();
    L32:
        r12.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(r13, false));
        return;
    L31:
        r13 = 0;
        goto L32
    L36:
        return;
    L20:
        r10 = -1;
    L22:
        r11 = null;
        goto L23
    }

    @Override // com.larus.canvas.feature.component.logic.provider.c0
    public final void b(CanvasGallerySidebarItemType r60, ky8.a r61) {
        Intrinsics.checkNotNullParameter(r60, "itemType");
        if (((BaseComponentFeatureInternal) this.a).a.getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L5;
        return;
    L5:
        String r4 = null;
        switch(a.a[r60.ordinal()]) {
            case 1: goto L93;
            case 2: goto L89;
            case 3: goto L86;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        GenImageUIActionReceiverComponent r1 = this.a;
        int r2 = GenImageUIActionReceiverComponent.y;
        r1.h3();
        n2 r3 = this.a.B3();
        if (r3 == null) goto L107;
        r3.Xu(1);
        return;
    L107:
        return;
    L12:
        GenImageUIActionReceiverComponent r5 = this.a;
        int r6 = GenImageUIActionReceiverComponent.y;
        r5.h3();
        return;
    L13:
        GenImageUIActionReceiverComponent r7 = this.a;
        int r8 = GenImageUIActionReceiverComponent.y;
        r7.getClass();
        if (r61 == null) goto L117;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        FragmentActivity r9 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getActivity();
        if (r9 == null) goto L118;
        com.larus.bmhome.chat.api.e0 r10 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r10 == null) goto L24;
        LaunchInfo r11 = r10.a;
        if (r11 == null) goto L24;
        String r12 = r11.W();
    L25:
        List r13 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r12);
        if (r13 == null) goto L44;
        Iterator r14 = r13.iterator();
    L29:
        if (r14.hasNext() == false) goto L41;
        Object r15 = r14.next();
        com.larus.bmhome.actionbar.model.r r16 = ((com.larus.bmhome.actionbar.model.z0) r15).q;
        if (r16 == null) goto L38;
        Integer r17 = r16.a;
        if (r17 == null) goto L38;
        if (r17.intValue() != 24) goto L38;
        boolean r18 = true;
    L39:
        if (r18 == false) goto L29;
    L42:
        com.larus.bmhome.actionbar.model.z0 r19 = (com.larus.bmhome.actionbar.model.z0) r15;
        if (r19 == null) goto L44;
    L62:
        if (r19 == null) goto L110;
        com.larus.bmhome.actionbar.model.r r20 = r19.q;
        if (r20 == null) goto L66;
        boolean r21 = Intrinsics.areEqual(r20.h, Boolean.TRUE);
    L67:
        if (r21 == true) goto L69;
        return;
    L69:
        if (((CanvasHostUiPolicy) r7.u.getValue()).a == false) goto L71;
        r7.h3();
    L71:
        IUgcAIGCService.Companion r22 = IUgcAIGCService.a;
        AuthModelDelegate r23 = AuthModelDelegate.b;
        wc9.e r110 = (wc9.e) r23.y().getValue();
        if (r110 == null) goto L74;
        String r111 = r110.a;
    L75:
        if (r111 != null) goto L77;
        r111 = "";
    L77:
        String r112 = r111;
        com.larus.bmhome.chat.api.e0 r24 = (com.larus.bmhome.chat.api.e0) r23.e().getValue();
        if (r24 == null) goto L82;
        LaunchInfo r25 = r24.a;
        if (r25 == null) goto L82;
        r4 = r25.W();
    L82:
        ChatParam r30 = new ChatParam(r112, r4, null, null, null, 252);
        String r113 = r61.g;
        Bundle r26 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        if (((CanvasHostUiPolicy) r7.u.getValue()).a == false) goto L85;
        r26.putBoolean("retain_ai_creation_home_memory", true);
    L85:
        r22.W(new ny9.b(false, r9, r19, r30, true, false, null, null, r113, null, null, null, null, null, null, null, null, null, null, false, false, new m2(r7), null, r26, false, null, null, null, false, null, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1084227871, 262143));
        return;
    L74:
        r111 = null;
        goto L75
    L66:
        r21 = false;
        goto L67
    L110:
        return;
    L38:
        r18 = false;
        goto L39
    L41:
        r15 = null;
    L44:
        if (r13 == null) goto L61;
        Iterator r27 = r13.iterator();
    L47:
        if (r27.hasNext() == false) goto L59;
        Object r28 = r27.next();
        com.larus.bmhome.actionbar.model.r r29 = ((com.larus.bmhome.actionbar.model.z0) r28).q;
        if (r29 == null) goto L56;
        Integer r31 = r29.a;
        if (r31 == null) goto L56;
        if (r31.intValue() != 18) goto L56;
        boolean r32 = true;
    L57:
        if (r32 == false) goto L47;
    L60:
        r19 = (com.larus.bmhome.actionbar.model.z0) r28;
    L56:
        r32 = false;
        goto L57
    L59:
        r28 = null;
        goto L60
    L61:
        r19 = null;
    L24:
        r12 = null;
        goto L25
    L118:
        return;
    L117:
        return;
    L86:
        GenImageUIActionReceiverComponent r33 = this.a;
        int r34 = GenImageUIActionReceiverComponent.y;
        o2 r35 = (o2) r33.r.getValue();
        if (r35 == null) goto L113;
        r35.OX("detail_click", "detail_click", "picture_detail");
        return;
    L113:
        return;
    L89:
        GenImageUIActionReceiverComponent r36 = this.a;
        int r37 = GenImageUIActionReceiverComponent.y;
        n2 r38 = r36.B3();
        if (r38 == null) goto L92;
        r38.Xu(3);
    L92:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new GenImageUIActionReceiverComponent$createSidebarCallback$1$onClickSidebarItem$1(this.a, null), 3, null);
        return;
    L93:
        GenImageUIActionReceiverComponent r39 = this.a;
        int r40 = GenImageUIActionReceiverComponent.y;
        r39.h3();
        n2 r41 = this.a.B3();
        if (r41 == null) goto L116;
        r41.Xu(2);
        return;
    L116:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}

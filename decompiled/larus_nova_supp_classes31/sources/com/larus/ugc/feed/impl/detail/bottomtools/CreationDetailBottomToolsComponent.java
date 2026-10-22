package com.larus.ugc.feed.impl.detail.bottomtools;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.s3$a;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.profile.api.ICreationService;
import com.larus.ugc.feed.api.model.CreationFeedTrackParamsKmp;
import com.larus.ugc.feed.impl.detail.ability.CreationDetailBottomToolsAbilityImpl;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import sq9.d0;
import sq9.p;
import sq9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\"H\u0002J*\u0010.\u001a\u00020\"2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010,2\b\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u00100\u001a\u0004\u0018\u00010,H\u0002J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/ugc/feed/api/detail/ability/IDetailBottomToolsViewAbility;", "initParams", "Lcom/larus/ugc/feed/api/detail/model/CreationDetailBottomToolsInitParamsKmp;", "<init>", "(Lcom/larus/ugc/feed/api/detail/model/CreationDetailBottomToolsInitParamsKmp;)V", "abilityBinding", "Lcom/larus/ugc/feed/impl/detail/ability/CreationDetailBottomToolsAndroidAbilityBinding;", "getAbilityBinding", "()Lcom/larus/ugc/feed/impl/detail/ability/CreationDetailBottomToolsAndroidAbilityBinding;", "abilityBinding$delegate", "Lkotlin/Lazy;", "ability", "Lcom/larus/ugc/feed/api/detail/ability/IKMPCreationDetailBottomToolsAbility;", "getAbility", "()Lcom/larus/ugc/feed/api/detail/ability/IKMPCreationDetailBottomToolsAbility;", "doSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "commentAbility", "Lcom/story/ai/biz/comment/api/CommentComponentAPIAbility;", "getCommentAbility", "()Lcom/story/ai/biz/comment/api/CommentComponentAPIAbility;", "commentAbility$delegate", "v1", "Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsView;", "getV1", "()Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsView;", "v2", "Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsViewV2;", "getV2", "()Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsViewV2;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "initObserver", "handleLikeAction", "doubleTap", "", "handleDoSameAction", "enterFrom", "", "onClickComment", "goToDoSame", "fileLocalPath", "quickMenuItemType", "showToolsView", "hideToolsView", "isToolsViewVisible", "updateCommentCount", "count", "", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationDetailBottomToolsComponent extends BaseContentWidget implements h0a.a {
    public static final /* synthetic */ int q = 0;
    public final i0a.a m;
    public final Lazy n;
    public t o;
    public final Lazy p;

    public final CreationDetailBottomToolsAbilityImpl Y2() {
        return ((com.larus.ugc.feed.impl.detail.ability.d) this.n.getValue()).a;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, h0a.a.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), Y2(), h0a.b.class);
        CreationDetailBottomToolsAbilityImpl r1 = Y2();
        i0a.a r2 = this.m;
        r1.b(r2.c, r2.d);
        ICreationService.Companion r3 = ICreationService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.o = r3.d(com.larus.ui.arch.component.internal.attach.a.b(this, this), false);
    }

    public CreationDetailBottomToolsComponent(i0a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initParams");
        this.m = r2;
        this.n = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
    }

    public final void Mt(boolean r15) {
        CreationDetailBottomToolsAbilityImpl r16 = Y2();
        i0a.a r0 = r16.d;
        if (r0 == null) goto L5;
        CreationFeedTrackParamsKmp r1 = r0.a;
    L6:
        k0a.a r2 = r16.b.a();
        l0a.a r17 = r16.c;
        boolean r4 = r2.b;
        UserCreation r5 = r2.e;
        if (r1 == null) goto L9;
        String r6 = r1.getBotId();
    L10:
        if (r1 == null) goto L12;
        String r7 = r1.getAiCreationRecommendFrom();
    L13:
        if (r1 == null) goto L15;
        String r8 = r1.getCurrentPage();
    L16:
        if (r1 == null) goto L18;
        String r9 = r1.getPreviousPage();
    L19:
        if (r1 == null) goto L21;
        String r10 = r1.getChatType();
    L22:
        if (r1 == null) goto L24;
        String r11 = r1.getConversationId();
    L25:
        if (r1 == null) goto L27;
        String r12 = r1.getEnterMethod();
    L28:
        r17.b(new l0a.d(r4, r5, r6, r7, r8, r9, r10, r11, r12));
        if (i3.a.f() == false) goto L31;
    L35:
        s3$a.a(null, 3);
        return;
    L31:
        if (AccountService.a.isLogin().booleanValue() == false) goto L35;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new CreationDetailBottomToolsComponent$handleLikeAction$1(this, null), 3, null);
        return;
    L27:
        r12 = null;
        goto L28
    L24:
        r11 = null;
        goto L25
    L21:
        r10 = null;
        goto L22
    L18:
        r9 = null;
        goto L19
    L15:
        r8 = null;
        goto L16
    L12:
        r7 = null;
        goto L13
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void Sj(String r51) {
        CreationDetailBottomToolsAbilityImpl r1 = Y2();
        i0a.a r2 = r1.d;
        if (r2 == null) goto L5;
        CreationFeedTrackParamsKmp r3 = r2.a;
    L6:
        k0a.a r4 = r1.b.a();
        l0a.a r5 = r1.c;
        UserCreation r7 = r4.e;
        boolean r8 = Intrinsics.areEqual(null, "template_detail_caption");
        i0a.a r6 = r1.d;
        if (r6 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        if (r3 == null) goto L14;
        String r10 = r3.getBotId();
    L15:
        if (r3 == null) goto L17;
        String r11 = r3.getAiCreationRecommendFrom();
    L18:
        if (r3 == null) goto L20;
        String r12 = r3.getCurrentPage();
    L21:
        if (r3 == null) goto L23;
        String r13 = r3.getPreviousPage();
    L24:
        if (r3 == null) goto L26;
        String r14 = r3.getChatType();
    L27:
        if (r3 == null) goto L29;
        String r15 = r3.getConversationId();
    L30:
        if (r3 == null) goto L32;
        Integer r16 = r3.getActionBarTemplateId();
    L33:
        if (r3 == null) goto L35;
        String r17 = r3.getEnterMethod();
    L36:
        if (r3 == null) goto L38;
        String r18 = r3.getPromptType();
    L39:
        if (r3 == null) goto L41;
        String r19 = r3.getPromptFrom();
    L42:
        if (r3 == null) goto L44;
        String r20 = r3.getVisualSize();
    L45:
        if (r3 == null) goto L47;
        String r21 = r3.getAnchorCreationId();
    L48:
        if (r3 == null) goto L50;
        String r22 = r3.getDouyinGid();
    L51:
        r5.c(new l0a.c(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22));
        CreationFeedTrackParamsKmp r23 = this.m.a;
        t r24 = this.o;
        if (r24 == null) goto L55;
        String r25 = r23.getCurrentPage();
        String r26 = r23.getEnterMethod();
        UserCreation r27 = ((k0a.a) Y2().b.a.getValue()).e;
        String r28 = r23.getRecommendFrom();
        String r30 = r23.getAiCreationRecommendFrom();
        String r31 = r23.getBotId();
        String r32 = r23.getConversationId();
        Boolean r33 = r23.isChatDoublePage();
        i0a.a r29 = this.m;
        boolean r34 = r29.e;
        boolean r35 = r29.b;
        String r37 = r23.getTemplatePageType();
        i0a.a r36 = this.m;
        String r38 = r36.h;
        String r39 = r36.i;
        String r40 = r36.j;
        String r41 = r36.k;
        d0 r42 = new d0(r23.getPromptType(), r23.getPromptFrom(), r23.getVisualSize(), r23.getTagCode(), r23.getWcbItemId(), r23.getRecoRequestId());
        String r45 = r23.getAnchorCreationId();
        String r46 = r23.getDouyinGid();
        i0a.a r43 = this.m;
        r24.a(new p(null, r25, r26, r27, r28, null, r30, r31, r32, r33, r34, null, r35, r37, r38, r39, r40, r41, r42, null, null, r45, r46, r43.f, Boolean.valueOf(r43.g), 1572864), null);
        return;
    L55:
        return;
    L50:
        r22 = null;
        goto L51
    L47:
        r21 = null;
        goto L48
    L44:
        r20 = null;
        goto L45
    L41:
        r19 = null;
        goto L42
    L38:
        r18 = null;
        goto L39
    L35:
        r17 = null;
        goto L36
    L32:
        r16 = null;
        goto L33
    L29:
        r15 = null;
        goto L30
    L26:
        r14 = null;
        goto L27
    L23:
        r13 = null;
        goto L24
    L20:
        r12 = null;
        goto L21
    L17:
        r11 = null;
        goto L18
    L14:
        r10 = null;
        goto L15
    L9:
        if (r6.b != true) goto L11;
        r9 = true;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.ugc.feed.impl.detail.bottomtools.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.larus.ugc.feed.impl.detail.bottomtools.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.ugc.feed.impl.detail.bottomtools.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.ugc.feed.impl.detail.bottomtools.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.ugc.feed.impl.detail.bottomtools.c] */
    public final void onViewCreated(View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        View r14 = F2();
        if (r14 == null) goto L5;
        CreationDetailBottomToolsViewV2 r15 = (CreationDetailBottomToolsViewV2) r14.findViewById(2131364546);
    L6:
        int r1 = 2131242262;
        if (r15 == null) goto L37;
        final ?? r7 = new a(this);
        final ?? r8 = new b(this);
        final ?? r9 = new c(this);
        Intrinsics.checkNotNullParameter(r7, "likeAction");
        Intrinsics.checkNotNullParameter(r8, "makeSameAction");
        e1.d(r15.a.f, new k(r7));
        e1.d(r15.a.b, new l(r9));
        e1.d(r15.a.c, new m(r8));
        i0a.a r10 = this.m;
        UserCreation r11 = r10.c;
        if (r10.b == true) goto L24;
        if (r11 == null) goto L14;
        CreationDynamicInfo r12 = r11.h;
        if (r12 == null) goto L14;
        String r16 = r12.c;
    L16:
        if (o0.d(r16) == false) goto L24;
        TextView r17 = r15.a.h;
        if (r11 == null) goto L22;
        CreationDynamicInfo r18 = r11.h;
        if (r18 == null) goto L22;
        String r19 = r18.c;
    L23:
        r17.setText(r19);
    L25:
        if (r11 == null) goto L31;
        CreationDynamicInfo r20 = r11.h;
        if (r20 == null) goto L31;
        TplInfo r21 = r20.e;
        if (r21 == null) goto L31;
        String r22 = r21.a;
    L33:
        if (Intrinsics.areEqual(r22, TplType.AI_REPLICA) == false) goto L35;
        int r23 = 2131242260;
    L36:
        r15.a.e.setImageResource(r23);
        goto L37
    L35:
        r23 = 2131242262;
    L31:
        r22 = null;
    L22:
        r19 = null;
    L14:
        r16 = null;
    L24:
        r15.a.h.setText(2131901659);
    L37:
        View r110 = F2();
        if (r110 == null) goto L40;
        CreationDetailBottomToolsView r111 = (CreationDetailBottomToolsView) r110.findViewById(2131364545);
    L41:
        if (r111 == null) goto L70;
        final ?? r24 = new d(this);
        final ?? r25 = new e(this);
        Intrinsics.checkNotNullParameter(r24, "likeAction");
        Intrinsics.checkNotNullParameter(r25, "makeSameAction");
        e1.d(r111.a.b, new h(r24));
        e1.d(r111.a.c, new i(r25));
        i0a.a r5 = this.m;
        UserCreation r6 = r5.c;
        if (r5.b == true) goto L58;
        if (r6 == null) goto L48;
        CreationDynamicInfo r26 = r6.h;
        if (r26 == null) goto L48;
        String r27 = r26.c;
    L50:
        if (o0.d(r27) == false) goto L58;
        TextView r4 = r111.a.g;
        if (r6 == null) goto L56;
        CreationDynamicInfo r28 = r6.h;
        if (r28 == null) goto L56;
        String r29 = r28.c;
    L57:
        r4.setText(r29);
    L59:
        if (r6 == null) goto L65;
        CreationDynamicInfo r30 = r6.h;
        if (r30 == null) goto L65;
        TplInfo r31 = r30.e;
        if (r31 == null) goto L65;
        String r32 = r31.a;
    L67:
        if (Intrinsics.areEqual(r32, TplType.AI_REPLICA) == false) goto L69;
        r1 = 2131242260;
    L69:
        r111.a.e.setImageResource(r1);
    L65:
        r32 = null;
    L56:
        r29 = null;
    L48:
        r27 = null;
    L58:
        r111.a.g.setText(2131901659);
    L70:
        View r112 = F2();
        if (r112 == null) goto L73;
        e1.x(r112);
    L73:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new CreationDetailBottomToolsComponent$initObserver$1(this, null), 3, null);
        return;
    L40:
        r111 = null;
        goto L41
    L5:
        r15 = null;
        goto L6
    }
}

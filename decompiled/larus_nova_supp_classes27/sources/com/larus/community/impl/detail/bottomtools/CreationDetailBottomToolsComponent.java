package com.larus.community.impl.detail.bottomtools;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.larus.bmhome.actionbar.model.j1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.detail.c0;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import sq9.d0;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020;H\u0002J\u0010\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u0007H\u0016J\b\u0010C\u001a\u00020\u0007H\u0002J\u0012\u0010D\u001a\u00020;2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J*\u0010G\u001a\u00020;2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010F2\b\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0003\u0010I\u001a\u0004\u0018\u00010FH\u0002J\b\u0010J\u001a\u00020\u0007H\u0002J\u000f\u0010K\u001a\u0004\u0018\u00010LH\u0002¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020P0OH\u0016J\b\u0010Q\u001a\u00020;H\u0016J\b\u0010R\u001a\u00020;H\u0016J\b\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020VH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001f\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b1\u00102R\u0010\u00104\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006W"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "<init>", "()V", "isV2", "", "viewModel", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsViewModel;", "getViewModel", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationTrackParams", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "getCreationTrackParams", "()Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "instructionConfExt", "Lcom/larus/community/impl/detail/model/InstructionConfExtWrap;", "getInstructionConfExt", "()Lcom/larus/community/impl/detail/model/InstructionConfExtWrap;", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "Lkotlin/Lazy;", "commentAbility", "Lcom/story/ai/biz/comment/api/CommentComponentAPIAbility;", "getCommentAbility", "()Lcom/story/ai/biz/comment/api/CommentComponentAPIAbility;", "commentAbility$delegate", "creationDetailFragmentAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailFragmentAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailFragmentAbility$delegate", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "getCreationDetailVideoAbility", "()Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "creationDetailVideoAbility$delegate", "remoteUserCreation", "doSameAbility", "Lcom/larus/platform/model/creation/ICreationDoSameAbility;", "ignoreTplInfo", "isFromAnchor", "()Z", "onAttach", "", "checkIgnoreTplInfo", "initObserver", "onViewCreated", "view", "Landroid/view/View;", "handleLikeAction", "doubleTap", "shouldShowHostBottomShareAction", "handleDoSameAction", "enterFrom", "", "goToDoSame", "fileLocalPath", "quickMenuItemType", "getHostAwareOpenNewChatPageOnSend", "getHostAwareDoSameLandingType", "", "()Ljava/lang/Integer;", "getCreationLikeState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "showToolsView", "hideToolsView", "isToolsViewVisible", "updateCommentCount", "count", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsComponent extends BaseContentWidget implements com.larus.community.impl.detail.bottomtools.a {
    public static final /* synthetic */ int v = 0;
    public final com.larus.ui.arch.vm.internal.l m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public UserCreation s;
    public sq9.t t;
    public boolean u;

    public static final class a implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public a(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class b implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public b(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class c implements Function0<ViewModelProvider.Factory> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final void Cr() {
        FLogger.a.i("CreationDetailBottomToolsComponent", "showToolsView");
        e1.x(F2());
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final void Hp() {
        FLogger.a.i("CreationDetailBottomToolsComponent", "hideToolsView");
        e1.o(F2());
    }

    public final CreationDetailBottomToolsViewModel p3() {
        return (CreationDetailBottomToolsViewModel) this.m.getValue();
    }

    public CreationDetailBottomToolsComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CreationDetailBottomToolsViewModel.class), Reflection.getOrCreateKotlinClass(CreationLikeState.class), new a(this), new b(this), c.a);
        this.n = LazyKt.lazy(new n(this));
        this.o = LazyKt.lazy(new o(this));
        this.p = LazyKt.lazy(new com.larus.community.impl.detail.bottomtools.c(this));
        this.q = LazyKt.lazy(new d(this));
        this.r = LazyKt.lazy(new e(this));
    }

    public final j29.a Y2() {
        return (j29.a) s1a.d.a(this).a(j29.a.class);
    }

    public final j29.b h3() {
        return (j29.b) s1a.d.a(this).a(j29.b.class);
    }

    public final UserCreation m3() {
        j29.c r0 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r0 == null) goto L7;
        UserCreation r1 = r0.a;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.s;
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final i1<CreationLikeState> qd() {
        return p3().getStateFlow();
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final boolean sO() {
        if (F2().getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void y2() {
        if (m3() == null) goto L11;
        CreationDetailBottomToolsViewModel r0 = p3();
        UserCreation r1 = m3();
        j29.a r2 = Y2();
        if (r2 == null) goto L9;
        zp9.g r3 = r2.a;
        if (r3 == null) goto L9;
        boolean r4 = Intrinsics.areEqual(r3.p, Boolean.TRUE);
    L10:
        r0.init(r1, true, r4);
    L9:
        r4 = false;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.community.impl.detail.bottomtools.a.class);
        m3 r5 = m3.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.t = r5.q(com.larus.ui.arch.component.internal.attach.a.b(this, this));
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final void Mt(boolean r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailBottomToolsComponent$handleLikeAction$1(this, r7, null), 3, null);
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final void Sj(final String r44) {
        if (z2.a.m() == true) goto L5;
        return;
    L5:
        com.larus.community.impl.detail.video.a r2 = (com.larus.community.impl.detail.video.a) this.r.getValue();
        if (r2 == null) goto L8;
        r2.Zz();
    L8:
        j29.a r3 = Y2();
        if (r3 == null) goto L13;
        zp9.g r4 = r3.a;
        if (r4 == null) goto L13;
        String r5 = r4.c;
    L14:
        j29.a r6 = Y2();
        if (r6 == null) goto L19;
        zp9.g r7 = r6.a;
        if (r7 == null) goto L19;
        String r110 = r7.j;
    L20:
        j29.a r8 = Y2();
        if (r8 == null) goto L25;
        zp9.g r9 = r8.a;
        if (r9 == null) goto L25;
        String r20 = r9.a;
    L26:
        j29.a r10 = Y2();
        if (r10 == null) goto L31;
        zp9.g r11 = r10.a;
        if (r11 == null) goto L31;
        String r21 = r11.h;
    L32:
        j29.a r12 = Y2();
        if (r12 == null) goto L37;
        zp9.g r13 = r12.a;
        if (r13 == null) goto L37;
        String r14 = r13.f;
    L38:
        j29.a r15 = Y2();
        if (r15 == null) goto L43;
        zp9.g r16 = r15.a;
        if (r16 == null) goto L43;
        String r23 = r16.d;
    L44:
        j29.a r17 = Y2();
        if (r17 == null) goto L49;
        zp9.g r18 = r17.a;
        if (r18 == null) goto L49;
        Integer r111 = r18.e;
    L50:
        UserCreation r22 = m3();
        if (r22 == null) goto L53;
        String r24 = r22.a;
    L54:
        UserCreation r25 = m3();
        if (r25 == null) goto L57;
        String r26 = zp9.d.d(r25);
    L58:
        UserCreation r27 = m3();
        if (r27 == null) goto L61;
        String r28 = zp9.d.c(r27);
    L62:
        UserCreation r30 = m3();
        if (r30 == null) goto L67;
        UserCreationTrackParams r31 = r30.n;
        if (r31 == null) goto L67;
        String r112 = r31.a;
    L68:
        UserCreation r32 = m3();
        if (r32 == null) goto L71;
        String r113 = zp9.d.b(r32);
    L72:
        if (r44 != null) goto L74;
        String r33 = "";
    L75:
        boolean r41 = false;
        if (r33.length() != 0) goto L78;
        boolean r34 = true;
    L80:
        if (r34 == false) goto L82;
        String r35 = "template_detail_button";
    L83:
        UserCreation r36 = m3();
        if (r36 == null) goto L88;
        UserCreationTrackParams r37 = r36.n;
        if (r37 == null) goto L88;
        Integer r38 = r37.b;
    L89:
        UserCreation r114 = m3();
        if (r114 == null) goto L92;
        Long r210 = r114.f;
    L93:
        UserCreation r115 = m3();
        if (r115 == null) goto L98;
        AuthorInfo r116 = r115.g;
        if (r116 == null) goto L98;
        String r117 = r116.b;
    L99:
        UserCreation r118 = m3();
        if (r118 == null) goto L104;
        UserCreationTrackParams r119 = r118.n;
        if (r119 == null) goto L104;
        String r120 = r119.f;
    L105:
        UserCreation r121 = m3();
        if (r121 == null) goto L110;
        UserCreationTrackParams r122 = r121.n;
        if (r122 == null) goto L110;
        String r123 = r122.d;
    L111:
        UserCreation r124 = m3();
        if (r124 == null) goto L116;
        UserCreationTrackParams r125 = r124.n;
        if (r125 == null) goto L116;
        String r211 = r125.e;
    L117:
        UserCreation r126 = m3();
        if (r126 == null) goto L120;
        String r212 = r126.i;
    L121:
        UserCreation r127 = m3();
        if (r127 == null) goto L124;
        String r213 = zp9.d.c(r127);
    L125:
        UserCreation r128 = m3();
        if (r128 == null) goto L128;
        Boolean r214 = Boolean.valueOf(r128.z());
    L129:
        UserCreation r129 = m3();
        if (r129 == null) goto L132;
        Boolean r215 = Boolean.valueOf(r129.D());
    L133:
        UserCreation r130 = m3();
        if (r130 == null) goto L140;
        UserCreationRefContent r131 = r130.o;
        if (r131 == null) goto L140;
        List r132 = r131.a();
        if (r132 == null) goto L140;
        Integer r216 = Integer.valueOf(r132.size());
    L141:
        j29.a r133 = Y2();
        if (r133 == null) goto L146;
        zp9.g r134 = r133.a;
        if (r134 == null) goto L146;
        String r310 = r134.i;
    L147:
        j29.a r135 = Y2();
        if (r135 == null) goto L152;
        zp9.g r136 = r135.a;
        if (r136 == null) goto L152;
        String r311 = r136.q;
    L153:
        j29.a r137 = Y2();
        if (r137 == null) goto L158;
        zp9.g r138 = r137.a;
        if (r138 == null) goto L158;
        String r312 = r138.r;
    L159:
        j29.a r139 = Y2();
        if (r139 == null) goto L164;
        zp9.g r140 = r139.a;
        if (r140 == null) goto L164;
        String r313 = r140.s;
    L166:
        if (this.u == false) goto L168;
        String r141 = "use_prompt";
        Object r314 = "template_detail_button";
    L171:
        String r315 = r141;
    L173:
        UserCreation r142 = m3();
        if (r142 == null) goto L176;
        String r316 = zp9.d.e(r142);
    L177:
        boolean r143 = IUgcAIGCService.a.v();
        UserCreation r144 = m3();
        if (r144 == null) goto L182;
        UserCreationTrackParams r145 = r144.n;
        if (r145 == null) goto L182;
        Integer r146 = r145.c;
    L183:
        j29.a r0 = Y2();
        if (r0 == null) goto L188;
        zp9.g r1 = r0.a;
        if (r1 == null) goto L188;
        String r40 = r1.n;
    L189:
        j29.a r42 = Y2();
        if (r42 == null) goto L194;
        zp9.g r43 = r42.a;
        if (r43 == null) goto L194;
        String r45 = r43.o;
    L195:
        Boolean r317 = Boolean.valueOf(r143);
        Object r46 = r314;
        u3.l(r5, r24, r35, r14, r26, r28, r113, r117, r146, r38, r112, r111, r123, r120, r211, r110, r20, r21, r210, r23, r212, r213, r215, r216, r214, r310, null, r316, r315, r317, r311, r312, r313, r40, r45, 268435840, 0);
        if (Intrinsics.areEqual(r44, "template_detail_caption") == true) goto L233;
        final CreationDetailBottomToolsComponent r47 = this;
        if (r47.u == true) goto L234;
        UserCreation r48 = m3();
        if (r48 != null) goto L202;
    L204:
        if (r41 == false) goto L234;
        Intrinsics.checkNotNullParameter(r47, "<this>");
        FragmentActivity r50 = com.larus.ui.arch.component.internal.attach.a.b(r47, r47).getActivity();
        if (r50 == null) goto L234;
        UserCreation r51 = m3();
        if (r51 == null) goto L234;
        Lazy r52 = com.larus.community.impl.quickmenu.doSame.e.a;
        JSONObject r53 = new JSONObject();
        j29.a r54 = Y2();
        if (r54 == null) goto L214;
        zp9.g r55 = r54.a;
        if (r55 == null) goto L214;
        String r56 = r55.b;
    L215:
        r53.putOpt("recommend_from", r56);
        r53.putOpt("show_from", r46);
        Unit r57 = Unit.INSTANCE;
        com.larus.community.impl.quickmenu.doSame.e.b(r50, r51, r53, new f(r47, r44));
        j29.a r58 = Y2();
        if (r58 == null) goto L220;
        zp9.g r60 = r58.a;
        if (r60 == null) goto L220;
        String r61 = r60.b;
    L221:
        Boolean r62 = Boolean.valueOf(r51.D());
        UserCreationRefContent r63 = r51.o;
        if (r63 == null) goto L226;
        List r64 = r63.a();
        if (r64 == null) goto L226;
        Integer r65 = Integer.valueOf(r64.size());
    L227:
        AuthorInfo r66 = r51.g;
        if (r66 == null) goto L230;
        String r67 = r66.b;
    L231:
        u3.o(r61, r62, r65, r67, r51.a, "template_detail_button", zp9.d.c(r51), zp9.d.d(r51), zp9.d.e(r51));
        return;
    L230:
        r67 = null;
    L226:
        r65 = null;
    L220:
        r61 = null;
    L214:
        r56 = null;
        goto L215
    L202:
        if (r48.a() != true) goto L204;
        r41 = true;
    L234:
        z3(r47, r44, null, 5);
        return;
    L233:
        r47 = this;
    L194:
        r45 = null;
    L188:
        r40 = null;
    L182:
        r146 = null;
        goto L183
    L176:
        r316 = null;
        goto L177
    L168:
        UserCreation r147 = m3();
        r314 = "template_detail_button";
        if (r147 == null) goto L172;
        r141 = zp9.d.a(r147, Intrinsics.areEqual(r44, "template_detail_caption"));
        goto L171
    L172:
        r315 = null;
    L164:
        r313 = null;
    L158:
        r312 = null;
    L152:
        r311 = null;
    L146:
        r310 = null;
    L140:
        r216 = null;
        goto L141
    L132:
        r215 = null;
        goto L133
    L128:
        r214 = null;
        goto L129
    L124:
        r213 = null;
        goto L125
    L120:
        r212 = null;
    L116:
        r211 = null;
    L110:
        r123 = null;
    L104:
        r120 = null;
    L98:
        r117 = null;
        goto L99
    L92:
        r210 = null;
    L88:
        r38 = null;
        goto L89
    L82:
        r35 = r33;
        goto L83
    L78:
        r34 = false;
        goto L80
    L74:
        r33 = r44;
        goto L75
    L71:
        r113 = null;
    L67:
        r112 = null;
        goto L68
    L61:
        r28 = null;
        goto L62
    L57:
        r26 = null;
        goto L58
    L53:
        r24 = null;
    L49:
        r111 = null;
    L43:
        r23 = null;
    L37:
        r14 = null;
    L31:
        r21 = null;
    L25:
        r20 = null;
    L19:
        r110 = null;
    L13:
        r5 = null;
        goto L14
    }

    @Override // com.larus.community.impl.detail.bottomtools.a
    public final void g4(long r3) {
        View r0 = F2();
        if (r0 == null) goto L7;
        ConstraintLayout r1 = (CreationDetailBottomToolsView) r0.findViewById(2131364545);
        if (r1 == null) goto L7;
        e1.o(r1);
    L7:
        View r2 = F2();
        if (r2 == null) goto L12;
        ConstraintLayout r4 = (CreationDetailBottomToolsViewV2) r2.findViewById(2131364546);
        if (r4 == null) goto L12;
        e1.x(r4);
    L12:
        View r5 = F2();
        if (r5 == null) goto L18;
        CreationDetailBottomToolsViewV2 r6 = (CreationDetailBottomToolsViewV2) r5.findViewById(2131364546);
        if (r6 == null) goto L19;
        r6.R5(r3);
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r13v7, types: [com.larus.community.impl.detail.bottomtools.h] */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.larus.community.impl.detail.bottomtools.i] */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.larus.community.impl.detail.bottomtools.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.ViewGroup, com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView] */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.view.ViewGroup, com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewV2] */
    /* JADX WARN: Type inference failed for: r8v11, types: [com.larus.community.impl.detail.bottomtools.g, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r17) {
        Intrinsics.checkNotNullParameter(r17, "view");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == true) goto L68;
        j29.a r4 = Y2();
        if (r4 == null) goto L16;
        zp9.g r5 = r4.a;
        if (r5 == null) goto L16;
        String r6 = r5.c;
    L18:
        if (o0.d(r6) == false) goto L67;
        j29.a r7 = Y2();
        if (r7 == null) goto L24;
        zp9.g r8 = r7.a;
        if (r8 == null) goto L24;
        String r9 = r8.c;
    L25:
        e0 r10 = (e0) AuthModelDelegate.b.e().getValue();
        if (r10 == null) goto L30;
        LaunchInfo r11 = r10.a;
        if (r11 == null) goto L30;
        String r12 = r11.W();
    L32:
        if (Intrinsics.areEqual(r9, r12) == true) goto L67;
        IActionBarService r13 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        j29.a r14 = Y2();
        if (r14 == null) goto L38;
        zp9.g r15 = r14.a;
        if (r15 == null) goto L38;
        String r16 = r15.c;
    L39:
        List r18 = r13.f(r16);
        if (r18 == null) goto L63;
        List r20 = r18;
        if ((r20 instanceof Collection) == true) goto L44;
    L46:
        Iterator r21 = r20.iterator();
    L48:
        if (r21.hasNext() == false) goto L60;
        com.larus.bmhome.actionbar.model.r r22 = ((z0) r21.next()).q;
        if (r22 == null) goto L57;
        Integer r23 = r22.a;
        if (r23 == null) goto L57;
        if (r23.intValue() != 28) goto L57;
        boolean r24 = true;
    L58:
        if (r24 == false) goto L48;
        boolean r25 = true;
    L61:
        if (r25 != true) goto L63;
        boolean r26 = true;
    L64:
        if (r26 == false) goto L68;
    L69:
        boolean r27 = false;
    L70:
        this.u = r27;
        if (r27 == false) goto L83;
        UserCreation r28 = m3();
        if (r28 == null) goto L79;
        CreationDynamicInfo r30 = r28.h;
        if (r30 == null) goto L79;
        TplInfo r31 = r30.e;
        if (r31 == null) goto L79;
        String r32 = r31.a;
    L81:
        if (Intrinsics.areEqual(r32, "change_picture") == false) goto L83;
        boolean r33 = true;
    L84:
        int r34 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r35 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(r35, "fragment");
        ICommunityHostBehaviorProvider r36 = e29.d.c();
        if (r36 != null) goto L87;
    L89:
        boolean r37 = false;
    L90:
        Intrinsics.checkNotNullParameter(this, "<this>");
        int r1 = e29.d.b(com.larus.ui.arch.component.internal.attach.a.b(this, this)).e;
        View r38 = F2();
        int r110 = 2130971546;
        int r111 = 2131167462;
        if (r38 == null) goto L158;
        final ?? r40 = (CreationDetailBottomToolsViewV2) r38.findViewById(2131364546);
        if (r40 == 0) goto L158;
        ConstraintLayout r112 = r40.a.h;
        if (r37 == false) goto L97;
        int r113 = 0;
    L98:
        r112.setVisibility(r113);
        if (r1 == 0) goto L101;
        r40.a.f.setImageResource(r1);
    L101:
        ConstraintLayout r114 = r40.a.b;
        ConstraintLayout.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L157;
        ConstraintLayout.LayoutParams r116 = r115;
        int r117 = 2131386070;
        if (r37 == false) goto L106;
        int r41 = 2131386070;
    L107:
        r116.endToStart = r41;
        r114.setLayoutParams(r116);
        ConstraintLayout r42 = r40.a.c;
        ViewGroup.LayoutParams r118 = r42.getLayoutParams();
        if (r118 == null) goto L155;
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        if (r37 == true) goto L113;
        r117 = 2131367328;
    L113:
        r119.startToEnd = r117;
        if (r37 == false) goto L116;
        int r120 = r40.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462));
    L117:
        r119.setMarginStart(r120);
        r42.setLayoutParams(r119);
        r40.setMakeSameActionVisible(z2.a.m());
        final ?? r43 = new com.larus.community.impl.detail.bottomtools.b(this);
        final ?? r44 = new g(this);
        final ?? r121 = new h(this);
        final ?? r122 = new i(this, r40);
        Intrinsics.checkNotNullParameter(r43, "likeAction");
        Intrinsics.checkNotNullParameter(r44, "makeSameAction");
        e1.d(r40.a.g, new w(r43));
        e1.d(r40.a.b, new x(r122));
        e1.d(r40.a.h, new y(r121));
        e1.d(r40.a.c, new z(r44));
        UserCreation r45 = m3();
        if (r45 != null) goto L120;
    L122:
        boolean r46 = false;
    L123:
        UserCreation r47 = m3();
        if (r46 == false) goto L126;
        r40.a.k.setText(2131901253);
        r40.a.e.setImageResource(2131243413);
        goto L158
    L126:
        if (r33 == true) goto L141;
        if (r47 == null) goto L131;
        CreationDynamicInfo r48 = r47.h;
        if (r48 == null) goto L131;
        String r50 = r48.c;
    L133:
        if (o0.d(r50) == false) goto L141;
        TextView r51 = r40.a.k;
        if (r47 == null) goto L139;
        CreationDynamicInfo r52 = r47.h;
        if (r52 == null) goto L139;
        String r53 = r52.c;
    L140:
        r51.setText(r53);
    L142:
        if (r47 == null) goto L148;
        CreationDynamicInfo r54 = r47.h;
        if (r54 == null) goto L148;
        TplInfo r55 = r54.e;
        if (r55 == null) goto L148;
        String r56 = r55.a;
    L150:
        if (Intrinsics.areEqual(r56, "ai_replica") == false) goto L152;
        int r57 = 2131242259;
    L153:
        r40.a.e.setImageResource(r57);
        goto L158
    L152:
        r57 = 2131240155;
    L148:
        r56 = null;
    L139:
        r53 = null;
    L131:
        r50 = null;
    L141:
        r40.a.k.setText(2131901659);
        goto L142
    L120:
        if (r45.b() != true) goto L122;
        r46 = true;
        goto L123
    L116:
        r120 = r40.getResources().getDimensionPixelSize(v19.c.b(2130971255, null, 2131166880));
        goto L117
    L155:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L106:
        r41 = 2131368262;
        goto L107
    L157:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L97:
        r113 = 8;
    L158:
        View r58 = F2();
        if (r58 == null) goto L196;
        ?? r60 = (CreationDetailBottomToolsView) r58.findViewById(2131364545);
        if (r60 == 0) goto L196;
        ConstraintLayout r61 = r60.a.d;
        if (r37 == false) goto L165;
        int r62 = 0;
    L166:
        r61.setVisibility(r62);
        if (r1 == 0) goto L169;
        r60.a.g.setImageResource(r1);
    L169:
        ConstraintLayout r63 = r60.a.b;
        ViewGroup.LayoutParams r64 = r63.getLayoutParams();
        if (r64 == null) goto L195;
        ViewGroup.LayoutParams r65 = (ConstraintLayout.LayoutParams) r64;
        int r66 = 2131368270;
        if (r37 == false) goto L174;
        int r67 = 2131368270;
    L175:
        ((ConstraintLayout.LayoutParams) r65).endToStart = r67;
        r63.setLayoutParams(r65);
        ConstraintLayout r68 = r60.a.c;
        ViewGroup.LayoutParams r70 = r68.getLayoutParams();
        if (r70 == null) goto L193;
        ConstraintLayout.LayoutParams r71 = (ConstraintLayout.LayoutParams) r70;
        if (r37 == true) goto L181;
        r66 = 2131368260;
    L181:
        r71.startToEnd = r66;
        Resources r72 = r60.getResources();
        if (r37 == true) goto L185;
        r110 = 2130971480;
        r111 = 2131167331;
    L185:
        r71.setMarginStart(r72.getDimensionPixelSize(v19.c.b(r110, null, r111)));
        r68.setLayoutParams(r71);
        r60.setMakeSameActionVisible(z2.a.m());
        r60.R5(new j(this), new k(this), new l(this));
        UserCreation r73 = m3();
        if (r73 != null) goto L188;
    L190:
        boolean r74 = false;
    L191:
        r60.T5(r74, m3(), r33);
        goto L196
    L188:
        if (r73.b() != true) goto L190;
        r74 = true;
        goto L191
    L193:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L174:
        r67 = 2131368262;
        goto L175
    L195:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L165:
        r62 = 8;
    L196:
        Cr();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailBottomToolsComponent$initObserver$1(this, null), 3, null);
        if (m3() != null) goto L199;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailBottomToolsComponent$initObserver$2(this, null), 3, null);
    L199:
        c0 r75 = (c0) this.p.getValue();
        if (r75 != null) goto L202;
    L204:
        boolean r76 = false;
    L205:
        if (r76 == false) goto L213;
        F2().post(new m(this));
        return;
    L213:
        return;
    L202:
        if (r75.nk() != true) goto L204;
        r76 = true;
        goto L205
    L87:
        if (r36.g(r35) != true) goto L89;
        r37 = true;
    L79:
        r32 = null;
    L83:
        r33 = false;
    L57:
        r24 = false;
    L60:
        r25 = false;
        goto L61
    L44:
        if (r20.isEmpty() == false) goto L46;
    L63:
        r26 = false;
    L38:
        r16 = null;
    L30:
        r12 = null;
    L24:
        r9 = null;
    L67:
        if (((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28) != null) goto L69;
    L16:
        r6 = null;
    L68:
        r27 = true;
        goto L70
    L5:
        if (r2.getBoolean("ignore_tpl_info") != true) goto L7;
        r3 = true;
        goto L9
    }

    public static void z3(CreationDetailBottomToolsComponent r34, String r35, String r36, int r37) {
        if ((r37 & 4) == 0) goto L5;
        String r12 = null;
    L6:
        sq9.t r14 = r34.t;
        if (r14 == null) goto L154;
        j29.a r1 = r34.Y2();
        if (r1 == null) goto L13;
        zp9.g r2 = r1.a;
        if (r2 == null) goto L13;
        String r3 = r2.a;
    L14:
        String r4 = String.valueOf(r3);
        j29.a r5 = r34.Y2();
        if (r5 == null) goto L19;
        zp9.g r6 = r5.a;
        if (r6 == null) goto L19;
        String r7 = r6.i;
    L20:
        UserCreation r8 = r34.m3();
        j29.a r9 = r34.Y2();
        if (r9 == null) goto L25;
        zp9.g r10 = r9.a;
        if (r10 == null) goto L25;
        String r11 = r10.b;
    L26:
        j29.a r13 = r34.Y2();
        if (r13 == null) goto L31;
        zp9.g r15 = r13.a;
        if (r15 == null) goto L31;
        String r16 = r15.j;
    L32:
        j29.a r17 = r34.Y2();
        if (r17 == null) goto L37;
        zp9.g r18 = r17.a;
        if (r18 == null) goto L37;
        String r20 = r18.c;
    L38:
        j29.a r21 = r34.Y2();
        if (r21 == null) goto L43;
        zp9.g r22 = r21.a;
        if (r22 == null) goto L43;
        String r23 = r22.d;
    L44:
        j29.a r24 = r34.Y2();
        if (r24 == null) goto L49;
        zp9.g r25 = r24.a;
        if (r25 == null) goto L49;
        Boolean r110 = r25.k;
    L50:
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Bundle r111 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34).getArguments();
        boolean r112 = true;
        if (r111 == null) goto L53;
        r112 = r111.getBoolean("open_new_chat_page_on_send", true);
    L53:
        int r26 = e29.d.a;
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Fragment r27 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34);
        Intrinsics.checkNotNullParameter(r27, "fragment");
        ICommunityHostBehaviorProvider r113 = e29.d.c();
        if (r113 == null) goto L56;
        r112 = r113.l(r27);
    L56:
        boolean r114 = r34.u;
        j29.a r28 = r34.Y2();
        if (r28 == null) goto L61;
        zp9.g r30 = r28.a;
        if (r30 == null) goto L61;
        String r115 = r30.m;
    L62:
        j29.b r31 = r34.h3();
        if (r31 == null) goto L67;
        j1 r32 = r31.a;
        if (r32 == null) goto L67;
        String r116 = r32.p;
    L68:
        j29.b r33 = r34.h3();
        if (r33 == null) goto L73;
        j1 r38 = r33.a;
        if (r38 == null) goto L73;
        String r210 = r38.q;
    L74:
        j29.b r40 = r34.h3();
        if (r40 == null) goto L79;
        j1 r41 = r40.a;
        if (r41 == null) goto L79;
        String r211 = r41.r;
    L80:
        j29.b r42 = r34.h3();
        if (r42 == null) goto L85;
        j1 r43 = r42.a;
        if (r43 == null) goto L85;
        String r212 = r43.s;
    L86:
        j29.a r44 = r34.Y2();
        if (r44 == null) goto L91;
        zp9.g r45 = r44.a;
        if (r45 == null) goto L91;
        String r213 = r45.q;
    L92:
        j29.a r46 = r34.Y2();
        if (r46 == null) goto L97;
        zp9.g r47 = r46.a;
        if (r47 == null) goto L97;
        String r214 = r47.r;
    L98:
        j29.a r48 = r34.Y2();
        if (r48 == null) goto L103;
        zp9.g r50 = r48.a;
        if (r50 == null) goto L103;
        String r215 = r50.s;
    L104:
        j29.a r51 = r34.Y2();
        if (r51 == null) goto L109;
        zp9.g r52 = r51.a;
        if (r52 == null) goto L109;
        String r216 = r52.t;
    L110:
        j29.a r53 = r34.Y2();
        if (r53 == null) goto L115;
        zp9.g r54 = r53.a;
        if (r54 == null) goto L115;
        String r217 = r54.u;
    L116:
        j29.a r55 = r34.Y2();
        if (r55 == null) goto L121;
        zp9.g r56 = r55.a;
        if (r56 == null) goto L121;
        String r218 = r56.v;
    L122:
        d0 r310 = new d0(r213, r214, r215, r216, r217, r218);
        j29.a r57 = r34.Y2();
        if (r57 == null) goto L127;
        zp9.g r58 = r57.a;
        if (r58 == null) goto L127;
        String r219 = r58.n;
    L128:
        j29.a r60 = r34.Y2();
        if (r60 == null) goto L133;
        zp9.g r61 = r60.a;
        if (r61 == null) goto L133;
        String r220 = r61.o;
    L134:
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Bundle r62 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34).getArguments();
        if (r62 != null) goto L137;
        boolean r221 = r114;
        Integer r222 = null;
    L148:
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34).getArguments();
        if (r0 == null) goto L151;
        Boolean r311 = Boolean.valueOf(r0.getBoolean("is_send_from_detail", false));
    L152:
        r14.a(new sq9.p(r35, r4, r7, r8, r11, null, r16, r20, r23, r110, r112, r12, r221, r115, r116, r210, r211, r212, r310, null, null, r219, r220, r222, r311, 1572864), null);
        return;
    L151:
        r311 = null;
        goto L152
    L137:
        r221 = r114;
        if (r62.containsKey("creation_dosame_landing_type") == false) goto L140;
        Integer r63 = Integer.valueOf(r62.getInt("creation_dosame_landing_type"));
    L141:
        Intrinsics.checkNotNullParameter(r34, "<this>");
        Fragment r117 = com.larus.ui.arch.component.internal.attach.a.b(r34, r34);
        Intrinsics.checkNotNullParameter(r117, "fragment");
        ICommunityHostBehaviorProvider r118 = e29.d.c();
        if (r118 == null) goto L147;
        Integer r119 = r118.c(r117);
        if (r119 == null) goto L147;
        r222 = r119;
    L147:
        r222 = r63;
        goto L148
    L140:
        r63 = null;
    L133:
        r220 = null;
    L127:
        r219 = null;
    L121:
        r218 = null;
    L115:
        r217 = null;
    L109:
        r216 = null;
    L103:
        r215 = null;
    L97:
        r214 = null;
    L91:
        r213 = null;
    L85:
        r212 = null;
    L79:
        r211 = null;
    L73:
        r210 = null;
    L67:
        r116 = null;
    L61:
        r115 = null;
    L49:
        r110 = null;
    L43:
        r23 = null;
    L37:
        r20 = null;
    L31:
        r16 = null;
    L25:
        r11 = null;
    L19:
        r7 = null;
    L13:
        r3 = null;
        goto L14
    L154:
        return;
    L5:
        r12 = r36;
        goto L6
    }
}

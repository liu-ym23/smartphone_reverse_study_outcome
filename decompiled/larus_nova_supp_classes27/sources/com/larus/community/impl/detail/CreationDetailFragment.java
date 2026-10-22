package com.larus.community.impl.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.adapter.LoadingItemDecoration;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailPageBinding;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsView;
import com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewV2;
import com.larus.community.impl.detail.header.CreationDetailCommentViewHolder;
import com.larus.community.impl.detail.header.CreationDetailHeadInspirationViewHolder;
import com.larus.community.impl.detail.image.CreationDetailImageView;
import com.larus.community.impl.detail.image.CreationFullscreenImageViewer;
import com.larus.community.impl.detail.loading.CreationDetailLoadingView;
import com.larus.community.impl.detail.prompt.CreationDetailPromptView;
import com.larus.community.impl.detail.toptools.CreationDetailTopToolsView;
import com.larus.community.impl.detail.video.CreationDetailVideoView;
import com.larus.community.impl.repository.CommunityCreationRecommendRepository;
import com.larus.community.impl.view.ViewPager2FixScrollableLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.CreationLikeInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.model.comment.ICommentService;
import com.larus.platform.model.comment.api.CommentHttpApi;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.larus.platform.model.comment.api.CommentScrollToIndexType;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001xB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J&\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u00020<H\u0016J\u0010\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\rH\u0002J\u001a\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010M\u001a\u00020<2\b\u0010N\u001a\u0004\u0018\u00010OJ\u0012\u0010P\u001a\u00020<2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J4\u0010Q\u001a\u0016\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T\u0012\u0004\u0012\u00020\u000b0R2\u0006\u0010U\u001a\u00020\r2\u000e\u0010V\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`TH\u0002J\b\u0010Z\u001a\u00020<H\u0002J\b\u0010[\u001a\u00020<H\u0002J\b\u0010\\\u001a\u00020\u000bH\u0016J\b\u0010]\u001a\u00020\rH\u0016J\u0006\u0010^\u001a\u00020<J\b\u0010_\u001a\u00020<H\u0002J\b\u0010`\u001a\u00020\u000bH\u0016J\b\u0010a\u001a\u00020<H\u0002J\b\u0010g\u001a\u00020<H\u0016J\b\u0010h\u001a\u00020<H\u0016J\b\u0010i\u001a\u00020\u000bH\u0016J\b\u0010j\u001a\u00020\u000bH\u0016J\b\u0010k\u001a\u00020\u000bH\u0016J\b\u0010n\u001a\u00020<H\u0002J\b\u0010t\u001a\u00020<H\u0002J\u0010\u0010v\u001a\u00020<2\u0006\u0010w\u001a\u00020\u000bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b7\u00108R\u000e\u0010:\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010b\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010*\u001a\u0004\bd\u0010eR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010o\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010*\u001a\u0004\bq\u0010rR\u000e\u0010u\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/larus/community/impl/detail/CreationDetailFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "Lcom/larus/community/api/spi/ICommunityDetailActivityResultHandler;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailPageBinding;", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "canShowInspirationList", "", "anchorCommentId", "", "gson", "Lcom/google/gson/Gson;", "directUseTemplate", "creationFeedAbility", "Lcom/larus/platform/api/creation/ICreationFeedAbility;", "getCreationFeedAbility", "()Lcom/larus/platform/api/creation/ICreationFeedAbility;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailPromptAbility", "Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "getCreationDetailPromptAbility", "()Lcom/larus/community/impl/detail/prompt/CreationDetailPromptAbility;", "creationDetailCommentAbility", "Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "getCreationDetailCommentAbility", "()Lcom/larus/community/impl/detail/comment/CreationDetailCommentAbility;", "creationDetailFullImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "getCreationDetailFullImageAbility", "()Lcom/larus/community/impl/detail/image/CreationDetailFullImageAbility;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailImageAbility", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "getCreationDetailImageAbility", "()Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "creationDetailImageAbility$delegate", "creationDetailVideoAbility", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "getCreationDetailVideoAbility", "()Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "creationDetailVideoAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "enableMixSkillIntercept", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "updateRootBottomPadding", "source", "onViewCreated", "view", "handleActivityResult", "data", "Landroid/content/Intent;", "handleCommunityActivityResult", "interceptByMixInstructionItem", "Lkotlin/Pair;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/custom/bean/CustomActionBarItem;", "botId", "defaultInstructionItem", "tvCommentTitleRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "bindVideoOrImageComponent", "setupViewTreeObserver", "autoLogEnterPage", "getCurrentPageName", "onBackPressed", "bindToVContext", "autoUseTemplate", "attachComponent", "headerCreator", "Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "getHeaderCreator", "()Lcom/larus/platform/api/creation/ICreationFeedHeaderCreator;", "headerCreator$delegate", "quit", "checkPromptToolsViewVisibility", "isShowInspiration", "isShowComment", "hasExtraContentList", "lastScrollTime", "", "updateScrollTimestamp", "screenHalfHeight", "", "getScreenHalfHeight", "()I", "screenHalfHeight$delegate", "setupFeedScrollMonitoring", "hasShownComment", "trackCommentComponentShow", "fromOnResume", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailFragment extends TraceFragment implements c0, e29.f {
    public static final /* synthetic */ int u = 0;
    public LarusCommunityCreationDetailPageBinding e;
    public zp9.g f;
    public boolean g;
    public String h;
    public final Gson i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final boolean o;
    public WeakReference<TextView> p;
    public final Lazy q;
    public long r;
    public final Lazy s;
    public boolean t;

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ CreationDetailFragment a;
        public final /* synthetic */ z0 b;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            zp9.g r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.h;
        }

        public final String getBotId() {
            zp9.g r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.c;
        }

        public final String getChatType() {
            zp9.g r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f;
        }

        public final String getClickFrom() {
            com.larus.bmhome.actionbar.model.r r0 = this.b.q;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0.b();
        }

        public final String getEnterMethod() {
            zp9.g r0 = this.a.f;
            if (r0 == null) goto L6;
            String r1 = r0.i;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public b(CreationDetailFragment r1, z0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements zp9.p {
        public final /* synthetic */ CreationDetailFragment a;

        public c(CreationDetailFragment r1) {
            this.a = r1;
        }

        public final CreationDetailHeadInspirationViewHolder a(ViewGroup r10) {
            Intrinsics.checkNotNullParameter(r10, "parent");
            View r8 = LayoutInflater.from(this.a.getContext()).inflate(2131561930, r10, false);
            CreationDetailFragment r11 = this.a;
            int r0 = CreationDetailFragment.u;
            com.larus.community.impl.detail.prompt.a r5 = r11.X90();
            com.larus.community.impl.detail.image.d r4 = (com.larus.community.impl.detail.image.d) this.a.l.getValue();
            com.larus.community.impl.detail.image.a r6 = this.a.W90();
            com.larus.community.impl.detail.video.a r7 = (com.larus.community.impl.detail.video.a) this.a.m.getValue();
            Intrinsics.checkNotNull(r8);
            return new CreationDetailHeadInspirationViewHolder(r4, r5, r6, r7, r8);
        }
    }

    public static final class d implements rq9.g {
        public final /* synthetic */ CreationDetailFragment a;

        public d(CreationDetailFragment r1) {
            this.a = r1;
        }

        public final CreationDetailCommentViewHolder a(ViewGroup r11) {
            Intrinsics.checkNotNullParameter(r11, "parent");
            View r9 = LayoutInflater.from(this.a.getContext()).inflate(2131561928, r11, false);
            CreationDetailFragment r12 = this.a;
            if (r9 == null) goto L5;
            TextView r1 = (TextView) r9.findViewById(2131390374);
        L6:
            r12.p = new WeakReference(r1);
            com.larus.community.impl.detail.prompt.a r5 = this.a.X90();
            com.larus.community.impl.detail.image.d r4 = (com.larus.community.impl.detail.image.d) this.a.l.getValue();
            com.larus.community.impl.detail.image.a r6 = this.a.W90();
            com.larus.community.impl.detail.video.a r7 = (com.larus.community.impl.detail.video.a) this.a.m.getValue();
            CreationDetailFragment r13 = this.a;
            r13.getClass();
            com.larus.community.impl.detail.comment.a r8 = (com.larus.community.impl.detail.comment.a) s1a.a.g(r13).getAbility(com.larus.community.impl.detail.comment.a.class);
            Intrinsics.checkNotNull(r9);
            return new CreationDetailCommentViewHolder(r4, r5, r6, r7, r8, r9);
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class e implements rq9.c {
        public final /* synthetic */ CreationDetailFragment a;

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "draft");
        }

        public e(CreationDetailFragment r1) {
            this.a = r1;
        }

        public final void a(long r3) {
            CreationDetailFragment r0 = this.a;
            int r1 = CreationDetailFragment.u;
            r0.getClass();
            com.larus.community.impl.detail.comment.a r2 = (com.larus.community.impl.detail.comment.a) s1a.a.g(r0).getAbility(com.larus.community.impl.detail.comment.a.class);
            if (r2 == null) goto L5;
            r2.g4(r3);
        L5:
            com.larus.community.impl.detail.bottomtools.a r4 = this.a.V90();
            if (r4 == null) goto L9;
            r4.g4(r3);
            return;
        }

        public final void c(RecyclerView r2) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            CreationDetailFragment r3 = this.a;
            int r0 = CreationDetailFragment.u;
            r3.aa0(false);
        }
    }

    public static final class f implements rq9.d {
        public final /* synthetic */ CreationDetailFragment a;

        public final String b() {
            return "";
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.community.impl.detail.b0] */
        public final Map<CommentItemCustomType, rq9.e> d() {
            CommentItemCustomType r1 = CommentItemCustomType.FAIL;
            final CreationDetailFragment r3 = this.a;
            return MapsKt.mapOf(new Pair[]{TuplesKt.to(CommentItemCustomType.EMPTY, new com.larus.community.impl.detail.comment.d()), TuplesKt.to(r1, new com.larus.community.impl.detail.comment.f(new b0(r3)))});
        }

        public final boolean e() {
            return false;
        }

        public final Integer g() {
            return -1;
        }

        public final boolean h() {
            return false;
        }

        public final boolean j() {
            return false;
        }

        public final CommentHttpApi.GetCommentListData m() {
            return null;
        }

        public final int p() {
            return 0;
        }

        public final String q() {
            return "PROFILE_CREATION_LIST_PUBLIC";
        }

        public final String a() {
            return this.a.h;
        }

        public final String c() {
            j29.c r0 = (j29.c) s1a.a.g(this.a).a(j29.c.class);
            if (r0 == null) goto L9;
            UserCreation r1 = r0.a;
            if (r1 == null) goto L9;
            AuthorInfo r2 = r1.g;
            if (r2 == null) goto L9;
            return r2.b;
        L9:
            return null;
        }

        public final long f() {
            j29.c r0 = (j29.c) s1a.a.g(this.a).a(j29.c.class);
            if (r0 == null) goto L11;
            UserCreation r1 = r0.a;
            if (r1 == null) goto L11;
            CreationCommunityInfo r2 = r1.k;
            if (r2 == null) goto L11;
            Long r3 = r2.b;
            if (r3 == null) goto L11;
            return r3.longValue();
        L11:
            return 0;
        }

        public final String i() {
            j29.c r0 = (j29.c) s1a.a.g(this.a).a(j29.c.class);
            if (r0 == null) goto L9;
            UserCreation r1 = r0.a;
            if (r1 == null) goto L9;
            UserCreationTrackParams r2 = r1.n;
            if (r2 == null) goto L9;
            return r2.a;
        L9:
            return null;
        }

        public final String k() {
            zp9.g r0 = this.a.f;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b;
        }

        public final Boolean l() {
            boolean r0 = v19.h.a;
            return Boolean.valueOf(v19.h.a(null));
        }

        public final Integer o() {
            return 2131102529;
        }

        public final CommentScrollToIndexType n() {
            return CommentScrollToIndexType.CURRENT;
        }

        public f(CreationDetailFragment r1) {
            this.a = r1;
        }
    }

    public static final class g implements rq9.f {
        public final /* synthetic */ CreationDetailFragment a;

        public final Pair<String, JSONObject> b() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("delete_ai_creation_comment", r0);
        }

        public final Pair d() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("ai_creation_comment_show", r0);
        }

        public final Pair<String, JSONObject> e() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("comment_ai_creation", r0);
        }

        public final JSONObject f() {
            j29.c r0 = (j29.c) s1a.a.g(this.a).a(j29.c.class);
            Integer r1 = null;
            if (r0 == null) goto L5;
            UserCreation r2 = r0.a;
        L6:
            JSONObject r3 = new JSONObject();
            CreationDetailFragment r4 = this.a;
            zp9.g r5 = r4.f;
            if (r5 == null) goto L9;
            String r6 = r5.c;
        L10:
            r3.put("bot_id", r6);
            zp9.g r7 = r4.f;
            if (r7 == null) goto L13;
            String r8 = r7.j;
        L14:
            r3.put("recommend_from", r8);
            zp9.g r9 = r4.f;
            if (r9 == null) goto L17;
            String r10 = r9.i;
        L18:
            r3.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, r10);
            zp9.g r11 = r4.f;
            if (r11 == null) goto L21;
            String r12 = r11.a;
        L22:
            r3.put("current_page", r12);
            zp9.g r13 = r4.f;
            if (r13 == null) goto L25;
            String r14 = r13.h;
        L26:
            r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r14);
            zp9.g r15 = r4.f;
            if (r15 == null) goto L29;
            String r16 = r15.f;
        L30:
            r3.put("chat_type", r16);
            zp9.g r17 = r4.f;
            if (r17 == null) goto L33;
            String r18 = r17.d;
        L34:
            r3.put("conversation_id", r18);
            if (r2 == null) goto L37;
            String r20 = r2.a;
        L38:
            r3.put("template_id", r20);
            if (r2 == null) goto L41;
            String r21 = zp9.d.c(r2);
        L42:
            r3.put("template_sub_type", r21);
            if (r2 == null) goto L47;
            UserCreationTrackParams r22 = r2.n;
            if (r22 == null) goto L47;
            String r23 = r22.a;
        L48:
            r3.put("template_rec_req_id", r23);
            zp9.g r24 = r4.f;
            if (r24 == null) goto L53;
            String r25 = r24.q;
            if (r25 == null) goto L53;
            r3.put("prompt_type", r25);
        L53:
            zp9.g r26 = r4.f;
            if (r26 == null) goto L58;
            String r27 = r26.r;
            if (r27 == null) goto L58;
            r3.put("prompt_from", r27);
        L58:
            zp9.g r28 = r4.f;
            if (r28 == null) goto L63;
            String r30 = r28.s;
            if (r30 == null) goto L63;
            r3.put("visual_size", r30);
        L63:
            if (r2 == null) goto L65;
            String r31 = zp9.d.b(r2);
        L66:
            if (r31 != null) goto L68;
        L71:
            boolean r32 = true;
        L72:
            if (r32 == false) goto L74;
            r31 = "default";
        L74:
            r3.put("template_source", r31);
            if (r2 == null) goto L79;
            Long r33 = r2.f;
            if (r33 == null) goto L79;
            Integer r34 = Integer.valueOf((int) r33.longValue());
        L80:
            r3.put("use_template_uv", r34);
            if (r2 == null) goto L87;
            CreationCommunityInfo r35 = r2.k;
            if (r35 == null) goto L87;
            CreationLikeInfo r36 = r35.a;
            if (r36 == null) goto L87;
            Long r37 = r36.a;
        L88:
            r3.put("like_template_cnt", r37);
            if (r2 == null) goto L93;
            CreationCommunityInfo r38 = r2.k;
            if (r38 == null) goto L93;
            Long r40 = r38.b;
        L94:
            r3.put("comment_template_cnt", r40);
            if (r2 == null) goto L99;
            AuthorInfo r41 = r2.g;
            if (r41 == null) goto L99;
            String r42 = r41.b;
        L100:
            r3.put("creator_id", r42);
            if (r2 == null) goto L105;
            UserCreationTrackParams r43 = r2.n;
            if (r43 == null) goto L105;
            r1 = r43.b;
        L105:
            r3.put("page_index", r1);
            return r3;
        L99:
            r42 = null;
        L93:
            r40 = null;
        L87:
            r37 = null;
        L79:
            r34 = null;
            goto L80
        L68:
            if (r31.length() == 0) goto L71;
            r32 = false;
            goto L72
        L65:
            r31 = null;
        L47:
            r23 = null;
            goto L48
        L41:
            r21 = null;
            goto L42
        L37:
            r20 = null;
            goto L38
        L33:
            r18 = null;
            goto L34
        L29:
            r16 = null;
            goto L30
        L25:
            r14 = null;
            goto L26
        L21:
            r12 = null;
            goto L22
        L17:
            r10 = null;
            goto L18
        L13:
            r8 = null;
            goto L14
        L9:
            r6 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public final Pair<String, JSONObject> g() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("copy_ai_creation_comment", r0);
        }

        public final Pair h() {
            return new Pair("comment_ai_creation_board_collapse", new JSONObject());
        }

        public final Pair<String, JSONObject> i() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("confirm_delete_ai_creation_comment", r0);
        }

        public final Pair<String, JSONObject> j() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("like_ai_creation_comment", r0);
        }

        public final Pair<String, JSONObject> k() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("unlike_ai_creation_comment", r0);
        }

        public final Pair<String, JSONObject> l() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("long_press_ai_creation_comment", r0);
        }

        public final Pair<String, JSONObject> m() {
            return new Pair("click_comment_ai_creation_input", new JSONObject());
        }

        public final Pair<String, JSONObject> n() {
            return new Pair("slide_comment_ai_creation", new JSONObject());
        }

        public final Pair<String, JSONObject> o() {
            JSONObject r0 = new JSONObject();
            r0.put("comment_method", "post_comment");
            return new Pair("report_ai_creation_comment", r0);
        }

        public g(CreationDetailFragment r1) {
            this.a = r1;
        }

        public final Pair<String, JSONObject> a(long r3) {
            JSONObject r0 = new JSONObject();
            r0.put("total_comment_cnt", (int) r3);
            return new Pair("comment_ai_creation_board_show", r0);
        }

        public final void c(Pair<String, ? extends JSONObject> r2) {
            Intrinsics.checkNotNullParameter(r2, "pair");
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "template_detail_page";
    }

    public static boolean Z90() {
        if (z2.a.getCreationCommentConfig().a() == true) goto L5;
    L7:
        return false;
    L5:
        if (ServiceManager.get().getService(ICommentService.class) == null) goto L7;
        return true;
    }

    @Override // com.larus.community.impl.detail.c0
    public final void quit() {
        int r0 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        ICommunityHostBehaviorProvider r1 = e29.d.c();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.f(this) != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L14;
        r3.finish();
        return;
    L14:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean yN() {
        if (z2.a.f1().h() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g == false) goto L7;
        return true;
    }

    public CreationDetailFragment() {
        this.g = true;
        this.i = new Gson();
        this.k = LazyKt.lazy(new t(this));
        this.l = LazyKt.lazy(new u(this));
        this.m = LazyKt.lazy(new v(this));
        this.n = LazyKt.lazy(new w(this));
        this.o = z2.a.getCreationMakeSameConfigV2().a();
        this.p = new WeakReference(null);
        this.q = LazyKt.lazy(new x(this));
        this.s = LazyKt.lazy(new y(this));
    }

    public final void U90() {
        com.larus.community.impl.detail.prompt.a r0 = X90();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L18;
        com.larus.community.impl.detail.bottomtools.a r3 = V90();
        if (r3 != null) goto L12;
    L14:
        if (r1 == false) goto L31;
        com.larus.community.impl.detail.bottomtools.a r4 = V90();
        if (r4 == null) goto L32;
        r4.Hp();
        return;
    L32:
        return;
    L31:
        return;
    L12:
        if (r3.sO() != true) goto L14;
        r1 = true;
        goto L14
    L18:
        com.larus.community.impl.detail.bottomtools.a r5 = V90();
        if (r5 != null) goto L21;
    L23:
        if (r1 == false) goto L34;
        long r6 = System.currentTimeMillis() - this.r;
        if (r6 <= 30) goto L29;
        com.larus.community.impl.detail.bottomtools.a r7 = V90();
        if (r7 == null) goto L35;
        r7.Cr();
        return;
    L35:
        return;
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailFragment$checkPromptToolsViewVisibility$1(r6, this, null), 3, null);
        return;
    L34:
        return;
    L21:
        if (r5.sO() == true) goto L23;
        r1 = true;
        goto L23
    L5:
        if (r0.vG() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final com.larus.community.impl.detail.bottomtools.a V90() {
        return (com.larus.community.impl.detail.bottomtools.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.bottomtools.a.class);
    }

    public final com.larus.community.impl.detail.image.a W90() {
        return (com.larus.community.impl.detail.image.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.image.a.class);
    }

    public final com.larus.community.impl.detail.prompt.a X90() {
        return (com.larus.community.impl.detail.prompt.a) s1a.a.g(this).getAbility(com.larus.community.impl.detail.prompt.a.class);
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean ak() {
        if (yN() == false) goto L5;
    L8:
        return true;
    L5:
        if (Z90() == true) goto L8;
        return false;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        fnc.a r0 = s1a.a.g(this).getAbility(fnc.a.class);
        if (r0 == null) goto L6;
        r0.SN();
        return;
    }

    public final void onResume() {
        super.onResume();
        LarusCommunityCreationDetailPageBinding r0 = this.e;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.j;
        if (r1 == null) goto L7;
        r1.post(new a0(this));
    L7:
        LarusCommunityCreationDetailPageBinding r2 = this.e;
        if (r2 == null) goto L12;
        ConstraintLayout r3 = r2.j;
        if (r3 == null) goto L12;
        i0.a.getClass();
        int r4 = i0.g();
        int r5 = r3.getPaddingStart();
        int r6 = r3.getPaddingEnd();
        int r7 = r3.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r3.getClass().getSimpleName() + ",source:,start:" + r5 + ",top:" + r4 + ",end:" + r6 + ",bottom:" + r7);
        r3.setPaddingRelative(r5, r4, r6, r7);
    L12:
        LarusCommunityCreationDetailPageBinding r8 = this.e;
        if (r8 == null) goto L17;
        ConstraintLayout r9 = r8.j;
        if (r9 == null) goto L17;
        r9.post(new com.larus.community.impl.detail.c(this));
    L17:
        LarusCommunityCreationDetailPageBinding r10 = this.e;
        if (r10 == null) goto L23;
        final ConstraintLayout r11 = r10.j;
        if (r11 == null) goto L24;
        ViewCompat.setOnApplyWindowInsetsListener(r11, new com.larus.community.impl.detail.d(r11, this));
        return;
    L24:
        return;
    }

    @Override // com.larus.community.impl.detail.c0
    public final boolean nk() {
        return this.j;
    }

    public final void Y90(Intent r70) {
        AuthModelDelegate r2 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        String r4 = "7234781073513644036";
        if (r3 == null) goto L8;
        LaunchInfo r5 = r3.a;
        if (r5 == null) goto L8;
        String r6 = r5.W();
        if (r6 == null) goto L8;
    L9:
        zp9.g r7 = this.f;
        if (r7 == null) goto L15;
        String r8 = r7.c;
        if (r8 == null) goto L15;
        String r9 = r8;
    L16:
        if (r7 == null) goto L18;
        String r10 = r7.d;
    L19:
        if (r70 == null) goto L22;
        String r11 = r70.getStringExtra("ipa_main_url");
        if (r11 == null) goto L22;
    L23:
        boolean r14 = true;
        if (r11.length() != 0) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L29;
        return;
    L29:
        if (r70 == null) goto L31;
        Boolean r13 = Boolean.valueOf(r70.getBooleanExtra("key_is_creation_private", false));
    L32:
        Boolean r15 = Boolean.TRUE;
        boolean r18 = Intrinsics.areEqual(r13, r15);
        if (r70 == null) goto L35;
        int r16 = r70.getIntExtra("select_instruction_type", 4);
    L36:
        z0 r17 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r16);
        if (this.o == true) goto L39;
        Pair r20 = new Pair(r17, r15);
    L54:
        z0 r21 = (z0) r20.getFirst();
        View r22 = getView();
        if (r22 == null) goto L57;
        r22.postDelayed(new com.larus.community.impl.detail.g(this), 200);
    L57:
        if (r70 == null) goto L59;
        String r23 = r70.getStringExtra("key_video_internal_resource");
    L60:
        if (r21 == null) goto L99;
        if (r70 == null) goto L63;
        ArrayList r110 = r70.getParcelableArrayListExtra("avatar_ref_image");
    L64:
        IUgcAIGCService.Companion r111 = IUgcAIGCService.a;
        FragmentActivity r112 = requireActivity();
        ArrayList r113 = r110;
        int r24 = r16;
        ChatParam r25 = new ChatParam(r10, r9, null, null, null, 252);
        List r28 = CollectionsKt.listOf(r11);
        if (r70 == null) goto L67;
        String r1 = r70.getStringExtra("avatar_dosame_default_prompt");
    L68:
        if (r113 == null) goto L83;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        Iterator r26 = r113.iterator();
    L71:
        if (r26.hasNext() == false) goto L81;
        String r27 = sq9.g.e((ResourceExt) r26.next());
        if (r27 != null) goto L75;
    L78:
        boolean r30 = true;
    L79:
        if (r30 == true) goto L71;
        String r210 = r27;
    L82:
        String r211 = r210;
    L84:
        b r31 = new b(this, r21);
        LinkedHashMap r32 = new LinkedHashMap();
        if (r23 != null) goto L87;
    L89:
        r14 = false;
    L90:
        if (r14 == false) goto L92;
        r32.put("internal_resources", r23);
    L92:
        String r212 = r1;
        Boolean r50 = r13;
        r111.W(new ny9.b(true, r112, r21, r25, true, false, null, r212, r211, null, r113, r28, null, Integer.valueOf(r24), null, null, null, null, null, false, false, r31, null, null, false, r32, null, null, false, null, false, null, Boolean.valueOf(r18), r50, Boolean.FALSE, null, null, null, null, null, null, Boolean.TRUE, null, null, null, null, null, null, null, false, -35663264, 261624));
        return;
    L87:
        if (o0.d(r23) != true) goto L89;
    L75:
        if (r27.length() == 0) goto L78;
        r30 = false;
        goto L79
    L81:
        r210 = null;
        goto L82
    L83:
        r211 = null;
        goto L84
    L67:
        r1 = null;
        goto L68
    L63:
        r110 = null;
        goto L64
    L99:
        return;
    L59:
        r23 = null;
        goto L60
    L39:
        com.larus.bmhome.chat.api.e0 r33 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        if (r33 == null) goto L48;
        LaunchInfo r34 = r33.a;
        if (r34 == null) goto L48;
        String r35 = r34.W();
        if (r35 == null) goto L48;
        r4 = r35;
    L48:
        if (Intrinsics.areEqual(r9, r4) == true) goto L50;
        r20 = new Pair(r17, r15);
        goto L54
    L50:
        z0 r36 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(28);
        if (r36 == null) goto L53;
        r20 = new Pair(r36, Boolean.FALSE);
        goto L54
    L53:
        r20 = new Pair(r17, r15);
        goto L54
    L35:
        r16 = 4;
        goto L36
    L31:
        r13 = null;
        goto L32
    L26:
        r12 = false;
    L22:
        r11 = "";
        goto L23
    L18:
        r10 = null;
    L15:
        r9 = r6;
    L8:
        r6 = "7234781073513644036";
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void aa0(boolean r5) {
        if (Z90() == true) goto L5;
        return;
    L5:
        long r1 = 0;
        if (this.t == false) goto L21;
        if (r5 == false) goto L50;
        fnc.a r6 = s1a.a.g(this).getAbility(fnc.a.class);
        if (r6 == null) goto L51;
        j29.c r0 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r0 == null) goto L19;
        UserCreation r2 = r0.a;
        if (r2 == null) goto L19;
        CreationCommunityInfo r3 = r2.k;
        if (r3 == null) goto L19;
        Long r4 = r3.b;
        if (r4 == null) goto L19;
        r1 = r4.longValue();
    L19:
        r6.vz(r1);
        return;
    L51:
        return;
    L50:
        return;
    L21:
        WeakReference<TextView> r7 = this.p;
        if (r7 == null) goto L52;
        TextView r8 = r7.get();
        if (r8 == null) goto L56;
        int[] r9 = new int[2];
        r8.getLocationOnScreen(r9);
        LarusCommunityCreationDetailPageBinding r10 = this.e;
        if (r10 == null) goto L53;
        ConstraintLayout r11 = r10.c;
        if (r11 == null) goto L57;
        int[] r12 = new int[2];
        r11.getLocationOnScreen(r12);
        boolean r13 = true;
        if (r9[1] < r12[1]) goto L35;
        r13 = false;
    L35:
        this.t = r13;
        if (r13 == false) goto L54;
        fnc.a r14 = s1a.a.g(this).getAbility(fnc.a.class);
        if (r14 == null) goto L55;
        j29.c r15 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r15 == null) goto L48;
        UserCreation r16 = r15.a;
        if (r16 == null) goto L48;
        CreationCommunityInfo r17 = r16.k;
        if (r17 == null) goto L48;
        Long r18 = r17.b;
        if (r18 == null) goto L48;
        r1 = r18.longValue();
    L48:
        r14.vz(r1);
        return;
    L55:
        return;
    L54:
        return;
    L57:
        return;
    L53:
        return;
    L56:
        return;
    }

    public final void ba0(String r9) {
        LarusCommunityCreationDetailPageBinding r0 = this.e;
        if (r0 == null) goto L18;
        ConstraintLayout r1 = r0.j;
        if (r1 == null) goto L19;
        FragmentActivity r2 = getActivity();
        if ((r2 instanceof FragmentActivity) == true) goto L11;
        r2 = null;
    L11:
        if (r2 != null) goto L13;
        return;
    L13:
        i0.a.getClass();
        int r3 = Math.min(i0.c(r2), i0.e());
        int r4 = e29.d.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r1, "rootView");
        ICommunityHostBehaviorProvider r5 = e29.d.c();
        if (r5 == null) goto L16;
        r3 = r5.u(this, r1, r3);
    L16:
        int r6 = r1.getPaddingStart();
        int r7 = r1.getPaddingTop();
        int r8 = r1.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:" + r9 + ",start:" + r6 + ",top:" + r7 + ",end:" + r8 + ",bottom:" + r3);
        r1.setPaddingRelative(r6, r7, r8, r3);
        return;
    L19:
        return;
    }

    @Override // e29.f
    public final void j6(Intent r1) {
        Y90(r1);
    }

    public final void onAttach(Context r28) {
        Intrinsics.checkNotNullParameter(r28, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r28);
        Bundle r0 = getArguments();
        boolean r3 = true;
        String r4 = null;
        if (r0 == null) goto L19;
        String r1 = r0.getString("creation");
        if (r1 == null) goto L19;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L19;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L13
        Object r2 = Result.constructor-impl((UserCreation) xt7.d.b.c(UserCreation.Companion.serializer(), r1));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r2) == false) goto L18;
        r2 = null;
    L18:
        UserCreation r6 = (UserCreation) r2;
    L20:
        if (r6 == null) goto L22;
        t1a.b r7 = s1a.a.g(this);
        j29.c r8 = j29.c.c;
        Intrinsics.checkNotNullParameter(r6, "creation");
        r7.n(new j29.c(r6, r6.a), j29.c.class);
    L27:
        Bundle r9 = getArguments();
        if (r9 == null) goto L30;
        String r10 = r9.getString("anchor_comment_id");
    L31:
        this.h = r10;
        Gson r11 = this.i;
        Bundle r12 = getArguments();
        if (r12 == null) goto L34;
        r4 = r12.getString("track_params");
    L34:
        zp9.g r13 = (zp9.g) GsonProtectorUtils.fromJson(r11, r4, zp9.g.class);
        if (r13 == null) goto L37;
        String r14 = r13.a;
        String r15 = r13.b;
        String r16 = r13.c;
        String r17 = r13.d;
        Integer r18 = r13.e;
        String r110 = r13.f;
        String r111 = r13.g;
        String r112 = r13.i;
        String r113 = r13.j;
        Boolean r114 = r13.k;
        String r20 = r13.l;
        String r21 = r13.m;
        String r22 = r13.n;
        String r23 = r13.o;
        Boolean r24 = r13.p;
        String r25 = r13.q;
        String r26 = r13.r;
        String r27 = r13.s;
        String r30 = r13.t;
        String r31 = r13.u;
        String r32 = r13.v;
        Intrinsics.checkNotNullParameter("template_detail_page", "currentPage");
        this.f = new zp9.g("template_detail_page", r15, r16, r17, r18, r110, r111, r14, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, r27, r30, r31, r32);
        t1a.b r33 = s1a.a.g(this);
        int r34 = j29.a.b;
        r33.n(new j29.a(this.f), j29.a.class);
    L37:
        Bundle r35 = getArguments();
        if (r35 == null) goto L40;
        this.g = r35.getBoolean("can_show_inspiration_list", true);
    L40:
        Bundle r36 = getArguments();
        if (r36 != null) goto L43;
    L47:
        s1a.a.g(this).c(this, c0.class);
        k1a.b.a(this, new z(this));
        return;
    L43:
        if (r36.getInt("direct_use_template") == 1) goto L46;
        r3 = false;
    L46:
        this.j = r3;
        goto L47
    L30:
        r10 = null;
        goto L31
    L22:
        Bundle r37 = getArguments();
        if (r37 == null) goto L27;
        String r38 = r37.getString("creation_id");
        if (r38 == null) goto L27;
        t1a.b r40 = s1a.a.g(this);
        j29.c r41 = j29.c.c;
        Intrinsics.checkNotNullParameter(r38, "creationId");
        r40.n(new j29.c(j29.c.c.a, r38), j29.c.class);
    L13:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        r6 = null;
        goto L20
    }

    public final void onViewCreated(View r47, Bundle r48) {
        Intrinsics.checkNotNullParameter(r47, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r47, r48);
        if (e2.a.isPad() == false) goto L12;
        int r1 = m0.a;
        float r2 = RangesKt.coerceAtMost(m0.b(getContext()) * 0.75f, c7.c(600));
        LarusCommunityCreationDetailPageBinding r3 = this.e;
        if (r3 == null) goto L12;
        ViewGroup.LayoutParams r4 = r3.k.getLayoutParams();
        if (r4 == null) goto L9;
        r4.width = (int) r2;
    L9:
        ViewGroup.LayoutParams r5 = r3.c.getLayoutParams();
        if (r5 == null) goto L12;
        r5.width = (int) r2;
    L12:
        String r6 = null;
        if (yN() == false) goto L94;
        k1a.b.a(this, new com.larus.community.impl.detail.b(this));
        zp9.l r7 = s1a.a.g(this).getAbility(zp9.l.class);
        if (r7 == null) goto L76;
        zp9.g r8 = this.f;
        if (r8 == null) goto L19;
        String r11 = r8.h;
    L20:
        if (r8 == null) goto L22;
        String r9 = r8.b;
    L23:
        if (r8 == null) goto L25;
        String r12 = r8.i;
    L26:
        if (r8 == null) goto L28;
        String r10 = r8.d;
    L29:
        if (r8 == null) goto L31;
        String r13 = r8.f;
    L32:
        if (r8 == null) goto L34;
        String r14 = r8.c;
    L35:
        if (r8 == null) goto L37;
        String r15 = r8.j;
    L38:
        if (r15 == null) goto L58;
        int r16 = r15.hashCode();
        if (r16 == (-493995263)) goto L55;
        if (r16 == (-286312810)) goto L51;
        if (r16 != 1708300943) goto L58;
        if (r15.equals("action_bar_template") == false) goto L58;
        r6 = "action_bar_enter_inspiration_feed";
    L61:
        zp9.g r17 = new zp9.g("template_detail_page", r9, r14, r10, null, r13, null, r11, r12, r6, null, null, null, null, null, null, null, null, null, null, null, null, 4193360);
        int r18 = i5.s0();
        Context r20 = getContext();
        float r21 = 200.0f;
        if (r20 == null) goto L64;
        float r22 = c7.d(Integer.valueOf(com.larus.utils.i.d(r20)));
    L65:
        int r23 = 2;
        if (r22 <= 500.0f) goto L68;
        int r24 = 3;
    L69:
        StaggeredGridItemDecoration r110 = new StaggeredGridItemDecoration(r24, c7.b(5), c7.b(5));
        Context r111 = getContext();
        if (r111 == null) goto L73;
        r21 = c7.d(Integer.valueOf(com.larus.utils.i.d(r111)));
    L73:
        if (r21 <= 500.0f) goto L75;
        r23 = 3;
    L75:
        r7.nh(new zp9.f(false, false, "List_Creation_Detail", true, r17, 4, Integer.valueOf(r18), null, false, null, null, false, null, 0, 0, false, null, false, r110, new LoadingItemDecoration(r23, c7.b(5)), false, false, null, null, null, null, null, null, null, null, 1072930691), new zp9.e(new CommunityCreationRecommendRepository(4, null, null, null, ((j29.c) s1a.a.g(this).f(j29.c.class)).b, null, null, null, 232), null, null, null, 14));
        goto L76
    L68:
        r24 = 2;
        goto L69
    L64:
        r22 = 200.0f;
        goto L65
    L51:
        if (r15.equals("personal_homepage_portfolio") == false) goto L58;
        r6 = "personal_homepage_portfolio_inspiration_feed";
        goto L61
    L55:
        if (r15.equals("create_feed") == false) goto L58;
        r6 = "create_feed_enter_inspiration_feed";
    L58:
        zp9.g r25 = this.f;
        if (r25 == null) goto L61;
        r6 = r25.j;
        goto L61
    L37:
        r15 = null;
        goto L38
    L34:
        r14 = null;
        goto L35
    L31:
        r13 = null;
        goto L32
    L28:
        r10 = null;
        goto L29
    L25:
        r12 = null;
        goto L26
    L22:
        r9 = null;
        goto L23
    L19:
        r11 = null;
    L76:
        zp9.l r26 = s1a.a.g(this).getAbility(zp9.l.class);
        if (r26 == null) goto L79;
        r26.Eo((zp9.p) this.q.getValue());
    L79:
        LarusCommunityCreationDetailPageBinding r27 = this.e;
        if (r27 == null) goto L85;
        final ConstraintLayout r28 = r27.a;
        if (r28 == null) goto L85;
        r28.getViewTreeObserver().addOnGlobalLayoutListener(new CreationDetailFragment$setupViewTreeObserver$1(r28, this));
    L85:
        zp9.l r30 = s1a.a.g(this).getAbility(zp9.l.class);
        if (r30 == null) goto L88;
        r30.addOnScrollListener(new CreationDetailFragment$setupFeedScrollMonitoring$1(this));
    L88:
        LarusCommunityCreationDetailPageBinding r31 = this.e;
        if (r31 == null) goto L160;
        ScrollView r32 = r31.k;
        if (r32 == null) goto L161;
        e1.o(r32);
        return;
    L161:
        return;
    L160:
        return;
    L94:
        if (Z90() == false) goto L135;
        final ICommentService r33 = (ICommentService) ServiceManager.get().getService(ICommentService.class);
        if (r33 == null) goto L124;
        f r34 = new f(this);
        j29.c r35 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r35 == null) goto L105;
        UserCreation r36 = r35.a;
        if (r36 == null) goto L105;
        String r37 = r36.a;
        if (r37 == null) goto L105;
        r6 = r37;
    L108:
        r33.c(this, new rq9.a(r34, new com.larus.community.impl.detail.comment.g(r6), new g(this), new e(this), new d(this)));
        LarusCommunityCreationDetailPageBinding r38 = this.e;
        if (r38 == null) goto L113;
        View r40 = r38.l;
        if (r40 == null) goto L113;
        e1.x(r40);
    L113:
        LarusCommunityCreationDetailPageBinding r41 = this.e;
        if (r41 == null) goto L118;
        ConstraintLayout r42 = r41.d;
        if (r42 == null) goto L118;
        e1.x(r42);
    L118:
        LarusCommunityCreationDetailPageBinding r43 = this.e;
        if (r43 == null) goto L123;
        CreationDetailBottomToolsViewV2 r44 = r43.d;
        if (r44 == null) goto L123;
        r44.R5(r34.f());
    L123:
        k1a.b.a(this, new m(this, r33));
    L105:
        j29.c r45 = (j29.c) s1a.a.g(this).a(j29.c.class);
        if (r45 == null) goto L108;
        r6 = r45.b;
    L124:
        LarusCommunityCreationDetailPageBinding r46 = this.e;
        if (r46 == null) goto L130;
        final ConstraintLayout r50 = r46.a;
        if (r50 == null) goto L130;
        r50.getViewTreeObserver().addOnGlobalLayoutListener(new CreationDetailFragment$setupViewTreeObserver$1(r50, this));
    L130:
        LarusCommunityCreationDetailPageBinding r51 = this.e;
        if (r51 == null) goto L163;
        ScrollView r52 = r51.k;
        if (r52 == null) goto L164;
        e1.o(r52);
        return;
    L164:
        return;
    L163:
        return;
    L135:
        LarusCommunityCreationDetailPageBinding r53 = this.e;
        if (r53 == null) goto L166;
        ConstraintLayout r54 = r53.j;
        if (r54 == null) goto L140;
        r54.setClipChildren(true);
    L140:
        ConstraintLayout r55 = r53.j;
        if (r55 == null) goto L143;
        r55.setClipToPadding(true);
    L143:
        com.larus.community.impl.detail.prompt.a r56 = X90();
        if (r56 == null) goto L146;
        r56.ut(r53.h);
    L146:
        final LarusCommunityCreationDetailPageBinding r57 = this.e;
        if (r57 == null) goto L152;
        com.larus.community.impl.detail.video.a r58 = (com.larus.community.impl.detail.video.a) this.m.getValue();
        if (r58 == null) goto L151;
        r58.jG(r57.i);
    L151:
        r57.k.post(new r(this, r57));
    L152:
        final LarusCommunityCreationDetailPageBinding r60 = this.e;
        if (r60 == null) goto L158;
        com.larus.community.impl.detail.image.d r61 = (com.larus.community.impl.detail.image.d) this.l.getValue();
        if (r61 == null) goto L157;
        r61.P9(r60.g);
    L157:
        r60.k.post(new s(this, r60));
    L158:
        e1.o(r53.f);
        return;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        View r0 = r17.inflate(2131561932, r18, false);
        int r1 = 2131364544;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131364544);
        if (r5 == null) goto L35;
        r1 = 2131364545;
        CreationDetailBottomToolsView r6 = (CreationDetailBottomToolsView) ViewBindings.findChildViewById(r0, 2131364545);
        if (r6 == null) goto L35;
        r1 = 2131364546;
        CreationDetailBottomToolsViewV2 r7 = (CreationDetailBottomToolsViewV2) ViewBindings.findChildViewById(r0, 2131364546);
        if (r7 == null) goto L35;
        r1 = 2131368234;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131368234);
        if (r8 == null) goto L35;
        r1 = 2131368237;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131368237);
        if (r9 == null) goto L35;
        r1 = 2131373352;
        if (((CreationFullscreenImageViewer) ViewBindings.findChildViewById(r0, 2131373352)) == null) goto L35;
        r1 = 2131378654;
        CreationDetailImageView r10 = (CreationDetailImageView) ViewBindings.findChildViewById(r0, 2131378654);
        if (r10 == null) goto L35;
        r1 = 2131378655;
        CreationDetailPromptView r11 = (CreationDetailPromptView) ViewBindings.findChildViewById(r0, 2131378655);
        if (r11 == null) goto L35;
        r1 = 2131378656;
        CreationDetailVideoView r12 = (CreationDetailVideoView) ViewBindings.findChildViewById(r0, 2131378656);
        if (r12 == null) goto L35;
        r1 = 2131379091;
        if (((CreationDetailLoadingView) ViewBindings.findChildViewById(r0, 2131379091)) == null) goto L35;
        r1 = 2131384822;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r0, 2131384822);
        if (r13 == null) goto L35;
        r1 = 2131385238;
        ScrollView r14 = (ScrollView) ViewBindings.findChildViewById(r0, 2131385238);
        if (r14 == null) goto L35;
        r1 = 2131389237;
        if (((CreationDetailTopToolsView) ViewBindings.findChildViewById(r0, 2131389237)) == null) goto L35;
        r1 = 2131392089;
        View r15 = ViewBindings.findChildViewById(r0, 2131392089);
        if (r15 == null) goto L35;
        View r2 = (ConstraintLayout) r0;
        this.e = new LarusCommunityCreationDetailPageBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        if (r2 == null) goto L36;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ViewPager2FixScrollableLayout r3 = new ViewPager2FixScrollableLayout(r2.getContext(), null);
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r3.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        return r3;
    L36:
        return null;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}

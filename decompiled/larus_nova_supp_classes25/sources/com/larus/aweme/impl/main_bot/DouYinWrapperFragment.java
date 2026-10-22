package com.larus.aweme.impl.main_bot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.api.bussiness.j;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.aweme.impl.databinding.LarusDouyinWrapperFragmentLayoutBinding;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.IAwemeDoublePostService;
import com.larus.bmhome.video.RecommendVideoApi;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.business.EnterVideoMethod;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import com.larus.utils.i;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import pr9.h;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0013'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010)\u001a\u00020$H\u0016J\u0018\u0010*\u001a\u00020$2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0002J\b\u0010.\u001a\u00020$H\u0016J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0016J\u0018\u00101\u001a\u0002022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0002J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020-J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0018\u00108\u001a\u00020$2\u0006\u00104\u001a\u00020-2\u0006\u00107\u001a\u00020\rH\u0016J\u0010\u00109\u001a\u00020$2\u0006\u00107\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006:"}, d2 = {"Lcom/larus/aweme/impl/main_bot/DouYinWrapperFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabChildFragment;", "<init>", "()V", "binding", "Lcom/larus/aweme/impl/databinding/LarusDouyinWrapperFragmentLayoutBinding;", "isFirst", "", "isShowBottomTab", "operate", "Lcom/larus/platform/model/video/sdkwrapper/feed/IOperateFeedFragment;", "page", "", "hasExposed", "pageSelected", "enterPageTime", "", "appBackGroundListener", "com/larus/aweme/impl/main_bot/DouYinWrapperFragment$appBackGroundListener$1", "Lcom/larus/aweme/impl/main_bot/DouYinWrapperFragment$appBackGroundListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "refreshSwipeListener", "Lcom/larus/platform/model/video/sdkwrapper/feed/CustomRefreshSwipeChangeListener;", "getRefreshSwipeListener", "()Lcom/larus/platform/model/video/sdkwrapper/feed/CustomRefreshSwipeChangeListener;", "setRefreshSwipeListener", "(Lcom/larus/platform/model/video/sdkwrapper/feed/CustomRefreshSwipeChangeListener;)V", "onViewCreated", "", "view", "getMoreListener", "com/larus/aweme/impl/main_bot/DouYinWrapperFragment$getMoreListener$1", "Lcom/larus/aweme/impl/main_bot/DouYinWrapperFragment$getMoreListener$1;", "onDestroyView", "createVideoFeedFragment", "itemIdList", "", "", "onResume", "handleBottomNavigation", "onPause", "createVideoFeedConfigure", "Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "reportLeavePage", "leaveMethod", "onChatTabSelected", "enterMethod", "position", "onChatTabUnselected", "onChatTabReselected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DouYinWrapperFragment extends Fragment implements ci8.c {
    public static final /* synthetic */ int n = 0;
    public LarusDouyinWrapperFragmentLayoutBinding d;
    public boolean e;
    public boolean f;
    public h g;
    public int h;
    public boolean i;
    public boolean j;
    public long k;
    public final a l;
    public final b m;

    public static final class a implements f09.a.b {
        public final /* synthetic */ DouYinWrapperFragment a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            DouYinWrapperFragment r0 = this.a;
            if (r0.j == false) goto L6;
            r0.S90("switch_background");
            return;
        }

        public final void onAppForeground() {
            DouYinWrapperFragment r0 = this.a;
            if (r0.j == false) goto L6;
            r0.k = System.currentTimeMillis();
            return;
        }

        public a(DouYinWrapperFragment r1) {
            this.a = r1;
        }
    }

    public static final class b implements pr9.g {
        public final /* synthetic */ DouYinWrapperFragment a;

        public b(DouYinWrapperFragment r1) {
            this.a = r1;
        }

        public final void a(j r8) {
            Intrinsics.checkNotNullParameter(r8, "callback");
            if (Intrinsics.areEqual(AppHost.a.a().getCurrentActivity(), this.a.getActivity()) == true) goto L5;
            return;
        L5:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new DouYinWrapperFragment$getMoreListener$1$getAids$1(this.a, r8, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.larus.aweme.impl.main_bot.DouYinWrapperFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.aweme.impl.main_bot.DouYinWrapperFragment$onViewCreated$1", f = "DouYinWrapperFragment.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DouYinWrapperFragment this$0;

        public AnonymousClass1(DouYinWrapperFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r5v6 */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L22:
            List r14 = (List) r13;
            if (r14 == null) goto L30;
            ?? r3 = new ArrayList();
            Iterator r15 = r14.iterator();
        L26:
            if (r15.hasNext() == false) goto L32;
            String r4 = ((Content) r15.next()).getItemId();
            if (r4 == null) goto L26;
            r3.add(r4);
        L32:
            DouYinWrapperFragment r16 = this.this$0;
            int r5 = DouYinWrapperFragment.n;
            r16.getClass();
            VideoFeedProviderDelegate r6 = VideoFeedProviderDelegate.b;
            Bundle r7 = r16.getArguments();
            if (r7 == null) goto L35;
            String r8 = r7.getString("enter_method");
        L37:
            if (Intrinsics.areEqual(r8, "outer_push") == false) goto L39;
            EnterVideoMethod r9 = EnterVideoMethod.OUTER_PUSH;
        L41:
            if (r16.f == false) goto L43;
            int r10 = 0;
        L44:
            or9.d r11 = new or9.d();
            r11.t = false;
            String r12 = AwemeVideoFeedDelegate.b.getSceneId();
            String r17 = "";
            if (r12 != null) goto L47;
            r12 = "";
        L47:
            Intrinsics.checkNotNullParameter(r12, "sceneID");
            r11.p = r12;
            r11.v = r10;
            r11.g = false;
            Long r18 = StringsKt.toLongOrNull(AccountService.a.getUserId());
            if (r18 == null) goto L50;
            long r19 = r18.longValue();
        L51:
            r11.q = r19;
            r11.w = 0;
            JSONObject r20 = new JSONObject();
            LaunchInfo r21 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
            if (r21 == null) goto L57;
            String r22 = r21.W();
            if (r22 == null) goto L57;
            r17 = r22;
        L57:
            r20.put("host_bot_id", r17);
            r20.put("host_recommend_type", "AwemeFeed");
            Intrinsics.checkNotNullParameter(r20, "trackParams");
            r11.o = r20;
            Intrinsics.checkNotNullParameter(r9, "enterVideoMethod");
            r11.a = r9;
            r11.k = false;
            r11.j = true;
            if (r3 != 0) goto L60;
        L62:
            if (r2 == false) goto L64;
            Intrinsics.checkNotNullParameter(r3, "itemIDList");
            r11.b = r3;
        L64:
            h r23 = r6.i(r11.a());
            r16.g = r23;
            if (r23 == null) goto L67;
            r23.xQ(new d(r16));
        L67:
            h r24 = r16.g;
            if (r24 == null) goto L71;
            Fragment r25 = r24.f();
            if (r25 == null) goto L71;
        L72:
            FragmentTransaction r110 = r16.getChildFragmentManager().beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r25, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L76;
            r110 = r110.replace(2131373275, r25);
        L76:
            r110.commitAllowingStateLoss();
            return Unit.INSTANCE;
        L71:
            r25 = new Fragment();
            goto L72
        L60:
            if ((!((Collection) r3).isEmpty()) != true) goto L62;
            r2 = true;
            goto L62
        L50:
            r19 = -1;
            goto L51
        L43:
            r10 = u.b(r16.requireActivity());
            goto L44
        L39:
            r9 = EnterVideoMethod.MAIN_DOUBLE_TAG;
            goto L41
        L35:
            r8 = null;
            goto L37
        L30:
            r3 = 0;
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            Bundle r111 = this.this$0.getArguments();
            if (r111 == null) goto L11;
            String r112 = r111.getString("argument_video_enter_item_id");
        L12:
            if (r112 != null) goto L14;
        L17:
            boolean r26 = true;
        L18:
            if (r26 == false) goto L31;
            RecommendVideoApi r113 = RecommendVideoApi.a;
            SortScene r27 = SortScene.InnerStream;
            this.label = 1;
            r13 = r113.c(r27, this);
            if (r13 != r0) goto L22;
            return r0;
        L31:
            r3 = CollectionsKt.listOf(r112);
            goto L32
        L14:
            if (r112.length() == 0) goto L17;
            r26 = false;
            goto L18
        L11:
            r112 = null;
            goto L12
        }
    }

    @Override // ci8.c
    public final void SL() {
    }

    public DouYinWrapperFragment() {
        this.e = true;
        this.h = 1;
        this.l = new a(this);
        this.m = new b(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        S90("system_back_button");
        AppHost.a.a().c(this.l);
        VideoFeedProviderDelegate.b.g(this.m);
        com.larus.bmhome.video.e.d("AwemeFeed");
    }

    public final void onPause() {
        super.onPause();
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        u.e(requireActivity(), true, r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        if (this.f == true) goto L9;
        LarusDouyinWrapperFragmentLayoutBinding r0 = this.d;
        if (r0 == null) goto L9;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        r1.post(new c(this));
    L9:
        u.e(requireActivity(), false, false);
    }

    @Override // ci8.c
    public final void LY(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveMethod");
        this.j = false;
        S90(r2);
    }

    public final void S90(String r9) {
        Intrinsics.checkNotNullParameter(r9, "leaveMethod");
        if (this.k > 0) goto L5;
        return;
    L5:
        IAwemeDoublePostService r0 = (IAwemeDoublePostService) ServiceManager.get().getService(IAwemeDoublePostService.class);
        if (r0 == null) goto L8;
        r0.b();
        com.larus.bmhome.double_post.utils.e.a.b(r9, System.currentTimeMillis() - this.k, Integer.valueOf(this.h));
    L8:
        this.k = 0;
    }

    @Override // ci8.c
    public final void jv(String r5) {
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        this.j = true;
        this.k = System.currentTimeMillis();
        if (this.i == true) goto L5;
        RecommendVideoApi r0 = RecommendVideoApi.a;
        RecommendVideoApi.a();
        this.i = true;
    L5:
        a1.d(null, "chat_video_tab", "chat", "bot_feeds", 49);
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        boolean r11 = r10.getBoolean("argument_is_show_bottom_tab");
    L6:
        this.f = r11;
        if (r11 == false) goto L23;
        LarusDouyinWrapperFragmentLayoutBinding r12 = this.d;
        if (r12 == null) goto L13;
        View r13 = r12.d;
        if (r13 == null) goto L13;
        r13.setVisibility(8);
    L13:
        LarusDouyinWrapperFragmentLayoutBinding r14 = this.d;
        if (r14 == null) goto L18;
        LinearLayout r15 = r14.f;
        if (r15 == null) goto L18;
        r15.setVisibility(8);
    L18:
        LarusDouyinWrapperFragmentLayoutBinding r16 = this.d;
        if (r16 == null) goto L49;
        View r17 = r16.c;
        if (r17 == null) goto L49;
        r17.setVisibility(8);
    L49:
        if (this.f == true) goto L55;
        LarusDouyinWrapperFragmentLayoutBinding r18 = this.d;
        if (r18 == null) goto L55;
        LinearLayout r19 = r18.a;
        if (r19 == null) goto L55;
        r19.post(new c(this));
    L55:
        AppHost.a.a().j(this.l);
        VideoFeedProviderDelegate.b.e(this.m);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L23:
        LarusDouyinWrapperFragmentLayoutBinding r20 = this.d;
        if (r20 == null) goto L28;
        LinearLayout r21 = r20.f;
        if (r21 == null) goto L28;
        r21.setVisibility(0);
    L28:
        LarusDouyinWrapperFragmentLayoutBinding r22 = this.d;
        if (r22 == null) goto L33;
        View r23 = r22.d;
        if (r23 == null) goto L33;
        r23.setVisibility(0);
    L33:
        LarusDouyinWrapperFragmentLayoutBinding r24 = this.d;
        if (r24 == null) goto L38;
        View r25 = r24.d;
        if (r25 == null) goto L38;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
    L39:
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) r26;
        LarusDouyinWrapperFragmentLayoutBinding r28 = this.d;
        if (r28 == null) goto L42;
        View r29 = r28.d;
    L43:
        Intrinsics.checkNotNull(r29);
        Context r30 = r29.getContext();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type android.app.Activity");
        r27.height = i.e((Activity) r30);
        LarusDouyinWrapperFragmentLayoutBinding r31 = this.d;
        if (r31 == null) goto L46;
        View r32 = r31.d;
    L47:
        Intrinsics.checkNotNull(r32);
        r32.setLayoutParams(r27);
        goto L49
    L46:
        r32 = null;
        goto L47
    L42:
        r29 = null;
    L38:
        r26 = null;
        goto L39
    L5:
        r11 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562320, r10, false);
        int r13 = 2131373275;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373275);
        if (r2 == null) goto L20;
        r13 = 2131374506;
        View r3 = ViewBindings.findChildViewById(r12, 2131374506);
        if (r3 == null) goto L20;
        r13 = 2131374507;
        View r4 = ViewBindings.findChildViewById(r12, 2131374507);
        if (r4 == null) goto L20;
        r13 = 2131374806;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, 2131374806);
        if (r5 == null) goto L20;
        r13 = 2131377668;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131377668);
        if (r6 == null) goto L20;
        r13 = 2131388523;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131388523);
        if (r7 == null) goto L20;
        LinearLayout r14 = (LinearLayout) r12;
        this.d = new LarusDouyinWrapperFragmentLayoutBinding(r14, r2, r3, r4, r5, r6, r7);
        if (r14 != null) goto L21;
        return null;
    L21:
        return g.a(r14);
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}

package com.larus.chat.job.impl.component;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.a0;
import com.larus.bmhome.b0;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.chat.job.impl.page.ChatJobListAdapter;
import com.larus.chat.job.impl.page.ChatJobListViewModel;
import com.larus.chat.job.impl.page.e0;
import com.larus.chat.job.impl.page.edit.ChatJobEditFragment;
import com.larus.chat.job.impl.page.edit.c0;
import com.larus.chat.job.impl.page.f0;
import com.larus.chat.job.impl.page.g0;
import com.larus.im.bean.job.AIJob;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017H\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010*\u001a\u00020+2\u0006\u00103\u001a\u000204H\u0002J \u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0018\u00108\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010&2\u0006\u00106\u001a\u00020\u0005H\u0002J\u001a\u0010:\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010;\u001a\u00020(H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010)\u001a\u00020\u0017H\u0002J\u0010\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010A\u001a\u00020\u00172\u0006\u0010?\u001a\u00020@2\u0006\u0010B\u001a\u00020&H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020HH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/chat/job/impl/component/ChatJobListComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "adapter", "Lcom/larus/chat/job/impl/page/ChatJobListAdapter;", "viewModel", "Lcom/larus/chat/job/impl/page/ChatJobListViewModel;", "screenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "loadMoreScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "loadingView", "Landroid/view/View;", "failureView", "emptyView", "onViewCreated", "", "view", "onDestroy", "observe", "hostFragment", "Landroidx/fragment/app/Fragment;", "render", "state", "Lcom/larus/chat/job/impl/page/ChatJobListUiState;", "maybeLoadMoreLocalJobs", "reason", "", "showJobMenu", "", "anchor", "job", "Lcom/larus/im/bean/job/AIJob;", "index", "hideInputSurfacesBeforeMenu", "resolveMenuStart", "menu", "buildMenuItems", "", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "context", "Landroid/content/Context;", "handleMenuClick", "id", "handleTaskClick", "openConversation", "menuClickFrom", "openEditPage", "readOnly", "captureAnchor", "Landroid/graphics/Bitmap;", "createFailureView", "parent", "Landroid/view/ViewGroup;", "createMessageView", ShareType.TEXT, "createMessageTextView", "Landroid/widget/TextView;", "fullLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "fullViewGroupLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobListComponent extends BaseContentWidget {
    public static final /* synthetic */ int w = 0;
    public int m;
    public ChatJobListAdapter n;
    public ChatJobListViewModel o;
    public x0 p;
    public SwipeRefreshLayout q;
    public RecyclerView r;
    public ChatJobListComponent$onViewCreated$scrollListener$1 s;
    public View t;
    public View u;
    public View v;

    public static final class a {
        public a() {
        }

        public static final String a(AIJob r3) {
            int r0 = ChatJobListComponent.w;
            StringBuilder r1 = new StringBuilder("id=");
            String r2 = StringsKt.takeLast(r3.getJobId(), 6);
            if (StringsKt.isBlank(r2) == false) goto L5;
            r2 = "blank";
        L5:
            r1.append(r2);
            r1.append(",type=");
            r1.append(r3.getJobType());
            r1.append(",status=");
            r1.append(r3.getStatus());
            return r1.toString();
        }
    }

    static {
        new a();
    }

    public final void onDestroy() {
        x0 r0 = this.p;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.p = null;
        SwipeRefreshLayout r1 = this.q;
        if (r1 == null) goto L8;
        r1.setOnRefreshListener(null);
    L8:
        ChatJobListComponent$onViewCreated$scrollListener$1 r2 = this.s;
        if (r2 == null) goto L13;
        RecyclerView r3 = this.r;
        if (r3 == null) goto L13;
        r3.removeOnScrollListener(r2);
    L13:
        this.s = null;
        RecyclerView r4 = this.r;
        if (r4 == null) goto L16;
        r4.setAdapter(null);
    L16:
        this.n = null;
        this.q = null;
        this.r = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.o = null;
    }

    public ChatJobListComponent() {
        this.m = 2131377227;
    }

    public final int U2() {
        return this.m;
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    public final void h3(AIJob r6) {
        String r0 = r6.getConversationId();
        if (r0 != null) goto L5;
    L16:
        FLogger.a.e("ChatJobListComponent", "openConversation skipped: conversationId is null or blank job=" + a.a(r6));
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L16;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r0, "conversationId");
        a0 r7 = b0.a(r1);
        if (r7 == null) goto L14;
        r7.J90(1, null, r0, "chat_conversation");
    L14:
        com.bytedance.router.i r8 = SmartRouter.buildRoute(r1.requireContext(), "//flow/chat_page");
        Bundle r2 = new Bundle();
        r2.putString("argConversationId", r0);
        r2.putBoolean("is_create_sub_conversation", true);
        r2.putInt("argBotConversationType", 3);
        r2.putString("enter_method", "cron_job");
        r2.putString("enter_from", "chat_job");
        r2.putString("argPreviousPage", "chat_job");
        r8.c.putExtras(r2);
        r8.d();
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.chat.job.impl.component.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.chat.job.impl.component.ChatJobListComponent$onViewCreated$scrollListener$1] */
    public final void onViewCreated(View r17) {
        Intrinsics.checkNotNullParameter(r17, "view");
        if ((r17 instanceof FrameLayout) == false) goto L5;
        FrameLayout r1 = (FrameLayout) r17;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.removeAllViews();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        this.o = (ChatJobListViewModel) new ViewModelProvider(r2).get(ChatJobListViewModel.class);
        x0 r4 = new x0();
        r4.d(r2);
        this.p = r4;
        ChatJobListComponent$onViewCreated$listAdapter$1 r5 = new ChatJobListComponent$onViewCreated$listAdapter$1(this);
        ez8.a r7 = ez8.a.a;
        ChatJobListAdapter r6 = new ChatJobListAdapter(r5, new ChatJobListComponent$onViewCreated$listAdapter$2(r7), new ChatJobListComponent$onViewCreated$listAdapter$3(this), new ChatJobListComponent$onViewCreated$listAdapter$4(r7));
        this.n = r6;
        RecyclerView r8 = new RecyclerView(r1.getContext());
        r8.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        e0 r9 = r6.e;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        int r10 = 0;
        r8.setItemViewCacheSize(0);
        f0 r11 = new f0(r9);
        r8.setRecycledViewPool(r11);
        r11.setMaxRecycledViews(2, 5);
        r8.setAdapter(r6);
        r8.setOverScrollMode(2);
        r8.setClipToPadding(false);
        r8.setPadding(0, i5.r0(), 0, i5.h());
        ?? r12 = new ChatJobListComponent$onViewCreated$scrollListener$1(this);
        this.s = r12;
        r8.addOnScrollListener(r12);
        this.r = r8;
        final SwipeRefreshLayout r13 = new SwipeRefreshLayout(r1.getContext());
        int r14 = 1;
        int r15 = gz8.g.a;
        Context r16 = r13.getContext();
        Intrinsics.checkNotNullParameter(r16, "context");
        r13.setColorSchemeColors(new int[]{v19.c.a(2130972123, r16, 2131103203)});
        r13.setOnRefreshListener(new g(this, r13));
        r13.addView(r8, new ViewGroup.LayoutParams(-1, -1));
        this.q = r13;
        int r18 = fz8.j.a;
        Context r19 = r1.getContext();
        Intrinsics.checkNotNullParameter(r19, "context");
        LinearLayout r20 = new LinearLayout(r19);
        r20.setOrientation(1);
        r20.setPadding(0, i5.h(), 0, 0);
        int r21 = 0;
    L10:
        if (r21 >= 4) goto L15;
        LinearLayout r110 = new LinearLayout(r19);
        r110.setOrientation(r14);
        r110.setPadding(i5.q(), i5.q(), i5.q(), i5.q());
        GradientDrawable r3 = gz8.g.a(r19);
        int r111 = i5.b();
        Intrinsics.checkNotNullParameter(r19, "context");
        r3.setStroke(r111, v19.c.a(2130972087, r19, 2131103162));
        r110.setBackground(r3);
        fz8.j.a r22 = new fz8.j.a(r19);
        int r23 = fz8.j.a;
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(i5.r(), i5.A());
        r112.topMargin = r10;
        r110.addView(r22, r112);
        fz8.j.a r24 = new fz8.j.a(r19);
        int r25 = i5.K();
        int r113 = i5.q();
        int r114 = i5.h();
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(r25, r113);
        r26.topMargin = r114;
        r110.addView(r24, r26);
        fz8.j.a r27 = new fz8.j.a(r19);
        int r28 = i5.d();
        int r29 = i5.q();
        int r115 = i5.h();
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(r28, r29);
        r116.topMargin = r115;
        r110.addView(r27, r116);
        View r30 = new View(r19);
        Intrinsics.checkNotNullParameter(r19, "context");
        r30.setBackgroundColor(v19.c.a(2130972087, r19, 2131103162));
        LinearLayout.LayoutParams r31 = new LinearLayout.LayoutParams(-1, i5.b());
        r31.topMargin = i5.h();
        Unit r32 = Unit.INSTANCE;
        r110.addView(r30, r31);
        fz8.j.a r33 = new fz8.j.a(r19);
        int r34 = i5.Z();
        int r35 = i5.q();
        int r117 = i5.h();
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(r34, r35);
        r118.topMargin = r117;
        r110.addView(r33, r118);
        LinearLayout.LayoutParams r36 = new LinearLayout.LayoutParams(-1, -2);
        r36.leftMargin = i5.q();
        r36.rightMargin = i5.q();
        if (r21 <= 0) goto L14;
        r36.topMargin = i5.h();
    L14:
        r20.addView(r110, r36);
        r21 = r21 + 1;
        r10 = 0;
        r14 = 1;
        goto L10
    L15:
        this.t = r20;
        int r37 = fz8.h.a;
        Context r38 = r1.getContext();
        final ?? r39 = new i(this);
        Intrinsics.checkNotNullParameter(r38, "context");
        Intrinsics.checkNotNullParameter(r39, "onRetry");
        LinearLayout r40 = new LinearLayout(r38);
        r40.setOrientation(1);
        r40.setGravity(17);
        View r41 = new AppCompatImageView(r38);
        r41.setImageResource(2131240031);
        r40.addView(r41, new LinearLayout.LayoutParams(i5.Z(), i5.Z()));
        TextView r42 = new TextView(r38);
        r42.setGravity(17);
        r42.setIncludeFontPadding(false);
        r42.setTextColor(gz8.g.b(r38));
        r42.setTextSize(17.0f);
        int r119 = Build.VERSION.SDK_INT;
        if (r119 < 28) goto L18;
        Typeface r120 = Typeface.create(Typeface.DEFAULT, 600, false);
        Intrinsics.checkNotNull(r120);
    L19:
        r42.setTypeface(r120);
        r42.setText(gz8.f.b("scheduledTasks_taskPage_desc_loadFail"));
        LinearLayout.LayoutParams r43 = new LinearLayout.LayoutParams(-2, -2);
        r43.topMargin = i5.A();
        Unit r121 = Unit.INSTANCE;
        r40.addView(r42, r43);
        TextView r44 = new TextView(r38);
        r44.setGravity(17);
        r44.setIncludeFontPadding(false);
        r44.setBackgroundResource(2131240030);
        Intrinsics.checkNotNullParameter(r38, "context");
        r44.setTextColor(v19.c.a(2130972312, r38, 2131103298));
        r44.setTextSize(16.0f);
        if (r119 < 28) goto L22;
        Typeface r45 = Typeface.create(Typeface.DEFAULT, 600, false);
        Intrinsics.checkNotNull(r45);
    L23:
        r44.setTypeface(r45);
        r44.setText(gz8.f.b("button_retry"));
        e1.d(r44, new fz8.f(r39));
        LinearLayout.LayoutParams r46 = new LinearLayout.LayoutParams(i5.i(), i5.c0());
        r46.topMargin = i5.m();
        r40.addView(r44, r46);
        this.u = r40;
        String r47 = gz8.f.b("scheduledTasks_desc_emptyState");
        Context r48 = r1.getContext();
        TextView r49 = new TextView(r48);
        r49.setGravity(17);
        r49.setTextColor(gz8.g.c(r48));
        r49.setTextSize(15.0f);
        r49.setText(r47);
        this.v = r49;
        r1.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        r1.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
        r1.addView(this.u, new FrameLayout.LayoutParams(-1, -1));
        r1.addView(this.v, new FrameLayout.LayoutParams(-1, -1));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner()), null, null, new ChatJobListComponent$observe$1(r2, this, null), 3, null);
        return;
    L22:
        r45 = Typeface.create(Typeface.DEFAULT, 1);
        Intrinsics.checkNotNull(r45);
        goto L23
    L18:
        Typeface r50 = Typeface.create(Typeface.DEFAULT, 1);
        Intrinsics.checkNotNull(r50);
        r120 = r50;
        goto L19
    L5:
        r1 = null;
        goto L6
    }

    public final void Y2(RecyclerView r4, String r5) {
        if (r4.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        int r1 = r4.computeVerticalScrollExtent();
        if (r1 > 0) goto L12;
        return;
    L12:
        if (((r4.computeVerticalScrollRange() - r4.computeVerticalScrollOffset()) - r1) > (r1 * 1)) goto L17;
        ChatJobListViewModel r6 = this.o;
        if (r6 == null) goto L18;
        r6.loadMoreLocalJobs(r5);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void m3(AIJob r7, boolean r8) {
        if (g0.c(r7) == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).requireActivity().getSupportFragmentManager();
        if (r1.findFragmentByTag("ChatJobEditFragment") == null) goto L8;
        return;
    L8:
        FragmentTransaction r2 = r1.beginTransaction();
        ChatJobEditFragment r3 = new ChatJobEditFragment();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r4 = new Bundle(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments());
        r4.putString("chat_job_id", r7.getJobId());
        c0.a(r4, r7);
        if (r8 == true) goto L11;
    L13:
        boolean r9 = false;
    L14:
        r4.putBoolean("chat_job_edit_read_only", r9);
        r4.putBoolean("chat_job_edit_open_conversation_after_run", true);
        r3.setArguments(r4);
        Unit r10 = Unit.INSTANCE;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ChatJobEditFragment", R.id.content) == true) goto L18;
        r2 = r2.add(R.id.content, r3, "ChatJobEditFragment");
    L18:
        r2.addToBackStack("ChatJobEditFragment").commitAllowingStateLoss();
        return;
    L11:
        if (r7.getJobType() != 3) goto L13;
        r9 = true;
        goto L14
    }
}

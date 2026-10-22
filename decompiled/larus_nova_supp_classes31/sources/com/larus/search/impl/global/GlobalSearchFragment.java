package com.larus.search.impl.global;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
import com.larus.chat.search.common.view.SearchHistoryItemView;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.service.z;
import com.larus.paging.k0;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.trace.tracknode.a$a;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import tx9.e1;
import tx9.i3;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0003*-3\u0018\u0000 f2\u00020\u0001:\u0001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010?\u001a\u0002062\u0006\u0010@\u001a\u000208H\u0016J\u0012\u0010A\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0002J\u000f\u0010E\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u000206H\u0002J\u001a\u0010H\u001a\u0002062\u0006\u0010I\u001a\u00020:2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010J\u001a\u000206H\u0016J\b\u0010K\u001a\u000206H\u0016J\b\u0010L\u001a\u000206H\u0002J\b\u0010M\u001a\u000206H\u0002J\b\u0010N\u001a\u000206H\u0016J\f\u0010Q\u001a\u000206*\u00020\u0005H\u0002J\b\u0010R\u001a\u000206H\u0002J\u0010\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020\u0011H\u0002J\b\u0010V\u001a\u000206H\u0002J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020\u0018H\u0002J\u0012\u0010Y\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010DH\u0002J\u0010\u0010[\u001a\u0002062\u0006\u0010Z\u001a\u00020DH\u0002J\u0010\u0010\\\u001a\u0002062\u0006\u0010Z\u001a\u00020DH\u0002J\u0010\u0010]\u001a\u0002062\u0006\u0010Z\u001a\u00020DH\u0002J \u0010^\u001a\u0002062\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010a\u001a\u00020\u0007H\u0016J\b\u0010b\u001a\u00020\u0011H\u0016J\u0010\u0010c\u001a\u0002062\u0006\u0010d\u001a\u00020eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/business/search/impl/databinding/LarusFragmentGlobalSearchBinding;", "hasSetupDataSource", "", "model", "Lcom/larus/search/impl/global/GlobalSearchViewModel;", "getModel", "()Lcom/larus/search/impl/global/GlobalSearchViewModel;", "model$delegate", "Lkotlin/Lazy;", "globalSearchResultAdapter", "Lcom/larus/search/impl/global/GlobalSearchResultAdapter;", "keyword", "", "keywordId", "lastKeyword", "openFromChatList", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "imePadding", "", "decorViewRect", "Landroid/graphics/Rect;", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "searchHistoryRepo", "Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "observeBotChangeJob", "Lkotlinx/coroutines/Job;", "botStatusObserver", "com/larus/search/impl/global/GlobalSearchFragment$botStatusObserver$1", "Lcom/larus/search/impl/global/GlobalSearchFragment$botStatusObserver$1;", "botUpdateListener", "com/larus/search/impl/global/GlobalSearchFragment$botUpdateListener$1", "Lcom/larus/search/impl/global/GlobalSearchFragment$botUpdateListener$1;", "autoSearch", "searchResultStartTime", "", "eventHelper", "com/larus/search/impl/global/GlobalSearchFragment$eventHelper$1", "Lcom/larus/search/impl/global/GlobalSearchFragment$eventHelper$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewStateRestored", "observeBotChange", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "setImeHeightListener", "()Lkotlin/Unit;", "resetPadding", "onViewCreated", "view", "onResume", "onPause", "registerAccountBlockListAdd", "initEvent", "onDestroyView", "loadStatus", "Lcom/larus/paging/LoadState;", "setupRetryView", "startCreateBot", "setDataSource", "enterMethod", "getQuery", "loadSearchHistory", "reportItemShow", "index", "getChatType", "data", "reportBotAdd", "reportBotRemove", "reportConfirmUnfollowBot", "reportStayTime", "query", "queryId", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GlobalSearchFragment extends TraceFragment {
    public static final /* synthetic */ int y = 0;
    public LarusFragmentGlobalSearchBinding e;
    public final Lazy f;
    public final GlobalSearchResultAdapter g;
    public String h;
    public String i;
    public String j;
    public boolean k;
    public final et3.c l;
    public int m;
    public final Rect n;
    public final Lazy o;
    public final hz8.a p;
    public final Lazy q;
    public Job r;
    public final b s;
    public final GlobalSearchFragment$botUpdateListener$1 t;
    public boolean u;
    public long v;
    public final GlobalSearchFragment$eventHelper$1 w;
    public com.larus.paging.u x;

    public static final class a {
    }

    public static final class b implements z<List<? extends wc9.e>> {
        public final /* synthetic */ GlobalSearchFragment a;

        public b(GlobalSearchFragment r1) {
            this.a = r1;
        }

        public final void c(Object r5) {
            List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
            wc9.e r7 = (wc9.e) CollectionsKt.getOrNull(r6, 0);
            if (r7 == null) goto L13;
            Integer r0 = r7.f;
            if (r0 != null) goto L9;
        L11:
            LifecycleOwnerKt.getLifecycleScope(this.a).launchWhenResumed(new GlobalSearchFragment$botStatusObserver$1$onChange$1(r7, this.a, null));
            return;
        L9:
            if (r0.intValue() != 1) goto L11;
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final void W90() {
        LarusFragmentGlobalSearchBinding r0 = this.e;
        if (r0 == null) goto L7;
        LinearLayout r1 = r0.f;
        if (r1 == null) goto L7;
        r1.removeAllViews();
    L7:
        LarusFragmentGlobalSearchBinding r2 = this.e;
        if (r2 == null) goto L12;
        ScrollView r3 = r2.e;
        if (r3 == null) goto L12;
        r3.setVisibility(0);
    L12:
        LarusFragmentGlobalSearchBinding r4 = this.e;
        if (r4 == null) goto L17;
        RecyclerView r5 = r4.g;
        if (r5 == null) goto L17;
        r5.setVisibility(8);
    L17:
        LarusFragmentGlobalSearchBinding r6 = this.e;
        if (r6 == null) goto L22;
        LoadingWithRetryView r7 = r6.b;
        if (r7 == null) goto L22;
        r7.setVisibility(8);
    L22:
        Context r8 = getContext();
        if (r8 != null) goto L25;
        return;
    L25:
        Iterator r9 = ((ArrayList) this.p.d).iterator();
    L27:
        if (r9.hasNext() == false) goto L34;
        final String r10 = (String) r9.next();
        View r11 = new SearchHistoryItemView(r8, null);
        r11.a(r10);
        r11.setOnItemClickListener(new com.larus.search.impl.global.a(this, r10));
        r11.setOnRemoveClickListener(new g(this, r10));
        LarusFragmentGlobalSearchBinding r12 = this.e;
        if (r12 == null) goto L27;
        LinearLayout r13 = r12.f;
        if (r13 == null) goto L27;
        r13.addView(r11);
        goto L27
    L34:
        if ((!((ArrayList) this.p.d).isEmpty()) == true) goto L36;
        return;
    L36:
        if (((ArrayList) this.p.d).size() <= 2) goto L51;
        LarusFragmentGlobalSearchBinding r14 = this.e;
        if (r14 == null) goto L52;
        LinearLayout r15 = r14.f;
        if (r15 == null) goto L53;
        TextView r16 = new TextView(getContext());
        r16.setText(r16.getContext().getText(2131909137));
        r16.setTextSize(1, 14.0f);
        r16.setTextColor(ContextCompat.getColor(r16.getContext(), 2131103143));
        r16.setGravity(17);
        r16.setOnClickListener(new h(this));
        r15.addView(r16, new LinearLayout.LayoutParams(-1, i5.d0()));
        return;
    L53:
        return;
    L52:
        return;
    }

    public final String k() {
        if (this.k == false) goto L5;
        return "chat_list_discover_search";
    L5:
        return "bot_list_discover_search";
    }

    public GlobalSearchFragment() {
        final Function0<Fragment> r0 = new GlobalSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GlobalSearchViewModel.class), new GlobalSearchFragment$special$$inlined$viewModels$default$2(r0), new GlobalSearchFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = new GlobalSearchResultAdapter();
        this.h = "";
        this.j = "";
        this.l = new et3.c("List_GlobalSearch", false, null);
        this.n = new Rect();
        this.o = LazyKt.lazy(new m());
        this.p = new hz8.a("key_search_history", 10);
        this.q = LazyKt.lazy(new n());
        this.s = new b(this);
        this.t = new GlobalSearchFragment$botUpdateListener$1(this);
        this.w = new GlobalSearchFragment$eventHelper$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        ((com.larus.im.service.q) this.o.getValue()).unRegisterConversationChangeListener(this.s);
        com.larus.im.service.o r0 = (com.larus.im.service.o) this.q.getValue();
        GlobalSearchFragment$botUpdateListener$1 r1 = this.t;
        r0.unregisterBotChangeListener(r1.a, r1);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        LarusFragmentGlobalSearchBinding r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L9;
        RecyclerView r2 = r0.g;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (this.g.getItemCount() <= 0) goto L15;
        X90(this.h, this.i);
        return;
    }

    public final void onResume() {
        super.onResume();
        LarusFragmentGlobalSearchBinding r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L20;
        RelativeLayout r2 = r0.a;
        if (r2.isAttachedToWindow() == false) goto L19;
        WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r2);
        if (r3 == null) goto L11;
        Insets r4 = r3.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r4 == null) goto L11;
        int r5 = r4.bottom;
    L12:
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets(r2);
        if (r6 == null) goto L17;
        Insets r7 = r6.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r7 == null) goto L17;
        int r8 = r7.top;
    L18:
        int r9 = r2.getPaddingStart();
        int r10 = r2.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r2.getClass().getSimpleName() + ",source:resetPadding,start:" + r9 + ",top:" + r8 + ",end:" + r10 + ",bottom:" + r5);
        r2.setPaddingRelative(r9, r8, r10, r5);
    L17:
        r8 = 0;
    L11:
        r5 = 0;
        goto L12
    L19:
        r2.addOnAttachStateChangeListener(new s(r2));
    L20:
        LarusFragmentGlobalSearchBinding r11 = this.e;
        if (r11 == null) goto L27;
        RecyclerView r12 = r11.g;
        if (r12 == null) goto L27;
        if (r12.getVisibility() != 0) goto L27;
        r1 = true;
    L27:
        if (r1 == true) goto L29;
        return;
    L29:
        if (this.g.getItemCount() <= 0) goto L33;
        this.v = SystemClock.elapsedRealtime();
        return;
    }

    public final String V90(RecommendBot r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        Integer r1 = r5.r();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L22:
        if (r1 != null) goto L25;
    L27:
        return "other_default";
    L25:
        if (r1.intValue() != 4) goto L27;
        return "notice";
    L14:
        if (r1.intValue() != 0) goto L22;
        BotCreatorInfo r6 = r5.j();
        if (r6 == null) goto L19;
        r0 = r6.getId();
    L19:
        if (Intrinsics.areEqual(r0, AccountService.a.getUserId()) == false) goto L21;
        return "self_created";
    L21:
        return "others_created";
    L9:
        if (r1.intValue() != 1) goto L11;
        return "default";
    L5:
        r1 = null;
        goto L6
    }

    public final void Y90(String r6) {
        if (this.h.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(this.h) == true) goto L36;
        LarusFragmentGlobalSearchBinding r1 = this.e;
        if (r1 == null) goto L15;
        RecyclerView r2 = r1.g;
        if (r2 == null) goto L15;
        y6.i(r2);
    L15:
        LarusFragmentGlobalSearchBinding r3 = this.e;
        int r4 = 8;
        if (r3 == null) goto L20;
        ScrollView r5 = r3.e;
        if (r5 == null) goto L20;
        r5.setVisibility(8);
    L20:
        LarusFragmentGlobalSearchBinding r7 = this.e;
        if (r7 == null) goto L28;
        LoadingWithRetryView r8 = r7.b;
        if (r8 == null) goto L28;
        if (Intrinsics.areEqual(this.x, com.larus.paging.u.b.b) == false) goto L27;
        r4 = 0;
    L27:
        r8.setVisibility(r4);
    L28:
        LarusFragmentGlobalSearchBinding r9 = this.e;
        if (r9 == null) goto L33;
        RecyclerView r10 = r9.g;
        if (r10 == null) goto L33;
        r10.setVisibility(0);
    L33:
        LiveData<k0<ws9.c>> r11 = ((GlobalSearchViewModel) this.f.getValue()).getSearchResultPager(this.h, r6, new WeakReference(this));
        Function1 r12 = new i(this);
        r11.observe(getViewLifecycleOwner(), new c(r12));
        return;
    L36:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        a$a.a(this, r3);
        r3.putIfNull("query", this.h);
        r3.putIfNull("query_id", this.i);
        r3.putIfNull("function_type", "bot_search");
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        boolean r0 = false;
        if (r4 == null) goto L5;
        boolean r5 = r4.getBoolean("key_open_from_chat_list", false);
    L6:
        this.k = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L10;
        String r7 = r6.getString("query");
        if (r7 == null) goto L10;
    L11:
        this.h = r7;
        if (r7.length() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        this.u = true;
        return;
    L17:
        return;
    L10:
        r7 = "";
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        LarusFragmentGlobalSearchBinding r0 = this.e;
        if (r0 == null) goto L7;
        SearchBar r1 = r0.c;
        if (r1 == null) goto L7;
        boolean r2 = ViewExtKt.h(r1);
    L8:
        r3.putBoolean("show_ime", r2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onViewStateRestored(Bundle r3) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(r3);
        boolean r0 = false;
        if (r3 != null) goto L5;
    L7:
        if (r0 == false) goto L14;
        LarusFragmentGlobalSearchBinding r4 = this.e;
        if (r4 == null) goto L15;
        SearchBar r5 = r4.c;
        if (r5 == null) goto L16;
        r5.b();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r3.getBoolean("show_ime") != true) goto L7;
        r0 = true;
        goto L7
    }

    public static final void U90(GlobalSearchFragment r18, RecommendBot r19) {
        r18.getClass();
        String r1 = r19.o();
        String r14 = r19.o();
        String r7 = r18.V90(r19);
        SearchMobParam r2 = r19.b;
        if (r2 == null) goto L5;
        String r10 = r2.c;
    L6:
        if (r2 == null) goto L8;
        String r11 = r2.d;
    L9:
        if (r2 == null) goto L11;
        String r12 = r2.e;
    L12:
        if (r2 == null) goto L14;
        String r16 = r2.f;
    L15:
        e1.a(r1, r7, null, null, "click_plus", null, null, r16, null, null, r10, r11, r12, "private", r14, r19.I0("").a(null), r18, 292793);
        return;
    L14:
        r16 = null;
        goto L15
    L11:
        r12 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    public final void X90(String r12, String r13) {
        if (this.v != 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.v;
        ws9.c r4 = this.g.B2(0);
        if (r4 == null) goto L14;
        ws9.b r5 = r4.b;
        if (r5 == null) goto L14;
        RecommendBot r6 = r5.a();
        if (r6 == null) goto L14;
        SearchMobParam r7 = r6.b;
        if (r7 == null) goto L14;
        String r8 = r7.c;
    L15:
        Long r9 = Long.valueOf(r0);
        i3.g(r9, r12, r13, r8, this, 433);
        this.v = 0;
        return;
    L14:
        r8 = null;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.search.impl.global.j] */
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        Ref.BooleanRef r1 = new Ref.BooleanRef();
        r1.element = true;
        final LarusFragmentGlobalSearchBinding r2 = this.e;
        if (r2 == null) goto L12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GlobalSearchFragment$onViewCreated$1$1(r2, this, r1, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GlobalSearchFragment$onViewCreated$1$2(r2, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GlobalSearchFragment$onViewCreated$1$3(this, null), 3, null);
        GlobalSearchResultAdapter r3 = this.g;
        r3.c = this.w;
        r2.g.setItemAnimator(null);
        r2.g.setLayoutManager(new LinearLayoutManager(getContext()));
        LarusFragmentGlobalSearchBinding r4 = this.e;
        if (r4 == null) goto L9;
        RecyclerView r5 = r4.g;
        if (r5 == null) goto L9;
        r5.setAdapter(this.g.A2(new GlobalSearchLoadStateAdapter(new j(this))));
    L9:
        r2.g.addOnScrollListener(new GlobalSearchFragment$onViewCreated$1$5(r2, this));
        y6.f(r2.g, new k(this), null, 0.1f, new l(this), 53);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GlobalSearchFragment$setupRetryView$1(this, r2, null), 3, null);
        r2.b.a();
        r2.b.setOnRetryListener(new com.larus.search.impl.global.b(this));
        e10 r6 = e10.a;
        if (e10.i() == false) goto L12;
        r2.b.setTipsAction(new com.larus.search.impl.global.c(this));
    L12:
        LarusFragmentGlobalSearchBinding r7 = this.e;
        if (r7 != null) goto L15;
    L34:
        W90();
        LarusFragmentGlobalSearchBinding r8 = this.e;
        if (r8 == null) goto L39;
        SearchBar r9 = r8.c;
        if (r9 == null) goto L39;
        r9.b();
    L39:
        AccountService.a.A().observe(getViewLifecycleOwner(), new c(new o(this)));
        ((com.larus.im.service.q) this.o.getValue()).registerConversationChangeListener(this.s);
        if (this.u == false) goto L47;
        String r10 = this.h;
        this.u = false;
        this.h = "";
        LarusFragmentGlobalSearchBinding r11 = this.e;
        if (r11 == null) goto L48;
        SearchBar r12 = r11.c;
        if (r12 == null) goto L49;
        r12.setText(r10);
        ViewExtKt.g(r12);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L15:
        if (Build.VERSION.SDK_INT >= 30) goto L32;
        final FragmentActivity r13 = getActivity();
        if (r13 == null) goto L33;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L33;
        final View r15 = r14.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L26;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r16 = ThreadMethodProxy.currentThread();
        if (r16 == com.larus.home.impl.utils.c.a) goto L26;
        com.larus.home.impl.utils.c.a(r16, "getDecorView");
    L26:
        if (r15 == null) goto L33;
        View r17 = r15.findViewById(R.id.content);
        if (r17 == null) goto L33;
        r17.getViewTreeObserver().addOnGlobalLayoutListener(new d(r15, this, r13));
    L33:
        Unit r18 = Unit.INSTANCE;
        goto L34
    L32:
        ViewExtKt.a(r7.a, new e(this));
        goto L33
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562397, r10, false);
        int r13 = 2131379091;
        LoadingWithRetryView r2 = ViewBindings.findChildViewById(r12, 2131379091);
        if (r2 == null) goto L20;
        r13 = 2131385326;
        SearchBar r3 = ViewBindings.findChildViewById(r12, 2131385326);
        if (r3 == null) goto L20;
        r13 = 2131385338;
        View r4 = ViewBindings.findChildViewById(r12, 2131385338);
        if (r4 == null) goto L20;
        r13 = 2131385501;
        ScrollView r5 = (ScrollView) ViewBindings.findChildViewById(r12, 2131385501);
        if (r5 == null) goto L20;
        r13 = 2131385502;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131385502);
        if (r6 == null) goto L20;
        r13 = 2131385573;
        RecyclerView r7 = ViewBindings.findChildViewById(r12, 2131385573);
        if (r7 == null) goto L20;
        RelativeLayout r14 = (RelativeLayout) r12;
        this.e = new LarusFragmentGlobalSearchBinding(r14, r2, r3, r4, r5, r6, r7);
        if (r14 == null) goto L17;
        r14.setTag(2131377847, this);
        return r14;
    L17:
        return null;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}

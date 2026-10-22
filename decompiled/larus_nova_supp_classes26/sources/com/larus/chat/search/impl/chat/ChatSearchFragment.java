package com.larus.chat.search.impl.chat;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.common.view.SearchHistoryItemView;
import com.larus.chat.search.impl.chat.section.SectionListAdapter;
import com.larus.chat.search.impl.databinding.LarusFragmentChatSearchBinding;
import com.larus.common_ui.paging.FPListAdapter;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ic8.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import tx9.i3;
import tx9.x3;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001L\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u0002:\u0002\u0091\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010=\u001a\u00020\u00072\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016JB\u0010?\u001a\u00020\u000728\u0010>\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tH\u0016J\b\u0010N\u001a\u00020\u0007H\u0002J<\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020<2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010W\u001a\u00020\u00072\b\u0010X\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020[H\u0002J\u0018\u0010\\\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010]\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020[2\u0006\u0010^\u001a\u00020\nH\u0002J\u0012\u0010_\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010a\u001a\u0004\u0018\u00010:2\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u000eH\u0016J\u0012\u0010h\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\u000f\u0010i\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0007H\u0002J\u001a\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020:2\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\u001a\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020:2\b\u0010`\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010s\u001a\u00020\u0007H\u0016J\b\u0010t\u001a\u00020\u0007H\u0016J\b\u0010u\u001a\u00020\u0007H\u0016J\u0010\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\nH\u0002J\b\u0010z\u001a\u00020\nH\u0002J\u001c\u0010{\u001a\u00020\u00072\b\b\u0002\u0010|\u001a\u00020\u00102\b\b\u0002\u0010}\u001a\u00020\u0010H\u0002J\u0011\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020DH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0010H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J#\u0010\u008a\u0001\u001a\u00020\u00072\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0010H\u0016J\t\u0010\u008e\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020\u00072\u0007\u0010Z\u001a\u00030\u0090\u0001H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0018\u001a\u0004\bH\u0010IR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/chat/search/api/IChatSearchFragment;", "<init>", "()V", "customCloseAction", "Lkotlin/Function0;", "", "customNavigateAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "route", "Landroid/os/Bundle;", "bundle", "", "binding", "Lcom/larus/chat/search/impl/databinding/LarusFragmentChatSearchBinding;", "model", "Lcom/larus/chat/search/impl/chat/ChatSearchViewModel;", "getModel", "()Lcom/larus/chat/search/impl/chat/ChatSearchViewModel;", "model$delegate", "Lkotlin/Lazy;", "sectionModel", "Lcom/larus/chat/search/impl/chat/ChatSectionViewModel;", "getSectionModel", "()Lcom/larus/chat/search/impl/chat/ChatSectionViewModel;", "sectionModel$delegate", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "globalSearchResultAdapter", "Lcom/larus/chat/search/impl/chat/ChatSearchResultAdapter;", "keyword", "keywordId", "lastKeyword", "canSectionRename", "searchInCvsId", "botId", "chatType", "chatPassThroughParams", "Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "getChatPassThroughParams", "()Lcom/larus/bmhome/chat/bean/ChatPassThroughParams;", "enableSmallWindowTopInsetAdaptation", "getEnableSmallWindowTopInsetAdaptation", "()Z", "imePadding", "", "decorViewRect", "Landroid/graphics/Rect;", "smallWindowPaddingAdaptationRoot", "Landroid/view/View;", "searchResultStartTime", "", "setCloseAction", "action", "setNavigateAction", "sectionListAdapter", "Lcom/larus/chat/search/impl/chat/section/SectionListAdapter;", "currentItemList", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "skipNextSectionResumeRefresh", "searchHistoryRepo", "Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "getSearchHistoryRepo", "()Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "searchHistoryRepo$delegate", "conversationListObserver", "com/larus/chat/search/impl/chat/ChatSearchFragment$conversationListObserver$1", "Lcom/larus/chat/search/impl/chat/ChatSearchFragment$conversationListObserver$1;", "tryHideSoftKeyboard", "openChat", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "localIndex", "messageId", "searchHighlightKeyword", "openSubConversation", "conversationId", "switchConversation", "params", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "openRoute", "getCommonBundle", "pageName", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewStateRestored", "setImeHeightListener", "()Lkotlin/Unit;", "resetPadding", "root", "insets", "Landroidx/core/view/WindowInsetsCompat;", "setupSmallWindowPaddingAdaptation", "clearSmallWindowPaddingAdaptation", "onViewCreated", "view", "onResume", "onPause", "onDestroyView", "loadStatus", "Lcom/larus/paging/LoadState;", "setDataSource", "enterMethod", "getQuery", "updateLoadingView", "showLoading", "showEmpty", "recordClickHistory", "loadHistoryOrSectionList", "init", "clickSearchSection", "data", "clickSubConversation", "loadSectionList", "refreshSectionConversationsOnResume", "loadSearchHistory", "reportItemShow", "index", "reportSectionItemShow", "reportStayTime", "query", "queryId", "autoLogEnterPage", "getCurrentPageName", "fillTrackParams", "Lcom/ixigua/lib/track/TrackParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSearchFragment extends TraceFragment {
    public static final /* synthetic */ int A = 0;
    public LarusFragmentChatSearchBinding e;
    public final Lazy f;
    public final Lazy g;
    public final et3.c h;
    public final Lazy i;
    public final ChatSearchResultAdapter j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public int q;
    public final Rect r;
    public View s;
    public long t;
    public SectionListAdapter u;
    public final List<SectionItemData> v;
    public boolean w;
    public final Lazy x;
    public final b y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.z<List<? extends wc9.e>> {
        public final /* synthetic */ ChatSearchFragment a;

        public b(ChatSearchFragment r1) {
            this.a = r1;
        }

        public final void c(Object r23) {
            List r1 = (List) r23;
            Intrinsics.checkNotNullParameter(r1, "conversation");
            List<SectionItemData> r2 = this.a.v;
            if (r2 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == true) goto L43;
            Iterator r4 = ((ArrayList) this.a.v).iterator();
        L12:
            String r5 = null;
            if (r4.hasNext() == false) goto L21;
            Object r6 = r4.next();
            String r7 = ((SectionItemData) r6).getConversationId();
            wc9.e r8 = (wc9.e) CollectionsKt.getOrNull(r1, 0);
            if (r8 == null) goto L17;
            String r9 = r8.a;
        L19:
            if (Intrinsics.areEqual(r7, r9) == false) goto L12;
        L22:
            SectionItemData r10 = (SectionItemData) r6;
            if (r10 == null) goto L41;
            String r11 = r10.getSectionName();
            wc9.e r12 = (wc9.e) CollectionsKt.getOrNull(r1, 0);
            if (r12 == null) goto L27;
            String r13 = r12.c;
        L29:
            if (Intrinsics.areEqual(r11, r13) == true) goto L44;
            int r14 = ((ArrayList) this.a.v).indexOf(r10);
            ((ArrayList) this.a.v).remove(r10);
            List<SectionItemData> r15 = this.a.v;
            wc9.e r16 = (wc9.e) CollectionsKt.getOrNull(r1, 0);
            if (r16 == null) goto L34;
            r5 = r16.c;
        L34:
            ListProtector.add(r15, r14, SectionItemData.copy$default(r10, 0, null, null, r5, 0, 0, null, false, null, 0, null, 2039, null));
            ChatSearchFragment r17 = this.a;
            SectionListAdapter r18 = r17.u;
            if (r18 == null) goto L42;
            r18.submitList(r17.v);
            return;
        L42:
            return;
        L44:
            return;
        L27:
            r13 = null;
            goto L29
        L41:
            return;
        L17:
            r9 = null;
            goto L19
        L21:
            r6 = null;
            goto L22
        L43:
            return;
        L5:
            if (((ArrayList) r2).isEmpty() == true) goto L8;
            r3 = false;
            goto L9
        }
    }

    public static final class c implements z {
        public final /* synthetic */ ChatSearchFragment a;

        @Override // com.larus.chat.search.impl.chat.z
        public final void j() {
            ChatSearchFragment r0 = this.a;
            int r1 = ChatSearchFragment.A;
            r0.ga0();
            this.a.X90().loadConversation(this.a.k, false);
        }

        @Override // com.larus.chat.search.impl.chat.z
        public final void k() {
            ChatSearchFragment r0 = this.a;
            int r1 = ChatSearchFragment.A;
            r0.X90().loadMessage(this.a.k, false);
        }

        public c(ChatSearchFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.chat.search.impl.chat.z
        public final void l(t r25) {
            Intrinsics.checkNotNullParameter(r25, "result");
            wc9.e r4 = r25.c;
            BotModel r5 = r25.d;
            long r6 = r25.j;
            ChatSearchFragment r2 = this.a;
            int r3 = ChatSearchFragment.A;
            r2.Y90().a(this.a.k);
            this.a.ga0();
            String r10 = null;
            if (r25.getType() != 1) goto L5;
            String r8 = r25.a;
        L7:
            if (r25.getType() != 1) goto L9;
            String r9 = r25.n;
        L10:
            this.a.ca0(r4, r5, r6, r8, r9);
            String r12 = IAIChatService.a.U7(r25.c);
            if (r25.getType() != 0) goto L13;
            String r7 = "chat";
        L14:
            String r18 = r7;
            Boolean r1 = r25.m;
            if (r1 != null) goto L18;
        L21:
            i3.e(null, r12, null, null, null, null, null, r18, r10, null, null, this.a, 29693);
            return;
        L18:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L20;
            r10 = "user";
            goto L21
        L20:
            r10 = "bot";
            goto L21
        L13:
            r7 = "chat_history";
            goto L14
        L9:
            r9 = null;
            goto L10
        L5:
            r8 = null;
            goto L7
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final void ba0() {
        this.w = false;
        LarusFragmentChatSearchBinding r1 = this.e;
        if (r1 == null) goto L7;
        RecyclerView r2 = r1.g;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        LarusFragmentChatSearchBinding r3 = this.e;
        if (r3 == null) goto L12;
        LinearLayout r4 = r3.e;
        if (r4 == null) goto L12;
        r4.removeAllViews();
    L12:
        LarusFragmentChatSearchBinding r5 = this.e;
        if (r5 == null) goto L17;
        ScrollView r6 = r5.d;
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        Context r0 = getContext();
        if (r0 != null) goto L20;
        return;
    L20:
        Iterator r7 = ((ArrayList) Y90().d).iterator();
    L22:
        if (r7.hasNext() == false) goto L29;
        final String r8 = (String) r7.next();
        SearchHistoryItemView r9 = new SearchHistoryItemView(r0, null);
        r9.a(r8);
        r9.setOnItemClickListener(new i(this, r8));
        r9.setOnRemoveClickListener(new j(this, r8));
        LarusFragmentChatSearchBinding r10 = this.e;
        if (r10 == null) goto L22;
        LinearLayout r11 = r10.e;
        if (r11 == null) goto L22;
        r11.addView(r9);
        goto L22
    L29:
        if ((!((ArrayList) Y90().d).isEmpty()) == true) goto L31;
        return;
    L31:
        if (((ArrayList) Y90().d).size() <= 2) goto L46;
        LarusFragmentChatSearchBinding r12 = this.e;
        if (r12 == null) goto L47;
        LinearLayout r13 = r12.e;
        if (r13 == null) goto L48;
        TextView r14 = new TextView(getContext());
        r14.setText(r14.getContext().getText(2131909137));
        r14.setTextSize(1, 14.0f);
        r14.setTextColor(ContextCompat.getColor(r14.getContext(), v19.c.b(2130972081, r14.getContext(), 2131103143)));
        r14.setGravity(17);
        r14.setOnClickListener(new k(this));
        r13.addView(r14, new LinearLayout.LayoutParams(-1, i5.d0()));
        return;
    L48:
        return;
    L47:
        return;
    }

    public final ChatSearchViewModel X90() {
        return (ChatSearchViewModel) this.f.getValue();
    }

    public final hz8.a Y90() {
        return (hz8.a) this.x.getValue();
    }

    public final ChatSectionViewModel Z90() {
        return (ChatSectionViewModel) this.g.getValue();
    }

    public final void ga0() {
        LarusFragmentChatSearchBinding r0 = this.e;
        if (r0 == null) goto L8;
        SearchBar r1 = r0.c;
        if (r1 == null) goto L9;
        ViewExtKt.g(r1);
        return;
    L9:
        return;
    }

    public final String k() {
        String r0 = this.n;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return "chat_list_search";
    L11:
        return "bot_setting_search";
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void onDestroyView() {
        View r0 = this.s;
        if (r0 == null) goto L5;
        ViewCompat.setOnApplyWindowInsetsListener(r0, null);
    L5:
        this.s = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ((com.larus.im.service.q) this.i.getValue()).unRegisterConversationChangeListener(this.y);
        this.e = null;
    }

    public ChatSearchFragment() {
        final Function0<Fragment> r0 = new ChatSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatSearchViewModel.class), new ChatSearchFragment$special$$inlined$viewModels$default$2(r0), new ChatSearchFragment$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new ChatSearchFragment$special$$inlined$viewModels$default$4(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ChatSectionViewModel.class), new ChatSearchFragment$special$$inlined$viewModels$default$5(r1), new ChatSearchFragment$special$$inlined$viewModels$default$6(r1, this));
        this.h = new et3.c("List_ChatSearch", false, null);
        this.i = LazyKt.lazy(new l());
        this.j = new ChatSearchResultAdapter(new c(this));
        this.k = "";
        this.r = new Rect();
        this.v = new ArrayList();
        this.x = LazyKt.lazy(new m(this));
        this.y = new b(this);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        LarusFragmentChatSearchBinding r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L9;
        RecyclerView r2 = r0.f;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (this.j.getItemCount() <= 0) goto L15;
        ea0(this.k, this.l);
        return;
    }

    public final void onResume() {
        super.onResume();
        LarusFragmentChatSearchBinding r0 = this.e;
        if (r0 == null) goto L8;
        RelativeLayout r1 = r0.a;
        if (r1.isAttachedToWindow() == false) goto L7;
        fa0(r1, ViewCompat.getRootWindowInsets(r1));
        goto L8
    L7:
        r1.addOnAttachStateChangeListener(new q(r1, this));
    L8:
        LarusFragmentChatSearchBinding r2 = this.e;
        if (r2 == null) goto L15;
        RecyclerView r3 = r2.f;
        if (r3 == null) goto L15;
        if (r3.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L21;
        if (this.j.getItemCount() <= 0) goto L21;
        this.t = SystemClock.elapsedRealtime();
    L21:
        if (this.u != null) goto L24;
        return;
    L24:
        if (this.w == false) goto L26;
        this.w = false;
        return;
    L26:
        ChatSectionViewModel.refreshCurrentConversations$default(Z90(), "onResume", false, 2, null);
        return;
    L15:
        r4 = false;
        goto L16
    }

    public static final void U90(ChatSearchFragment r6) {
        r6.X90().updateKeyWord(r6.k);
        if (r6.k.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r6.k) == true) goto L41;
        LarusFragmentChatSearchBinding r1 = r6.e;
        if (r1 == null) goto L15;
        RecyclerView r2 = r1.f;
        if (r2 == null) goto L15;
        y6.i(r2);
    L15:
        LarusFragmentChatSearchBinding r3 = r6.e;
        int r4 = 8;
        if (r3 == null) goto L20;
        ScrollView r5 = r3.d;
        if (r5 == null) goto L20;
        r5.setVisibility(8);
    L20:
        LarusFragmentChatSearchBinding r7 = r6.e;
        if (r7 == null) goto L25;
        RecyclerView r8 = r7.g;
        if (r8 == null) goto L25;
        r8.setVisibility(8);
    L25:
        LarusFragmentChatSearchBinding r9 = r6.e;
        if (r9 == null) goto L33;
        LoadingWithRetryView r10 = r9.b;
        if (r10 == null) goto L33;
        if (Intrinsics.areEqual(null, com.larus.paging.u.b.b) == false) goto L32;
        r4 = 0;
    L32:
        r10.setVisibility(r4);
    L33:
        LarusFragmentChatSearchBinding r11 = r6.e;
        if (r11 == null) goto L38;
        RecyclerView r12 = r11.f;
        if (r12 == null) goto L38;
        r12.setVisibility(0);
    L38:
        ChatSearchResultAdapter r13 = r6.j;
        r13.b = 0;
        r13.submitList(CollectionsKt.emptyList());
        r13.notifyDataSetChanged();
        r6.X90().loadFirstPageData(r6.k, r6.n);
        ha0(r6, true, false, 2);
        return;
    L41:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.chat.search.impl.chat.a] */
    public final void aa0(boolean r9) {
        ChatSearchResultAdapter r0 = this.j;
        r0.b = 0;
        r0.submitList(CollectionsKt.emptyList());
        r0.notifyDataSetChanged();
        LarusFragmentChatSearchBinding r1 = this.e;
        if (r1 == null) goto L7;
        RecyclerView r2 = r1.f;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        LarusFragmentChatSearchBinding r3 = this.e;
        if (r3 == null) goto L12;
        LoadingWithRetryView r4 = r3.b;
        if (r4 == null) goto L12;
        r4.setVisibility(8);
    L12:
        z2 r5 = z2.a;
        r5.w3();
        r5.w3();
        if (o0.d(this.n) == true) goto L15;
    L32:
        ba0();
        return;
    L15:
        if (this.m == false) goto L32;
        if (r9 == false) goto L22;
        this.w = true;
        ChatSectionViewModel r10 = Z90();
        String r6 = this.n;
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        r10.loadFirstData(r6);
    L22:
        LarusFragmentChatSearchBinding r11 = this.e;
        if (r11 == null) goto L27;
        ScrollView r12 = r11.d;
        if (r12 == null) goto L27;
        r12.setVisibility(8);
    L27:
        LarusFragmentChatSearchBinding r13 = this.e;
        if (r13 == null) goto L34;
        RecyclerView r7 = r13.g;
        if (r7 == null) goto L35;
        SectionListAdapter r14 = new SectionListAdapter(new FPListAdapter.a(new com.larus.chat.search.impl.chat.a(this)), new p(this));
        this.u = r14;
        r7.setVisibility(0);
        r7.setItemAnimator(null);
        r7.setAdapter(r14);
        r7.setLayoutManager(new LinearLayoutManager(getContext()));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new ChatSearchFragment$loadSectionList$1$1(this, r14, null));
        r7.addOnScrollListener(new ChatSearchFragment$loadSectionList$1$2(this));
        y6.d(r7, new g(this), null, null, new h(this), 13);
        return;
    L35:
        return;
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        com.larus.trace.tracknode.a.a.a(this, r3);
        r3.putIfNull("query", this.k);
        r3.putIfNull("query_id", this.l);
        r3.putIfNull("function_type", "chat_search");
        if (o0.d(this.o) == false) goto L6;
        r3.putIfNull("bot_id", this.o);
    L6:
        if (o0.d(this.p) == false) goto L9;
        r3.putIfNull("chat_type", this.p);
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getString("key.search.in.conv.id");
    L6:
        this.n = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        boolean r7 = r6.getBoolean("key.search.in.can.section.rename");
    L10:
        this.m = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L13;
        String r9 = r8.getString("key.search.bot.id");
    L14:
        this.o = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L17;
        r0 = r10.getString("key.search.chat.type");
    L17:
        this.p = r0;
        return;
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        LarusFragmentChatSearchBinding r0 = this.e;
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
        LarusFragmentChatSearchBinding r4 = this.e;
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

    public static final void V90(ChatSearchFragment r5, ni8.e r6) {
        String r0 = r5.k();
        if (r6.e == true) goto L5;
    L31:
        Integer r1 = r6.l;
        if (r1 != null) goto L35;
    L37:
        x3.a("conversation_click", "chat_search_blocked", "conversation_type=" + r6.l);
        return;
    L35:
        if (r1.intValue() != 3) goto L37;
        Bundle r7 = r5.W90(r6, r0);
        by7.h.k(r7, r5);
        r5.da0("//flow/chat_page", r7);
        return;
    L5:
        if (AccountService.a.a() == true) goto L31;
        int r3 = 0;
        if (l0.a(r6.m) == false) goto L26;
        Bundle r2 = r5.W90(r6, r0);
        ArrayList<Integer> r4 = new ArrayList();
        ConversationPage r8 = r6.h;
        if (r8 == null) goto L13;
        List r9 = r8.getPageList();
        if (r9 == null) goto L13;
    L14:
        r4.addAll(r9);
        Unit r10 = Unit.INSTANCE;
        r2.putIntegerArrayList("argument_multi_tab_list", r4);
        ConversationPage r11 = r6.h;
        if (r11 == null) goto L19;
        Integer r12 = r11.getDefaultStatus();
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
    L20:
        r2.putInt("argument_multi_tab_default_tab", r13);
        ConversationPage r14 = r6.h;
        if (r14 == null) goto L25;
        Integer r15 = r14.getPagePosition();
        if (r15 == null) goto L25;
        r3 = r15.intValue();
    L25:
        r2.putInt("argument_multi_tab_title_style", r3);
        by7.h.k(r2, r5);
        r5.da0("//flow/chat_multi_tab", r2);
        return;
    L19:
        r13 = PageType.Chat.getType();
    L13:
        r9 = CollectionsKt.emptyList();
        goto L14
    L26:
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r0), TuplesKt.to("argConversationId", r6.a), TuplesKt.to("argClickEnterFrom", r6.k), TuplesKt.to("argBotId", r6.j), TuplesKt.to("argBotType", r6.n), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r6.i)), TuplesKt.to("conversation_page", r6.h), TuplesKt.to("default_tab", Integer.valueOf(r6.g)), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r6.o)), TuplesKt.to("target_middle_msg_id", r6.q), TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r6.q), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r6.r), TuplesKt.to("search_highlight_keyword", r6.s)});
        Bundle r17 = r5.getArguments();
        if (r17 == null) goto L29;
        ChatPassThroughParams r18 = ic8.k.a(r17);
    L30:
        ic8.k.b(r16, r18);
        by7.h.k(r16, r5);
        r5.da0("//flow/chat_page_double_tab", r16);
        return;
    L29:
        r18 = null;
        goto L30
    }

    public final Bundle W90(ni8.e r4, String r5) {
        Boolean r6 = Boolean.TRUE;
        Bundle r7 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r5), TuplesKt.to("argConversationId", r4.a), TuplesKt.to("argBotId", r4.j), TuplesKt.to("argBotType", r4.n), TuplesKt.to("argClickEnterFrom", r4.k), TuplesKt.to("argCvsBgImgUrl", r4.b), TuplesKt.to("argCvsBgImgColor", r4.c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r4.d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r4.i)), TuplesKt.to("enter_method", "search_result_click"), TuplesKt.to("enter_from", "search_result_click"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r4.o)), TuplesKt.to("target_middle_msg_id", r4.q), TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r4.q), TuplesKt.to("is_single_mode", r6), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r4.r), TuplesKt.to("search_highlight_keyword", r4.s), TuplesKt.to("argBotConversationType", Integer.valueOf(r4.v)), TuplesKt.to("arg_is_from_search", r6)});
        Bundle r8 = getArguments();
        if (r8 == null) goto L5;
        ChatPassThroughParams r9 = ic8.k.a(r8);
    L6:
        ic8.k.b(r7, r9);
        return r7;
    L5:
        r9 = null;
        goto L6
    }

    public final void da0(String r2, Bundle r3) {
        com.bytedance.router.i r4 = SmartRouter.buildRoute(getContext(), r2);
        r4.c.putExtras(r3);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
    }

    public final void ea0(String r11, String r12) {
        if (this.t != 0) goto L5;
        return;
    L5:
        i3.g(Long.valueOf(SystemClock.elapsedRealtime() - this.t), r11, r12, null, this, 497);
        this.t = 0;
    }

    public final void fa0(View r7, WindowInsetsCompat r8) {
        int r0 = 0;
        if (r8 == null) goto L7;
        Insets r1 = r8.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r1 == null) goto L7;
        int r2 = r1.bottom;
    L8:
        Bundle r3 = getArguments();
        boolean r4 = true;
        if (r3 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        Bundle r6 = getArguments();
        if (r6 != null) goto L17;
    L19:
        r4 = false;
    L20:
        if (r5 == false) goto L23;
        if (r4 == false) goto L23;
    L27:
        int r9 = r7.getPaddingStart();
        int r10 = r7.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r7.getClass().getSimpleName() + ",source:resetPadding,start:" + r9 + ",top:" + r0 + ",end:" + r10 + ",bottom:" + r2);
        r7.setPaddingRelative(r9, r0, r10, r2);
        return;
    L23:
        if (r8 == null) goto L27;
        Insets r11 = r8.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r11 == null) goto L27;
        r0 = r11.top;
        goto L27
    L17:
        if (r6.getBoolean("disable_top_padding", false) != true) goto L19;
    L11:
        if (r3.getBoolean("argIsHalfScreen", false) != true) goto L13;
        r5 = true;
    L7:
        r2 = 0;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.chat.search.impl.chat.n] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        X90().getSearchResultLv().observe(getViewLifecycleOwner(), new s.a(new n(this)));
        final LarusFragmentChatSearchBinding r13 = this.e;
        Boolean r14 = null;
        if (r13 == null) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatSearchFragment$onViewCreated$2$1(r13, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ChatSearchFragment$onViewCreated$2$2(r13, this, null), 3, null);
        r13.f.setItemAnimator(null);
        r13.f.setLayoutManager(new LinearLayoutManager(getContext()));
        LarusFragmentChatSearchBinding r0 = this.e;
        if (r0 == null) goto L9;
        RecyclerView r1 = r0.f;
        if (r1 == null) goto L9;
        r1.setAdapter(this.j);
    L9:
        r13.f.addOnScrollListener(new ChatSearchFragment$onViewCreated$2$3(r13, this));
        y6.d(r13.f, new o(this), null, null, new com.larus.chat.search.impl.chat.b(this), 13);
        r13.b.a();
    L10:
        Bundle r15 = getArguments();
        boolean r2 = false;
        if (r15 == null) goto L17;
        Intrinsics.checkNotNullParameter(r15, "<this>");
        ChatPassThroughParams r16 = ic8.k.a(r15);
        if (r16 == null) goto L15;
        r14 = Boolean.valueOf(r16.getEnableSmallWindowTopInsetAdaptation());
    L15:
        if (r14 == null) goto L17;
        boolean r17 = r14.booleanValue();
    L23:
        if (r17 == false) goto L34;
        LarusFragmentChatSearchBinding r18 = this.e;
        if (r18 == null) goto L34;
        RelativeLayout r19 = r18.a;
        if (r19 == null) goto L34;
        this.s = r19;
        ViewCompat.setOnApplyWindowInsetsListener(r19, new d(this));
        if (r19.isAttachedToWindow() == false) goto L33;
        ViewCompat.requestApplyInsets(r19);
        goto L34
    L33:
        r19.addOnAttachStateChangeListener(new r(r19));
    L34:
        LarusFragmentChatSearchBinding r110 = this.e;
        if (r110 != null) goto L37;
    L56:
        aa0(true);
        LarusFragmentChatSearchBinding r111 = this.e;
        if (r111 == null) goto L69;
        SearchBar r112 = r111.c;
        if (r112 == null) goto L69;
        String r113 = this.n;
        if (r113 != null) goto L63;
    L64:
        r2 = true;
    L65:
        if (r2 == false) goto L67;
        int r114 = 2131909105;
    L68:
        r112.setHint(getString(r114));
        z2.a.w3();
        r112.b();
        r112.setCustomCancelClickAction(new com.larus.chat.search.impl.chat.c(this));
        goto L69
    L67:
        r114 = 2131909108;
        goto L68
    L63:
        if (r113.length() != 0) goto L65;
    L69:
        ((com.larus.im.service.q) this.i.getValue()).registerConversationChangeListener(this.y);
        return;
    L37:
        if (Build.VERSION.SDK_INT >= 30) goto L54;
        final FragmentActivity r115 = getActivity();
        if (r115 == null) goto L55;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L55;
        final View r117 = r116.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L48;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L48;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L48:
        if (r117 == null) goto L55;
        View r4 = r117.findViewById(R.id.content);
        if (r4 == null) goto L55;
        r4.getViewTreeObserver().addOnGlobalLayoutListener(new e(r117, this, r115));
    L55:
        Unit r118 = Unit.INSTANCE;
        goto L56
    L54:
        ViewExtKt.a(r110.a, new f(this));
    L17:
        Bundle r119 = getArguments();
        if (r119 != null) goto L20;
    L22:
        r17 = false;
        goto L23
    L20:
        if (r119.getBoolean("enable_small_window_top_inset_adaptation", false) != true) goto L22;
        r17 = true;
        goto L23
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562354, r10, false);
        int r13 = 2131379091;
        LoadingWithRetryView r2 = ViewBindings.findChildViewById(r12, 2131379091);
        if (r2 == null) goto L20;
        r13 = 2131385326;
        SearchBar r3 = ViewBindings.findChildViewById(r12, 2131385326);
        if (r3 == null) goto L20;
        r13 = 2131385501;
        ScrollView r4 = (ScrollView) ViewBindings.findChildViewById(r12, 2131385501);
        if (r4 == null) goto L20;
        r13 = 2131385502;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131385502);
        if (r5 == null) goto L20;
        r13 = 2131385573;
        RecyclerView r6 = ViewBindings.findChildViewById(r12, 2131385573);
        if (r6 == null) goto L20;
        r13 = 2131385590;
        RecyclerView r7 = ViewBindings.findChildViewById(r12, 2131385590);
        if (r7 == null) goto L20;
        RelativeLayout r14 = (RelativeLayout) r12;
        this.e = new LarusFragmentChatSearchBinding(r14, r2, r3, r4, r5, r6, r7);
        if (r14 == null) goto L17;
        r14.setTag(2131377847, this);
        return r14;
    L17:
        return null;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    public static void ha0(ChatSearchFragment r2, boolean r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        LarusFragmentChatSearchBinding r6 = r2.e;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r3 == false) goto L13;
        r6.b.b();
        r6.d.setVisibility(8);
        r6.g.setVisibility(8);
        r6.f.setVisibility(8);
        return;
    L13:
        if (r4 == false) goto L15;
        r6.b.d(2131906532);
        r6.f.setVisibility(8);
        r6.d.setVisibility(8);
        r6.g.setVisibility(8);
        return;
    L15:
        r6.f.setVisibility(0);
        r6.b.setVisibility(8);
        r6.d.setVisibility(8);
        r6.g.setVisibility(8);
        r2.t = SystemClock.elapsedRealtime();
    }

    public final void ca0(wc9.e r16, BotModel r17, long r18, String r20, String r21) {
        if (r16 != null) goto L5;
        return;
    L5:
        ConversationPage r0 = r16.g;
        if (r0 == null) goto L8;
        List r1 = r0.getPageList();
    L9:
        boolean r4 = l0.b(r1);
        FLogger r2 = FLogger.a;
        r2.i("ChatSearchFragment", "name is >>> " + r16.c);
        r2.i("ChatSearchFragment", "botConversationType is >>> " + r16.v);
        r2.d("search_landing", "open chat from chat search conversationId=" + r16.a + ", messageId=" + r20 + ", localIndex=" + r18 + ", highlight=" + s.a(r21) + ", query=" + s.a(this.k) + ", isShowTab=" + r4);
        Integer r3 = r16.v;
        if (r3 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        r2.i("ChatSearchFragment", "current conversation is douyin");
        SmartRouter.buildRoute(getContext(), "//flow/douyin_bot").d();
        return;
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatSearchFragment$openChat$1(r16, r17, this, r4, r18, r20, r21, null), 3, null);
        return;
    L13:
        if (r3.intValue() != 4) goto L15;
        r5 = true;
        goto L16
    L8:
        r1 = null;
        goto L9
    }
}

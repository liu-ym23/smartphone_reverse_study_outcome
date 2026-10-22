package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.layout.LKUIRelativeLayout;
import com.larksuite.component.ui.layout.plus.PerMonitorRenderLKUIPlus;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.chatwindow.BottomSpaceItemDecoration;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.ChatAdapterV2;
import com.ss.android.lark.chat.chatwindow.chat.WallpaperAdaptionTimeLineDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.ChatImageErrDetector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.BannerSettingItemDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.FirstMessagePaddingDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.MessageListDecorationController;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.TopTipsDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.chat.BannerSetting;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.utils.j0;
import com.ss.android.lark.chat.utils.k0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListRendererFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a {
    public static boolean x;
    public static boolean y;
    public final t6b.k a;
    public final h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> b;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b c;
    public SceneCoordinateRecyclerView d;
    public LKUIPtrFrameLayout e;
    public LKUIRelativeLayout f;
    public boolean g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final ArrayList<RecyclerView.OnScrollListener> k;
    public com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> l;
    public final Lazy m;
    public boolean n;
    public d o;
    public MessageListDecorationController p;
    public final Lazy q;
    public MessageVisibleManager r;
    public MessageVisibleHintPointParams s;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.b t;
    public boolean u;
    public boolean v;
    public final Lazy w;

    public static final class a extends r<y6b.c<?>> {
        public final LKUIPtrFrameLayout a;
        public final Function0<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a> b;
        public final Function0<Integer> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(LKUIPtrFrameLayout r2, Function0<? extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a> r3, Function0<Integer> r4) {
            Intrinsics.checkNotNullParameter(r2, "prtFrame");
            Intrinsics.checkNotNullParameter(r3, "dataFeature");
            Intrinsics.checkNotNullParameter(r4, "itemCount");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.r, com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c
        public final void b(boolean r4, int r5, int r6) {
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) this.b.invoke();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.canLoadMore() == false) goto L12;
            if (r6 < (((Number) this.c.invoke()).intValue() - 5)) goto L12;
            if (z6b.a.a == true) goto L12;
            this.a.autoLoadMore();
        L12:
            if (r0.canLoadPre() == false) goto L20;
            if (r5 > 5) goto L21;
            if (r4 == true) goto L16;
            return;
        L16:
            if (z6b.a.a == true) goto L23;
            this.a.autoRefresh();
            return;
        L23:
            return;
        L21:
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends r<y6b.c<?>> {
        public final Function1<Long, Unit> a;
        public Long b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Long, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onFirstFrameShown");
            this.a = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.r, com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c
        public final void a(List<? extends y6b.c<?>> r3) {
            Intrinsics.checkNotNullParameter(r3, "itemList");
            if (this.b != null) goto L6;
            long r0 = System.currentTimeMillis();
            this.b = Long.valueOf(r0);
            this.a.invoke(Long.valueOf(r0));
            return;
        }
    }

    public static final class d implements Runnable {
        public Runnable a;

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.a;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.run();     // Catch: Throwable -> L7
        L5:
            this.a = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public d(MessageListScrollFeature.d r2) {
            Intrinsics.checkNotNullParameter(r2, "runnable");
            this.a = r2;
        }
    }

    public static final class e extends r<y6b.c<?>> {
        public final Function1<String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super String, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "onDetected");
            this.a = r2;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.r, com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c
        public final void a(List<? extends y6b.c<?>> r5) {
            Intrinsics.checkNotNullParameter(r5, "itemList");
            Iterator<T> r6 = r5.iterator();
        L3:
            Object r1 = null;
            BaseTextContentVO r2 = null;
            if (r6.hasNext() == false) goto L19;
            Object r0 = r6.next();
            T r3 = ((y6b.c) r0).o;
            if ((r3 instanceof BaseTextContentVO) == false) goto L8;
            r2 = (BaseTextContentVO) r3;
        L8:
            if (r2 == null) goto L16;
            RichText r4 = r2.g();
            if (r4 == null) goto L16;
            List r7 = r4.getAnchorIds();
            if (r7 == null) goto L16;
            boolean r8 = true;
            if ((!r7.isEmpty()) != true) goto L16;
        L17:
            if (r8 == false) goto L3;
            r1 = r0;
        L16:
            r8 = false;
        L19:
            y6b.c r9 = (y6b.c) r1;
            if (r9 == null) goto L28;
            this.a.invoke(r9.c);
            return;
        }
    }

    public static final class f {
        public f(MessageListRendererFeature r1) {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    static {
        x = true;
        y = true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final s2b.g C() {
        return (s2b.g) this.j.getValue();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a G() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a H() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    public final com.ss.android.lark.chat.chatwindow.chat.a I() {
        return (com.ss.android.lark.chat.chatwindow.chat.a) this.h.getValue();
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a J() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final d0 c() {
        return this.a.u();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> d() {
        return this.a.k();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final SceneCoordinateRecyclerView getRecyclerView() {
        SceneCoordinateRecyclerView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        return null;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final v4b.d j() {
        return this.a.j();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onDestroy() {
        com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> r0 = this.l;
        if (r0 == null) goto L5;
        r0.a.removeOnScrollListener((RecyclerView.OnScrollListener) r0.n.getValue());
        r0.b.unregisterAdapterDataObserver((RecyclerView.AdapterDataObserver) r0.o.getValue());
        r0.k.d();
        r0.l.post(new com.ss.android.lark.chat.chatwindow.chat.v2.widget.e(r0));
    L5:
        this.l = null;
        ((ChatImageErrDetector) this.m.getValue()).getClass();
        ChatImageErrDetector.c = null;
        ChatImageErrDetector.d = null;
        ((ConcurrentHashMap) ChatImageErrDetector.a).clear();
        ChatImageErrDetector.b.clear();
        this.r = null;
        x = false;
        y = false;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onStart() {
        MessageVisibleManager r0 = this.r;
        if (r0 == null) goto L6;
        r0.a(MessageVisibleManager.CalculateExposeTimeScene.ON_START);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onStop() {
        MessageVisibleManager r0 = this.r;
        if (r0 == null) goto L5;
        r0.a(MessageVisibleManager.CalculateExposeTimeScene.ON_STOP);
    L5:
        this.a.r();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = this.c;
        RecyclerView r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r1 = null;
    L8:
        IChatService r3 = r1.getContainer().j0();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r4 = G();
        if (r4 == null) goto L11;
        Chat r5 = r4.getCurrentChat();
    L12:
        RecyclerView r6 = this.d;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
    L16:
        f r7 = new f(this);
        int r8 = k0.a;
        Intrinsics.checkNotNullParameter(r3, "chatService");
        Intrinsics.checkNotNullParameter(r7, "messagePosInfo");
        if (r5 == null) goto L73;
        if (r2 == null) goto L74;
        String r9 = "n";
        if (com.ss.android.lark.chat.utils.k.c(r5) == Chat.MessagePosition.RECENT_LEFT) goto L24;
        ChatHitPoint r10 = ChatHitPoint.a;
        r10.getClass();
        r10.b().sendEvent("chat_exit", new JSONObject().put("save_progress", "n"));
        return;
    L24:
        i7b.b r11 = new i7b.b();
        LinearLayoutManager r12 = r2.getLayoutManager();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager r13 = r12;
        boolean r14 = true;
        int r15 = r13.findLastVisibleItemPosition();     // Catch: Exception -> L58
        if (r15 >= 0) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == false) goto L60;
        y6b.a r17 = (y6b.a) I().getItem(r15);     // Catch: Exception -> L58
        if (r17.A() == r5.getLastVisibleMessagePosition()) goto L60;
        if (r17.q() == r5.getLastMessagePositionBadgeCount()) goto L60;
        MessageFoldDetail r18 = r17.x();     // Catch: Exception -> L58
        if (r18 != null) goto L40;
    L42:
        boolean r19 = false;
    L43:
        if (r19 == true) goto L60;
        int r20 = r13.findFirstVisibleItemPosition();     // Catch: Exception -> L58
        if (r20 >= 0) goto L48;
    L50:
        boolean r110 = false;
    L51:
        if (r110 == false) goto L60;
        r11.a = ((y6b.a) I().getItem(r20)).A();     // Catch: Exception -> L58
        View r21 = r2.getChildAt(0);     // Catch: Exception -> L58
        if (r21 == null) goto L55;
        int r22 = r21.getTop();     // Catch: Exception -> L58
    L56:
        r11.b = r22;     // Catch: Exception -> L58
        goto L60
    L55:
        r22 = 0;
        goto L56
    L48:
        if (r20 >= I().getItemCount()) goto L50;
        r110 = true;
        goto L51
    L40:
        if (((int) r18.getLastMessagePosition()) != r5.getLastVisibleMessagePosition()) goto L42;
        r19 = true;
    L60:
        Log.i(TitlebarViewModel.LOG_TAG, "saveCurrentReadPositionIfNeed, currentPosition is:" + r11.a + ", topOffset is:" + r11.b);
        ChatHitPoint r23 = ChatHitPoint.a;
        if (r11.a != (-1)) goto L64;
        r14 = false;
    L64:
        r23.getClass();
        if (r14 == false) goto L68;
        r9 = "y";
    L68:
        r23.b().sendEvent("chat_exit", new JSONObject().put("save_progress", r9));
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new j0(r3, r5, r11));
        return;
    L28:
        if (r15 >= I().getItemCount()) goto L30;
        r16 = true;
    L58:
        e = move-exception;
        Log.e(TitlebarViewModel.LOG_TAG, "getCurrentReadPosition err", e);
        goto L60
    L74:
        return;
    L73:
        return;
    L15:
        r2 = r6;
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final Long q() {
        return ((c) this.w.getValue()).b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final List<y6b.c<?>> t() {
        RecyclerView r0 = this.d;     // Catch: NullPointerException -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");     // Catch: NullPointerException -> L7
        r0 = null;
    L5:
        LinearLayoutManager r1 = r0.getLayoutManager();     // Catch: NullPointerException -> L7
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");     // Catch: NullPointerException -> L7
        LinearLayoutManager r2 = r1;     // Catch: NullPointerException -> L7
        int r3 = r2.findFirstVisibleItemPosition();     // Catch: NullPointerException -> L7
        int r4 = r2.findLastVisibleItemPosition();     // Catch: NullPointerException -> L7
        return I().o1(r3, r4);
    L8:
        return new ArrayList();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final List<y6b.c<?>> w() {
        com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> r0 = this.l;
        if (r0 == null) goto L16;
        LinearLayoutManager r1 = r0.a.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L7;
        LinearLayoutManager r2 = r1;
        int r3 = r2.findFirstVisibleItemPosition();
        int r4 = r2.findLastVisibleItemPosition();
    L8:
        ArrayList r5 = new ArrayList();
        if (r3 > r4) goto L18;
    L10:
        y6b.c r6 = r0.c.getItem(r3);
        if (r6 == null) goto L13;
        r5.add(r6);
    L13:
        if (r3 == r4) goto L19;
        r3 = r3 + 1;
        goto L10
    L19:
        return r5;
    L18:
        return r5;
    L7:
        r3 = -1;
        r4 = -1;
        goto L8
    L16:
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final FirstMessagePaddingType z() {
        return this.a.f();
    }

    public final boolean K() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = G();
        BannerSetting r1 = null;
        if (r0 == null) goto L5;
        Chat r2 = r0.getCurrentChat();
    L7:
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        return false;
    L14:
        if (r2 == null) goto L16;
        r1 = r2.getBannerSetting();
    L16:
        if (r1 == null) goto L26;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r3 = G();
        if (r3 != null) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L26;
        Log.i("MessageListRendererFeature", "isRetentionFeatureOn: true.");
        return true;
    L20:
        if (r3.canLoadPre() == true) goto L22;
        r5 = true;
    L26:
        return false;
    L9:
        if (r2.isSecret() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final com.ss.android.lark.chat.chatwindow.chat.a getAdapter() {
        return I();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final boolean v() {
        return this.n;
    }

    public static final boolean F(MessageListRendererFeature r4) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = r4.c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        if (r0.getContainer().C().isEnable("im.paywall.notice") == true) goto L15;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = r4.c;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L12:
        if (r1.getContainer().C().isEnable("lark.security.offline_caching_policy") == true) goto L15;
        return false;
    L10:
        r1 = r5;
    L15:
        return true;
    }

    public static final boolean m(MessageListRendererFeature r6) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = r6.G();
        Integer r1 = null;
        if (r0 == null) goto L7;
        Chat r2 = r0.getCurrentChat();
        if (r2 == null) goto L7;
        BannerSetting r3 = r2.getBannerSetting();
    L8:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r4 = r6.G();
        if (r4 == null) goto L13;
        Chat r5 = r4.getCurrentChat();
        if (r5 == null) goto L13;
        int r7 = r5.getFirstMessagePosition();
    L14:
        if (r3 == null) goto L18;
        Integer r8 = r3.getChatMessagePosition();
        if (r8 == null) goto L18;
        int r9 = r8.intValue();
    L19:
        boolean r10 = true;
        if (r6.K() == false) goto L26;
        if (r9 >= r7) goto L23;
    L22:
        return false;
    L23:
        if (r9 != r7) goto L56;
        if (r7 == 0) goto L22;
        return true;
    L56:
        return true;
    L26:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r11 = r6.G();
        if (r11 == null) goto L29;
        int r12 = r11.Fe();
    L30:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r13 = r6.G();
        if (r13 == null) goto L33;
        r1 = Integer.valueOf(r13.Fe());
    L33:
        if (r1 == null) goto L52;
        if (r12 <= 0) goto L52;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r14 = r6.G();
        if (r14 != null) goto L38;
    L40:
        boolean r15 = false;
    L41:
        if (r15 == false) goto L52;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r16 = r6.G();
        if (r16 == null) goto L49;
        Chat r17 = r16.getCurrentChat();
        if (r17 == null) goto L49;
        if (r17.isSecret() == true) goto L49;
        boolean r18 = true;
    L50:
        if (r18 == false) goto L52;
    L53:
        Log.i("MessageListRendererFeature", "isExpireTimeFeatureOn: " + r10 + '.');
        return r10;
    L49:
        r18 = false;
        goto L50
    L38:
        if (r14.canLoadPre() == true) goto L40;
        r15 = true;
    L52:
        r10 = false;
        goto L53
    L29:
        r12 = 0;
    L18:
        r9 = r7;
    L13:
        r7 = -1;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.InterfaceC0063a
    public final void l(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p r4 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p) r3;
    L6:
        if (r4 == null) goto L14;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.e r0 = (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.e) this.q.getValue();
        PhotoItem r5 = r4.c;
        if (r5 == null) goto L11;
        String r6 = r5.getMessageId();
        if (r6 == null) goto L11;
    L12:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "msgId");
        r0.b = r6;
        return;
    L11:
        r6 = BuildConfig.FLAVOR;
        goto L12
    L14:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final void n(com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c<y6b.c<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> r0 = this.l;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a
    public final void s(MessageListScrollFeature.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.o = new d(r2);
    }

    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v9, types: [android.view.ViewGroup, com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView] */
    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r13) {
        Intrinsics.checkNotNullParameter(r13, "initData");
        Intrinsics.checkNotNullParameter(r13, "initData");
        com.ss.android.lark.chat.chatwindow.chat.a r14 = I();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L5:
        r14.s1(DevEnvUtil.isDebugMode(r0.getContext()));
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r15 = this.c;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r15 = null;
    L8:
        a4b.a r16 = (a4b.a) r15.b(a4b.a.class);
        if (r16 == null) goto L30;
        a4b.b r8 = r16.A();
        if (r8 == null) goto L30;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r17 = this.c;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r17 = null;
    L16:
        s2b.d r6 = r17.a();
        if (r6 == null) goto L29;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r7 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c(this, r6, r8);
        h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r3 = this.b;
        SceneCoordinateRecyclerView r18 = this.d;
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        SceneCoordinateRecyclerView r4 = null;
    L22:
        r3.g(r4, I(), r6, r7, r8, this.a.j(), this.a.i(), new MessageListRendererFeature$initAdapter$1$1(this));
        com.ss.android.lark.chat.chatwindow.chat.a r19 = I();
        if ((r19 instanceof ChatAdapterV2) == false) goto L25;
        ChatAdapterV2 r110 = (ChatAdapterV2) r19;
    L26:
        if (r110 == null) goto L30;
        com.ss.android.lark.blueprint.d r111 = r110.y2();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.d r5 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.d(this);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r5, "env");
        vza.d r112 = r111.c.c;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r5, "env");
        r112.a.put(r5.c(), r5);
        goto L30
    L25:
        r110 = null;
        goto L26
    L21:
        r4 = r18;
        goto L22
    L29:
        Log.e(TitlebarViewModel.LOG_TAG, "mMessageContext is null");
    L30:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r113 = G();
        if (r113 == null) goto L38;
        MutableLiveData r114 = r113.Da();
        if (r114 == null) goto L38;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r9 = this.c;
        if (r9 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r9 = null;
    L37:
        r114.observe(r9.getLifecycleOwner(), new m(this));
    L38:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r115 = G();
        if (r115 == null) goto L46;
        MutableLiveData r116 = r115.Kn();
        if (r116 == null) goto L46;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r10 = this.c;
        if (r10 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r10 = null;
    L45:
        r116.observe(r10.getLifecycleOwner(), new n(this));
    L46:
        SceneCoordinateRecyclerView r117 = this.d;
        ?? r118 = r117;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r118 = 0;
    L50:
        if (FirstMessagePaddingType.NONE == this.a.f()) goto L52;
        boolean r1 = true;
    L53:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r11 = this.c;
        if (r11 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r11 = null;
    L56:
        Context r12 = r11.getContext();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r20 = this.c;
        if (r20 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r20 = null;
    L59:
        BannerSettingItemDecoration r21 = new BannerSettingItemDecoration(r12, r20.getFragment(), r118, new q(this));
        MessageListDecorationController.a r2 = new MessageListDecorationController.a(r118.getContext(), r118);
        Intrinsics.checkNotNullParameter(r21, "updateDecoration");
        ((ArrayList) r2.c).add(r21);
        TopTipsDecoration r22 = new TopTipsDecoration(new o(this));
        Intrinsics.checkNotNullParameter(r22, "updateDecoration");
        ((ArrayList) r2.c).add(r22);
        FirstMessagePaddingDecoration r23 = new FirstMessagePaddingDecoration(new p(this));
        Intrinsics.checkNotNullParameter(r23, "updateDecoration");
        ((ArrayList) r2.c).add(r23);
        MessageListDecorationController r119 = new MessageListDecorationController(r2);
        this.p = r119;
        if (r1 == false) goto L78;
        Iterator r24 = ((ArrayList) r119.b).iterator();
    L64:
        if (r24.hasNext() == false) goto L71;
        RecyclerView.ItemDecoration r25 = (z3b.a) r24.next();
        if ((r25 instanceof RecyclerView.ItemDecoration) == false) goto L68;
        RecyclerView.ItemDecoration r26 = r25;
    L69:
        if (r26 == null) goto L64;
        r119.c.addItemDecoration(r26);
        goto L64
    L68:
        r26 = null;
        goto L69
    L71:
        r119.a(MessageListDecorationController.Scene.SCENE_INIT);
        return;
    L78:
        return;
    L52:
        r1 = false;
        goto L53
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r10) {
        Intrinsics.checkNotNullParameter(r10, "env");
        this.c = r10;
        View r11 = r10.getContentView();
        if (r11 != null) goto L6;
        Log.e("MessageListRendererFeature", "contentView is null");
        return;
    L6:
        CommonRecyclerView r2 = (SceneCoordinateRecyclerView) r11.findViewById(2131365561);
        this.d = r2;
        SceneCoordinateRecyclerView r4 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r2 = null;
    L9:
        r2.r(MapsKt.mapOf(new Pair[]{TuplesKt.to("biz", Integer.valueOf(Biz.Messenger.getValue())), TuplesKt.to("scene", Integer.valueOf(Scene.Chat.getValue()))}));
        this.e = r11.findViewById(2131365579);
        this.f = r11.findViewById(2131379996);
        this.g = true;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a r12 = J();
        if (r12 == null) goto L15;
        RecyclerView r3 = this.d;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r3 = null;
    L14:
        r12.D6(r3);
    L15:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r13 = H();
        if (r13 == null) goto L18;
        r13.k(this);
    L18:
        LKUIRelativeLayout r14 = this.f;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        r14 = null;
    L21:
        r14.registerPlus(PerMonitorRenderLKUIPlus.class).setMonitorCallback(new i());
        LKUIPtrFrameLayout r15 = this.e;
        if (r15 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r15 = null;
    L24:
        r15.setKeepHeaderWhenRefresh(true);
        LKUIPtrFrameLayout r16 = this.e;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r16 = null;
    L27:
        r16.setForceBackWhenComplete(true);
        LKUIPtrFrameLayout r17 = this.e;
        if (r17 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r17 = null;
    L30:
        r17.disableWhenHorizontalMove(true);
        LKUIPtrFrameLayout r18 = this.e;
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r18 = null;
    L33:
        r18.setEnableScrollContentAfterLoad(true);
        LKUIPtrFrameLayout r19 = this.e;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r19 = null;
    L36:
        r19.setPtrHandler(new MessageListRendererFeature$initPullToRefresh$1(this));
        SceneCoordinateRecyclerView r110 = this.d;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r110 = null;
    L39:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.c;
        if (r5 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L42:
        final Context r0 = r5.getContext();
        StableLinearLayoutManager r6 = new MessageListRendererFeature$initMessageList$1(r0);
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        Log.i("MessageListRendererFeature", "updateLayoutManager called");
        if (r6.getOrientation() != 1) goto L77;
        r6.setRecycleChildrenOnDetach(true);
        r6.setStackFromEnd(false);
        RecyclerView r1 = this.d;
        if (r1 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r1 = null;
    L47:
        r1.setLayoutManager(r6);
        this.b.f(r110, new MessageListRendererFeature$initMessageList$2(this));
        r110.setTouchViewListener(new g(this));
        if (this.a.e() == true) goto L51;
        zdc.h.b(r110);
    L51:
        if (this.a.d() == true) goto L53;
        r110.addItemDecoration(new WallpaperAdaptionTimeLineDecoration(I(), this.a.t(), new h(this)));
    L53:
        r110.addItemDecoration(new BottomSpaceItemDecoration(new MessageListRendererFeature$initMessageList$5(this)));
        Iterator<T> r7 = this.a.g().iterator();
    L55:
        if (r7.hasNext() == false) goto L57;
        r110.addItemDecoration((RecyclerView.ItemDecoration) r7.next());
        goto L55
    L57:
        Iterator<RecyclerView.OnScrollListener> r8 = this.k.iterator();
    L59:
        if (r8.hasNext() == false) goto L61;
        r110.addOnScrollListener(r8.next());
        goto L59
    L61:
        this.k.clear();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter("message_list_component", "tag");
        zdc.f r9 = new zdc.f(r110);
        Intrinsics.checkNotNullParameter(r9, "listener");
        ((CommonRecyclerView) r110).j.add(r9);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.f r20 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.f(this);
        Intrinsics.checkNotNullParameter(r20, "listener");
        ((CommonRecyclerView) r110).j.add(r20);
        SceneCoordinateRecyclerView r21 = this.d;
        if (r21 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r21 = null;
    L64:
        com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> r111 = new com.ss.android.lark.chat.chatwindow.chat.v2.widget.c(r21, I().e(), new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.e(this));
        this.l = r111;
        r111.c((c) this.w.getValue());
        LKUIPtrFrameLayout r22 = this.e;
        if (r22 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mPtrFrame");
        r22 = null;
    L67:
        r111.c(new a(r22, new MessageListRendererFeature$initItemDetector$1(this), new MessageListRendererFeature$initItemDetector$2(this)));
        r111.c(new e(new MessageListRendererFeature$initItemDetector$3(this)));
        com.ss.android.lark.chat.chatwindow.chat.v2.widget.c<y6b.c<?>> r112 = this.l;
        if (r112 == null) goto L70;
        r112.a.addOnScrollListener((RecyclerView.OnScrollListener) r112.n.getValue());
        r112.b.registerAdapterDataObserver((RecyclerView.AdapterDataObserver) r112.o.getValue());
    L70:
        ChatImageErrDetector r113 = (ChatImageErrDetector) this.m.getValue();
        SceneCoordinateRecyclerView r23 = this.d;
        if (r23 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
    L74:
        com.ss.android.lark.chat.chatwindow.chat.a r24 = I();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r24, "adapter");
        ChatImageErrDetector.c = new WeakReference(r4);
        ChatImageErrDetector.d = new WeakReference(r24);
        return;
    L73:
        r4 = r23;
        goto L74
    L77:
        throw new RuntimeException("layoutManager.orientation must be vertical");
    }

    public MessageListRendererFeature(t6b.k r2, h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        Intrinsics.checkNotNullParameter(r3, "listRenderer");
        this.a = r2;
        this.b = r3;
        this.h = LazyKt.lazy(new MessageListRendererFeature$mChatAdapter$2(this));
        this.i = LazyKt.lazy(new MessageListRendererFeature$displayConcatAdapter$2(this));
        this.j = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MessageListRendererFeature$messageListInnerConcatAdapter$2(this));
        this.k = new ArrayList();
        this.m = LazyKt.lazy(MessageListRendererFeature$chatImageErrDetector$2.INSTANCE);
        this.q = LazyKt.lazy(new MessageListRendererFeature$mImageCellRefresh$2(this));
        this.t = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.b();
        this.w = LazyKt.lazy(new MessageListRendererFeature$firstFrameShownDetector$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onActivityResult(int r4, int r5, Intent r6) {
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.e r7 = (com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.e) this.q.getValue();
        if (r4 != 666) goto L23;
        int r8 = 0;
        if (r7.b.length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L27;
        Iterator<T> r10 = r7.a.getData().iterator();
    L11:
        if (r10.hasNext() == false) goto L29;
        Object r0 = r10.next();
        int r1 = r8 + 1;
        if (r8 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        y6b.c r2 = (y6b.c) r0;
        if (r2 == null) goto L18;
        String r3 = r2.c;
    L20:
        if (Intrinsics.areEqual(r3, r7.b) == true) goto L21;
        r8 = r1;
        goto L11
    L21:
        UICallbackExecutor.post(new com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.image.d(r7, r8));
        return;
    L18:
        r3 = null;
        goto L20
    L29:
        return;
    L27:
        return;
    L7:
        r9 = false;
        goto L8
    L23:
        r7.getClass();
    }
}

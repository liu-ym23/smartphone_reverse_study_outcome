package com.bytedance.android.annie.container.fragment;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.CardCustomMonitorKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.FragmentCustomMonitorKey;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.bridge.method.h2;
import com.bytedance.android.annie.bridge.method.j0;
import com.bytedance.android.annie.bridge.method.m0;
import com.bytedance.android.annie.bridge.method.n0;
import com.bytedance.android.annie.bridge.method.o0;
import com.bytedance.android.annie.bridge.method.p0;
import com.bytedance.android.annie.bridge.method.q0;
import com.bytedance.android.annie.bridge.method.r0;
import com.bytedance.android.annie.bridge.method.s0;
import com.bytedance.android.annie.bridge.method.t0;
import com.bytedance.android.annie.bridge.method.u0;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.card.web.WebComponent;
import com.bytedance.android.annie.card.web.secLink.LiveSecLinkManager;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.monitor.SlardarMonitorUtils;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridKitType;
import com.bytedance.android.annie.service.prerender.PrerenderMaxSizeLruCache;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.annie.util.u;
import com.bytedance.android.annie.util.y;
import com.bytedance.android.annie.view.ForceInterceptConstraintLayout;
import com.bytedance.android.annie.view.FullscreenVideoFrame;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieFragment;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/container/fragment/AnnieFragment;", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/annie/card/f;", "Lcom/bytedance/android/annie/container/fragment/q;", "<init>", "()V", "a", "b", "annie_release"}, k = 1, mv = {1, 4, 3})
public class AnnieFragment extends HybridFragment implements WeakHandler.IHandler, com.bytedance.android.annie.card.f, q {
    public static final /* synthetic */ int H1 = 0;
    public FullscreenVideoFrame A;
    public View B;
    public WebChromeClient.CustomViewCallback C;
    public WeakHandler D;
    public boolean E;
    public WebRiskHintView F;
    public Disposable G;
    public com.bytedance.android.annie.bridge.method.permission.b G1;
    public final Lazy H;
    public View H0;
    public final Lazy I;
    public final List<Pair<String, Object>> J;
    public boolean K;
    public final Lazy L;
    public final Lazy L0;
    public final List<HybridFragment.a> M;
    public IHybridComponent.b N;
    public IHybridComponent.a O;
    public int P;
    public int P0;
    public final Lazy Q;
    public int R;
    public WeakReference<View> S;
    public final Lazy<b> T;
    public final Lazy<AnnieFragment$mOnAttachStateListener$1.a> U;
    public com.bytedance.android.annie.bridge.p V;
    public int V0;
    public com.bytedance.android.annie.container.fragment.c W;
    public boolean X;
    public View Y;
    public int Z;
    public FrameLayout b1;
    public Map<Integer, View> d;
    public FragmentParamVoNew e;
    public com.bytedance.android.annie.param.a f;
    public View g;
    public boolean g1;
    public View h;
    public l h1;
    public View i;
    public View j;
    public View k;
    public w8.d k0;
    public final Boolean k1;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public View p;
    public int p0;
    public boolean p1;
    public u7.a q;
    public u7.c r;
    public boolean s;
    public int t;
    public int[] u;
    public int v;
    public volatile boolean v1;
    public v7.b w;
    public View x;
    public boolean x1;
    public int y;
    public final CompositeDisposable y1;
    public int z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference<AnnieFragment> a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            AnnieFragment r0 = this.a.get();
            int r1 = 0;
            if (r0 == null) goto L13;
            FragmentActivity r10 = r0.getActivity();
            if (r10 == null) goto L13;
            Resources r11 = r10.getResources();
            if (r11 == null) goto L13;
            Configuration r12 = r11.getConfiguration();
            if (r12 == null) goto L13;
            if (r12.orientation != 2) goto L13;
            boolean r13 = true;
        L14:
            AnnieFragment r14 = this.a.get();
            if (r14 == null) goto L41;
            Integer r15 = null;
            if (r13 == false) goto L21;
            View r16 = r14.getView();
            if (r16 == null) goto L25;
            int r17 = r16.getWidth();
        L24:
            r15 = Integer.valueOf(r17);
        L25:
            if (r15 == null) goto L27;
            r1 = r15.intValue();
        L27:
            int r18 = r14.R;
            if (r18 != 0) goto L31;
            r14.R = r1;
            return;
        L31:
            if (r18 == r1) goto L42;
            v7.b r19 = r14.w;
            if (r19 == null) goto L35;
            r19.c();
        L35:
            View r20 = r14.getView();
            if (r20 == null) goto L43;
            ViewTreeObserver r21 = r20.getViewTreeObserver();
            if (r21 == null) goto L44;
            r21.removeOnGlobalLayoutListener(this);
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L21:
            View r22 = r14.getView();
            if (r22 == null) goto L25;
            r17 = r22.getHeight();
            goto L24
        L41:
            return;
        L13:
            r13 = false;
            goto L14
        }

        public b(WeakReference<AnnieFragment> r10) {
            Intrinsics.checkNotNullParameter(r10, "fragment");
            this.a = r10;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FragmentCustomMonitorKey.values().length];
            r0[FragmentCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[FragmentCustomMonitorKey.IsContainerPreload.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[FragmentCustomMonitorKey.IsUserOpen.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[FragmentCustomMonitorKey.IsPrerender.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[FragmentCustomMonitorKey.HasReload.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AnnieCard a;
        public final /* synthetic */ AnnieFragment b;

        public d(AnnieCard r1, AnnieFragment r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = com.bytedance.android.annie.container.fragment.n.a;     // Catch: Throwable -> L10
            View r1 = this.a.getHybridView();     // Catch: Throwable -> L10
            if (r1 == null) goto L5;
            Integer r10 = Integer.valueOf(r1.getHeight());     // Catch: Throwable -> L10
        L6:
            AnnieFragment r11 = this.b;     // Catch: Throwable -> L10
            int r12 = r11.v;     // Catch: Throwable -> L10
            int[] r13 = r11.u;     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L10
            ShapeDrawable r14 = com.bytedance.android.annie.container.fragment.n.c(r10, r12, r13);     // Catch: Throwable -> L10
            View r15 = this.a.getHybridView();     // Catch: Throwable -> L10
            if (r15 == null) goto L13;
            r15.setBackgroundDrawable(r14);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r10 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class e implements IHybridComponent.a {
        public final /* synthetic */ AnnieFragment a;
        public final /* synthetic */ AnnieCard b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ y6.c a;
            public final /* synthetic */ AnnieFragment b;
            public final /* synthetic */ AnnieCard c;

            public a(y6.c r1, AnnieFragment r10, AnnieCard r11) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r10) {
                com.bytedance.android.annie.card.g r11 = ((JSBridgeManager) this.a).t;
                FragmentParamVoNew r0 = this.b.e;
                if (r0 == null) goto L5;
                boolean r1 = r0.w1();
            L6:
                FragmentActivity r12 = this.b.getActivity();
                String r13 = this.c.getBizKey();
                r11.getClass();
                Intrinsics.checkNotNullParameter(r13, "bizKey");
                if (r12 == null) goto L14;
                y6.e r14 = r11.a;
                if (r14 == null) goto L15;
                if (r1 == false) goto L12;
                ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).G0(r14, r12);
                return;
            L12:
                ((z9.b) Annie.getService(z9.b.class, r13)).D(r14, r12);
                return;
            L15:
                return;
            L14:
                return;
            L5:
                r1 = false;
                goto L6
            }
        }

        @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
        public final void onJSBridgeCreated(y6.c r10) {
            Intrinsics.checkNotNullParameter(r10, "manager");
            IHybridComponent.a r0 = this.a.O;
            if (r0 == null) goto L5;
            r0.onJSBridgeCreated(r10);
        L5:
            AnnieFragment.V90(this.a, r10);
            if ((r10 instanceof JSBridgeManager) == false) goto L11;
            ((JSBridgeManager) r10).t.a(this.a);
            AnnieFragment r1 = this.a;
            View r11 = r1.p;
            if (r11 == null) goto L12;
            r11.setOnClickListener(new a(r10, r1, this.b));
            return;
        L12:
            return;
        }

        public e(AnnieFragment r1, AnnieCard r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class f implements com.bytedance.android.annie.card.base.b {
        public final /* synthetic */ AnnieFragment a;
        public final /* synthetic */ FragmentParamVoNew b;
        public final /* synthetic */ AnnieCard c;

        @Override // com.bytedance.android.annie.card.base.b
        public final void b(c0 r10) {
            Intrinsics.checkNotNullParameter(r10, "call");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void c(JSONObject r10, c0 r11) {
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r11, "call");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void h(View r1, com.bytedance.android.annie.card.web.resource.a r10) {
            Intrinsics.checkNotNullParameter(r10, "resourceInfo");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void j(View r1, String r10, String r11) {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void k(View r1, String r10, Bitmap r11, boolean r12) {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void l(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map r12) {
            com.bytedance.android.annie.card.base.a.a(r1, r10, r11, r12);
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void m(boolean r1) {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void onBeforeCreateRenderData(View r10) {
            Intrinsics.checkNotNullParameter(r10, "hybridView");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onBeforeGlobalPropsInitialize() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onBeforeInitialPropsInitialize() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onBeforeJsbRegister() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void onBeforeLoadRequest(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map r12) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r10, "resType");
            Intrinsics.checkNotNullParameter(r11, "type");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onBeforeLynxEnvInitialize(boolean r1) {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onCardLoadStart() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void onCreateRenderData(View r10, Set r11) {
            Intrinsics.checkNotNullParameter(r10, "hybridView");
            Intrinsics.checkNotNullParameter(r11, "stateKeys");
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onEngineLoadEnd() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onEngineLoadStart() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onGlobalPropsInitialized() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onInitialPropsInitialized() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onJsbRegistered() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onLynxEnvInitialized() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void onRelease() {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final /* synthetic */ void onTemplateLoaded(View r1, boolean r10) {
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void n(LynxView r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            FragmentParamVoNew r0 = this.a.e;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == false) goto L17;
            final AnnieFragment r12 = this.a;
            r12.getClass();
            final ViewPager r13 = r12.Z90(r10, AnnieFragment$handleNestedScrollWithVp$vp$1.INSTANCE);
            boolean r14 = r13 instanceof ViewPager;
            if (r14 == false) goto L17;
            final ArrayList r15 = new ArrayList();
            if (r14 == false) goto L14;
            ViewPager r16 = r13;
        L15:
            if (r16 == null) goto L17;
            r16.addOnPageChangeListener(new AnnieFragment$handleNestedScrollWithVp$1(r15, r13, r12));
            goto L17
        L14:
            r16 = null;
        L17:
            FragmentParamVoNew r17 = this.a.e;
            if (r17 != null) goto L20;
        L22:
            if (r1 == false) goto L27;
            View r18 = this.a.Z90(r10, AnnieFragment$bindAnnieCardCallbackNew$1$2$onFirstScreen$1.INSTANCE);
            if (r18 == null) goto L28;
            AnnieFragment r19 = this.a;
            r19.S = new WeakReference(r18);
            return;
        L28:
            return;
        L27:
            return;
        L20:
            if (r17.c() != true) goto L22;
            r1 = true;
            goto L22
        L5:
            if (r0.q() != true) goto L7;
            r11 = true;
            goto L8
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void g(View r10, String r11) {
            v7.b r12 = this.a.w;
            if (r12 == null) goto L5;
            r12.c();
        L5:
            AnnieFragment r13 = this.a;
            IHybridComponent r14 = r13.getMAnnieCard();
            int r0 = com.bytedance.android.annie.container.fragment.n.a;
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L10
            r1.put("visible", true);     // Catch: JSONException -> L10
            if (r14 == null) goto L12;
            r14.sendJsEvent("H5_visibilityChange", r1);     // Catch: JSONException -> L10
        L12:
            w8.d r15 = r13.k0;
            if (r15 == null) goto L16;
            r15.a(true);
        L16:
            if (AnnieConfigSettingKeys.ENABLE_LYNX_REUSE_CARD.a().booleanValue() == false) goto L25;
            FragmentParamVoNew r16 = this.b;
            if (r16 == null) goto L26;
            AnnieCard r17 = this.c;
            if (r16.G1() == false) goto L27;
            com.bytedance.android.annie.container.fragment.a.c((String) r16.S.getValue(), r17);
            return;
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        }

        public f(AnnieFragment r1, FragmentParamVoNew r10, AnnieCard r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // com.bytedance.android.annie.card.base.b
        public final void i(LynxView r1, String r10, String r11) {
            FrameLayout r12 = (FrameLayout) this.a.S90(2131374651);
            if (r12 == null) goto L7;
            r12.setVisibility(0);
            return;
        }
    }

    public static final class g extends com.bytedance.android.annie.card.web.e {
        public final /* synthetic */ AnnieFragment b;
        public final /* synthetic */ AnnieCard c;
        public final /* synthetic */ FragmentParamVoNew d;
        public final /* synthetic */ AnnieCard e;

        public final void D() {
            View r0 = this.b.h;
            if (r0 == null) goto L5;
            r0.setBackgroundColor(ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
        L5:
            FrameLayout r1 = (FrameLayout) this.b.S90(2131374651);
            if (r1 == null) goto L10;
            r1.setVisibility(8);
            return;
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void r() {
            AnnieFragment.U90(this.b);
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void w() {
            this.b.fa0();
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void x(String r10) {
            FragmentParamVoNew r0 = this.b.e;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == true) goto L10;
            return;
        L10:
            if (this.b.getActivity() == null) goto L24;
            if (r10 != null) goto L13;
        L14:
            r1 = true;
        L15:
            if (r1 == false) goto L17;
            return;
        L17:
            if (Intrinsics.areEqual(r10, "about:blank") == true) goto L26;
            TextView r12 = this.b.o;
            if (r12 == null) goto L27;
            r12.setText(r10);
            return;
        L27:
            return;
        L26:
            return;
        L13:
            if (r10.length() != 0) goto L15;
        L24:
            return;
        L5:
            if (r0.e2() != true) goto L7;
            r11 = true;
            goto L8
        }

        @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
        public final void g(View r10, String r11) {
            v7.b r12 = this.b.w;
            if (r12 == null) goto L5;
            r12.c();
        L5:
            AnnieFragment r13 = this.b;
            if (r13.s == true) goto L8;
        L10:
            this.b.fa0();
            AnnieCard r14 = this.c;
            int r0 = com.bytedance.android.annie.container.fragment.n.a;
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L15
            r1.put("visible", true);     // Catch: JSONException -> L15
            if (r14 == null) goto L17;
            r14.sendJsEvent("H5_visibilityChange", r1);     // Catch: JSONException -> L15
        L17:
            boolean r15 = r10 instanceof WebView;
            FrameLayout r16 = null;
            if (r15 == false) goto L20;
            WebView r17 = (WebView) r10;
        L21:
            if (r17 == null) goto L28;
            String r18 = r17.getTitle();
            if (r18 == null) goto L28;
            TextView r19 = this.b.o;
            if (r19 == null) goto L28;
            r19.setText(r18);
        L28:
            FragmentParamVoNew r20 = this.b.e;
            if (r20 == null) goto L39;
            String r21 = r20.c2();
            if (r21 == null) goto L39;
            AnnieFragment r22 = this.b;
            if ((true ^ StringsKt.isBlank(r21)) == false) goto L39;
            TextView r23 = r22.o;
            if (r23 == null) goto L39;
            r23.setText(r21);
        L39:
            if (this.b.E == false) goto L46;
            if (r15 == false) goto L42;
            WebView r24 = (WebView) r10;
        L43:
            if (r24 == null) goto L45;
            r24.clearHistory();
        L45:
            this.b.E = false;
            goto L46
        L42:
            r24 = null;
        L46:
            AnnieFragment r25 = this.b;
            if (r25.k == null) goto L58;
            if (r15 == false) goto L58;
            WebView r26 = (WebView) r10;
            Intrinsics.checkNotNullParameter(r26, "webView");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L52;
            r25.da0(r26);
            goto L58
        L52:
            Object r27 = r25.getMAnnieCard();
            if ((r27 instanceof FrameLayout) == false) goto L55;
            r16 = (FrameLayout) r27;
        L55:
            if (r16 == null) goto L58;
            r16.post(new com.bytedance.android.annie.container.fragment.i(r25, r26));
        L58:
            if (AnnieConfigSettingKeys.ENABLE_WEB_REUSE_CARD.a().booleanValue() == false) goto L67;
            FragmentParamVoNew r28 = this.d;
            if (r28 == null) goto L68;
            AnnieCard r29 = this.e;
            if (r28.G1() == false) goto L69;
            com.bytedance.android.annie.container.fragment.a.c((String) r28.S.getValue(), r29);
            return;
        L69:
            return;
        L68:
            return;
        L67:
            return;
        L20:
            r17 = null;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        L8:
            if (r13.k1.booleanValue() == true) goto L10;
            D();
            goto L10
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void z(View r10, WebChromeClient.CustomViewCallback r11) {
            com.bytedance.android.annie.ng.a r0 = com.bytedance.android.annie.ng.g.c.get(this.c.getBizKey());
            if (r0 == null) goto L9;
            o8.h r1 = r0.a;
            if (r1 == null) goto L9;
            if (r1.c == true) goto L9;
            boolean r12 = true;
        L10:
            if (r12 == false) goto L12;
            return;
        L12:
            AnnieFragment r13 = this.b;
            if (r13.B == null) goto L16;
            Intrinsics.checkNotNull(r11);
            r11.onCustomViewHidden();
            return;
        L16:
            TextView r14 = r13.o;
            if (r14 == null) goto L20;
            r14.setVisibility(0);
        L20:
            AnnieFragment r15 = this.b;
            r15.C = r11;
            FullscreenVideoFrame r16 = r15.A;
            if (r16 == null) goto L23;
            r16.addView(r10);
        L23:
            AnnieFragment r17 = this.b;
            r17.B = r10;
            UIUtils.requestOrienation(r17.getActivity(), true);
            FullscreenVideoFrame r18 = this.b.A;
            if (r18 == null) goto L27;
            r18.setVisibility(0);
        L27:
            FullscreenVideoFrame r19 = this.b.A;
            if (r19 == null) goto L31;
            r19.requestFocus();
            return;
        L31:
            return;
        L9:
            r12 = false;
            goto L10
        }

        @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
        public final void j(View r10, String r11, String r12) {
            this.b.s = true;
            com.bytedance.android.annie.param.a r13 = this.c.getMAnnieContext();
            if (r13 == null) goto L8;
            x8.b r14 = r13.d;
            if (r14 == null) goto L8;
            r14.a("AnnieFragment", r11 + " - " + r12);
        L8:
            if (this.b.k1.booleanValue() == false) goto L11;
            D();
            return;
        }

        public g(AnnieFragment r1, AnnieCard r10, FragmentParamVoNew r11, AnnieCard r12) {
            this.b = r1;
            this.c = r10;
            this.d = r11;
            this.e = r12;
            super(null);
        }

        @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
        public final void k(View r1, String r10, Bitmap r11, boolean r12) {
            if (this.b.s == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r10, "about:blank") == true) goto L15;
            FrameLayout r13 = (FrameLayout) this.b.S90(2131374651);
            if (r13 == null) goto L10;
            r13.setVisibility(0);
        L10:
            View r14 = this.b.h;
            if (r14 == null) goto L16;
            r14.setBackgroundColor(ColorProtector.parseColor("#00000000"));
            return;
        L16:
            return;
        }
    }

    public static final class h implements IHybridComponent.b {
        public final /* synthetic */ AnnieFragment a;

        public h(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.api.card.IHybridComponent.b
        public final void a(WebComponent r10, int r11, int r12, int r13, int r14) {
            AnnieFragment r0 = this.a;
            r0.P = r12;
            boolean r1 = false;
            if (r12 <= 0) goto L28;
            FragmentParamVoNew r15 = r0.e;
            if (r15 != null) goto L7;
        L9:
            boolean r16 = false;
        L10:
            if (r16 == false) goto L28;
            FragmentParamVoNew r17 = this.a.e;
            if (r17 != null) goto L14;
        L16:
            if (r1 == false) goto L20;
            if (this.a.p0 != 3) goto L20;
        L21:
            u7.a r18 = this.a.q;
            if (r18 == null) goto L24;
            r18.d();
        L24:
            AnnieFragment r19 = this.a;
            View r20 = r19.g;
            if (r20 == null) goto L38;
            r20.setAlpha(RangesKt.coerceAtMost(Math.abs(r12 / (((Number) r19.L0.getValue()).intValue() + this.a.P0)), 1.0f));
        L38:
            IHybridComponent.b r21 = this.a.N;
            if (r21 == null) goto L42;
            r21.a(r10, r11, r12, r13, r14);
            return;
        L42:
            return;
        L20:
            if (this.a.isFullScreen() == false) goto L38;
        L14:
            if (r17.g2() != true) goto L16;
            r1 = true;
            goto L16
        L7:
            if (r15.w1() != true) goto L9;
            r16 = true;
        L28:
            if (r12 != 0) goto L38;
            FragmentParamVoNew r22 = this.a.e;
            if (r22 != null) goto L32;
        L34:
            if (r1 == false) goto L38;
            u7.a r23 = this.a.q;
            if (r23 == null) goto L38;
            r23.c();
            goto L38
        L32:
            if (r22.w1() != true) goto L34;
            r1 = true;
            goto L34
        }
    }

    public static final class i<T> implements ValueCallback {
        public final /* synthetic */ AnnieFragment a;

        public i(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            AnnieFragment r0 = this.a;
            int r1 = AnnieFragment.H1;
            y6.e r11 = r0.aa0();
            String r12 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r11.a = r12;
        }
    }

    public static final class j<T> implements ValueCallback {
        public final /* synthetic */ AnnieFragment a;

        public j(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            AnnieFragment r0 = this.a;
            int r1 = AnnieFragment.H1;
            y6.e r11 = r0.aa0();
            String r12 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r11.c = r12;
        }
    }

    public static final class k<T> implements ValueCallback {
        public final /* synthetic */ AnnieFragment a;

        public k(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            AnnieFragment r0 = this.a;
            int r1 = AnnieFragment.H1;
            y6.e r11 = r0.aa0();
            String r12 = com.bytedance.android.annie.container.fragment.n.e((String) r10);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r11.d = r12;
        }
    }

    public static final class l implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ AnnieFragment b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            AnnieFragment r0 = this.b;
            int r1 = AnnieFragment.H1;
            r0.addCardAndBindEvent();
            return true;
        }

        public l(View r1, AnnieFragment r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class m implements View.OnLayoutChangeListener {
        public final /* synthetic */ AnnieFragment a;

        public m(AnnieFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
            Configuration r18 = com.bytedance.android.annie.util.p.a.getResources().getConfiguration();
            if (r18 == null) goto L5;
            int r19 = r18.orientation;
        L6:
            AnnieFragment r20 = this.a;
            int r21 = r20.z;
            if (r21 != (-1)) goto L9;
            r20.z = r19;
            return;
        L9:
            if (r19 == r21) goto L23;
            r20.z = r19;
            com.bytedance.android.annie.param.a r22 = r20.f;
            if (r22 == null) goto L15;
            x8.b r23 = r22.d;
            if (r23 == null) goto L15;
            r23.e("AnnieFragment", "AnnieFragment mRootView addOnLayoutChangeListener updateScreenMetrics");
        L15:
            IHybridComponent r24 = this.a.getMAnnieCard();
            if ((r24 instanceof AnnieCard) == false) goto L18;
            AnnieCard r25 = (AnnieCard) r24;
        L19:
            if (r25 == null) goto L24;
            FrameLayout.LayoutParams r26 = this.a.ba0();
            r25.setLayoutParams(r26);
            r25.f(r26.width, r26.height);
            return;
        L24:
            return;
        L18:
            r25 = null;
            goto L19
        L23:
            return;
        L5:
            r19 = -1;
            goto L6
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ AnnieFragment a;

        public n(AnnieFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Integer r11 = (Integer) r10;
            if (this.a.v1 == false) goto L5;
            AnnieFragment r12 = this.a;
            r12.x1 = Annie.INSTANCE.isBackground();
        L5:
            this.a.realVisibleChange(false);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ AnnieFragment a;

        public o(AnnieFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            com.bytedance.android.annie.param.a r0 = this.a.f;
            if (r0 == null) goto L8;
            x8.b r1 = r0.d;
            if (r1 == null) goto L9;
            x8.b.c(r1, r11);
            return;
        L9:
            return;
        }
    }

    public static final class p implements View.OnKeyListener {
        public final /* synthetic */ AnnieFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ boolean d;

        public p(AnnieFragment r1, String r10, JSONObject r11, boolean r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r10, int r11, KeyEvent r12) {
            Intrinsics.checkNotNullParameter(r12, "keyEvent");
            if (r11 == 4) goto L5;
            return false;
        L5:
            if (r12.getAction() != 1) goto L13;
            AnnieFragment r13 = this.a;
            int r14 = AnnieFragment.H1;
            IHybridComponent r15 = r13.getMAnnieCard();
            if (r15 == null) goto L10;
            r15.sendJsEvent(this.b, this.c);
        L10:
            return !this.d;
        L13:
            return false;
        }
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    public void handlePullStateChange(int r1) {
    }

    public boolean inIgnoreArea(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final boolean isAnnieXFragment() {
        return false;
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onRefresh() {
    }

    private final void closeActivity() {
        FragmentParamVoNew r0 = this.e;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L17;
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L25;
        r11.finish();
        return;
    L25:
        return;
    L17:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r1), "intercept_back"), "1") == false) goto L21;
        IHybridComponent r12 = getMAnnieCard();
        if (r12 == null) goto L27;
        r12.sendJsEvent("H5_webcastPageQuit", new JSONObject());
        return;
    L27:
        return;
    L21:
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L29;
        r13.finish();
        return;
    L29:
        return;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r10 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final String getUrl() {
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    private final void initStatusBar() {
        if (AnnieConfigSettingKeys.NOT_SUPPORT_STATUS_BAR_PARAMS_ON_POPUP.a().booleanValue() == true) goto L5;
    L7:
        FragmentParamVoNew r0 = this.e;
        if (r0 == null) goto L93;
        boolean r10 = true;
        if (r0.b2() == false) goto L18;
        String r1 = r0.a2();
        if (Intrinsics.areEqual(r1, IHostContextDepend.SKIN_TYPE_WHITE) == false) goto L15;
        com.bytedance.android.annie.util.i.h(getActivity());
    L17:
        com.bytedance.android.annie.util.i.c(getActivity());
        com.bytedance.android.annie.container.fragment.n.f(getActivity(), r0.Z1());
    L44:
        if (r0.D() == true) goto L46;
        return;
    L46:
        if (r0.i() == false) goto L86;
        FragmentActivity r11 = getActivity();
        int r12 = com.bytedance.android.annie.util.f.a;
        int r13 = u.a;
        if (r11 != null) goto L50;
    L78:
        r10 = false;
    L79:
        if (r10 == false) goto L81;
        com.bytedance.android.annie.container.fragment.n.g(getActivity(), r0.a2());
        goto L86
    L81:
        int r14 = u.a;
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L86;
        r15.getWindow().setFlags(1024, 1024);
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        r15.getWindow().setStatusBarColor(r15.getResources().getColor(R.color.transparent));
        goto L86
    L50:
        if (Build.VERSION.SDK_INT < 28) goto L62;
        View r16 = r11.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L91;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r17 = ThreadMethodProxy.currentThread();
        if (r17 == com.larus.home.impl.utils.c.a) goto L91;
        com.larus.home.impl.utils.c.a(r17, "getDecorView");
    L91:
        Object r18 = r16.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(r16, new Object[0]);     // Catch: Exception -> L60
        Object r19 = r18.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(r18, new Object[0]);     // Catch: Exception -> L60
        Object r20 = r19.getClass().getMethod("getBoundingRects", new Class[0]).invoke(r19, new Object[0]);     // Catch: Exception -> L60
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.collections.List<android.graphics.Rect>");     // Catch: Exception -> L60
        if (((List) r20).size() <= 0) goto L62;
        boolean r21 = true;
    L63:
        if (r21 == true) goto L79;
        if (com.bytedance.android.annie.ng.g.b().b.e == true) goto L79;
        Resources r22 = r11.getResources();     // Catch: Exception -> L74
        int r23 = r22.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Exception -> L74
        if (r23 <= 0) goto L69;
        String r24 = r22.getString(r23);     // Catch: Exception -> L74
    L70:
        if (r24 == null) goto L75;
        if (TextUtils.isEmpty(r24) == true) goto L75;
        boolean r25 = true;
    L76:
        if (r25 == false) goto L78;
    L69:
        r24 = null;
    L75:
        r25 = false;
    L60:
        e = move-exception;
        e.printStackTrace();
    L62:
        r21 = false;
    L86:
        if (r0.r() == false) goto L95;
        com.bytedance.android.annie.container.fragment.n.g(getActivity(), r0.a2());
        return;
    L95:
        return;
    L15:
        if (Intrinsics.areEqual(r1, IHostContextDepend.SKIN_TYPE_BLACK) == false) goto L17;
        com.bytedance.android.annie.util.i.i(getActivity().getWindow(), Boolean.TRUE);
        goto L17
    L18:
        int r26 = com.bytedance.android.annie.container.fragment.n.a;
        String r27 = r0.b;
        if (r27 != null) goto L22;
        r27 = "";
    L22:
        if (com.bytedance.android.annie.container.fragment.n.d(r27, Boolean.valueOf(r0.b2())) == false) goto L26;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L26;
        boolean r28 = true;
    L27:
        String r29 = r0.a2();
        if (r29 == null) goto L44;
        FragmentActivity r30 = getActivity();
        String r31 = r0.Z1();
        boolean r32 = r0.i();
        boolean r110 = r0.r();
        Intrinsics.checkNotNullParameter(r29, "statusBarColor");
        if (r30 == null) goto L44;
        if (r28 == false) goto L34;
        com.bytedance.android.annie.util.i.i(r30.getWindow(), Boolean.TRUE);
        com.bytedance.android.annie.util.i.c(r30);
        com.bytedance.android.annie.container.fragment.n.f(r30, IHostContextDepend.SKIN_TYPE_WHITE);
        goto L44
    L34:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r29) == false) goto L37;
        com.bytedance.android.annie.util.i.h(r30);
        com.bytedance.android.annie.util.i.c(r30);
    L42:
        com.bytedance.android.annie.container.fragment.n.f(r30, r31);
        goto L44
    L37:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_BLACK, r29) == false) goto L42;
        com.bytedance.android.annie.util.i.i(r30.getWindow(), Boolean.TRUE);
        if (r32 == true) goto L42;
        if (r110 == true) goto L42;
        com.bytedance.android.annie.util.i.c(r30);
    L26:
        r28 = false;
        goto L27
    L93:
        return;
    L5:
        if (isFullScreen() == true) goto L7;
    }

    public final y6.e aa0() {
        return (y6.e) this.L.getValue();
    }

    public final FrameLayout.LayoutParams ba0() {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        getActivity();
        t r1 = t.a;
        int r10 = t.f(requireActivity());
        int r11 = t.g(requireActivity());
        FragmentParamVoNew r12 = this.e;
        int r13 = 0;
        if (r12 == null) goto L14;
        float r14 = r12.S1();
        if (r12.L1() == true) goto L7;
        int r15 = com.bytedance.android.annie.util.p.a.a(44);
    L9:
        if (r12.i() == false) goto L11;
    L13:
        int r16 = r13;
        r13 = r15;
    L15:
        int r17 = ((r10 - r13) - r16) - r1.e(getActivity());
        if ((r11 / r10) <= r14) goto L18;
        r0.width = (int) (r17 * r14);
        r0.height = r17;
        r0.gravity = 17;
    L19:
        return r0;
    L18:
        r0.width = r11;
        r0.height = r17;
        goto L19
    L11:
        if (r12.r() == true) goto L13;
        com.bytedance.android.annie.util.p r18 = com.bytedance.android.annie.util.p.a;
        r13 = com.bytedance.android.annie.util.p.f();
        goto L13
    L7:
        r15 = 0;
        goto L9
    L14:
        r14 = 1.0f;
        r16 = 0;
        goto L15
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void cancelLoading() {
        v7.b r0 = this.w;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void closeByReplace() {
        FragmentParamVoNew r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        closeActivity();
        return;
    L9:
        Y90();
        return;
    L5:
        if (r0.h2() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final boolean disableDragDown() {
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L23;
        if (this.P > 0) goto L24;
        WeakReference<View> r10 = this.S;
        if (r10 == null) goto L18;
        View r11 = r10.get();
        if (r11 == null) goto L18;
        if (r11.canScrollVertically(-1) != true) goto L18;
        boolean r12 = true;
    L20:
        if ((!r12) == false) goto L24;
        return false;
    L18:
        r12 = false;
    L24:
        return true;
    L23:
        if (this.P > 0) goto L24;
        return false;
    L5:
        if (r0.c() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void fa0() {
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (getMAnnieCard() == null) goto L59;
        IHybridComponent r1 = getMAnnieCard();
        boolean r10 = true;
        int r11 = 0;
        if (r1 != null) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L19;
        if (r0.D() == true) goto L19;
        r10 = false;
    L19:
        if (r10 == false) goto L21;
        int r13 = 0;
    L23:
        if (r0.g2() == false) goto L28;
        if (r0.W1() == true) goto L28;
    L35:
        if (r0.X1() == false) goto L41;
        View r14 = this.j;
        if (r14 == null) goto L41;
        r14.setVisibility(r11);
    L41:
        if (r0.W1() == false) goto L47;
        View r15 = this.i;
        if (r15 == null) goto L47;
        r15.setVisibility(r13);
    L47:
        if (r0.w1() == false) goto L58;
        View r16 = this.m;
        if (r16 == null) goto L52;
        r16.setVisibility(r13);
    L52:
        View r17 = this.n;
        if (r17 == null) goto L60;
        r17.setVisibility(r11);
        return;
    L60:
        return;
    L58:
        return;
    L28:
        if (r0.A1() == false) goto L30;
        boolean r18 = r0.X1();
    L31:
        if (r18 == true) goto L35;
        if (r10 == false) goto L35;
        r11 = 8;
        goto L35
    L30:
        r18 = false;
        goto L31
    L21:
        r13 = 8;
        goto L23
    L10:
        if (r1.canGoBack() != true) goto L12;
        r12 = true;
        goto L13
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "host";
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    @Deprecated(message = "不建议使用，请联系@jintai.001", replaceWith = @ReplaceWith(expression = "release()", imports = {}))
    public final void handRelease() {
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r10 = new StringBuilder("===handRelease: ");
        String r11 = getUrl();
        if (r11 != null) goto L9;
        r11 = "empty";
    L9:
        r10.append(r11);
        r10.append("===");
        r1.e("AnnieFragment", r10.toString());
    L10:
        ((ArrayList) this.M).clear();
        super.release();
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final boolean isFullScreen() {
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.D() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.f2() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean needAdapterStatusBarColor() {
        if (AnnieConfigSettingKeys.ENABLE_PULL_UP_ADAPTER_STATUS_BAR.a().booleanValue() == true) goto L5;
        return false;
    L5:
        if ((this instanceof LiveAnnieFragment) == false) goto L23;
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L24;
        FragmentParamVoNew r10 = this.e;
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        if (r10.w1() != true) goto L18;
        r11 = true;
        goto L19
    L24:
        return false;
    L9:
        if (r0.g2() != true) goto L11;
        r1 = true;
        goto L12
    L23:
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r10 = new StringBuilder("===release: ");
        String r11 = getUrl();
        if (r11 != null) goto L9;
        r11 = "empty";
    L9:
        r10.append(r11);
        r10.append("===");
        r1.e("AnnieFragment", r10.toString());
    L10:
        FragmentParamVoNew r12 = this.e;
        if (r12 != null) goto L13;
    L15:
        boolean r13 = false;
    L16:
        if (r13 == false) goto L18;
        super.release();
    L18:
        ((ArrayList) this.M).clear();
        return;
    L13:
        if (r12.G1() == true) goto L15;
        r13 = true;
        goto L16
    }

    public AnnieFragment() {
        this.d = new LinkedHashMap();
        this.r = new u7.c(false, false);
        this.y = -1;
        this.z = -1;
        this.E = true;
        this.H = LazyKt.lazy(AnnieFragment$enablePendingLoad$2.INSTANCE);
        this.I = LazyKt.lazy(AnnieFragment$enableParentViewCheck$2.INSTANCE);
        this.J = new ArrayList();
        this.L = LazyKt.lazy(AnnieFragment$mShareInfo$2.INSTANCE);
        this.M = new ArrayList();
        this.Q = LazyKt.lazy(AnnieFragment$mSoftKeyboardFixHeight$2.INSTANCE);
        this.T = LazyKt.lazy(new AnnieFragment$mGlobalLayoutListener$1(this));
        this.U = LazyKt.lazy(new AnnieFragment$mOnAttachStateListener$1(this));
        this.Z = -1;
        this.p0 = -1;
        this.L0 = LazyKt.lazy(AnnieFragment$mNavBarHeight$2.INSTANCE);
        this.k1 = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a();
        this.v1 = true;
        this.y1 = new CompositeDisposable();
    }

    private final void Y90() {
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof BaseDialogFragment) == false) goto L17;
        DialogFragment r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L18:
        return;
    }

    private final Window getWindow() {
        if (isFullScreen() == false) goto L7;
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L14;
        return null;
    L14:
        return r0.getWindow();
    L7:
        DialogFragment r1 = getParentFragment();
        if (r1 == null) goto L15;
        Dialog r10 = r1.getDialog();
        if (r10 != null) goto L12;
        return null;
    L12:
        return r10.getWindow();
    L15:
        return null;
    }

    public final void addCardAndBindEvent() {
        if (getContext() != null) goto L5;
        return;
    L5:
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L13;
        x8.b r1 = r0.d;
        if (r1 == null) goto L13;
        StringBuilder r10 = new StringBuilder("===addCardAndBindEvent：");
        String r11 = getUrl();
        if (r11 != null) goto L12;
        r11 = "empty";
    L12:
        r10.append(r11);
        r10.append("===");
        r1.e("AnnieFragment", r10.toString());
    L13:
        com.bytedance.android.annie.param.a r12 = this.f;
        if (r12 == null) goto L17;
        String r13 = r12.getUuid();
        if (r13 == null) goto L17;
    L18:
        AnnieFragmentManager.d(r13, this);
        FragmentParamVoNew r14 = this.e;
        if (r14 == null) goto L35;
        setMAnnieCard(W90(r14));
        if (AnnieConfigSettingKeys.LIVE_ENABLE_HYBRID_SEC_BANNER.a().booleanValue() == true) goto L23;
    L34:
        setCloseByGesture(!r14.J1());
        goto L35
    L23:
        if (Intrinsics.areEqual(r14.E(), Boolean.TRUE) == false) goto L34;
        IHybridComponent r15 = getMAnnieCard();
        Object r16 = null;
        if (r15 == null) goto L27;
        View r17 = r15.getHybridView();
    L29:
        if ((r17 instanceof o7.d) == false) goto L34;
        IHybridComponent r18 = getMAnnieCard();
        if (r18 == null) goto L33;
        r16 = r18.getHybridView();
    L33:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.android.annie.card.web.base.ISecLinkHandler");
        ((o7.d) r16).setCallback(new com.bytedance.android.annie.container.fragment.h(this));
        goto L34
    L27:
        r17 = null;
    L35:
        this.k0 = ((w8.c) getService(w8.c.class)).F1(this, getActivity());
        this.G = Observable.timer(1500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.annie.container.fragment.e(this), new com.bytedance.android.annie.container.fragment.f(this));
        return;
    L17:
        r13 = "";
        goto L18
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void back() {
        IHybridComponent r0 = getMAnnieCard();
        if (r0 == null) goto L6;
        r0.goBack();
        return;
    }

    public final boolean ca0() {
        if (isFullScreen() == true) goto L5;
        return false;
    L5:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L16;
        FragmentParamVoNew r0 = this.e;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0.H1() != true) goto L11;
        r1 = true;
        goto L12
    L16:
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        if (isFullScreen() == false) goto L5;
        closeActivity();
        return;
    L5:
        Y90();
    }

    public final void ea0() {
        if (ThreadUtils.b() == true) goto L11;
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L34;
        x8.b r1 = r0.d;
        if (r1 == null) goto L35;
        r1.a("AnnieFragment", "send cache jsEvent not in main thread");
        return;
    L35:
        return;
    L34:
        return;
    L11:
        if ((getMAnnieCard() instanceof AnnieCard) == false) goto L23;
        IHybridComponent r10 = getMAnnieCard();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.android.annie.card.AnnieCard");
        if (((AnnieCard) r10).getLoadSuccess() == false) goto L23;
        Iterator r11 = ((ArrayList) this.J).iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        Pair r12 = (Pair) r11.next();
        IHybridComponent r13 = getMAnnieCard();
        if (r13 == null) goto L17;
        r13.sendJsEvent((String) r12.getFirst(), r12.getSecond());
        goto L17
    L21:
        ((ArrayList) this.J).clear();
        return;
    L23:
        com.bytedance.android.annie.param.a r14 = this.f;
        if (r14 == null) goto L36;
        x8.b r15 = r14.d;
        if (r15 == null) goto L37;
        r15.a("AnnieFragment", "send cache jsEvent before load success");
        return;
    L37:
        return;
    }

    public void onDestroy() {
        super.onDestroy();
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r10 = new StringBuilder("===onDestroy: ");
        String r11 = getUrl();
        if (r11 != null) goto L9;
        r11 = "empty";
    L9:
        r10.append(r11);
        r10.append("===");
        r1.f("AnnieFragment", "on_destroy", r10.toString());
    L10:
        View r12 = this.h;
        if (r12 == null) goto L13;
        r12.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.U.getValue());
    L13:
        l r13 = this.h1;
        if (r13 == null) goto L21;
        View r14 = this.h;
        if (r14 == null) goto L21;
        ViewTreeObserver r15 = r14.getViewTreeObserver();
        if (r15 == null) goto L21;
        r15.removeOnPreDrawListener(r13);
    L21:
        if (needAdapterStatusBarColor() == true) goto L23;
    L29:
        AnnieFragmentManager.f(containerId(), null, 6);
        View r16 = this.Y;
        if (r16 == null) goto L38;
        ViewTreeObserver r17 = r16.getViewTreeObserver();
        if (r17 == null) goto L38;
        if (r17.isAlive() == false) goto L38;
        com.bytedance.android.annie.container.fragment.c r18 = this.W;
        if (r18 == null) goto L38;
        r17.removeOnGlobalLayoutListener(r18);
    L38:
        release();
        return;
    L23:
        if (com.bytedance.android.annie.ng.g.g == false) goto L29;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L29;
        if (this.g1 == false) goto L29;
        com.bytedance.android.annie.util.i.h(getActivity());
        this.g1 = false;
        goto L29
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onDetach() {
        super.onDetach();
        Disposable r0 = this.G;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.y1.dispose();
        w8.d r1 = this.k0;
        if (r1 == null) goto L9;
        r1.a(false);
        return;
    }

    public final void onPause() {
        super.onPause();
        IHybridComponent r0 = getMAnnieCard();
        if ((r0 instanceof AnnieCard) == false) goto L5;
        AnnieCard r1 = (AnnieCard) r0;
    L6:
        if (r1 == null) goto L13;
        IHybridComponent r10 = r1.getMCurrentHybridComponent();
        if ((r10 instanceof BaseHybridComponent) == false) goto L10;
        BaseHybridComponent r11 = (BaseHybridComponent) r10;
    L11:
        if (r11 == null) goto L13;
        r11.onPause();
        goto L13
    L10:
        r11 = null;
    L13:
        IHybridComponent r12 = getMAnnieCard();
        int r13 = com.bytedance.android.annie.container.fragment.n.a;
        boolean r14 = false;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L18
        r15.put("visible", false);     // Catch: JSONException -> L18
        if (r12 == null) goto L20;
        r12.sendJsEvent("H5_visibilityChange", r15);     // Catch: JSONException -> L18
    L20:
        w8.d r16 = this.k0;
        if (r16 == null) goto L23;
        r16.a(false);
    L23:
        FragmentActivity r17 = getActivity();
        if (r17 != null) goto L26;
    L28:
        if (r14 == false) goto L33;
        AnnieFragmentManager.f(containerId(), null, 6);
        return;
    L33:
        return;
    L26:
        if (r17.isFinishing() != true) goto L28;
        r14 = true;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r10 = new StringBuilder("===onResume: ");
        String r11 = getUrl();
        if (r11 != null) goto L9;
        r11 = "empty";
    L9:
        r10.append(r11);
        r10.append("===");
        r1.e("AnnieFragment", r10.toString());
    L10:
        IHybridComponent r12 = getMAnnieCard();
        int r13 = com.bytedance.android.annie.container.fragment.n.a;
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L15
        r14.put("visible", true);     // Catch: JSONException -> L15
        if (r12 == null) goto L17;
        r12.sendJsEvent("H5_visibilityChange", r14);     // Catch: JSONException -> L15
    L17:
        w8.d r15 = this.k0;
        if (r15 == null) goto L20;
        r15.a(true);
    L20:
        IHybridComponent r16 = getMAnnieCard();
        View r17 = null;
        if ((r16 instanceof AnnieCard) == false) goto L23;
        AnnieCard r18 = (AnnieCard) r16;
    L24:
        boolean r19 = false;
        if (r18 == null) goto L44;
        IHybridComponent r20 = r18.getMCurrentHybridComponent();
        if ((r20 instanceof BaseHybridComponent) == false) goto L29;
        BaseHybridComponent r21 = (BaseHybridComponent) r20;
    L30:
        if (r21 == null) goto L33;
        r21.onResume();
    L33:
        if (r18.F == false) goto L43;
        CardCustomMonitorKey r22 = CardCustomMonitorKey.UserOpenTime;
        Bundle r23 = r18.k.getBundle();
        if (r23 == null) goto L37;
        long r24 = r23.getLong("open_time");
    L38:
        r18.p(r22, Long.valueOf(r24));
        CardCustomMonitorKey r25 = CardCustomMonitorKey.LoadScene;
        if (r18.h == false) goto L41;
        int r26 = 2;
    L42:
        r18.p(r25, Integer.valueOf(r26));
        r18.F = false;
        goto L43
    L41:
        r26 = 0;
        goto L42
    L37:
        r24 = 0;
    L43:
        r18.p(CardCustomMonitorKey.DidAppear, Long.valueOf(System.currentTimeMillis()));
        goto L44
    L29:
        r21 = null;
    L44:
        FragmentParamVoNew r27 = this.e;
        if (r27 != null) goto L47;
    L49:
        boolean r28 = false;
    L50:
        if (r28 == true) goto L59;
        FragmentParamVoNew r29 = this.e;
        if (r29 != null) goto L54;
    L56:
        boolean r30 = false;
    L57:
        if (r30 == true) goto L59;
        boolean r31 = true;
    L60:
        Lazy r32 = AnnieFragmentManager.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        if (AnnieFragmentManager.c().isEmpty() == false) goto L63;
        boolean r33 = true;
    L75:
        if (r33 == true) goto L77;
        if (r31 == true) goto L77;
    L78:
        Bundle r34 = getArguments();
        if (r34 != null) goto L81;
    L83:
        boolean r35 = false;
    L84:
        if (r35 == false) goto L86;
        initStatusBar();
    L86:
        FragmentParamVoNew r36 = this.e;
        if (r36 != null) goto L89;
    L91:
        if (r19 == false) goto L105;
        if ((getMAnnieCard() instanceof HybridCard) == false) goto L105;
        IHybridComponent r37 = getMAnnieCard();
        if ((r37 instanceof HybridCard) == false) goto L97;
        HybridCard r38 = (HybridCard) r37;
    L98:
        if (r38 == null) goto L105;
        if (r38.getDestroyedFlag() == false) goto L105;
        FragmentParamVoNew r39 = this.e;
        if (r39 == null) goto L105;
        setMAnnieCard(W90(r39));
        goto L105
    L97:
        r38 = null;
    L105:
        if ((getMAnnieCard() instanceof AnnieCard) == false) goto L109;
        IHybridComponent r40 = getMAnnieCard();
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type com.bytedance.android.annie.card.AnnieCard");
        if (((AnnieCard) r40).getLoadSuccess() == false) goto L109;
        ea0();
    L109:
        IHybridComponent r41 = getMAnnieCard();
        if ((r41 instanceof AnnieCard) == false) goto L112;
        AnnieCard r42 = (AnnieCard) r41;
    L113:
        if (r42 == null) goto L127;
        FragmentParamVoNew r43 = this.e;
        if (r43 == null) goto L117;
        String r44 = r43.e();
    L118:
        View r45 = this.h;
        if (r45 == null) goto L121;
        r17 = r45.findViewById(2131374652);
    L121:
        r42.setErrorPageRoot((ViewGroup) r17);
        r42.setDialogWidth(this.y);
        r42.j(r44);
        r42.setErrorPageRetryHandler(new AnnieFragment$onResume$2$2(this));
        Function0<Unit> r46 = r42.getMAnnieContext().b;
        if (r46 == null) goto L125;
        r42.setErrorPageCloseHandler(r46);
    L125:
        if (r42.h == false) goto L127;
        r42.l();
        goto L127
    L117:
        r44 = "default";
    L127:
        FragmentParamVoNew r47 = this.e;
        if (r47 == null) goto L133;
        setCloseByGesture(!r47.J1());
        return;
    L133:
        return;
    L112:
        r42 = null;
        goto L113
    L89:
        if (r36.d() != true) goto L91;
        r19 = true;
        goto L91
    L81:
        if (r34.getBoolean("update_status_in_resume") != true) goto L83;
        r35 = true;
    L77:
        realVisibleChange(true);
        goto L78
    L63:
        Set r48 = AnnieFragmentManager.c().entrySet();
        if ((!r48.isEmpty()) == true) goto L67;
        r48 = null;
    L67:
        if (r48 == null) goto L73;
        Map.Entry r49 = (Map.Entry) CollectionsKt.last(r48);
        if (r49 == null) goto L73;
        WeakReference r50 = (WeakReference) r49.getValue();
        if (r50 == null) goto L73;
        HybridFragment r51 = (HybridFragment) r50.get();
    L74:
        r33 = Intrinsics.areEqual(r51, this);
    L73:
        r51 = null;
        goto L74
    L54:
        if (r29.h2() != true) goto L56;
        r30 = true;
    L59:
        r31 = false;
        goto L60
    L47:
        if (r27.f2() != true) goto L49;
        r28 = true;
        goto L50
    L23:
        r18 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public final void onStop() {
        super.onStop();
        this.y1.add(Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), new o(this)));
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final v7.b getLoadingFragment() {
        return this.w;
    }

    public static final boolean T90(AnnieFragment r10) {
        if (com.bytedance.android.annie.ng.g.g == false) goto L8;
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L8;
    L43:
        return false;
    L8:
        if (((Boolean) r10.Q.getValue()).booleanValue() == true) goto L24;
        FragmentParamVoNew r11 = r10.e;
        if (r11 == null) goto L43;
        if (r11.u1() != (-1)) goto L43;
        if (r11.D() == false) goto L22;
        if (r11.i() == false) goto L19;
    L42:
        return true;
    L19:
        if (r11.r() == false) goto L43;
    L22:
        if (r11.f2() == false) goto L43;
    L24:
        FragmentParamVoNew r12 = r10.e;
        if (r12 == null) goto L43;
        if (r12.u1() > (-1)) goto L43;
        if (r12.D() == false) goto L39;
        if (r12.i() == true) goto L36;
        if (r12.r() == false) goto L43;
    L36:
        if (r12.u1() != (-2)) goto L43;
    L39:
        if (r12.f2() == false) goto L43;
        if (r12.u1() != (-1)) goto L43;
        goto L42
    }

    public static final void U90(AnnieFragment r10) {
        if (r10.B != null) goto L5;
        r10.C = null;
        return;
    L5:
        TextView r0 = r10.o;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
    L8:
        FullscreenVideoFrame r1 = r10.A;
        if (r1 == null) goto L15;
        r1.setVisibility(8);
        r1.removeView(r10.B);
        r10.B = null;
        UIUtils.requestOrienation(r10.getActivity(), false);
        WebChromeClient.CustomViewCallback r11 = r10.C;
        if (r11 == null) goto L16;
        r11.onCustomViewHidden();
        return;
    L16:
        return;
    }

    public final View S90(int r10) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r11 = (View) ((LinkedHashMap) this.d).get(2131374651);
        if (r11 != null) goto L14;
        View r12 = getView();
        if (r12 == null) goto L12;
        View r13 = r12.findViewById(2131374651);
        if (r13 == null) goto L12;
        this.d.put(2131374651, r13);
        return r13;
    L12:
        return null;
    L14:
        return r11;
    }

    public final AnnieCard W90(FragmentParamVoNew r33) {
        com.bytedance.android.annie.param.a r10 = this.f;
        String r11 = "AnnieFragment";
        if (r10 == null) goto L10;
        x8.b r12 = r10.d;
        if (r12 == null) goto L10;
        StringBuilder r13 = new StringBuilder("===addHybridCardNew：");
        String r14 = getUrl();
        if (r14 != null) goto L9;
        r14 = "empty";
    L9:
        r13.append(r14);
        r13.append("===");
        r12.f("AnnieFragment", "add_hybrid_card", r13.toString());
    L10:
        Context r15 = getContext();
        if (r15 == null) goto L276;
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        if (r33.U1().length() <= 0) goto L15;
        boolean r17 = true;
    L16:
        if (r17 == false) goto L134;
        if (r33.o() == null) goto L134;
        if ((r15 instanceof Activity) == true) goto L22;
        Activity r18 = null;
    L23:
        String r19 = r33.o();
        if (r19 != null) goto L26;
        r19 = "";
    L26:
        ConcurrentHashMap<Integer, s9.f> r110 = s9.a.a;
        String r111 = getBizKey();
        Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r111, "bizKey");
        com.bytedance.android.annie.ng.a r112 = com.bytedance.android.annie.ng.g.c.get(r111);
        if (r112 == null) goto L33;
        o8.g r113 = r112.d;
        if (r113 == null) goto L33;
        if (r113.b == true) goto L33;
        boolean r114 = true;
    L34:
        if (r114 == true) goto L38;
        Uri r115 = UriProtector.parse(r19);
        String r116 = UriProtector.getQueryParameter(r115, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r116 == null) goto L38;
        String r117 = UriProtector.getQueryParameter(r115, "prerender_cache_key");
        Uri r118 = UriProtector.parse(r116);     // Catch: Exception -> L79
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L79
        String r27 = "empty";
        r20.append(r118.getScheme());     // Catch: Exception -> L77
        r20.append(':');     // Catch: Exception -> L77
        if (r118.getPort() != (-1)) goto L45;
        Object r119 = "";
    L46:
        r20.append(r119);     // Catch: Exception -> L77
        r20.append("//");     // Catch: Exception -> L77
        r20.append(r118.getHost());     // Catch: Exception -> L77
        r20.append(r118.getPath());     // Catch: Exception -> L77
        String r21 = r20.toString() + '_' + r117;
        ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r22 = s9.a.c;
        if (r22.get(r111) == null) goto L55;
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r23 = r22.get(r111);
        if (r23 == null) goto L55;
        WeakReference r24 = (WeakReference) r23.get(r21);
        if (r24 == null) goto L55;
        HybridCard r25 = (HybridCard) r24.get();
    L56:
        r11 = "AnnieFragment";
        if (r25 == null) goto L63;
        r15 = r15;
        if (r18 != null) goto L61;
    L62:
        j9.b r120 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r26 = new JSONObject();
        r26.put("biz", r111);
        r26.put("cache_key", r21);
        r26.put(com.bytedance.android.ec.core.event.a.KEY_URL, r116);
        r26.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "success");
        r26.put(com.bytedance.android.ec.core.event.a.KEY_MSG, "success");
        Unit r28 = Unit.INSTANCE;
        j9.b.a.a(r120, r25, "annie_container_prerender_fetch", r116, r26, null, null, null, 1, 320);
    L65:
        if (r25 == null) goto L68;
        s9.a.f(r21, r111, false);
        j9.b r121 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r29 = new JSONObject();
        r29.put("biz", r111);
        r29.put("cache_key", r21);
        r29.put(com.bytedance.android.ec.core.event.a.KEY_URL, r116);
        r29.put("type", 0);
        r29.put(com.bytedance.android.ec.core.event.a.KEY_MSG, "use clean");
        j9.b.a.a(r121, r25, "annie_container_prerender_clear", r116, r29, null, null, null, 1, 320);
    L68:
        if ((r25 instanceof AnnieCard) == false) goto L70;
        AnnieCard r30 = (AnnieCard) r25;
    L71:
        if (r30 == null) goto L82;
        com.bytedance.android.annie.param.a r31 = r30.getMAnnieContext();
        if (r31 == null) goto L82;
        String r32 = r31.getMonitorID();
        if (r32 == null) goto L82;
        ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).V0().a(r32, "is_prerender_hit", 1);
    L82:
        if (r25 == null) goto L116;
        if ((r25 instanceof AnnieCard) == false) goto L116;
        r25.setPreRender(true);
        Map<String, ? extends Object> r34 = MapsKt.mapOf(TuplesKt.to("queryItems", y.a(r19)));
        AnnieCard r35 = (AnnieCard) r25;
        Intrinsics.checkNotNullParameter(r33, "cardParamVoNew");
        IHybridComponent r36 = r35.getMCurrentHybridComponent();
        if (r36 != null) goto L88;
    L94:
        r25.sendJsEvent("prerenderPageWillOpen", new JSONObject());
        ViewParent r37 = r35.getParent();
        if ((r37 instanceof ViewGroup) == false) goto L97;
        ViewGroup r38 = (ViewGroup) r37;
    L98:
        if (r38 == null) goto L100;
        r38.removeAllViews();
    L100:
        r25.addOnPreDrawListener();
        FragmentParamVoNew r39 = this.e;
        if (r39 == null) goto L103;
        X90(r35, r39);
    L103:
        com.bytedance.android.annie.param.a r40 = this.f;
        if (r40 == null) goto L113;
        b7.b r41 = r40.getCommonLifecycle();
        if (r41 == null) goto L109;
        r40.setCommonLifecycle(new com.bytedance.android.annie.container.fragment.d(r41, this));
    L109:
        if (r25.getLoadSuccess() == false) goto L113;
        b7.b r42 = r40.getCommonLifecycle();
        if (r42 == null) goto L113;
        r42.onLoadSuccess(r25);
    L113:
        if (r18 == 0) goto L116;
        r25.e(r18);
        goto L116
    L97:
        r38 = null;
        goto L98
    L88:
        if (r36.hybridType() != IHybridComponent.HybridType.H5) goto L93;
        WebComponent r43 = (WebComponent) r36;
        Intrinsics.checkNotNullParameter(r33, "cardParamVoNew");
        x8.b r44 = r43.e.d;
        StringBuilder r45 = new StringBuilder("===forceUpdateGlobalProps: ");
        String r46 = r33.o();
        if (r46 != null) goto L92;
        r46 = r27;
    L92:
        r45.append(r46);
        r45.append("===");
        r44.e("WebComponent", r45.toString());
        r43.f.evaluateJavascript(r43.g(r34, true, r33), null);
        goto L94
    L93:
        r36.updateGlobalProps(r34);
    L116:
        if ((r25 instanceof AnnieCard) == false) goto L118;
        AnnieCard r47 = (AnnieCard) r25;
    L119:
        if (r47 == null) goto L121;
        X90(r47, this.e);
    L122:
        r16.element = r47;
        if (r47 != null) goto L132;
        com.bytedance.android.annie.param.a r48 = this.f;
        if (r48 == null) goto L130;
        b7.b r49 = r48.getCommonLifecycle();
        if (r49 == null) goto L129;
        r48.setCommonLifecycle(new com.bytedance.android.annie.container.fragment.d(r49, this));
    L129:
        AnnieCard r50 = new AnnieCard(r15, r33, r48);
        X90(r50, r33);
    L131:
        r47 = r50;
        goto L132
    L130:
        r50 = null;
    L132:
        String r51 = r11;
    L191:
        if (r47 == null) goto L276;
        if (ca0() == false) goto L210;
        FrameLayout r0 = (FrameLayout) S90(2131374651);
        if (r0 == null) goto L197;
        r0.addView(r47, ba0());
    L197:
        FragmentParamVoNew r1 = this.e;
        if (r1 == null) goto L227;
        String r52 = r1.C1();
        if (r52 == null) goto L227;
        if (StringsKt.isBlank(r52) == true) goto L227;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L208
        int r54 = Color.parseColor(r52);     // Catch: Throwable -> L208
        FrameLayout r55 = (FrameLayout) S90(2131374651);     // Catch: Throwable -> L208
        if (r55 == null) goto L206;
        r55.setBackgroundColor(r54);     // Catch: Throwable -> L208
    L206:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L208
    L208:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L227:
        com.bytedance.android.annie.param.a r57 = this.f;
        if (r57 == null) goto L233;
        x8.b r58 = r57.d;
        if (r58 == null) goto L233;
        r58.e(r51, "create annie card succeed and add it");
    L233:
        if (r47.h == false) goto L240;
        com.bytedance.android.annie.param.a r59 = this.f;
        if (r59 == null) goto L283;
        x8.b r60 = r59.d;
        if (r60 == null) goto L283;
        r60.e(r51, "prerender annie card");
    L283:
        return r47;
    L240:
        if (getMarkPendingLoad() == false) goto L249;
        if (((Boolean) this.H.getValue()).booleanValue() == false) goto L249;
        setMarkPendingLoad(false);
        a7.a.a(r47, null, null, 3);
        com.bytedance.android.annie.param.a r61 = this.f;
        if (r61 == null) goto L283;
        x8.b r62 = r61.d;
        if (r62 == null) goto L283;
        r62.e(r51, "load for pending case");
    L249:
        if (getMSupportLazyLoad() == false) goto L258;
        FragmentParamVoNew r63 = this.e;
        if (r63 != null) goto L253;
    L255:
        boolean r64 = false;
    L256:
        if (r64 == false) goto L258;
    L267:
        if (this.p1 == true) goto L273;
        com.bytedance.android.annie.param.a r65 = this.f;
        if (r65 == null) goto L283;
        x8.b r66 = r65.d;
        if (r66 == null) goto L283;
        r66.e(r51, "lazy load annie card");
    L273:
        a7.a.a(r47, null, null, 3);
        goto L283
    L253:
        if (r63.Q1() != true) goto L255;
        r64 = true;
    L258:
        if (r47.f == false) goto L273;
        FragmentParamVoNew r67 = this.e;
        if (r67 != null) goto L262;
    L264:
        boolean r122 = false;
    L265:
        if (r122 == false) goto L273;
    L262:
        if (r67.G1() != true) goto L264;
        r122 = true;
        goto L265
    L210:
        FrameLayout r68 = (FrameLayout) S90(2131374651);
        if (r68 == null) goto L213;
        r68.addView(r47);
    L213:
        int[] r69 = this.u;
        if (r69 == null) goto L224;
        Intrinsics.checkNotNull(r69);
        if (r69.length != 0) goto L218;
        boolean r210 = true;
    L220:
        if ((!r210) == false) goto L224;
        View r70 = r47.getHybridView();
        if (r70 == null) goto L227;
        r70.post(new d(r47, this));
        goto L227
    L218:
        r210 = false;
    L224:
        View r71 = r47.getHybridView();
        if (r71 == null) goto L227;
        r71.setBackgroundColor(this.t);
        goto L227
    L121:
        r47 = null;
        goto L122
    L118:
        r47 = null;
        goto L119
    L70:
        r30 = null;
        goto L71
    L61:
        if (Intrinsics.areEqual(r25.getContext(), r18) == true) goto L62;
    L64:
        j9.b r123 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r72 = new JSONObject();
        r72.put("biz", r111);
        r72.put("cache_key", r21);
        r72.put(com.bytedance.android.ec.core.event.a.KEY_URL, r116);
        r72.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "fail");
        r72.put(com.bytedance.android.ec.core.event.a.KEY_MSG, "no match");
        Unit r73 = Unit.INSTANCE;
        j9.b.a.a(r123, null, "annie_container_prerender_fetch", r116, r72, null, null, null, 1, 320);
        r25 = null;
        goto L65
    L63:
        r15 = r15;
    L55:
        r25 = null;
        goto L56
    L45:
        r119 = Integer.valueOf(r118.getPort());     // Catch: Exception -> L77
    L80:
        int r74 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "解析schema种的url失败:".concat(r19), false);
    L81:
        r25 = null;
    L79:
        r27 = "empty";
    L38:
        r15 = r15;
        r27 = "empty";
    L33:
        r114 = false;
        goto L34
    L22:
        r18 = (Activity) r15;
    L134:
        if (r33.G1() == false) goto L172;
        IHybridComponent r75 = com.bytedance.android.annie.container.fragment.a.b((String) r33.S.getValue());
        if ((r75 instanceof AnnieCard) == false) goto L138;
        AnnieCard r76 = (AnnieCard) r75;
    L139:
        r16.element = r76;
        if (r76 == null) goto L142;
        ViewParent r77 = r76.getParent();
    L144:
        if ((r77 instanceof ViewGroup) == false) goto L146;
        ViewGroup r78 = (ViewGroup) r77;
    L147:
        if (r78 == null) goto L149;
        r78.removeAllViews();
    L149:
        AnnieCard r79 = (AnnieCard) r16.element;
        if (r79 == null) goto L152;
        r79.addOnPreDrawListener();
    L152:
        AnnieCard r80 = (AnnieCard) r16.element;
        if (r80 == null) goto L157;
        FragmentParamVoNew r81 = this.e;
        if (r81 == null) goto L157;
        X90(r80, r81);
    L157:
        com.bytedance.android.annie.param.a r82 = this.f;
        if (r82 == null) goto L172;
        b7.b r83 = r82.getCommonLifecycle();
        if (r83 == null) goto L162;
        r82.setCommonLifecycle(new com.bytedance.android.annie.container.fragment.d(r83, this));
    L162:
        AnnieCard r84 = (AnnieCard) r16.element;
        if (r84 != null) goto L165;
    L167:
        boolean r85 = false;
    L168:
        if (r85 == false) goto L172;
        b7.b r86 = r82.getCommonLifecycle();
        if (r86 == null) goto L172;
        r86.onLoadSuccess((View) r16.element);
        goto L172
    L165:
        if (r84.getLoadSuccess() != true) goto L167;
        r85 = true;
        goto L168
    L146:
        r78 = null;
        goto L147
    L142:
        r77 = null;
        goto L144
    L138:
        r76 = null;
    L172:
        com.bytedance.android.annie.param.a r87 = this.f;
        if (r87 == null) goto L180;
        x8.b r88 = r87.d;
        if (r88 == null) goto L180;
        StringBuilder r89 = new StringBuilder("===getOrCreateCardNew：");
        String r90 = getUrl();
        if (r90 != null) goto L179;
        r90 = "empty";
    L179:
        r89.append(r90);
        r89.append("===");
        String r91 = r89.toString();
        r51 = "AnnieFragment";
        r88.f(r51, "add_hybrid_card", r91);
    L181:
        r47 = (AnnieCard) r16.element;
        if (r47 != null) goto L191;
        com.bytedance.android.annie.param.a r92 = this.f;
        if (r92 == null) goto L189;
        b7.b r93 = r92.getCommonLifecycle();
        if (r93 == null) goto L188;
        r92.setCommonLifecycle(new com.bytedance.android.annie.container.fragment.d(r93, this));
    L188:
        AnnieCard r94 = new AnnieCard(r15, r33, r92);
        X90(r94, r33);
    L190:
        r47 = r94;
        goto L191
    L189:
        r94 = null;
    L180:
        r51 = "AnnieFragment";
        goto L181
    L15:
        r17 = false;
    L276:
        return null;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void closeWithFrom(boolean r10) {
        if (r10 == false) goto L14;
        BaseDialogFragment r11 = getParentFragment();
        if ((r11 instanceof BaseDialogFragment) == false) goto L6;
        BaseDialogFragment r12 = r11;
    L7:
        if (r12 == null) goto L18;
        r12.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L19;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L18:
        return;
    L6:
        r12 = null;
        goto L7
    L14:
        close();
    }

    public final void da0(WebView r10) {
        FragmentParamVoNew r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L14;
        y6.e r11 = aa0();
        String r12 = r10.getUrl();
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.b = r12;
        r10.evaluateJavascript("document.title", new i(this));
        r10.evaluateJavascript("document.getElementsByName('description')[0].content", new j(this));
        r10.evaluateJavascript("document.getElementsByTagName('link')[0].href", new k(this));
        return;
    L14:
        return;
    L5:
        if (r0.I1() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void enableClose(boolean r10) {
        if (isFullScreen() == false) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("type", "systemBack");
        Unit r1 = Unit.INSTANCE;
        ga0(r10, "containerShouldClose", r0);
        return;
    L6:
        BaseDialogFragment r11 = getParentFragment();
        if ((r11 instanceof BaseDialogFragment) == false) goto L9;
        BaseDialogFragment r12 = r11;
    L10:
        if (r12 == null) goto L13;
        r12.U90(r10);
        return;
    L13:
        return;
    L9:
        r12 = null;
        goto L10
    }

    public final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, getBizKey());
    }

    public final void ia0(float r10) {
        int r0 = this.P0;
        if (r0 <= 0) goto L10;
        int r11 = ((int) (r0 * r10)) + com.bytedance.android.annie.util.p.a.a(9);
        if (Math.abs(r11 - this.V0) <= 1) goto L11;
        this.V0 = r11;
        View r1 = this.l;
        if (r1 == null) goto L12;
        r1.setPadding(0, r11, 0, 0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L7;
        x8.b r1 = r0.d;
        if (r1 == null) goto L7;
        r1.f("AnnieFragment", "create_activity", "===onActivityCreated: bundle=" + r10 + "===");
    L7:
        FragmentParamVoNew r11 = this.e;
        int r12 = -1;
        if (r11 != null) goto L10;
    L15:
        if (r12 < 0) goto L20;
        Window r13 = getWindow();
        if (r13 == null) goto L20;
        r13.setSoftInputMode(r12);
    L20:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_HEIGHT.a().booleanValue() == true) goto L22;
    L29:
        addCardAndBindEvent();
        return;
    L22:
        if (isFullScreen() == false) goto L29;
        View r14 = this.h;
        if (r14 == null) goto L26;
        this.h1 = new l(r14, this);
        r14.getViewTreeObserver().addOnPreDrawListener(this.h1);
        Unit r15 = Unit.INSTANCE;
    L27:
        if (r15 != null) goto L31;
        addCardAndBindEvent();
        return;
    L31:
        return;
    L26:
        r15 = null;
        goto L27
    L10:
        if (r11.F1() == false) goto L13;
        r12 = 48;
    L13:
        if (r11.u1() < 0) goto L15;
        r12 = r11.u1();
        goto L15
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        FrameLayout r11 = (FrameLayout) S90(2131374651);
        boolean r0 = false;
        AnnieCard r1 = null;
        if (r11 != null) goto L5;
    L27:
        boolean r12 = false;
    L28:
        if (r12 == false) goto L30;
        return;
    L30:
        if (ca0() == false) goto L36;
        IHybridComponent r13 = getMAnnieCard();
        if ((r13 instanceof AnnieCard) == false) goto L34;
        r1 = (AnnieCard) r13;
    L34:
        if (r1 == null) goto L51;
        FrameLayout.LayoutParams r14 = ba0();
        r1.setLayoutParams(r14);
        r1.f(r14.width, r14.height);
        return;
    L51:
        return;
    L36:
        FragmentParamVoNew r15 = this.e;
        if (r15 != null) goto L39;
    L41:
        if (r0 == true) goto L43;
        return;
    L43:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L54;
        IHybridComponent r16 = getMAnnieCard();
        if ((r16 instanceof AnnieCard) == false) goto L47;
        r1 = (AnnieCard) r16;
    L47:
        if (r1 == null) goto L55;
        t r17 = t.a;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(t.g(requireActivity()), t.f(requireActivity()));
        r1.setLayoutParams(r18);
        r1.f(r18.width, r18.height);
        return;
    L55:
        return;
    L54:
        return;
    L39:
        if (r15.h2() != true) goto L41;
        r0 = true;
        goto L41
    L5:
        if (r11.getChildCount() != 0) goto L27;
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        FragmentParamVoNew r20 = this.e;
        if (r20 == null) goto L25;
        if (r20.G1() == false) goto L25;
        IHybridComponent r21 = com.bytedance.android.annie.container.fragment.a.b((String) r20.S.getValue());
        if ((r21 instanceof AnnieCard) == false) goto L13;
        AnnieCard r22 = (AnnieCard) r21;
    L14:
        r19.element = r22;
        if (r22 == null) goto L17;
        ViewParent r23 = r22.getParent();
    L19:
        if ((r23 instanceof ViewGroup) == false) goto L21;
        ViewGroup r24 = (ViewGroup) r23;
    L22:
        if (r24 == null) goto L25;
        r24.removeAllViews();
        goto L25
    L21:
        r24 = null;
        goto L22
    L17:
        r23 = null;
        goto L19
    L13:
        r22 = null;
    L25:
        if (r19.element == null) goto L27;
        r11.post(new com.bytedance.android.annie.container.fragment.m(this, r19, r11));
        r12 = true;
        goto L28
    }

    public final void onCreate(Bundle r18) {
        super.onCreate(r18);
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
        return;
    L5:
        com.bytedance.android.annie.param.a r0 = this.f;
        String r10 = "empty";
        if (r0 == null) goto L13;
        x8.b r1 = r0.d;
        if (r1 == null) goto L13;
        StringBuilder r11 = new StringBuilder("===onCreate:");
        String r12 = getUrl();
        if (r12 != null) goto L12;
        r12 = "empty";
    L12:
        r11.append(r12);
        r11.append("===");
        r1.f("AnnieFragment", "create", r11.toString());
    L13:
        Bundle r13 = getArguments();
        if (r13 == null) goto L16;
        FragmentParamVoNew r14 = (FragmentParamVoNew) r13.getParcelable("hybrid_common_vo_new");
    L18:
        if ((r14 instanceof FragmentParamVoNew) == true) goto L21;
        r14 = null;
    L21:
        this.e = r14;
        if (r14 == null) goto L24;
        HybridKitType r15 = r14.a;
    L26:
        if (r15 != HybridKitType.LYNX) goto L28;
        boolean r16 = true;
    L29:
        this.r = new u7.c(r16, com.bytedance.android.annie.ng.g.b().c.a);
        FragmentParamVoNew r17 = this.e;
        if (r17 == null) goto L173;
        String r19 = "#00000000";
        this.t = com.bytedance.android.annie.container.fragment.n.a(r17.s(), r17.z1(), ColorProtector.parseColor("#00000000"));
        String r110 = r17.g();
        if (r110 == null) goto L34;
        List r20 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
    L35:
        List r21 = r20;
        if (r21 != null) goto L38;
    L41:
        boolean r22 = true;
    L42:
        if (r22 == true) goto L57;
        int r23 = r20.size();
        if (2 <= r23) goto L46;
    L48:
        boolean r24 = false;
    L49:
        if (r24 == false) goto L57;
        this.u = new int[r20.size()];
        Iterator r25 = r20.iterator();
        int r26 = 0;
    L52:
        if (r25.hasNext() == false) goto L57;
        int r111 = r26 + 1;
        int r112 = com.bytedance.android.annie.container.fragment.n.a((String) r25.next(), r17.z1(), ColorProtector.parseColor("#00000000"));
        int[] r113 = this.u;
        if (r113 == null) goto L56;
        r113[r26] = r112;
    L56:
        r26 = r111;
        goto L52
    L46:
        if (r23 >= 4) goto L48;
        r24 = true;
    L57:
        this.v = r17.h();
        if (r17.h2() == false) goto L83;
        HashMap<String, List<WeakReference<Activity>>> r27 = r7.a.a;
        String r28 = r17.T1();
        String r29 = r17.P1();
        FragmentActivity r114 = getActivity();
        Intrinsics.checkNotNullParameter(r28, "pageTag");
        Intrinsics.checkNotNullParameter(r29, "launchMode");
        if (AnnieConfigSettingKeys.HYBRID_ENABLE_REMOVE_SAME_PAGE.a().booleanValue() == true) goto L62;
        x8.a.d("FullScreenPageRecord", "disable remove same page by setting", true);
        goto L83
    L62:
        StringsKt.isBlank(r28);
        int r115 = x8.a.a;
        x8.a.d("FullScreenPageRecord", "start register pageTag " + r28 + " launchMode " + r29 + " activity " + r114, true);
        if (Intrinsics.areEqual(r29, "remove_same_page") == false) goto L76;
        x8.a.d("FullScreenPageRecord", "start close activity pageTag: " + r28, true);
        List<WeakReference<Activity>> r30 = r7.a.a.get(r28);
        if (r30 == null) goto L73;
        Iterator<T> r116 = r30.iterator();
    L68:
        if (r116.hasNext() == false) goto L73;
        Activity r117 = (Activity) ((WeakReference) r116.next()).get();
        if (r117 == null) goto L68;
        r117.finish();
    L73:
        List<WeakReference<Activity>> r31 = r7.a.a.get(r28);
        if (r31 == null) goto L76;
        r31.clear();
    L76:
        if (r114 == null) goto L83;
        StringsKt.isBlank(r28);
        HashMap<String, List<WeakReference<Activity>>> r32 = r7.a.a;
        List<WeakReference<Activity>> r118 = r32.get(r28);
        if (r118 == null) goto L81;
        r118.add(new WeakReference(r114));
        goto L83
    L81:
        r32.put(r28, CollectionsKt.mutableListOf(new WeakReference[]{new WeakReference(r114)}));
    L83:
        if (r17.b2() == false) goto L173;
        int r33 = com.bytedance.android.annie.container.fragment.n.a;
        int r34 = this.t;
        com.bytedance.android.annie.ng.g.b().getClass();
        boolean r35 = com.bytedance.android.annie.ng.e.a.k;
        if (r34 != ColorProtector.parseColor("#00ffffff")) goto L87;
    L88:
        if (r35 == false) goto L90;
        r19 = IHostContextDepend.SKIN_TYPE_WHITE;
    L90:
        r34 = ColorProtector.parseColor(r19);
    L91:
        this.t = r34;
        goto L173
    L87:
        if (r34 != (-1)) goto L91;
    L38:
        if (r21.isEmpty() == true) goto L41;
        r22 = false;
        goto L42
    L34:
        r20 = null;
    L173:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L120
        FragmentParamVoNew r37 = this.e;     // Catch: Throwable -> L120
        if (r37 == null) goto L117;
        String r38 = r37.b;     // Catch: Throwable -> L120
        if (r38 == null) goto L117;
        String r39 = r37.o();     // Catch: Throwable -> L120
        FragmentParamVoNew r40 = this.e;     // Catch: Throwable -> L120
        if (r40 == null) goto L99;
        BaseHybridParamVoNew.HybridType r41 = r40.M1();     // Catch: Throwable -> L120
    L101:
        if (r41 != BaseHybridParamVoNew.HybridType.LYNX) goto L103;
    L116:
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L120
    L118:
        Object r43 = Result.constructor-impl(r42);     // Catch: Throwable -> L120
    L122:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L125;
        x8.a.c("AnnieFragment", r44, false);
    L125:
        com.bytedance.android.annie.param.a r45 = this.f;
        if (r45 == null) goto L135;
        x8.b r46 = r45.d;
        if (r46 == null) goto L135;
        StringBuilder r47 = new StringBuilder("===parseArgs: ");
        String r48 = getUrl();
        if (r48 == null) goto L133;
        r10 = r48;
    L133:
        r47.append(r10);
        r47.append("===");
        r46.f("AnnieFragment", "parse_args", r47.toString());
    L135:
        if (this.f != null) goto L158;
        this.p1 = true;
        Bundle r49 = new Bundle();
        r49.putBoolean("container_has_recreated", true);
        Unit r50 = Unit.INSTANCE;
        com.bytedance.android.annie.param.a r51 = new com.bytedance.android.annie.param.a(null, r49, null, 27);
        FragmentParamVoNew r52 = this.e;
        if (r52 == null) goto L139;
        String r53 = r52.b;
    L140:
        r51.setUrl(r53);
        FragmentParamVoNew r54 = this.e;
        if (r54 == null) goto L145;
        BaseHybridParamVoNew.HybridType r55 = r54.M1();
        if (r55 == null) goto L145;
        String r56 = r55.toMonitorString();
    L146:
        r51.setType(r56);
        h8.c r57 = new h8.c(null);
        r57.onInit(r51);
        r57.onBeforeOpenContainer();
        FragmentParamVoNew r58 = this.e;
        String r59 = "";
        if (r58 == null) goto L150;
        String r60 = r58.o();
        if (r60 == null) goto L150;
    L151:
        FragmentParamVoNew r61 = this.e;
        if (r61 == null) goto L157;
        String r62 = r61.c;
        if (r62 == null) goto L157;
        r59 = r62;
    L157:
        r57.onPrepareInitDataStart(r60, r59, false);
        r51.setCommonLifecycle(r57);
        this.f = r51;
    L150:
        r60 = "";
    L145:
        r56 = null;
        goto L146
    L139:
        r53 = null;
    L158:
        com.bytedance.android.annie.param.a r63 = this.f;
        if (r63 != null) goto L161;
    L163:
        this.D = new WeakHandler(this);
        initStatusBar();
        FragmentParamVoNew r64 = this.e;
        if (r64 == null) goto L183;
        String r65 = r64.b;
        if (r65 == null) goto L184;
        Set<String> r66 = SlardarMonitorUtils.a;
        if (r64.a != HybridKitType.LYNX) goto L170;
        String r67 = "lynx";
    L171:
        SlardarMonitorUtils.a(r65, this, r67);
        return;
    L170:
        r67 = "H5";
        goto L171
    L184:
        return;
    L183:
        return;
    L161:
        if (r63.b != null) goto L163;
        r63.b = new AnnieFragment$onCreate$3$1(this);
        goto L163
    L103:
        if (LiveSecLinkManager.b(r38, r39, getBizKey()) == false) goto L116;
        com.bytedance.android.annie.param.a r68 = this.f;     // Catch: Throwable -> L120
        if (r68 == null) goto L110;
        x8.b r69 = r68.d;     // Catch: Throwable -> L120
        if (r69 == null) goto L110;
        r69.a("AnnieFragment", "invalid scheme " + r39);     // Catch: Throwable -> L120
    L110:
        com.bytedance.android.annie.param.a r70 = this.f;     // Catch: Throwable -> L120
        if (r70 == null) goto L115;
        b7.b r71 = r70.getCommonLifecycle();     // Catch: Throwable -> L120
        if (r71 == null) goto L115;
        r71.onContainerError(null, 500, "invalid scheme " + r39);     // Catch: Throwable -> L120
    L115:
        close();     // Catch: Throwable -> L120
        goto L116
    L99:
        r41 = null;
    L117:
        r42 = null;
    L120:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L122
    L28:
        r16 = false;
        goto L29
    L24:
        r15 = null;
        goto L26
    L16:
        r14 = null;
        goto L18
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onInjectShareInfo(y6.e r10) {
        View r11 = this.p;
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void realVisibleChange(boolean r10) {
        if (r10 != this.v1) goto L5;
        return;
    L5:
        this.v1 = r10;
        IHybridComponent r0 = getMAnnieCard();
        if ((r0 instanceof AnnieCard) == false) goto L8;
        AnnieCard r1 = (AnnieCard) r0;
    L9:
        if (r1 == null) goto L22;
        String r11 = "app";
        if (r10 == true) goto L13;
        if (r10 == true) goto L21;
        if (Annie.INSTANCE.isBackground() == true) goto L19;
    L15:
        r11 = AIStateLogRequest.SOURCE_PAGE;
    L19:
        r1.g(r10, r11);
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    L13:
        if (this.x1 == false) goto L15;
    L22:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void registerLifecycleListener(HybridFragment.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleListener");
        ((ArrayList) this.M).add(r10);
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final void registerOnRequestPermissionsCallBack(com.bytedance.android.annie.bridge.method.permission.b r10) {
        Intrinsics.checkNotNullParameter(r10, "onRequestPermissionsCallBack");
        this.G1 = r10;
    }

    public final void setArguments(Bundle r10) {
        if (r10 == null) goto L4;
        FragmentParamVoNew r0 = (FragmentParamVoNew) r10.getParcelable("hybrid_common_vo_new");
    L5:
        if (r0 == null) goto L8;
        super.setArguments(r10);
        return;
    L8:
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setCloseByGesture(boolean r10) {
        ga0(r10, "on_key_back", new JSONObject());
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setHybridNavBarColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "navBarColor");
        View r0 = this.g;     // Catch: Exception -> L7
        if (r0 == null) goto L16;
        r0.setBackgroundColor(Color.parseColor(r10));     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        com.bytedance.android.annie.param.a r1 = this.f;
        if (r1 == null) goto L17;
        x8.b r11 = r1.d;
        if (r11 == null) goto L18;
        x8.b.c(r11, e);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setHybridStatusBarBgColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        com.bytedance.android.annie.container.fragment.n.f(getActivity(), r10);
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setHybridStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        if (Intrinsics.areEqual(r10, "light") == false) goto L6;
        com.bytedance.android.annie.util.i.h(getActivity());
        return;
    L6:
        if (Intrinsics.areEqual(r10, "dark") == false) goto L10;
        com.bytedance.android.annie.util.i.j(getActivity(), Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setHybridTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        TextView r0 = this.o;
        if (r0 == null) goto L7;
        r0.setText(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setHybridTitleColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        TextView r0 = this.o;     // Catch: Exception -> L7
        if (r0 == null) goto L16;
        r0.setTextColor(Color.parseColor(r10));     // Catch: Exception -> L7
        return;
    L16:
        return;
    L7:
        e = move-exception;
        com.bytedance.android.annie.param.a r1 = this.f;
        if (r1 == null) goto L17;
        x8.b r11 = r1.d;
        if (r11 == null) goto L18;
        x8.b.c(r11, e);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.O = r10;
        IHybridComponent r0 = getMAnnieCard();
        if (r0 == null) goto L6;
        r0.setJSBridgeListener(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public final void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        this.N = r10;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, a7.b
    public final void setRadius(float r10) {
        IHybridComponent r0 = getMAnnieCard();
        if (r0 == null) goto L6;
        r0.setRadius(r10);
        return;
    }

    public final void setUserVisibleHint(boolean r10) {
        super.setUserVisibleHint(r10);
        if (r10 == true) goto L5;
    L7:
        realVisibleChange(r10);
        return;
    L5:
        if (this.v1 == false) goto L7;
        this.v1 = false;
        goto L7
    }

    public static final void V90(AnnieFragment r10, y6.c r11) {
        com.bytedance.android.annie.param.a r0 = r10.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r12 = new StringBuilder("===registerBridge: ");
        String r13 = r10.getUrl();
        if (r13 != null) goto L9;
        r13 = "empty";
    L9:
        r12.append(r13);
        r12.append("===");
        r1.e("AnnieFragment", r12.toString());
    L10:
        Iterator<T> r14 = ((w8.c) r10.getService(w8.c.class)).provideStateFulFragmentMethods(r10).entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        ((ArrayList) r10.M).add(r15.getValue());
        r11.registerMethod((String) r15.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r15.getValue());
        goto L12
    L14:
        int r16 = j0.a;
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Map r17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("setTitle", new m0(r10)), TuplesKt.to("cancelLoading", new n0(r10)), TuplesKt.to("setContainer", new o0(r10))});
        Map r18 = MapsKt.mapOf(new Pair[]{TuplesKt.to("requestPermission", new p0(r10)), TuplesKt.to("createCalendarEvent", new q0(r10)), TuplesKt.to("deleteCalendarEvent", new r0(r10)), TuplesKt.to("readCalendarEvent", new s0(r10)), TuplesKt.to("showLoading", new t0(r10)), TuplesKt.to("hideLoading", new u0(r10))});
        if (Intrinsics.areEqual(r10.getBizKey(), "webcast") == true) goto L18;
        r17 = MapsKt.plus(r17, r18);
    L18:
        Iterator r19 = r17.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r19.next();
        r11.registerMethod((String) r20.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r20.getValue());
        goto L20
    L22:
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Iterator r21 = MapsKt.mapOf(TuplesKt.to("setSideslip", new h2(r10))).entrySet().iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        Map.Entry r22 = (Map.Entry) r21.next();
        r11.registerMethod((String) r22.getKey(), (com.bytedance.ies.web.jsbridge2.g) r22.getValue());
        goto L24
    L26:
        FragmentActivity r23 = r10.getActivity();
        if (r23 == null) goto L51;
        Iterator r24 = ((CopyOnWriteArraySet) a9.j.c).iterator();
    L30:
        if (r24.hasNext() == false) goto L47;
        y6.a r25 = (y6.a) r24.next();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r23, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Iterator r26 = MapsKt.emptyMap().entrySet().iterator();
    L33:
        if (r26.hasNext() == false) goto L35;
        Map.Entry r27 = (Map.Entry) r26.next();
        r11.registerMethod((String) r27.getKey(), (n56.c) r27.getValue());
        goto L33
    L35:
        Iterator<T> r28 = r25.h(r10).entrySet().iterator();
    L37:
        if (r28.hasNext() == false) goto L39;
        Map.Entry r29 = (Map.Entry) r28.next();
        r11.registerMethod((String) r29.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r29.getValue());
        goto L37
    L39:
        Iterator r30 = r25.g(r23, r10).entrySet().iterator();
    L41:
        if (r30.hasNext() == false) goto L43;
        Map.Entry r31 = (Map.Entry) r30.next();
        ((ArrayList) r10.M).add(r31.getValue());
        r11.registerMethod((String) r31.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r31.getValue());
        goto L41
    L43:
        Iterator<T> r32 = r25.i(r10).entrySet().iterator();
    L45:
        if (r32.hasNext() == false) goto L30;
        Map.Entry r33 = (Map.Entry) r32.next();
        r11.registerMethod((String) r33.getKey(), (com.bytedance.ies.web.jsbridge2.g) r33.getValue());
        goto L45
    L47:
        com.bytedance.android.annie.bridge.p r34 = ((w8.c) r10.getService(w8.c.class)).X(r23, r10);
        r10.V = r34;
        if (r34 == null) goto L51;
        r11.registerMethod("calendar", r34.provide());
    L51:
        if (r10.S90(2131374651) == null) goto L64;
        com.bytedance.ies.web.jsbridge2.f.b r35 = ((w8.c) r10.getService(w8.c.class)).w(r10.S90(2131374651));
        if (r35 == null) goto L65;
        r11.registerMethod("clipScreen", r35);
        return;
    L65:
        return;
    }

    public final void X90(AnnieCard r10, FragmentParamVoNew r11) {
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r12 = new StringBuilder("===bindAnnieCardCallbackNew: ");
        String r13 = getUrl();
        if (r13 != null) goto L9;
        r13 = "empty";
    L9:
        r12.append(r13);
        r12.append("===");
        r1.e("AnnieFragment", r12.toString());
    L10:
        r10.setJSBridgeListener(new e(this, r10));
        r10.c(new f(this, r11, r10));
        r10.o(new g(this, r10, r11, r10));
        r10.setOnScrollChangeListener(new h(this));
        if (AnnieConfigSettingKeys.TRY_FIX_REUSE_CARD_ON_SUCCESS.a().booleanValue() == true) goto L17;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.G1() == false) goto L19;
        com.bytedance.android.annie.container.fragment.a.c((String) r11.S.getValue(), r10);
        return;
    L19:
        return;
    }

    public final View Z90(View r10, Function1<? super View, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        if (((Boolean) r11.invoke(r10)).booleanValue() == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r12 = (ViewGroup) r10;
        int r0 = r12.getChildCount();
        int r13 = 0;
    L9:
        if (r13 >= r0) goto L14;
        View r14 = Z90(r12.getChildAt(r13), r11);
        if (r14 != null) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return r14;
    L14:
        return null;
    }

    public final void ha0(View r10, int r11) {
        if ((r10 instanceof TextView) == false) goto L6;
        com.bytedance.android.annie.util.p r0 = com.bytedance.android.annie.util.p.a;
        Context r1 = requireContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        ((TextView) r10).setCompoundDrawables(r1.getResources().getDrawable(r11), null, null, null);
        return;
    L6:
        if ((r10 instanceof ImageView) == false) goto L10;
        ImageView r12 = (ImageView) r10;
        if (r12 == null) goto L14;
        com.bytedance.android.annie.util.p r13 = com.bytedance.android.annie.util.p.a;
        Context r14 = requireContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        r12.setImageDrawable(r14.getResources().getDrawable(r11));
        return;
    L14:
        return;
    L10:
        if (r10 == null) goto L16;
        r10.setBackgroundResource(r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r10, Map<String, ? extends Object> r11) {
        setCustomMonitorKey(FragmentCustomMonitorKey.HasReload, Integer.valueOf(isLoaded() ? 1 : 0));
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L10;
        x8.b r1 = r0.d;
        if (r1 == null) goto L10;
        StringBuilder r12 = new StringBuilder("===load: ");
        String r13 = getUrl();
        if (r13 != null) goto L9;
        r13 = "empty";
    L9:
        r12.append(r13);
        r12.append("===");
        r1.e("AnnieFragment", r12.toString());
    L10:
        super.load(r10, r11);
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final void requestPermissionsProxy(String[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        super.requestPermissions(r10, r11);
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    @Deprecated(message = "没有业务调用，已废弃")
    public final <T> void sendJsEventWithCache(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        if (ThreadUtils.b() == true) goto L16;
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L9;
        b7.b r1 = r0.getCommonLifecycle();
        if (r1 == null) goto L9;
        r1.onContainerError(null, 400, "should send js event in mainThread, event name:" + r10);
    L9:
        com.bytedance.android.annie.param.a r12 = this.f;
        if (r12 == null) goto L24;
        x8.b r13 = r12.d;
        if (r13 == null) goto L25;
        r13.a("AnnieFragment", "should send js event in mainThread, event name:" + r10 + " ,data: " + r11);
        return;
    L25:
        return;
    L24:
        return;
    L16:
        if ((getMAnnieCard() instanceof AnnieCard) == false) goto L22;
        IHybridComponent r14 = getMAnnieCard();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.android.annie.card.AnnieCard");
        if (((AnnieCard) r14).getLoadSuccess() == false) goto L22;
        IHybridComponent r15 = getMAnnieCard();
        if (r15 == null) goto L26;
        r15.sendJsEvent(r10, r11);
        return;
    L26:
        return;
    L22:
        ((ArrayList) this.J).add(new Pair(r10, r11));
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public final void setCustomMonitorKey(FragmentCustomMonitorKey r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        com.bytedance.android.annie.param.a r0 = this.f;
        if (r0 == null) goto L5;
        String r1 = r0.getMonitorID();
    L6:
        Intrinsics.checkNotNull(r1);
        k9.d r12 = ((k9.e) getService(k9.e.class)).V0();
        com.bytedance.android.annie.param.a r13 = this.f;
        if (r13 == null) goto L11;
        x8.b r14 = r13.d;
        if (r14 == null) goto L11;
        r14.e("AnnieFragment", "setCustomMonitorKey " + r10 + ", value: " + r11 + ", monitorId: " + r1);
    L11:
        int r15 = c.a[r10.ordinal()];
        if (r15 == 1) goto L43;
        if (r15 != 2) goto L16;
        r12.d(r1, "is_container_preload", r11.toString());
        com.bytedance.android.annie.param.a r16 = this.f;
        if (r16 == null) goto L67;
        Bundle r17 = r16.getBundle();
        if (r17 == null) goto L68;
        r17.putString("is_container_preload", r11.toString());
        return;
    L68:
        return;
    L67:
        return;
    L16:
        if (r15 != 3) goto L18;
        r12.d(r1, "is_user_open", r11.toString());
        com.bytedance.android.annie.param.a r18 = this.f;
        if (r18 == null) goto L64;
        Bundle r19 = r18.getBundle();
        if (r19 == null) goto L65;
        r19.putString("is_user_open", r11.toString());
        return;
    L65:
        return;
    L64:
        return;
    L18:
        if (r15 != 4) goto L20;
        r12.d(r1, "is_prerender", r11.toString());
        com.bytedance.android.annie.param.a r20 = this.f;
        if (r20 == null) goto L61;
        Bundle r21 = r20.getBundle();
        if (r21 == null) goto L62;
        r21.putString("is_prerender", r11.toString());
        return;
    L62:
        return;
    L61:
        return;
    L20:
        if (r15 != 5) goto L75;
        r12.d(r1, "has_reload", r11.toString());
        com.bytedance.android.annie.param.a r22 = this.f;
        if (r22 == null) goto L58;
        Bundle r23 = r22.getBundle();
        if (r23 == null) goto L59;
        r23.putString("has_reload", r11.toString());
        return;
    L59:
        return;
    L58:
        return;
    L75:
        return;
    L43:
        if (this.K == false) goto L45;
        return;
    L45:
        this.K = true;
        if ((r11 instanceof Long) == false) goto L52;
        Number r24 = (Number) r11;
        r12.c(r1, "open_time", r24.longValue());
        com.bytedance.android.annie.param.a r25 = this.f;
        if (r25 == null) goto L70;
        Bundle r26 = r25.getBundle();
        if (r26 == null) goto L71;
        r26.putLong("real_open_time", r24.longValue());
        return;
    L71:
        return;
    L70:
        return;
    L52:
        com.bytedance.android.annie.param.a r27 = this.f;
        if (r27 == null) goto L73;
        x8.b r28 = r27.d;
        if (r28 == null) goto L74;
        r28.e("AnnieFragment", "setCustomMonitorKey " + r10 + ", typeof value is not Long, do nothing");
        return;
    L74:
        return;
    L73:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewGroup, com.bytedance.android.annie.view.ForceInterceptConstraintLayout] */
    public final void ga0(final boolean r10, final String r11, final JSONObject r12) {
        if (AnnieConfigSettingKeys.ANNIE_TRY_FIX_FORBID_RIGHT_BACK.a().booleanValue() == true) goto L5;
    L12:
        View r0 = getView();
        if (r0 == null) goto L18;
        r0.setFocusableInTouchMode(true);
        r0.requestFocus();
        r0.setOnKeyListener(new p(this, r11, r12, r10));
        return;
    L18:
        return;
    L5:
        if (hybridType() != IHybridComponent.HybridType.H5) goto L12;
        Object r1 = getView();
        if ((r1 instanceof ForceInterceptConstraintLayout) == false) goto L9;
        ?? r13 = (ForceInterceptConstraintLayout) r1;
    L10:
        if (r13 == 0) goto L16;
        r13.setFocusableInTouchMode(true);
        r13.requestFocus();
        r13.setOnDispatchKeyEvent(new AnnieFragment$setCloseByGesture$1$1(this, r11, r12, r10));
        return;
    L16:
        return;
    L9:
        r13 = 0;
        goto L10
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        Iterator<T> r0 = this.M.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((HybridFragment.a) r0.next()).onActivityResult(r10, r11, r12);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        boolean r0 = false;
        View r16 = r13.inflate(2131558547, r14, false);
        r16.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.U.getValue());
        if (AnnieConfigSettingKeys.FIX_SCREEN_LAYOUT_ORIENTATION_DEVICE_TYPE.a().contains(Build.MODEL) == false) goto L5;
        r16.addOnLayoutChangeListener(new m(this));
    L5:
        this.h = r16;
        com.bytedance.android.annie.param.a r17 = this.f;
        String r10 = "empty";
        if (r17 == null) goto L13;
        x8.b r18 = r17.d;
        if (r18 == null) goto L13;
        StringBuilder r11 = new StringBuilder("===onCreateView：");
        String r12 = getUrl();
        if (r12 != null) goto L12;
        r12 = "empty";
    L12:
        r11.append(r12);
        r11.append("===");
        r18.f("AnnieFragment", "create_container_view", r11.toString());
    L13:
        com.bytedance.android.annie.param.a r19 = this.f;
        if (r19 == null) goto L21;
        x8.b r110 = r19.d;
        if (r110 == null) goto L21;
        StringBuilder r20 = new StringBuilder("===initUi start：");
        String r21 = getUrl();
        if (r21 != null) goto L20;
        r21 = "empty";
    L20:
        r20.append(r21);
        r20.append("===");
        r110.f("AnnieFragment", "init_ui", r20.toString());
    L21:
        FragmentParamVoNew r111 = this.e;
        ViewGroup r22 = null;
        r22 = null;
        if (r111 != null) goto L24;
    L239:
        View r112 = this.i;
        if (r112 == null) goto L242;
        r112.setOnClickListener(new com.bytedance.android.annie.container.fragment.j(this));
    L242:
        View r113 = this.m;
        if (r113 == null) goto L245;
        r113.setOnClickListener(new com.bytedance.android.annie.container.fragment.j(this));
    L245:
        View r114 = this.k;
        if (r114 == null) goto L248;
        r114.setOnClickListener(new com.bytedance.android.annie.container.fragment.l(this));
    L248:
        View r115 = this.j;
        if (r115 == null) goto L251;
        r115.setOnClickListener(new com.bytedance.android.annie.container.fragment.k(this));
    L251:
        View r116 = this.n;
        if (r116 == null) goto L254;
        r116.setOnClickListener(new com.bytedance.android.annie.container.fragment.k(this));
    L254:
        FullscreenVideoFrame r117 = this.A;
        if (r117 == null) goto L257;
        r117.setListener(new com.bytedance.android.annie.container.fragment.b(this));
    L257:
        FragmentParamVoNew r118 = this.e;
        if (r118 != null) goto L260;
    L262:
        boolean r119 = false;
    L263:
        if (r119 == true) goto L270;
        FragmentParamVoNew r120 = this.e;
        if (r120 != null) goto L267;
    L269:
        if (r0 == true) goto L270;
    L293:
        com.bytedance.android.annie.param.a r121 = this.f;
        if (r121 == null) goto L302;
        x8.b r122 = r121.d;
        if (r122 == null) goto L302;
        StringBuilder r1 = new StringBuilder("===bindEvent: ");
        String r23 = getUrl();
        if (r23 == null) goto L301;
        r10 = r23;
    L301:
        r1.append(r10);
        r1.append("===");
        r122.e("AnnieFragment", r1.toString());
    L302:
        this.b1 = (FrameLayout) r16.findViewById(2131372985);
        return r16;
    L267:
        if (r120.h2() != true) goto L269;
        r0 = true;
    L270:
        Window r123 = getWindow();
        if (r123 == null) goto L288;
        View r124 = r123.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L278;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r24 = ThreadMethodProxy.currentThread();
        if (r24 == com.larus.home.impl.utils.c.a) goto L278;
        com.larus.home.impl.utils.c.a(r24, "getDecorView");
    L278:
        View r125 = r124.findViewById(R.id.content);
        if ((r125 instanceof ViewGroup) == false) goto L281;
        ViewGroup r126 = (ViewGroup) r125;
    L282:
        if (r126 == null) goto L288;
        ?? r25 = isFullScreen();
        if (r25 >= r126.getChildCount()) goto L287;
        r126.getChildAt(r25 == true ? 1 : 0);
    L287:
        r22 = r126;
        goto L288
    L281:
        r126 = null;
    L288:
        this.Y = r22;
        this.W = new com.bytedance.android.annie.container.fragment.c(this);
        View r127 = this.Y;
        if (r127 == null) goto L293;
        ViewTreeObserver r128 = r127.getViewTreeObserver();
        if (r128 == null) goto L293;
        r128.addOnGlobalLayoutListener(this.W);
        goto L293
    L260:
        if (r118.f2() != true) goto L262;
        r119 = true;
        goto L263
    L24:
        if (r111.i() == false) goto L26;
    L27:
        t r26 = t.a;
        this.P0 = t.i();
    L29:
        if (r111.L1() == true) goto L31;
    L32:
        Context r27 = getContext();
        if (r27 == null) goto L42;
        u7.c r28 = this.r;
        if (r111.w1() == false) goto L37;
        int r29 = 2131362977;
    L38:
        FrameLayout r30 = (FrameLayout) r16.findViewById(r29);
        int r31 = u7.b.a;
        Intrinsics.checkNotNullParameter(r28, "configModel");
        Intrinsics.checkNotNullParameter(r30, "parent");
        Intrinsics.checkNotNullParameter(r27, "context");
        if (r28.b == false) goto L41;
        u7.a r32 = new w7.b(r27, r30);
    L43:
        this.q = r32;
        if (r32 == null) goto L46;
        View r33 = r32.a();
    L47:
        this.g = r33;
        if (r33 == null) goto L50;
        View r34 = r33.findViewById(2131363762);
    L51:
        this.m = r34;
        View r35 = this.g;
        if (r35 == null) goto L54;
        TextView r36 = (TextView) r35.findViewById(2131388772);
    L55:
        this.o = r36;
        View r37 = this.g;
        if (r37 == null) goto L58;
        View r38 = r37.findViewById(2131364832);
    L59:
        this.p = r38;
        View r39 = this.g;
        if (r39 == null) goto L62;
        View r40 = r39.findViewById(2131366972);
    L63:
        this.n = r40;
        if (r111.w1() == false) goto L86;
        View r41 = this.g;
        if (r41 == null) goto L68;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
    L70:
        if (r42 == null) goto L73;
        r42.height = this.P0 + com.bytedance.android.annie.util.p.a.a(44 + 9);
    L73:
        View r43 = this.g;
        if (r43 == null) goto L76;
        r43.setPadding(0, this.P0 + com.bytedance.android.annie.util.p.a.a(9), 0, 0);
    L76:
        View r44 = this.g;
        if (r44 == null) goto L81;
        r44.setLayoutParams(r42);
    L81:
        if (r111.I1() == false) goto L93;
        View r45 = this.p;
        if (r45 == null) goto L93;
        r45.setVisibility(0);
    L93:
        String r46 = r111.c2();
        if (r46 != null) goto L96;
    L98:
        boolean r47 = false;
    L99:
        if (r47 == false) goto L101;
        String r48 = r111.c2();
        Intrinsics.checkNotNull(r48);
        setHybridTitle(r48);
    L101:
        String r49 = r111.d2();
        if (r49 != null) goto L104;
    L106:
        boolean r50 = false;
    L107:
        if (r50 == false) goto L109;
        String r51 = r111.d2();
        Intrinsics.checkNotNull(r51);
        setHybridTitleColor(r51);
    L109:
        String r52 = r111.R1();
        if (r52 != null) goto L112;
    L114:
        boolean r53 = false;
    L115:
        if (r53 == false) goto L117;
        String r54 = r111.R1();
        Intrinsics.checkNotNull(r54);
        setHybridNavBarColor(r54);
    L117:
        String r55 = r111.c2();
        if (r55 != null) goto L120;
    L122:
        boolean r56 = false;
    L123:
        if (r56 == false) goto L128;
        TextView r57 = this.o;
        if (r57 == null) goto L128;
        r57.setText(r111.c2());
    L128:
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L144;
        int r58 = com.bytedance.android.annie.container.fragment.n.a;
        String r59 = r111.b;
        if (r59 != null) goto L134;
        r59 = "";
    L134:
        if (com.bytedance.android.annie.container.fragment.n.d(r59, Boolean.valueOf(r111.b2())) == false) goto L136;
    L137:
        View r60 = this.g;
        if (r60 == null) goto L140;
        r60.setBackgroundResource(2131231330);
    L140:
        TextView r61 = this.o;
        if (r61 == null) goto L143;
        r61.setTextColor(-16777216);
    L143:
        ha0(this.m, 2131231321);
        ha0(this.n, 2131231331);
        ha0(this.p, 2131231342);
        goto L144
    L136:
        if (r111.w1() == true) goto L137;
    L144:
        this.l = r16.findViewById(2131362980);
        this.i = r16.findViewById(2131362967);
        if (r111.A1() == false) goto L147;
        final View r62 = r16.findViewById(2131362968);
    L148:
        this.j = r62;
        if (r62 == null) goto L152;
        ViewCompat.setAccessibilityDelegate(r62, new AnnieFragment$initBaseTitleBarNew$1$1(r62));
    L152:
        if (r111.N1() != 1) goto L156;
        ha0(this.j, 2131231336);
    L156:
        if (r111.g2() == false) goto L161;
        View r63 = this.j;
        if (r63 == null) goto L161;
        r63.setAlpha(0.0f);
    L161:
        this.k = r16.findViewById(2131362970);
        this.F = (WebRiskHintView) r16.findViewById(2131362982);
        if (r111.W1() == false) goto L170;
        if (r111.D() == false) goto L170;
        View r64 = this.i;
        if (r64 == null) goto L170;
        r64.setVisibility(0);
    L170:
        if (r111.X1() == false) goto L178;
        if (r111.D() == false) goto L178;
        View r65 = this.j;
        if (r65 == null) goto L178;
        r65.setVisibility(0);
    L178:
        if (r111.I1() == false) goto L184;
        View r66 = this.k;
        if (r66 == null) goto L184;
        r66.setVisibility(0);
    L184:
        if (r111.D() == false) goto L187;
        ia0(1.0f);
    L187:
        if (r111.f2() == false) goto L218;
        if (r111.q() == true) goto L193;
        if (r111.g2() == false) goto L218;
    L193:
        if (r111.V1() == true) goto L218;
        if (com.bytedance.android.annie.util.m.a(getActivity()) == true) goto L218;
        View r67 = r16.findViewById(2131383441);
        FragmentParamVoNew r68 = this.e;
        if (r68 == null) goto L199;
        String r69 = r68.O1();
    L200:
        this.H0 = r16.findViewById(2131383440);
        if (r67 == null) goto L205;
        r67.setVisibility(0);
    L205:
        if (Intrinsics.areEqual(IHostContextDepend.SKIN_TYPE_WHITE, r69) == false) goto L210;
        View r70 = this.H0;
        if (r70 == null) goto L218;
        r70.setBackgroundResource(2131231323);
        goto L218
    L210:
        if (Intrinsics.areEqual("dark", r69) == false) goto L214;
        View r71 = this.H0;
        if (r71 == null) goto L218;
        r71.setBackgroundResource(2131231322);
        goto L218
    L214:
        View r72 = this.H0;
        if (r72 == null) goto L218;
        r72.setBackgroundResource(2131231323);
        goto L218
    L199:
        r69 = null;
    L218:
        if (r111.K1() == false) goto L220;
    L231:
        this.A = (FullscreenVideoFrame) r16.findViewById(2131368481);
        com.bytedance.android.annie.param.a r129 = this.f;
        if (r129 == null) goto L239;
        x8.b r130 = r129.d;
        if (r130 == null) goto L239;
        StringBuilder r73 = new StringBuilder("===initUi end: ");
        String r74 = getUrl();
        if (r74 != null) goto L238;
        r74 = "empty";
    L238:
        r73.append(r74);
        r73.append("===");
        r130.f("AnnieFragment", "init_ui", r73.toString());
        goto L239
    L220:
        if (com.bytedance.android.annie.ng.g.b().c.b == true) goto L231;
        Context r131 = getContext();
        if (r131 == null) goto L224;
        v7.b r132 = u7.b.b(this.r, (ViewGroup) r16.findViewById(2131379011), r131, getBizKey());
    L225:
        this.w = r132;
        if (r132 == null) goto L228;
        this.x = r132.a();
    L228:
        v7.b r133 = this.w;
        if (r133 == null) goto L231;
        r133.d();
        goto L231
    L224:
        r132 = null;
        goto L225
    L147:
        r62 = r16.findViewById(2131362969);
        goto L148
    L120:
        if ((!StringsKt.isBlank(r55)) != true) goto L122;
        r56 = true;
        goto L123
    L112:
        if ((!StringsKt.isBlank(r52)) != true) goto L114;
        r53 = true;
        goto L115
    L104:
        if ((!StringsKt.isBlank(r49)) != true) goto L106;
        r50 = true;
        goto L107
    L96:
        if ((!StringsKt.isBlank(r46)) != true) goto L98;
        r47 = true;
        goto L99
    L68:
        r42 = null;
        goto L70
    L86:
        u7.a r75 = this.q;
        if (r75 == null) goto L89;
        r75.d();
    L89:
        View r76 = this.m;
        if (r76 == null) goto L93;
        r76.setVisibility(0);
        goto L93
    L62:
        r40 = null;
        goto L63
    L58:
        r38 = null;
        goto L59
    L54:
        r36 = null;
        goto L55
    L50:
        r34 = null;
        goto L51
    L46:
        r33 = null;
        goto L47
    L41:
        r32 = new w7.a(r27, r30);
        goto L43
    L37:
        r29 = 2131362976;
        goto L38
    L42:
        r32 = null;
        goto L43
    L31:
        if (r111.w1() == false) goto L144;
    L26:
        if (r111.r() == false) goto L29;
        goto L27
    }

    public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        com.bytedance.android.annie.bridge.p r0 = this.V;
        if (r0 == null) goto L12;
        r0.onRequestPermissionsResult(r10, r11, r12);
    L12:
        com.bytedance.android.annie.bridge.method.permission.b r1 = this.G1;     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        r1.onRequestPermissionsResult(r10, r11, r12);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        b8.a r13 = b8.a.a;
        b8.a.a(new b8.b("AnnieFragment", LogLevel.ERROR, e, null, 8), true);
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, a7.b
    public final void setRadius(float r10, float r11, float r12, float r13) {
        IHybridComponent r0 = getMAnnieCard();
        if (r0 == null) goto L6;
        r0.setRadius(r10, r11, r12, r13);
        return;
    }
}

package com.obric.miniapp.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.ai.view.popup.AppletPopup;
import com.bytedance.applet.event.EventDispatcher;
import com.bytedance.applet.utils.MessageUtils;
import com.bytedance.assem.arch.extensions.AssembleExtKt;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.viewModel.IVMSubscriber;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b2;
import com.larus.platform.api.e1;
import com.larus.search.api.IBrowserService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.miniapp.databinding.MiniAppFragmentBinding;
import com.obric.oui.text.OTextView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u0002:\u0002\u0083\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010F\u001a\u00020!H\u0002J\b\u0010G\u001a\u00020!H\u0002J\b\u0010O\u001a\u00020!H\u0016J\u0012\u0010P\u001a\u0002092\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020!H\u0002J&\u0010U\u001a\u0004\u0018\u00010\u001f2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0017J\n\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0006\u0010\\\u001a\u000209J\u001a\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020\u001f2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0017J\b\u0010_\u001a\u000209H\u0016J\u0006\u0010`\u001a\u00020!J\u0006\u0010a\u001a\u000209J\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020RH\u0016J\b\u0010d\u001a\u000209H\u0002J\u0010\u0010e\u001a\u0002092\u0006\u0010f\u001a\u00020!H\u0016J\b\u0010g\u001a\u000209H\u0002J\b\u0010h\u001a\u000209H\u0002J\b\u0010i\u001a\u000209H\u0016J\b\u0010j\u001a\u000209H\u0016J\b\u0010k\u001a\u000209H\u0016J\b\u0010l\u001a\u000209H\u0016J\u000e\u0010m\u001a\u000209H\u0082@¢\u0006\u0002\u0010nJ \u0010o\u001a\u0002092\u0006\u0010p\u001a\u00020Y2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0003J\b\u0010u\u001a\u000209H\u0002J\u0016\u0010v\u001a\u0002092\u0006\u0010w\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010xJ\b\u0010~\u001a\u000209H\u0002J\b\u0010\u007f\u001a\u000209H\u0002J\t\u0010\u0080\u0001\u001a\u000209H\u0002J\t\u0010\u0081\u0001\u001a\u000209H\u0002J\t\u0010\u0082\u0001\u001a\u000209H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000RF\u00103\u001a:\u0012\u0013\u0012\u00110!¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110#¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0004\u0012\u000209\u0018\u000104j\u0004\u0018\u0001`:X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010;\u001a%\u0012\u0013\u0012\u00110!¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0004\u0012\u000209\u0018\u00010<j\u0004\u0018\u0001`>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010I\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!04X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bK\u0010LR\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010{\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010}0|X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/obric/miniapp/view/MiniAppFragment;", "Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "Lcom/bytedance/assem/arch/viewModel/IVMSubscriber;", "<init>", "()V", "mRenderStateVM", "Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "getMRenderStateVM", "()Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "mRenderStateVM$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "schema", "", "binding", "Lcom/obric/miniapp/databinding/MiniAppFragmentBinding;", MemorySourceLinkType.URL, "appletBotId", "fsConversationId", "lastMsgIndex", "", "Ljava/lang/Long;", "appletPage", "Lcom/bytedance/ai/api/model/view/IAIContainerView;", "reader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "morePopup", "Lcom/skydoves/balloon/Balloon;", "trace", "Lcom/larus/platform/api/IPageLoadTrace;", "urlQueryTitle", "webViewClientCustomView", "Landroid/view/View;", "isCurrentFullScreen", "", "originalPaddingTop", "", "originalPaddingBottom", "fullScreen", "closeMethodImpl", "Lcom/obric/miniapp/jsb/MiniAppFragmentCloseMethodImpl;", "hideTitleBar", "statusBarTransparent", "navigationBarTransparent", "showActionBar", "titleBarTransparent", "hideBackButton", "blockBackPress", "backPressedEnabled", "disableBounce", "eventListener", "Lcom/bytedance/ai/event/IEventListener;", "keyboardStatusCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "onShown", "height", "", "Lcom/bytedance/ai/floating/KeyboardStatusCallback;", "speakStatusCallback", "Lkotlin/Function1;", "onSpeak", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "defaultBackgroundColor", "closeActivity", "isRealVisible", "actionBarMode", "titleBarMode", "titleBarBackground", "speakerStatus", "isSpeakerEnable", "speakerVisibleByDefault", "isRedirectQuery", "redirectQueryCall", "bounceWithKeyboard", "getBounceWithKeyboard", "()Z", "bounceWithKeyboard$delegate", "Lkotlin/Lazy;", "isBackPressedEnabled", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleFullScreen", "isFullScreen", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "renderEngine", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "backPressed", "onViewCreated", "view", "doRefresh", "isEntryPage", "close", "onSaveInstanceState", "outState", "backWebPage", "onHiddenChanged", "hidden", "handleRealResume", "handleRealPause", "onResume", "onStop", "onDestroyView", "onDestroy", "setupEventListener", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalWebView", "root", "fragment", "Landroidx/fragment/app/Fragment;", "params", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "initFloatingSpeaker", "updateFloatingBotId", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "floatingSpeakerController", "Lcom/bytedance/ai/api/model/view/IFloatingSpeakerController;", "window", "Lkotlin/Function0;", "Landroid/view/Window;", "setTitleBar", "setTitleBarTitle", "setTitleBarBackgroundColor", "setTitleBarMode", "setTitleBarBackButton", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppFragment extends AIFragmentBase implements IVMSubscriber {
    public static final /* synthetic */ int R = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public MiniAppFragment$setupEventListener$listener$1 D;
    public p E;
    public String F;
    public boolean G;
    public boolean H;
    public String I;
    public String J;
    public String K;
    public String L;
    public boolean M;
    public final z N;
    public final Lazy O;
    public final MiniAppFragment$floatingSpeakerController$1 P;
    public final b0 Q;
    public final com.bytedance.assem.arch.viewModel.b d;
    public final String e;
    public MiniAppFragmentBinding f;
    public String g;
    public String h;
    public String i;
    public Long j;
    public com.bytedance.ai.model.widgets.c k;
    public x1 l;
    public final e1 m;
    public String n;
    public View o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public bla.a t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ MiniAppFragment b;
        public final /* synthetic */ LinearLayout c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r11) {
            this.a.removeOnAttachStateChangeListener(this);
            if (this.b.s == false) goto L5;
            Intrinsics.checkNotNull(this.c);
            LinearLayout r12 = this.c;
            int r5 = r12.getPaddingStart();
            int r6 = r12.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r5 + ",top:0,end:" + r6 + ",bottom:0");
            r12.setPaddingRelative(r5, 0, r6, 0);
            return;
        L5:
            Intrinsics.checkNotNull(this.c);
            LinearLayout r13 = this.c;
            int r7 = r13.getPaddingStart();
            int r8 = r13.getPaddingTop();
            int r9 = r13.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r13.getClass().getSimpleName() + ",source:,start:" + r7 + ",top:" + r8 + ",end:" + r9 + ",bottom:0");
            r13.setPaddingRelative(r7, r8, r9, 0);
        }

        public b(View r1, MiniAppFragment r2, LinearLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void F60() {
    }

    public final com.bytedance.tiktok.proxy.b NY() {
        return this;
    }

    public final LifecycleOwner Tm() {
        return this;
    }

    public final LifecycleOwner aM() {
        return this;
    }

    public final com.bytedance.tiktok.proxy.a dh() {
        return null;
    }

    public final LifecycleOwner fr() {
        return null;
    }

    public final com.bytedance.tiktok.proxy.a oq() {
        return this;
    }

    public final com.bytedance.tiktok.proxy.c<com.bytedance.tiktok.proxy.a> pF() {
        return this;
    }

    public final void S90() {
        FLogger.a.i("MiniAppFragment", "click reload");     // Catch: Exception -> L12
        com.bytedance.ai.model.widgets.c r1 = this.k;     // Catch: Exception -> L12
        if (r1 == null) goto L6;
        r1.doRefresh();     // Catch: Exception -> L12
    L6:
        k2.m r2 = com.bytedance.assem.arch.service.e.a(this, Reflection.getOrCreateKotlinClass(k2.m.class));     // Catch: Exception -> L12
        if (r2 == null) goto L17;
        k2.q r3 = r2.h();     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        r3.doRefresh();     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    L12:
        e = move-exception;
        FLogger.a.i("MiniAppFragment", "click reload error: " + e);
    }

    public final void W90() {
        FLogger r1 = FLogger.a;
        r1.i("MiniAppFragment", this + " handleRealResume");
        if (this.H == true) goto L13;
        this.H = true;
        com.bytedance.ai.model.widgets.c r2 = this.k;
        if (r2 == null) goto L7;
        r2.onHostShow();
    L7:
        e1 r3 = this.m;
        if (r3 == null) goto L10;
        r3.b("create");
    L10:
        e1 r4 = this.m;
        if (r4 == null) goto L13;
        r4.c("load");
    L13:
        MiniAppBaseActivity r5 = getActivity();
        if (r5 != null) goto L16;
    L18:
        MiniAppFragmentBinding r6 = this.f;
        if (r6 == null) goto L32;
        OTextView r7 = r6.h;
        if (r7 == null) goto L32;
        r7.setText(this.n);
    L32:
        com.bytedance.ai.model.widgets.c r8 = this.k;     // Catch: Exception -> L29
        if (r8 == null) goto L34;
        PageInfo r9 = r8.getPageInfo();     // Catch: Exception -> L29
        if (r9 == null) goto L35;
        LinkedHashSet r10 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L29
        com.bytedance.ai.model.widgets.c r11 = this.k;     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L29
        com.bytedance.ai.utils.c.b(r9, r11, hashCode());     // Catch: Exception -> L29
        com.bytedance.ai.utils.c.c(hashCode(), false);     // Catch: Exception -> L29
        r1.i("MiniAppFragment", "MiniAppPage pushed to stack in onResume: " + r9.getPageName() + ", fragmentHashCode: " + hashCode());     // Catch: Exception -> L29
        return;
    L35:
        return;
    L34:
        return;
    L29:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "onResume error: " + e.getMessage());
        return;
    L16:
        if ((r5 instanceof MiniAppBaseActivity) == false) goto L18;
        r5.W1(this.v, this.w);
        goto L18
    }

    public final boolean X90() {
        if (Intrinsics.areEqual(this.L, "1") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.L, "2") == true) goto L8;
        return false;
    }

    public final k2.q Y90() {
        k2.m r0 = com.bytedance.assem.arch.service.e.a(this, Reflection.getOrCreateKotlinClass(k2.m.class));
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final void Z90() {
        MiniAppFragmentBinding r0 = this.f;
        if (r0 == null) goto L27;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        int r2 = com.larus.utils.u.c(r1);
    L9:
        if (this.u == false) goto L11;
        r0.f.setVisibility(8);
        r0.e.setVisibility(8);
        r0.g.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r3 = r0.j.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r3).topMargin = 0;
    L25:
        aa0();
        return;
    L11:
        MiniAppFragmentBinding r4 = this.f;
        if (r4 == null) goto L14;
        r4.h.setText(this.n);
    L14:
        ba0();
        ViewGroup.LayoutParams r5 = r0.j.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        int r7 = r6.topMargin;
        if (this.v == false) goto L20;
        r0.g.setPadding(0, r2, 0, 0);
        if (this.y == false) goto L19;
        r2 = 0;
    L24:
        r6.topMargin = r2;
        ca0();
        r0.f.setVisibility(0);
        r0.e.setVisibility(0);
        goto L25
    L19:
        r7 = r7 + r2;
    L23:
        r2 = r7;
        goto L24
    L20:
        r0.g.setPadding(0, 0, 0, 0);
        if (this.y == false) goto L23;
    L7:
        r2 = 0;
        goto L9
    }

    public final void aa0() {
        MiniAppFragmentBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.z == false) goto L7;
        r0.b.setVisibility(8);
        r0.b.setOnClickListener(null);
        return;
    L7:
        r0.b.setVisibility(0);
        r0.b.setOnClickListener(new r(this));
    }

    public final void ba0() {
        MiniAppFragmentBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.K.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L17;
        r0.g.setBackgroundColor(Color.parseColor(this.K));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "invalid navBarBackground: " + this.K + ": " + e);
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void ca0() {
        MiniAppFragmentBinding r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.J, "light") == false) goto L7;
        r0.b.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2131243960, null));
        r0.h.setTextColor(getResources().getColor(2131103630));
        return;
    L7:
        r0.b.setImageDrawable(ResourcesCompat.getDrawable(getResources(), 2131243961, null));
        r0.h.setTextColor(getResources().getColor(2131103631));
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        V90(false);
        com.larus.platform.service.g.a.g("MiniAppFragment");
        FLogger r2 = FLogger.a;
        r2.i("MiniAppFragment", "onDestroy");
        bla.a r4 = this.t;
        if (r4 == null) goto L13;
        ArrayList r5 = (ArrayList) bla.a.e;
        r5.remove(r4);
        if ((!r5.isEmpty()) == false) goto L7;
        Map r6 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, ListProtector.get(r5, 0));
    L10:
        r4.j r1 = bla.a.d;
        if (r1 == null) goto L13;
        IHostContextDepend r7 = r4.a.a;
        Intrinsics.checkNotNullParameter(r1, "hostRouterDepend");
        r4.a.j = r1;
        goto L13
    L7:
        hx7.f r3 = bla.a.c;
        if (r3 == null) goto L10;
        Map r8 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, r3);
    L13:
        Activity r9 = AppHost.a.a().getCurrentActivity();
        if (r9 == null) goto L16;
        Lazy r10 = i2.f.i;
        i2.f.a.a().p(r9);
        i2.f.a.a().k(r9);
    L16:
        MiniAppFragment$setupEventListener$listener$1 r11 = this.D;
        if (r11 == null) goto L24;
        EventDispatcher r12 = EventDispatcher.a;
        EventDispatcher.l(this.h, r11);
    L24:
        LinkedHashSet r13 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L21
        r2.i("MiniAppFragment", "onDestroy, page removed from stack: " + com.bytedance.ai.utils.c.a(hashCode()) + ", fragmentHashCode: " + hashCode());     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "onDestroy popPage error: " + e.getMessage());
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        FLogger r1 = FLogger.a;
        r1.i("MiniAppFragment", "onStop");
        LinkedHashSet r3 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L5
        com.bytedance.ai.utils.c.c(hashCode(), true);     // Catch: Exception -> L5
        r1.i("MiniAppFragment", "MiniAppPage paused, fragmentHashCode: " + hashCode());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "onPause error: " + e.getMessage());
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.miniapp.view.z] */
    public MiniAppFragment() {
        com.bytedance.assem.arch.viewModel.g.c r0 = com.bytedance.assem.arch.viewModel.g.c.a;
        final KClass r3 = Reflection.getOrCreateKotlinClass(RenderStateVM.class);
        Function0<String> r4 = new MiniAppFragment$special$$inlined$assemViewModel$default$1(r3);
        MiniAppFragment$special$$inlined$assemViewModel$default$2 r9 = MiniAppFragment$special$$inlined$assemViewModel$default$2.INSTANCE;
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.a.a) == false) goto L5;
        com.bytedance.assem.arch.viewModel.b r1 = new com.bytedance.assem.arch.viewModel.b(r3, r4, VMExtKt.h(), VMExtKt.l(this), VMExtKt.n(this), VMExtKt.b(), r9, VMExtKt.i(this, true), VMExtKt.d(this, true));
    L12:
        this.d = r1;
        this.e = "aweme://webview/?url=";
        this.h = "";
        this.m = com.larus.platform.service.g.a.h("WebFragment");
        this.n = "";
        this.s = true;
        this.B = true;
        this.C = true;
        this.G = true;
        this.I = "light";
        this.J = "light";
        this.K = "";
        this.N = new z(this);
        this.O = LazyKt.lazy(new a0(this));
        this.P = new MiniAppFragment$floatingSpeakerController$1(this);
        this.Q = new b0(this);
        return;
    L5:
        if (r0 != null) goto L7;
    L11:
        r1 = new com.bytedance.assem.arch.viewModel.b(r3, r4, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.b(), r9, VMExtKt.i(this, false), VMExtKt.d(this, false));
        goto L12
    L7:
        if (Intrinsics.areEqual(r0, r0) == true) goto L11;
        throw new IllegalArgumentException("Do not support this scope here.");
    }

    public final void close() {
        AppletPopup r0 = getParentFragment();
        FragmentActivity r2 = null;
        if ((r0 instanceof AppletPopup) == false) goto L5;
        AppletPopup r1 = r0;
    L7:
        if (r1 == null) goto L9;
        r1.da0(true);
        return;
    L9:
        DialogFragment r3 = getParentFragment();
        if ((r3 instanceof DialogFragment) == false) goto L12;
        DialogFragment r4 = r3;
    L13:
        if (r4 == null) goto L21;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L45;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L45:
        return;
    L21:
        if (this.G == false) goto L25;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L47;
        r6.finish();
        return;
    L47:
        return;
    L25:
        Object r7 = getContext();
        if ((r7 instanceof MiniAppBaseActivity) == false) goto L28;
        MiniAppBaseActivity r8 = (MiniAppBaseActivity) r7;
    L29:
        if (r8 == null) goto L31;
        r8.U1();
        return;
    L31:
        Context r9 = getContext();
        if ((r9 instanceof FragmentActivity) == false) goto L34;
        r2 = (FragmentActivity) r9;
    L34:
        if (r2 == null) goto L50;
        FragmentManager r10 = r2.getSupportFragmentManager();
        if (r10.getBackStackEntryCount() <= 1) goto L38;
        r10.popBackStackImmediate();
        return;
    L38:
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L52;
        r11.finish();
        return;
    L52:
        return;
    L50:
        return;
    L28:
        r8 = null;
        goto L29
    L12:
        r4 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        MiniAppFragment$setupEventListener$listener$1 r0 = this.D;
        if (r0 == null) goto L13;
        String r2 = this.h;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        EventDispatcher r4 = EventDispatcher.a;
        EventDispatcher.l(this.h, r0);
        goto L13
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
    L13:
        MiniAppFragmentBinding r1 = this.f;
        if (r1 == null) goto L18;
        MiniAppActionBar r5 = r1.d;
        if (r5 == null) goto L18;
        r5.a = null;
        r5.c = null;
        r5.d = null;
    L18:
        com.bytedance.ai.model.widgets.c r6 = this.k;
        if (r6 == null) goto L21;
        r6.onHostDestroy();
    L21:
        this.f = null;
        Lazy r7 = i2.f.i;
        i2.f r8 = i2.f.a.a();
        if (r8 == null) goto L24;
        r8.m(AppHost.a.a().getCurrentActivity(), false);
    L24:
        FLogger.a.i("MiniAppFragment", "onDestroyView");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FLogger.a.i("MiniAppFragment", this + " onResume");
        if (isHidden() == true) goto L6;
        W90();
        return;
    }

    public final boolean T90() {
        return this.B;
    }

    public final void V90(boolean r8) {
        if (r8 != this.p) goto L5;
        return;
    L5:
        this.p = r8;
        if (r8 == false) goto L29;
        if (Build.VERSION.SDK_INT < 30) goto L23;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L16;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        WindowInsetsController r2 = r1.getInsetsController();
        if (r2 == null) goto L16;
        r2.hide(WindowInsets.Type.statusBars());
    L16:
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L49;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L49;
        WindowInsetsController r5 = r4.getInsetsController();
        if (r5 == null) goto L49;
        r5.hide(WindowInsets.Type.navigationBars());
    L49:
        MiniAppFragmentBinding r6 = this.f;
        if (r6 == null) goto L69;
        LinearLayout r7 = r6.a;
        if (r7 == null) goto L72;
        if (r8 == false) goto L56;
        this.r = r7.getPaddingBottom();
        this.q = r7.getPaddingTop();
    L56:
        int r9 = 0;
        if (r8 == false) goto L59;
        int r10 = 0;
    L60:
        if (r8 == true) goto L63;
        r9 = this.q;
    L63:
        MiniAppFragmentBinding r11 = this.f;
        if (r11 == null) goto L70;
        LinearLayout r12 = r11.a;
        if (r12 == null) goto L71;
        int r13 = r12.getPaddingStart();
        int r14 = r12.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r13 + ",top:" + r9 + ",end:" + r14 + ",bottom:" + r10);
        r12.setPaddingRelative(r13, r9, r14, r10);
        return;
    L71:
        return;
    L70:
        return;
    L59:
        r10 = this.r;
        goto L60
    L72:
        return;
    L69:
        return;
    L23:
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L49;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L49;
        r16.addFlags(1024);
        goto L49
    L29:
        if (Build.VERSION.SDK_INT < 30) goto L44;
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L37;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L37;
        WindowInsetsController r19 = r18.getInsetsController();
        if (r19 == null) goto L37;
        r19.show(WindowInsets.Type.statusBars());
    L37:
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L49;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L49;
        WindowInsetsController r22 = r21.getInsetsController();
        if (r22 == null) goto L49;
        r22.show(WindowInsets.Type.navigationBars());
        goto L49
    L44:
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L49;
        Window r24 = r23.getWindow();
        if (r24 == null) goto L49;
        r24.clearFlags(1024);
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [com.obric.miniapp.view.MiniAppFragment$setupEventListener$listener$1] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    public final Object da0(Continuation<? super Unit> r5) {
        if ((r5 instanceof MiniAppFragment$setupEventListener$1) == false) goto L7;
        MiniAppFragment$setupEventListener$1 r0 = (MiniAppFragment$setupEventListener$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        MiniAppFragment r4 = (MiniAppFragment) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L20:
        Message r7 = (Message) r6;
        if (r7 == null) goto L23;
        Long r8 = Boxing.boxLong(r7.getLocalIndex());
    L24:
        r4.j = r8;
    L25:
        FLogger.a.i("FloatingSpeaker", "setupEventListener lastMsgIndex = " + this.j);
        if (o0.d(this.h) == false) goto L32;
        MiniAppFragment$setupEventListener$listener$1 r9 = this.D;
        ?? r10 = r9;
        if (r9 != null) goto L30;
        ?? r11 = new MiniAppFragment$setupEventListener$listener$1(this);
        this.D = r11;
        r10 = r11;
    L30:
        EventDispatcher r12 = EventDispatcher.a;
        String r13 = this.h;
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r10, "listener");
        EventDispatcher.k(r13).e.add(r10);
    L32:
        return Unit.INSTANCE;
    L23:
        r8 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r14 = this.i;
        if (r14 == null) goto L25;
        IChatRepoService r15 = zh8.a.a;
        r0.L$0 = this;
        r0.label = 1;
        r6 = r15.D1(r14, r0);
        if (r6 != r2) goto L19;
        return r2;
    L19:
        r4 = this;
    L7:
        r0 = new MiniAppFragment$setupEventListener$1(this, r5);
        goto L8
    }

    public final void onCreate(Bundle r11) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r11);
        if (r11 == null) goto L5;
        Bundle r0 = new Bundle();
        r0.putAll(r11);
        setArguments(r0);
    L5:
        e1 r12 = this.m;
        if (r12 == null) goto L8;
        r12.startTrace();
    L8:
        e1 r13 = this.m;
        if (r13 == null) goto L11;
        r13.c("create");
    L11:
        com.larus.platform.service.g.a.e("MiniAppFragment");
        Bundle r14 = getArguments();
        String r1 = "";
        String r2 = null;
        if (r14 == null) goto L15;
        String r15 = r14.getString(MemorySourceLinkType.URL);
        if (r15 == null) goto L15;
    L21:
        this.g = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L25;
        String r17 = r16.getString("pageId");
        if (r17 == null) goto L25;
    L26:
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r3 = AppletRuntimeManager.e(r17);
        this.k = r3;
        if (r3 == null) goto L45;
        PageInfo r4 = r3.getPageInfo();
        if (r4 == null) goto L45;
        String r6 = r4.getPageName();
        FLogger r7 = FLogger.a;
        r7.d("MiniAppFragment", "pageId: " + r6);
        String r8 = r4.getPageData();
        if (r8 != null) goto L111;
    L38:
        boolean r9 = true;
    L40:
        if (r9 == false) goto L42;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L36
        r10.put("fromMiniApp", true);     // Catch: JSONException -> L36
        r4.setPageData(r10.toString());     // Catch: JSONException -> L36
        r7.i("MiniAppFragment", "pageData is NULL, set fromMiniApp");     // Catch: JSONException -> L36
        goto L45
    L42:
        JSONObject r18 = new JSONObject(r8);     // Catch: JSONException -> L36
        r18.put("fromMiniApp", true);     // Catch: JSONException -> L36
        r4.setPageData(r18.toString());     // Catch: JSONException -> L36
        r7.i("MiniAppFragment", "set fromMiniApp");     // Catch: JSONException -> L36
        goto L45
    L111:
    L36:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "exception in preprocessing pageData: " + e + ' ');
        goto L45
    L33:
        if (r8.length() == 0) goto L38;
        r9 = false;
    L45:
        com.bytedance.ai.model.widgets.c r5 = this.k;
        if (r5 == null) goto L52;
        PageInfo r19 = r5.getPageInfo();
        if (r19 == null) goto L52;
        ReadableMap r20 = r19.getPageSettings();
        if (r20 == null) goto L52;
        String r21 = r20.getString("speakerStatus");
    L53:
        this.L = r21;
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("onCreate pageId ");
        r23.append(r17);
        r23.append(" appletPage ");
        com.bytedance.ai.model.widgets.c r110 = this.k;
        if (r110 == null) goto L56;
        r2 = r110.getAppletId();
    L56:
        r23.append(r2);
        r22.i("MiniAppFragment", r23.toString());
        com.bytedance.ai.model.widgets.c r111 = this.k;
        if (r111 != null) goto L59;
    L107:
        FragmentActivity r112 = getActivity();
        if (r112 == null) goto L112;
        r112.finish();
        return;
    L112:
        return;
    L59:
        if (r111.getAppletId() == null) goto L107;
        com.bytedance.ai.model.widgets.c r113 = this.k;
        if (r113 == null) goto L64;
        r113.setFloatingSpeakerController(this.P);
    L64:
        com.bytedance.ai.model.widgets.c r114 = this.k;
        if (r114 == null) goto L68;
        String r115 = r114.getBotId();
        if (r115 == null) goto L68;
    L69:
        this.h = r115;
        Bundle r116 = getArguments();
        if (r116 == null) goto L72;
        boolean r117 = r116.getBoolean("fullScreen", true);
    L73:
        this.s = r117;
        Uri r118 = UriProtector.parse(this.g);
        String r24 = UriProtector.getQueryParameter(r118, "title");
        if (r24 != null) goto L76;
        r24 = "";
    L76:
        this.n = r24;
        this.A = r118.getBooleanQueryParameter("blockBackPress", false);
        if (this.s == true) goto L87;
        if (r118.getBooleanQueryParameter("hideTitleBar", true) == false) goto L81;
    L84:
        boolean r25 = true;
    L85:
        this.u = r25;
        this.v = r118.getBooleanQueryParameter("transStatusBar", true);
        this.w = r118.getBooleanQueryParameter("transNavigationBar", true);
    L94:
        this.C = r118.getBooleanQueryParameter("disableBounce", false);
        this.F = UriProtector.getQueryParameter(r118, "backgroundColor");
        this.G = r118.getBooleanQueryParameter("closeActivity", true);
        this.x = r118.getBooleanQueryParameter("showActionBar", false);
        String r26 = UriProtector.getQueryParameter(r118, "actionBarMode");
        String r27 = "light";
        if (r26 != null) goto L97;
        r26 = "light";
    L97:
        this.I = r26;
        String r28 = UriProtector.getQueryParameter(r118, "titleBarMode");
        if (r28 == null) goto L101;
        r27 = r28;
    L101:
        this.J = r27;
        String r29 = UriProtector.getQueryParameter(r118, "titleBarBackground");
        if (r29 == null) goto L105;
        r1 = r29;
    L105:
        this.K = r1;
        this.y = r118.getBooleanQueryParameter("transTitleBar", false);
        this.z = r118.getBooleanQueryParameter("hideBackButton", false);
        this.t = new bla.a(this, this.G);
        r22.i("MiniAppFragment", "onCreate url:" + this.g);
        return;
    L81:
        if (r118.getBooleanQueryParameter("hideNavBar", true) == true) goto L84;
        r25 = false;
        goto L85
    L87:
        if (r118.getBooleanQueryParameter("hideTitleBar", false) == false) goto L89;
    L92:
        boolean r30 = true;
    L93:
        this.u = r30;
        this.v = r118.getBooleanQueryParameter("transStatusBar", false);
        this.w = r118.getBooleanQueryParameter("transNavigationBar", false);
        goto L94
    L89:
        if (r118.getBooleanQueryParameter("hideNavBar", false) == true) goto L92;
        r30 = false;
        goto L93
    L72:
        r117 = true;
    L68:
        r115 = "";
    L52:
        r21 = null;
    L25:
        r17 = "2147483647";
    L15:
        Bundle r119 = getArguments();
        if (r119 == null) goto L18;
        r15 = r119.getString("link_url");
    L19:
        if (r15 != null) goto L21;
        r15 = "";
        goto L21
    L18:
        r15 = null;
        goto L19
    }

    public final void onHiddenChanged(boolean r5) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r5);
        if (r5 == false) goto L5;
    L7:
        if (r5 == false) goto L26;
        FLogger r0 = FLogger.a;
        r0.i("MiniAppFragment", this + " handleRealPause");
        if (this.H == false) goto L27;
        MiniAppFragmentBinding r1 = this.f;
        if (r1 == null) goto L15;
        OTextView r2 = r1.h;
        if (r2 == null) goto L15;
        r2.setText("");
    L15:
        this.H = false;
        com.bytedance.ai.model.widgets.c r3 = this.k;
        if (r3 == null) goto L23;
        r3.onHostHide();
    L23:
        LinkedHashSet r4 = com.bytedance.ai.utils.c.a;     // Catch: Exception -> L20
        com.bytedance.ai.utils.c.c(hashCode(), true);     // Catch: Exception -> L20
        r0.i("MiniAppFragment", "handleRealPause: page paused, fragmentHashCode: " + hashCode());     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        FLogger.a.e("MiniAppFragment", "handleRealPause error: " + e.getMessage());
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (isResumed() == false) goto L7;
        W90();
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r2);
        if (getArguments() == null) goto L5;
        r2.putAll(getArguments());
    L5:
        com.bytedance.ai.model.widgets.c r3 = this.k;
        if (r3 == null) goto L9;
        r3.setPageStatus(PageStatus.RE_CREATE);
        return;
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        MiniAppFragmentBinding r2 = this.f;
        if (r2 == null) goto L68;
        LinearLayout r4 = r2.a;
        IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r0 == null) goto L7;
        final ts9.a r1 = r0.f();
    L8:
        String r7 = this.e;
        String r8 = this.g;
        boolean r9 = HttpExtKt.e().a;
        boolean r10 = HttpExtKt.e().c;
        String r11 = HttpExtKt.e().b;
        String r12 = HttpExtKt.e().d;
        b2.a r6 = b2.a;
        String r13 = r6.o();
        String r14 = r6.h();
        Callable r15 = new o(r1);
        Callable r5 = new u(r1);
        if (r1 == null) goto L12;
        List r3 = r1.e;
        if (r3 == null) goto L12;
    L13:
        final k2.b r16 = new k2.b(r7, r8, r9, r10, r11, r12, r13, r14, r15, r5, r3, this.C);
        String r17 = this.F;
        if (r17 != null) goto L16;
    L33:
        com.bytedance.ai.model.widgets.c r18 = this.k;
        if (r18 == null) goto L36;
        r18.createContainer(r2.j, r16, null, this);
    L37:
        Intrinsics.checkNotNull(r4);
        if (r4.isAttachedToWindow() == true) goto L40;
        r4.addOnAttachStateChangeListener(new b(r4, this, r4));
    L44:
        FragmentActivity r19 = getActivity();
        if (r19 == null) goto L47;
        int r22 = com.larus.utils.u.c(r19);
    L48:
        com.bytedance.ai.model.widgets.c r23 = this.k;
        if (r23 == null) goto L67;
        AppletRuntime r24 = r23.getAppletRuntime();
        if (r24 == null) goto L67;
        Applet r25 = r24.h;
        if (r25 == null) goto L67;
        if (this.x == false) goto L65;
        r2.d.setVisibility(0);
        final MiniAppActionBar r26 = r2.d;
        if (Intrinsics.areEqual(this.I, "dark") == false) goto L59;
        final Drawable r27 = ResourcesCompat.getDrawable(r26.getResources(), 2131243951, null);
        r26.b.a.post(new f(r26, r27));
        r26.b.c.setImageResource(2131243966);
        r26.b.b.setImageResource(2131243963);
        r26.b.d.setBackgroundColor(r26.getResources().getColor(2131103625));
    L60:
        MiniAppActionBar r28 = r2.d;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        int r31 = r30.topMargin;
        if (this.v == false) goto L63;
        r30.topMargin = r22 + r31;
    L64:
        r28.setLayoutParams(r30);
    L66:
        r2.d.setApplet(r25);
        r2.d.setOnCloseListener(new v(this));
        r2.d.setOnRefreshListener(new w(this));
        goto L67
    L63:
        r30.topMargin = r31;
        goto L64
    L59:
        final Drawable r32 = ResourcesCompat.getDrawable(r26.getResources(), 2131243952, null);
        r26.b.a.post(new e(r26, r32));
        r26.b.c.setImageResource(2131243965);
        r26.b.b.setImageResource(2131243962);
        r26.b.d.setBackgroundColor(r26.getResources().getColor(2131103626));
        goto L60
    L65:
        r2.d.setVisibility(8);
    L67:
        Z90();
        ProgressBar r33 = r2.e;
        r33.setMax(100);
        r33.setProgress(0);
        goto L68
    L47:
        r22 = 0;
        goto L48
    L40:
        if (this.s == false) goto L42;
        int r34 = r4.getPaddingStart();
        int r35 = r4.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:,start:" + r34 + ",top:0,end:" + r35 + ",bottom:0");
        r4.setPaddingRelative(r34, 0, r35, 0);
        goto L44
    L42:
        int r36 = r4.getPaddingStart();
        int r37 = r4.getPaddingTop();
        int r110 = r4.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r4.getClass().getSimpleName() + ",source:,start:" + r36 + ",top:" + r37 + ",end:" + r110 + ",bottom:0");
        r4.setPaddingRelative(r36, r37, r110, 0);
        goto L44
    L36:
        final LinearLayout r38 = r2.j;
        FLogger.a.i("MiniAppFragment", "createLocalWebView fragment " + this);
        AssembleExtKt.a(this, new c0(this, r16, r38));
        goto L37
    L16:
        if (r17.length() <= 0) goto L18;
        boolean r39 = true;
    L19:
        if (r39 == true) goto L22;
        r17 = null;
    L22:
        if (r17 == null) goto L33;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L25
        Object r41 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r17)));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r41) == false) goto L30;
        r41 = null;
    L30:
        Integer r42 = (Integer) r41;
        if (r42 == null) goto L33;
        r2.j.setBackgroundColor(r42.intValue());
    L25:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L18:
        r39 = false;
    L12:
        r3 = CollectionsKt.emptyList();
        goto L13
    L7:
        r1 = null;
    L68:
        FLogger.a.i("MiniAppFragment", "onViewCreated load kitViewDelegate=" + Y90());
    }

    public static final Object U90(MiniAppFragment r6, String r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof MiniAppFragment$updateFloatingBotId$1) == false) goto L7;
        MiniAppFragment$updateFloatingBotId$1 r0 = (MiniAppFragment$updateFloatingBotId$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L44:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MiniAppFragment r10 = (MiniAppFragment) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L35:
        r10.i = (String) r9;
        FLogger.a.i("FloatingSpeaker", "updateBotId " + r6.h + ' ' + r6.i);
        MiniAppFragmentBinding r11 = r6.f;
        if (r11 == null) goto L40;
        FloatingSpeakerView r12 = r11.c;
        if (r12 == null) goto L40;
        String r13 = r6.h;
        String r4 = r6.i;
        Intrinsics.checkNotNullParameter(r13, "botId");
        r12.d = r13;
        r12.e = r4;
    L40:
        r0.L$0 = null;
        r0.label = 2;
        if (r6.da0(r0) != r2) goto L44;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        if (Intrinsics.areEqual(r6.h, r7) == true) goto L44;
        MiniAppFragmentBinding r14 = r6.f;
        if (r14 == null) goto L23;
        FloatingSpeakerView r15 = r14.c;
        if (r15 == null) goto L23;
        r15.setPlaceHolder(null);
    L23:
        MiniAppFragmentBinding r16 = r6.f;
        if (r16 == null) goto L28;
        FloatingSpeakerView r17 = r16.c;
        if (r17 == null) goto L28;
        r17.f = null;
    L28:
        MiniAppFragment$setupEventListener$listener$1 r18 = r6.D;
        if (r18 == null) goto L31;
        EventDispatcher r5 = EventDispatcher.a;
        EventDispatcher.l(r6.h, r18);
    L31:
        r6.D = null;
        r6.h = r7;
        MessageUtils r19 = MessageUtils.a;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r19.d(r7, r0);
        if (r9 == r2) goto L45;
        r10 = r6;
        goto L35
    L45:
        return r2;
    L7:
        r0 = new MiniAppFragment$updateFloatingBotId$1(r6, r8);
        goto L8
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        if (r19 == null) goto L7;
        boolean r5 = true;
        if (ViewExtKt.h(r19) != true) goto L7;
    L8:
        if (r5 == false) goto L10;
        ViewExtKt.g(r19);
    L10:
        View r0 = r18.inflate(2131563653, r19, false);
        int r2 = 2131364679;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r0, 2131364679);
        if (r7 == null) goto L57;
        r2 = 2131373013;
        FloatingSpeakerView r8 = ViewBindings.findChildViewById(r0, 2131373013);
        if (r8 == null) goto L57;
        r2 = 2131380124;
        MiniAppActionBar r9 = (MiniAppActionBar) ViewBindings.findChildViewById(r0, 2131380124);
        if (r9 == null) goto L57;
        r2 = 2131383297;
        ProgressBar r10 = (ProgressBar) ViewBindings.findChildViewById(r0, 2131383297);
        if (r10 == null) goto L57;
        r2 = 2131388807;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r0, 2131388807);
        if (r11 == null) goto L57;
        r2 = 2131388812;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131388812);
        if (r12 == null) goto L57;
        r2 = 2131391606;
        OTextView r13 = ViewBindings.findChildViewById(r0, 2131391606);
        if (r13 == null) goto L57;
        r2 = 2131393122;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131393122);
        if (r14 == null) goto L57;
        r2 = 2131393131;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131393131);
        if (r15 == null) goto L57;
        this.f = new MiniAppFragmentBinding((LinearLayout) r0, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        com.larus.utils.v.a(this, new x(this));
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if (r1 == null) goto L31;
        Lazy r3 = i2.f.i;
        i2.f.a.a().p(r1);
        i2.f.a.a().k(r1);
    L31:
        FLogger.a.i("MiniAppFragment", "onCreateView");
        com.bytedance.assem.arch.viewModel.e.a.b(this, (RenderStateVM) this.d.getValue(), new y(this));
        if (X90() == false) goto L52;
        this.E = new p(this);
        Function1 r4 = new q(this);
        MiniAppFragmentBinding r6 = this.f;
        if (r6 == null) goto L46;
        FloatingSpeakerView r16 = r6.c;
        if (r16 == null) goto L46;
        Set r17 = r16.a;
        monitor-enter(r17);
        r16.a.add(r4);     // Catch: Throwable -> L43
        monitor-exit(r17);
    L43:
        th = move-exception;
        throw th;
    L46:
        MiniAppFragmentBinding r21 = this.f;
        if (r21 == null) goto L51;
        FloatingSpeakerView r22 = r21.c;
        if (r22 == null) goto L51;
        r22.setRedirectQuery(this.N);
    L51:
        this.P.n(Intrinsics.areEqual(this.L, "1"), false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MiniAppFragment$initFloatingSpeaker$3(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MiniAppFragment$initFloatingSpeaker$4(this, null), 2, null);
    L52:
        MiniAppFragmentBinding r23 = this.f;
        if (r23 != null) goto L55;
        return null;
    L55:
        return r23.a;
    L57:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    L7:
        r5 = false;
        goto L8
    }

    public final void vT(RenderStateVM r1, com.bytedance.assem.arch.viewModel.i r2, Function1 r3, Function2 r4) {
        com.bytedance.assem.arch.viewModel.e.a.a(this, r1, r2, r3, r4);
    }
}

package com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 l2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0001lB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020)H\u0016J\f\u0010>\u001a\u00020;*\u00020)H\u0002J\u0014\u0010?\u001a\u00020;2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030'H\u0016J\u0010\u0010>\u001a\u00020;*\u0006\u0012\u0002\b\u00030'H\u0002J\b\u0010A\u001a\u00020\u001bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020\bH\u0016J\r\u0010G\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010HJ\u001c\u0010I\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020L0K\u0012\u0004\u0012\u00020L0JH\u0016J\b\u0010M\u001a\u00020;H\u0016J\b\u0010N\u001a\u00020;H\u0016J\b\u0010O\u001a\u00020;H\u0016J\b\u0010P\u001a\u00020;H\u0016J\b\u0010Q\u001a\u00020;H\u0002J\b\u0010R\u001a\u00020;H\u0002J\b\u0010S\u001a\u00020;H\u0002J\u0010\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\bH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\u0018\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u0014H\u0016J\b\u0010[\u001a\u00020;H\u0016J\b\u0010\\\u001a\u00020;H\u0016J\b\u0010]\u001a\u00020;H\u0016J\u0010\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020\u001eH\u0016J\u0010\u0010`\u001a\u00020;2\u0006\u0010_\u001a\u00020\u001eH\u0016J\u0010\u0010a\u001a\u00020;2\u0006\u0010_\u001a\u00020#H\u0016J\u0010\u0010b\u001a\u00020;2\u0006\u0010_\u001a\u00020#H\u0016J\b\u0010c\u001a\u00020\u001bH\u0002J\u0010\u0010d\u001a\u00020;2\u0006\u0010e\u001a\u00020DH\u0016J\u0010\u0010f\u001a\u00020;2\u0006\u0010e\u001a\u00020DH\u0016J\u0011\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010i\u001a\u00020;2\u0006\u0010h\u001a\u00020\u0004H\u0096\u0001R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001f\u0010 R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b$\u0010 R\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u00101\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\bk\u0010 ¨\u0006m"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/FuncKeyboardComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardComponentCallbacks;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/View$OnAttachStateChangeListener;", "enableFuncKeyboard", BuildConfig.FLAVOR, "<init>", "(Z)V", "mCurrentChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "mCurrentChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "mOpenApp", "Lcom/ss/android/lark/biz/im/api/OpenApp;", "mBannedReasons", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/BannedKeyboardReason;", "Lkotlin/collections/HashMap;", "getMBannedReasons", "()Ljava/util/HashMap;", "mBannedReasons$delegate", "Lkotlin/Lazy;", "mLastTotalHeight", BuildConfig.FLAVOR, "mStatusListeners", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardStatusListener;", "getMStatusListeners", "()Ljava/util/List;", "mStatusListeners$delegate", "mControlStatusListeners", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$OnKeyboardControlStatusChangeListener;", "getMControlStatusListeners", "mControlStatusListeners$delegate", "mContentPlugin", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardContent;", "mKeyboardSwitcher", "Lcom/ss/android/lark/keyboard/base/IKeyboardSwitcherPlugin;", "isCreated", "mSwitcherContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMSwitcherContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMSwitcherContainer", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mMenuContainer", "Landroid/widget/FrameLayout;", "getMMenuContainer", "()Landroid/widget/FrameLayout;", "setMMenuContainer", "(Landroid/widget/FrameLayout;)V", "mRootContainer", "getMRootContainer", "setMRootContainer", "registerKeyboardSwitcher", BuildConfig.FLAVOR, IPortraitService.NAME, "keyboardSwitcher", "attachToFuncKeyboard", "registerFuncKeyboardContent", "contentPlugin", "getKeyboardType", "isKeyboardEnable", "getContainerView", "Landroid/view/View;", "getRootView", "hasView", "getLayoutResId", "()Ljava/lang/Integer;", "provideWidgetExport", BuildConfig.FLAVOR, "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "onCreate", "onDestroy", "onPause", "onStop", "initView", "addGlobalLayoutListener", "removeGlobalLayoutListener", "setupKeyboardEnable", "chat", "needHideKeyBoard", "isKeyboardBanned", "bannedKeyboardShown", "reason", "banReason", "hideKeyboard", "showKeyboard", "onGlobalLayout", "addKeyboardStatusListener", "listener", "removeKeyboardStatusListener", "registerKeyboardControlStatusChangeListener", "unRegisterKeyboardControlStatusChangeListener", "getFuncKeyboardTotalHeight", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "registerCallback", "callback", "unregisterCallback", "callbacks", "getCallbacks", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FuncKeyboardComponent extends ChatBaseComponent implements IFuncKeyboardComponent, oxa.c<IFuncKeyboardComponent.a>, ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
    public static final /* synthetic */ int s = 0;
    public final /* synthetic */ oxa.a<IFuncKeyboardComponent.a> l;
    public Chat m;

    @BindView(10635)
    public FrameLayout mMenuContainer;

    @BindView(10206)
    public ConstraintLayout mRootContainer;

    @BindView(11272)
    public ConstraintLayout mSwitcherContainer;
    public ChatChatter n;
    public final Lazy o;
    public int p;
    public final Lazy q;
    public final Lazy r;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ FuncKeyboardComponent a;

        public b(FuncKeyboardComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            i7b.a r6 = (i7b.a) r5;
            Intrinsics.checkNotNullParameter(r6, "initData");
            PerfLog.start("func_keyboard_init_with_data", BuildConfig.FLAVOR);
            FuncKeyboardComponent r2 = this.a;
            r2.m = r6.f;
            r2.n = r6.g;
            if (r2.G0() == false) goto L5;
            this.a.hideKeyboard();
        L5:
            FuncKeyboardComponent r7 = this.a;
            Chat r3 = r7.m;
            Iterator r8 = r7.l.a.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            ((IFuncKeyboardComponent.a) r8.next()).b();
            goto L7
        L9:
            PerfLog.end("func_keyboard_init_with_data", BuildConfig.FLAVOR);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ FuncKeyboardComponent a;

        public c(FuncKeyboardComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Chat) r2) == null) goto L6;
            FuncKeyboardComponent r3 = this.a;
            int r0 = FuncKeyboardComponent.s;
            r3.getClass();
            return;
        }
    }

    static {
    }

    public final boolean v0() {
        return true;
    }

    public final ConstraintLayout F0() {
        ConstraintLayout r0 = this.mRootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        return null;
    }

    public final boolean G0() {
        int r0 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.a;
        Chat r1 = this.m;
        ChatChatter r2 = this.n;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L24;
        if (r1 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L24;
        if (r1 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L24;
        boolean r6 = false;
    L25:
        if (r6 == true) goto L31;
        int r7 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        if (com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.a((HashMap) this.o.getValue()) == true) goto L32;
        return false;
    L32:
        return true;
    L31:
        return true;
    L18:
        if (r1.isFrozen() == false) goto L20;
        r5 = true;
        goto L21
    L11:
        if (r1.isChatable() == false) goto L14;
        r4 = false;
    L24:
        r6 = true;
        goto L25
    L5:
        if (r2.isDimission() == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b
    public final View getRootView() {
        if (this.mRootContainer != null) goto L7;
        return null;
    L7:
        return F0();
    }

    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(IFuncKeyboardComponent.class, this));
    }

    public FuncKeyboardComponent() {
        this.l = new oxa.a();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.o = LazyKt.lazy(r0, FuncKeyboardComponent$mBannedReasons$2.INSTANCE);
        this.q = LazyKt.lazy(r0, FuncKeyboardComponent$mStatusListeners$2.INSTANCE);
        this.r = LazyKt.lazy(r0, FuncKeyboardComponent$mControlStatusListeners$2.INSTANCE);
    }

    public final void E0() {
        ConstraintLayout r0 = F0();
        if (r0.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        Log.d("FuncKeyboardComponent", "observer " + r1 + " add global layout " + this);
        r1.addOnGlobalLayoutListener(this);
        return;
    }

    public final void H0() {
        ConstraintLayout r0 = F0();
        if (r0.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == false) goto L9;
        Log.d("FuncKeyboardComponent", "observer " + r1 + " remove global layout " + this);
        r1.removeOnGlobalLayoutListener(this);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void I() {
        if (G0() == false) goto L5;
        return;
    L5:
        F0().setVisibility(0);
        Iterator r0 = ((List) this.r.getValue()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        IFuncKeyboardComponent.c r1 = (IFuncKeyboardComponent.c) r0.next();
        int r2 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        r1.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.b((HashMap) this.o.getValue()));
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void hideKeyboard() {
        F0().setVisibility(8);
        Iterator r0 = ((List) this.r.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IFuncKeyboardComponent.c r1 = (IFuncKeyboardComponent.c) r0.next();
        int r2 = com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.d;
        r1.a(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a.C0033a.b((HashMap) this.o.getValue()));
        goto L4
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        PerfLog.start("func_keyboard_init", BuildConfig.FLAVOR);
        View r2 = ((Widget) this).e;
        if (r2 == null) goto L7;
        ButterKnife.bind(this, r2);
        E0();
        F0().addOnAttachStateChangeListener(this);
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(D0(), this, new b(this));
        C0().observe(this, new c(this));
        PerfLog.end("func_keyboard_init", BuildConfig.FLAVOR);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void onDestroy() {
        H0();
        F0().removeOnAttachStateChangeListener(this);
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onDestroy();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (F0().getVisibility() != 8) goto L5;
        int r0 = 0;
    L7:
        if (r0 == this.p) goto L15;
        Iterator r1 = ((List) this.q.getValue()).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((IFuncKeyboardComponent.b) r1.next()).b(r0);
        goto L10
    L12:
        this.p = r0;
        return;
    L15:
        return;
    L5:
        Log.d("FuncKeyboardComponent", "func keyboard total height = " + F0().getHeight());
        r0 = F0().getHeight();
        goto L7
    }

    public final Integer r0() {
        return 2131559315;
    }

    public final void onPause() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onPause();
    }

    public final void onStop() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onStop();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void FE(KeyboardWrapperConfigurator.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((List) this.q.getValue()).add(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void aV(KeyboardWrapperConfigurator.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((List) this.q.getValue()).remove(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void f6(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r3) {
        Intrinsics.checkNotNullParameter("banned_select", "reason");
        Intrinsics.checkNotNullParameter(r3, "banReason");
        ((HashMap) this.o.getValue()).put("banned_select", r3);
        if (G0() == false) goto L5;
        hideKeyboard();
        return;
    L5:
        I();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        E0();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        H0();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void pL(KeyboardWrapperConfigurator.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((List) this.r.getValue()).remove(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent
    public final void rk(KeyboardWrapperConfigurator.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((List) this.r.getValue()).add(r2);
    }
}

package com.bytedance.android.live.browser.webview.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.lw;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\bI\u0010JJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0012\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0018\u0010*\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u001c\u0010=\u001a\n <*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010?\u001a\u00020\b8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b?\u00101\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00101R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00101R\u001b\u0010G\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010AR\u0018\u0010H\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010>¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/browser/webview/fragment/LiveAnnieXDialogImpl;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/android/annie/container/dialog/l;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "Lcom/bytedance/android/live/browser/webview/fragment/l;", "Lcom/bytedance/android/live/browser/webview/fragment/m;", "", "initFloatLive", "", "isLightStatusBar", "isMute", "handleChangeMuteStatus", "Landroid/widget/FrameLayout;", "floatView", "Lia/f;", KtvSubElement.CONTAINER, "Lt36/f;", "annieXLiveFragmentModel", "enablePullUpAdapterStatusBar", "attach", "pullUpAdapterStatusBar", "Landroid/view/MotionEvent;", "event", "inIgnoreArea", "", "state", "handlePullStateChange", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreatedProxy", "isAutoFloatEnable", "finish", "", "getRequestPage", "onDestroyViewProxy", "Lorg/json/JSONObject;", "params", "showLiveFloatWindow", "hideLiveFloatWindow", "isShowLiveFloatWindow", "mute", "longMute", "setMuteStatus", "onDestroyProxy", "needAdapterStatusBarColor", "modStatusBar", "setModStatusBar", "getModStatusBar", "mModStatusBar", "Z", "Lcom/bytedance/android/annie/business/ability/schema/model/b;", "mAnnieXLiveFragmentModel", "Lcom/bytedance/android/annie/business/ability/schema/model/b;", "Lia/f;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "mFloatView", "Landroid/widget/FrameLayout;", "mEnablePullUpAdapterStatusBar", "kotlin.jvm.PlatformType", "fixFloatWindowShowStatus", "Ljava/lang/Boolean;", "mIsShowLiveFloatWindowNew", "getMIsShowLiveFloatWindowNew", "()Z", "mIsMute", "mIsLongMute", "canShowFloatLive$delegate", "Lkotlin/Lazy;", "getCanShowFloatLive", "canShowFloatLive", "originLightStatusBar", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnnieXDialogImpl extends Fragment implements com.bytedance.android.annie.container.dialog.l, IVideoFloatManager.AutoFloatEnable, l, m {
    private Activity activity;
    private final Lazy canShowFloatLive$delegate;
    private ia.f container;
    private final Boolean fixFloatWindowShowStatus;
    private com.bytedance.android.annie.business.ability.schema.model.b mAnnieXLiveFragmentModel;
    private boolean mEnablePullUpAdapterStatusBar;
    private FrameLayout mFloatView;
    private boolean mIsLongMute;
    private boolean mIsMute;
    private boolean mIsShowLiveFloatWindowNew;
    private boolean mModStatusBar;
    private Boolean originLightStatusBar;

    public static final class a implements Runnable {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ LiveAnnieXDialogImpl b;

        public a(FrameLayout r1, LiveAnnieXDialogImpl r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).hideFloatWindow(this.b, this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ LiveAnnieXDialogImpl b;
        public final /* synthetic */ JSONObject c;

        public b(FrameLayout r1, LiveAnnieXDialogImpl r2, JSONObject r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            JSONObject r1 = this.c;
            Long r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.optString("room_id");
        L6:
            JSONObject r4 = this.c;
            String r5 = "";
            if (r4 == null) goto L10;
            String r6 = r4.optString("business_line");
            if (r6 == null) goto L10;
        L11:
            JSONObject r7 = this.c;
            if (r7 == null) goto L14;
            boolean r8 = r7.optBoolean("is_mute");
        L15:
            JSONObject r9 = this.c;
            if (r9 == null) goto L18;
            JSONObject r11 = r9.optJSONObject("enter_live_params");
        L20:
            if (r11 == null) goto L23;
            String r12 = r11.optString("EVENT_ORIGIN_FEATURE");
            if (r12 == null) goto L23;
        L25:
            if (r11 == null) goto L28;
            String r13 = r11.optString("enter_method");
            if (r13 == null) goto L28;
        L30:
            if (r11 == null) goto L33;
            String r14 = r11.optString("enter_from_merge");
            if (r14 == null) goto L33;
        L35:
            if (r11 == null) goto L40;
            String r15 = r11.optString("ecom_live_params");
            if (r15 == null) goto L40;
            r5 = r15;
        L40:
            HashMap r16 = new HashMap();
            boolean r17 = true;
            if (r12.length() != 0) goto L43;
            boolean r18 = true;
        L44:
            if (r18 == true) goto L47;
            r16.put("EVENT_ORIGIN_FEATURE", r12);
        L47:
            if (r13.length() != 0) goto L49;
            boolean r19 = true;
        L50:
            if (r19 == true) goto L53;
            r16.put("enter_method", r13);
        L53:
            if (r14.length() != 0) goto L55;
            boolean r21 = true;
        L56:
            if (r21 == true) goto L59;
            r16.put("enter_from_merge", r14);
        L59:
            if (r5.length() == 0) goto L62;
            r17 = false;
        L62:
            if (r17 == true) goto L65;
            r16.put("ecom_live_params", r5);
        L65:
            if (Intrinsics.areEqual("game", r6) == false) goto L67;
            FloatWindowBusinessLine r22 = FloatWindowBusinessLine.Game;
        L68:
            IMiddlewareLiveVideoFloatWindowService r23 = jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class);
            LiveAnnieXDialogImpl r24 = this.b;
            FrameLayout r25 = this.a;
            InnerContextEntity.InnerFloatExtra r110 = new InnerContextEntity.InnerFloatExtra();
            if (r3 == null) goto L71;
            r2 = StringsKt.toLongOrNull(r3);
        L71:
            r110.setEnterRoomId(r2);
            r110.setMute(r8);
            r110.setMobParams(r16);
            r110.setBusinessLine(r22);
            Unit r26 = Unit.INSTANCE;
            r23.showFloatWindow(r24, r25, r110);
            if (LiveAnnieXDialogImpl.access$getMIsMute$p(this.b) == true) goto L74;
            return;
        L74:
            if (LiveAnnieXDialogImpl.access$getMIsLongMute$p(this.b) == true) goto L78;
            LiveAnnieXDialogImpl.access$handleChangeMuteStatus(this.b, false);
            return;
        L78:
            return;
        L67:
            r22 = null;
            goto L68
        L55:
            r21 = false;
            goto L56
        L49:
            r19 = false;
            goto L50
        L43:
            r18 = false;
        L33:
            r14 = "";
        L28:
            r13 = "";
        L23:
            r12 = "";
            goto L25
        L18:
            r11 = null;
            goto L20
        L14:
            r8 = false;
        L10:
            r6 = "";
            goto L11
        L5:
            r3 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final boolean getCanShowFloatLive() {
        return ((Boolean) this.canShowFloatLive$delegate.getValue()).booleanValue();
    }

    public String getRequestPage() {
        return "LiveAnnieFragment";
    }

    public boolean isAutoFloatEnable() {
        return true;
    }

    public void onDestroyProxy() {
    }

    public boolean pullUpAdapterStatusBar() {
        return true;
    }

    private final boolean getMIsShowLiveFloatWindowNew() {
        if (this.fixFloatWindowShowStatus.booleanValue() == false) goto L6;
        return jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).isFloatWindowShowing();
    L6:
        return this.mIsShowLiveFloatWindowNew;
    }

    private final void initFloatLive() {
        ia.f r0 = this.container;
        if (r0 == null) goto L5;
        r0.registerWeakHolder(l.class, this);
    L5:
        ia.f r1 = this.container;
        if (r1 == null) goto L9;
        r1.registerWeakHolder(m.class, this);
        return;
    }

    private final boolean isLightStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        Activity r0 = this.activity;
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        return com.bytedance.android.live.browser.utils.f.b(r1);
    L11:
        return false;
    }

    public void finish() {
        ia.f r0 = this.container;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public boolean needAdapterStatusBarColor() {
        if (this.mEnablePullUpAdapterStatusBar == true) goto L5;
    L7:
        return false;
    L5:
        if (pullUpAdapterStatusBar() == false) goto L7;
        return true;
    }

    public LiveAnnieXDialogImpl() {
        this.fixFloatWindowShowStatus = (Boolean) lw.a.getValue();
        this.canShowFloatLive$delegate = LazyKt.lazy(LiveAnnieXDialogImpl$canShowFloatLive$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public void hideLiveFloatWindow() {
        if (getMIsShowLiveFloatWindowNew() == true) goto L5;
        return;
    L5:
        this.mIsShowLiveFloatWindowNew = false;
        FrameLayout r0 = this.mFloatView;
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new a(r0, this));
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public boolean isShowLiveFloatWindow() {
        return getMIsShowLiveFloatWindowNew();
    }

    public void onDestroyViewProxy() {
        if (getMIsShowLiveFloatWindowNew() == false) goto L6;
        hideLiveFloatWindow();
    L6:
        if (this.mIsMute == true) goto L8;
        return;
    L8:
        if (this.mIsLongMute == true) goto L12;
        handleChangeMuteStatus(false);
        return;
    }

    public boolean getModStatusBar() {
        return this.mModStatusBar;
    }

    public static final /* synthetic */ boolean access$getMIsLongMute$p(LiveAnnieXDialogImpl r0) {
        return r0.mIsLongMute;
    }

    public static final /* synthetic */ boolean access$getMIsMute$p(LiveAnnieXDialogImpl r0) {
        return r0.mIsMute;
    }

    private final void handleChangeMuteStatus(boolean r4) {
        if (r4 == false) goto L4;
        xs2.b.a().post(new h1(47));
    L5:
        jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).toggleLiveAudio(r4);
        return;
    L4:
        xs2.b.a().post(new h1(48));
        goto L5
    }

    public void handlePullStateChange(int r4) {
        com.bytedance.android.annie.business.ability.schema.model.b r0 = this.mAnnieXLiveFragmentModel;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r4 != 3) goto L11;
        if (r1 == false) goto L24;
        if (getCanShowFloatLive() == false) goto L24;
        showLiveFloatWindow(null);
    L24:
        if (Intrinsics.areEqual(this.originLightStatusBar, Boolean.FALSE) == false) goto L31;
        this.mModStatusBar = true;
        return;
    L31:
        return;
    L11:
        if (r4 != 4) goto L32;
        if (r1 == true) goto L15;
        return;
    L15:
        if (getCanShowFloatLive() == true) goto L17;
        return;
    L17:
        if (getMIsShowLiveFloatWindowNew() == false) goto L29;
        hideLiveFloatWindow();
        return;
    L29:
        return;
    L32:
        return;
    L5:
        if (r0.d() != true) goto L7;
        r1 = true;
        goto L9
    }

    public boolean inIgnoreArea(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).onFloatWindowInterceptTouchEvent(this, r2);
    }

    public void onActivityCreatedProxy(Bundle r1) {
        initFloatLive();
    }

    public void setModStatusBar(boolean r1) {
        this.mModStatusBar = r1;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public void showLiveFloatWindow(JSONObject r3) {
        if (getMIsShowLiveFloatWindowNew() == false) goto L5;
        return;
    L5:
        this.mIsShowLiveFloatWindowNew = true;
        FrameLayout r0 = this.mFloatView;
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new b(r0, this, r3));
        return;
    }

    public static final /* synthetic */ void access$handleChangeMuteStatus(LiveAnnieXDialogImpl r0, boolean r1) {
        r0.handleChangeMuteStatus(r1);
    }

    public static final /* synthetic */ void access$setMIsLongMute$p(LiveAnnieXDialogImpl r0, boolean r1) {
        r0.mIsLongMute = r1;
    }

    public static final /* synthetic */ void access$setMIsMute$p(LiveAnnieXDialogImpl r0, boolean r1) {
        r0.mIsMute = r1;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.m
    public void setMuteStatus(boolean r1, boolean r2) {
        this.mIsMute = r1;
        this.mIsLongMute = r1;
        handleChangeMuteStatus(r1);
    }

    public void attach(FrameLayout r2, ia.f r3, t36.f r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "floatView");
        Intrinsics.checkNotNullParameter(r3, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r4, "annieXLiveFragmentModel");
        this.mFloatView = r2;
        this.container = r3;
        Object r0 = null;
        if ((r4 instanceof com.bytedance.android.annie.business.ability.schema.model.b) == true) goto L5;
        r4 = null;
    L5:
        this.mAnnieXLiveFragmentModel = (com.bytedance.android.annie.business.ability.schema.model.b) r4;
        this.mEnablePullUpAdapterStatusBar = r5;
        Object r6 = r3.getWeakContext().get();
        if ((r6 instanceof Activity) == false) goto L9;
        r0 = r6;
    L9:
        this.activity = (Activity) r0;
    }
}

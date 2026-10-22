package com.bytedance.android.live.browser.webview.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.business.container.AnnieXLiveFragment;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.lw;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b1\u00102J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016R\u001c\u0010$\u001a\n #*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00078B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u001b\u0010/\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010)R\u0018\u00100\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010%¨\u00063"}, d2 = {"Lcom/bytedance/android/live/browser/webview/fragment/LiveAnnieXFragment;", "Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "Lcom/bytedance/android/live/browser/webview/fragment/l;", "Lcom/bytedance/android/live/browser/webview/fragment/m;", "", "initFloatLive", "", "isLightStatusBar", "isMute", "handleChangeMuteStatus", "pullUpAdapterStatusBar", "Landroid/view/MotionEvent;", "event", "inIgnoreArea", "", "state", "handlePullStateChange", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "isAutoFloatEnable", "finish", "", "getRequestPage", "onDestroyView", "Lorg/json/JSONObject;", "params", "showLiveFloatWindow", "hideLiveFloatWindow", "isShowLiveFloatWindow", "mute", "longMute", "setMuteStatus", "onDestroy", "kotlin.jvm.PlatformType", "fixFloatWindowShowStatus", "Ljava/lang/Boolean;", "mIsShowLiveFloatWindowNew", "Z", "getMIsShowLiveFloatWindowNew", "()Z", "mIsMute", "mIsLongMute", "canShowFloatLive$delegate", "Lkotlin/Lazy;", "getCanShowFloatLive", "canShowFloatLive", "originLightStatusBar", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnnieXFragment extends AnnieXLiveFragment implements IVideoFloatManager.AutoFloatEnable, l, m {
    private final Lazy canShowFloatLive$delegate;
    private final Boolean fixFloatWindowShowStatus;
    private boolean mIsLongMute;
    private boolean mIsMute;
    private boolean mIsShowLiveFloatWindowNew;
    private Boolean originLightStatusBar;

    public static final class a implements Runnable {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ LiveAnnieXFragment b;

        public a(FrameLayout r1, LiveAnnieXFragment r2) {
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
        public final /* synthetic */ LiveAnnieXFragment b;
        public final /* synthetic */ JSONObject c;

        public b(FrameLayout r1, LiveAnnieXFragment r2, JSONObject r3) {
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
            LiveAnnieXFragment r24 = this.b;
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
            if (LiveAnnieXFragment.access$getMIsMute$p(this.b) == true) goto L74;
            return;
        L74:
            if (LiveAnnieXFragment.access$getMIsLongMute$p(this.b) == true) goto L78;
            LiveAnnieXFragment.access$handleChangeMuteStatus(this.b, false);
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

    public /* bridge */ /* synthetic */ void addOnPreDrawListener() {
    }

    public /* bridge */ /* synthetic */ boolean canGoBack() {
        return false;
    }

    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    public String getRequestPage() {
        return "LiveAnnieFragment";
    }

    public /* bridge */ /* synthetic */ void goBack() {
    }

    public boolean isAutoFloatEnable() {
        return true;
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

    private final boolean isLightStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        return com.bytedance.android.live.browser.utils.f.b(r1);
    L11:
        return false;
    }

    public LiveAnnieXFragment() {
        this.fixFloatWindowShowStatus = (Boolean) lw.a.getValue();
        this.canShowFloatLive$delegate = LazyKt.lazy(LiveAnnieXFragment$canShowFloatLive$2.INSTANCE);
    }

    private final void initFloatLive() {
        com.bytedance.android.annie.business.ability.schema.model.b r0 = getMAnnieXLiveFragmentModel();
        if (r0 != null) goto L5;
    L9:
        registerWeakHolder(l.class, this);
        registerWeakHolder(m.class, this);
        return;
    L5:
        if (r0.d() == false) goto L9;
        if (getCanShowFloatLive() == false) goto L9;
        showLiveFloatWindow(null);
        goto L9
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public void hideLiveFloatWindow() {
        if (getMIsShowLiveFloatWindowNew() == true) goto L5;
        return;
    L5:
        this.mIsShowLiveFloatWindowNew = false;
        FrameLayout r0 = getMFloatView();
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new a(r0, this));
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public boolean isShowLiveFloatWindow() {
        return getMIsShowLiveFloatWindowNew();
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
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

    public void finish() {
        close();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public static final /* synthetic */ boolean access$getMIsLongMute$p(LiveAnnieXFragment r0) {
        return r0.mIsLongMute;
    }

    public static final /* synthetic */ boolean access$getMIsMute$p(LiveAnnieXFragment r0) {
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
        com.bytedance.android.annie.business.ability.schema.model.b r0 = getMAnnieXLiveFragmentModel();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        getMAnnieXLiveFragmentModel();
        if (r4 != 3) goto L11;
        if (r1 == false) goto L24;
        if (getCanShowFloatLive() == false) goto L24;
        showLiveFloatWindow(null);
    L24:
        if (Intrinsics.areEqual(this.originLightStatusBar, Boolean.FALSE) == false) goto L26;
        setMModStatusBar(true);
    L26:
        super.handlePullStateChange(r4);
        return;
    L11:
        if (r4 != 4) goto L26;
        if (r1 == false) goto L26;
        if (getCanShowFloatLive() == false) goto L26;
        if (getMIsShowLiveFloatWindowNew() == false) goto L26;
        hideLiveFloatWindow();
        goto L26
    L5:
        if (r0.d() != true) goto L7;
        r1 = true;
        goto L8
    }

    public boolean inIgnoreArea(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).onFloatWindowInterceptTouchEvent(this, r2);
    }

    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        initFloatLive();
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public void showLiveFloatWindow(JSONObject r3) {
        if (getMIsShowLiveFloatWindowNew() == false) goto L5;
        return;
    L5:
        this.mIsShowLiveFloatWindowNew = true;
        FrameLayout r0 = getMFloatView();
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new b(r0, this, r3));
        return;
    }

    public static final /* synthetic */ void access$handleChangeMuteStatus(LiveAnnieXFragment r0, boolean r1) {
        r0.handleChangeMuteStatus(r1);
    }

    public static final /* synthetic */ void access$setMIsLongMute$p(LiveAnnieXFragment r0, boolean r1) {
        r0.mIsLongMute = r1;
    }

    public static final /* synthetic */ void access$setMIsMute$p(LiveAnnieXFragment r0, boolean r1) {
        r0.mIsMute = r1;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.m
    public void setMuteStatus(boolean r1, boolean r2) {
        this.mIsMute = r1;
        this.mIsLongMute = r1;
        handleChangeMuteStatus(r1);
    }
}

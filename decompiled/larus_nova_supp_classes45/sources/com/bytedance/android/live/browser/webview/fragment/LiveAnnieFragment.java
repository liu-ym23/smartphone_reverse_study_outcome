package com.bytedance.android.live.browser.webview.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/browser/webview/fragment/LiveAnnieFragment;", "Lcom/bytedance/android/annie/container/fragment/AnnieFragment;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "Lcom/bytedance/android/live/browser/webview/fragment/l;", "Lcom/bytedance/android/live/browser/webview/fragment/m;", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnnieFragment extends AnnieFragment implements IVideoFloatManager.AutoFloatEnable, l, m {
    public final Boolean L1;
    public boolean M1;
    public boolean P1;
    public boolean Q1;
    public final Lazy S1;
    public Boolean T1;

    public static final class a implements Runnable {
        public final /* synthetic */ FrameLayout a;
        public final /* synthetic */ LiveAnnieFragment b;

        public a(FrameLayout r1, LiveAnnieFragment r2) {
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
        public final /* synthetic */ LiveAnnieFragment b;
        public final /* synthetic */ JSONObject c;

        public b(FrameLayout r1, LiveAnnieFragment r2, JSONObject r3) {
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
            LiveAnnieFragment r24 = this.b;
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
            LiveAnnieFragment r27 = this.b;
            if (r27.P1 == true) goto L74;
            return;
        L74:
            if (r27.Q1 == true) goto L78;
            r27.handleChangeMuteStatus(false);
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

    public final String getRequestPage() {
        return "LiveAnnieFragment";
    }

    public final boolean isAutoFloatEnable() {
        return true;
    }

    public final boolean ja0() {
        if (this.L1.booleanValue() == false) goto L9;
        IMiddlewareLiveVideoFloatWindowService r0 = jc1.k.f(IMiddlewareLiveVideoFloatWindowService.class);
        if (r0 == null) goto L11;
        return r0.isFloatWindowShowing();
    L11:
        return this.M1;
    L9:
        return this.M1;
    }

    public LiveAnnieFragment() {
        this.L1 = (Boolean) lw.a.getValue();
        this.S1 = LazyKt.lazy(LiveAnnieFragment$canShowFloatLive$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void hideLiveFloatWindow() {
        if (ja0() == true) goto L5;
        return;
    L5:
        this.M1 = false;
        FrameLayout r0 = ((AnnieFragment) this).b1;
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new a(r0, this));
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final boolean isShowLiveFloatWindow() {
        return ja0();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (ja0() == false) goto L6;
        hideLiveFloatWindow();
    L6:
        if (this.P1 == true) goto L8;
        return;
    L8:
        if (this.Q1 == true) goto L12;
        handleChangeMuteStatus(false);
        return;
    }

    public final void finish() {
        close();
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void handleChangeMuteStatus(boolean r4) {
        if (r4 == false) goto L4;
        xs2.b.a().post(new h1(47));
    L5:
        jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).toggleLiveAudio(r4);
        return;
    L4:
        xs2.b.a().post(new h1(48));
        goto L5
    }

    public final void handlePullStateChange(int r11) {
        FragmentParamVoNew r0 = ((AnnieFragment) this).e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        FragmentParamVoNew r3 = ((AnnieFragment) this).e;
        if (r3 == null) goto L11;
        String r4 = r3.a2();
    L13:
        if (r11 != 3) goto L15;
        if (r2 == true) goto L45;
    L47:
        if (r4 == null) goto L82;
        int r12 = r4.hashCode();
        if (r12 == 93818879) goto L68;
        if (r12 != 113101865) goto L82;
        if (r4.equals("white") == false) goto L82;
        if (this.T1 == null) goto L58;
    L66:
        com.bytedance.android.annie.util.i.h(getActivity());
        goto L82
    L58:
        if (Build.VERSION.SDK_INT < 23) goto L65;
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L65;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L65;
        r1 = com.bytedance.android.live.browser.utils.f.b(r14);
    L65:
        this.T1 = Boolean.valueOf(r1);
        goto L66
    L68:
        if (r4.equals("black") == false) goto L82;
        if (this.T1 == null) goto L72;
    L80:
        com.bytedance.android.annie.util.i.j(getActivity(), Boolean.FALSE);
        goto L82
    L72:
        if (Build.VERSION.SDK_INT < 23) goto L79;
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L79;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L79;
        r1 = com.bytedance.android.live.browser.utils.f.b(r16);
    L79:
        this.T1 = Boolean.valueOf(r1);
    L82:
        if (Intrinsics.areEqual(this.T1, Boolean.FALSE) == false) goto L89;
        ((AnnieFragment) this).g1 = true;
        return;
    L89:
        return;
    L45:
        if (((Boolean) this.S1.getValue()).booleanValue() == false) goto L47;
        showLiveFloatWindow(null);
        goto L47
    L15:
        if (r11 != 4) goto L90;
        if (r2 == true) goto L19;
    L23:
        if (r4 == null) goto L91;
        int r17 = r4.hashCode();
        if (r17 == 93818879) goto L37;
        if (r17 == 113101865) goto L30;
        return;
    L30:
        if (r4.equals("white") == false) goto L85;
        Boolean r18 = this.T1;
        Boolean r5 = Boolean.FALSE;
        if (Intrinsics.areEqual(r18, r5) == false) goto L34;
        com.bytedance.android.annie.util.i.h(getActivity());
    L35:
        ((AnnieFragment) this).g1 = false;
        this.T1 = null;
        return;
    L34:
        com.bytedance.android.annie.util.i.j(getActivity(), r5);
        goto L35
    L85:
        return;
    L37:
        if (r4.equals("black") == true) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(this.T1, Boolean.TRUE) == false) goto L41;
        com.bytedance.android.annie.util.i.j(getActivity(), Boolean.FALSE);
    L42:
        ((AnnieFragment) this).g1 = false;
        this.T1 = null;
        return;
    L41:
        com.bytedance.android.annie.util.i.h(getActivity());
        goto L42
    L91:
        return;
    L19:
        if (((Boolean) this.S1.getValue()).booleanValue() == false) goto L23;
        if (ja0() == false) goto L23;
        hideLiveFloatWindow();
        goto L23
    L90:
        return;
    L11:
        r4 = null;
        goto L13
    L5:
        if (r0.Y1() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean inIgnoreArea(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return jc1.k.n(IMiddlewareLiveVideoFloatWindowService.class).onFloatWindowInterceptTouchEvent(this, r2);
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        FragmentParamVoNew r3 = ((AnnieFragment) this).e;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.Y1() == true) goto L7;
        return;
    L7:
        if (r3.D() == true) goto L9;
        return;
    L9:
        if (((Boolean) this.S1.getValue()).booleanValue() == false) goto L15;
        showLiveFloatWindow(null);
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void showLiveFloatWindow(JSONObject r3) {
        if (ja0() == false) goto L5;
        return;
    L5:
        this.M1 = true;
        FrameLayout r0 = ((AnnieFragment) this).b1;
        if (r0 == null) goto L9;
        MainThreadPostUtils.e(new b(r0, this, r3));
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.m
    public final void setMuteStatus(boolean r1, boolean r2) {
        this.P1 = r1;
        this.Q1 = r1;
        handleChangeMuteStatus(r1);
    }
}

package com.bytedance.android.live.browser.webview.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b30.a0;
import b30.f0;
import b30.z;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.business.container.AnnieXLiveDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.t;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.android.livesdk.WebDialogRecorder;
import com.bytedance.android.livesdk.config.ad0;
import com.bytedance.android.livesdk.config.j7;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.LiveCardReleaseOpt;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.config.AppConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/webview/fragment/WebDialogFragmentForAnnie;", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "Lcom/bytedance/android/live/browser/jsbridge/f;", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$AutoFloatEnable;", "Lcom/bytedance/android/live/browser/webview/fragment/l;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WebDialogFragmentForAnnie extends BaseWebDialogFragment implements com.bytedance.android.live.browser.jsbridge.f, IVideoFloatManager.AutoFloatEnable, l {
    public PopupHybridParamVo d;
    public BaseHybridParamVo e;
    public String f;
    public HybridDialog g;
    public t h;
    public gf1.a i;
    public com.bytedance.android.live.browser.q j;
    public v k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WebDialogFragmentForAnnie a;

        public b(WebDialogFragmentForAnnie r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a0 r3 = (a0) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            BaseHybridParamVo r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.K(r3.a);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WebDialogFragmentForAnnie a;

        public c(WebDialogFragmentForAnnie r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            z r4 = (z) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            BaseHybridParamVo r0 = this.a.e;
            if (r0 == null) goto L10;
            boolean r1 = true;
            if (r4.a == 1) goto L8;
            r1 = false;
        L8:
            r0.J(r1);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ WebDialogFragmentForAnnie a;

        public d(WebDialogFragmentForAnnie r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((b30.c) r2, "event");
            HybridDialog r3 = this.a.g;
            if (r3 == null) goto L13;
            r3.dismissAllowingStateLoss();     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L14;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L14:
            return;
        }
    }

    public static final class e implements HybridDialog.a {
        public final /* synthetic */ WebDialogFragmentForAnnie a;

        public final void onScroll(int r1) {
        }

        public final void onShow() {
        }

        public final void onDismiss() {
            Dialog r0 = this.a.getDialog();
            if (r0 == null) goto L21;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r2 == null) goto L18;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L7:
            if (Looper.myLooper() == r1.getLooper()) goto L9;
            r1.post(DialogLancet.createDismissRunnable(r0));
            return;
        }

        public e(WebDialogFragmentForAnnie r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void finish() {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L10;
        r1 = r2;
    L10:
        LiveAnnieFragment r3 = (LiveAnnieFragment) r1;
        if (r3 == null) goto L14;
        r3.close();
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final String getRequestPage() {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L11;
        r1 = r2;
    L11:
        if (((LiveAnnieFragment) r1) == null) goto L13;
        return "LiveAnnieFragment";
    L13:
        return "WebDialogFragmentForAnnie";
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void hideLiveFloatWindow() {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L10;
        r1 = r2;
    L10:
        LiveAnnieFragment r3 = (LiveAnnieFragment) r1;
        if (r3 == null) goto L14;
        r3.hideLiveFloatWindow();
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean isAutoFloatEnable() {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L11;
        r1 = r2;
    L11:
        if (((LiveAnnieFragment) r1) == null) goto L13;
        return true;
    L13:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final boolean isShowLiveFloatWindow() {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L10;
        r1 = r2;
    L10:
        LiveAnnieFragment r3 = (LiveAnnieFragment) r1;
        if (r3 != null) goto L15;
        return false;
    L15:
        return r3.ja0();
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        com.bytedance.android.live.browser.q r0 = this.j;
        if (r0 == null) goto L15;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Integer r2 = (Integer) j7.a.getValue();
        if (r2 == null) goto L15;
        if (r2.intValue() != 1) goto L15;
        Iterator r3 = ((LinkedHashMap) r0.c).entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (Intrinsics.areEqual((BaseWebDialogFragment) r4.getValue(), this) == false) goto L11;
        r0.c.remove(r4.getKey());
    L15:
        com.bytedance.android.live.browser.q r1 = this.j;
        if (r1 == null) goto L28;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L27;
        Iterator<WeakReference<DialogFragment>> r5 = r1.b.iterator();
    L21:
        if (r5.hasNext() == false) goto L25;
        WeakReference<DialogFragment> r6 = r5.next();
        if (Intrinsics.areEqual(r6.get(), this) == false) goto L21;
    L26:
        CopyOnWriteArrayList<WeakReference<DialogFragment>> r7 = r1.b;
        r7.remove(r6);
        goto L28
    L25:
        r6 = null;
        goto L26
    L27:
        r1.a.remove(this);
    L28:
        WebDialogRecorder r8 = (WebDialogRecorder) WebDialogRecorder.c.getValue();
        if (r8.a.isEmpty() == true) goto L38;
        r8.a.pop();
        return;
    }

    public WebDialogFragmentForAnnie() {
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void S90(boolean r3) {
        HybridDialog r0 = this.g;
        if ((r0 instanceof BaseDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        BaseDialogFragment r1 = (BaseDialogFragment) r0;
        if (r1 == null) goto L9;
        r1.U90(r3);
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void T90(t r1) {
        this.h = r1;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void U90(boolean r3) {
        HybridDialog r0 = this.g;
        if ((r0 instanceof BaseDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        BaseDialogFragment r1 = (BaseDialogFragment) r0;
        if (r1 == null) goto L9;
        r1.k = r3;
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void V90(boolean r3) {
        HybridDialog r0 = this.g;
        if ((r0 instanceof BaseDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        BaseDialogFragment r1 = (BaseDialogFragment) r0;
        if (r1 == null) goto L9;
        r1.j = r3;
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void X90(boolean r3) {
        HybridDialog r0 = this.g;
        if ((r0 instanceof BaseDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        BaseDialogFragment r1 = (BaseDialogFragment) r0;
        if (r1 == null) goto L9;
        r1.Z90(r3);
        return;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        ((ObservableSubscribeProxy) xs2.b.a().b(a0.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new b(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(z.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new c(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(b30.c.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new d(this));
    }

    public final void onCreate(Bundle r21) {
        super.onCreate(r21);
        if (TTLiveService.getLiveService() != null) goto L12;
        ALogger.e("WebDialogFragmentForAnnie", "livesdk not init!");
        dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L191;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L191:
        return;
    L12:
        BrowserServiceImpl.Companion.getClass();
        s20.b r1 = (s20.b) BrowserServiceImpl.access$getDiComponent$cp();
        r1.getClass();
        s20.b r2 = r1.b;
        this.j = (com.bytedance.android.live.browser.q) r2.f.get();
        this.k = (v) r2.e.get();
        Bundle r3 = getArguments();
        if (r3 == null) goto L34;
        int r8 = com.bytedance.android.live.schema.helper.a.a;
        if (r3.get("hybrid_pop_vo") != null) goto L18;
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamHelper->checkFullScreenVo: webHybridParamVo is null");
        r3.putParcelable("hybrid_pop_vo", com.bytedance.android.live.schema.helper.a.e(r3.getString(LiveSlardarConstants.EXTRA_KEY_URL), null, r3));
    L18:
        this.d = r3.getParcelable("hybrid_pop_vo");
        this.f = r3.getString("arg_url");
        PopupHybridParamVo r4 = this.d;
        if (r4 == null) goto L21;
        BaseHybridParamVo r9 = r4.k;
    L22:
        this.e = r9;
        ALogger.i("WebDialogFragmentForAnnie", String.valueOf(r4));
        if (TextUtils.isEmpty(this.f) == true) goto L34;
        Uri r5 = UriProtector.parse(this.f);
        if (r5 == null) goto L34;
        String r6 = UriProtector.getQueryParameter(r5, "open_animate");     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r6) == true) goto L34;
        PopupHybridParamVo r11 = this.d;     // Catch: Exception -> L32
        if (r11 == null) goto L34;
        r11.O(Intrinsics.areEqual(GamePromoteDataContext.GAME_TYPE_MOBILE, r6));     // Catch: Exception -> L32
        goto L34
    L21:
        r9 = null;
    L34:
        if (e5.j(getActivity()) == false) goto L36;
    L46:
        boolean r7 = true;
    L47:
        if (r7 == false) goto L50;
        setVertical(false);
    L50:
        if (Build.VERSION.SDK_INT >= 23) goto L52;
    L55:
        String r12 = this.f;
        if (r12 == null) goto L127;
        List r13 = (List) ad0.a.getValue();
        if (r13 != null) goto L60;
    L90:
        boolean r14 = false;
    L91:
        if (r14 == false) goto L100;
        BaseHybridParamVo r15 = this.e;
        if (r15 == null) goto L95;
        r15.J(true);
    L95:
        setShouldUseNewPanel(true);
        PopupHybridParamVo r16 = this.d;
        if (r16 == null) goto L98;
        String r17 = r16.m;
    L99:
        setAnimationType(r17);
        goto L100
    L98:
        r17 = null;
    L100:
        WebDialogRecorder r18 = (WebDialogRecorder) WebDialogRecorder.c.getValue();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        r18.a.push(r12);
        PopupHybridParamVo r19 = this.d;
        if (r19 != null) goto L103;
    L112:
        com.bytedance.android.live.browser.q r22 = this.j;
        if (r22 == null) goto L127;
        Intrinsics.checkNotNullParameter(r12, "scheme");
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Integer r23 = (Integer) j7.a.getValue();
        if (r23 == null) goto L127;
        if (r23.intValue() != 1) goto L127;
        BaseWebDialogFragment r24 = r22.c.put(r12, this);
        if (r24 == null) goto L127;
        r24.dismissAllowingStateLoss();     // Catch: Exception -> L123
    L123:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L127;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L127
    L103:
        if ((r19.a() & 80) != 80) goto L112;
        String r26 = UriProtector.getQueryParameter(UriProtector.parse(this.f), "pull_down_close");     // Catch: Exception -> L111
        if (r26 == null) goto L112;
        BaseHybridParamVo r110 = this.e;     // Catch: Exception -> L111
        if (r110 == null) goto L112;
        r110.J(Intrinsics.areEqual(GamePromoteDataContext.GAME_TYPE_MOBILE, r26));     // Catch: Exception -> L111
        goto L112
    L60:
        if ((!r13.isEmpty()) == false) goto L90;
        Iterator r111 = r13.iterator();
    L63:
        if (r111.hasNext() == false) goto L90;
        String r112 = (String) r111.next();
        if (StringsKt.startsWith$default(r112, "http", false, 2, null) == true) goto L67;
        r112 = "http://" + r112;
    L67:
        Uri r27 = UriProtector.parse(r112);
        if (r27 == null) goto L63;
        if (r27.getPath() == null) goto L63;
        if (r27.getHost() == null) goto L63;
        String r113 = "";
        if (TextUtils.isEmpty(r27.getPath()) == true) goto L81;
        String r114 = r27.getPath();
        if (r114 != null) goto L79;
        r114 = "";
    L79:
        if (StringsKt.contains$default(r12, r114, false, 2, null) == false) goto L63;
    L81:
        if (TextUtils.isEmpty(r27.getHost()) == true) goto L88;
        String r28 = r27.getHost();
        if (r28 == null) goto L87;
        r113 = r28;
    L87:
        if (StringsKt.contains$default(r12, r113, false, 2, null) == false) goto L63;
    L88:
        r14 = true;
    L127:
        StringBuilder r29 = new StringBuilder("WebDialogFragmentForAnnie-> onCreate berfor ");
        PopupHybridParamVo r31 = this.d;
        if (r31 == null) goto L130;
        String r32 = r31.toString();
    L131:
        r29.append(r32);
        ALogger.i("WebDialogFragmentForAnnie", r29.toString());
        com.bytedance.android.live.browser.q r33 = this.j;
        if (r33 == null) goto L137;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        if (LiveCardReleaseOpt.INSTANCE.useWeakRef() == false) goto L136;
        r33.b.add(new WeakReference(this));
        goto L137
    L136:
        r33.a.add(this);
    L137:
        BaseHybridParamVo r34 = this.e;
        if (r34 == null) goto L140;
        String r35 = r34.c;
    L141:
        if (r34 == null) goto L143;
        String r115 = r34.z();
    L145:
        if (TextUtils.isEmpty(r115) == true) goto L170;
        Intrinsics.checkNotNull(r115);
        if (StringsKt.startsWith$default(r115, "http", false, 2, null) == false) goto L170;
        if (LiveHybridSettingKeys.ENABLE_SHARE_COOKIE_URL_TO_HTTPS.getValue().booleanValue() == false) goto L170;
        Iterator<T> r36 = LiveHybridSettingKeys.SHARE_COOKIE_URL_TO_HTTPS_LIST.getValue().iterator();
    L153:
        if (r36.hasNext() == false) goto L157;
        if (StringsKt.contains$default(r115, (String) r36.next(), false, 2, null) == false) goto L153;
        boolean r37 = true;
    L158:
        if (r37 == true) goto L170;
        Application r38 = jc1.a.b();
        if (r38 == null) goto L163;
        List r39 = AppConfig.getInstance(r38).getShareCookieHostList(r115);
    L165:
        if (StringsKt.startsWith$default(r115, "http", false, 2, null) == false) goto L170;
        if (r39 == null) goto L170;
        if ((!r39.isEmpty()) == false) goto L170;
        HashMap r41 = new HashMap();
        r41.put(LiveSlardarConstants.EXTRA_KEY_URL, r115);
        u.l().sendLog("live_sdk_webview_http_cookie", r41, new Object[0]);
        r115 = StringsKt.replaceFirst$default(r115, "http://", "https://", false, 4, null);
        goto L170
    L163:
        r39 = null;
        goto L165
    L157:
        r37 = false;
    L170:
        this.i = new gf1.a(r35, r115, this.h);
        return;
    L143:
        r115 = null;
        goto L145
    L140:
        r35 = null;
        goto L141
    L130:
        r32 = null;
        goto L131
    L52:
        if (isVertical() == false) goto L54;
        setStyle(1, 2131954608);
        goto L55
    L54:
        setStyle(1, 2131954607);
        goto L55
    L36:
        if (getActivity() != null) goto L38;
    L40:
        boolean r42 = false;
    L41:
        if (r42 == true) goto L43;
    L45:
        r7 = false;
        goto L47
    L43:
        if (LiveHybridSettingKeys.ENABLE_HYBRID_CONTAINER_ORIENTATION_BY_SIZE.getValue().booleanValue() == false) goto L45;
    L38:
        if (s1.y() <= s1.w()) goto L40;
        r42 = true;
        goto L41
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        if (r4 == null) goto L7;
        Window r0 = r4.getWindow();
        if (r0 == null) goto L7;
        r0.clearFlags(6);
        r0.setDimAmount(0.0f);
    L7:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.e.b().d();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.l
    public final void showLiveFloatWindow(JSONObject r4) {
        HybridDialog r0 = this.g;
        IHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent r2 = r0.getHybridComponent();
    L7:
        if ((r2 instanceof LiveAnnieFragment) == false) goto L10;
        r1 = r2;
    L10:
        LiveAnnieFragment r3 = (LiveAnnieFragment) r1;
        if (r3 == null) goto L14;
        r3.showLiveFloatWindow(r4);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final int show(FragmentTransaction r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "transaction");
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f));
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, this, r0) == false) goto L9;
        return -1;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L7:
        return super.show(r4, r5);
    }

    public final void showNow(FragmentManager r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f));
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r5, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r4, r5);
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L10;
    L7:
        com.bytedance.android.livesdk.e.b().a();
        xs2.b.a().post(new f0(this.f));
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r2, r3);
        goto L7
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        String r0 = this.f;
        PopupHybridParamVo r1 = this.d;
        BaseHybridParamVo r2 = this.e;
        WebDialogFragmentForAnnie$createSchemaUri$1 r3 = WebDialogFragmentForAnnie$createSchemaUri$1.INSTANCE;
        AnnieXLiveDialog r4 = null;
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        Object r5 = r3.invoke(r0, r1, r2);
    L8:
        Uri r7 = (Uri) r5;
        if (r7 == null) goto L26;
        AnnieXLiveDialog r6 = ((IBaseBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(requireContext(), r7, new r(this), getArguments(), null);
        if (r6 == null) goto L31;
        r6.setJSBridgeListener(new q(this, r6));
    L31:
    L23:
        e = move-exception;
        e.getMessage();
    L25:
        r4 = r6;
        goto L26
    L14:
        if ((r6 instanceof AnnieXLiveDialog) == false) goto L17;
        r4 = r6;
    L17:
        AnnieXLiveDialog r8 = r4;     // Catch: Exception -> L23
        if (r8 == null) goto L25;
        Intrinsics.checkNotNullParameter(l.class, "clazz");     // Catch: Exception -> L23
        com.bytedance.android.anniex.container.d r9 = r8.g;     // Catch: Exception -> L23
        if (r9 == null) goto L25;
        r9.registerWeakHolder(l.class, this);     // Catch: Exception -> L23
    L26:
        this.g = r4;
        if (r4 == null) goto L30;
        r4.T90(new e(this));
    L30:
        return super/*androidx.fragment.app.Fragment*/.onCreateView(r12, r13, r14);
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment
    public final void W90(String r8, int r9, int r11, int r12, int r13, BaseHybridParamVo.HybridType r14) {
        Intrinsics.checkNotNullParameter(r14, "type");
        int r15 = p.a[r14.ordinal()];
        if (r15 != 1) goto L5;
        BaseHybridParamVoNew.HybridType r16 = BaseHybridParamVoNew.HybridType.LYNX;
    L16:
        BaseHybridParamVoNew.HybridType r6 = r16;
        HybridDialog r17 = this.g;
        if ((r17 instanceof BaseDialogFragment) == true) goto L19;
        r17 = null;
    L19:
        BaseDialogFragment r0 = (BaseDialogFragment) r17;
        if (r0 == null) goto L23;
        r0.la0(r8, r9, r11, r12, r13, r6);
        return;
    L23:
        return;
    L5:
        if (r15 != 2) goto L7;
        r16 = BaseHybridParamVoNew.HybridType.H5;
        goto L16
    L7:
        if (r15 != 3) goto L9;
        r16 = BaseHybridParamVoNew.HybridType.HOST_H5;
        goto L16
    L9:
        if (r15 != 4) goto L12;
        r16 = BaseHybridParamVoNew.HybridType.HOST_H5;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}

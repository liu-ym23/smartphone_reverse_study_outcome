package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/WebDialogServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebDialogServiceWidget extends MiddlewareRoomWidget implements Observer<KVData>, vlc.l {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public BaseWebDialogFragment b;
    public HybridDialog c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ WebDialogServiceWidget a;

        public a(WebDialogServiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.wq();
        }
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.WebDialogServiceWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb30/m;", "p1", "", "invoke", "(Lb30/m;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<b30.m, Unit> {
        public AnonymousClass1(WebDialogServiceWidget r8) {
            super(1, r8, WebDialogServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/browser/jsbridge/event/OpenLiveWebViewEvent;)V", 0);
        }

        public final void invoke(b30.m r10) {
            Intrinsics.checkNotNullParameter(r10, "p1");
            WebDialogServiceWidget r0 = (WebDialogServiceWidget) ((CallableReference) this).receiver;
            r0.getClass();
            r10.getClass();
            if (TextUtils.isEmpty(null) == true) goto L15;
            Resources r11 = r0.getContext().getResources();
            DisplayMetrics r12 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics());
            float r1 = r12.widthPixels;
            float r2 = r12.density;
            int r3 = (int) (r1 / r2);
            int r13 = (int) (r12.heightPixels / r2);
            if (r0.g1() == false) goto L8;
            int r7 = r13 / 2;
            int r6 = r3;
        L10:
            if (r0.g1() == false) goto L12;
            int r5 = 80;
        L13:
            r0.xq(new i2(null, "", r5, r6, r7, 0));
            return;
        L12:
            r5 = 8388613;
            goto L13
        L8:
            r6 = r13;
            r7 = r6;
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b30.m) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.WebDialogServiceWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/i2;", "p1", "", "invoke", "(Lzg1/i2;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<i2, Unit> {
        public AnonymousClass2(WebDialogServiceWidget r8) {
            super(1, r8, WebDialogServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/PopHalfWebDialogEvent;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i2) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(i2 r2) {
            ((WebDialogServiceWidget) ((CallableReference) this).receiver).xq(r2);
        }
    }

    private final FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public final boolean g1() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.V9() != true) goto L11;
        return true;
    L5:
        if (r0.V9() != true) goto L6;
        return true;
    }

    public WebDialogServiceWidget() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        L7(b30.m.class, new b(new AnonymousClass1(this)));
        L7(i2.class, new b(new AnonymousClass2(this)));
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.addMessageListener(MessageType.ANCHOR_COMMON_DIALOG_MESSAGE.getIntType(), this);
    L7:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.observe("cmd_close_h5_dialog", this);
    L10:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 == null) goto L18;
        PropertyOwner r4 = r3.Ce();
        if (r4 == null) goto L19;
        Disposable r5 = r4.subscribe(new a(this));
        if (r5 == null) goto L20;
        RxUtilKt.c(r5, this.d);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.d.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        vlc.d r2 = (vlc.d) r1.get("data_message_manager", null);
        if (r2 == null) goto L10;
        r2.removeMessageListener(this);
    L10:
        wq();
        this.b = null;
        this.c = null;
        this.a = null;
    }

    public final void wq() {
        if (SettingKeyUtils.a() == true) goto L12;
        BaseWebDialogFragment r0 = this.b;
        if (r0 == null) goto L25;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L26;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L26:
        return;
    L25:
        return;
    L12:
        HybridDialog r2 = this.c;
        if (r2 == null) goto L28;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L29;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L29:
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L21;
        if (r4 == null) goto L9;
        String r5 = r4.getKey();
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.hashCode() == (-797556114)) goto L16;
        return;
    L16:
        if (r5.equals("cmd_close_h5_dialog") == false) goto L20;
        wq();
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L10
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof com.bytedance.android.livesdk.message.model.n) == false) goto L8;
        com.bytedance.android.livesdk.message.model.n r5 = (com.bytedance.android.livesdk.message.model.n) r4;
        UrlBuilder r0 = new UrlBuilder(r5.getSchema());
        r0.addParam("mega_object", r5.E());
        IHostBusiness r6 = jc1.k.f(IHostBusiness.class);
        if (r6 == null) goto L9;
        r6.ecOpenSchema(getContext(), r0.toString(), new Bundle());
        return;
    L9:
        return;
    }

    public final void xq(i2 r21) {
        if (r21 == null) goto L89;
        if (TextUtils.isEmpty(r21.a) == true) goto L89;
        IBrowserService r2 = jc1.k.f(IBrowserService.class);
        FragmentActivity r3 = getActivity();
        if (r2 == null) goto L87;
        if (r3 == null) goto L87;
        int r4 = r21.d;
        if (r4 <= 0) goto L14;
    L17:
        int r5 = r21.e;
        if (r5 <= 0) goto L20;
    L23:
        com.bytedance.android.livesdk.log.filter.n0 r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r6 != null) goto L26;
    L42:
        String r7 = "";
        String r10 = r7;
        String r11 = r10;
    L43:
        com.bytedance.android.livesdk.log.filter.s0 r12 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r12 != null) goto L46;
    L68:
        String r9 = "";
        String r13 = r9;
        String r8 = r13;
    L69:
        int r17 = r5;
        UrlBuilder r0 = new UrlBuilder(r21.a);
        r0.addParam("language", Locale.CHINA.getLanguage());
        r0.addParam("enter_from", r10);
        r0.addParam("source_v3", r11);
        r0.addParam("anchor_id", r9);
        r0.addParam("log_pb", r13);
        r0.addParam("request_id", r8);
        r0.addParam("event_page", r7);
        r0.addParam("event_belong", "live_interact");
        if (SettingKeyUtils.a() == true) goto L72;
        com.bytedance.android.live.browser.webview.fragment.o r1 = r2.buildWebDialog(r0.build()).setWidth(r4);
        r1.b = r17;
        r1.d(r21.f);
        r1.c = r21.g;
        r1.i = r21.c;
        r1.a(r21.i);
        r1.f(r21.b);
        r1.p = r21.j;
        r1.q = true;
        r1.l = r21.h;
        BaseWebDialogFragment r14 = r1.build();
        this.b = r14;
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r3, r14);
        return;
    L72:
        Uri.Builder r15 = x6.a.a(r0.build()).appendQueryParameter("type", "popup").appendQueryParameter("width", String.valueOf(r4)).appendQueryParameter("height", String.valueOf(r17)).appendQueryParameter("radius", String.valueOf(r21.f)).appendQueryParameter("margin", String.valueOf(r21.g));
        if (r21.c != 80) goto L75;
        String r16 = "bottom";
    L76:
        Uri.Builder r18 = r15.appendQueryParameter("gravity", r16);
        String r19 = "1";
        if (r21.j == false) goto L79;
        String r20 = "1";
    L80:
        Uri.Builder r22 = r18.appendQueryParameter("show_dim", r20);
        if (r21.h == true) goto L84;
        r19 = "0";
    L84:
        this.c = r2.showHybridDialog(r3, r22.appendQueryParameter("use_bottom_close", r19).build(), null);
        return;
    L79:
        r20 = "0";
        goto L80
    L75:
        r16 = "other";
        goto L76
    L46:
        if ((r12 instanceof com.bytedance.android.livesdk.log.filter.s0) == false) goto L68;
        com.bytedance.android.livesdk.log.filter.s0 r110 = r12;
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("anchor_id") == false) goto L53;
        String r23 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("anchor_id");
        if (r23 == null) goto L53;
        String r111 = r23;
    L55:
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("log_pb") == false) goto L60;
        String r24 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("log_pb");
        if (r24 == null) goto L60;
        String r112 = r24;
    L62:
        if (((com.bytedance.android.livesdk.log.filter.a) r110).b.containsKey("request_id") == false) goto L67;
        String r25 = (String) ((com.bytedance.android.livesdk.log.filter.a) r110).b.get("request_id");
        if (r25 != null) goto L66;
        r25 = "";
    L66:
        r8 = r25;
        r9 = r111;
        r13 = r112;
        goto L69
    L67:
        r9 = r111;
        r13 = r112;
        r8 = "";
    L60:
        r112 = "";
    L53:
        r111 = "";
        goto L55
    L26:
        if ((r6 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L42;
        com.bytedance.android.livesdk.log.filter.n0 r26 = r6;
        if (((com.bytedance.android.livesdk.log.filter.a) r26).b.containsKey("enter_from") == false) goto L31;
        r10 = (String) ((com.bytedance.android.livesdk.log.filter.a) r26).b.get("enter_from");
        if (r10 == null) goto L31;
    L33:
        if (((com.bytedance.android.livesdk.log.filter.a) r26).b.containsKey("source") == false) goto L36;
        r11 = (String) ((com.bytedance.android.livesdk.log.filter.a) r26).b.get("source");
        if (r11 == null) goto L36;
    L38:
        if (((com.bytedance.android.livesdk.log.filter.a) r26).b.containsKey("event_page") == false) goto L41;
        r7 = (String) ((com.bytedance.android.livesdk.log.filter.a) r26).b.get("event_page");
        if (r7 != null) goto L43;
    L41:
        r7 = "";
    L36:
        r11 = "";
    L31:
        r10 = "";
        goto L33
    L20:
        if (g1() == false) goto L22;
        r5 = 400;
        goto L23
    L22:
        r5 = 320;
        goto L23
    L14:
        if (g1() == false) goto L16;
        r4 = 300;
        goto L17
    L16:
        r4 = 240;
    L87:
        return;
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}

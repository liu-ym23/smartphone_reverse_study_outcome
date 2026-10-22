package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.m0;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.config.hc1;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/DiamondRankDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DiamondRankDialog extends CommonBottomDialog {
    public MultiTypeAdapter a;
    public final String b;
    public final long c;
    public final com.bytedance.android.live.broadcastgame.api.model.u d;
    public final PanelType e;
    public final boolean f;
    public final /* synthetic */ i20.a g;

    public static final class a<T1, T2, R> implements BiFunction {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3, Object r4) {
            BaseResponse r5 = (BaseResponse) r3;
            BaseResponse r6 = (BaseResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "t1");
            Intrinsics.checkNotNullParameter(r6, "t2");
            BaseResponse r0 = new BaseResponse();
            r0.data = new f0((m0) r5.data, (com.bytedance.android.live.broadcastgame.opengame.network.f) r6.data);
            return r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DiamondRankDialog a;

        public b(DiamondRankDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            BaseResponse r11 = (BaseResponse) r9;
            String r5 = "";
            if (((f0) r11.data).a.a() < 0) goto L32;
            List<com.bytedance.android.live.broadcastgame.opengame.network.f.a> r0 = ((f0) r11.data).b.a();
            if (r0 != null) goto L7;
        L10:
            boolean r1 = true;
        L11:
            if (r1 == true) goto L32;
            long r2 = ((f0) r11.data).a.a();
            ArrayList r3 = new ArrayList();
            r3.add(((f0) r11.data).a);
            r3.addAll(((f0) r11.data).b.a());
            MultiTypeAdapter r12 = this.a.a;
            if (r12 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L16:
            r12.a = r3;
            MultiTypeAdapter r13 = this.a.a;
            if (r13 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L19:
            r13.notifyDataSetChanged();
            this.a.findViewById(2131383669).setVisibility(0);
            this.a.findViewById(2131387318).setVisibility(8);
            int r14 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.api.model.u r15 = this.a.d;
            if (r15 == null) goto L23;
            String r4 = r15.name;
            if (r4 == null) goto L23;
        L24:
            if (r15 == null) goto L31;
            com.bytedance.android.live.broadcastgame.api.model.r r16 = r15.c();
            if (r16 == null) goto L31;
            String r17 = String.valueOf(r16.p());
            if (r17 == null) goto L31;
            r5 = r17;
        L31:
            com.bytedance.android.live.broadcastgame.api.interactgame.n.c(r4, r5, String.valueOf(r2));
            return;
        L23:
            r4 = "";
            goto L24
        L7:
            if (r0.isEmpty() == true) goto L10;
            r1 = false;
        L32:
            this.a.findViewById(2131387318).showEmpty();
            int r18 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.api.model.u r19 = this.a.d;
            if (r19 == null) goto L36;
            String r6 = r19.name;
            if (r6 == null) goto L36;
        L37:
            if (r19 == null) goto L44;
            com.bytedance.android.live.broadcastgame.api.model.r r21 = r19.c();
            if (r21 == null) goto L44;
            String r22 = String.valueOf(r21.p());
            if (r22 == null) goto L44;
            r5 = r22;
        L44:
            com.bytedance.android.live.broadcastgame.api.interactgame.n.c(r6, r5, "0");
            return;
        L36:
            r6 = "";
            goto L37
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DiamondRankDialog a;

        public c(DiamondRankDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.findViewById(2131387318).showError();
            int r7 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.api.model.u r8 = this.a.d;
            String r0 = "";
            if (r8 == null) goto L6;
            String r1 = r8.name;
            if (r1 == null) goto L6;
        L7:
            if (r8 == null) goto L14;
            com.bytedance.android.live.broadcastgame.api.model.r r9 = r8.c();
            if (r9 == null) goto L14;
            String r11 = String.valueOf(r9.p());
            if (r11 == null) goto L14;
            r0 = r11;
        L14:
            com.bytedance.android.live.broadcastgame.api.interactgame.n.c(r1, r0, "-1");
            return;
        L6:
            r1 = "";
            goto L7
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DiamondRankDialog a;

        public d(DiamondRankDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Uri.Builder r5 = UriProtector.parse((String) hc1.a.getValue()).buildUpon().appendQueryParameter("height", String.valueOf(UIUtils.px2dip(this.a.getContext(), ((RelativeLayout) this.a.findViewById(2131382021)).getHeight())));
            if (this.a.f == false) goto L5;
            r5.appendQueryParameter("horizontal_width", String.valueOf(395)).build();
        L5:
            Uri r6 = r5.build();
            Logger.d("diamond-rank-dialog", "open uri = " + r6);
            jc1.k.n(IRoomService.class).actionHandler().handle(this.a.getContext(), r6);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ DiamondRankDialog a;

        public e(DiamondRankDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.M0();
        }
    }

    public final int getLayoutId() {
        return 2131565447;
    }

    public final void M0() {
        findViewById(2131383669).setVisibility(8);
        findViewById(2131387318).setVisibility(0);
        findViewById(2131387318).showLoading();
        Lazy r0 = LiveOpenGameClient.d;
        RxUtilKt.h(Observable.zip(((AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class)).getTotalDiamonds(this.b, this.c), ((AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class)).getDiamondRankList(this.b, this.c), a.a)).subscribe(new b(this), new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.g.b();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void show() {
        Disposable r0 = com.bytedance.android.live.broadcastgame.opengame.utils.i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.g.a(r0);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        PanelType r11 = this.e;
        Intrinsics.checkNotNullParameter(r11, "type");
        ((RelativeLayout) findViewById(2131382021)).setLayoutParams(new FrameLayout.LayoutParams(-1, r11.getHeight()));
        ((ImageView) findViewById(2131383537)).setOnClickListener(new d(this));
        findViewById(2131383669).setLayoutManager(new SSLinearLayoutManager(getContext()));
        MultiTypeAdapter r1 = new MultiTypeAdapter();
        this.a = r1;
        r1.z2(com.bytedance.android.live.broadcastgame.opengame.network.f.a.class, new w());
        MultiTypeAdapter r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r2.z2(m0.class, new d0());
        RecyclerView r3 = findViewById(2131383669);
        MultiTypeAdapter r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        r3.setAdapter(r4);
        findViewById(2131383669).addOnScrollListener(new AnonymousClass2(this));
        String r12 = i2.a;
        i2.e((HSImageView) findViewById(2131364135), "/broadcastgame/ttlive_bg_open_panel.png");
        if (this.f == false) goto L33;
        Window r5 = getWindow();
        if (r5 == null) goto L13;
        r5.setGravity(5);
    L13:
        Window r6 = getWindow();
        if (r6 == null) goto L18;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L18;
        r7.width = s1.f(395.0f);
    L18:
        Window r8 = getWindow();
        if (r8 == null) goto L23;
        WindowManager.LayoutParams r13 = r8.getAttributes();
        if (r13 == null) goto L23;
        r13.type = 1000;
    L23:
        View r0 = findViewById(2131382021);
        if (r0 == null) goto L32;
        Drawable r14 = r0.getBackground();
        if ((r14 instanceof GradientDrawable) == true) goto L28;
        r14 = null;
    L28:
        GradientDrawable r15 = (GradientDrawable) r14;
        float r16 = s1.e(12.0f);
        if (r15 == null) goto L31;
        r15.setCornerRadii(new float[]{r16, r16, 0.0f, 0.0f, 0.0f, 0.0f, r16, r16});
    L31:
        a1.k(r0, s1.q(getContext()).heightPixels);
    L32:
        t8.d(getWindow());
        i2.e((HSImageView) findViewById(2131364135), "/broadcastgame/ttlive_bg_game_anchor_consumer_list.png");
    L33:
        View r17 = LayoutInflater.from(getContext()).inflate(2131565448, null);
        View r18 = LayoutInflater.from(getContext()).inflate(2131565449, null);
        ((TextView) r18.findViewById(2131391305)).setOnClickListener(new e(this));
        findViewById(2131387318).setBuilder(new LoadingStatusView.Builder(getContext()).setLoadingView(new DouyinLoadingLayout(getContext())).setEmptyView(r17).setErrorView(r18));
        M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r2) {
        super/*android.app.Dialog*/.onWindowFocusChanged(r2);
        if (this.f == false) goto L7;
        if (r2 == false) goto L8;
        t8.d(getWindow());
        return;
    L8:
        return;
    }

    public DiamondRankDialog(Context r2, String r3, long r4, com.bytedance.android.live.broadcastgame.api.model.u r6, PanelType r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r7, "panelType");
        super(r2, r8, false);
        this.g = new i20.a();
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}

package com.bytedance.android.live.profit.format.voicechat.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.format.voicechat.dialog.VoiceChatMicPermissionDialog;
import com.bytedance.android.live.profit.format.voicechat.model.CloseReason;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatPrivilegeSource;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.android.live.profit.format.voicechat.view.AlphaMaskView;
import com.bytedance.android.live.profit.format.voicechat.view.BlurBackgroundImageView;
import com.bytedance.android.live.profit.format.voicechat.view.CircleProgressView;
import com.bytedance.android.live.profit.format.voicechat.view.OperationTipView;
import com.bytedance.android.live.profit.format.voicechat.view.VoiceChatActionView;
import com.bytedance.android.live.profit.format.voicechat.view.VoiceChatAvatarView;
import com.bytedance.android.live.profit.format.voicechat.view.VoiceChatButtonView;
import com.bytedance.android.live.profit.format.voicechat.viewmodel.VoiceChatViewModel;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.format.GiftPlayerView;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdkapi.service.IMiddlewareInnerLiveFloatWindowService;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.mt.protector.impl.UriProtector;
import com.gyf.barlibrary.ImmersionBar;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.SingleSubject;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nu0.o;
import nu0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/fragment/FormatVoiceChatFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "CancelThrowable", "a", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatVoiceChatFragment extends BaseFragment {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final long z = 0;
    public final Lazy d;
    public ViewGroup e;
    public TextView f;
    public TextView g;
    public tr.d h;
    public VoiceChatAvatarView i;
    public VoiceChatButtonView j;
    public VoiceChatActionView k;
    public AlphaMaskView l;
    public BlurBackgroundImageView m;
    public View n;
    public FrameLayout o;
    public View p;
    public LiveDoubleColorBallAnimationView q;
    public OperationTipView r;
    public boolean s;
    public Function0<Unit> t;
    public final com.bytedance.android.live.profit.format.voicechat.log.a u;
    public final long v;
    public boolean w;
    public Animator x;
    public Disposable y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/fragment/FormatVoiceChatFragment$CancelThrowable;", "", Constants.OperatorKey.MSG, "", "(Ljava/lang/String;)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CancelThrowable extends Throwable {
        public CancelThrowable(String r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
            super(r2);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public b(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            nu0.j.d(this.a, "on receive exit event", null);
            FormatVoiceChatFragment r0 = this.a;
            ((nu0.i) r4).getClass();
            r0.t = null;
            this.a.W90().closeChat(false, CloseReason.OTHER, "forceQuit");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public c(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            nu0.j.c(this.a, "on gift play timeout!!", null, 6);
            FormatVoiceChatFragment.V90(this.a, 2833);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public d(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ju0.f r3 = (ju0.f) r2;
            OperationTipView r0 = this.a.r;
            if (r0 == null) goto L6;
            r0.d(r3);
            return;
        }
    }

    public static final class e implements VoiceChatButtonView.d {
        public final /* synthetic */ FormatVoiceChatFragment a;

        @Override // com.bytedance.android.live.profit.format.voicechat.view.VoiceChatButtonView.d
        public final void a() {
            final FormatVoiceChatFragment r0 = this.a;
            int r1 = FormatVoiceChatFragment.A;
            r0.getClass();
            String r2 = mu0.c.a;
            String r3 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + System.currentTimeMillis() + new SecureRandom().nextInt(WebcastRedirectException.UNKNOWN);
            mu0.c.a = r3;
            mu0.c.b.put("trace_id", r3);
            boolean r4 = false;
            mu0.c.c(VoiceChatTraceStep.CLICK_START, null, null, 0, 14);
            final com.bytedance.android.live.profit.format.voicechat.model.a r5 = (com.bytedance.android.live.profit.format.voicechat.model.a) r0.W90().getBootConfig().getValue();
            final com.bytedance.android.live.profit.format.voicechat.model.c r6 = (com.bytedance.android.live.profit.format.voicechat.model.c) r0.W90().getStartButton().getValue();
            if (r5 == null) goto L47;
            if (r6 == null) goto L47;
            boolean r7 = jc1.k.n(IMiddlewareHostBusiness.class).isInAvCallFloatWindow();
            IMiddlewareInnerLiveFloatWindowService r8 = jc1.k.f(IMiddlewareInnerLiveFloatWindowService.class);
            if (r8 != null) goto L9;
        L11:
            boolean r9 = false;
        L12:
            if (r9 == true) goto L16;
            if (r7 == true) goto L16;
            boolean r10 = false;
        L17:
            if (r10 == false) goto L19;
            int r12 = ToastUtil.a;
            ToastUtil.b(s1.B(2131916709), 0);
            return;
        L19:
            TokenCert r13 = VoiceChatMicPermissionDialog.b;
            Context r14 = r0.requireContext();
            Intrinsics.checkNotNullParameter(r14, "context");
            if (Build.VERSION.SDK_INT >= 31) goto L22;
        L43:
            List<String> r15 = VoiceChatMicPermissionDialog.c;
            if (m60.c.c(r14, r15) == false) goto L46;
            r0.Y90(r5, r6);
            return;
        L46:
            Context r16 = r0.requireContext();
            Function1<Boolean, Unit> r17 = new FormatVoiceChatFragment$onClickStart$1(r0, r5, r6);
            Intrinsics.checkNotNullParameter(r16, "context");
            Intrinsics.checkNotNullParameter(r17, "callback");
            Activity r18 = ContextUtil.contextToActivity(r16);
            SettingKey r19 = m60.i.a;
            m60.i.b r20 = new m60.i.b(r18);
            r20.c = com.bytedance.android.live.profit.format.voicechat.dialog.a.a;
            r20.a(new com.bytedance.android.live.profit.format.voicechat.dialog.b(r17), VoiceChatMicPermissionDialog.b, r15);
            return;
        L22:
            if (((Boolean) nu0.l.i.getValue(null, nu0.l.a[7])).booleanValue() == false) goto L43;
            Object r22 = r14.getSystemService("audio");
            if (r22 == null) goto L42;
            AudioDeviceInfo[] r23 = ((AudioManager) r22).getDevices(2);
            int r24 = r23.length;
            int r25 = 0;
        L26:
            if (r25 >= r24) goto L39;
            AudioDeviceInfo r110 = r23[r25];
            if (r110.getType() != 8) goto L30;
        L35:
            boolean r111 = true;
        L36:
            if (r111 == true) goto L37;
            r25 = r25 + 1;
            goto L26
        L37:
            r4 = true;
            goto L39
        L30:
            if (r110.getType() == 7) goto L35;
            if (r110.getType() == 26) goto L35;
            r111 = false;
        L39:
            if (r4 == false) goto L43;
            VoiceChatMicPermissionDialog.c.add("android.permission.BLUETOOTH_CONNECT");
            goto L43
        L42:
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        L16:
            r10 = true;
            goto L17
        L9:
            if (r8.floatWindowIsShowing() != true) goto L11;
            r9 = true;
        L47:
            nu0.j.c(r0, "on click start, boot config is null!", null, 6);
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.view.VoiceChatButtonView.d
        public final void b() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L6;
            r0.finish();
            return;
        }

        public e(FormatVoiceChatFragment r1) {
            this.a = r1;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public f(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            com.bytedance.android.live.profit.format.voicechat.model.a r9 = (com.bytedance.android.live.profit.format.voicechat.model.a) r8;
            TextView r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.setText(r9.getAuthorName());
        L5:
            ImageModel r1 = new ImageModel();
            r1.setUrls(CollectionsKt.listOf(r9.getAuthorAvatarUrl()));
            RxUtilKt.c(RxUtilKt.h(a1.k(r1).subscribeOn(Schedulers.io())).subscribe(new com.bytedance.android.live.profit.format.voicechat.fragment.b(this), new com.bytedance.android.live.profit.format.voicechat.fragment.c(this)), this.a.W90().getCd());
            this.a.showLoading(false);
            FormatVoiceChatFragment r2 = this.a;
            if (r9.getStartButton().getPrivilegeSource() != VoiceChatPrivilegeSource.VIP.getType()) goto L8;
            boolean r3 = true;
        L9:
            com.bytedance.android.live.profit.format.voicechat.log.a r4 = r2.u;
            Pair[] r10 = new Pair[1];
            if (r3 == false) goto L12;
            String r5 = DataType.TRUE;
        L13:
            r10[0] = TuplesKt.to("is_vip", r5);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r10, "pairs");
            MapsKt.putAll(r4.a, r10);
            com.bytedance.android.live.profit.format.voicechat.log.a.b(r2.u, "format_call_page_show");
            return;
        L12:
            r5 = DataType.FALSE;
            goto L13
        L8:
            r3 = false;
            goto L9
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public g(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.live.profit.format.voicechat.model.c r6 = (com.bytedance.android.live.profit.format.voicechat.model.c) r5;
            VoiceChatButtonView r0 = this.a.j;
            if (r0 == null) goto L6;
            Intrinsics.checkNotNullParameter(r6, "buttonInfo");
            r0.c.setText(r6.getText());
            r0.d.setText(r6.getDesc());
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(r0.c, 16, 20, 1, 2);
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public h(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            final com.bytedance.android.live.profit.format.voicechat.model.f r14 = (com.bytedance.android.live.profit.format.voicechat.model.f) r13;
            if ((r14 instanceof com.bytedance.android.live.profit.format.voicechat.model.f.b) == false) goto L11;
            FormatVoiceChatFragment r0 = this.a;
            r0.w = true;
            com.bytedance.android.live.profit.format.voicechat.log.a.b(r0.u, "format_call_start");
            PublishSubject<nu0.i> r1 = p.a;
            FormatVoiceChatFragment.S90(this.a, VoiceChatState.CONNECTING);
            VoiceChatAvatarView r2 = this.a.i;
            if (r2 == null) goto L69;
            long r3 = ((com.bytedance.android.live.profit.format.voicechat.model.f.b) r14).a.d.getCountDown();
            Function0<Unit> r15 = new FormatVoiceChatFragment$onViewCreated$7$1(this);
            Intrinsics.checkNotNullParameter(r15, "onCountDown");
            CircleProgressView r4 = r2.c;
            if (r4 == null) goto L9;
            r4.setProgressDirection(Path.Direction.CCW);
        L9:
            long r5 = r3 * ((long) 10);
            r2.e = RxUtilKt.h(Observable.intervalRange(0, 1 + r5, 0, 100, TimeUnit.MILLISECONDS).map(new com.bytedance.android.live.profit.format.voicechat.view.h(r5))).subscribe(new com.bytedance.android.live.profit.format.voicechat.view.i(r2, r15));
            return;
        L69:
            return;
        L11:
            if ((r14 instanceof com.bytedance.android.live.profit.format.voicechat.model.f.a) == false) goto L71;
            FormatVoiceChatFragment r6 = this.a;
            if (r6.s == true) goto L15;
        L19:
            PublishSubject<nu0.i> r7 = p.a;
            FormatVoiceChatFragment r8 = this.a;
            r8.s = false;
            VoiceChatAvatarView r9 = r8.i;
            if (r9 == null) goto L31;
            HSImageView r10 = r9.d;
            if (r10 == null) goto L24;
            r10.setVisibility(8);
        L24:
            CircleProgressView r12 = r9.c;
            if (r12 == null) goto L27;
            r12.setProgress(0.0f);
        L27:
            Disposable r16 = r9.e;
            if (r16 == null) goto L31;
            r16.dispose();
        L31:
            if (((com.bytedance.android.live.profit.format.voicechat.model.f.a) r14).a == false) goto L35;
            FragmentActivity r17 = this.a.getActivity();
            if (r17 == null) goto L72;
            r17.finish();
            return;
        L72:
            return;
        L35:
            FormatVoiceChatFragment r18 = this.a;
            Animator r19 = r18.x;
            if (r19 == null) goto L38;
            r19.cancel();
        L38:
            Animator[] r20 = new Animator[7];
            AlphaMaskView r22 = r18.l;
            Animator r23 = null;
            if (r22 == null) goto L41;
            Animator r24 = r22.a(false, 1883);
        L42:
            r20[0] = r24;
            VoiceChatActionView r25 = r18.k;
            if (r25 == null) goto L45;
            String r26 = VoiceChatActionView.s;
            Animator r27 = r25.a(false, 0);
        L46:
            r20[1] = r27;
            VoiceChatAvatarView r28 = r18.i;
            if (r28 == null) goto L49;
            Animator r29 = r28.b(1883, false, false);
        L50:
            r20[2] = r29;
            VoiceChatButtonView r30 = r18.j;
            if (r30 == null) goto L53;
            Animator r32 = r30.a(true, 1466);
        L54:
            r20[3] = r32;
            TextView r33 = r18.f;
            if (r33 == null) goto L57;
            Animator r34 = o.b(r33, 1883, FormatVoiceChatFragment.B, FormatVoiceChatFragment.A);
        L58:
            r20[4] = r34;
            TextView r35 = r18.g;
            if (r35 == null) goto L61;
            Animator r36 = o.b(r35, 1883, FormatVoiceChatFragment.D, FormatVoiceChatFragment.C);
        L62:
            r20[5] = r36;
            View r37 = r18.n;
            if (r37 == null) goto L67;
            Drawable r38 = r37.getBackground();
            if (r38 == null) goto L67;
            r23 = o.a(r38, 1883, FormatVoiceChatFragment.F, FormatVoiceChatFragment.E);
        L67:
            r20[6] = r23;
            AnimatorSet r39 = new AnimatorSet();
            r39.playTogether(CollectionsKt.toList(ArraysKt.filterNotNull(r20)));
            r39.setStartDelay(340);
            r39.addListener(new com.bytedance.android.live.profit.format.voicechat.fragment.f(r18));
            r39.start();
            r18.x = r39;
            return;
        L61:
            r36 = null;
            goto L62
        L57:
            r34 = null;
            goto L58
        L53:
            r32 = null;
            goto L54
        L49:
            r29 = null;
            goto L50
        L45:
            r27 = null;
            goto L46
        L41:
            r24 = null;
            goto L42
        L15:
            if (((com.bytedance.android.live.profit.format.voicechat.model.f.a) r14).b != CloseReason.COUNT_DOWN) goto L17;
            final boolean r40 = true;
        L18:
            r6.u.a("format_call_end", new FormatVoiceChatFragment$onViewCreated$7$2(r14, r40));
            goto L19
        L17:
            r40 = false;
            goto L18
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public i(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            FormatVoiceChatFragment r0 = this.a;
            FormatVoiceChatFragment.S90(r0, (VoiceChatState) r2);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public j(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            VoiceChatActionView r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.c(r3.booleanValue());
            return;
        }
    }

    public final class k implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public k(Function1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r2) {
            this.a.invoke(r2);
        }
    }

    public final class l implements Consumer {
        public final /* synthetic */ Function1 a;

        public l(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class m<T, R> implements Function {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public m(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Boolean r4 = (Boolean) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.booleanValue() == false) goto L6;
            FormatVoiceChatFragment r5 = this.a;
            int r0 = FormatVoiceChatFragment.A;
            return r5.W90().sendGift(this.a.requireContext(), this.a.u.a);
        L6:
            return Single.error(new CancelThrowable("on gift send cancel"));
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ FormatVoiceChatFragment a;

        public n(FormatVoiceChatFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            nu0.j.a(this.a, "on gift send success");
            h1 r4 = ((p2) r3).getGift();
            if (r4 == null) goto L5;
            this.a.X90(r4);
            return;
        L5:
            FormatVoiceChatFragment.T90(this.a, new Throwable("gift result empty"));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.fragment.FormatVoiceChatFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C03561 extends FunctionReferenceImpl implements Function1<View, Unit> {
        public C03561(FormatVoiceChatFragment r8) {
            super(1, r8, FormatVoiceChatFragment.class, "showRulePage", "showRulePage(Landroid/view/View;)V", 0);
        }

        public final void invoke(View r4) {
            FormatVoiceChatFragment r0 = (FormatVoiceChatFragment) ((CallableReference) this).receiver;
            int r1 = FormatVoiceChatFragment.A;
            r0.getClass();
            if (r4 == null) goto L7;
            String r2 = (String) nu0.l.b.getValue(null, nu0.l.a[0]);
            com.bytedance.android.livesdk.revenue.service.hybrid.d.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class), r4.getContext(), UriProtector.parse(r2), null);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((View) r1);
            return Unit.INSTANCE;
        }
    }

    public final VoiceChatViewModel W90() {
        return (VoiceChatViewModel) this.d.getValue();
    }

    static {
        z = ((Number) nu0.l.e.getValue(null, nu0.l.a[3])).longValue();
        A = s1.h(2131107503);
        B = s1.h(2131107504);
        C = s1.h(2131107501);
        D = s1.h(2131107502);
        E = s1.h(2131107499);
        F = s1.h(2131107500);
    }

    public FormatVoiceChatFragment() {
        final Function0<Fragment> r0 = new FormatVoiceChatFragment$$special$$inlined$viewModels$1(this);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VoiceChatViewModel.class), new FormatVoiceChatFragment$$special$$inlined$viewModels$2(r0), null);
        this.u = new com.bytedance.android.live.profit.format.voicechat.log.a();
        this.v = System.currentTimeMillis();
    }

    public final void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        this.u.a("format_call_page_exit", new AnonymousClass1(this));
        PublishSubject<nu0.i> r0 = p.a;
        tr.d r1 = this.h;
        if (r1 == null) goto L5;
        r1.release();
    L5:
        VoiceChatAvatarView r2 = this.i;
        if (r2 == null) goto L16;
        HSImageView r3 = r2.d;
        if (r3 == null) goto L10;
        r3.setVisibility(8);
    L10:
        CircleProgressView r4 = r2.c;
        if (r4 == null) goto L13;
        r4.setProgress(0.0f);
    L13:
        Disposable r5 = r2.e;
        if (r5 == null) goto L16;
        r5.dispose();
    L16:
        Animator r6 = this.x;
        if (r6 == null) goto L19;
        r6.cancel();
    L19:
        Disposable r7 = this.y;
        if (r7 == null) goto L23;
        r7.dispose();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.clearFlags(128);
        return;
    L9:
        return;
    }

    public final void onPause() {
        super.onPause();
        nu0.j.a(this, "on page pause");
        hu0.a r0 = W90().getRtcManager();
        r0.e = true;
        if (r0.d == null) goto L6;
        r0.a.g();
        return;
    }

    public final void onResume() {
        super.onResume();
        nu0.j.a(this, "on page resume");
        hu0.a r0 = W90().getRtcManager();
        if (r0.e == true) goto L5;
    L9:
        r0.e = false;
        return;
    L5:
        if (r0.d == null) goto L9;
        if (r0.i == true) goto L9;
        r0.a.f();
        goto L9
    }

    public static final void U90(FormatVoiceChatFragment r4) {
        Context r0 = r4.requireContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        SingleSubject r1 = SingleSubject.create();
        c9.a r2 = new c9.a(r0);
        r2.d(2131916714);
        r2.a(2131916713);
        nu0.e r3 = nu0.e.a;
        c9.b r5 = r2.a;
        r5.o = r3;
        r5.g = 17;
        r2.b(2131916711, new nu0.f(r1));
        r2.c(2131916712, new nu0.g(r1));
        r2.a.n = new nu0.h(r1);
        r2.e();
        RxUtilKt.c(r1.subscribe(new com.bytedance.android.live.profit.format.voicechat.fragment.d(r4), com.bytedance.android.live.profit.format.voicechat.fragment.e.a), r4.W90().getCd());
    }

    public final void X90(h1 r3) {
        nu0.j.a(this, "real start chat");
        com.bytedance.android.live.profit.format.voicechat.log.a.b(this.u, "format_call_charge_success");
        VoiceChatActionView r0 = this.k;
        if (r0 == null) goto L5;
        r0.b(VoiceChatState.CONNECTING);
    L5:
        tr.d r1 = this.h;
        if (r1 == null) goto L8;
        r1.a(r3);
    L8:
        Disposable r4 = this.y;
        if (r4 == null) goto L11;
        r4.dispose();
    L11:
        this.y = RxUtilKt.h(Observable.timer(((Number) nu0.l.d.getValue(null, nu0.l.a[2])).longValue(), TimeUnit.SECONDS)).subscribe(new c(this));
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        com.bytedance.android.live.profit.format.voicechat.log.a r7 = this.u;
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        r0 = new Bundle();
    L5:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "bundle");
        String r3 = r0.getString("format_owner_id", "");
        r7.b = r3;
        r7.a.put("format_owner_id", r3);
        r7.a.put("format_id", r0.getString("format_id", ""));
        r7.a.put("enter_from", r0.getString("enter_from", ""));
        r7.a.put("enter_method", r0.getString("enter_method", ""));
        r7.a.put("format_digital_human_id", r0.getString("format_digital_human_id", ""));
        r7.a.put("chat_id", r0.getString("chat_id", ""));
        String r8 = mu0.c.a;
        Map<String, String> r9 = this.u.a;
        Intrinsics.checkNotNullParameter(r9, "params");
        mu0.c.a = "";
        Map<String, String> r1 = mu0.c.b;
        ((LinkedHashMap) r1).clear();
        r1.putAll(r9);
        W90().init(this.u.b);
        RxUtilKt.c(p.a.subscribe(new b(this)), W90().getCd());
    }

    public final void showLoading(boolean r1) {
        if (r1 == false) goto L9;
        View r2 = this.p;
        if (r2 == null) goto L6;
        ViewUtilsKt.f(r2);
    L6:
        LiveDoubleColorBallAnimationView r3 = this.q;
        if (r3 == null) goto L16;
        r3.b();
        return;
    L16:
        return;
    L9:
        View r4 = this.p;
        if (r4 == null) goto L12;
        ViewUtilsKt.e(r4);
    L12:
        LiveDoubleColorBallAnimationView r5 = this.q;
        if (r5 == null) goto L18;
        r5.c();
        return;
    }

    public static final void S90(FormatVoiceChatFragment r8, VoiceChatState r9) {
        r8.getClass();
        nu0.j.a(r8, "on chat state change: " + r9);
        VoiceChatActionView r0 = r8.k;
        if (r0 == null) goto L5;
        r0.b(r9);
    L5:
        OperationTipView r1 = r8.r;
        boolean r2 = true;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r9, "state");
        if (com.bytedance.android.live.profit.format.voicechat.view.c.a[r9.ordinal()] == 1) goto L15;
        Disposable r4 = r1.i;
        if (r4 == null) goto L13;
        r4.dispose();
    L13:
        if (r1.getVisibility() != 0) goto L19;
        r1.c(false).start();
        goto L19
    L15:
        nu0.j.d(r1, "开始 thinking 倒计时", null);
        Disposable r5 = r1.i;
        if (r5 == null) goto L18;
        r5.dispose();
    L18:
        r1.i = RxUtilKt.h(Observable.timer(((Number) nu0.l.h.getValue(null, nu0.l.a[6])).longValue(), TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.live.profit.format.voicechat.view.d(r1));
    L19:
        VoiceChatAvatarView r10 = r8.i;
        if (r10 == null) goto L45;
        Intrinsics.checkNotNullParameter(r9, "state");
        if (r9 != VoiceChatState.SPEAKING) goto L24;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L30;
        HSImageView r6 = r10.d;
        if (r6 == null) goto L34;
        r6.setVisibility(0);
    L34:
        if (r9 == VoiceChatState.THINKING) goto L37;
        r2 = false;
    L37:
        if (r2 == false) goto L41;
        HSImageView r12 = r10.g;
        if (r12 == null) goto L46;
        r12.setVisibility(0);
        return;
    L46:
        return;
    L41:
        HSImageView r13 = r10.g;
        if (r13 == null) goto L48;
        r13.setVisibility(8);
        return;
    L48:
        return;
    L30:
        HSImageView r7 = r10.d;
        if (r7 == null) goto L34;
        r7.setVisibility(8);
        goto L34
    L24:
        r3 = false;
        goto L26
    }

    public static final void T90(FormatVoiceChatFragment r2, Throwable r3) {
        r2.getClass();
        nu0.j.c(r2, "send gift failed!", r3, 4);
        r2.s = false;
        if ((r3 instanceof CancelThrowable) == false) goto L5;
        String r4 = "sendGiftCancel";
    L6:
        int r5 = com.bytedance.android.live.profit.format.voicechat.log.a.c;
        com.bytedance.android.live.profit.format.voicechat.log.a.C0020a.a("format_call_close", MapsKt.plus(MapsKt.mapOf(TuplesKt.to("reason", r4)), mu0.c.b));
        return;
    L5:
        r4 = "sendGiftFailed";
        goto L6
    }

    public static final void V90(FormatVoiceChatFragment r6, long r7) {
        VoiceChatButtonView r0 = r6.j;
        if (r0 == null) goto L5;
        int r2 = VoiceChatButtonView.e;
        r0.a(false, 0).start();
    L5:
        Animator r1 = r6.x;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        Animator[] r3 = new Animator[6];
        AlphaMaskView r4 = r6.l;
        Animator r5 = null;
        if (r4 == null) goto L11;
        Animator r8 = r4.a(true, r7);
    L12:
        r3[0] = r8;
        VoiceChatActionView r9 = r6.k;
        if (r9 == null) goto L15;
        Animator r10 = r9.a(true, r7);
    L16:
        r3[1] = r10;
        TextView r12 = r6.f;
        if (r12 == null) goto L19;
        Animator r13 = o.b(r12, r7, A, B);
    L20:
        r3[2] = r13;
        TextView r14 = r6.g;
        if (r14 == null) goto L23;
        Animator r15 = o.b(r14, r7, C, D);
    L24:
        r3[3] = r15;
        View r16 = r6.n;
        if (r16 == null) goto L29;
        Drawable r17 = r16.getBackground();
        if (r17 == null) goto L29;
        Animator r18 = o.a(r17, r7, E, F);
    L30:
        r3[4] = r18;
        VoiceChatAvatarView r19 = r6.i;
        if (r19 == null) goto L33;
        String r20 = VoiceChatAvatarView.h;
        r5 = r19.b(r7, true, true);
    L33:
        r3[5] = r5;
        long r22 = z;
        AnimatorSet r23 = new AnimatorSet();
        r23.playTogether(CollectionsKt.toList(ArraysKt.filterNotNull(r3)));
        r23.setStartDelay(r22);
        r23.addListener(new com.bytedance.android.live.profit.format.voicechat.fragment.g(r6));
        r23.start();
        r6.x = r23;
        return;
    L29:
        r18 = null;
        goto L30
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    }

    public final void Y90(com.bytedance.android.live.profit.format.voicechat.model.a r8, com.bytedance.android.live.profit.format.voicechat.model.c r9) {
        if (this.s == false) goto L6;
        nu0.j.c(this, "start chat failed, isChatting!!", null, 6);
        return;
    L6:
        this.s = true;
        com.bytedance.android.live.profit.format.voicechat.log.a.b(this.u, "format_call_charge");
        nu0.j.d(this, "before chat start, privilege source: " + r9.getPrivilegeSource(), null);
        if (r9.getPrivilegeSource() != VoiceChatPrivilegeSource.GIFT.getType()) goto L17;
        Context r2 = requireContext();
        long r3 = r8.getGiftDiamond();
        Intrinsics.checkNotNullParameter(r2, "context");
        if (((Boolean) nu0.k.b.getValue(null, nu0.k.a[0])).booleanValue() == false) goto L11;
        Single r10 = Single.just(Boolean.TRUE);
    L16:
        RxUtilKt.c(RxUtilKt.i(r10.flatMap(new m(this))).subscribe(new n(this), new l(new FormatVoiceChatFragment$startChat$3(this))), W90().getCd());
        return;
    L11:
        r10 = SingleSubject.create();
        String r0 = s1.C(2131916717, new Object[]{Long.valueOf(r3)});
        c9.b r1 = new c9.b();
        r1.a = r2;
        r1.b = 2;
        r1.e = r1.a.getText(2131916718);
        r1.f = r0;
        r1.o = nu0.a.a;
        r1.g = 17;
        nu0.b r12 = new nu0.b(r10);
        r1.j = r1.a.getText(2131916715);
        r1.k = r12;
        nu0.c r13 = new nu0.c(r10);
        r1.l = r1.a.getText(2131916716);
        r1.m = r13;
        r1.n = new nu0.d(r10);
        c9 r14 = new c9(r1.a, r1);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r14);
        goto L16
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L15:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L16
    L17:
        h1 r4 = (h1) vh7.f.c(h1.class);
        r4.setId(r8.getGiftId());
        r4.setName("");
        r4.setPrimaryEffectId(r8.getEffectId());
        r4.setType(2);
        Unit r15 = Unit.INSTANCE;
        X90(r4);
    }

    /* JADX WARN: Type inference failed for: r6v15, types: [com.bytedance.android.live.profit.format.voicechat.fragment.FormatVoiceChatFragment$onViewCreated$$inlined$apply$lambda$1] */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        ViewGroup r7 = this.e;
        OperationTipView r8 = null;
        if (r7 == null) goto L5;
        TextView r9 = (TextView) r7.findViewById(2131392704);
    L6:
        this.f = r9;
        ViewGroup r10 = this.e;
        if (r10 == null) goto L9;
        TextView r12 = (TextView) r10.findViewById(2131392701);
    L10:
        this.g = r12;
        ViewGroup r13 = this.e;
        if (r13 == null) goto L13;
        AlphaMaskView r14 = (AlphaMaskView) r13.findViewById(2131379672);
    L14:
        this.l = r14;
        ViewGroup r15 = this.e;
        if (r15 == null) goto L17;
        BlurBackgroundImageView r16 = (BlurBackgroundImageView) r15.findViewById(2131392680);
    L18:
        this.m = r16;
        ViewGroup r17 = this.e;
        if (r17 == null) goto L21;
        VoiceChatAvatarView r18 = (VoiceChatAvatarView) r17.findViewById(2131392681);
    L22:
        this.i = r18;
        ViewGroup r19 = this.e;
        if (r19 == null) goto L25;
        VoiceChatButtonView r20 = (VoiceChatButtonView) r19.findViewById(2131392685);
    L26:
        this.j = r20;
        ViewGroup r22 = this.e;
        if (r22 == null) goto L29;
        VoiceChatActionView r23 = (VoiceChatActionView) r22.findViewById(2131392677);
    L30:
        this.k = r23;
        ViewGroup r24 = this.e;
        if (r24 == null) goto L33;
        View r25 = r24.findViewById(2131392696);
    L34:
        this.n = r25;
        ViewGroup r26 = this.e;
        if (r26 == null) goto L37;
        View r27 = r26.findViewById(2131392690);
    L38:
        this.p = r27;
        ViewGroup r28 = this.e;
        if (r28 == null) goto L41;
        LiveDoubleColorBallAnimationView r29 = (LiveDoubleColorBallAnimationView) r28.findViewById(2131392692);
    L42:
        this.q = r29;
        ViewGroup r30 = this.e;
        if (r30 == null) goto L45;
        FrameLayout r32 = (FrameLayout) r30.findViewById(2131373772);
    L46:
        this.o = r32;
        ViewGroup r33 = this.e;
        if (r33 == null) goto L49;
        r8 = (OperationTipView) r33.findViewById(2131381565);
    L49:
        this.r = r8;
        View r34 = this.n;
        if (r34 == null) goto L54;
        Drawable r35 = r34.getBackground();
        if (r35 == null) goto L54;
        r35.mutate();
    L54:
        showLoading(true);
        ViewGroup r36 = this.e;
        if (r36 == null) goto L59;
        View r37 = r36.findViewById(2131392699);
        if (r37 == null) goto L59;
        ViewGroup.LayoutParams r0 = r37.getLayoutParams();
        r0.height = ImmersionBar.getStatusBarHeight(requireActivity());
        Unit r1 = Unit.INSTANCE;
        r37.setLayoutParams(r0);
    L59:
        ImmersionBar.with(this).transparentStatusBar().statusBarDarkFont(true).init();
        FragmentActivity r38 = getActivity();
        if (r38 == null) goto L64;
        Window r39 = r38.getWindow();
        if (r39 == null) goto L64;
        r39.addFlags(128);
    L64:
        View r40 = this.n;
        if (r40 == null) goto L67;
        r40.setOnClickListener(new k(new C03561(this)));
    L67:
        VoiceChatButtonView r42 = this.j;
        if (r42 == null) goto L70;
        r42.setButtonClickListener(new e(this));
    L70:
        VoiceChatActionView r43 = this.k;
        if (r43 == null) goto L73;
        r43.setActionListener(new AnonymousClass3(this));
    L73:
        GiftPlayerView r44 = com.bytedance.android.live.revenue.core.util.f.a(tr.b.class).j5(requireContext(), true);
        View r45 = r44.getView();
        if (r45 == null) goto L78;
        FrameLayout r2 = this.o;
        if (r2 == null) goto L78;
        r2.addView(r45, new FrameLayout.LayoutParams(-1, -1, 80));
    L78:
        r44.f(new FormatVoiceChatFragment$onViewCreated$$inlined$apply$lambda$1(this));
        Unit r46 = Unit.INSTANCE;
        this.h = r44;
        W90().getBootConfig().observe(getViewLifecycleOwner(), new f(this));
        W90().getStartButton().observe(getViewLifecycleOwner(), new g(this));
        W90().getState().observe(getViewLifecycleOwner(), new h(this));
        W90().getChatState().observe(getViewLifecycleOwner(), new i(this));
        W90().isMute().observe(getViewLifecycleOwner(), new j(this));
        W90().getTopics().observe(getViewLifecycleOwner(), new d(this));
        FragmentActivity r47 = getActivity();
        if (r47 == null) goto L84;
        OnBackPressedDispatcher r48 = r47.getOnBackPressedDispatcher();
        if (r48 == null) goto L85;
        r48.addCallback(getViewLifecycleOwner(), new AnonymousClass11(this));
        return;
    L85:
        return;
    L84:
        return;
    L45:
        r32 = null;
        goto L46
    L41:
        r29 = null;
        goto L42
    L37:
        r27 = null;
        goto L38
    L33:
        r25 = null;
        goto L34
    L29:
        r23 = null;
        goto L30
    L25:
        r20 = null;
        goto L26
    L21:
        r18 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566024, r3, false);
        if ((r5 instanceof ViewGroup) == true) goto L5;
        r5 = null;
    L5:
        ViewGroup r6 = (ViewGroup) r5;
        this.e = r6;
        return r6;
    }
}

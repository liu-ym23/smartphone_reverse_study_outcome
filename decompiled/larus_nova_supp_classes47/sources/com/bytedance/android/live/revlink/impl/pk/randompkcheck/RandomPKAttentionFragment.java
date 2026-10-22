package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.pk.service.j;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/randompkcheck/RandomPKAttentionFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lzy0/b;", "hybridCard", "Lcom/bytedance/android/live/revenue/platform/hybrid/api/HybridType;", "getType", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RandomPKAttentionFragment extends LiveDialogFragment {
    public static final /* synthetic */ int p = 0;
    public zy0.b d;
    public ViewGroup e;
    public FrameLayout f;
    public Switch g;
    public FrameLayout h;
    public RandomMatchCheckSource i;
    public DouyinLoadingLayout j;
    public final CompositeDisposable k;
    public j l;
    public Boolean m;
    public String n;
    public x o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RandomPKAttentionFragment a;

        public b(RandomPKAttentionFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            Switch r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.setChecked(!r4.booleanValue());
        L6:
            if (r4.booleanValue() == false) goto L11;
            FrameLayout r5 = this.a.f;
            if (r5 == null) goto L12;
            r5.setVisibility(8);
            return;
        L12:
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ RandomPKAttentionFragment a;

        public c(RandomPKAttentionFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            RandomPKAttentionFragment r4 = this.a;
            int r0 = RandomPKAttentionFragment.p;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L18;
            if (r2 == null) goto L22;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L19;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L23;
            Object r7 = r2.getSystemService("input_method");
            if (r7 == null) goto L17;
            InputMethodManager r8 = (InputMethodManager) r7;
            if (r8.isActive() == false) goto L20;
            r8.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        L23:
            return;
        L19:
            return;
        L22:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ RandomPKAttentionFragment a;

        public d(RandomPKAttentionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ RandomPKAttentionFragment a;

        public e(RandomPKAttentionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            final RandomPKAttentionFragment r6 = this.a;
            String r0 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.b(r6.i);
            Intrinsics.checkNotNullParameter(r0, "connection_type");
            HashMap r2 = new HashMap();
            r2.put("connection_type", r0);
            com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r2);
            n r1 = new n();
            Map<String, String> r3 = r1.a;
            Intrinsics.checkNotNullParameter(r3, "map");
            Intrinsics.checkNotNullParameter(r2, "map");
            r3.putAll(r2);
            cy0.e.a.getClass();
            cy0.j r4 = cy0.e.a.a;
            m.e.getClass();
            Object r7 = m.b(r4).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r7);
            ((i) ((f80.a) r7)).w3("livesdk_randommatch_announcement_bottom_agree", r1.a, r1.b);
            r6.T90(true, new RandomPKAttentionFragment$onAgreeBtnClick$1(r6));
        }
    }

    public static final class f implements LiveBottomSheetDialog.m {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ boolean b;

        public g(Function1 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            jy0.b.c("randon_pk_attention_fragment", "on confirm autocheck succeed", null, 4);
            this.a.invoke(Boolean.valueOf(this.b));
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            jy0.b.c("randon_pk_attention_fragment", "on confirm autocheck error", null, 4);
        }
    }

    static {
    }

    public RandomPKAttentionFragment() {
        this.k = new CompositeDisposable();
        this.n = "";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.k.clear();
    }

    private final HybridType getType(zy0.b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L5;
        Window r7 = r6.getWindow();
    L6:
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L12:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, s1.f(484.0f));
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        r7.setWindowAnimations(2131954623);
        return;
    L14:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        RandomCheckDataContext r3 = RandomCheckDataContext.Companion.getContext();
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getRandomChecked();
        if (r4 == null) goto L13;
        Observable r5 = r4.a();
        if (r5 == null) goto L14;
        Disposable r6 = r5.subscribe(new b(this));
        if (r6 == null) goto L15;
        RxUtilKt.c(r6, this.k);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new c(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public static final /* synthetic */ HybridType S90(RandomPKAttentionFragment r0, zy0.b r1) {
        return r0.getType(r1);
    }

    public final void T90(boolean r8, Function1<? super Boolean, Unit> r9) {
        k r0 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        if (r0 == null) goto L19;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L23;
        HashMap r6 = new HashMap();
        r6.put("auto_confirm", Boolean.valueOf(r8));
        r31.a r2 = r31.b.a(r31.a.a);
        long r3 = r1.getId();
        IBaseUser r4 = r1.getOwner();
        if (r4 == null) goto L10;
        Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
        String r5 = r4.getCastSecUid();
    L11:
        Observable<ExtraResponse<Object, Extra>> r7 = r2.N(r3, r5, 14, r6);
        if (r7 == null) goto L20;
        Observable r10 = r7.compose(RxUtil.rxSchedulerHelper());
        if (r10 == null) goto L21;
        Disposable r12 = r10.subscribe(new g(r9, r8), h.a);
        if (r12 == null) goto L22;
        RxUtilKt.c(r12, this.k);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r5 = null;
        goto L11
    L23:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        setBottomSheetSlideProcessor(f.a);
        this.j = r8.findViewById(2131379098);
        this.e = (ViewGroup) r8.findViewById(2131363356);
        DouyinLoadingLayout r10 = this.j;
        if (r10 == null) goto L5;
        r10.setVisibility(0);
    L5:
        Context r12 = getContext();
        boolean r1 = true;
        if (r12 == null) goto L9;
        f51.a r2 = f51.a.e;
        r2.getClass();
        this.d = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r12, UriProtector.parse((String) f51.a.c.getValue(r2, f51.a.a[1])), new RandomPKAttentionFragment$loadAttentionWebView$1(this));
    L9:
        zy0.b r13 = this.d;
        if (r13 == null) goto L14;
        xy0.a<?> r14 = r13.g();
        if (r14 == null) goto L14;
        r14.load();
    L14:
        View r15 = r8.findViewById(2131363770);
        View r3 = null;
        if ((r15 instanceof AutoRTLImageView) == true) goto L17;
        r15 = null;
    L17:
        AutoRTLImageView r16 = (AutoRTLImageView) r15;
        if (r16 == null) goto L20;
        r16.setImageDrawable(s1.m(2131251314));
        r3.c(r16, "返回", true);
        r16.setOnClickListener(new d(this));
        Unit r17 = Unit.INSTANCE;
    L20:
        View r18 = r8.findViewById(2131362317);
        if ((r18 instanceof FrameLayout) == true) goto L23;
        r18 = null;
    L23:
        FrameLayout r19 = (FrameLayout) r18;
        this.f = r19;
        RandomMatchCheckSource r4 = this.i;
        if (r4 != RandomMatchCheckSource.Setting) goto L27;
        if (r19 == null) goto L28;
        r19.setVisibility(8);
    L28:
        View r20 = r8.findViewById(2131362316);
        if ((r20 instanceof TextView) == false) goto L32;
        r3 = r20;
    L32:
        TextView r5 = (TextView) r3;
        if (r5 == null) goto L35;
        r5.setOnClickListener(new e(this));
    L35:
        this.h = (FrameLayout) r8.findViewById(2131363355);
        Switch r22 = (Switch) r8.findViewById(2131387872);
        this.g = r22;
        if (r22 == null) goto L38;
        r22.setClickable(false);
    L38:
        Switch r23 = this.g;
        if (r23 == null) goto L41;
        r23.setChecked(!RandomCheckDataContext.Companion.b());
    L41:
        FrameLayout r24 = this.h;
        if (r24 == null) goto L44;
        r24.setOnClickListener(new RandomPKAttentionFragment$initSwitch$1(this));
    L44:
        Switch r25 = this.g;
        if (r25 == null) goto L47;
        r1 = r25.isChecked();
    L47:
        String r26 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.c(this.i);
        Intrinsics.checkNotNullParameter(r26, "source");
        HashMap r0 = new HashMap();
        if (r1 == false) goto L50;
        String r6 = "on";
    L51:
        r0.put("status", r6);
        r0.put("source", r26);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r0);
        n r27 = new n();
        Map<String, String> r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r28.putAll(r0);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        m.e.getClass();
        Object r30 = m.b(r29).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r30);
        ((i) ((f80.a) r30)).w3("livesdk_randommatch_announcements_show", r27.a, r27.b);
        return;
    L50:
        r6 = "off";
        goto L51
    L27:
        String r32 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.b(r4);
        Intrinsics.checkNotNullParameter(r32, "connection_type");
        HashMap r7 = new HashMap();
        r7.put("connection_type", r32);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r7);
        n r33 = new n();
        Map<String, String> r34 = r33.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r34.putAll(r7);
        cy0.e.a.getClass();
        cy0.j r35 = cy0.e.a.a;
        m.e.getClass();
        Object r36 = m.b(r35).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r36);
        ((i) ((f80.a) r36)).w3("livesdk_randommatch_announcement_bottom_show", r33.a, r33.b);
        goto L28
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131567249, r2);
    }
}

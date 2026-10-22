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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.pk.service.j;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/randompkcheck/RandomPKCheckFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RandomPKCheckFragment extends LiveDialogFragment {
    public static final /* synthetic */ int m = 0;
    public HSImageView d;
    public RandomMatchCheckSource e;
    public RandomMatchCheckSource f;
    public Boolean g;
    public String h;
    public TextView i;
    public final CompositeDisposable j;
    public j k;
    public x l;

    public static final class a {
        public a() {
        }

        public static RandomPKCheckFragment a(RandomMatchCheckSource r3, RandomMatchCheckSource r4, Boolean r5, String r6, x r7, int r8) {
            int r0 = RandomPKCheckFragment.m;
            if ((r8 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r8 & 4) == 0) goto L8;
            r5 = Boolean.FALSE;
        L8:
            String r2 = "";
            if ((r8 & 8) == 0) goto L12;
            r6 = "";
        L12:
            if ((r8 & 16) == 0) goto L14;
            r7 = null;
        L14:
            Intrinsics.checkNotNullParameter(r3, "source");
            RandomPKCheckFragment r9 = new RandomPKCheckFragment();
            r9.e = r3;
            if (r4 == null) goto L18;
            r3 = r4;
        L18:
            r9.f = r3;
            if (r5 == null) goto L21;
            boolean r10 = r5.booleanValue();
        L22:
            r9.g = Boolean.valueOf(r10);
            if (r6 == null) goto L26;
            r2 = r6;
        L26:
            r9.h = r2;
            r9.l = r7;
            return r9;
        L21:
            r10 = false;
            goto L22
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ RandomPKCheckFragment a;

        public b(RandomPKCheckFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            RandomPKCheckFragment r4 = this.a;
            int r0 = RandomPKCheckFragment.m;
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RandomPKCheckFragment a;

        public c(RandomPKCheckFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            RandomPKCheckFragment r6 = this.a;
            int r0 = RandomPKCheckFragment.m;
            r6.getClass();
            r6.dismiss();     // Catch: Exception -> L5
        L9:
            RandomMatchCheckSource r1 = r6.e;
            if (r1 == RandomMatchCheckSource.AttentionFragment) goto L37;
            int r2 = RandomPKAttentionFragment.p;
            if (r1 != null) goto L14;
            r1 = RandomMatchCheckSource.CheckFragment;
        L14:
            x r3 = r6.l;
            Intrinsics.checkNotNullParameter(r1, "source");
            RandomPKAttentionFragment r4 = new RandomPKAttentionFragment();
            r4.i = r1;
            r4.o = r3;
            FragmentActivity r7 = r6.getActivity();
            if (r7 == null) goto L23;
            FragmentManager r8 = r7.getSupportFragmentManager();
            if (r8 == null) goto L23;
            LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "randon_pk_attention_fragment", r9);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r4, r9) == true) goto L23;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
        L22:
            r4.show(r8, "randon_pk_attention_fragment");
        L23:
            r4.l = r6.k;
            Boolean r10 = r6.g;
            if (r10 == null) goto L26;
            boolean r12 = r10.booleanValue();
        L27:
            r4.m = Boolean.valueOf(r12);
            String r13 = r6.h;
            if (r13 != null) goto L30;
            r13 = "";
        L30:
            r4.n = r13;
            return;
        L26:
            r12 = false;
            goto L27
        L37:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r14 = DialogFragmentLancet.sLastShowStack;
            if (r14 == null) goto L9;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ RandomPKCheckFragment a;

        public d(RandomPKCheckFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            RandomPKCheckFragment r3 = this.a;
            int r0 = RandomPKCheckFragment.m;
            r3.S90("cancel");
            r3.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ RandomPKCheckFragment a;

        public e(RandomPKCheckFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            RandomPKCheckFragment r9 = this.a;
            int r0 = RandomPKCheckFragment.m;
            r9.getClass();
            k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
            if (r1 == null) goto L20;
            IRoom r2 = r1.getRoom();
            if (r2 == null) goto L21;
            HashMap r6 = new HashMap();
            r6.put("auto_confirm", Boolean.TRUE);
            r31.a r3 = r31.b.a(r31.a.a);
            long r4 = r2.getId();
            IBaseUser r5 = r2.getOwner();
            if (r5 == null) goto L10;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            String r7 = r5.getCastSecUid();
        L11:
            Observable<ExtraResponse<Object, Extra>> r10 = r3.N(r4, r7, 14, r6);
            if (r10 == null) goto L18;
            Observable r12 = r10.compose(RxUtil.rxSchedulerHelper());
            if (r12 == null) goto L18;
            Disposable r13 = r12.subscribe(new com.bytedance.android.live.revlink.impl.pk.randompkcheck.d(r9), com.bytedance.android.live.revlink.impl.pk.randompkcheck.e.a);
            if (r13 == null) goto L18;
            RxUtilKt.c(r13, r9.j);
        L18:
            r9.S90("accept");
            return;
        L10:
            r7 = null;
            goto L11
        L21:
            return;
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

    static {
        new a();
    }

    public RandomPKCheckFragment() {
        this.h = "";
        this.j = new CompositeDisposable();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.j.clear();
    }

    public final void S90(String r6) {
        RandomMatchCheckSource r0 = this.e;
        if (r0 != RandomMatchCheckSource.PKUserListFragment) goto L5;
    L10:
        String r1 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.b(r0);
        Intrinsics.checkNotNullParameter(r1, "connection_type");
        Intrinsics.checkNotNullParameter(r6, "choice");
        HashMap r4 = new HashMap();
        r4.put("connection_type", r1);
        r4.put("choice", r6);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r4);
        n r7 = new n();
        Map<String, String> r2 = r7.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r2.putAll(r4);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r5 = m.b(r3).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r5);
        ((i) ((f80.a) r5)).w3("livesdk_randommatch_announcement_page_click", r7.a, r7.b);
        return;
    L5:
        if (r0 == RandomMatchCheckSource.MultiPKUserListFragment) goto L10;
        if (r0 != RandomMatchCheckSource.AttentionFragment) goto L12;
        String r8 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.c(this.f);
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r6, "choice");
        HashMap r9 = new HashMap();
        r9.put("source", r8);
        r9.put("choice", r6);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r9);
        n r10 = new n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r12.putAll(r9);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        m.e.getClass();
        Object r14 = m.b(r13).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r14);
        ((i) ((f80.a) r14)).w3("livesdk_randommatch_reject_announcement_page_click", r10.a, r10.b);
        return;
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
        r7.setLayout(-1, s1.f(373.0f));
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

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        setBottomSheetSlideProcessor(f.a);
        RandomMatchCheckSource r5 = this.e;
        if (r5 != RandomMatchCheckSource.PKUserListFragment) goto L5;
    L10:
        String r6 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.b(r5);
        Intrinsics.checkNotNullParameter(r6, "connection_type");
        HashMap r1 = new HashMap();
        r1.put("connection_type", r6);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r1);
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r8.putAll(r1);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        m.e.getClass();
        Object r10 = m.b(r9).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r10);
        ((i) ((f80.a) r10)).w3("livesdk_randommatch_announcement_page_show", r7.a, r7.b);
        return;
    L5:
        if (r5 == RandomMatchCheckSource.MultiPKUserListFragment) goto L10;
        if (r5 != RandomMatchCheckSource.AttentionFragment) goto L12;
        String r12 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.c(this.f);
        Intrinsics.checkNotNullParameter(r12, "source");
        HashMap r2 = new HashMap();
        r2.put("source", r12);
        com.bytedance.android.live.revlink.impl.pk.randompkcheck.b.a(r2);
        n r13 = new n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r14.putAll(r2);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        m.e.getClass();
        Object r16 = m.b(r15).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r16);
        ((i) ((f80.a) r16)).w3("livesdk_randommatch_reject_announcement_page_show", r13.a, r13.b);
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r8 = r5.inflate(2131567142, r6);
        View r9 = r8.findViewById(2131375140);
        View r0 = null;
        if ((r9 instanceof HSImageView) == true) goto L5;
        r9 = null;
    L5:
        HSImageView r10 = (HSImageView) r9;
        this.d = r10;
        if (r10 == null) goto L8;
        x41.a r12 = x41.a.f;
        r12.getClass();
        r10.setImageURI((String) x41.a.e.getValue(r12, x41.a.a[3]));
    L8:
        float r13 = s1.f(12.0f);
        RoundingParams r14 = RoundingParams.fromCornersRadii(r13, r13, 0.0f, 0.0f);
        HSImageView r15 = this.d;
        if (r15 == null) goto L13;
        GenericDraweeHierarchy r16 = r15.getHierarchy();
        if (r16 == null) goto L13;
        r16.setRoundingParams(r14);
    L13:
        View r17 = r8.findViewById(2131374380);
        if ((r17 instanceof LinearLayout) == false) goto L17;
        r0 = r17;
    L17:
        LinearLayout r1 = (LinearLayout) r0;
        if (r1 == null) goto L20;
        r1.setOnClickListener(new c(this));
    L20:
        TextView r18 = (TextView) r8.findViewById(2131365123);
        if (r18 == null) goto L23;
        r18.setOnClickListener(new d(this));
    L23:
        TextView r19 = (TextView) r8.findViewById(2131367675);
        this.i = r19;
        if (r19 == null) goto L26;
        r19.setOnClickListener(new e(this));
    L26:
        TextView r20 = this.i;
        if (r20 == null) goto L39;
        RandomMatchCheckSource r22 = this.e;
        if (r22 == null) goto L35;
        int r23 = com.bytedance.android.live.revlink.impl.pk.randompkcheck.c.a[r22.ordinal()];
        if (r23 != 1) goto L34;
        String r24 = "同意";
    L38:
        r20.setText(r24);
        goto L39
    L34:
        if (r23 != 2) goto L35;
        r24 = "同意并发起随机匹配";
    L35:
        r24 = "同意并发起随机PK";
    L39:
        TextView r25 = (TextView) r8.findViewById(2131381026);
        if (r25 != null) goto L42;
    L46:
        return r8;
    L42:
        if (this.e != RandomMatchCheckSource.AttentionFragment) goto L44;
        String r26 = "同意以下协议才可关闭开关";
    L45:
        r25.setText(r26);
        goto L46
    L44:
        r26 = "发起随机匹配前请阅读并同意以下协议";
        goto L45
    }
}

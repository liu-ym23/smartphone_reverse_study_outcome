package com.bytedance.android.live.livepkaudience.dialog;

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
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.livepkaudience.vm.PkAudiencePreApplyViewModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudiencePreApplyDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudiencePreApplyDialog extends LiveDialogFragment {
    public static final /* synthetic */ int t = 0;
    public Room d;
    public DataCenter e;
    public final CompositeDisposable f;
    public PkAudiencePreApplyViewModel g;
    public final MultiTypeAdapter h;
    public TextView i;
    public RecyclerView j;
    public FrameLayout k;
    public TextView l;
    public HSImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public boolean r;
    public final b s;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PkAudiencePreApplyDialog a;

        public b(PkAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Integer r7 = (Integer) r6;
            if (r7 != null) goto L5;
            return;
        L5:
            if (r7.intValue() != 0) goto L17;
            TextView r8 = this.a.q;
            if (r8 == null) goto L9;
            r8.setText(s1.B(2131917501));
        L9:
            this.a.S90(null);
            this.a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r9 = DialogFragmentLancet.sLastShowStack;
            if (r9 == null) goto L45;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L45:
            return;
        L17:
            if (r7.intValue() != 1) goto L28;
            DataCenter r10 = this.a.e;
            if (r10 == null) goto L21;
            r10.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
        L21:
            TextView r11 = this.a.q;
            if (r11 == null) goto L24;
            r11.setText(s1.B(2131914738));
        L24:
            PkAudiencePreApplyDialog r12 = this.a;
            PkAudiencePreApplyViewModel r0 = r12.g;
            if (r0 == null) goto L47;
            r0.fetchList(r12.d, true);
            return;
        L47:
            return;
        L28:
            if (r7.intValue() != 2) goto L49;
            DataCenter r13 = this.a.e;
            if (r13 == null) goto L40;
            r13.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        L40:
            this.a.dismiss();     // Catch: Exception -> L35
            return;
        L35:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r14 = DialogFragmentLancet.sLastShowStack;
            if (r14 == null) goto L50;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L50:
            return;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkAudiencePreApplyDialog a;

        public d(PkAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkAudiencePreApplyDialog r4 = this.a;
            int r0 = PkAudiencePreApplyDialog.t;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class e<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkAudiencePreApplyDialog a;

        public e(PkAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            PkAudiencePreApplyDialog r0 = this.a;
            r0.S90((Text) r2);
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkAudiencePreApplyDialog a;

        public f(PkAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            c1 r10 = (c1) r9;
            if (r10 == null) goto L48;
            PkAudiencePreApplyDialog r1 = this.a;
            View r2 = r1.p;
            if (r2 == null) goto L7;
            r2.setVisibility(0);
        L7:
            IBaseUser r3 = r10.f();
            String r4 = null;
            if (r3 == null) goto L10;
            py.k r5 = r3.getAvatarThumbKt();
        L11:
            PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r5, -1)).setAutoPlayAnimations(false);
            HSImageView r7 = r1.m;
            if (r7 == null) goto L14;
            DraweeController r8 = r7.getController();
        L15:
            AbstractDraweeController r11 = r6.setOldController(r8).build();
            HSImageView r12 = r1.m;
            if (r12 == null) goto L18;
            r12.setController(r11);
        L18:
            TextView r13 = r1.n;
            if (r13 == null) goto L24;
            IBaseUser r14 = r10.f();
            if (r14 == null) goto L23;
            r4 = r14.getNickName();
        L23:
            r13.setText(r4);
        L24:
            String r15 = "-";
            if (hd0.c.f().j() == false) goto L42;
            int r0 = r10.d();
            TextView r16 = r1.l;
            if (r16 != null) goto L29;
        L36:
            TextView r17 = r1.o;
            if (r17 == null) goto L39;
            r17.setVisibility(0);
        L39:
            TextView r18 = r1.o;
            if (r18 == null) goto L52;
            long r19 = 1000;
            r18.setText(TimeUtils.getTimeDescription(s1.getContext(), r10.a() * r19, r10.b * r19));
            return;
        L52:
            return;
        L29:
            if (r0 < 100) goto L31;
            String r20 = "99+";
        L35:
            r16.setText(r20);
            goto L36
        L31:
            if (r0 == 0) goto L34;
            r15 = String.valueOf(r0);
        L34:
            r20 = r15;
            goto L35
        L42:
            TextView r21 = r1.l;
            if (r21 == null) goto L45;
            r21.setText("-");
        L45:
            TextView r22 = r1.o;
            if (r22 == null) goto L54;
            r22.setVisibility(8);
            return;
        L54:
            return;
        L14:
            r8 = null;
            goto L15
        L10:
            r5 = null;
            goto L11
        L48:
            View r23 = this.a.p;
            if (r23 == null) goto L56;
            r23.setVisibility(8);
            return;
        }
    }

    public static final class g<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkAudiencePreApplyDialog a;

        public g(PkAudiencePreApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            List r5 = (List) r4;
            if (r5 != null) goto L5;
            FrameLayout r6 = this.a.k;
            if (r6 == null) goto L19;
            r6.setVisibility(0);
        L19:
            RecyclerView r7 = this.a.j;
            if (r7 == null) goto L24;
            r7.setVisibility(4);
            return;
        L24:
            return;
        L5:
            if (r5.isEmpty() == false) goto L9;
            FrameLayout r1 = this.a.k;
            if (r1 == null) goto L15;
            r1.setVisibility(0);
        L15:
            MultiTypeAdapter r0 = this.a.h;
            r0.a = r5;
            r0.notifyDataSetChanged();
            return;
        L9:
            FrameLayout r2 = this.a.k;
            if (r2 == null) goto L12;
            r2.setVisibility(8);
        L12:
            RecyclerView r3 = this.a.j;
            if (r3 == null) goto L15;
            r3.setVisibility(0);
            goto L15
        }
    }

    static {
    }

    public PkAudiencePreApplyDialog() {
        this.f = new CompositeDisposable();
        this.h = new MultiTypeAdapter();
        this.s = new b(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        hd0.c.f().e(this.s);
        this.f.dispose();
    }

    public final void S90(Text r4) {
        if (r4 == null) goto L4;
        TextView r0 = this.i;
        if (r0 == null) goto L15;
        r0.setText(sb2.a.h(r4, "", false));
        return;
    L15:
        return;
    L4:
        if (hd0.c.f().g() == false) goto L12;
        TextView r5 = this.i;
        if (r5 == null) goto L13;
        r5.setText(s1.B(2131917503));
        return;
    L13:
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L12;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L12;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setGravity(80);
        r7.setSoftInputMode(48);
    L12:
        setBottomSheetSlideProcessor(c.a);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        Pair r3 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(this));
        PkAudiencePreApplyViewModel r0 = (PkAudiencePreApplyViewModel) r3.component1();
        Disposable r4 = (Disposable) r3.component2();
        this.g = r0;
        this.f.add(r4);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        this.r = false;     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        PkAudiencePreApplyViewModel r3 = this.g;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.release();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.i = (TextView) r2.findViewById(2131391606);
        this.j = r2.findViewById(2131392990);
        this.k = (FrameLayout) r2.findViewById(2131392989);
        this.l = (TextView) r2.findViewById(2131390468);
        this.m = r2.findViewById(2131376019);
        this.n = (TextView) r2.findViewById(2131391677);
        this.o = (TextView) r2.findViewById(2131391674);
        View r4 = r2.findViewById(2131392991);
        this.p = r4;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        this.q = (TextView) r2.findViewById(2131390275);
        Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r5 != null) goto L9;
    L10:
        hd0.c.f().c(this.s);
    L11:
        this.h.z2(c1.class, new com.bytedance.android.live.livepkaudience.list.p());
        this.h.z2(com.bytedance.android.live.livepkaudience.list.m.a.class, new com.bytedance.android.live.livepkaudience.list.m());
        this.h.z2(com.bytedance.android.live.livepkaudience.list.a.class, new com.bytedance.android.live.livepkaudience.list.r());
        RecyclerView r6 = this.j;
        if (r6 == null) goto L14;
        r6.setAdapter(this.h);
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext()));
        r6.addOnScrollListener(new PkAudiencePreApplyDialog$onViewCreated$$inlined$apply$lambda$1(this));
    L14:
        PkAudiencePreApplyViewModel r7 = this.g;
        if (r7 == null) goto L19;
        LiveData<Text> r8 = r7.getWaitingTitleData();
        if (r8 == null) goto L19;
        r8.observe(this, new e(this));
    L19:
        PkAudiencePreApplyViewModel r9 = this.g;
        if (r9 == null) goto L24;
        LiveData<c1> r10 = r9.getUserWaitingData();
        if (r10 == null) goto L24;
        r10.observe(this, new f(this));
    L24:
        PkAudiencePreApplyViewModel r11 = this.g;
        if (r11 == null) goto L29;
        LiveData<List<Object>> r12 = r11.getWaitingListData();
        if (r12 == null) goto L29;
        r12.observe(this, new g(this));
    L29:
        PkAudiencePreApplyViewModel r13 = this.g;
        if (r13 == null) goto L32;
        r13.fetchList(this.d, true);
    L32:
        TextView r14 = this.q;
        if (r14 == null) goto L35;
        r14.setOnClickListener(x0.a(new AnonymousClass5(this)));
    L35:
        HSImageView r15 = this.m;
        if (r15 == null) goto L39;
        r15.setOnClickListener(x0.a(AnonymousClass6.INSTANCE));
        return;
    L39:
        return;
    L9:
        if (r5.intValue() == 2) goto L11;
        goto L10
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565698, r2);
    }
}

package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.livepkaudience.vm.PkGuestApplyViewModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.WidgetManager;
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
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkGuestApplyDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkGuestApplyDialog extends LiveDialogFragment {
    public static final /* synthetic */ int t = 0;
    public Room d;
    public final Lazy e;
    public final MultiTypeAdapter f;
    public TextView g;
    public RecyclerView h;
    public FrameLayout i;
    public TextView j;
    public HSImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public boolean o;
    public String p;
    public int q;
    public final int r;
    public final b s;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PkGuestApplyDialog a;

        public b(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.intValue() != 0) goto L11;
            TextView r5 = this.a.n;
            if (r5 == null) goto L9;
            r5.setText(s1.B(2131917501));
        L9:
            this.a.T90(null);
            return;
        L11:
            if (r4.intValue() != 1) goto L16;
            TextView r6 = this.a.n;
            if (r6 == null) goto L29;
            r6.setText(s1.B(2131914738));
            return;
        L29:
            return;
        L16:
            if (r4.intValue() == 2) goto L25;
            return;
        L25:
            this.a.dismiss();     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L32;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
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
        public final /* synthetic */ PkGuestApplyDialog a;

        public d(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkGuestApplyDialog r4 = this.a;
            int r0 = PkGuestApplyDialog.t;
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
        public final /* synthetic */ PkGuestApplyDialog a;

        public e(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L10;
            int r1 = r6.intValue();
            if (r1 == this.a.r) goto L9;
            if (r1 == 41) goto L9;
            com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r2.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r2, 40);
        L9:
            com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, 41);
        L10:
            if (r6 != null) goto L13;
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.c.x1;
            r7.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r7, 40);
            return;
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkGuestApplyDialog a;

        public f(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            PkGuestApplyDialog r0 = this.a;
            r0.T90((Text) r2);
        }
    }

    public static final class g<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkGuestApplyDialog a;

        public g(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            WaitingListUser r11 = (WaitingListUser) r10;
            if (r11 == null) goto L59;
            PkGuestApplyDialog r0 = this.a;
            int r1 = PkGuestApplyDialog.t;
            r0.getClass();
            IBaseUser r2 = r11.getUserFlex();
            String r3 = null;
            if (r2 == null) goto L7;
            py.k r4 = r2.getAvatarThumbKt();
        L8:
            boolean r5 = false;
            PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r4, -1)).setAutoPlayAnimations(false);
            HSImageView r7 = r0.k;
            if (r7 == null) goto L11;
            DraweeController r8 = r7.getController();
        L12:
            AbstractDraweeController r9 = r6.setOldController(r8).build();
            HSImageView r12 = r0.k;
            if (r12 == null) goto L15;
            r12.setController(r9);
        L15:
            TextView r13 = r0.l;
            if (r13 == null) goto L20;
            if (r2 == null) goto L19;
            r3 = r2.getNickName();
        L19:
            r13.setText(r3);
        L20:
            String r14 = "-";
            if (hd0.c.f().j() == false) goto L52;
            long r15 = r11.getOffset();
            TextView r16 = r0.j;
            if (r16 != null) goto L25;
        L32:
            TextView r17 = r0.m;
            if (r17 == null) goto L35;
            r17.setVisibility(0);
        L35:
            Integer r18 = (Integer) com.bytedance.android.livesdk.sharedpref.c.x1.getValue();
            if (r18 != null) goto L39;
        L51:
            tc0.c.h().P = r11;
            return;
        L39:
            if (r18.intValue() != 41) goto L51;
            TextView r19 = r0.m;
            if (r19 == null) goto L51;
            String r20 = r11.getFanTicket();
            if (r20 != null) goto L45;
        L46:
            r5 = true;
        L47:
            if (r5 == false) goto L49;
            String r21 = "0";
        L50:
            r19.setText(r21);
            goto L51
        L49:
            r21 = r11.getFanTicket();
            goto L50
        L45:
            if (StringsKt.isBlank(r20) == false) goto L47;
        L25:
            if (r15 < 100) goto L28;
            r14 = "99+";
        L31:
            r16.setText(r14);
            goto L32
        L28:
            if (r15 == 0) goto L31;
            r14 = String.valueOf(r15);
            goto L31
        L52:
            TextView r110 = r0.j;
            if (r110 == null) goto L55;
            r110.setText("-");
        L55:
            TextView r111 = r0.m;
            if (r111 == null) goto L61;
            r111.setVisibility(8);
            return;
        L61:
            return;
        L11:
            r8 = null;
            goto L12
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class h<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ PkGuestApplyDialog a;

        public h(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            List r5 = (List) r4;
            if (r5 != null) goto L5;
            FrameLayout r6 = this.a.i;
            if (r6 == null) goto L28;
            r6.setVisibility(0);
        L28:
            RecyclerView r7 = this.a.h;
            if (r7 == null) goto L34;
            r7.setVisibility(4);
            return;
        L34:
            return;
        L5:
            if (r5.isEmpty() == false) goto L9;
            FrameLayout r1 = this.a.i;
            if (r1 == null) goto L15;
            r1.setVisibility(0);
        L15:
            PkGuestApplyDialog r0 = this.a;
            r0.f.a = r5;
            RecyclerView r2 = r0.h;
            if (r2 != null) goto L18;
        L24:
            new Handler(Looper.getMainLooper()).post(new o(this, r5));
            return;
        L18:
            if (r2.isComputingLayout() == true) goto L24;
            RecyclerView r3 = this.a.h;
            if (r3 == null) goto L24;
            if (r3.getScrollState() != 0) goto L24;
            this.a.f.notifyDataSetChanged();
            return;
        L9:
            FrameLayout r8 = this.a.i;
            if (r8 == null) goto L12;
            r8.setVisibility(8);
        L12:
            RecyclerView r9 = this.a.h;
            if (r9 == null) goto L15;
            r9.setVisibility(0);
            goto L15
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ PkGuestApplyDialog a;

        public i(PkGuestApplyDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PkGuestApplyDialog r4 = this.a;
            int r0 = PkGuestApplyDialog.t;
            PkGuestApplyViewModel r5 = r4.S90();
            if (r5 == null) goto L22;
            LiveData<WaitingListUser> r6 = r5.getUserWaitingData();
            if (r6 == null) goto L23;
            WaitingListUser r7 = (WaitingListUser) r6.getValue();
            if (r7 == null) goto L24;
            IBaseUser r8 = r7.getUserFlex();
            if (r8 == null) goto L25;
            PkGuestApplyViewModel r1 = this.a.S90();
            if (r1 == null) goto L20;
            LiveData<WaitingListUser> r2 = r1.getUserWaitingData();
            if (r2 == null) goto L20;
            WaitingListUser r9 = (WaitingListUser) r2.getValue();
            if (r9 == null) goto L20;
            if (r9.isAnonymous() != true) goto L20;
            ALogger.i("PkGuestApplyDialog", "click on the anonymous user avatar for apply , do not pull up the profile card");
            f2.c(s1.B(2131918948), 0);
            return;
        L20:
            xs2.b.a().post(new UserProfileEvent(r8));
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    static {
    }

    public final PkGuestApplyViewModel S90() {
        return (PkGuestApplyViewModel) this.e.getValue();
    }

    public PkGuestApplyDialog() {
        this.e = InfraKotlinExtsKt.mainThreadLazy(PkGuestApplyDialog$vm$2.INSTANCE);
        this.f = new MultiTypeAdapter();
        this.q = WaitingListType.UNKNOWN.ordinal();
        this.r = 71;
        this.s = new b(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        hd0.c.f().e(this.s);
    }

    public final void T90(Text r4) {
        if (r4 == null) goto L4;
        TextView r0 = this.g;
        if (r0 == null) goto L15;
        r0.setText(sb2.a.h(r4, "", false));
        return;
    L15:
        return;
    L4:
        if (hd0.c.f().g() == false) goto L12;
        TextView r5 = this.g;
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

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setStyle(1, 2131954719);
        int r0 = el0.j.b;
        String r1 = this.p;
        LinkedHashMap r2 = new LinkedHashMap();
        el0.j.m(r2);
        el0.j.k(r2);
        el0.j.i(r2);
        if (r1 == null) goto L5;
        r2.put("request_page", r1);
    L5:
        el0.j.n(r2, Integer.valueOf(dl0.n.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_connection_apply_page_show", r2, new Object[]{Room.class});
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new d(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        this.o = false;     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        PkGuestApplyViewModel r3 = S90();     // Catch: Throwable -> L7
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

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        WidgetManager.of(this, r9).load(2131372686, new BannerWidget(this.d));
        this.q = WaitingListType.UNKNOWN.ordinal();
        this.g = (TextView) r9.findViewById(2131391606);
        this.h = r9.findViewById(2131392990);
        this.i = (FrameLayout) r9.findViewById(2131392989);
        this.j = (TextView) r9.findViewById(2131390468);
        this.k = r9.findViewById(2131376019);
        this.l = (TextView) r9.findViewById(2131391677);
        this.m = (TextView) r9.findViewById(2131391674);
        this.n = (TextView) r9.findViewById(2131390275);
        if (com.bytedance.live.datacontext.d.d(PkGuestApplyViewModel.TAG) != null) goto L5;
        return;
    L5:
        Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r11 != null) goto L9;
    L10:
        hd0.c.f().c(this.s);
    L11:
        this.f.z2(WaitingListUser.class, new com.bytedance.android.live.livepkaudience.list.q(new AnonymousClass1(this)));
        this.f.z2(com.bytedance.android.live.livepkaudience.list.l.a.class, new com.bytedance.android.live.livepkaudience.list.l(null, null));
        this.f.z2(com.bytedance.android.live.livepkaudience.list.a.class, new com.bytedance.android.live.livepkaudience.list.r());
        RecyclerView r12 = this.h;
        if (r12 == null) goto L14;
        r12.setAdapter(this.f);
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext()));
        r12.addOnScrollListener(new PkGuestApplyDialog$onViewCreated$$inlined$apply$lambda$1(this));
    L14:
        PkGuestApplyViewModel r13 = S90();
        if (r13 == null) goto L19;
        LiveData<Integer> r14 = r13.getSortTypeLiveData();
        if (r14 == null) goto L19;
        r14.observe(this, new e(this));
    L19:
        PkGuestApplyViewModel r15 = S90();
        if (r15 == null) goto L24;
        LiveData<Text> r16 = r15.getWaitingTitleData();
        if (r16 == null) goto L24;
        r16.observe(this, new f(this));
    L24:
        PkGuestApplyViewModel r17 = S90();
        if (r17 == null) goto L29;
        LiveData<WaitingListUser> r18 = r17.getUserWaitingData();
        if (r18 == null) goto L29;
        r18.observe(this, new g(this));
    L29:
        PkGuestApplyViewModel r19 = S90();
        if (r19 == null) goto L34;
        MutableLiveData<Integer> r20 = r19.getWaitingListType();
        if (r20 == null) goto L34;
        r20.observe(this, new n(this));
    L34:
        PkGuestApplyViewModel r21 = S90();
        if (r21 == null) goto L39;
        LiveData<List<Object>> r22 = r21.getWaitingListData();
        if (r22 == null) goto L39;
        r22.observe(this, new h(this));
    L39:
        PkGuestApplyViewModel r0 = S90();
        if (r0 == null) goto L42;
        PkGuestApplyViewModel.fetchList$default(r0, true, this.d, null, this.q, 0, 20, null);
    L42:
        TextView r23 = this.n;
        if (r23 == null) goto L45;
        r23.setOnClickListener(x0.a(new AnonymousClass7(this)));
    L45:
        HSImageView r24 = this.k;
        if (r24 == null) goto L49;
        r24.setOnClickListener(new i(this));
        return;
    L49:
        return;
    L9:
        if (r11.intValue() == 2) goto L11;
        goto L10
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565697, r2);
    }
}

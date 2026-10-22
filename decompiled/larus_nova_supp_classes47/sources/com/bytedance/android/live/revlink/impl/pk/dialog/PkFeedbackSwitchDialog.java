package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView;
import com.bytedance.android.livesdk.link.model.w7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkFeedbackSwitchDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkFeedbackSwitchDialog extends LinkCommonDialogFragment {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> e;
    public IRoom f;
    public boolean g;
    public final boolean h;
    public final String i;
    public final String j;
    public long k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkFeedbackSwitchDialog a;

        public b(PkFeedbackSwitchDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            PkFeedbackSwitchDialog r3 = this.a;
            int r0 = PkFeedbackSwitchDialog.m;
            r3.T90();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkFeedbackSwitchDialog a;
        public final /* synthetic */ View b;

        public c(PkFeedbackSwitchDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            if (r5 == null) goto L12;
            w7 r6 = (w7) r5.data;
            if (r6 == null) goto L13;
            View r0 = this.b;
            if (r0 == null) goto L9;
            View r1 = r0.findViewById(2131382348);
        L10:
            ((PkFeedbackView) r1).g(r6, this.a.g, false);
            return;
        L9:
            r1 = null;
            goto L10
        L13:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ View a;

        public d(View r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            View r5 = this.a;
            View r0 = null;
            if (r5 == null) goto L5;
            View r6 = r5.findViewById(2131380667);
        L6:
            ((TextView) r6).setVisibility(0);
            View r7 = this.a;
            if (r7 == null) goto L9;
            View r8 = r7.findViewById(2131382348);
        L10:
            ((PkFeedbackView) r8).setVisibility(8);
            View r9 = this.a;
            if (r9 == null) goto L13;
            r0 = r9.findViewById(2131389780);
        L13:
            ((Button) r0).setVisibility(8);
            return;
        L9:
            r8 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackSwitchDialog a;

        public e(PkFeedbackSwitchDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            PkFeedbackSwitchDialog r10 = this.a;
            boolean r2 = false;
            if (TextUtils.isEmpty(((PkFeedbackView) r10.S90(2131382348)).getPkSelectTag()) == false) goto L10;
            if (TextUtils.isEmpty(((PkFeedbackView) r10.S90(2131382348)).getSelectSubTag()) == false) goto L10;
            if (TextUtils.isEmpty(((PkFeedbackView) r10.S90(2131382348)).getSelectTag()) == false) goto L10;
            ToastUtil.a(2131921419, 0);
            return;
        L10:
            if (r10.l == false) goto L12;
            ToastUtil.a(2131921420, 0);
            return;
        L12:
            r10.T90();
            HashMap r1 = new HashMap();
            LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
            IRoom r4 = r10.f;
            String r5 = null;
            if (r4 == null) goto L15;
            Long r6 = Long.valueOf(r4.getId());
        L16:
            r1.put("room_id", r6);
            if (r3 == null) goto L19;
            Long r7 = Long.valueOf(r3.c());
        L20:
            r1.put("channel_id", r7);
            if (r3 == null) goto L23;
            Integer r8 = Integer.valueOf(r3.i());
        L24:
            r1.put("match_type", r8);
            IPKLinkBizDataService r12 = com.bytedance.android.live.revlink.impl.global.b.P();
            if (r12 == null) goto L31;
            IPKLinkBizDataService.c r13 = r12.getGuestInfo();
            if (r13 == null) goto L31;
            IBaseUser r14 = r13.c;
            if (r14 == null) goto L31;
            Intrinsics.checkNotNullParameter(r14, "$this$secUidExt");
            String r15 = r14.getCastSecUid();
        L32:
            r1.put("sec_to_user_id", r15);
            if (r10.g == false) goto L39;
            LinkCrossRoomDataHolder r16 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r16 == null) goto L39;
            if (r16.i() != 1) goto L39;
            r2 = true;
        L39:
            if (r2 == false) goto L41;
            r1.put("no_auto_match", Boolean.FALSE);
            r1.put("dislike_pk_user_reason", ((PkFeedbackView) r10.S90(2131382348)).getPkSelectTag());
        L41:
            r1.put("scene", r10.i);
            IRoom r17 = r10.f;
            if (r17 == null) goto L46;
            IBaseUser r18 = r17.getOwner();
            if (r18 == null) goto L46;
            Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
            r5 = r18.getCastSecUid();
        L46:
            r1.put("sec_anchor_id", r5);
            r1.put("issue_category", ((PkFeedbackView) r10.S90(2131382348)).getSelectTag());
            if (((PkFeedbackView) r10.S90(2131382348)).n == false) goto L49;
            String r19 = ((PkFeedbackView) r10.S90(2131382348)).getSelectReportTag();
        L50:
            r1.put("issue_content", r19);
            r1.put("report_serial_id", Integer.valueOf(((PkFeedbackView) r10.S90(2131382348)).getSelectReportSerialId()));
            r1.put("feedback_type", ((PkFeedbackView) r10.S90(2131382348)).getSelectTagType());
            r1.put("extra_str", new JSONObject().toString());
            Ref.BooleanRef r20 = new Ref.BooleanRef();
            r20.element = ((PkFeedbackView) r10.S90(2131382348)).n;
            Observable<ExtraResponse<Object, Extra>> r0 = r31.b.a(r31.a.a).feedback(r1);
            if (r0 == null) goto L62;
            Observable r22 = r0.subscribeOn(Schedulers.io());
            if (r22 == null) goto L63;
            Observable r23 = r22.observeOn(AndroidSchedulers.mainThread());
            if (r23 == null) goto L64;
            ObservableSubscribeProxy r24 = (ObservableSubscribeProxy) r23.as(AutoDispose.bind(r10.getActivity()));
            if (r24 == null) goto L65;
            r24.subscribe(new com.bytedance.android.live.revlink.impl.pk.dialog.d(r10, r20), com.bytedance.android.live.revlink.impl.pk.dialog.e.a);
            return;
        L65:
            return;
        L64:
            return;
        L63:
            return;
        L62:
            return;
        L49:
            r19 = ((PkFeedbackView) r10.S90(2131382348)).getSelectSubTag();
        L31:
            r15 = null;
            goto L32
        L23:
            r8 = null;
            goto L24
        L19:
            r7 = null;
            goto L20
        L15:
            r6 = null;
            goto L16
        }
    }

    public static final class f implements PkFeedbackView.a {
        public final /* synthetic */ PkFeedbackSwitchDialog a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView.a
        public final void a(CharSequence r4) {
            View r1 = null;
            if (((PkFeedbackView) this.a.S90(2131382348)).f() == false) goto L12;
            View r5 = this.b;
            if (r5 == null) goto L7;
            View r6 = r5.findViewById(2131389780);
        L8:
            ((Button) r6).setClickable(true);
            View r7 = this.b;
            if (r7 == null) goto L11;
            r1 = r7.findViewById(2131389780);
        L11:
            ((Button) r1).setAlpha(1.0f);
            return;
        L7:
            r6 = null;
            goto L8
        L12:
            View r8 = this.b;
            if (r8 == null) goto L15;
            View r9 = r8.findViewById(2131389780);
        L16:
            ((Button) r9).setClickable(false);
            View r10 = this.b;
            if (r10 == null) goto L19;
            r1 = r10.findViewById(2131389780);
        L19:
            ((Button) r1).setAlpha(0.5f);
            return;
        L15:
            r9 = null;
            goto L16
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView.a
        public final void b(boolean r5) {
            PkFeedbackSwitchDialog r6 = this.a;
            if (((PkFeedbackView) r6.S90(2131382348)).n == false) goto L13;
            String r1 = ((PkFeedbackView) this.a.S90(2131382348)).getSelectReportTag();
            if (r1 != null) goto L7;
        L10:
            boolean r2 = true;
        L11:
            if (r2 == false) goto L13;
            boolean r3 = true;
        L14:
            r6.l = r3;
            this.a.getClass();
            View r4 = null;
            if (((PkFeedbackView) this.a.S90(2131382348)).f() == true) goto L24;
            View r7 = this.b;
            if (r7 == null) goto L19;
            View r8 = r7.findViewById(2131389780);
        L20:
            ((Button) r8).setClickable(false);
            View r9 = this.b;
            if (r9 == null) goto L23;
            r4 = r9.findViewById(2131389780);
        L23:
            ((Button) r4).setAlpha(0.5f);
            return;
        L19:
            r8 = null;
            goto L20
        L24:
            View r10 = this.b;
            if (r10 == null) goto L27;
            View r12 = r10.findViewById(2131389780);
        L28:
            ((Button) r12).setClickable(true);
            View r13 = this.b;
            if (r13 == null) goto L31;
            r4 = r13.findViewById(2131389780);
        L31:
            ((Button) r4).setAlpha(1.0f);
            return;
        L27:
            r12 = null;
            goto L28
        L7:
            if (r1.length() == 0) goto L10;
            r2 = false;
        L13:
            r3 = false;
            goto L14
        }

        public f(PkFeedbackSwitchDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackSwitchDialog a;

        public g(PkFeedbackSwitchDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.isShowing() == true) goto L12;
            return;
        L12:
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackSwitchDialog a;

        public h(PkFeedbackSwitchDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.dismiss();     // Catch: Exception -> L5
        L10:
            if (y.c() == false) goto L15;
            com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
            if (r5 == null) goto L21;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r5, 0, 0, null, 7);
            return;
        L21:
            return;
        L15:
            com.bytedance.android.live.revlink.impl.pk.service.h r6 = com.bytedance.android.live.revlink.impl.global.b.U();
            if (r6 == null) goto L22;
            com.bytedance.android.live.revlink.impl.pk.service.h.a.a(r6, null, 3);
            return;
        L22:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L10;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }
    }

    static {
    }

    public PkFeedbackSwitchDialog() {
        this.e = new LinkedHashMap();
        if (b51.b.c0.k() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.h = r0;
        if (r0 == false) goto L11;
        String r1 = "multi_linker";
    L12:
        this.i = r1;
        if (r0 == false) goto L15;
        String r2 = "连线";
    L16:
        this.j = r2;
        return;
    L15:
        r2 = "PK";
        goto L16
    L11:
        r1 = "pk";
        goto L12
    L5:
        if (y.c() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void T90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L19;
        if (r1 == null) goto L22;
        Dialog r2 = getDialog();
        if (r2 == null) goto L21;
        View r3 = r2.getCurrentFocus();
        if (r3 == null) goto L23;
        Object r4 = r1.getSystemService("input_method");
        if (r4 == null) goto L18;
        InputMethodManager r5 = (InputMethodManager) r4;
        if (r5.isActive() == false) goto L20;
        r5.hideSoftInputFromWindow(r3.getWindowToken(), 0);
        return;
    L20:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L23:
        return;
    L21:
        return;
    L22:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.clear();
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        this.l = false;     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r10, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r12);
        String r0 = null;
        if (this.h == false) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r13 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r13 == null) goto L17;
        r13.z();
    L17:
        ((TextView) r10.findViewById(2131388772)).setText(s1.C(2131921418, new Object[]{this.j}));
        ((Button) r10.findViewById(2131389780)).setVisibility(0);
        Button r1 = (Button) r10.findViewById(2131389780);
        if (r1 == null) goto L20;
        r1.setAlpha(0.5f);
    L20:
        ((Button) r10.findViewById(2131389780)).setOnClickListener(new e(this));
        IRoom r14 = this.f;
        if (r14 == null) goto L32;
        r31.a r2 = r31.b.a(r31.a.a);
        String r3 = this.i;
        long r4 = r14.getId();
        long r6 = this.k;
        IBaseUser r15 = r14.getOwner();
        if (r15 == null) goto L25;
        r0 = iz.a.a(r15);
    L25:
        Observable<ExtraResponse<w7, Extra>> r16 = r2.x(r3, r4, r6, r0);
        if (r16 == null) goto L32;
        Observable r17 = r16.subscribeOn(Schedulers.io());
        if (r17 == null) goto L32;
        Observable r18 = r17.observeOn(AndroidSchedulers.mainThread());
        if (r18 == null) goto L32;
        r18.subscribe(new c(this, r10), new d(r10));
    L32:
        PkFeedbackView r19 = (PkFeedbackView) r10.findViewById(2131382348);
        if (r19 == null) goto L35;
        r19.setListener(new f(this, r10));
    L35:
        r10.setBackgroundColor(ColorProtector.parseColor("#00000000"));
        View r110 = r10.findViewById(2131381758);
        if (r110 == null) goto L38;
        r110.setOnClickListener(new g(this));
    L38:
        ((ImageView) S90(2131372266)).setOnClickListener(new h(this));
        return;
    L7:
        h41.f r111 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r111 == null) goto L17;
        LinkedHashMap r5 = new LinkedHashMap();
        int r7 = UserListInviteType.a;
        LinkCrossRoomDataHolder r8 = r111.d();
        if (r8 == null) goto L12;
        int r9 = r8.f();
    L13:
        r5.put("invitee_list", UserListInviteType.a(r9, null));
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r22.putAll(r5);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.PAGE_SOURCE_LOG);
        r23.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r112 = r111.d();
        if (r112 == null) goto L16;
        r112.m(r23);
    L16:
        ((ArrayList) r20.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r113 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r114 = com.bytedance.android.scope.m.b(r113).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r114);
        ((mz0.i) ((f80.a) r114)).w3("livesdk_pk_feedback_page_show", r20.a, r20.b);
        goto L17
    L12:
        r9 = 0;
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565696, r3, false);
    }
}

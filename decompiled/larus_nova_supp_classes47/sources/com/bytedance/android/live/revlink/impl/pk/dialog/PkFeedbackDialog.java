package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.w7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkFeedbackDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkFeedbackDialog extends LiveDialogFragment {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public b g;
    public com.bytedance.android.live.revlink.link.biz.service.l h;
    public boolean i;
    public boolean j;
    public IRoom k;
    public boolean l;
    public final String m;
    public f2 n;
    public long o;

    public static final class a {
        @JvmStatic
        public static PkFeedbackDialog a(boolean r1, IRoom r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "scene");
            PkFeedbackDialog r4 = new PkFeedbackDialog();
            r4.j = r1;
            r4.k = r2;
            if (r2 == null) goto L7;
            IBaseUser r5 = r2.getOwner();
            if (r5 == null) goto L7;
            String r6 = iz.a.a(r5);
        L8:
            r4.l = Intrinsics.areEqual(r6, iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b()));
            r4.n = null;
            LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r7 == null) goto L11;
            long r8 = r7.c();
        L12:
            r4.o = r8;
            return r4;
        L11:
            r8 = 0;
        L7:
            r6 = null;
            goto L8
        }
    }

    public interface b {
        void a(boolean r1);

        void onFeedBackInfoUpdate(boolean r1, List<String> r2);
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public c(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            PkFeedbackDialog r3 = this.a;
            int r0 = PkFeedbackDialog.p;
            r3.U90();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkFeedbackDialog a;
        public final /* synthetic */ View b;

        public d(PkFeedbackDialog r1, View r2) {
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
            PkFeedbackDialog r2 = this.a;
            ((PkFeedbackView) r1).g(r6, r2.l, r2.j);
            return;
        L9:
            r1 = null;
            goto L10
        L13:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ View a;

        public e(View r1) {
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

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public f(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("reinvite");
            com.bytedance.android.live.revlink.impl.pk.utils.j r1 = com.bytedance.android.live.revlink.impl.global.b.O();
            if (r1 != null) goto L5;
        L9:
            View.OnClickListener r2 = this.a.e;
            if (r2 == null) goto L12;
            r2.onClick(r5);
        L12:
            this.a.X90();
            return;
        L5:
            if (r1.c(-1, null, 1) != true) goto L9;
            com.bytedance.android.live.revlink.link.biz.service.l r3 = this.a.h;
            if (r3 == null) goto L9;
            r3.a(true);
            goto L9
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public g(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("once_more");
            View.OnClickListener r1 = this.a.f;
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public h(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("once_more");
            View.OnClickListener r1 = this.a.f;
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public i(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("end");
            View.OnClickListener r1 = this.a.e;
            if (r1 == null) goto L5;
            r1.onClick(r2);
        L5:
            this.a.X90();
        }
    }

    public static final class j implements PkFeedbackView.a {
        public final /* synthetic */ PkFeedbackDialog a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView.a
        public final void a(CharSequence r7) {
            if (r7 != null) goto L5;
        L8:
            boolean r8 = true;
        L9:
            View r4 = null;
            if (r8 == true) goto L12;
        L30:
            View r9 = this.b;
            if (r9 == null) goto L33;
            View r10 = r9.findViewById(2131364792);
        L34:
            ((Button) r10).setClickable(true);
            View r12 = this.b;
            if (r12 == null) goto L37;
            View r13 = r12.findViewById(2131364792);
        L38:
            ((Button) r13).setAlpha(1.0f);
            View r14 = this.b;
            if (r14 == null) goto L41;
            View r15 = r14.findViewById(2131389780);
        L42:
            ((Button) r15).setClickable(true);
            View r16 = this.b;
            if (r16 == null) goto L45;
            r4 = r16.findViewById(2131389780);
        L45:
            ((Button) r4).setAlpha(1.0f);
            return;
        L41:
            r15 = null;
            goto L42
        L37:
            r13 = null;
            goto L38
        L33:
            r10 = null;
            goto L34
        L12:
            if (((PkFeedbackView) this.a.S90(2131382348)).o == false) goto L30;
            View r17 = this.b;
            if (r17 == null) goto L17;
            View r18 = r17.findViewById(2131364792);
        L18:
            ((Button) r18).setClickable(false);
            View r19 = this.b;
            if (r19 == null) goto L21;
            View r20 = r19.findViewById(2131364792);
        L22:
            ((Button) r20).setAlpha(0.5f);
            View r22 = this.b;
            if (r22 == null) goto L25;
            View r23 = r22.findViewById(2131389780);
        L26:
            ((Button) r23).setClickable(false);
            View r24 = this.b;
            if (r24 == null) goto L29;
            r4 = r24.findViewById(2131389780);
        L29:
            ((Button) r4).setAlpha(0.5f);
            return;
        L25:
            r23 = null;
            goto L26
        L21:
            r20 = null;
            goto L22
        L17:
            r18 = null;
            goto L18
        L5:
            if (r7.length() == 0) goto L8;
            r8 = false;
            goto L9
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView.a
        public final void b(boolean r7) {
            View r1 = null;
            if (r7 == false) goto L9;
            View r8 = this.b;
            if (r8 == null) goto L7;
            View r9 = r8.findViewById(2131364792);
        L8:
            ((Button) r9).setText(2131921416);
        L14:
            PkFeedbackDialog r10 = this.a;
            if (((PkFeedbackView) r10.S90(2131382348)).n == false) goto L25;
            String r3 = ((PkFeedbackView) this.a.S90(2131382348)).getSelectReportTag();
            if (r3 != null) goto L19;
        L22:
            boolean r4 = true;
        L23:
            if (r4 == false) goto L25;
            boolean r5 = true;
        L26:
            r10.i = r5;
            PkFeedbackDialog r12 = this.a;
            b r6 = r12.g;
            if (r6 == null) goto L30;
            r6.a(r12.i);
        L30:
            if (((PkFeedbackView) this.a.S90(2131382348)).o == false) goto L47;
            View r13 = this.b;
            if (r13 == null) goto L34;
            View r14 = r13.findViewById(2131364792);
        L35:
            ((Button) r14).setClickable(false);
            View r15 = this.b;
            if (r15 == null) goto L38;
            View r16 = r15.findViewById(2131364792);
        L39:
            ((Button) r16).setAlpha(0.5f);
            View r17 = this.b;
            if (r17 == null) goto L42;
            View r18 = r17.findViewById(2131389780);
        L43:
            ((Button) r18).setClickable(false);
            View r19 = this.b;
            if (r19 == null) goto L46;
            r1 = r19.findViewById(2131389780);
        L46:
            ((Button) r1).setAlpha(0.5f);
            return;
        L42:
            r18 = null;
            goto L43
        L38:
            r16 = null;
            goto L39
        L34:
            r14 = null;
            goto L35
        L47:
            View r20 = this.b;
            if (r20 == null) goto L50;
            View r22 = r20.findViewById(2131364792);
        L51:
            ((Button) r22).setClickable(true);
            View r23 = this.b;
            if (r23 == null) goto L54;
            View r24 = r23.findViewById(2131364792);
        L55:
            ((Button) r24).setAlpha(1.0f);
            View r25 = this.b;
            if (r25 == null) goto L58;
            View r26 = r25.findViewById(2131389780);
        L59:
            ((Button) r26).setClickable(true);
            View r27 = this.b;
            if (r27 == null) goto L62;
            r1 = r27.findViewById(2131389780);
        L62:
            ((Button) r1).setAlpha(1.0f);
            return;
        L58:
            r26 = null;
            goto L59
        L54:
            r24 = null;
            goto L55
        L50:
            r22 = null;
            goto L51
        L19:
            if (r3.length() == 0) goto L22;
            r4 = false;
        L25:
            r5 = false;
            goto L26
        L7:
            r9 = null;
            goto L8
        L9:
            View r28 = this.b;
            if (r28 == null) goto L12;
            View r29 = r28.findViewById(2131364792);
        L13:
            ((Button) r29).setText(2131921413);
            goto L14
        L12:
            r29 = null;
            goto L13
        }

        public j(PkFeedbackDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public k(PkFeedbackDialog r1) {
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

    public static final class l implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public l(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("end");
            com.bytedance.android.live.revlink.link.biz.service.l r1 = this.a.h;
            if (r1 == null) goto L5;
            r1.a(false);
        L5:
            View.OnClickListener r2 = this.a.e;
            if (r2 == null) goto L8;
            r2.onClick(r3);
        L8:
            this.a.X90();
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public m(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("reinvite");
            com.bytedance.android.live.revlink.impl.pk.utils.j r1 = com.bytedance.android.live.revlink.impl.global.b.O();
            if (r1 != null) goto L5;
        L9:
            View.OnClickListener r2 = this.a.e;
            if (r2 == null) goto L12;
            r2.onClick(r5);
        L12:
            this.a.X90();
            return;
        L5:
            if (r1.c(-1, null, 1) != true) goto L9;
            com.bytedance.android.live.revlink.link.biz.service.l r3 = this.a.h;
            if (r3 == null) goto L9;
            r3.a(true);
            goto L9
        }
    }

    public static final class n implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public n(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.W90();
        }
    }

    public static final class o implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public o(PkFeedbackDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            boolean r0 = this.a.l;
            com.bytedance.android.live.revlink.impl.global.b.j();
            h41.g.b("reinvite");
            com.bytedance.android.live.revlink.impl.pk.utils.j r1 = com.bytedance.android.live.revlink.impl.global.b.O();
            if (r1 != null) goto L5;
        L9:
            View.OnClickListener r2 = this.a.e;
            if (r2 == null) goto L12;
            r2.onClick(r5);
        L12:
            this.a.X90();
            return;
        L5:
            if (r1.c(-1, null, 1) != true) goto L9;
            com.bytedance.android.live.revlink.link.biz.service.l r3 = this.a.h;
            if (r3 == null) goto L9;
            r3.a(true);
            goto L9
        }
    }

    public static final class p implements View.OnClickListener {
        public final /* synthetic */ PkFeedbackDialog a;

        public p(PkFeedbackDialog r1) {
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

    public static final class q<T> implements Consumer {
        public final /* synthetic */ PkFeedbackDialog a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ String c;

        public q(PkFeedbackDialog r1, Ref.BooleanRef r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            ExtraResponse r12 = (ExtraResponse) r10;
            if (this.a.isShowing() == true) goto L65;
        L11:
            HashMap r13 = new HashMap();
            PkFeedbackDialog r0 = this.a;
            if (r0.j == false) goto L15;
            String r1 = "page";
        L18:
            r13.put("action_from", r1);
            boolean r2 = this.a.l;
            String r3 = DataType.TRUE;
            if (r2 == false) goto L21;
            String r4 = DataType.TRUE;
        L22:
            r13.put("is_anchor", r4);
            if (this.b.element == true) goto L26;
            r3 = "2";
        L26:
            r13.put("toast_content", r3);
            long r5 = 0;
            LinkCrossRoomDataHolder r6 = com.bytedance.android.live.revlink.impl.global.b.j();
            long r7 = 0;
            if (r6 != null) goto L29;
        L34:
            long r8 = System.currentTimeMillis();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = com.bytedance.android.live.revlink.impl.global.b.R();
            if (r9 == null) goto L37;
            r7 = r9.getPkStartTimeMs();
        L37:
            String r14 = String.valueOf((r8 - r7) / ((long) WebcastRedirectException.UNKNOWN));
            f2 r15 = this.a.n;
            String r16 = "";
            if (r15 == null) goto L56;
            r13.put("channel_id", String.valueOf(r15.getChannelId()));
            r13.put("pk_id", "");
            if (((int) r15.getMatchType()) != 0) goto L43;
            String r17 = "manual_pk";
        L46:
            r13.put("connection_type", r17);
            r13.put("pk_time", "300");
            IBattleUserInfo r18 = r15.getBattleUserInfo();
            if (r18 == null) goto L52;
            k0 r19 = r18.getUserInfo();
            if (r19 == null) goto L52;
            String r20 = r19.getUserId();
            if (r20 == null) goto L52;
        L53:
            r13.put("right_user_id", r20);
            r13.put("connection_time", "");
            if (((int) r15.getMatchType()) != 0) goto L56;
            r13.put("invitee_list", "");
        L52:
            r20 = "";
            goto L53
        L43:
            if (((int) r15.getMatchType()) != 1) goto L45;
            r17 = "random_pk";
            goto L46
        L45:
            r17 = "";
        L56:
            r13.put("source", "end_page");
            String r22 = this.c;
            if (r22 == null) goto L60;
            r16 = r22;
        L60:
            r13.put("contect", r16);
            mz0.n r23 = new mz0.n();
            Map<String, String> r24 = r23.a;
            Intrinsics.checkNotNullParameter(r24, "map");
            Intrinsics.checkNotNullParameter(r13, "map");
            r24.putAll(r13);
            mz0.m r110 = new mz0.m();
            r110.b(LogCommon.ROOM);
            r110.b(LogCommon.PAGE_SOURCE_LOG);
            com.bytedance.android.livesdk.revenue.log.h r25 = vh6.c.b(kr2.a.class).be();
            Intrinsics.checkNotNullParameter(r25, "linkInfoLog");
            r25.c(r5);
            Intrinsics.checkNotNullParameter(r14, "connectionTime");
            r25.b(r14);
            ((ArrayList) r110.a).add(r25.a);
            LinkCrossRoomDataHolder.a r26 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.b(r110);
            ((ArrayList) r23.b).addAll(r110.a);
            cy0.e.a.getClass();
            cy0.j r111 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r112);
            ((mz0.i) ((f80.a) r112)).w3("livesdk_pk_start_feedback_submit_success", r23.a, r23.b);
            if (this.b.element == false) goto L63;
            ToastUtil.a(2131921424, 0);
            return;
        L63:
            int r113 = ToastUtil.a;
            ToastUtil.b(s1.C(2131921426, new Object[]{this.a.T90()}), 0);
            return;
        L29:
            if (r6.i() != 0) goto L34;
            LinkCrossRoomDataHolder r27 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r27 == null) goto L33;
            r5 = r27.f();
            goto L34
        L33:
            r5 = 0;
            goto L34
        L21:
            r4 = DataType.FALSE;
            goto L22
        L15:
            if (r0.l == false) goto L17;
            r1 = "record";
            goto L18
        L17:
            r1 = "press";
            goto L18
        L65:
            this.a.dismiss();     // Catch: Exception -> L7
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r114 = DialogFragmentLancet.sLastShowStack;
            if (r114 == null) goto L11;
            com.bytedance.crash.d.d(r114, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L11
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final String T90() {
        if (TextUtils.equals(this.m, "multi_linker") == false) goto L5;
        return "连线";
    L5:
        return "PK";
    }

    public final boolean V90() {
        if (this.l == false) goto L11;
        LinkCrossRoomDataHolder r0 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r0 == null) goto L11;
        if (r0.i() != 1) goto L11;
        if (this.j == false) goto L11;
        return true;
    L11:
        return false;
    }

    public PkFeedbackDialog() {
        this.d = new LinkedHashMap();
        this.m = "pk";
    }

    public final void U90() {
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

    public final void W90() {
        boolean r2 = false;
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getPkSelectTag()) == false) goto L13;
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getSelectSubTag()) == false) goto L13;
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getSelectTag()) == false) goto L13;
        if (this.j == true) goto L92;
        ToastUtil.a(2131921419, 0);
        return;
    L92:
        return;
    L13:
        if (this.i == false) goto L16;
        ToastUtil.a(2131921420, 0);
        return;
    L16:
        U90();
        HashMap r1 = new HashMap();
        String r3 = ((PkFeedbackView) S90(2131382348)).getSelectTag();
        LinkCrossRoomDataHolder r4 = com.bytedance.android.live.revlink.impl.global.b.j();
        f2 r5 = this.n;
        String r12 = null;
        if (r5 != null) goto L39;
        IRoom r6 = this.k;
        if (r6 == null) goto L21;
        Long r7 = Long.valueOf(r6.getId());
    L22:
        r1.put("room_id", r7);
        if (r4 == null) goto L25;
        Long r8 = Long.valueOf(r4.c());
    L26:
        r1.put("channel_id", r8);
        if (r4 == null) goto L29;
        Integer r9 = Integer.valueOf(r4.i());
    L30:
        r1.put("match_type", r9);
        IPKLinkBizDataService r10 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r10 == null) goto L37;
        IPKLinkBizDataService.c r13 = r10.getGuestInfo();
        if (r13 == null) goto L37;
        IBaseUser r14 = r13.c;
        if (r14 == null) goto L37;
        Intrinsics.checkNotNullParameter(r14, "$this$secUidExt");
        String r15 = r14.getCastSecUid();
    L38:
        r1.put("sec_to_user_id", r15);
    L53:
        if (V90() == false) goto L55;
        r1.put("no_auto_match", Boolean.FALSE);
        r1.put("dislike_pk_user_reason", ((PkFeedbackView) S90(2131382348)).getPkSelectTag());
    L55:
        r1.put("scene", this.m);
        IRoom r16 = this.k;
        if (r16 == null) goto L60;
        IBaseUser r17 = r16.getOwner();
        if (r17 == null) goto L60;
        Intrinsics.checkNotNullParameter(r17, "$this$secUidExt");
        String r18 = r17.getCastSecUid();
    L61:
        r1.put("sec_anchor_id", r18);
        r1.put("issue_category", r3);
        if (((PkFeedbackView) S90(2131382348)).n == false) goto L64;
        String r19 = ((PkFeedbackView) S90(2131382348)).getSelectReportTag();
    L65:
        r1.put("issue_content", r19);
        r1.put("report_serial_id", Integer.valueOf(((PkFeedbackView) S90(2131382348)).getSelectReportSerialId()));
        r1.put("feedback_type", ((PkFeedbackView) S90(2131382348)).getSelectTagType());
        JSONObject r20 = new JSONObject();
        if (this.j == false) goto L82;
        com.bytedance.android.live.revenuelink.rtc.f r22 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r22 == null) goto L72;
        com.bytedance.android.live.revenuelink.rtc.i r23 = r22.getRtcManager();
        if (r23 == null) goto L72;
        r2 = r23.F();
    L72:
        r20.put("is_client_mixstream", r2);
        IRoom r24 = this.k;
        if (r24 == null) goto L77;
        LiveMode r25 = r24.getStreamType();
        if (r25 == null) goto L77;
        Integer r26 = Integer.valueOf(r25.getIndex());
    L78:
        r20.put("room_scene", r26);
        if (r4 == null) goto L81;
        r12 = r4.e();
    L81:
        r20.put("link_mic_str", r12);
    L77:
        r26 = null;
    L82:
        r1.put("extra_str", r20.toString());
        Ref.BooleanRef r27 = new Ref.BooleanRef();
        r27.element = ((PkFeedbackView) S90(2131382348)).n;
        Observable<ExtraResponse<Object, Extra>> r0 = r31.b.a(r31.a.a).feedback(r1);
        if (r0 == null) goto L93;
        Observable r28 = r0.subscribeOn(Schedulers.io());
        if (r28 == null) goto L94;
        Observable r29 = r28.observeOn(AndroidSchedulers.mainThread());
        if (r29 == null) goto L95;
        ObservableSubscribeProxy r30 = (ObservableSubscribeProxy) r29.as(AutoDispose.bind(getActivity()));
        if (r30 == null) goto L96;
        r30.subscribe(new q(this, r27, r3), r.a);
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L64:
        r19 = ((PkFeedbackView) S90(2131382348)).getSelectSubTag();
    L60:
        r18 = null;
    L37:
        r15 = null;
        goto L38
    L29:
        r9 = null;
        goto L30
    L25:
        r8 = null;
        goto L26
    L21:
        r7 = null;
        goto L22
    L39:
        r1.put("room_id", Long.valueOf(r5.getOwnHistoricRoomId()));
        f2 r32 = this.n;
        if (r32 == null) goto L42;
        Long r33 = Long.valueOf(r32.getChannelId());
    L43:
        r1.put("channel_id", r33);
        f2 r34 = this.n;
        if (r34 == null) goto L46;
        Long r35 = Long.valueOf(r34.getMatchType());
    L47:
        r1.put("match_type", r35);
        f2 r36 = this.n;
        if (r36 == null) goto L50;
        String r37 = r36.getRivalSecUserId();
    L51:
        r1.put("sec_to_user_id", r37);
        goto L53
    L50:
        r37 = null;
        goto L51
    L46:
        r35 = null;
        goto L47
    L42:
        r33 = null;
        goto L43
    }

    public final void X90() {
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getPkSelectTag()) == true) goto L5;
    L10:
        boolean r1 = true;
    L11:
        ArrayList r2 = new ArrayList();
        r2.clear();
        r2.addAll(((PkFeedbackView) S90(2131382348)).getSelectRandomTags());
        b r0 = this.g;
        if (r0 == null) goto L14;
        r0.onFeedBackInfoUpdate(r1, r2);
    L14:
        W90();
        return;
    L5:
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getSelectSubTag()) == false) goto L10;
        if (TextUtils.isEmpty(((PkFeedbackView) S90(2131382348)).getSelectTag()) == false) goto L10;
        r1 = false;
        goto L11
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.d).get(2131382348);
        if (r4 != null) goto L14;
        View r5 = getView();
        if (r5 == null) goto L12;
        View r6 = r5.findViewById(2131382348);
        if (r6 == null) goto L12;
        this.d.put(2131382348, r6);
        return r6;
    L12:
        return null;
    L14:
        return r4;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    L14:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new c(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        super.onDismiss(r2);     // Catch: Throwable -> L13
        View r3 = getView();     // Catch: Throwable -> L13
        if (r3 == null) goto L5;
        View r4 = r3.findViewById(2131381758);     // Catch: Throwable -> L13
    L6:
        if (r4 == null) goto L8;
        r4.setVisibility(4);     // Catch: Throwable -> L13
    L8:
        this.i = false;     // Catch: Throwable -> L13
        b r0 = this.g;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        r0.a(false);     // Catch: Throwable -> L13
    L11:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        r4 = null;
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r26, "view");
        super.onViewCreated(r26, r27);
        TextView r3 = (TextView) r26.findViewById(2131387553);
        if (r3 == null) goto L5;
        r3.setText(s1.C(2131921428, new Object[]{T90()}));
    L5:
        long r18 = 0;
        if (this.j == false) goto L35;
        long r12 = 0;
        LinkCrossRoomDataHolder r20 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r20 != null) goto L10;
    L15:
        long r22 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r23 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r23 == null) goto L18;
        r18 = r23.getPkStartTimeMs();
    L18:
        String r5 = String.valueOf((r22 - r18) / ((long) WebcastRedirectException.UNKNOWN));
        HashMap r6 = new HashMap();
        w31.c r19 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r19 != null) goto L21;
    L23:
        String r4 = "invitee";
    L24:
        r6.put("anchor_type", r4);
        r6.put("action_from", "page");
        if (this.l == false) goto L27;
        Object r7 = DataType.TRUE;
    L28:
        r6.put("is_anchor", r7);
        mz0.n r2 = new mz0.n();
        Map<String, String> r8 = r2.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r8.putAll(r6);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.h r10 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r10, "linkInfoLog");
        r10.c(r12);
        Intrinsics.checkNotNullParameter(r5, "connectionTime");
        r10.b(r5);
        ((ArrayList) r9.a).add(r10.a);
        LinkCrossRoomDataHolder.a r13 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r9);
        ((ArrayList) r2.b).addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_pk_start_feedback_page_show", r2.a, r2.b);
        ((TextView) r26.findViewById(2131388772)).setText(s1.C(2131921418, new Object[]{T90()}));
        ((Button) r26.findViewById(2131364791)).setOnClickListener(new l(this));
        ((Button) r26.findViewById(2131364792)).setOnClickListener(new m(this));
        ((LinearLayout) r26.findViewById(2131364756)).setVisibility(0);
        Button r16 = (Button) r26.findViewById(2131364791);
        if (r16 == null) goto L31;
        r16.setVisibility(0);
    L31:
        Button r17 = (Button) r26.findViewById(2131364792);
        if (r17 == null) goto L34;
        r17.setVisibility(0);
    L34:
        ((Button) r26.findViewById(2131389780)).setVisibility(8);
    L83:
        IRoom r24 = this.k;
        q11.b r25 = null;
        if (r24 == null) goto L96;
        r31.a r28 = r31.b.a(r31.a.a);
        String r110 = this.m;
        long r111 = r24.getId();
        long r112 = this.o;
        IBaseUser r29 = r24.getOwner();
        if (r29 == null) goto L88;
        String r113 = iz.a.a(r29);
    L89:
        Observable<ExtraResponse<w7, Extra>> r30 = r28.x(r110, r111, r112, r113);
        if (r30 == null) goto L96;
        Observable r32 = r30.subscribeOn(Schedulers.io());
        if (r32 == null) goto L96;
        Observable r33 = r32.observeOn(AndroidSchedulers.mainThread());
        if (r33 == null) goto L96;
        r33.subscribe(new d(this, r26), new e(r26));
        goto L96
    L88:
        r113 = null;
    L96:
        ImageLoader.bindImage(r26.findViewById(2131376459), "https://" + com.bytedance.android.live.revenue.common.k0.a + "/obj/live-android/ttlive_bg_pk_feedback_in_penalty.png");
        com.bytedance.android.live.revlink.impl.pk.utils.q r34 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r34 == null) goto L99;
        r25 = r34.a();
    L99:
        q11.b.c r35 = q11.b.c.b;
        if (Intrinsics.areEqual(r25, r35) == false) goto L102;
    L103:
        ((TextView) r26.findViewById(2131388772)).setText(2131921414);
        TextView r36 = (TextView) r26.findViewById(2131387553);
        if (r36 == null) goto L106;
        r36.setVisibility(8);
    L106:
        PkFeedbackView r37 = (PkFeedbackView) r26.findViewById(2131382348);
        if (r37 == null) goto L109;
        r37.setVisibility(8);
    L109:
        Button r38 = (Button) r26.findViewById(2131364791);
        if (r38 == null) goto L112;
        r38.setVisibility(0);
    L112:
        Button r39 = (Button) r26.findViewById(2131364792);
        if (r39 == null) goto L115;
        r39.setVisibility(0);
    L115:
        Button r40 = (Button) r26.findViewById(2131364791);
        if (r40 == null) goto L119;
        r40.setText(2131920679);
        Unit r42 = Unit.INSTANCE;
    L119:
        if (V90() == false) goto L124;
        Button r43 = (Button) r26.findViewById(2131364792);
        if (r43 == null) goto L123;
        r43.setText(2131919380);
        Unit r44 = Unit.INSTANCE;
    L123:
        ((Button) r26.findViewById(2131364792)).setOnClickListener(new o(this));
    L129:
        if (V90() == false) goto L132;
        ((Button) r26.findViewById(2131364791)).setText(2131921415);
        ((Button) r26.findViewById(2131364791)).setOnClickListener(new f(this));
    L145:
        ((Button) r26.findViewById(2131364792)).setText(2131921413);
        ((Button) r26.findViewById(2131364792)).setClickable(true);
        ((Button) r26.findViewById(2131364792)).setOnClickListener(new i(this));
        PkFeedbackView r45 = (PkFeedbackView) r26.findViewById(2131382348);
        if (r45 == null) goto L149;
        r45.setListener(new j(this, r26));
        Unit r46 = Unit.INSTANCE;
    L149:
        if (Intrinsics.areEqual(r25, r35) == false) goto L151;
    L154:
        int r47 = 0;
        r26.findViewById(2131376459).setVisibility(0);
    L155:
        View r48 = r26.findViewById(2131381758);
        if (r48 == null) goto L159;
        r48.setVisibility(r47);
    L159:
        if (this.n == null) goto L161;
        String r49 = "#57000000";
    L162:
        r26.setBackgroundColor(ColorProtector.parseColor(r49));
        Unit r50 = Unit.INSTANCE;
        View r1 = r26.findViewById(2131381758);
        if (r1 == null) goto L166;
        r1.setOnClickListener(new k(this));
        return;
    L166:
        return;
    L161:
        r49 = "#00000000";
        goto L162
    L151:
        if (Intrinsics.areEqual(r25, q11.b.C0295b.b) == true) goto L154;
        r26.findViewById(2131376459).setVisibility(8);
        r47 = 0;
        goto L155
    L132:
        if (this.l == false) goto L140;
        LinkCrossRoomDataHolder r52 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r52 == null) goto L140;
        if (r52.i() != 3) goto L140;
        if (this.j == false) goto L140;
        boolean r53 = true;
    L142:
        if (r53 == false) goto L144;
        ((Button) r26.findViewById(2131364791)).setVisibility(0);
        ((Button) r26.findViewById(2131364791)).setText(2131921412);
        ((Button) r26.findViewById(2131364791)).setOnClickListener(new g(this));
        goto L145
    L144:
        ((Button) r26.findViewById(2131364791)).setText(2131921412);
        ((Button) r26.findViewById(2131364791)).setOnClickListener(new h(this));
    L140:
        r53 = false;
        goto L142
    L124:
        Button r54 = (Button) r26.findViewById(2131364792);
        if (r54 == null) goto L127;
        r54.setText(2131920678);
        Unit r55 = Unit.INSTANCE;
    L127:
        ((Button) r26.findViewById(2131364792)).setOnClickListener(new p(this));
        goto L129
    L102:
        if (Intrinsics.areEqual(r25, q11.b.C0295b.b) == false) goto L129;
    L27:
        r7 = DataType.FALSE;
        goto L28
    L21:
        if (r19.e() != true) goto L23;
        r4 = "inviter";
        goto L24
    L10:
        if (r20.i() != 0) goto L15;
        LinkCrossRoomDataHolder r114 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r114 == null) goto L14;
        r12 = r114.f();
        goto L15
    L14:
        r12 = 0;
        goto L15
    L35:
        long r115 = 0;
        LinkCrossRoomDataHolder r56 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r56 != null) goto L38;
    L43:
        long r210 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r57 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r57 == null) goto L46;
        r18 = r57.getPkStartTimeMs();
    L46:
        String r58 = String.valueOf((r210 - r18) / ((long) WebcastRedirectException.UNKNOWN));
        HashMap r59 = new HashMap();
        if (this.l == false) goto L49;
        String r60 = "record";
    L50:
        r59.put("action_from", r60);
        if (this.l == false) goto L53;
        Object r62 = DataType.TRUE;
    L54:
        r59.put("is_anchor", r62);
        f2 r63 = this.n;
        if (r63 == null) goto L75;
        r59.put("channel_id", String.valueOf(r63.getChannelId()));
        r59.put("pk_id", "");
        if (((int) r63.getMatchType()) != 0) goto L60;
        String r64 = "manual_pk";
    L63:
        r59.put("connection_type", r64);
        r59.put("pk_time", "300");
        IBattleUserInfo r65 = r63.getBattleUserInfo();
        if (r65 == null) goto L69;
        k0 r66 = r65.getUserInfo();
        if (r66 == null) goto L69;
        String r67 = r66.getUserId();
        if (r67 == null) goto L69;
    L70:
        r59.put("right_user_id", r67);
        r59.put("connection_time", "");
        if (((int) r63.getMatchType()) != 0) goto L73;
        r59.put("invitee_list", "");
    L73:
        Unit r68 = Unit.INSTANCE;
    L69:
        r67 = "";
        goto L70
    L60:
        if (((int) r63.getMatchType()) != 1) goto L62;
        r64 = "random_pk";
        goto L63
    L62:
        r64 = "";
    L75:
        if (TextUtils.equals(this.m, "multi_linker") == true) goto L77;
    L81:
        mz0.n r69 = new mz0.n();
        Map<String, String> r70 = r69.a;
        Intrinsics.checkNotNullParameter(r70, "map");
        Intrinsics.checkNotNullParameter(r59, "map");
        r70.putAll(r59);
        mz0.m r72 = new mz0.m();
        r72.b(LogCommon.ROOM);
        r72.b(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.h r73 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r73, "linkInfoLog");
        r73.c(r115);
        Intrinsics.checkNotNullParameter(r58, "connectionTime");
        r73.b(r58);
        ((ArrayList) r72.a).add(r73.a);
        LinkCrossRoomDataHolder.a r74 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r72);
        ((ArrayList) r69.b).addAll(r72.a);
        cy0.e.a.getClass();
        cy0.j r75 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r76 = com.bytedance.android.scope.m.b(r75).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r76);
        ((mz0.i) ((f80.a) r76)).w3("livesdk_pk_start_feedback_page_show", r69.a, r69.b);
    L82:
        ((TextView) r26.findViewById(2131388772)).setText(s1.C(2131921418, new Object[]{T90()}));
        ((LinearLayout) r26.findViewById(2131364756)).setVisibility(8);
        ((Button) r26.findViewById(2131389780)).setVisibility(0);
        ((Button) r26.findViewById(2131389780)).setOnClickListener(new n(this));
        goto L83
    L77:
        if (b51.b.c0.k() == false) goto L81;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r77 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r77 == null) goto L82;
        r77.z();
        Unit r78 = Unit.INSTANCE;
        goto L82
    L53:
        r62 = DataType.FALSE;
        goto L54
    L49:
        r60 = "press";
        goto L50
    L38:
        if (r56.i() != 0) goto L43;
        LinkCrossRoomDataHolder r79 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r79 == null) goto L42;
        r115 = r79.f();
        goto L43
    L42:
        r115 = 0;
        goto L43
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565695, r3, false);
    }
}

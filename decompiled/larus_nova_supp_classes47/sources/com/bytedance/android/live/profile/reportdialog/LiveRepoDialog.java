package com.bytedance.android.live.profile.reportdialog;

import am2.c0;
import am2.n;
import am2.x;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import j40.c2;
import java.util.HashMap;
import java.util.Objects;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import q46.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class LiveRepoDialog extends LiveDialogFragment implements a.InterfaceC0012a, View.OnClickListener {
    public a d;
    public String e;
    public String f;
    public String g;
    public IBaseUser h;
    public IRoom i;
    public boolean j;
    public String k;
    public Activity l;
    public final CompositeDisposable m;
    public boolean n;
    public UserProfileEvent o;
    public String p;
    public ProfileMonitor q;
    public final String r;

    @Override // com.bytedance.android.live.profile.reportdialog.a.InterfaceC0012a
    public final void i7(Throwable r1) {
    }

    public final void onDestroy() {
        a r0 = this.d;
        if (r0 == null) goto L5;
        ((b) r0).a = null;
    L5:
        this.j = false;
        this.m.clear();
        ProfileMonitor r1 = this.q;
        if (r1 == null) goto L8;
        EndType r2 = EndType.HideProfileWithReportDialog;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "endType");
        Intrinsics.checkNotNullParameter("", Constants.OperatorKey.MSG);
        r1.c = false;
        r1.a(r2, "");
    L8:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public LiveRepoDialog() {
        this.k = "";
        this.m = new CompositeDisposable();
        this.q = null;
        this.r = ((String) c2.a.getValue()) + "to_user_id";
        setNoTitleAndCancelOutside(true);
    }

    static {
    }

    public final void onActivityCreated(Bundle r5) {
        Dialog r0 = getDialog();
        if (r0 != null) goto L6;
        super.onActivityCreated(r5);
        return;
    L6:
        super.onActivityCreated(r5);
        Window r6 = r0.getWindow();
        if (r6 != null) goto L9;
        return;
    L9:
        if (PadConfigUtils.c() == false) goto L12;
        r6.addFlags(1024);
        WindowManager.LayoutParams r1 = r6.getAttributes();
        r1.gravity = 8388693;
        r6.setLayout(-1, -1);
        r6.setAttributes(r1);
    L15:
        r6.setFlags(0, 65792);
        r6.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L12:
        if (this.n == false) goto L14;
        r6.setLayout(-1, s1.w() - s1.A());
        r6.setGravity(80);
        goto L15
    L14:
        r6.addFlags(1024);
        int r2 = s1.w();
        WindowManager.LayoutParams r3 = r6.getAttributes();
        r3.gravity = 8388693;
        r6.setLayout(r2, r2);
        r6.setAttributes(r3);
        goto L15
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        if (r12.getId() != 2131390273) goto L11;
        dismiss();     // Catch: Exception -> L6
    L65:
        dismiss();     // Catch: Exception -> L60
        return;
    L60:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L72;
        d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L72:
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L65;
        d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L65
    L11:
        if (r12.getId() != 2131391292) goto L65;
        if (this.i != null) goto L15;
        return;
    L15:
        if (this.l != null) goto L17;
        return;
    L17:
        if (this.h != null) goto L19;
        return;
    L19:
        if (this.o == null) goto L71;
        ((IMiddlewareReportService) k.f(IMiddlewareReportService.class)).reportWithUserProfileEvent(ReportConstant$BusinessSource.ReportAnonymityComment, this.h, this.i, this.o);
        String r15 = this.k;
        String r0 = this.e;
        if (TextUtils.equals(NewProfileInfoViewModel.PAGE_NAME, r15) == false) goto L24;
    L27:
        boolean r1 = true;
    L28:
        HashMap r6 = new HashMap();
        IMiddlewareReportService r7 = (IMiddlewareReportService) k.f(IMiddlewareReportService.class);
        UserProfileEvent r8 = this.o;
        String r9 = "";
        if (r8 == null) goto L31;
        String r10 = r8.mReportTypeForLog;
    L32:
        r6.put("report_type", r7.getReportType(r15, r10, r1));
        IMiddlewareReportService r2 = (IMiddlewareReportService) k.f(IMiddlewareReportService.class);
        UserProfileEvent r16 = this.o;
        if (r16 == null) goto L35;
        r9 = r16.mReportTypeForLog;
    L35:
        r6.put("request_page", r2.getRequestPage(r15, r9));
        r6.put("to_user_id", String.valueOf(r0));
        r6.put("room_id", String.valueOf(this.i.getId()));
        String r3 = DataType.TRUE;
        r6.put("livesdk_profile_hide_confirm", DataType.TRUE);
        if (this.i.isHasCommerceGoods() == true) goto L39;
        r3 = DataType.FALSE;
    L39:
        r6.put("is_sale", r3);
        if (this.i.getRoomAuthStatus() != null) goto L42;
    L48:
        int r17 = h1.a;
        String r18 = i1.a(this.i.getStreamType());
        if (TextUtils.isEmpty(r18) == true) goto L51;
    L56:
        r6.put("live_type", r18);
        j0.l().sendLog("livesdk_live_user_report", r6, new Object[]{IRoom.class, new x(), n.f(), new c0(xs0.a.a())});
        goto L65
    L51:
        if (this.i.getStreamType() != LiveMode.MEDIA) goto L54;
        r18 = "media";
        goto L56
    L54:
        if (this.i.getStreamType() != LiveMode.OFFICIAL_ACTIVITY) goto L56;
        r18 = "official_activity";
        goto L56
    L42:
        if (this.i.getRoomAuthStatus().getEnableUserCard() == true) goto L48;
        IBaseUser r19 = this.h;
        if (r19 == null) goto L48;
        if (r19.getWebcastUid() == null) goto L48;
        r6.put(this.r, this.h.getWebcastUid());
        goto L48
    L31:
        r10 = "";
        goto L32
    L24:
        if (TextUtils.equals("live_barrage", r15) == true) goto L27;
        r1 = false;
        goto L28
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.j = true;
        a r0 = this.d;
        if (r0 == null) goto L5;
        ((b) r0).a = this;
    L5:
        setStyle(1, 2131954579);
    }

    public static void S90(LiveRepoDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LiveRepoDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LiveRepoDialog");
    }

    @Override // com.bytedance.android.live.profile.reportdialog.a.InterfaceC0012a
    public final void N2(IBaseUser r2, boolean r3) {
        if (this.j == true) goto L6;
        return;
    L6:
        if (this.i.getOwner() == null) goto L9;
        Objects.equals(this.i.getOwner().getIdString(), this.e);
    L9:
        if (r2 == null) goto L14;
        String r4 = r2.getIdString();
        int r0 = os0.a.a;
        o0.a.getClass();
        if (o0.a.b(r4) == false) goto L15;
        this.h = r2;
        return;
    L15:
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        if (this.i != null) goto L5;
        return;
    L5:
        j0.l().sendLog("livesdk_live_report_dialog_show", null, new Object[]{IRoom.class, new x(), n.f(), new c0(xs0.a.a())});
        r5.findViewById(2131391292).setOnClickListener(this);
        r5.findViewById(2131390273).setOnClickListener(this);
        TextView r7 = (TextView) r5.findViewById(2131391606);
        String r8 = this.p;
        if (r8 != null) goto L8;
    L10:
        UserProfileEvent r9 = this.o;
        if (r9 == null) goto L19;
        IBaseUser r10 = r9.user;
        if (r10 == null) goto L19;
        if (r10.isAnonymous() == false) goto L19;
        this.h = this.o.user;
        ALogger.i("LiveRepoDialog", "if the reported user is an anonymous user, there is no need to query once");
        return;
    L19:
        if (this.i != null) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(this.f) == false) goto L24;
        this.f = k.f(IMiddlewareUserService.class).user().a(this.e);
    L24:
        HashMap r12 = new HashMap();
        r12.put("user_open_id", this.e);
        r12.put("user_union_id", this.g);
        if (this.i.getOwner() == null) goto L27;
        String r13 = this.i.getOwner().getIdString();
    L28:
        r12.put("anchor_open_id", r13);
        r12.put("packed_level", String.valueOf(2));
        r12.put("current_room_id", String.valueOf(this.i.getId()));
        r12.put("request_from", "report");
        UserProfileEvent r14 = this.o;
        if (r14 == null) goto L35;
        IBaseUser r15 = r14.user;
        if (r15 == null) goto L35;
        if (TextUtils.isEmpty(r15.getWebcastUid()) == true) goto L35;
        r12.put("target_webcast_uid", this.o.user.getWebcastUid());
    L35:
        r12.put("target_display_role", String.valueOf(com.bytedance.android.live.profile.mysteriousman.a.a(this.o)));
        final a r16 = this.d;
        if (r16 == null) goto L42;
        final ProfileMonitor r0 = this.q;
        if (r0 == null) goto L40;
        r0.i(TimeType.RequestStart);
    L40:
        k.f(IMiddlewareUserService.class).user().o(r12).observeOn(AndroidSchedulers.mainThread()).subscribe(new at0.a(r16, r0), new at0.b(r16, r0));
        return;
    L42:
        return;
    L27:
        r13 = "";
        goto L28
    L8:
        if (r8.length() <= 0) goto L10;
        r7.setText(this.p);
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131565729, r3, false);
    }

    public static void T90(ProfileMonitor r2, FragmentActivity r3, boolean r4, IRoom r5, UserProfileEvent r6, String r7) {
        if (r3 != null) goto L4;
        return;
    L4:
        LiveRepoDialog r0 = r3.getSupportFragmentManager().findFragmentByTag("LiveRepoDialog");
        if (r0 != null) goto L13;
        if (r6 != null) goto L8;
        r6 = new UserProfileEvent(DataType.FALSE);
    L8:
        IBaseUser r1 = r6.user;
        if (r1 != null) goto L11;
        String r8 = String.valueOf(r6.getUserIdStr());
    L12:
        LiveRepoDialog r9 = new LiveRepoDialog();
        r9.e = r8;
        r9.f = r6.secUserId;
        r9.g = r6.unionId;
        r9.i = r5;
        r9.d = new a();
        r9.k = r6.mSource;
        r9.l = r3;
        r9.n = r4;
        r9.o = r6;
        r9.p = r7;
        r9.q = r2;
        S90(r9, r3.getSupportFragmentManager());
        return;
    L11:
        r8 = r1.getIdString();
        goto L12
    L13:
        LiveRepoDialog r10 = r0;
        r10.q = r2;
        if (r10.getDialog() != null) goto L16;
    L19:
        S90(r10, r3.getSupportFragmentManager());
        return;
    L16:
        if (r10.getDialog().isShowing() == false) goto L19;
        if (r10.isRemoving() == true) goto L19;
    }
}

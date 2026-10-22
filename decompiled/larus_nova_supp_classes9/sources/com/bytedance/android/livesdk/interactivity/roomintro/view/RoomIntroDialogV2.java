package com.bytedance.android.livesdk.interactivity.roomintro.view;

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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.uikit.layout.WrapLineFlowLayout;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.roomintro.api.RoomIntroApi;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.android.uicomponent.button.UIButton;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/view/RoomIntroDialogV2;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroDialogV2 extends LiveDialogFragment {
    public static final /* synthetic */ int u = 0;
    public RoomIntroDataSource d;
    public LiveSwitchButton e;
    public HSImageView f;
    public TextCorrectionEditText g;
    public TextView h;
    public WrapLineFlowLayout i;
    public UIButton j;
    public WrapLineFlowLayout k;
    public View l;
    public ViewGroup m;
    public ViewGroup n;
    public TextView o;
    public TextView p;
    public ViewGroup q;
    public TextView r;
    public final CompositeDisposable s;
    public boolean t;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RoomIntroDialogV2 a;

        public b(RoomIntroDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            com.bytedance.android.livesdk.log.g r8 = com.bytedance.android.livesdk.log.u.l();
            Pair[] r0 = new Pair[5];
            RoomIntroDataSource r1 = this.a.d;
            String r2 = BuildConfig.FLAVOR;
            if (r1 == null) goto L10;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r3 = r1.n;
            if (r3 == null) goto L10;
            Long r4 = r3.d();
            if (r4 == null) goto L10;
            String r5 = String.valueOf(r4.longValue());
            if (r5 == null) goto L10;
        L11:
            r0[0] = TuplesKt.to("room_id", r5);
            RoomIntroDataSource r6 = this.a.d;
            if (r6 == null) goto L18;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r9 = r6.n;
            if (r9 == null) goto L18;
            String r10 = r9.a();
            if (r10 == null) goto L18;
        L19:
            r0[1] = TuplesKt.to("anchor_id", r10);
            RoomIntroDataSource r11 = this.a.d;
            if (r11 == null) goto L28;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r13 = r11.n;
            if (r13 == null) goto L28;
            if (r13.a != null) goto L26;
            String r14 = "live_start";
        L27:
            r2 = r14;
            goto L28
        L26:
            r14 = "live_room";
        L28:
            r0[2] = TuplesKt.to("request_page", r2);
            String r15 = "0";
            r0[3] = TuplesKt.to("is_video", "0");
            RoomIntroDataSource r16 = this.a.d;
            if (r16 == null) goto L37;
            PropertyOwner r17 = r16.m;
            if (r17 == null) goto L37;
            gz.b r18 = (gz.b) r17.a;
            if (r18 == null) goto L37;
            if (r18.a != true) goto L37;
            r15 = "1";
        L37:
            r0[4] = TuplesKt.to("has_poi", r15);
            r8.sendLog("livesdk_room_detail_revise_success", MapsKt.mapOf(r0), new Object[0]);
            RoomIntroDialogV2.W90(this.a, true);
            return;
        L18:
            r10 = BuildConfig.FLAVOR;
        L10:
            r5 = BuildConfig.FLAVOR;
            goto L11
        }
    }

    static {
    }

    public RoomIntroDialogV2() {
        setNoTitleAndCancelOutside(true);
        this.s = new CompositeDisposable();
    }

    public static final boolean S90(RoomIntroDialogV2 r3) {
        Context r4 = r3.getContext();
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.getSystemService("input_method");
    L7:
        if ((r5 instanceof InputMethodManager) == false) goto L10;
        r0 = r5;
    L10:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 == null) goto L21;
        Integer r2 = (Integer) JavaCalls.callMethod(r1, "getInputMethodWindowVisibleHeight", new Object[0]);
        if (r2 != null) goto L16;
        return false;
    L16:
        if (r2.intValue() <= 0) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public static final void V90(RoomIntroDialogV2 r7) {
        r7.getClass();
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L35;
        FragmentActivity r1 = r7.getActivity();
        gz.a r2 = new gz.a();
        s1.w();
        RoomIntroDataSource r3 = r7.d;
        String r4 = BuildConfig.FLAVOR;
        if (r3 == null) goto L12;
        PropertyOwner r5 = r3.m;
        if (r5 == null) goto L12;
        gz.b r6 = (gz.b) r5.a;
        if (r6 == null) goto L12;
        String r8 = r6.c;
        if (r8 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        String r9 = jc1.k.n(IUserService.class).user().b().getIdString();
        r2.a.put("anchor_id", r9);
        RoomIntroDataSource r10 = r7.d;
        if (r10 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r11 = r10.n;
        if (r11 == null) goto L23;
        if (r11.a != null) goto L20;
        boolean r13 = true;
    L21:
        if (r13 != true) goto L23;
        r2.a.put("live_status", "before");
    L34:
        r2.a.put("enter_from", "room_detail_poi_set");
        Unit r14 = Unit.INSTANCE;
        DialogFragment r15 = r0.getPoiSearchModalDialog(r1, r2, new x(r7));
    L36:
        FragmentActivity r16 = ContextUtil.contextToFragmentActivity(r7.getContext());
        if (r16 == null) goto L50;
        FragmentManager r17 = r16.getSupportFragmentManager();
        if (r17 == null) goto L51;
        if (r15 == null) goto L52;
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, "RoomIntroDialogV2SelectPoi", r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r15, r18) == true) goto L53;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L45:
        r15.showNow(r17, "RoomIntroDialogV2SelectPoi");
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L20:
        r13 = false;
    L23:
        r2.a.put("live_status", "living");
        Map r19 = r2.a;
        RoomIntroDataSource r20 = r7.d;
        if (r20 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r21 = r20.n;
        if (r21 == null) goto L33;
        Long r23 = r21.d();
        if (r23 == null) goto L33;
        String r24 = String.valueOf(r23.longValue());
        if (r24 == null) goto L33;
        r4 = r24;
    L33:
        r19.put("room_id", r4);
    L12:
        r8 = BuildConfig.FLAVOR;
        goto L13
    L35:
        r15 = null;
        goto L36
    }

    public final void X90(boolean r6) {
        if (r6 == false) goto L29;
        RoomIntroDataSource r7 = this.d;
        if (r7 != null) goto L7;
    L14:
        View r8 = this.l;
        if (r8 == null) goto L19;
        View r9 = r8.findViewById(2131381316);
        if (r9 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r9);
    L19:
        View r10 = this.l;
        if (r10 == null) goto L24;
        View r11 = r10.findViewById(2131387899);
        if (r11 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r11);
    L24:
        View r13 = this.l;
        if (r13 == null) goto L45;
        View r14 = r13.findViewById(2131384786);
        if (r14 == null) goto L46;
        UtilityKotlinExtentionsKt.w(r14);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        if (((sh6.b) r7.d.a).a() == true) goto L9;
        r7.d.a(sh6.c.a(Unit.INSTANCE));
    L9:
        PropertyOwner<sh6.b<Integer>> r3 = r7.e;
        Intrinsics.checkNotNullParameter(r3, "$this$valueNullable");
        Integer r4 = (Integer) com.bytedance.android.live.core.arch.mvvm.f.a(r3);
        if (r4 == null) goto L12;
        int r5 = r4.intValue();
    L13:
        r7.e.a(sh6.c.a(Integer.valueOf(r5 + 1)));
        goto L14
    L12:
        r5 = 0;
        goto L13
    L29:
        View r15 = this.l;
        if (r15 == null) goto L34;
        View r16 = r15.findViewById(2131381316);
        if (r16 == null) goto L34;
        UtilityKotlinExtentionsKt.w(r16);
    L34:
        View r17 = this.l;
        if (r17 == null) goto L39;
        View r18 = r17.findViewById(2131387899);
        if (r18 == null) goto L39;
        UtilityKotlinExtentionsKt.w(r18);
    L39:
        View r19 = this.l;
        if (r19 == null) goto L48;
        View r20 = r19.findViewById(2131384786);
        if (r20 == null) goto L49;
        UtilityKotlinExtentionsKt.t(r20);
        return;
    L49:
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L7;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L7;
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        r5.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Dialog r6 = getDialog();
        if (r6 == null) goto L15;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L16;
        View r8 = r7.findViewById(2131389843);
        if (r8 == null) goto L17;
        r8.setOnClickListener(x0.a(new AnonymousClass2(this)));
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954638);
        setShouldUseNewPanel(true);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        this.s.clear();     // Catch: Throwable -> L5
        com.bytedance.android.live.core.utils.x0.a(this.g);     // Catch: Throwable -> L5
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

    public static final void T90(RoomIntroDialogV2 r7, String r8) {
        r7.getClass();
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r1 = new Pair[3];
        RoomIntroDataSource r2 = r7.d;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r4 = r2.n;
        if (r4 == null) goto L7;
        String r5 = r4.c();
    L8:
        r1[0] = TuplesKt.to("live_type", r5);
        RoomIntroDataSource r6 = r7.d;
        if (r6 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r9 = r6.n;
        if (r9 == null) goto L15;
        String r10 = r9.a();
        if (r10 == null) goto L15;
        r3 = r10;
    L15:
        r1[1] = TuplesKt.to("anchor_id", r3);
        RoomIntroDataSource r11 = r7.d;
        Long r13 = null;
        if (r11 == null) goto L20;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r14 = r11.n;
        if (r14 == null) goto L20;
        Long r15 = r14.d();
    L21:
        if (r15 == null) goto L32;
        RoomIntroDataSource r16 = r7.d;
        if (r16 == null) goto L27;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r17 = r16.n;
        if (r17 == null) goto L27;
        r13 = r17.d();
    L27:
        if (r13 != null) goto L30;
    L31:
        String r18 = "live_take_detail";
    L33:
        r1[2] = TuplesKt.to("event_page", r18);
        r0.sendLog(r8, MapsKt.mutableMapOf(r1), new Object[0]);
        return;
    L30:
        if (r13.longValue() != 0) goto L31;
    L32:
        r18 = "live_take_page";
    L20:
        r15 = null;
    L7:
        r5 = BuildConfig.FLAVOR;
        goto L8
    }

    public static final void U90(RoomIntroDialogV2 r9, String r10) {
        r9.getClass();
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r1 = new Pair[5];
        RoomIntroDataSource r2 = r9.d;
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r4 = r2.n;
        if (r4 == null) goto L7;
        String r5 = r4.c();
    L8:
        r1[0] = TuplesKt.to("live_type", r5);
        RoomIntroDataSource r6 = r9.d;
        if (r6 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r7 = r6.n;
        if (r7 == null) goto L16;
        Long r8 = r7.d();
        if (r8 == null) goto L16;
        String r11 = String.valueOf(r8.longValue());
        if (r11 == null) goto L16;
    L17:
        r1[1] = TuplesKt.to("room_id", r11);
        RoomIntroDataSource r13 = r9.d;
        if (r13 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r14 = r13.n;
        if (r14 == null) goto L24;
        String r15 = r14.a();
        if (r15 == null) goto L24;
        r3 = r15;
    L24:
        r1[2] = TuplesKt.to("anchor_id", r3);
        RoomIntroDataSource r16 = r9.d;
        Long r17 = null;
        if (r16 == null) goto L29;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r18 = r16.n;
        if (r18 == null) goto L29;
        Long r19 = r18.d();
    L30:
        if (r19 == null) goto L41;
        RoomIntroDataSource r20 = r9.d;
        if (r20 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r21 = r20.n;
        if (r21 == null) goto L36;
        r17 = r21.d();
    L36:
        if (r17 != null) goto L39;
    L40:
        String r23 = "live_take_detail";
    L42:
        r1[3] = TuplesKt.to("event_page", r23);
        RoomIntroDataSource r24 = r9.d;
        if (r24 == null) goto L51;
        PropertyOwner r25 = r24.m;
        if (r25 == null) goto L51;
        gz.b r26 = (gz.b) r25.a;
        if (r26 == null) goto L51;
        if (r26.a != true) goto L51;
        String r27 = "1";
    L52:
        r1[4] = TuplesKt.to("has_poi", r27);
        r0.sendLog(r10, MapsKt.mutableMapOf(r1), new Object[0]);
        return;
    L51:
        r27 = "0";
        goto L52
    L39:
        if (r17.longValue() != 0) goto L40;
    L41:
        r23 = "live_take_page";
    L29:
        r19 = null;
    L16:
        r11 = BuildConfig.FLAVOR;
    L7:
        r5 = BuildConfig.FLAVOR;
        goto L8
    }

    public static final void W90(RoomIntroDialogV2 r14, boolean r15) {
        RoomIntroDataSource r0 = r14.d;
        String r1 = null;
        if (r0 == null) goto L7;
        PropertyOwner r2 = r0.g;
        if (r2 == null) goto L7;
        List r3 = (List) r2.a;
    L8:
        if (r0 == null) goto L10;
        String r7 = r0.a();
    L11:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        boolean r5 = true;
        if (r4 == null) goto L22;
        kj0.b r6 = r4.getSelfDisciplineService();
        if (r6 == null) goto L22;
        if (r6.isSelfDisciplineOn() != true) goto L22;
        IInteractService r8 = jc1.k.f(IInteractService.class);
        if (r8 == null) goto L22;
        kj0.b r9 = r8.getSelfDisciplineService();
        if (r9 == null) goto L22;
        r9.logUpdateRoomIntro(r7);
    L22:
        com.bytedance.android.live.core.utils.x0.a(r14.g);
        if (r3 != null) goto L76;
        String r10 = null;
    L28:
        String r11 = r10;
    L29:
        RoomIntroApi r13 = (RoomIntroApi) com.bytedance.android.live.network.c.b().e(RoomIntroApi.class);
        RoomIntroDataSource r16 = r14.d;
        if (r16 == null) goto L34;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r17 = r16.n;
        if (r17 == null) goto L34;
        Long r18 = r17.d();
    L35:
        RoomIntroDataSource r19 = r14.d;
        if (r19 == null) goto L40;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r20 = r19.n;
        if (r20 == null) goto L40;
        String r21 = r20.c();
    L41:
        RoomIntroDataSource r23 = r14.d;
        if (r23 == null) goto L46;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.c r24 = r23.n;
        if (r24 == null) goto L46;
        Long r25 = r24.b();
    L47:
        RoomIntroDataSource r26 = r14.d;
        if (r26 == null) goto L52;
        PropertyOwner r27 = r26.k;
        if (r27 == null) goto L52;
        Boolean r110 = (Boolean) r27.a;
    L53:
        if (r26 == null) goto L57;
        PropertyOwner r28 = r26.l;
        if (r28 == null) goto L57;
        Boolean r111 = (Boolean) r28.a;
    L58:
        if (r26 == null) goto L70;
        PropertyOwner r29 = r26.m;
        if (r29 == null) goto L70;
        gz.b r30 = (gz.b) r29.a;
        if (r30 == null) goto L70;
        if (r30.c.length() == 0) goto L67;
        r5 = false;
    L67:
        if (r5 == false) goto L69;
        r1 = "-1";
        goto L70
    L69:
        r1 = r30.c;
    L70:
        Observable r31 = r13.updateRoomIntro(r18, r15, BuildConfig.FLAVOR, r7, r21, r25, r11, r110, r111, r1).compose(RxUtil.rxSchedulerHelper());
        if (r31 == null) goto L78;
        ObservableSubscribeProxy r33 = (ObservableSubscribeProxy) r31.as(AutoDispose.bind(r14));
        if (r33 == null) goto L79;
        r33.subscribe(new z(r14, r15), new a0(r14));
        return;
    L79:
        return;
    L78:
        return;
    L57:
        r111 = null;
    L52:
        r110 = null;
    L46:
        r25 = null;
    L40:
        r21 = null;
    L34:
        r18 = null;
        goto L35
    L76:
        r10 = GsonHelper.get().toJson(r3);     // Catch: Exception -> L26
    L26:
        r11 = null;
        goto L29
    L10:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        View r7 = this.l;
        if (r7 == null) goto L5;
        r7.setOnTouchListener(new y(this));
    L5:
        LiveSwitchButton r8 = this.e;
        if (r8 == null) goto L8;
        r8.setOnCheckedChangeListener(new w(this));
    L8:
        RoomIntroDataSource r9 = this.d;
        if (r9 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.roomintro.api.b r10 = r9.o;
        if (r10 == null) goto L13;
        boolean r11 = r10.k();
    L14:
        LiveSwitchButton r1 = this.e;
        if (r1 == null) goto L17;
        boolean r2 = r1.isChecked();
    L18:
        if (r11 == r2) goto L22;
        LiveSwitchButton r3 = this.e;
        if (r3 == null) goto L22;
        r3.f(false, false);
    L22:
        X90(r11);
        IUserService r13 = jc1.k.f(IUserService.class);
        Unit r4 = null;
        if (r13 == null) goto L29;
        com.bytedance.android.livesdk.user.f r14 = r13.user();
        if (r14 == null) goto L29;
        IUser r15 = r14.b();
        if (r15 == null) goto L29;
        py.k r16 = r15.getAvatarThumb();
    L30:
        ImageUtil.loadRoundImage((ImageView) r5.findViewById(2131389468), r16);
        u r17 = new u(this);
        HSImageView r18 = this.f;
        if (r18 == null) goto L33;
        r18.setOnClickListener(new t(this, r17));
    L33:
        FrescoLoader.with(getContext()).load("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_broadcast_image_room_intro_demo.png").actualScaleType(ImageView.ScaleType.FIT_CENTER).controllerListener(new ImageLoader.e(null, r17, false)).placeholder(2131250137).into(this.f);
        int r19 = com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m.i;
        RoomIntroDataSource r20 = this.d;
        WrapLineFlowLayout r21 = this.k;
        CompositeDisposable r0 = this.s;
        Intrinsics.checkNotNullParameter(r0, "cd");
        if (r20 == null) goto L37;
        if (r21 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m r23 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.m(r20, r21, r0);
    L39:
        if (r23 == null) goto L41;
        Function0<Integer> r24 = new RoomIntroDialogV2$initLabels$1(this);
        Intrinsics.checkNotNullParameter(r24, "getRoomIntroDialogHeightAction");
        r23.h.add(com.bytedance.android.live.core.arch.mvvm.f.b(r23.f.i).subscribe(new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.o(r23, r24)));
    L41:
        int r25 = com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a.f;
        RoomIntroDataSource r26 = this.d;
        TextCorrectionEditText r27 = this.g;
        TextView r28 = this.h;
        WrapLineFlowLayout r29 = this.i;
        if (r26 != null) goto L44;
        com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a r30 = null;
    L45:
        RoomIntroDataSource r31 = this.d;
        if (r31 == null) goto L48;
        r31.c = r30;
    L48:
        if (r30 == null) goto L50;
        r30.c();
    L50:
        RoomIntroDataSource r33 = this.d;
        if (r33 == null) goto L59;
        PropertyOwner r34 = r33.k;
        if (r34 == null) goto L59;
        Observable r35 = com.bytedance.android.live.core.arch.mvvm.f.b(r34);
        if (r35 == null) goto L59;
        Disposable r36 = r35.subscribe(new v(this));
        if (r36 == null) goto L59;
        RxUtilKt.c(r36, this.s);
    L63:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.o) r52.n.a.getValue()).a() == false) goto L77;
        RoomIntroDataSource r37 = this.d;
        if (r37 == null) goto L74;
        PropertyOwner r38 = r37.l;
        if (r38 == null) goto L74;
        Observable r39 = com.bytedance.android.live.core.arch.mvvm.f.b(r38);
        if (r39 == null) goto L74;
        Disposable r40 = r39.subscribe(new o(this));
        if (r40 == null) goto L74;
        RxUtilKt.c(r40, this.s);
    L74:
        ALogger.i("RoomIntroDialogV2", "no appointment");
        ViewGroup r41 = this.n;
        if (r41 == null) goto L77;
        UtilityKotlinExtentionsKt.t(r41);
        Unit r43 = Unit.INSTANCE;
    L77:
        RoomIntroDataSource r44 = this.d;
        if (r44 == null) goto L98;
        PropertyOwner r45 = r44.m;
        if (r45 == null) goto L98;
        Observable r46 = com.bytedance.android.live.core.arch.mvvm.f.b(r45);
        if (r46 == null) goto L98;
        Disposable r47 = r46.subscribe(new q(this));
        if (r47 == null) goto L98;
        RxUtilKt.c(r47, this.s);
        RoomIntroDataSource r48 = this.d;
        if (r48 == null) goto L94;
        PropertyOwner r49 = r48.f;
        if (r49 == null) goto L94;
        Observable r50 = com.bytedance.android.live.core.arch.mvvm.f.b(r49);
        if (r50 == null) goto L94;
        Disposable r51 = r50.subscribe(new p(this));
        if (r51 == null) goto L94;
        RxUtilKt.c(r51, this.s);
    L94:
        ViewGroup r53 = this.q;
        if (r53 == null) goto L97;
        r53.setOnClickListener(x0.a(new RoomIntroDialogV2$initLocalLifePoi$$inlined$let$lambda$2(this)));
        r4 = Unit.INSTANCE;
    L97:
        if (r4 == null) goto L98;
    L101:
        UIButton r54 = this.j;
        if (r54 == null) goto L105;
        r54.setOnClickListener(new b(this));
        return;
    L105:
        return;
    L98:
        ALogger.i("RoomIntroDialogV2", "no local life poi");
        ViewGroup r55 = this.q;
        if (r55 == null) goto L101;
        UtilityKotlinExtentionsKt.t(r55);
        Unit r56 = Unit.INSTANCE;
    L59:
        ALogger.i("RoomIntroDialogV2", "no poi");
        ViewGroup r57 = this.m;
        if (r57 == null) goto L63;
        UtilityKotlinExtentionsKt.t(r57);
        Unit r58 = Unit.INSTANCE;
        goto L63
    L44:
        r30 = new com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter.a(r26, r27, r28, r29);
    L37:
        r23 = null;
    L29:
        r16 = null;
        goto L30
    L17:
        r2 = false;
    L13:
        r11 = false;
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565756, r3, false);
        if (r5 == null) goto L5;
        this.e = r5.findViewById(2131387878);
        this.f = r5.findViewById(2131381317);
        this.g = r5.findViewById(2131371469);
        this.h = (TextView) r5.findViewById(2131371471);
        this.i = r5.findViewById(2131375570);
        this.j = r5.findViewById(2131364848);
        this.k = r5.findViewById(2131388160);
        this.l = r5;
        this.m = (ViewGroup) r5.findViewById(2131382547);
        this.n = (ViewGroup) r5.findViewById(2131363203);
        this.o = (TextView) r5.findViewById(2131363212);
        this.p = (TextView) r5.findViewById(2131382724);
        this.q = (ViewGroup) r5.findViewById(2131379119);
        this.r = (TextView) r5.findViewById(2131379121);
        return r5;
    L5:
        return null;
    }
}

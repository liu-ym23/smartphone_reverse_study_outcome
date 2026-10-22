package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/InputPositionNameDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InputPositionNameDialog extends CommonBottomDialog {
    public static final /* synthetic */ int i = 0;
    public final CompositeDisposable a;
    public final boolean b;
    public boolean c;
    public int d;
    public final IRoom e;
    public final String f;
    public final boolean g;
    public final boolean h;

    public static final class a {
    }

    public static final class b implements View.OnKeyListener {
        public final /* synthetic */ InputPositionNameDialog a;

        public b(InputPositionNameDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            InputPositionNameDialog r4 = this.a;
            int r5 = InputPositionNameDialog.i;
            if (r2 != 66) goto L5;
            r4.M0();
            return false;
        L5:
            r4.getClass();
            return false;
        }
    }

    public static final class c extends d2 {
        public final /* synthetic */ InputPositionNameDialog a;

        public c(InputPositionNameDialog r1) {
            this.a = r1;
        }

        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Editable r5 = ((EditText) this.a.findViewById(2131371488)).getText();
            if (r5 == null) goto L5;
            int r6 = r5.length();
        L7:
            if (r6 <= 0) goto L9;
            ((TextView) this.a.findViewById(2131364848)).setBackgroundResource(2131249467);
        L10:
            InputPositionNameDialog r7 = this.a;
            String r8 = null;
            if (r7.b == false) goto L16;
            TextView r9 = (TextView) r7.findViewById(2131390975);
            Editable r10 = ((EditText) this.a.findViewById(2131371488)).getText();
            if (r10 == null) goto L15;
            r8 = r10.toString();
        L15:
            r9.setText(r8);
            return;
        L16:
            TextView r11 = (TextView) r7.findViewById(2131390978);
            Editable r12 = ((EditText) this.a.findViewById(2131371488)).getText();
            if (r12 == null) goto L19;
            r8 = r12.toString();
        L19:
            r11.setText(r8);
            return;
        L9:
            ((TextView) this.a.findViewById(2131364848)).setBackgroundResource(2131249430);
            goto L10
        L5:
            r6 = 0;
            goto L7
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InputPositionNameDialog a;

        public d(InputPositionNameDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            InputPositionNameDialog r3 = this.a;
            int r0 = InputPositionNameDialog.i;
            r3.M0();
        }
    }

    public static final class e implements LiveBottomSheetDialog.k {
        public final /* synthetic */ InputPositionNameDialog a;

        public e(InputPositionNameDialog r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            x0.a((EditText) this.a.findViewById(2131371488));
        }
    }

    public static final class f implements InputFilter {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            if (r1 == null) goto L8;
            String r7 = r1.toString();
            if (r7 == null) goto L8;
            String r8 = StringsKt.replace$default(r7, "\n", "", false, 4, null);
            if (r8 == null) goto L8;
            return r8;
        L8:
            return "";
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ InputPositionNameDialog a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public g(InputPositionNameDialog r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            x0.a((EditText) this.a.findViewById(2131371488));
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.a.d;
            String r4 = this.b;
            long r5 = this.c;
            String r7 = ((com.bytedance.android.live.network.response.a) r10).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.w0(r2, r4, r5, r7);
            f2.b(2131919011, 0);
            CommonBottomDialog r11 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r11);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r11);
            r11.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r11);
        L17:
            jf0.a r12 = jf0.a.a;
            String r13 = this.b;
            InputPositionNameDialog r3 = this.a;
            int r6 = r3.d;
            boolean r8 = r3.g;
            boolean r9 = r3.h;
            boolean r14 = r3.c;
            Intrinsics.checkNotNullParameter(r13, "seatName");
            HashMap r15 = new HashMap();
            TalkRoomLogUtils.B0(r15, Integer.valueOf(je0.d.f()), null, 4);
            r15.put("seat_name", r13);
            r15.put("seat_num", String.valueOf(r6));
            String r16 = "1";
            if (r8 == false) goto L20;
            Object r17 = "1";
        L21:
            r15.put("is_guest", r17);
            if (r9 == true) goto L25;
            r16 = "0";
        L25:
            r15.put("is_first_edit", r16);
            if (r14 == false) goto L28;
            String r18 = "administrator";
        L29:
            r15.put("user_type", r18);
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_submit_success", r15, new Object[]{IRoom.class, am2.x.class});
            return;
        L28:
            r18 = "anchor";
            goto L29
        L20:
            r17 = "0";
            goto L21
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r19 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r19 == null) goto L16;
            com.bytedance.crash.d.d(r19, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r11);
            throw th;
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r11));
            goto L17
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ InputPositionNameDialog a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public h(InputPositionNameDialog r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a.d;
            String r3 = this.b;
            long r4 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.v0(r1, r3, r4, r8);
            ExceptionUtils.handleException(this.a.getContext(), r8);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565492;
    }

    public final void M0() {
        if (this.e != null) goto L5;
        return;
    L5:
        Editable r0 = ((EditText) findViewById(2131371488)).getText();
        if (r0 == null) goto L80;
        String r1 = r0.toString();
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L81;
        com.bytedance.android.live.liveinteract.plantform.core.y r3 = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        com.bytedance.android.live.liveinteract.plantform.core.y r4 = (com.bytedance.android.live.liveinteract.plantform.core.y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (ThemedCompetitionContext.Companion.g() == false) goto L22;
        int r5 = this.d;
        if (r4 == null) goto L22;
        if (r5 != r4.q()) goto L22;
    L56:
        boolean r6 = true;
    L58:
        if (r6 == true) goto L61;
        if (r3 == null) goto L61;
        r3.M(this.d);
    L61:
        jf0.a r7 = jf0.a.a;
        int r8 = this.d;
        boolean r9 = this.g;
        boolean r10 = this.h;
        boolean r11 = this.c;
        Intrinsics.checkNotNullParameter(r1, "seatName");
        HashMap r12 = new HashMap();
        TalkRoomLogUtils.B0(r12, Integer.valueOf(je0.d.f()), null, 4);
        r12.put("seat_name", r1);
        r12.put("seat_num", String.valueOf(r8));
        String r13 = "1";
        if (r9 == false) goto L64;
        Object r14 = "1";
    L65:
        r12.put("is_guest", r14);
        if (r10 == true) goto L69;
        r13 = "0";
    L69:
        r12.put("is_first_edit", r13);
        if (r11 == false) goto L72;
        String r15 = "administrator";
    L73:
        r12.put("user_type", r15);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_name_submit", r12, new Object[]{IRoom.class, am2.x.class});
        long r16 = System.currentTimeMillis();
        this.a.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).setPositionAttribute(this.e.getId(), this.d, r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r1, r16), new h(this, r1, r16)));
        return;
    L72:
        r15 = "anchor";
        goto L73
    L64:
        r14 = "0";
    L22:
        if (r4 == null) goto L36;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r17 = r4.c;
        if (r17 == null) goto L36;
        Iterator<ILinkPlayerInfoBridge> r18 = r17.iterator();
    L27:
        if (r18.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r19 = r18.next();
        if (r19.getUserPosition() != this.d) goto L31;
        boolean r20 = true;
    L32:
        if (r20 == false) goto L27;
    L35:
        ILinkPlayerInfoBridge r21 = r19;
    L37:
        if (r21 == null) goto L41;
        IBaseUser r22 = r21.getUser();
        if (r22 == null) goto L41;
        String r23 = r22.getIdString();
    L42:
        IRoom r24 = this.e;
        if (r24 == null) goto L45;
        String r25 = r24.getOwnerUserIdString();
    L46:
        boolean r26 = Intrinsics.areEqual(r23, r25);
        if (ThemedCompetitionContext.Companion.g() == false) goto L51;
        if (r21 == null) goto L51;
        if (r26 == false) goto L56;
    L51:
        Integer r27 = je0.d.h();
        if (r27 != null) goto L55;
    L57:
        r6 = false;
        goto L58
    L55:
        if (r27.intValue() != 66) goto L57;
    L45:
        r25 = null;
    L41:
        r23 = null;
        goto L42
    L31:
        r20 = false;
        goto L32
    L34:
        r19 = null;
    L36:
        r21 = null;
        goto L37
    L81:
        return;
    L13:
        r2 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getWindow() == null) goto L35;
        Window r0 = getWindow();
        if (r0 == null) goto L13;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L11:
        if (r1 == null) goto L13;
        r1.setPadding(0, 0, 0, 0);
    L13:
        Window r3 = getWindow();
        if (r3 == null) goto L16;
        r3.setLayout(-1, -1);
    L16:
        Window r4 = getWindow();
        if (r4 == null) goto L19;
        r4.setGravity(80);
    L19:
        Window r5 = getWindow();
        if (r5 == null) goto L22;
        r5.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        Window r6 = getWindow();
        if (r6 == null) goto L25;
        r6.setSoftInputMode(16);
    L25:
        Window r7 = getWindow();
        if (r7 == null) goto L28;
        r7.clearFlags(1024);
    L28:
        Window r8 = getWindow();
        if (r8 == null) goto L31;
        r8.addFlags(262144);
    L31:
        Window r9 = getWindow();
        if (r9 == null) goto L36;
        r9.addFlags(32);
        return;
    L36:
        return;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        GradientDrawable r11 = new GradientDrawable();
        r11.setCornerRadius(UtilityKotlinExtentionsKt.i(10));
        this.c = je0.d.Y();
        if (this.b == false) goto L21;
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(s1.h(2131109391));
        r0.setCornerRadius(UtilityKotlinExtentionsKt.i(30));
        findViewById(2131392561).setBackground(r0);
        r11.setColor(ColorProtector.parseColor("#33000000"));
        ((TextView) findViewById(2131390975)).setBackground(r11);
        if (this.d >= 0) goto L7;
        this.d = 0;
    L7:
        ((TextView) findViewById(2131391017)).setText("0" + (this.d + 1));
        TextView r12 = (TextView) findViewById(2131391017);
        if (je0.d.D() == false) goto L16;
        IInteractService r1 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r4 = je0.d.h();
        if (r4 == null) goto L12;
        int r5 = r4.intValue();
    L14:
        if (r1.isVoiceMultiEnlargeSeat(r5, this.d) == false) goto L16;
        String r2 = s1.B(2131919275);
    L20:
        r12.setText(r2);
        ImageLoader.bindImage(findViewById(2131375158), "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_edit_position_name_bg.png");
        r2.a(findViewById(2131375158), UtilityKotlinExtentionsKt.i(2));
    L27:
        if (this.f == null) goto L44;
        ((EditText) findViewById(2131371488)).setText(this.f);
        ((EditText) findViewById(2131371488)).setSelection(this.f.length());
        if (this.f.length() <= 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L43;
        ((TextView) findViewById(2131364848)).setBackgroundResource(2131249467);
        String r6 = null;
        if (this.b == false) goto L39;
        TextView r14 = (TextView) findViewById(2131390975);
        Editable r3 = ((EditText) findViewById(2131371488)).getText();
        if (r3 == null) goto L38;
        r6 = r3.toString();
    L38:
        r14.setText(r6);
        goto L44
    L39:
        TextView r15 = (TextView) findViewById(2131390978);
        Editable r7 = ((EditText) findViewById(2131371488)).getText();
        if (r7 == null) goto L42;
        r6 = r7.toString();
    L42:
        r15.setText(r6);
        goto L44
    L43:
        ((TextView) findViewById(2131364848)).setBackgroundResource(2131249430);
        goto L44
    L31:
        r13 = false;
    L44:
        ((EditText) findViewById(2131371488)).setFilters(new InputFilter[]{((EditText) findViewById(2131371488)).getFilters()[0], f.a});
        ((EditText) findViewById(2131371488)).setOnKeyListener(new b(this));
        ((EditText) findViewById(2131371488)).addTextChangedListener(new c(this));
        ((TextView) findViewById(2131364848)).setOnClickListener(new d(this));
        x0.b((EditText) findViewById(2131371488));
        setCanceledOnTouchOutside(true);
        setLiveBottomSheetOutsideListener(new e(this));
        return;
    L12:
        r5 = 0;
    L16:
        int r8 = this.d;
        if (r8 < 9) goto L19;
        r2 = String.valueOf(r8 + 1);
        goto L20
    L19:
        r2 = "0" + (this.d + 1);
        goto L20
    L21:
        UtilityKotlinExtentionsKt.t(findViewById(2131372683));
        UtilityKotlinExtentionsKt.w(findViewById(2131372879));
        r11.setColor(ColorProtector.parseColor("#33000000"));
        ((TextView) findViewById(2131390978)).setBackground(r11);
        TextView r16 = (TextView) findViewById(2131391018);
        if (je0.d.w() == true) goto L24;
        StringBuilder r9 = new StringBuilder("0");
        int r17 = this.d;
    L25:
        r9.append(r17);
        r16.setText(r9.toString());
        r2.a(findViewById(2131392562), UtilityKotlinExtentionsKt.i(4));
        goto L27
    L24:
        r9 = new StringBuilder("0");
        r17 = this.d + 1;
        goto L25
    }

    public InputPositionNameDialog(Context r2, int r3, IRoom r4, String r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.a = new CompositeDisposable();
        this.b = je0.d.u();
    }

    public /* synthetic */ InputPositionNameDialog(Context r8, int r9, IRoom r10, String r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 8) == 0) goto L5;
        r11 = "";
    L5:
        String r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        boolean r5 = false;
    L10:
        if ((r14 & 32) == 0) goto L12;
        boolean r6 = false;
    L13:
        this(r8, r9, r10, r4, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }
}

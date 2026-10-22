package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.api.LiveAdjustPositionApi;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.GetPositionPanelResponse;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.PositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkAudiHamletFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkHeightFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager.MultiLinkWidthFitRecyclerLayoutManager;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.adapter.AdjustGuestPositionListAdapter;
import com.bytedance.android.livesdk.config.ya0;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AdjustGuestPositionDialog extends com.bytedance.android.livesdk.common.b implements View.OnClickListener, com.bytedance.android.live.liveinteract.videotalk.adapter.b {
    public static final /* synthetic */ int v = 0;
    public final int b;
    public final int c;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m d;
    public int e;
    public final int f;
    public Button g;
    public RecyclerView h;
    public AdjustGuestPositionListAdapter i;
    public final IRoom j;
    public final CompositeDisposable k;
    public Disposable l;
    public int m;
    public int n;
    public int o;
    public Map<Long, PositionItem> p;
    public final Lazy q;
    public ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r;
    public final boolean s;
    public View t;
    public final int u;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public a(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r4;
            ?? r6 = this.a;
            if (r6.s == false) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public c(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r4;
            ?? r6 = this.a;
            if (r6.s == false) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public e(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
        public final void accept(Object r4) {
            StateMachine.c.b r5 = (StateMachine.c.b) r4;
            if (TeamFightContext.Companion.h() == false) goto L21;
            ?? r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class f {
    }

    public static final class g extends Handler {
        public final WeakReference<AdjustGuestPositionDialog> a;

        public g(AdjustGuestPositionDialog r2) {
            Intrinsics.checkNotNullParameter(r2, "obj");
            super(Looper.getMainLooper());
            this.a = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            Intrinsics.checkNotNullParameter(r6, "msg");
            WeakReference<AdjustGuestPositionDialog> r0 = this.a;
            if (r0 == null) goto L11;
            AdjustGuestPositionDialog r1 = r0.get();
            if (r1 != null) goto L7;
            return;
        L7:
            if (r6.what != 5) goto L13;
            r1.l.dispose();
            Disposable r7 = du2.a.b(1, 5, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.c(r1));
            RxUtilKt.c(r7, r1.k);
            r1.l = r7;
            return;
        L13:
            return;
        }
    }

    public static final class h implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public h(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r4) {
            Intrinsics.checkNotNullParameter(r4, "request");
            ?? r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r13, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r14) {
            Intrinsics.checkNotNullParameter(r13, "request");
            Intrinsics.checkNotNullParameter(r14, "response");
            if (r14.a.getUiLayout() != 30) goto L24;
            AdjustGuestPositionDialog r15 = this.a;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r16 = r14.a;
            r15.getClass();
            if (r16.getUiLayout() != 30) goto L25;
            r16 = r16.b();
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r17 = r16.d();
            int r1 = 0;
            if (r17 == null) goto L10;
            int r18 = r17.b();
        L11:
            List<com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d> r2 = r16.h();
            if (r2 == null) goto L25;
            Iterator<T> r3 = r2.iterator();
        L15:
            if (r3.hasNext() == false) goto L25;
            Object r4 = r3.next();
            int r5 = r1 + 1;
            if (r1 >= 0) goto L19;
            CollectionsKt.throwIndexOverflow();
        L19:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d r6 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.m.d) r4;
            if (r1 != 0) goto L22;
            r6.l((((double) r18) - r6.b()) / ((double) 2));
        L23:
            r1 = r5;
            goto L15
        L22:
            double r7 = r6.b() - r6.d();
            r6.j(r6.b());
            r6.k(r6.e() - r7);
            goto L23
        L10:
            r18 = 0;
        L25:
            AdjustGuestPositionDialog r19 = this.a;
            r19.d = r16;
            int r8 = s1.y();
            int r9 = s1.w();
            View r10 = r19.t;
            if (r10 == null) goto L30;
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
            if (r11 == null) goto L30;
            float r12 = r11.height;
        L31:
            RecyclerView r20 = r19.h;
            ViewGroup.LayoutParams r21 = null;
            if (r20 == null) goto L34;
            ViewGroup.LayoutParams r22 = r20.getLayoutParams();
        L36:
            if ((r22 instanceof ViewGroup.MarginLayoutParams) == true) goto L38;
            r22 = null;
        L38:
            ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
            if (r23 == null) goto L41;
            float r24 = r23.topMargin;
        L42:
            Button r25 = r19.g;
            if (r25 == null) goto L45;
            ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        L47:
            if ((r26 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
            r21 = r26;
        L50:
            ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r21;
            if (r27 == null) goto L53;
            float r28 = r27.height;
        L54:
            if (r27 == null) goto L56;
            float r29 = r27.topMargin;
        L57:
            if (r27 == null) goto L59;
            float r30 = r27.bottomMargin;
        L60:
            Integer r31 = je0.d.h();
            if (r31 != null) goto L64;
        L65:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r32 = r16.d();
            float r33 = 0.0f;
            if (r32 == null) goto L68;
            float r34 = r32.b();
        L69:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r110 = r16.d();
            if (r110 == null) goto L72;
            r33 = r110.c();
        L72:
            float r35 = r34 / r33;
        L74:
            float r111 = s1.y() - (s1.f(64.0f) * 2);
            float r0 = r35 * r111;
            float r36 = r9;
            float r112 = r36 / r8;
            if (((Boolean) ya0.a.getValue()).booleanValue() == false) goto L82;
            if (r8 <= r9) goto L78;
        L81:
            r0 = (((((r36 - UtilityKotlinExtentionsKt.h(r19.u)) - r12) - r24) - r28) - r29) - r30;
            r111 = (1 / r35) * r0;
            goto L82
        L78:
            if (r0 > r36) goto L81;
            if (r112 < r35) goto L81;
        L82:
            RecyclerView r113 = r19.h;
            if (r113 == null) goto L87;
            ViewGroup.LayoutParams r114 = r113.getLayoutParams();
            if (r114 == null) goto L87;
            r114.width = (int) r111;
            r114.height = (int) r0;
        L87:
            this.a.c();
            return;
        L68:
            r34 = 0.0f;
            goto L69
        L64:
            if (r31.intValue() != 28) goto L65;
            r35 = 1.4f;
            goto L74
        L59:
            r30 = UtilityKotlinExtentionsKt.h(34);
            goto L60
        L56:
            r29 = UtilityKotlinExtentionsKt.h(20);
            goto L57
        L53:
            r28 = UtilityKotlinExtentionsKt.h(44);
            goto L54
        L45:
            r26 = null;
            goto L47
        L41:
            r24 = UtilityKotlinExtentionsKt.h(18);
            goto L42
        L34:
            r22 = null;
        L30:
            r12 = UtilityKotlinExtentionsKt.h(20);
            goto L31
        L24:
            r16 = r14.a;
            goto L25
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public i(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, com.bytedance.android.live.liveinteract.videotalk.adapter.b] */
        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            DATA r0 = r10.data;
            if (r0 == 0) goto L72;
            this.a.m = ((GetPositionPanelResponse) r0).getUserPosition();
            this.a.p = ((GetPositionPanelResponse) r10.data).getPositionMap();
            ?? r1 = this.a;
            Map<Long, PositionItem> r11 = ((GetPositionPanelResponse) r10.data).getPositionMap();
            String r2 = AdjustGuestPositionDialog.b(r1.f);
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r3 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
            int r4 = r1.e;
            if (r4 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L7;
        L10:
            if (r11 == null) goto L15;
            Iterator<Map.Entry<Long, PositionItem>> r12 = r11.entrySet().iterator();
        L13:
            if (r12.hasNext() == false) goto L15;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a.add(r12.next().getValue());
        L15:
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r13 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        L16:
            if (r13 == null) goto L74;
            r1.r = r13;
            r1.i = new AdjustGuestPositionListAdapter(r1.getContext(), r1.e, r1.r, r1.c);
            int r14 = r1.e;
            boolean r5 = true;
            if (r14 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L21;
        L22:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15 = r1.d;
            if (r15 == null) goto L42;
            RecyclerView r6 = r1.h;
            if (r6 == null) goto L42;
            Integer r7 = je0.d.h();
            if (r7 != null) goto L30;
        L32:
            int r8 = ug0.b.a;
            Intrinsics.checkNotNullParameter(r15, "layoutConfig");
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.a r16 = r15.c();
            if (r16 != null) goto L35;
        L37:
            boolean r17 = false;
        L38:
            if (r17 == false) goto L40;
            RecyclerView.LayoutManager r18 = new MultiLinkHeightFitRecyclerLayoutManager(r15);
        L41:
            r6.setLayoutManager(r18);
            goto L42
        L40:
            r18 = new MultiLinkWidthFitRecyclerLayoutManager(r15);
            goto L41
        L35:
            if (r16.e() != 2) goto L37;
            r17 = true;
            goto L38
        L30:
            if (r7.intValue() != 28) goto L32;
            r18 = new MultiLinkAudiHamletFitRecyclerLayoutManager(r15);
        L42:
            AdjustGuestPositionListAdapter r19 = r1.i;
            if (r19 == null) goto L45;
            r19.e = r1;
        L45:
            RecyclerView r20 = r1.h;
            if (r20 == null) goto L48;
            r20.setAdapter(r19);
        L48:
            ALogger.i("AdjustGuestPositionDialog", "选中用户uid -> ".concat(r2));
            ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r21 = r1.r;
            Intrinsics.checkNotNullParameter(r21, "adapterList");
            if (r2.length() == 0) goto L53;
            r5 = false;
        L53:
            if (r5 == true) goto L61;
            int r22 = r21.size();
            int r23 = 0;
        L56:
            if (r23 >= r22) goto L61;
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.multilink.base.model.c0) ListProtector.get(r21, r23)).getUserId().toString(), r2) == true) goto L62;
            r23 = r23 + 1;
        L62:
            r1.n = r23;
            if (r23 != 10) goto L65;
            f2.c("麦位拉取失败，请重试", 0);
        L65:
            ALogger.i("AdjustGuestPositionDialog", "当前设置高亮位置 ： " + r1.n);
            AdjustGuestPositionListAdapter r24 = r1.i;
            if (r24 == null) goto L73;
            r24.d = r1.n;
            return;
        L73:
            return;
        L61:
            r23 = 10;
            goto L62
        L21:
            if (r14 != MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L42;
        L74:
            return;
        L7:
            if (r4 == MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L10;
            r13 = null;
            goto L16
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;

        public j(AdjustGuestPositionDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog, java.lang.Object] */
        public final void accept(Object r4) {
            CustomApiServerException r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "error");
            if ((r5 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r6 = r5;
            if (TextUtils.isEmpty(r6.getPrompt()) == true) goto L7;
            f2.c(r6.getPrompt(), 0);
        L7:
            int r0 = AdjustGuestPositionDialog.v;
            ALogger.e("AdjustGuestPositionDialog", String.valueOf(r6.getErrorCode()));
        L9:
            ?? r7 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r2 == null) goto L23;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L12:
            if (Looper.myLooper() == r1.getLooper()) goto L14;
            r1.post(DialogLancet.createDismissRunnable(r7));
            return;
        L8:
            int r3 = AdjustGuestPositionDialog.v;
            ALogger.e("AdjustGuestPositionDialog", r5.getMessage());
            goto L9
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;
        public final /* synthetic */ LinkmicAdjustPositionPingType b;

        public k(AdjustGuestPositionDialog r1, LinkmicAdjustPositionPingType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            if (this.b != LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel) goto L6;
            AdjustGuestPositionDialog r5 = this.a;
            ((g) r5.q.getValue()).removeCallbacksAndMessages(null);
            r5.r.clear();
            r5.k.dispose();
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ AdjustGuestPositionDialog a;
        public final /* synthetic */ LinkmicAdjustPositionPingType b;

        public l(AdjustGuestPositionDialog r1, LinkmicAdjustPositionPingType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            CustomApiServerException r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "error");
            if ((r4 instanceof CustomApiServerException) == false) goto L5;
            int r0 = AdjustGuestPositionDialog.v;
            ALogger.e("AdjustGuestPositionDialog", String.valueOf(r4.getErrorCode()));
        L7:
            if (this.b != LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel) goto L10;
            AdjustGuestPositionDialog r5 = this.a;
            ((g) r5.q.getValue()).removeCallbacksAndMessages(null);
            r5.r.clear();
            r5.k.dispose();
            return;
        L10:
            return;
        L5:
            int r1 = AdjustGuestPositionDialog.v;
            ALogger.e("AdjustGuestPositionDialog", r4.getMessage());
            goto L7
        }
    }

    static {
    }

    public final void c() {
        String r6 = b(this.f);
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (this.j != null) goto L12;
        return;
    L12:
        if (r2.a(r6) == false) goto L14;
        Disposable r1 = ((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).getPositionPanel(this.j.getId(), d5.c(r6), r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this), new j(this));
        this.k.add(r1);
    L14:
        g r2 = (g) this.q.getValue();
        if (r2 == null) goto L18;
        r2.sendEmptyMessageDelayed(5, 5000);
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        d(LinkmicAdjustPositionPingType.AdjustPositionPingType_Cancel);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public static String b(int r5) {
        List<T> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
        if (r0 != 0) goto L5;
        return "0";
    L5:
        int r2 = r0.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L21;
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) ListProtector.get(r0, r3);
        if (r4 == null) goto L20;
        if (r4.getUserPositionFlex() != r5) goto L20;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) ListProtector.get(r0, r3);
        if (r6 == null) goto L26;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L27;
        String r8 = r7.getIdString();
        if (r8 != null) goto L19;
        return "0";
    L19:
        return r8;
    L27:
        return "0";
    L26:
        return "0";
    L20:
        r3 = r3 + 1;
        goto L6
    L21:
        return "0";
    }

    public final int a(com.bytedance.android.livesdk.multilink.base.model.c0 r4) {
        Map<Long, PositionItem> r0 = this.p;
        if (r0 == null) goto L11;
        Iterator<Map.Entry<Long, PositionItem>> r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Map.Entry<Long, PositionItem> r2 = r1.next();
        if (r2.getValue().equals(r4) == false) goto L6;
        return (int) r2.getKey().longValue();
    L16:
        return 0;
    L11:
        return 0;
    }

    public final void d(LinkmicAdjustPositionPingType r5) {
        if (this.j != null) goto L5;
        return;
    L5:
        Disposable r6 = ((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).pingAdjustPosition(this.j.getId(), r5.ordinal()).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this, r5), new l(this, r5));
        this.k.add(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        HashMap r0 = new HashMap();
        if (r9 == null) goto L5;
        Integer r10 = Integer.valueOf(r9.getId());
    L6:
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.intValue() != 2131367648) goto L34;
        AdjustGuestPositionListAdapter r11 = this.i;
        if (r11 == null) goto L13;
        com.bytedance.android.livesdk.multilink.base.model.c0 r12 = r11.f;
    L14:
        if (r12 == null) goto L17;
        String r3 = b(this.m);
        r0.put(r3, String.valueOf(a(r12)));
        ALogger.i("AdjustGuestPositionDialog", "即将换位的用户uid -> " + r3 + ", 即将换位的位置 ——> " + a(r12));
        this.o = a(r12);
    L17:
        if (r12 == null) goto L27;
        int r13 = a(r12);
        int r4 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.f.a;
        int r5 = this.f;
        HashMap r6 = new HashMap();
        TalkRoomLogUtils.B0(r6, Integer.valueOf(je0.d.f()), null, 4);
        r6.put("seat_num", String.valueOf(r5));
        r6.put("to_seat_num", String.valueOf(r13));
        r6.put("is_guest", "1");
        Integer r14 = je0.d.h();
        if (r14 != null) goto L22;
    L24:
        String r15 = "classic";
    L25:
        r6.put("play_layout", r15);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_order_submit", r6, new Object[]{IRoom.class, am2.x.class});
        goto L27
    L22:
        if (r14.intValue() != 28) goto L24;
        r15 = "avatar";
    L27:
        if (this.j == null) goto L30;
        this.k.add(((LiveAdjustPositionApi) com.bytedance.android.live.network.c.b().e(LiveAdjustPositionApi.class)).adjustPosition(this.j.getId(), new JSONObject(r0).toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.a(this), new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.b(this)));
    L30:
        Button r16 = (Button) findViewById(2131367648);
        if (r16 == null) goto L35;
        r16.setEnabled(false);
        return;
    L35:
        return;
    L13:
        r12 = null;
        goto L14
    L34:
        return;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r19) {
        super/*android.app.Dialog*/.onCreate(r19);
        int r1 = this.b;
        if (yg0.h.i(this.c) == true) goto L5;
        int r2 = 0;
    L9:
        this.e = r2;
        ALogger.i("AdjustGuestPositionDialog", "当前布局 -> " + this.e);
        int r3 = this.e;
        if (r3 != MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal()) goto L12;
    L13:
        setContentView(LayoutInflater.from(getContext()).inflate(2131565439, null));
    L14:
        Window r4 = getWindow();
        if (r4 == null) goto L22;
        r4.setGravity(80);
        int r5 = s1.y();
        int r6 = s1.w();
        if (((Boolean) ya0.a.getValue()).booleanValue() == false) goto L20;
        if (r5 <= r6) goto L20;
        int r7 = (int) (r6 - UtilityKotlinExtentionsKt.h(this.u));
    L21:
        r4.setLayout(-1, r7);
    L20:
        r7 = -2;
    L22:
        this.t = findViewById(2131388772);
        Button r8 = (Button) findViewById(2131367648);
        this.g = r8;
        if (r8 == null) goto L25;
        r8.setOnClickListener(this);
    L25:
        this.h = findViewById(2131384914);
        Button r9 = this.g;
        if (r9 == null) goto L28;
        r9.setBackgroundResource(2131248785);
    L28:
        Button r10 = this.g;
        if (r10 == null) goto L31;
        r10.setEnabled(false);
    L31:
        int r11 = this.c;
        if (r11 != 21) goto L34;
        int r12 = 27;
    L36:
        if (yg0.h.i(r12) == false) goto L38;
        Triple r13 = new Triple(0, 0, "AdjustGuestPositionDialog#onCreate");
        ln0.a r14 = yg0.h.a;
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r12, 0, null, false, 0, false, null, r13, null, null, null, 894), new h(this), null);
        return;
    L38:
        c();
        return;
    L34:
        r12 = r11;
        goto L36
    L12:
        if (r3 != MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal()) goto L14;
    L5:
        if (r1 != 5) goto L7;
        r2 = MicPanelType.AUDIO_COMMON_WINDOW_LAYOUT.ordinal();
        goto L9
    L7:
        r2 = MicPanelType.VIDEO_COMMON_WINDOW_LAYOUT.ordinal();
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.adapter.b
    public final void onItemClick(int r2) {
        if (r2 != this.n) goto L10;
        Button r3 = this.g;
        if (r3 == null) goto L7;
        r3.setBackgroundResource(2131248785);
    L7:
        Button r4 = this.g;
        if (r4 == null) goto L17;
        r4.setEnabled(false);
        return;
    L17:
        return;
    L10:
        Button r5 = this.g;
        if (r5 == null) goto L13;
        r5.setBackgroundResource(2131248784);
    L13:
        Button r6 = this.g;
        if (r6 == null) goto L19;
        r6.setEnabled(true);
        return;
    }

    public AdjustGuestPositionDialog(Context r2, int r3, int r4, IRoom r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, true);
        this.b = r3;
        this.c = r4;
        this.f = r6;
        this.j = r5;
        CompositeDisposable r7 = new CompositeDisposable();
        this.k = r7;
        this.l = Disposables.disposed();
        this.q = LazyKt.lazy(new AdjustGuestPositionDialog$weakHandler$2(this));
        this.r = new ArrayList();
        this.u = 70;
        com.bytedance.live.datacontext.j r8 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r8 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r8.getValue();
        if (r9 == null) goto L11;
        BehaviorSubject r10 = r9.a();
        if (r10 == null) goto L11;
        Disposable r11 = r10.subscribe(new a(this), b.a);
        if (r11 == null) goto L11;
        r7.add(r11);
    L11:
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r12 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r12.getValue();
        if (r13 == null) goto L20;
        BehaviorSubject r14 = r13.a();
        if (r14 == null) goto L20;
        Disposable r15 = r14.subscribe(new c(this), d.a);
        if (r15 == null) goto L20;
        r7.add(r15);
    L20:
        TeamFightContext r16 = TeamFightContext.Companion.getContext();
        if (r16 == null) goto L29;
        com.bytedance.live.datacontext.k<StateMachine.c.b<com.bytedance.android.live.liveinteract.revenue.fight.e.b, com.bytedance.android.live.liveinteract.revenue.fight.e.a, Object>> r17 = r16.getStateChangeEffect();
        if (r17 == null) goto L29;
        PublishSubject r18 = r17.onEvent();
        if (r18 == null) goto L29;
        Disposable r19 = r18.subscribe(new e(this));
        if (r19 == null) goto L29;
        r7.add(r19);
    L29:
        this.s = true;
    }
}

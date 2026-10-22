package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.action.ActionManager;
import com.bytedance.android.livesdk.viewmodel.CommonGuideViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/CommonGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lqo1/a;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonGuideWidget extends LiveWidget implements ViewModelProvider.Factory, qo1.a {
    public com.bytedance.android.livesdk.chatroom.widget.n a;
    public CommonGuideViewModel b;
    public Room c;
    public com.bytedance.android.livesdk.message.model.k3 d;
    public final CompositeDisposable e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CommonGuideWidget a;

        public a(CommonGuideWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Pair r8 = (Pair) r7;
            CommonGuideViewModel.j r0 = (CommonGuideViewModel.j) r8.component1();
            CommonGuideViewModel.e r9 = (CommonGuideViewModel.j) r8.component2();
            CommonGuideWidget r1 = this.a;
            r1.getClass();
            if ((r9 instanceof CommonGuideViewModel.h) == false) goto L38;
            CommonGuideViewModel r10 = r1.b;
            if (r10 == null) goto L9;
            CommonGuideViewModel.g r11 = r10.getStateMachine();
            if (r11 == null) goto L9;
            CommonGuideViewModel.j r12 = r11.a;
        L11:
            if ((r12 instanceof CommonGuideViewModel.h) == false) goto L25;
            com.bytedance.android.livesdk.message.model.k3 r13 = ((CommonGuideViewModel.h) r12).a;
            if (r13 == null) goto L25;
            String r14 = r13.E();
            if (r14 == null) goto L25;
            if (tb1.c.c == false) goto L25;
            if (StringsKt.contains$default(r14, "webcast_audiotalk_invite", false, 2, null) == false) goto L23;
        L24:
            boolean r15 = true;
        L26:
            if (r15 == true) goto L50;
            r1.xq();
            com.bytedance.android.livesdk.chatroom.widget.n r16 = new com.bytedance.android.livesdk.chatroom.widget.n(((Widget) r1).context, r1.b);
            r1.a = r16;
            if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L45;
            DialogLancet.handleBlockedDialogShow(r16);
        L33:
            com.bytedance.android.livesdk.f.d().a();
            com.bytedance.android.livesdk.chatroom.widget.n r17 = r1.a;
            if (r17 == null) goto L36;
            r17.setOnDismissListener(a0.a);
        L36:
            com.bytedance.android.livesdk.log.u.l().sendLog("commonguide_show", r1.yq(), new Object[]{Room.class, am2.x.class});
            return;
        L45:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
        L32:
            DialogLancet.beforeDialogShow(r16);
            r16.show();
            DialogLancet.afterDialogShow(r16);
            goto L33
        L50:
            return;
        L23:
            if (StringsKt.contains$default(r14, "webcast_inroom_bigparty", false, 2, null) == true) goto L24;
        L25:
            r15 = false;
        L9:
            r12 = null;
            goto L11
        L38:
            if ((r9 instanceof CommonGuideViewModel.e) == false) goto L41;
            r1.xq();
            ActionManager.getInstance().action(r9.a);
            com.bytedance.android.livesdk.log.u.l().sendLog("commonguide_click", r1.yq(), new Object[]{Room.class, am2.x.class});
            return;
        L41:
            if ((r9 instanceof CommonGuideViewModel.f) == false) goto L49;
            r1.xq();
            return;
        }
    }

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final String getSpm() {
        return "a100.a100.a130";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final Map<String, String> yq() {
        Pair[] r0 = new Pair[4];
        Room r1 = this.c;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.id);
    L6:
        r0[0] = TuplesKt.to("room_id", String.valueOf(r3));
        IUserService r4 = jc1.k.f(IUserService.class);
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L11;
        String r6 = r5.n();
    L12:
        r0[1] = TuplesKt.to("user_id", String.valueOf(r6));
        Room r7 = this.c;
        if (r7 == null) goto L15;
        String r8 = r7.getOwnerUserIdString();
    L16:
        r0[2] = TuplesKt.to("anchor_id", String.valueOf(r8));
        com.bytedance.android.livesdk.message.model.k3 r9 = this.d;
        if (r9 == null) goto L19;
        r2 = Integer.valueOf(r9.getMessageType());
    L19:
        r0[3] = TuplesKt.to("message_type", String.valueOf(r2));
        return MapsKt.mapOf(r0);
    L15:
        r8 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final void xq() {
        com.bytedance.android.livesdk.chatroom.widget.n r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        this.a = null;
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        wq(r0);
        goto L7
    }

    public CommonGuideWidget() {
        this.e = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        this.c = (Room) r0.get("data_room", null);
    L5:
        CommonGuideViewModel r1 = getViewModel(CommonGuideViewModel.class, this);
        this.b = r1;
        if (r1 == null) goto L9;
        this.e.add(RxUtilKt.e(r1.getStateMachine().b).subscribe(new a(this)));
    L9:
        if (ho1.a.o(getComponentContext()) == false) goto L14;
        h70.b r2 = getComponentContext();
        if (r2 == null) goto L15;
        ho1.a.p(r2, qo1.a.class, this);
        return;
    L15:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.widget.n r0 = this.a;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        wq(r0);
    L8:
        if (this.e.isDisposed() == true) goto L10;
        this.e.dispose();
    L10:
        this.a = null;
        this.b = null;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r1 = getComponentContext();
        if (r1 == null) goto L14;
        ho1.a.q(r1, qo1.a.class);
        return;
    }

    public static void wq(com.bytedance.android.livesdk.chatroom.widget.n r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // qo1.a
    public final void Qf(com.bytedance.android.livesdk.message.model.k3 r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.d = r3;
        CommonGuideViewModel r0 = this.b;
        if (r0 == null) goto L6;
        r0.getStateMachine().a(new CommonGuideViewModel.d(r3));
        return;
    }

    public final <T extends ViewModel> T create(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "modelClass");
        return new CommonGuideViewModel();
    }
}

package com.bytedance.android.live.liveinteract.awemeplay;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/LiveAwemeVideoPlayWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveAwemeVideoPlayWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public final CompositeDisposable a;
    public boolean b;
    public final b c;
    public final FragmentManager d;
    public final d e;

    public static final class a {
    }

    public static final class b<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {
        public final /* synthetic */ LiveAwemeVideoPlayWidget a;

        public b(LiveAwemeVideoPlayWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
        L7:
            if (r3 != null) goto L10;
            return;
        L10:
            if (r3.intValue() != 2) goto L13;
        L11:
            LiveAwemeVideoPlayWidget r4 = this.a;
            int r0 = LiveAwemeVideoPlayWidget.f;
            r4.wq();
            return;
        L13:
            return;
        L6:
            if (r3.intValue() == 0) goto L11;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveAwemeVideoPlayWidget a;

        public c(LiveAwemeVideoPlayWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            if (r7.longValue() <= 0) goto L16;
            Context r0 = ((Widget) this.a).context;
            x0.d r1 = new x0.d();
            r1.b = r0;
            r1.a = 2;
            r1.k = false;
            x0 r2 = new x0(r1.b, r1);
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L14;
            DialogLancet.handleBlockedDialogShow(r2);
        L9:
            Disposable r8 = k.n(IMiddlewareHostBusiness.class).queryAweme(r7.longValue(), new com.bytedance.android.live.liveinteract.awemeplay.a(this, r2, r7));
            if (r8 == null) goto L17;
            RxUtilKt.c(r8, this.a.a);
            return;
        L17:
            return;
        L14:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L8:
            DialogLancet.beforeDialogShow(r2);
            r2.show();
            DialogLancet.afterDialogShow(r2);
            goto L9
        }
    }

    static {
    }

    public final void wq() {
        FragmentManager r0 = this.d;
        Fragment r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.findFragmentByTag("LiveAwemeVideoPlayWidget");
    L7:
        if ((r2 instanceof DialogFragment) == false) goto L10;
        r1 = r2;
    L10:
        DialogFragment r3 = (DialogFragment) r1;
        if (r3 == null) goto L21;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L22;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void onCreate() {
        super.onCreate();
        f.c(this);
        Boolean r0 = m.j(this).isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.b = r1;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L12;
        DataCenter r3 = r2.observe("cmd_dismiss_dialog_end", this);
        if (r3 == null) goto L12;
        r3.observe("cmd_on_live_end_fragment_show", this);
    L12:
        if (this.b == true) goto L14;
        hd0.c.f().c(this.c);
    L14:
        com.bytedance.live.datacontext.m r4 = m.j(this).k2();
        if (r4 == null) goto L22;
        Observable r5 = r4.a();
        if (r5 == null) goto L23;
        Disposable r6 = r5.subscribe(new c(this));
        if (r6 == null) goto L24;
        RxUtilKt.c(r6, this.a);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        f.d(this);
        if (this.b == true) goto L5;
        hd0.c.f().e(this.c);
    L5:
        this.a.dispose();
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L16;
        String r5 = r4.getKey();
        int r0 = r5.hashCode();
        if (r0 == (-774172322)) goto L13;
        if (r0 == (-170252752)) goto L10;
        return;
    L10:
        if (r5.equals("cmd_on_live_end_fragment_show") == false) goto L17;
    L14:
        wq();
        return;
    L17:
        return;
    L13:
        if (r5.equals("cmd_dismiss_dialog_end") == true) goto L14;
        return;
    }

    public LiveAwemeVideoPlayWidget(FragmentManager r1, d r2) {
        this.d = r1;
        this.e = r2;
        this.a = new CompositeDisposable();
        this.c = new b(this);
    }
}

package ha2;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.base.model.message.m3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.PSSelectedMessageApi;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.PSSelectedMessageDialog;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import ga2.e;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ PSSelectedMessageDialog a;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = ga2.d.a;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            ALogger.e("PSSelectedMessage", "Selected Message Status Update Failed. " + e.a(r4));
        }
    }

    public c(PSSelectedMessageDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        vlc.d r10 = (vlc.d) this.a.d.get("data_message_manager");
        if (r10 != null) goto L5;
        return;
    L5:
        m3 r0 = f.c(m3.class);
        r0.setStatus(2);
        r0.setSource("CloseEntry");
        r0.setToast(s1.B(2131922412));
        r10.j(r0, true);
        PSSelectedMessageApi.a.getClass();
        PSSelectedMessageApi r2 = (PSSelectedMessageApi) com.bytedance.android.live.network.c.b().e(PSSelectedMessageApi.class);
        if (r2 == null) goto L14;
        Observable<Response<Object>> r11 = r2.sendShowStatusChange(a0.n(this.a.d).getRoomId(), "only_switch", 2);
        if (r11 == null) goto L14;
        Observable r13 = r11.compose(RxUtil.rxSchedulerHelper());
        if (r13 == null) goto L14;
        Disposable r14 = r13.subscribe(a.a, b.a);
        if (r14 == null) goto L14;
        RxUtilKt.c(r14, this.a.e);
    L14:
        j0 r15 = j0.l();
        Pair[] r3 = new Pair[2];
        r3[0] = TuplesKt.to("click_type", "close");
        if (this.a.f.c() == false) goto L17;
        String r4 = "ai";
    L18:
        r3[1] = TuplesKt.to("selected_mode_type", r4);
        r15.sendLog("livesdk_selected_message_layer_click", MapsKt.mapOf(r3), new Object[]{IRoom.class, x.class});
        AppCompatDialog r16 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r16);
        if (r1 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(r16);
        r16.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(r16);
        return;
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r16);
        throw th;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r5 == null) goto L32;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
        goto L32
    L21:
        if (Looper.myLooper() == r1.getLooper()) goto L23;
        r1.post(DialogLancet.createDismissRunnable(r16));
        return;
    L17:
        r4 = "normal";
        goto L18
    }
}

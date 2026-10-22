package ha2;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.gift.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.PSSelectedMessageDialog;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ PSSelectedMessageDialog a;

    public b(PSSelectedMessageDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        SelectedMsgABHelper.h(this.a.getContext(), this.a.d, "suspension_layer", SelectedMsgABHelper.b().settingPageSchemaAi);
        j0 r7 = j0.l();
        Pair[] r1 = new Pair[2];
        r1[0] = TuplesKt.to("click_type", e.FETCH_FROM_SETTING);
        if (this.a.f.c() == false) goto L5;
        String r2 = "ai";
    L6:
        r1[1] = TuplesKt.to("selected_mode_type", r2);
        r7.sendLog("livesdk_selected_message_layer_click", MapsKt.mapOf(r1), new Object[]{IRoom.class, x.class});
        AppCompatDialog r8 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r8);
        if (r0 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r8);
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r0.getLooper()) goto L11;
        r0.post(DialogLancet.createDismissRunnable(r8));
        return;
    L5:
        r2 = "normal";
        goto L6
    }
}

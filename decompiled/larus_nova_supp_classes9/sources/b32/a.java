package b32;

import am2.x;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {

    /* JADX INFO: renamed from: b32.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0004a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ OnBindPhoneListener c;

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            r4.dismiss();
            Activity r6 = this.a;
            String r7 = this.b;
            k.f(IMiddlewareHostApp.class).startBindMobileFullFragment(r6, "live_detail", "live_detail", this.c);
            HashMap r8 = new HashMap();
            r8.put("bind_page_source", r7);
            j0.l().sendLog("livesdk_phone_bind_page_show", r8, new Object[]{new x(), IRoom.class});
        }

        public DialogInterfaceOnClickListenerC0004a(Activity r1, String r2, OnBindPhoneListener r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static void a(Activity r7, String r8, OnBindPhoneListener r9, View.OnClickListener r10) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r7);
        SpannableString r1 = new SpannableString(r7.getString(2131918889));
        r1.setSpan(new ForegroundColorSpan(r7.getResources().getColor(2131107745)), 1, 16, 33);
        TextView r2 = new TextView(r7);
        r2.setTextSize(1, 18.0f);
        r2.setText(r1);
        r2.setPadding(s1.f(30.0f), s1.f(20.0f), s1.f(30.0f), s1.f(10.0f));
        r2.setTextColor(-16777216);
        r2.setOnClickListener(r10);
        r0.setCustomTitle(r2).setNegativeButton(2131918887, new b()).setPositiveButton(2131918888, new DialogInterfaceOnClickListenerC0004a(r7, r8, r9)).setCancelable(false);
        AlertDialog r11 = r0.create();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r11);
    L7:
        r11.getButton(-1).setTextColor(r7.getResources().getColor(2131107745));
        r11.getButton(-2).setTextColor(r7.getResources().getColor(2131107654));
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L7
    }
}

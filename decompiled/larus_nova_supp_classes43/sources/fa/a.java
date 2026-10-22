package fa;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static String a;
    public static long b;
    public static String c;
    public static long d;

    static {
    }

    public static void b(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r11, a) == true) goto L10;
    L11:
        a = r11;
        b = System.currentTimeMillis();
        TextView r0 = new TextView(new ContextThemeWrapper(r10, 2131954088));
        r0.setBackground(r10.getResources().getDrawable(2131231339));
        r0.setText(r11);
        if (NotificationManagerCompat.from(r10).areNotificationsEnabled() == false) goto L17;
        Toast r12 = new Toast(r10);
        r12.setGravity(17, 0, 0);
        r12.setView(r0);
        r12.setDuration(0);
        r12.show();
        return;
    L17:
        Toast r13 = new Toast(r10);     // Catch: Throwable -> L16
        r13.setGravity(17, 0, 0);     // Catch: Throwable -> L16
        r13.setView(r0);     // Catch: Throwable -> L16
        r13.setDuration(0);     // Catch: Throwable -> L16
        r13.show();     // Catch: Throwable -> L16
        return;
    L23:
        return;
    L10:
        if ((System.currentTimeMillis() - b) >= 2500) goto L11;
    }

    public static void a(Context r10, String r11, Drawable r12) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        Intrinsics.checkNotNullParameter(r12, "img");
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r11, c) == true) goto L10;
    L11:
        c = r11;
        d = System.currentTimeMillis();
        View r0 = LayoutInflater.from(r10).inflate(2131558551, null);
        if (r0 == null) goto L23;
        ImageView r1 = (ImageView) r0.findViewById(2131388948);
        ((TextView) r0.findViewById(2131388953)).setText(r11);
        r1.setImageDrawable(r12);
        if (NotificationManagerCompat.from(r10).areNotificationsEnabled() == false) goto L19;
        Toast r13 = new Toast(r10);
        r13.setGravity(17, 0, 0);
        r13.setView(r0);
        r13.setDuration(0);
        r13.show();
        return;
    L19:
        Toast r14 = new Toast(r10);     // Catch: Throwable -> L18
        r14.setGravity(17, 0, 0);     // Catch: Throwable -> L18
        r14.setView(r0);     // Catch: Throwable -> L18
        r14.setDuration(0);     // Catch: Throwable -> L18
        r14.show();     // Catch: Throwable -> L18
        return;
    L26:
        return;
    L23:
        return;
    L10:
        if ((System.currentTimeMillis() - d) >= 2500) goto L11;
    }
}

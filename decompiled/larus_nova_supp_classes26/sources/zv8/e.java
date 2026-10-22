package zv8;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntranceType;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(final e r12) {
            Intrinsics.checkNotNullParameter(r12, "debugEntrance");
            AppHost.Companion r0 = AppHost.a;
            final Activity r1 = r0.a().getCurrentActivity();
            if (r1 == null) goto L32;
            String r2 = CollectionsKt.joinToString$default(r12.e(), ", ", null, null, 0, null, null, 62, null);
            View r3 = r1.getLayoutInflater().inflate(2131562018, null);
            if (r3 == null) goto L34;
            boolean r5 = true;
            final AlertDialog r4 = new AlertDialog.Builder(r1).setView(r3).setCancelable(true).show();
            TextView r6 = (TextView) r3.findViewById(2131368618);
            ImageView r7 = (ImageView) r3.findViewById(2131368617);
            int r8 = e.a;
            boolean r9 = aw8.c.b(r12);
            if (r9 == false) goto L10;
            int r10 = 2131901396;
        L11:
            if (r9 == false) goto L13;
            int r11 = 2131241918;
        L14:
            if (r6 == null) goto L16;
            r6.setText(r1.getString(r10));
        L16:
            if (r7 == null) goto L18;
            r7.setImageDrawable(AppCompatResources.getDrawable(r1, r11));
        L18:
            TextView r13 = (TextView) r3.findViewById(2131368615);
            if (r13 == null) goto L21;
            r13.setText("Owner：" + r2);
        L21:
            LinearLayout r14 = (LinearLayout) r3.findViewById(2131368616);
            if (r0.isOversea() == true) goto L25;
        L28:
            if (r5 == true) goto L30;
            r14.setVisibility(8);
            return;
        L30:
            r14.setVisibility(0);
            r14.setOnClickListener(new c(r12, r4, r1));
            return;
        L25:
            if (r0.isTestChannel() == true) goto L28;
            r5 = false;
            goto L28
        L13:
            r11 = 2131241924;
            goto L14
        L10:
            r10 = 2131901395;
            goto L11
        L34:
            return;
        }
    }

    static {
    }

    public e() {
    }

    public void a() {
    }

    public abstract EntranceGroup b();

    public abstract String c();

    public abstract EntranceType d();

    public abstract List<String> e();

    public final String toString() {
        return "DebugEntrance(group: " + b() + ", name: " + c() + ", owner: " + CollectionsKt.joinToString$default(e(), null, null, null, 0, null, null, 63, null) + ')';
    }
}

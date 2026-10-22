package s62;

import ak6.g;
import am2.x;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ak6.e {
    public final /* synthetic */ s62.a a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ View c;

    public static final class a implements PopupWindow.OnDismissListener {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            this.a.a.d = null;
        }
    }

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    public final void b(g r11) {
        Intrinsics.checkNotNullParameter(r11, "rendResult");
        this.b.setText(r11.a);
        ImageView r13 = (ImageView) this.c.findViewById(2131364900);
        LinearLayout r0 = (LinearLayout) this.c.findViewById(2131364929);
        int[] r2 = new int[2];
        View r3 = this.a.i;
        if (r3 == null) goto L5;
        r3.getLocationOnScreen(r2);
    L5:
        int r4 = r2[0] + UtilityKotlinExtentionsKt.i(10);
        a1.m(r13, r4);
        r0.measure(0, 0);
        int r14 = r0.getMeasuredWidth();
        if (r14 <= ((UtilityKotlinExtentionsKt.i(20) + r4) + UtilityKotlinExtentionsKt.i(10))) goto L8;
        a1.m(r0, UtilityKotlinExtentionsKt.i(12));
    L9:
        int r15 = k22.a.a;
        HashMap r1 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("answer_type", "text")});
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L15;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L15;
        String r7 = r6.n();
        if (r7 == null) goto L15;
    L16:
        r1.put("user_id", r7);
        j0.l().sendLog("livesdk_ai_qa_function_guidance_show", r1, new Object[]{IRoom.class, x.class});
        k22.a.b("live_format_guidance");
        s62.a r16 = this.a;
        View r8 = r16.i;
        if (r8 == null) goto L25;
        yo2.e r9 = new yo2.e(r16.g);
        ((yo2.d) r9).d = this.c;
        ((yo2.d) r9).e = 0;
        ((yo2.d) r9).m = 5;
        ((yo2.d) r9).f = false;
        ((yo2.d) r9).g = false;
        r9.a();
        r16.d = r9;
        yo2.e r10 = this.a.d;
        if (r10 == null) goto L21;
        r10.i(r8, 1, 1, 0, UtilityKotlinExtentionsKt.i(2));
    L21:
        yo2.e r17 = this.a.d;
        if (r17 == null) goto L26;
        ((yo2.d) r17).k = new a(this);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r7 = BuildConfig.FLAVOR;
        goto L16
    L8:
        a1.m(r0, ((r4 + UtilityKotlinExtentionsKt.i(20)) + UtilityKotlinExtentionsKt.i(10)) - r14);
        goto L9
    }

    public e(s62.a r1, TextView r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}

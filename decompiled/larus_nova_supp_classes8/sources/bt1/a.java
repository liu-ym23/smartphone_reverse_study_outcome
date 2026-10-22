package bt1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.ui.GradientTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends Dialog {
    public final View a;
    public final TextView b;
    public final Button c;
    public g d;
    public final int[] e;
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.a f;

    /* JADX INFO: renamed from: bt1.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0009a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0009a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            g r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            g r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.c();
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            g r2 = this.a.d;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class d {
    }

    public static final class e implements GradientTextView.a {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final LinearGradient a(int r9, int r10) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, r10, this.a.e, null, Shader.TileMode.CLAMP);
        }
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.d = null;
        com.bytedance.android.livesdk.f.d().f();
    }

    public final void a(long r11) {
        TextView r0 = this.b;
        int r1 = LiveResUtil.getColor(2131107039);     // Catch: Throwable -> L5
        SpannableStringBuilder r2 = new SpannableStringBuilder();     // Catch: Throwable -> L5
        r2.append("就剩");     // Catch: Throwable -> L5
        int r3 = r2.length();     // Catch: Throwable -> L5
        r2.append(String.valueOf(r11) + "秒");     // Catch: Throwable -> L5
        r2.setSpan(new ForegroundColorSpan(r1), r3, r2.length(), 33);     // Catch: Throwable -> L5
        r2.append("即可膨胀为");     // Catch: Throwable -> L5
        int r12 = r2.length();     // Catch: Throwable -> L5
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.coupon.util.a r4 = com.bytedance.android.livesdk.coupon.util.a.a;     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r5 = this.f;     // Catch: Throwable -> L5
        long r6 = r5.a + r5.d.c();     // Catch: Throwable -> L5
        r4.getClass();     // Catch: Throwable -> L5
        r13.append(com.bytedance.android.livesdk.coupon.util.a.a(r6));     // Catch: Throwable -> L5
        r13.append("元");     // Catch: Throwable -> L5
        r2.append(r13.toString());     // Catch: Throwable -> L5
        r2.setSpan(new ForegroundColorSpan(r1), r12, r2.length(), 33);     // Catch: Throwable -> L5
    L7:
        r0.setText(r2);
        return;
    L5:
        th = move-exception;
        ALogger.e("ExpandCouponCloseRoomDialog", "createCouponTitle error " + Log.getStackTraceString(th));
        r2 = null;
        goto L7
    }

    public a(Context r17, com.bytedance.android.livesdk.coupon.expandcoupon.model.a r18, long r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "couponData");
        super(r17, 2131954668);
        this.f = r18;
        View r1 = LayoutInflater.from(r17).inflate(2131565950, null);
        this.a = r1;
        this.b = (TextView) r1.findViewById(2131390449);
        Button r3 = (Button) r1.findViewById(2131364710);
        Button r4 = (Button) r1.findViewById(2131367906);
        this.c = r4;
        TextView r5 = (TextView) r1.findViewById(2131390723);
        TextView r6 = (TextView) r1.findViewById(2131390719);
        GradientTextView r7 = r1.findViewById(2131390725);
        GradientTextView r8 = r1.findViewById(2131390721);
        GradientTextView r9 = r1.findViewById(2131390724);
        GradientTextView r10 = r1.findViewById(2131390720);
        this.e = new int[]{LiveResUtil.getColor(2131107444), LiveResUtil.getColor(2131107443), LiveResUtil.getColor(2131107442)};
        e r11 = new e(this);
        setContentView(r1);
        r4.setOnClickListener(new ViewOnClickListenerC0009a(this));
        r3.setOnClickListener(new b(this));
        setOnCancelListener(new c(this));
        com.bytedance.android.livesdk.coupon.util.a r12 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r14 = r18.b;
        r12.getClass();
        r5.setText(LiveResUtil.getString(2131916519, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r14)}));
        r6.setText(LiveResUtil.getString(2131916519, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r18.b + r18.d.b())}));
        r7.setLinearGradientCreator(r11);
        r8.setLinearGradientCreator(r11);
        r9.setLinearGradientCreator(r11);
        r10.setLinearGradientCreator(r11);
        r9.setText(com.bytedance.android.livesdk.coupon.util.a.a(r18.a));
        r10.setText(com.bytedance.android.livesdk.coupon.util.a.a(r18.a + r18.d.c()));
        a(r19);
    }
}

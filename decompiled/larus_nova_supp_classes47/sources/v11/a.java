package v11;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import qr2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {

    /* JADX INFO: renamed from: v11.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0331a implements View.OnClickListener {
        public final /* synthetic */ TextView a;

        public ViewOnClickListenerC0331a(TextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            c r3 = vh6.c.b(c.class);
            if (r3 == null) goto L6;
            r3.openMockLinkDialog(this.a.getContext());
            return;
        }
    }

    public static final void a(ViewGroup r4) {
        if (r4 == null) goto L5;
        TextView r0 = new TextView(r4.getContext());
        r0.setText("连");
        r0.setTextSize(UtilityKotlinExtentionsKt.h(12));
        r0.setGravity(17);
        r0.setBackgroundColor(ColorProtector.parseColor("#33ffffff"));
        r0.setOnClickListener(new ViewOnClickListenerC0331a(r0));
        Unit r1 = Unit.INSTANCE;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(48), UtilityKotlinExtentionsKt.i(48));
        r2.gravity = 21;
        r2.rightMargin = UtilityKotlinExtentionsKt.i(16);
        r4.addView(r0, r2);
        return;
    }
}

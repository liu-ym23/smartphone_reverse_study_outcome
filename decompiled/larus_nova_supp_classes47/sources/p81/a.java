package p81;

import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ViewSwitcher.ViewFactory {
    public final /* synthetic */ SimpleIndicatorTextSwitcher2 a;
    public final /* synthetic */ String b;

    /* JADX INFO: renamed from: p81.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0291a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0291a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            SimpleIndicatorTextSwitcher2 r0 = this.a.a;
            d r1 = (d) ListProtector.get(r0.b, r0.getCurrentIndex());
            if (r1 == null) goto L8;
            View.OnClickListener r2 = r1.b;
            if (r2 == null) goto L9;
            r2.onClick(r3);
            return;
        L9:
            return;
        }
    }

    public a(SimpleIndicatorTextSwitcher2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public final View makeView() {
        TextView r0 = new TextView(this.a.getContext());
        r0.setSingleLine(true);
        r0.setLines(1);
        r0.setSingleLine();
        r0.setText(this.b);
        this.a.a.getClass();
        r0.setTextSize(1, 13.0f);
        this.a.a.getClass();
        r0.setTextColor(-1);
        r0.setGravity(this.a.a.a);
        r0.setIncludeFontPadding(false);
        r0.setOnClickListener(new ViewOnClickListenerC0291a(this));
        return r0;
    }
}

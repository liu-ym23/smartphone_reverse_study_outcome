package ea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.annie.view.WebRiskHintView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ WebRiskHintView a;
    public final /* synthetic */ String b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ WebRiskHintView a;

        public a(WebRiskHintView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ViewGroup r11 = this.a.c;
            if (r11 == null) goto L7;
            r11.setVisibility(8);
            return;
        }
    }

    public b(WebRiskHintView r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        WebRiskHintView r0 = this.a;
        r0.c = (ViewGroup) LayoutInflater.from(r0.getContext()).inflate(2131558560, this.a);
        WebRiskHintView r1 = this.a;
        ViewGroup r10 = r1.c;
        ImageView r11 = null;
        if (r10 == null) goto L5;
        TextView r12 = (TextView) r10.findViewById(2131362985);
    L6:
        r1.a = r12;
        WebRiskHintView r13 = this.a;
        ViewGroup r14 = r13.c;
        if (r14 == null) goto L9;
        r11 = (ImageView) r14.findViewById(2131362983);
    L9:
        r13.b = r11;
        WebRiskHintView r15 = this.a;
        ImageView r16 = r15.b;
        if (r16 == null) goto L12;
        r16.setOnClickListener(new a(r15));
    L12:
        TextView r17 = this.a.a;
        if (r17 == null) goto L17;
        r17.setText(this.b);
        return;
    L17:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

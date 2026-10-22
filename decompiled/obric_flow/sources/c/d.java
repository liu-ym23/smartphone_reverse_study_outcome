package c;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressDetail;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.Adapter<C0009d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1033b;

    /* JADX INFO: renamed from: c.d$d, reason: collision with other inner class name */
    public static class C0009d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f1034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f1035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f1036c;
        public final ImageView d;

        public C0009d(View r5) {
            super(r5);
            this.d = (ImageView) r5.findViewById(R.id.detail_line_bottom);
            this.f1034a = (ImageView) r5.findViewById(R.id.detail_circle);
            this.f1035b = (TextView) r5.findViewById(R.id.detail_status);
            this.f1036c = (TextView) r5.findViewById(R.id.detail_time);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f1033b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        C0009d r12 = (C0009d) r10;
        ArrayList r5 = this.f1033b;
        String r13 = ((ExpressDetail.Detail) r5.get(r11)).getDesc();
        if (r13.length() < 45) goto L5;
        r13 = r13.substring(0, 45) + "...";
    L5:
        ArrayList r14 = s.f1081a;
        Matcher r15 = Pattern.compile("[1][3456789]\\d{9}").matcher(r13);
        if (r15.find() == false) goto L8;
        m.i("ExpressUtils", "getTelNumber: " + r15.group());
        String r16 = r15.group();
    L9:
        f r17 = this.f1032a;
        if (r16 != null) goto L12;
        r12.f1035b.setText(r13);
    L13:
        String r18 = ((ExpressDetail.Detail) r5.get(r11)).getTime();
        TextView r19 = r12.f1036c;
        r19.setText(r18);
        TextView r20 = r12.f1035b;
        ImageView r21 = r12.f1034a;
        if (r11 != 0) goto L16;
        r21.setImageResource(R.drawable.express_shape_circle_logistics_green);
        RelativeLayout.LayoutParams r110 = new RelativeLayout.LayoutParams((int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle), (int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle));
        r110.addRule(14);
        r21.setLayoutParams(r110);
        r19.setTextColor(r17.getResources().getColor(R.color.express_detail_color));
        r20.setTextColor(r17.getResources().getColor(R.color.express_detail_color));
        return;
    L16:
        int r22 = r5.size() - 1;
        ImageView r111 = r12.d;
        if (r11 != r22) goto L19;
        r20.setTextColor(r17.getResources().getColor(R.color.express_detail_default_color));
        r19.setTextColor(r17.getResources().getColor(R.color.express_detail_default_color));
        r21.setImageResource(R.drawable.express_shape_circle_logistics_gray);
        RelativeLayout.LayoutParams r23 = new RelativeLayout.LayoutParams((int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle), (int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle));
        r23.addRule(14);
        r21.setLayoutParams(r23);
        r111.setVisibility(8);
        return;
    L19:
        r20.setTextColor(r17.getResources().getColor(R.color.express_detail_default_color));
        r19.setTextColor(r17.getResources().getColor(R.color.express_detail_default_color));
        r21.setImageResource(R.drawable.express_shape_circle_logistics_gray);
        RelativeLayout.LayoutParams r24 = new RelativeLayout.LayoutParams((int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle), (int) r17.getResources().getDimension(R.dimen.express_jd_detail_circle));
        r24.addRule(14);
        r21.setLayoutParams(r24);
        RelativeLayout.LayoutParams r25 = new RelativeLayout.LayoutParams((int) r17.getResources().getDimension(R.dimen.express_jd_detail_line), -1);
        r25.addRule(3, R.id.detail_circle);
        r25.addRule(13);
        r111.setLayoutParams(r25);
        r111.setVisibility(0);
        return;
    L12:
        SpannableString r26 = new SpannableString(r13);
        r26.setSpan(new g(this, r16), r13.indexOf(r16), r13.indexOf(r16) + 11, 33);
        r26.setSpan(new ForegroundColorSpan(r17.getResources().getColor(R.color.express_span_color)), r13.indexOf(r16), r13.indexOf(r16) + 11, 33);
        r12.f1035b.setText(r26);
        r12.f1035b.setMovementMethod(LinkMovementMethod.getInstance());
        goto L13
    L8:
        r16 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r10) {
        return new C0009d(LayoutInflater.from(this.f1032a).inflate(R.layout.express_detail_item, r5, false));
    }
}

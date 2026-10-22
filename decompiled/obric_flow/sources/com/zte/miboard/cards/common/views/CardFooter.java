package com.zte.miboard.cards.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import c.k0;
import com.obric.oui.button.OButton;
import com.zte.miboard.cards.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CardFooter extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OButton f16241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f16242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OButton f16243c;
    private View d;
    private OButton e;
    private a f;

    public interface a {
        void a(@NonNull View r5);

        @Nullable
        ArrayList<String> getCardFooterMoreTexts();

        @Nullable
        int[] getMoreBtnTextIds();
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16244a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f16245b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f16246c = null;
        public static final b d = null;
        private static final /* synthetic */ b[] e = null;

        static {
            f16244a = new b("NONE", 0);
            f16245b = new b("LEFT", 1);
            f16246c = new b("LEFT_RIGHT", 2);
            d = new b("LEFT_MIDDLE_RIGHT", 3);
            e = a();
        }

        private b(String r5, int r10) {
            super(r5, r10);
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f16244a, f16245b, f16246c, d};
        }

        public static b valueOf(String r5) {
            return (b) Enum.valueOf(b.class, r5);
        }

        public static b[] values() {
            return (b[]) e.clone();
        }
    }

    public CardFooter(@NonNull Context r5) {
        this(r5, null);
    }

    private b getFooterState() {
        a r5 = this.f;
        ArrayList<String> r10 = null;
        if (r5 == null) goto L5;
        int[] r11 = r5.getMoreBtnTextIds();
    L6:
        a r12 = this.f;
        if (r12 == null) goto L10;
        r10 = r12.getCardFooterMoreTexts();
    L10:
        if (r10 != null) goto L12;
        if (r11 == null) goto L41;
        if (r11.length != 1) goto L31;
        return b.f16245b;
    L31:
        if (r11.length != 2) goto L35;
        return b.f16246c;
    L35:
        if (r11.length != 3) goto L39;
        return b.d;
    L39:
        return b.f16244a;
    L41:
        return b.f16244a;
    L12:
        if (r10.size() != 1) goto L16;
        return b.f16245b;
    L16:
        if (r10.size() != 2) goto L20;
        return b.f16246c;
    L20:
        if (r10.size() != 3) goto L24;
        return b.d;
    L24:
        return b.f16244a;
    L5:
        r11 = null;
        goto L6
    }

    public void a(View r5) {
        a r10 = this.f;
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        OButton r5 = (OButton) findViewById(R.id.card_footer_title_left);
        this.f16241a = r5;
        r5.setOnClickListener(new ar.a(this, 19));
        this.f16242b = findViewById(R.id.card_footer_divider_left);
        OButton r10 = (OButton) findViewById(R.id.card_footer_title_middle);
        this.f16243c = r10;
        r10.setOnClickListener(new ar.a(this, 19));
        this.d = findViewById(R.id.card_footer_divider_middle);
        OButton r11 = (OButton) findViewById(R.id.card_footer_title_right);
        this.e = r11;
        r11.setOnClickListener(new ar.a(this, 19));
    }

    public void setCallback(a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f = r5;
        a();
    }

    public CardFooter(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public void a() {
        a r5 = this.f;
        if (r5 != null) goto L5;
        return;
    L5:
        int[] r10 = r5.getMoreBtnTextIds();
        if (r10 == null) goto L8;
        a(r10);
    L11:
        b r11 = getFooterState();
        b r12 = b.f16244a;
        int r13 = 0;
        if (r12.equals(r11) == false) goto L16;
        this.f16241a.setVisibility(8);
    L14:
        this.f16242b.setVisibility(8);
        this.f16243c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    L25:
        this.f16242b.setVisibility(8);
        this.d.setVisibility(8);
        if (r12.equals(r11) == false) goto L28;
        r13 = 8;
    L28:
        setVisibility(r13);
        return;
    L16:
        if (b.f16246c.equals(r11) == false) goto L20;
        this.f16241a.setVisibility(0);
        this.f16242b.setVisibility(0);
        this.f16243c.setVisibility(8);
        this.d.setVisibility(8);
    L18:
        this.e.setVisibility(0);
        goto L25
    L20:
        if (b.f16245b.equals(r11) == false) goto L23;
        this.f16241a.setVisibility(0);
        goto L14
    L23:
        if (b.d.equals(r11) == false) goto L25;
        this.f16241a.setVisibility(0);
        this.f16242b.setVisibility(0);
        this.f16243c.setVisibility(0);
        this.d.setVisibility(0);
        goto L18
    L8:
        ArrayList<String> r14 = this.f.getCardFooterMoreTexts();
        if (r14 == null) goto L11;
        a(r14);
        goto L11
    }

    public CardFooter(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    private void a(ArrayList<String> r10) {
        if (this.f != null) goto L5;
        return;
    L5:
        ArrayList r5 = new ArrayList(r10);
        r10.clear();
        Iterator r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        String r12 = (String) r11.next();
        if (r12 == null) goto L7;
        r10.add(r12.toUpperCase());
        goto L7
    L12:
        if (r10.size() != 3) goto L16;
        this.f16241a.setText(r10.get(0));
        this.f16241a.setVisibility(0);
        this.f16242b.setVisibility(0);
        this.f16243c.setText(r10.get(1));
        this.f16243c.setVisibility(0);
        this.d.setVisibility(0);
        OButton r13 = this.e;
        String r14 = r10.get(2);
    L14:
        r13.setText(r14);
        this.e.setVisibility(0);
    L24:
        this.f16242b.setVisibility(8);
        this.d.setVisibility(8);
        String r15 = k0.f1060a;
        return;
    L16:
        if (r10.size() != 2) goto L19;
        this.f16241a.setText(r10.get(0));
        this.f16241a.setVisibility(0);
        this.f16242b.setVisibility(0);
        this.f16243c.setVisibility(8);
        this.d.setVisibility(8);
        r13 = this.e;
        r14 = r10.get(1);
        goto L14
    L19:
        if (r10.size() != 1) goto L24;
        if (getFooterState().equals(b.f16245b) == false) goto L23;
        this.f16241a.setText(r10.get(0));
        this.f16241a.setVisibility(0);
        this.f16242b.setVisibility(8);
        this.e.setVisibility(8);
        this.f16243c.setVisibility(8);
        this.d.setVisibility(8);
        goto L24
    L23:
        this.f16241a.setVisibility(8);
        this.f16242b.setVisibility(8);
        this.f16243c.setVisibility(8);
        this.d.setVisibility(8);
        r13 = this.e;
        r14 = r10.get(0);
        goto L14
    }

    private void a(int[] r10) {
        ArrayList<String> r5 = new ArrayList();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r13 = r10[r12];
        r5.add(getResources().getString(r13));
        r12 = r12 + 1;
        goto L3
    L5:
        a(r5);
    }
}

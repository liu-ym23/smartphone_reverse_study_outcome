package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.obric.cae.R;
import j0.h0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d extends o {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AlertController f641p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlertController.b f642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f643b;

        public a(Context r8) {
            int r10 = d.d(r8, 0);
            this.f642a = new AlertController.b(new ContextThemeWrapper(r8, d.d(r8, r10)));
            this.f643b = r10;
        }

        public final d a() {
            AlertController.b r8 = this.f642a;
            d r10 = new d(r8.f562a, this.f643b);
            View r11 = r8.f566e;
            AlertController r12 = r10.f641p;
            if (r11 == null) goto L5;
            r12.f549o = r11;
        L16:
            if (r8.f568g == null) goto L32;
            int r13 = r12.f553s;
            AlertController.RecycleListView r14 = (AlertController.RecycleListView) r8.f563b.inflate(r13, null);
            if (r8.f570i == false) goto L20;
            int r15 = r12.f554t;
        L21:
            ListAdapter r16 = r8.f568g;
            if (r16 != null) goto L25;
            r16 = new AlertController.d(r8.f562a, r15);
        L25:
            r12.f550p = r16;
            r12.f551q = r8.f571j;
            if (r8.f569h == null) goto L29;
            r14.setOnItemClickListener(new c(r8, r12));
        L29:
            if (r8.f570i == false) goto L31;
            r14.setChoiceMode(1);
        L31:
            r12.f539e = r14;
            goto L32
        L20:
            r15 = r12.f555u;
        L32:
            r10.setCancelable(true);
            r10.setCanceledOnTouchOutside(true);
            r10.setOnCancelListener(null);
            r10.setOnDismissListener(null);
            DialogInterface.OnKeyListener r17 = r8.f567f;
            if (r17 == null) goto L35;
            r10.setOnKeyListener(r17);
        L35:
            return r10;
        L5:
            CharSequence r18 = r8.f565d;
            if (r18 == null) goto L10;
            r12.f538d = r18;
            TextView r19 = r12.f547m;
            if (r19 == null) goto L10;
            r19.setText(r18);
        L10:
            Drawable r20 = r8.f564c;
            if (r20 == null) goto L16;
            r12.f545k = r20;
            r12.f544j = 0;
            ImageView r21 = r12.f546l;
            if (r21 == null) goto L16;
            r21.setVisibility(0);
            r12.f546l.setImageDrawable(r20);
            goto L16
        }
    }

    public d(Context r8, int r10) {
        super(r8, d(r8, r10));
        this.f641p = new AlertController(getContext(), this, getWindow());
    }

    public static int d(Context r8, int r10) {
        if (((r10 >>> 24) & 255) < 1) goto L5;
        return r10;
    L5:
        TypedValue r11 = new TypedValue();
        r8.getTheme().resolveAttribute(R.attr.alertDialogTheme, r11, true);
        return r11.resourceId;
    }

    @Override // androidx.appcompat.app.o, androidx.activity.l, android.app.Dialog
    public final void onCreate(Bundle r17) {
        super.onCreate(r17);
        AlertController r8 = this.f641p;
        r8.f536b.setContentView(r8.f552r);
        Window r10 = r8.f537c;
        View r11 = r10.findViewById(R.id.parentPanel);
        View r12 = r11.findViewById(R.id.topPanel);
        View r13 = r11.findViewById(R.id.contentPanel);
        View r14 = r11.findViewById(R.id.buttonPanel);
        ViewGroup r15 = (ViewGroup) r11.findViewById(R.id.customPanel);
        r10.setFlags(131072, 131072);
        r15.setVisibility(8);
        View r16 = r15.findViewById(R.id.topPanel);
        View r18 = r15.findViewById(R.id.contentPanel);
        View r19 = r15.findViewById(R.id.buttonPanel);
        ViewGroup r20 = AlertController.a(r16, r12);
        ViewGroup r21 = AlertController.a(r18, r13);
        ViewGroup r22 = AlertController.a(r19, r14);
        NestedScrollView r23 = (NestedScrollView) r10.findViewById(R.id.scrollView);
        r8.f543i = r23;
        int r24 = 0;
        r23.setFocusable(false);
        r8.f543i.setNestedScrollingEnabled(false);
        TextView r25 = (TextView) r21.findViewById(android.R.id.message);
        r8.f548n = r25;
        if (r25 == null) goto L9;
        r25.setVisibility(8);
        r8.f543i.removeView(r8.f548n);
        if (r8.f539e == null) goto L8;
        ViewGroup r26 = (ViewGroup) r8.f543i.getParent();
        int r110 = r26.indexOfChild(r8.f543i);
        r26.removeViewAt(r110);
        r26.addView(r8.f539e, r110, new ViewGroup.LayoutParams(-1, -1));
        goto L9
    L8:
        r21.setVisibility(8);
    L9:
        Button r27 = (Button) r22.findViewById(android.R.id.button1);
        r8.f540f = r27;
        AlertController.a r111 = r8.f558x;
        r27.setOnClickListener(r111);
        if (TextUtils.isEmpty(null) == false) goto L12;
        r8.f540f.setVisibility(8);
        int r112 = 0;
    L13:
        Button r113 = (Button) r22.findViewById(android.R.id.button2);
        r8.f541g = r113;
        r113.setOnClickListener(r111);
        if (TextUtils.isEmpty(null) == false) goto L16;
        r8.f541g.setVisibility(8);
    L17:
        Button r114 = (Button) r22.findViewById(android.R.id.button3);
        r8.f542h = r114;
        r114.setOnClickListener(r111);
        if (TextUtils.isEmpty(null) == false) goto L20;
        r8.f542h.setVisibility(8);
    L21:
        TypedValue r115 = new TypedValue();
        r8.f535a.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, r115, true);
        if (r115.data == 0) goto L24;
        boolean r116 = true;
    L26:
        if (r116 == false) goto L35;
        if (r112 != 1) goto L29;
        Button r117 = r8.f540f;
    L34:
        LinearLayout.LayoutParams r118 = (LinearLayout.LayoutParams) r117.getLayoutParams();
        r118.gravity = 1;
        r118.weight = 0.5f;
        r117.setLayoutParams(r118);
        goto L35
    L29:
        if (r112 != 2) goto L32;
        r117 = r8.f541g;
        goto L34
    L32:
        if (r112 != 4) goto L35;
        r117 = r8.f542h;
    L35:
        if (r112 == 0) goto L37;
        boolean r119 = true;
    L38:
        if (r119 == true) goto L41;
        r22.setVisibility(8);
    L41:
        if (r8.f549o == null) goto L43;
        r20.addView(r8.f549o, 0, new ViewGroup.LayoutParams(-1, -2));
        r10.findViewById(R.id.title_template).setVisibility(8);
    L56:
        if (r15.getVisibility() == 8) goto L58;
        boolean r28 = true;
    L59:
        if (r20 != null) goto L61;
    L63:
        int r29 = 0;
    L65:
        if (r22.getVisibility() == 8) goto L67;
        boolean r30 = true;
    L68:
        if (r30 == true) goto L72;
        View r31 = r21.findViewById(R.id.textSpacerNoButtons);
        if (r31 == null) goto L72;
        r31.setVisibility(0);
    L72:
        if (r29 == 0) goto L82;
        NestedScrollView r32 = r8.f543i;
        if (r32 == null) goto L77;
        r32.setClipToPadding(true);
    L77:
        if (r8.f539e == null) goto L79;
        View r33 = r20.findViewById(R.id.titleDividerNoCustom);
    L80:
        if (r33 == null) goto L85;
    L81:
        r33.setVisibility(0);
    L85:
        AlertController.RecycleListView r34 = r8.f539e;
        if ((r34 instanceof AlertController.RecycleListView) == false) goto L99;
        r34.getClass();
        if (r30 == false) goto L90;
        if (r29 != 0) goto L99;
    L90:
        int r35 = r34.getPaddingLeft();
        if (r29 == 0) goto L93;
        int r120 = r34.getPaddingTop();
    L94:
        int r121 = r34.getPaddingRight();
        if (r30 == false) goto L97;
        int r122 = r34.getPaddingBottom();
    L98:
        r34.setPadding(r35, r120, r121, r122);
        goto L99
    L97:
        r122 = r34.f560b;
        goto L98
    L93:
        r120 = r34.f559a;
    L99:
        if (r28 == true) goto L112;
        View r36 = r8.f539e;
        if (r36 != null) goto L104;
        r36 = r8.f543i;
    L104:
        if (r36 == null) goto L112;
        if (r30 == false) goto L107;
        r24 = 2;
    L107:
        int r37 = r29 | r24;
        View r38 = r10.findViewById(R.id.scrollIndicatorUp);
        View r39 = r10.findViewById(R.id.scrollIndicatorDown);
        WeakHashMap<View, h0> r40 = j0.w.f8437a;
        j0.w.j.d(r36, r37, 3);
        if (r38 == null) goto L110;
        r21.removeView(r38);
    L110:
        if (r39 == null) goto L112;
        r21.removeView(r39);
    L112:
        AlertController.RecycleListView r41 = r8.f539e;
        if (r41 == null) goto L120;
        ListAdapter r42 = r8.f550p;
        if (r42 == null) goto L121;
        r41.setAdapter(r42);
        int r43 = r8.f551q;
        if (r43 <= (-1)) goto L122;
        r41.setItemChecked(r43, true);
        r41.setSelection(r43);
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L79:
        r33 = null;
        goto L80
    L82:
        r33 = r21.findViewById(R.id.textSpacerNoTitle);
        if (r33 == null) goto L85;
    L67:
        r30 = false;
        goto L68
    L61:
        if (r20.getVisibility() == 8) goto L63;
        r29 = 1;
        goto L65
    L58:
        r28 = false;
        goto L59
    L43:
        r8.f546l = (ImageView) r10.findViewById(android.R.id.icon);
        if ((!TextUtils.isEmpty(r8.f538d)) == true) goto L46;
    L54:
        r10.findViewById(R.id.title_template).setVisibility(8);
        r8.f546l.setVisibility(8);
        r20.setVisibility(8);
        goto L56
    L46:
        if (r8.f556v == false) goto L54;
        TextView r123 = (TextView) r10.findViewById(R.id.alertTitle);
        r8.f547m = r123;
        r123.setText(r8.f538d);
        int r124 = r8.f544j;
        if (r124 == 0) goto L50;
        r8.f546l.setImageResource(r124);
        goto L56
    L50:
        Drawable r125 = r8.f545k;
        if (r125 == null) goto L53;
        r8.f546l.setImageDrawable(r125);
        goto L56
    L53:
        r8.f547m.setPadding(r8.f546l.getPaddingLeft(), r8.f546l.getPaddingTop(), r8.f546l.getPaddingRight(), r8.f546l.getPaddingBottom());
        r8.f546l.setVisibility(8);
        goto L56
    L37:
        r119 = false;
        goto L38
    L24:
        r116 = false;
        goto L26
    L20:
        r8.f542h.setText(null);
        r8.f542h.setVisibility(0);
        r112 = r112 | 4;
        goto L21
    L16:
        r8.f541g.setText(null);
        r8.f541g.setVisibility(0);
        r112 = r112 | 2;
        goto L17
    L12:
        r8.f540f.setText(null);
        r8.f540f.setVisibility(0);
        r112 = 1;
        goto L13
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r8, KeyEvent r10) {
        NestedScrollView r11 = this.f641p.f543i;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        return true;
    L11:
        return super.onKeyDown(r8, r10);
    L5:
        if (r11.f(r10) == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r8, KeyEvent r10) {
        NestedScrollView r11 = this.f641p.f543i;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        return true;
    L11:
        return super.onKeyUp(r8, r10);
    L5:
        if (r11.f(r10) == false) goto L7;
        r12 = true;
        goto L8
    }

    @Override // androidx.appcompat.app.o, android.app.Dialog
    public final void setTitle(CharSequence r8) {
        super.setTitle(r8);
        AlertController r10 = this.f641p;
        r10.f538d = r8;
        TextView r11 = r10.f547m;
        if (r11 == null) goto L6;
        r11.setText(r8);
        return;
    }
}

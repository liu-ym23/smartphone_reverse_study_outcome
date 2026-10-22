package com.zte.miboard.cards.express;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.m;
import c.s;
import c.s0;
import com.bumptech.glide.f;
import com.bumptech.glide.g;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.q;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.data.ExpressNode;
import io.reactivex.internal.observers.h;
import n0.d;
import q0.e;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressListItem extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f16289b;

    public interface a {
        void a(ExpressNode r5);
    }

    public ExpressListItem(Context r5) {
        this(r5, null);
    }

    public void a(View r5) {
        m.i("ExpressListItem", "onItemClick");
        ExpressNode r10 = (ExpressNode) getTag();
        s.f(getContext(), r10);
        ExpressCard.i();
    }

    public void b(View r5) {
        StringBuilder r10 = new StringBuilder("onItemDeleteClick callback=");
        if (this.f16289b == null) goto L5;
        boolean r11 = true;
    L6:
        r10.append(r11);
        m.i("ExpressListItem", r10.toString());
        ExpressNode r12 = (ExpressNode) getTag();
        a r13 = this.f16289b;
        if (r13 == null) goto L10;
        r13.a(r12);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r5 = 0;
        if (this.f16288a == true) goto L6;
        int r10 = getResources().getDimensionPixelSize(R.dimen.express_more_aty_item_padding_left);
        int r11 = getResources().getDimensionPixelSize(R.dimen.express_more_aty_item_padding_right);
        setPadding(r10, getPaddingTop(), r11, getPaddingBottom());
        findViewById(R.id.express_list_item_bg_layout).setVisibility(0);
    L6:
        if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        Resources r12 = getResources();
        if (this.f16288a == false) goto L10;
        int r13 = R.dimen.express_list_item_height;
    L11:
        int r14 = r12.getDimensionPixelSize(r13);
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) getLayoutParams();
        r15.height = r14;
        setLayoutParams(r15);
        setMinimumHeight(r14);
        goto L12
    L10:
        r13 = R.dimen.express_list_item_height_in_more_aty;
    L12:
        ImageView r16 = (ImageView) findViewById(R.id.express_list_item_icon);
        if ((r16.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16.getLayoutParams();
        Resources r18 = getResources();
        if (this.f16288a == false) goto L17;
        int r19 = R.dimen.express_list_item_icon_margin_start_in_icon;
    L18:
        r17.leftMargin = r18.getDimensionPixelSize(r19);
        Resources r20 = getResources();
        if (this.f16288a == false) goto L21;
        int r21 = R.dimen.express_list_item_icon_margin_end_in_icon;
    L22:
        r17.rightMargin = r20.getDimensionPixelSize(r21);
        Resources r22 = getResources();
        if (this.f16288a == false) goto L25;
        int r23 = R.dimen.express_list_item_icon_size;
    L26:
        int r24 = r22.getDimensionPixelSize(r23);
        r17.width = r24;
        r17.height = r24;
        r16.setLayoutParams(r17);
        goto L27
    L25:
        r23 = R.dimen.express_list_item_icon_size_in_more_aty;
        goto L26
    L21:
        r21 = R.dimen.express_list_item_icon_margin_end_in_aty;
        goto L22
    L17:
        r19 = R.dimen.express_list_item_icon_margin_start_in_aty;
    L27:
        View r25 = findViewById(R.id.express_list_item_divider);
        if (this.f16288a == false) goto L30;
        r5 = 8;
    L30:
        r25.setVisibility(r5);
        final int r26 = 0;
        setOnClickListener(new b(this, r26));
        final int r27 = 1;
        findViewById(R.id.express_list_item_delete_layout).setOnClickListener(new b(this, r27));
    }

    public void setItemCallback(a r5) {
        this.f16289b = r5;
    }

    public ExpressListItem(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public void a(ExpressNode r10, boolean r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        setTag(r10);
        if (r10.getStatusGroup() != 1) goto L9;
        int r5 = R.color.express_totake;
    L12:
        ((TextView) findViewById(R.id.express_state)).setTextColor(getContext().getColor(r5));
        ((TextView) findViewById(R.id.express_state)).setText(r10.getStatus());
        View r12 = findViewById(R.id.express_state_send_icon);
        int r13 = 8;
        if (r10.isSend() == false) goto L15;
        int r14 = 0;
    L16:
        r12.setVisibility(r14);
        View r15 = findViewById(R.id.express_state_error);
        if (r10.isOutDate() == false) goto L19;
        int r16 = 0;
    L20:
        r15.setVisibility(r16);
        View r17 = findViewById(R.id.express_list_item_delete_layout);
        if (r11 == false) goto L23;
        int r18 = 0;
    L24:
        r17.setVisibility(r18);
        ((TextView) findViewById(R.id.express_sj)).setText(r10.getExpressName() + ":  " + r10.getMailNo());
        if (TextUtils.isEmpty(r10.getPhone()) == false) goto L27;
        String r19 = "";
    L31:
        ((TextView) findViewById(R.id.express_list_item_phone_end_number)).setText(String.format(getResources().getString(R.string.express_phone_end_number), new Object[]{r19}));
        ((TextView) findViewById(R.id.express_list_item_phone_end_number_2)).setText(String.format(getResources().getString(R.string.express_phone_end_number), new Object[]{r19}));
        if (this.f16288a == false) goto L37;
        TextView r20 = (TextView) findViewById(R.id.express_list_item_phone_end_number);
        if (ExpressCard.getLoginUserCount() <= 1) goto L36;
        r13 = 0;
    L36:
        r20.setVisibility(r13);
    L39:
        if (this.f16288a == false) goto L41;
        TextView r21 = (TextView) findViewById(R.id.express_state);
    L42:
        ImageView r22 = (ImageView) findViewById(R.id.express_list_item_icon);
        String r23 = r10.getLogo();
        boolean r24 = s0.f1083a;
        if (TextUtils.isEmpty(r23) == false) goto L45;
        boolean r25 = false;
    L46:
        if (r25 == true) goto L48;
    L77:
        r22.setImageResource(R.drawable.express_company_logo);
        return;
    L48:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L50;
        boolean r26 = true;
    L51:
        if (r26 == false) goto L77;
        Context r27 = getContext().getApplicationContext();
        h.h(r27, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        g r28 = com.bumptech.glide.b.b(r27).f.b(r27);
        String r29 = r10.getLogo();
        r28.getClass();
        f r30 = new f(r28.f1407a, r28, Drawable.class, r28.f1408b);
        r30.f1404v = r29;
        r30.f1405w = true;
        f r31 = (f) r30.i(R.drawable.express_company_logo);
        r31.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L76;
        h.g(r22);
        if (com.bumptech.glide.request.a.f(r31.f1673a, 2048) == false) goto L57;
        com.bumptech.glide.request.a r32 = r31;
    L66:
        r31.f1402t.f1389c.getClass();
        Class r33 = r31.s;
        if (Bitmap.class.equals(r33) == false) goto L70;
        d r34 = new n0.b(r22, 0);
    L72:
        r31.t(r34, r32, e.f21451a);
        return;
    L70:
        if (Drawable.class.isAssignableFrom(r33) == false) goto L74;
        r34 = new n0.b(r22, 1);
        goto L72
    L74:
        throw new IllegalArgumentException("Unhandled class: " + r33 + ", try .as*(Class).transcode(ResourceTranscoder)");
    L57:
        if (r22.getScaleType() != null) goto L59;
        r32 = r31;
        goto L66
    L59:
        switch(com.bumptech.glide.e.f1398a[r22.getScaleType().ordinal()]) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L62;
            case 5: goto L62;
            case 6: goto L61;
            default: goto L80;
        };
    L61:
        r32 = r31.s().g(j.f1612c, new com.bumptech.glide.load.resource.bitmap.g());
        r32.f1683o = true;
        goto L66
    L62:
        r32 = r31.s().g(j.f1611b, new q());
        r32.f1683o = true;
        goto L66
    L63:
        r32 = r31.s().g(j.f1612c, new com.bumptech.glide.load.resource.bitmap.g());
        r32.f1683o = true;
        goto L66
    L64:
        r32 = r31.s().g(j.d, new com.bumptech.glide.load.resource.bitmap.f());
        goto L66
    L80:
        r32 = r31;
        goto L66
    L76:
        throw new IllegalArgumentException("You must call this method on the main thread");
    L50:
        r26 = false;
        goto L51
    L45:
        r25 = URLUtil.isNetworkUrl(r23);
        goto L46
    L41:
        ((TextView) findViewById(R.id.express_state)).setTextAppearance(R.style.Title_1_Regular);
        ((TextView) findViewById(R.id.express_sj)).setTextAppearance(R.style.Subtitle_2_Regular);
        ((TextView) findViewById(R.id.express_list_item_phone_end_number)).setTextAppearance(R.style.Subtitle_2_Regular);
        ((TextView) findViewById(R.id.express_list_item_phone_end_number_2)).setTextAppearance(R.style.Subtitle_2_Regular);
        goto L42
    L37:
        ((TextView) findViewById(R.id.express_list_item_phone_end_number)).setVisibility(8);
        ((TextView) findViewById(R.id.express_list_item_phone_end_number_2)).setVisibility(0);
        goto L39
    L27:
        if (r10.getPhone().length() <= 4) goto L29;
        r19 = r10.getPhone().substring(r10.getPhone().length() - 4);
        goto L31
    L29:
        r19 = r10.getPhone();
        goto L31
    L23:
        r18 = 8;
        goto L24
    L19:
        r16 = 8;
        goto L20
    L15:
        r14 = 8;
        goto L16
    L9:
        if (r10.getStatusGroup() != 2) goto L11;
        r5 = R.color.express_signed;
        goto L12
    L11:
        r5 = R.color.express_watch_details;
        goto L12
    }

    public ExpressListItem(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f16288a = !(getContext() instanceof Activity);
    }
}

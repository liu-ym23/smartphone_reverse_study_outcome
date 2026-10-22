package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYCardItem;
import kotlin.jvm.internal.Intrinsics;
import w20.u7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends BaseMVIListItem<GiftDIYCardItem, GiftAction> {
    public py.k l;
    public final TextView m;
    public final TextView n;
    public final HSImageView o;
    public final HSImageView p;
    public final HSImageView q;
    public final View r;
    public final TextView s;

    public final void i() {
    }

    public n(View r2) {
        Intrinsics.checkNotNullParameter(r2, "inflateView");
        super(r2, new GiftDIYCardItem());
        this.l = vh7.f.c(py.k.class);
        this.m = (TextView) ((BaseMVIListItem) this).j.findViewById(2131379475);
        this.n = (TextView) ((BaseMVIListItem) this).j.findViewById(2131387547);
        this.o = ((BaseMVIListItem) this).j.findViewById(2131369257);
        this.p = ((BaseMVIListItem) this).j.findViewById(2131385851);
        this.q = ((BaseMVIListItem) this).j.findViewById(2131369258);
        this.r = ((BaseMVIListItem) this).j.findViewById(2131384219);
        this.s = (TextView) ((BaseMVIListItem) this).j.findViewById(2131365217);
    }

    public final void b(com.bytedance.android.anya.k r14, MVIState r15) {
        GiftDIYCardItem r16 = (GiftDIYCardItem) r15;
        Intrinsics.checkNotNullParameter(r14, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r16, "state");
        r0<GiftDIYCardItem, py.k> r0 = r16.getGiftIcon();
        Object r1 = r14.c.a(r0);
        if (r1 == null) goto L5;
        r14.b.a.invoke(r0);
        this.l = (py.k) r1;
    L5:
        r0<GiftDIYCardItem, com.bytedance.android.livesdk.gift.model.n> r2 = r16.getDiyCardInfo();
        Object r3 = r14.c.a(r2);
        boolean r4 = true;
        if (r3 == null) goto L97;
        r14.b.a.invoke(r2);
        com.bytedance.android.livesdk.gift.model.n r5 = (com.bytedance.android.livesdk.gift.model.n) r3;
        String r6 = r5.getMainText();
        Bitmap r7 = null;
        if (r6 != null) goto L10;
    L15:
        String r8 = r5.getSubText();
        if (r8 != null) goto L18;
    L23:
        CardLockInfo r9 = r5.getLockInfo();
        if (r9 == null) goto L26;
        Integer r10 = Integer.valueOf(r9.getLockStatus());
    L27:
        if (r10 == null) goto L37;
        CardLockInfo r11 = r5.getLockInfo();
        if (r11 != null) goto L31;
    L32:
        CardLockInfo r13 = r5.getLockInfo();
        if (r13 != null) goto L35;
    L36:
        this.o.setAlpha(0.3f);
        ViewUtilsKt.f(this.q);
    L39:
        if ((r5 instanceof sz1.a) == false) goto L93;
        if (TextUtils.isEmpty(((sz1.a) r5).getLocalIconBitmap()) == true) goto L93;
        byte[] r17 = Base64.decode(((sz1.a) r5).getLocalIconBitmap(), 0);     // Catch: Exception -> L91
        Bitmap r18 = BitmapFactory.decodeByteArray(r17, 0, r17.length);     // Catch: Exception -> L91
        u7.b r19 = ((sz1.a) r5).getGiftToolbarFrame();     // Catch: Exception -> L91
        if (r19 == null) goto L85;
        Float r20 = r19.c();     // Catch: Exception -> L91
        if (r20 == null) goto L47;
        int r21 = (int) r20.floatValue();     // Catch: Exception -> L91
    L48:
        if (r21 < 0) goto L53;
        Float r23 = r19.c();     // Catch: Exception -> L91
        if (r23 == null) goto L53;
        int r24 = (int) r23.floatValue();     // Catch: Exception -> L91
    L54:
        Float r25 = r19.d();     // Catch: Exception -> L91
        if (r25 == null) goto L57;
        int r26 = (int) r25.floatValue();     // Catch: Exception -> L91
    L58:
        if (r26 < 0) goto L63;
        Float r27 = r19.d();     // Catch: Exception -> L91
        if (r27 == null) goto L63;
        int r28 = (int) r27.floatValue();     // Catch: Exception -> L91
    L64:
        Float r29 = r19.b();     // Catch: Exception -> L91
        if (r29 == null) goto L67;
        int r30 = (int) r29.floatValue();     // Catch: Exception -> L91
    L69:
        if ((r30 + r24) > r18.getWidth()) goto L85;
        Float r31 = r19.a();     // Catch: Exception -> L91
        if (r31 == null) goto L73;
        int r33 = (int) r31.floatValue();     // Catch: Exception -> L91
    L75:
        if ((r33 + r28) > r18.getHeight()) goto L85;
        Float r34 = r19.b();     // Catch: Exception -> L91
        if (r34 == null) goto L79;
        int r35 = (int) r34.floatValue();     // Catch: Exception -> L91
    L80:
        Float r36 = r19.a();     // Catch: Exception -> L91
        if (r36 == null) goto L83;
        int r110 = (int) r36.floatValue();     // Catch: Exception -> L91
    L84:
        r7 = Bitmap.createBitmap(r18, r24, r28, r35, r110, null, false);     // Catch: Exception -> L91
        goto L85
    L83:
        r110 = 0;
        goto L84
    L79:
        r35 = 0;
        goto L80
    L73:
        r33 = 0;
        goto L75
    L67:
        r30 = 0;
    L63:
        r28 = 0;
        goto L64
    L57:
        r26 = 0;
    L53:
        r24 = 0;
        goto L54
    L47:
        r21 = 0;
    L85:
        HSImageView r37 = this.o;     // Catch: Exception -> L91
        if (r7 == null) goto L89;
        r18 = r7;
    L89:
        r37.setImageBitmap(r18);     // Catch: Exception -> L91
    L96:
        ((BaseMVIListItem) this).j.setOnClickListener(new m(this));
    L91:
        ImageLoader.bindImage(this.o, this.l);
    L93:
        if (r5.getIconImg() == null) goto L95;
        ImageLoader.bindImage(this.o, r5.getIconImg());
        goto L96
    L95:
        ImageLoader.bindImage(this.o, this.l);
        goto L96
    L35:
        if (r13.getLockStatus() == CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L37;
    L31:
        if (r11.getLockStatus() != CardLockInfo.Companion.LockStatus.UNKNOWN.getV()) goto L32;
    L37:
        this.o.setAlpha(1.0f);
        ViewUtilsKt.e(this.q);
        goto L39
    L26:
        r10 = null;
        goto L27
    L18:
        if ((!TextUtils.isEmpty(r8)) == true) goto L21;
        r8 = null;
    L21:
        if (r8 == null) goto L23;
        this.n.setText(r8);
        goto L23
    L10:
        if ((!TextUtils.isEmpty(r6)) == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        this.m.setText(r6);
    L97:
        r0<GiftDIYCardItem, Boolean> r38 = r16.getSelected();
        Object r39 = r14.c.a(r38);
        if (r39 == null) goto L103;
        r14.b.a.invoke(r38);
        if (((Boolean) r39).booleanValue() == false) goto L102;
        ViewUtilsKt.f(this.p);
        goto L103
    L102:
        ViewUtilsKt.e(this.p);
    L103:
        r0<GiftDIYCardItem, Boolean> r40 = r16.getShowRemindDot();
        Object r41 = r14.c.a(r40);
        if (r41 == null) goto L109;
        r14.b.a.invoke(r40);
        if (((Boolean) r41).booleanValue() == false) goto L108;
        ViewUtilsKt.f(this.r);
        goto L109
    L108:
        ViewUtilsKt.e(this.r);
    L109:
        r0<GiftDIYCardItem, String> r111 = r16.getExpireTime();
        Object r43 = r14.c.a(r111);
        if (r43 == null) goto L121;
        r14.b.a.invoke(r111);
        String r44 = (String) r43;
        if (r44.length() > 0) goto L115;
        r4 = false;
    L115:
        if (r4 == false) goto L117;
        ViewUtilsKt.f(this.s);
        this.s.setText(r44);
        return;
    L117:
        ViewUtilsKt.e(this.s);
        return;
    }
}

package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECAuctionStatusLayout;", "Landroid/widget/LinearLayout;", "Lq83/a;", "", "getCountDownText", "", "getCountDownSeconds", "getCurrentMillis", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionStatusLayout extends LinearLayout implements q83.a {
    public final ImageView a;
    public final TextView b;
    public ECPromotionAuctionInfo c;
    public boolean d;
    public final Paint e;
    public final RectF f;
    public Function0<Unit> g;
    public long h;

    public static final class a {
    }

    static {
    }

    private final long getCountDownSeconds() {
        return (this.h - getCurrentMillis()) / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
    }

    private final String getCountDownText() {
        long r0 = this.h - getCurrentMillis();
        if (r0 >= IServerListener.WHAT_BYTELINK_SINK_ERROR) goto L6;
        return null;
    L6:
        if (this.d == false) goto L9;
        return b(r0);
    L9:
        return th.a.h(getContext(), 2131913887, new Object[]{b(r0)});
    }

    public final boolean c() {
        if (this.c != null) goto L5;
        return false;
    L5:
        if (getCountDownSeconds() <= 10) goto L7;
        return false;
    L7:
        return true;
    }

    private final long getCurrentMillis() {
        return SystemClock.elapsedRealtime();
    }

    public final void a(ECPromotionAuctionInfo r10) {
        Integer r0 = r10.getStatus();
        String r11 = null;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        if (r0 != null) goto L16;
    L18:
        if (r0 != null) goto L21;
    L24:
        if (r0 != null) goto L27;
    L23:
        int r1 = 0;
    L30:
        if (r1 == 0) goto L32;
        this.a.setVisibility(0);
        this.a.setImageResource(r1);
    L33:
        if (r11 == null) goto L48;
        this.b.setVisibility(0);
        this.b.setText(r11);
        TextView r12 = this.b;
        if (this.d == true) goto L46;
        Integer r13 = r10.getStatus();
        if (r13 == null) goto L46;
        if (r13.intValue() != 2) goto L46;
        if (c() == false) goto L45;
        int r14 = -52412;
    L47:
        r12.setTextColor(r14);
        return;
    L45:
        r14 = -2146035677;
    L46:
        r14 = -1;
        goto L47
    L48:
        this.b.setVisibility(8);
        return;
    L32:
        this.a.setVisibility(8);
        goto L33
    L27:
        if (r0.intValue() != 4) goto L23;
        r11 = th.a.g(getContext(), 2131913890);
        goto L23
    L21:
        if (r0.intValue() != 6) goto L24;
    L22:
        r11 = th.a.g(getContext(), 2131913889);
        goto L23
    L16:
        if (r0.intValue() != 3) goto L18;
    L11:
        if (r0.intValue() != 2) goto L13;
        r11 = getCountDownText();
        r1 = 2131248064;
        goto L30
    L6:
        if (r0.intValue() != 1) goto L8;
        r1 = 2131248063;
        goto L30
    }

    public final String b(long r10) {
        long r11 = r10 / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
        long r0 = 60;
        long r12 = r11 % r0;
        long r13 = r11 / r0;
        StringBuilder r1 = new StringBuilder();
        long r14 = 10;
        if (r13 >= r14) goto L5;
        String r15 = "0" + r13;
    L6:
        r1.append(r15);
        r1.append(':');
        if (r12 >= r14) goto L9;
        String r16 = "0" + r12;
    L10:
        r1.append(r16);
        return r1.toString();
    L9:
        r16 = String.valueOf(r12);
        goto L10
    L5:
        r15 = String.valueOf(r13);
        goto L6
    }

    public final boolean d(Long r10) {
        if (r10 == null) goto L4;
        long r0 = r10.longValue();
    L5:
        ECPromotionAuctionInfo r11 = this.c;
        if (r11 == null) goto L16;
        int r12 = wl.a.b;
        this.h = wl.a.a(r11.getEndTime());
        Integer r13 = r11.getStatus();
        if (r13 != null) goto L11;
        return false;
    L11:
        if (r13.intValue() == 2) goto L13;
        return false;
    L13:
        if ((this.h - r0) < IServerListener.WHAT_BYTELINK_SINK_ERROR) goto L19;
        return true;
    L19:
        return false;
    L16:
        return false;
    L4:
        r0 = getCurrentMillis();
        goto L5
    }

    public final boolean e(ECPromotionAuctionInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "auctionInfo");
        Integer r0 = r10.getStatus();
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.intValue() != 2) goto L10;
        if (r10.getBizId() != 1) goto L10;
        r10.setStatus(6);
        r10.setButtonLabel(th.a.g(getContext(), 2131913888));
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        if (this.b.getVisibility() != 0) goto L19;
        Paint r0 = this.e;
        if (this.a.getVisibility() != 8) goto L8;
        int r1 = 855638016;
    L17:
        r0.setColor(r1);
        float r11 = UIUtils.dip2Px(getContext(), 8.0f);
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        r10.drawRoundRect(this.f, r11, r11, this.e);
        return;
    L8:
        if (this.d == false) goto L14;
        if (c() == false) goto L12;
        r1 = 1476342596;
        goto L17
    L12:
        r1 = 1459617792;
        goto L17
    L14:
        if (c() == false) goto L16;
        r1 = 234491406;
        goto L17
    L16:
        r1 = 135665699;
        goto L17
    }

    public final boolean onTick(long r10) {
        if (d(Long.valueOf(r10)) == false) goto L17;
        ECPromotionAuctionInfo r11 = this.c;
        if (r11 == null) goto L24;
        a(r11);
        if (getCountDownSeconds() != 10) goto L25;
        HashMap<String, JSONObject> r12 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r0 = com.bytedance.android.ec.core.hybrid.utils.j.d("ecom_auction_toast_timestamp");
        if (r0 == null) goto L11;
        long r13 = JSONObjectProtectorUtils.getLong(r0, "timestamp");
    L13:
        if ((System.currentTimeMillis() - r13) <= 2000) goto L26;
        Toast.makeText(getContext(), th.a.g(getContext(), 2131913892), 0).show();
        JSONObject r14 = new JSONObject();
        r14.put("timestamp", System.currentTimeMillis());
        Unit r1 = Unit.INSTANCE;
        com.bytedance.android.ec.core.hybrid.utils.j.h("ecom_auction_toast_timestamp", r14);
        return true;
    L26:
        return true;
    L11:
        r13 = 0;
        goto L13
    L25:
        return true;
    L24:
        return true;
    L17:
        ECPromotionAuctionInfo r15 = this.c;
        if (r15 == null) goto L20;
        a(r15);
    L20:
        Function0<Unit> r16 = this.g;
        if (r16 == null) goto L23;
        Unit r17 = (Unit) r16.invoke();
    L23:
        return false;
    }

    public ECAuctionStatusLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.e = new Paint(1);
        this.f = new RectF();
        setOrientation(0);
        setWillNotDraw(false);
        ImageView r1 = new ImageView(r10);
        this.a = r1;
        r1.setAdjustViewBounds(true);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        Unit r12 = Unit.INSTANCE;
        addView(r1);
        TextView r13 = new TextView(r10);
        this.b = r13;
        r13.setIncludeFontPadding(false);
        r13.setVisibility(8);
        r13.setGravity(16);
        int r14 = (int) UIUtils.dip2Px(r10, 2.0f);
        r13.setPadding(r14, 0, r14, 0);
        r13.setTextColor(-1);
        r13.setTextSize(1, 10.0f);
        com.bytedance.android.ec.core.utils.c0.b(r13, 500);
        r13.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(r13);
    }
}

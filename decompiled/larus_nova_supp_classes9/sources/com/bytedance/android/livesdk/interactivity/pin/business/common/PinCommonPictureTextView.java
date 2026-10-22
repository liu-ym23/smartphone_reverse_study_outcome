package com.bytedance.android.livesdk.interactivity.pin.business.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.common.utils.h;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightDataCommonPictureText;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PictureTextStyle;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g42.e;
import g42.i;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/common/PinCommonPictureTextView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "Landroid/view/View;", "k", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinCommonPictureTextView extends FrameLayout implements e {
    public Map<Integer, View> a;
    public final View b;
    public final TextView c;
    public final RoundCornerImageView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final Button h;
    public final View i;
    public final View j;
    public final PinCommonPictureTextView k;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ PinCommonPictureTextView b;

        public a(String r1, PinCommonPictureTextView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ILiveActionHandler r4 = k.f(ILiveActionHandler.class);
            if (r4 == null) goto L6;
            r4.handle(this.b.getContext(), this.a);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PinCommonPictureTextView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ HighlightDataCommonPictureText c;

        public b(PinCommonPictureTextView r1, boolean r2, HighlightDataCommonPictureText r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (h.b(this.b) == false) goto L5;
            PinCommonPictureTextView.e(this.a, this.c, true);
            return;
        L5:
            f2.b(2131921367, 0);
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.b(2131921365, 0);
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ PinCommonPictureTextView a;
        public final /* synthetic */ HighlightDataCommonPictureText b;

        public d(PinCommonPictureTextView r1, HighlightDataCommonPictureText r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r3) {
            PinCommonPictureTextView.e(this.a, this.b, false);
            return true;
        }
    }

    public PinCommonPictureTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinCommonPictureTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getContentHeight() {
        return this.b.getHeight();
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(72);
    }

    @Override // g42.e
    public View getView() {
        return this.k;
    }

    @Override // g42.e
    public final void a(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final View d(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public static void f(Text r1, TextView r2) {
        qb2.c.a(r1, new k92.b(r2));
    }

    @Override // g42.e
    public final void b(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "item");
        e.a.a(r2, r3);
    }

    @Override // g42.e
    public void update(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
        e.a.update(this, r2, r3);
    }

    public PinCommonPictureTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131566736, this);
        this.b = d(2131367833);
        this.c = (TextView) d(2131391620);
        this.d = d(2131376466);
        this.e = (TextView) d(2131390916);
        this.f = (TextView) d(2131391522);
        this.g = (TextView) d(2131367553);
        this.h = (Button) d(2131367550);
        this.i = d(2131382314);
        this.j = d(2131367802);
        this.k = this;
    }

    public static final void e(PinCommonPictureTextView r3, HighlightDataCommonPictureText r4, boolean r5) {
        r3.getClass();
        String r6 = r4.getScene();
        if (r6 == null) goto L6;
        f42.b r7 = new f42.b(new f42.a(r6, r4.getPinId()));
        r7.d = r5;
        i.a(r7);
        return;
    }

    @Override // g42.e
    public final void c(DataCenter r6, g42.c r7, HighlightItem r8) {
        Intrinsics.checkNotNullParameter(r7, "pinContainer");
        Intrinsics.checkNotNullParameter(r8, "highlightItem");
        HighlightDataCommonPictureText r9 = r8.getCommonPictureTextData();
        if (r9 == null) goto L5;
        PictureTextStyle r0 = r9.getPictureTextStyle();
    L6:
        if (r0 != null) goto L9;
        this.c.setText(BuildConfig.FLAVOR);
        this.e.setText(BuildConfig.FLAVOR);
        setOnLongClickListener(null);
        return;
    L9:
        ImageModel r1 = r0.getPicture();
        if (r1 != null) goto L12;
        UtilityKotlinExtentionsKt.t(this.d);
    L13:
        Text r2 = r0.getText();
        Text r3 = r0.getSubText();
        if (r3 != null) goto L16;
        UtilityKotlinExtentionsKt.t(this.f);
        this.e.setMaxLines(2);
    L20:
        if (r2 != null) goto L22;
        UtilityKotlinExtentionsKt.t(this.e);
    L23:
        PinCommon r4 = r9.getPinCommon();
        if (r4 == null) goto L28;
        Text r5 = r4.getTitle();
        if (r5 == null) goto L28;
        f(r5, this.c);
    L28:
        boolean r10 = z.e(r7.getDataCenter(), false);
        if (r4 == null) goto L31;
        OperateInfo r11 = r4.getOperateInfo();
    L32:
        if (r11 != null) goto L34;
        UtilityKotlinExtentionsKt.t(this.i);
    L43:
        if (r10 == false) goto L45;
        setOnLongClickListener(new d(this, r9));
    L46:
        String r13 = r0.getSchema();
        if (r13 == null) goto L50;
        setOnClickListener(new a(r13, this));
        return;
    L50:
        return;
    L45:
        setOnLongClickListener(null);
        goto L46
    L34:
        UtilityKotlinExtentionsKt.w(this.i);
        Text r14 = r11.getCreatorText();
        if (r14 == null) goto L37;
        f(r14, this.g);
    L37:
        if (r10 == false) goto L39;
    L42:
        this.h.setAlpha(1.0f);
        this.h.setOnClickListener(new b(this, r10, r9));
        goto L43
    L39:
        if (Intrinsics.areEqual(r11.getCreator(), r7.getCurrentUserId()) == true) goto L42;
        this.h.setAlpha(0.34f);
        this.h.setOnClickListener(c.a);
        goto L43
    L31:
        r11 = null;
        goto L32
    L22:
        UtilityKotlinExtentionsKt.w(this.e);
        f(r2, this.e);
        goto L23
    L16:
        UtilityKotlinExtentionsKt.w(this.f);
        f(r3, this.f);
        if (r2 != null) goto L19;
        this.f.setMaxLines(2);
        goto L20
    L19:
        this.f.setMaxLines(1);
        this.e.setMaxLines(1);
        goto L20
    L12:
        UtilityKotlinExtentionsKt.w(this.d);
        ImageLoader.bindImage(this.d, r1);
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public /* synthetic */ PinCommonPictureTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import i12.e;
import i12.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/NewGiftSwitchImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/EffectSwitchStatus;", "getState", "()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/EffectSwitchStatus;", "state", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewGiftSwitchImageView extends ConstraintLayout {
    public Map<Integer, View> a;
    public String b;
    public String c;
    public long d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NewGiftSwitchImageView a;

        public a(NewGiftSwitchImageView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            NewGiftSwitchImageView.R5(this.a);
        }
    }

    public NewGiftSwitchImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NewGiftSwitchImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final EffectSwitchStatus getState() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, i2.class);
    L6:
        i2 r2 = (i2) r1;
        if (r2 == null) goto L13;
        if (r2.c() == true) goto L13;
        return EffectSwitchStatus.CLOSE;
    L13:
        return EffectSwitchStatus.OPEN;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(NewGiftSwitchImageView r5) {
        HSImageView r0 = r5._$_findCachedViewById(2131387882);
        Object r3 = null;
        if (r5.getState() != EffectSwitchStatus.OPEN) goto L12;
        e r1 = o.b();
        if (r1 == null) goto L7;
        r3 = m.e.d(r1, i2.class);
    L7:
        i2 r4 = (i2) r3;
        if (r4 == null) goto L10;
        r4.a(false);
    L10:
        ToastUtil.a(2131917168, 0);
        ImageLoader.bindImage(r0, r5.c, r5.getWidth(), r5.getHeight());
        h.r(r5.d, false);
        return;
    L12:
        if (r5.getState() != EffectSwitchStatus.CLOSE) goto L22;
        e r2 = o.b();
        if (r2 == null) goto L16;
        r3 = m.e.d(r2, i2.class);
    L16:
        i2 r6 = (i2) r3;
        if (r6 == null) goto L19;
        r6.a(true);
    L19:
        ToastUtil.a(2131917169, 0);
        ImageLoader.bindImage(r0, r5.b, r5.getWidth(), r5.getHeight());
        h.r(r5.d, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r4 = (View) ((LinkedHashMap) this.a).get(2131387882);
        if (r4 != null) goto L12;
        View r5 = findViewById(2131387882);
        if (r5 == null) goto L10;
        this.a.put(2131387882, r5);
        return r5;
    L10:
        return null;
    L12:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewGiftSwitchImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131565249, this);
        _$_findCachedViewById(2131387882).setOnClickListener(new a(this));
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
        s1.j(2131168708);
        s1.j(2131168708);
    }

    public /* synthetic */ NewGiftSwitchImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void S5(String r5, String r6, int r7, int r8, long r9, boolean r11) {
        String r0 = BuildConfig.FLAVOR;
        if (r5 != null) goto L5;
        String r1 = BuildConfig.FLAVOR;
    L6:
        this.b = r1;
        if (r6 == null) goto L10;
        r0 = r6;
    L10:
        this.c = r0;
        this.d = r9;
        HSImageView r2 = _$_findCachedViewById(2131387882);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.width = r7;
        r3.height = r8;
        r2.setLayoutParams(r3);
        if (getState() != EffectSwitchStatus.CLOSE) goto L21;
        if (r6 == null) goto L21;
        if (r6.length() <= 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 != true) goto L21;
        r2.setVisibility(0);
        ImageLoader.bindImage(r2, r6, r7, r7);
        if (r11 == false) goto L32;
        h.s(r9, false);
        return;
    L32:
        return;
    L16:
        r10 = false;
    L21:
        if (r5 != null) goto L23;
    L30:
        r2.setVisibility(8);
        return;
    L23:
        if (r5.length() <= 0) goto L25;
        boolean r13 = true;
    L26:
        if (r13 != true) goto L30;
        r2.setVisibility(0);
        ImageLoader.bindImage(r2, r5, r7, r7);
        if (r11 == false) goto L34;
        h.s(r9, true);
        return;
    L34:
        return;
    L25:
        r13 = false;
        goto L26
    L5:
        r1 = r5;
        goto L6
    }
}

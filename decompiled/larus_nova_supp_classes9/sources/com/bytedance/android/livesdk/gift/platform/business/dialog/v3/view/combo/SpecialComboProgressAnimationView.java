package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.e;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import jy0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/SpecialComboProgressAnimationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecialComboProgressAnimationView extends FrameLayout {
    public Map<Integer, View> a;

    public SpecialComboProgressAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SpecialComboProgressAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
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

    public SpecialComboProgressAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131565266, this);
        int r5 = GiftManagerKt.s().size();
        if (r5 <= 0) goto L18;
        int r6 = ((e) ListProtector.get(GiftManagerKt.s(), r5 - 1)).comboCount;
    L18:
        Typeface r7 = Typeface.createFromAsset(r2.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L15
        TextView r8 = (TextView) a(2131367242);     // Catch: Exception -> L15
        if (r8 == null) goto L8;
        r8.setTypeface(r7);     // Catch: Exception -> L15
    L8:
        TextView r9 = (TextView) a(2131367244);     // Catch: Exception -> L15
        if (r9 == null) goto L11;
        r9.setTypeface(r7);     // Catch: Exception -> L15
    L11:
        TextView r10 = (TextView) a(2131367246);     // Catch: Exception -> L15
        if (r10 == null) goto L20;
        r10.setTypeface(r7);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        b.c("ComboProgressAnimationView", "load font asset exception: " + e.getMessage(), null, 4);
    }

    public /* synthetic */ SpecialComboProgressAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

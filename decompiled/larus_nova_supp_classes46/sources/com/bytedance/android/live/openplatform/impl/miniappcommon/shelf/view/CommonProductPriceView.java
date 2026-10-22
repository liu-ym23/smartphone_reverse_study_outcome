package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductPriceView extends LinearLayout {
    public Map<Integer, View> a;

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

    public final void b(ProductPriceInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "priceInfo");
        String r0 = r12.currentPrefix;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        UtilityKotlinExtentionsKt.t(a(2131368345));
    L13:
        String r3 = r12.currentSuffix;
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        UtilityKotlinExtentionsKt.t(a(2131368346));
    L24:
        String r5 = r12.currentPrice;
        if (r5 != null) goto L27;
    L30:
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
        UtilityKotlinExtentionsKt.t(a(2131368344));
        UtilityKotlinExtentionsKt.t(a(2131368343));
    L39:
        String r7 = r12.originalPrice;
        if (r7 != null) goto L42;
    L43:
        r1 = true;
    L45:
        if (r1 == false) goto L47;
        UtilityKotlinExtentionsKt.t(a(2131381687));
        return;
    L47:
        ((TextView) a(2131381687)).setText("¥" + r12.originalPrice);
        ((TextView) a(2131381687)).getPaint().setFlags(17);
        UtilityKotlinExtentionsKt.w(a(2131381687));
        return;
    L42:
        if (StringsKt.isBlank(r7) == false) goto L45;
    L34:
        String r8 = r12.currentPrice;
        Intrinsics.checkNotNull(r8);
        List r9 = StringsKt.split$default(r8, new String[]{"."}, false, 0, 6, null);
        if (r9.size() != 1) goto L37;
        UtilityKotlinExtentionsKt.t(a(2131368343));
    L38:
        ((TextView) a(2131368344)).setText((CharSequence) ListProtector.get(r9, 0));
        UtilityKotlinExtentionsKt.w(a(2131368344));
        UtilityKotlinExtentionsKt.w(a(2131380266));
        goto L39
    L37:
        ((TextView) a(2131368343)).setText("." + ((String) ListProtector.get(r9, 1)));
        UtilityKotlinExtentionsKt.w(a(2131368343));
        goto L38
    L27:
        if (StringsKt.isBlank(r5) == true) goto L30;
        r6 = false;
        goto L32
    L23:
        ((TextView) a(2131368346)).setText(r12.currentSuffix);
        UtilityKotlinExtentionsKt.w(a(2131368346));
        goto L24
    L16:
        if (StringsKt.isBlank(r3) == true) goto L19;
        r4 = false;
        goto L21
    L12:
        ((TextView) a(2131368345)).setText(r12.currentPrefix);
        UtilityKotlinExtentionsKt.w(a(2131368345));
        goto L13
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L10
    }

    public CommonProductPriceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131566961, this);
    }
}

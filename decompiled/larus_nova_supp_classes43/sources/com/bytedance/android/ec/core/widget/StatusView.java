package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingConfig;
import com.bytedance.android.ui.ec.widget.loading.ECSloganLoadingAnimationView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/core/widget/StatusView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/widget/j;", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "", "setECStatus", "Landroid/view/View;", "loadingView", "setupLoadingAnim", "", "a", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StatusView extends FrameLayout implements j {
    public Map<Integer, View> a;
    public int b;
    public View c;

    public static final class a {
    }

    static {
    }

    public StatusView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public StatusView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    @Override // com.bytedance.android.ec.core.widget.j
    public final void showLoading() {
        setVisibility(0);
        setECStatus(0);
    }

    public final View a() {
        ECLoadingConfig r0 = ECLoadingConfig.INSTANCE;
        if (r0.isDecided() == true) goto L5;
        r0.decideUsePersistentCache(ECSettingKeys.E());
    L5:
        ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
        Context r10 = getContext();
        r1.getClass();
        View r11 = ShoppingAsyncInflater.a.a(r10).aU(2131564798, this, false);
        Lazy r12 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L9;
    L11:
        this.c = r11;
        return r11;
    L9:
        if (we.a.a == false) goto L11;
        ((LinearLayout) r11.findViewById(2131389439)).setVisibility(0);
        goto L11
    }

    @Override // com.bytedance.android.ec.core.widget.j
    public final void reset() {
        if (this.b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r0 = this.a.get(Integer.valueOf(this.b));
        if (r0 == null) goto L8;
        r0.setVisibility(4);
    L8:
        this.b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.a;
    }

    public void setECStatus(int r10) {
        int r0 = this.b;
        if (r0 < 0) goto L7;
        View r1 = this.a.get(Integer.valueOf(r0));
        if (r1 == null) goto L7;
        r1.setVisibility(4);
    L7:
        View r11 = this.a.get(Integer.valueOf(r10));
        if (r11 == null) goto L15;
        r11.setVisibility(0);
        this.b = r10;
        if (r10 != 0) goto L16;
        Lazy r12 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L17;
        setupLoadingAnim(r11);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void setStatusViews(Map<Integer, View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.a = r10;
    }

    public void setupLoadingAnim(View r10) {
        Intrinsics.checkNotNullParameter(r10, "loadingView");
        ECSloganLoadingAnimationView r11 = r10.findViewById(2131386336);
        if (r11 == null) goto L6;
        r11.setVisibility(0);
        return;
    }

    public StatusView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = new LinkedHashMap();
        this.b = -1;
        b(null, null, false);
    }

    public final void b(View r10, View r11, boolean r12) {
        this.a.clear();
        Map<Integer, View> r0 = this.a;
        if (r10 != null) goto L15;
        if (r12 == false) goto L14;
        r10 = this.c;
        if (r10 == null) goto L13;
        ViewParent r13 = r10.getParent();
        if ((r13 instanceof ViewGroup) == true) goto L10;
        r13 = null;
    L10:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L15;
        r14.removeView(r10);
        goto L15
    L13:
        r10 = a();
        this.c = r10;
        Intrinsics.checkNotNull(r10);
        goto L15
    L14:
        r10 = a();
    L15:
        r0.put(0, r10);
        this.a.put(1, null);
        this.a.put(2, r11);
        removeAllViews();
        Iterator<Integer> r15 = this.a.keySet().iterator();
    L17:
        if (r15.hasNext() == false) goto L22;
        View r16 = this.a.get(Integer.valueOf(r15.next().intValue()));
        if (r16 == null) goto L17;
        r16.setVisibility(4);
        addView(r16);
        goto L17
    }

    public /* synthetic */ StatusView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}

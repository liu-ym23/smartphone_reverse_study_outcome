package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0011\u0010\u0015B#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0011\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MediaMultiAnchorTitleView;", "Landroid/widget/FrameLayout;", "Ly82/j;", "Landroid/view/View;", "getView", "Lcom/bytedance/android/livesdk/interactivity/medialink/contract/h;", "state", BuildConfig.FLAVOR, "setState", BuildConfig.FLAVOR, "isAnchor", "Z", "()Z", "setAnchor", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorTitleView extends FrameLayout implements y82.j {
    public Map<Integer, View> a;

    @Override // y82.j
    public View getView() {
        return this;
    }

    public final void setAnchor(boolean r1) {
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(2131567785, this, true);
        ((MultiPkTextView) a(2131391118)).setTypeface(Typeface.DEFAULT);
        ((MultiPkTextView) a(2131391118)).getPaint().setFakeBoldText(true);
        ((MultiPkTextView) a(2131391118)).setTextSize(1, 12.0f);
        MultiPkTextView r0 = (MultiPkTextView) a(2131391118);
        u r1 = new u();
        s r2 = new s(getContext());
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "textStyle");
        Intrinsics.checkNotNullParameter(r2, "numStyle");
        r0.c = r1;
        r0.d = r2;
        a(2131391589).setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
        ViewGroup.LayoutParams r3 = a(2131388805).getLayoutParams();
        r3.height = s1.f(20.0f);
        a(2131388805).setMinimumWidth(s1.f(20.0f));
        a(2131388805).setLayoutParams(r3);
        if (PadConfigUtils.c() == false) goto L7;
        UIUtils.updateLayout(a(2131388805), -2, UtilityKotlinExtentionsKt.i(32));
        return;
    }

    public MediaMultiAnchorTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        b();
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

    @Override // y82.j
    public void setState(com.bytedance.android.livesdk.interactivity.medialink.contract.h r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        r4.getClass();
        a(2131388805).setActualImageResource(r4.a);
        UIUtils.updateLayout(a(2131388805), -2, r4.b);
        ((FrameLayout) a(2131388847)).setMinimumWidth(r4.c);
        if (r4.d == false) goto L5;
        int r5 = 4;
    L6:
        setVisibility(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public MediaMultiAnchorTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        b();
    }

    public MediaMultiAnchorTitleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        b();
    }
}

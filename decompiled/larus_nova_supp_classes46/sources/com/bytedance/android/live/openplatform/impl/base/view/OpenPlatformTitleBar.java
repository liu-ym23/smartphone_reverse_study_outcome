package com.bytedance.android.live.openplatform.impl.base.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import ko0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\"\u0010&B#\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformTitleBar;", "Landroid/widget/RelativeLayout;", "", "title", "", "setTitle", "", "resId", "setLeftIconDrawable", "", "show", "setLeftIconVisibility", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnLeftIconClickListener", "url", "setLeftNetIconUrl", "setLeftNetIconVisibility", "setOnLeftNetIconClickListener", "text", "setLeftTvText", "setLeftTvVisibility", "setOnLeftTvClickListener", "setRightIconDrawable", "setRightIconVisibility", "setOnRightIconClickListener", "setRightTvText", "setRightTvVisibility", "setOnRightTvClickListener", "setSecondRightTvText", "setSecondRightTvVisibility", "setOnSecondRightTvClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformTitleBar extends RelativeLayout {
    public Map<Integer, View> a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OpenPlatformTitleBar a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ f c;
        public final /* synthetic */ int d;

        public b(OpenPlatformTitleBar r1, Activity r2, f r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            c90.a.a r0 = new c90.a.a(this.b);
            r0.a(this.c.a);
            r0.e = this.c.b;
            c90.a r1 = new c90.a(r0);
            ((LivePopupWindow) r1).b = this.c.c;
            if (this.d != 2) goto L5;
            View r2 = this.a.a(2131384641);
        L6:
            r1.f();
            float r3 = r1.e();
            r1.o = (r2.getMeasuredWidth() + ((UtilityKotlinExtentionsKt.i(7) * 8) / 3)) - r1.e();
            r1.h = r3;
            r1.i(r2, 80, false);
            return;
        L5:
            r2 = this.a.a(2131384584);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public OpenPlatformTitleBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
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

    public final void setLeftIconDrawable(int r2) {
        ((ImageView) a(2131377773)).setImageResource(r2);
    }

    public final void setLeftIconVisibility(boolean r2) {
        ImageView r0 = (ImageView) a(2131377773);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setLeftNetIconUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        ImageLoader.bindImage(a(2131377800), r2);
    }

    public final void setLeftNetIconVisibility(boolean r2) {
        HSImageView r0 = a(2131377800);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setLeftTvText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        ((TextView) a(2131377823)).setText(r2);
    }

    public final void setLeftTvVisibility(boolean r2) {
        TextView r0 = (TextView) a(2131377823);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setOnLeftIconClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        ((ImageView) a(2131377773)).setOnClickListener(r2);
    }

    public final void setOnLeftNetIconClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        a(2131377800).setOnClickListener(r2);
    }

    public final void setOnLeftTvClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        ((TextView) a(2131377823)).setOnClickListener(r2);
    }

    public final void setOnRightIconClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        ((ImageView) a(2131384584)).setOnClickListener(r2);
    }

    public final void setOnRightTvClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        ((TextView) a(2131384641)).setOnClickListener(r2);
    }

    public final void setOnSecondRightTvClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onClickListener");
        ((TextView) a(2131385687)).setOnClickListener(r2);
    }

    public final void setRightIconDrawable(int r2) {
        ((ImageView) a(2131384584)).setImageResource(r2);
    }

    public final void setRightIconVisibility(boolean r2) {
        ImageView r0 = (ImageView) a(2131384584);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setRightTvText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        ((TextView) a(2131384641)).setText(r2);
    }

    public final void setRightTvVisibility(boolean r2) {
        TextView r0 = (TextView) a(2131384641);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setSecondRightTvText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        ((TextView) a(2131385687)).setText(r2);
    }

    public final void setSecondRightTvVisibility(boolean r2) {
        TextView r0 = (TextView) a(2131385687);
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        ((TextView) a(2131388920)).setText(r2);
    }

    public OpenPlatformTitleBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OpenPlatformTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131567796, this);
    }

    public final void b(Activity r2, int r3, f r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (r2 != null) goto L5;
        return;
    L5:
        post(new b(this, r2, r4, r3));
    }
}

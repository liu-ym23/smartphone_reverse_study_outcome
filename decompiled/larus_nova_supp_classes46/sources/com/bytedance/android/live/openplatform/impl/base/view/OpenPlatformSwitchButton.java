package com.bytedance.android.live.openplatform.impl.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformSwitchButton;", "Landroid/widget/RelativeLayout;", "", "isChecked", "", "setChecked", "Lcom/bytedance/android/live/openplatform/impl/base/view/OpenPlatformSwitchButton$a;", "listener", "setOnCheckedChangeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformSwitchButton extends RelativeLayout {
    public Map<Integer, View> a;
    public a b;
    public boolean c;

    public interface a {
        void a(OpenPlatformSwitchButton r1, boolean r2, ap0.b.a r3);

        void b();
    }

    public interface b {
        void a(boolean r1);
    }

    public OpenPlatformSwitchButton(Context r2) {
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

    public final void setChecked(boolean r2) {
        a(2131387878).setChecked(r2);
    }

    public final void setOnCheckedChangeListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public OpenPlatformSwitchButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public OpenPlatformSwitchButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131567795, this);
        DrawableWrapper r5 = new RotatingDrawable(s1.m(2131252545));
        DrawableCompat.setTint(r5, ColorProtector.parseColor("#4D161823"));
        ((ImageView) a(2131379042)).setImageDrawable(r5);
        a(2131387878).setEnableDrag(false);
        a(2131387878).setToggleEventInterceptor(new ap0.b(this));
    }
}

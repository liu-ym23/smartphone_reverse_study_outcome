package com.bytedance.android.live.openplatform.impl.base.view.settingdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/SettingItemView;", "Landroid/widget/LinearLayout;", "", "getDescription", "", "getDescriptionColor", "Landroid/view/View;", "getRightView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SettingItemView extends LinearLayout {
    public abstract String getDescription();

    public View getRightView() {
        return null;
    }

    public int getDescriptionColor() {
        return s1.h(2131108464);
    }

    public SettingItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public SettingItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public SettingItemView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        TextView r6 = new TextView(getContext());
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.i(52)));
        setGravity(17);
        setPadding(UtilityKotlinExtentionsKt.i(16), 0, UtilityKotlinExtentionsKt.i(16), 0);
        r6.setText(getDescription());
        r6.setTextSize(14.0f);
        r6.setTextColor(getDescriptionColor());
        Unit r7 = Unit.INSTANCE;
        addView(r6, new LinearLayout.LayoutParams(0, -2, 1.0f));
        View r8 = getRightView();
        if (r8 == null) goto L6;
        addView(r8);
        return;
    }
}

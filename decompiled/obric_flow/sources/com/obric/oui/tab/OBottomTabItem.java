package com.obric.oui.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabItem")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/tab/OBottomTabItem;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "a", "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", MessageIndication.CONTENT_TYPE_TEXT, "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "icon", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f14638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f14639b;

    @JvmOverloads
    public OBottomTabItem(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final Drawable getIcon() {
        return this.f14639b;
    }

    public final CharSequence getText() {
        return this.f14638a;
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public final void setIcon(Drawable r5) {
        this.f14639b = r5;
    }

    public final void setText(CharSequence r5) {
        this.f14638a = r5;
    }

    @JvmOverloads
    public OBottomTabItem(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, R$styleable.OTabItem);
        this.f14638a = r11.getText(R$styleable.OBottomTabItem_android_text);
        this.f14639b = r11.getDrawable(R$styleable.OBottomTabItem_android_icon);
        r11.recycle();
    }
}

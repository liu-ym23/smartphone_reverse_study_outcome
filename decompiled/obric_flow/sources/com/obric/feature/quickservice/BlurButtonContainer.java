package com.obric.feature.quickservice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.obric.feature.view.ORelativeLayout;
import com.obric.flow.cardlistpage.fluid.LauncherMaterialToken;
import com.obric.oui.material.n;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/feature/quickservice/BlurButtonContainer;", "Lcom/obric/feature/view/ORelativeLayout;", "Lcom/obric/oui/common/style/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "radius", "", "setCornerRadius", "(F)V", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBlurButtonContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlurButtonContainer.kt\ncom/obric/feature/quickservice/BlurButtonContainer\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n*L\n1#1,74:1\n181#2,3:75\n180#2,5:78\n*S KotlinDebug\n*F\n+ 1 BlurButtonContainer.kt\ncom/obric/feature/quickservice/BlurButtonContainer\n*L\n30#1:75,3\n30#1:78,5\n*E\n"})
public class BlurButtonContainer extends ORelativeLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f11430c;
    public float d;

    @JvmOverloads
    public BlurButtonContainer(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        float r5 = getWidth();
        float r11 = getHeight();
        if (r11 > 0.0f) goto L5;
        return;
    L5:
        if (r5 <= 0.0f) goto L14;
        float r12 = this.d;
        if (r12 <= 0.0f) goto L10;
        float r13 = r12;
    L11:
        r10.drawRoundRect(0.0f, 0.0f, r5, r11, r13, r13, this.f11430c);
        return;
    L10:
        r13 = r11 / 2;
        goto L11
    }

    public final void setCornerRadius(float r5) {
        this.d = r5;
        invalidate();
    }

    @JvmOverloads
    public BlurButtonContainer(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ BlurButtonContainer(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public BlurButtonContainer(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 4, 0);
        Paint r12 = new Paint();
        this.f11430c = r12;
        this.d = a.a(28, 1);
        n.q(3, 2, this);
        n.t(r12, 3, LauncherMaterialToken.SysUI_Launcher_Widget_Background_Overlay.invoke(Boolean.valueOf(!ym.a.h(r5))));
    }
}

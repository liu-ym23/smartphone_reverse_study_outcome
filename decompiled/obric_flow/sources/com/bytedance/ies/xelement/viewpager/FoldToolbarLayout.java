package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.launcher.widget.R$id;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FoldToolbarLayout<T extends AppBarLayout> extends CoordinatorLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppBarLayout f6510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CollapsingToolbarLayout f6511c;
    public final Toolbar d;

    public FoldToolbarLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        new LinkedHashMap();
        super(r5);
        if ((r5 instanceof LynxContext) == false) goto L5;
        LynxLog.b(2, "FoldToolbarLayout", "context is: " + ((LynxContext) r5).getBaseContext());
    L5:
        View r10 = LayoutInflater.from(r5).inflate(a(), this, true);
        this.f6510b = (AppBarLayout) findViewById(R$id.app_bar_layout);
        CollapsingToolbarLayout r11 = (CollapsingToolbarLayout) findViewById(R$id.collapsing_toolbar_layout);
        this.f6511c = r11;
        this.d = (Toolbar) findViewById(R$id.x_fold_toolbar);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof AppBarLayout.LayoutParams) == false) goto L9;
        this.f6509a = ((AppBarLayout.LayoutParams) r12).getScrollFlags();
        return;
    }

    public abstract int a();

    public abstract void b(boolean r5);
}

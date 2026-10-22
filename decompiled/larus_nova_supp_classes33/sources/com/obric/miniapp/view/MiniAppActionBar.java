package com.obric.miniapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.model.objects.Applet;
import com.obric.miniapp.databinding.MiniAppActionBarBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/miniapp/view/MiniAppActionBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "binding", "Lcom/obric/miniapp/databinding/MiniAppActionBarBinding;", "onCloseListener", "Lkotlin/Function0;", "", "onRefreshListener", "updateBackground", "isDark", "", "setApplet", "setOnCloseListener", "listener", "setOnRefreshListener", "release", "initActionBarInLightMode", "initActionBarInDarkMode", "showMiniAppMenu", "getItemDataList", "", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "navigateToMiniAppOwnSettingsPage", "targetApplet", "onMiniAppShortcutClick", "navigateToMiniAppSystemSettingsPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppActionBar extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public Applet a;
    public final MiniAppActionBarBinding b;
    public Function0<Unit> c;
    public Function0<Unit> d;

    public static final class a {
    }

    static {
    }

    public final void setApplet(Applet r2) {
        Intrinsics.checkNotNullParameter(r2, "applet");
        this.a = r2;
    }

    public final void setOnCloseListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void setOnRefreshListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    public MiniAppActionBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ConstraintLayout r12 = LayoutInflater.from(r10).inflate(2131563651, this, false);
        int r13 = 2131364762;
        ConstraintLayout r0 = ViewBindings.findChildViewById(r12, 2131364762);
        if (r0 == null) goto L15;
        r13 = 2131364763;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r12, 2131364763);
        if (r8 == null) goto L15;
        r13 = 2131376412;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, 2131376412);
        if (r5 == null) goto L15;
        r13 = 2131376413;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, 2131376413);
        if (r6 == null) goto L15;
        r13 = 2131380141;
        View r7 = ViewBindings.findChildViewById(r12, 2131380141);
        if (r7 == null) goto L15;
        ConstraintLayout r14 = r12;
        this.b = new MiniAppActionBarBinding(r14, r0, r8, r5, r6, r7);
        addView(r14);
        r8.setOnClickListener(new c(this));
        r0.setOnClickListener(new d(this));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}

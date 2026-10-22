package com.larus.av_call.view;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusButtonSceneModeBinding;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.image.loader.ImageLoaderKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0014\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eJ \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/av_call/view/SceneModeButton;", "Landroid/widget/LinearLayout;", "Lcom/larus/av_call/view/IRealCallDayNight;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/av_call/databinding/LarusButtonSceneModeBinding;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "forceDarkMode", "", "configDependency", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "initView", "", "subtitleUseCC", "enableAudioBgSimpleColor", "updateButton", "scene", "Lcom/larus/av_call/model/CallSceneDisplayModel;", "springSceneTitle", "", "setExitListener", "listener", "Lkotlin/Function0;", "refreshThemeDayNight", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SceneModeButton extends LinearLayout {
    public static final /* synthetic */ int e = 0;
    public final LarusButtonSceneModeBinding a;
    public ThemeType b;
    public boolean c;
    public final IRealtimeCallConfigDependency d;

    public SceneModeButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SceneModeButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a(boolean r6) {
        this.c = r6;
        Application r0 = i88.e.a;
        ThemeType r1 = this.b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r1, "themeType");
        if (r6 == false) goto L5;
    L16:
        int r2 = 2131238827;
    L17:
        setBackground(ContextCompat.getDrawable(i88.e.a, r2));
        LarusButtonSceneModeBinding r3 = this.a;
        ThemeType r4 = this.b;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "themeType");
        i88.e.h(r3.d, r4, r6);
        if (r6 == false) goto L20;
    L23:
        r3.e.setIndeterminateTintList(ColorStateList.valueOf(com.larus.utils.j0.a(2131103298)));
        AppCompatTextView r7 = r3.f;
        int r5 = com.larus.utils.j0.a;
        r7.setTextColor(com.larus.utils.j0.a(2131103298));
        r3.b.setBackgroundColor(com.larus.utils.j0.a(2131106537));
        r3.c.setImageResource(2131241913);
        return;
    L20:
        if (i88.e.o(r4) == true) goto L23;
        r3.e.setIndeterminateTintList(ColorStateList.valueOf(com.larus.utils.j0.a(2131103292)));
        AppCompatTextView r8 = r3.f;
        int r9 = com.larus.utils.j0.a;
        r8.setTextColor(com.larus.utils.j0.a(2131103292));
        r3.b.setBackgroundColor(com.larus.utils.j0.a(2131103293));
        r3.c.setImageDrawable(com.larus.utils.j0.f(2131241913, ColorProtector.parseColor("#CC000000")));
        return;
    L5:
        if (i88.e.o(r1) == true) goto L16;
        IRealtimeCallConfigDependency r10 = i88.e.b;
        if (r10 == null) goto L12;
        boolean r11 = true;
        if (r10.r() != true) goto L12;
    L13:
        if (r11 == false) goto L15;
        r2 = 2131238831;
        goto L17
    L15:
        r2 = v19.c.b(2130970613, null, 2131238828);
    L12:
        r11 = false;
        goto L13
    }

    public final void setExitListener(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.larus.utils.e1.d(this.a.c, new i(r3));
    }

    public final void b(h88.c r6, String r7) {
        LarusButtonSceneModeBinding r0 = this.a;
        if (r6 != null) goto L10;
        com.larus.utils.e1.x(r0.d);
        com.larus.utils.e1.o(r0.e);
        com.larus.utils.e1.o(r0.b);
        com.larus.utils.e1.o(r0.c);
        Application r8 = i88.e.a;
        i88.e.h(r0.d, this.b, this.c);
        AppCompatTextView r9 = r0.f;
        if (r7 != null) goto L8;
        r7 = getContext().getString(2131911056);
    L8:
        r9.setText(r7);
        return;
    L10:
        if (r6.f == false) goto L12;
        com.larus.utils.e1.o(r0.b);
        com.larus.utils.e1.o(r0.c);
    L13:
        r0.a.setEnabled(!r6.g);
        if (r6.a == false) goto L16;
        com.larus.utils.e1.o(r0.d);
        com.larus.utils.e1.x(r0.e);
    L17:
        r0.f.setText(r6.d);
        return;
    L16:
        com.larus.utils.e1.x(r0.d);
        com.larus.utils.e1.o(r0.e);
        Application r10 = i88.e.a;
        SimpleDraweeView r11 = r0.d;
        final ThemeType r1 = this.b;
        String r2 = r6.b;
        final Boolean r3 = r6.c;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r1, "themeType");
        ImageLoaderKt.y(r11, r2, "scene_item", new i88.c(r3, r1), 4);
        goto L17
    L12:
        com.larus.utils.e1.x(r0.b);
        com.larus.utils.e1.x(r0.c);
        goto L13
    }

    public SceneModeButton(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LayoutInflater.from(r8).inflate(2131561857, this);
        int r11 = 2131371861;
        View r2 = ViewBindings.findChildViewById(this, 2131371861);
        if (r2 == null) goto L15;
        r11 = 2131371862;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(this, 2131371862);
        if (r3 == null) goto L15;
        r11 = 2131385152;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(this, 2131385152);
        if (r4 == null) goto L15;
        r11 = 2131385154;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(this, 2131385154);
        if (r5 == null) goto L15;
        r11 = 2131385163;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131385163);
        if (r6 == null) goto L15;
        this.a = new LarusButtonSceneModeBinding(this, r2, r3, r4, r5, r6);
        this.b = ThemeType.DEFAULT;
        this.d = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        setOrientation(0);
        setVisibility(8);
        setGravity(16);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public /* synthetic */ SceneModeButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}

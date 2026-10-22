package com.larksuite.component.card.component.header;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DeviceUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/component/header/UniversalCardHeaderBgUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/header/CardHeaderView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "setProps", "", "props", "Lcom/lynx/react/bridge/ReadableMap;", "generateMessageCardHeader", "Landroid/graphics/drawable/Drawable;", "cardColor", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardHeaderBgUI extends LynxUI<CardHeaderView> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public UniversalCardHeaderBgUI(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        CardHeaderView r0 = new CardHeaderView(r2);
        r0.setClipToOutline(true);
        r0.setId(2131374285);
        return r0;
    }

    @LynxProp(name = "props")
    public final void setProps(ReadableMap r12) {
        TraceEvent.beginSection("UniversalCardHeaderBgUI.setProps");
        Log.i("UniversalCardHeaderBgUI", "setProps start");
        if (r12 == null) goto L23;
        String r2 = r12.getString("tintColor");
        if (k.b(r2) == false) goto L11;
        Log.i("UniversalCardHeaderBgUI", "setProps tintColor " + r2);
        String r13 = r12.getString("template");     // Catch: Exception -> L9
        CardHeaderView r3 = (CardHeaderView) ((LynxUI) this).mView;     // Catch: Exception -> L9
        r3.getClass();     // Catch: Exception -> L9
        r3.a = new CardHeaderView.a(r13, null, null);     // Catch: Exception -> L9
        ((CardHeaderView) ((LynxUI) this).mView).setBackground(M(((CardHeaderView) ((LynxUI) this).mView).getContext(), Color.parseColor(r2)));     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("UniversalCardHeaderBgUI", "parse color " + e);
        goto L23
    L11:
        Log.i("UniversalCardHeaderBgUI", "setProps using gradient");
        ReadableArray r14 = r12.getArray("gradientColors");     // Catch: Exception -> L21
        if (r14 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L23;
        int r7 = Color.parseColor(r14.getString(0));     // Catch: Exception -> L21
        int r15 = Color.parseColor(r14.getString(1));     // Catch: Exception -> L21
        CardHeaderView r8 = (CardHeaderView) ((LynxUI) this).mView;     // Catch: Exception -> L21
        Integer r9 = Integer.valueOf(r7);     // Catch: Exception -> L21
        Integer r10 = Integer.valueOf(r15);     // Catch: Exception -> L21
        r8.getClass();     // Catch: Exception -> L21
        r8.a = new CardHeaderView.a(null, r9, r10);     // Catch: Exception -> L21
        ((CardHeaderView) ((LynxUI) this).mView).setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r7, r15}));     // Catch: Exception -> L21
        goto L23
    L15:
        if (r14.size() != 2) goto L17;
        r6 = true;
    L21:
        e = move-exception;
        Log.e("UniversalCardHeaderBgUI", "parse gradientColors " + e);
    L23:
        TraceEvent.endSection("UniversalCardHeaderBgUI.setProps");
    }

    public static Drawable M(Context r9, int r10) {
        if (r10 != ContextCompat.getColor(r9, 2131109055)) goto L5;
        int r0 = ContextCompat.getColor(r9, 2131109053);
    L6:
        hz7.a r1 = new hz7.a();
        r1.setColor(r10);
        r1.b(r0);
        r1.f = DeviceUtils.getScreenDensity(r9);
        int r2 = UIHelper.dp2px(1.0f);
        GradientDrawable r4 = new GradientDrawable();
        r4.setStroke(r2, UDColorUtils.getColor(r9, 2131109335));
        InsetDrawable r11 = new InsetDrawable(r4, 0, 0, 0, -2);
        Log.i("UniversalCardHeaderBgUI", "generateMessageCardHeader, cardColor=" + r10 + ", baseColor=" + r0);
        return new LayerDrawable(new Drawable[]{r1, r11});
    L5:
        r0 = ContextCompat.getColor(r9, 2131109054);
        goto L6
    }
}

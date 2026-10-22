package com.bytedance.ai.view.popup.params;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.utils.l;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u0013\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "Lcom/bytedance/ai/view/popup/params/AbsAppletPopupSchemaParam;", "<init>", "()V", "resizeDurationInMillSeconds", "", "getResizeDurationInMillSeconds", "()J", "setResizeDurationInMillSeconds", "(J)V", "isLandscape", "", "context", "Landroid/content/Context;", "getRealGravity", "", "getRealWidth", "", "getRealHeight", "getRealTransitionAnimation", "isIn", "adjustValues", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPopupSchemaParam extends AbsAppletPopupSchemaParam {
    private long resizeDurationInMillSeconds;

    public AppletPopupSchemaParam() {
        this.resizeDurationInMillSeconds = 300;
    }

    public final void adjustValues() {
        if (getSelfAdaptiveHeight() == false) goto L6;
        setHeight(-1);
    L6:
        if (getHeight() != (-1)) goto L14;
        String r0 = getGravity();
        if (Intrinsics.areEqual(r0, "bottom") == false) goto L11;
        setHeight(l.b(null));
        goto L14
    L11:
        if (Intrinsics.areEqual(r0, "center") == false) goto L14;
        setHeight(o.a(400.0f));
    L14:
        if (getWidth() != (-1)) goto L22;
        String r1 = getGravity();
        if (Intrinsics.areEqual(r1, "bottom") == false) goto L19;
        setWidth(l.c(null));
        goto L22
    L19:
        if (Intrinsics.areEqual(r1, "center") == false) goto L22;
        setWidth(o.a(300.0f));
    L22:
        if (getSelfAdaptiveHeight() == true) goto L27;
        if (getVariableHeight() <= getHeight()) goto L27;
        setDragHeight(getVariableHeight());
        setDragBack(true);
        setDragByGesture(true);
        setEnablePullDownClose(true);
        setTransitionAnimationIn(AnimationStyle.SLIDE.getValue());
        setGravity("bottom");
    L27:
        if (getMinMarginTop() <= 0) goto L30;
        setKeyboardAdjust(2);
    L30:
        if (getTransStatusBar() == false) goto L40;
        setKeyboardCompat(true);
    L40:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L37
        long r11 = (long) (CastFloatProtector.parseFloat(getResizeDuration()) * IServerListener.WHAT_BYTELINK_SINK_ERROR);     // Catch: Throwable -> L37
        this.resizeDurationInMillSeconds = r11;     // Catch: Throwable -> L37
        if (r11 >= 0) goto L35;
        this.resizeDurationInMillSeconds = 300;     // Catch: Throwable -> L37
    L35:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final long getResizeDurationInMillSeconds() {
        return this.resizeDurationInMillSeconds;
    }

    public static boolean a(Context r1) {
        if (r1 == null) goto L10;
        Resources r10 = r1.getResources();
        if (r10 == null) goto L10;
        Configuration r11 = r10.getConfiguration();
        if (r11 == null) goto L10;
        if (r11.orientation != 2) goto L10;
        return true;
    L10:
        return false;
    }

    public final String getRealGravity(Context r10) {
        String r0 = getGravity();
        if (a(r10) == true) goto L5;
        return r0;
    L5:
        if (getLandscapeGravity().length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L10;
        return r0;
    L10:
        return getLandscapeGravity();
    L7:
        r11 = false;
        goto L8
    }

    public final int getRealHeight(Context r10) {
        int r0 = getHeight();
        if (a(r10) == true) goto L5;
        return r0;
    L5:
        if (getLandscapeHeight() > 0) goto L7;
        return r0;
    L7:
        return getLandscapeHeight();
    }

    public final int getRealWidth(Context r10) {
        int r0 = getWidth();
        if (a(r10) == true) goto L5;
        return r0;
    L5:
        if (getLandscapeWidth() > 0) goto L7;
        return r0;
    L7:
        return getLandscapeWidth();
    }

    public final void setResizeDurationInMillSeconds(long r1) {
        this.resizeDurationInMillSeconds = r1;
    }

    public final String getRealTransitionAnimation(Context r1, boolean r10) {
        if (r10 == false) goto L4;
        String r11 = getTransitionAnimationIn();
    L6:
        if (a(r1) == true) goto L8;
        return r11;
    L8:
        if (getLandscapeTransitionAnimation().length() <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
        return r11;
    L13:
        return getLandscapeTransitionAnimation();
    L10:
        r12 = false;
        goto L11
    L4:
        r11 = getTransitionAnimationOut();
        goto L6
    }

    public static /* synthetic */ String getRealTransitionAnimation$default(AppletPopupSchemaParam r0, Context r1, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L6;
        r10 = true;
    L6:
        return r0.getRealTransitionAnimation(r1, r10);
    }
}

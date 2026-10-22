package com.obric.aiproactive.ui.preference;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/preference/RuleEditorAlertDialog;", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "context", "Landroid/content/Context;", "withHeightMatchParent", "", "<init>", "(Landroid/content/Context;Z)V", "onOutsideTouch", "Lkotlin/Function0;", "", "getOnOutsideTouch", "()Lkotlin/jvm/functions/Function0;", "setOnOutsideTouch", "(Lkotlin/jvm/functions/Function0;)V", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "isOutsideTouch", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class r extends com.obric.oui.dialog.v2.alert.a {
    private Function0<Unit> d;

    public r(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r4);
    }

    private final boolean a(MotionEvent r5) {
        Window r4 = getWindow();
        if (r4 == null) goto L21;
        View r6 = r4.getDecorView();
        if (r6 == null) goto L21;
        if (r5.getAction() != 4) goto L10;
        return true;
    L10:
        if (r5.getX() >= 0.0f) goto L12;
        return true;
    L12:
        if (r5.getY() >= 0.0f) goto L14;
        return true;
    L14:
        if (r5.getX() <= r6.getWidth()) goto L16;
        return true;
    L16:
        if (r5.getY() <= r6.getHeight()) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (r5.getAction() != 4) goto L24;
        return true;
    L24:
        return false;
    }

    public final void a(Function0<Unit> r3) {
        this.d = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (a(r2) == false) goto L12;
        if (a.b(r2.getAction()) == false) goto L13;
        Function0<Unit> r1 = this.d;
        if (r1 == null) goto L14;
        r1.invoke();
        return true;
    L14:
        return true;
    L13:
        return true;
    L12:
        return super.onTouchEvent(r2);
    }
}

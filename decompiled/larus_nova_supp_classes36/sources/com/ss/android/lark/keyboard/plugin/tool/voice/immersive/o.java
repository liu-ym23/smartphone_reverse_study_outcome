package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements View.OnTouchListener {
    public final /* synthetic */ AsrInputVoiceView a;
    public final /* synthetic */ FrameLayout b;

    public o(AsrInputVoiceView r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.AsrInputVoiceView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r9, MotionEvent r10) {
        Log.i("AsrInputVoiceView", "On touch decor view, event.action: " + r10.getAction());
        ?? r0 = this.a;
        if (r0.s == true) goto L17;
        Intrinsics.checkNotNull(r10);
        if (r9 != null) goto L8;
        boolean r11 = false;
    L13:
        if (r11 == true) goto L15;
        AsrInputVoiceView.c6(this.a).forceAsrSessionFinish(CancelAsrTimeoutState.CancelByClick, true);
        Log.i("AsrInputVoiceView", "cancel asr after record by click ");
    L15:
        Log.i("AsrInputVoiceView", "set touch through view gone");
        this.b.setVisibility(8);
        return false;
    L8:
        Region r4 = r0.e.v().e().f();
        int[] r5 = {0, 0};
        if (sob.c.a(r0) == false) goto L11;
        r9.getLocationInWindow(r5);
        int r12 = r5[0];
        int r6 = r5[1];
        r0.getLocationInWindow(r5);
        r5[0] = ((int) r10.getX()) + (r12 - r5[0]);
        r5[1] = ((int) r10.getY()) + (r6 - r5[1]);
    L12:
        r11 = r4.contains(r5[0], r5[1]) | r4.isEmpty();
        goto L13
    L11:
        r0.getLocationOnScreen(r5);
        r5[0] = (int) (r10.getRawX() - r5[0]);
        r5[1] = (int) (r10.getRawY() - r5[1]);
        goto L12
    L17:
        return true;
    }
}

package com.ss.android.lark.keyboard.classicinput.base;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b implements mob.a {
    public final c a;
    public final lob.b b;
    public View c;
    public com.ss.android.lark.keyboard.b d;

    @Override // mob.a
    public final void A() {
    }

    public abstract void g();

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        com.ss.android.lark.keyboard.classicinput.a r0 = (com.ss.android.lark.keyboard.classicinput.a) this;
        c r1 = r0.a;
        r1.getClass();
        Log.i("KeyBoard", "additionPluginController stop");
        Iterator r2 = ((HashMap) r1.a).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((IInputSupportAdditionPlugin) ((Map.Entry) r2.next()).getValue()).onStop();
        goto L4
    L6:
        r0.v();
    }

    public final com.ss.android.lark.keyboard.b a() {
        com.ss.android.lark.keyboard.b r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public final View e() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public b() {
        this.a = new c();
        this.b = new lob.b();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        a().e().of(this).d(ImeState.class, new BaseInputSupportPlugin$initKeyboardStatusHandler$1(this));
        Lifecycle r0 = a().l().b;
        if (r0 == null) goto L5;
        r0.addObserver(new BaseInputSupportPlugin$initKeyboardStatusHandler$2(this));
    L5:
        com.ss.android.lark.keyboard.classicinput.a r1 = (com.ss.android.lark.keyboard.classicinput.a) this;
        ImageView r2 = r1.p;
        CharSequence r3 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPostDraftDotIV");
        r2 = null;
    L8:
        r2.setVisibility(4);
        KeyboardFunctionEditText r4 = r1.o;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mMsgInputET");
        r4 = null;
    L11:
        Editable r5 = r4.getText();
        if (r5 == null) goto L14;
        r3 = StringsKt.trim(r5);
    L14:
        r1.u(!TextUtils.isEmpty(r3));
    }

    @Override // mob.a
    public final void s(lob.a r3) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        lob.b r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "watcher");
        ((ArrayList) r1.a).add(r3);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }
}

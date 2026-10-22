package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.chat.chatwindow.biz.component.threadkeyboard.IThreadKeyboardComponent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class KeyboardWrapper implements IKeyboardWrapper {
    public final Context a;
    public final IKeyboardComponent b;
    public final IFuncKeyboardComponent c;
    public final IThreadKeyboardComponent d;
    public int e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void I() {
        int r0 = this.e;
        if (r0 != 0) goto L5;
        IKeyboardComponent r1 = this.b;
        if (r1 == null) goto L23;
        r1.I();
        return;
    L23:
        return;
    L5:
        if (r0 != 1) goto L7;
        IFuncKeyboardComponent r2 = this.c;
        if (r2 == null) goto L21;
        r2.I();
        return;
    L21:
        return;
    L7:
        if (r0 != 2) goto L24;
        IThreadKeyboardComponent r3 = this.d;
        if (r3 == null) goto L19;
        r3.yY();
        return;
    L19:
        return;
    }

    public final ArrayList<IKeyboardWrapper.a> a() {
        return (ArrayList) this.f.getValue();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void hideKeyboard() {
        int r0 = this.e;
        if (r0 != 0) goto L5;
        IKeyboardComponent r1 = this.b;
        if (r1 == null) goto L23;
        r1.hideKeyboard();
        return;
    L23:
        return;
    L5:
        if (r0 != 1) goto L7;
        IFuncKeyboardComponent r2 = this.c;
        if (r2 == null) goto L21;
        r2.hideKeyboard();
        return;
    L21:
        return;
    L7:
        if (r0 != 2) goto L24;
        IThreadKeyboardComponent r3 = this.d;
        if (r3 == null) goto L19;
        r3.Av();
        return;
    L19:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final int d0() {
        return this.e;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void i0(final Function0 r8) {
        IKeyboardComponent r0 = this.b;
        final int r1 = 0;
        if (r0 == null) goto L5;
        r0.GA(false);
    L5:
        Function0<Unit> r2 = new KeyboardWrapper$changeToKeyboard$2(r8, this, r1);
        int r9 = this.e;
        if (r9 != 0) goto L8;
        r2.invoke();
        return;
    L8:
        IFuncKeyboardComponent r3 = this.c;
        View r4 = null;
        if (r3 == null) goto L11;
        View r5 = r3.getRootView();
    L12:
        IKeyboardComponent r6 = this.b;
        if (r6 == null) goto L15;
        View r7 = r6.getRootView();
    L16:
        IThreadKeyboardComponent r10 = this.d;
        if (r10 == null) goto L19;
        r4 = r10.getRootView();
    L19:
        if (r5 == null) goto L28;
        if (r7 == null) goto L28;
        if (r4 == null) goto L28;
        Iterator<T> r11 = a().iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        ((IKeyboardWrapper.a) r11.next()).a(r9, 0);
        goto L25
    L27:
        r5.setVisibility(8);
        r4.setVisibility(8);
        r7.setVisibility(0);
        r7.setTranslationY(0.0f);
        r7.setAlpha(1.0f);
        r7.post(new d(this, r2, r9));
        return;
    L28:
        r2.invoke();
        return;
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void l0(KeyboardWrapperConfigurator.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a().add(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void r(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r3) {
        Intrinsics.checkNotNullParameter("banned_select", "key");
        Intrinsics.checkNotNullParameter(r3, "banReason");
        int r0 = this.e;
        if (r0 != 0) goto L5;
        IKeyboardComponent r1 = this.b;
        if (r1 == null) goto L23;
        r1.f6(r3);
        return;
    L23:
        return;
    L5:
        if (r0 != 1) goto L7;
        IFuncKeyboardComponent r2 = this.c;
        if (r2 == null) goto L21;
        r2.f6(r3);
        return;
    L21:
        return;
    L7:
        if (r0 != 2) goto L24;
        IThreadKeyboardComponent r4 = this.d;
        if (r4 == null) goto L19;
        r4.b40();
        return;
    L19:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper
    public final void start(Function1 r2) {
        this.e = 0;
        if (r2 == null) goto L6;
        r2.invoke(0);
        return;
    }

    public KeyboardWrapper(Context r2, IKeyboardComponent r3, IFuncKeyboardComponent r4, IThreadKeyboardComponent r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KeyboardWrapper$listeners$2.INSTANCE);
        this.g = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardWrapper$animators$2(this));
    }
}

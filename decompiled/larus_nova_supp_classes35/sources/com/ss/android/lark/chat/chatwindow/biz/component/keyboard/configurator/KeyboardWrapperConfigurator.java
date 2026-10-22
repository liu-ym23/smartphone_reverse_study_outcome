package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator;

import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorKey;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.IKeyboardTopExtendComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapperComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.threadkeyboard.IThreadKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner;
import com.ss.android.lark.keyboard.event.ForceHeightChange;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@ConfiguratorKey(ConfiguratorType.KEYBOARD_WRAPPER)
public final class KeyboardWrapperConfigurator implements l3c.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements IKeyboardWrapper.a {
        public final /* synthetic */ IKeyboardComponent a;
        public final /* synthetic */ e b;
        public final /* synthetic */ IFuncKeyboardComponent c;
        public final /* synthetic */ d d;
        public final /* synthetic */ c e;
        public final /* synthetic */ IThreadKeyboardComponent f;
        public final /* synthetic */ f g;
        public final /* synthetic */ IKeyboardTopExtendComponent h;
        public final /* synthetic */ Lazy<com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a> i;
        public final /* synthetic */ IMessageListComponent j;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper.a
        public final void b(int r3) {
            IMessageListComponent r0 = this.j;
            if (r0 == null) goto L5;
            r0.MH(ScrollScene.KEYBOARD_TYPE_CHANGE);
        L5:
            if (r3 != 0) goto L15;
            IKeyboardTopExtendComponent r4 = this.h;
            if (r4 == null) goto L9;
            r4.Id();
        L9:
            IKeyboardComponent r5 = this.a;
            if (r5 == null) goto L16;
            com.ss.android.lark.keyboard.b r6 = r5.n();
            if (r6 == null) goto L17;
            k r1 = r6.e();
            ForceHeightChange.Factory r2 = ForceHeightChange.c;
            int r7 = com.ss.android.lark.c.a(r6);
            r2.getClass();
            ForceHeightChange r8 = (ForceHeightChange) r2.a();
            ((HeightChange) r8).a = r7;
            k.a.a(r1, r8);
            return;
        L17:
            return;
        L16:
            return;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper.a
        public final void a(int r2, int r3) {
            if (r2 != r3) goto L5;
            return;
        L5:
            if (r3 != 0) goto L7;
            IKeyboardComponent r4 = this.a;
            if (r4 == null) goto L60;
            e r0 = this.b;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            if (r0 == null) goto L57;
            r4.F20(r0);
        L57:
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r1 = (com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a) this.i.getValue();
            Intrinsics.checkNotNullParameter(r4, "<this>");
            if (r1 == null) goto L60;
            r4.lD(r1);
        L60:
            IFuncKeyboardComponent r5 = this.c;
            if (r5 == null) goto L68;
            d r6 = this.d;
            Intrinsics.checkNotNullParameter(r5, "<this>");
            if (r6 == null) goto L65;
            r5.aV(r6);
        L65:
            c r7 = this.e;
            Intrinsics.checkNotNullParameter(r5, "<this>");
            if (r7 == null) goto L68;
            r5.pL(r7);
        L68:
            IThreadKeyboardComponent r8 = this.f;
            if (r8 == null) goto L76;
            r8.l(this.g);
            return;
        L76:
            return;
        L7:
            if (r3 != 1) goto L9;
            IKeyboardComponent r9 = this.a;
            if (r9 == null) goto L38;
            e r10 = this.b;
            Intrinsics.checkNotNullParameter(r9, "<this>");
            if (r10 == null) goto L35;
            r9.qk(r10);
        L35:
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r11 = (com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a) this.i.getValue();
            Intrinsics.checkNotNullParameter(r9, "<this>");
            if (r11 == null) goto L38;
            r9.lS(r11);
        L38:
            IFuncKeyboardComponent r12 = this.c;
            if (r12 == null) goto L46;
            d r13 = this.d;
            Intrinsics.checkNotNullParameter(r12, "<this>");
            if (r13 == null) goto L43;
            r12.FE(r13);
        L43:
            c r14 = this.e;
            Intrinsics.checkNotNullParameter(r12, "<this>");
            if (r14 == null) goto L46;
            r12.rk(r14);
        L46:
            IThreadKeyboardComponent r15 = this.f;
            if (r15 == null) goto L49;
            r15.l(this.g);
        L49:
            IKeyboardTopExtendComponent r16 = this.h;
            if (r16 == null) goto L74;
            r16.gt();
            return;
        L74:
            return;
        L9:
            if (r3 != 2) goto L77;
            IKeyboardComponent r17 = this.a;
            if (r17 == null) goto L19;
            com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a r18 = (com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a) this.i.getValue();
            Intrinsics.checkNotNullParameter(r17, "<this>");
            if (r18 == null) goto L16;
            r17.lS(r18);
        L16:
            e r19 = this.b;
            Intrinsics.checkNotNullParameter(r17, "<this>");
            if (r19 == null) goto L19;
            r17.qk(r19);
        L19:
            IFuncKeyboardComponent r20 = this.c;
            if (r20 == null) goto L27;
            d r21 = this.d;
            Intrinsics.checkNotNullParameter(r20, "<this>");
            if (r21 == null) goto L24;
            r20.aV(r21);
        L24:
            c r22 = this.e;
            Intrinsics.checkNotNullParameter(r20, "<this>");
            if (r22 == null) goto L27;
            r20.pL(r22);
        L27:
            IThreadKeyboardComponent r23 = this.f;
            if (r23 == null) goto L72;
            r23.m(this.g);
            return;
        L72:
            return;
        }

        public b(IKeyboardComponent r1, e r2, IFuncKeyboardComponent r3, d r4, c r5, IThreadKeyboardComponent r6, f r7, IKeyboardTopExtendComponent r8, Lazy<com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.a> r9, IMessageListComponent r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public static final class c implements IFuncKeyboardComponent.c {
        public final /* synthetic */ IKeyboardTopExtendComponent a;

        public c(IKeyboardTopExtendComponent r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent.c
        public final void a(boolean r1) {
            if (r1 == true) goto L6;
            IKeyboardTopExtendComponent r2 = this.a;
            if (r2 == null) goto L10;
            r2.wC();
            return;
        L10:
            return;
        L6:
            IKeyboardTopExtendComponent r3 = this.a;
            if (r3 == null) goto L12;
            r3.fb();
            return;
        }
    }

    public static final class d implements IFuncKeyboardComponent.b {
        public final /* synthetic */ MessageListAnimationContainer a;
        public final /* synthetic */ IMessageListComponent b;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent.b
        public final void b(int r3) {
            MessageListAnimationContainer r0 = this.a;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L12;
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            r2.bottomMargin = r3;
            r0.setLayoutParams(r2);
            IMessageListComponent r4 = this.b;
            if ((r4 instanceof IMessageListComponentInner) == false) goto L7;
            IMessageListComponentInner r5 = (IMessageListComponentInner) r4;
        L8:
            if (r5 == null) goto L13;
            r5.XE();
            return;
        L13:
            return;
        L7:
            r5 = null;
            goto L8
        L12:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        public d(MessageListAnimationContainer r1, IMessageListComponent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements IKeyboardComponent.a {
        public final /* synthetic */ IKeyboardTopExtendComponent a;

        public e(IKeyboardTopExtendComponent r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent.a
        public final void a(boolean r1) {
            if (r1 == true) goto L6;
            IKeyboardTopExtendComponent r2 = this.a;
            if (r2 == null) goto L10;
            r2.wC();
            return;
        L10:
            return;
        L6:
            IKeyboardTopExtendComponent r3 = this.a;
            if (r3 == null) goto L12;
            r3.fb();
            return;
        }
    }

    public static final class f implements com.ss.android.lark.biz.im.api.extension.chat_window.e {
        public final /* synthetic */ IKeyboardTopExtendComponent a;
        public final /* synthetic */ IMessageListComponent b;

        public f(IKeyboardTopExtendComponent r1, IMessageListComponent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Inject
    public KeyboardWrapperConfigurator() {
    }

    public final void a(l3c.f r15) {
        Intrinsics.checkNotNullParameter(r15, "rt");
        IKeyboardWrapperComponent r0 = (IKeyboardWrapperComponent) r15.a(IKeyboardWrapperComponent.class);
        if (r0 != null) goto L6;
        Log.w("KeyboardWrapperConfigurator", "keyboardWrapperComponent == null");
        return;
    L6:
        IKeyboardWrapper r1 = r0.wA();
        final MessageListAnimationContainer r2 = (MessageListAnimationContainer) ViewCompat.requireViewById(r15.getFragment().requireView(), 2131380364);
        final IMessageListComponent r13 = (IMessageListComponent) r15.a(IMessageListComponent.class);
        IKeyboardTopExtendComponent r11 = (IKeyboardTopExtendComponent) r15.a(IKeyboardTopExtendComponent.class);
        final IKeyboardComponent r4 = (IKeyboardComponent) r15.a(IKeyboardComponent.class);
        IFuncKeyboardComponent r6 = (IFuncKeyboardComponent) r15.a(IFuncKeyboardComponent.class);
        IThreadKeyboardComponent r9 = (IThreadKeyboardComponent) r15.a(IThreadKeyboardComponent.class);
        final e r5 = new e(r11);
        c r8 = new c(r11);
        d r7 = new d(r2, r13);
        f r10 = new f(r11, r13);
        final Lazy r12 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new KeyboardWrapperConfigurator$configure$keyboardEventHandler$2(r2, r13));
        r1.start(new KeyboardWrapperConfigurator$configure$1(r4, r5, r12));
        r1.l0(new b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13));
    }
}

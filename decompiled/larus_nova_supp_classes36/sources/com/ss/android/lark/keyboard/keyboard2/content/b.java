package com.ss.android.lark.keyboard.keyboard2.content;

import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.j;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.utils.TransitionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.keyboard.keyboard2.content.c, com.ss.android.lark.keyboard.keyboard2.c {
    public static final PathInterpolator k = null;
    public final KeyboardMainContent a;
    public com.ss.android.lark.keyboard.b b;
    public BasicKeyboard c;
    public FrameLayout d;
    public final Map<String, IKeyboardContent> e;
    public final Map<String, View> f;
    public final List<IKeyboardContent> g;
    public IKeyboardContent h;
    public boolean i;
    public boolean j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.keyboard2.content.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0151b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IKeyboardContent.ViewInitStrategy.values().length];
            r0[IKeyboardContent.ViewInitStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IKeyboardContent.ViewInitStrategy.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements MessageQueue.IdleHandler {
        public final /* synthetic */ b a;
        public final /* synthetic */ IKeyboardContent b;

        public c(b r1, IKeyboardContent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.a.u(this.b);
            return false;
        }
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        this.i = true;
        this.c = (BasicKeyboard) r().y(j.x);
        Iterator r0 = ((ArrayList) this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        n((IKeyboardContent) r0.next());
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        this.i = false;
        Iterator r0 = ((LinkedHashMap) this.e).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IKeyboardContent) ((Map.Entry) r0.next()).getValue()).onDestroy();
        goto L4
    }

    static {
        k = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final IKeyboardContent getContent() {
        Intrinsics.checkNotNullParameter(ImmersiveVoiceInputComponent.a, TabAppInfo.IMAGE_JSON_KEY);
        return (IKeyboardContent) ((LinkedHashMap) this.e).get("ImmersiveVoiceKeyboardKey");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final IKeyboardContent l() {
        IKeyboardContent r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        return null;
    L6:
        return r0;
    }

    public final com.ss.android.lark.keyboard.b r() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final KeyboardMainContent e() {
        return this.a;
    }

    public b(KeyboardMainContent r2) {
        Intrinsics.checkNotNullParameter(r2, "mainContent");
        this.a = r2;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new ArrayList();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final void g(boolean r2) {
        a(KeyboardMainContent.m, r2);
    }

    public final void n(IKeyboardContent r3) {
        r3.onCreate();
        IKeyboardContent.ViewInitStrategy r0 = r3.a();
        int r1 = C0151b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        u(r3);
        return;
    L5:
        if (r1 != 2) goto L11;
        Looper.myQueue().addIdleHandler(new c(this, r3));
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final View u(IKeyboardContent r8) {
        IKeyboardContent.a r0 = r8.getKey();
        Map<String, View> r1 = this.f;
        String r2 = r0.getTag();
        LinkedHashMap r3 = (LinkedHashMap) r1;
        Object r4 = r3.get(r2);
        Object r5 = r4;
        if (r4 != null) goto L19;
        FrameLayout r6 = this.d;
        FrameLayout r7 = null;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r6 = null;
    L7:
        View r9 = r8.b(r6);
        r9.setVisibility(8);
        if (r9.getLayoutParams() != null) goto L10;
    L12:
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -2);
        r10.gravity = 80;
        r9.setLayoutParams(r10);
    L13:
        FrameLayout r11 = this.d;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
    L17:
        r7.addView(r9);
        r3.put(r2, r9);
        r5 = r9;
        goto L19
    L16:
        r7 = r11;
        goto L17
    L10:
        if ((r9.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L12;
    L19:
        return (View) r5;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.c
    public final void a(IKeyboardContent.a r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, TabAppInfo.IMAGE_JSON_KEY);
        if (this.j == false) goto L6;
        Log.i("KeyboardContentManager", "is in content change transition, ignore change");
        return;
    L6:
        IKeyboardContent r0 = (IKeyboardContent) ((LinkedHashMap) this.e).get(r14.getTag());
        if (r0 != null) goto L10;
        Log.e("KeyboardContentManager", "content not found, key: " + r14.getTag());
        return;
    L10:
        View r1 = u(r0);
        IKeyboardContent r2 = this.h;
        IKeyboardContent r5 = null;
        if (r2 != null) goto L13;
        r1.setVisibility(0);
        r0.onShow();
        IKeyboardContent.a r16 = null;
    L59:
        this.h = r0;
        r0.onShow();
        IKeyboardContent r3 = this.h;
        if (r3 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
    L63:
        r5.c(r().z().height());
        k.a.a(r().e(), new com.ss.android.lark.keyboard.keyboard2.content.a(r16, r14));
        return;
    L62:
        r5 = r3;
        goto L63
    L13:
        final View r4 = u(r2);
        if (Intrinsics.areEqual(r4, r1) == true) goto L49;
        if (r15 == false) goto L47;
        PathInterpolator r12 = k;
        final Transition r17 = new Slide().addTarget(r4).addTarget(r1);
        r17.setInterpolator(r12);
        r17.setDuration(285);
        r17.addListener(new KeyboardContentManagerImpl$changeContentWithAnimation$1(this, r17, r4));
        Lazy r6 = TransitionUtils.a;
        FrameLayout r7 = this.d;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r7 = null;
    L21:
        if (TransitionUtils.a(r7) == true) goto L28;
        FrameLayout r8 = this.d;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r8 = null;
    L26:
        if (ViewCompat.isLaidOut(r8) == false) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L37;
        BasicKeyboard r10 = this.c;
        if (r10 == null) goto L33;
        r10.n = true;
    L33:
        FrameLayout r11 = this.d;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r11 = null;
    L36:
        TransitionManager.beginDelayedTransition(r11, r17);
    L37:
        r4.setVisibility(4);
        r1.setVisibility(0);
        FrameLayout r18 = this.d;
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r18 = null;
    L40:
        r18.setMinimumHeight(Math.max(r4.getHeight(), r1.getHeight()));
        BasicKeyboard r19 = this.c;
        if (r19 == null) goto L43;
        r19.U();
    L43:
        FrameLayout r110 = this.d;
        if (r110 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r110 = null;
    L46:
        k.a.a(r().e(), new com.ss.android.lark.keyboard.event.a(r110.getHeight(), r1.getMeasuredHeight(), 285, r12));
    L48:
        r().z();
    L28:
        r9 = false;
        goto L29
    L47:
        r4.setVisibility(8);
        r1.setVisibility(0);
    L49:
        IKeyboardContent r111 = this.h;
        if (r111 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r111 = null;
    L52:
        r111.onHide();
        IKeyboardContent r112 = this.h;
        if (r112 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r112 = null;
    L55:
        r112.c(0);
        IKeyboardContent r113 = this.h;
        if (r113 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("currentContent");
        r113 = null;
    L58:
        r16 = r113.getKey();
        goto L59
    }
}

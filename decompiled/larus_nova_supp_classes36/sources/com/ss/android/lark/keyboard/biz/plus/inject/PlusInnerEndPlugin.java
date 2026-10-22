package com.ss.android.lark.keyboard.biz.plus.inject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import wnb.e;
import wxa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PlusInnerEndPlugin implements wnb.b<PlusInnerEndPlugin> {
    public static final b i = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public final Lazy b;
    public View c;
    public com.ss.android.lark.keyboard.ime.c d;
    public Job e;
    public Boolean f;
    public com.ss.android.lark.keyboard.b g;
    public wnb.c h;

    public static final class a implements wxa.c {
        public final /* synthetic */ PlusInnerEndPlugin a;

        public final void a(UplinkFileEntity r2) {
            Intrinsics.checkNotNullParameter(r2, "entity");
        }

        public a(PlusInnerEndPlugin r1) {
            this.a = r1;
        }

        public final void b(UplinkFileEntity r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            PlusInnerEndPlugin r0 = this.a;
            r0.getClass();
            if (f.d(r5) == false) goto L5;
        L6:
            int r6 = xob.a.a;
            Context r7 = r0.a.a.requireContext();
            String r1 = r0.a.c.getId();
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r1, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r1), new Pair("click", "image_media_insert"), new Pair("target", "none"), new Pair("keyboard_status", xob.a.a(r7))});
            return;
        L5:
            if (f.e(r5) == true) goto L6;
        }
    }

    public static final class b implements wnb.b.a<PlusInnerEndPlugin> {
        public b() {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PlusInnerEndPlugin a;

        public c(PlusInnerEndPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.g().z().B() == false) goto L12;
            m r4 = this.a.g().H().k();
            if (r4 == null) goto L7;
            KeyboardMenuItemKey r5 = r4.g();
        L9:
            if (r5 != KeyboardMenuItemKey.Plus) goto L12;
            this.a.g().z().a();
            PlusInnerEndPlugin.f(this.a, false, "plus_click_close");
            return;
        L7:
            r5 = null;
        L12:
            PlusInnerEndPlugin.f(this.a, true, "plus_click_open");
            this.a.g().H().f(KeyboardMenuItemKey.Plus);
        }
    }

    public static final class d implements dya.a {
        public final /* synthetic */ PlusInnerEndPlugin a;

        public d(PlusInnerEndPlugin r1) {
            this.a = r1;
        }

        public final void a(boolean r8) {
            PlusInnerEndPlugin r0 = this.a;
            Log.i("PlusInnerEndPlugin", r0.k("FLOW_PLUS_EXTERNAL_SELECT_BEFORE", Boolean.valueOf(r8), "external_callback", r0.f));
            PlusInnerEndPlugin r1 = this.a;
            com.ss.android.lark.keyboard.keyboard2.d r2 = r1.g().H();
            if (r8 == false) goto L8;
            r2.w(KeyboardMenuItemKey.Plus);
            View r3 = r1.c;
            if (r3 == null) goto L7;
            PlusInnerEndPlugin.m(r3, r1.j(), true);
        L7:
            Log.i("PlusInnerEndPlugin", "select plus item.");
        L18:
            PlusInnerEndPlugin r4 = this.a;
            Log.i("PlusInnerEndPlugin", r4.k("FLOW_PLUS_EXTERNAL_SELECT_AFTER", Boolean.valueOf(r8), "external_callback", r4.f));
            return;
        L8:
            m r5 = r2.k();
            if (r5 == null) goto L11;
            KeyboardMenuItemKey r6 = r5.g();
        L13:
            if (r6 != KeyboardMenuItemKey.Plus) goto L15;
            Log.i("PlusInnerEndPlugin", "unSelect plus item.");
            r2.h();
        L15:
            View r7 = r1.c;
            if (r7 == null) goto L18;
            PlusInnerEndPlugin.m(r7, false, true);
            goto L18
        L11:
            r6 = null;
            goto L13
        }
    }

    static {
        i = new b();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        final View r1 = LayoutInflater.from(this.a.a.requireContext()).inflate(2131561609, null);
        r1.setOnClickListener(new c(this));
        this.c = r1;
        Intrinsics.checkNotNull(r1);
        if (this.d != null) goto L9;
        com.ss.android.lark.keyboard.ime.a r2 = g().z();
        m(r1, j(), false);
        com.ss.android.lark.keyboard.ime.c r3 = r2.v(this);
        r3.a(new PlusInnerEndPlugin$bindPanelShowHideRotate$1$1(this, r1));
        r3.d(new PlusInnerEndPlugin$bindPanelShowHideRotate$1$2(this, r1));
        this.d = r3;
    L9:
        Job r4 = this.e;
        if (r4 == null) goto L12;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L12:
        this.e = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.a), null, null, new PlusInnerEndPlugin$bindPanelEvent$1(this, null), 3, null);
        return r1;
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    public final com.ss.android.lark.keyboard.b g() {
        com.ss.android.lark.keyboard.b r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        com.ss.android.lark.keyboard.ime.c r0 = this.d;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.d = null;
        View r1 = this.c;
        if (r1 == null) goto L10;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        this.c = null;
        Job r3 = this.e;
        if (r3 == null) goto L13;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L13:
        this.e = null;
        Boolean r4 = this.f;
        Log.i("PlusInnerEndPlugin", k("FLOW_PLUS_STATE_RESET", r4, "destroy", r4));
        this.f = null;
    }

    public final boolean j() {
        if (g().z().B() == false) goto L15;
        m r0 = g().H().k();
        if (r0 == null) goto L7;
        KeyboardMenuItemKey r1 = r0.g();
    L9:
        if (r1 != KeyboardMenuItemKey.Plus) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r2 = false;
        goto L12
    L7:
        r1 = null;
        goto L9
    L15:
        return false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEnd;
    }

    @Override // wnb.b
    public final wnb.b.a<PlusInnerEndPlugin> getKey() {
        return i;
    }

    public PlusInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r3) {
        Intrinsics.checkNotNullParameter(r3, "keyboardPluginContext");
        this.a = r3;
        Lazy r4 = LazyKt.lazy(new PlusInnerEndPlugin$plusExtension$2(this));
        this.b = r4;
        d r0 = new d(this);
        eya.b r1 = (eya.b) r4.getValue();
        if (r1 == null) goto L5;
        r1.Z6(r0);
    L5:
        eya.b r5 = (eya.b) r4.getValue();
        if (r5 == null) goto L9;
        r5.K3(new a(this));
        return;
    }

    public static String l(Object r0) {
        if (r0 == null) goto L5;
        String r1 = Integer.toHexString(System.identityHashCode(r0));
        if (r1 == null) goto L5;
        return r1;
    L5:
        return "null";
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public static final void f(PlusInnerEndPlugin r5, boolean r6, String r7) {
        Boolean r0 = r5.f;
        if (Intrinsics.areEqual(r0, Boolean.valueOf(r6)) == false) goto L5;
        Log.i("PlusInnerEndPlugin", r5.k("FLOW_PLUS_STATE_SKIP_DUPLICATE", Boolean.valueOf(r6), r7, r0));
        return;
    L5:
        eya.b r1 = (eya.b) r5.b.getValue();
        if (r1 != null) goto L8;
        Log.w("PlusInnerEndPlugin", r5.k("FLOW_PLUS_STATE_EXTENSION_UNAVAILABLE", Boolean.valueOf(r6), r7, r0));
        return;
    L8:
        r5.f = Boolean.valueOf(r6);
        Log.i("PlusInnerEndPlugin", r5.k("FLOW_PLUS_STATE_DISPATCH_BEFORE", Boolean.valueOf(r6), r7, r0));
        r1.d7(r6);
        Log.i("PlusInnerEndPlugin", r5.k("FLOW_PLUS_STATE_DISPATCH_AFTER", Boolean.valueOf(r6), r7, r0));
    }

    public static void m(View r0, boolean r1, boolean r2) {
        if (r1 == false) goto L4;
        float r3 = 45.0f;
    L5:
        if (r2 == true) goto L8;
        r0.animate().cancel();
        r0.setRotation(r3);
        return;
    L8:
        r0.animate().rotation(r3).setDuration(150).start();
        return;
    L4:
        r3 = 0.0f;
        goto L5
    }

    public final String k(String r8, Boolean r9, String r10, Boolean r11) {
        if (this.g == null) goto L5;
        com.ss.android.lark.keyboard.ime.a r0 = g().z();
        m r5 = g().H().k();
        if (r5 == null) goto L9;
        KeyboardMenuItemKey r6 = r5.g();
    L11:
        return r8 + " select=" + r9 + " previous=" + r11 + " source=" + r10 + " keyboardInitialized=true plugin=" + l(this) + " fragment=" + l(this.a.a) + " wrapper=" + l(r0) + " ime=" + r0.getImeState().b() + " panel=" + r0.getPanelState().b() + " wrapperHeight=" + r0.height() + " panelShowing=" + r0.B() + " selected=" + r6;
    L9:
        r6 = null;
        goto L11
    L5:
        return r8 + " select=" + r9 + " previous=" + r11 + " source=" + r10 + " keyboardInitialized=false plugin=" + l(this) + " fragment=" + l(this.a.a);
    }
}

package com.ss.android.lark.keyboard.biz.send.inject;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.biz.camera.inject.CameraInnerStartPlugin;
import com.ss.android.lark.keyboard.biz.plus.inject.PlusInnerEndPlugin;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.widget.richtext.i;
import cya.d;
import cya.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InputContentToggleInnerPlugin implements wnb.b<InputContentToggleInnerPlugin>, l {
    public static final a k = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public c c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Job h;
    public boolean i;
    public boolean j;

    public static final class a implements wnb.b.a<InputContentToggleInnerPlugin> {
        public a() {
        }
    }

    static {
        k = new a();
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(q r1) {
        return false;
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // wnb.b
    public final View a() {
        View r0 = new View(this.a.a.requireContext());
        boolean r2 = false;
        r0.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        r0.setVisibility(8);
        com.ss.android.lark.keyboard.keyboard2.b r1 = f().L();
        if ((r1 instanceof f) == false) goto L5;
        f r3 = (f) r1;
    L7:
        if (this.d == true) goto L25;
        if (r3 == null) goto L25;
        this.d = true;
        r3.p(this);
        Job r5 = this.h;
        if (r5 == null) goto L12;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L12:
        this.h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.a), null, null, new InputContentToggleInnerPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        f().e().of(this).c(znb.a.class, new InputContentToggleInnerPlugin$initAttachmentStateFlow$2(this));
        boolean r4 = !i.l(r3.getContent());
        wxa.a r6 = (wxa.a) this.f.getValue();
        if (r6 == null) goto L19;
        List r7 = r6.q1();
        if (r7 == null) goto L19;
        if ((!r7.isEmpty()) != true) goto L19;
        boolean r8 = true;
    L20:
        this.i = r8;
        if (r4 == true) goto L23;
        if (r8 == true) goto L23;
    L24:
        y(r2);
    L23:
        r2 = true;
    L19:
        r8 = false;
    L25:
        f().e().of(this).d(h.class, new InputContentToggleInnerPlugin$refreshSendUI$1$1(this));
        return r0;
    L5:
        r3 = null;
        goto L7
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, 0, 0);
    }

    public final com.ss.android.lark.keyboard.b f() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    @Override // wnb.b
    public final c h() {
        c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        if (this.d == true) goto L5;
        return;
    L5:
        this.d = false;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        com.ss.android.lark.keyboard.keyboard2.b r2 = f().L();     // Catch: Throwable -> L15
        if ((r2 instanceof f) == false) goto L9;
        f r3 = (f) r2;     // Catch: Throwable -> L15
    L10:
        if (r3 == null) goto L12;
        r3.E(this);     // Catch: Throwable -> L15
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r4);     // Catch: Throwable -> L15
    L17:
        Job r5 = this.h;
        if (r5 == null) goto L20;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L20:
        this.h = null;
        return;
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
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
        return Direction.InnerBottom;
    }

    @Override // wnb.b
    public final wnb.b.a<InputContentToggleInnerPlugin> getKey() {
        return k;
    }

    public InputContentToggleInnerPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.e = LazyKt.lazy(new InputContentToggleInnerPlugin$eventCenter$2(this));
        this.f = LazyKt.lazy(new InputContentToggleInnerPlugin$attachmentExtension$2(this));
        this.g = LazyKt.lazy(new InputContentToggleInnerPlugin$attachmentEntityListStateFlow$2(this));
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r6) {
        this.j = r6;
        wxa.a r7 = (wxa.a) this.f.getValue();
        boolean r0 = true;
        boolean r1 = false;
        if (r7 == null) goto L9;
        List r8 = r7.q1();
        if (r8 == null) goto L9;
        if ((!r8.isEmpty()) != true) goto L9;
        boolean r9 = true;
    L10:
        this.i = r9;
        Editable r10 = f().L().c().getEditableText();
        if (r10 == null) goto L13;
        CharSequence r11 = StringsKt.trim(r10);
    L14:
        boolean r12 = !TextUtils.isEmpty(String.valueOf(r11));
        if (this.i == true) goto L19;
        if (r12 == true) goto L19;
        boolean r2 = false;
    L20:
        if (r2 == false) goto L22;
    L39:
        h().a(SendInnerEndPlugin.q);
        if (this.i == false) goto L65;
        wxa.a r3 = (wxa.a) this.f.getValue();
        if (r3 == null) goto L58;
        List r4 = r3.q1();
        if (r4 == null) goto L58;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L48;
    L50:
        Iterator r13 = r5.iterator();
    L52:
        if (r13.hasNext() == false) goto L56;
        if (wxa.f.c((UplinkFileEntity) r13.next()) == false) goto L52;
    L57:
        r1 = r0;
    L56:
        r0 = false;
        goto L57
    L48:
        if (r5.isEmpty() == false) goto L50;
    L58:
        if (r1 == false) goto L60;
        h().b(CameraInnerStartPlugin.e);
    L61:
        if (r12 == false) goto L63;
        h().b(VoiceInnerEndPlugin.t);
    L64:
        h().b(PlusInnerEndPlugin.i);
    L71:
        k.a.a((k) this.e.getValue(), new znb.b());
        ((k) this.e.getValue()).of(this).c(com.ss.android.lark.keyboard.biz.mention.inject.a.class, new InputContentToggleInnerPlugin$notifyEnableChanged$1(this));
        return;
    L63:
        h().a(VoiceInnerEndPlugin.t);
        goto L64
    L60:
        h().a(CameraInnerStartPlugin.e);
        goto L61
    L65:
        boolean r14 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        if (com.ss.android.lark.keyboard.biz.mention.inject.b.a == false) goto L70;
        if (r2 == true) goto L70;
        h().b(PlusInnerEndPlugin.i);
        return;
    L70:
        h().b(CameraInnerStartPlugin.e);
        h().b(VoiceInnerEndPlugin.t);
        h().b(PlusInnerEndPlugin.i);
        goto L71
    L22:
        if (this.j == true) goto L39;
        d r15 = com.ss.android.lark.keyboard.a.a(f());
        if (r15 == null) goto L31;
        h r16 = r15.d();
        if (r16 == null) goto L31;
        if (r16.a() != 4) goto L31;
    L32:
        if (r0 == false) goto L34;
        return;
    L34:
        h().a(CameraInnerStartPlugin.e);
        h().a(VoiceInnerEndPlugin.t);
        boolean r17 = com.ss.android.lark.keyboard.biz.mention.inject.b.a;
        if (com.ss.android.lark.keyboard.biz.mention.inject.b.a == false) goto L38;
        if (r2 == true) goto L38;
        h().b(PlusInnerEndPlugin.i);
        h().a(SendInnerEndPlugin.q);
    L38:
        h().a(PlusInnerEndPlugin.i);
        h().b(SendInnerEndPlugin.q);
    L31:
        r0 = false;
    L19:
        r2 = true;
        goto L20
    L13:
        r11 = null;
    L9:
        r9 = false;
        goto L10
    }
}

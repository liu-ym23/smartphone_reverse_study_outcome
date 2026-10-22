package com.ss.android.lark.keyboard.biz.attachment.inject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AttachmentInnerTopPlugin implements wnb.b<AttachmentInnerTopPlugin> {
    public static final a i = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public com.ss.android.lark.keyboard.b b;
    public c c;
    public final Lazy d;
    public Boolean e;
    public MutableLiveData f;
    public LifecycleOwner g;
    public final b h;

    public static final class a implements wnb.b.a<AttachmentInnerTopPlugin> {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AttachmentInnerTopPlugin a;

        public b(AttachmentInnerTopPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Chat r3 = (Chat) r2;
            Intrinsics.checkNotNullParameter(r3, "chat");
            this.a.f(r3);
        }
    }

    static {
        i = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        h r0 = this.a.e;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.c;
        if (r1 == null) goto L8;
        Chat r2 = (Chat) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        f(r2);
        wxa.a r3 = (wxa.a) this.d.getValue();
        ViewGroup r4 = null;
        if (r3 == null) goto L12;
        ViewGroup r5 = r3.q2();
    L14:
        if ((r5 instanceof View) == false) goto L16;
        r4 = r5;
    L16:
        if (r4 != null) goto L19;
        Log.e("AttachmentInnerTopPlugin", "takeAttachmentPanelView is null.");
        return new FrameLayout(this.a.a.requireContext());
    L19:
        com.ss.android.lark.biz.im.api.extension.chat_window.b r6 = this.a;
        h r7 = r6.e;
        if (r7 == null) goto L32;
        MutableLiveData r8 = r7.c;
        if (r8 == null) goto L32;
        LifecycleOwner r9 = r6.a.getViewLifecycleOwner();
        MutableLiveData r10 = this.f;
        if (r10 == r8) goto L27;
    L29:
        if (r10 == null) goto L31;
        r10.removeObserver(this.h);
    L31:
        this.f = r8;
        this.g = r9;
        r8.observe(r9, this.h);
        goto L32
    L27:
        if (this.g != r9) goto L29;
    L32:
        return r4;
    L12:
        r5 = null;
    L8:
        r2 = this.a.c;
        goto L9
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, 0, 0);
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
        MutableLiveData r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeObserver(this.h);
    L5:
        this.f = null;
        this.g = null;
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
        return Direction.InnerTop;
    }

    @Override // wnb.b
    public final wnb.b.a<AttachmentInnerTopPlugin> getKey() {
        return i;
    }

    public AttachmentInnerTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.d = LazyKt.lazy(new AttachmentInnerTopPlugin$attachmentExtension$2(this));
        this.h = new b(this);
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void f(Chat r3) {
        boolean r4 = com.ss.android.lark.keyboard.utils.b.a(r3);
        if (Intrinsics.areEqual(this.e, Boolean.valueOf(r4)) == false) goto L5;
        return;
    L5:
        this.e = Boolean.valueOf(r4);
        Log.i("AttachmentInnerTopPlugin", "update suggested action visibility, visible=" + r4);
        wxa.a r0 = (wxa.a) this.d.getValue();
        if (r0 == null) goto L9;
        r0.a(r4);
        return;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}

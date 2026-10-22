package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements wnb.b<h> {
    public static final a d = null;
    public final Context a;
    public com.ss.android.lark.keyboard.b b;
    public wnb.c c;

    public static final class a implements wnb.b.a<h> {
        public a() {
        }
    }

    static {
        d = new a();
    }

    @Override // wnb.b
    public final /* synthetic */ boolean i() {
        return false;
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        AttributeSet r4 = null;
        DoubaoMentionPanelView r0 = new DoubaoMentionPanelView(this.a, r4, 6, 0);
        r0.setId(2131392525);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r0;
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, 0, 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerTop;
    }

    @Override // wnb.b
    public final wnb.b.a<h> getKey() {
        return d;
    }

    public h(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
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
}

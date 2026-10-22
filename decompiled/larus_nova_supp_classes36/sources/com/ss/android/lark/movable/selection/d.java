package com.ss.android.lark.movable.selection;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface d {
    void g(FfiCaret r1, Point r2, Point r3);

    /* JADX INFO: renamed from: getCaretId-pVg5ArA */
    int mo1477getCaretIdpVg5ArA();

    View getView();

    Rect getVisibleInsets();

    void onCleared();

    void setIsGhost(boolean r1);
}

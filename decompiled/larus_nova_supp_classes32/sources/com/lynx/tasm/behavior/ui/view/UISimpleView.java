package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.view.ViewGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class UISimpleView<T extends ViewGroup> extends UIGroup<T> {
    public UISimpleView(Context r1) {
        this((LynxContext) r1);
    }

    public UISimpleView(LynxContext r2) {
        this(r2, null);
    }

    public UISimpleView(LynxContext r1, Object r2) {
        super(r1, r2);
    }
}

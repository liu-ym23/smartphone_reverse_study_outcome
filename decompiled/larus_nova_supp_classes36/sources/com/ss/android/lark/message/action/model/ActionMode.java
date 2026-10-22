package com.ss.android.lark.message.action.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum ActionMode extends Enum<ActionMode> {
    public static final ActionMode MULTI = null;
    public static final ActionMode SINGLE = null;
    public static final /* synthetic */ ActionMode[] a = null;

    static {
        ActionMode r0 = new ActionMode("SINGLE", 0);
        SINGLE = r0;
        ActionMode r1 = new ActionMode("MULTI", 1);
        MULTI = r1;
        a = new ActionMode[]{r0, r1};
    }

    public static ActionMode[] values() {
        return (ActionMode[]) a.clone();
    }

    public static ActionMode valueOf(String r1) {
        return (ActionMode) a.a(ActionMode.class, r1);
    }

    public ActionMode(String r1, int r2) {
        super(r1, r2);
    }
}

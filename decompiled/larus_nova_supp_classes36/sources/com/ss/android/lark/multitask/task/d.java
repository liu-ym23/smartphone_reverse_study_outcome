package com.ss.android.lark.multitask.task;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final CharSequence a;

    public String getIdentifier() {
        return null;
    }

    public String getType() {
        return null;
    }

    public final String toString() {
        return "TaskSnapshot{id=0, title=" + this.a + ", drawable=null, container=null, starter=null, savedState=null}";
    }

    public d() {
        this.a = "";
    }

    public final int hashCode() {
        throw null;
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof d) == true) goto L9;
        return false;
    L9:
        ((d) r2).getClass();
        throw null;
    }
}

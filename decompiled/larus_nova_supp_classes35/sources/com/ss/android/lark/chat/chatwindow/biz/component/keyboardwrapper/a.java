package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a$a, reason: collision with other inner class name */
    public static final class C0033a {
        @JvmStatic
        public static boolean a(HashMap r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Iterator r3 = r2.entrySet().iterator();
            boolean r0 = false;
        L4:
            if (r3.hasNext() == false) goto L6;
            r0 = r0 | ((a) ((Map.Entry) r3.next()).getValue()).b;
            goto L4
        L6:
            return r0;
        }

        @JvmStatic
        public static boolean b(HashMap r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Iterator r3 = r2.entrySet().iterator();
            boolean r0 = false;
        L4:
            if (r3.hasNext() == false) goto L6;
            r0 = r0 | ((a) ((Map.Entry) r3.next()).getValue()).c;
            goto L4
        L6:
            return r0;
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BannedKeyboardReason(reason=" + this.a + ", banKeyboard=" + this.b + ", banKeyboardTop=" + this.c + ')';
    }

    public a() {
        Intrinsics.checkNotNullParameter("banned_select", "reason");
        this.a = "banned_select";
        this.b = true;
        this.c = true;
    }
}

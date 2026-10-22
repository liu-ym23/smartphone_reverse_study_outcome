package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends com.bytedance.android.livesdk.common.b {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final int e;
    public final List<a> f;
    public final List<PopupMenu.OnMenuItemClickListener> g;
    public final int h;
    public final PopupMenu.OnMenuItemClickListener i;

    public static final class a {
        public final int a;
        public final boolean b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            int r0 = this.a * 31;
            boolean r1 = this.b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return ((r0 + r2) * 31) + this.c;
        }

        public final String toString() {
            return "ActionMenuItem(text=" + this.a + ", disabled=" + this.b + ", textColor=" + this.c + ")";
        }

        public a(int r3, boolean r4, int r5) {
            int r1 = 0;
            if ((r5 & 2) == 0) goto L6;
            r4 = false;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r1 = 2131107134;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setWindowAnimations(0);
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        Window r9 = getWindow();
        int r1 = 0;
        if (r9 == null) goto L5;
        r9.setBackgroundDrawable(new ColorDrawable(0));
        r9.setGravity(80);
        r9.setLayout(-1, -2);
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(2131565409, null));
        ((TextView) this.b.getValue()).setText(this.e);
        ((ViewGroup) this.c.getValue()).removeAllViews();
        Iterator<T> r10 = this.f.iterator();
    L7:
        if (r10.hasNext() == false) goto L18;
        Object r2 = r10.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        a r4 = (a) r2;
        TextView r5 = new TextView(getContext());
        int r6 = s1.h(r4.c);
        if (r4.b == false) goto L14;
        r6 = r6 & Integer.MAX_VALUE;
    L14:
        r5.setTextColor(r6);
        r5.setBackgroundColor(s1.h(2131108569));
        r5.setTextSize(16.0f);
        r5.setGravity(17);
        PopupMenu.OnMenuItemClickListener r7 = (PopupMenu.OnMenuItemClickListener) CollectionsKt.getOrNull(this.g, r1);
        if (r7 == null) goto L16;
        r5.setText(r4.a);
        ViewGroup r11 = (ViewGroup) this.c.getValue();
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, (int) s1.e(56.0f));
        r12.topMargin = s1.f(0.5f);
        Unit r13 = Unit.INSTANCE;
        r11.addView(r5, r12);
        r5.setOnClickListener(new f(r7, this));
        r1 = r3;
        goto L7
    L16:
        ALogger.e("BottomPickerDialog", "action is null when add item: " + r4);
        return;
    L18:
        ((TextView) this.d.getValue()).setText(this.h);
        ((TextView) this.d.getValue()).setOnClickListener(new g(this));
    }

    public e(Context r2, List r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "options");
        Intrinsics.checkNotNullParameter(r4, "optionActions");
        super(r2, true);
        this.e = 2131919926;
        this.f = r3;
        this.g = r4;
        this.h = 2131915442;
        this.i = null;
        this.b = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$titleView$2(this));
        this.c = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$itemContainer$2(this));
        this.d = InfraKotlinExtsKt.mainThreadLazy(new BottomSheetActionPickerDialog$cancelView$2(this));
    }
}

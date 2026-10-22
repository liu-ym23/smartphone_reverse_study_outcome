package com.bytedance.android.annie.container.fragment.flavor.fail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.util.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends FailSubFragmentProxy {

    /* JADX INFO: renamed from: com.bytedance.android.annie.container.fragment.flavor.fail.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0068a implements View.OnClickListener {
        public final /* synthetic */ Function0<Unit> a;

        public ViewOnClickListenerC0068a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r10 = this.a;
            if (r10 == null) goto L6;
            r10.invoke();
            return;
        }
    }

    @Override // u7.a
    public final View b() {
        boolean r0 = m.c();
        LayoutInflater r1 = LayoutInflater.from(getContext());
        if (r0 == true) goto L5;
        int r10 = 2131558555;
    L6:
        View r11 = r1.inflate(r10, this.b, false);
        g(r11, 2131231346);
        return r11;
    L5:
        r10 = 2131558556;
        goto L6
    }

    public a(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(r10, r11);
    }

    @Override // com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy
    public final void f(View r10, Function0<Unit> r11) {
        if (r10 == null) goto L7;
        View r12 = r10.findViewById(2131393128);
        if (r12 == null) goto L8;
        r12.setOnClickListener(new ViewOnClickListenerC0068a(r11));
        return;
    L8:
        return;
    }
}

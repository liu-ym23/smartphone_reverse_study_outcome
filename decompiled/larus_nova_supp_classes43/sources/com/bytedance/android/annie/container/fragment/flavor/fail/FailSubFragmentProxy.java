package com.bytedance.android.annie.container.fragment.flavor.fail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.p;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class FailSubFragmentProxy extends u7.a {
    public View d;
    public Function0<Unit> e;
    public Function0<Unit> f;
    public final Map<String, String> g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FailSubFragmentProxy a;

        public a(FailSubFragmentProxy r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r10 = this.a.f;
            if (r10 == null) goto L6;
            r10.invoke();
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FailSubFragmentProxy a;

        public b(FailSubFragmentProxy r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FailSubFragmentProxy r0 = this.a;     // Catch: Throwable -> L7
            if (r0.d != null) goto L5;
            r0.a();     // Catch: Throwable -> L7
        L5:
            FailSubFragmentProxy.e(this.a);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public abstract void f(View r1, Function0<Unit> r10);

    @Override // u7.a
    public final void d() {
        ThreadUtils.c(new b(this));
    }

    @Override // u7.a
    public final View a() {
        View r0 = super.a();
        this.d = r0;
        Intrinsics.checkNotNull(r0);
        f(r0, new FailSubFragmentProxy$createAndInsertView$1$1(this));
        return r0;
    }

    public static final /* synthetic */ void e(FailSubFragmentProxy r0) {
        super.d();
    }

    public FailSubFragmentProxy(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(r10, r11);
        this.g = new HashMap();
    }

    public final void g(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        String r0 = (String) ((HashMap) this.g).get("is_popup");
        Integer r1 = null;
        if (r0 == null) goto L5;
        Boolean r12 = Boolean.valueOf(Boolean.parseBoolean(r0));
    L6:
        String r13 = (String) ((HashMap) this.g).get("is_bottom_popup");
        if (r13 == null) goto L9;
        Boolean r14 = Boolean.valueOf(Boolean.parseBoolean(r13));
    L10:
        String r15 = (String) ((HashMap) this.g).get("popup_width");
        if (r15 == null) goto L13;
        r1 = Integer.valueOf(CastIntegerProtector.parseInt(r15));
    L13:
        if (r1 != null) goto L15;
    L19:
        boolean r16 = false;
    L20:
        Boolean r17 = Boolean.TRUE;
        if (Intrinsics.areEqual(r12, r17) == false) goto L33;
        ImageView r18 = (ImageView) r10.findViewById(2131372060);
        if (r18 == null) goto L33;
        if (Intrinsics.areEqual(r14, Boolean.FALSE) == false) goto L31;
        if (r16 == false) goto L31;
        if (r11 <= 0) goto L29;
        p r19 = p.a;
        Context r20 = getContext();
        Intrinsics.checkNotNullParameter(r20, "context");
        r18.setImageDrawable(r20.getResources().getDrawable(r11));
    L29:
        ViewGroup.LayoutParams r21 = r18.getLayoutParams();
        p r22 = p.a;
        r21.height = r22.a(60.0f);
        r21.width = r22.a(60.0f);
        r18.setLayoutParams(r21);
    L31:
        if (Intrinsics.areEqual(r14, r17) == false) goto L33;
        ViewGroup.LayoutParams r23 = r18.getLayoutParams();
        p r24 = p.a;
        r23.height = r24.a(128.0f);
        r23.width = r24.a(172.0f);
        r18.setLayoutParams(r23);
    L33:
        View r25 = r10.findViewById(2131372061);
        if (r25 == null) goto L37;
        r25.setOnClickListener(new a(this));
        return;
    L37:
        return;
    L15:
        if (r1.intValue() <= 0) goto L19;
        if (r1.intValue() >= p.a.a(310.0f)) goto L19;
        r16 = true;
        goto L20
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}

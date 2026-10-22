package com.larus.bmhome.chat.outerinput;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.n5;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class OuterInputEventHandler {
    public static final /* synthetic */ int i = 0;
    public final TraceFragment a;
    public final Function0<LarusWidgetInputBinding> b;
    public boolean c;
    public String d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.c == true) goto L28;
        this.c = true;
        TraceFragment r0 = this.a;
        if (r0 == null) goto L10;
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L10;
        String r2 = r1.getString("arg_outer_input_tab_key");
        if (r2 == null) goto L10;
    L11:
        this.d = r2;
        FLogger.a.i("OuterInputEventHandler", "handleEvent, tabKey:" + this.d);
        TraceFragment r3 = this.a;
        if (r3 == null) goto L29;
        Bundle r4 = r3.getArguments();
        if (r4 == null) goto L30;
        int r5 = r4.getInt("arg_outer_input_event_id");
        if (r5 >= 101) goto L18;
        return;
    L18:
        if (r5 >= 201) goto L20;
        b(r5);
        return;
    L20:
        TraceFragment r6 = this.a;
        if (r6 == null) goto L25;
        Bundle r7 = r6.getArguments();
        if (r7 == null) goto L25;
        OuterInputEventBus.OuterInputEvent r8 = (OuterInputEventBus.OuterInputEvent) r7.getParcelable("arg_outer_input_down_event");
    L26:
        a(r5, r8);
        return;
    L25:
        r8 = null;
        goto L26
    L30:
        return;
    L29:
        return;
    L10:
        r2 = "";
        goto L11
    }

    public final void b(int r4) {
        FLogger r0 = FLogger.a;
        r0.i("OuterInputEventHandler", "handleClickEvent, eventId:" + r4);
        boolean r1 = true;
        switch(r4) {
            case 101: goto L30;
            case 102: goto L29;
            case 103: goto L28;
            case 104: goto L27;
            case 105: goto L24;
            case 106: goto L10;
            case 107: goto L5;
            default: goto L43;
        };
    L5:
        TraceFragment r5 = this.a;
        if (r5 == null) goto L32;
        final t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L33;
        t0.a.post(new z(r6));
        return;
    L33:
        return;
    L32:
        return;
    L10:
        g1 r7 = (g1) this.g.getValue();
        if (r7 != null) goto L13;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        t0.a.post(new y(this));
        return;
    L18:
        TraceFragment r8 = this.a;
        if (r8 == null) goto L21;
        f1 r9 = (f1) s1a.a.g(r8).getAbility(f1.class);
    L22:
        if (r9 == null) goto L36;
        r9.XM();
        return;
    L36:
        return;
    L21:
        r9 = null;
        goto L22
    L13:
        if (r7.isVisible() != true) goto L15;
    L24:
        ICoreInputAbility r10 = (ICoreInputAbility) this.h.getValue();
        if (r10 == null) goto L38;
        r10.BU(true, true, "");
        return;
    L38:
        return;
    L27:
        t0.a.post(new x(this));
        return;
    L28:
        t0.a.post(new w(this));
        return;
    L29:
        t0.a.post(new v(this));
        return;
    L30:
        r0.e("OuterInputEventHandler", "click first phone");
        return;
    }

    public OuterInputEventHandler(TraceFragment r2, n5 r3) {
        Intrinsics.checkNotNullParameter(r3, "binding");
        this.a = r2;
        this.b = r3;
        this.d = "";
        this.e = LazyKt.lazy(new r(this));
        this.f = LazyKt.lazy(new s(this));
        this.g = LazyKt.lazy(new t(this));
        this.h = LazyKt.lazy(new u(this));
    }

    public final void a(int r11, OuterInputEventBus.OuterInputEvent r12) {
        FLogger r0 = FLogger.a;
        r0.i("OuterInputEventHandler", "handleTouchEvent, eventId:" + r11);
        ICoreInputAbility r1 = (ICoreInputAbility) this.h.getValue();
        if (r1 == null) goto L6;
        r1.s3(100);
    L6:
        switch(r11) {
            case 201: goto L14;
            case 202: goto L11;
            case 203: goto L8;
            default: goto L33;
        };
    L8:
        LarusWidgetInputBinding r13 = (LarusWidgetInputBinding) this.b.invoke();
        if (r13 == null) goto L17;
        View r14 = r13.w;
    L18:
        if (r12 != null) goto L20;
        return;
    L20:
        r0.i("OuterInputEventHandler", "handleTouchEvent, downEvent:" + r12);
        if (r14 == null) goto L23;
        r14.setTag(2131365544, TuplesKt.to(Float.valueOf(r12.d), Float.valueOf(r12.e)));
    L23:
        if (r14 == null) goto L25;
        MutableSharedFlow<Integer> r2 = OuterInputEventBus.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r14.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), r12.a, r12.b, r12.c, 0));
    L25:
        TraceFragment r15 = this.a;
        if (r15 == null) goto L34;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r15);
        if (r3 == null) goto L35;
        BuildersKt.launch$default(r3, null, null, new OuterInputEventHandler$doHandleTouchEvent$1(this, r14, null), 3, null);
        return;
    L35:
        return;
    L34:
        return;
    L17:
        r14 = null;
        goto L18
    L11:
        LarusWidgetInputBinding r16 = (LarusWidgetInputBinding) this.b.invoke();
        if (r16 == null) goto L31;
        r14 = r16.R;
        goto L18
    L31:
        r14 = null;
        goto L18
    L14:
        LarusWidgetInputBinding r17 = (LarusWidgetInputBinding) this.b.invoke();
        if (r17 == null) goto L32;
        r14 = r17.M;
        goto L18
    L32:
        r14 = null;
        goto L18
    L33:
        r14 = null;
        goto L18
    }

    public final void d(Integer r3, String r4, OuterInputEventBus.OuterInputEvent r5) {
        Intrinsics.checkNotNullParameter(r4, "tabKey");
        this.d = r4;
        FLogger.a.i("OuterInputEventHandler", "handleEvent2, tabKey:".concat(r4));
        if (r3 == null) goto L11;
        r3.intValue();
        if (r3.intValue() >= 101) goto L7;
        return;
    L7:
        if (r3.intValue() >= 201) goto L9;
        b(r3.intValue());
        return;
    L9:
        a(r3.intValue(), r5);
        return;
    }
}

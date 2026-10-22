package com.bytedance.apm.agent.instrumentation;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;
import z6.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f3838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3839c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(Integer r5, long r10, String r11, int r12) {
        this.f3837a = r12;
        this.f3838b = r5;
        this.f3839c = r10;
        this.d = r11;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch(this.f3837a) {
            case 0: goto L60;
            default: goto L62;
        };
    L60:
        if (FragmentInstrumentation.access$000() != null) goto L34;
        return;
    L34:
        if (FragmentInstrumentation.access$000().get() == null) goto L73;
        View r5 = ((View) FragmentInstrumentation.access$000().get()).findViewById(this.f3838b.intValue());     // Catch: Exception -> L59
        if (FragmentInstrumentation.access$100() != 0) goto L39;
        FragmentInstrumentation.access$102(System.currentTimeMillis());     // Catch: Exception -> L59
    L39:
        if (r5 != null) goto L41;
        return;
    L41:
        if (r5.getVisibility() == 0) goto L43;
        return;
    L43:
        if (r5.getWidth() <= 0) goto L76;
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L59
        if (((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().isAlive() == true) goto L47;
    L49:
        FragmentInstrumentation.access$202(null);     // Catch: Exception -> L59
        FragmentInstrumentation.access$002(null);     // Catch: Exception -> L59
        if (FragmentInstrumentation.access$300() == null) goto L52;
        z6.a.f23408a.removeCallbacks(FragmentInstrumentation.access$300());     // Catch: Exception -> L59
    L52:
        long r11 = r10 - this.f3839c;     // Catch: Exception -> L59
        if ((r10 - FragmentInstrumentation.access$100()) > 1) goto L55;
        return;
    L55:
        if (r11 >= FragmentInstrumentation.access$400()) goto L78;
        String r12 = FragmentInstrumentation.access$500();     // Catch: Exception -> L59
        String r13 = this.d;     // Catch: Exception -> L59
        b.f23409a.d(new s5.a(0, r11, r13, r12));     // Catch: Exception -> L59
        return;
    L78:
        return;
    L47:
        if (FragmentInstrumentation.access$200() == null) goto L49;
        ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L59
        goto L49
    L76:
        return;
    L73:
        return;
    L79:
        return;
    L62:
        if (FragmentTimeAgent.access$300() != null) goto L7;
        return;
    L7:
        if (FragmentTimeAgent.access$300().get() == null) goto L65;
        View r14 = ((View) FragmentTimeAgent.access$300().get()).findViewById(this.f3838b.intValue());     // Catch: Exception -> L58
        if (FragmentTimeAgent.access$400() != 0) goto L12;
        FragmentTimeAgent.access$402(System.currentTimeMillis());     // Catch: Exception -> L58
    L12:
        if (r14 != null) goto L14;
        return;
    L14:
        if (r14.getVisibility() == 0) goto L16;
        return;
    L16:
        if (r14.getWidth() <= 0) goto L68;
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L58
        if (((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().isAlive() == true) goto L20;
    L22:
        FragmentTimeAgent.access$502(null);     // Catch: Exception -> L58
        FragmentTimeAgent.access$302(null);     // Catch: Exception -> L58
        if (FragmentTimeAgent.access$600() == null) goto L25;
        z6.a.f23408a.removeCallbacks(FragmentTimeAgent.access$600());     // Catch: Exception -> L58
    L25:
        long r16 = r15 - this.f3839c;     // Catch: Exception -> L58
        if ((r15 - FragmentTimeAgent.access$400()) > 1) goto L28;
        return;
    L28:
        if (r16 >= FragmentTimeAgent.access$700()) goto L70;
        FragmentTimeAgent.access$800(FragmentTimeAgent.access$000(), this.d, this.f3839c, r15);     // Catch: Exception -> L58
        return;
    L70:
        return;
    L20:
        if (FragmentTimeAgent.access$500() == null) goto L22;
        ((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.access$500());     // Catch: Exception -> L58
        goto L22
    L68:
        return;
    L65:
        return;
    }
}

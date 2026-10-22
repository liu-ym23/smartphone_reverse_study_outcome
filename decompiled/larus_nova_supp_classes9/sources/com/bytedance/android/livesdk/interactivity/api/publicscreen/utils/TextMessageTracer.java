package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r52.f4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TextMessageTracer implements s42.c {
    public static final boolean a = false;
    public static final TextMessageTracer b = null;

    public TextMessageTracer() {
    }

    @Override // s42.c
    public final void c() {
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void i() {
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    static {
        b = new TextMessageTracer();
        a = ((Boolean) f4.a.getValue()).booleanValue();
    }

    public static void A(String r2) {
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a999").addArg("info", r2), "TextMessageTracer");
    }

    public static final String u(com.bytedance.android.livesdk.interactivity.api.entity.f r0) {
        T r1 = r0.b;
        if (r1 == 0) goto L6;
        String r2 = r1.getMessageMethod();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "UNKNOWN_PUBLIC_SCREEN_MESSAGE_TYPE";
    }

    public static final String v(tlc.d r1) {
        if ((r1 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        r1 = null;
    L5:
        com.bytedance.android.live.base.model.message.t r2 = (com.bytedance.android.live.base.model.message.t) r1;
        if (r2 == null) goto L9;
        String r3 = r2.getMessageMethod();
        if (r3 == null) goto L9;
        return r3;
    L9:
        return "UNKNOWN_MESSAGE_TYPE";
    }

    public static String w(IWidget r3) {
        if (r3 == null) goto L16;
        Widget r4 = (Widget) r3;
        ViewGroup r0 = r4.containerView;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (r0.getLayoutParams() == null) goto L18;
        ViewGroup.LayoutParams r5 = r4.containerView.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        StringBuilder r1 = new StringBuilder("height: ");
        r1.append(r5.height);
        r1.append(", width: ");
        r1.append(r5.width);
        r1.append(", margin: (");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r1.append(r6.leftMargin);
        r1.append('-');
        r1.append(r6.topMargin);
        r1.append('-');
        r1.append(r6.rightMargin);
        r1.append('-');
        r1.append(r6.bottomMargin);
        r1.append(')');
        return r1.toString();
    L12:
        return "height: " + r5.height + ", width: " + r5.width;
    L18:
        return BuildConfig.FLAVOR;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    }

    public static long x(com.bytedance.android.livesdk.interactivity.api.entity.f r2) {
        T r3 = r2.b;
        if (r3 != 0) goto L7;
        return 0;
    L7:
        return r3.getMessageId();
    }

    public static String y(IWidget r3) {
        if (r3 == null) goto L14;
        Widget r4 = (Widget) r3;
        ViewGroup r0 = r4.containerView;
        int r1 = -1;
        if (r0 != null) goto L6;
        int r2 = -1;
    L7:
        View r5 = r4.contentView;
        if (r5 == null) goto L12;
        r1 = r5.getVisibility();
    L12:
        return "container state: " + r2 + ", content state: " + r1;
    L6:
        r2 = r0.getVisibility();
        goto L7
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    }

    public static void z(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
        return;
    L5:
        ALogger.i("TextMessageTracer", (String) r1.invoke());
    }

    @Override // s42.c
    public final void b(int r3) {
        A("unknown message view type: " + r3);
    }

    @Override // s42.c
    public final void d(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        B(x(r4), new TextMessageTracer$onMessageDiscardedByInterceptor$1$1(r4));
    }

    @Override // s42.c
    public final void e(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        if (r4 == null) goto L5;
        B(x(r4), new TextMessageTracer$onMessageDiscardedByOverTime$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void f(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        if (r4 == null) goto L5;
        B(x(r4), new TextMessageTracer$onMessageDiscardedByFoldStrategy$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void h(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        if (r4 == null) goto L5;
        B(x(r4), new TextMessageTracer$onMessageDiscardedByScore$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void k(final tlc.d r4) {
        if (r4 == null) goto L5;
        B(r4.getMessageId(), new TextMessageTracer$onLiveMessageDiscardedByConverter$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void l(final tlc.d r4) {
        if (r4 == null) goto L5;
        B(r4.getMessageId(), new TextMessageTracer$onLiveMessageReceived$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void n(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        if (r4 == null) goto L5;
        B(x(r4), new TextMessageTracer$onMessageShowedInList$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void o(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        B(x(r4), new TextMessageTracer$onMessageShowInFold$1$1(r4));
    }

    @Override // s42.c
    public final void p(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        B(x(r4), new TextMessageTracer$onMessageAddToPublicScreen$1$1(r4));
    }

    @Override // s42.c
    public final void q(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        if (r4 == null) goto L5;
        B(x(r4), new TextMessageTracer$onMessageDiscardedByBufferLimit$1$1(r4));
        return;
    }

    @Override // s42.c
    public final void t(final tlc.d r4) {
        if (r4 == null) goto L5;
        B(r4.getMessageId(), new TextMessageTracer$onLiveMessageDiscardedByPrimaryFilter$1$1(r4));
        return;
    }

    public static void B(long r1, Function0 r3) {
        if (a == true) goto L5;
        return;
    L5:
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a100").businessId(String.valueOf(r1)).addArg("info", r3.invoke()), "TextMessageTracer");
    }

    public static void C(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cause");
        Intrinsics.checkNotNullParameter(r3, "result");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a149.a999").addArg("info", "widget visible state changed, cause by: " + r2 + ", changed to " + r3), "TextMessageTracer");
    }

    @Override // s42.c
    public final void j(IWidget r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "cause");
        A("widget visible state changed, cause by: " + r4 + ", " + y(r3));
    }

    @Override // s42.c
    public final void s(IWidget r3, IRoom r4, s42.c.b r5) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "room");
        StringBuilder r6 = new StringBuilder("widget unloaded, roomId: ");
        r6.append(r4.getId());
        r6.append(", ");
        r6.append(y(r3));
        r6.append(", ");
        r6.append(w(r3));
        r6.append(", ");
        Context r7 = r3.getContext();
        if (r7 == null) goto L7;
        ContentResolver r8 = r7.getContentResolver();
        if (r8 == null) goto L7;
        String r9 = "animationScale: " + Settings.Global.getFloat(r8, "animator_duration_scale", 1.0f);
    L8:
        r6.append(r9);
        A(r6.toString());
        return;
    L7:
        r9 = "null";
        goto L8
    }

    @Override // s42.c
    public final void a(TextMessageWidget r3, IRoom r4, boolean r5, boolean r6, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r7) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r7, "publicScreenData");
        A("widget loaded, roomId: " + r4.getId() + ", isPortrait: " + r6 + ", " + y(r3) + ", " + w(r3));
        ViewGroup r8 = ((Widget) r3).containerView;
        if (r8 == null) goto L7;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L7;
        int r10 = r9.height;
    L9:
        if (r10 != 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L25;
        LiveTracingMonitor.EventModule r13 = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
        JSONObject r14 = new JSONObject();
        r14.put("category_1", "component_load");     // Catch: JSONException -> L19
    L23:
        r14.put("category_2", BuildConfig.FLAVOR);     // Catch: JSONException -> L20
    L17:
        LiveMonitor r15 = new LiveMonitor();
        r15.mCategory = r14;
        r15.mEventModule = r13;
        r15.mServiceName = "ttlive_text_message_height_zero_error";
        r15.mExtraLog = null;
        r15.mMetrics = null;
        LiveMonitor.access$002(r15, false);
        LiveMonitor.access$102(r15, false);
        LiveMonitor.access$202(r15, true);
        LiveMonitor.access$302(r15, false);
        LiveMonitor.access$402(r15, false);
        r15.report();
        return;
    L25:
        return;
    L11:
        r11 = false;
    L7:
        r10 = Integer.MIN_VALUE;
        goto L9
    }
}

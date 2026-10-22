package com.bytedance.ai.model.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends c {
    public final Lazy a;
    public final Lazy b;
    public k2.t c;

    public static final class a {
    }

    static {
    }

    public final k2.k h() {
        return (k2.k) this.b.getValue();
    }

    @Override // k2.o
    public final View engineView() {
        k2.k r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.engineView();
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        k2.k r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAIBridge();
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.k
    public final k2.m getContainerViewService() {
        k2.k r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContainerViewService();
    }

    @Override // k2.o
    public final View realView() {
        k2.k r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.realView();
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final k2.t getFloatingSpeakerController() {
        return this.c;
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        k2.k r0 = h();
        if (r0 == null) goto L6;
        r0.onMessageToJS(r10);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final void setFloatingSpeakerController(k2.t r1) {
        this.c = r1;
    }

    public f(AppletRuntime r10, final PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        super(r10, r11);
        this.a = LazyKt.lazy(new d(r11, this));
        this.b = LazyKt.lazy(new e(r11, this));
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        k2.k r0 = h();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getViewModel(r10, r11);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.o
    public final void handleWebViewDrawEnd(long r10, long r11) {
        k2.k r0 = h();
        if (r0 == null) goto L6;
        r0.handleWebViewDrawEnd(r10, r11);
        return;
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        k2.k r0 = h();
        if (r0 == null) goto L6;
        r0.onMessageToAIBridge(r10, r11);
        return;
    }

    @Override // k2.k
    public final void createContainer(ViewGroup r10, k2.b r11, Activity r12, Fragment r13) {
        Intrinsics.checkNotNullParameter(r10, "root");
        Intrinsics.checkNotNullParameter(r11, "params");
        k2.k r0 = h();
        if (r0 == null) goto L6;
        r0.createContainer(r10, r11, r12, r13);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.p
    public final View createPage(PageInfo r10, Context r11, Function1<? super Integer, Unit> r12, Function1<? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super.createPage(r10, r11, null, null);
        if (((k2.p) this.a.getValue()) == null) goto L7;
        k2.p r1 = (k2.p) this.a.getValue();
        if (r1 != null) goto L13;
        return null;
    L13:
        return r1.createPage(r10, r11, r12, r13);
    L7:
        String r14 = "Unable to create page, pageType=" + r10.getPageType();
        if (r13 == null) goto L10;
        r13.invoke(r14);
    L10:
        IllegalArgumentException r15 = new IllegalArgumentException(r14);
        com.bytedance.ai.utils.g.a.e("AIPageDelegate", r15.getMessage(), r15);
        return null;
    }
}

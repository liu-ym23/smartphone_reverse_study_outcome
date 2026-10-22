package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements vr1.k, com.bytedance.android.scope.o {
    public k() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.k
    public final dw2.g a() {
        return new dw2.g();
    }

    @Override // vr1.k
    public final pw2.d c() {
        return new pw2.d();
    }

    @Override // vr1.k
    public final com.bytedance.android.livesdk.widgetdescriptor.template.container.d f() {
        return new com.bytedance.android.livesdk.widgetdescriptor.template.container.d();
    }

    @Override // vr1.k
    public final com.bytedance.android.livesdk.widgetdescriptor.n g() {
        return new com.bytedance.android.livesdk.widgetdescriptor.n();
    }

    @Override // vr1.k
    public final com.bytedance.android.livesdk.tetris.f j() {
        return new com.bytedance.android.livesdk.tetris.f();
    }

    @Override // vr1.k
    public final com.bytedance.android.livesdk.widgetdescriptor.comment.d k() {
        return new com.bytedance.android.livesdk.widgetdescriptor.comment.d();
    }

    @Override // vr1.k
    public final pw2.c o() {
        return new pw2.c();
    }

    @Override // vr1.k
    public final List<j70.f> q() {
        Map r1 = d90.b.a;
        j70.c r2 = d90.b.p;
        return CollectionsKt.mutableListOf(new j70.c[]{d90.b.c, d90.b.e, d90.b.d, r2, d90.b.h, d90.b.i, d90.b.j, r2, d90.b.g});
    }

    @Override // vr1.k
    public final LayerDescriptorList s() {
        int r0 = com.bytedance.android.livesdk.castscreen.api.b.a;
        LayerDescriptorList r1 = new LayerDescriptorList();
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.e());
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.h());
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.d());
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.c());
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.g());
        r1.add(new com.bytedance.android.livesdk.castscreen.descriptor.f());
        return r1;
    }

    @Override // vr1.k
    public final j70.c A() {
        return d90.b.o;
    }

    @Override // vr1.k
    public final LayerDescriptorList d(DataCenter r1) {
        return new com.bytedance.android.livesdk.widgetdescriptor.m().i();
    }

    @Override // vr1.k
    public final LayerDescriptorList h(DataCenter r1) {
        return new com.bytedance.android.livesdk.widgetdescriptor.m().f();
    }

    @Override // vr1.k
    public final LayerDescriptorList i(DataCenter r3) {
        LayerDescriptorList r4 = new LayerDescriptorList();
        com.bytedance.android.livesdk.widgetdescriptor.m r0 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        r4.addAll(r0.k());
        r4.addAll(r0.b());
        r4.addAll(r0.h());
        return r4;
    }

    @Override // vr1.k
    public final LayerDescriptorList n(DataCenter r1) {
        return new com.bytedance.android.livesdk.widgetdescriptor.m().j();
    }

    @Override // vr1.k
    public final LayerDescriptorList w(DataCenter r3) {
        LayerDescriptorList r4 = new LayerDescriptorList();
        com.bytedance.android.livesdk.widgetdescriptor.m r0 = new com.bytedance.android.livesdk.widgetdescriptor.m();
        r4.addAll(r0.e());
        r4.addAll(r0.c());
        r4.addAll(r0.g());
        return r4;
    }

    @Override // vr1.k
    public final LayerDescriptorList x(DataCenter r1) {
        return new com.bytedance.android.livesdk.widgetdescriptor.m().a();
    }

    @Override // vr1.k
    public final LayerDescriptorList y(DataCenter r1) {
        return new com.bytedance.android.livesdk.widgetdescriptor.m().d();
    }
}

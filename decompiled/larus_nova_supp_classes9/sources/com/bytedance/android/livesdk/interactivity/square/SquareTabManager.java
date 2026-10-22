package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePipelineType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.ui.IModelListDataManager;
import com.bytedance.android.livesdk.interactivity.api.settings.config.y0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SquareTabManager implements com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b {
    public j a;
    public boolean b;
    public final y0 c;
    public boolean d;
    public boolean e;
    public final e52.a f;
    public final k52.a g;
    public final DataCenter h;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l i;
    public final IModelListDataManager j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void c() {
        this.e = true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void e() {
        this.b = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void i() {
        this.d = true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final boolean a() {
        if (this.c.b() == false) goto L6;
        return false;
    L6:
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a;
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a(this.h) == false) goto L11;
        ALogger.i("square_tab", "has component, ban square");
        return true;
    L11:
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void b() {
        j r0 = this.a;
        if (r0 == null) goto L6;
        ALogger.i("square_tab", "start update");
        r0.a.g();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void destroy() {
        j r0 = this.a;
        if (r0 == null) goto L13;
        r0.f.a();
        r0.f.d(r0.h);
        r0.a.i();
        j52.b r2 = r0.a;
        l52.a r3 = r0.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r2.a).remove(r3);
        ((ArrayDeque) r0.i.a).clear();
        r0.b = null;
        List r4 = CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.square.plugin.a(r0.e));
        if ((!r4.isEmpty()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L13;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        r0.g.unregisterMessagePlugin((h52.a) r5.next());
    L13:
        ALogger.i("square_tab", "manager destroy,pipeline = null");
        this.a = null;
        this.j.destroy();
        this.e = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void h() {
        j r0 = this.a;
        if (r0 == null) goto L6;
        r0.a.i();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void j() {
        if (this.a == null) goto L6;
        ALogger.i("square_tab", "pipeline not null, return");
        return;
    L6:
        ALogger.i("square_tab", "create pipeline");
        j r2 = new j(this.g, new h(this.h, this.i), this.i);
        this.a = r2;
        Function1<List<? extends h52.c>, Unit> r0 = new SquareTabManager$createPipeline$1(this);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r2.b = r0;
        m52.b r3 = r2.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "cb");
        r3.h = r0;
        j r1 = this.a;
        if (r1 == null) goto L20;
        ALogger.i("square_tab", "prepare pipeline");
        r1.f.b(r1.h);
        List r4 = CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.square.plugin.a(r1.e));
        if ((!r4.isEmpty()) == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L17;
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        h52.a<h52.d, ? extends h52.c> r6 = (h52.a) r5.next();
        r1.g.registerMessagePlugin(r6);
        ALogger.i("square_tab", "register plugin:" + r6.getPluginType());
    L17:
        r1.a.b(r1.c);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void startMessage() {
        j r0 = this.a;
        if (r0 == null) goto L6;
        ALogger.i("square_tab", "start repo");
        r0.f.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final void stopMessage() {
        ALogger.i("square_tab", "stop pipeline");
        j r0 = this.a;
        if (r0 == null) goto L6;
        r0.f.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final boolean d() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final boolean f() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final IModelListDataManager g() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b
    public final k52.a k() {
        return this.g;
    }

    public SquareTabManager(DataCenter r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.l r13, com.bytedance.android.livesdk.interactivity.square.a r14) {
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r14, "dataManager");
        this.h = r11;
        this.i = r13;
        this.j = r14;
        this.b = true;
        y0 r0 = com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.d.a;
        this.c = r0;
        e52.a r15 = r13.getTextConfig();
        if (r15 != null) goto L9;
        Boolean r16 = Boolean.FALSE;
        q92.a r2 = q92.b.b(((Boolean) r11.get("data_is_anchor", r16)).booleanValue(), (IRoom) r11.get("data_room"));
        Boolean r17 = (Boolean) r11.get("data_is_anchor", r16);
        if (r17 == null) goto L7;
        boolean r18 = r17.booleanValue();
    L8:
        r2.m = q.a(r2, true, r18);
        Unit r19 = Unit.INSTANCE;
        e52.a r8 = r2;
    L10:
        this.f = r8;
        MessagePipelineType r4 = MessagePipelineType.SquareTabPipeline;
        int r5 = r0.a();
        int r6 = r0.g();
        int r7 = r0.e();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<h52.c> r110 = r8.i();
        if (r110 != null) goto L13;
        int r111 = da2.a.a;
        q92.a r112 = (q92.a) r8;
        Intrinsics.checkNotNullParameter(r112, "config");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k<h52.c> r9 = new da2.b(new xa2.a(r112));
    L14:
        this.g = new k52.a(r4, r5, r6, r7, r8, r9);
        return;
    L13:
        r9 = r110;
        goto L14
    L7:
        r18 = false;
        goto L8
    L9:
        r8 = r15;
        goto L10
    }
}

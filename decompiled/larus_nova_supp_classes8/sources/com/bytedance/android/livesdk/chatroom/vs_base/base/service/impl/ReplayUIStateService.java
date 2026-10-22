package com.bytedance.android.livesdk.chatroom.vs_base.base.service.impl;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayOrientationControlUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.android.scope.o;
import ir1.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mq1.d0;
import mq1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayUIStateService implements o, d0 {
    public int a;
    public final Function0<Integer> b;
    public Lambda c;
    public int d;
    public Lambda e;
    public final HashMap<Class<? extends c>, c> f;
    public final ArrayList<f0> g;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.g.clear();
    }

    public final void q() {
        Iterator<f0> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().wg();
        goto L4
    }

    public ReplayUIStateService() {
        this.a = 1;
        this.b = ReplayUIStateService$isPad$1.INSTANCE;
        this.c = ReplayUIStateService$isLandScreen$1.INSTANCE;
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == false) goto L8;
        if (FoldScreenUtils.e() == false) goto L8;
    L10:
        int r0 = 0;
    L11:
        this.d = r0;
        this.e = ReplayUIStateService$isFoldOpen$1.INSTANCE;
        this.f = new HashMap();
        this.g = new ArrayList();
        return;
    L8:
        if (((Number) this.c.invoke()).intValue() != 8) goto L10;
        r0 = 4;
        goto L11
    }

    @Override // mq1.d0
    public final void a(final boolean r3) {
        int r0 = ((Number) this.c.invoke()).intValue();
        this.c = new ReplayUIStateService$changeLandScreen$1(r3);
        if (r0 != 8) goto L5;
        boolean r1 = true;
    L6:
        if (r3 == r1) goto L9;
        q();
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // mq1.d0
    public final <T extends c> T c(Class<? extends c> r3) {
        Intrinsics.checkNotNullParameter(r3, "ui");
        if (this.f.containsKey(r3) == true) goto L5;
    L6:
        c r0 = r3.newInstance();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "uiStateService");
        r0.a = this;
        if ((r0 instanceof ReplayOrientationControlUIState) == false) goto L9;
        h(r0.b);
    L9:
        this.f.put(r3, r0);
    L10:
        T r4 = (T) this.f.get(r3);
        if (r4 == null) goto L14;
        return r4;
    L14:
        throw new RuntimeException("是不是传错东西进来了？");
    L5:
        if (this.f.get(r3) != null) goto L10;
        goto L6
    }

    @Override // mq1.d0
    public final void d(boolean r4) {
        boolean r0 = false;
        if (r4 == false) goto L5;
    L7:
        int r1 = this.a;
        this.a = r4 ? 1 : 0;
        if (r1 != 1) goto L10;
        r0 = true;
    L10:
        if (r4 == r0) goto L13;
        q();
        return;
    L13:
        return;
    L5:
        if (((Number) this.b.invoke()).intValue() == 2) goto L7;
        f(false);
        goto L7
    }

    @Override // mq1.d0
    public final void f(boolean r5) {
        boolean r1 = false;
        if (this.a == 0) goto L5;
    L7:
        int r0 = this.d;
        if (r5 == false) goto L10;
        int r3 = 4;
    L11:
        this.d = r3;
        if (r0 != 4) goto L14;
        r1 = true;
    L14:
        if (r5 == r1) goto L17;
        q();
        return;
    L17:
        return;
    L10:
        r3 = 0;
        goto L11
    L5:
        if (((Number) this.b.invoke()).intValue() != 0) goto L7;
        r5 = false;
        goto L7
    }

    @Override // mq1.d0
    public final void h(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.add(r2);
    }

    @Override // mq1.d0
    public final void k(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g.remove(r2);
    }

    @Override // mq1.d0
    public final void n(boolean r3) {
        if (FoldScreenUtils.f() == true) goto L6;
        this.e = ReplayUIStateService$changeFoldOpen$1.INSTANCE;
        return;
    L6:
        int r0 = ((Number) this.e.invoke()).intValue();
        if (r3 == false) goto L9;
        Lambda r1 = ReplayUIStateService$changeFoldOpen$2.INSTANCE;
    L10:
        this.e = r1;
        if (r0 != 16) goto L13;
        boolean r2 = true;
    L14:
        if (r3 == r2) goto L17;
        q();
        return;
    L17:
        return;
    L13:
        r2 = false;
        goto L14
    L9:
        r1 = ReplayUIStateService$changeFoldOpen$3.INSTANCE;
        goto L10
    }

    public final boolean o(int r3) {
        if ((r3 ^ (((((this.a | ((Number) this.b.invoke()).intValue()) | this.d) | ((Number) this.c.invoke()).intValue()) | ((Number) this.e.invoke()).intValue()) & r3)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mq1.d0
    public final boolean g(int r2, ReplayTetrisDescriptor<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "vsTetrisDescriptor");
        return o(r2);
    }

    @Override // mq1.d0
    public final boolean i(int r2, ReplayWidgetDescriptor<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "replayWidgetDescriptor");
        return o(r2);
    }

    @Override // mq1.d0
    public final boolean j(int r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "uiState");
        return o(r2);
    }
}

package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.PanelWidget;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/ControlDataDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ControlDataDynamicLoader extends AbsDynamicLoader {
    public final SparseArray<ExtendedToolbarButton.c> h;
    public final Context i;
    public final Function1<String, Unit> j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        MorePanelDynamicControllerViewModel.Companion r1 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r2 = this.a;
        r1.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.c r3 = MorePanelDynamicControllerViewModel.Companion.a(r2);
        List r4 = null;
        if (r3 == null) goto L5;
        List r5 = r3.getDynamicData(new ControlDataDynamicLoader$getNetSwitchData$1(this));
    L7:
        if (r5 == null) goto L38;
        ArrayList r9 = new ArrayList();
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L37;
        PanelWidget r10 = (PanelWidget) r6.next();
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r11 == null) goto L16;
        com.bytedance.live.datacontext.j r12 = r11.getTbCompConfigRegister();
        if (r12 == null) goto L16;
        o r13 = (o) r12.getValue();
    L18:
        if ((r13 instanceof o) == true) goto L20;
        r13 = null;
    L20:
        if (r13 == null) goto L34;
        a0 r14 = r13.getToolbarConfig(r10.getId());
        if (r14 == null) goto L34;
        ToolbarButton r15 = r14.l(false, true);
        if (r15 == null) goto L27;
        r15.setServerId(r10.getId());
    L27:
        if (r15 == null) goto L35;
        s r16 = new s();
        r16.a = r10.getId();
        String r17 = r10.getName();
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.b = r17;
        r16.c = ImageModel.genBy(r10.getImageUrl());
        r16.g = r10.getShowType();
        r16.o = r10.getPayload();
        c0.b r18 = r14.h(r16, true, Boolean.FALSE);
        x3 r19 = g();
        if (r19 == null) goto L35;
        r19.k(r15, r18);
    L35:
        if (r15 == null) goto L10;
        r9.add(r15);
    L34:
        r15 = null;
    L16:
        r13 = null;
        goto L18
    L37:
        r0.addAll(r9);
    L38:
        if (r3 == null) goto L40;
        r4 = r3.getDynamicData(new ControlDataDynamicLoader$getPureDynamicData$1(this));
    L40:
        if (r4 == null) goto L64;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L43:
        if (r8.hasNext() == false) goto L63;
        PanelWidget r20 = (PanelWidget) r8.next();
        ExtendedToolbarButton.c r21 = this.h.get(r20.getId());
        if (r21 != null) goto L56;
        String[] r110 = new String[1];
        String r111 = r20.getImageUrl();
        if (r111 != null) goto L50;
        r111 = "";
    L50:
        r110[0] = r111;
        ArrayList r112 = CollectionsKt.arrayListOf(r110);
        String r113 = r20.getTitle();
        if (r113 != null) goto L53;
        r113 = "";
    L53:
        r21 = new ExtendedToolbarButton.c(r112, r113, false, String.valueOf(r20.getId()));
        this.h.put(r20.getId(), r21);
        x3 r114 = g();
        if (r114 == null) goto L56;
        r114.p(r21, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.i(r20));
    L56:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r115 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r21);
        r115.g = r20.getId();
        r115.i = 2;
        String[] r22 = new String[1];
        String r116 = r20.getImageUrl();
        if (r116 != null) goto L59;
        r116 = "";
    L59:
        r22[0] = r116;
        r115.c = CollectionsKt.arrayListOf(r22);
        String r23 = r20.getTitle();
        if (r23 != null) goto L62;
        r23 = "";
    L62:
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r115.f = r23;
        r115.a = true;
        r7.add(r115);
        goto L43
    L63:
        r0.addAll(r7);
    L64:
        return r0;
    L5:
        r5 = null;
        goto L7
    }

    public final x3 g() {
        c0 r1 = null;
        if (z.m(this.a, true) == false) goto L8;
        g3 r0 = y3.f(this.a);
        if ((r0 instanceof x3) == true) goto L14;
        return null;
    L14:
        return r0;
    L8:
        c0 r2 = y3.i(this.a);
        if ((r2 instanceof x3) == false) goto L13;
        r1 = r2;
    L13:
        return (x3) r1;
    }

    public final Context getContext() {
        return this.i;
    }

    public static final boolean f(ControlDataDynamicLoader r3, int r4) {
        if (r4 != 3) goto L6;
        r3.getClass();
        return true;
    L6:
        if (((Boolean) r3.a.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L10;
        if (r4 == 1) goto L15;
    L12:
        return false;
    L15:
        return true;
    L10:
        if (r4 != 2) goto L12;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ControlDataDynamicLoader(e r2, Context r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "update");
        super(r2);
        this.i = r3;
        this.j = r4;
        this.h = new SparseArray();
    }
}

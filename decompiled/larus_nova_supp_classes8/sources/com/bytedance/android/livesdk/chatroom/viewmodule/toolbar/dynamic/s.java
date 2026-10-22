package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdk.chatroom.utils.v2;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarBizSkin;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import j40.o4;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements ToolbarMatchInterface {
    public static final /* synthetic */ int q = 0;
    public int a;
    public String b;
    public py.k c;
    public String d;
    public String e;
    public int f;
    public int g;
    public IToolbarComponentSkin h;
    public Map<String, v2> i;
    public List<e0> j;
    public List<e0> k;
    public final f0 l;
    public boolean m;
    public boolean n;
    public String o;
    public boolean p;

    public static final class a {
        public static s a(IToolbarComponentData r4) {
            Intrinsics.checkNotNullParameter(r4, "button");
            s r0 = new s();
            r0.a = r4.getId();
            String r1 = r4.getName();
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.b = r1;
            String r3 = r4.getScheme();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.e = r3;
            r0.c = r4.getIcon();
            String r5 = r4.getExtraData();
            if (r5 == null) goto L12;
            r2 = r5;
        L12:
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.d = r2;
            r0.l.b = false;
            r0.f = r4.getGroupId();
            r0.g = RangesKt.coerceAtLeast(r4.getShowType(), 1);
            return r0;
        }
    }

    static {
    }

    public final int getSource() {
        return this.l.b ? 1 : 0;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final boolean isFromMsg() {
        return this.l.b;
    }

    public final boolean isInMore() {
        return Intrinsics.areEqual(this.l.a, Boolean.TRUE);
    }

    public final String toString() {
        if (this.l.b == false) goto L7;
        return this.b + '(' + this.a + "-msg)";
    L7:
        return this.b + '(' + this.a + ')';
    }

    public s() {
        this.a = -1;
        this.b = "";
        this.d = "";
        this.e = "";
        this.g = 3;
        this.l = new f0();
        this.p = true;
    }

    public final String compInfo() {
        return ToolbarMatchInterface.DefaultImpls.compInfo(this);
    }

    public final String getComponentExtra() {
        return this.d;
    }

    public final int getComponentGroupId() {
        return this.f;
    }

    public final int getComponentId() {
        return this.a;
    }

    public final String getComponentName() {
        return this.b;
    }

    public final boolean isBizCheckFinish() {
        return this.p;
    }

    public final boolean isPreloadScene() {
        return this.n;
    }

    public final boolean isQuickPreload() {
        return this.m;
    }

    public final void changeBizCheckFinish(boolean r1) {
        this.p = r1;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(s.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L23;
        s r6 = (s) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(o4.a.getValue(), Boolean.FALSE) == true) goto L19;
    L21:
        return true;
    L19:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L21;
        return false;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.NewToolbarModel");
    L8:
        r2 = null;
        goto L10
    }

    public final void setExtraDataAfterCheck(Object r2) {
        this.l.c = r2;
    }

    public final void updateExtraData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        this.d = r2;
    }

    public final py.e findResource(ResKeyEnum r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        IToolbarBizSkin r0 = null;
        if (r4 == false) goto L9;
        IToolbarComponentSkin r5 = this.h;
        if (r5 == null) goto L14;
        Map r6 = r5.getVertical();
        if (r6 == null) goto L14;
        IToolbarBizSkin r7 = (IToolbarBizSkin) r6.get(r3.getKey());
    L15:
        if (r7 != null) goto L23;
        IToolbarComponentSkin r8 = this.h;
        if (r8 == null) goto L22;
        Map r9 = r8.getGeneral();
        if (r9 == null) goto L22;
        r0 = (IToolbarBizSkin) r9.get(r3.getKey());
    L22:
        return r0;
    L23:
        return r7;
    L14:
        r7 = null;
        goto L15
    L9:
        IToolbarComponentSkin r10 = this.h;
        if (r10 == null) goto L14;
        Map r11 = r10.getLandscape();
        if (r11 == null) goto L14;
        r7 = (IToolbarBizSkin) r11.get(r3.getKey());
        goto L15
    }
}

package com.larksuite.component.card.component.personlist.avatar;

import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.PersonListProps;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J6\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0015\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J0\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "personListProps", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "avatarSize", "", "avatarGap", "moreTextSize", "moreMaxCount", "moreBgColor", "setContent", "", "props", "Lcom/lynx/react/bridge/ReadableMap;", "onLayout", "left", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "adjustShowCount", "showCount", "gap", "needShowMore", "", "maxWidth", "avatarShowData", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode$PersonAvatarExtraData;", "getExtraBundle", "", "Companion", "PersonAvatarExtraData", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonAvatarGroupShadowNode extends ShadowNode implements h {
    public int A;
    public b B;
    public PersonListProps v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final List<PersonInfo> c;
        public final int d;
        public final boolean e;
        public final int f;
        public final int g;
        public final int h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L7:
            return ((((((r0 + r1) * 31) + this.f) * 31) + this.g) * 31) + this.h;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "PersonAvatarExtraData(avatarSize=" + this.a + ", avatarGap=" + this.b + ", personList=" + this.c + ", avatarCount=" + this.d + ", needShowMore=" + this.e + ", moreBgColor=" + this.f + ", moreTextSize=" + this.g + ", moreMaxCount=" + this.h + ')';
        }

        public b(int r2, int r3, List<PersonInfo> r4, int r5, boolean r6, int r7, int r8, int r9) {
            Intrinsics.checkNotNullParameter(r4, "personList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    static {
    }

    public PersonAvatarGroupShadowNode() {
        i(this);
        g.a.getClass();
        this.w = g.d(null);
        this.x = g.a(null);
        this.y = g.e(null);
        this.z = g.c(null);
        this.A = g.b(null);
    }

    public final Object m() {
        return this.B;
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        Gson r1 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L5
        PersonListProps r4 = (PersonListProps) com.larksuite.component.card.component.g.c(r3, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r4 != null) goto L10;
        Log.e("PersonAvatarGroupShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.v = r4;
        g.a.getClass();
        this.w = g.d(r4);
        this.x = g.a(this.v);
        this.y = g.e(this.v);
        this.z = g.c(this.v);
        this.A = g.b(this.v);
        q();
        return;
    L5:
        th = move-exception;
        Log.e("PersonAvatarGroupShadowNode", "props from lynx transform failed", th);
        r4 = null;
        goto L7
    }

    public final void f(int r1, int r2) {
        TraceEvent.beginSection("PersonAvatarGroupShadowNode.onLayout");
        ((LayoutNode) this).e = false;
        TraceEvent.endSection("PersonAvatarGroupShadowNode.onLayout");
    }

    public final long c(LayoutNode r19, float r110, MeasureMode r20, float r21, MeasureMode r22) {
        TraceEvent.beginSection("PersonAvatarGroupShadowNode.measure");
        Log.d("PersonAvatarGroupShadowNode", "\n***************** measure start **********************\n");
        Log.d("PersonAvatarGroupShadowNode", "\n***************** origin width: " + r110 + " height:" + r21 + "  widthMode:" + r20 + "  heightMode:" + r22 + " **********************\n");
        MeasureMode r6 = MeasureMode.UNDEFINED;
        boolean r8 = false;
        if (r20 == r6) goto L17;
        if (r22 == r6) goto L17;
        if (r110 != 0.0f) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L17;
        if (r21 != 0.0f) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L17;
        return i.b(0, 0);
    L13:
        r2 = false;
        goto L14
    L8:
        r4 = false;
    L17:
        PersonListProps r3 = this.v;
        if (r3 == null) goto L47;
        int r5 = (int) (r110 / (this.w - this.x));
        int r7 = r3.getPersons().size();
        int r9 = 5;
        if (r3.getPersons().size() <= r5) goto L30;
        if (r5 > 5) goto L24;
        r9 = r5 - 1;
    L24:
        int r10 = this.w;
        if ((((r10 - this.x) * r9) + r10) <= r110) goto L44;
        if (r9 <= 1) goto L44;
        r9 = r9 - 1;
    L44:
        int r12 = r9;
        boolean r13 = true;
    L46:
        this.B = new b(this.w, this.x, r3.getPersons(), r12, r13, this.A, this.y, this.z);
        goto L47
    L30:
        if (r3.getPersons().size() <= 5) goto L32;
        r8 = true;
    L33:
        int r11 = this.w;
        int r14 = r11 - this.x;
        if (r8 == false) goto L36;
        int r15 = (r14 * r9) + r11;
    L38:
        if (r15 <= r110) goto L42;
        if (r9 <= 1) goto L42;
        r9 = r9 - 1;
    L42:
        if (r9 < r3.getPersons().size()) goto L44;
        r12 = r7;
        r13 = r8;
        goto L46
    L36:
        r15 = ((r9 - 1) * r14) + r11;
        goto L38
    L32:
        r9 = r3.getPersons().size();
    L47:
        TraceEvent.endSection("PersonAvatarGroupShadowNode.measure");
        return i.a(r110, this.w);
    }
}

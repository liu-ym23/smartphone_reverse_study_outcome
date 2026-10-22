package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class DependencyNode implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f13612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13613b;
    public boolean c;
    WidgetRun d;
    Type e;
    int f;
    public int g;
    int h;
    f i;
    public boolean j;
    List<d> k;
    List<DependencyNode> l;

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type HORIZONTAL_DIMENSION = null;
        public static final Type LEFT = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final Type UNKNOWN = null;
        public static final Type VERTICAL_DIMENSION = null;

        static {
            Type r0 = new Type("UNKNOWN", 0);
            UNKNOWN = r0;
            Type r1 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r1;
            Type r3 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r3;
            Type r5 = new Type("LEFT", 3);
            LEFT = r5;
            Type r7 = new Type("RIGHT", 4);
            RIGHT = r7;
            Type r9 = new Type("TOP", 5);
            TOP = r9;
            Type r11 = new Type("BOTTOM", 6);
            BOTTOM = r11;
            Type r13 = new Type("BASELINE", 7);
            BASELINE = r13;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    public DependencyNode(WidgetRun r4) {
        this.f13612a = null;
        this.f13613b = false;
        this.c = false;
        this.e = Type.UNKNOWN;
        this.h = 1;
        this.i = null;
        this.j = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = r4;
    }

    public void a() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.f13613b = false;
    }

    public void a(int r3) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        this.g = r3;
        Iterator<d> r2 = this.k.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin");
        r4.update(r4);
        goto L7
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        this.k.add(r4);
        if (this.j == false) goto L6;
        r4.update(r4);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.d.d.C()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(this.e).append("(");
        if (this.j == false) goto L5;
        Object r1 = Integer.valueOf(this.g);
    L7:
        return r0.append(r1).append(") <t=").append(this.l.size()).append(":d=").append(this.k.size()).append(">").toString();
    L5:
        r1 = "unresolved";
        goto L7
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r8) {
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.memorydata.plugin");
        Iterator<DependencyNode> r10 = this.l.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (((DependencyNode) ZeusTransformUtils.preCheckCast(r10.next(), DependencyNode.class, "com.obric.memorydata.plugin")).j == true) goto L4;
        return;
    L8:
        this.c = true;
        d r1 = this.f13612a;
        if (r1 == null) goto L12;
        r1.update(this);
    L12:
        if (this.f13613b == false) goto L15;
        this.d.update(this);
        return;
    L15:
        DependencyNode r2 = null;
        int r3 = 0;
        Iterator<DependencyNode> r4 = this.l.iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        DependencyNode r5 = (DependencyNode) ZeusTransformUtils.preCheckCast(r4.next(), DependencyNode.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L17;
        r3 = r3 + 1;
        r2 = r5;
        goto L17
    L22:
        if (r2 == null) goto L33;
        if (r3 != 1) goto L33;
        if (r2.j == false) goto L33;
        f r11 = this.i;
        if (r11 != null) goto L29;
    L32:
        a(r2.g + this.f);
        goto L33
    L29:
        if (r11.j == false) goto L31;
        this.f = this.h * this.i.g;
        goto L32
    L31:
        return;
    L33:
        d r12 = this.f13612a;
        if (r12 == null) goto L45;
        r12.update(this);
        return;
    }
}

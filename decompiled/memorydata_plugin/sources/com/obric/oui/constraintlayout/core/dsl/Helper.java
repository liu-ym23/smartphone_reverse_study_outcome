package com.obric.oui.constraintlayout.core.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class Helper {
    protected static final Map<Constraint.Side, String> e = null;
    protected static final Map<Type, String> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f13532b;
    protected a c;
    protected Map<String, String> d;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BARRIER = null;
        public static final Type HORIZONTAL_CHAIN = null;
        public static final Type HORIZONTAL_GUIDELINE = null;
        public static final Type VERTICAL_CHAIN = null;
        public static final Type VERTICAL_GUIDELINE = null;

        static {
            Type r0 = new Type("VERTICAL_GUIDELINE", 0);
            VERTICAL_GUIDELINE = r0;
            Type r1 = new Type("HORIZONTAL_GUIDELINE", 1);
            HORIZONTAL_GUIDELINE = r1;
            Type r3 = new Type("VERTICAL_CHAIN", 2);
            VERTICAL_CHAIN = r3;
            Type r5 = new Type("HORIZONTAL_CHAIN", 3);
            HORIZONTAL_CHAIN = r5;
            Type r7 = new Type("BARRIER", 4);
            BARRIER = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
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

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f13533a;

        public String toString() {
            return this.f13533a;
        }
    }

    static {
        HashMap r0 = new HashMap();
        e = r0;
        r0.put(Constraint.Side.LEFT, "'left'");
        r0.put(Constraint.Side.RIGHT, "'right'");
        r0.put(Constraint.Side.TOP, "'top'");
        r0.put(Constraint.Side.BOTTOM, "'bottom'");
        r0.put(Constraint.Side.START, "'start'");
        r0.put(Constraint.Side.END, "'end'");
        r0.put(Constraint.Side.BASELINE, "'baseline'");
        HashMap r1 = new HashMap();
        f = r1;
        r1.put(Type.VERTICAL_GUIDELINE, "vGuideline");
        r1.put(Type.HORIZONTAL_GUIDELINE, "hGuideline");
        r1.put(Type.VERTICAL_CHAIN, "vChain");
        r1.put(Type.HORIZONTAL_CHAIN, "hChain");
        r1.put(Type.BARRIER, "barrier");
    }

    public void a(Map<String, String> r5, StringBuilder r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r7 = r4.keySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        r6.append(r1).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append((String) ZeusTransformUtils.preCheckCast(r4.get(r1), String.class, "com.obric.memorydata.plugin")).append(",\n");
        goto L7
    }

    public a getType() {
        return this.c;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.f13532b + ":{\n");
        if (this.c == null) goto L5;
        r0.append("type:'").append(this.c.toString()).append("',\n");
    L5:
        Map<String, String> r1 = this.d;
        if (r1 == null) goto L8;
        a(r1, r0);
    L8:
        r0.append("},\n");
        return r0.toString();
    }
}

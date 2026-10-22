package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface STEdGrp extends XmlString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<STEdGrp> f19814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19815b = null;
    public static final Enum c = null;
    public static final Enum d = null;
    public static final Enum e = null;
    public static final Enum f = null;
    public static final Enum g = null;
    public static final Enum h = null;
    public static final Enum i = null;

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ADMINISTRATORS = 3;
        static final int INT_CONTRIBUTORS = 4;
        static final int INT_CURRENT = 7;
        static final int INT_EDITORS = 5;
        static final int INT_EVERYONE = 2;
        static final int INT_NONE = 1;
        static final int INT_OWNERS = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = null;

        static {
            table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("everyone", 2), new Enum("administrators", 3), new Enum("contributors", 4), new Enum("editors", 5), new Enum("owners", 6), new Enum("current", 7)});
        }

        private Enum(String r1, int r2) {
            super(r1, r2);
        }

        public static Enum forInt(int r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        public static Enum forString(String r2) {
            return (Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), Enum.class, "com.obric.memorydata.plugin");
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    static {
        SimpleTypeFactory<STEdGrp> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "stedgrp6bdctype");
        f19814a = r0;
        f19815b = r0.getType();
        c = Enum.forString("none");
        d = Enum.forString("everyone");
        e = Enum.forString("administrators");
        f = Enum.forString("contributors");
        g = Enum.forString("editors");
        h = Enum.forString("owners");
        i = Enum.forString("current");
    }
}

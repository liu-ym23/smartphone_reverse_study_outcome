package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaRegularExpression extends RegularExpression {
    static final Map<String, SchemaRegularExpression> knownPatterns = null;

    static {
        knownPatterns = buildKnownPatternMap();
    }

    private SchemaRegularExpression(String r2) {
        super(r2, "X");
    }

    /* synthetic */ SchemaRegularExpression(String r1, AnonymousClass1 r2) {
        this(r1);
    }

    private static Map<String, SchemaRegularExpression> buildKnownPatternMap() {
        HashMap r0 = new HashMap();
        final String r2 = "\\c+";
        r0.put("\\c+", new AnonymousClass1(r2));
        final String r3 = "\\i\\c*";
        r0.put("\\i\\c*", new AnonymousClass2(r3));
        final String r4 = "[\\i-[:]][\\c-[:]]*";
        r0.put("[\\i-[:]][\\c-[:]]*", new AnonymousClass3(r4));
        return r0;
    }

    public static RegularExpression forPattern(String r3) {
        SchemaRegularExpression r0 = (SchemaRegularExpression) ZeusTransformUtils.preCheckCast(knownPatterns.get(r3), SchemaRegularExpression.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new RegularExpression(r3, "X");
    }
}

package androidx.room.jarjarred.org.antlr.v4.codegen;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ModelElement;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.FormalArgument;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OutputModelWalker {
    STGroup templates;
    Tool tool;

    public OutputModelWalker(Tool r5, STGroup r10) {
        this.tool = r5;
        this.templates = r10;
    }

    public ST walk(OutputModelObject r13, boolean r14) {
        Class<?> r5 = r13.getClass();
        String r10 = r5.getSimpleName();
        if (r14 == false) goto L5;
        r10 = r10.concat("Header");
    L5:
        ST r11 = this.templates.getInstanceOf(r10);
        if (r11 != null) goto L9;
        this.tool.errMgr.toolError(ErrorType.CODE_GEN_TEMPLATES_INCOMPLETE, new Object[]{r10});
        return new ST(j0.k("[", r10, " invalid]"));
    L9:
        Map<String, FormalArgument> r12 = r11.impl.formalArguments;
        if (r12 != null) goto L13;
        this.tool.errMgr.toolError(ErrorType.CODE_TEMPLATE_ARG_ISSUE, new Object[]{r10, "<none>"});
        return r11;
    L13:
        r11.add(r12.keySet().iterator().next(), r13);
        HashSet r15 = new HashSet();
        Field[] r16 = r5.getFields();
        int r17 = r16.length;
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L54;
        Field r19 = r16[r18];
        if (((ModelElement) r19.getAnnotation(ModelElement.class)) == null) goto L53;
        String r20 = r19.getName();
        if (r15.add(r20) == true) goto L22;
        this.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[]{"Model object " + r13.getClass().getSimpleName() + " has multiple fields named '" + r20 + "'"});
        goto L53
    L22:
        if (r12.get(r20) == null) goto L53;
        Object r21 = r19.get(r13);     // Catch: IllegalAccessException -> L52
        if ((r21 instanceof OutputModelObject) == false) goto L28;
        r11.add(r20, walk((OutputModelObject) r21, r14));     // Catch: IllegalAccessException -> L52
        goto L53
    L28:
        if ((r21 instanceof Collection) == true) goto L42;
        if ((r21 instanceof OutputModelObject[]) == true) goto L42;
        if ((r21 instanceof Map) == false) goto L39;
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: IllegalAccessException -> L52
        Iterator r23 = ((Map) r21).entrySet().iterator();     // Catch: IllegalAccessException -> L52
    L36:
        if (r23.hasNext() == false) goto L38;
        Map.Entry r110 = (Map.Entry) r23.next();     // Catch: IllegalAccessException -> L52
        r22.put(r110.getKey(), walk((OutputModelObject) r110.getValue(), r14));     // Catch: IllegalAccessException -> L52
        goto L36
    L38:
        r11.add(r20, r22);     // Catch: IllegalAccessException -> L52
        goto L53
    L39:
        if (r21 == null) goto L53;
        this.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[]{"not recognized nested model element: " + r20});     // Catch: IllegalAccessException -> L52
    L42:
        if ((r21 instanceof OutputModelObject[]) == false) goto L44;
        r21 = Arrays.asList((OutputModelObject[]) r21);     // Catch: IllegalAccessException -> L52
    L44:
        Iterator r24 = ((Collection) r21).iterator();     // Catch: IllegalAccessException -> L52
    L46:
        if (r24.hasNext() == false) goto L53;
        Object r25 = r24.next();     // Catch: IllegalAccessException -> L52
        if (r25 == null) goto L46;
        r11.add(r20, walk((OutputModelObject) r25, r14));     // Catch: IllegalAccessException -> L52
    L52:
        this.tool.errMgr.toolError(ErrorType.CODE_TEMPLATE_ARG_ISSUE, new Object[]{r10, r20});
    L53:
        r18 = r18 + 1;
        goto L14
    L54:
        return r11;
    }
}

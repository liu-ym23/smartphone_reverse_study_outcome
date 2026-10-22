package org.apache.commons.math3.exception.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;
    private Map<String, Object> context;
    private List<Object[]> msgArguments;
    private List<Localizable> msgPatterns;
    private Throwable throwable;

    public ExceptionContext(Throwable r1) {
        this.throwable = r1;
        this.msgPatterns = new ArrayList();
        this.msgArguments = new ArrayList();
        this.context = new HashMap();
    }

    private String buildMessage(Locale r9, String r10) {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.msgPatterns.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Localizable r4 = (Localizable) ZeusTransformUtils.preCheckCast(this.msgPatterns.get(r2), Localizable.class, "com.obric.memorydata.plugin");
        r0.append(new MessageFormat(r4.getLocalizedString(r9), r9).format((Object[]) ZeusTransformUtils.preCheckCast(this.msgArguments.get(r2), Object[].class, "com.obric.memorydata.plugin")));
        r3 = r3 + 1;
        if (r3 >= r1) goto L7;
        r0.append(r10);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    private void deSerializeContext(ObjectInputStream r6) {
        int r0 = r6.readInt();
        this.context = new HashMap();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r6.readObject(), String.class, "com.obric.memorydata.plugin");
        Object r3 = r6.readObject();
        this.context.put(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    private void deSerializeMessages(ObjectInputStream r8) {
        int r0 = r8.readInt();
        this.msgPatterns = new ArrayList(r0);
        this.msgArguments = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        this.msgPatterns.add((Localizable) ZeusTransformUtils.preCheckCast(r8.readObject(), Localizable.class, "com.obric.memorydata.plugin"));
        int r3 = r8.readInt();
        Object[] r4 = new Object[r3];
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        r4[r5] = r8.readObject();
        r5 = r5 + 1;
        goto L5
    L7:
        this.msgArguments.add(r4);
        r2 = r2 + 1;
        goto L3
    }

    private String nonSerializableReplacement(Object r2) {
        return "[Object could not be serialized: " + r2.getClass().getName() + "]";
    }

    private void readObject(ObjectInputStream r4) {
        this.throwable = (Throwable) ZeusTransformUtils.preCheckCast(r4.readObject(), Throwable.class, "com.obric.memorydata.plugin");
        deSerializeMessages(r4);
        deSerializeContext(r4);
    }

    private void serializeContext(ObjectOutputStream r5) {
        r5.writeInt(this.context.size());
        Iterator<Map.Entry<String, Object>> r0 = this.context.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.writeObject(r1.getKey());
        Object r2 = r1.getValue();
        if (ZeusTransformUtils.instanceOf(r2, Serializable.class) == true) goto L9;
        r2 = nonSerializableReplacement(r2);
    L9:
        r5.writeObject(r2);
        goto L4
    }

    private void serializeMessages(ObjectOutputStream r9) {
        int r0 = this.msgPatterns.size();
        r9.writeInt(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        r9.writeObject((Localizable) ZeusTransformUtils.preCheckCast(this.msgPatterns.get(r2), Localizable.class, "com.obric.memorydata.plugin"));
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(this.msgArguments.get(r2), Object[].class, "com.obric.memorydata.plugin");
        int r4 = r3.length;
        r9.writeInt(r4);
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        if (ZeusTransformUtils.instanceOf(r3[r5], Serializable.class) == false) goto L9;
        Object r6 = r3[r5];
    L10:
        r9.writeObject(r6);
        r5 = r5 + 1;
        goto L5
    L9:
        r6 = nonSerializableReplacement(r3[r5]);
        goto L10
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.writeObject(this.throwable);
        serializeMessages(r2);
        serializeContext(r2);
    }

    public void addMessage(Localizable r3, Object... r4) {
        Localizable r5 = (Localizable) ZeusTransformUtils.wrapperContextForParams(r3, Localizable.class, "com.obric.memorydata.plugin");
        this.msgPatterns.add(r5);
        this.msgArguments.add(ArgUtils.flatten(r4));
    }

    public Set<String> getKeys() {
        return this.context.keySet();
    }

    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }

    public String getMessage() {
        return getMessage(Locale.US);
    }

    public String getMessage(Locale r2) {
        return buildMessage(r2, ": ");
    }

    public String getMessage(Locale r1, String r2) {
        return buildMessage(r1, r2);
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Object getValue(String r1) {
        return this.context.get(r1);
    }

    public void setValue(String r1, Object r2) {
        this.context.put(r1, r2);
    }
}

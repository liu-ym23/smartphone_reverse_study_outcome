package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public class StructuredDataCollectionMessage implements MessageCollectionMessage<StructuredDataMessage>, q {
    private static final long serialVersionUID = 5725337076388822924L;
    private final List<StructuredDataMessage> structuredDataMessageList;

    public StructuredDataCollectionMessage(List<StructuredDataMessage> r3) {
        this.structuredDataMessageList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r4) {
        Iterator<StructuredDataMessage> r3 = this.structuredDataMessageList.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((StructuredDataMessage) ZeusTransformUtils.preCheckCast(r3.next(), StructuredDataMessage.class, "com.obric.memorydata.plugin")).formatTo(r4);
        goto L4
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        StringBuilder r0 = new StringBuilder();
        Iterator<StructuredDataMessage> r4 = this.structuredDataMessageList.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        StructuredDataMessage r1 = (StructuredDataMessage) ZeusTransformUtils.preCheckCast(r4.next(), StructuredDataMessage.class, "com.obric.memorydata.plugin");
        if (r1.getFormat() == null) goto L4;
        if (r0.length() <= 0) goto L10;
        r0.append(", ");
    L10:
        r0.append(r1.getFormat());
        goto L4
    L12:
        return r0.toString();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        StringBuilder r0 = new StringBuilder();
        formatTo(r0);
        return r0.toString();
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        ArrayList r0 = new ArrayList();
        Iterator<StructuredDataMessage> r9 = this.structuredDataMessageList.iterator();
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L8;
        Object[] r3 = ((StructuredDataMessage) ZeusTransformUtils.preCheckCast(r9.next(), StructuredDataMessage.class, "com.obric.memorydata.plugin")).getParameters();
        if (r3 == null) goto L4;
        r0.add(r3);
        r2 = r2 + r3.length;
        goto L4
    L8:
        Object[] r10 = new Object[r2];
        Iterator r1 = r0.iterator();
        int r4 = 0;
    L10:
        if (r1.hasNext() == false) goto L14;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r1.next(), Object[].class, "com.obric.memorydata.plugin");
        int r6 = r5.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L10;
        r10[r4] = r5[r7];
        r7 = r7 + 1;
        r4 = r4 + 1;
        goto L12
    L14:
        return r10;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        Iterator<StructuredDataMessage> r3 = this.structuredDataMessageList.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Throwable r0 = ((StructuredDataMessage) ZeusTransformUtils.preCheckCast(r3.next(), StructuredDataMessage.class, "com.obric.memorydata.plugin")).getThrowable();
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<StructuredDataMessage> iterator() {
        return this.structuredDataMessageList.iterator();
    }
}

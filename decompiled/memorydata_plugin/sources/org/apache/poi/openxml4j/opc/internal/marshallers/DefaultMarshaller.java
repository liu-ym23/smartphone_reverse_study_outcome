package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.OutputStream;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;

/* JADX INFO: loaded from: classes7.dex */
public final class DefaultMarshaller implements PartMarshaller {
    public DefaultMarshaller() {
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart r1, OutputStream r2) {
        return r1.save(r2);
    }
}

package org.apache.poi.openxml4j.opc.internal;

import java.io.InputStream;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;

/* JADX INFO: loaded from: classes7.dex */
public interface PartUnmarshaller {
    PackagePart unmarshall(UnmarshallContext r1, InputStream r2);
}

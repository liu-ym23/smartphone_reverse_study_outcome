package org.apache.poi.openxml4j.opc;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes7.dex */
public final class StreamHelper {
    public static boolean saveXmlInStream(Document r3, final OutputStream r4) {
        Document r5 = (Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin");
        Transformer r0 = XMLHelper.newTransformer();     // Catch: TransformerException -> L6
        DOMSource r1 = new DOMSource(r5);     // Catch: TransformerException -> L6
        StreamResult r6 = new StreamResult(new AnonymousClass1(r4));     // Catch: TransformerException -> L6
        r0.setOutputProperty("encoding", RpcUtils.CHARSET_UTF8);     // Catch: TransformerException -> L6
        r0.setOutputProperty("indent", "no");     // Catch: TransformerException -> L6
        r0.setOutputProperty("standalone", "yes");     // Catch: TransformerException -> L6
        r0.transform(r1, r6);     // Catch: TransformerException -> L6
        return true;
    L6:
        return false;
    }
}

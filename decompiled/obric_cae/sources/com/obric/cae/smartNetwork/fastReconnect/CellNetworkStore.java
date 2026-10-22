package com.obric.cae.smartNetwork.fastReconnect;

import com.obric.cae.log.CaeLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes2.dex */
public class CellNetworkStore {
    private static final String TAG = "CellNetworkStore";

    public CellNetworkStore() {
    }

    public static List<CellNetworkInfo> readCellInfoFromFile(String r10) {
        ArrayList r8 = new ArrayList();
        File r11 = new File(r10);     // Catch: Exception -> L18
        if (r11.exists() == true) goto L7;
        CaeLog.d(TAG, r10 + " filePath not exist!");     // Catch: Exception -> L18
        return r8;
    L7:
        Document r12 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(r11);     // Catch: Exception -> L18
        r12.getDocumentElement().normalize();     // Catch: Exception -> L18
        NodeList r13 = r12.getElementsByTagName("CellInfo");     // Catch: Exception -> L18
        int r14 = 0;
    L9:
        if (r14 >= r13.getLength()) goto L20;
        Node r15 = r13.item(r14);     // Catch: Exception -> L18
        if (r15.getNodeType() != 1) goto L17;
        Element r16 = (Element) r15;     // Catch: Exception -> L18
        long r17 = Long.parseLong(r16.getElementsByTagName("CellId").item(0).getTextContent());     // Catch: Exception -> L18
        NodeList r18 = r16.getElementsByTagName("Network");     // Catch: Exception -> L18
        ArrayList r19 = new ArrayList();     // Catch: Exception -> L18
        int r20 = 0;
    L14:
        if (r20 >= r18.getLength()) goto L16;
        r19.add(r18.item(r20).getTextContent());     // Catch: Exception -> L18
        r20 = r20 + 1;     // Catch: Exception -> L18
        goto L14
    L16:
        r8.add(new CellNetworkInfo(r17, r19));     // Catch: Exception -> L18
    L17:
        r14 = r14 + 1;
    L20:
        return r8;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public static void writeCellInfoToFile(List<CellNetworkInfo> r8, String r10) {
        Document r11 = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();     // Catch: Exception -> L11
        Element r12 = r11.createElement("CellInfoList");     // Catch: Exception -> L11
        r11.appendChild(r12);     // Catch: Exception -> L11
        Iterator<CellNetworkInfo> r13 = r8.iterator();     // Catch: Exception -> L11
    L4:
        if (r13.hasNext() == false) goto L9;
        CellNetworkInfo r14 = r13.next();     // Catch: Exception -> L11
        Element r15 = r11.createElement("CellInfo");     // Catch: Exception -> L11
        r12.appendChild(r15);     // Catch: Exception -> L11
        Element r16 = r11.createElement("CellId");     // Catch: Exception -> L11
        r16.appendChild(r11.createTextNode(Long.toString(r14.getCellId())));     // Catch: Exception -> L11
        r15.appendChild(r16);     // Catch: Exception -> L11
        Iterator<String> r17 = r14.getNetworkList().iterator();     // Catch: Exception -> L11
    L7:
        if (r17.hasNext() == false) goto L4;
        String r18 = r17.next();     // Catch: Exception -> L11
        Element r19 = r11.createElement("Network");     // Catch: Exception -> L11
        r19.appendChild(r11.createTextNode(r18));     // Catch: Exception -> L11
        r15.appendChild(r19);     // Catch: Exception -> L11
        goto L7
    L9:
        Transformer r20 = TransformerFactory.newInstance().newTransformer();     // Catch: Exception -> L11
        DOMSource r21 = new DOMSource(r11);     // Catch: Exception -> L11
        StreamResult r22 = new StreamResult(new File(r10));     // Catch: Exception -> L11
        r20.setOutputProperty("indent", "yes");     // Catch: Exception -> L11
        r20.transform(r21, r22);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}

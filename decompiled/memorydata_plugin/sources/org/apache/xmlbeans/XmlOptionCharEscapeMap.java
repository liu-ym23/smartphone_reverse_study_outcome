package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public class XmlOptionCharEscapeMap {
    private static final Map<Character, String> _predefEntities = null;
    private final Map<Character, String> _charMap;

    static {
        HashMap r0 = new HashMap();
        _predefEntities = r0;
        r0.put(Character.valueOf(Typography.less), "&lt;");
        r0.put(Character.valueOf(Typography.greater), "&gt;");
        r0.put(Character.valueOf(Typography.amp), "&amp;");
        r0.put('\'', "&apos;");
        r0.put(Character.valueOf(Typography.quote), "&quot;");
    }

    public XmlOptionCharEscapeMap() {
        this._charMap = new HashMap();
    }

    public boolean containsChar(char r1) {
        return this._charMap.containsKey(Character.valueOf(r1));
    }

    public String getEscapedString(char r2) {
        return (String) ZeusTransformUtils.preCheckCast(this._charMap.get(Character.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }
}

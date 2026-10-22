package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class StringEnumAbstractBase implements Serializable {
    private static final long serialVersionUID = 1;
    private int _int;
    private String _string;

    public static final class Table {
        private List<StringEnumAbstractBase> _list;
        private Map<String, StringEnumAbstractBase> _map;

        public Table(StringEnumAbstractBase[] r5) {
            this._map = new HashMap(r5.length);
            this._list = new ArrayList(r5.length + 1);
            int r0 = 0;
        L4:
            if (r0 >= r5.length) goto L10;
            this._map.put(r5[r0].toString(), r5[r0]);
            int r1 = r5[r0].intValue();
        L7:
            if (this._list.size() > r1) goto L9;
            this._list.add(null);
            goto L7
        L9:
            this._list.set(r1, r5[r0]);
            r0 = r0 + 1;
            goto L4
        }

        public StringEnumAbstractBase forInt(int r2) {
            if (r2 >= 0) goto L4;
            return null;
        L4:
            if (r2 <= this._list.size()) goto L7;
            return null;
        L7:
            return (StringEnumAbstractBase) ZeusTransformUtils.preCheckCast(this._list.get(r2), StringEnumAbstractBase.class, "com.obric.memorydata.plugin");
        }

        public StringEnumAbstractBase forString(String r2) {
            return (StringEnumAbstractBase) ZeusTransformUtils.preCheckCast(this._map.get(r2), StringEnumAbstractBase.class, "com.obric.memorydata.plugin");
        }
    }

    public StringEnumAbstractBase(String r1, int r2) {
        this._string = r1;
        this._int = r2;
    }

    public final int hashCode() {
        return this._string.hashCode();
    }

    public final int intValue() {
        return this._int;
    }

    public final String toString() {
        return this._string;
    }
}

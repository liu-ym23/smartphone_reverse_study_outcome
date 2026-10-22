package org.apache.poi.ss.formula.function;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class FunctionMetadata {
    private final int _index;
    private final int _maxParams;
    private final int _minParams;
    private final String _name;
    private final byte[] _parameterClassCodes;
    private final byte _returnClassCode;

    FunctionMetadata(int r1, String r2, int r3, int r4, byte r5, byte[] r6) {
        this._index = r1;
        this._name = r2;
        this._minParams = r3;
        this._maxParams = r4;
        this._returnClassCode = r5;
        if (r6 != null) goto L5;
        byte[] r7 = null;
    L6:
        this._parameterClassCodes = r7;
        return;
    L5:
        r7 = (byte[]) ZeusTransformUtils.preCheckCast(r6.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public int getIndex() {
        return this._index;
    }

    public int getMaxParams() {
        return this._maxParams;
    }

    public int getMinParams() {
        return this._minParams;
    }

    public String getName() {
        return this._name;
    }

    public byte[] getParameterClassCodes() {
        return (byte[]) ZeusTransformUtils.preCheckCast(this._parameterClassCodes.clone(), byte[].class, "com.obric.memorydata.plugin");
    }

    public byte getReturnClassCode() {
        return this._returnClassCode;
    }

    public boolean hasFixedArgsLength() {
        if (this._minParams != this._maxParams) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUnlimitedVarags() {
        if (30 != this._maxParams) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return getClass().getName() + " [" + this._index + " " + this._name + "]";
    }
}

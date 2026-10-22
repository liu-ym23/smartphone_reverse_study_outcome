package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hwpf.sprm.CharacterSprmUncompressor;
import org.apache.poi.hwpf.sprm.SprmBuffer;
import org.apache.poi.hwpf.usermodel.CharacterProperties;

/* JADX INFO: loaded from: classes7.dex */
public final class CHPX extends BytePropertyNode<CHPX> {
    CHPX(int r1, int r2, SprmBuffer r3) {
        super(r1, r2, r3);
    }

    public CharacterProperties getCharacterProperties(StyleSheet r2, short r3) {
        if (r2 != null) goto L6;
        return new CharacterProperties();
    L6:
        return CharacterSprmUncompressor.uncompressCHP(r2, r2.getCharacterStyle(r3), getGrpprl(), 0);
    }

    public byte[] getGrpprl() {
        return ((SprmBuffer) ZeusTransformUtils.preCheckCast(this._buf, SprmBuffer.class, "com.obric.memorydata.plugin")).toByteArray();
    }

    public SprmBuffer getSprmBuf() {
        return (SprmBuffer) ZeusTransformUtils.preCheckCast(this._buf, SprmBuffer.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "CHPX from " + getStart() + " to " + getEnd() + " (in bytes " + getStartBytes() + " to " + getEndBytes() + ")";
    }
}

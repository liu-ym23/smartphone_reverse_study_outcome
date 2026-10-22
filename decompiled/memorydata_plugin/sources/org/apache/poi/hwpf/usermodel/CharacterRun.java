package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.CHPX;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.sprm.SprmBuffer;

/* JADX INFO: loaded from: classes7.dex */
public final class CharacterRun extends Range {
    protected SprmBuffer _chpx;
    protected short _istd;
    protected CharacterProperties _props;

    CharacterRun(CHPX r4, StyleSheet r5, short r6, Range r7) {
        super(Math.max(r7._start, r4.getStart()), Math.min(r7._end, r4.getEnd()), r7);
        this._props = r4.getCharacterProperties(r5, r6);
        this._chpx = r4.getSprmBuf();
        this._istd = r6;
    }

    public int getPicOffset() {
        return this._props.getFcPic();
    }

    public boolean isData() {
        return this._props.isFData();
    }

    public boolean isObj() {
        return this._props.isFObj();
    }

    public boolean isOle2() {
        return this._props.isFOle2();
    }

    public boolean isSpecialCharacter() {
        return this._props.isFSpec();
    }

    @Override // org.apache.poi.hwpf.usermodel.Range
    public String toString() {
        String r2 = text();
        return "CharacterRun of " + r2.length() + " characters - " + r2;
    }
}

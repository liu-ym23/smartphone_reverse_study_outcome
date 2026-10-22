package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFComment extends HSSFTextbox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NoteRecord _note;

    static {
    }

    public HSSFComment(EscherContainerRecord r1, ObjRecord r2, TextObjectRecord r3, NoteRecord r4) {
        super(r1, r2, r3);
        this._note = r4;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, HSSFComment.class) == true) goto L6;
        return false;
    L6:
        HSSFComment r4 = (HSSFComment) ZeusTransformUtils.preCheckCast(r3, HSSFComment.class, "com.obric.memorydata.plugin");
        return getNoteRecord().equals(r4.getNoteRecord());
    }

    public int getColumn() {
        return this._note.getColumn();
    }

    public NoteRecord getNoteRecord() {
        return this._note;
    }

    public int getRow() {
        return this._note.getRow();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(getRow()), Integer.valueOf(getColumn())});
    }
}

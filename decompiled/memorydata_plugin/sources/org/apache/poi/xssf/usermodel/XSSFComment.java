package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.a;
import com.microsoft.schemas.vml.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.model.CommentsTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ag;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFComment {
    private final ag _comment;
    private final Comments _comments;
    private XSSFRichTextString _str;
    private final o _vmlShape;

    public XSSFComment(Comments r3, ag r4, o r5) {
        Comments r6 = (Comments) ZeusTransformUtils.wrapperContextForParams(r3, Comments.class, "com.obric.memorydata.plugin");
        ag r7 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.memorydata.plugin");
        o r8 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin");
        this._comment = r7;
        this._comments = r6;
        this._vmlShape = r8;
        if (r7 == null) goto L9;
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.sizeOfClientDataArray() <= 0) goto L11;
        CellReference r2 = new CellReference(r7.getRef());
        a r9 = r8.getClientDataArray(0);
        r9.setRowArray(0, new BigInteger(String.valueOf(r2.getRow())));
        r9.setColumnArray(0, new BigInteger(String.valueOf(r2.getCol())));
        avoidXmlbeansCorruptPointer(r8);
        return;
    L11:
        return;
    }

    public XSSFComment(CommentsTable r3, ag r4, o r5) {
        this(r3, (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.memorydata.plugin"), (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin"));
    }

    private static void avoidXmlbeansCorruptPointer(o r2) {
        ((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin")).getClientDataList().toString();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFComment.class) == true) goto L5;
        return false;
    L5:
        XSSFComment r5 = (XSSFComment) ZeusTransformUtils.preCheckCast(r4, XSSFComment.class, "com.obric.memorydata.plugin");
        if (getCTComment() == r5.getCTComment()) goto L8;
        return false;
    L8:
        if (getCTShape() != r5.getCTShape()) goto L12;
        return true;
    L12:
        return false;
    }

    public CellAddress getAddress() {
        return new CellAddress(this._comment.getRef());
    }

    public ag getCTComment() {
        return this._comment;
    }

    public o getCTShape() {
        return this._vmlShape;
    }

    public int getColumn() {
        return getAddress().getColumn();
    }

    public int getRow() {
        return getAddress().getRow();
    }

    public XSSFRichTextString getString() {
        if (this._str != null) goto L8;
        if (this._comment.getText() == null) goto L8;
        this._str = new XSSFRichTextString(this._comment.getText());
    L8:
        return this._str;
    }

    public int hashCode() {
        return ((getRow() * 17) + getColumn()) * 31;
    }
}

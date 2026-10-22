package androidx.room.jarjarred.org.stringtemplate.v4;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AutoIndentWriter implements STWriter {
    public int[] anchors;
    public int anchors_sp;
    public boolean atStartOfLine;
    public int charIndex;
    public int charPosition;
    public List<String> indents;
    public int lineWidth;
    public String newline;
    public Writer out;

    public AutoIndentWriter(Writer r5, String r10) {
        ArrayList r11 = new ArrayList();
        this.indents = r11;
        this.anchors = new int[10];
        this.anchors_sp = -1;
        this.atStartOfLine = true;
        this.charPosition = 0;
        this.charIndex = 0;
        this.lineWidth = -1;
        this.out = r5;
        r11.add(null);
        this.newline = r10;
    }

    public int indent() throws IOException {
        Iterator<String> r5 = this.indents.iterator();
        int r10 = 0;
    L4:
        if (r5.hasNext() == false) goto L8;
        String r11 = r5.next();
        if (r11 == null) goto L4;
        int r12 = r11.length() + r10;
        this.out.write(r11);
        r10 = r12;
        goto L4
    L8:
        int r13 = this.anchors_sp;
        if (r13 < 0) goto L16;
        int r14 = this.anchors[r13];
        if (r14 <= r10) goto L16;
        int r15 = r14 - r10;
        int r16 = 1;
    L13:
        if (r16 > r15) goto L15;
        this.out.write(32);
        r16 = r16 + 1;
        goto L13
    L15:
        r10 = r10 + r15;
    L16:
        this.charPosition += r10;
        this.charIndex += r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int index() {
        return this.charIndex;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public void popAnchorPoint() {
        this.anchors_sp--;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public String popIndentation() {
        List<String> r5 = this.indents;
        return r5.remove(r5.size() - 1);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public void pushAnchorPoint() {
        int r5 = this.anchors_sp + 1;
        int[] r10 = this.anchors;
        if (r5 < r10.length) goto L5;
        int[] r11 = new int[r10.length * 2];
        System.arraycopy(r10, 0, r11, 0, r10.length - 1);
        this.anchors = r11;
    L5:
        int r12 = this.anchors_sp + 1;
        this.anchors_sp = r12;
        this.anchors[r12] = this.charPosition;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public void pushIndentation(String r5) {
        this.indents.add(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public void setLineWidth(int r5) {
        this.lineWidth = r5;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int write(String r10) throws IOException {
        int r5 = this.newline.length();
        int r11 = r10.length();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L15;
        char r14 = r10.charAt(r12);
        if (r14 == '\r') goto L14;
        if (r14 != '\n') goto L11;
        this.atStartOfLine = true;
        this.charPosition = -r5;
        this.out.write(this.newline);
        r13 = r13 + r5;
        this.charIndex += r5;
        this.charPosition += r13;
        goto L14
    L11:
        if (this.atStartOfLine == false) goto L13;
        r13 = r13 + indent();
        this.atStartOfLine = false;
    L13:
        r13 = r13 + 1;
        this.out.write(r14);
        this.charPosition++;
        this.charIndex++;
    L14:
        r12 = r12 + 1;
        goto L3
    L15:
        return r13;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int writeSeparator(String r5) throws IOException {
        return write(r5);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int writeWrap(String r10) throws IOException {
        int r5 = this.lineWidth;
        if (r5 == (-1)) goto L26;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (this.atStartOfLine == false) goto L8;
        return 0;
    L8:
        if (this.charPosition < r5) goto L29;
        int r11 = 0;
        int r12 = 0;
    L11:
        if (r11 >= r10.length()) goto L21;
        char r13 = r10.charAt(r11);
        if (r13 == '\r') goto L19;
        if (r13 != '\n') goto L18;
        this.out.write(this.newline);
        int r14 = this.newline.length() + r12;
        this.charPosition = 0;
        this.charIndex = this.newline.length() + this.charIndex;
        r12 = indent() + r14;
        goto L19
    L18:
        r12 = r12 + 1;
        this.out.write(r13);
        this.charPosition++;
        this.charIndex++;
    L19:
        r11 = r11 + 1;
        goto L11
    L21:
        return r12;
    L29:
        return 0;
    L26:
        return 0;
    }

    public AutoIndentWriter(Writer r5) {
        this(r5, System.getProperty("line.separator"));
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.STWriter
    public int write(String r5, String r10) throws IOException {
        int r11 = writeWrap(r10);
        return write(r5) + r11;
    }
}

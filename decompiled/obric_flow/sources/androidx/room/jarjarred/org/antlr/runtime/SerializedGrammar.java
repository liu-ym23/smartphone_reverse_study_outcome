package androidx.room.jarjarred.org.antlr.runtime;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SerializedGrammar {
    public static final String COOKIE = "$ANTLR";
    public static final int FORMAT_VERSION = 1;
    public String name;
    public List<? extends Rule> rules;
    public char type;

    public class Block extends Node {
        List[] alts;
        final /* synthetic */ SerializedGrammar this$0;

        public Block(SerializedGrammar r5, List[] r10) {
            this.this$0 = r5;
            super(r5);
            this.alts = r10;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.SerializedGrammar.Node
        public String toString() {
            StringBuilder r5 = new StringBuilder("(");
            int r10 = 0;
        L3:
            List[] r11 = this.alts;
            if (r10 >= r11.length) goto L9;
            List r12 = r11[r10];
            if (r10 <= 0) goto L8;
            r5.append("|");
        L8:
            r5.append(r12.toString());
            r10 = r10 + 1;
            goto L3
        L9:
            r5.append(")");
            return r5.toString();
        }
    }

    public abstract class Node {
        final /* synthetic */ SerializedGrammar this$0;

        public Node(SerializedGrammar r5) {
            this.this$0 = r5;
        }

        public abstract String toString();
    }

    public class Rule {
        Block block;
        String name;
        final /* synthetic */ SerializedGrammar this$0;

        public Rule(SerializedGrammar r5, String r10, Block r11) {
            this.this$0 = r5;
            this.name = r10;
            this.block = r11;
        }

        public String toString() {
            return this.name + ":" + this.block;
        }
    }

    public class RuleRef extends Node {
        int ruleIndex;
        final /* synthetic */ SerializedGrammar this$0;

        public RuleRef(SerializedGrammar r5, int r10) {
            this.this$0 = r5;
            super(r5);
            this.ruleIndex = r10;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.SerializedGrammar.Node
        public String toString() {
            return String.valueOf(this.ruleIndex);
        }
    }

    public class TokenRef extends Node {
        final /* synthetic */ SerializedGrammar this$0;
        int ttype;

        public TokenRef(SerializedGrammar r5, int r10) {
            this.this$0 = r5;
            super(r5);
            this.ttype = r10;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.SerializedGrammar.Node
        public String toString() {
            return String.valueOf(this.ttype);
        }
    }

    public SerializedGrammar(String r5) throws IOException {
        System.out.println("loading " + r5);
        DataInputStream r10 = new DataInputStream(new BufferedInputStream(new FileInputStream(r5)));
        readFile(r10);
        r10.close();
    }

    public List<Node> readAlt(DataInputStream r5) throws IOException {
        ArrayList r10 = new ArrayList();
        if (r5.readByte() != 65) goto L26;
        byte r11 = r5.readByte();
    L6:
        if (r11 == 59) goto L24;
        if (r11 != 45) goto L10;
        r5.readChar();
        r5.readChar();
    L23:
        r11 = r5.readByte();
        goto L6
    L10:
        if (r11 != 66) goto L12;
        r10.add(readBlock(r5));
        goto L23
    L12:
        if (r11 != 114) goto L14;
        r10.add(new RuleRef(this, r5.readShort()));
        goto L23
    L14:
        if (r11 != 116) goto L16;
        r10.add(new TokenRef(this, r5.readShort()));
        goto L23
    L16:
        if (r11 != 126) goto L23;
        r5.readShort();
        goto L23
    L24:
        return r10;
    L26:
        throw new IOException("missing A on start of alt");
    }

    public Block readBlock(DataInputStream r5) throws IOException {
        int r10 = r5.readShort();
        List[] r11 = new List[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L6;
        r11[r12] = readAlt(r5);
        r12 = r12 + 1;
        goto L3
    L6:
        return new Block(this, r11);
    }

    public void readFile(DataInputStream r5) throws IOException {
        if (readString(r5).equals(COOKIE) == false) goto L7;
        r5.readByte();
        char r10 = (char) r5.readByte();
        this.type = r10;
        String r11 = readString(r5);
        this.name = r11;
        PrintStream r12 = System.out;
        r12.println(r10 + " grammar " + r11);
        short r13 = r5.readShort();
        StringBuilder r14 = new StringBuilder("num rules = ");
        r14.append(r13);
        r12.println(r14.toString());
        this.rules = readRules(r5, r13);
        return;
    L7:
        throw new IOException("not a serialized grammar file");
    }

    public Rule readRule(DataInputStream r5) throws IOException {
        if (r5.readByte() != 82) goto L11;
        String r10 = readString(r5);
        System.out.println("rule: " + r10);
        r5.readByte();
        Block r11 = readBlock(r5);
        if (r5.readByte() != 46) goto L9;
        return new Rule(this, r10, r11);
    L9:
        throw new IOException("missing . on end of rule");
    L11:
        throw new IOException("missing R on start of rule");
    }

    public List<? extends Rule> readRules(DataInputStream r5, int r10) throws IOException {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11.add(readRule(r5));
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public String readString(DataInputStream r5) throws IOException {
        byte r10 = r5.readByte();
        StringBuilder r11 = new StringBuilder();
    L4:
        if (r10 == 59) goto L7;
        r11.append((char) r10);
        r10 = r5.readByte();
        goto L4
    L7:
        return r11.toString();
    }

    public String toString() {
        return this.type + " grammar " + this.name + this.rules;
    }
}

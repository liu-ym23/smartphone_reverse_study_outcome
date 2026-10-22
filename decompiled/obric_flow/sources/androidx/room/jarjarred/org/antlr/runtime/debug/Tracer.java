package androidx.room.jarjarred.org.antlr.runtime.debug;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class Tracer extends BlankDebugEventListener {
    public IntStream input;
    protected int level;

    public Tracer(IntStream r5) {
        this.level = 0;
        this.input = r5;
    }

    public void enterRule(String r5) {
        int r10 = 1;
    L4:
        if (r10 > this.level) goto L6;
        System.out.print(" ");
        r10 = r10 + 1;
        goto L4
    L6:
        PrintStream r11 = System.out;
        StringBuilder r12 = j0.x("> ", r5, " lookahead(1)=");
        r12.append(getInputSymbol(1));
        r11.println(r12.toString());
        this.level++;
    }

    public void exitRule(String r5) {
        this.level--;
        int r10 = 1;
    L4:
        if (r10 > this.level) goto L6;
        System.out.print(" ");
        r10 = r10 + 1;
        goto L4
    L6:
        PrintStream r11 = System.out;
        StringBuilder r12 = j0.x("< ", r5, " lookahead(1)=");
        r12.append(getInputSymbol(1));
        r11.println(r12.toString());
    }

    public Object getInputSymbol(int r5) {
        IntStream r10 = this.input;
        if ((r10 instanceof TokenStream) == false) goto L7;
        return ((TokenStream) r10).LT(r5);
    L7:
        return Character.valueOf((char) r10.LA(r5));
    }
}

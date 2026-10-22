package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class LexerActionExecutor {
    private final int hashCode;
    private final LexerAction[] lexerActions;

    public LexerActionExecutor(LexerAction[] r5) {
        this.lexerActions = r5;
        int r10 = MurmurHash.initialize();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10 = MurmurHash.update(r10, r5[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        this.hashCode = MurmurHash.finish(r10, r5.length);
    }

    public static LexerActionExecutor append(LexerActionExecutor r5, LexerAction r10) {
        if (r5 == null) goto L5;
        LexerAction[] r11 = r5.lexerActions;
        LexerAction[] r12 = (LexerAction[]) Arrays.copyOf(r11, r11.length + 1);
        r12[r12.length - 1] = r10;
        return new LexerActionExecutor(r12);
    L5:
        return new LexerActionExecutor(new LexerAction[]{r10});
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerActionExecutor) == true) goto L8;
        return false;
    L8:
        LexerActionExecutor r10 = (LexerActionExecutor) r5;
        if (this.hashCode != r10.hashCode) goto L14;
        if (Arrays.equals(this.lexerActions, r10.lexerActions) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public void execute(Lexer r10, CharStream r11, int r12) {
        int r5 = r11.index();
        boolean r13 = false;
        LexerAction[] r14 = this.lexerActions;     // Catch: Throwable -> L22
        int r15 = r14.length;     // Catch: Throwable -> L22
        int r16 = 0;
        boolean r17 = false;
    L5:
        if (r16 >= r15) goto L19;
        LexerAction r18 = r14[r16];     // Catch: Throwable -> L11
        if ((r18 instanceof LexerIndexedCustomAction) == false) goto L14;
        int r19 = ((LexerIndexedCustomAction) r18).getOffset() + r12;     // Catch: Throwable -> L11
        r11.seek(r19);     // Catch: Throwable -> L11
        r18 = ((LexerIndexedCustomAction) r18).getAction();     // Catch: Throwable -> L11
        if (r19 == r5) goto L16;
        r17 = true;
    L17:
        r18.execute(r10);     // Catch: Throwable -> L11
        r16 = r16 + 1;
    L16:
        r17 = false;
        goto L17
    L14:
        if (r18.isPositionDependent() == false) goto L17;
        r11.seek(r5);     // Catch: Throwable -> L11
    L11:
        th = th;
        r13 = r17;
    L23:
        if (r13 == false) goto L25;
        r11.seek(r5);
    L25:
        throw th;
    L19:
        if (r17 == false) goto L31;
        r11.seek(r5);
        return;
    L31:
        return;
    L22:
        th = th;
        goto L23
    }

    public LexerActionExecutor fixOffsetBeforeMatch(int r5) {
        LexerAction[] r10 = null;
        int r11 = 0;
    L3:
        LexerAction[] r12 = this.lexerActions;
        if (r11 >= r12.length) goto L13;
        if (r12[r11].isPositionDependent() == false) goto L12;
        LexerAction[] r13 = this.lexerActions;
        if ((r13[r11] instanceof LexerIndexedCustomAction) == true) goto L12;
        if (r10 != null) goto L11;
        r10 = (LexerAction[]) r13.clone();
    L11:
        r10[r11] = new LexerIndexedCustomAction(r5, this.lexerActions[r11]);
    L12:
        r11 = r11 + 1;
        goto L3
    L13:
        if (r10 != null) goto L16;
        return this;
    L16:
        return new LexerActionExecutor(r10);
    }

    public LexerAction[] getLexerActions() {
        return this.lexerActions;
    }

    public int hashCode() {
        return this.hashCode;
    }
}

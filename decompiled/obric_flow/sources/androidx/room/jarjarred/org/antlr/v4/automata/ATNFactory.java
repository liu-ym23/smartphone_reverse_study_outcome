package androidx.room.jarjarred.org.antlr.v4.automata;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ATNFactory {

    public static class Handle {
        public ATNState left;
        public ATNState right;

        public Handle(ATNState r5, ATNState r10) {
            this.left = r5;
            this.right = r10;
        }

        public String toString() {
            return "(" + this.left + "," + this.right + ")";
        }
    }

    Handle action(ActionAST r5);

    Handle action(String r5);

    Handle alt(List<Handle> r5);

    Handle block(BlockAST r5, GrammarAST r10, List<Handle> r11);

    Handle charSetLiteral(GrammarAST r5);

    ATN createATN();

    Handle epsilon(GrammarAST r5);

    Handle label(Handle r5);

    Handle lexerAltCommands(Handle r5, Handle r10);

    Handle lexerCallCommand(GrammarAST r5, GrammarAST r10);

    Handle lexerCommand(GrammarAST r5);

    Handle listLabel(Handle r5);

    ATNState newState();

    Handle optional(GrammarAST r5, Handle r10);

    Handle plus(GrammarAST r5, Handle r10);

    Handle range(GrammarAST r5, GrammarAST r10);

    Handle rule(GrammarAST r5, String r10, Handle r11);

    Handle ruleRef(GrammarAST r5);

    Handle sempred(PredAST r5);

    Handle set(GrammarAST r5, List<GrammarAST> r10, boolean r11);

    void setCurrentOuterAlt(int r5);

    void setCurrentRuleName(String r5);

    Handle star(GrammarAST r5, Handle r10);

    Handle stringLiteral(TerminalAST r5);

    Handle tokenRef(TerminalAST r5);

    Handle wildcard(GrammarAST r5);
}

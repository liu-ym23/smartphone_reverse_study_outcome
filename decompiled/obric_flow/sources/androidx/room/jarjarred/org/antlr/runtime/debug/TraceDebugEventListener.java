package androidx.room.jarjarred.org.antlr.runtime.debug;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class TraceDebugEventListener extends BlankDebugEventListener {
    TreeAdaptor adaptor;

    public TraceDebugEventListener(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Object r10) {
        int r11 = this.adaptor.getUniqueID(r10);
        String r12 = this.adaptor.getText(r10);
        int r13 = this.adaptor.getType(r10);
        PrintStream r14 = System.out;
        StringBuilder r15 = j0.v("LT ", r5, r11, " ", " ");
        r15.append(r12);
        r15.append(" ");
        r15.append(r13);
        r14.println(r15.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void addChild(Object r5, Object r10) {
        System.out.println("addChild " + this.adaptor.getUniqueID(r5) + ", " + this.adaptor.getUniqueID(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void becomeRoot(Object r5, Object r10) {
        System.out.println("becomeRoot " + this.adaptor.getUniqueID(r5) + ", " + this.adaptor.getUniqueID(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeNode(Object r5) {
        int r10 = this.adaptor.getUniqueID(r5);
        String r11 = this.adaptor.getText(r5);
        int r12 = this.adaptor.getType(r5);
        System.out.println("consumeNode " + r10 + " " + r11 + " " + r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5) {
        int r10 = this.adaptor.getUniqueID(r5);
        String r11 = this.adaptor.getText(r5);
        int r12 = this.adaptor.getType(r5);
        System.out.println("create " + r10 + ": " + r11 + ", " + r12);
    }

    public void enterRule(String r5) {
        System.out.println("enterRule " + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterSubRule(int r5) {
        System.out.println("enterSubRule");
    }

    public void exitRule(String r5) {
        System.out.println("exitRule " + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitSubRule(int r5) {
        System.out.println("exitSubRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void location(int r5, int r10) {
        System.out.println("location " + r5 + ":" + r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void nilNode(Object r5) {
        System.out.println("nilNode " + this.adaptor.getUniqueID(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void setTokenBoundaries(Object r5, int r10, int r11) {
        System.out.println("setTokenBoundaries " + this.adaptor.getUniqueID(r5) + ", " + r10 + ", " + r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5, Token r10) {
        int r11 = this.adaptor.getUniqueID(r5);
        this.adaptor.getText(r5);
        int r12 = r10.getTokenIndex();
        System.out.println("create " + r11 + ": " + r12);
    }
}

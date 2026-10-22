package androidx.room.jarjarred.org.antlr.v4.gui;

import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import javax.print.PrintException;
import javax.swing.JFrame;

/* JADX INFO: loaded from: classes.dex */
public class Trees {
    private Trees() {
    }

    public static String getPS(Tree r5, List<String> r10, String r11, int r12) {
        return new TreePostScriptGenerator(r10, r5, r11, r12).getPS();
    }

    public static Future<JFrame> inspect(Tree r5, List<String> r10) {
        return new TreeViewer(r10, r5).open();
    }

    public static void save(Tree r5, Parser r10, String r11) throws IOException, PrintException {
        if (r10 == null) goto L4;
        List r12 = Arrays.asList(r10.getRuleNames());
    L5:
        save(r5, r12, r11);
        return;
    L4:
        r12 = null;
        goto L5
    }

    public static String toStringTree(Tree r5, TreeTextProvider r10) {
        if (r5 != null) goto L5;
        return "null";
    L5:
        int r11 = 0;
        String r12 = Utils.escapeWhitespace(r10.getText(r5), false);
        if (r5.getChildCount() != 0) goto L8;
        return r12;
    L8:
        StringBuilder r13 = new StringBuilder("(");
        r13.append(Utils.escapeWhitespace(r10.getText(r5), false));
        r13.append(' ');
    L10:
        if (r11 >= r5.getChildCount()) goto L14;
        if (r11 <= 0) goto L13;
        r13.append(' ');
    L13:
        r13.append(toStringTree(r5.getChild(r11), r10));
        r11 = r11 + 1;
        goto L10
    L14:
        r13.append(")");
        return r13.toString();
    }

    public static void writePS(Tree r5, List<String> r10, String r11, String r12, int r13) throws IOException {
        String r14 = getPS(r5, r10, r12, r13);
        BufferedWriter r15 = new BufferedWriter(new FileWriter(r11));
        r15.write(r14);     // Catch: Throwable -> L6
        r15.close();
        return;
    L6:
        th = move-exception;
        r15.close();
        throw th;
    }

    public static String getPS(Tree r5, List<String> r10) {
        return getPS(r5, r10, "Helvetica", 11);
    }

    public static Future<JFrame> inspect(Tree r5, Parser r10) {
        if (r10 == null) goto L4;
        List r11 = Arrays.asList(r10.getRuleNames());
    L6:
        return inspect(r5, r11);
    L4:
        r11 = null;
        goto L6
    }

    public static void save(Tree r5, Parser r10, String r11, String r12, int r13) throws IOException {
        if (r10 == null) goto L4;
        List r14 = Arrays.asList(r10.getRuleNames());
    L5:
        save(r5, r14, r11, r12, r13);
        return;
    L4:
        r14 = null;
        goto L5
    }

    public static void save(Tree r5, List<String> r10, String r11) throws IOException, PrintException {
        writePS(r5, r10, r11);
    }

    public static void save(Tree r5, List<String> r10, String r11, String r12, int r13) throws IOException {
        writePS(r5, r10, r11, r12, r13);
    }

    public static void writePS(Tree r5, List<String> r10, String r11) throws IOException {
        writePS(r5, r10, r11, "Helvetica", 11);
    }
}

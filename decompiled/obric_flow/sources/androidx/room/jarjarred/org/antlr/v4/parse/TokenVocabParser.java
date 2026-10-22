package androidx.room.jarjarred.org.antlr.v4.parse;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class TokenVocabParser {
    protected final Grammar g;

    public TokenVocabParser(Grammar r5) {
        this.g = r5;
    }

    public File getImportedVocabFile() {
        String r5 = this.g.getOptionString("tokenVocab");
        File r10 = new File(this.g.tool.libDirectory, a.t(new StringBuilder(), File.separator, r5, CodeGenerator.VOCAB_FILE_EXTENSION));
        if (r10.exists() == false) goto L5;
        return r10;
    L5:
        File r11 = new File(this.g.tool.outputDirectory, j0.j(r5, CodeGenerator.VOCAB_FILE_EXTENSION));
        if (r11.exists() == false) goto L8;
        return r11;
    L8:
        String r12 = this.g.fileName;
        char r13 = File.separatorChar;
        if (r12.lastIndexOf(r13) != (-1)) goto L11;
        String r14 = ".";
    L13:
        return new File(r14, j0.j(r5, CodeGenerator.VOCAB_FILE_EXTENSION));
    L11:
        String r15 = this.g.fileName;
        r14 = r15.substring(0, r15.lastIndexOf(r13));
        goto L13
    }

    public Map<String, Integer> load() {
        LinkedHashMap r5 = new LinkedHashMap();
        File r10 = getImportedVocabFile();
        Grammar r11 = this.g;
        Tool r12 = r11.tool;
        String r13 = r11.getOptionString("tokenVocab");
        BufferedReader r14 = null;
        Pattern r15 = Pattern.compile("([^\n]+?)[ \\t]*?=[ \\t]*?([0-9]+)");     // Catch: Throwable -> L6 Exception -> L8 FileNotFoundException -> L58
        FileInputStream r16 = new FileInputStream(r10);     // Catch: Throwable -> L6 Exception -> L8 FileNotFoundException -> L58
        if (r12.grammarEncoding == null) goto L10;
        InputStreamReader r17 = new InputStreamReader(r16, r12.grammarEncoding);     // Catch: Throwable -> L6 Exception -> L8 FileNotFoundException -> L58
    L11:
        BufferedReader r18 = new BufferedReader(r17);     // Catch: Throwable -> L6 Exception -> L8 FileNotFoundException -> L58
        goto L42
    L71:
        String r19 = r18.readLine();     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        int r20 = 1;
        int r110 = -1;
        int r111 = 1;
    L13:
        if (r19 == null) goto L61;
        Matcher r112 = r15.matcher(r19);     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
    L16:
        if (r112.find() == false) goto L27;
        String r21 = r112.group(r20);     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        String r113 = r112.group(2);     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        int r114 = Integer.valueOf(r113).intValue();     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24 NumberFormatException -> L25
    L26:
        r12.log("grammar", "import " + r21 + "=" + r114);     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        r5.put(r21, Integer.valueOf(r114));     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        r111 = r111 + 1;     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        r110 = Math.max(r110, r114);     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
    L30:
        r19 = r18.readLine();     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        r15 = r15;
        r20 = 1;
    L25:
        r12.errMgr.toolError(ErrorType.TOKENS_FILE_SYNTAX_ERROR, new Object[]{r13 + CodeGenerator.VOCAB_FILE_EXTENSION, " bad token type: " + r113, Integer.valueOf(r111)});     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        r114 = 0;
        goto L26
    L27:
        r15 = r15;
        if (r19.length() <= 0) goto L30;
        r12.errMgr.toolError(ErrorType.TOKENS_FILE_SYNTAX_ERROR, new Object[]{r13 + CodeGenerator.VOCAB_FILE_EXTENSION, " bad token def: " + r19, Integer.valueOf(r111)});     // Catch: Throwable -> L20 Exception -> L22 FileNotFoundException -> L24
        goto L30
    L61:
        r18.close();     // Catch: IOException -> L34
    L51:
        return r5;
    L34:
        e = move-exception;
        r12.errMgr.toolError(ErrorType.ERROR_READING_TOKENS_FILE, e, new Object[]{r10, e.getMessage()});
    L24:
        r14 = r18;
    L22:
        e = e;
        r14 = r18;
    L36:
        r12.errMgr.toolError(ErrorType.ERROR_READING_TOKENS_FILE, e, new Object[]{r10, e.getMessage()});     // Catch: Throwable -> L6
        if (r14 == null) goto L51;
        r14.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        r12.errMgr.toolError(ErrorType.ERROR_READING_TOKENS_FILE, e, new Object[]{r10, e.getMessage()});
    L20:
        th = move-exception;
        Throwable r22 = th;
        r14 = r18;
    L52:
        if (r14 == null) goto L73;
        r14.close();     // Catch: IOException -> L55
        throw r22;
    L55:
        e = move-exception;
        r12.errMgr.toolError(ErrorType.ERROR_READING_TOKENS_FILE, e, new Object[]{r10, e.getMessage()});
        throw r22;
    L73:
        throw r22;
    L10:
        r17 = new InputStreamReader(r16);     // Catch: Throwable -> L6 Exception -> L8 FileNotFoundException -> L58
    L6:
        th = move-exception;
        r22 = th;
    L8:
        e = e;
    L42:
        GrammarAST r23 = this.g.ast.getOptionAST("tokenVocab");     // Catch: Throwable -> L6
        if (r13.equals(r23.getToken().getText()) == false) goto L45;
        r12.errMgr.grammarError(ErrorType.CANNOT_FIND_TOKENS_FILE_REFD_IN_GRAMMAR, this.g.fileName, r23.getToken(), new Object[]{r10});     // Catch: Throwable -> L6
    L46:
        if (r14 == null) goto L51;
        r14.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        r12.errMgr.toolError(ErrorType.ERROR_READING_TOKENS_FILE, e, new Object[]{r10, e.getMessage()});
        goto L51
    L45:
        r12.errMgr.toolError(ErrorType.CANNOT_FIND_TOKENS_FILE_GIVEN_ON_CMDLINE, new Object[]{r10, this.g.name});     // Catch: Throwable -> L6
        goto L46
    }
}

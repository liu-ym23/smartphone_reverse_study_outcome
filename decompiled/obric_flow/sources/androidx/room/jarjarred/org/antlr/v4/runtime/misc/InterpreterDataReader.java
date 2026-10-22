package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InterpreterDataReader {

    public static class InterpreterData {
        ATN atn;
        List<String> channels;
        List<String> modes;
        List<String> ruleNames;
        Vocabulary vocabulary;

        public InterpreterData() {
        }
    }

    public InterpreterDataReader() {
    }

    public static InterpreterData parseFile(String r10) {
        InterpreterData r5 = new InterpreterData();
        r5.ruleNames = new ArrayList();
        BufferedReader r11 = new BufferedReader(new FileReader(r10));     // Catch: IOException -> L90
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L17
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L17
        if (r11.readLine().equals("token literal names:") == false) goto L81;
    L7:
        String r14 = r11.readLine();     // Catch: Throwable -> L17
        if (r14 == null) goto L20;
        if (r14.isEmpty() == true) goto L20;
        if (r14.equals("null") == false) goto L16;
        r14 = "";
    L16:
        r12.add(r14);     // Catch: Throwable -> L17
    L20:
        if (r11.readLine().equals("token symbolic names:") == false) goto L79;
    L21:
        String r15 = r11.readLine();     // Catch: Throwable -> L17
        if (r15 == null) goto L30;
        if (r15.isEmpty() == true) goto L30;
        if (r15.equals("null") == false) goto L29;
        r15 = "";
    L29:
        r13.add(r15);     // Catch: Throwable -> L17
    L30:
        r5.vocabulary = new VocabularyImpl((String[]) r12.toArray(new String[0]), (String[]) r13.toArray(new String[0]));     // Catch: Throwable -> L17
        if (r11.readLine().equals("rule names:") == false) goto L77;
    L32:
        String r16 = r11.readLine();     // Catch: Throwable -> L17
        if (r16 == null) goto L39;
        if (r16.isEmpty() == true) goto L39;
        r5.ruleNames.add(r16);     // Catch: Throwable -> L17
    L39:
        if (r16.equals("channel names:") == false) goto L59;
        r5.channels = new ArrayList();     // Catch: Throwable -> L17
    L41:
        String r17 = r11.readLine();     // Catch: Throwable -> L17
        if (r17 == null) goto L48;
        if (r17.isEmpty() == true) goto L48;
        r5.channels.add(r17);     // Catch: Throwable -> L17
    L48:
        if (r11.readLine().equals("mode names:") == false) goto L57;
        r5.modes = new ArrayList();     // Catch: Throwable -> L17
    L50:
        String r18 = r11.readLine();     // Catch: Throwable -> L17
        if (r18 == null) goto L59;
        if (r18.isEmpty() == true) goto L59;
        r5.modes.add(r18);     // Catch: Throwable -> L17
        goto L50
    L57:
        throw new RuntimeException("Unexpected data entry");     // Catch: Throwable -> L17
    L59:
        if (r11.readLine().equals("atn:") == false) goto L75;
        String[] r19 = r11.readLine().split(",");     // Catch: Throwable -> L17
        char[] r20 = new char[r19.length];     // Catch: Throwable -> L17
        int r21 = 0;
    L62:
        if (r21 >= r19.length) goto L71;
        String r22 = r19[r21];     // Catch: Throwable -> L17
        if (r22.startsWith("[") == false) goto L67;
        int r23 = Integer.parseInt(r22.substring(1).trim());     // Catch: Throwable -> L17
    L70:
        r20[r21] = (char) r23;     // Catch: Throwable -> L17
        r21 = r21 + 1;     // Catch: Throwable -> L17
        goto L62
    L67:
        if (r22.endsWith("]") == false) goto L69;
        r23 = Integer.parseInt(r22.substring(0, r22.length() - 1).trim());     // Catch: Throwable -> L17
        goto L70
    L69:
        r23 = Integer.parseInt(r22.trim());     // Catch: Throwable -> L17
        goto L70
    L71:
        r5.atn = new ATNDeserializer().deserialize(r20);     // Catch: Throwable -> L17
        r11.close();     // Catch: IOException -> L90
        goto L89
    L75:
        throw new RuntimeException("Unexpected data entry");     // Catch: Throwable -> L17
    L77:
        throw new RuntimeException("Unexpected data entry");     // Catch: Throwable -> L17
    L79:
        throw new RuntimeException("Unexpected data entry");     // Catch: Throwable -> L17
    L81:
        throw new RuntimeException("Unexpected data entry");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L86
    L88:
        throw th;     // Catch: IOException -> L90
    L86:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L90
    L89:
        return r5;
    }
}

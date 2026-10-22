package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Misc {
    public static final String newline = null;

    static {
        newline = System.getProperty("line.separator");
    }

    public Misc() {
    }

    public static String getFileName(String r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new File(r5).getName();
    }

    public static String getFileNameNoSuffix(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r10 = getFileName(r5);
        return r10.substring(0, r10.lastIndexOf(46));
    }

    public static Coordinate getLineCharPosition(String r10, int r11) {
        int r5 = 1;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L10;
        if (r10.charAt(r12) != '\n') goto L7;
        r5 = r5 + 1;
        r13 = 0;
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        r13 = r13 + 1;
        goto L8
    L10:
        return new Coordinate(r5, r13);
    }

    public static String getParent(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.lastIndexOf(47);
        if (r10 > 0) goto L8;
        if (r10 != 0) goto L12;
        return "/";
    L12:
        return "";
    L8:
        return r5.substring(0, r10);
    }

    public static String getPrefix(String r5) {
        if (r5 != null) goto L5;
        return "/";
    L5:
        String r10 = getParent(r5);
        if (r10.endsWith("/") == false) goto L8;
        return r10;
    L8:
        return r10.concat("/");
    }

    public static String join(Iterator<?> r5, String r10) {
        StringBuilder r11 = new StringBuilder();
    L4:
        if (r5.hasNext() == false) goto L9;
        r11.append(r5.next());
        if (r5.hasNext() == false) goto L4;
        r11.append(r10);
        goto L4
    L9:
        return r11.toString();
    }

    public static boolean referenceEquals(Object r5, Object r10) {
        if (r5 != r10) goto L4;
        return true;
    L4:
        return false;
    }

    public static String replaceEscapedRightAngle(String r10) {
        StringBuilder r5 = new StringBuilder();
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L25;
        char r12 = r10.charAt(r11);
        if (r12 != '<') goto L11;
        if (r10.substring(r11).startsWith("<\\\\>") == false) goto L11;
        r5.append("<\\\\>");
        r11 = r11 + 4;
    L11:
        if (r12 != '>') goto L17;
        if (r10.substring(r11).startsWith(">\\>") == false) goto L17;
        r5.append(">>");
    L15:
        r11 = r11 + 3;
    L17:
        if (r12 != '\\') goto L23;
        if (r10.substring(r11).startsWith("\\>>") == false) goto L23;
        if (r10.substring(r11).startsWith("\\>>>") == true) goto L23;
        r5.append(">>");
    L23:
        r5.append(r12);
        r11 = r11 + 1;
        goto L4
    L25:
        return r5.toString();
    }

    public static String replaceEscapes(String r5) {
        return r5.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll(Profiler.DATA_SEP, "\\\\t");
    }

    public static String strip(String r5, int r10) {
        return a.n(r5, r10, r10);
    }

    public static String stripLastPathElement(String r5) {
        int r10 = r5.lastIndexOf(47);
        if (r10 >= 0) goto L6;
        return r5;
    L6:
        return r5.substring(0, r10);
    }

    public static String trimOneStartingNewline(String r5) {
        if (r5.startsWith("\r\n") == false) goto L6;
        return r5.substring(2);
    L6:
        if (r5.startsWith("\n") == true) goto L8;
        return r5;
    L8:
        return r5.substring(1);
    }

    public static String trimOneTrailingNewline(String r5) {
        if (r5.endsWith("\r\n") == false) goto L6;
        return a.n(r5, 2, 0);
    L6:
        if (r5.endsWith("\n") == true) goto L8;
        return r5;
    L8:
        return a.n(r5, 1, 0);
    }

    public static boolean urlExists(URL r5) {
        URLConnection r10 = r5.openConnection();     // Catch: IOException -> L23
        boolean r11 = true;
        if ((r10 instanceof JarURLConnection) == false) goto L26;
        JarURLConnection r12 = (JarURLConnection) r10;     // Catch: IOException -> L23
        URLClassLoader r13 = new URLClassLoader(new URL[]{r12.getJarFileURL()});     // Catch: IOException -> L23
        if (r13.findResource(r12.getEntryName()) != null) goto L10;
        r11 = false;
    L10:
        r13.close();     // Catch: IOException -> L23
        return r11;
    L12:
        th = move-exception;
        r13.close();     // Catch: IOException -> L23
        throw th;     // Catch: IOException -> L23
    L26:
        InputStream r14 = r5.openStream();     // Catch: Throwable -> L21
        if (r14 == null) goto L18;
        r14.close();     // Catch: IOException -> L23
    L18:
        if (r14 != null) goto L20;
        return false;
    L20:
        return true;
    L21:
        th = move-exception;
        throw th;     // Catch: IOException -> L23
    L23:
        return false;
    }
}

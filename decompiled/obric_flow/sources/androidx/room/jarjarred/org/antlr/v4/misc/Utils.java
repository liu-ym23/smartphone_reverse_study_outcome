package androidx.room.jarjarred.org.antlr.v4.misc;

import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static final int INTEGER_POOL_MAX_VALUE = 1000;
    static Integer[] ints;

    public interface Filter<T> {
        boolean select(T r5);
    }

    public interface Func0<TResult> {
        TResult exec();
    }

    public interface Func1<T1, TResult> {
        TResult exec(T1 r5);
    }

    static {
        ints = new Integer[1001];
    }

    public Utils() {
    }

    public static String capitalize(String r5) {
        return Character.toUpperCase(r5.charAt(0)) + r5.substring(1);
    }

    public static String decapitalize(String r5) {
        return Character.toLowerCase(r5.charAt(0)) + r5.substring(1);
    }

    public static <T> T find(List<?> r5, Class<T> r10) {
        Iterator<?> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Object r12 = r11.next();
        if (r10.isInstance(r12) == false) goto L4;
        return r10.cast(r12);
    L9:
        return null;
    }

    public static <T> int indexOf(List<? extends T> r5, Filter<T> r10) {
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L9;
        if (r10.select(r5.get(r11)) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    public static String join(Object[] r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L4:
        if (r12 >= r5.length) goto L9;
        r11.append(r5[r12].toString());
        r12 = r12 + 1;
        if (r12 >= r5.length) goto L4;
        r11.append(r10);
        goto L4
    L9:
        return r11.toString();
    }

    public static <T> int lastIndexOf(List<? extends T> r5, Filter<T> r10) {
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10.select(r5.get(r11)) == true) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    public static <T extends GrammarAST> List<String> nodesToStrings(List<T> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add(r11.next().getText());
        goto L7
    L9:
        return r10;
    }

    public static <From, To> List<To> select(List<From> r5, Func1<From, To> r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<From> r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(r10.exec(r12.next()));
        goto L7
    L9:
        return r11;
    }

    public static void setSize(List<?> r5, int r10) {
        if (r10 >= r5.size()) goto L6;
        r5.subList(r10, r5.size()).clear();
        return;
    L6:
        if (r10 <= r5.size()) goto L10;
        r5.add(null);
        goto L6
    }

    public static String sortLinesInString(String r5) {
        String[] r10 = r5.split("\n");
        Arrays.sort(r10);
        List r11 = Arrays.asList(r10);
        StringBuilder r12 = new StringBuilder();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.append((String) r13.next());
        r12.append('\n');
        goto L4
    L7:
        return r12.toString();
    }

    public static String stripFileExtension(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.lastIndexOf(46);
        if (r10 >= 0) goto L9;
        return r5;
    L9:
        return r5.substring(0, r10);
    }
}

package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static boolean matches(@Nullable String r5, @NonNull String r10) {
        if (r5 != null) goto L6;
        return false;
    L6:
        return mimeTypeAgainstFilter(r5.split("/"), r10.split("/"));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] r10, @NonNull String r11) {
        int r5 = 0;
        if (r10 == null) goto L5;
        ArrayList r12 = new ArrayList();
        String[] r13 = r11.split("/");
        int r14 = r10.length;
    L7:
        if (r5 >= r14) goto L13;
        String r15 = r10[r5];
        if (mimeTypeAgainstFilter(r15.split("/"), r13) == false) goto L11;
        r12.add(r15);
    L11:
        r5 = r5 + 1;
        goto L7
    L13:
        return (String[]) r12.toArray(new String[r12.size()]);
    L5:
        return new String[0];
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] r5, @NonNull String[] r10) {
        if (r10.length != 2) goto L25;
        if (r10[0].isEmpty() == true) goto L23;
        if (r10[1].isEmpty() == true) goto L23;
        if (r5.length == 2) goto L12;
        return false;
    L12:
        if (XPath.WILDCARD.equals(r10[0]) == true) goto L17;
        if (r10[0].equals(r5[0]) == true) goto L17;
        return false;
    L17:
        if (XPath.WILDCARD.equals(r10[1]) == false) goto L19;
    L21:
        return true;
    L19:
        if (r10[1].equals(r5[1]) == true) goto L21;
        return false;
    L23:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    L25:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }

    @Nullable
    public static String matches(@Nullable String r10, @NonNull String[] r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r12 = r10.split("/");
        int r5 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r5) goto L11;
        String r14 = r11[r13];
        if (mimeTypeAgainstFilter(r12, r14.split("/")) == true) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L11:
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] r10, @NonNull String r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r12 = r11.split("/");
        int r5 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r5) goto L11;
        String r14 = r10[r13];
        if (mimeTypeAgainstFilter(r14.split("/"), r12) == true) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L11:
        return null;
    }
}

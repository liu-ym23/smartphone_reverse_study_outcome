package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    @Nullable
    public static String matches(@Nullable String r10, @NonNull String[] r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r12 = r10.split("/");
        int r13 = r11.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r11[r14];
        if (mimeTypeAgainstFilter(r12, r15.split("/")) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return r15;
    L11:
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] r10, @NonNull String r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r12 = r11.split("/");
        int r13 = r10.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = r10[r14];
        if (mimeTypeAgainstFilter(r15.split("/"), r12) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return r15;
    L11:
        return null;
    }

    public static boolean matches(@Nullable String r10, @NonNull String r11) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return mimeTypeAgainstFilter(r10.split("/"), r11.split("/"));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] r10, @NonNull String r11) {
        int r12 = 0;
        if (r10 == null) goto L5;
        ArrayList r13 = new ArrayList();
        String[] r14 = r11.split("/");
        int r15 = r10.length;
    L7:
        if (r12 >= r15) goto L13;
        String r16 = r10[r12];
        if (mimeTypeAgainstFilter(r16.split("/"), r14) == false) goto L11;
        r13.add(r16);
    L11:
        r12 = r12 + 1;
        goto L7
    L13:
        return (String[]) r13.toArray(new String[r13.size()]);
    L5:
        return new String[0];
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] r10, @NonNull String[] r11) {
        if (r11.length != 2) goto L25;
        if (r11[0].isEmpty() == true) goto L23;
        if (r11[1].isEmpty() == true) goto L23;
        if (r10.length == 2) goto L12;
        return false;
    L12:
        if ("*".equals(r11[0]) == true) goto L17;
        if (r11[0].equals(r10[0]) == true) goto L17;
        return false;
    L17:
        if ("*".equals(r11[1]) == false) goto L19;
    L21:
        return true;
    L19:
        if (r11[1].equals(r10[1]) == true) goto L21;
        return false;
    L23:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
    L25:
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }
}

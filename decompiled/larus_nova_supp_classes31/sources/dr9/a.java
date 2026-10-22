package dr9;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(ResourceRef r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getKind() == ResourceRefKind.LOCAL_URI) goto L6;
        return null;
    L6:
        if (StringsKt.startsWith$default(r5.getUri(), "/", false, 2, null) == false) goto L9;
        return r5.getUri();
    L9:
        if (StringsKt.equals(UriProtector.parse(r5.getUri()).getScheme(), "file", true) == true) goto L11;
        return null;
    L11:
        return UriProtector.parse(r5.getUri()).getPath();
    }

    public static final ResourceRef b(String r8, String r9, int r10, int r11) {
        if (r8 != null) goto L5;
    L44:
        if (r9 != null) goto L46;
        return null;
    L46:
        if ((!StringsKt.isBlank(r9)) == false) goto L48;
        String r4 = r9;
    L49:
        if (r4 != null) goto L51;
        return null;
    L51:
        return new ResourceRef(r4, ResourceRefKind.REMOTE_KEY, r4, r10, r11);
    L48:
        r4 = null;
        goto L49
    L5:
        if ((!StringsKt.isBlank(r8)) == false) goto L7;
        String r3 = r8;
    L8:
        if (r3 == null) goto L44;
        if (StringsKt.startsWith$default(r3, "/", false, 2, null) == false) goto L14;
        ResourceRefKind r12 = ResourceRefKind.LOCAL_URI;
    L13:
        ResourceRefKind r5 = r12;
        if (r9 != null) goto L38;
    L40:
        String r6 = null;
    L42:
        return new ResourceRef(r3, r5, r6, r10, r11);
    L38:
        if ((!StringsKt.isBlank(r9)) == false) goto L40;
        r6 = r9;
        goto L42
    L14:
        String r13 = UriProtector.parse(r3).getScheme();
        if (r13 == null) goto L17;
        String r14 = r13.toLowerCase(Locale.ROOT);
    L18:
        if (r14 != null) goto L20;
    L43:
        return null;
    L20:
        switch(r14.hashCode()) {
            case 3143036: goto L33;
            case 3213448: goto L29;
            case 99617003: goto L26;
            case 951530617: goto L23;
            default: goto L43;
        };
    L23:
        if (r14.equals("content") == false) goto L43;
    L35:
        r12 = ResourceRefKind.LOCAL_URI;
        goto L13
    L26:
        if (r14.equals("https") == false) goto L43;
    L31:
        r12 = ResourceRefKind.REMOTE_URL;
        goto L13
    L29:
        if (r14.equals("http") == true) goto L31;
    L33:
        if (r14.equals("file") == true) goto L35;
    L17:
        r14 = null;
        goto L18
    L7:
        r3 = null;
        goto L8
    }

    public static /* synthetic */ ResourceRef c(String r2, int r3, int r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 0;
    L9:
        return b(r2, null, r3, r4);
    }
}

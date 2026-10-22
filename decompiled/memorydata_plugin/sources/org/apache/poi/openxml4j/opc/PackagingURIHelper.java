package org.apache.poi.openxml4j.opc;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* JADX INFO: loaded from: classes7.dex */
public final class PackagingURIHelper {
    public static final PackagePartName CORE_PROPERTIES_PART_NAME = null;
    public static final URI CORE_PROPERTIES_URI = null;
    private static final c LOG = null;
    public static final PackagePartName PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = null;
    public static final URI PACKAGE_RELATIONSHIPS_ROOT_URI = null;
    public static final PackagePartName PACKAGE_ROOT_PART_NAME = null;
    public static final URI PACKAGE_ROOT_URI = null;
    private static final char[] hexDigits = null;
    private static final Pattern missingAuthPattern = null;
    private static URI packageRootUri;

    static {
        LOG = b.a(PackagingURIHelper.class);
        PackagePartName r1 = null;
        URI r2 = new URI("/");     // Catch: URISyntaxException -> L8
        URI r3 = new URI("/_rels/.rels");     // Catch: URISyntaxException -> L7
        packageRootUri = new URI("/");     // Catch: URISyntaxException -> L20
        URI r0 = new URI("/docProps/core.xml");     // Catch: URISyntaxException -> L20
    L10:
        PACKAGE_ROOT_URI = r2;
        PACKAGE_RELATIONSHIPS_ROOT_URI = r3;
        CORE_PROPERTIES_URI = r0;
        PackagePartName r4 = createPartName(r3);     // Catch: InvalidFormatException -> L16
        PackagePartName r5 = createPartName(r0);     // Catch: InvalidFormatException -> L15
        r1 = new PackagePartName(r2, false);     // Catch: InvalidFormatException -> L19
    L17:
        PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = r4;
        CORE_PROPERTIES_PART_NAME = r5;
        PACKAGE_ROOT_PART_NAME = r1;
        missingAuthPattern = Pattern.compile("\\w+://");
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return;
    L15:
        r5 = null;
    L16:
        r5 = null;
        r4 = null;
    L9:
        r0 = null;
    L7:
        r3 = null;
    L8:
        r2 = null;
        r3 = null;
        goto L9
    }

    public PackagingURIHelper() {
    }

    public static String combine(String r2, String r3) {
        if (r2.endsWith("/") == false) goto L5;
    L9:
        boolean r1 = r2.endsWith("/");
        if ((r3.startsWith("/") ^ r1) == false) goto L12;
        StringBuilder r4 = new StringBuilder().append(r2);
    L8:
        return r4.append(r3).toString();
    L12:
        return "";
    L5:
        if (r3.startsWith("/") == true) goto L9;
        r4 = new StringBuilder().append(r2).append('/');
        goto L8
    }

    public static PackagePartName createPartName(String r1) {
        return createPartName(toURI(r1));
    L5:
        e = move-exception;
        throw new InvalidFormatException(e.getMessage());
    }

    public static PackagePartName createPartName(URI r2) {
        if (r2 == null) goto L6;
        return new PackagePartName(r2, true);
    L6:
        throw new IllegalArgumentException("partName");
    }

    public static String encode(String r4) {
        if (r4.length() != 0) goto L5;
        return r4;
    L5:
        ByteBuffer r5 = ByteBuffer.wrap(r4.getBytes(StandardCharsets.UTF_8));
        StringBuilder r0 = new StringBuilder();
    L7:
        if (r5.hasRemaining() == false) goto L14;
        int r1 = r5.get() & 255;
        if (isUnsafe(r1) == false) goto L11;
        r0.append('%');
        char[] r2 = hexDigits;
        r0.append(r2[(r1 >> 4) & 15]);
        char r3 = r2[(r1 >> 0) & 15];
    L12:
        r0.append(r3);
        goto L7
    L11:
        r3 = (char) r1;
        goto L12
    L14:
        return r0.toString();
    }

    public static String getFilename(URI r4) {
        if (r4 == null) goto L10;
        String r5 = r4.getPath();
        int r0 = r5.length();
        int r1 = r0;
    L4:
        r1 = r1 - 1;
        if (r1 < 0) goto L15;
        if (r5.charAt(r1) != '/') goto L4;
        return r5.substring(r1 + 1, r0);
    L15:
        return "";
    L10:
        return "";
    }

    public static String getFilenameWithoutExtension(URI r2) {
        String r3 = getFilename(r2);
        int r0 = r3.lastIndexOf(46);
        if (r0 != (-1)) goto L6;
        return r3;
    L6:
        return r3.substring(0, r0);
    }

    public static PackagePartName getRelationshipPartName(PackagePartName r4) {
        if (r4 == null) goto L17;
        if (PACKAGE_ROOT_URI.getPath().equals(r4.getURI().getPath()) == false) goto L8;
        return PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
    L8:
        if (r4.isRelationshipPartURI() == true) goto L15;
        String r0 = r4.getURI().getPath();
        String r5 = getFilename(r4.getURI());
        return createPartName(combine(combine(r0.substring(0, r0.length() - r5.length()), "_rels"), r5) + ".rels");
    L12:
        return null;
    L15:
        throw new InvalidOperationException("Can't be a relationship part");
    L17:
        throw new IllegalArgumentException("partName");
    }

    public static URI getSourcePartUriFromRelationshipPartUri(URI r3) {
        if (r3 == null) goto L14;
        if (isRelationshipPartURI(r3) == false) goto L12;
        if (r3.compareTo(PACKAGE_RELATIONSHIPS_ROOT_URI) == 0) goto L8;
        String r0 = r3.getPath();
        String r4 = getFilenameWithoutExtension(r3);
        String r1 = r0.substring(0, (r0.length() - r4.length()) - 5);
        return getURIFromPath(combine(r1.substring(0, (r1.length() - 5) - 1), r4));
    L8:
        return PACKAGE_ROOT_URI;
    L12:
        throw new IllegalArgumentException("Must be a relationship part");
    L14:
        throw new IllegalArgumentException("Must not be null");
    }

    public static URI getURIFromPath(String r1) {
        return toURI(r1);
    L5:
        throw new IllegalArgumentException("path");
    }

    public static boolean isRelationshipPartURI(URI r1) {
        if (r1 == null) goto L6;
        return r1.getPath().matches(".*_rels.*.rels$");
    L6:
        throw new IllegalArgumentException("partUri");
    }

    private static boolean isUnsafe(int r1) {
        if (r1 < 128) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 124) goto L10;
        if (Character.isWhitespace(r1) == true) goto L10;
        return false;
    }

    public static URI relativizeURI(URI r12, URI r13, boolean r14) {
        StringBuilder r0 = new StringBuilder();
        String[] r1 = r12.getPath().split("/", -1);
        String[] r3 = r13.getPath().split("/", -1);
        if (r1.length == 0) goto L79;
        if (r3.length == 0) goto L77;
        int r8 = 0;
        if (r12.toString().equals("/") == false) goto L20;
        String r15 = r13.getPath();
        if (r14 == true) goto L11;
        return r13;
    L11:
        if (r15.length() > 0) goto L13;
        return r13;
    L13:
        if (r15.charAt(0) == '/') goto L96;
        return r13;
    L96:
        return new URI(r15.substring(1));
    L20:
        int r16 = 0;
        int r4 = 0;
    L22:
        if (r16 >= r1.length) goto L29;
        if (r16 >= r3.length) goto L29;
        if (r1[r16].equals(r3[r16]) == false) goto L29;
        r4 = r4 + 1;
        r16 = r16 + 1;
    L29:
        if (r4 == 0) goto L32;
        if (r4 == 1) goto L32;
    L51:
        if (r4 == r1.length) goto L53;
    L57:
        if (r4 != 1) goto L59;
        r0.append("/");
    L64:
        if (r4 >= r3.length) goto L71;
        if (r0.length() <= 0) goto L70;
        if (r0.charAt(r0.length() - 1) == '/') goto L70;
        r0.append("/");
    L70:
        r0.append(r3[r4]);
        r4 = r4 + 1;
    L71:
        String r17 = r13.getRawFragment();
        if (r17 == null) goto L75;
        r0.append("#").append(r17);
    L75:
        return new URI(r0.toString());
    L59:
        int r18 = r4;
    L61:
        if (r18 >= (r1.length - 1)) goto L64;
        r0.append("../");
        r18 = r18 + 1;
        goto L61
    L53:
        if (r4 != r3.length) goto L57;
        if (r12.equals(r13) == false) goto L71;
        r0.append(r1[r1.length - 1]);
    L32:
        if (r1[0].isEmpty() == false) goto L51;
        if (r3[0].isEmpty() == false) goto L51;
        int r19 = 0;
    L37:
        if (r19 >= (r1.length - 2)) goto L40;
        r0.append("../");
        r19 = r19 + 1;
    L40:
        if (r8 >= r3.length) goto L49;
        if (r3[r8].isEmpty() == true) goto L47;
        r0.append(r3[r8]);
        if (r8 == (r3.length - 1)) goto L47;
        r0.append("/");
    L47:
        r8 = r8 + 1;
        goto L40
    L49:
        return new URI(r0.toString());
    L16:
        e = move-exception;
        LOG.atWarn().a(e).a("Failed to relativize");
        return null;
    L77:
        throw new IllegalArgumentException("Can't relativize an empty target URI !");
    L79:
        throw new IllegalArgumentException("Can't relativize an empty source URI !");
    }

    public static URI resolvePartUri(URI r2, URI r3) {
        if (r2 == null) goto L13;
        if (r2.isAbsolute() == true) goto L13;
        if (r3 == null) goto L11;
        if (r3.isAbsolute() == true) goto L11;
        return r2.resolve(r3);
    L11:
        throw new IllegalArgumentException("targetUri invalid - " + r3);
    L13:
        throw new IllegalArgumentException("sourcePartUri invalid - " + r2);
    }

    public static URI toURI(String r5) {
        if (r5.contains("\\") == false) goto L5;
        r5 = r5.replace('\\', '/');
    L5:
        int r0 = r5.indexOf(35);
        if (r0 == (-1)) goto L9;
        r5 = r5.substring(0, r0) + "#" + encode(r5.substring(r0 + 1));
    L9:
        if (r5.length() <= 0) goto L21;
        StringBuilder r1 = new StringBuilder();
        int r2 = r5.length() - 1;
    L11:
        if (r2 < 0) goto L18;
        char r3 = r5.charAt(r2);
        if (Character.isWhitespace(r3) == true) goto L16;
        if (r3 != 160) goto L18;
    L16:
        r1.append(r3);
        r2 = r2 - 1;
    L18:
        if (r1.length() <= 0) goto L21;
        r5 = r5.substring(0, r2 + 1) + encode(r1.reverse().toString());
    L21:
        if (missingAuthPattern.matcher(r5).matches() == false) goto L24;
        r5 = r5 + "/";
    L24:
        return new URI(r5);
    }
}

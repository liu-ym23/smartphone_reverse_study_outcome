package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.net.URI;
import java.util.Locale;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;

/* JADX INFO: loaded from: classes7.dex */
public final class PackagePartName implements Comparable<PackagePartName> {
    private final boolean isRelationship;
    private final URI partNameURI;

    PackagePartName(URI r1, boolean r2) {
        if (r2 == false) goto L6;
        throwExceptionIfInvalidPartUri(r1);
    L7:
        this.partNameURI = r1;
        this.isRelationship = isRelationshipPartURI(r1);
        return;
    L6:
        if (PackagingURIHelper.PACKAGE_ROOT_URI.equals(r1) == true) goto L7;
        throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
    }

    private static void checkPCharCompliance(String r7) {
        int r0 = r7.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L39;
        char r2 = r7.charAt(r1);
        if (isDigitOrLetter(r2) == true) goto L38;
        if ("-._~".indexOf(r2) > (-1)) goto L38;
        if (":@".indexOf(r2) > (-1)) goto L38;
        if ("!$&'()*+,;=".indexOf(r2) > (-1)) goto L38;
        if (r2 != '%') goto L37;
        if ((r0 - r1) < 2) goto L35;
        int r3 = r1 + 1;
        if (isHexDigit(r7.charAt(r3)) == false) goto L35;
        int r4 = r1 + 2;
        if (isHexDigit(r7.charAt(r4)) == false) goto L35;
        char r5 = (char) Integer.parseInt(r7.substring(r3, r1 + 3), 16);
        if (r5 == '/') goto L33;
        if (r5 == '\\') goto L33;
        if (isDigitOrLetter(r5) == true) goto L31;
        if ("-._~".indexOf(r5) > (-1)) goto L31;
        r1 = r4;
    L31:
        throw new InvalidFormatException("A segment shall not contain percent-encoded unreserved characters. [M1.8]");
    L33:
        throw new InvalidFormatException("A segment shall not contain percent-encoded forward slash ('/'), or backward slash ('\\') characters. [M1.7]");
    L35:
        throw new InvalidFormatException("The segment " + r7 + " contain invalid encoded character !");
    L37:
        throw new InvalidFormatException("A segment shall not hold any characters other than pchar characters. [M1.6]");
    L38:
        r1 = r1 + 1;
        goto L3
    }

    public static int compare(String r7, String r8) {
        int r0 = 0;
        if (r7 != null) goto L8;
        if (r8 == null) goto L50;
        return -1;
    L50:
        return 0;
    L8:
        if (r8 != null) goto L12;
        return 1;
    L12:
        if (r7.equalsIgnoreCase(r8) == false) goto L14;
        return 0;
    L14:
        String r9 = r7.toLowerCase(Locale.ROOT);
        String r10 = r8.toLowerCase(Locale.ROOT);
        int r1 = r9.length();
        int r2 = r10.length();
        int r3 = 0;
    L15:
        if (r0 >= r1) goto L39;
        if (r3 >= r2) goto L39;
        int r4 = r0 + 1;
        char r5 = r9.charAt(r0);
        int r6 = r3 + 1;
        char r11 = r10.charAt(r3);
        if (Character.isDigit(r5) == true) goto L20;
    L34:
        if (r5 == r11) goto L37;
        return r5 - r11;
    L37:
        r0 = r4;
        r3 = r6;
        goto L15
    L20:
        if (Character.isDigit(r11) == false) goto L34;
        int r12 = r4 - 1;
    L22:
        if (r4 >= r1) goto L26;
        if (Character.isDigit(r9.charAt(r4)) == false) goto L26;
        r4 = r4 + 1;
    L26:
        int r13 = r6 - 1;
    L27:
        if (r6 >= r2) goto L31;
        if (Character.isDigit(r10.charAt(r6)) == false) goto L31;
        r6 = r6 + 1;
    L31:
        int r14 = new BigInteger(r9.substring(r12, r4)).compareTo(new BigInteger(r10.substring(r13, r6)));
        if (r14 == 0) goto L37;
        return r14;
    L39:
        return r1 - r2;
    }

    public static int compare(PackagePartName r1, PackagePartName r2) {
        String r0 = null;
        if (r1 != null) goto L5;
        String r3 = null;
    L6:
        if (r2 == null) goto L10;
        r0 = r2.getName();
    L10:
        return compare(r3, r0);
    L5:
        r3 = r1.getName();
        goto L6
    }

    private static boolean isDigitOrLetter(char r1) {
        if (r1 < '0') goto L7;
        if (r1 > '9') goto L7;
    L14:
        return true;
    L7:
        if (r1 < 'A') goto L11;
        if (r1 <= 'Z') goto L14;
    L11:
        if (r1 >= 'a') goto L13;
    L15:
        return false;
    L13:
        if (r1 > 'z') goto L15;
        goto L14
    }

    private static boolean isHexDigit(char r1) {
        if (r1 < '0') goto L7;
        if (r1 > '9') goto L7;
    L14:
        return true;
    L7:
        if (r1 < 'A') goto L11;
        if (r1 <= 'F') goto L14;
    L11:
        if (r1 >= 'a') goto L13;
    L15:
        return false;
    L13:
        if (r1 > 'f') goto L15;
        goto L14
    }

    private boolean isRelationshipPartURI(URI r1) {
        if (r1 == null) goto L6;
        return r1.getPath().matches("^.*/_rels/.*\\.rels$");
    L6:
        throw new IllegalArgumentException("partUri");
    }

    private static void throwExceptionIfAbsoluteUri(URI r3) {
        if (r3.isAbsolute() == true) goto L6;
        return;
    L6:
        throw new InvalidFormatException("Absolute URI forbidden: " + r3);
    }

    private static void throwExceptionIfEmptyURI(URI r3) {
        if (r3 == null) goto L13;
        String r0 = r3.getPath();
        if (r0.length() == 0) goto L11;
        if (r0.length() == 1) goto L8;
        return;
    L8:
        if (r0.charAt(0) == '/') goto L11;
        return;
    L11:
        throw new InvalidFormatException("A part name shall not be empty [M1.1]: " + r3.getPath());
    L13:
        throw new IllegalArgumentException("partURI");
    }

    private static void throwExceptionIfInvalidPartUri(URI r1) {
        if (r1 == null) goto L6;
        throwExceptionIfEmptyURI(r1);
        throwExceptionIfAbsoluteUri(r1);
        throwExceptionIfPartNameNotStartsWithForwardSlashChar(r1);
        throwExceptionIfPartNameEndsWithForwardSlashChar(r1);
        throwExceptionIfPartNameHaveInvalidSegments(r1);
        return;
    L6:
        throw new IllegalArgumentException("partUri");
    }

    private static void throwExceptionIfPartNameEndsWithForwardSlashChar(URI r3) {
        String r0 = r3.getPath();
        if (r0.length() > 0) goto L5;
        return;
    L5:
        if (r0.charAt(r0.length() - 1) == '/') goto L8;
        return;
    L8:
        throw new InvalidFormatException("A part name shall not have a forward slash as the last character [M1.5]: " + r3.getPath());
    }

    private static void throwExceptionIfPartNameHaveInvalidSegments(URI r7) {
        if (r7 == null) goto L26;
        String[] r0 = r7.toASCIIString().replaceFirst("^/", "").split("/");
        if (r0.length < 1) goto L24;
        int r1 = r0.length;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L22;
        String r5 = r0[r4];
        if (r5 == null) goto L21;
        if (r5.isEmpty() == true) goto L21;
        if (r5.endsWith(".") == true) goto L19;
        if (r5.replaceAll("\\\\.", "").isEmpty() == true) goto L17;
        checkPCharCompliance(r5);
        r4 = r4 + 1;
        goto L6
    L17:
        throw new InvalidFormatException("A segment shall include at least one non-dot character. [M1.10]: " + r7.getPath());
    L19:
        throw new InvalidFormatException("A segment shall not end with a dot ('.') character [M1.9]: " + r7.getPath());
    L21:
        throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + r7.getPath());
    L22:
        return;
    L24:
        throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + r7.getPath());
    L26:
        throw new IllegalArgumentException("partUri");
    }

    private static void throwExceptionIfPartNameNotStartsWithForwardSlashChar(URI r3) {
        String r0 = r3.getPath();
        if (r0.length() > 0) goto L5;
        return;
    L5:
        if (r0.charAt(0) != '/') goto L8;
        return;
    L8:
        throw new InvalidFormatException("A part name shall start with a forward slash ('/') character [M1.4]: " + r3.getPath());
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(PackagePartName r3) {
        return compareTo2((PackagePartName) ZeusTransformUtils.preCheckCast(r3, PackagePartName.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PackagePartName r1) {
        return compare(this, r1);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, PackagePartName.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (compare(getName(), ((PackagePartName) ZeusTransformUtils.preCheckCast(r3, PackagePartName.class, "com.obric.memorydata.plugin")).getName()) != 0) goto L7;
        return true;
    }

    public String getExtension() {
        String r2 = this.partNameURI.getPath();
        if (r2.length() <= 0) goto L8;
        int r0 = r2.lastIndexOf(46);
        if (r0 > (-1)) goto L7;
        return "";
    L7:
        return r2.substring(r0 + 1);
    L8:
        return "";
    }

    public String getName() {
        return getURI().toASCIIString();
    }

    public URI getURI() {
        return this.partNameURI;
    }

    public int hashCode() {
        return getName().toLowerCase(Locale.ROOT).hashCode();
    }

    public boolean isRelationshipPartURI() {
        return this.isRelationship;
    }

    public String toString() {
        return getName();
    }
}

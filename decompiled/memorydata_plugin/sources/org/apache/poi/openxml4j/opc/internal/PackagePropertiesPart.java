package org.apache.poi.openxml4j.opc.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PackagePropertiesPart extends PackagePart implements PackageProperties {
    private static final String[] DATE_FORMATS = null;
    private final Pattern TIME_ZONE_PAT;
    private final String[] TZ_DATE_FORMATS;
    protected Optional<String> category;
    protected Optional<String> contentStatus;
    protected Optional<String> contentType;
    protected Optional<Date> created;
    protected Optional<String> creator;
    protected Optional<String> description;
    protected Optional<String> identifier;
    protected Optional<String> keywords;
    protected Optional<String> language;
    protected Optional<String> lastModifiedBy;
    protected Optional<Date> lastPrinted;
    protected Optional<Date> modified;
    protected Optional<String> revision;
    protected Optional<String> subject;
    protected Optional<String> title;
    protected Optional<String> version;

    static {
        DATE_FORMATS = new String[]{"yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ss.SS'Z'", "yyyy-MM-dd"};
    }

    public PackagePropertiesPart(OPCPackage r3, PackagePartName r4) {
        super(r3, r4, "application/vnd.openxmlformats-package.core-properties+xml");
        this.TZ_DATE_FORMATS = new String[]{"yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.Sz", "yyyy-MM-dd'T'HH:mm:ss.SSz", "yyyy-MM-dd'T'HH:mm:ss.SSSz"};
        this.TIME_ZONE_PAT = Pattern.compile("([-+]\\d\\d):?(\\d\\d)");
        this.category = Optional.empty();
        this.contentStatus = Optional.empty();
        this.contentType = Optional.empty();
        this.created = Optional.empty();
        this.creator = Optional.empty();
        this.description = Optional.empty();
        this.identifier = Optional.empty();
        this.keywords = Optional.empty();
        this.language = Optional.empty();
        this.lastModifiedBy = Optional.empty();
        this.lastPrinted = Optional.empty();
        this.modified = Optional.empty();
        this.revision = Optional.empty();
        this.subject = Optional.empty();
        this.title = Optional.empty();
        this.version = Optional.empty();
    }

    private static String getDateValue(Date r3) {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
        r0.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        return r0.format(r3);
    }

    private static String getDateValue(Optional<Date> r2) {
        return (String) ZeusTransformUtils.preCheckCast(r2.map($$Lambda$PackagePropertiesPart$lE7NtIpBSnLIv6MWTZ3_3mibyOA.INSTANCE).orElse(""), String.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$FXI71IL-u7K3v79N2wK7KCwB1D4, reason: not valid java name */
    public static /* synthetic */ Stream m3171lambda$FXI71ILu7K3v79N2wK7KCwB1D4(Object[] r0) {
        return Stream.of(r0);
    }

    public static /* synthetic */ String lambda$lE7NtIpBSnLIv6MWTZ3_3mibyOA(Date r0) {
        return getDateValue(r0);
    }

    private static Date parseDateFormat(String[] r6, String r7) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        SimpleDateFormat r4 = new SimpleDateFormat(r6[r2], Locale.ROOT);
        r4.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        Date r3 = r4.parse(r7, new ParsePosition(0));
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    private Optional<Date> parseDateValue(String r7) {
        if (r7 == null) goto L21;
        if (r7.isEmpty() == true) goto L21;
        Matcher r0 = this.TIME_ZONE_PAT.matcher(r7);
        Date r1 = null;
        if (r0.find() == false) goto L9;
        r1 = parseDateFormat(this.TZ_DATE_FORMATS, r7.substring(0, r0.start()) + r0.group(1) + r0.group(2));
    L9:
        if (r1 == null) goto L11;
    L15:
        if (r1 == null) goto L19;
        return Optional.of(r1);
    L19:
        throw new InvalidFormatException("Date " + r7 + " not well formatted, expected format in: " + ((String) ZeusTransformUtils.preCheckCast(Stream.of(new String[][]{this.TZ_DATE_FORMATS, DATE_FORMATS}).flatMap($$Lambda$PackagePropertiesPart$FXI71ILu7K3v79N2wK7KCwB1D4.INSTANCE).collect(Collectors.joining(", ")), String.class, "com.obric.memorydata.plugin")));
    L11:
        if (r7.endsWith("Z") == false) goto L13;
        String r2 = r7;
    L14:
        r1 = parseDateFormat(DATE_FORMATS, r2);
        goto L15
    L13:
        r2 = r7 + "Z";
    L21:
        return Optional.empty();
    }

    private Optional<String> parseStringValue(String r1) {
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return Optional.of(r1);
    L9:
        return Optional.empty();
    }

    public void flush() {
    }

    public Optional<String> getCategoryProperty() {
        return this.category;
    }

    public Optional<String> getContentStatusProperty() {
        return this.contentStatus;
    }

    public Optional<String> getContentTypeProperty() {
        return this.contentType;
    }

    public Optional<Date> getCreatedProperty() {
        return this.created;
    }

    public String getCreatedPropertyString() {
        return getDateValue(this.created);
    }

    public Optional<String> getCreatorProperty() {
        return this.creator;
    }

    public Optional<String> getDescriptionProperty() {
        return this.description;
    }

    public Optional<String> getIdentifierProperty() {
        return this.identifier;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    public Optional<String> getKeywordsProperty() {
        return this.keywords;
    }

    public Optional<String> getLanguageProperty() {
        return this.language;
    }

    public Optional<String> getLastModifiedByProperty() {
        return this.lastModifiedBy;
    }

    public Optional<Date> getLastPrintedProperty() {
        return this.lastPrinted;
    }

    public String getLastPrintedPropertyString() {
        return getDateValue(this.lastPrinted);
    }

    public Optional<Date> getModifiedProperty() {
        return this.modified;
    }

    public String getModifiedPropertyString() {
        if (this.modified.isPresent() == false) goto L7;
        Optional<Date> r1 = this.modified;
    L6:
        return getDateValue(r1);
    L7:
        r1 = Optional.of(new Date());
        goto L6
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        throw new InvalidOperationException("Can't use output stream to set properties !");
    }

    public Optional<String> getRevisionProperty() {
        return this.revision;
    }

    public Optional<String> getSubjectProperty() {
        return this.subject;
    }

    public Optional<String> getTitleProperty() {
        return this.title;
    }

    public Optional<String> getVersionProperty() {
        return this.version;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream r1) {
        throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
    }

    public void setCategoryProperty(String r1) {
        this.category = parseStringValue(r1);
    }

    public void setContentStatusProperty(String r1) {
        this.contentStatus = parseStringValue(r1);
    }

    public void setContentTypeProperty(String r1) {
        this.contentType = parseStringValue(r1);
    }

    public void setCreatedProperty(String r1) {
        this.created = parseDateValue(r1);
    }

    public void setCreatedProperty(Optional<Date> r1) {
        this.created = r1;
    }

    @Override // org.apache.poi.openxml4j.opc.PackageProperties
    public void setCreatorProperty(String r1) {
        this.creator = parseStringValue(r1);
    }

    public void setDescriptionProperty(String r1) {
        this.description = parseStringValue(r1);
    }

    public void setIdentifierProperty(String r1) {
        this.identifier = parseStringValue(r1);
    }

    public void setKeywordsProperty(String r1) {
        this.keywords = parseStringValue(r1);
    }

    public void setLanguageProperty(String r1) {
        this.language = parseStringValue(r1);
    }

    public void setLastModifiedByProperty(String r1) {
        this.lastModifiedBy = parseStringValue(r1);
    }

    public void setLastPrintedProperty(String r1) {
        this.lastPrinted = parseDateValue(r1);
    }

    public void setModifiedProperty(String r1) {
        this.modified = parseDateValue(r1);
    }

    public void setRevisionProperty(String r1) {
        this.revision = parseStringValue(r1);
    }

    public void setSubjectProperty(String r1) {
        this.subject = parseStringValue(r1);
    }

    public void setTitleProperty(String r1) {
        this.title = parseStringValue(r1);
    }

    public void setVersionProperty(String r1) {
        this.version = parseStringValue(r1);
    }
}

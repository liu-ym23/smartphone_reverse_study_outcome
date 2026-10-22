package org.bouncycastle.i18n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.filter.Filter;

/* JADX INFO: loaded from: classes7.dex */
public class LocalizedMessage {
    protected FilteredArguments arguments;
    protected String encoding;
    protected FilteredArguments extraArgs;
    protected final String id;
    protected ClassLoader loader;
    protected final String resource;

    protected static class FilteredArguments {
        protected int[] argFilterType;
        protected Object[] arguments;
        protected Filter filter;
        protected Object[] filteredArgs;
        protected boolean[] isLocaleSpecific;
        protected Object[] unpackedArgs;

        private Object filter(int r2, Object r3) {
            Filter r1 = this.filter;
            if (r1 == null) goto L17;
            if (r3 != null) goto L6;
            r3 = "null";
        L6:
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L16;
            if (r2 == 2) goto L14;
            return null;
        L14:
            return r1.doFilterUrl(r3.toString());
        L16:
            return r1.doFilter(r3.toString());
        L17:
            return r3;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Object[] getFilteredArgs(Locale r6) {
            Object[] r0 = new Object[this.unpackedArgs.length];
            int r1 = 0;
        L3:
            Object[] r2 = this.unpackedArgs;
            if (r1 >= r2.length) goto L13;
            Object[] r3 = this.filteredArgs;
            if (r3[r1] == null) goto L8;
            Object r4 = r3[r1];
        L12:
            r0[r1] = r4;
            r1 = r1 + 1;
            goto L3
        L8:
            Object r5 = r2[r1];
            if (this.isLocaleSpecific[r1] == false) goto L11;
            String r7 = ((LocaleString) ZeusTransformUtils.preCheckCast(r5, LocaleString.class, "com.obric.memorydata.plugin")).getLocaleString(r6);
            r4 = filter(this.argFilterType[r1], r7);
            goto L12
        L11:
            r4 = filter(this.argFilterType[r1], r5);
            this.filteredArgs[r1] = r4;
            goto L12
        L13:
            return r0;
        }

        public boolean isEmpty() {
            if (this.unpackedArgs.length != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public String addExtraArgs(String r2, Locale r3) {
        if (this.extraArgs == null) goto L11;
        StringBuffer r0 = new StringBuffer(r2);
        Object[] r1 = this.extraArgs.getFilteredArgs(r3);
        int r4 = 0;
    L6:
        if (r4 >= r1.length) goto L9;
        r0.append(r1[r4]);
        r4 = r4 + 1;
        goto L6
    L9:
        return r0.toString();
    L11:
        return r2;
    }

    public String formatWithTimeZone(String r4, Object[] r5, Locale r6, TimeZone r7) {
        MessageFormat r3 = new MessageFormat(" ");
        r3.setLocale(r6);
        r3.applyPattern(r4);
        if (r7.equals(TimeZone.getDefault()) == true) goto L12;
        Format[] r8 = r3.getFormats();
        int r9 = 0;
    L6:
        if (r9 >= r8.length) goto L12;
        if (ZeusTransformUtils.instanceOf(r8[r9], DateFormat.class) == false) goto L10;
        DateFormat r0 = (DateFormat) ZeusTransformUtils.preCheckCast(r8[r9], DateFormat.class, "com.obric.memorydata.plugin");
        r0.setTimeZone(r7);
        r3.setFormat(r9, r0);
    L10:
        r9 = r9 + 1;
    L12:
        return r3.format(r5);
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String r10, Locale r11, TimeZone r12) {
        String r1 = this.id;
        if (r10 == null) goto L5;
        r1 = r1 + "." + r10;
    L5:
        String r6 = r1;
        ClassLoader r13 = this.loader;     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
        if (r13 != null) goto L9;
        ResourceBundle r14 = ResourceBundle.getBundle(this.resource, r11);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L10:
        String r15 = r14.getString(r6);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
        if (this.encoding.equals("ISO-8859-1") == true) goto L14;
        r15 = new String(r15.getBytes("ISO-8859-1"), this.encoding);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L14:
        if (this.arguments.isEmpty() == true) goto L16;
        r15 = formatWithTimeZone(r15, this.arguments.getFilteredArgs(r11), r11, r12);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L16:
        return addExtraArgs(r15, r11);
    L9:
        r14 = ResourceBundle.getBundle(this.resource, r11, r13);     // Catch: UnsupportedEncodingException -> L18 MissingResourceException -> L21
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        String r4 = "Can't find entry " + r6 + " in resource file " + this.resource + ".";
        String r5 = this.resource;
        ClassLoader r16 = this.loader;
        if (r16 == null) goto L24;
        ClassLoader r8 = r16;
    L26:
        throw new MissingEntryException(r4, r5, r6, r11, r8);
    L24:
        r8 = getClassLoader();
        goto L26
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append("Resource: \"").append(this.resource);
        r0.append("\" Id: \"").append(this.id).append("\"");
        r0.append(" Arguments: ").append(this.arguments.getArguments().length).append(" normal");
        FilteredArguments r1 = this.extraArgs;
        if (r1 != null) goto L5;
    L7:
        r0.append(" Encoding: ").append(this.encoding);
        r0.append(" ClassLoader: ").append(this.loader);
        return r0.toString();
    L5:
        if (r1.getArguments().length <= 0) goto L7;
        r0.append(", ").append(this.extraArgs.getArguments().length).append(" extra");
        goto L7
    }
}

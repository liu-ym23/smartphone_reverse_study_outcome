package com.bytedance.frameworks.baselib.network.http.parser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;
import z2.b;

/* JADX INFO: loaded from: classes.dex */
public class MimeType implements Externalizable {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private b parameters;
    private String primaryType;
    private String subType;

    public MimeType() {
        this.primaryType = "application";
        this.subType = "*";
        this.parameters = new b();
    }

    public MimeType(String r10) {
        parse(r10);
    }

    public MimeType(String r10, String r11) {
        if (isValidToken(r10) == false) goto L11;
        Locale r12 = Locale.ENGLISH;
        this.primaryType = r10.toLowerCase(r12);
        if (isValidToken(r11) == false) goto L9;
        this.subType = r11.toLowerCase(r12);
        this.parameters = new b();
        return;
    L9:
        throw new MimeTypeParseException("Sub type is invalid.");
    L11:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    private static boolean isTokenChar(char r10) {
        if (r10 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r10 >= 127) goto L9;
        if (TSPECIALS.indexOf(r10) >= 0) goto L9;
        return true;
    }

    private boolean isValidToken(String r10) {
        int r11 = r10.length();
        if (r11 <= 0) goto L12;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        if (isTokenChar(r10.charAt(r12)) == false) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private void parse(String r10) {
        int r11 = r10.indexOf(47);
        int r12 = r10.indexOf(59);
        if (r11 >= 0) goto L8;
        if (r12 >= 0) goto L8;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L8:
        if (r11 >= 0) goto L14;
        if (r12 < 0) goto L14;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L14:
        if (r11 < 0) goto L17;
        if (r12 >= 0) goto L17;
        String r13 = r10.substring(0, r11).trim();
        Locale r14 = Locale.ENGLISH;
        this.primaryType = r13.toLowerCase(r14);
        this.subType = r10.substring(r11 + 1).trim().toLowerCase(r14);
        this.parameters = new b();
    L20:
        if (isValidToken(this.primaryType) == false) goto L27;
        if (isValidToken(this.subType) == false) goto L25;
        return;
    L25:
        throw new MimeTypeParseException("Sub type is invalid.");
    L27:
        throw new MimeTypeParseException("Primary type is invalid.");
    L17:
        if (r11 >= r12) goto L29;
        String r15 = r10.substring(0, r11).trim();
        Locale r16 = Locale.ENGLISH;
        this.primaryType = r15.toLowerCase(r16);
        this.subType = r10.substring(r11 + 1, r12).trim().toLowerCase(r16);
        this.parameters = new b(r10.substring(r12));
        goto L20
    L29:
        throw new MimeTypeParseException("Unable to find a sub type.");
    }

    public String getBaseType() {
        return this.primaryType + "/" + this.subType;
    }

    public String getParameter(String r10) {
        return this.parameters.a(r10);
    }

    public b getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean match(MimeType r10) {
        if (this.primaryType.equals(r10.getPrimaryType()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.subType.equals("*") == false) goto L7;
    L10:
        return true;
    L7:
        if (r10.getSubType().equals("*") == true) goto L10;
        if (this.subType.equals(r10.getSubType()) == false) goto L11;
        goto L10
    }

    public boolean match(String r10) {
        return match(new MimeType(r10));
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        parse(r10.readUTF());     // Catch: MimeTypeParseException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public void removeParameter(String r10) {
        this.parameters.e(r10);
    }

    public void setParameter(String r10, String r11) {
        this.parameters.f(r10, r11);
    }

    public void setPrimaryType(String r10) {
        if (isValidToken(this.primaryType) == false) goto L7;
        this.primaryType = r10.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    public void setSubType(String r10) {
        if (isValidToken(this.subType) == false) goto L7;
        this.subType = r10.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Sub type is invalid.");
    }

    public String toString() {
        return getBaseType() + this.parameters.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r10) {
        r10.writeUTF(toString());
        r10.flush();
    }
}

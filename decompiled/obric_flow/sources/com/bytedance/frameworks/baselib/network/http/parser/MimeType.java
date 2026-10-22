package com.bytedance.frameworks.baselib.network.http.parser;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Hashtable;
import java.util.Locale;
import y9.a;

/* JADX INFO: loaded from: classes2.dex */
public class MimeType implements Externalizable {
    private a parameters;
    private String primaryType;
    private String subType;

    public MimeType() {
        this.primaryType = "application";
        this.subType = XPath.WILDCARD;
        this.parameters = new a();
    }

    public static boolean a(String r5) {
        int r10 = r5.length();
        if (r10 <= 0) goto L16;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L14;
        char r12 = r5.charAt(r11);
        if (r12 <= ' ') goto L13;
        if (r12 >= 127) goto L13;
        if ("()<>@,;:/[]?=\\\"".indexOf(r12) >= 0) goto L13;
        r11 = r11 + 1;
    L13:
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    public final void b(String r15) {
        int r5 = r15.indexOf(47);
        int r10 = r15.indexOf(59);
        if (r5 >= 0) goto L8;
        if (r10 >= 0) goto L8;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L8:
        if (r5 >= 0) goto L14;
        if (r10 < 0) goto L14;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L14:
        if (r5 < 0) goto L17;
        if (r10 >= 0) goto L17;
        String r11 = r15.substring(0, r5).trim();
        Locale r12 = Locale.ENGLISH;
        this.primaryType = r11.toLowerCase(r12);
        this.subType = r15.substring(r5 + 1).trim().toLowerCase(r12);
        this.parameters = new a();
    L89:
        if (a(this.primaryType) == false) goto L96;
        if (a(this.subType) == false) goto L94;
        return;
    L94:
        throw new MimeTypeParseException("Sub type is invalid.");
    L96:
        throw new MimeTypeParseException("Primary type is invalid.");
    L17:
        if (r5 >= r10) goto L100;
        String r13 = r15.substring(0, r5).trim();
        Locale r14 = Locale.ENGLISH;
        this.primaryType = r13.toLowerCase(r14);
        this.subType = r15.substring(r5 + 1, r10).trim().toLowerCase(r14);
        String r16 = r15.substring(r10);
        a r17 = new a();
        r17.f23240a = new Hashtable();
        if (r16 == null) goto L87;
        int r18 = r16.length();
        if (r18 <= 0) goto L87;
        int r19 = a.b(0, r16);
    L25:
        if (r19 >= r18) goto L86;
        if (r16.charAt(r19) != ';') goto L86;
        int r20 = a.b(r19 + 1, r16);
        if (r20 >= r18) goto L87;
        int r21 = r20;
    L32:
        if (r21 >= r18) goto L36;
        if (a.a(r16.charAt(r21)) == false) goto L36;
        r21 = r21 + 1;
    L36:
        String r22 = r16.substring(r20, r21).toLowerCase(Locale.ENGLISH);
        int r23 = a.b(r21, r16);
        if (r23 >= r18) goto L85;
        if (r16.charAt(r23) != '=') goto L85;
        int r24 = a.b(r23 + 1, r16);
        if (r24 >= r18) goto L83;
        char r25 = r16.charAt(r24);
        if (r25 != '\"') goto L72;
        int r26 = r24 + 1;
        if (r26 >= r18) goto L70;
        int r110 = r26;
    L48:
        if (r110 >= r18) goto L55;
        r25 = r16.charAt(r110);
        if (r25 == '\"') goto L55;
        if (r25 != '\\') goto L54;
        r110 = r110 + 1;
    L54:
        r110 = r110 + 1;
    L55:
        if (r25 != '\"') goto L68;
        String r27 = r16.substring(r26, r110);
        int r28 = r27.length();
        StringBuffer r29 = new StringBuffer();
        r29.ensureCapacity(r28);
        int r30 = 0;
        boolean r111 = false;
    L57:
        if (r30 >= r28) goto L66;
        char r112 = r27.charAt(r30);
        if (r111 == true) goto L62;
        if (r112 == '\\') goto L62;
        r29.append(r112);
    L65:
        r30 = r30 + 1;
    L62:
        if (r111 == false) goto L64;
        r29.append(r112);
        r111 = false;
        goto L65
    L64:
        r111 = true;
        goto L65
    L66:
        String r31 = r29.toString();
        int r113 = r110 + 1;
    L79:
        r17.f23240a.put(r22, r31);
        r19 = a.b(r113, r16);
        goto L25
    L68:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L70:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L72:
        if (a.a(r25) == false) goto L81;
        r113 = r24;
    L74:
        if (r113 >= r18) goto L78;
        if (a.a(r16.charAt(r113)) == false) goto L78;
        r113 = r113 + 1;
    L78:
        r31 = r16.substring(r24, r113);
        goto L79
    L81:
        throw new MimeTypeParseException(j0.g(r24, "Unexpected character encountered at index "));
    L83:
        throw new MimeTypeParseException(j0.C("Couldn't find a value for parameter named ", r22));
    L85:
        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
    L86:
        if (r19 >= r18) goto L87;
        throw new MimeTypeParseException("More characters encountered in input than expected.");
    L87:
        this.parameters = r17;
        goto L89
    L100:
        throw new MimeTypeParseException("Unable to find a sub type.");
    }

    public String getBaseType() {
        return this.primaryType + "/" + this.subType;
    }

    public String getParameter(String r5) {
        a r10 = this.parameters;
        r10.getClass();
        String r11 = r5.trim().toLowerCase(Locale.ENGLISH);
        return (String) r10.f23240a.get(r11);
    }

    public a getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean match(MimeType r5) {
        if (this.primaryType.equals(r5.getPrimaryType()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.subType.equals(XPath.WILDCARD) == false) goto L7;
    L10:
        return true;
    L7:
        if (r5.getSubType().equals(XPath.WILDCARD) == true) goto L10;
        if (this.subType.equals(r5.getSubType()) == false) goto L11;
        goto L10
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r5) throws IOException, ClassNotFoundException {
        b(r5.readUTF());     // Catch: MimeTypeParseException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public void removeParameter(String r5) {
        a r10 = this.parameters;
        r10.getClass();
        String r11 = r5.trim().toLowerCase(Locale.ENGLISH);
        r10.f23240a.remove(r11);
    }

    public void setParameter(String r5, String r10) {
        a r11 = this.parameters;
        r11.getClass();
        String r12 = r5.trim().toLowerCase(Locale.ENGLISH);
        r11.f23240a.put(r12, r10);
    }

    public void setPrimaryType(String r5) throws MimeTypeParseException {
        if (a(this.primaryType) == false) goto L7;
        this.primaryType = r5.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    public void setSubType(String r5) throws MimeTypeParseException {
        if (a(this.subType) == false) goto L7;
        this.subType = r5.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Sub type is invalid.");
    }

    public String toString() {
        return getBaseType() + this.parameters.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r5) throws IOException {
        r5.writeUTF(toString());
        r5.flush();
    }

    public boolean match(String r5) throws MimeTypeParseException {
        return match(new MimeType(r5));
    }

    public MimeType(String r5) throws MimeTypeParseException {
        b(r5);
    }

    public MimeType(String r5, String r10) throws MimeTypeParseException {
        if (a(r5) == false) goto L11;
        Locale r11 = Locale.ENGLISH;
        this.primaryType = r5.toLowerCase(r11);
        if (a(r10) == false) goto L9;
        this.subType = r10.toLowerCase(r11);
        this.parameters = new a();
        return;
    L9:
        throw new MimeTypeParseException("Sub type is invalid.");
    L11:
        throw new MimeTypeParseException("Primary type is invalid.");
    }
}

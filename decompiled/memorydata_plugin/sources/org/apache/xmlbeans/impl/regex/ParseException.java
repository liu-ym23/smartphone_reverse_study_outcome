package org.apache.xmlbeans.impl.regex;

/* JADX INFO: loaded from: classes7.dex */
public class ParseException extends RuntimeException {
    int location;

    public ParseException(String r1, int r2) {
        super(r1);
        this.location = r2;
    }

    public int getLocation() {
        return this.location;
    }
}

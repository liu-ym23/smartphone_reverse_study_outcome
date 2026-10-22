package com.tom_roush.fontbox.g.a;

/* JADX INFO: loaded from: classes6.dex */
public class g extends e {
    public g() {
    }

    @Override // com.tom_roush.fontbox.g.a.e
    public String[] a() {
        return new String[]{System.getProperty("user.home") + "/.fonts", "/usr/local/fonts", "/usr/local/share/fonts", "/usr/share/fonts", "/usr/X11R6/lib/X11/fonts"};
    }
}

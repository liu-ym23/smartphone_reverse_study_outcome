package com.tom_roush.fontbox.g.a;

/* JADX INFO: loaded from: classes6.dex */
public class d extends e {
    public d() {
    }

    @Override // com.tom_roush.fontbox.g.a.e
    public String[] a() {
        return new String[]{System.getProperty("user.home") + "/Library/Fonts/", "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"};
    }
}

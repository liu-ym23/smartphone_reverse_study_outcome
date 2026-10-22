package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends uu8.a {
    public final String d() {
        String r0 = this.a.getString("description_status");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = null;
    L11:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public final String e() {
        String r0 = this.a.getString("visual_style_status");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        r0 = null;
    L11:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public p() {
    }
}

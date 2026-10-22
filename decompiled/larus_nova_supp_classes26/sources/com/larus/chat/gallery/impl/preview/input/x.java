package com.larus.chat.gallery.impl.preview.input;

import android.net.Uri;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x implements zs8.a {
    public final /* synthetic */ Uri a;

    @Override // zs8.a
    public final String Y1() {
        return null;
    }

    @Override // zs8.a
    public final String a() {
        return null;
    }

    @Override // zs8.a
    public final String b() {
        return "picture_detail";
    }

    @Override // zs8.a
    public final String c() {
        return null;
    }

    @Override // zs8.a
    public final String d() {
        return null;
    }

    @Override // zs8.a
    public final String e() {
        return null;
    }

    @Override // zs8.a
    public final String f() {
        return null;
    }

    @Override // zs8.a
    public final String g() {
        return null;
    }

    @Override // zs8.a
    public final String getBotId() {
        return null;
    }

    @Override // zs8.a
    public final String getChatType() {
        return null;
    }

    @Override // zs8.a
    public final String getClickFrom() {
        return "";
    }

    @Override // zs8.a
    public final String getEnterMethod() {
        return "photo_preview_sug";
    }

    @Override // zs8.a
    public final String getTemplateType() {
        return null;
    }

    @Override // zs8.a
    public final String h() {
        return null;
    }

    @Override // zs8.a
    public final String i() {
        return null;
    }

    @Override // zs8.a
    public final String j() {
        return null;
    }

    @Override // zs8.a
    public final String k() {
        return null;
    }

    @Override // zs8.a
    public final boolean l() {
        return false;
    }

    @Override // zs8.a
    public final String m() {
        return null;
    }

    @Override // zs8.a
    public final String n() {
        return null;
    }

    @Override // zs8.a
    public final String p() {
        return null;
    }

    @Override // zs8.a
    public final String o() {
        if (Intrinsics.areEqual(this.a.getScheme(), ShareType.FILE) == false) goto L5;
        return "shoot";
    L5:
        return "album";
    }

    public x(Uri r1) {
        this.a = r1;
    }
}

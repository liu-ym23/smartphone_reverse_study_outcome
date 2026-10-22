package com.larus.bmhome.chat.component.action;

import com.larus.im.bean.message.Image;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s implements zs8.a {
    public final /* synthetic */ SuggestedActionComponent a;
    public final /* synthetic */ Image b;

    public final String a() {
        return null;
    }

    public final String b() {
        return "chat";
    }

    public final String c() {
        return null;
    }

    public final String d() {
        return null;
    }

    public final String e() {
        return null;
    }

    public final String f() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final String getBotId() {
        return null;
    }

    public final String getChatType() {
        return null;
    }

    public final String getClickFrom() {
        return "";
    }

    public final String getEnterMethod() {
        return "input_attachment_sug";
    }

    public final String getTemplateType() {
        return null;
    }

    public final String h() {
        return null;
    }

    public final String i() {
        return null;
    }

    public final String j() {
        return null;
    }

    public final String k() {
        return null;
    }

    public final boolean l() {
        return false;
    }

    public final String m() {
        return null;
    }

    public final String n() {
        return null;
    }

    public final String p() {
        return null;
    }

    public final String Y1() {
        return SuggestedActionComponent.h3(this.a);
    }

    public final String o() {
        String r0 = this.b.localResPath;
        if (r0 == null) goto L10;
        String r1 = r0.toLowerCase(Locale.getDefault());
        if (r1 != null) goto L7;
        return "album";
    L7:
        if (StringsKt.startsWith(StringsKt.substringAfterLast$default(r1, '/', null, 2, null), "camera", true) == true) goto L9;
        return "album";
    L9:
        return "shoot";
    L10:
        return "album";
    }

    public s(SuggestedActionComponent r1, Image r2) {
        this.a = r1;
        this.b = r2;
    }
}

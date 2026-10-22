package com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.i;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import ova.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends fob.a<i> {

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.anchor.tasklink.a$a, reason: collision with other inner class name */
    public static final class C0138a {
    }

    static {
    }

    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r4) {
        Intrinsics.checkNotNullParameter(r4, "property");
        if (TextUtils.isEmpty(r4.getHref()) == false) goto L5;
        return false;
    L5:
        if (URLUtil.isValidUrl(r4.getHref()) == false) goto L31;
        Uri r0 = UriProtector.parse(r4.getHref());
        if (r0.isOpaque() == false) goto L10;
        return false;
    L10:
        Set r2 = UriProtector.getQueryParameterNames(r0);
        if (r4.isCustom() == false) goto L25;
        f.m().getClass();
        if (f.q(r0) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r0.getPath(), "/client/todo/detail") == true) goto L17;
        return false;
    L17:
        if (r2.size() == 2) goto L19;
        return false;
    L19:
        if (r2.contains("suite_entity_num") == true) goto L21;
        return false;
    L21:
        if (r2.contains("guid") == false) goto L30;
        return true;
    L30:
        return false;
    L25:
        return false;
    L31:
        return false;
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r3) {
        Intrinsics.checkNotNullParameter(r3, "property");
        return new i(r3.getHref(), r3.getContent());
    }
}

package com.ss.android.lark.flow.chat.message.system;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageActionType;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.biz.im.api.extension.message.system.c {
    public final SystemMessageActionType a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = SystemMessageActionType.CONTENT_ACTION;
    }

    public SystemMessageActionType getType() {
        return this.a;
    }

    public final com.ss.android.lark.biz.im.api.extension.message.system.b d(com.ss.android.lark.biz.im.api.extension.message.system.a r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(f.class, "handlerApiClass");
        return r3.a().b(f.class);
    }

    public final boolean a(ContentValue r4, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r5) {
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        if (r4 == null) goto L5;
        ContentValueType r0 = r4.getContentValueType();
    L7:
        if (r0 == ContentValueType.ACTION) goto L10;
        return false;
    L10:
        if (((EnumSet) SystemMessageConfig.e.getValue()).contains(r5.a.getType()) == false) goto L12;
        return false;
    L12:
        SystemContent r6 = r5.a;
        if (r6.getVersion() > 0) goto L15;
        return true;
    L15:
        com.ss.android.lark.chat.export.entity.message.content.e r7 = (com.ss.android.lark.chat.export.entity.message.content.e) r6.getItemActions().get(Integer.valueOf(r4.getActionId()));
        if (r7 != null) goto L18;
        return false;
    L18:
        if (r7.a() != true) goto L22;
        return true;
    L22:
        return false;
    L5:
        r0 = null;
        goto L7
    }

    public final String b(ContentValue r2, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        if (r2 == null) goto L6;
        String r4 = r2.getValue();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }

    public final void c(SpannableStringBuilder r1, ContentValue r2, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r3) {
        Intrinsics.checkNotNullParameter(r1, "result");
        Intrinsics.checkNotNullParameter(r3, "systemActionContext");
    }
}

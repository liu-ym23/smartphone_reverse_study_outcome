package com.ss.android.lark.flow.chat.message.system;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageActionType;
import com.ss.android.lark.biz.im.api.extension.message.system.SystemMessageConfig;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import java.util.EnumSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.biz.im.api.extension.message.system.c {
    public final SystemMessageActionType a;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.system.a$a, reason: collision with other inner class name */
    public static final class C0029a {
    }

    static {
    }

    public a() {
        this.a = SystemMessageActionType.CONTENT_ACTION;
    }

    public SystemMessageActionType getType() {
        return this.a;
    }

    public final com.ss.android.lark.biz.im.api.extension.message.system.b d(com.ss.android.lark.biz.im.api.extension.message.system.a r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(e.class, "handlerApiClass");
        return r3.a().b(e.class);
    }

    public final boolean a(ContentValue r4, com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open.c r5) {
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        if (((EnumSet) SystemMessageConfig.d.getValue()).contains(r5.a.getType()) == false) goto L5;
        return false;
    L5:
        ContentValueType r6 = null;
        if (r4 == null) goto L8;
        ContentValueType r1 = r4.getContentValueType();
    L10:
        if (r1 == ContentValueType.USER) goto L20;
        if (r4 == null) goto L13;
        ContentValueType r2 = r4.getContentValueType();
    L15:
        if (r2 == ContentValueType.CHATTER) goto L20;
        if (r4 == null) goto L19;
        r6 = r4.getContentValueType();
    L19:
        if (r6 == ContentValueType.BOT) goto L20;
        return false;
    L13:
        r2 = null;
    L20:
        return true;
    L8:
        r1 = null;
        goto L10
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

package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements Function1<f5b.b, f5b.b> {
    public final Map<Long, UserGroupEntity> a;

    public q(Map<Long, UserGroupEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroups");
        this.a = r2;
    }

    private final void update(f5b.b r8) {
        if (r8 == null) goto L7;
        Message r1 = r8.getMessage();
        if (r1 == null) goto L7;
        Content r2 = r1.getContent();
    L9:
        if ((r2 instanceof BaseTextContent) == false) goto L11;
        BaseTextContent r3 = (BaseTextContent) r2;
    L12:
        if (r3 != null) goto L14;
        return;
    L14:
        RichText r4 = r3.getRichText();
        if (r4 != null) goto L17;
        return;
    L17:
        ArrayList r5 = r4.getAtUserGroupIds();
        boolean r6 = false;
        if (r5 == null) goto L46;
        ArrayList r7 = new ArrayList();
        Iterator r9 = r5.iterator();
    L21:
        if (r9.hasNext() == false) goto L38;
        String r10 = (String) r9.next();
        RichText r11 = r3.getRichText();
        if (r11 == null) goto L31;
        RichText.RichTextElements r12 = r11.getElements();
        if (r12 == null) goto L31;
        Map r13 = r12.getDictionary();
        if (r13 == null) goto L31;
        RichTextElement r14 = (RichTextElement) r13.get(r10);
        if (r14 == null) goto L31;
        RichTextElement.AtUserGroupProperty r15 = (RichTextElement.AtUserGroupProperty) r14.getProperty();
    L33:
        if ((r15 instanceof RichTextElement.AtUserGroupProperty) == true) goto L36;
        r15 = null;
    L36:
        if (r15 == null) goto L21;
        r7.add(r15);
    L31:
        r15 = null;
        goto L33
    L38:
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r16 = r7.iterator();
    L40:
        if (r16.hasNext() == false) goto L46;
        RichTextElement.AtUserGroupProperty r17 = (RichTextElement.AtUserGroupProperty) r16.next();
        UserGroupEntity r18 = this.a.get(Long.valueOf(r17.getUserGroupId()));
        if (r18 == null) goto L45;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Intrinsics.checkNotNullParameter(r17, "property");
        r17.setDisplayName(r18.display_name);
        r17.setPermissionStatus(r18.status.intValue());
        r6 = true;
    L45:
        r0.add(Unit.INSTANCE);
    L46:
        r8.setForceUpdate(r6);
        return;
    L11:
        r3 = null;
    L7:
        r2 = null;
        goto L9
    }

    public final Object invoke(Object r1) {
        f5b.b r2 = (f5b.b) r1;
        update(r2);
        return r2;
    }
}

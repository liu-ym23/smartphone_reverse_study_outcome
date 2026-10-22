package k4b;

import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Function1<f5b.b, Boolean> {
    public final Map<Long, UserGroupEntity> a;

    public f(Map<Long, UserGroupEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "userGroups");
        this.a = r2;
    }

    public final Object invoke(Object r6) {
        f5b.b r7 = (f5b.b) r6;
        Intrinsics.checkNotNullParameter(r7, "chatMessage");
        Message r8 = r7.getMessage();
        if (r8.getType() != Message.Type.TEXT) goto L5;
    L7:
        Content r9 = r8.getContent();
        if ((r9 instanceof BaseTextContent) == false) goto L10;
        BaseTextContent r10 = (BaseTextContent) r9;
    L11:
        if (r10 == null) goto L57;
        RichText r0 = r10.getRichText();
        if (r0 == null) goto L45;
        ArrayList r1 = r0.getAtUserGroupIds();
        if (r1 == null) goto L45;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L19:
        if (r3.hasNext() == false) goto L37;
        String r4 = (String) r3.next();
        RichText r5 = r10.getRichText();
        if (r5 == null) goto L29;
        RichText.RichTextElements r11 = r5.getElements();
        if (r11 == null) goto L29;
        Map r12 = r11.getDictionary();
        if (r12 == null) goto L29;
        RichTextElement r13 = (RichTextElement) r12.get(r4);
        if (r13 == null) goto L29;
        RichTextElement.AtUserGroupProperty r14 = (RichTextElement.AtUserGroupProperty) r13.getProperty();
    L31:
        if ((r14 instanceof RichTextElement.AtUserGroupProperty) == true) goto L34;
        r14 = null;
    L34:
        if (r14 == null) goto L19;
        r2.add(r14);
    L29:
        r14 = null;
        goto L31
    L37:
        if (r2.isEmpty() == true) goto L45;
        Iterator r15 = r2.iterator();
    L41:
        if (r15.hasNext() == false) goto L45;
        if (this.a.containsKey(Long.valueOf(((RichTextElement.AtUserGroupProperty) r15.next()).getUserGroupId())) == false) goto L41;
        boolean r16 = true;
    L47:
        return Boolean.valueOf(r16);
    L45:
        r16 = false;
        goto L47
    L57:
        return Boolean.FALSE;
    L10:
        r10 = null;
        goto L11
    L5:
        if (r8.getType() == Message.Type.POST) goto L7;
        return Boolean.FALSE;
    }
}

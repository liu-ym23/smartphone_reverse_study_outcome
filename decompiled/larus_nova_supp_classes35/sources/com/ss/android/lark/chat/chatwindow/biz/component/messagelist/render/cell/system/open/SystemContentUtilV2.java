package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SystemContentUtilV2 {
    public static final SystemContentUtilV2 a = null;
    public static final Lazy b = null;
    public static final Set<ContentValueType> c = null;

    public SystemContentUtilV2() {
    }

    static {
        a = new SystemContentUtilV2();
        b = LazyKt.lazy(SystemContentUtilV2$processorList$2.INSTANCE);
        c = SetsKt.setOf(new ContentValueType[]{ContentValueType.BOT, ContentValueType.CHATTER});
    }

    public static SpannableStringBuilder a(Map.Entry r18, List r19, c r20) {
        List r0 = r19;
        Intrinsics.checkNotNullParameter(r18, "entry");
        String r2 = "processorList";
        Intrinsics.checkNotNullParameter(r0, "processorList");
        Intrinsics.checkNotNullParameter(r20, "systemActionContext");
        String r5 = (String) r18.getKey();
        List r3 = (List) r18.getValue();
        List r6 = r3;
        int r7 = 0;
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r8 == false) goto L13;
        Log.i("SystemContentUtilV2", "getClickableSubString return: contentValues is empty, type=" + r20.a.getType() + ",key=" + r5);
        return new SpannableStringBuilder();
    L13:
        SpannableStringBuilder r9 = new SpannableStringBuilder();
        d r10 = f1.a;
        String r11 = UIUtils.getString(ChatCoreModule.a().getContext(), 2131892254);
        int r12 = r6.size();
    L14:
        if (r7 >= r12) goto L44;
        if (r7 == 0) goto L17;
        r9.append(r11);
    L17:
        ContentValue r13 = (ContentValue) ListProtector.get(r3, r7);
        Intrinsics.checkNotNullParameter(r9, ChameleonOpenTracker.ParamKey.RESULT);
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r13, "contentValue");
        Intrinsics.checkNotNullParameter(r0, r2);
        Intrinsics.checkNotNullParameter(r20, "systemActionContext");
        SystemContent r14 = r20.a;
        if (r14.getType() != SystemMessageType.USER_CHECK_OTHERS_TELEPHONE) goto L20;
        r13.setContentValueType(ContentValueType.USER);
    L20:
        Iterator r15 = r0.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        Object r16 = r15.next();
        if (((com.ss.android.lark.biz.im.api.extension.message.system.c) r16).a(r13, r20) == false) goto L22;
    L27:
        com.ss.android.lark.biz.im.api.extension.message.system.c r17 = (com.ss.android.lark.biz.im.api.extension.message.system.c) r16;
        if (r17 != null) goto L30;
        Log.i("SystemContentUtilV2", "not find processor, direct append, type=" + r14.getType() + ", key=" + r5 + ", valueType=" + r13.getContentValueType());
        r9.append(r13.getValue());
        String r110 = r2;
    L43:
        r7 = r7 + 1;
        r0 = r19;
        r2 = r110;
        goto L14
    L30:
        r17.c(r9, r13, r20);
        int r1 = r9.length();
        r110 = r2;
        r9.append(r17.b(r13, r20));
        int r4 = r9.length();
        if (r14.getVersion() > 0) goto L33;
    L35:
        b r111 = new b(r17, r20, r13, r20.context());
        if (r13.getContentValueType() == ContentValueType.CHATTER) goto L40;
        if (r13.getContentValueType() == ContentValueType.USER) goto L40;
    L42:
        r9.setSpan(r111, r1, r4, 33);
    L40:
        if (r14.getType() != SystemMessageType.INVITE_AT_CHATTERS) goto L42;
        r111.a = 2131106607;
        goto L42
    L33:
        if (r13.isClickable() == true) goto L35;
        Log.i("SystemContentUtilV2", "not add click span, type=" + r14.getType() + ", key=" + r5 + ", valueType=" + r13.getContentValueType());
        goto L43
    L26:
        r16 = null;
        goto L27
    L44:
        return r9;
    L5:
        if (r6.isEmpty() == true) goto L8;
        r8 = false;
        goto L10
    }

    public static SpannableStringBuilder b(SpannableStringBuilder r10, String r11, SpannableStringBuilder r12) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        int r2 = 0;
        int r3 = -1;
    L3:
        r3 = StringsKt.indexOf$default(r10, r11, r3 + 1, false, 4, null);
        if (r3 == (-1)) goto L7;
        r0 = r0.append(r10.subSequence(r2, r3)).append(r12);
        r2 = r11.length() + r3;
        goto L3
    L7:
        return r0.append(r10.subSequence(r2, r10.length()));
    }
}

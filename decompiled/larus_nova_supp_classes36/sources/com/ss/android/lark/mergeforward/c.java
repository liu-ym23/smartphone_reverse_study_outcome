package com.ss.android.lark.mergeforward;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.j;
import com.ss.android.lark.biz.im.api.r;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    @JvmStatic
    public static final boolean a(FragmentActivity r8, MergeForwardContent r9, Message r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "mergeForwardContent");
        ParseMergeForwardDataUtils$openDoubaoMergeForwardPage$1 r2 = ParseMergeForwardDataUtils$openDoubaoMergeForwardPage$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "mergeForwardContent");
        Intrinsics.checkNotNullParameter(r2, "canOpenPage");
        if (r9.isCopyFromDoubao() == true) goto L6;
        return false;
    L6:
        if (((Boolean) r2.invoke()).booleanValue() == false) goto L76;
        Map r0 = r9.getChatters();
        String r3 = null;
        if (r0 == null) goto L25;
        Collection r1 = r0.values();
        if (r1 == null) goto L25;
        Iterator r4 = r1.iterator();
    L14:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (((ChatterInfo) r5).getType() != Chatter.ChatterType.USER) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L14;
    L22:
        ChatterInfo r7 = (ChatterInfo) r5;
        if (r7 == null) goto L25;
        String r11 = r7.getName();
    L26:
        Map r12 = r9.getChatters();
        if (r12 == null) goto L43;
        Collection r13 = r12.values();
        if (r13 == null) goto L43;
        Iterator r14 = r13.iterator();
    L32:
        if (r14.hasNext() == false) goto L39;
        Object r15 = r14.next();
        if (((ChatterInfo) r15).getType() != Chatter.ChatterType.BOT) goto L36;
        boolean r16 = true;
    L37:
        if (r16 == false) goto L32;
    L40:
        ChatterInfo r17 = (ChatterInfo) r15;
        if (r17 == null) goto L43;
        r3 = r17.getName();
        goto L43
    L36:
        r16 = false;
        goto L37
    L39:
        r15 = null;
    L43:
        StringBuilder r18 = new StringBuilder();
        boolean r19 = !TextUtils.isEmpty(r11);
        boolean r20 = !TextUtils.isEmpty(r3);
        if (r19 == false) goto L47;
        if (r20 == false) goto L47;
        r18.append(r11);
        r18.append(UIHelper.getString(2131891910));
        r18.append(r3);
        r18.append(UIHelper.getString(2131891911));
    L55:
        r r21 = (r) LarkContext.spiByDwarf(r.class);
        List r22 = r9.getMessages();
        if (r22 == null) goto L61;
        List r23 = r22;
        ?? r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L59:
        if (r25.hasNext() == false) goto L62;
        r24.add(((Message) r25.next()).getContent());
    L62:
        r21.U(r8, new j(r10, r24, r18.toString()));
        return true;
    L61:
        r24 = CollectionsKt.emptyList();
    L47:
        if (r19 == true) goto L51;
        if (r20 == true) goto L51;
        r18.append(UIHelper.getString(2131891921));
    L51:
        if (r19 == true) goto L54;
        r11 = r3;
    L54:
        r18.append(r11);
        r18.append(UIHelper.getString(2131891911));
        goto L55
    L18:
        r6 = false;
        goto L19
    L21:
        r5 = null;
    L25:
        r11 = null;
        goto L26
    L76:
        return false;
    }
}

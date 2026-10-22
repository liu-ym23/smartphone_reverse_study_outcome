package com.ss.android.lark.mention.base;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.LabelAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SearchBean;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MentionUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final LabelAtBean b() {
        LabelAtBean r0 = new LabelAtBean(UIHelper.getString(2131890338));
        r0.setBgColorResId(2131100548);
        r0.setTextSize(16);
        r0.setVerticalPadding(UIHelper.dp2px(20.0f));
        return r0;
    }

    public static List a(List r11) {
        Intrinsics.checkNotNullParameter(r11, "searchData");
        String r0 = UIHelper.getString(2131890337);
        String r1 = UIHelper.getString(2131890338);
        List r2 = CollectionsKt.toMutableList(r11);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L3:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L8;
        Object r6 = r4.next();
        if ((true ^ Intrinsics.areEqual("mention_ai_knowledge", ((BaseAtBean) r6).getId())) == false) goto L3;
        r3.add(r6);
        goto L3
    L8:
        Log.i("MentionUtils", "aiKnowledgeToTop - searchData size: " + r11.size() + ", filteredData size: " + r3.size());
        ArrayList r12 = new ArrayList();
        int r7 = r3.size();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L22;
        r12.add(ListProtector.get(r3, r8));
        if (r8 >= (r3.size() - 1)) goto L21;
        BaseAtBean r9 = (BaseAtBean) ListProtector.get(r3, r8);
        BaseAtBean r10 = (BaseAtBean) ListProtector.get(r3, r8 + 1);
        if ((r9 instanceof LabelAtBean) == false) goto L21;
        if (Intrinsics.areEqual(((LabelAtBean) r9).getDisplayName(), r0) == false) goto L21;
        if ((r10 instanceof LabelAtBean) == false) goto L21;
        if (Intrinsics.areEqual(((LabelAtBean) r10).getDisplayName(), r1) == true) goto L21;
        r12.add(b());
    L21:
        r8 = r8 + 1;
        goto L9
    L22:
        Log.i("MentionUtils", "aiKnowledgeToTop - resultData size: " + r12.size());
        if (r12.isEmpty() == true) goto L31;
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L31;
        if ((((BaseAtBean) r13.next()) instanceof SearchBean) == false) goto L27;
    L32:
        if (r5 == true) goto L34;
        return r12;
    L34:
        ListProtector.add(r12, 0, new SearchBean(new com.ss.android.lark.mention.base.impl.atselector.bean.a(arb.a.b.a0(UIHelper.getString(2131891028)), UIHelper.getString(2131891203), Chatter.ChatterType.USER)));
        return r12;
    L31:
        r5 = false;
        goto L32
    }

    public static boolean d(Chat r4) {
        if (r4 != null) goto L5;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L16;
        if (r4 != null) goto L15;
        return false;
    L15:
        if (r4.isAdmin() == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r4.isP2PChat() == true) goto L11;
        if (r4.getOwnerId() == null) goto L11;
        if (TextUtils.equals(r4.getOwnerId(), b.a().d()) == false) goto L11;
        r2 = true;
        goto L12
    }

    public static List c(List r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "chatterList");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Object r1 = r6.next();
        ChatChatter r2 = (ChatChatter) r1;
        if (r2.isDimission() == false) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2.getChatter().getId(), r5) == true) goto L10;
        r3 = true;
        goto L11
    L13:
        return r0;
    }

    public static List e(List r6, List r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "oldData");
        Intrinsics.checkNotNullParameter(r7, "newData");
        List r9 = r7;
        final ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r2 = r9.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(((BaseAtBean) r2.next()).getId());
        goto L4
    L6:
        StringBuilder r3 = new StringBuilder("keepOld: ");
        r3.append(r8);
        r3.append(", old: ");
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r5 = r6.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(((BaseAtBean) r5.next()).getId());
        goto L8
    L10:
        r3.append(r4);
        r3.append(" , new: ");
        r3.append(r0);
        Log.i("MentionUtils", r3.toString());
        List r10 = CollectionsKt.toMutableList(r6);
        if (r8 == true) goto L13;
        CollectionsKt.retainAll(r10, new MentionUtils$mergeMentionLists$2(r0));
    L13:
        List r11 = r10;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        r1.add(((BaseAtBean) r12.next()).getId());
        goto L15
    L17:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r9.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if ((!r1.contains(((BaseAtBean) r15).getId())) == false) goto L19;
        r13.add(r15);
        goto L19
    L23:
        CollectionsKt.addAll(r10, r13);
        StringBuilder r16 = new StringBuilder("mergedList: ");
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r18 = r11.iterator();
    L25:
        if (r18.hasNext() == false) goto L27;
        r17.add(((BaseAtBean) r18.next()).getId());
        goto L25
    L27:
        r16.append(r17);
        Log.i("MentionUtils", r16.toString());
        return r10;
    }

    public static void f(List r4, List r5, List r6) {
        Intrinsics.checkNotNullParameter(r4, "old");
        Intrinsics.checkNotNullParameter(r5, "separatedInChat");
        Intrinsics.checkNotNullParameter(r6, "separatedOutChat");
        ArrayList r0 = new ArrayList();
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if ((r1 instanceof SearchBean) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        StringBuilder r8 = new StringBuilder("original data before separated: ");
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r2.add(((SearchBean) r3.next()).getId());
        goto L10
    L12:
        r8.append(r2);
        Log.i("MentionUtils", r8.toString());
        Iterator r9 = r0.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        SearchBean r10 = (SearchBean) r9.next();
        if (r10.isOutChatUser() == true) goto L17;
        ((ArrayList) r5).add(r10);
        goto L14
    L17:
        ((ArrayList) r6).add(r10);
        goto L14
    }
}

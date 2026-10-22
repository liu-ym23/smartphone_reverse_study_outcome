package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.favorite.FavoriteMessageInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileDetailController {
    public static final Set<String> a = null;
    public static List<IFileDetailPlugin> b;
    public static IFileDetailPlugin c;

    static {
        a = SetsKt.setOf(new String[]{"eml", "msg"});
        b = new ArrayList();
    }

    public static boolean a(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Message r0 = (Message) r3.next();
        if (r0.isRecalled() == true) goto L9;
        if (r0.isSourceFileDelete() == false) goto L4;
        return false;
    L9:
        return false;
    L11:
        return true;
    }

    public static void c(FileDetailLaunchParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Context r0 = r3.getContext().get();
        if (r0 != null) goto L5;
        return;
    L5:
        Intent r1 = new Intent(r0, FileDetailActivity.class);
        r1.putExtra("extra.launch.params", r3);
        r0.startActivity(r1);
    }

    public static void d(final FileDetailLaunchParams r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        final UIGetDataCallback r0 = new UIGetDataCallback(new FileDetailController$openFileMessageDetail$1(r7));
        ArrayList r1 = new ArrayList();
        final ArrayList r2 = new ArrayList();
        Message r3 = r7.getMessage();
        boolean r4 = false;
        if (r3 != null) goto L5;
        r1.add(r7.getMessageId());
    L16:
        if (TextUtils.isEmpty(r7.getMergeMsgId()) == true) goto L18;
        r1.add(r7.getMergeMsgId());
    L18:
        FavoriteMessageInfo r5 = r7.getFavoriteMessage();
        if (r5 == null) goto L23;
        Message r6 = r5.getSourceMessage();
        if (r6 == null) goto L23;
        final String r8 = r6.getId();
    L24:
        if (r8 != null) goto L26;
    L27:
        r4 = true;
    L28:
        if (r4 == true) goto L33;
        if (r1.contains(r8) == true) goto L33;
        r1.add(r8);
    L33:
        if (CollectionUtils.isNotEmpty(r1) == false) goto L39;
        com.ss.android.lark.storage.a r9 = FileDetailModule.a;
        hfb.b r10 = FileDetailModule.a.a();
        if (r10 == null) goto L41;
        hfb.b.d r11 = r10.getChatDependency();
        if (r11 == null) goto L42;
        new FileDetailController$checkParams$1(r8, r7, r2, r0);
        r11.a();
        return;
    L42:
        return;
    L41:
        return;
    L39:
        r0.onSuccess(Boolean.valueOf(a(r2)));
        return;
    L26:
        if (r8.length() != 0) goto L28;
    L23:
        r8 = null;
        goto L24
    L5:
        String r12 = r7.getSenderTenantId();
        if (r12 != null) goto L8;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        r7.setSenderTenantId(r3.getFromChatterTenantId());
    L14:
        r2.add(r3);
        goto L16
    L8:
        if (r12.length() == 0) goto L11;
        r13 = false;
        goto L12
    }

    public static String b(List r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        Iterator r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r1 = r5.next();
        if (Intrinsics.areEqual(r4, ((Message) r1).getId()) == false) goto L13;
    L18:
        Message r2 = (Message) r1;
        if (r2 != null) goto L21;
        return null;
    L21:
        return r2.getFromChatterTenantId();
    L17:
        r1 = null;
        goto L18
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L9
    }
}

package xtb;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.dto.FileDetailLaunchParams;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.detail.FileDetailController;
import com.ss.android.lark.officesdk.integrator.im.impl.g;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import vab.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements b {
    @Inject
    public a() {
    }

    public static int a(Chat r0) {
        if (r0 == null) goto L4;
        Chat.Type r1 = r0.getType();
    L6:
        return r1.getNumber();
    L4:
        r1 = Chat.Type.UNKNOWN;
        goto L6
    }

    public final void b(Context r7, Message r8, Chat r9) {
        boolean r0 = false;
        if (r9 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r9 != null) goto L10;
    L12:
        boolean r1 = y0.b(r9);
        boolean r3 = y0.c(r9);
        FileDetailLaunchParams.a r4 = new FileDetailLaunchParams.a(r7, r8);
        String r10 = r8.getChatId();
        Intrinsics.checkNotNullParameter(r10, "chatId");
        r4.d = r10;
        r4.f = r2;
        r4.g = r0;
        r4.c(r1);
        r4.b(r3);
        r4.y = null;
        r4.A = null;
        r4.B = a(r9);
        r4.j = 1;
        if (TextUtils.isEmpty(null) == true) goto L18;
        if (r8.getType() != Message.Type.FILE) goto L18;
        r4.z = r8.getContent().getKey();
    L18:
        if (TextUtils.isEmpty(r8.getThreadId()) == false) goto L20;
        r4.h = r8.getPosition();
    L22:
        if (TextUtils.isEmpty("") == true) goto L24;
        Intrinsics.checkNotNullParameter("", "originMergeForwardId");
        r4.w = "";
    L24:
        int r11 = g.a;
        FileDetailLaunchParams r12 = r4.a();
        Intrinsics.checkNotNullParameter(r12, "params");
        FileDetailController.d(r12);
        return;
    L20:
        String r13 = r8.getThreadId();
        Intrinsics.checkNotNullParameter(r13, "threadId");
        r4.t = r13;
        r4.x = r8.getThreadPosition();
        goto L22
    L10:
        if (r9.isCrossWithKa() == false) goto L12;
        r0 = true;
        goto L12
    L5:
        if (r9.isSecret() == false) goto L7;
        r2 = true;
        goto L8
    }

    public final void e(Context r17, Message r18, Chat r19) {
        boolean r1 = y0.b(r19);
        boolean r2 = y0.c(r19);
        if (TextUtils.isEmpty(null) == true) goto L10;
        FileContent r4 = r18.getContent();
        if ((r4 instanceof FileContent) == false) goto L8;
        String r5 = r4.getKey();
    L11:
        Intrinsics.checkNotNullParameter(r18, "message");
        Chat.Type.UNKNOWN.getNumber();
        String r6 = r18.getId();
        String r7 = r18.getContent().getKey();
        String r8 = r18.getContent().getName();
        long r9 = r18.getContent().getSize();
        String r10 = r18.getChatId();
        Intrinsics.checkNotNullParameter(r10, "chatId");
        int r11 = a(r19);
        int r13 = -1;
        if (r18.isReplyInThreadRootMessage() == false) goto L16;
        int r12 = r18.getPosition();
    L14:
        r13 = r12;
        int r14 = -1;
        String r15 = null;
    L19:
        int r16 = g.a;
        FolderManageLaunchParams r110 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r110.a = r6;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r110.b = r10;
        r110.c = r13;
        r110.d = false;
        r110.e = 0;
        r110.f = 1;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r110.g = r7;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r110.h = r8;
        r110.i = null;
        r110.j = null;
        r110.k = r15;
        r110.l = r14;
        r110.m = r18;
        r110.n = r9;
        r110.o = null;
        r110.p = r1;
        r110.q = r2;
        r110.r = 1;
        r110.s = null;
        r110.t = null;
        r110.u = r5;
        r110.v = null;
        r110.w = r11;
        FileDetailModule.a(r17, r110);
        return;
    L16:
        if (r18.isReplyInThreadChildMessage() == false) goto L18;
        r15 = r18.getThreadId();
        r14 = r18.getThreadPosition();
        goto L19
    L18:
        r12 = r18.getPosition();
        goto L14
    L8:
        if ((r4 instanceof FolderContent) == false) goto L10;
        r5 = ((FolderContent) r4).getKey();
    L10:
        r5 = "";
        goto L11
    }

    public final void d(Context r6, FileContent r7, String r8, Chat r9, int r10, boolean r11) {
        boolean r0 = y0.b(r9);
        boolean r1 = y0.c(r9);
        if (r9.isCrossWithKa() == false) goto L5;
        boolean r2 = true;
    L6:
        FileDetailLaunchParams.a r4 = new FileDetailLaunchParams.a(r6, r7, r8);
        r4.h = r10;
        r4.c(r0);
        r4.b(r1);
        r4.g = r2;
        r4.B = a(r9);
        r4.k = false;
        r4.v = false;
        r4.z = r7.getKey();
        long r12 = r4.m | 8;
        r4.m = r12;
        if (r11 == true) goto L9;
        r4.m = r12 ^ 8;
    L9:
        String r13 = r9.getId();
        Intrinsics.checkNotNullParameter(r13, "chatId");
        r4.d = r13;
        FileDetailLaunchParams r14 = r4.a();
        Intrinsics.checkNotNullParameter(r14, "params");
        FileDetailController.d(r14);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void f(Context r17, Message r18, FolderContent r19, String r20, Chat r21, int r22, String r23, String r24, boolean r25) {
        if (r25 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        boolean r4 = y0.c(r21);
        Intrinsics.checkNotNullParameter(r20, "messageId");
        Chat.Type.UNKNOWN.getNumber();
        String r5 = r19.getKey();
        Intrinsics.checkNotNullParameter(r5, "folderKey");
        String r6 = r19.getName();
        Intrinsics.checkNotNullParameter(r6, "folderName");
        long r7 = r19.getSize();
        int r9 = a(r21);
        String r10 = r19.getKey();
        if (r18 == null) goto L11;
        Message r12 = r18;
    L12:
        String r13 = r21.getId();
        Intrinsics.checkNotNullParameter(r13, "chatId");
        FolderManageLaunchParams r14 = new FolderManageLaunchParams();
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r14.a = r20;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r14.b = r13;
        r14.c = r22;
        r14.d = false;
        r14.e = 10;
        r14.f = -99;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r14.g = r5;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r14.h = r6;
        r14.i = null;
        r14.j = null;
        r14.k = null;
        r14.l = -1;
        r14.m = r12;
        r14.n = r7;
        r14.o = null;
        r14.p = r3;
        r14.q = r4;
        r14.r = 1;
        r14.s = r23;
        r14.t = r24;
        r14.u = r10;
        r14.v = null;
        r14.w = r9;
        FileDetailModule.a(r17, r14);
        return;
    L11:
        r12 = null;
        goto L12
    L5:
        if (y0.b(r21) == false) goto L7;
        r3 = true;
        goto L8
    }

    public final void c(Context r5, Message r6, FileContent r7, String r8, Chat r9, int r10, boolean r11, String r12, String r13, boolean r14) {
        boolean r1 = true;
        if (r14 == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        boolean r2 = y0.c(r9);
        if (r9.isCrossWithKa() == true) goto L12;
        r1 = false;
    L12:
        FileDetailLaunchParams.a r3 = new FileDetailLaunchParams.a(r5, r7, r8);
        r3.h = r10;
        r3.c(r15);
        r3.b(r2);
        r3.g = r1;
        r3.B = a(r9);
        r3.k = false;
        r3.v = false;
        r3.z = r7.getKey();
        r3.y = r12;
        r3.A = r13;
        long r16 = r3.m | 8;
        r3.m = r16;
        if (r11 == true) goto L15;
        r3.m = r16 ^ 8;
    L15:
        if (r6 == null) goto L17;
        Intrinsics.checkNotNullParameter(r6, "message");
        r3.b = r6;
    L17:
        String r17 = r9.getId();
        Intrinsics.checkNotNullParameter(r17, "chatId");
        r3.d = r17;
        FileDetailLaunchParams r18 = r3.a();
        Intrinsics.checkNotNullParameter(r18, "params");
        FileDetailController.d(r18);
        return;
    L5:
        if (y0.b(r9) == false) goto L7;
        r15 = true;
        goto L8
    }
}

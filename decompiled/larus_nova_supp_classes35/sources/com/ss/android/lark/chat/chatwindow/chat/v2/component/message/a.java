package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.ImageErrorRecord;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ ChatImageErrDetector a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public a(ChatImageErrDetector r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ChatImageErrDetector r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        r0.getClass();
        if (ChatImageErrDetector.c != null) goto L5;
    L65:
        Log.i("ChatImageDetector", "exit chat when detect");
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_EXIT_CHAT, null);
        return;
    L5:
        if (ChatImageErrDetector.d == null) goto L65;
        ConcurrentHashMap r3 = (ConcurrentHashMap) ChatImageErrDetector.a;
        if (r3.get(new ChatImageErrDetector.b(r1, r2)) != null) goto L11;
        Log.i("ChatImageDetector", "has reported");
        return;
    L11:
        if (Intrinsics.areEqual(r3.get(new ChatImageErrDetector.b(r1, r2)), Boolean.TRUE) == false) goto L13;
        Log.i("ChatImageDetector", "success after failed");
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_SUCCESS, null);
        return;
    L13:
        WeakReference<RecyclerView> r4 = ChatImageErrDetector.c;
        if (r4 == null) goto L72;
        RecyclerView r5 = r4.get();
        if (r5 == null) goto L73;
        LinearLayoutManager r6 = r5.getLayoutManager();
        if (r6 != null) goto L21;
        return;
    L21:
        if ((r6 instanceof LinearLayoutManager) == false) goto L23;
        LinearLayoutManager r7 = r6;
        int r8 = r7.findFirstVisibleItemPosition();
        int r9 = r7.findLastVisibleItemPosition();
    L25:
        if (r8 < 0) goto L64;
        if (r9 < 0) goto L64;
        WeakReference<com.ss.android.lark.chat.chatwindow.chat.a> r10 = ChatImageErrDetector.d;
        if (r10 == null) goto L33;
        com.ss.android.lark.chat.chatwindow.chat.a r11 = r10.get();
        if (r11 == null) goto L33;
        List r12 = r11.o1(r8, r9);
    L34:
        if (r12 != null) goto L36;
    L63:
        Log.i("ChatImageDetector", "current data list is empty");
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_DATA_LIST_EMPTY, null);
        return;
    L36:
        if (r12.isEmpty() == true) goto L63;
        Iterator r13 = r12.iterator();
    L40:
        if (r13.hasNext() == false) goto L62;
        y6b.c r14 = (y6b.c) r13.next();
        if (Intrinsics.areEqual(r14.c, r1) == false) goto L40;
        if (r14.r == Message.Status.NORMAL) goto L47;
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_MESSAGE_RECALL, null);
        return;
    L47:
        if (r14.getType() != Message.Type.IMAGE) goto L61;
        T r15 = r14.o.a;
        if ((r15 instanceof ImageContent) == false) goto L61;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.ImageContent");
        ImageSet r16 = ((ImageContent) r15).getImageSet();
        if (r16 != null) goto L54;
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_IMAGE_SET_EMPTY, null);
        return;
    L54:
        Image r17 = com.ss.android.lark.chat.utils.g.b(r16);
        if (r17 != null) goto L58;
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_IMAGE_EMPTY, null);
        return;
    L58:
        if (Intrinsics.areEqual(r17.getKey(), r2) == true) goto L60;
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_IMAGE_KEY_NOT_EQUAL, null);
        return;
    L60:
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_IMAGE_LOAD_REAL_FAILED, ImageErrorRecord.INSTANCE.getErrorResult(r2));
        return;
    L61:
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_MESSAGE_NOT_IMAGE, null);
        return;
    L62:
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_MESSAGE_NOT_EXIST, null);
        return;
    L33:
        r12 = null;
    L64:
        Log.i("ChatImageDetector", "current data list is empty");
        ChatImageErrDetector.a(r1, r2, ChatImageErrDetector.ErrorType.TYPE_DATA_LIST_EMPTY, null);
        return;
    L23:
        r8 = -1;
        r9 = -1;
        goto L25
    L73:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

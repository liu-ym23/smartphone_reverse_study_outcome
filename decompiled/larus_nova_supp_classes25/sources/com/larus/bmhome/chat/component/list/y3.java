package com.larus.bmhome.chat.component.list;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.ui.arch.component.internal.attach.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p99.d;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y3 implements FragmentResultListener {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ y3(ChatListComponent r1) {
        this.a = r1;
    }

    public final void onFragmentResult(String r18, Bundle r19) {
        ChatListComponent r2 = this.a;
        int r3 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r18, "<unused var>");
        Intrinsics.checkNotNullParameter(r19, "data");
        d r4 = r2.m3;
        if (r4 == null) goto L9;
        wc9.e r5 = r2.R4();
        if (r5 == null) goto L7;
        String r6 = r5.B;
    L8:
        r4.k(r6);
        goto L9
    L7:
        r6 = null;
    L9:
        boolean r12 = r19.getBoolean("is_submit", false);
        Bundle r7 = r19.getBundle("extra_data");
        if (r7 == null) goto L12;
        String r15 = r7.getString("message_id");
    L13:
        int[] r8 = r19.getIntArray("selected_code_list");
        if (r8 == null) goto L18;
        List r9 = ArraysKt.toList(r8);
        if (r9 == null) goto L18;
        List r11 = r9;
    L19:
        String r10 = r19.getString("input_txt", "");
        if (r7 == null) goto L22;
        int r1 = r7.getInt("feedback_scene", MsgFeedbackType.MsgFeedbackTypeDefault.value);
    L23:
        ChatListComponentViewModel r13 = r2.U5();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Context r14 = a.b(r2, r2).getContext();
        String r16 = r2.G4();
        Intrinsics.checkNotNull(r10);
        Integer r17 = Integer.valueOf(r1);
        String r110 = UUID.randomUUID().toString();
        wc9.e r20 = r2.R4();
        if (r20 == null) goto L27;
        String r21 = r20.B;
        if (r21 == null) goto L27;
    L44:
        if (r21 != null) goto L46;
        r21 = "";
    L46:
        String r22 = r15;
        String r23 = r15;
        String r111 = r21;
        r13.reportDislike(r14, r16, r22, r10, r11, r12, r17, r110, r111, ChatListComponent.p7(Integer.valueOf(r1)));
        MessageAdapter r24 = r2.O;
        if (r24 == null) goto L65;
        Iterator r25 = ((ArrayList) r24.getCurrentList()).iterator();
    L50:
        if (r25.hasNext() == false) goto L54;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((Message) r26).getMessageId(), r23) == false) goto L50;
    L55:
        Message r27 = (Message) r26;
        if (r27 == null) goto L66;
        ChatControlTrace.b.O(r27, de8.d.a(r2.f1()), null);
        return;
    L66:
        return;
    L54:
        r26 = null;
        goto L55
    L65:
        return;
    L27:
        MessageAdapter r28 = r2.O;
        if (r28 == null) goto L43;
        List<b> r29 = r28.z2();
        if (r29 == null) goto L43;
        Iterator<T> r30 = r29.iterator();
    L33:
        if (r30.hasNext() == false) goto L37;
        Object r31 = r30.next();
        if (Intrinsics.areEqual(((b) r31).getMessage().getMessageId(), r15) == false) goto L33;
    L38:
        b r32 = (b) r31;
        if (r32 == null) goto L43;
        Message r33 = r32.getMessage();
        if (r33 == null) goto L43;
        r21 = r33.getSectionId();
        goto L44
    L37:
        r31 = null;
    L43:
        r21 = null;
        goto L44
    L22:
        r1 = MsgFeedbackType.MsgFeedbackTypeDefault.value;
    L18:
        r11 = CollectionsKt.listOf(Integer.valueOf(r19.getInt("selected_code", 0)));
        goto L19
    L12:
        r15 = null;
        goto L13
    }
}

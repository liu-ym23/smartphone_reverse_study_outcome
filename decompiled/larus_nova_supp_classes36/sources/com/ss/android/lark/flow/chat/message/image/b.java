package com.ss.android.lark.flow.chat.message.image;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.flow.chat.page.ChatFragment;
import com.ss.android.lark.flow.chat.page.FlowChatActivity;
import com.ss.android.lark.flow.chat.page.flow.FlowChatFragment;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardActivity;
import com.ss.android.lark.flow.mergeforward.FlowMergeForwardContainerFragment;
import com.ss.android.lark.flow.mergeforward.page.FlowMergeForwardFragment;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static GallerySource b(m2b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.e0() == false) goto L7;
        return GallerySource.MergeForward;
    L7:
        if (r1.Y() == false) goto L11;
        return GallerySource.ReplayThread;
    L11:
        return GallerySource.Chat;
    }

    public static void a(FragmentActivity r6, boolean r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Object r1 = null;
        if ((r6 instanceof FlowChatActivity) == false) goto L6;
        Pair r0 = new Pair(Reflection.getOrCreateKotlinClass(ChatFragment.class), Reflection.getOrCreateKotlinClass(FlowChatFragment.class));
    L13:
        if (r0 != null) goto L16;
        Log.e("FlowGalleryUtils", "onShowStatusBar, not support " + r6);
        return;
    L16:
        FragmentManager r9 = r6.getSupportFragmentManager();
        if (r9 == null) goto L52;
        List r10 = r9.getFragments();
        if (r10 == null) goto L53;
        Iterator r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Object r3 = r11.next();
        if (((KClass) r0.getFirst()).isInstance((Fragment) r3) == false) goto L22;
    L27:
        Fragment r4 = (Fragment) r3;
        if (r4 == null) goto L54;
        FragmentManager r12 = r4.getChildFragmentManager();
        if (r12 == null) goto L55;
        List r13 = r12.getFragments();
        if (r13 == null) goto L56;
        Iterator r14 = r13.iterator();
    L35:
        if (r14.hasNext() == false) goto L39;
        Object r5 = r14.next();
        if (((KClass) r0.getSecond()).isInstance((Fragment) r5) == false) goto L35;
        r1 = r5;
    L39:
        Fragment r2 = (Fragment) r1;
        if (r2 == null) goto L57;
        com.ss.android.lark.insets.f r15 = WindowInsetsUtils.b(r2);
        if (r7 == false) goto L44;
        r8 = 0;
    L44:
        r15.l(r8);
        Log.i("FlowGalleryUtils", "onShowStatusBar, set forcePatchTopFixedHeight: " + r15.j());
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L26:
        r3 = null;
        goto L27
    L53:
        return;
    L52:
        return;
    L6:
        if ((r6 instanceof FlowMergeForwardActivity) == false) goto L9;
        r0 = new Pair(Reflection.getOrCreateKotlinClass(FlowMergeForwardContainerFragment.class), Reflection.getOrCreateKotlinClass(FlowMergeForwardFragment.class));
        goto L13
    L9:
        if ((r6 instanceof FlowReplyInThreadActivity) == false) goto L11;
        r0 = new Pair(Reflection.getOrCreateKotlinClass(FlowReplyInThreadContainerFragment.class), Reflection.getOrCreateKotlinClass(FlowReplyInThreadFragment.class));
        goto L13
    L11:
        r0 = null;
        goto L13
    }
}

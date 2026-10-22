package com.larus.bmhome.double_post.drag_panel;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatAwemeFeedComponent$addFragment$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public ChatAwemeFeedComponent$addFragment$2(Object r8) {
        super(0, r8, ChatAwemeFeedComponent.class, "getFourCardHeight", "getFourCardHeight()I", 0);
    }

    public final Integer invoke() {
        ChatAwemeFeedComponent r0 = (ChatAwemeFeedComponent) ((CallableReference) this).receiver;
        int r2 = 0;
        if (r0.I == null) goto L17;
        LarusPageChatBinding r1 = r0.p3();
        ChatMessageList r3 = null;
        if (r1 == null) goto L8;
        ChatMessageList r4 = r1.n;
    L10:
        if ((r4 instanceof ViewGroup) == false) goto L12;
        r3 = r4;
    L12:
        if (r3 == null) goto L17;
        View r5 = r3.getChildAt(0);
        if (r5 == null) goto L17;
        r2 = r5.getHeight();
        goto L17
    L8:
        r4 = null;
    L17:
        return Integer.valueOf(r2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m9invoke() {
        return invoke();
    }
}

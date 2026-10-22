package com.larus.bmhome.double_post.drag_panel;

import android.widget.TextView;
import com.larus.bmhome.databinding.LarusFragmentAwemeDoublePostBinding;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.double_post.utils.c;
import com.larus.bmhome.video.Content;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import ip8.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ChatAwemeFeedComponent$addFragment$1 extends FunctionReferenceImpl implements Function0<Integer> {
    public ChatAwemeFeedComponent$addFragment$1(Object r8) {
        super(0, r8, AwemeDoublePostFragment.class, "getAvailableHeight", "getAvailableHeight()I", 0);
    }

    public final Integer invoke() {
        AwemeDoublePostFragment r0 = (AwemeDoublePostFragment) ((CallableReference) this).receiver;
        int r2 = 0;
        if (r0.j == true) goto L38;
        if (((ChatAwemeFeedConfig) r0.s.getValue()).getShouldFullyDisplay() == true) goto L7;
    L9:
        LarusFragmentAwemeDoublePostBinding r1 = r0.e;
        if (r1 == null) goto L19;
        TextView r3 = r1.c;
        if (r3 == null) goto L19;
        if (r3.getVisibility() != 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 != true) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
        int r6 = ((Number) i5.X.getValue()).intValue();
        int r7 = c.a();
    L35:
        r2 = r6 + r7;
        goto L38
    L22:
        List r8 = CollectionsKt.toMutableList(((FPagingAdapter) r0.i).b);
        if ((r8 instanceof Collection) == true) goto L25;
    L27:
        Iterator r9 = r8.iterator();
    L29:
        if (r9.hasNext() == false) goto L33;
        if (d.a((Content) r9.next()) == false) goto L29;
        r2 = 1;
    L33:
        if (r2 != 0) goto L36;
        r6 = i5.m0();
        r7 = c.a();
        goto L35
    L36:
        r2 = Integer.MAX_VALUE;
        goto L38
    L25:
        if (r8.isEmpty() == false) goto L27;
    L16:
        r4 = false;
    L19:
        r5 = false;
        goto L20
    L7:
        if (Intrinsics.areEqual(r0.q, Boolean.TRUE) == true) goto L9;
    L38:
        return Integer.valueOf(r2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8invoke() {
        return invoke();
    }
}

package com.ss.android.lark.chat.plugin;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.movable.selection.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/movable/selection/MovableScrollBounds;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatRichTextClickPlugin$onCreate$1$longClickHandler$1$1$createAutoScrollStrategy$1 extends Lambda implements Function0<i> {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ int $topOffsetPx;

    public ChatRichTextClickPlugin$onCreate$1$longClickHandler$1$1$createAutoScrollStrategy$1(RecyclerView r1, int r2) {
        this.$recyclerView = r1;
        this.$topOffsetPx = r2;
        super(0);
    }

    public final i invoke() {
        RecyclerView r1 = this.$recyclerView;
        int[] r3 = new int[2];
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r3);
    L5:
        Float r4 = Float.valueOf(r3[1] + this.$topOffsetPx);
        RecyclerView r5 = this.$recyclerView;
        int[] r2 = new int[2];
        if (r5 == null) goto L8;
        r5.getLocationOnScreen(r2);
    L8:
        int r6 = r2[1];
        if (r5 == null) goto L11;
        int r7 = r5.getHeight();
    L13:
        return new i(r4, Float.valueOf(r6 + r7));
    L11:
        r7 = 0;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m651invoke() {
        return invoke();
    }
}

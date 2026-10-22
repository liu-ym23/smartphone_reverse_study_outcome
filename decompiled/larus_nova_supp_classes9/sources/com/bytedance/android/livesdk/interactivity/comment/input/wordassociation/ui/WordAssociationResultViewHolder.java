package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c32.c;
import c32.d;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils.WordAssociationAppLogger;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/wordassociation/ui/WordAssociationResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WordAssociationResultViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final LinearLayout b;
    public final RecyclerView c;
    public final MultiTypeAdapter d;
    public final LinearLayoutManager e;
    public final g f;
    public final long g;

    public WordAssociationResultViewHolder(View r2, g r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.a = (TextView) r2.findViewById(2131390168);
        this.b = (LinearLayout) r2.findViewById(2131373393);
        this.c = r2.findViewById(2131373395);
        this.d = new MultiTypeAdapter();
        this.e = new LinearLayoutManager(r2.getContext(), 0, false);
    }

    public static final void T3(WordAssociationResultViewHolder r20, Context r21, d r23, String r24, g r25) {
        r20.getClass();
        int r1 = r23.actionType;
        boolean r9 = false;
        if (r1 != 1) goto L5;
        WordAssociationAppLogger.d(r23, r23.a(), r24, r23.b, r23.c, r20.g);
        String r0 = r23.schemaUrl;
        if (r0 != null) goto L39;
    L40:
        r9 = true;
    L41:
        if (r9 == true) goto L43;
        k.n(IBaseLiveActionHandler.class).handle(r21, r23.schemaUrl);
    L43:
        if (r25 == null) goto L59;
        h r2 = i.b(null, 3);
        if ((r2 instanceof InteractivityPlatformContext) == true) goto L47;
        r2 = null;
    L47:
        InteractivityPlatformContext r3 = (InteractivityPlatformContext) r2;
        if (r3 == null) goto L52;
        n<c> r4 = r3.getWordAssociateResult();
        if (r4 == null) goto L52;
        r4.setValue(null);
    L52:
        r25.J();
        return;
    L59:
        return;
    L39:
        if (r0.length() != 0) goto L41;
    L5:
        if (r1 != 2) goto L60;
        WordAssociationAppLogger.d(r23, r23.a(), r24, r23.b, r23.c, r20.g);
        Map<String, String> r5 = r23.extraMap;
        if (r5 == null) goto L54;
        String r6 = r5.get("emoji_id");
        if (r6 == null) goto L55;
        Long r7 = StringsKt.toLongOrNull(r6);
        if (r7 == null) goto L56;
        long r13 = r7.longValue();
        Map<String, String> r8 = r23.extraMap;
        if (r8 == null) goto L20;
        String r10 = r8.get("emoji_scale");
        if (r10 == null) goto L20;
        Integer r11 = StringsKt.toIntOrNull(r10);
        if (r11 == null) goto L20;
        int r14 = r11.intValue();
    L21:
        HashMap r15 = new HashMap();
        r15.put("is_word_to_vipemoji", "1");
        r15.put("message_source", "association");
        xs2.b r16 = xs2.b.a();
        ISendCommentEvent.Sender r17 = ISendCommentEvent.Sender.SubscribeJSB;
        HashMap r18 = new HashMap();
        if (r25 == null) goto L24;
        CommentFlowContext r19 = r25.S();
    L25:
        r16.post(new c0(r13, r14, false, r17, r18, r19, r15));
        if (r25 == null) goto L57;
        h r26 = i.b(null, 3);
        if ((r26 instanceof InteractivityPlatformContext) == true) goto L30;
        r26 = null;
    L30:
        InteractivityPlatformContext r27 = (InteractivityPlatformContext) r26;
        if (r27 == null) goto L35;
        n<c> r28 = r27.getWordAssociateResult();
        if (r28 == null) goto L35;
        r28.setValue(null);
    L35:
        r25.J();
        return;
    L57:
        return;
    L24:
        r19 = null;
    L20:
        r14 = 0;
        goto L21
    L56:
        return;
    L55:
        return;
    L54:
        return;
    }
}

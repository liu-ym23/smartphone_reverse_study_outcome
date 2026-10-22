package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import c32.d;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import tb2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends me.drakeet.multitype.b<d, WordAssociationResultViewHolder> {
    public final g b;
    public final long c;

    public b(g r1, long r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r9, Object r10) {
        WordAssociationResultViewHolder r11 = (WordAssociationResultViewHolder) r9;
        d r13 = (d) r10;
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r13, "item");
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(null);
        r11.a.setText(BuildConfig.FLAVOR);
        UtilityKotlinExtentionsKt.t(r11.c);
        a5 r0 = r13.associationDisplayText;
        if (r0 == null) goto L53;
        float r2 = r11.a.getTextSize();
        f.a.getClass();
        x r3 = r.b;
        Intrinsics.checkNotNullParameter(r0, "text");
        tb2.d r1 = r.a(r0, null);
        boolean r4 = true;
        if (r1.a.size() != 1) goto L13;
        c r5 = (c) CollectionsKt.firstOrNull(r1.a);
        if (r5 == null) goto L10;
        ITextPieceImage r6 = r5.getImageValue();
    L11:
        if (r6 == null) goto L13;
    L14:
        if (r4 == false) goto L23;
        Iterator<c> r7 = r1.a.iterator();
    L17:
        if (r7.hasNext() == false) goto L23;
        ITextPieceImage r8 = r7.next().getImageValue();
        if (r8 == null) goto L17;
        int r14 = (int) (r8.getScalingRate() * r2);
        if (r8.getScalingRate() <= 0.0f) goto L17;
        r8.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r8.setHeight(r14);
    L23:
        qb2.c.b(r1, new WordAssociationResultViewHolder$bind$2(r11, r13), null, 28);
        if (r13.actionType != 3) goto L49;
        Map<String, String> r15 = r13.extraMap;
        if (r15 == null) goto L50;
        String r16 = r15.get("fusion_emoji_list");
        if (r16 == null) goto L51;
        RecyclerView r17 = r11.c;
        if (r17 == null) goto L32;
        r17.setLayoutManager(r11.e);
    L32:
        RecyclerView r18 = r11.c;
        if (r18 == null) goto L35;
        MultiTypeAdapter r19 = r11.d;
        r19.z2(com.bytedance.android.livesdk.interactivity.api.emoji.a.class, new a(r11.f, r13, r11.g));
        Unit r110 = Unit.INSTANCE;
        r18.setAdapter(r19);
    L35:
        List r111 = GsonHelper.fromJsonArray(r16, com.bytedance.android.livesdk.interactivity.api.emoji.a.class);
        if (r111.size() <= 0) goto L52;
        UtilityKotlinExtentionsKt.w(r11.c);
        LinearLayout r20 = r11.b;
        if (r20 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r20);
    L40:
        Items r21 = new Items();
        r21.addAll(r111);
        MultiTypeAdapter r23 = r11.d;
        r23.a = r21;
        r23.notifyDataSetChanged();
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L10:
        r6 = null;
    L13:
        r4 = false;
        goto L14
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new WordAssociationResultViewHolder(r4.inflate(2131566819, r5, false), this.b, this.c);
    }
}

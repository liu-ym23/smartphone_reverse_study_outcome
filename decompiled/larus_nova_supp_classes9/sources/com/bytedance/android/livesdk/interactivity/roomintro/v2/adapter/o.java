package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ Function0 b;

    public o(m r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Unit r11 = (Unit) r10;
        List r13 = (List) this.a.f.g.a;
        ALogger.i("RoomIntroDialogV2", "selectedLabels change, new labels: " + r13);
        this.a.g.removeAllViews();
        Iterator<T> r0 = r13.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L26;
        T r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        RoomIntroLabel r5 = (RoomIntroLabel) r3;
        m r6 = this.a;
        p r7 = (p) CollectionsKt.getOrNull(r6.e, r2);
        if (r7 != null) goto L12;
        View r8 = LayoutInflater.from(r6.g.getContext()).inflate(2131567493, r6.g, false);
        p r9 = new p(r8, (TextView) r8.findViewById(2131388367), r8.findViewById(2131374718));
        ((ArrayList) r6.e).add(r9);
        r7 = r9;
    L12:
        ViewGroup r14 = this.a.g;
        Intrinsics.checkNotNullParameter(r5, "label");
        Intrinsics.checkNotNullParameter(r14, "container");
        if (r7.a.getParent() != null) goto L15;
        r14.addView(r7.a);
    L15:
        r7.b.setText(r5.getShowText());
        String r15 = r5.getLabelIconForAnchorSettingDialog();
        if (r15 != null) goto L18;
    L21:
        boolean r16 = true;
    L22:
        if (r16 == true) goto L24;
        UtilityKotlinExtentionsKt.w(r7.c);
        ImageLoader.bindImage(r7.c, r15);
    L25:
        r2 = r4;
        goto L4
    L24:
        UtilityKotlinExtentionsKt.t(r7.c);
        goto L25
    L18:
        if (r15.length() == 0) goto L21;
        r16 = false;
        goto L22
    L26:
        m r1 = this.a;
        Function0 r17 = this.b;
        if (r1.f.q.isEmpty() == true) goto L37;
        View r18 = r1.a;
        if (r18 != null) goto L32;
        View r19 = LayoutInflater.from(r1.g.getContext()).inflate(2131567492, r1.g, false);
        if (r19 == null) goto L37;
        r1.g.addView(r19);
        r1.a = r19;
        r1.b = r19.findViewById(2131362238);
        r1.c = r19.findViewById(2131362235);
        r1.d = r19.findViewById(2131362236);
        r19.setOnClickListener(new n(r1, r17));
        goto L37
    L32:
        if (r18.getParent() != null) goto L37;
        r1.g.addView(r1.a);
    L37:
        m r20 = this.a;
        if (r20.a != null) goto L40;
        return;
    L40:
        if (r13.isEmpty() == false) goto L50;
        View r110 = r20.b;
        if (r110 == null) goto L44;
        UtilityKotlinExtentionsKt.t(r110);
    L44:
        View r111 = r20.c;
        if (r111 == null) goto L47;
        UtilityKotlinExtentionsKt.w(r111);
    L47:
        View r112 = r20.d;
        if (r112 == null) goto L64;
        UtilityKotlinExtentionsKt.w(r112);
        return;
    L64:
        return;
    L50:
        View r113 = r20.b;
        if (r113 == null) goto L53;
        UtilityKotlinExtentionsKt.w(r113);
    L53:
        View r114 = r20.c;
        if (r114 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r114);
    L56:
        View r115 = r20.d;
        if (r115 == null) goto L66;
        UtilityKotlinExtentionsKt.t(r115);
        return;
    }
}

package com.bytedance.android.live.effect.composer;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/composer/n;", "node", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "invoke", "(Lcom/bytedance/android/live/effect/composer/n;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "restoreSticker"}, k = 3, mv = {1, 4, 3})
final class LiveComposerManagerB$restoreEffect$1 extends Lambda implements Function2<n, Sticker, Unit> {
    final /* synthetic */ String $panel;
    final /* synthetic */ String $parentResId;
    final /* synthetic */ LiveComposerManagerB this$0;

    public LiveComposerManagerB$restoreEffect$1(LiveComposerManagerB r1, String r2, String r3) {
        this.this$0 = r1;
        this.$parentResId = r2;
        this.$panel = r3;
        super(2);
    }

    public final void invoke(n r18, Sticker r19) {
        Intrinsics.checkNotNullParameter(r18, "node");
        Intrinsics.checkNotNullParameter(r19, "sticker");
        r19.setParentResId(this.$parentResId);
        Iterator r2 = ((ArrayList) r18.i).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r19.getUpdateKeys().add(((p) r2.next()).b);
        goto L4
    L6:
        Iterator r3 = ((ArrayList) r18.i).iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if (((p) r4).a == null) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L8;
    L17:
        if (r4 == null) goto L35;
        LiveComposerManagerB.c0(this.this$0, this.$panel, r19, false, r18.j, Long.valueOf(r18.g), "_restoreEffect", r18.l, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 256);
        List<p> r6 = r18.i;
        ArrayList r7 = new ArrayList();
        Iterator r8 = ((ArrayList) r6).iterator();
    L20:
        if (r8.hasNext() == false) goto L27;
        Object r9 = r8.next();
        if (((p) r9).a == null) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L20;
        r7.add(r9);
        goto L20
    L24:
        r11 = false;
        goto L25
    L27:
        Iterator r12 = r7.iterator();
    L29:
        if (r12.hasNext() == false) goto L51;
        p r13 = (p) r12.next();
        LiveComposerManagerB r14 = this.this$0;
        String r15 = this.$panel;
        String r16 = r13.b;
        Float r17 = r13.a;
        if (r17 == null) goto L33;
        float r21 = r17.floatValue();
    L34:
        LiveComposerManagerB.m0(r14, r15, r19, r16, r21, r18.l, Long.valueOf(r18.g), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 64);
        goto L29
    L33:
        r21 = 0.0f;
        goto L34
    L51:
        return;
    L35:
        LiveComposerManagerB r22 = this.this$0;
        String r23 = this.$panel;
        boolean r24 = r18.j;
        LiveComposerManagerB.c0(r22, r23, r19, r24, r24, Long.valueOf(r18.g), "_restoreEffect", r18.l, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), 256);
        return;
    L12:
        r5 = false;
        goto L13
    L15:
        r4 = null;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((n) r1, (Sticker) r2);
        return Unit.INSTANCE;
    }
}

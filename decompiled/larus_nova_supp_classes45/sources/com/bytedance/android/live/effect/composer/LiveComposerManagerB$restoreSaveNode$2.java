package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"doRestoreSaveNode", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveComposerManagerB$restoreSaveNode$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $allSticker;
    final /* synthetic */ Function1 $isDownload;
    final /* synthetic */ String $panel;
    final /* synthetic */ LiveComposerManagerB this$0;

    public LiveComposerManagerB$restoreSaveNode$2(LiveComposerManagerB r1, List r2, String r3, Function1 r4) {
        this.this$0 = r1;
        this.$allSticker = r2;
        this.$panel = r3;
        this.$isDownload = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m741invoke() {
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_RESTORE_MULTI_THREAD_ERROR.getValue().booleanValue() == false) goto L5;
        this.this$0.getClass();
    L5:
        List r0 = this.$allSticker;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L19;
        Effect r3 = (Effect) r2.next();
        List r4 = this.$allSticker;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(r3.getResourceId(), ((Effect) r7).getResourceId()) == false) goto L10;
        r5.add(r7);
        goto L10
    L14:
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r8.add(((Effect) r9.next()).getEffectId());
        goto L16
    L18:
        r1.add(new Pair(r3, r8));
        goto L7
    L19:
        Iterator r11 = r1.iterator();
    L21:
        if (r11.hasNext() == false) goto L50;
        Pair r12 = (Pair) r11.next();
        Effect r13 = (Effect) r12.getFirst();
        if (r13.getEffectType() != 1) goto L49;
        if (CollectionUtils.isEmpty(r13.getChildEffects()) == true) goto L49;
        List r14 = r13.getChildEffects();
        if (r14 == null) goto L21;
        List r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L30:
        if (r17.hasNext() == false) goto L45;
        Effect r18 = (Effect) r17.next();
        List r19 = r13.getChildEffects();
        if (r19 == null) goto L43;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r19.iterator();
    L35:
        if (r22.hasNext() == false) goto L39;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(r18.getResourceId(), ((Effect) r23).getResourceId()) == false) goto L35;
        r21.add(r23);
        goto L35
    L39:
        Collection r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r25 = r21.iterator();
    L41:
        if (r25.hasNext() == false) goto L44;
        r24.add(((Effect) r25.next()).getEffectId());
    L44:
        r16.add(new Pair(r18, r24));
        goto L30
    L43:
        r24 = CollectionsKt.emptyList();
        goto L44
    L45:
        Iterator r26 = r16.iterator();
    L47:
        if (r26.hasNext() == false) goto L21;
        Pair r27 = (Pair) r26.next();
        LiveComposerManagerB.X(this.this$0, this.$panel, (Effect) r27.getFirst(), r13.getResourceId(), (List) r27.getSecond(), this.$isDownload);
    L49:
        LiveComposerManagerB.X(this.this$0, this.$panel, r13, null, (List) r12.getSecond(), this.$isDownload);
        goto L21
    L50:
        LiveComposerManagerB r28 = this.this$0;
        int r29 = LiveComposerManagerB.H;
        r28.getClass();
        CopyOnWriteArrayList<n> r31 = this.this$0.j;
        ArrayList r32 = new ArrayList();
        Iterator<T> r33 = r31.iterator();
    L52:
        if (r33.hasNext() == false) goto L57;
        Object r34 = r33.next();
        if (Intrinsics.areEqual(((n) r34).a, this.$panel) == false) goto L52;
        r32.add(r34);
        goto L52
    L57:
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_RESTORE_MULTI_THREAD_ERROR.getValue().booleanValue() == false) goto L59;
        this.this$0.getClass();
    L59:
        this.this$0.j.removeAll(r32);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m741invoke();
        return Unit.INSTANCE;
    }
}

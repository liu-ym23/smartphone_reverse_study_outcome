package com.larus.photopicker.v2.impl.data;

import android.net.Uri;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/photopicker/v2/impl/data/model/MediaFolder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.ContentResolverMediaSource$loadMediaFolders$2", f = "ContentResolverMediaSource.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"foldersMap"}, s = {"L$0"})
public final class ContentResolverMediaSource$loadMediaFolders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends mp9.b>>, Object> {
    final /* synthetic */ List<MediaTab> $allTabs;
    final /* synthetic */ mp9.a $filter;
    Object L$0;
    int label;
    final /* synthetic */ ContentResolverMediaSource this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ContentResolverMediaSource$loadMediaFolders$2(ContentResolverMediaSource r1, mp9.a r2, List<? extends MediaTab> r3, Continuation<? super ContentResolverMediaSource$loadMediaFolders$2> r4) {
        this.this$0 = r1;
        this.$filter = r2;
        this.$allTabs = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ContentResolverMediaSource$loadMediaFolders$2(this.this$0, this.$filter, this.$allTabs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<mp9.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Map r3 = (Map) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object r4 = r26;
    L12:
        List r5 = (List) r4;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        Long r9 = Boxing.boxLong(((mp9.c) r8).e);
        Object r10 = r6.get(r9);
        if (r10 != null) goto L18;
        r10 = new ArrayList();
        r6.put(r9, r10);
    L18:
        ((List) r10).add(r8);
        goto L14
    L19:
        int r11 = e0.a;
        e0.d(this.this$0.c, "loadMediaFolders: 2.folder count: " + r6.size());
        List<MediaTab> r12 = this.$allTabs;
        ContentResolverMediaSource r13 = this.this$0;
        Iterator r14 = r6.entrySet().iterator();
    L21:
        if (r14.hasNext() == false) goto L40;
        Map.Entry r15 = (Map.Entry) r14.next();
        long r16 = ((Number) r15.getKey()).longValue();
        List r17 = (List) r15.getValue();
        Iterator r18 = r17.iterator();
        if (r18.hasNext() == true) goto L25;
        Object r19 = null;
    L34:
        mp9.c r20 = (mp9.c) r19;
        String r110 = ((mp9.c) CollectionsKt.first(r17)).f;
        Map<MediaTab, Integer> r111 = mp9.d.b(r17, r12);
        Long r21 = Boxing.boxLong(r16);
        if (r20 == null) goto L37;
        Uri r112 = r20.b;
    L38:
        r3.put(r21, new mp9.b(r16, r110, r112, r17.size(), r111, mp9.d.a(r17, r12, r13.b.b)));
        goto L21
    L37:
        r112 = null;
        goto L38
    L25:
        r19 = r18.next();
        if (r18.hasNext() == false) goto L34;
        long r113 = ((mp9.c) r19).h;
    L29:
        Object r114 = r18.next();
        Iterator r115 = r18;
        long r22 = ((mp9.c) r114).h;
        if (r113 >= r22) goto L33;
        r113 = r22;
        r19 = r114;
    L33:
        if (r115.hasNext() == false) goto L34;
        r18 = r115;
        goto L29
    L40:
        String r23 = this.this$0.a.getString(2131899716);
        mp9.c r24 = (mp9.c) CollectionsKt.firstOrNull(r5);
        if (r24 == null) goto L43;
        Uri r25 = r24.b;
    L44:
        mp9.b r27 = new mp9.b(-1, r23, r25, r5.size(), mp9.d.b(r5, this.$allTabs), mp9.d.a(r5, this.$allTabs, this.this$0.b.b));
        int r28 = e0.a;
        e0.d(this.this$0.c, "loadMediaFolders: 3.create All media folders, media count: " + r27.d + ", media count map: " + r27.e);
        List r29 = CollectionsKt.plus(CollectionsKt.listOf(r27), r3.values());
        e0.d(this.this$0.c, "loadMediaFolders: 4.End load media folders, folder count: " + r29.size());
        return r29;
    L43:
        r25 = null;
        goto L44
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        int r30 = e0.a;
        e0.d(this.this$0.c, "loadMediaFolders: 1.Start load media folders");
        LinkedHashMap r31 = new LinkedHashMap();
        ContentResolverMediaSource r32 = this.this$0;
        int r33 = r32.b.b;
        mp9.a r34 = this.$filter;
        this.L$0 = r31;
        this.label = 1;
        r4 = r32.c(-1, r33, r34, this);
        if (r4 != r1) goto L11;
        return r1;
    L11:
        r3 = r31;
        goto L12
    }
}

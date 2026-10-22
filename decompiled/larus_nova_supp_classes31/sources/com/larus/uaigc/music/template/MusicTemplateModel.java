package com.larus.uaigc.music.template;

import com.larus.bmhome.music.protocol.ListMusicGenTemplateApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class MusicTemplateModel {
    public final long a;
    public ad9.d.a b;
    public com.larus.bmhome.music.protocol.c c;

    public MusicTemplateModel() {
        this.a = RandomKt.Random(System.currentTimeMillis()).nextLong();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.uaigc.music.template.x] */
    public final Object b(Continuation<? super Unit> r12) {
        if ((r12 instanceof MusicTemplateModel$preFetch$1) == false) goto L7;
        MusicTemplateModel$preFetch$1 r0 = (MusicTemplateModel$preFetch$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MusicTemplateModel$preFetch$1 r8 = r0;
        Object r13 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        com.larus.bmhome.music.protocol.c r10 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == false) goto L35;
        dm9.a.b r15 = r14;
        if (r15.a.isSuccess() == false) goto L33;
        int r5 = 0;
        ad9.d.a r4 = new ad9.d.a(String.valueOf(this.a), false, new x(), 2);
        com.larus.bmhome.music.protocol.c r16 = (com.larus.bmhome.music.protocol.c) r15.a.getData();
        if (r16 == null) goto L32;
        List r6 = r16.c();
        if (r6 == null) goto L31;
        List r7 = CollectionsKt.filterNotNull(r6);
        if (r7 == null) goto L31;
        Iterator r9 = r7.iterator();
    L29:
        if (r9.hasNext() == false) goto L31;
        bq8.a r11 = (bq8.a) r9.next();
        int r17 = r5 + 1;
        String r18 = String.valueOf(r5);
        r4.a(r11, r18);
        com.larus.bmhome.music.player.b.a r19 = com.larus.bmhome.music.player.b.a;
        String r20 = r4.a;
        r19.getClass();
        com.larus.bmhome.music.player.b.a.c(r20, r18, r11);
        r5 = r17;
    L31:
        r10 = r16;
    L32:
        this.c = r10;
        this.b = r4;
        FLogger.a.i("MusicTemplateRepository", "success in fetch template list ");
    L38:
        return Unit.INSTANCE;
    L33:
        FLogger.a.e("MusicTemplateRepository", "failed in fetch template list code " + r15.a.getCode() + " message " + r15.a.getMsg());
        goto L38
    L35:
        if ((r14 instanceof dm9.a.a) == false) goto L38;
        FLogger.a.e("MusicTemplateRepository", "failed in fetch template list remote " + ((dm9.a.a) r14).c);
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        ListMusicGenTemplateApi.a r110 = ListMusicGenTemplateApi.a;
        MusicTemplateModel$preFetch$result$1 r21 = new MusicTemplateModel$preFetch$result$1(this, null);
        r8.label = 1;
        r110.getClass();
        FlowHttpConnection r111 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Social", ListMusicGenTemplateApi.class, r21, false, null, null, null, r8, 248);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new MusicTemplateModel$preFetch$1(this, r12);
        goto L8
    }

    public final Object a(int r12, Continuation<? super com.larus.bmhome.music.protocol.c> r13) {
        if ((r13 instanceof MusicTemplateModel$fetchNextInternal$1) == false) goto L7;
        MusicTemplateModel$fetchNextInternal$1 r0 = (MusicTemplateModel$fetchNextInternal$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MusicTemplateModel$fetchNextInternal$1 r8 = r0;
        Object r14 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r12 = r8.I$0;
        ResultKt.throwOnFailure(r14);
    L17:
        dm9.a.b r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L41;
        dm9.a.b r16 = r15;
        if (r16.a.isSuccess() == false) goto L39;
        FLogger.a.i("MusicTemplateRepository", "success in fetch template list ");
        com.larus.bmhome.music.protocol.c r17 = (com.larus.bmhome.music.protocol.c) r16.a.getData();
        if (r17 == null) goto L47;
        List r4 = r17.c();
        if (r4 == null) goto L38;
        List r5 = CollectionsKt.filterNotNull(r4);
        if (r5 == null) goto L38;
        Iterator r6 = r5.iterator();
    L29:
        if (r6.hasNext() == false) goto L38;
        bq8.a r7 = (bq8.a) r6.next();
        int r9 = r12 + 1;
        String r18 = String.valueOf(r12);
        ad9.d.a r10 = this.b;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("playListDecorator");
        r10 = null;
    L33:
        r10.a(r7, r18);
        com.larus.bmhome.music.player.b.a r11 = com.larus.bmhome.music.player.b.a;
        ad9.d.a r19 = this.b;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("playListDecorator");
        r19 = null;
    L36:
        String r20 = r19.a;
        r11.getClass();
        com.larus.bmhome.music.player.b.a.c(r20, r18, r7);
        r12 = r9;
    L38:
        return r17;
    L47:
        return null;
    L39:
        FLogger.a.e("MusicTemplateRepository", "failed in fetch template list code " + r16.a.getCode() + " message " + r16.a.getMsg());
    L43:
        return null;
    L41:
        if ((r15 instanceof dm9.a.a) == false) goto L43;
        FLogger.a.e("MusicTemplateRepository", "failed in fetch template list remote " + ((dm9.a.a) r15).c);
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        ListMusicGenTemplateApi.a r110 = ListMusicGenTemplateApi.a;
        MusicTemplateModel$fetchNextInternal$result$1 r21 = new MusicTemplateModel$fetchNextInternal$result$1(this, r12, null);
        r8.I$0 = r12;
        r8.label = 1;
        r110.getClass();
        FlowHttpConnection r111 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Social", ListMusicGenTemplateApi.class, r21, false, null, null, null, r8, 248);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new MusicTemplateModel$fetchNextInternal$1(this, r13);
        goto L8
    }
}

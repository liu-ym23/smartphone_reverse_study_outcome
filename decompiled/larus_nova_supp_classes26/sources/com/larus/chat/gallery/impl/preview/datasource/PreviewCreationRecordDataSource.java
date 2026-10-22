package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewCreationRecordDataSource implements IGalleryDataSource<xy8.d> {
    public static final /* synthetic */ int c = 0;
    public final com.larus.chat.gallery.api.i a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public final boolean h() {
        return false;
    }

    public final int k() {
        return 20;
    }

    public final boolean b() {
        return IAIChatUgcAIGCService.a.U();
    }

    public static boolean o(UserCreation r6) {
        String r0 = r6.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r4 = null;
        if (zp9.d.f(r6) == false) goto L20;
        UserCreationContent r7 = r6.e;
        if (r7 == null) goto L14;
        VideoUserContent r8 = r7.e;
        if (r8 == null) goto L14;
        VideoInfo r9 = r8.a;
        if (r9 == null) goto L14;
        r4 = r9.a;
    L14:
        if (r4 != null) goto L16;
    L17:
        r1 = true;
    L19:
        return !r1;
    L16:
        if (r4.length() != 0) goto L19;
    L20:
        UserCreationContent r2 = r6.e;
        if (r2 == null) goto L26;
        UserCreationImage r5 = r2.a;
        if (r5 == null) goto L26;
        ImageInfo r10 = r5.a;
        if (r10 == null) goto L26;
    L37:
        if (r10 == null) goto L42;
        Image r3 = r10.c;
        if (r3 == null) goto L42;
        String r11 = r3.a;
        if (r11 == null) goto L42;
    L50:
        if (r11.length() != 0) goto L52;
        boolean r12 = true;
    L53:
        if (r12 == true) goto L55;
    L56:
        return true;
    L55:
        if (s(r6, r0, 1, true) != null) goto L56;
        return false;
    L52:
        r12 = false;
    L42:
        if (r10 == null) goto L46;
        Image r13 = r10.a;
        if (r13 == null) goto L46;
        r4 = r13.a;
    L46:
        if (r4 != null) goto L48;
        r11 = r6.j();
        goto L50
    L48:
        r11 = r4;
    L26:
        if (r2 == null) goto L30;
        UserCreationUserAvatar r14 = r2.c;
        if (r14 == null) goto L30;
        r10 = r14.a;
    L31:
        if (r10 != null) goto L37;
        if (r2 == null) goto L36;
        AiBeautifyUserContent r15 = r2.d;
        if (r15 == null) goto L36;
        r10 = r15.a;
    L36:
        r10 = null;
    L30:
        r10 = null;
        goto L31
    }

    public static Object u(List r5) {
        if (IAIChatUgcAIGCService.a.U() == true) goto L5;
        return r5;
    L5:
        List r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        xy8.d r1 = (xy8.d) r7.next();
        UserCreation r2 = r1.n;
        if (r2 == null) goto L15;
        xy8.d r3 = q(r2, r1.q, true);
        if (r3 == null) goto L15;
        r1 = r3;
    L15:
        r0.add(r1);
        goto L7
    L16:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Set] */
    public final Object c(Continuation<? super b0<? extends List<xy8.d>>> r7) {
        FLogger r8 = FLogger.a;
        r8.i("PreviewCreationRecordDS", "loadInitial, selectCreationId=" + this.b);
        List<UserCreation> r0 = this.a.a();
        List<UserCreation> r2 = r0;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        r8.e("PreviewCreationRecordDS", "loadInitial: creations is empty");
        return new b0.a(new IllegalStateException("creations is empty"), false);
    L12:
        Iterator<UserCreation> r9 = r0.iterator();
        int r1 = 0;
    L14:
        if (r9.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r9.next().a, this.b) == true) goto L20;
        r1 = r1 + 1;
    L20:
        int r10 = RangesKt.coerceAtLeast(r1, 0);
        int r5 = RangesKt.coerceAtLeast(r10 - 3, 0);
        int r11 = RangesKt.coerceAtMost(r10 + 3, CollectionsKt.getLastIndex(r0));
        if (IAIChatUgcAIGCService.a.U() == false) goto L28;
        List<UserCreation> r12 = r0.subList(r5, r11 + 1);
        final ?? r6 = new HashSet();
        Iterator r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L29;
        String r14 = ((UserCreation) r13.next()).a;
        if (r14 == null) goto L24;
        r6.add(r14);
    L29:
        List r15 = r(r0, CollectionsKt.emptyList(), new k(r6));
        Integer r16 = (Integer) this.a.d().getValue();
        if (r16 == null) goto L37;
        if (r16.intValue() != 1) goto L37;
        r3 = false;
    L37:
        return new b0.b(r15, r3, false);
    L28:
        r6 = SetsKt.emptySet();
        goto L29
    L19:
        r1 = -1;
        goto L20
    L5:
        if (r2.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final Object p(Continuation r8) {
        if ((r8 instanceof PreviewCreationRecordDataSource$loadMore$1) == false) goto L7;
        PreviewCreationRecordDataSource$loadMore$1 r0 = (PreviewCreationRecordDataSource$loadMore$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r4 = r0.I$0;
        ResultKt.throwOnFailure(r9);
    L22:
        g r10 = (g) r9;
        if ((r10 instanceof g.c) == false) goto L29;
        List<UserCreation> r11 = this.a.a();
        if (r11 != null) goto L27;
        r11 = CollectionsKt.emptyList();
    L27:
        List<UserCreation> r12 = r11;
        List r5 = CollectionsKt.drop(r12, r4);
        final boolean r6 = IAIChatUgcAIGCService.a.U();
        return new b0.b(r(r5, CollectionsKt.take(r12, r4), new i(r6)), true, false, 4);
    L29:
        if ((r10 instanceof g.a) == false) goto L35;
        List<UserCreation> r13 = this.a.a();
        if (r13 != null) goto L33;
        r13 = CollectionsKt.emptyList();
    L33:
        List<UserCreation> r14 = r13;
        List r7 = CollectionsKt.drop(r14, r4);
        final boolean r15 = IAIChatUgcAIGCService.a.U();
        return new b0.b(r(r7, CollectionsKt.take(r14, r4), new j(r15)), false, false, 4);
    L35:
        if ((r10 instanceof g.b) == false) goto L38;
        return new b0.a(new RuntimeException("loadMore error"), true);
    L38:
        if ((r10 instanceof g.d) == false) goto L42;
        FLogger.a.e("PreviewCreationRecordDS", "loadMore timeout");
        return new b0.a(new RuntimeException("loadMore timeout"), true);
    L42:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("PreviewCreationRecordDS", "loadMore");
        List<UserCreation> r16 = this.a.a();
        if (r16 == null) goto L17;
        int r17 = r16.size();
    L18:
        r0.I$0 = r17;
        r0.label = 1;
        Object r18 = l(r17, r0);
        if (r18 != r2) goto L21;
        return r2;
    L21:
        r4 = r17;
        r9 = r18;
        goto L22
    L17:
        r17 = 0;
    L7:
        r0 = new PreviewCreationRecordDataSource$loadMore$1(this, r8);
        goto L8
    }

    public final com.larus.gallery.api.k v(xy8.d r25) {
        GalleryType r1 = r25.e;
        xy8.b r2 = r25.c;
        nr9.f r3 = null;
        if (r2 == null) goto L26;
        String r5 = r2.a;
        String r6 = r2.b;
        Integer r7 = Integer.valueOf(r2.i);
        Integer r8 = Integer.valueOf(r2.j);
        z2 r4 = z2.a;
        boolean r9 = true;
        if (r4.getCreationPreviewPerformanceOptConfig().b == false) goto L16;
        com.larus.platform.model.chat.n r10 = r4.getCreationPreviewPerformanceOptConfig();
        if (r10.b == true) goto L9;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == true) goto L16;
        boolean r12 = true;
    L17:
        Boolean r13 = Boolean.valueOf(r12);
        com.larus.platform.model.chat.n r14 = r4.getCreationPreviewPerformanceOptConfig();
        if (r14.b == true) goto L20;
    L24:
        r9 = false;
    L25:
        com.larus.gallery.api.m r15 = new com.larus.gallery.api.m(r5, r6, r7, r8, r13, Boolean.valueOf(r9), Integer.valueOf(r4.getCreationPreviewPerformanceOptConfig().c), 144);
    L27:
        xy8.g r0 = r25.d;
        if (r0 == null) goto L34;
        String r16 = r0.a;
        String r17 = r0.g;
        String r18 = r0.b;
        String r19 = r0.c;
        double r20 = r0.l;
        String r110 = r0.f;
        String r21 = r0.d;
        if (r21 == null) goto L32;
        r3 = new nr9.f(r21, r21, null, null, null, null, 60);
    L32:
        r3 = new com.larus.gallery.api.q(r16, new nr9.g(r16, r17, r18, r19, Double.valueOf(r20), null, r3, r110, null, null, 800), r0.m, "ugc_video", "immersive_preview", 32);
    L34:
        return new com.larus.gallery.api.k(r1, r15, r3, null, null, 8);
    L20:
        if (r14.c <= 0) goto L24;
        if (r4.a2() == false) goto L24;
    L9:
        if (r10.c <= 0) goto L13;
        if (r4.a2() == false) goto L13;
        r11 = true;
    L16:
        r12 = false;
        goto L17
    L26:
        r15 = null;
        goto L27
    }

    public PreviewCreationRecordDataSource(com.larus.chat.gallery.api.i r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "dataBridge");
        Intrinsics.checkNotNullParameter(r3, "selectCreationId");
        this.a = r2;
        this.b = r3;
    }

    public static xy8.e m(UserCreation r13, String r14) {
        Integer r3 = Integer.valueOf(r13.b);
        CreationDynamicInfo r0 = r13.h;
        if (r0 == null) goto L5;
        String r4 = r0.d;
    L6:
        UserCreationRefContent r1 = r13.o;
        if (r1 == null) goto L9;
        String r5 = HttpExtKt.p(r1);
    L10:
        UserCreationContent r2 = r13.e;
        if (r2 == null) goto L19;
        VideoContentFromChat r6 = r2.f;
        if (r6 == null) goto L19;
        String r7 = r6.a;
        if (r7 == null) goto L19;
        if ((!StringsKt.isBlank(r7)) == false) goto L19;
        String r8 = r7;
    L20:
        String r10 = r13.k();
        Integer r15 = r13.d;
        if (r15 != null) goto L24;
    L26:
        boolean r11 = false;
    L28:
        return new xy8.e(r14, r3, r4, r5, r8, null, null, null, r10, r11, 736);
    L24:
        if (r15.intValue() != 1) goto L26;
        r11 = true;
    L19:
        r8 = null;
        goto L20
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static Map n(UserCreation r2, boolean r3) {
        Pair[] r0 = new Pair[3];
        String r4 = r2.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0[0] = TuplesKt.to("creation_id", r4);
        if (r3 == false) goto L8;
        String r5 = "video_detail";
    L9:
        r0[1] = TuplesKt.to("current_page", r5);
        r0[2] = TuplesKt.to("enter_from", "creation_record");
        return MapsKt.mapOf(r0);
    L8:
        r5 = "picture_detail";
        goto L9
    }

    public final /* bridge */ /* synthetic */ Object d(Object r1, Continuation r2) {
        xy8.d r3 = (xy8.d) r1;
        return p(r2);
    }

    public final Object e(List<xy8.d> r5, Continuation<? super List<Pair<xy8.d, com.larus.gallery.api.k>>> r6) {
        if ((r6 instanceof PreviewCreationRecordDataSource$refreshDisplayItems$1) == false) goto L7;
        PreviewCreationRecordDataSource$refreshDisplayItems$1 r0 = (PreviewCreationRecordDataSource$refreshDisplayItems$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        List r8 = (List) r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        xy8.d r4 = (xy8.d) r10.next();
        r9.add(TuplesKt.to(r4, v(r4)));
        goto L19
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        r7 = u(r5);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new PreviewCreationRecordDataSource$refreshDisplayItems$1(this, r6);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object f(Object r1, Continuation r2) {
        return t((xy8.d) r1, r2);
    }

    public final Object g(Object r3, Continuation r4) {
        xy8.d r5 = (xy8.d) r3;
        return new b0.b(CollectionsKt.emptyList(), false, false, 2);
    }

    public final Object i(Object r1, Continuation r2) {
        return v((xy8.d) r1);
    }

    public final boolean j(Object r2, Object r3) {
        xy8.d r4 = (xy8.d) r2;
        xy8.d r5 = (xy8.d) r3;
        Intrinsics.checkNotNullParameter(r4, "first");
        Intrinsics.checkNotNullParameter(r5, "second");
        return Intrinsics.areEqual(r4.b, r5.b);
    }

    public final Object l(int r5, Continuation<? super g> r6) {
        if ((r6 instanceof PreviewCreationRecordDataSource$awaitLoadMore$1) == false) goto L7;
        PreviewCreationRecordDataSource$awaitLoadMore$1 r0 = (PreviewCreationRecordDataSource$awaitLoadMore$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        g r8 = (g) r7;
        if (r8 == null) goto L20;
        return r8;
    L20:
        return g.d.a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        PreviewCreationRecordDataSource$awaitLoadMore$2 r9 = new PreviewCreationRecordDataSource$awaitLoadMore$2(this, r5, null);
        r0.label = 1;
        r7 = TimeoutKt.c(10000, r9, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new PreviewCreationRecordDataSource$awaitLoadMore$1(this, r6);
        goto L8
    }

    public final Object t(xy8.d r5, Continuation<? super xy8.d> r6) {
        if ((r6 instanceof PreviewCreationRecordDataSource$refreshOriginalData$1) == false) goto L7;
        PreviewCreationRecordDataSource$refreshOriginalData$1 r0 = (PreviewCreationRecordDataSource$refreshOriginalData$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (xy8.d) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        xy8.d r8 = (xy8.d) CollectionsKt.firstOrNull((List) r7);
        if (r8 != null) goto L21;
        return r5;
    L21:
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        List r9 = CollectionsKt.listOf(r5);
        r0.L$0 = r5;
        r0.label = 1;
        r7 = u(r9);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new PreviewCreationRecordDataSource$refreshOriginalData$1(this, r6);
        goto L8
    }

    public static xy8.d q(UserCreation r48, int r49, boolean r50) {
        String r1 = r48.a;
        Integer r2 = null;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (zp9.d.f(r48) == false) goto L147;
        UserCreationContent r3 = r48.e;
        if (r3 == null) goto L10;
        VideoUserContent r4 = r3.e;
    L11:
        if (r4 == null) goto L13;
        VideoInfo r5 = r4.a;
    L14:
        if (r5 == null) goto L16;
        String r6 = r5.a;
    L18:
        if (r6 != null) goto L20;
    L23:
        boolean r8 = true;
    L24:
        if (r8 == true) goto L149;
        if (r4 == null) goto L31;
        ImageInfo r9 = r4.b;
        if (r9 == null) goto L31;
        Image r10 = r9.c;
        if (r10 == null) goto L31;
    L42:
        if (r10 == null) goto L50;
        String r11 = r10.a;
        if (r11 == null) goto L50;
        if ((!StringsKt.isBlank(r11)) == true) goto L49;
        r11 = null;
    L49:
        if (r11 == null) goto L50;
    L59:
        String r12 = r5.f;
        String r13 = r5.b;
        String r14 = r5.c;
        Double r15 = r5.d;
        String r16 = r5.e;
        long r28 = 0;
        if (r10 == null) goto L70;
        Long r7 = Long.valueOf(r10.c);
        if (r7.longValue() <= 0) goto L64;
        boolean r17 = true;
    L65:
        if (r17 == true) goto L68;
        r7 = null;
    L68:
        if (r7 == null) goto L70;
        Integer r21 = Integer.valueOf((int) r7.longValue());
    L71:
        if (r10 == null) goto L81;
        Long r18 = Long.valueOf(r10.d);
        if (r18.longValue() <= 0) goto L75;
        boolean r19 = true;
    L76:
        if (r19 == true) goto L79;
        r18 = null;
    L79:
        if (r18 == null) goto L81;
        Integer r20 = Integer.valueOf((int) r18.longValue());
    L82:
        nr9.g r22 = new nr9.g(r6, r12, r13, r14, r15, r16, new nr9.f(r11, r11, null, r20, r21, null, 36), null, null, null, 896);
        if (r50 == false) goto L92;
        IAIChatUgcAIGCService.Companion r0 = IAIChatUgcAIGCService.a;
        if (r4 == null) goto L87;
        ImageInfo r23 = r4.b;
    L88:
        nr9.g r24 = r0.D0(r6, r22, r0.Z(r23));
        if (r24 == null) goto L92;
        r22 = r24;
        goto L92
    L87:
        r23 = null;
    L92:
        SourceType r25 = SourceType.CREATION_RECORD;
        String r26 = "record_".concat(r1);
        String r27 = r22.a;
        if (r27 != null) goto L95;
        String r31 = r6;
    L96:
        String r29 = r22.c;
        String r110 = r22.d;
        nr9.f r111 = r22.g;
        if (r111 == null) goto L102;
        String r112 = r111.b;
        if (r112 == null) goto L102;
        String r34 = r112;
    L103:
        String r30 = r22.b;
        if (r111 == null) goto L116;
        Integer r113 = r111.e;
        if (r113 == null) goto L116;
        if (r113.intValue() <= 0) goto L110;
        boolean r114 = true;
    L111:
        if (r114 == true) goto L114;
        r113 = null;
    L114:
        if (r113 == null) goto L116;
        int r40 = r113.intValue();
    L117:
        nr9.f r115 = r22.g;
        if (r115 == null) goto L129;
        Integer r116 = r115.d;
        if (r116 == null) goto L129;
        if (r116.intValue() <= 0) goto L124;
        boolean r117 = true;
    L125:
        if (r117 == false) goto L127;
        r2 = r116;
    L127:
        if (r2 == null) goto L129;
        int r41 = r2.intValue();
    L130:
        Double r32 = r22.e;
        if (r32 != null) goto L135;
        r32 = r5.d;
        if (r32 != null) goto L135;
        double r118 = 0.0d;
    L136:
        double r42 = r118;
        String r33 = r22.f;
        String r35 = r22.a;
        if (r35 != null) goto L141;
        String r45 = r6;
    L142:
        xy8.g r36 = new xy8.g(r31, r29, r110, r34, r111, null, r30, r33, null, r40, r41, r42, null, r45, null, 45344);
        GalleryType r37 = GalleryType.Video;
        Map r38 = n(r48, true);
        String r39 = r48.k();
        Long r43 = r48.m;
        if (r43 == null) goto L148;
        r28 = r43.longValue();
    L148:
        return new xy8.d(r25, r26, null, r36, r37, r38, r39, r28, null, null, null, null, m(r48, r1), r48, null, null, r49, 52996);
    L141:
        r45 = r35;
    L135:
        r118 = r32.doubleValue();
        goto L136
    L124:
        r117 = false;
    L129:
        r41 = 0;
        goto L130
    L110:
        r114 = false;
    L116:
        r40 = 0;
    L102:
        r34 = r11;
        goto L103
    L95:
        r31 = r27;
        goto L96
    L75:
        r19 = false;
    L81:
        r20 = null;
        goto L82
    L64:
        r17 = false;
    L70:
        r21 = null;
    L50:
        if (r10 == null) goto L56;
        r11 = r10.b;
        if (r11 == null) goto L56;
        if ((!StringsKt.isBlank(r11)) == false) goto L56;
    L57:
        if (r11 != null) goto L59;
        r11 = r48.e();
    L56:
        r11 = null;
    L31:
        if (r4 == null) goto L35;
        ImageInfo r44 = r4.b;
        if (r44 == null) goto L35;
        r10 = r44.b;
    L36:
        if (r10 != null) goto L42;
        if (r4 == null) goto L41;
        ImageInfo r46 = r4.b;
        if (r46 == null) goto L41;
        r10 = r46.a;
    L41:
        r10 = null;
    L35:
        r10 = null;
        goto L36
    L149:
        return null;
    L20:
        if (r6.length() == 0) goto L23;
        r8 = false;
        goto L24
    L16:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L10:
        r4 = null;
        goto L11
    L147:
        return s(r48, r1, r49, r50);
    }

    public static List r(List r6, List r7, Function1 r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = r7.iterator();
    L3:
        int r2 = 0;
        if (r9.hasNext() == false) goto L17;
        UserCreation r1 = (UserCreation) r9.next();
        UserCreationTrackParams r3 = r1.n;
        if (r3 == null) goto L10;
        Integer r4 = r3.c;
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
    L12:
        if (o(r1) == false) goto L3;
        Integer r10 = Integer.valueOf(r5);
        Integer r11 = (Integer) r0.get(Integer.valueOf(r5));
        if (r11 == null) goto L16;
        r2 = r11.intValue();
    L16:
        r0.put(r10, Integer.valueOf(r2 + 1));
    L10:
        r5 = 0;
        goto L12
    L17:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r6.iterator();
    L19:
        if (r13.hasNext() == false) goto L33;
        UserCreation r14 = (UserCreation) r13.next();
        UserCreationTrackParams r15 = r14.n;
        if (r15 == null) goto L25;
        Integer r16 = r15.c;
        if (r16 == null) goto L25;
        int r17 = r16.intValue();
    L26:
        Integer r18 = (Integer) r0.get(Integer.valueOf(r17));
        if (r18 == null) goto L29;
        int r19 = r18.intValue();
    L30:
        int r20 = r19 + 1;
        r0.put(Integer.valueOf(r17), Integer.valueOf(r20));
        xy8.d r21 = q(r14, r20, ((Boolean) r8.invoke(r14)).booleanValue());
        if (r21 == null) goto L19;
        r12.add(r21);
        goto L19
    L29:
        r19 = 0;
    L25:
        r17 = 0;
        goto L26
    L33:
        return r12;
    }

    public static xy8.d s(UserCreation r28, String r29, int r30, boolean r31) {
        UserCreationContent r1 = r28.e;
        if (r1 == null) goto L8;
        UserCreationImage r3 = r1.a;
        if (r3 == null) goto L8;
        ImageInfo r4 = r3.a;
        if (r4 == null) goto L8;
    L19:
        if (r31 == false) goto L22;
        ImageInfo r2 = IAIChatUgcAIGCService.a.o0(r4);
        if (r2 == null) goto L22;
    L23:
        boolean r5 = true;
        if (r31 == true) goto L26;
    L28:
        boolean r22 = false;
    L29:
        if (r2 == null) goto L36;
        Image r6 = r2.c;
        if (r6 == null) goto L36;
        String r7 = r6.a;
        if (r7 == null) goto L36;
    L35:
        String r17 = r7;
        if (r17.length() != 0) goto L46;
        boolean r8 = true;
    L47:
        if (r8 == false) goto L52;
        if (r31 == true) goto L52;
        return s(r28, r29, r30, true);
    L52:
        if (r17.length() != 0) goto L54;
        boolean r9 = true;
    L55:
        if (r9 == false) goto L57;
        return null;
    L57:
        if (r2 == null) goto L67;
        Image r10 = r2.b;
        if (r10 == null) goto L67;
        String r11 = r10.a;
        if (r11 == null) goto L67;
        if ((!StringsKt.isBlank(r11)) == true) goto L66;
        r11 = null;
    L66:
        if (r11 == null) goto L67;
    L98:
        String r18 = r11;
        if (r2 == null) goto L103;
        Image r12 = r2.c;
        if (r12 == null) goto L103;
    L106:
        int r13 = (int) r12.c;
    L108:
        if (r2 == null) goto L112;
        Image r14 = r2.c;
        if (r14 == null) goto L112;
        long r15 = r14.d;
    L116:
        int r16 = (int) r15;
    L118:
        if (r4 == null) goto L122;
        Image r19 = r4.a;
        if (r19 == null) goto L122;
        String r110 = r19.a;
    L123:
        FLogger r20 = FLogger.a;
        StringBuilder r21 = new StringBuilder("mapImageCreation: creationId=");
        r21.append(r29);
        r21.append(", width=");
        r21.append(r13);
        r21.append(", height=");
        r21.append(r16);
        r21.append(", hasOrigin=");
        if (r110 != null) goto L126;
    L129:
        boolean r23 = true;
    L130:
        r21.append(!r23);
        r20.i("PreviewCreationRecordDS", r21.toString());
        LinkedHashMap r111 = new LinkedHashMap();
        if (r4 == null) goto L137;
        Image r24 = r4.c;
        if (r24 == null) goto L137;
        String r25 = r24.a;
        if (r25 == null) goto L137;
        r111.put("share_preview_url", r25);
    L137:
        if (r4 == null) goto L143;
        Image r26 = r4.a;
        if (r26 == null) goto L143;
        String r27 = r26.a;
        if (r27 == null) goto L143;
        r111.put("share_download_url", r27);
    L143:
        if (r4 == null) goto L149;
        Image r32 = r4.i;
        if (r32 == null) goto L149;
        String r33 = r32.a;
        if (r33 == null) goto L149;
        r111.put("share_raw_url", r33);
    L149:
        if (r4 == null) goto L153;
        Image r34 = r4.a;
        if (r34 == null) goto L153;
        r111.put("share_image_origin_width", String.valueOf(r34.c));
    L153:
        if (r4 == null) goto L157;
        Image r35 = r4.a;
        if (r35 == null) goto L157;
        r111.put("share_image_origin_height", String.valueOf(r35.d));
    L157:
        AuthorInfo r36 = r28.g;
        if (r36 == null) goto L162;
        String r37 = r36.b;
        if (r37 == null) goto L162;
        r111.put("share_author_uid", r37);
    L162:
        UserCreationRefContent r38 = r28.o;
        if (r38 == null) goto L165;
        boolean r39 = Intrinsics.areEqual(r38.b, Boolean.TRUE);
    L167:
        if (r28.b == 3) goto L170;
        r5 = false;
    L170:
        if (r39 == true) goto L175;
        if (r5 == true) goto L175;
        String r40 = r28.o();
        if (r40 == null) goto L175;
        r111.put("share_ref_url", r40);
    L175:
        if (r39 == false) goto L177;
        r111.put("share_disable_puzzle", "true");
    L177:
        SourceType r41 = SourceType.CREATION_RECORD;
        String r42 = "record_".concat(r29);
        if (r4 == null) goto L182;
        Image r43 = r4.i;
        if (r43 == null) goto L182;
        String r210 = r43.a;
    L183:
        Boolean r211 = Boolean.TRUE;
        if (r4 == null) goto L189;
        Image r44 = r4.a;
        if (r44 == null) goto L189;
        String r45 = r44.e;
        if (r45 == null) goto L189;
    L206:
        String r212 = r45;
    L207:
        xy8.b r46 = new xy8.b(r17, r18, r110, r210, r211, r22, r212, r13, r16, 64);
        GalleryType r47 = GalleryType.Image;
        Map r112 = n(r28, false);
        String r113 = r28.k();
        Long r48 = r28.m;
        if (r48 == null) goto L210;
        long r114 = r48.longValue();
    L212:
        return new xy8.d(r41, r42, r46, null, r47, r112, r113, r114, null, r111, IUgcAIGCService.a.H(r28, null), null, m(r28, r29), r28, null, null, r30, 51464);
    L210:
        r114 = 0;
    L189:
        if (r4 == null) goto L193;
        Image r49 = r4.c;
        if (r49 == null) goto L193;
        r45 = r49.e;
    L194:
        if (r45 != null) goto L206;
        if (r4 == null) goto L199;
        Image r50 = r4.b;
        if (r50 == null) goto L199;
        r45 = r50.e;
    L200:
        if (r45 != null) goto L206;
        if (r4 == null) goto L205;
        Image r51 = r4.i;
        if (r51 == null) goto L205;
        r212 = r51.e;
    L205:
        r212 = null;
    L199:
        r45 = null;
    L193:
        r45 = null;
    L182:
        r210 = null;
        goto L183
    L165:
        r39 = false;
        goto L167
    L126:
        if (StringsKt.isBlank(r110) == true) goto L129;
        r23 = false;
    L122:
        r110 = null;
    L112:
        if (r2 == null) goto L117;
        Image r52 = r2.a;
        if (r52 == null) goto L117;
        r15 = r52.d;
    L117:
        r16 = 0;
    L103:
        if (r2 == null) goto L107;
        r12 = r2.a;
        if (r12 != null) goto L106;
    L107:
        r13 = 0;
    L67:
        if (r2 == null) goto L75;
        Image r53 = r2.b;
        if (r53 == null) goto L75;
        r11 = r53.b;
        if (r11 == null) goto L75;
        if ((!StringsKt.isBlank(r11)) == false) goto L75;
    L76:
        if (r11 != null) goto L98;
        if (r4 == null) goto L85;
        Image r54 = r4.b;
        if (r54 == null) goto L85;
        r11 = r54.a;
        if (r11 == null) goto L85;
        if ((!StringsKt.isBlank(r11)) == false) goto L85;
    L86:
        if (r11 != null) goto L98;
        if (r4 == null) goto L95;
        Image r55 = r4.b;
        if (r55 == null) goto L95;
        r11 = r55.b;
        if (r11 == null) goto L95;
        if ((!StringsKt.isBlank(r11)) == false) goto L95;
    L96:
        if (r11 != null) goto L98;
        r11 = r28.e();
    L95:
        r11 = null;
    L85:
        r11 = null;
    L75:
        r11 = null;
        goto L76
    L54:
        r9 = false;
        goto L55
    L46:
        r8 = false;
    L36:
        if (r2 == null) goto L40;
        Image r56 = r2.a;
        if (r56 == null) goto L40;
        r7 = r56.a;
    L41:
        if (r7 != null) goto L35;
        r7 = r28.j();
    L40:
        r7 = null;
        goto L41
    L26:
        if (IAIChatUgcAIGCService.a.k0(r4) == false) goto L28;
        r22 = true;
    L22:
        r2 = r4;
    L8:
        if (r1 == null) goto L12;
        UserCreationUserAvatar r57 = r1.c;
        if (r57 == null) goto L12;
        r4 = r57.a;
    L13:
        if (r4 != null) goto L19;
        if (r1 == null) goto L18;
        AiBeautifyUserContent r58 = r1.d;
        if (r58 == null) goto L18;
        r4 = r58.a;
    L18:
        r4 = null;
    L12:
        r4 = null;
        goto L13
    }
}

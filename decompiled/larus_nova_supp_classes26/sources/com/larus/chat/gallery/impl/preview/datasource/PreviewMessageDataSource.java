package com.larus.chat.gallery.impl.preview.datasource;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageQueryRequest;
import com.larus.im.bean.message.MessageQueryResponse;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewMessageDataSource implements IGalleryDataSource<xy8.d> {
    public static final /* synthetic */ int p = 0;
    public final String a;
    public final String b;
    public final Message c;
    public final List<Message> d;
    public final int e;
    public final Integer f;
    public final Bitmap g;
    public final boolean h;
    public String i;
    public String j;
    public long k;
    public boolean l;
    public boolean m;
    public final ConcurrentHashMap.KeySetView<String, Boolean> n;
    public SourceType o;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final int k() {
        return 20;
    }

    public final boolean b() {
        return CreationNoWatermarkManager.a.D();
    }

    public final boolean h() {
        Message r0 = this.c;
        if (r0 == null) goto L7;
        h.a.getClass();
        if (h.c(r0) != true) goto L7;
        boolean r1 = true;
    L9:
        return !r1;
    L7:
        r1 = false;
        goto L9
    }

    public final List<Long> l() {
        SourceType r0 = this.o;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        return CollectionsKt.listOf(new Long[]{10200L, 20200L, 10100L, 20100L, 10300L});
    L18:
        return CollectionsKt.listOf(new Long[]{10100L, 20100L});
    L19:
        return CollectionsKt.listOf(10300L);
    L16:
        return CollectionsKt.listOf(new Long[]{10200L, 20200L});
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public final Object c(Continuation<? super b0<? extends List<xy8.d>>> r35) {
        if ((r35 instanceof PreviewMessageDataSource$loadInitial$1) == false) goto L7;
        PreviewMessageDataSource$loadInitial$1 r2 = (PreviewMessageDataSource$loadInitial$1) r35;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        PreviewMessageDataSource r7 = (PreviewMessageDataSource) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L48:
        List<xy8.d> r8 = r7.v((List) r1);
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("loadInitial success, dataList.size=");
        ArrayList r11 = (ArrayList) r8;
        r10.append(r11.size());
        r10.append(", initialSourceType=");
        r10.append(this.o);
        r10.append(", itemKeys=");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r13 = r11.iterator();
    L50:
        if (r13.hasNext() == false) goto L52;
        r12.add(((xy8.d) r13.next()).b);
        goto L50
    L52:
        r10.append(r12);
        r9.i("PreviewMessageDataSource", r10.toString());
        if (this.o == SourceType.BOT_RESP) goto L56;
        r6 = true;
    L56:
        return new b0.b(r8, r6, r6);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
    L36:
        List<xy8.d> r14 = (List) r1;
        xy8.d r15 = (xy8.d) CollectionsKt.getOrNull(r14, this.e);
        if (r15 == null) goto L40;
        SourceType r16 = r15.a;
        if (r16 == null) goto L40;
    L44:
        this.o = r16;
        r2.L$0 = this;
        r2.label = 3;
        r1 = r(r14, "gallery_initial", r2);
        if (r1 != r4) goto L47;
        return r4;
    L47:
        r7 = this;
    L40:
        xy8.d r17 = (xy8.d) CollectionsKt.firstOrNull(r14);
        if (r17 == null) goto L43;
        r16 = r17.a;
        goto L44
    L43:
        r16 = null;
        goto L44
    L17:
        ResultKt.throwOnFailure(r1);
    L29:
        Message r18 = (Message) r1;
        if (r18 != null) goto L33;
        FLogger.a.e("PreviewMessageDataSource", "loadInitial failed: selectMessage not found");
        return new b0.a(new IllegalStateException("selectMessage not found"), false);
    L33:
        this.k = r18.getCreateTime() * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        FLogger.a.i("PreviewMessageDataSource", "loadInitial, contentType=" + r18.getContentType() + ", message.createTime=" + r18.getCreateTime() + ", startTime=" + this.k + ", messageId=" + r18.getMessageId());
        r2.label = 2;
        r1 = x(r18, r2);
        if (r1 != r4) goto L36;
        return r4;
    L18:
        ResultKt.throwOnFailure(r1);
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("loadInitial, conversationId=");
        r20.append(this.a);
        r20.append(", selectMessageId=");
        r20.append(this.b);
        r20.append(", hasMessage=");
        if (this.c == null) goto L21;
        boolean r110 = true;
    L22:
        r20.append(r110);
        r19.i("PreviewMessageDataSource", r20.toString());
        r18 = this.c;
        if (r18 != null) goto L33;
        r2.label = 1;
        SafeContinuation r21 = new SafeContinuation(IntrinsicsKt.intercepted(r2));
        com.larus.im.d.e().u(new MessageQueryRequest(3, this.a, 1, Long.MAX_VALUE, 0, l(), null, 1, 1, false, MapsKt.mapOf(TuplesKt.to("target_message_id", this.b)), true, 0, null, 12368, null), new u(r21, this));
        r1 = r21.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L27:
        if (r1 != r4) goto L29;
        return r4;
    L21:
        r110 = false;
    L7:
        r2 = new PreviewMessageDataSource$loadInitial$1(this, r35);
        goto L8
    }

    public final Object m(Continuation r18) {
        if ((r18 instanceof PreviewMessageDataSource$loadMore$1) == false) goto L7;
        Continuation<? super List<xy8.d>> r1 = (PreviewMessageDataSource$loadMore$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Continuation<? super List<xy8.d>> r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        List r4 = (List) r8.L$1;
        MessageQueryResponse r5 = (MessageQueryResponse) r8.L$0;
        ResultKt.throwOnFailure(r0);
        List r6 = r4;
    L58:
        List r7 = (List) r0;
        FLogger.a.i("PreviewMessageDataSource", "loadMore: filteredMessages=" + r6.size() + ", dataList.size=" + r7.size());
        return new b0.b(r7, r5.hasMore, false, 4);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L34:
        r5 = (MessageQueryResponse) r0;
        if (r5 != null) goto L38;
        FLogger.a.e("PreviewMessageDataSource", "loadMore failed");
        return new b0.a(new RuntimeException("loadMore failed"), true);
    L38:
        this.i = r5.pageToken;
        List r10 = r5.historyMessages;
        if (r10 != null) goto L41;
        r10 = CollectionsKt.emptyList();
    L41:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("loadMore: rawMessages=");
        r12.append(r10.size());
        r12.append(", hasMore=");
        r12.append(r5.hasMore);
        r12.append(", messageIds=");
        List r13 = r10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L43:
        if (r15.hasNext() == false) goto L45;
        r14.add(((Message) r15.next()).getMessageId());
        goto L43
    L45:
        r12.append(r14);
        r12.append(", contentTypes=");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r17 = r13.iterator();
    L47:
        if (r17.hasNext() == false) goto L49;
        r16.add(Boxing.boxInt(((Message) r17.next()).getContentType()));
        goto L47
    L49:
        r12.append(r16);
        r11.i("PreviewMessageDataSource", r12.toString());
        ArrayList r19 = new ArrayList();
        Iterator r20 = r13.iterator();
    L51:
        if (r20.hasNext() == false) goto L55;
        Object r21 = r20.next();
        if ((!Intrinsics.areEqual(((Message) r21).getMessageId(), this.b)) == false) goto L51;
        r19.add(r21);
        goto L51
    L55:
        r8.L$0 = r5;
        r8.L$1 = r19;
        r8.label = 3;
        r0 = y(r19, "gallery_more", r8);
        r6 = r19;
        if (r0 != r9) goto L58;
        return r9;
    L17:
        List<Message> r22 = (List) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L27:
        List r23 = (List) r0;
        if ((!r23.isEmpty()) == false) goto L31;
        FLogger.a.i("PreviewMessageDataSource", "loadMore: loadedMessages=" + r22.size() + ", dataList.size=" + r23.size());
        return new b0.b(r23, true, false, 4);
    L31:
        FLogger.a.i("PreviewMessageDataSource", "loadMore, startTime=" + this.k + ", pageToken=" + this.i);
        long r24 = 1 + this.k;
        String r25 = this.i;
        r8.L$0 = null;
        r8.label = 2;
        r0 = p(2, r24, r25, r8);
        if (r0 != r9) goto L34;
        return r9;
    L18:
        ResultKt.throwOnFailure(r0);
        if (this.o == SourceType.BOT_RESP) goto L21;
        r22 = u(2);
        if ((!r22.isEmpty()) == false) goto L31;
        r8.L$0 = r22;
        r8.label = 1;
        r0 = y(r22, "gallery_more_loaded", r8);
        if (r0 != r9) goto L27;
        return r9;
    L21:
        return new b0.b(CollectionsKt.emptyList(), false, false, 4);
    L7:
        r1 = new PreviewMessageDataSource$loadMore$1(this, r18);
        goto L8
    }

    public final Object n(Continuation r19) {
        if ((r19 instanceof PreviewMessageDataSource$loadPrevious$1) == false) goto L7;
        Continuation<? super List<xy8.d>> r1 = (PreviewMessageDataSource$loadPrevious$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Continuation<? super List<xy8.d>> r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        List r4 = (List) r8.L$1;
        MessageQueryResponse r5 = (MessageQueryResponse) r8.L$0;
        ResultKt.throwOnFailure(r0);
        List r6 = r4;
    L58:
        List r7 = (List) r0;
        FLogger.a.i("PreviewMessageDataSource", "loadPrevious: filteredMessages=" + r6.size() + ", dataList.size=" + r7.size());
        return new b0.b(r7, false, r5.hasMore, 2);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L34:
        r5 = (MessageQueryResponse) r0;
        if (r5 != null) goto L38;
        FLogger.a.e("PreviewMessageDataSource", "loadPrevious failed");
        return new b0.a(new RuntimeException("loadPrevious failed"), true);
    L38:
        this.j = r5.pageToken;
        List r10 = r5.historyMessages;
        if (r10 != null) goto L41;
        r10 = CollectionsKt.emptyList();
    L41:
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("loadPrevious: rawMessages=");
        r12.append(r10.size());
        r12.append(", hasMore=");
        r12.append(r5.hasMore);
        r12.append(", messageIds=");
        List r13 = r10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L43:
        if (r15.hasNext() == false) goto L45;
        r14.add(((Message) r15.next()).getMessageId());
        goto L43
    L45:
        r12.append(r14);
        r12.append(", contentTypes=");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r17 = r13.iterator();
    L47:
        if (r17.hasNext() == false) goto L49;
        r16.add(Boxing.boxInt(((Message) r17.next()).getContentType()));
        goto L47
    L49:
        r12.append(r16);
        r11.i("PreviewMessageDataSource", r12.toString());
        ArrayList r18 = new ArrayList();
        Iterator r20 = r13.iterator();
    L51:
        if (r20.hasNext() == false) goto L55;
        Object r21 = r20.next();
        if ((!Intrinsics.areEqual(((Message) r21).getMessageId(), this.b)) == false) goto L51;
        r18.add(r21);
        goto L51
    L55:
        r8.L$0 = r5;
        r8.L$1 = r18;
        r8.label = 3;
        r0 = y(r18, "gallery_previous", r8);
        r6 = r18;
        if (r0 != r9) goto L58;
        return r9;
    L17:
        List<Message> r22 = (List) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L27:
        List r23 = (List) r0;
        if ((!r23.isEmpty()) == false) goto L31;
        FLogger.a.i("PreviewMessageDataSource", "loadPrevious: loadedMessages=" + r22.size() + ", dataList.size=" + r23.size());
        return new b0.b(r23, false, true, 2);
    L31:
        FLogger.a.i("PreviewMessageDataSource", "loadPrevious, startTime=" + this.k + ", pageToken=" + this.j);
        long r110 = RangesKt.coerceAtLeast(this.k - 1, 0);
        String r24 = this.j;
        r8.L$0 = null;
        r8.label = 2;
        r0 = p(1, r110, r24, r8);
        if (r0 != r9) goto L34;
        return r9;
    L18:
        ResultKt.throwOnFailure(r0);
        if (this.o == SourceType.BOT_RESP) goto L21;
        r22 = u(1);
        if ((!r22.isEmpty()) == false) goto L31;
        r8.L$0 = r22;
        r8.label = 1;
        r0 = y(r22, "gallery_previous_loaded", r8);
        if (r0 != r9) goto L27;
        return r9;
    L21:
        return new b0.b(CollectionsKt.emptyList(), false, false, 2);
    L7:
        r1 = new PreviewMessageDataSource$loadPrevious$1(this, r19);
        goto L8
    }

    public final List<Message> u(long r19) {
        if (r19 != 2) goto L6;
        boolean r3 = this.l;
        this.l = false;
    L9:
        if (r3 == false) goto L99;
        if (this.d.isEmpty() == true) goto L99;
        Iterator<Message> r4 = this.d.iterator();
        int r5 = 0;
    L15:
        if (r4.hasNext() == false) goto L37;
        Message r9 = r4.next();
        if (Intrinsics.areEqual(r9.getMessageId(), this.b) == true) goto L32;
        Message r12 = this.c;
        if (r12 == null) goto L22;
        String r13 = r12.getLocalMessageId();
    L23:
        if (r13 != null) goto L25;
    L28:
        boolean r14 = true;
    L29:
        if (r14 == false) goto L31;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == true) goto L38;
        r5 = r5 + 1;
    L38:
        if (r5 < 0) goto L45;
        if (r19 != 2) goto L42;
        List<Message> r6 = this.d.subList(0, r5);
    L96:
        FLogger.a.i("PreviewMessageDataSource", "takeLoadedMessages: direction=" + r19 + ", loaded=" + this.d.size() + ", selectedIndex=" + r5 + ", matched=" + r6.size());
        return CollectionsKt.asReversed(r6);
    L42:
        if (r19 != 1) goto L44;
        List<Message> r7 = this.d;
        r6 = r7.subList(r5 + 1, r7.size());
        goto L96
    L44:
        r6 = CollectionsKt.emptyList();
        goto L96
    L45:
        Message r8 = this.c;
        if (r8 == null) goto L48;
        List<Message> r11 = this.d;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r11.iterator();
    L51:
        if (r16.hasNext() == false) goto L95;
        Object r17 = r16.next();
        Message r18 = (Message) r17;
        Integer r20 = Integer.valueOf(ComparisonsKt.compareValues(Long.valueOf(r18.getCreateTime()), Long.valueOf(r8.getCreateTime())));
        if (r20.intValue() == 0) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == true) goto L59;
        r20 = null;
    L59:
        if (r20 == null) goto L61;
        int r21 = r20.intValue();
    L82:
        if (r19 != 2) goto L87;
        if (r21 <= 0) goto L85;
        boolean r22 = true;
    L86:
        long r111 = 1;
    L92:
        if (r22 == false) goto L51;
        r15.add(r17);
        goto L51
    L85:
        r22 = false;
        goto L86
    L87:
        r111 = 1;
        if (r19 != 1) goto L91;
        if (r21 >= 0) goto L91;
        r22 = true;
    L91:
        r22 = false;
        goto L92
    L61:
        Integer r23 = Integer.valueOf(Intrinsics.compare(r18.getLocalIndex(), r8.getLocalIndex()));
        if (r23.intValue() == 0) goto L64;
        boolean r24 = true;
    L65:
        if (r24 == true) goto L68;
        r23 = null;
    L68:
        if (r23 == null) goto L70;
        r21 = r23.intValue();
        goto L82
    L70:
        String r25 = r18.getMessageId();
        String r26 = "";
        if (r25 != null) goto L75;
        r25 = r18.getLocalMessageId();
        if (r25 != null) goto L75;
        r25 = "";
    L75:
        String r112 = r8.getMessageId();
        if (r112 != null) goto L80;
        r112 = r8.getLocalMessageId();
        if (r112 != null) goto L80;
    L81:
        r21 = r25.compareTo(r26);
    L80:
        r26 = r112;
        goto L81
    L64:
        r24 = false;
        goto L65
    L55:
        r110 = false;
        goto L56
    L95:
        r6 = r15;
        goto L96
    L48:
        return CollectionsKt.emptyList();
    L31:
        if (Intrinsics.areEqual(r9.getLocalMessageId(), r13) == false) goto L33;
    L25:
        if (r13.length() == 0) goto L28;
        r14 = false;
        goto L29
    L22:
        r13 = null;
    L32:
        r10 = true;
        goto L34
    L37:
        r5 = -1;
    L99:
        return CollectionsKt.emptyList();
    L6:
        if (r19 != 1) goto L8;
        r3 = this.m;
        this.m = false;
        goto L9
    L8:
        r3 = false;
        goto L9
    }

    public final List<xy8.d> v(List<xy8.d> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (this.n.add(((xy8.d) r1).b) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final com.larus.gallery.api.k w(xy8.d r32) {
        if (this.h == false) goto L5;
    L12:
        boolean r2 = false;
    L14:
        if (r32.a != SourceType.CREATION_CARD) goto L16;
        boolean r5 = true;
    L17:
        GalleryType r7 = r32.e;
        xy8.b r6 = r32.c;
        nr9.f r8 = null;
        if (r6 == null) goto L51;
        String r10 = r6.a;
        String r11 = r6.b;
        Integer r12 = Integer.valueOf(r6.i);
        Integer r13 = Integer.valueOf(r6.j);
        if (r2 == false) goto L35;
        z2 r9 = z2.a;
        if (r9.getCreationPreviewPerformanceOptConfig().b == false) goto L33;
        com.larus.platform.model.chat.n r14 = r9.getCreationPreviewPerformanceOptConfig();
        if (r14.b == true) goto L26;
    L30:
        boolean r15 = false;
    L31:
        if (r15 == true) goto L33;
        boolean r16 = true;
    L34:
        Boolean r17 = Boolean.valueOf(r16);
    L36:
        if (r2 == false) goto L46;
        z2 r18 = z2.a;
        com.larus.platform.model.chat.n r19 = r18.getCreationPreviewPerformanceOptConfig();
        if (r19.b == true) goto L40;
    L44:
        boolean r20 = false;
    L45:
        Boolean r110 = Boolean.valueOf(r20);
    L47:
        if (r2 == false) goto L49;
        Integer r111 = Integer.valueOf(z2.a.getCreationPreviewPerformanceOptConfig().c);
    L50:
        com.larus.gallery.api.m r112 = new com.larus.gallery.api.m(r10, r11, r12, r13, r17, r110, r111, 144);
    L52:
        xy8.g r3 = r32.d;
        if (r3 == null) goto L99;
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("[mapToDisplayItem] hasVideoModel=");
        String r113 = r3.g;
        if (r113 != null) goto L57;
    L60:
        boolean r114 = true;
    L61:
        r22.append(!r114);
        r22.append(", hasPlayUrl=");
        String r115 = r3.b;
        if (r115 != null) goto L64;
    L67:
        boolean r116 = true;
    L68:
        r22.append(!r116);
        r22.append(", hasLocalPath=");
        String r117 = r3.f;
        if (r117 != null) goto L71;
    L74:
        boolean r118 = true;
    L75:
        r22.append(!r118);
        r21.i("PreviewMessageDataSource", r22.toString());
        nr9.f r119 = r3.e;
        if (r119 == null) goto L81;
        Bitmap r23 = r3.n;
        if (r23 != null) goto L80;
        r23 = r119.f;
    L80:
        r8 = nr9.f.a(r119, null, null, null, null, r23, 31);
    L84:
        nr9.f r26 = r8;
        String r24 = r3.a;
        String r25 = r3.g;
        String r120 = r3.b;
        String r121 = r3.c;
        double r122 = r3.l;
        nr9.g r123 = new nr9.g(r24, r25, r120, r121, Double.valueOf(r122), r3.h, r26, r3.f, r3.i, null, 512);
        int r124 = r3.m;
        if (r5 == false) goto L87;
        String r4 = "ugc_video";
    L88:
        String r125 = r4;
        if (r5 == false) goto L91;
        String r27 = "immersive_preview";
    L92:
        String r126 = r27;
        xy8.e r1 = r32.m;
        if (r1 != null) goto L95;
    L97:
        boolean r127 = false;
    L98:
        com.larus.gallery.api.q r28 = new com.larus.gallery.api.q(r24, r123, r124, r125, r126, r127);
    L101:
        return new com.larus.gallery.api.k(r7, r112, r28, null, null, 8);
    L95:
        if (r1.j != true) goto L97;
        r127 = true;
        goto L98
    L91:
        r27 = "";
        goto L92
    L87:
        r4 = r3.o;
        goto L88
    L81:
        String r128 = r3.d;
        if (r128 == null) goto L84;
        r8 = new nr9.f(r128, r128, null, null, null, r3.n, 28);
        goto L84
    L71:
        if (StringsKt.isBlank(r117) == true) goto L74;
        r118 = false;
        goto L75
    L64:
        if (StringsKt.isBlank(r115) == true) goto L67;
        r116 = false;
        goto L68
    L57:
        if (StringsKt.isBlank(r113) == true) goto L60;
        r114 = false;
        goto L61
    L99:
        r28 = null;
        goto L101
    L49:
        r111 = null;
        goto L50
    L40:
        if (r19.c <= 0) goto L44;
        if (r18.a2() == false) goto L44;
        r20 = true;
        goto L45
    L46:
        r110 = null;
        goto L47
    L26:
        if (r14.c <= 0) goto L30;
        if (r9.a2() == false) goto L30;
        r15 = true;
    L33:
        r16 = false;
        goto L34
    L35:
        r17 = null;
        goto L36
    L51:
        r112 = null;
        goto L52
    L16:
        r5 = false;
        goto L17
    L5:
        if (r32.a == SourceType.CREATION_CARD) goto L11;
        xy8.b r29 = r32.c;
        if (r29 == null) goto L9;
        boolean r30 = Intrinsics.areEqual(r29.e, Boolean.TRUE);
    L10:
        if (r30 == false) goto L12;
    L9:
        r30 = false;
    L11:
        r2 = true;
        goto L14
    }

    public final /* bridge */ /* synthetic */ Object d(Object r1, Continuation r2) {
        xy8.d r3 = (xy8.d) r1;
        return m(r2);
    }

    public final Object e(List<xy8.d> r5, Continuation<? super List<Pair<xy8.d, com.larus.gallery.api.k>>> r6) {
        if ((r6 instanceof PreviewMessageDataSource$refreshDisplayItems$1) == false) goto L7;
        PreviewMessageDataSource$refreshDisplayItems$1 r0 = (PreviewMessageDataSource$refreshDisplayItems$1) r6;
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
        r9.add(TuplesKt.to(r4, w(r4)));
        goto L19
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        r7 = r(r5, "gallery_display_window", r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new PreviewMessageDataSource$refreshDisplayItems$1(this, r6);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object f(Object r1, Continuation r2) {
        return q((xy8.d) r1, r2);
    }

    public final /* bridge */ /* synthetic */ Object g(Object r1, Continuation r2) {
        xy8.d r3 = (xy8.d) r1;
        return n(r2);
    }

    public final /* bridge */ /* synthetic */ Object i(Object r1, Continuation r2) {
        return o((xy8.d) r1, r2);
    }

    public final boolean j(Object r2, Object r3) {
        xy8.d r4 = (xy8.d) r2;
        xy8.d r5 = (xy8.d) r3;
        Intrinsics.checkNotNullParameter(r4, "first");
        Intrinsics.checkNotNullParameter(r5, "second");
        return Intrinsics.areEqual(r4.b, r5.b);
    }

    public final Object o(xy8.d r5, Continuation<? super com.larus.gallery.api.k> r6) {
        if ((r6 instanceof PreviewMessageDataSource$mapToDisplayItem$1) == false) goto L7;
        PreviewMessageDataSource$mapToDisplayItem$1 r0 = (PreviewMessageDataSource$mapToDisplayItem$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PreviewMessageDataSource r8 = (PreviewMessageDataSource) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L19:
        return r8.w((xy8.d) r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = this;
        r0.label = 1;
        r7 = q(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L17:
        r8 = this;
    L7:
        r0 = new PreviewMessageDataSource$mapToDisplayItem$1(this, r6);
        goto L8
    }

    public final Object q(xy8.d r5, Continuation<? super xy8.d> r6) {
        if ((r6 instanceof PreviewMessageDataSource$refreshOriginalData$1) == false) goto L7;
        PreviewMessageDataSource$refreshOriginalData$1 r0 = (PreviewMessageDataSource$refreshOriginalData$1) r6;
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
        List<xy8.d> r9 = CollectionsKt.listOf(r5);
        r0.L$0 = r5;
        r0.label = 1;
        r7 = r(r9, "gallery_display_item", r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new PreviewMessageDataSource$refreshOriginalData$1(this, r6);
        goto L8
    }

    public final Object s(Message r6, Continuation<? super String> r7) {
        if ((r7 instanceof PreviewMessageDataSource$resolveBotRespDesc$1) == false) goto L7;
        PreviewMessageDataSource$resolveBotRespDesc$1 r0 = (PreviewMessageDataSource$resolveBotRespDesc$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L28:
        Message r9 = (Message) r8;
        if (r9 != null) goto L32;
        return null;
    L32:
        return com.larus.bmhome.chat.bean.d.H(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        String r10 = r6.getReplyId();
        if (r10 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        return null;
    L23:
        r0.label = 1;
        SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        com.larus.im.d.e().m(r10, new r(r12));
        r8 = r12.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r8 != r2) goto L28;
        return r2;
    L17:
        if (StringsKt.isBlank(r10) == true) goto L20;
        r11 = false;
    L7:
        r0 = new PreviewMessageDataSource$resolveBotRespDesc$1(this, r7);
        goto L8
    }

    public final Object t(Message r9, Continuation<? super String> r10) {
        if ((r10 instanceof PreviewMessageDataSource$resolveUserSendDesc$1) == false) goto L7;
        PreviewMessageDataSource$resolveUserSendDesc$1 r0 = (PreviewMessageDataSource$resolveUserSendDesc$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L38:
        Iterator r12 = ((List) r11).iterator();
    L40:
        if (r12.hasNext() == false) goto L47;
        Object r13 = r12.next();
        if (((Message) r13).getContentType() != 1) goto L44;
        boolean r4 = true;
    L45:
        if (r4 == false) goto L40;
    L48:
        Message r14 = (Message) r13;
        if (r14 != null) goto L51;
        return null;
    L51:
        return com.larus.bmhome.chat.bean.d.H(r14);
    L44:
        r4 = false;
        goto L45
    L47:
        r13 = null;
        goto L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Map r15 = r9.getExt();
        if (r15 == null) goto L17;
        String r16 = (String) r15.get("collection_id");
    L18:
        if (r16 != null) goto L20;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == false) goto L26;
        return null;
    L26:
        String r17 = r9.getConversationId();
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        r0.label = 1;
        if (StringsKt.isBlank(r17) == false) goto L32;
        Object r18 = CollectionsKt.emptyList();
    L35:
        r11 = r18;
        if (r11 != r2) goto L38;
        return r2;
    L32:
        SafeContinuation r6 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        com.larus.im.d.e().p(r17, r16, new s(r6));
        r18 = r6.getOrThrow();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r0);
        goto L35
    L20:
        if (StringsKt.isBlank(r16) == true) goto L23;
        r5 = false;
        goto L24
    L17:
        r16 = null;
    L7:
        r0 = new PreviewMessageDataSource$resolveUserSendDesc$1(this, r10);
        goto L8
    }

    public final Object x(Message r67, Continuation<? super List<xy8.d>> r68) {
        Message r15 = r67;
        if ((r68 instanceof PreviewMessageDataSource$transformMessage$1) == false) goto L7;
        PreviewMessageDataSource$transformMessage$1 r2 = (PreviewMessageDataSource$transformMessage$1) r68;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        PreviewMessageDataSource$transformMessage$1 r14 = r2;
        Object r0 = r14.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        int r11 = 2;
        boolean r8 = true;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        xy8.d r5 = (xy8.d) r14.L$1;
        List r6 = (List) r14.L$0;
        ResultKt.throwOnFailure(r0);
        List r7 = r6;
        xy8.d r9 = r5;
        int r10 = 10;
    L327:
        String r1 = (String) r0;
        List r12 = r7;
    L333:
        String r22 = r1;
        xy8.d r16 = r9;
        List r17 = r12;
    L334:
        String r18 = r22;
        if (r18 != null) goto L337;
    L340:
        boolean r19 = true;
    L341:
        if (r19 == false) goto L343;
        return r17;
    L343:
        FLogger.a.i("PreviewMessageDataSource", "transformMessage: 补充 desc=" + r18 + ", sourceType=" + r16.a);
        List r20 = r17;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, r10));
        Iterator r23 = r20.iterator();
    L345:
        if (r23.hasNext() == false) goto L347;
        r21.add(xy8.d.a((xy8.d) r23.next(), null, null, null, null, r18, null, null, null, null, 0, 131007));
        goto L345
    L347:
        return r21;
    L337:
        if (r18.length() == 0) goto L340;
        r19 = false;
        goto L341
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        xy8.d r24 = (xy8.d) r14.L$1;
        List r25 = (List) r14.L$0;
        ResultKt.throwOnFailure(r0);
        List r26 = r25;
        r9 = r24;
        r10 = 10;
    L332:
        r1 = (String) r0;
        r12 = r26;
        goto L333
    L16:
        ResultKt.throwOnFailure(r0);
        h.a.getClass();
        int r27 = 3;
        r22 = null;
        if (h.c(r67) == false) goto L278;
        String r28 = "message";
        Intrinsics.checkNotNullParameter(r15, "message");
        ArrayList r29 = new ArrayList();
        Intrinsics.checkNotNullParameter(r15, "<this>");
        Iterator r210 = vd9.r.a(r67).iterator();
        int r30 = 0;
        ArrayList r31 = r29;
    L20:
        if (r210.hasNext() == false) goto L277;
        Object r32 = r210.next();
        int r211 = r30 + 1;
        if (r30 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        Block r33 = (Block) r32;
        if (r33.getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L276;
        BlockContent r34 = r33.getContent();
        if (r34 == null) goto L276;
        CreationBlock r35 = r34.getCreationBlock();
        if (r35 == null) goto L276;
        List r36 = r35.creations;
        if (r36 == null) goto L276;
        Iterator r212 = r36.iterator();
        int r37 = 0;
        r31 = r31;
    L35:
        if (r212.hasNext() == false) goto L276;
        Object r38 = r212.next();
        int r213 = r37 + 1;
        if (r37 >= 0) goto L39;
        CollectionsKt.throwIndexOverflow();
    L39:
        CreationItem r39 = (CreationItem) r38;
        h r40 = h.a;
        SourceType r110 = SourceType.CREATION_CARD;
        int r214 = r31.size() + 1;
        r40.getClass();
        Intrinsics.checkNotNullParameter(r15, r28);
        Intrinsics.checkNotNullParameter(r110, "sourceType");
        Intrinsics.checkNotNullParameter(r39, "item");
        Integer r41 = r39.type;
        long r111 = 0;
        if (r41 != null) goto L43;
    L96:
        int r43 = r30;
        ArrayList r44 = r31;
        r28 = r28;
        r13 = r13;
        r14 = r14;
        if (r41 != null) goto L100;
    L271:
        int r310 = r43;
        xy8.d r42 = null;
        ArrayList r45 = r44;
    L272:
        ArrayList r46 = r45;
        if (r42 == null) goto L275;
        r46.add(r42);
    L275:
        r15 = r67;
        r31 = r46;
        r37 = r213;
        r30 = r310;
        r28 = r28;
        r13 = r13;
        r14 = r14;
        r27 = 3;
        r8 = true;
        r11 = 2;
        goto L35
    L100:
        if (r41.intValue() != 4) goto L271;
        LocalVideoData r47 = r39.localVideo;
        if (r47 == null) goto L271;
        String r48 = r47.videoPath;
        if (r48 == null) goto L108;
        boolean r112 = true;
        if ((!StringsKt.isBlank(r48)) == true) goto L110;
    L109:
        r48 = null;
    L110:
        if (r48 != null) goto L112;
    L115:
        boolean r49 = true;
    L116:
        if (r49 == false) goto L127;
        String r50 = r47.uri;
        if (r50 != null) goto L120;
    L123:
        boolean r51 = true;
    L124:
        if (r51 == false) goto L127;
    L132:
        boolean r52 = false;
    L135:
        if (r52 == true) goto L138;
        r47 = null;
    L138:
        if (r47 == null) goto L271;
        String r53 = r47.videoPath;
        if (r53 != null) goto L143;
    L145:
        r53 = null;
    L146:
        String r311 = h.f(r47);
        String r54 = h.h(h.f(r47));
        if (r54 != null) goto L163;
        Cover r55 = r47.cover;
        if (r55 == null) goto L153;
        ImageObj r56 = r55.imagePreview;
        if (r56 == null) goto L153;
        String r57 = r56.url;
    L154:
        r54 = h.i(r57);
        if (r54 != null) goto L163;
        Cover r58 = r47.cover;
        if (r58 == null) goto L161;
        ImageObj r59 = r58.imageThumb;
        if (r59 == null) goto L161;
        String r60 = r59.url;
    L162:
        r54 = h.i(r60);
    L161:
        r60 = null;
    L153:
        r57 = null;
    L163:
        String r510 = r54;
        String r61 = r47.uri;
        if (r61 != null) goto L166;
    L168:
        r61 = null;
    L169:
        String r62 = h.d(r67, r43, r37);
        String r63 = r47.vid;
        if (r63 != null) goto L178;
        if (r61 != null) goto L177;
        if (r53 != null) goto L176;
        r63 = r39.id;
        if (r63 != null) goto L178;
        String r410 = h.d(r67, r43, r37);
    L179:
        if (r61 == null) goto L188;
        if (r53 != null) goto L182;
    L185:
        boolean r64 = true;
    L186:
        if (r64 == false) goto L188;
        String r411 = r61;
    L189:
        Cover r65 = r47.cover;
        if (r65 == null) goto L196;
        LocalImageMeta r66 = r65.localImagePreview;
        if (r66 == null) goto L196;
        Long r69 = r66.width;
        if (r69 == null) goto L196;
        long r70 = r69.longValue();
    L204:
        int r71 = (int) r70;
        Cover r72 = r47.cover;
        if (r72 == null) goto L211;
        LocalImageMeta r73 = r72.localImagePreview;
        if (r73 == null) goto L211;
        Long r74 = r73.height;
        if (r74 == null) goto L211;
        long r75 = r74.longValue();
    L219:
        nr9.f r511 = new nr9.f(r510, r510, r311, Integer.valueOf((int) r75), Integer.valueOf(r71), null, 32);
        String r76 = r47.videoType;
        String r77 = r39.id;
        Long r78 = r47.width;
        if (r78 == null) goto L222;
        long r79 = r78.longValue();
    L223:
        int r113 = (int) r79;
        Long r80 = r47.height;
        if (r80 == null) goto L226;
        long r114 = r80.longValue();
    L227:
        int r81 = (int) r114;
        Double r82 = r47.duration;
        if (r53 != null) goto L230;
    L263:
        if (r82 == null) goto L265;
        double r115 = r82.doubleValue();
    L266:
        xy8.g r83 = new xy8.g(r410, r411, null, r510, r511, r53, r61, r76, r77, r113, r81, r115, null, null, null, 61444);
        GalleryType r84 = GalleryType.Video;
        Map r85 = h.a(r67, false);
        long r116 = r67.getCreateTime();
        LocalMediaType r86 = LocalMediaType.VIDEO;
        String r87 = h.h(r53);
        if (r87 == null) goto L270;
        r61 = r87;
    L270:
        r310 = r43;
        r42 = new xy8.d(r110, r62, null, r83, r84, r85, null, r116, null, null, null, null, null, null, r67, new xy8.c(r86, r61, r53), r214, 16196);
        r45 = r44;
    L265:
        r115 = 0.0d;
        goto L266
    L230:
        if (new PolarisFileWrapper(r53).isFile() == false) goto L232;
        String r88 = r53;
    L233:
        if (r88 == null) goto L263;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L245
        MediaMetadataRetriever r118 = new MediaMetadataRetriever();     // Catch: Throwable -> L245
        r118.setDataSource(r88);     // Catch: Throwable -> L242
        String r89 = h.b(r118);     // Catch: Throwable -> L242
        if (r89 == null) goto L240;
        Long r90 = StringsKt.toLongOrNull(r89);     // Catch: Throwable -> L242
    L241:
        r118.release();     // Catch: Throwable -> L245
        Object r91 = Result.constructor-impl(r90);     // Catch: Throwable -> L245
    L248:
        if (Result.isFailure-impl(r91) == false) goto L250;
        r91 = null;
    L250:
        Long r92 = (Long) r91;
        if (r92 != null) goto L253;
    L261:
        if (r82 == null) goto L265;
        r115 = r82.doubleValue();
        goto L266
    L253:
        if (r92.longValue() <= 0) goto L255;
        boolean r119 = true;
    L256:
        if (r119 == true) goto L259;
        r92 = null;
    L259:
        if (r92 == null) goto L261;
        r115 = r92.longValue() / 1000.0d;
        goto L266
    L255:
        r119 = false;
        goto L256
    L240:
        r90 = null;
    L242:
        th = move-exception;
        r118.release();     // Catch: Throwable -> L245
        throw th;     // Catch: Throwable -> L245
    L245:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r91 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L248
    L232:
        r88 = null;
        goto L233
    L226:
        r114 = 0;
        goto L227
    L222:
        r79 = 0;
    L211:
        if (r72 == null) goto L215;
        ImageObj r93 = r72.imagePreview;
        if (r93 == null) goto L215;
        r75 = r93.height;
    L215:
        Long r94 = r47.height;
        if (r94 == null) goto L218;
        r75 = r94.longValue();
        goto L219
    L218:
        r75 = 0;
    L196:
        if (r65 == null) goto L200;
        ImageObj r95 = r65.imagePreview;
        if (r95 == null) goto L200;
        r70 = r95.width;
    L200:
        Long r96 = r47.width;
        if (r96 == null) goto L203;
        r70 = r96.longValue();
        goto L204
    L203:
        r70 = 0;
        goto L204
    L182:
        if (r53.length() == 0) goto L185;
        r64 = false;
    L188:
        r411 = null;
        goto L189
    L176:
        r410 = r53;
        goto L179
    L177:
        r410 = r61;
    L178:
        r410 = r63;
        goto L179
    L166:
        if ((StringsKt.isBlank(r61) ^ r112) == false) goto L168;
    L143:
        if ((StringsKt.isBlank(r53) ^ r112) == false) goto L145;
    L120:
        if (r50.length() == 0) goto L123;
        r51 = false;
    L127:
        Integer r97 = r47.status;
        if (r97 == null) goto L134;
        if (r97.intValue() != 3) goto L132;
    L134:
        r52 = true;
        goto L135
    L112:
        if (r48.length() == 0) goto L115;
        r49 = false;
        goto L116
    L108:
        r112 = true;
        goto L109
    L43:
        if (r41.intValue() != r27) goto L96;
        LocalImageData r98 = r39.localImage;
        if (r98 == null) goto L94;
        String r99 = h.g(r98);
        if (r99 != null) goto L49;
    L52:
        boolean r100 = true;
    L53:
        if (r100 == true) goto L59;
        Integer r101 = r98.status;
        if (r101 != null) goto L57;
    L58:
        boolean r102 = true;
    L60:
        if (r102 == true) goto L63;
        r98 = null;
    L63:
        if (r98 == null) goto L94;
        String r103 = h.g(r98);
        if (r103 == null) goto L94;
        String r104 = h.g(r98);
        String r121 = h.h(r103);
        if (r121 == null) goto L94;
        String r122 = h.h(r104);
        String r105 = h.d(r15, r30, r37);
        String r215 = h.h(h.g(r98));
        if (r215 != null) goto L74;
        String r216 = r121;
    L75:
        LocalImageMeta r106 = r98.localImageOriRaw;
        if (r106 == null) goto L80;
        Long r107 = r106.width;
        if (r107 == null) goto L80;
        long r123 = r107.longValue();
    L81:
        int r108 = (int) r123;
        LocalImageMeta r109 = r98.localImageOriRaw;
        if (r109 == null) goto L86;
        Long r124 = r109.height;
        if (r124 == null) goto L86;
        r111 = r124.longValue();
    L86:
        xy8.b r312 = new xy8.b(r121, r216, r122, null, null, false, null, r108, (int) r111, 248);
        GalleryType r125 = GalleryType.Image;
        Map r126 = h.a(r15, r8);
        long r217 = r67.getCreateTime();
        LocalMediaType r127 = LocalMediaType.IMAGE;
        if (r122 != null) goto L89;
        String r128 = r121;
    L90:
        if (r104 == null) goto L93;
        r103 = r104;
    L93:
        int r412 = r30;
        ArrayList r413 = r31;
        xy8.d r313 = new xy8.d(r110, r105, r312, null, r125, r126, null, r217, null, null, null, null, null, null, r67, new xy8.c(r127, r128, r103), r214, 16200);
    L95:
        r42 = r313;
        r310 = r412;
        r45 = r413;
        goto L272
    L89:
        r128 = r122;
    L80:
        r123 = 0;
        goto L81
    L74:
        r216 = r215;
        goto L75
    L57:
        if (r101.intValue() == r11) goto L58;
    L59:
        r102 = false;
        goto L60
    L49:
        if (r99.length() == 0) goto L52;
        r100 = false;
    L94:
        r412 = r30;
        r413 = r31;
        r313 = null;
    L276:
        r15 = r67;
        r31 = r31;
        r30 = r211;
        r28 = r28;
        r13 = r13;
        r14 = r14;
        r27 = 3;
        r8 = true;
        r11 = 2;
        goto L20
    L277:
        Object r414 = r13;
        PreviewMessageDataSource$transformMessage$1 r415 = r14;
        List r129 = r31;
    L280:
        if (Intrinsics.areEqual(r67.getMessageId(), this.b) == true) goto L283;
    L286:
        List r130 = r129;
        r10 = 10;
    L308:
        if (r130.isEmpty() == false) goto L310;
        return r130;
    L310:
        r16 = (xy8.d) CollectionsKt.first(r130);
        if (r16.g.length() <= 0) goto L313;
        boolean r131 = true;
    L314:
        if (r131 == false) goto L316;
        return r130;
    L316:
        int r132 = b.a[r16.a.ordinal()];
        if (r132 != 1) goto L319;
        Object r133 = r414;
        PreviewMessageDataSource$transformMessage$1 r134 = r415;
        r134.L$0 = r130;
        r134.L$1 = r16;
        r134.label = 1;
        Object r135 = t(r67, r134);
        if (r135 != r133) goto L331;
        return r133;
    L331:
        List r610 = r130;
        r9 = r16;
        r0 = r135;
        r26 = r610;
        goto L332
    L319:
        if (r132 == 2) goto L323;
        r17 = r130;
        if (r132 != 3) goto L334;
    L323:
        PreviewMessageDataSource$transformMessage$1 r136 = r415;
        r136.L$0 = r130;
        r136.L$1 = r16;
        r136.label = 2;
        Object r137 = s(r67, r136);
        Object r138 = r414;
        if (r137 != r138) goto L326;
        return r138;
    L326:
        List r611 = r130;
        r9 = r16;
        r0 = r137;
        r7 = r611;
        goto L327
    L313:
        r131 = false;
        goto L314
    L283:
        if (this.f == null) goto L285;
    L287:
        List r139 = r129;
        r10 = 10;
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator r141 = r139.iterator();
        int r142 = 0;
    L289:
        if (r141.hasNext() == false) goto L306;
        Object r143 = r141.next();
        int r144 = r142 + 1;
        if (r142 >= 0) goto L293;
        CollectionsKt.throwIndexOverflow();
    L293:
        xy8.d r145 = (xy8.d) r143;
        xy8.g r146 = r145.d;
        if (r142 != this.e) goto L305;
        if (r146 == null) goto L305;
        Integer r147 = this.f;
        if (r147 == null) goto L300;
        int r148 = r147.intValue();
    L301:
        Bitmap r149 = this.g;
        if (r149 != null) goto L304;
        r149 = r146.n;
    L304:
        r145 = xy8.d.a(r145, null, xy8.g.a(r146, r148, r149), null, null, null, null, null, null, null, 0, 131063);
        goto L305
    L300:
        r148 = r146.m;
    L305:
        r140.add(r145);
        r142 = r144;
        goto L289
    L306:
        r130 = r140;
        goto L308
    L285:
        if (this.g != null) goto L287;
    L278:
        r414 = r13;
        r415 = r14;
        v.a.getClass();
        r129 = v.n(r67);
    L7:
        r2 = new PreviewMessageDataSource$transformMessage$1(this, r68);
        goto L8
    }

    public final Object r(List<xy8.d> r22, String r23, Continuation<? super List<xy8.d>> r24) {
        List<xy8.d> r0 = r22;
        String r1 = r23;
        if ((r24 instanceof PreviewMessageDataSource$refreshOriginalDataList$1) == false) goto L7;
        PreviewMessageDataSource$refreshOriginalDataList$1 r3 = (PreviewMessageDataSource$refreshOriginalDataList$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        Iterator r7 = (Iterator) r3.L$3;
        List r8 = (List) r3.L$2;
        String r9 = (String) r3.L$1;
        List<xy8.d> r10 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L50:
        if (r7.hasNext() == false) goto L55;
        Message r11 = (Message) r7.next();
        CreationNoWatermarkManager r12 = CreationNoWatermarkManager.a;
        ImageContentData r13 = IAIChatUgcAIGCService.a.d0(r11);
        String r14 = r9 + "_image_explain";
        r3.L$0 = r10;
        r3.L$1 = r9;
        r3.L$2 = r8;
        r3.L$3 = r7;
        r3.label = 2;
        if (r12.p(r13, r14, r3) != r5) goto L50;
        return r5;
    L55:
        if (CreationNoWatermarkManager.a.D() == true) goto L57;
        return r10;
    L57:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r8.iterator();
    L59:
        if (r16.hasNext() == false) goto L61;
        Message r17 = (Message) r16.next();
        v.a.getClass();
        CollectionsKt.addAll(r15, v.n(r17));
        goto L59
    L61:
        LinkedHashMap r18 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
        Iterator r19 = r15.iterator();
    L63:
        if (r19.hasNext() == false) goto L65;
        Object r20 = r19.next();
        r18.put(((xy8.d) r20).b, r20);
        goto L63
    L65:
        List<xy8.d> r110 = r10;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r25 = r110.iterator();
    L67:
        if (r25.hasNext() == false) goto L102;
        xy8.d r26 = (xy8.d) r25.next();
        if (r26.a != SourceType.CREATION_CARD) goto L101;
        xy8.d r27 = (xy8.d) r18.get(r26.b);
        if (r27 == null) goto L101;
        String r28 = r26.g;
        if (r28.length() != 0) goto L77;
        boolean r29 = true;
    L78:
        if (r29 == false) goto L80;
        r28 = r27.g;
    L80:
        String r111 = r28;
        xy8.g r30 = r27.d;
        Integer r31 = null;
        if (r30 == null) goto L99;
        xy8.g r32 = r26.d;
        if (r32 == null) goto L98;
        Integer r112 = Integer.valueOf(r32.m);
        if (r112.intValue() <= 0) goto L88;
        boolean r113 = true;
    L89:
        if (r113 == false) goto L91;
        r31 = r112;
    L91:
        if (r31 == null) goto L93;
        int r33 = r31.intValue();
    L94:
        Bitmap r34 = r32.n;
        if (r34 != null) goto L97;
        r34 = r30.n;
    L97:
        r30 = xy8.g.a(r30, r33, r34);
        goto L98
    L93:
        r33 = r30.m;
        goto L94
    L88:
        r113 = false;
    L98:
        xy8.g r114 = r30;
    L100:
        r26 = xy8.d.a(r27, null, r114, null, null, r111, null, null, null, null, 0, 130999);
        goto L101
    L99:
        r114 = null;
        goto L100
    L77:
        r29 = false;
    L101:
        r21.add(r26);
        goto L67
    L102:
        return r21;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r35 = (List) r3.L$2;
        r1 = (String) r3.L$1;
        List<xy8.d> r36 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
        List r37 = r35;
        r0 = r36;
    L39:
        ArrayList r115 = new ArrayList();
        Iterator r38 = r37.iterator();
    L41:
        if (r38.hasNext() == false) goto L48;
        Object r116 = r38.next();
        if (((Message) r116).getContentType() != 6) goto L45;
        boolean r117 = true;
    L46:
        if (r117 == false) goto L41;
        r115.add(r116);
        goto L41
    L45:
        r117 = false;
        goto L46
    L48:
        Iterator r39 = r115.iterator();
        r10 = r0;
        r7 = r39;
        r9 = r1;
        r8 = r37;
        goto L50
    L16:
        ResultKt.throwOnFailure(r2);
        r37 = SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r0), new o()), new p()), new q()));
        if (r37.isEmpty() == false) goto L19;
        return r0;
    L19:
        ArrayList r118 = new ArrayList();
        Iterator r40 = r37.iterator();
    L21:
        if (r40.hasNext() == false) goto L33;
        Object r119 = r40.next();
        Message r120 = (Message) r119;
        if (r120.getContentType() != 9999) goto L25;
    L30:
        boolean r121 = true;
    L31:
        if (r121 == false) goto L21;
        r118.add(r119);
        goto L21
    L25:
        if (r120.getContentType() == 1) goto L27;
    L29:
        r121 = false;
        goto L31
    L27:
        if (com.larus.im.bean.message.a.b0(r120) == false) goto L29;
    L33:
        CreationNoWatermarkManager r41 = CreationNoWatermarkManager.a;
        r3.L$0 = r0;
        r3.L$1 = r1;
        r3.L$2 = r37;
        r3.label = 1;
        r41.getClass();
        Object r42 = r41.o(CreationNoWatermarkManager.j(r118), r1, r3);
        if (r42 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        r42 = Unit.INSTANCE;
    L37:
        if (r42 != r5) goto L39;
        return r5;
    L7:
        r3 = new PreviewMessageDataSource$refreshOriginalDataList$1(this, r24);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0081 -> B:23:0x0086). Please report as a decompilation issue!!! */
    public final Object y(List<Message> r12, String r13, Continuation<? super List<xy8.d>> r14) {
        if ((r14 instanceof PreviewMessageDataSource$transformMessages$1) == false) goto L7;
        PreviewMessageDataSource$transformMessages$1 r0 = (PreviewMessageDataSource$transformMessages$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        PreviewMessageDataSource r16 = (PreviewMessageDataSource) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L37:
        return r16.v((List) r15);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List<xy8.d> r17 = (List) r0.L$3;
        Iterator<Message> r18 = (Iterator) r0.L$2;
        List<xy8.d> r4 = (List) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r6 = r2;
        PreviewMessageDataSource$transformMessages$1 r7 = r0;
        String r8 = r5;
        Object r9 = r15;
        Iterator<Message> r19 = r18;
        PreviewMessageDataSource r110 = this;
    L23:
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((Iterable) r9).iterator();
    L25:
        if (r11.hasNext() == false) goto L32;
        Object r20 = r11.next();
        if (((xy8.d) r20).a != r110.o) goto L29;
        boolean r21 = true;
    L30:
        if (r21 == false) goto L25;
        r10.add(r20);
        goto L25
    L29:
        r21 = false;
        goto L30
    L32:
        r17.addAll(r10);
        r16 = r110;
        Iterator<Message> r111 = r19;
        List<xy8.d> r112 = r4;
        Object r22 = r6;
    L18:
        if (r111.hasNext() == false) goto L33;
        Message r23 = r111.next();
        r7.L$0 = r8;
        r7.L$1 = r112;
        r7.L$2 = r111;
        r7.L$3 = r112;
        r7.label = 1;
        r9 = r16.x(r23, r7);
        if (r9 != r22) goto L22;
        return r22;
    L22:
        r6 = r22;
        r4 = r112;
        r19 = r111;
        r110 = r16;
        r17 = r4;
        goto L23
    L33:
        r7.L$0 = r16;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.label = 2;
        r15 = r16.r(r112, r8, r7);
        if (r15 != r22) goto L37;
        return r22;
    L16:
        ResultKt.throwOnFailure(r15);
        r112 = new ArrayList();
        r22 = r2;
        r7 = r0;
        r8 = r13;
        r111 = r12.iterator();
        r16 = this;
    L7:
        r0 = new PreviewMessageDataSource$transformMessages$1(this, r14);
        goto L8
    }

    public final Object p(long r28, long r30, String r32, ContinuationImpl r33) {
        FLogger.a.i("PreviewMessageDataSource", "queryMessages: direction=" + r28 + ", startTime=" + r30 + ", pageToken=" + r32 + ", conversationId=" + this.a + ", queryTypeFilter=" + l());
        SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(r33));
        com.larus.im.d.e().u(new MessageQueryRequest(3, this.a, r28, r30, 0, l(), r32, 20, 1, false, null, true, 0, null, 13328, null), new t(r15));
        Object r1 = r15.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r33);
    L5:
        return r1;
    }

    public PreviewMessageDataSource(String r2, String r3, Message r4, List<Message> r5, int r6, Integer r7, Bitmap r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "selectMessageId");
        Intrinsics.checkNotNullParameter(r5, "loadedMessages");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.l = true;
        this.m = true;
        this.n = ConcurrentHashMap.newKeySet();
    }
}

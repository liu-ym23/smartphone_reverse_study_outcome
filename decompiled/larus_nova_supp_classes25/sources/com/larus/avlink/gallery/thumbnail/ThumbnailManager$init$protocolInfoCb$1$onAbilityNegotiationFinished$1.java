package com.larus.avlink.gallery.thumbnail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.avlink.gallery.model.AlbumInfo;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.MediaInfo;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1", f = "ThumbnailManager.kt", i = {1, 2, 2, 2, 3, 3, 3}, l = {DoraCallStateCode.DOUBAO_FOCUS_CHANGED, DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION, 173, DoraCallStateCode.ENV_OBSERVE_USER_WIFI_CONFIG}, m = "invokeSuspend", n = {"startTime", "albumListResult", "currentSn", "duration", "localAlbumList", "response", "remoteAlbumList"}, s = {"J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
public final class ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/avlink/gallery/thumbnail/ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/avlink/gallery/model/HardwareResponse;", "Lcom/larus/avlink/gallery/model/AlbumInfo;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<r98.a<AlbumInfo>> {
        public a() {
        }
    }

    public ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1(Continuation<? super ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    public final Object invokeSuspend(Object r25) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L13;
        if (r4 != 4) goto L12;
        List r0 = (List) this.L$2;
        AlbumInfo r2 = (AlbumInfo) this.L$1;
        List r5 = (List) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Exception -> L152
    L104:
        List r6 = r0;
        AlbumInfo r1 = r2;
        List r8 = r5;
    L105:
        List r7 = r8;     // Catch: Exception -> L152
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Exception -> L152
        Iterator r10 = r7.iterator();     // Catch: Exception -> L152
    L107:
        if (r10.hasNext() == false) goto L109;
        r9.add(Boxing.boxLong(((ThumbnailMetadata) r10.next()).getImageUuid()));     // Catch: Exception -> L152
        goto L107
    L109:
        if (r6 == null) goto L122;
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L152
        Iterator r12 = r6.iterator();     // Catch: Exception -> L152
    L112:
        if (r12.hasNext() == false) goto L120;
        Object r13 = r12.next();     // Catch: Exception -> L152
        MediaInfo r14 = (MediaInfo) r13;     // Catch: Exception -> L152
        if (r14 == null) goto L116;
        Long r15 = r14.getMediaId();     // Catch: Exception -> L152
    L118:
        if ((!CollectionsKt.contains(r9, r15)) == false) goto L112;
        r11.add(r13);     // Catch: Exception -> L152
        goto L112
    L116:
        r15 = null;
        goto L118
    L120:
        List r16 = CollectionsKt.filterNotNull(r11);     // Catch: Exception -> L152
        if (r16 == null) goto L122;
    L123:
        ThumbnailManager r17 = ThumbnailManager.a;     // Catch: Exception -> L152
        ThumbnailManager.c("Sync album list from remote - localAlbumIdList(" + r8.size() + ')', r8);     // Catch: Exception -> L152
        StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L152
        r18.append("Sync album list from remote - remoteAlbumList(");     // Catch: Exception -> L152
        if (r6 == null) goto L126;
        int r19 = r6.size();     // Catch: Exception -> L152
    L127:
        r18.append(r19);     // Catch: Exception -> L152
        r18.append(')');     // Catch: Exception -> L152
        String r20 = r18.toString();     // Catch: Exception -> L152
        if (r6 == null) goto L137;
        List r21 = r6;     // Catch: Exception -> L152
        ?? r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));     // Catch: Exception -> L152
        Iterator r23 = r21.iterator();     // Catch: Exception -> L152
    L131:
        if (r23.hasNext() == false) goto L138;
        MediaInfo r24 = (MediaInfo) r23.next();     // Catch: Exception -> L152
        if (r24 == null) goto L135;
        Long r26 = r24.getMediaId();     // Catch: Exception -> L152
    L136:
        r22.add(r26);     // Catch: Exception -> L152
        goto L131
    L135:
        r26 = null;
    L138:
        ThumbnailManager.c(r20, r22);     // Catch: Exception -> L152
        String r27 = "Sync album list from remote - realAlbumList(" + r16.size() + ')';     // Catch: Exception -> L152
        List r28 = r16;     // Catch: Exception -> L152
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));     // Catch: Exception -> L152
        Iterator r30 = r28.iterator();     // Catch: Exception -> L152
    L140:
        if (r30.hasNext() == false) goto L146;
        MediaInfo r31 = (MediaInfo) r30.next();     // Catch: Exception -> L152
        if (r31 == null) goto L144;
        Long r32 = r31.getMediaId();     // Catch: Exception -> L152
    L145:
        r29.add(r32);     // Catch: Exception -> L152
        goto L140
    L144:
        r32 = null;
        goto L145
    L146:
        ThumbnailManager.c(r27, r29);     // Catch: Exception -> L152
        ConcurrentLinkedQueue<MediaInfo> r33 = ThumbnailManager.e;     // Catch: Exception -> L152
        r33.clear();     // Catch: Exception -> L152
        r33.addAll(r16);     // Catch: Exception -> L152
        ThumbnailManager.g.clear();     // Catch: Exception -> L152
        Iterator r34 = r16.iterator();     // Catch: Exception -> L152
    L148:
        if (r34.hasNext() == false) goto L154;
        MediaInfo r35 = (MediaInfo) r34.next();     // Catch: Exception -> L152
        ThumbnailManager r36 = ThumbnailManager.a;     // Catch: Exception -> L152
        if (ThumbnailManager.o(r35) == false) goto L148;
        ThumbnailManager.g.offer(r35);     // Catch: Exception -> L152
        goto L148
    L154:
        ThumbnailManager r37 = ThumbnailManager.a;     // Catch: Exception -> L152
        if (r1 == null) goto L157;
        Integer r38 = r1.getPictureCount();     // Catch: Exception -> L152
    L158:
        if (r1 == null) goto L160;
        Integer r39 = r1.getVideoCount();     // Catch: Exception -> L152
    L161:
        ThumbnailManager.f(r38, r39);     // Catch: Exception -> L152
        ThumbnailManager.s("NegotiationFinish");     // Catch: Exception -> L152
        FLogger.a.i("ThumbnailManager", "Sync album list from remote finished, display list size: " + ThumbnailManager.e.size() + ", upload list size: " + ThumbnailManager.g.size());     // Catch: Exception -> L152
    L171:
        return Unit.INSTANCE;
    L160:
        r39 = null;
        goto L161
    L157:
        r38 = null;
        goto L158
    L137:
        r22 = CollectionsKt.emptyList();     // Catch: Exception -> L152
        goto L138
    L126:
        r19 = 0;
    L122:
        r16 = CollectionsKt.emptyList();     // Catch: Exception -> L152
        goto L123
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        long r40 = this.J$0;
        String r41 = (String) this.L$1;
        b49.b r42 = (b49.b) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Exception -> L168
        long r110 = r40;
        Object r43 = r25;
    L53:
        r8 = (List) r43;     // Catch: Exception -> L168
        String r44 = new String(((b49.b.b) r42).a, Charsets.UTF_8);     // Catch: Exception -> L168
        FLogger.a.i("ThumbnailManager", "Sync album list from remote, albumListString length: " + r44.length());     // Catch: Exception -> L168
        r98.a r45 = (r98.a) new Gson().fromJson(r44, new a().getType());     // Catch: Exception -> L152
        if (r45 == null) goto L57;
        r1 = (AlbumInfo) r45.a();     // Catch: Exception -> L152
    L58:
        if (r1 == null) goto L62;
        List<MediaInfo> r46 = r1.getList();     // Catch: Exception -> L152
        if (r46 == null) goto L62;
        r6 = CollectionsKt.filterNotNull(r46);     // Catch: Exception -> L152
    L63:
        GalleryMobHelper r47 = GalleryMobHelper.a;     // Catch: Exception -> L152
        if (r6 == null) goto L66;
        int r111 = r6.size();     // Catch: Exception -> L152
    L67:
        int r48 = ((b49.b.b) r42).b;     // Catch: Exception -> L152
        r47.getClass();     // Catch: Exception -> L152
        GalleryMobHelper.l(r111, r110, 0, 0, r48);     // Catch: Exception -> L152
        if (r6 == null) goto L80;
        ArrayList r49 = new ArrayList();     // Catch: Exception -> L152
        Iterator r50 = r6.iterator();     // Catch: Exception -> L152
    L71:
        if (r50.hasNext() == false) goto L78;
        MediaInfo r112 = (MediaInfo) r50.next();     // Catch: Exception -> L152
        if (r112 == null) goto L75;
        Long r113 = r112.getMediaId();     // Catch: Exception -> L152
    L76:
        if (r113 == null) goto L71;
        r49.add(r113);     // Catch: Exception -> L152
        goto L71
    L75:
        r113 = null;
        goto L76
    L78:
        Set r51 = CollectionsKt.toSet(r49);     // Catch: Exception -> L152
        if (r51 == null) goto L80;
    L81:
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L152
        Iterator r52 = r8.iterator();     // Catch: Exception -> L152
    L83:
        if (r52.hasNext() == false) goto L94;
        Object r115 = r52.next();     // Catch: Exception -> L152
        ThumbnailMetadata r116 = (ThumbnailMetadata) r115;     // Catch: Exception -> L152
        if (r51.contains(Boxing.boxLong(r116.getImageUuid())) == true) goto L87;
    L90:
        boolean r117 = true;
    L91:
        if (r117 == false) goto L83;
        r114.add(r115);     // Catch: Exception -> L152
        goto L83
    L87:
        if (Intrinsics.areEqual(r116.getSn(), r41) == false) goto L90;
        r117 = false;
        goto L91
    L94:
        ArrayList r53 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));     // Catch: Exception -> L152
        Iterator r54 = r114.iterator();     // Catch: Exception -> L152
    L96:
        if (r54.hasNext() == false) goto L99;
        r53.add(Boxing.boxLong(((ThumbnailMetadata) r54.next()).getImageUuid()));     // Catch: Exception -> L152
        goto L96
    L99:
        if ((!r114.isEmpty()) == false) goto L105;
        ThumbnailManager r55 = ThumbnailManager.a;     // Catch: Exception -> L152
        this.L$0 = r8;     // Catch: Exception -> L152
        this.L$1 = r1;     // Catch: Exception -> L152
        this.L$2 = r6;     // Catch: Exception -> L152
        this.label = 4;     // Catch: Exception -> L152
        if (r55.j(r53, r41, this) != r3) goto L103;
        return r3;
    L103:
        r2 = r1;
        r0 = r6;
        r5 = r8;
    L80:
        r51 = SetsKt.emptySet();     // Catch: Exception -> L152
        goto L81
    L66:
        r111 = 0;
    L62:
        r6 = null;
        goto L63
    L57:
        r1 = null;
        goto L58
    L16:
        long r118 = this.J$0;
        ResultKt.throwOnFailure(r25);     // Catch: Exception -> L168
        Object r56 = r25;
    L39:
        r42 = (b49.b) r56;     // Catch: Exception -> L168
    L41:
        long r119 = System.currentTimeMillis() - r118;     // Catch: Exception -> L168
        IDoraService r57 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L168
        if (r57 == null) goto L46;
        DeviceService r58 = r57.device();     // Catch: Exception -> L168
        if (r58 == null) goto L46;
        r41 = r58.m();     // Catch: Exception -> L168
    L48:
        if ((r42 instanceof b49.b.b) == false) goto L165;
        ThumbnailManager r59 = ThumbnailManager.a;     // Catch: Exception -> L168
        this.L$0 = r42;     // Catch: Exception -> L168
        this.L$1 = r41;     // Catch: Exception -> L168
        this.J$0 = r119;     // Catch: Exception -> L168
        this.label = 3;     // Catch: Exception -> L168
        r43 = ThumbnailManager.a(r59, this);     // Catch: Exception -> L168
        if (r43 != r3) goto L52;
        return r3;
    L52:
        r110 = r119;
        goto L53
    L165:
        if ((r42 instanceof b49.b.a) == false) goto L171;
        GalleryMobHelper r60 = GalleryMobHelper.a;     // Catch: Exception -> L168
        int r61 = ((b49.b.a) r42).a;     // Catch: Exception -> L168
        r60.getClass();     // Catch: Exception -> L168
        GalleryMobHelper.l(0, r119, 1, r61, 10);     // Catch: Exception -> L168
        FLogger.a.i("ThumbnailManager", "Sync album list from remote: data is empty");     // Catch: Exception -> L168
    L46:
        r41 = "";
        goto L48
    L18:
        ResultKt.throwOnFailure(r25);     // Catch: Exception -> L168
        Object r62 = r25;
    L28:
        Boolean r63 = (Boolean) r62;     // Catch: Exception -> L168
    L30:
        FLogger r120 = FLogger.a;     // Catch: Exception -> L168
        r120.i("ThumbnailManager", "Album thumbnail ability: " + r63);     // Catch: Exception -> L168
        if (Intrinsics.areEqual(r63, Boxing.boxBoolean(true)) == false) goto L171;
        r120.i("ThumbnailManager", "Start to sync album list from remote...");     // Catch: Exception -> L168
        ThumbnailManager.j = 0;     // Catch: Exception -> L168
        ThumbnailManager.k = 0;     // Catch: Exception -> L168
        r118 = System.currentTimeMillis();     // Catch: Exception -> L168
        ThumbnailManager r64 = ThumbnailManager.a;     // Catch: Exception -> L168
        IDoraService r65 = ThumbnailManager.k();     // Catch: Exception -> L168
        if (r65 == null) goto L40;
        VisionService r66 = r65.V();     // Catch: Exception -> L168
        if (r66 == null) goto L40;
        this.J$0 = r118;     // Catch: Exception -> L168
        this.label = 2;     // Catch: Exception -> L168
        r56 = r66.u(this);     // Catch: Exception -> L168
        if (r56 != r3) goto L39;
        return r3;
    L40:
        r42 = null;
        goto L41
    L20:
        ResultKt.throwOnFailure(r25);
        ThumbnailManager r67 = ThumbnailManager.a;     // Catch: Exception -> L168
        IDoraService r68 = ThumbnailManager.k();     // Catch: Exception -> L168
        if (r68 == null) goto L29;
        AbilityService r69 = r68.o0();     // Catch: Exception -> L168
        if (r69 == null) goto L29;
        this.label = 1;     // Catch: Exception -> L168
        r62 = r69.i("albumThumbnail");     // Catch: Exception -> L168
        if (r62 != r3) goto L28;
        return r3;
    L29:
        r63 = null;
    L168:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error in sync album list from remote: " + e.getMessage(), e);
    L152:
        e = move-exception;
        FLogger.a.e("ThumbnailManager", "Error in sync album list from remote: " + e.getMessage(), e);     // Catch: Exception -> L168
        goto L171
    }
}

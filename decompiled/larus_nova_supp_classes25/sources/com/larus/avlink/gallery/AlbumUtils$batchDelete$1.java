package com.larus.avlink.gallery;

import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.executor.MediaSyncExecutor;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.AlbumUtils$batchDelete$1", f = "AlbumUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION, 142, DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION}, m = "invokeSuspend", n = {"imageMediaIds", "videoMediaIds", "deletedUniqIds", "deletedPaths", "filePath", "imageMediaIds", "videoMediaIds", "deletedUniqIds", "deletedPaths", "filePath", "metadata", "imageMediaIds", "videoMediaIds", "deletedUniqIds", "deletedPaths", "filePath", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6"})
public final class AlbumUtils$batchDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $deleteFromAlbum;
    final /* synthetic */ List<String> $filePaths;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    public AlbumUtils$batchDelete$1(List<String> r1, boolean r2, Continuation<? super AlbumUtils$batchDelete$1> r3) {
        this.$filePaths = r1;
        this.$deleteFromAlbum = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AlbumUtils$batchDelete$1(this.$filePaths, this.$deleteFromAlbum, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x009e: MOVE (r7 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:16777374), block:B:19:0x009e */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0314 -> B:21:0x00ec). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r33) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Object r3 = null;
        String r4 = "";
        String r5 = "doubao_local_delete";
        ?? r6 = 3;
        int r8 = 1;
        String r9 = "AlbumUtils";
        if (r0 != 0) goto L143;
        ResultKt.throwOnFailure(r33);
        FLogger.a.i("AlbumUtils", "Starting batch delete for " + this.$filePaths.size() + " files");
        ArrayList r1 = new ArrayList();
        ArrayList r7 = new ArrayList();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        List<String> r12 = this.$filePaths;
        AlbumUtils$batchDelete$1 r15 = this;
        boolean r14 = this.$deleteFromAlbum;
        Iterator r13 = r12.iterator();
        List r16 = r11;
        List r17 = r10;
        String r18 = "AlbumUtils";
        List r19 = r7;
        String r20 = "doubao_local_delete";
        String r21 = "";
        Object r22 = r2;
        ?? r23 = r1;
    L22:
        if (r13.hasNext() == false) goto L118;
        String r24 = (String) r13.next();
        AlbumUtils.a(r24);     // Catch: Exception -> L113
        AlbumDataBaseHelper r25 = AlbumDataBaseHelper.a;     // Catch: Exception -> L113
        r15.L$0 = r23;     // Catch: Exception -> L113
        r15.L$1 = r19;     // Catch: Exception -> L113
        r15.L$2 = r17;     // Catch: Exception -> L113
        r15.L$3 = r16;     // Catch: Exception -> L113
        r15.L$4 = r13;     // Catch: Exception -> L113
        r15.L$5 = r24;     // Catch: Exception -> L113
        r15.L$6 = r3;     // Catch: Exception -> L113
        r15.Z$0 = r14;     // Catch: Exception -> L113
        r15.label = r8;     // Catch: Exception -> L113
        Object r26 = r25.p(r24, r15);     // Catch: Exception -> L113
        if (r26 != r22) goto L27;
        return r22;
    L27:
        String r29 = r20;
        ?? r27 = r23;
        r2 = r22;
        r4 = r21;
        r5 = r29;
        List r30 = r17;
        String r110 = r24;
        List r28 = r19;
        r9 = r18;
        boolean r111 = r14;
        List r112 = r30;
        Iterator r31 = r13;
        List r113 = r16;
        Iterator r114 = r31;
    L150:
        MediaMetadata r32 = (MediaMetadata) r26;     // Catch: Exception -> L111
        r6 = r27;
        if (r32 == null) goto L42;
        GalleryStoragePolicyManager r115 = GalleryStoragePolicyManager.a;     // Catch: Exception -> L111
        r15.L$0 = r27;     // Catch: Exception -> L111
        r15.L$1 = r28;     // Catch: Exception -> L111
        r15.L$2 = r112;     // Catch: Exception -> L111
        r15.L$3 = r113;     // Catch: Exception -> L111
        r15.L$4 = r114;     // Catch: Exception -> L111
        r15.L$5 = r110;     // Catch: Exception -> L111
        r15.L$6 = r32;     // Catch: Exception -> L111
        r15.Z$0 = r111;     // Catch: Exception -> L111
        r15.label = 2;     // Catch: Exception -> L111
        r115.getClass();     // Catch: Exception -> L111
        Object r34 = GalleryStoragePolicyManager.h(r32, r5, r15);     // Catch: Exception -> L111
        r6 = r27;
        if (r34 != r2) goto L146;
        return r2;
    L146:
        w88.o r35 = (w88.o) r34;     // Catch: Exception -> L39
        FLogger r36 = FLogger.a;     // Catch: Exception -> L39
        StringBuilder r37 = new StringBuilder();     // Catch: Exception -> L39
        Object r38 = r2;
        r37.append("cleanup local deleted media result=");     // Catch: Exception -> L37
        r37.append(r35);     // Catch: Exception -> L37
        r37.append(", uniqId=");     // Catch: Exception -> L37
        r37.append(r32.getUniqId());     // Catch: Exception -> L37
        r36.i(r9, r37.toString());     // Catch: Exception -> L37
        r2 = r38;
        r6 = r6;
    L37:
        e = e;
    L41:
        r2 = r38;
    L116:
        FLogger.a.e(r9, "Error processing file " + r110 + ": " + e.getMessage(), e);
        ?? r39 = r6;
    L117:
        r17 = r112;
        r14 = r111;
        r18 = r9;
        r19 = r28;
        String r210 = r4;
        r22 = r2;
        r23 = r39;
        r20 = r5;
        r21 = r210;
        List r310 = r113;
        r13 = r114;
        r16 = r310;
        r3 = null;
        r8 = 1;
    L39:
        e = e;
        r38 = r2;
    L42:
        if (r111 == false) goto L83;
        if (r32 != null) goto L131;
    L50:
        String r40 = null;
    L51:
        if (r40 != null) goto L53;
        Object r211 = r2;
        String r311 = r5;
        boolean r212 = r111;
        Iterator r213 = r114;
        FLogger.a.w(r9, "Cannot extract media ID from: " + r110);     // Catch: Exception -> L108
    L84:
        if (r32 == null) goto L110;
        AlbumDataBaseHelper r41 = AlbumDataBaseHelper.a;     // Catch: Exception -> L108
        String r42 = r32.getUniqId();     // Catch: Exception -> L108
        r15.L$0 = r6;     // Catch: Exception -> L108
        r15.L$1 = r28;     // Catch: Exception -> L108
        r15.L$2 = r112;     // Catch: Exception -> L108
        r15.L$3 = r113;     // Catch: Exception -> L108
        r114 = r213;
        r15.L$4 = r114;     // Catch: Exception -> L106
        r15.L$5 = r110;     // Catch: Exception -> L106
        r15.L$6 = r32;     // Catch: Exception -> L106
        r111 = r212;
        r15.Z$0 = r111;     // Catch: Exception -> L103
        r15.label = 3;     // Catch: Exception -> L100
        Object r43 = r41.d(r42, r15);     // Catch: Exception -> L100
        r2 = r211;
        if (r43 != r2) goto L95;
        return r2;
    L95:
        r5 = r311;
        r6 = r6;
    L152:
        r112.add(r32.getUniqId());     // Catch: Exception -> L98
        Boxing.boxBoolean(r113.add(r110));     // Catch: Exception -> L98
        r39 = r6;
    L98:
        e = e;
    L100:
        e = e;
        r2 = r211;
    L102:
        r5 = r311;
    L103:
        e = e;
        r2 = r211;
    L106:
        e = e;
        r2 = r211;
        r111 = r212;
        goto L102
    L110:
        r2 = r211;
        r111 = r212;
        r114 = r213;
        r5 = r311;
        r39 = r6;
        goto L117
    L53:
        r311 = r5;
        String r44 = StringsKt.substringAfterLast$default(r110, "/", null, 2, null);     // Catch: Exception -> L76
        int r116 = AlbumUtils.a;     // Catch: Exception -> L76
        r211 = r2;
        r212 = r111;
        r213 = r114;
        if (CollectionsKt.listOf(new String[]{"mp4", "mkv", "avi", "mov"}).contains(StringsKt.substringAfterLast(r44, '.', r4).toLowerCase(Locale.getDefault())) == false) goto L66;
        Boxing.boxBoolean(r28.add(r40));     // Catch: Exception -> L108
        goto L84
    L66:
        if (CollectionsKt.listOf(new String[]{"jpg", "jpeg", "png", "gif"}).contains(StringsKt.substringAfterLast(r44, '.', r4).toLowerCase(Locale.getDefault())) == false) goto L68;
        Boxing.boxBoolean(r6.add(r40));     // Catch: Exception -> L108
        goto L84
    L68:
        FLogger.a.w(r9, "Unknown file type: " + r44);     // Catch: Exception -> L108
    L108:
        e = e;
    L75:
        r2 = r211;
        r111 = r212;
        r114 = r213;
    L73:
        e = e;
        r211 = r2;
        r212 = r111;
        r213 = r114;
    L76:
        e = e;
        r5 = r311;
        r2 = r2;
        r111 = r111;
        r114 = r114;
        goto L116
    L131:
        Long r45 = r32.getSystemGalleryId();     // Catch: Exception -> L48
        if (r45 == null) goto L50;
        r40 = r45.toString();     // Catch: Exception -> L48
    L48:
        e = e;
        goto L116
    L83:
        r211 = r2;
        r311 = r5;
        r212 = r111;
        r213 = r114;
    L111:
        e = e;
        String r214 = r4;
        r22 = r2;
        ?? r46 = r27;
        r20 = r5;
        r21 = r214;
        String r312 = r9;
        r19 = r28;
        r24 = r110;
        r17 = r112;
        r14 = r111;
        r18 = r312;
        List r313 = r113;
        r13 = r114;
        r16 = r313;
    L115:
        String r215 = r20;
        r6 = r46;
        r2 = r22;
        r4 = r21;
        r5 = r215;
        List r314 = r17;
        r110 = r24;
        r28 = r19;
        r9 = r18;
        r111 = r14;
        r112 = r314;
        Iterator r315 = r13;
        r113 = r16;
        r114 = r315;
    L113:
        e = e;
        r46 = r23;
        goto L115
    L118:
        com.larus.avlink.gallery.business.a.a(r17, r16, r20);
        if (r15.$deleteFromAlbum == false) goto L128;
        if ((!((Collection) r23).isEmpty()) == false) goto L124;
        FLogger.a.i(r18, "Deleting " + r23.size() + " images from album: " + CollectionsKt.joinToString$default((Iterable) r23, ",", null, null, 0, null, null, 62, null));
        MediaSyncExecutor r47 = MediaSyncExecutor.a;
        MediaSyncExecutor.d((String[]) ((Collection) r23).toArray(new String[0]));
    L124:
        if ((!r19.isEmpty()) == false) goto L126;
        FLogger.a.i(r18, "Deleting " + r19.size() + " videos from album: " + CollectionsKt.joinToString$default(r19, ",", null, null, 0, null, null, 62, null));
        MediaSyncExecutor r48 = MediaSyncExecutor.a;
        MediaSyncExecutor.d((String[]) r19.toArray(new String[0]));
    L126:
        FLogger.a.i(r18, "Batch delete completed: " + r23.size() + " images, " + r19.size() + " videos");
    L128:
        return Unit.INSTANCE;
    L143:
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L11;
        r111 = this.Z$0;
        r32 = (MediaMetadata) this.L$6;
        r110 = (String) this.L$5;
        r114 = (Iterator) this.L$4;
        r113 = (List) this.L$3;
        r112 = (List) this.L$2;
        List r117 = (List) this.L$1;
        List r49 = (List) this.L$0;
        ResultKt.throwOnFailure(r33);     // Catch: Exception -> L18
        r28 = r117;
        r15 = this;
        r6 = r49;
        goto L152
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r111 = this.Z$0;
        r32 = (MediaMetadata) this.L$6;
        r110 = (String) this.L$5;
        r114 = (Iterator) this.L$4;
        r113 = (List) this.L$3;
        r112 = (List) this.L$2;
        List r118 = (List) this.L$1;
        List r50 = (List) this.L$0;
        ResultKt.throwOnFailure(r33);     // Catch: Exception -> L18
        r34 = r33;
        r28 = r118;
        r15 = this;
        r6 = r50;
        goto L146
    L15:
        r111 = this.Z$0;
        r110 = (String) this.L$5;
        r114 = (Iterator) this.L$4;
        r113 = (List) this.L$3;
        r112 = (List) this.L$2;
        List r119 = (List) this.L$1;
        List r51 = (List) this.L$0;
        ResultKt.throwOnFailure(r33);     // Catch: Exception -> L18
        r26 = r33;
        r28 = r119;
        r15 = this;
        r27 = r51;
    L18:
        e = e;
        r28 = r15;
        r15 = this;
        goto L116
    }
}

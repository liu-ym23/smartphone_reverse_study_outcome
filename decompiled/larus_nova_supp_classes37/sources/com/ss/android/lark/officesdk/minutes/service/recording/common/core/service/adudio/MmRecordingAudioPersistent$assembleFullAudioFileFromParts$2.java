package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $audioFilePath;
    final /* synthetic */ String $recordingId;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2(String r1, String r2, MmRecordingAudioPersistent r3, String r4, Continuation<? super MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2> r5) {
        this.$userId = r1;
        this.$recordingId = r2;
        this.this$0 = r3;
        this.$audioFilePath = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingAudioPersistent$assembleFullAudioFileFromParts$2(this.$userId, this.$recordingId, this.this$0, this.$audioFilePath, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L125;
        ResultKt.throwOnFailure(r18);
        boolean r2 = false;
        int r3 = 0;
        MmRecordFileHelper r4 = MmRecordFileHelper.a;     // Catch: Throwable -> L87
        String r5 = this.$userId;     // Catch: Throwable -> L87
        String r6 = this.$recordingId;     // Catch: Throwable -> L87
        r4.getClass();     // Catch: Throwable -> L87
        File r7 = MmRecordFileHelper.f(r5, r6);     // Catch: Throwable -> L87
        if (r7.exists() == true) goto L8;
    L115:
        lvb.a.h(this.this$0.c, "[assembleFullAudioFileFromParts] partDir not exists, recordingId=" + this.$recordingId + ", dir=" + r7.getAbsolutePath());     // Catch: Throwable -> L119
        return Boxing.boxBoolean(false);
    L8:
        if (r7.isDirectory() == false) goto L115;
        File[] r0 = r7.listFiles();     // Catch: Throwable -> L87
        if (r0 == null) goto L26;
        ?? r8 = new ArrayList();     // Catch: Throwable -> L87
        int r9 = r0.length;     // Catch: Throwable -> L87
        int r10 = 0;
    L14:
        if (r10 >= r9) goto L28;
        File r11 = r0[r10];     // Catch: Throwable -> L87
        if (r11.isFile() == true) goto L18;
    L22:
        boolean r12 = false;
    L23:
        if (r12 == false) goto L25;
        r8.add(r11);     // Catch: Throwable -> L87
    L25:
        r10 = r10 + 1;     // Catch: Throwable -> L87
        goto L14
    L18:
        if (Intrinsics.areEqual(FilesKt.getExtension(r11), "ogg") == false) goto L20;
    L21:
        r12 = true;
        goto L23
    L20:
        if (Intrinsics.areEqual(FilesKt.getExtension(r11), "pcm") == false) goto L22;
    L28:
        if (r8.isEmpty() == false) goto L31;
        lvb.a.h(this.this$0.c, "[assembleFullAudioFileFromParts] no part files, recordingId=" + this.$recordingId);     // Catch: Throwable -> L87
        return Boxing.boxBoolean(false);
    L31:
        h r1 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L87
        File r13 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(this.$audioFilePath);     // Catch: Throwable -> L87
        File r14 = r13.getParentFile();     // Catch: Throwable -> L87
        if (r14 != null) goto L34;
    L39:
        if (r14 != null) goto L41;
        r14 = r7;
    L41:
        VFSFile r15 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r14, r13.getName() + ".tmp");     // Catch: Throwable -> L87
        if (r15.exists() == false) goto L44;
        r15.delete();     // Catch: Throwable -> L87
    L44:
        Ref.IntRef r16 = new Ref.IntRef();     // Catch: Throwable -> L87
        LinkedHashMap r17 = new LinkedHashMap();     // Catch: Throwable -> L87
        Iterator r19 = ((Iterable) r8).iterator();     // Catch: Throwable -> L87
    L46:
        if (r19.hasNext() == false) goto L55;
        Object r20 = r19.next();     // Catch: Throwable -> L87
        Integer r110 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(FilesKt.getNameWithoutExtension((VFSFile) r20), "_", null, 2, null));     // Catch: Throwable -> L87
        if (r110 == null) goto L50;
        int r111 = r110.intValue();     // Catch: Throwable -> L87
    L51:
        Integer r112 = Boxing.boxInt(r111);     // Catch: Throwable -> L87
        ?? r113 = r17.get(r112);     // Catch: Throwable -> L87
        if (r113 != null) goto L54;
        r113 = new ArrayList();     // Catch: Throwable -> L87
        r17.put(r112, r113);     // Catch: Throwable -> L87
    L54:
        ((List) r113).add(r20);     // Catch: Throwable -> L87
        goto L46
    L50:
        r111 = Integer.MAX_VALUE;
        goto L51
    L55:
        SortedMap r21 = MapsKt.toSortedMap(r17);     // Catch: Throwable -> L87
        MmRecordingAudioPersistent r22 = this.this$0;     // Catch: Throwable -> L87
        String r23 = this.$recordingId;     // Catch: Throwable -> L87
        Iterator r24 = r21.entrySet().iterator();     // Catch: Throwable -> L87
    L57:
        if (r24.hasNext() == false) goto L98;
        List r114 = (List) ((Map.Entry) r24.next()).getValue();     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L87
        Iterator r115 = r114.iterator();     // Catch: Throwable -> L87
    L60:
        if (r115.hasNext() == false) goto L65;
        Object r116 = r115.next();     // Catch: Throwable -> L87
        if (Intrinsics.areEqual(FilesKt.getExtension((VFSFile) r116), "ogg") == false) goto L60;
    L66:
        VFSFile r117 = (VFSFile) r116;     // Catch: Throwable -> L87
        if (r117 == null) goto L69;
        byte[] r118 = r117.readBytes();     // Catch: Throwable -> L87
    L90:
        if (r118.length != 0) goto L92;
        boolean r25 = true;
    L94:
        if ((!r25) == false) goto L96;
        FilesKt.appendBytes(r15, r118);     // Catch: Throwable -> L119
        r16.element++;     // Catch: Throwable -> L119
    L96:
        r3 = 0;
        goto L57
    L92:
        r25 = false;
        goto L94
    L69:
        Iterator r119 = r114.iterator();     // Catch: Throwable -> L87
    L71:
        if (r119.hasNext() == false) goto L75;
        Object r120 = r119.next();     // Catch: Throwable -> L87
        if (Intrinsics.areEqual(FilesKt.getExtension((VFSFile) r120), "pcm") == false) goto L71;
    L76:
        VFSFile r121 = (VFSFile) r120;     // Catch: Throwable -> L87
        if (r121 != null) goto L79;
        r118 = new byte[r3];     // Catch: Throwable -> L87
        goto L90
    L79:
        r118 = MmRecordingAudioPersistent.a(r22, r121.readBytes());     // Catch: Throwable -> L87
        if (r118.length != 0) goto L82;
        boolean r122 = true;
    L84:
        if ((!r122) == false) goto L90;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r7, FilesKt.getNameWithoutExtension(r121) + ".ogg").writeBytes(r118);     // Catch: Throwable -> L87
        r121.delete();     // Catch: Throwable -> L87
        String r123 = r22.c;     // Catch: Throwable -> L87
        StringBuilder r124 = new StringBuilder();     // Catch: Throwable -> L87
        r124.append("[assembleFullAudioFileFromParts] encoded pcm part, recordingId=");     // Catch: Throwable -> L119
        r124.append(r23);     // Catch: Throwable -> L119
        r124.append(", file=");     // Catch: Throwable -> L119
        r124.append(r121.getName());     // Catch: Throwable -> L119
        lvb.a.e(r123, r124.toString());     // Catch: Throwable -> L119
        goto L90
    L82:
        r122 = false;
        goto L84
    L75:
        r120 = null;
        goto L76
    L65:
        r116 = null;
        goto L66
    L98:
        if (r16.element != 0) goto L100;
    L111:
        lvb.a.h(this.this$0.c, "[assembleFullAudioFileFromParts] no data appended, recordingId=" + this.$recordingId);     // Catch: Throwable -> L119
        r15.delete();     // Catch: Throwable -> L119
        return Boxing.boxBoolean(false);
    L100:
        if (r15.exists() == false) goto L111;
        if (r15.length() == 0) goto L111;
        if (r13.exists() == false) goto L108;
        r13.delete();     // Catch: Throwable -> L119
    L108:
        if (r15.renameTo(r13) == true) goto L110;
        FilesKt.copyTo$default(r15, r13, true, 0, 4, null);     // Catch: Throwable -> L119
        r15.delete();     // Catch: Throwable -> L119
    L110:
        lvb.a.e(this.this$0.c, "[assembleFullAudioFileFromParts] success, recordingId=" + this.$recordingId + ", partCount=" + r16.element + ", audioFilePath=" + this.$audioFilePath + ", bytes=" + r13.length());     // Catch: Throwable -> L119
        r2 = true;
    L123:
        return Boxing.boxBoolean(r2);
    L34:
        if (r14.mkdirs() == true) goto L39;
        if (r14.exists() == true) goto L39;
        lvb.a.b(this.this$0.c, "[assembleFullAudioFileFromParts] make target parent failed, path=" + r14.getAbsolutePath());     // Catch: Throwable -> L87
        return Boxing.boxBoolean(false);
    L26:
        r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L119:
        th = th;
        r2 = false;
    L121:
        lvb.a.b(this.this$0.c, "[assembleFullAudioFileFromParts] failed, recordingId=" + this.$recordingId + ", error=" + th);
    L87:
        th = th;
        goto L121
    L125:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

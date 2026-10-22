package com.larus.photopicker.v2.impl.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/photopicker/v2/impl/data/model/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.ContentResolverMediaSource$queryMediaItem$2", f = "ContentResolverMediaSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContentResolverMediaSource$queryMediaItem$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super mp9.c>, Object> {
    final /* synthetic */ String $uriString;
    int label;
    final /* synthetic */ ContentResolverMediaSource this$0;

    public ContentResolverMediaSource$queryMediaItem$2(String r1, ContentResolverMediaSource r2, Continuation<? super ContentResolverMediaSource$queryMediaItem$2> r3) {
        this.$uriString = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContentResolverMediaSource$queryMediaItem$2(this.$uriString, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super mp9.c> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L88;
        ResultKt.throwOnFailure(r41);
        Uri r0 = UriProtector.parse(this.$uriString);     // Catch: Exception -> L84
        if (Intrinsics.areEqual(r0.getScheme(), "content") == true) goto L8;
        return null;
    L8:
        boolean r3 = r0.getPathSegments().contains("video");     // Catch: Exception -> L84
        List r4 = CollectionsKt.mutableListOf(new String[]{"_id", "_display_name", "date_modified", "date_added", "width", "height", "mime_type", "_size", "bucket_display_name", "bucket_id"});     // Catch: Exception -> L84
        if (r3 == false) goto L12;
        int r5 = c.c;     // Catch: Exception -> L84
        r4.add("duration");     // Catch: Exception -> L84
    L12:
        Cursor r1 = a(this.this$0.a.getContentResolver(), r0, (String[]) r4.toArray(new String[0]));     // Catch: Exception -> L84
        if (r1 == null) goto L86;
        Cursor r6 = r1;     // Catch: Exception -> L84
        Cursor r2 = r6;     // Catch: Throwable -> L77
        if (r2.moveToFirst() == true) goto L19;
        CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L84
        return null;
    L19:
        int r7 = r2.getColumnIndex("_id");     // Catch: Throwable -> L77
        int r8 = r2.getColumnIndex("_display_name");     // Catch: Throwable -> L77
        int r9 = r2.getColumnIndex("date_modified");     // Catch: Throwable -> L77
        int r10 = r2.getColumnIndex("date_added");     // Catch: Throwable -> L77
        int r11 = r2.getColumnIndex("width");     // Catch: Throwable -> L77
        int r12 = r2.getColumnIndex("height");     // Catch: Throwable -> L77
        int r13 = r2.getColumnIndex("mime_type");     // Catch: Throwable -> L77
        int r14 = r2.getColumnIndex("_size");     // Catch: Throwable -> L77
        int r15 = c.c;     // Catch: Throwable -> L77
        int r16 = r2.getColumnIndex("duration");     // Catch: Throwable -> L77
        int r17 = r2.getColumnIndex("bucket_display_name");     // Catch: Throwable -> L77
        int r18 = r2.getColumnIndex("bucket_id");     // Catch: Throwable -> L77
        if (r7 >= 0) goto L22;
        long r38 = 0;
    L25:
        if (r8 < 0) goto L30;
        String r19 = r2.getString(r8);     // Catch: Throwable -> L77
        if (r19 == null) goto L30;
        String r25 = r19;
    L31:
        if (r9 < 0) goto L33;
        long r20 = r2.getLong(r9);     // Catch: Throwable -> L77
    L34:
        if (r10 < 0) goto L36;
        long r110 = r2.getLong(r10);     // Catch: Throwable -> L77
    L37:
        if (r11 < 0) goto L39;
        int r34 = r2.getInt(r11);     // Catch: Throwable -> L77
    L40:
        if (r12 < 0) goto L42;
        int r35 = r2.getInt(r12);     // Catch: Throwable -> L77
    L43:
        if (r13 < 0) goto L46;
        String r21 = r2.getString(r13);     // Catch: Throwable -> L77
        if (r21 == null) goto L46;
    L47:
        if (r14 < 0) goto L49;
        long r36 = r2.getLong(r14);     // Catch: Throwable -> L77
    L50:
        if (r16 < 0) goto L52;
        long r32 = r2.getLong(r16);     // Catch: Throwable -> L77
    L53:
        if (r17 < 0) goto L58;
        String r22 = r2.getString(r17);     // Catch: Throwable -> L77
        if (r22 == null) goto L58;
        String r28 = r22;
    L59:
        if (r18 < 0) goto L61;
        long r26 = r2.getLong(r18);     // Catch: Throwable -> L77
    L63:
        if (StringsKt.startsWith$default(r21, "video/", false, 2, null) == false) goto L65;
        MediaType r23 = MediaType.VIDEO;     // Catch: Throwable -> L77
    L67:
        if (r23 != MediaType.VIDEO) goto L69;
        Uri r24 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L77
    L70:
        long r27 = r38;
        Uri r29 = ContentUris.withAppendedId(r24, r27);     // Catch: Throwable -> L77
        if (r20 <= 0) goto L73;
        long r30 = r20;
    L74:
        mp9.c r31 = new mp9.c(r27, r29, r23, r25, r26, r28, r21, r30, r32, r34, r35, r36);     // Catch: Throwable -> L77
        CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L84
        return r31;
    L73:
        r30 = r110;
        goto L74
    L69:
        r24 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L77
        goto L70
    L65:
        r23 = MediaType.IMAGE;     // Catch: Throwable -> L77
        goto L67
    L61:
        r26 = 0;
    L58:
        r28 = "";
        goto L59
    L52:
        r32 = 0;
        goto L53
    L49:
        r36 = 0;
    L46:
        r21 = "image/jpeg";
        goto L47
    L42:
        r35 = 0;
        goto L43
    L39:
        r34 = 0;
        goto L40
    L36:
        r110 = 0;
        goto L37
    L33:
        r20 = 0;
    L30:
        r25 = "";
        goto L31
    L22:
        r38 = r2.getLong(r7);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Exception -> L84
        throw th;     // Catch: Exception -> L84
    L86:
        return null;
    L84:
        e = move-exception;
        int r33 = e0.a;
        e0.c(this.this$0.c, "queryMediaItem failed: " + e.getMessage());
        goto L86
    L88:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }
}

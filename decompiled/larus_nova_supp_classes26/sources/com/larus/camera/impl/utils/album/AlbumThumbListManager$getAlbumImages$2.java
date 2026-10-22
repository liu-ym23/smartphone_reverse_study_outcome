package com.larus.camera.impl.utils.album;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.album.AlbumThumbListManager$getAlbumImages$2", f = "AlbumThumbListManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumThumbListManager$getAlbumImages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Uri>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Uri> $imageUris;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ int $internalLimit;
    final /* synthetic */ Function1<Exception, Unit> $onError;
    final /* synthetic */ Function2<List<? extends Uri>, Integer, Unit> $onSuccess;
    final /* synthetic */ String[] $projection;
    final /* synthetic */ String $sortOrder;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumThumbListManager$getAlbumImages$2(Uri r1, int r2, Context r3, String[] r4, String r5, List<Uri> r6, Function2<? super List<? extends Uri>, ? super Integer, Unit> r7, Function1<? super Exception, Unit> r8, Ref.IntRef r9, Continuation<? super AlbumThumbListManager$getAlbumImages$2> r10) {
        this.$uri = r1;
        this.$internalLimit = r2;
        this.$context = r3;
        this.$projection = r4;
        this.$sortOrder = r5;
        this.$imageUris = r6;
        this.$onSuccess = r7;
        this.$onError = r8;
        this.$index = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new AlbumThumbListManager$getAlbumImages$2(this.$uri, this.$internalLimit, this.$context, this.$projection, this.$sortOrder, this.$imageUris, this.$onSuccess, this.$onError, this.$index, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Uri>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r13);
        Ref.IntRef r14 = new Ref.IntRef();     // Catch: Exception -> L46
        if (Build.VERSION.SDK_INT < 26) goto L25;
        FLogger.a.i("BotUtils", "getAlbumImages SDK_INT>0");     // Catch: Exception -> L46
        Bundle r1 = new Bundle();     // Catch: Exception -> L46
        r1.putInt("android:query-arg-limit", this.$internalLimit);     // Catch: Exception -> L46
        r1.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});     // Catch: Exception -> L46
        r1.putInt("android:query-arg-sort-direction", 1);     // Catch: Exception -> L46
        Cursor r2 = a(this.$context.getContentResolver(), this.$uri.buildUpon().appendQueryParameter("limit", String.valueOf(this.$internalLimit)).build(), this.$projection, r1);     // Catch: Exception -> L46
        if (r2 == null) goto L42;
        Cursor r3 = r2;     // Catch: Exception -> L46
        Ref.IntRef r4 = this.$index;     // Catch: Exception -> L46
        int r5 = this.$internalLimit;     // Catch: Exception -> L46
        List<Uri> r7 = this.$imageUris;     // Catch: Exception -> L46
        Cursor r8 = r3;     // Catch: Throwable -> L20
        r14.element = r8.getCount();     // Catch: Throwable -> L20
        int r6 = r8.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L20
    L13:
        if (r8.moveToNext() == false) goto L17;
        if (r4.element >= r5) goto L17;
        r7.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r8.getLong(r6)));     // Catch: Throwable -> L20
        r4.element++;     // Catch: Throwable -> L20
    L17:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L46
        goto L42
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L42:
        FLogger.a.i("BotUtils", "getAlbumImages success size=" + this.$imageUris.size());     // Catch: Exception -> L46
        Function2<List<? extends Uri>, Integer, Unit> r10 = this.$onSuccess;     // Catch: Exception -> L46
        if (r10 == null) goto L51;
        r10.invoke(this.$imageUris, Boxing.boxInt(r14.element));     // Catch: Exception -> L46
    L51:
        return this.$imageUris;
    L25:
        FLogger.a.i("BotUtils", "getAlbumImages SDK_INT<=0");     // Catch: Exception -> L46
        Cursor r11 = c(this.$context.getContentResolver(), this.$uri.buildUpon().appendQueryParameter("limit", String.valueOf(this.$internalLimit)).build(), this.$projection, this.$sortOrder);     // Catch: Exception -> L46
        if (r11 == null) goto L42;
        Cursor r12 = r11;     // Catch: Exception -> L46
        Ref.IntRef r15 = this.$index;     // Catch: Exception -> L46
        int r16 = this.$internalLimit;     // Catch: Exception -> L46
        List<Uri> r17 = this.$imageUris;     // Catch: Exception -> L46
        Cursor r18 = r12;     // Catch: Throwable -> L37
        r14.element = r18.getCount();     // Catch: Throwable -> L37
        int r19 = r18.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L37
    L30:
        if (r18.moveToNext() == false) goto L34;
        if (r15.element >= r16) goto L34;
        r17.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r18.getLong(r19)));     // Catch: Throwable -> L37
        r15.element++;     // Catch: Throwable -> L37
    L34:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L46
        goto L42
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        FLogger.a.e("BotUtils", "getAlbumImages error msg=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        Function1<Exception, Unit> r0 = this.$onError;
        if (r0 == null) goto L51;
        r0.invoke(e);
        goto L51
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r15, Uri r16, String[] r17, Bundle r18) {
        f06.c r11 = new f06.c();
        Object[] r12 = {r16, r17, r18, null};
        f06.b r14 = new f06.b();
        f06.d r9 = r11.b(240004, "android/content/ContentResolver", "query", r15, r12, "android.database.Cursor", r14);
        if (r9.a == false) goto L6;
        r11.a(240004, "android/content/ContentResolver", "query", r15, r12, null, r14, false);
        return (Cursor) r9.b;
    L6:
        Cursor r10 = r15.query(r16, r17, r18, null);
        r11.a(240004, "android/content/ContentResolver", "query", r15, r12, r10, r14, true);
        return r10;
    }

    public static Cursor c(ContentResolver r12, Uri r13, String[] r14, String r15) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, r15};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r16 = r12.query(r13, r14, null, null, r15);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r16, r10, true);
        return r16;
    }
}

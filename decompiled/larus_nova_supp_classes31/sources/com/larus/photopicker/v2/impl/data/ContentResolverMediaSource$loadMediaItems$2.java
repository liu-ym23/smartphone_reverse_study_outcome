package com.larus.photopicker.v2.impl.data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/photopicker/v2/impl/data/model/MediaItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.ContentResolverMediaSource$loadMediaItems$2", f = "ContentResolverMediaSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContentResolverMediaSource$loadMediaItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<mp9.c>>, Object> {
    final /* synthetic */ mp9.a $filter;
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    int label;
    final /* synthetic */ ContentResolverMediaSource this$0;

    public ContentResolverMediaSource$loadMediaItems$2(mp9.a r1, ContentResolverMediaSource r2, int r3, int r4, Continuation<? super ContentResolverMediaSource$loadMediaItems$2> r5) {
        this.$filter = r1;
        this.this$0 = r2;
        this.$page = r3;
        this.$pageSize = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ContentResolverMediaSource$loadMediaItems$2(this.$filter, this.this$0, this.$page, this.$pageSize, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<mp9.c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r13);
        ArrayList r14 = new ArrayList();
        int r0 = c.c;     // Catch: Exception -> L15
        mp9.a r1 = this.$filter;     // Catch: Exception -> L15
        Long r2 = null;
        if (r1 == null) goto L10;
        MediaTab r3 = r1.b;     // Catch: Exception -> L15
        if (r3 == null) goto L10;
        MediaType r4 = r3.toMediaType();     // Catch: Exception -> L15
    L11:
        if (r1 == null) goto L13;
        r2 = r1.a;     // Catch: Exception -> L15
    L13:
        Pair<String, String[]> r5 = new c(r4, r2).a();     // Catch: Exception -> L15
        String r6 = (String) r5.component1();     // Catch: Exception -> L15
        String[] r7 = (String[]) r5.component2();     // Catch: Exception -> L15
        Uri r8 = MediaStore.Files.getContentUri("external");     // Catch: Exception -> L15
        ContentResolverMediaSource.d(this.this$0, a(this.this$0.a.getContentResolver(), r8, new String[]{"_id", "_display_name", "date_added", "mime_type", "width", "height", "_size", "bucket_id", "bucket_display_name", "duration"}, r6, r7), r14, this.$page, this.$pageSize);     // Catch: Exception -> L15
    L17:
        int r9 = e0.a;
        e0.d(this.this$0.c, "loadMediaItems: [" + r14.size() + ']');
        return r14;
    L10:
        r4 = null;
    L15:
        e = move-exception;
        int r10 = e0.a;
        e0.c(this.this$0.c, "loadMediaItems failed: " + e.getMessage());
        goto L17
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r17, Uri r18, String[] r19, String r20, String[] r21) {
        f06.c r14 = new f06.c();
        Object[] r15 = {r18, r19, r20, r21, "date_modified DESC"};
        f06.b r16 = new f06.b();
        f06.d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
        if (r0.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r17.query(r18, r19, r20, r21, "date_modified DESC");
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
        return r1;
    }
}

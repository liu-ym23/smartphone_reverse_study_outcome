package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import android.os.CancellationSignal;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/database/Cursor;", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver$query$2 extends Lambda implements Function0<Cursor> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ String[] $projection;
    final /* synthetic */ String $selection;
    final /* synthetic */ String[] $selectionArgs;
    final /* synthetic */ String $sortOrder;
    final /* synthetic */ ContentResolverTranslateEntry$Companion$InnerContentResolver this$0;

    public ContentResolverTranslateEntry$Companion$InnerContentResolver$query$2(ContentResolverTranslateEntry$Companion$InnerContentResolver r1, String[] r2, String r3, String[] r4, String r5, CancellationSignal r6) {
        this.this$0 = r1;
        this.$projection = r2;
        this.$selection = r3;
        this.$selectionArgs = r4;
        this.$sortOrder = r5;
        this.$cancellationSignal = r6;
        super(0);
    }

    public final Cursor invoke() {
        this.this$0.getClass();
        this.this$0.getClass();
        String[] r1 = this.$projection;
        String r2 = this.$selection;
        String[] r3 = this.$selectionArgs;
        String r4 = this.$sortOrder;
        CancellationSignal r5 = this.$cancellationSignal;
        f06.c r14 = new f06.c();
        Object[] r15 = {null, r1, r2, r3, r4, r5};
        f06.b r6 = new f06.b();
        f06.d r7 = r14.b(240004, "android/content/ContentResolver", "query", null, r15, "android.database.Cursor", r6);
        if (r7.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", null, r15, null, r6, false);
        return (Cursor) r7.b;
    L6:
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1595invoke() {
        return invoke();
    }
}

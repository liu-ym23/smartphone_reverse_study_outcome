package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$findLocalMeetingIds$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$findLocalMeetingIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$findLocalMeetingIds$2(String r1, Continuation<? super MmRecordFileHelper$findLocalMeetingIds$2> r2) {
        this.$userId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordFileHelper$findLocalMeetingIds$2(this.$userId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r8);
        MmRecordFileHelper r9 = MmRecordFileHelper.a;
        String r0 = this.$userId;
        r9.getClass();
        VFSFile r10 = MmRecordFileHelper.g(r0);
        if (r10.exists() == true) goto L7;
        return null;
    L7:
        if (r10.isDirectory() == false) goto L47;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L46;
        ArrayList r1 = new ArrayList();
        int r2 = r11.length;
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L17;
        File r5 = r11[r4];
        if (r5.isDirectory() == false) goto L16;
        r1.add(r5);
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        r12.add(((File) r3.next()).getName());
        goto L19
    L21:
        ArrayList r6 = new ArrayList();
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L33;
        Object r7 = r13.next();
        String r14 = (String) r7;
        if (Intrinsics.areEqual(r14, "OfflineRecordings") == true) goto L29;
        Intrinsics.checkNotNull(r14);
        if (StringsKt.startsWith$default(r14, "native_local_", false, 2, null) == true) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == false) goto L23;
        r6.add(r7);
    L29:
        r15 = false;
        goto L30
    L33:
        return r6;
    L46:
        return null;
    L47:
        return null;
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

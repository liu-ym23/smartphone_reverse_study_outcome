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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$findNativeLocalSessionKeys$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$findNativeLocalSessionKeys$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$findNativeLocalSessionKeys$2(String r1, Continuation<? super MmRecordFileHelper$findNativeLocalSessionKeys$2> r2) {
        this.$userId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordFileHelper$findNativeLocalSessionKeys$2(this.$userId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object, java.util.List] */
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r11);
        MmRecordFileHelper r12 = MmRecordFileHelper.a;
        String r0 = this.$userId;
        r12.getClass();
        VFSFile r13 = MmRecordFileHelper.g(r0);
        if (r13.exists() == true) goto L7;
    L29:
        lvb.a.e("MmRecordFileHelper", "[findNativeLocalSessionKeys] skip, root not exists:" + r13.getAbsolutePath());
        return CollectionsKt.emptyList();
    L7:
        if (r13.isDirectory() == false) goto L29;
        File[] r14 = r13.listFiles();
        if (r14 == null) goto L26;
        ArrayList r1 = new ArrayList();
        int r2 = r14.length;
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L22;
        File r5 = r14[r4];
        if (r5.isDirectory() == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L21;
        r1.add(r5);
    L21:
        r4 = r4 + 1;
        goto L12
    L16:
        if (StringsKt.startsWith$default(r5.getName(), "native_local_", false, 2, null) == false) goto L18;
        r6 = true;
        goto L19
    L22:
        ?? r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L24:
        if (r3.hasNext() == false) goto L27;
        r15.add(((File) r3.next()).getName());
    L27:
        lvb.a.e("MmRecordFileHelper", "[findNativeLocalSessionKeys] userId:" + this.$userId + ", count:" + r15.size() + ", sessionKeys:" + r15);
        return r15;
    L26:
        r15 = CollectionsKt.emptyList();
        goto L27
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

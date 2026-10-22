package com.obric.datatransfer.server;

import com.obric.datatransfer.logger.TransferLogger;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lwja/a;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.obric.datatransfer.server.BaseTransferProvider$generateTransferableFiles$2", f = "BaseTransferProvider.kt", i = {0, 1}, l = {226, 232}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
final class BaseTransferProvider$generateTransferableFiles$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super wja.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<File> $files;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseTransferProvider this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseTransferProvider$generateTransferableFiles$2(List<? extends File> r1, BaseTransferProvider r2, Continuation<? super BaseTransferProvider$generateTransferableFiles$2> r3) {
        this.$files = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        BaseTransferProvider$generateTransferableFiles$2 r0 = new BaseTransferProvider$generateTransferableFiles$2(this.$files, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super wja.a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0059 -> B:48:0x017a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0080 -> B:48:0x017a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a7 -> B:48:0x017a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x015c -> B:48:0x017a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x015f -> B:48:0x017a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 1;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Iterator<File> r4 = (Iterator) this.L$1;
        SequenceScope r5 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        BaseTransferProvider$generateTransferableFiles$2 r6 = this;
    L48:
        r3 = 1;
    L12:
        if (r4.hasNext() == false) goto L50;
        File r7 = r4.next();
        if (r7.exists() == false) goto L15;
        if (r7.isDirectory() == false) goto L24;
        File[] r8 = r7.listFiles();
        if (r8 == null) goto L48;
        BaseTransferProvider r9 = r6.this$0;
        List r10 = ArraysKt.toList(r8);
        int r11 = BaseTransferProvider.e;
        r9.getClass();
        Sequence r12 = SequencesKt.sequence(new BaseTransferProvider$generateTransferableFiles$2(r10, r9, null));
        r6.L$0 = r5;
        r6.L$1 = r4;
        r6.label = r3;
        if (r5.yieldAll(r12, r6) != r1) goto L12;
        return r1;
    L24:
        if (r7.isFile() == false) goto L48;
        BaseTransferProvider r13 = r6.this$0;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r7, "file");
        Map<String, File> r14 = r13.b();
        e r15 = (e) r13.b.getValue();
        Iterator<Map.Entry<String, File>> r16 = r14.entrySet().iterator();
        int r17 = -1;
        wja.a r18 = null;
    L27:
        if (r16.hasNext() == false) goto L43;
        Map.Entry<String, File> r19 = r16.next();
        String r110 = r19.getKey();
        File r111 = r19.getValue();
        if (r111 == null) goto L27;
        String r112 = r111.getAbsolutePath();
        if (StringsKt.startsWith$default(r7.getAbsolutePath(), r112, false, 2, null) == false) goto L27;
        String r20 = r7.getAbsolutePath().substring(r112.length());
        if (r20.length() != 0) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L40;
        if (StringsKt.startsWith$default(r20, File.separator, false, 2, null) == false) goto L27;
    L40:
        if (r112.length() <= r17) goto L27;
        String r0 = StringsKt.removePrefix(r20, File.separator);
        r18 = new wja.a(r110, r0, r7.length(), 10, r15.a(r110, r0));
        r17 = r112.length();
        goto L27
    L35:
        r113 = false;
        goto L36
    L43:
        if (r18 == null) goto L47;
        TransferLogger.c(r6.this$0.d, "build transferable file " + r18);
        r6.L$0 = r5;
        r6.L$1 = r4;
        r6.label = 2;
        if (r5.yield(r18, r6) != r1) goto L48;
        return r1;
    L47:
        TransferLogger r21 = r6.this$0.d;
        String r22 = "Skipping unsupported file: " + r7.getAbsolutePath();
        com.obric.datatransfer.logger.a r23 = TransferLogger.b;
        r21.d(r22, null);
        goto L48
    L15:
        TransferLogger r25 = r6.this$0.d;
        String r26 = "File does not exist: " + r7.getAbsolutePath();
        com.obric.datatransfer.logger.a r114 = TransferLogger.b;
        r25.d(r26, null);
        goto L48
    L50:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r4 = (Iterator) this.L$1;
        r5 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        r6 = this;
        goto L12
    L10:
        ResultKt.throwOnFailure(r24);
        SequenceScope r27 = (SequenceScope) this.L$0;
        r6 = this;
        r5 = r27;
        r4 = this.$files.iterator();
        goto L12
    }
}

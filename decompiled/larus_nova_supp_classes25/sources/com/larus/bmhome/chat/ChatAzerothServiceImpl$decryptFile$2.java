package com.larus.bmhome.chat;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import yoa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.ChatAzerothServiceImpl$decryptFile$2", f = "ChatAzerothServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatAzerothServiceImpl$decryptFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ String $decryptionKey;
    final /* synthetic */ boolean $deleteInput;
    final /* synthetic */ String $inputPath;
    final /* synthetic */ String $outputPath;
    int label;

    public ChatAzerothServiceImpl$decryptFile$2(String r1, String r2, boolean r3, String r4, Continuation<? super ChatAzerothServiceImpl$decryptFile$2> r5) {
        this.$inputPath = r1;
        this.$outputPath = r2;
        this.$deleteInput = r3;
        this.$decryptionKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatAzerothServiceImpl$decryptFile$2(this.$inputPath, this.$outputPath, this.$deleteInput, this.$decryptionKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L68;
        ResultKt.throwOnFailure(r11);
        FLogger r12 = FLogger.a;
        r12.i("ChatAzerothServiceImpl", "decrypt file, inputPath: " + this.$inputPath + ", outputPath: " + this.$outputPath + ", deleteInput: " + this.$deleteInput);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        Unit r4 = null;
        PolarisFileWrapper r5 = new PolarisFileWrapper(this.$inputPath);     // Catch: Throwable -> L29 Exception -> L31
        r1.element = com.larus.utils.r.n(r5);     // Catch: Throwable -> L29 Exception -> L31
        PolarisFileWrapper r6 = new PolarisFileWrapper(this.$outputPath);     // Catch: Throwable -> L29 Exception -> L31
        File r7 = r6.getParentFile();     // Catch: Throwable -> L29 Exception -> L31
        if (r7 != null) goto L8;
    L10:
        r6.createNewFile();     // Catch: Throwable -> L29 Exception -> L31
        r3.element = com.larus.utils.r.o(r6);     // Catch: Throwable -> L29 Exception -> L31
        int r8 = 0;
        a.b(Base64.decode(this.$decryptionKey, 0), (InputStream) r1.element, (OutputStream) r3.element);     // Catch: Throwable -> L29 Exception -> L31
        if (this.$deleteInput == true) goto L74;
    L20:
        FLogger.a.i("ChatAzerothServiceImpl", "decrypt file success");     // Catch: Throwable -> L29 Exception -> L31
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L52
        FileInputStream r14 = (FileInputStream) r1.element;     // Catch: Throwable -> L52
        if (r14 == null) goto L24;
        r14.close();     // Catch: Throwable -> L52
    L24:
        FileOutputStream r15 = (FileOutputStream) r3.element;     // Catch: Throwable -> L52
        if (r15 == null) goto L27;
        r15.close();     // Catch: Throwable -> L52
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L52
    L27:
        Result.constructor-impl(r4);     // Catch: Throwable -> L52
    L55:
        return Boxing.boxInt(r8);
    L74:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        if (r5.delete() == false) goto L15;
        r12.i("ChatAzerothServiceImpl", "delete input file success");     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
        goto L20
    L15:
        r12.e("ChatAzerothServiceImpl", "delete input file failed");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29 Exception -> L31
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29 Exception -> L31
        goto L20
    L8:
        if (r7.exists() == true) goto L10;
        r7.mkdirs();     // Catch: Throwable -> L29 Exception -> L31
    L31:
        e = move-exception;
        FLogger.a.e("ChatAzerothServiceImpl", "decrypt file error: " + e.getMessage());     // Catch: Throwable -> L29
        if ((e instanceof FileNotFoundException) == false) goto L36;
        r8 = 3002;
    L45:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L52
        FileInputStream r17 = (FileInputStream) r1.element;     // Catch: Throwable -> L52
        if (r17 == null) goto L48;
        r17.close();     // Catch: Throwable -> L52
    L48:
        FileOutputStream r18 = (FileOutputStream) r3.element;     // Catch: Throwable -> L52
        if (r18 == null) goto L27;
        r18.close();     // Catch: Throwable -> L52
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L27
    L36:
        if ((e instanceof IOException) == false) goto L39;
        r8 = 3003;
        goto L45
    L39:
        if ((e instanceof IllegalArgumentException) == false) goto L41;
        r8 = 3004;
        goto L45
    L41:
        if ((e instanceof GeneralSecurityException) == false) goto L44;
        r8 = 3005;
        goto L45
    L44:
        r8 = 3001;
    L29:
        th = move-exception;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L64
        FileInputStream r2 = (FileInputStream) r1.element;     // Catch: Throwable -> L64
        if (r2 == null) goto L59;
        r2.close();     // Catch: Throwable -> L64
    L59:
        FileOutputStream r19 = (FileOutputStream) r3.element;     // Catch: Throwable -> L64
        if (r19 == null) goto L62;
        r19.close();     // Catch: Throwable -> L64
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L64
    L62:
        Result.constructor-impl(r4);     // Catch: Throwable -> L64
    L66:
        throw th;
    L64:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L52:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L68:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

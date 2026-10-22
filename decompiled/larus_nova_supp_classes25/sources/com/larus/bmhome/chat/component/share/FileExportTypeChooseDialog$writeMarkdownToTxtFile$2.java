package com.larus.bmhome.chat.component.share;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$writeMarkdownToTxtFile$2", f = "FileExportTypeChooseDialog.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {485, 492}, m = "invokeSuspend", n = {"cacheFilePath", "file", "validCount", "cacheFilePath", "file", "userPrefix", "validCount", "message"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6"})
final class FileExportTypeChooseDialog$writeMarkdownToTxtFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ List<Message> $messages;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ FileExportTypeChooseDialog this$0;

    public FileExportTypeChooseDialog$writeMarkdownToTxtFile$2(FileExportTypeChooseDialog r1, List<Message> r2, Continuation<? super FileExportTypeChooseDialog$writeMarkdownToTxtFile$2> r3) {
        this.this$0 = r1;
        this.$messages = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FileExportTypeChooseDialog$writeMarkdownToTxtFile$2(this.this$0, this.$messages, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01cb -> B:49:0x01cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x023c -> B:62:0x023f). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Message r3 = (Message) this.L$6;
        Iterator r8 = (Iterator) this.L$5;
        FileExportTypeChooseDialog r9 = (FileExportTypeChooseDialog) this.L$4;
        Ref.IntRef r10 = (Ref.IntRef) this.L$3;
        String r11 = (String) this.L$2;
        File r12 = (File) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r27);
        Object r14 = r27;
        FileExportTypeChooseDialog$writeMarkdownToTxtFile$2 r15 = this;
    L62:
        String r16 = (String) r14;
        if (d.G0(r3) == false) goto L65;
        String r4 = r11 + 65306;
    L66:
        FilesKt.appendText$default(r12, r4 + '\n' + r16 + '\n', null, 2, null);
        r10.element = r10.element + 1;
    L58:
        if (r8.hasNext() == false) goto L67;
        r3 = (Message) r8.next();
        r15.L$0 = r13;
        r15.L$1 = r12;
        r15.L$2 = r11;
        r15.L$3 = r10;
        r15.L$4 = r9;
        r15.L$5 = r8;
        r15.L$6 = r3;
        r15.label = 2;
        r14 = FileExportTypeChooseDialog.T90(r9, r3, r15);
        if (r14 != r1) goto L62;
        return r1;
    L67:
        Ref.IntRef r17 = r10;
        File r18 = r12;
        String r19 = r13;
    L69:
        if (r17.element <= 0) goto L79;
        com.larus.platform.model.chat.q r5 = (com.larus.platform.model.chat.q) r15.this$0.v.getValue();
        if (r5 != null) goto L73;
    L75:
        boolean r6 = false;
    L76:
        if (r6 == false) goto L79;
        FilesKt.appendText$default(r18, "\n" + AppHost.a.getApplication().getString(2131899692) + '\n', null, 2, null);
        goto L79
    L73:
        if (r5.b() != true) goto L75;
        r6 = true;
    L79:
        if (r17.element > 0) goto L81;
        return null;
    L81:
        return r19;
    L65:
        r4 = r9.h + 65306;
        goto L66
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Iterator r7 = (Iterator) this.L$3;
        r17 = (Ref.IntRef) this.L$2;
        r18 = (File) this.L$1;
        r19 = (String) this.L$0;
        ResultKt.throwOnFailure(r27);
        Object r110 = r27;
        r15 = this;
    L49:
        List r111 = (List) r110;
        if (r111 == null) goto L53;
        String r112 = CollectionsKt.joinToString$default(r111, "\n", null, null, 0, null, null, 62, null);
    L54:
        FilesKt.appendText$default(r18, r112 + '\n', null, 2, null);
        r17.element = r17.element + 1;
    L42:
        if (r7.hasNext() == false) goto L69;
        Block r113 = (Block) r7.next();
        com.larus.bmhome.chat.layout.holder.helper.s0 r114 = ILegacyChatUiServiceDelegate.b.X8();
        if (r114 == null) goto L53;
        List r115 = CollectionsKt.listOf(r113);
        r15.L$0 = r19;
        r15.L$1 = r18;
        r15.L$2 = r17;
        r15.L$3 = r7;
        r15.label = 1;
        FileExportTypeChooseDialog$writeMarkdownToTxtFile$2 r20 = r15;
        r110 = com.larus.bmhome.chat.layout.holder.helper.s0.a.a(r114, r115, false, null, false, null, r20, 30);
        if (r110 != r1) goto L48;
        return r1;
    L48:
        r15 = r20;
        goto L49
    L53:
        r112 = null;
        goto L54
    L82:
        r112 = null;
        goto L54
    L10:
        ResultKt.throwOnFailure(r27);
        FileExportTypeChooseDialog r21 = this.this$0;
        int r22 = FileExportTypeChooseDialog.w;
        r21.getClass();
        AppHost.Companion r23 = AppHost.a;
        File r24 = r23.getApplication().getExternalFilesDir(null);
        StringBuilder r25 = new StringBuilder();
        r25.append(r24);
        String r26 = File.separator;
        r25.append(r26);
        r25.append("export");
        r25.append(r26);
        String r28 = r25.toString();
        FileExportTypeChooseDialog r29 = this.this$0;
        Application r116 = r23.getApplication();
        Function0<String> r117 = r29.d;
        if (r117 == null) goto L14;
        String r118 = (String) r117.invoke();
        if (r118 == null) goto L14;
    L16:
        if (r118.length() <= 15) goto L20;
        r118 = r118.substring(0, 15);
    L20:
        if (r118.length() <= 0) goto L22;
        boolean r119 = true;
    L24:
        if (r119 == false) goto L26;
        String r30 = r118 + '.' + r29.f.getExtension();
    L27:
        String r31 = r28 + r30;
        r18 = new PolarisFileWrapper(r31);
        m5.a(r18);
        if (r18.exists() == true) goto L38;
        File r120 = r18.getParentFile();
        if (r120 == null) goto L35;
        if (r120.exists() == true) goto L35;
        r120.mkdirs();
        FLogger.a.d("FileExportTypeChooseDialog", "mkdirs " + r120.getAbsolutePath());
    L35:
        if (r18.createNewFile() == true) goto L38;
        FLogger.a.e("FileExportTypeChooseDialog", "create new file failed");
        return null;
    L38:
        String r32 = r23.getApplication().getString(2131910908);
        r10 = new Ref.IntRef();
        if ((!this.this$0.n.isEmpty()) == false) goto L56;
        r7 = this.this$0.n.iterator();
        r15 = this;
        r19 = r31;
        r17 = r10;
        goto L42
    L56:
        List<Message> r121 = this.$messages;
        FileExportTypeChooseDialog r122 = this.this$0;
        r15 = this;
        r13 = r31;
        r8 = r121.iterator();
        r11 = r32;
        r12 = r18;
        r9 = r122;
        goto L58
    L26:
        r30 = r116.getString(2131905588, new Object[]{r29.h, new SimpleDateFormat("MMdd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()))}) + '.' + r29.f.getExtension();
        goto L27
    L22:
        r119 = false;
    L14:
        r118 = "";
        goto L16
    }
}

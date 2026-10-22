package com.larus.bmhome.chat.component.share;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import by7.e;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;
import com.larus.bmhome.chat.deepresearch.component.i0;
import com.larus.bmhome.chat.layout.holder.helper.TargetDataSource;
import com.larus.bmhome.share.network.MessageShareApi;
import com.larus.bmhome.share.network.c;
import com.larus.chat.common.databinding.LarusDialogFileExportTypeChooseBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u00109\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0014H\u0002J\u000e\u0010=\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010:J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u001eH\u0002J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\nH\u0002J*\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010G0F2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040IH\u0082@¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\u0004\u0018\u00010\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u00020G0\u0013H\u0082@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u0004H\u0002J\u0012\u0010O\u001a\u00020\u00042\b\u0010P\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020UH\u0002J\n\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020\u001eH\u0002J\b\u0010Y\u001a\u00020\u001eH\u0016J\u0018\u0010Z\u001a\u0004\u0018\u00010\u00042\u0006\u0010[\u001a\u00020GH\u0082@¢\u0006\u0002\u0010\\R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0006R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+¨\u0006^"}, d2 = {"Lcom/larus/bmhome/chat/component/share/FileExportTypeChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "getTitle", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/larus/chat/common/databinding/LarusDialogFileExportTypeChooseBinding;", "exportType", "Lcom/larus/common_ui/view/FileExportType;", "conversationId", "botName", "exportActionId", "chatKey", "", "botId", "clickModule", "exportMessageList", "", "Lcom/larus/bmhome/chat/component/share/FileExportMessageData;", "exportListBlock", "Lcom/larus/im/bean/message/block/Block;", "deepResearchId", "deepResearchReportId", "containEncrypted", "", "currentPage", "showFrom", "onPreviewAfter", "", "getOnPreviewAfter", "()Lkotlin/jvm/functions/Function0;", "setOnPreviewAfter", "paneAwareController", "Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "getPaneAwareController", "()Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "paneAwareController$delegate", "Lkotlin/Lazy;", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "exportTxtFile", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTxtMessage", "it", "openFileExportH5", "toastFailure", "resId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseArgument", "onFileTypeChange", "type", "getMessageList", "", "Lcom/larus/im/bean/message/Message;", "messageIds", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeMarkdownToTxtFile", "messages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileCachePath", "safeSubStr", "string", "getFileCacheName", "context", "Landroid/content/Context;", "newExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getITrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "handleContainEncryptedUI", "onDestroyView", "getMarkdownForMessage", "message", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FileExportTypeChooseDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int w = 0;
    public final Function0<String> d;
    public LarusDialogFileExportTypeChooseBinding e;
    public FileExportType f;
    public String g;
    public String h;
    public String i;
    public long j;
    public String k;
    public String l;
    public List<v0> m;
    public List<Block> n;
    public String o;
    public String p;
    public boolean q;
    public String r;
    public String s;
    public Function0<Unit> t;
    public final Lazy u;
    public final Lazy v;

    public static final class a {
        public a() {
        }

        public static void a(FileExportTypeChooseDialog r3) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            r3.dismiss();     // Catch: Throwable -> L5 Exception -> L7
        L18:
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L5
            Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L5
            if (r4 == null) goto L17;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L5
            return;
        L17:
            return;
        L5:
            th = move-exception;
            FLogger.a.d("FileExportTypeChooseDialog", "dialog dismiss error: " + th);
        }

        public static void c(FileExportTypeChooseDialog r3, FragmentManager r4) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Intrinsics.checkNotNullParameter(r4, "manager");
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "FileExportTypeChooseDialog", r1);     // Catch: Exception -> L9
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r3, r1) == true) goto L17;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L7:
            r3.show(r4, "FileExportTypeChooseDialog");     // Catch: Exception -> L9
            return;
        L17:
            return;
        L9:
            e = move-exception;
            FLogger.a.d("FileExportTypeChooseDialog", "dialog show error: " + e);
        }

        public static FileExportTypeChooseDialog b(String r15, List r16, List r17, String r18, String r19, String r20, long r21, String r23, String r24, String r25, i0 r26, boolean r27, String r28, String r29, int r30) {
            int r5 = FileExportTypeChooseDialog.w;
            String r6 = null;
            if ((r30 & 4) == 0) goto L5;
            List r7 = null;
        L7:
            if ((r30 & 128) == 0) goto L9;
            String r8 = "main_text";
        L10:
            String r9 = "";
            if ((r30 & 256) == 0) goto L13;
            String r10 = "";
        L15:
            if ((r30 & 512) != 0) goto L19;
            r9 = r25;
        L19:
            if ((r30 & 1024) == 0) goto L21;
            Function0 r11 = new g1();
        L23:
            if ((r30 & 2048) == 0) goto L25;
            boolean r12 = false;
        L27:
            if ((r30 & 4096) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r30 & 8192) != 0) goto L34;
            r6 = r29;
        L34:
            Intrinsics.checkNotNullParameter(r15, "conversationId");
            Intrinsics.checkNotNullParameter(r16, "messageList");
            Intrinsics.checkNotNullParameter(r18, "botName");
            Intrinsics.checkNotNullParameter(r19, "botId");
            Intrinsics.checkNotNullParameter(r20, "exportActionId");
            Intrinsics.checkNotNullParameter(r8, "clickModule");
            Intrinsics.checkNotNullParameter(r10, "deepResearchId");
            Intrinsics.checkNotNullParameter(r9, "deepResearchReportId");
            Intrinsics.checkNotNullParameter(r11, "getTitle");
            FileExportTypeChooseDialog r4 = new FileExportTypeChooseDialog(r11);
            Bundle r14 = new Bundle();
            r14.putString("conv_id", r15);
            h.a.getClass();
            r14.putString("message_list", h.c(r16));
            r14.putString("bot_name", r18);
            r14.putString("bot_id", r19);
            r14.putString("export_action_id", r20);
            r14.putLong("chat_key", r21);
            r14.putString("click_module", r8);
            r14.putString("block_list", h.c(r7));
            r14.putString("extra_deep_research_id", r10);
            r14.putString("extra_deep_research_report_id", r9);
            r14.putBoolean("extra_contain_encrypted", r12);
            r14.putString("current_page", r13);
            r14.putString("show_from", r6);
            r4.setArguments(r14);
            return r4;
        L29:
            r13 = r28;
            goto L31
        L25:
            r12 = r27;
            goto L27
        L21:
            r11 = r26;
            goto L23
        L13:
            r10 = r24;
            goto L15
        L9:
            r8 = r23;
            goto L10
        L5:
            r7 = r17;
            goto L7
        }
    }

    static {
        new a();
    }

    public FileExportTypeChooseDialog() {
        this(null);
    }

    public final e V90() {
        if (this.o.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L12;
        e r1 = getParentFragment();
        if ((r1 instanceof e) == true) goto L11;
        return null;
    L11:
        return r1;
    L12:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public final void onDestroyView() {
        ((PaneAwareBottomSheetController) this.u.getValue()).e();
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public FileExportTypeChooseDialog(Function0<String> r2) {
        this.d = r2;
        this.f = FileExportType.word;
        this.g = "";
        this.h = "";
        this.i = "";
        this.k = "";
        this.m = CollectionsKt.emptyList();
        this.n = CollectionsKt.emptyList();
        this.o = "";
        this.p = "";
        this.r = "";
        this.s = "";
        this.u = LazyKt.lazy(new c1(this));
        this.v = LazyKt.lazy(new d1());
    }

    public final void W90(FileExportType r7) {
        this.f = r7;
        FileExportTypeItemView[] r0 = new FileExportTypeItemView[3];
        LarusDialogFileExportTypeChooseBinding r1 = this.e;
        LarusDialogFileExportTypeChooseBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r0[0] = r1.f;
        LarusDialogFileExportTypeChooseBinding r3 = this.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r0[1] = r3.c;
        LarusDialogFileExportTypeChooseBinding r4 = this.e;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r0[2] = r2.e;
        Iterator r5 = CollectionsKt.listOf(r0).iterator();
    L14:
        if (r5.hasNext() == false) goto L20;
        FileExportTypeItemView r6 = (FileExportTypeItemView) r5.next();
        if (r6.getFileType() != r7) goto L18;
        boolean r8 = true;
    L19:
        r6.setSelected(r8);
        goto L14
    L18:
        r8 = false;
        goto L19
    L20:
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public final Dialog onCreateDialog(Bundle r1) {
        return ((PaneAwareBottomSheetController) this.u.getValue()).b();
    }

    public static final Object S90(FileExportTypeChooseDialog r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof FileExportTypeChooseDialog$exportTxtFile$1) == false) goto L7;
        FileExportTypeChooseDialog$exportTxtFile$1 r0 = (FileExportTypeChooseDialog$exportTxtFile$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r16);
    L80:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r16);
    L66:
        String r17 = (String) r16;
        if (r17 != null) goto L69;
    L70:
        r4 = true;
    L71:
        if (r4 == false) goto L73;
        FLogger.a.e("FileExportTypeChooseDialog", "cacheFilePath empty, failed");
        return Unit.INSTANCE;
    L73:
        FLogger.a.d("FileExportTypeChooseDialog", "cacheFilePath: " + r17);
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L76;
        r5.D0();
        com.larus.home.impl.sdk.b1.a.a(r17, new b1());
    L76:
        MainCoroutineDispatcher r6 = Dispatchers.getMain();
        FileExportTypeChooseDialog$exportTxtFile$3 r7 = new FileExportTypeChooseDialog$exportTxtFile$3(r14, r17, null);
        r0.label = 4;
        if (BuildersKt.withContext(r6, r7, r0) != r2) goto L80;
        return r2;
    L69:
        if (r17.length() != 0) goto L71;
    L18:
        ResultKt.throwOnFailure(r16);
    L63:
        List r18 = CollectionsKt.sortedWith(CollectionsKt.filterNotNull(((Map) r16).values()), new h1());
        r0.label = 3;
        r16 = BuildersKt.withContext(Dispatchers.getIO(), new FileExportTypeChooseDialog$writeMarkdownToTxtFile$2(r14, r18, null), r0);
        if (r16 != r2) goto L66;
        return r2;
    L19:
        ResultKt.throwOnFailure(r16);
    L87:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r16);
        List<v0> r19 = r14.m;
        ArrayList r8 = new ArrayList();
        Iterator<T> r110 = r19.iterator();
    L22:
        if (r110.hasNext() == false) goto L48;
        Object r10 = r110.next();
        v0 r11 = (v0) r10;
        Integer r12 = r11.a();
        if (r12 != null) goto L27;
    L28:
        Integer r13 = r11.a();
        if (r13 != null) goto L32;
    L33:
        Integer r111 = r11.a();
        if (r111 != null) goto L37;
    L39:
        boolean r112 = false;
    L41:
        if (r112 == true) goto L43;
    L45:
        boolean r113 = false;
    L46:
        if (r113 == false) goto L22;
        r8.add(r10);
        goto L22
    L43:
        if (com.larus.utils.o0.d(r11.b()) == false) goto L45;
        r113 = true;
        goto L46
    L37:
        if (r111.intValue() != 9999) goto L39;
    L40:
        r112 = true;
        goto L41
    L32:
        if (r13.intValue() == 11) goto L40;
    L27:
        if (r12.intValue() == 1) goto L40;
    L48:
        LinkedHashSet r114 = new LinkedHashSet();
        Iterator r9 = r8.iterator();
    L50:
        if (r9.hasNext() == false) goto L53;
        String r115 = ((v0) r9.next()).b();
        Intrinsics.checkNotNull(r115);
        r114.add(r115);
        goto L50
    L53:
        if (r114.isEmpty() == false) goto L58;
        FLogger.a.e("FileExportTypeChooseDialog", "messageIds empty");
        r0.label = 1;
        if (r14.X90(2131905593, r0) != r2) goto L87;
        return r2;
    L58:
        r0.label = 2;
        j r20 = new j(IntrinsicsKt.intercepted(r0), 1);
        r20.C();
        com.larus.im.d.e().d(r114, new i1(r20));
        r16 = r20.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L61;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L61:
        if (r16 != r2) goto L63;
        return r2;
    L7:
        r0 = new FileExportTypeChooseDialog$exportTxtFile$1(r14, r15);
        goto L8
    }

    public static final Object U90(FileExportTypeChooseDialog r12, Continuation r13) {
        r12.getClass();
        if ((r13 instanceof FileExportTypeChooseDialog$openFileExportH5$1) == false) goto L7;
        FileExportTypeChooseDialog$openFileExportH5$1 r0 = (FileExportTypeChooseDialog$openFileExportH5$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r7 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r14);
    L62:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);
    L58:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r14);
    L61:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r14);
    L27:
        dm9.a.a r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L30;
        com.larus.bmhome.share.network.e r16 = (com.larus.bmhome.share.network.e) ((dm9.a.b) r15).a.getData();
        if (r16 == null) goto L39;
        String r17 = r16.a();
    L40:
        if (r17 != null) goto L43;
        r17 = "";
    L43:
        if (r17.length() == 0) goto L46;
        r7 = false;
    L46:
        if (r7 == false) goto L48;
    L54:
        r0.label = 3;
        if (r12.X90(2131905593, r0) != r2) goto L58;
        return r2;
    L48:
        if (Intrinsics.areEqual(r17, "0") == true) goto L54;
        FLogger.a.d("FileExportTypeChooseDialog", "message export save success, export id: ".concat(r17));
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        FileExportTypeChooseDialog$openFileExportH5$2 r5 = new FileExportTypeChooseDialog$openFileExportH5$2(r12, r17, null);
        r0.label = 4;
        if (BuildersKt.withContext(r4, r5, r0) != r2) goto L62;
        return r2;
    L39:
        r17 = null;
        goto L40
    L30:
        if ((r15 instanceof dm9.a.a) == false) goto L60;
        FLogger r6 = FLogger.a;
        StringBuilder r8 = new StringBuilder("message export save failed, code: ");
        dm9.a.a r18 = r15;
        r8.append(r18.a);
        r8.append(", msg: ");
        r8.append(r18.b);
        r8.append(", e: ");
        r8.append(r18.c);
        r6.e("FileExportTypeChooseDialog", r8.toString());
        r0.label = 2;
        if (r12.X90(2131908080, r0) != r2) goto L61;
        return r2;
    L60:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r14);
        String r19 = r12.g;
        List<v0> r9 = r12.m;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        v0 r20 = (v0) r11.next();
        r10.add(new c(r20.b(), r20.a()));
        goto L22
    L24:
        com.larus.bmhome.share.network.d r21 = new com.larus.bmhome.share.network.d(r19, r10, r12.p, 2);
        MessageShareApi.Companion r110 = MessageShareApi.a;
        FileExportTypeChooseDialog$openFileExportH5$result$1 r22 = new FileExportTypeChooseDialog$openFileExportH5$result$1(r21, null);
        r0.label = 1;
        r110.getClass();
        r14 = MessageShareApi.Companion.b(r22, r0);
        if (r14 != r2) goto L27;
        return r2;
    L7:
        r0 = new FileExportTypeChooseDialog$openFileExportH5$1(r12, r13);
        goto L8
    }

    public final Object X90(int r4, ContinuationImpl r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getMain(), new FileExportTypeChooseDialog$toastFailure$2(this, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final void onViewCreated(View r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r23, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r23, r24);
        Bundle r0 = getArguments();
        LarusDialogFileExportTypeChooseBinding r2 = null;
        String r3 = "";
        if (r0 == null) goto L5;
        String r1 = r0.getString("conv_id", "");
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        this.g = r1;
        Bundle r4 = getArguments();
        if (r4 == null) goto L11;
        String r5 = r4.getString("bot_name", "");
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        this.h = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L17;
        String r7 = r6.getString("bot_id", "");
    L18:
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        this.k = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L23;
        String r9 = r8.getString("export_action_id", "");
    L24:
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        this.i = r9;
        Bundle r10 = getArguments();
        long r11 = 0;
        if (r10 == null) goto L29;
        r11 = r10.getLong("chat_key", 0);
    L29:
        this.j = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L33;
        String r13 = r12.getString("click_module");
        if (r13 == null) goto L33;
    L34:
        this.l = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L38;
        String r15 = r14.getString("extra_deep_research_id", "");
        if (r15 == null) goto L38;
    L39:
        this.o = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L43;
        String r17 = r16.getString("extra_deep_research_report_id", "");
        if (r17 == null) goto L43;
    L44:
        this.p = r17;
        Bundle r18 = getArguments();
        if (r18 == null) goto L47;
        boolean r19 = r18.getBoolean("extra_contain_encrypted", false);
    L48:
        this.q = r19;
        Bundle r20 = getArguments();
        if (r20 == null) goto L51;
        String r21 = r20.getString("current_page", "");
    L52:
        if (r21 != null) goto L54;
        r21 = "";
    L54:
        this.r = r21;
        Bundle r22 = getArguments();
        if (r22 == null) goto L57;
        String r25 = r22.getString("message_list", "");
    L58:
        if (r25 != null) goto L60;
        r25 = "";
    L60:
        Bundle r26 = getArguments();
        if (r26 == null) goto L63;
        String r27 = r26.getString("block_list", "");
    L64:
        if (r27 != null) goto L66;
        r27 = "";
    L66:
        h r28 = h.a;
        if (StringsKt.isBlank(r25) == false) goto L166;
    L78:
        Object r29 = null;
    L79:
        List<v0> r30 = (List) r29;
        if (r30 != null) goto L82;
        r30 = CollectionsKt.emptyList();
    L82:
        this.m = r30;
        h r31 = h.a;
        if (StringsKt.isBlank(r27) == false) goto L164;
    L94:
        Object r32 = null;
    L95:
        List<Block> r33 = (List) r32;
        if (r33 != null) goto L98;
        r33 = CollectionsKt.emptyList();
    L98:
        this.n = r33;
        Bundle r34 = getArguments();
        if (r34 == null) goto L101;
        String r35 = r34.getString("show_from", "");
    L102:
        if (r35 == null) goto L105;
        r3 = r35;
    L105:
        this.s = r3;
        Dialog r36 = getDialog();
        if (r36 == null) goto L108;
        r36.setOnShowListener(new w0(this));
    L108:
        LarusDialogFileExportTypeChooseBinding r37 = this.e;
        if (r37 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r37 = null;
    L111:
        r37.f.setItemType(FileExportType.word);
        LarusDialogFileExportTypeChooseBinding r38 = this.e;
        if (r38 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L114:
        r38.c.setItemType(FileExportType.pdf);
        LarusDialogFileExportTypeChooseBinding r39 = this.e;
        if (r39 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r39 = null;
    L117:
        r39.e.setItemType(FileExportType.txt);
        FileExportTypeItemView[] r40 = new FileExportTypeItemView[3];
        LarusDialogFileExportTypeChooseBinding r41 = this.e;
        if (r41 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r41 = null;
    L120:
        r40[0] = r41.f;
        LarusDialogFileExportTypeChooseBinding r42 = this.e;
        if (r42 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r42 = null;
    L123:
        r40[1] = r42.c;
        LarusDialogFileExportTypeChooseBinding r43 = this.e;
        if (r43 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r43 = null;
    L126:
        r40[2] = r43.e;
        Iterator r44 = CollectionsKt.listOf(r40).iterator();
    L128:
        if (r44.hasNext() == false) goto L131;
        final FileExportTypeItemView r45 = (FileExportTypeItemView) r44.next();
        com.larus.utils.e1.d(r45, new x0(this, r45));
        LruCache r46 = ko8.a.a;
        String r47 = r45.getFileType().toFileTypeStr();
        String r48 = this.s;
        String r49 = this.i;
        long r110 = this.j;
        String r111 = this.l;
        String r112 = CollectionsKt.joinToString$default(this.m, null, null, null, 0, null, new y0(), 31, null);
        String r113 = this.o;
        String r114 = this.r;
        e r115 = V90();
        Intrinsics.checkNotNullParameter(r48, "showFrom");
        Intrinsics.checkNotNullParameter(r47, "filType");
        Intrinsics.checkNotNullParameter(r49, "exportActionId");
        IAIChatControlTraceService.a.Ea(r48, r47, r49, r110, r111, r112, r113, r114, r115);
        goto L128
    L131:
        if (this.q == true) goto L133;
        W90(FileExportType.word);
    L134:
        LarusDialogFileExportTypeChooseBinding r50 = this.e;
        if (r50 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L137:
        com.larus.utils.e1.d(r50.b, new z0(this));
        LarusDialogFileExportTypeChooseBinding r51 = this.e;
        if (r51 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r51 = null;
    L140:
        com.larus.utils.e1.d(r51.d, new a1(this));
        Context r52 = getContext();
        if (r52 == null) goto L148;
        Dialog r53 = getDialog();
        if (r53 == null) goto L148;
        Window r54 = r53.getWindow();
        if (r54 == null) goto L148;
        r54.setNavigationBarColor(ContextCompat.getColor(r52, v19.c.b(2130970534, r52, 2131102545)));
    L148:
        if (this.q == false) goto L169;
        LarusDialogFileExportTypeChooseBinding r55 = this.e;
        if (r55 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r55 = null;
    L152:
        r55.f.setClickable(false);
        LarusDialogFileExportTypeChooseBinding r56 = this.e;
        if (r56 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r56 = null;
    L155:
        r56.f.setAlpha(0.5f);
        LarusDialogFileExportTypeChooseBinding r57 = this.e;
        if (r57 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r57 = null;
    L158:
        r57.c.setClickable(false);
        LarusDialogFileExportTypeChooseBinding r58 = this.e;
        if (r58 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L162:
        r2.c.setAlpha(0.5f);
        return;
    L161:
        r2 = r58;
        goto L162
    L169:
        return;
    L133:
        W90(FileExportType.txt);
        goto L134
    L101:
        r35 = null;
        goto L102
    L164:
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L87
        r31.getClass();     // Catch: Throwable -> L87
        r32 = Result.constructor-impl(h.b.fromJson(r27, new m1().getType()));     // Catch: Throwable -> L87
    L89:
        Throwable r60 = Result.exceptionOrNull-impl(r32);
        if (r60 == null) goto L93;
        com.larus.im.internal.delegate.c0 r61 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r62 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r60, "<this>");
        r62.append(ExceptionsKt.stackTraceToString(r60));
        r61.e("GsonHolder", r62.toString());
    L93:
        if (Result.isFailure-impl(r32) == false) goto L95;
    L87:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    L166:
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L71
        r28.getClass();     // Catch: Throwable -> L71
        r29 = Result.constructor-impl(h.b.fromJson(r25, new l1().getType()));     // Catch: Throwable -> L71
    L73:
        Throwable r65 = Result.exceptionOrNull-impl(r29);
        if (r65 == null) goto L77;
        com.larus.im.internal.delegate.c0 r66 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r116 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r65, "<this>");
        r116.append(ExceptionsKt.stackTraceToString(r65));
        r66.e("GsonHolder", r116.toString());
    L77:
        if (Result.isFailure-impl(r29) == false) goto L79;
    L71:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L63:
        r27 = null;
        goto L64
    L57:
        r25 = null;
        goto L58
    L51:
        r21 = null;
        goto L52
    L47:
        r19 = false;
    L43:
        r17 = "";
    L38:
        r15 = "";
    L33:
        r13 = "main_text";
        goto L34
    L23:
        r9 = null;
        goto L24
    L17:
        r7 = null;
        goto L18
    L11:
        r5 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static final Object T90(FileExportTypeChooseDialog r9, Message r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof FileExportTypeChooseDialog$getMarkdownForMessage$1) == false) goto L7;
        FileExportTypeChooseDialog$getMarkdownForMessage$1 r0 = (FileExportTypeChooseDialog$getMarkdownForMessage$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L26:
        List r14 = (List) r12;
        if (r14 == null) goto L29;
        String r15 = CollectionsKt.joinToString$default(r14, "\n", null, null, 0, null, null, 62, null);
    L31:
        return r15;
    L29:
        r15 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        IChatAzerothService r16 = com.larus.bmhome.x.a();
        Intrinsics.checkNotNull(r16);
        if (r16.d(r10) == true) goto L17;
        com.larus.bmhome.chat.layout.holder.helper.s0 r17 = ILegacyChatUiServiceDelegate.b.X8();
        if (r17 == null) goto L29;
        TargetDataSource r3 = TargetDataSource.Content;
        r0.label = 1;
        r12 = r17.a(r10, "\n\n", r3, r0);
        if (r12 != r13) goto L26;
        return r13;
    L17:
        if (z2.a.isPinEncryptionDiscontinue() == false) goto L19;
        int r18 = 2131908792;
    L32:
        return AppHost.a.getApplication().getString(r18);
    L19:
        r18 = 2131900677;
    L7:
        r0 = new FileExportTypeChooseDialog$getMarkdownForMessage$1(r9, r11);
        goto L8
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562071, r10, false);
        int r13 = 2131365114;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r12, 2131365114);
        if (r3 == null) goto L17;
        r13 = 2131382085;
        FileExportTypeItemView r4 = ViewBindings.findChildViewById(r12, 2131382085);
        if (r4 == null) goto L17;
        r13 = 2131382890;
        RoundTextView r5 = ViewBindings.findChildViewById(r12, 2131382890);
        if (r5 == null) goto L17;
        r13 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131388772)) == null) goto L17;
        r13 = 2131391740;
        FileExportTypeItemView r6 = ViewBindings.findChildViewById(r12, 2131391740);
        if (r6 == null) goto L17;
        r13 = 2131393311;
        FileExportTypeItemView r7 = ViewBindings.findChildViewById(r12, 2131393311);
        if (r7 == null) goto L17;
        View r14 = (ConstraintLayout) r12;
        this.e = new LarusDialogFileExportTypeChooseBinding(r14, r3, r4, r5, r6, r7);
        return ((PaneAwareBottomSheetController) this.u.getValue()).f(r9.getContext(), r14);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}

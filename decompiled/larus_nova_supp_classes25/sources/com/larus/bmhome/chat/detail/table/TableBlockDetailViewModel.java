package com.larus.bmhome.chat.detail.table;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.network.SharePanelShowHelper;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ_\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2'\b\u0002\u0010)\u001a!\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0010\u0018\u00010*JS\u0010/\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2'\b\u0002\u0010)\u001a!\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0010\u0018\u00010*H\u0002J\u001e\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c032\u0006\u00104\u001a\u000201H\u0002J\u001a\u00105\u001a\u0004\u0018\u00010+2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0002JK\u00106\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2'\b\u0002\u0010)\u001a!\u0012\u0015\u0012\u0013\u0018\u000108¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u0010\u0018\u00010*R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/detail/table/TableBlockDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_shareDetailData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/share/network/ShareDetailData;", "shareDetailData", "Landroidx/lifecycle/LiveData;", "getShareDetailData", "()Landroidx/lifecycle/LiveData;", "sharePanelShowHelper", "Lcom/larus/bmhome/share/network/SharePanelShowHelper;", "paint", "Landroid/graphics/Paint;", "tryShowSharePanel", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "loadingAbility", "Lcom/larus/bmhome/share/network/SharePanelShowLoadingAbility;", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "conversationId", "", "messageId", "node", "Lcom/ixigua/lib/track/ITrackNode;", "saveTableToImage", "fragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "qrCodeUrl", "contentMarkDown", "loadDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "resultCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "doSaveTableToImage", "calcTableWidth", "", "lines", "", "cellCount", "generateQRCode", "saveContentToFile", "content", "Ljava/io/File;", "file", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TableBlockDetailViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "TableBlockDetailViewModel";
    private final MutableLiveData<com.larus.bmhome.share.network.i> _shareDetailData;
    private final Paint paint;
    private final LiveData<com.larus.bmhome.share.network.i> shareDetailData;
    private final SharePanelShowHelper sharePanelShowHelper;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$doSaveTableToImage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$doSaveTableToImage$1", f = "TableBlockDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $cellCount;
        final /* synthetic */ String $contentMarkDown;
        final /* synthetic */ Context $context;
        final /* synthetic */ List<String> $lines;
        final /* synthetic */ l0 $loadDialog;
        final /* synthetic */ Ref.ObjectRef<Deferred<Unit>> $loadingDeferred;
        final /* synthetic */ String $qrCodeUrl;
        final /* synthetic */ Function1<Bitmap, Unit> $resultCallback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TableBlockDetailViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$doSaveTableToImage$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$doSaveTableToImage$1$1", f = "TableBlockDetailViewModel.kt", i = {}, l = {DoraCallStateCode.RTOS_STOP_SI_BY_GESTURE}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ l0 $loadDialog;
            int label;

            public C00601(l0 r1, Continuation<? super C00601> r2) {
                this.$loadDialog = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00601(this.$loadDialog, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public static void INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$doSaveTableToImage$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
                if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
                DialogLancet.handleBlockedDialogShow(r1);
                return;
            L10:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
            L7:
                DialogLancet.beforeDialogShow(r1);
                r1.show();
                DialogLancet.afterDialogShow(r1);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L11:
                FLogger.a.d(TableBlockDetailViewModel.TAG, "doSaveTableToImage: show loading");
                l0 r5 = this.$loadDialog;
                if (r5 == null) goto L14;
                INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$doSaveTableToImage$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r5);
                return Unit.INSTANCE;
            L14:
                return null;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                this.label = 1;
                if (DelayKt.delay(500, this) != r0) goto L11;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Ref.ObjectRef<Deferred<Unit>> r1, Context r2, TableBlockDetailViewModel r3, List<String> r4, int r5, String r6, String r7, Function1<? super Bitmap, Unit> r8, l0 r9, Continuation<? super AnonymousClass1> r10) {
            this.$loadingDeferred = r1;
            this.$context = r2;
            this.this$0 = r3;
            this.$lines = r4;
            this.$cellCount = r5;
            this.$contentMarkDown = r6;
            this.$qrCodeUrl = r7;
            this.$resultCallback = r8;
            this.$loadDialog = r9;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            AnonymousClass1 r11 = new AnonymousClass1(this.$loadingDeferred, this.$context, this.this$0, this.$lines, this.$cellCount, this.$contentMarkDown, this.$qrCodeUrl, this.$resultCallback, this.$loadDialog, r14);
            r11.L$0 = r13;
            return r11;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$doSaveTableToImage$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final Object invokeSuspend(Object r68) {
            AnonymousClass1 r0 = this;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (r0.label != 0) goto L40;
            ResultKt.throwOnFailure(r68);
            CoroutineScope r2 = (CoroutineScope) r0.L$0;
            Ref.ObjectRef<Deferred<Unit>> r9 = r0.$loadingDeferred;     // Catch: Throwable -> L41
            r9.element = BuildersKt.async$default(r2, null, null, new C00601(r0.$loadDialog, null), 3, null);     // Catch: Throwable -> L41
            FLogger.a.d(TableBlockDetailViewModel.TAG, "doSaveTableToImage...");     // Catch: Throwable -> L41
            Context r3 = r0.$context;     // Catch: Throwable -> L41
            Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L41
            View r4 = LayoutInflater.from(r3).inflate(2131562823, null, false);     // Catch: Throwable -> L41
            final FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r4, 2131367812);     // Catch: Throwable -> L41
            if (r10 == null) goto L27;
            HorizontalScrollView r5 = (HorizontalScrollView) r4;     // Catch: Throwable -> L41
            CustomMarkdownTextView r6 = new CustomMarkdownTextView(r0.$context, null, 6, 0);     // Catch: Throwable -> L41
            r6.setBottomLineWeight(i5.x0(v19.c.b(2130971253, null, 2131166876)));     // Catch: Throwable -> L41
            r6.setLineColor(1207959551);     // Catch: Throwable -> L41
            r6.setTextSize(0, we8.a.a(i5.o(), false));     // Catch: Throwable -> L41
            r6.setLineSpacing(0.0f, 1.25f);     // Catch: Throwable -> L41
            Intrinsics.checkNotNullParameter(r6, "view");     // Catch: Throwable -> L41
            r10.removeAllViews();     // Catch: Throwable -> L41
            r10.addView(r6);     // Catch: Throwable -> L41
            int r7 = TableBlockDetailViewModel.access$calcTableWidth(r0.this$0, r0.$lines, r0.$cellCount);     // Catch: Throwable -> L41
            AppHost.Companion r8 = AppHost.a;     // Catch: Throwable -> L41
            int r11 = Math.min((com.larus.utils.i.d(r8.getApplication()) - (i5.k0() * 2)) / r0.$cellCount, i5.w());     // Catch: Throwable -> L41
            gw8.c.a.getClass();     // Catch: Throwable -> L41
            gw8.c r12 = gw8.c.a.b();     // Catch: Throwable -> L41
            if (r12 != null) goto L42;
            lw8.l r1 = null;
        L44:
            r6.C(r1, null, null, null);     // Catch: Throwable -> L24
            final Bitmap r17 = TableBlockDetailViewModel.access$generateQRCode(this.this$0, this.$context, this.$qrCodeUrl);     // Catch: Throwable -> L41
            Activity r13 = r8.a().getCurrentActivity();     // Catch: Throwable -> L41
            if (r13 == null) goto L19;
            final FrameLayout r15 = (FrameLayout) r13.findViewById(R.id.content);     // Catch: Throwable -> L41
        L20:
            if (r15 == null) goto L22;
            HorizontalScrollView r14 = r5;
            r15.addView(r14, new FrameLayout.LayoutParams(-2, -2));     // Catch: Throwable -> L41
        L23:
            e1.q(r14);     // Catch: Throwable -> L41
            SoftReference r16 = y.a;     // Catch: Throwable -> L41
            final Context r18 = this.$context;     // Catch: Throwable -> L41
            final Ref.ObjectRef<Deferred<Unit>> r19 = this.$loadingDeferred;     // Catch: Throwable -> L41
            final l0 r110 = this.$loadDialog;     // Catch: Throwable -> L41
            final Function1<Bitmap, Unit> r111 = this.$resultCallback;     // Catch: Throwable -> L41
            final HorizontalScrollView r112 = r14;
            Runnable r20 = new r(r10, r18, r19, r110, r111, r15, r112, r17);     // Catch: Throwable -> L41
            Intrinsics.checkNotNullParameter(r20, "action");     // Catch: Throwable -> L41
            y.d(r20, 300);     // Catch: Throwable -> L41
        L38:
            return Unit.INSTANCE;
        L22:
            r14 = r5;
            goto L23
        L19:
            r15 = null;
        L24:
            r0 = this;
            goto L28
        L42:
            String r113 = r0.$contentMarkDown;     // Catch: Throwable -> L11
            int r114 = i5.r0();     // Catch: Throwable -> L11
            int r31 = i5.r0();     // Catch: Throwable -> L11
            float r21 = we8.a.a(i5.o(), false);     // Catch: Throwable -> L11
            int r22 = i5.b();     // Catch: Throwable -> L11
            Context r23 = r0.$context;     // Catch: Throwable -> L11
            int r24 = ContextCompat.getColor(r23, v19.c.b(2130972089, r23, 2131103169));     // Catch: Throwable -> L11
            int r115 = i5.q();     // Catch: Throwable -> L11
            int r116 = i5.r0();     // Catch: Throwable -> L11
            int r25 = ContextCompat.getColor(r0.$context, R.color.transparent);     // Catch: Throwable -> L11
            Context r117 = r0.$context;     // Catch: Throwable -> L11
            int r26 = ContextCompat.getColor(r117, v19.c.b(2130972086, r117, 2131103159));     // Catch: Throwable -> L11
            r1 = gw8.c.b.b(r12, r6, r113, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, new TableConfig(false, 0, Boxing.boxFloat(r21), Boxing.boxInt(r22), Boxing.boxInt(r24), null, Boxing.boxInt(r31), Boxing.boxInt(r114), Boxing.boxInt(r7), Boxing.boxInt(r11), Boxing.boxInt(r115), Boxing.boxInt(r116), null, null, false, false, false, false, false, null, Boxing.boxInt(r25), Boxing.boxInt(r26), 1044515, null), null, null, null, null, null, null, -4194305, 31));     // Catch: Throwable -> L11
        L11:
            r0 = this;
            goto L28
        L27:
            throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131367812)));     // Catch: Throwable -> L41
        L28:
            Function1<Bitmap, Unit> r27 = r0.$resultCallback;
            if (r27 == null) goto L31;
            r27.invoke(null);
        L31:
            Deferred r28 = (Deferred) r0.$loadingDeferred.element;
            if (r28 == null) goto L34;
            Job.DefaultImpls.cancel$default(r28, null, 1, null);
        L34:
            l0 r29 = r0.$loadDialog;
            if (r29 == null) goto L38;
            INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$doSaveTableToImage$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r29);
            goto L38
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$saveContentToFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.table.TableBlockDetailViewModel$saveContentToFile$1", f = "TableBlockDetailViewModel.kt", i = {1}, l = {316, 325}, m = "invokeSuspend", n = {"loadingDeferred"}, s = {"L$0"})
    public static final class C01541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ Context $context;
        final /* synthetic */ l0 $loadDialog;
        final /* synthetic */ Function1<File, Unit> $resultCallback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01541(Function1<? super File, Unit> r1, Context r2, String r3, l0 r4, Continuation<? super C01541> r5) {
            this.$resultCallback = r1;
            this.$context = r2;
            this.$content = r3;
            this.$loadDialog = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01541 r6 = new C01541(this.$resultCallback, this.$context, this.$content, this.$loadDialog, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$saveContentToFile$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Deferred r2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r13);
        L23:
            l0 r3 = this.$loadDialog;
            Function1<File, Unit> r4 = this.$resultCallback;
            File r14 = (File) r13;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
            if (r3 == null) goto L26;
            INVOKEVIRTUAL_com_larus_bmhome_chat_detail_table_TableBlockDetailViewModel$saveContentToFile$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);
        L26:
            FLogger.a.d(TableBlockDetailViewModel.TAG, "saveCodeToFile: shareFileDeferred dismiss loading");
            if (r4 == null) goto L30;
            r4.invoke(r14);
        L30:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Function1<File, Unit> r5 = (Function1) this.L$0;
            ResultKt.throwOnFailure(r13);
        L18:
            r5.invoke(r13);
            goto L30
        L10:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            Deferred r6 = BuildersKt.async$default(r15, Dispatchers.getIO(), null, new TableBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1(this.$context, this.$content, null), 2, null);
            if (r6.isCompleted() == false) goto L19;
            FLogger.a.d(TableBlockDetailViewModel.TAG, "saveCodeToFile: shareFileDeferred is Complete");
            Function1<File, Unit> r16 = this.$resultCallback;
            if (r16 == null) goto L30;
            this.L$0 = r16;
            this.label = 1;
            Object r7 = r6.await(this);
            if (r7 != r0) goto L17;
            return r0;
        L17:
            r5 = r16;
            r13 = r7;
            goto L18
        L19:
            Deferred r17 = BuildersKt.async$default(r15, null, null, new TableBlockDetailViewModel$saveContentToFile$1$loadingDeferred$1(r6, this.$loadDialog, null), 3, null);
            this.L$0 = r17;
            this.label = 2;
            Object r8 = r6.await(this);
            if (r8 != r0) goto L22;
            return r0;
        L22:
            r2 = r17;
            r13 = r8;
            goto L23
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(TableBlockDetailViewModel r0, Context r1, String r2, String r3, l0 r4, Function1 r5, boolean r6) {
        return saveTableToImage$lambda$2(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit yo(TableBlockDetailViewModel r0, com.larus.bmhome.share.network.i r1) {
        return tryShowSharePanel$lambda$1(r0, r1);
    }

    public TableBlockDetailViewModel() {
        MutableLiveData<com.larus.bmhome.share.network.i> r0 = new MutableLiveData();
        this._shareDetailData = r0;
        this.shareDetailData = r0;
        this.sharePanelShowHelper = new SharePanelShowHelper(ViewModelKt.getViewModelScope(this));
        Paint r1 = new Paint();
        r1.setTextSize(i5.o());
        this.paint = r1;
    }

    public final LiveData<com.larus.bmhome.share.network.i> getShareDetailData() {
        return this.shareDetailData;
    }

    private final int calcTableWidth(List<String> r14, int r15) {
        int r0 = com.larus.utils.i.d(AppHost.a.getApplication()) - (i5.k0() * 2);
        int r16 = r0 / r15;
        int r1 = i5.q();
        Iterator<T> r17 = r14.iterator();
        int r3 = 0;
    L4:
        if (r17.hasNext() == false) goto L12;
        Iterator r4 = StringsKt.split$default(StringsKt.trim((String) r17.next(), new char[]{'|'}), new String[]{"|"}, false, 0, 6, null).iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L11;
        String r6 = (String) r4.next();
        if (o0.d(r6) == false) goto L7;
        r5 = r5 + Math.min(MathKt.roundToInt(this.paint.measureText(StringsKt.trim(r6).toString())) + (r1 * 2), r16);
        goto L7
    L11:
        r3 = Math.max(r0, Math.max(r3, r5));
        goto L4
    L12:
        return r3;
    }

    private final Bitmap generateQRCode(Context r7, String r8) {
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        r4.put(EncodeHintType.MARGIN, 1);
        return o19.a.a(r8, i5.k0(), i5.k0(), ContextCompat.getColor(r7, v19.c.b(2130972079, r7, 2131103136)), r4, z2.a.shareQrCodeUseCustomStyle());
    }

    private static final Unit tryShowSharePanel$lambda$1(TableBlockDetailViewModel r1, com.larus.bmhome.share.network.i r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        r1._shareDetailData.postValue(r2);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ int access$calcTableWidth(TableBlockDetailViewModel r0, List r1, int r2) {
        return r0.calcTableWidth(r1, r2);
    }

    public static final /* synthetic */ Bitmap access$generateQRCode(TableBlockDetailViewModel r0, Context r1, String r2) {
        return r0.generateQRCode(r1, r2);
    }

    public final void saveContentToFile(Context r11, String r12, l0 r13, Function1<? super File, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r12 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        FLogger.a.i(TAG, "saveCodeToFile: codeContent is null or empty");
        if (r14 == null) goto L16;
        r14.invoke(null);
        return;
    L16:
        return;
    L14:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01541(r14, r11, r12, r13, null), 3, null);
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    private final void doSaveTableToImage(Context r16, String r17, String r18, l0 r19, Function1<? super Bitmap, Unit> r20) {
        List r4 = StringsKt.split$default(r18, new String[]{"\n"}, false, 0, 6, null);
        if (r4.isEmpty() == false) goto L8;
        FLogger.a.i(TAG, "doSaveTableToImage: lines List is empty");
        if (r20 == null) goto L16;
        r20.invoke(null);
        return;
    L16:
        return;
    L8:
        int r5 = StringsKt.split$default(StringsKt.trim((String) ListProtector.get(r4, 0), new char[]{'|'}), new String[]{"|"}, false, 0, 6, null).size();
        if (r5 > 0) goto L14;
        FLogger.a.i(TAG, "doSaveTableToImage: cellCount error");
        if (r20 == null) goto L17;
        r20.invoke(null);
        return;
    L17:
        return;
    L14:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(new Ref.ObjectRef(), r16, this, r4, r5, r18, r17, r20, r19, null), 3, null);
    }

    public final void saveTableToImage(Fragment r10, final Context r11, final String r12, final String r13, final l0 r14, final Function1<? super Bitmap, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        if (r11 != null) goto L5;
        return;
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        if (r12 != null) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT <= 29) goto L12;
        doSaveTableToImage(r11, r12, r13, r14, r15);
        return;
    L12:
        if (ContextCompat.checkSelfPermission(r11, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L14;
        doSaveTableToImage(r11, r12, r13, r14, r15);
        return;
    L14:
        i2 r1 = i2.b;
        i2.q(r10, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new p(this, r11, r12, r13, r14, r15));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveContentToFile$default(TableBlockDetailViewModel r0, Context r1, String r2, l0 r3, Function1 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.saveContentToFile(r1, r2, r3, r4);
    }

    private static final Unit saveTableToImage$lambda$2(TableBlockDetailViewModel r0, Context r1, String r2, String r3, l0 r4, Function1 r5, boolean r6) {
        if (r6 == false) goto L5;
        r0.doSaveTableToImage(r1, r2, r3, r4, r5);
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doSaveTableToImage$default(TableBlockDetailViewModel r6, Context r7, String r8, String r9, l0 r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.doSaveTableToImage(r7, r8, r9, r10, r11);
    }

    public final void tryShowSharePanel(FragmentActivity r15, ShareScene r16, com.larus.bmhome.share.network.j r17, com.larus.bmhome.share.panel.b r18, com.larus.bmhome.share.panel.h r19, String r20, String r21, by7.e r22) {
        Intrinsics.checkNotNullParameter(r16, "shareScene");
        Intrinsics.checkNotNullParameter(r17, "loadingAbility");
        Intrinsics.checkNotNullParameter(r18, "shareContent");
        Intrinsics.checkNotNullParameter(r19, "eventParam");
        Intrinsics.checkNotNullParameter(r20, "conversationId");
        Intrinsics.checkNotNullParameter(r21, "messageId");
        Intrinsics.checkNotNullParameter(r22, "node");
        if (r15 != null) goto L5;
        return;
    L5:
        SharePanelShowHelper r2 = this.sharePanelShowHelper;
        Function1 r13 = new q(this);
        int r1 = SharePanelShowHelper.d;
        r2.c(r15, r17, r16, r19, r18, r20, r21, r22, true, null, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveTableToImage$default(TableBlockDetailViewModel r7, Fragment r8, Context r9, String r10, String r11, l0 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.saveTableToImage(r8, r9, r10, r11, r12, r13);
    }
}

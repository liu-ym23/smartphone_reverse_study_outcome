package com.larus.bmhome.bigimg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.common_ui.image.CustomPhotoTransitionPagerAdapter;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.larus.common_ui.photoviewer.transition.TransitionPagerAdapter;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0016J\u0018\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\tH\u0002J\u000f\u0010=\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000208H\u0002J \u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020$J\u0010\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020$H\u0002J\u0010\u0010K\u001a\u0002082\u0006\u0010J\u001a\u00020$H\u0002J\b\u0010L\u001a\u000208H\u0002J\"\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020\t2\u0006\u0010;\u001a\u00020$2\b\b\u0002\u0010O\u001a\u00020\rH\u0002J\u0010\u0010P\u001a\u0002082\u0006\u0010F\u001a\u00020$H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010;\u001a\u00020$H\u0002J\u001e\u0010R\u001a\u0002082\f\u0010S\u001a\b\u0012\u0004\u0012\u0002080T2\u0006\u0010U\u001a\u00020\tH\u0016J\n\u0010V\u001a\u00020\t*\u00020\tJ(\u0010W\u001a\u0002082\u0006\u0010F\u001a\u00020$2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\tJ\u0010\u0010\f\u001a\u0002082\u0006\u0010;\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020$0.j\b\u0012\u0004\u0012\u00020$`/X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog;", "Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "Lcom/larus/bmhome/bigimg/IHandleMoreAction;", "context", "Landroid/content/Context;", "imageUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "thumbImageUrls", "", "reportParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "showIndicator", "", "actionCallback", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;ZLcom/larus/bmhome/bigimg/IHandleMoreAction;)V", "getImageUrls", "()Ljava/util/List;", "setImageUrls", "(Ljava/util/List;)V", "getActionCallback", "()Lcom/larus/bmhome/bigimg/IHandleMoreAction;", "share", "Landroid/widget/ImageView;", "download", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "more", "Landroidx/appcompat/widget/AppCompatImageView;", "backIcon", "timeView", "Landroid/widget/TextView;", "poiView", "titleBar", "Landroid/view/ViewGroup;", "safeCurrentPos", "", "getSafeCurrentPos", "()I", "previousIndex", "startTime", "", "loadedIndexList", "", "filteredIndexList", "enterPicDetailEventHistory", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "imageChangedByScrollListener", "Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "getImageChangedByScrollListener", "()Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;", "setImageChangedByScrollListener", "(Lcom/larus/bmhome/bigimg/BigCreationChangedByScrollListener;)V", "isTransition", "onAttachedToWindow", "", "onDetachedFromWindow", "reportEnterPicDetailEvent", "pos", "enterMethod", "getExtraViewLayout", "()Ljava/lang/Integer;", "initIconListeners", "handleMediaReplaced", "mediaId", "newPath", "mediaItem", "Lcom/larus/bmhome/bigimg/MediaItem;", "refreshCurrentDisplayedMedia", "position", "performDirectDelete", "deletePos", "cleanupStatesAfterDelete", "deletedPos", "updateIndexesAfterDelete", "updateUIAfterDelete", "onDoShareAction", "source", "onlyShare", "updateIconStatus", "refreshMoreIcon", "handleDelete", "confirmCallback", "Lkotlin/Function0;", "path", "removeFileUriPrefix", "showAnimatedSafely", "view", "Landroid/view/View;", "enableRestoreTransition", "tag", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BigImageLocalPhotoViewerDialog extends CustomPhotoViewerDialog implements l1 {
    public static final /* synthetic */ int H = 0;
    public final ViewGroup A;
    public int B;
    public final long C;
    public final Set<Integer> D;
    public final Set<Integer> E;
    public final HashSet<Integer> F;
    public boolean G;
    public final Context q;
    public List<n1> r;
    public final boolean s;
    public final l1 t;
    public final ImageView u;
    public final CommonDownLoadLayout v;
    public final AppCompatImageView w;
    public final ImageView x;
    public final TextView y;
    public final TextView z;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8", f = "BigImageLocalPhotoViewerDialog.kt", i = {}, l = {DoraCallStateCode.DOUBAO_START_LIVE_TUTOR}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BigImageLocalPhotoViewerDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog$8$2", f = "BigImageLocalPhotoViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BigImageLocalPhotoViewerDialog this$0;

            public AnonymousClass2(BigImageLocalPhotoViewerDialog r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L22;
                ResultKt.throwOnFailure(r3);
                final BigImageLocalPhotoViewerDialog r4 = this.this$0;
                int r0 = BigImageLocalPhotoViewerDialog.H;
                r4.getClass();
                AppHost.a.isPlugin();
                ImageView r1 = r4.u;
                if (r1 == null) goto L7;
                r1.setVisibility(8);
            L7:
                ConstraintLayout r2 = r4.v;
                if (r2 == null) goto L10;
                com.larus.utils.e1.o(r2);
            L10:
                ImageView r5 = r4.u;
                if (r5 == null) goto L13;
                com.larus.utils.e1.d(r5, new m(r4));
            L13:
                AppCompatImageView r6 = r4.w;
                if (r6 == null) goto L16;
                com.larus.utils.e1.d(r6, new p(r4));
            L16:
                ImageView r7 = r4.x;
                if (r7 == null) goto L20;
                com.larus.utils.e1.d(r7, new q(r4));
            L20:
                return Unit.INSTANCE;
            L22:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass8(BigImageLocalPhotoViewerDialog r1, Continuation<? super AnonymousClass8> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass8(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            final BigImageLocalPhotoViewerDialog r7 = this.this$0;
            CustomPhotoTransitionPagerAdapter r2 = ((CustomPhotoViewerDialog) r7).n;
            r2.n = new a0(r7);
            MainCoroutineDispatcher r8 = Dispatchers.getMain();
            AnonymousClass2 r3 = new AnonymousClass2(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r8, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog$Companion$ButtonStatus;", "", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface ButtonStatus {
            public static final int AddedPrivate = 2;
            public static final int AddedPublic = 3;
            public static final a Companion = null;
            public static final int Disable = 0;
            public static final int UnAdd = 1;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    static {
    }

    public final int l() {
        if (((PhotoViewerDialog) this).f <= (this.r.size() - 1)) goto L6;
        return this.r.size() - 1;
    L6:
        return ((PhotoViewerDialog) this).f;
    }

    public final Integer g() {
        return 2131562805;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        boolean r0 = g.a;
        g.a = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        boolean r0 = g.a;
        g.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(BigImageLocalPhotoViewerDialog r3) {
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

    public final void j(int r7) {
        this.D.remove(Integer.valueOf(r7));
        this.E.remove(Integer.valueOf(r7));
        this.F.remove(Integer.valueOf(r7));
        Set<Integer> r0 = this.D;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        if (((Number) r4).intValue() <= r7) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L10:
        Iterator r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        int r6 = ((Number) r5.next()).intValue();
        this.D.remove(Integer.valueOf(r6));
        this.D.add(Integer.valueOf(r6 - 1));
        goto L12
    L14:
        Set<Integer> r8 = this.E;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        if (((Number) r11).intValue() <= r7) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == false) goto L16;
        r9.add(r11);
        goto L16
    L20:
        r12 = false;
        goto L21
    L23:
        Iterator r13 = r9.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        int r14 = ((Number) r13.next()).intValue();
        this.E.remove(Integer.valueOf(r14));
        this.E.add(Integer.valueOf(r14 - 1));
        goto L25
    L27:
        HashSet<Integer> r15 = this.F;
        ArrayList r16 = new ArrayList();
        Iterator<Integer> r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L36;
        Integer r18 = r17.next();
        if (r18.intValue() <= r7) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == false) goto L29;
        r16.add(r18);
        goto L29
    L33:
        r19 = false;
        goto L34
    L36:
        Iterator r20 = r16.iterator();
    L38:
        if (r20.hasNext() == false) goto L40;
        int r21 = ((Number) r20.next()).intValue();
        this.F.remove(Integer.valueOf(r21));
        this.F.add(Integer.valueOf(r21 - 1));
        goto L38
    }

    public final void o(int r3) {
        t1 r4 = ((n1) ListProtector.get(this.r, r3)).b;
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L11;
        AppCompatImageView r5 = this.w;
        if (r5 == null) goto L15;
        com.larus.utils.e1.o(r5);
        return;
    L15:
        return;
    L11:
        AppCompatImageView r6 = this.w;
        if (r6 == null) goto L17;
        com.larus.utils.e1.x(r6);
        return;
    L17:
        return;
    L5:
        if (r4.d() != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void q(int r10) {
        t1 r0 = ((n1) ListProtector.get(this.r, r10)).b;
        Long r1 = null;
        if (r0 == null) goto L7;
        GeoLocationInfo r2 = r0.a();
        if (r2 == null) goto L7;
        String r3 = r2.getPoi();
    L8:
        boolean r4 = true;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L19;
        TextView r6 = this.z;
        if (r6 == null) goto L25;
        com.larus.utils.e1.o(r6);
    L25:
        int r7 = com.larus.utils.j0.a;
        String r8 = com.larus.utils.j0.d(2131902167);
        String r9 = com.larus.utils.j0.d(2131902118);
        String r11 = com.larus.utils.j0.d(2131902094);
        if (r3 == null) goto L32;
        if (r3.length() == 0) goto L32;
        r4 = false;
    L32:
        if (r4 == false) goto L34;
        String r12 = "yyyy" + r8 + "MM" + r9 + "dd" + r11 + "\nHH:mm:ss";
    L35:
        SimpleDateFormat r13 = new SimpleDateFormat(r12, Locale.CHINA);
        t1 r14 = ((n1) ListProtector.get(this.r, r10)).b;
        if (r14 == null) goto L38;
        r1 = Long.valueOf(r14.e());
    L38:
        if (r1 == null) goto L43;
        long r15 = r1.longValue();
        TextView r16 = this.y;
        if (r16 == null) goto L44;
        r16.setText(r13.format(Long.valueOf(r15)));
        return;
    L44:
        return;
    L43:
        return;
    L34:
        r12 = "yyyy" + r8 + "MM" + r9 + "dd" + r11 + " HH:mm:ss";
        goto L35
    L19:
        TextView r17 = this.z;
        if (r17 == null) goto L22;
        r17.setText(r3);
    L22:
        TextView r18 = this.z;
        if (r18 == null) goto L25;
        com.larus.utils.e1.x(r18);
        goto L25
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
    L7:
        r3 = null;
        goto L8
    }

    public final void r(int r4) {
        if (r4 == ((PhotoViewerDialog) this).f) goto L5;
        return;
    L5:
        ImageView r0 = this.u;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.D.contains(Integer.valueOf(r4)) == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        r0.setEnabled(r5);
        return;
    L10:
        if (this.E.contains(Integer.valueOf(r4)) == true) goto L12;
        r5 = true;
        goto L13
    }

    @Override // com.larus.bmhome.bigimg.l1
    public final void a(final Function0<Unit> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "confirmCallback");
        Intrinsics.checkNotNullParameter(r4, "path");
        l1 r0 = this.t;
        if (r0 == null) goto L6;
        r0.a(new o(r3), r4);
        return;
    }

    public final void p(int r4, String r5) {
        if (this.F.contains(Integer.valueOf(r4)) == true) goto L6;
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = h(r4);
        r1.put("enter_method", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("enter_picture_detail", r1);
        this.F.add(Integer.valueOf(r4));
        return;
    }

    public final void m(String r7, String r8, t1 r9) {
        Intrinsics.checkNotNullParameter(r7, "mediaId");
        Intrinsics.checkNotNullParameter(r8, "newPath");
        FLogger.a.i("BigImagePhotoViewer", "handleMediaReplaced: mediaId=" + r7 + ", newPath=" + r8);
        if (r9 != null) goto L5;
        return;
    L5:
        List<n1> r0 = CollectionsKt.toMutableList(this.r);
        int r1 = r0.size();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L16;
        t1 r5 = ((n1) ListProtector.get(r0, r3)).b;
        if (r5 == null) goto L11;
        String r6 = r5.g();
    L13:
        if (Intrinsics.areEqual(r6, r7) == true) goto L14;
        r3 = r3 + 1;
        goto L7
    L14:
        ListProtector.set(r0, r3, new n1(r8, r9));
    L17:
        if (r3 != (-1)) goto L20;
        FLogger.a.w("BigImagePhotoViewer", "Media not found for replacement: " + r7);
        return;
    L20:
        this.r = r0;
        o(l());
        ((CustomPhotoViewerDialog) this).n.B2(r0);
        ((CustomPhotoViewerDialog) this).n.notifyItemChanged(r3);
        return;
    L11:
        r6 = null;
        goto L13
    L16:
        r3 = -1;
        goto L17
    }

    public final void n(String r5, int r6, boolean r7) {
        ShareServiceDelegate r0 = ShareServiceDelegate.b;
        JSONObject r1 = h(r6);
        r1.put("click_method", r5);
        r0.w(r1);
        if (this.D.contains(Integer.valueOf(r6)) == true) goto L5;
        return;
    L5:
        if (this.E.contains(Integer.valueOf(r6)) == true) goto L54;
        if (r6 < 0) goto L50;
        List r8 = ((CustomPhotoViewerDialog) this).n.k;
        if (r8 == null) goto L11;
        int r9 = r8.size();
    L12:
        if (r6 >= r9) goto L55;
        CustomPhotoTransitionPagerAdapter r10 = ((CustomPhotoViewerDialog) this).n;
        int r2 = ((PhotoViewerDialog) this).f;
        List r11 = r10.k;
        if (r11 == null) goto L32;
        n1 r12 = (n1) CollectionsKt.getOrNull(r11, r2);
        if (r12 == null) goto L32;
        String r13 = r12.c;
        String r3 = null;
        if (r13 == null) goto L30;
        String r14 = StringsKt.substringBefore$default(r13, "?", null, 2, null);
        if (r14 == null) goto L30;
        String r15 = StringsKt.substringBefore$default(r14, "#", null, 2, null);
        if (r15 == null) goto L30;
        String r16 = StringsKt.substringAfterLast$default(r15, "/", null, 2, null);
        if (r16 == null) goto L30;
        String r17 = r16.toLowerCase(Locale.ROOT);
        if (r17 == null) goto L30;
        r3 = StringsKt.substringAfterLast$default(r17, ".", null, 2, null);
    L30:
        if (Intrinsics.areEqual(r3, "mp4") == false) goto L32;
        char r18 = 2;
    L33:
        if (r18 == 1) goto L42;
        if (r18 != 2) goto L56;
        String r19 = ((n1) ListProtector.get(this.r, r6)).c;
        if (r19 != null) goto L39;
        return;
    L39:
        IDoraEService r20 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r20 == null) goto L51;
        r20.a(r19);
        return;
    L51:
        return;
    L56:
        return;
    L42:
        String r21 = ((n1) ListProtector.get(this.r, r6)).c;
        if (r21 != null) goto L45;
        return;
    L45:
        IDoraEService r22 = (IDoraEService) ServiceManager.get().getService(IDoraEService.class);
        if (r22 == null) goto L53;
        r22.d(CollectionsKt.listOf(r21), r7);
        return;
    L53:
        return;
    L32:
        r18 = 1;
        goto L33
    L55:
        return;
    L11:
        r9 = 0;
        goto L12
    L50:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BigImageLocalPhotoViewerDialog(Context r7, List r8, uo8.k r9, boolean r10, l1 r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "imageUrls");
        Intrinsics.checkNotNullParameter(r9, "reportParams");
        super(r7, r8, null, r9);
        this.q = r7;
        this.r = r8;
        this.s = r10;
        this.t = r11;
        this.B = -1;
        this.D = new LinkedHashSet();
        this.E = new LinkedHashSet();
        this.F = new HashSet();
        this.C = System.currentTimeMillis();
        CustomPhotoTransitionPagerAdapter r12 = ((CustomPhotoViewerDialog) this).n;
        Function1 r13 = new s(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.m = r13;
        CustomPhotoTransitionPagerAdapter r14 = ((CustomPhotoViewerDialog) this).n;
        r14.o = new t(this);
        y r15 = new y(this);
        Intrinsics.checkNotNullParameter(r15, "transitionListener");
        ((TransitionPagerAdapter) r14).c.add(r15);
        ((PhotoViewerDialog) this).d = new z(this);
        setOnDismissListener(new u(this));
        setOnShowListener(new v(this));
        this.w = ((PhotoViewerDialog) this).c.findViewById(2131380286);
        this.u = (ImageView) ((PhotoViewerDialog) this).c.findViewById(2131386047);
        this.v = (CommonDownLoadLayout) ((PhotoViewerDialog) this).c.findViewById(2131370179);
        this.x = (ImageView) ((PhotoViewerDialog) this).c.findViewById(2131363762);
        this.y = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131375011);
        this.z = (TextView) ((PhotoViewerDialog) this).c.findViewById(2131375009);
        ViewGroup r16 = (ViewGroup) ((PhotoViewerDialog) this).c.findViewById(2131388775);
        this.A = r16;
        if (r16 == null) goto L9;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L8;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        com.larus.utils.i0.a.getClass();
        r18.topMargin = com.larus.utils.i0.g() + i5.r0();
        r16.setLayoutParams(r18);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass8(this, null), 3, null);
    }
}

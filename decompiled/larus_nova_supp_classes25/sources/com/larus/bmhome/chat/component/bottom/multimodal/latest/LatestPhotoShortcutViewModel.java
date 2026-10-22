package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\u000f*\u00020\rH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutViewState;", "<init>", "()V", "config", "Lcom/larus/platform/model/chat/LatestPhotoShortcutConfig;", "contentResolver", "Landroid/content/ContentResolver;", "autoDismissJob", "Lkotlinx/coroutines/Job;", "markAsShown", "", "Landroid/net/Uri;", "hasShown", "", "isSelfScreenshot", "execQueryLatestPhoto", "checkLatestPhoto", "uri", "filePath", "", "addedDate", "", "targetValid", "addedTimeValid", "setInitState", "queryLatestImage", "context", "Landroid/content/Context;", "launchAutoDismissJob", "forceLaunch", "stopAutoDismissJob", "updateShortcutViewState", "state", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ShortcutViewState;", "handleEvent", "event", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LatestPhotoShortcutViewModel extends ComponentViewModel<LatestPhotoShortcutViewState> {
    public static final a Companion = null;
    private static final String TAG = "LatestPhotoShortcutViewModel";
    private static final int TARGET_SOURCE_ALL = 0;
    private static final int TARGET_SOURCE_ONLY_SCREENSHOT = 1;
    private Job autoDismissJob;
    private final com.larus.platform.model.chat.z config;
    private ContentResolver contentResolver;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutViewModel$queryLatestImage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutViewModel$queryLatestImage$1", f = "LatestPhotoShortcutViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LatestPhotoShortcutViewModel this$0;

        public AnonymousClass1(LatestPhotoShortcutViewModel r1, Context r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$context, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            LatestPhotoShortcutViewModel.access$setContentResolver$p(this.this$0, this.$context.getContentResolver());
            LatestPhotoShortcutViewModel.access$setInitState(this.this$0);
            LatestPhotoShortcutViewModel r7 = this.this$0;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            Object r8 = Result.constructor-impl(LatestPhotoShortcutViewModel.access$execQueryLatestPhoto(r7));     // Catch: Throwable -> L7
        L9:
            Throwable r1 = Result.exceptionOrNull-impl(r8);
            if (r1 == null) goto L13;
            FLogger.a.e(LatestPhotoShortcutViewModel.TAG, "[queryLatestImage] failed, " + r1);
        L13:
            if (Result.isFailure-impl(r8) == false) goto L15;
            r8 = null;
        L15:
            Uri r9 = (Uri) r8;
            if (r9 == null) goto L18;
            LatestPhotoShortcutViewModel r2 = this.this$0;
            LatestPhotoShortcutViewModel.access$markAsShown(r2, r9);
            LatestPhotoShortcutViewModel.access$updateShortcutViewState(r2, new ShortcutViewState.b(r9));
        L20:
            return Unit.INSTANCE;
        L18:
            LatestPhotoShortcutViewModel.access$updateShortcutViewState(this.this$0, ShortcutViewState.a.a);
        L7:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LatestPhotoShortcutViewState No(LatestPhotoShortcutViewModel r0, LatestPhotoShortcutViewState r1) {
        return setInitState$lambda$2(r0, r1);
    }

    public static /* synthetic */ LatestPhotoShortcutViewState Oo(ShortcutViewState r0, LatestPhotoShortcutViewState r1) {
        return updateShortcutViewState$lambda$6(r0, r1);
    }

    private final Uri execQueryLatestPhoto() {
        String[] r8 = {"_id", "_data", "date_added"};
        Uri r12 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver r6 = this.contentResolver;
        if (r6 == null) goto L23;
        Cursor r7 = com_larus_bmhome_chat_component_bottom_multimodal_latest_LatestPhotoShortcutViewModel_android_content_ContentResolver_query(r6, r12, r8, null, null, "date_added DESC");
        if (r7 == null) goto L23;
        Cursor r9 = r7;
        Cursor r10 = r9;     // Catch: Throwable -> L18
        if (r10.moveToFirst() == false) goto L16;
        int r3 = r10.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L18
        int r4 = r10.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L18
        int r5 = r10.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L18
        long r11 = r10.getLong(r3);     // Catch: Throwable -> L18
        String r13 = r10.getString(r4);     // Catch: Throwable -> L18
        long r14 = Long.parseLong(r10.getString(r5)) * ((long) 1000);     // Catch: Throwable -> L18
        Uri r15 = ContentUris.withAppendedId(r12, r11);     // Catch: Throwable -> L18
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L18
        r16.d(TAG, "[execQueryLatestPhoto] filePath:" + r13);     // Catch: Throwable -> L18
        r16.d(TAG, "[execQueryLatestPhoto] contentUri:" + r15);     // Catch: Throwable -> L18
        r16.d(TAG, "[execQueryLatestPhoto] addedDate:" + r14);     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L18
        if (checkLatestPhoto(r15, r13, r14) == true) goto L14;
        r15 = null;
    L14:
        CloseableKt.closeFinally(r9, null);
        return r15;
    L16:
        FLogger.a.i(TAG, "[execQueryLatestPhoto] has no permissions or album is empty");     // Catch: Throwable -> L18
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r9, null);
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L23:
        return null;
    }

    private final void setInitState() {
        FLogger.a.i(TAG, "[setInitState]");
        setState(new i0(this));
    }

    private final void stopAutoDismissJob() {
        Job r0 = this.autoDismissJob;
        if (r0 == null) goto L5;
        FLogger.a.i(TAG, "[stopAutoDismissJob]");
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.autoDismissJob = null;
    }

    public LatestPhotoShortcutViewModel() {
        com.larus.platform.model.chat.z r0 = z2.a.latestPhotoShortcutConfig();
        FLogger.a.i(TAG, "[latestPhotoShortcutConfig] config:" + r0);
        this.config = r0;
    }

    public static final /* synthetic */ Uri access$execQueryLatestPhoto(LatestPhotoShortcutViewModel r0) {
        return r0.execQueryLatestPhoto();
    }

    public static final /* synthetic */ com.larus.platform.model.chat.z access$getConfig$p(LatestPhotoShortcutViewModel r0) {
        return r0.config;
    }

    public static final /* synthetic */ void access$setInitState(LatestPhotoShortcutViewModel r0) {
        r0.setInitState();
    }

    private final boolean addedTimeValid(long r4) {
        long r0 = System.currentTimeMillis() - r4;
        FLogger.a.i(TAG, "[addedTimeValid] diff:" + r0 + "ms");
        if (r0 >= this.config.f) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean hasShown(Uri r2) {
        String r3 = r2.toString();
        CopyOnWriteArraySet<String> r0 = c0.a;
        Intrinsics.checkNotNullParameter(r3, "uriString");
        return c0.a.contains(r3);
    }

    private final boolean isSelfScreenshot(Uri r2) {
        String r3 = r2.toString();
        CopyOnWriteArraySet<String> r0 = c0.a;
        Intrinsics.checkNotNullParameter(r3, "uriString");
        return c0.b.contains(r3);
    }

    private final void launchAutoDismissJob(boolean r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        stopAutoDismissJob();     // Catch: Throwable -> L9
        if ((((LatestPhotoShortcutViewState) getState()).getShortcutViewState() instanceof ShortcutViewState.b) == true) goto L6;
        if (r8 == true) goto L6;
    L7:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        FLogger.a.e(TAG, "[launchAutoDismissJob] " + r10);
        return;
    L17:
        return;
    L6:
        this.autoDismissJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LatestPhotoShortcutViewModel$launchAutoDismissJob$1$1(this, r8, null), 3, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final void markAsShown(Uri r4) {
        String r5 = r4.toString();
        FLogger.a.i(TAG, "[markAsShown] uri:" + r5);
        CopyOnWriteArraySet<String> r0 = c0.a;
        Intrinsics.checkNotNullParameter(r5, "uriString");
        c0.a.add(r5);
    }

    private final Job queryLatestImage(Context r7) {
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r7, null), 2, null);
    }

    private final boolean targetValid(String r3) {
        if (this.config.c != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        String[] r1 = com.larus.bmhome.chat.screenshot.f.e;
        return com.larus.bmhome.chat.screenshot.f.a.a(r3);
    L9:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final void updateShortcutViewState(final ShortcutViewState r4) {
        FLogger.a.i(TAG, "[updateShortcutViewState] state:" + r4);
        setState(new h0(r4));
        if (Intrinsics.areEqual(r4, ShortcutViewState.a.a) == false) goto L6;
        stopAutoDismissJob();
        return;
    L6:
        if ((r4 instanceof ShortcutViewState.b) == false) goto L10;
        launchAutoDismissJob(true);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void handleEvent(LatestPhotoShortcutEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        FLogger.a.i(TAG, "[handleEvent] event:" + r4);
        if ((r4 instanceof LatestPhotoShortcutEvent.a) == false) goto L6;
        queryLatestImage(((LatestPhotoShortcutEvent.a) r4).getContext());
        return;
    L6:
        if (Intrinsics.areEqual(r4, LatestPhotoShortcutEvent.c.a) == false) goto L9;
        stopAutoDismissJob();
        return;
    L9:
        if (Intrinsics.areEqual(r4, LatestPhotoShortcutEvent.d.a) == false) goto L12;
        launchAutoDismissJob$default(this, false, 1, null);
        return;
    L12:
        if (Intrinsics.areEqual(r4, LatestPhotoShortcutEvent.b.a) == false) goto L16;
        updateShortcutViewState(ShortcutViewState.a.a);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$markAsShown(LatestPhotoShortcutViewModel r0, Uri r1) {
        r0.markAsShown(r1);
    }

    public static final /* synthetic */ void access$setContentResolver$p(LatestPhotoShortcutViewModel r0, ContentResolver r1) {
        r0.contentResolver = r1;
    }

    public static final /* synthetic */ void access$updateShortcutViewState(LatestPhotoShortcutViewModel r0, ShortcutViewState r1) {
        r0.updateShortcutViewState(r1);
    }

    private static final LatestPhotoShortcutViewState setInitState$lambda$2(LatestPhotoShortcutViewModel r1, LatestPhotoShortcutViewState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r2.copy(ShortcutViewState.a.a, r1.config.d);
    }

    private static final LatestPhotoShortcutViewState updateShortcutViewState$lambda$6(ShortcutViewState r3, LatestPhotoShortcutViewState r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setState");
        return LatestPhotoShortcutViewState.copy$default(r4, r3, false, 2, null);
    }

    private final boolean checkLatestPhoto(Uri r4, String r5, long r6) {
        if (hasShown(r4) == false) goto L7;
        FLogger.a.i(TAG, "[checkLatestPhoto] ignore, has shown");
        return false;
    L7:
        if (isSelfScreenshot(r4) == false) goto L11;
        FLogger.a.i(TAG, "[checkLatestPhoto] ignore, self screenshot");
        return false;
    L11:
        if (addedTimeValid(r6) == true) goto L15;
        FLogger.a.i(TAG, "[checkLatestPhoto] ignore, too old");
        return false;
    L15:
        if (targetValid(r5) == true) goto L18;
        FLogger.a.i(TAG, "[checkLatestPhoto] ignore, target unmatched");
        return false;
    L18:
        return true;
    }

    public static /* synthetic */ void launchAutoDismissJob$default(LatestPhotoShortcutViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.launchAutoDismissJob(r1);
    }

    private static Cursor com_larus_bmhome_chat_component_bottom_multimodal_latest_LatestPhotoShortcutViewModel_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}

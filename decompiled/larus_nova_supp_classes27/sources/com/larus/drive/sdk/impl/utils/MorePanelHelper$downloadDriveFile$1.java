package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.doc.api.IDocService;
import com.larus.drive.biz.api.IDriveService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.drive.sdk.impl.utils.file.DriveDownloadManager;
import com.larus.sheet.api.ISheetService;
import com.larus.slides.api.ISlidesService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.MorePanelHelper$downloadDriveFile$1", f = "MorePanelHelper.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
public final class MorePanelHelper$downloadDriveFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DriveFileItem $file;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ DriveDownloadPriority $priority;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.AI_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveFileType.AI_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MorePanelHelper$downloadDriveFile$1(DriveFileItem r1, Context r2, Fragment r3, CoroutineScope r4, DriveDownloadPriority r5, Continuation<? super MorePanelHelper$downloadDriveFile$1> r6) {
        this.$file = r1;
        this.$context = r2;
        this.$fragment = r3;
        this.$scope = r4;
        this.$priority = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MorePanelHelper$downloadDriveFile$1(this.$file, this.$context, this.$fragment, this.$scope, this.$priority, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r30);
        Object r4 = r30;
    L23:
        int r5 = ((Number) r4).intValue();
        if (r5 != 10001) goto L26;
        int r6 = a.a[this.$file.j.ordinal()];
        if (r6 == 1) goto L81;
        FragmentActivity r7 = null;
        if (r6 != 2) goto L36;
        Fragment r8 = this.$fragment;
        if (r8 == null) goto L87;
        DriveFileItem r9 = this.$file;
        ISlidesService r10 = (ISlidesService) ServiceManager.get().getService(ISlidesService.class);
        if (r10 == null) goto L87;
        String r11 = r9.b;
        String r12 = IDriveService.a.j();
        int r13 = n.a;
        wc9.e r14 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r14 == null) goto L73;
        r7 = r14.a;
    L73:
        if (r7 != null) goto L75;
        FragmentActivity r22 = "";
    L76:
        String r15 = n.f();
        if (r15 != null) goto L79;
        String r23 = "";
    L80:
        r10.j(r8, new kw9.h(r11, "ai_space_list", r12, null, null, null, null, null, null, null, false, "aippt_new", null, null, r22, r23, null, null, null, null, 997368));
        goto L87
    L79:
        r23 = r15;
        goto L80
    L75:
        r22 = r7;
    L87:
        return Unit.INSTANCE;
    L36:
        if (r6 == 3) goto L51;
        Lazy r16 = MorePanelHelper.a;
        final DriveFileItem r17 = this.$file;
        final Context r18 = this.$context;
        final CoroutineScope r20 = this.$scope;
        if ((r18 instanceof FragmentActivity) == false) goto L40;
        r7 = (FragmentActivity) r18;
    L40:
        final FragmentActivity r21 = r7;
        CoroutineScope r24 = DriveDownloadManager.a;
        if (r21 == null) goto L44;
        DriveDownloadManager.e = new WeakReference(r21);
    L44:
        String r25 = MorePanelHelper.c().a(r17, r18, DriveDownloadPriority.NORMAL, new MorePanelHelper$downloadDriveFileExceptAI$taskId$1(r21, r20, r17, r18));
        if (r25 != null) goto L47;
    L48:
        r3 = true;
    L49:
        if (r3 == true) goto L87;
        DriveDownloadManager.c(r21, r25, DriveDownloadStatus.UNSTARTED, 0, 0);
        goto L87
    L47:
        if (StringsKt.isBlank(r25) == false) goto L49;
    L51:
        Fragment r26 = this.$fragment;
        if (r26 == null) goto L87;
        DriveFileItem r27 = this.$file;
        ISheetService r28 = (ISheetService) ServiceManager.get().getService(ISheetService.class);
        if (r28 == null) goto L87;
        String r31 = r27.b;
        String r110 = IDriveService.a.j();
        int r32 = n.a;
        wc9.e r33 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r33 == null) goto L58;
        r7 = r33.a;
    L58:
        if (r7 != null) goto L60;
        FragmentActivity r111 = "";
    L61:
        String r34 = n.f();
        if (r34 != null) goto L64;
        String r112 = "";
    L65:
        r28.b(r26, new kw9.e(r31, "ai_space_list", r110, r111, r112, "ai_space_list", 184312));
        goto L87
    L64:
        r112 = r34;
        goto L65
    L60:
        r111 = r7;
        goto L61
    L81:
        Fragment r35 = this.$fragment;
        if (r35 == null) goto L87;
        DriveFileItem r36 = this.$file;
        IDocService r37 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r37 == null) goto L87;
        r37.M9(r35, r36.b, MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_type", Boxing.boxInt(10)), TuplesKt.to("doc_title", r36.a)}));
        goto L87
    L26:
        if (r5 == 10002) goto L29;
        FLogger.a.i("MorePanelHelper", "[downloadDriveFile] Permission interface error");
        t19.s r38 = t19.s.a;
        Context r40 = this.$context;
        r38.getClass();
        t19.s.s(r40, 2131899179);
        return Unit.INSTANCE;
    L29:
        FLogger.a.i("MorePanelHelper", "[downloadDriveFile] Blocked by security control; operation=DOWNLOAD");
        t19.s r41 = t19.s.a;
        Context r42 = this.$context;
        r41.getClass();
        t19.s.s(r42, 2131901792);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r30);
        Lazy r43 = MorePanelHelper.a;
        e89.c r44 = MorePanelHelper.c();
        DriveFileItem r45 = this.$file;
        String r46 = r45.b;
        int r47 = r45.d;
        DriveFileType r48 = r45.j;
        if (r48 != DriveFileType.AI_DOC) goto L11;
    L16:
        boolean r50 = true;
    L17:
        if (r50 == false) goto L19;
        String r51 = "EXPORT";
    L20:
        this.label = 1;
        r4 = r44.i(r46, r47, r51, this);
        if (r4 != r1) goto L23;
        return r1;
    L19:
        r51 = "DOWNLOAD";
        goto L20
    L11:
        if (r48 == DriveFileType.AI_SLIDES) goto L16;
        if (r48 == DriveFileType.AI_SHEET) goto L16;
        r50 = false;
        goto L17
    }
}

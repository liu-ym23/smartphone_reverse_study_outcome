package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.home.impl.utils.c;
import com.larus.image.loader.ResourceUrlExpireHandleUtil;
import com.larus.mainbot.impl.databinding.LarusDialogFileCardDownloadBinding;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import t19.s;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0082@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0002J\u001e\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010)J\u001e\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020'2\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\u0010H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J\u0017\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/download/FileCardDownloadDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDialogFileCardDownloadBinding;", "resolveJob", "Lkotlinx/coroutines/Job;", "saveJob", "downloadId", "", "tempFilePath", "", "terminal", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "startDownload", "resolveDownloadUrl", "originalUrl", "resourceUri", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDownloadListener", "Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;", "fileName", "saveDownloadedFile", "localFile", "Ljava/io/File;", "exportFileToSystemDownloads", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportWithMediaStore", "exportToLegacyDownloads", "copyToWithCancellation", "input", "Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "(Ljava/io/InputStream;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildUniqueFile", "directory", "sanitizeFileName", "cancelDownload", "cancelActiveWork", "finishWithFailure", "errorCode", "(Ljava/lang/Integer;)V", "deleteTempFile", MusicAppletPage.KEY_PATH, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileCardDownloadDialogFragment extends DialogFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDialogFileCardDownloadBinding d;
    public Job e;
    public Job f;
    public int g;
    public String h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public final void W90() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.f;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        if (this.g <= 0) goto L16;
        Context r2 = getContext();
        if (r2 == null) goto L15;
        Context r3 = r2.getApplicationContext();
        if (r3 == null) goto L15;
        Downloader.getInstance(r3).cancel(this.g);
    L15:
        this.g = 0;
    L16:
        String r4 = this.h;
        if (r4 == null) goto L19;
        Z90(r4);
    L19:
        this.h = null;
    }

    public final void onDestroyView() {
        if (this.i == true) goto L5;
        this.i = true;
        W90();
    L5:
        this.d = null;
        super.onDestroyView();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.setCanceledOnTouchOutside(false);
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L16;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L17;
        r2.setBackgroundDrawable(new ColorDrawable(0));
        r2.addFlags(2);
        r2.setDimAmount(0.32f);
        View r3 = r2.getDecorView();
        if (c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L14;
        c.a(r4, "getDecorView");
    L14:
        r3.setPadding(0, 0, 0, 0);
        r2.setGravity(17);
        r2.setLayout(c7.b(288), c7.b(144));
        return;
    L17:
        return;
    }

    public FileCardDownloadDialogFragment() {
    }

    public static void Z90(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Result.constructor-impl(Boolean.valueOf(new PolarisFileWrapper(r1).delete()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setCancelable(false);
    }

    public static final void U90(FileCardDownloadDialogFragment r4, Integer r5) {
        if (r4.i == true) goto L20;
        r4.i = true;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("download terminated, fileName=");
        Bundle r2 = r4.getArguments();
        if (r2 == null) goto L8;
        String r3 = r2.getString("file_name");
    L9:
        r1.append(r3);
        r1.append(", errorCode=");
        r1.append(r5);
        r0.e("FileCardDownloadDialog", r1.toString());
        r4.W90();
        s r6 = s.a;
        Context r7 = r4.getContext();
        r6.getClass();
        s.b(r7, 2131910881, false);
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L19;
        d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public static void X90(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, null, null};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240019);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240019, "android/content/ContentResolver", ShareChannel.DELETE, r20, r2, "int", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L20;
        ((Integer) r5.b).intValue();
        return;
    L20:
        r20.delete(r21, null, null);
        return;
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        r14.setClipToOutline(true);
        LarusDialogFileCardDownloadBinding r16 = this.d;
        if (r16 == null) goto L7;
        TextView r17 = r16.b;
        if (r17 == null) goto L7;
        r17.setOnClickListener(new com.larus.bmhome.chat.standarduikit.fileblock.download.a(this));
    L7:
        Context r6 = getContext();
        if (r6 == null) goto L45;
        Bundle r18 = getArguments();
        if (r18 == null) goto L13;
        String r19 = r18.getString(ShareType.FILE_URL);
    L15:
        if (r19 != null) goto L17;
        String r3 = "";
    L18:
        Bundle r110 = getArguments();
        if (r110 == null) goto L21;
        String r111 = r110.getString("resource_uri");
    L22:
        if (r111 != null) goto L24;
        String r4 = "";
    L25:
        Bundle r112 = getArguments();
        if (r112 == null) goto L28;
        String r113 = r112.getString("file_name");
    L29:
        if (r113 != null) goto L31;
        String r7 = "";
    L32:
        String r114 = StringsKt.trim(StringsKt.replace$default(StringsKt.substringAfterLast$default(StringsKt.replace$default(r7, '\\', '/', false, 4, null), '/', null, 2, null), "\u0000", "", false, 4, null)).toString();
        if (r114.length() != 0) goto L35;
        boolean r0 = true;
    L36:
        if (r0 == false) goto L38;
        r114 = "doubao_" + System.currentTimeMillis();
    L38:
        String r5 = r114;
        LarusDialogFileCardDownloadBinding r115 = this.d;
        if (r115 == null) goto L43;
        ProgressBar r116 = r115.d;
        if (r116 == null) goto L43;
        r116.setIndeterminate(true);
    L43:
        this.e = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new FileCardDownloadDialogFragment$startDownload$1(this, r3, r4, r5, r6, null), 3, null);
        return;
    L35:
        r0 = false;
        goto L36
    L31:
        r7 = r113;
        goto L32
    L28:
        r113 = null;
        goto L29
    L24:
        r4 = r111;
        goto L25
    L21:
        r111 = null;
        goto L22
    L17:
        r3 = r19;
        goto L18
    L13:
        r19 = null;
        goto L15
    }

    public static void Y90(ContentResolver r21, Uri r22, ContentValues r23) {
        ArrayList r2 = new ArrayList();
        Object[] r3 = {r22, r23, null, null};
        f06.b r14 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(240018);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r18 = r9;
        int r19 = r10;
        f06.a[] r20 = r11;
        f06.d r6 = r8.preInvoke(240018, "android/content/ContentResolver", "update", r21, r3, "int", r14);     // Catch: Exception -> L22
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L22
    L17:
        if (r6.a == false) goto L20;
        ((Integer) r6.b).intValue();
        return;
    L20:
        r21.update(r22, r23, null, null);
        return;
    L14:
        r9 = r18 + 1;
        r10 = r19;
        r11 = r20;
        goto L8
    L15:
        r6 = new f06.d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        ConstraintLayout r8 = r5.inflate(2131562070, r6, false);
        int r9 = 2131370156;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r8, 2131370156);
        if (r10 == null) goto L16;
        ConstraintLayout r11 = r8;
        View r1 = ViewBindings.findChildViewById(r8, 2131370172);
        if (r1 == null) goto L14;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r8, 2131370185);
        if (r2 != null) goto L9;
        r9 = 2131370185;
        goto L16
    L9:
        if (((TextView) ViewBindings.findChildViewById(r8, 2131370187)) == null) goto L12;
        this.d = new LarusDialogFileCardDownloadBinding(r11, r10, r1, r2);
        return r11;
    L12:
        r9 = 2131370187;
        goto L16
    L14:
        r9 = 2131370172;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }

    public static final Object S90(FileCardDownloadDialogFragment r12, File r13, String r14, Continuation r15) {
        r12.getClass();
        if ((r15 instanceof FileCardDownloadDialogFragment$exportToLegacyDownloads$1) == false) goto L7;
        FileCardDownloadDialogFragment$exportToLegacyDownloads$1 r0 = (FileCardDownloadDialogFragment$exportToLegacyDownloads$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        PolarisFileOutputStreamWrapper r17 = (Closeable) r0.L$4;
        PolarisFileInputStreamWrapper r18 = (Closeable) r0.L$3;
        File r19 = (File) r0.L$2;
        Context r5 = (Context) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
        File r7 = r19;
        r14 = r6;
    L84:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L58
        CloseableKt.closeFinally(r18, null);     // Catch: Throwable -> L54 CancellationException -> L56
        JobKt.ensureActive(r0.getContext());     // Catch: Throwable -> L54 CancellationException -> L56
        MediaScannerConnection.scanFile(r5, new String[]{r7.getAbsolutePath()}, null, null);     // Catch: Throwable -> L54 CancellationException -> L56
    L103:
        return Boxing.boxBoolean(r4);
    L58:
        th = th;
    L94:
        throw th;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: Throwable -> L54 CancellationException -> L56
        throw th;     // Catch: Throwable -> L54 CancellationException -> L56
    L60:
        Throwable th = th;
        r6 = r14;
        r19 = r7;
    L62:
        PolarisFileInputStreamWrapper r11 = r18;
        PolarisFileOutputStreamWrapper r111 = r17;
    L63:
        PolarisFileInputStreamWrapper r112 = r11;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        PolarisFileInputStreamWrapper r113 = r112;
        th = th;
    L73:
        r18 = r113;
    L14:
        th = th;
        goto L62
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        Context r114 = r12.getContext();
        if (r114 == null) goto L83;
        Context r115 = r114.getApplicationContext();
        if (r115 == null) goto L83;
        PolarisFileWrapper r116 = new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Doubao");
        if (r116.exists() == false) goto L26;
    L28:
        int r8 = StringsKt.lastIndexOf$default(r14, '.', 0, false, 6, null);
        if (r8 <= 0) goto L31;
        String r9 = r14.substring(0, r8);
    L32:
        if (r8 <= 0) goto L34;
        String r10 = r14.substring(r8);
    L35:
        r7 = new PolarisFileWrapper(r116, r14);
        int r20 = 1;
    L37:
        if (r7.exists() == false) goto L100;
        r7 = new PolarisFileWrapper(r116, r9 + '(' + r20 + ')' + r10);
        r20 = r20 + 1;
        goto L37
    L100:
        r113 = new PolarisFileInputStreamWrapper(r13);     // Catch: Throwable -> L54 CancellationException -> L56
        r111 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L72
        r0.L$0 = r14;     // Catch: Throwable -> L64
        r0.L$1 = r115;     // Catch: Throwable -> L64
        r0.L$2 = r7;     // Catch: Throwable -> L64
        r0.L$3 = r113;     // Catch: Throwable -> L64
        r0.L$4 = r111;     // Catch: Throwable -> L64
        r0.label = 1;     // Catch: Throwable -> L64
        byte[] r21 = new byte[8192];     // Catch: Throwable -> L64
    L42:
        JobKt.ensureActive(r0.getContext());     // Catch: Throwable -> L64
        int r22 = r113.read(r21);     // Catch: Throwable -> L64
        if (r22 < 0) goto L45;
        r111.write(r21, 0, r22);     // Catch: Throwable -> L64
        goto L42
    L45:
        if (Unit.INSTANCE == r2) goto L104;
        r5 = r115;
        r17 = r111;
        r18 = r113;
        goto L84
    L104:
        return r2;
    L64:
        th = move-exception;
        r11 = r113;
        th = th;
    L72:
        th = th;
    L56:
        e = move-exception;
        r7.delete();
        throw e;
    L54:
        th = move-exception;
        r7.delete();
        FLogger.a.e("FileCardDownloadDialog", "save to legacy Downloads failed, fileName=" + r14, th);
        r4 = false;
        goto L103
    L34:
        r10 = "";
        goto L35
    L31:
        r9 = r14;
        goto L32
    L26:
        if (r116.mkdirs() == true) goto L28;
        return Boxing.boxBoolean(false);
    L83:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new FileCardDownloadDialogFragment$exportToLegacyDownloads$1(r12, r15);
        goto L8
    }

    public static final Object T90(FileCardDownloadDialogFragment r28, File r29, String r30, Continuation r31) {
        String r1 = r30;
        r28.getClass();
        if ((r31 instanceof FileCardDownloadDialogFragment$exportWithMediaStore$1) == false) goto L7;
        FileCardDownloadDialogFragment$exportWithMediaStore$1 r2 = (FileCardDownloadDialogFragment$exportWithMediaStore$1) r31;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        PolarisFileInputStreamWrapper r6 = (Closeable) r2.L$5;
        Closeable r7 = (Closeable) r2.L$4;
        Uri r8 = (Uri) r2.L$3;
        ContentValues r9 = (ContentValues) r2.L$2;
        ContentResolver r10 = (ContentResolver) r2.L$1;
        String r11 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        PolarisFileInputStreamWrapper r12 = r6;
        r1 = r11;
        r7 = r7;
    L103:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L68
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L66
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L62 CancellationException -> L64
        JobKt.ensureActive(r2.getContext());     // Catch: Throwable -> L62 CancellationException -> L64
        r9.clear();     // Catch: Throwable -> L62 CancellationException -> L64
        r9.put("is_pending", Boxing.boxInt(0));     // Catch: Throwable -> L62 CancellationException -> L64
        Y90(r10, r8, r9);     // Catch: Throwable -> L62 CancellationException -> L64
        boolean r14 = true;
    L123:
        return Boxing.boxBoolean(r14);
    L64:
        e = e;
    L95:
        X90(r10, r8);
        throw e;
    L62:
        th = th;
    L92:
        X90(r10, r8);
        FLogger.a.e("FileCardDownloadDialog", "save to MediaStore failed, fileName=" + r1, th);
        r14 = false;
    L66:
        th = move-exception;
        Throwable r15 = th;
        Closeable r16 = r7;
    L101:
        throw r15;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r16, r15);     // Catch: Throwable -> L85 CancellationException -> L87
        throw th;     // Catch: Throwable -> L85 CancellationException -> L87
    L68:
        Throwable th = th;
        PolarisFileInputStreamWrapper r26 = r12;
        r11 = r1;
        r6 = r26;
    L70:
        Throwable r17 = th;
        r12 = r6;
        Closeable r18 = r7;
    L109:
        throw r17;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        CloseableKt.closeFinally(r12, r17);     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L78
    L14:
        th = th;
        goto L70
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        Context r19 = r28.getContext();
        if (r19 == null) goto L98;
        Context r20 = r19.getApplicationContext();
        if (r20 == null) goto L98;
        ContentResolver r21 = r20.getContentResolver();
        r9 = new ContentValues();
        r9.put("_display_name", r1);
        r9.put("title", r1);
        String r22 = URLConnection.guessContentTypeFromName(r30);
        if (r22 != null) goto L26;
        r22 = "application/octet-stream";
    L26:
        r9.put("mime_type", r22);
        r9.put("relative_path", Environment.DIRECTORY_DOWNLOADS + "/Doubao");
        r9.put("is_pending", Boxing.boxInt(1));
        Uri r23 = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r23, r9};
        f06.b r112 = new f06.b();
        g06.a r113 = (g06.a) ApiHookConfig.b.get(240017);
        if (r113 == null) goto L29;
        f06.a[] r114 = r113.i;
    L30:
        f06.a[] r115 = r114;
        int r116 = r115.length;
        int r117 = 0;
    L32:
        if (r117 >= r116) goto L39;
        f06.a r118 = r115[r117];
        int r24 = r117;
        int r25 = r116;
        f06.a[] r27 = r115;
        Object[] r210 = r111;
        ArrayList r32 = r110;
        f06.d r119 = r118.preInvoke(240017, "android/content/ContentResolver", "insert", r21, r210, "android.net.Uri", r112);     // Catch: Exception -> L99
        if (r119.a == true) goto L41;
        r32.add(r118);     // Catch: Exception -> L99
    L41:
        if (r119.a == false) goto L43;
        Uri r33 = (Uri) r119.b;
    L44:
        Uri r34 = r33;
        if (r34 == null) goto L122;
        OutputStream r120 = ContentResolverWrapper.openOutputStream(r21, r34);     // Catch: Throwable -> L85 CancellationException -> L87
        if (r120 == null) goto L90;
        r12 = new PolarisFileInputStreamWrapper(r29);     // Catch: Throwable -> L78
        r2.L$0 = r1;     // Catch: Throwable -> L71
        r2.L$1 = r21;     // Catch: Throwable -> L71
        r2.L$2 = r9;     // Catch: Throwable -> L71
        r2.L$3 = r34;     // Catch: Throwable -> L71
        r2.L$4 = r120;     // Catch: Throwable -> L71
        r2.L$5 = r12;     // Catch: Throwable -> L71
        r2.label = 1;     // Catch: Throwable -> L71
        byte[] r121 = new byte[8192];     // Catch: Throwable -> L71
    L51:
        JobKt.ensureActive(r2.getContext());     // Catch: Throwable -> L71
        int r122 = r12.read(r121);     // Catch: Throwable -> L71
        if (r122 < 0) goto L54;
        r120.write(r121, 0, r122);     // Catch: Throwable -> L71
        goto L51
    L54:
        if (Unit.INSTANCE == r4) goto L124;
        r8 = r34;
        r10 = r21;
        r7 = r120;
        goto L103
    L124:
        return r4;
    L71:
        th = move-exception;
        r17 = th;
        r18 = r120;
        goto L109
    L90:
        throw new IOException("Open Downloads output stream failed");     // Catch: Throwable -> L85 CancellationException -> L87
    L87:
        e = e;
        r10 = r21;
        r8 = r34;
    L85:
        th = th;
        r10 = r21;
        r8 = r34;
        goto L92
    L122:
        return Boxing.boxBoolean(false);
    L43:
        r33 = r21.insert(r23, r9);
    L38:
        r117 = r24 + 1;
        r110 = r32;
        r116 = r25;
        r115 = r27;
        r111 = r210;
        goto L32
    L39:
        r119 = new f06.d(false, null);
        goto L41
    L29:
        r114 = ApiHookConfig.d;
    L98:
        return Boxing.boxBoolean(false);
    L78:
        th = move-exception;
        r15 = th;
        r16 = r18;
    L7:
        r2 = new FileCardDownloadDialogFragment$exportWithMediaStore$1(r28, r31);
        goto L8
    }

    public static final Object V90(FileCardDownloadDialogFragment r6, String r7, String r8, Continuation r9) {
        r6.getClass();
        if ((r9 instanceof FileCardDownloadDialogFragment$resolveDownloadUrl$1) == false) goto L7;
        FileCardDownloadDialogFragment$resolveDownloadUrl$1 r0 = (FileCardDownloadDialogFragment$resolveDownloadUrl$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L51
    L37:
        FileUrlRespData r11 = (FileUrlRespData) ((com.larus.network.http.a) r10).b;     // Catch: Throwable -> L51
        if (r11 == null) goto L48;
        List r12 = r11.getFileUrlList();     // Catch: Throwable -> L51
        if (r12 == null) goto L48;
        FileUrlData r13 = (FileUrlData) CollectionsKt.firstOrNull(r12);     // Catch: Throwable -> L51
        if (r13 == null) goto L48;
        String r14 = r13.getMainUrl();     // Catch: Throwable -> L51
        if (r14 == null) goto L48;
        if (y0.e(r14) == false) goto L48;
    L49:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L51
    L53:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L60;
        FLogger r17 = FLogger.a;
        StringBuilder r4 = new StringBuilder("resolve download url failed, fileName=");
        Bundle r18 = r6.getArguments();
        if (r18 == null) goto L58;
        String r19 = r18.getString("file_name");
    L59:
        r4.append(r19);
        r17.e("FileCardDownloadDialog", r4.toString(), r16);
        goto L60
    L58:
        r19 = null;
    L60:
        boolean r20 = Result.isFailure-impl(r15);
        Object r21 = r15;
        if (r20 == true) goto L63;
    L69:
        return r21;
    L63:
        return null;
    L48:
        r14 = null;
        goto L49
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r22 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L26
        r7 = r22;
    L24:
        Object r23 = Result.constructor-impl((String) r10);     // Catch: Throwable -> L26
        String r24 = r7;
    L28:
        Object r5 = r23;
        r21 = r24;
        if (Result.isFailure-impl(r5) == true) goto L69;
        return r5;
    L19:
        ResultKt.throwOnFailure(r10);
        if (y0.e(r7) == false) goto L32;
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L26
        ResourceUrlExpireHandleUtil r26 = ResourceUrlExpireHandleUtil.a;     // Catch: Throwable -> L26
        r0.L$0 = r7;     // Catch: Throwable -> L26
        r0.label = 1;     // Catch: Throwable -> L26
        r10 = r26.a(r7, r0);     // Catch: Throwable -> L26
        r7 = r7;
        if (r10 != r2) goto L24;
        return r2;
    L32:
        if (StringsKt.isBlank(r8) == true) goto L63;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L51
        Lazy r28 = ChatApi.a;     // Catch: Throwable -> L51
        ChatApi r29 = ChatApi.a.a();     // Catch: Throwable -> L51
        List r30 = CollectionsKt.listOf(r8);     // Catch: Throwable -> L51
        String r31 = UploadDataType.FILE.getType();     // Catch: Throwable -> L51
        r0.label = 2;     // Catch: Throwable -> L51
        r29.getClass();     // Catch: Throwable -> L51
        r10 = ChatApi.e(r30, r31, r0);     // Catch: Throwable -> L51
        if (r10 != r2) goto L37;
        return r2;
    L26:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        r24 = r7;
    L51:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new FileCardDownloadDialogFragment$resolveDownloadUrl$1(r6, r9);
        goto L8
    }
}

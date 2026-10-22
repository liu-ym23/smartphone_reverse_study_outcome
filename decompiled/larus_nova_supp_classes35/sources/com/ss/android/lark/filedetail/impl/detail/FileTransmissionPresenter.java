package com.ss.android.lark.filedetail.impl.detail;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.larksuite.framework.utils.RomUtils;
import com.larksuite.framework.utils.m0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.filedetail.impl.FileDetailFragment;
import com.ss.android.lark.filedetail.impl.open.FileOpenUtils;
import com.ss.android.lark.filedetail.impl.open.OpenFileParams;
import com.ss.android.lark.filedetail.util.DownloadPathConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;
import com.ss.android.lark.pb.compliance.MGetIMFileRiskTagRequest;
import com.ss.android.lark.pb.compliance.SourceTerminal;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileTransmissionPresenter {
    public static boolean t = true;
    public WeakReference<z> a;
    public final CallbackManager b;
    public final hfb.b c;
    public final hfb.b.e d;
    public final hfb.b.d e;
    public final hfb.b.InterfaceC0233b f;
    public String g;
    public Message.SourceType h;
    public String i;
    public String j;
    public FileDownloadState k;
    public Context l;
    public File m;
    public String n;
    public boolean o;
    public final boolean p;
    public String q;
    public OpenFileParams r;
    public final AtomicBoolean s;

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter$10, reason: invalid class name */
    class AnonymousClass10 implements IGetDataCallback<Boolean> {
        final /* synthetic */ FileTransmissionPresenter this$0;
        final /* synthetic */ Context val$context;
        final /* synthetic */ FileContent val$fileContent;
        final /* synthetic */ String val$messageId;
        final /* synthetic */ OpenFileParams val$params;

        public static /* synthetic */ void a(AnonymousClass10 r0, FileContent r1) {
            r0.lambda$onSuccess$0(r1);
        }

        private /* synthetic */ void lambda$onSuccess$0(FileContent r2) {
            FileTransmissionPresenter.a(this.this$0, r2.getKey());
        }

        public void onError(ErrorResult r5) {
            Log.w("FileTransmissionPresenter", "check attachment risk download permission failed, allows download.", r5);
            this.this$0.h(this.val$fileContent, this.val$messageId, this.val$context, this.val$params);
        }

        public void onSuccess(Boolean r5) {
            if (Boolean.TRUE.equals(r5) == false) goto L5;
            this.this$0.h(this.val$fileContent, this.val$messageId, this.val$context, this.val$params);
            return;
        L5:
            Executor r6 = CoreThreadPool.getDefault().getUIExecutor();
            final FileContent r0 = this.val$fileContent;
            r6.execute(new o(this, r0));
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((Boolean) r1);
        }

        public AnonymousClass10(FileTransmissionPresenter r1, FileContent r2, String r3, Context r4, OpenFileParams r5) {
            this.this$0 = r1;
            this.val$fileContent = r2;
            this.val$messageId = r3;
            this.val$context = r4;
            this.val$params = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter$2, reason: invalid class name */
    class AnonymousClass2 implements IGetDataCallback<hfb.a> {
        final /* synthetic */ FileTransmissionPresenter this$0;
        final /* synthetic */ String val$appreciableKey;
        final /* synthetic */ FileContent val$fileContent;
        final /* synthetic */ boolean val$isSecret;
        final /* synthetic */ Message val$mMsg;

        /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter$2$a */
        public class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ AnonymousClass2 a;

            public a(AnonymousClass2 r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r1) {
                if (this.a.this$0.d() == null) goto L6;
                this.a.this$0.d().y();
                return;
            }
        }

        public static /* synthetic */ void a(AnonymousClass2 r0, FileContent r1, Message r2, ErrorResult r3, z r4) {
            r0.lambda$onError$3(r1, r2, r3, r4);
        }

        public static /* synthetic */ void b(AnonymousClass2 r0, DialogInterface r1) {
            r0.lambda$onError$1(r1);
        }

        private /* synthetic */ void lambda$onError$1(DialogInterface r1) {
            this.this$0.d().y();
        }

        private /* synthetic */ void lambda$onError$2(DialogInterface r1) {
            this.this$0.d().y();
        }

        public void onError(final ErrorResult r8) {
            this.this$0.s.set(false);
            Log.e("FileTransmissionPresenter", r8);
            rfb.a.a(this.val$isSecret, ErrorType.SDK, r8.getErrorCode(), r8.getDebugMsg());
            final z r6 = this.this$0.d();
            final FileContent r3 = this.val$fileContent;
            final Message r4 = this.val$mMsg;
            UICallbackExecutor.execute(new r(this, r3, r4, r8, r6));
        }

        public void onSuccess(hfb.a r3) {
            this.this$0.s.set(false);
            r3.getClass();
            FileOpenUtils.a(null);
            throw null;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((hfb.a) r1);
        }

        private /* synthetic */ void lambda$onSuccess$0(String r3, FileContent r4) {
            if (TextUtils.isEmpty(r3) == false) goto L6;
            r4.setFileState(FileState.DOWNLOAD);
            this.this$0.k(0);
            Log.i("FileTransmissionPresenter", "download success ,filePath is empty");
            return;
        L6:
            if (sfb.c.b().i(r3).exists() == false) goto L10;
            r4.setProgress(100);
            r4.setFilePath(r3);
            r4.setFileState(FileState.DONE);
            this.this$0.k(100);
            Log.i("FileTransmissionPresenter", "download success");
            return;
        }

        private void lambda$onError$3(FileContent r3, Message r4, ErrorResult r5, z r6) {
            r3.setFileState(FileState.DOWNLOAD);
            FileTransmissionPresenter r7 = this.this$0;
            FileDownloadState r0 = r7.k;
            if (r0 == FileDownloadState.STOP) goto L12;
            if (r0 == FileDownloadState.PAUSE) goto L12;
            if (r0 == FileDownloadState.DOWNLOAD_NETWORK) goto L12;
            if (r7.d() == null) goto L12;
            this.this$0.d().HF();
        L12:
            if (r5.getErrorCode() != 410) goto L14;
        L37:
            r4.setSourceFileDelete(true);
            if (this.this$0.d() == null) goto L40;
            this.this$0.d().fM();
        L40:
            Iterator r8 = ((CopyOnWriteArrayList) qfb.b.a).iterator();
        L42:
            if (r8.hasNext() == false) goto L55;
            ((qfb.b.a) r8.next()).a();
            goto L42
        L55:
            return;
        L14:
            if (r5.getErrorCode() == 10006) goto L37;
            if (r5.getErrorCode() != 5601) goto L20;
            com.ss.android.lark.filedetail.impl.p.a(this.this$0.l, false, new a(this));
            return;
        L20:
            if (r5.getErrorCode() != 5602) goto L23;
            com.ss.android.lark.filedetail.impl.p.a(this.this$0.l, true, new q(this));
            return;
        L23:
            if (r5.getErrorCode() != 321000) goto L27;
            if (r6 == null) goto L47;
            FileDetailModuleDependencyMock.e r9 = this.this$0.f;
            r9.getClass();
            Log.w("FileDetailModuleDependencyMock", "getAuditDisplayMsg mocked");
            r5.getDisplayMsg(null);
            r9.getClass();
            Log.w("FileDetailModuleDependencyMock", "onCheckedAuthorizationFailed mocked");
            return;
        L47:
            return;
        L27:
            if (r5.getErrorCode() != 321001) goto L31;
            if (r6 == null) goto L49;
            this.this$0.d().y();
            return;
        L49:
            return;
        L31:
            if (r5.getErrorCode() != 5607) goto L35;
            if (r6 == null) goto L51;
            r6.CW(r5.getDisplayMsg());
            return;
        L51:
            return;
        L35:
            if (r5.getCode() != (-439800)) goto L53;
            LKUIToast.show(this.this$0.l, 2131891060);
            return;
        }

        public AnonymousClass2(FileTransmissionPresenter r1, String r2, FileContent r3, boolean r4, Message r5) {
            this.this$0 = r1;
            this.val$appreciableKey = r2;
            this.val$fileContent = r3;
            this.val$isSecret = r4;
            this.val$mMsg = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter$4, reason: invalid class name */
    class AnonymousClass4 implements IGetDataCallback<Boolean> {
        final /* synthetic */ FileTransmissionPresenter this$0;
        final /* synthetic */ IGetDataCallback val$cancelableCallback;
        final /* synthetic */ String val$chatId;
        final /* synthetic */ FileContent val$downloadContent;
        final /* synthetic */ FileContent val$fileContent;
        final /* synthetic */ boolean val$isSecret;
        final /* synthetic */ Message val$mMsg;
        final /* synthetic */ OnUpdateProgressListener val$progressListener;

        /* JADX INFO: renamed from: com.ss.android.lark.filedetail.impl.detail.FileTransmissionPresenter$4$a */
        public class a implements Runnable {
            public final /* synthetic */ AnonymousClass4 a;

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass4 r0 = this.a;     // Catch: Throwable -> L4
                FileTransmissionPresenter.a(r0.this$0, r0.val$downloadContent.getKey());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(AnonymousClass4 r1) {
                this.a = r1;
            }
        }

        public void onError(ErrorResult r5) {
            Log.i("FileTransmissionPresenter", "download file: canUserDownloadRiskFile failed, allows download file.");
            this.this$0.e(this.val$mMsg, this.val$fileContent, this.val$isSecret, this.val$downloadContent);
        }

        public void onSuccess(Boolean r5) {
            Log.i("FileTransmissionPresenter", "download file: canUserDownloadRiskFile success.");
            if (r5.booleanValue() == false) goto L5;
            Log.i("FileTransmissionPresenter", "canUserDownloadRiskFile is true, allows download file.");
            this.this$0.e(this.val$mMsg, this.val$fileContent, this.val$isSecret, this.val$downloadContent);
            return;
        L5:
            this.this$0.s.set(false);
            Log.i("FileTransmissionPresenter", "canUserDownloadRiskFile is false, stops download file.");
            CoreThreadPool.getDefault().getUIExecutor().execute(new a(this));
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((Boolean) r1);
        }

        public AnonymousClass4(FileTransmissionPresenter r1, Message r2, FileContent r3, boolean r4, String r5, FileContent r6, IGetDataCallback r7, OnUpdateProgressListener r8) {
            this.this$0 = r1;
            this.val$mMsg = r2;
            this.val$fileContent = r3;
            this.val$isSecret = r4;
            this.val$chatId = r5;
            this.val$downloadContent = r6;
            this.val$cancelableCallback = r7;
            this.val$progressListener = r8;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[FileDownloadState.values().length];
            b = r0;
            r0[FileDownloadState.PAUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L16:
            b[FileDownloadState.RECALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L18:
            b[FileDownloadState.DOWNLOADING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L7:
            int[] r2 = new int[FileState.values().length];
            a = r2;
            r2[FileState.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            a[FileState.DOWNLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public interface b {
    }

    public final z d() {
        WeakReference<z> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final void j() {
        if (TextUtils.isEmpty(this.g) == false) goto L5;
        return;
    L5:
        Log.i("FileTransmissionPresenter", "stop download,msgId:" + this.g);
        if (TextUtils.isEmpty(this.j) == false) goto L8;
        FileDetailModuleDependencyMock.b r0 = this.d;
        this.h.getNumber();
        r0.getClass();
        Log.w("FileDetailModuleDependencyMock", "cancelDownloadMessageFile mocked");
        return;
    L8:
        this.d.getClass();
        Log.w("FileDetailModuleDependencyMock", "cancelDownloadMailAttachment mocked");
    }

    public FileTransmissionPresenter(boolean r3) {
        this.b = new CallbackManager();
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        hfb.b r1 = FileDetailModule.a.a();
        this.c = r1;
        this.d = r1.getDownloadDependency();
        this.e = r1.getChatDependency();
        this.f = r1.getAuditDependency();
        this.k = FileDownloadState.NORMAL;
        this.o = false;
        this.s = new AtomicBoolean(false);
        this.p = r3;
    }

    public final void k(int r4) {
        UICallbackExecutor.execute(new i(this, r4, 0));
    }

    public static void a(FileTransmissionPresenter r4, String r5) {
        r4.getClass();
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        FileDetailModule.a.a().getDynamicDomainDependency().getClass();
        String r1 = FileDetailModuleDependencyMock.c();
        yob.e.a().getClass();
        int r2 = com.ss.android.lark.language.service.impl.a.f;
        Locale r3 = com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting();
        String r6 = r1 + "/document-security-inspection/appeal?obj_token=" + r5 + "&file_type=0&locale=" + (r3.getLanguage() + "-" + r3.getCountry());
        Context r7 = r4.l;
        new UDDialogBuilder(r7).title(2131890734).message(2131891115).addActionButton(2131391777, 2131890732, new u(r4, r7, r6)).addActionButton(2131391778, 2131890733, new t()).show();
    }

    public final void b(final Message r11, final FileContent r12, final Context r13, final OpenFileParams r14) {
        if (StoragePermissionUtils.b() == true) goto L5;
    L8:
        t = false;
        Log.i("FileTransmissionPresenter", "apply permission");
        Activity r1 = Contexts.requireActivity(r13);
        Token r2 = new Token("LARK-PSDA-messenger_file_download_with_message");
        StoragePermissionUtils.f(r1, new n0c.b(new AnonymousClass12(this, r11, r12, r13, r14)), 16, r2, new String[0]);
        return;
    L5:
        if (t == true) goto L8;
        Log.i("FileTransmissionPresenter", "Not first request permission");
        i(r11, r12, r13, null, null);
    }

    public final void c(final FileContent r11, final String r12, final Context r13, final OpenFileParams r14) {
        if (StoragePermissionUtils.b() == true) goto L5;
    L8:
        t = false;
        Activity r1 = Contexts.requireActivity(r13);
        Token r2 = new Token("LARK-PSDA-messenger_file_download_with_content");
        StoragePermissionUtils.f(r1, new n0c.b(new AnonymousClass13(this, r11, r12, r13, r14)), 16, r2, new String[0]);
        return;
    L5:
        if (t == true) goto L8;
        Log.i("FileTransmissionPresenter", "Not first request permission");
        g(r11, r12, r13, r14);
    }

    public final void e(Message r10, FileContent r11, boolean r12, FileContent r13) {
        r11.setFileState(FileState.DOWNLOADING);
        boolean r0 = false;
        r11.setProgress(0);
        k(0);
        String r14 = com.ss.android.lark.filedetail.impl.a.a(this.l, r13.getName());
        if (r12 == false) goto L6;
    L157:
        FileDetailModuleDependencyMock.b r15 = this.d;
        r10.getId();
        r10.getSourceId();
        r10.getSourceType().getNumber();
        this.r.getDownloadFileScene();
        r13.getKey();
        this.r.getPreviewId();
        this.r.getAuthFileKey();
        this.r.getMsgLinkToken();
        new Token("LARK-PSDA-messenger_file_detail_transmission");
        r15.getClass();
        Log.w("FileDetailModuleDependencyMock", "downLoadMessageFile mocked");
        return;
    L6:
        if (r14 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L157;
        int r2 = sfb.b.a;
        DownloadPathConfig r3 = (DownloadPathConfig) SettingManager.getInstance().get(DownloadPathConfig.class);
        if (r3 != null) goto L17;
        Log.w("FileDetailUtil", "isFixPathConfigEnable config == null");
    L129:
        boolean r4 = false;
    L131:
        if (r4 == true) goto L133;
        Log.i("DownloadFileUtils", "fixDownloadPath config disabled");
        goto L157
    L133:
        VFSFiles r5 = VFSFiles.b;
        VFSFile r6 = r5.i(r14);
        File r7 = r6.getParentFile();     // Catch: Exception -> L155
        if (r7 != null) goto L138;
        Log.w("DownloadFileUtils", "fixDownloadPath parent == null,path:" + r14);     // Catch: Exception -> L155
        goto L157
    L138:
        if (r7.exists() == true) goto L140;
        Log.i("DownloadFileUtils", "fixDownloadPath mkdirs:" + r7.mkdirs());     // Catch: Exception -> L155
    L140:
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L155
        r8.append("fixDownloadPath path:" + r14);     // Catch: Exception -> L155
        r8.append(",file<" + r6.exists() + '-' + r6.canWrite() + '>');     // Catch: Exception -> L155
        r8.append(",dir<" + r7.exists() + '-' + r7.canWrite() + '>');     // Catch: Exception -> L155
        Log.i("DownloadFileUtils", r8.toString());     // Catch: Exception -> L155
        if (r6.exists() == false) goto L143;
    L145:
        boolean r16 = r6.canWrite();     // Catch: Exception -> L155
        if (r0 == false) goto L148;
        Log.i("DownloadFileUtils", "fixDownloadPath delete:" + r6.delete());     // Catch: Exception -> L155
    L148:
        if (r16 == false) goto L150;
        Log.i("DownloadFileUtils", "fixDownloadPath canWrite");     // Catch: Exception -> L155
        goto L157
    L150:
        String r17 = r6.getName();     // Catch: Exception -> L155
        VFSPath r18 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.g, new com.ss.android.lark.storage.d(new String[]{"download"}));     // Catch: Exception -> L155
        if (com.suite.lark.component.storage.ext.b.b(r18) == true) goto L153;
        com.suite.lark.component.storage.ext.b.d(r18);     // Catch: Exception -> L155
    L153:
        Log.i("DownloadFileUtils", "fixDownloadPath newPath:" + r5.D(r5.F(r18), r17).getAbsolutePath());     // Catch: Exception -> L155
        goto L157
    L143:
        if (r6.createNewFile() == false) goto L145;
        r0 = true;
    L155:
        e = move-exception;
        Log.e("DownloadFileUtils", "Fix path failed", e);
        goto L157
    L17:
        List<sfb.a> r9 = r3.a();
        List<sfb.a> r19 = r9;
        if (r19 != null) goto L20;
    L23:
        boolean r20 = true;
    L24:
        if (r20 == false) goto L26;
        Log.w("FileDetailUtil", "isFixPathConfigEnable devices == null");
        goto L129
    L26:
        List<sfb.a> r21 = r9;
        if ((r21 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r22 = r21.iterator();
    L33:
        if (r22.hasNext() == false) goto L129;
        sfb.a r23 = (sfb.a) r22.next();
        String r24 = r23.a();
        if (r24 != null) goto L37;
    L40:
        boolean r25 = true;
    L41:
        if (r25 == false) goto L67;
        String r26 = r23.b();
        if (r26 != null) goto L45;
    L48:
        boolean r27 = true;
    L49:
        if (r27 == false) goto L67;
        String r28 = r23.c();
        if (r28 != null) goto L53;
    L56:
        boolean r29 = true;
    L57:
        if (r29 == false) goto L67;
        String r30 = r23.d();
        if (r30 != null) goto L61;
    L64:
        boolean r31 = true;
    L65:
        if (r31 == false) goto L67;
        boolean r32 = true;
    L68:
        if (r32 == true) goto L126;
        String r33 = r23.a();
        if (r33 != null) goto L72;
    L75:
        boolean r34 = true;
    L76:
        if (r34 == false) goto L78;
    L81:
        boolean r35 = true;
    L82:
        if (r35 == false) goto L126;
        String r36 = r23.b();
        if (r36 != null) goto L86;
    L89:
        boolean r37 = true;
    L90:
        if (r37 == false) goto L92;
    L95:
        boolean r38 = true;
    L96:
        if (r38 == false) goto L126;
        String r39 = r23.c();
        if (r39 != null) goto L100;
    L103:
        boolean r40 = true;
    L104:
        if (r40 == false) goto L106;
    L109:
        boolean r41 = true;
    L110:
        if (r41 == false) goto L126;
        String r42 = r23.d();
        if (r42 != null) goto L114;
    L117:
        boolean r43 = true;
    L118:
        if (r43 == false) goto L120;
    L123:
        boolean r44 = true;
    L124:
        if (r44 == false) goto L126;
        boolean r45 = true;
    L127:
        if (r45 == false) goto L33;
        r4 = true;
        goto L131
    L120:
        if (Intrinsics.areEqual(r42, String.valueOf(Build.VERSION.SDK_INT)) == true) goto L123;
        r44 = false;
        goto L124
    L114:
        if (r42.length() == 0) goto L117;
        r43 = false;
        goto L118
    L106:
        if (Intrinsics.areEqual(r39, Build.MODEL) == true) goto L109;
        r41 = false;
        goto L110
    L100:
        if (r39.length() == 0) goto L103;
        r40 = false;
        goto L104
    L92:
        if (Intrinsics.areEqual(r36, Build.MANUFACTURER) == true) goto L95;
        r38 = false;
        goto L96
    L86:
        if (r36.length() == 0) goto L89;
        r37 = false;
        goto L90
    L78:
        if (Intrinsics.areEqual(r33, Build.BRAND) == true) goto L81;
        r35 = false;
        goto L82
    L72:
        if (r33.length() == 0) goto L75;
        r34 = false;
    L126:
        r45 = false;
        goto L127
    L61:
        if (r30.length() == 0) goto L64;
        r31 = false;
        goto L65
    L53:
        if (r28.length() == 0) goto L56;
        r29 = false;
        goto L57
    L45:
        if (r26.length() == 0) goto L48;
        r27 = false;
    L67:
        r32 = false;
        goto L68
    L37:
        if (r24.length() == 0) goto L40;
        r25 = false;
        goto L41
    L29:
        if (r21.isEmpty() == false) goto L31;
    L20:
        if (r19.isEmpty() == true) goto L23;
        r20 = false;
        goto L24
    L8:
        if (r14.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public final void f(Context r6, File r7, String r8, String r9) {
        if (r7.getName().endsWith(".apk") == false) goto L23;
        String[] r0 = FileUtils.a;
        int r1 = Build.VERSION.SDK_INT;
        boolean r2 = false;
        if (r1 >= 26) goto L7;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L13:
        r2 = true;
    L14:
        if (r2 == true) goto L23;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        if (r1 < 26) goto L25;
        if (r1 < 26) goto L26;
        Intent r10 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", UriProtector.parse("package:" + r6.getPackageName()));
        if ((r6 instanceof Activity) == false) goto L21;
        ((Activity) r6).startActivityForResult(r10, 1);
        return;
    L21:
        r10.addFlags(268435456);
        r6.startActivity(r10);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        if (RomUtils.j() == false) goto L14;
    L7:
        if (r6.getPackageManager().canRequestPackageInstalls() == true) goto L9;
        r4 = false;
    L23:
        FileOpenUtils.b(r6, r7, r8, r9, this.g);
    }

    public final void g(final FileContent r10, final String r11, final Context r12, final OpenFileParams r13) {
        this.l = r12;
        ArrayList<String> r0 = r10.getRiskObjectKeys();
        if (r0 != null) goto L5;
    L20:
        h(r10, r11, r12, r13);
        return;
    L5:
        if (r10.getFileState() != FileState.DOWNLOAD) goto L20;
        if (this.c.isFeatureGatingEnable("im.message.richtext_file_attachment_risk_detect_disabled") == true) goto L20;
        if (this.c.isFeatureGatingEnable("messenger.file.detect") == false) goto L20;
        if (r0.contains(r10.getKey()) == false) goto L15;
        wbb.d r1 = vbb.a.a();
        com.ss.android.lark.download.service.impl.j r2 = (com.ss.android.lark.download.service.impl.j) r1;
        r2.c(new AnonymousClass10(this, r10, r11, r12, r13));
        return;
    L15:
        if (CollectionUtils.isEmpty(r0) == false) goto L20;
        if (this.p == true) goto L20;
        wbb.d r3 = vbb.a.a();
        List r4 = Collections.singletonList(r10.getKey());
        IGetDataCallback<List<wbb.d.c>> r8 = new AnonymousClass9(this, r10, r11, r12, r13);
        ((com.ss.android.lark.download.service.impl.j) r3).getClass();
        Log.i("DownloadFile", "getIMFileRiskTagByKeys calls.");
        MGetIMFileRiskTagRequest.Builder r14 = new MGetIMFileRiskTagRequest.Builder().source_terminal(SourceTerminal.Mobile).object_id(r4);
        SdkSender.sendPassThroughRequest(Command.GET_IM_FILE_RISK_TAG, r14, r8, new com.ss.android.lark.download.service.impl.i());
    }

    public final void h(final FileContent r17, String r18, Context r19, OpenFileParams r20) {
        this.g = r18;
        this.j = r17.getKey();
        j();
        int r2 = a.a[r17.getFileState().ordinal()];
        boolean r3 = true;
        if (r2 != 1) goto L5;
        com.ss.android.lark.vfs.h r4 = sfb.c.b();
        String r5 = r17.getFilePath();
        r17.getName();
        VFSFile r6 = r4.i(sfb.c.a(r5));
        String[] r7 = FileUtils.a;
        String r8 = FileUtils.p(r6.getPath());
        if (TextUtils.isEmpty(r8) == false) goto L39;
        boolean r9 = false;
    L40:
        if (r9 == false) goto L48;
        WeakReference<z> r10 = this.a;
        if (r10 != null) goto L44;
    L46:
        f(r19, r6, r17.getMime(), this.j);
        return;
    L44:
        if (r10.get() == null) goto L46;
        this.a.get().vy(Collections.singletonList(r6.getPath()));
        return;
    L48:
        if (com.ss.android.lark.filedetail.impl.open.c.b(d(), r19, r17, r20) == true) goto L54;
        f(r19, r6, r17.getMime(), this.j);
        return;
    L54:
        return;
    L39:
        r9 = r8.contains("image/");
        goto L40
    L5:
        if (r2 == 2) goto L8;
        return;
    L8:
        if (this.p == true) goto L10;
        this.f.getClass();
        Log.w("FileDetailModuleDependencyMock", "auditFileDownload mocked");
    L10:
        r17.setFileState(FileState.DOWNLOADING);
        r17.setProgress(0);
        k(0);
        this.b.wrapAndAddGetDataCallback(new AnonymousClass11(this, r17));
        String r11 = r17.getName();
        Token r12 = new Token("LARK-PSDA-messenger_file_download_create");
        Set r13 = MediaStoreUtil.a;
        Intrinsics.checkNotNullParameter(r12, "token");
        String r14 = FileUtils.p(r11);
        Set r15 = MediaStoreUtil.a;
        MediaStoreUtil.DirType r16 = MediaStoreUtil.h(r11);
        ContentValues r110 = new ContentValues();
        Intrinsics.checkNotNullParameter(r14, "mimeType");
        Intrinsics.checkNotNullParameter(r16, "dirType");
        Intrinsics.checkNotNullParameter(r12, "token");
        Intrinsics.checkNotNullParameter(r14, "mimeType");
        Intrinsics.checkNotNullParameter(r16, "dirType");
        if (r11 != null) goto L14;
    L17:
        PolarisFileWrapper r21 = null;
    L33:
        if (r21 == null) goto L35;
        r21.getAbsolutePath();
    L35:
        FileDetailModuleDependencyMock.b r22 = this.d;
        r17.getKey();
        r22.getClass();
        Log.w("FileDetailModuleDependencyMock", "downloadMailAttachment mocked");
        return;
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L21;
        if (DevEnvUtil.isDebugMode(r19) == false) goto L17;
        throw new RuntimeException("Filename should not be null");
    L21:
        if (Build.VERSION.SDK_INT > 29) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L31;
        Intrinsics.checkNotNullParameter(r14, "mimeType");
        Intrinsics.checkNotNullParameter(r16, "dirType");
        Intrinsics.checkNotNullParameter(r12, "token");
        Uri r23 = MediaStoreUtil.g(r19, r11, r14, r16, r110, r12);
        if (r23 != null) goto L28;
        Intrinsics.checkNotNullParameter(r14, "mimeType");
        Intrinsics.checkNotNullParameter(r16, "dirType");
        r23 = MediaStoreUtil.g(r19, r11, r14, r16, r110, null);
    L28:
        r21 = m0.b(r19, r23, false);
        if (r21 != null) goto L33;
        PolarisFileWrapper r24 = new PolarisFileWrapper(new PolarisFileWrapper(Environment.getExternalStorageDirectory(), MediaStoreUtil.i(r16)), r11);
    L32:
        r21 = r24;
        goto L33
    L31:
        r24 = new PolarisFileWrapper(new PolarisFileWrapper(Environment.getExternalStorageDirectory(), MediaStoreUtil.i(r16)), r11);
        goto L32
    }

    public final void i(Message r21, final FileContent r22, Context r23, OpenFileParams r24, FileDetailFragment.c r25) {
        this.l = r23;
        this.g = r21.getId();
        r21.getSourceId();
        this.h = r21.getSourceType();
        this.i = r22.getKey();
        if (r24 != null) goto L5;
        OpenFileParams.Companion.getClass();
        OpenFileParams.a r1 = new OpenFileParams.a();
        Intrinsics.checkNotNullParameter(r22, "fileContent");
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r1.a = r22;
        String r3 = this.g;
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.b = r3;
        r1.e = false;
        OpenFileParams r5 = r1.a();
    L6:
        this.r = r5;
        int r2 = a.a[r22.getFileState().ordinal()];
        if (r2 != 1) goto L9;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new p(this, r22, r25, r23, r5));
        return;
    L9:
        if (r2 == 2) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r5.getMergeMsgChatId()) == false) goto L14;
        r21.getChatId();
    L16:
        if (this.s.compareAndSet(false, true) == false) goto L22;
        boolean r4 = r5.isSecret();
        int r6 = rfb.a.a;
        String r7 = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.file_download, "null", true, MapsKt.mapOf(new Pair[]{TuplesKt.to("is_crypto", Boolean.valueOf(r4)), TuplesKt.to("had_been_paused", Boolean.FALSE)}), null, null, null, 448, null);
        this.q = r7;
        IGetDataCallback r0 = this.b.wrapAndAddCallback(new AnonymousClass2(this, r7, r22, r4, r21));
        new AnonymousClass3(this, r22);
        if (r21.getType() != Message.Type.FILE) goto L20;
        FileContent r8 = (FileContent) r21.getContent();
    L21:
        System.currentTimeMillis();
        FileDetailModuleDependencyMock.e r9 = this.f;
        r8.getKey();
        r21.getId();
        r9.getClass();
        Log.w("FileDetailModuleDependencyMock", "checkFileDownloadAuthorizationAndShowWarningOnFailed mocked");
        return;
    L20:
        r8 = r22;
        goto L21
    L22:
        Log.e("FileTransmissionPresenter", "downloadFile duplicated", new RuntimeException("Unexpected method call"));
        return;
    L14:
        r5.getMergeMsgChatId();
        goto L16
    L5:
        r5 = r24;
        goto L6
    }
}

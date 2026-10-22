package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.keyboard.KeyboardScene;
import com.ss.android.lark.keyboard.dtocompat.Image;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.statistics.PostInputPluginHitPoint;
import com.ss.android.lark.keyboard.statistics.TextInputPluginHitPoint;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import com.ss.android.lark.widget.photopicker.statistics.PerfGalleryLoadMonitor;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PhotoKBPlugin extends PanelMenuItem implements com.ss.android.lark.keyboard.base.b {
    public static final /* synthetic */ int w = 0;
    public final boolean d;
    public final boolean e;
    public final com.ss.android.lark.keyboard.plugin.tool.photo.a f;
    public View g;
    public LarkPhotoPickerView h;
    public final CommonLoadingDialog i;
    public final int j;
    public final int k;
    public final int l;
    public final Function0<Unit> m;
    public String n;
    public boolean o;
    public final boolean p;
    public final n q;
    public final KeyboardMenuItemKey r;
    public final g s;
    public VideoSendChecker.a t;
    public boolean u;
    public b v;

    public static final class a {
    }

    public interface b {
        void a(List<Photo> r1);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[KeyboardScene.values().length];
            r0[KeyboardScene.Moments.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class d extends dlb.b {
        public final /* synthetic */ PhotoKBPlugin a;
        public final /* synthetic */ Activity b;

        public static final class a implements Runnable {
            public final /* synthetic */ PhotoKBPlugin a;

            public a(PhotoKBPlugin r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.ss.android.lark.c.f(this.a.n());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // dlb.b
        public final void h() {
            UICallbackExecutor.execute(new a(this.a));
            PhotoKBPlugin.H(this.a);
        }

        public d(PhotoKBPlugin r1, Activity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // dlb.b
        public final void i(int r3, String r4) {
            Log.e("PhotoKBPlugin", "onUploadFailed, errorCode:" + r3 + ", errorMsg:" + r4);
            if (KeyboardPhotoModule.a().isHitStorageQuotaLimit(r3) == false) goto L5;
            KeyboardPhotoModule.a().showQuotaLimitDialog(this.b, r3);
        L23:
            PhotoKBPlugin.H(this.a);
            return;
        L5:
            PhotoKBPlugin r0 = this.a;
            if (r3 != r0.l) goto L9;
            KeyboardPhotoModule.a().showUnifiedStorageLimitCTADialog(this.b);
            goto L23
        L9:
            if (r3 != r0.j) goto L12;
            KeyboardPhotoModule.a().onAuthorizatedDeny(this.b, r4);
            goto L23
        L12:
            if (r3 == r0.k) goto L23;
            if (r4 != null) goto L15;
        L18:
            boolean r5 = true;
        L19:
            if (r5 == true) goto L21;
            UDToast.show(this.b, r4);
        L22:
            this.a.n().z().z();
            goto L23
        L21:
            UDToast.show(this.b, 2131891722);
            goto L22
        L15:
            if (r4.length() == 0) goto L18;
            r5 = false;
            goto L19
        }

        @Override // dlb.b
        public final void k(com.ss.android.lark.image.uploader.entity.b r5, com.ss.android.lark.image.uploader.entity.c r6) {
            Intrinsics.checkNotNullParameter(r5, "uploadImage");
            if (r6 == null) goto L12;
            String r7 = r6.a;
            ImageInfo r0 = r5.k;
            int r1 = 0;
            if (r0 == null) goto L7;
            int r2 = r0.a;
        L8:
            if (r0 == null) goto L10;
            r1 = r0.b;
        L10:
            Image r3 = new Image(CollectionsKt.listOf(r5.j), r2, r1, r7);
            this.a.L(r3, r5.b);
            return;
        L7:
            r2 = 0;
            goto L8
        }

        @Override // dlb.b
        public final void j(int r2, com.ss.android.lark.image.uploader.entity.b r3, long r4, int r6, int r7) {
            PhotoKBPlugin.H(this.a);
            Log.e("PhotoKBPlugin", "onUploadFileCheckInvalid, errorCode:" + r2 + ", maxLimitValue:" + r4);
            if (r2 != (-10003)) goto L5;
            Activity r5 = this.b;
            StringBuilder r8 = new StringBuilder();
            r8.append(r6);
            r8.append('*');
            r8.append(r7);
            UDToast.show(r5, UIHelper.mustacheFormat(2131891176, "ResolutionRate", r8.toString()));
            return;
        L5:
            if (r2 == (-10001)) goto L7;
            UDToast.show(this.b, UIHelper.getString(2131891182));
            return;
        L7:
            UDToast.show(this.b, UIHelper.mustacheFormat(2131891159, "Num", "" + r4));
        }
    }

    public static final class e extends PermissionPurposeWindowPermissionResult {
        public final /* synthetic */ PhotoKBPlugin b;

        public e(PhotoKBPlugin r1) {
            this.b = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult
        public final void b(StoragePermissionUtils.c r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.b.S(r2);
        }
    }

    public static final class f implements com.ss.android.lark.utils.h.d {
        public final /* synthetic */ PhotoKBPlugin a;

        public final boolean b() {
            return true;
        }

        public final boolean a() {
            if (this.a.J().a != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public f(PhotoKBPlugin r1) {
            this.a = r1;
        }
    }

    static {
    }

    public void R() {
    }

    public void U() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131254899;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        LarkPhotoPickerView r0 = this.h;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.f.l();
    }

    public final StoragePermissionUtils.c J() {
        return new StoragePermissionUtils.c(n().l().getContext(), new String[0]);
    }

    public final boolean Q() {
        if (n().L().getInputType() != InputSupportType.Post) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.r;
    }

    public static final void H(PhotoKBPlugin r2) {
        Activity r0 = r2.n().l().getContext();
        if (r0.isDestroyed() == false) goto L5;
    L7:
        Log.e("PhotoKBPlugin", "activity destroyed, skip hide dialog");
        return;
    L5:
        if (r0.isFinishing() == true) goto L7;
        r2.i.dismiss();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r6) {
        View r0 = null;
        if (r6 == false) goto L45;
        KeyboardScene r7 = n().l().a;
        PerfGalleryLoadMonitor r3 = PerfGalleryLoadMonitor.a;
        if (c.a[r7.ordinal()] != 1) goto L7;
        Scene r8 = Scene.Moments;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "scene");
        PerfGalleryLoadMonitor.a r4 = PerfGalleryLoadMonitor.b;
        if (r4 != null) goto L11;
        r4 = new PerfGalleryLoadMonitor.a();
    L11:
        PerfGalleryLoadMonitor.b = r4;
        r4.a(r8, 1);
        U();
        if (n().L().getInputType() != InputSupportType.Post) goto L14;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        new PostInputPluginHitPoint("picture").c();
    L19:
        this.m.invoke();
        if (this.o == true) goto L32;
        this.o = true;
        View r10 = this.g;
        if (r10 == null) goto L24;
        r0 = r10;
    L25:
        r0.setSelected(true);
        boolean r11 = Q();
        LarkPhotoPickerView r1 = this.h;
        if (r1 == null) goto L28;
        r1.setIsInPostMode(r11);
    L28:
        LarkPhotoPickerView r12 = this.h;
        if (r12 == null) goto L31;
        r12.setEnablePostSendVideo(this.f.j());
    L31:
        S(J());
        return;
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L25
    L32:
        View r13 = this.g;
        if (r13 == null) goto L35;
        r0 = r13;
    L36:
        r0.setSelected(true);
        boolean r14 = Q();
        LarkPhotoPickerView r2 = this.h;
        if (r2 == null) goto L39;
        r2.setIsInPostMode(r14);
    L39:
        LarkPhotoPickerView r15 = this.h;
        if (r15 == null) goto L42;
        r15.setEnablePostSendVideo(this.f.j());
    L42:
        LarkPhotoPickerView r16 = this.h;
        if (r16 == null) goto L55;
        r16.g(false);
        return;
    L55:
        return;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L36
    L18:
        new TextInputPluginHitPoint("picture").c();
        goto L19
    L14:
        r9 = false;
        goto L16
    L7:
        r8 = Scene.Chat;
        goto L8
    L45:
        View r17 = this.g;
        if (r17 == null) goto L48;
        r0 = r17;
    L49:
        r0.setSelected(false);
        LarkPhotoPickerView r18 = this.h;
        if (r18 == null) goto L52;
        r18.b();
    L52:
        this.f.l();
        return;
    L48:
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        goto L49
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r14, "container");
        final Activity r0 = n().l().getContext();
        LarkPhotoPickerView r15 = LayoutInflater.from(r14.getContext()).inflate(2131561738, r14, false);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.widget.halfscreen.LarkPhotoPickerView");
        this.h = r15;
        LarkPhotoPickerView.d r16 = new PhotoKBPlugin$onCreatePanel$onFuncPickListener$1(this, r0);
        LarkPhotoPickerView r1 = this.h;
        if (r1 == null) goto L5;
        r1.setShowGif(true);
        r1.setShowVideo(this.f.p());
        r1.setPhotoPickerListener(r16);
    L5:
        StoragePermissionUtils.c r17 = J();
        Log.i("PhotoKBPlugin", "onCreatePanel / " + r17);
        if (r17.a != 2) goto L11;
        Activity r4 = n().l().getContext();
        e r18 = new e(this);
        com.ss.android.lark.utils.l r6 = com.ss.android.lark.utils.n.b();
        Token r7 = new Token("LARK-PSDA-android_photo_picker_request_permission");
        f r11 = new f(this);
        String[] r2 = new String[0];
        StoragePermissionUtils.b r3 = StoragePermissionUtils.c(r4, 22, r2);
        if (r3.a == false) goto L10;
        r18.b(new StoragePermissionUtils.c(r4, r2));
        goto L11
    L10:
        String[] r12 = r3.b;
        com.ss.android.lark.utils.h.e(r4, new com.ss.android.lark.utils.c(r18, r4, r2), r6, r7, true, r12.length, 0, r11, r12);
    L11:
        LarkPhotoPickerView r19 = this.h;
        if (r19 == null) goto L15;
        return r19;
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void S(StoragePermissionUtils.c r4) {
        Log.i("PhotoKBPlugin", "prepareMedias / " + r4);
        int r5 = r4.a;
        LarkPhotoPickerView r0 = this.h;
        if (r0 == null) goto L14;
        r0.i();
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L17;
        r0.g(false);
        return;
    L17:
        return;
    L11:
        if (r0.j() == true) goto L16;
        r0.g(false);
        return;
    L16:
        return;
    }

    public final List<Photo> T(List<Photo> r8) {
        com.ss.android.lark.keyboard.plugin.tool.photo.a r0 = this.f;
        RichText r2 = null;
        if ((r0 instanceof com.ss.android.lark.keyboard.plugin.tool.photo.b) == false) goto L5;
        com.ss.android.lark.keyboard.plugin.tool.photo.b r1 = (com.ss.android.lark.keyboard.plugin.tool.photo.b) r0;
    L6:
        if (r1 != null) goto L9;
        return r8;
    L9:
        if (r1.a() == true) goto L11;
        return r8;
    L11:
        Object r3 = n().L().c();
        if ((r3 instanceof FunctionEditText) == false) goto L14;
        r2 = com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) ((FunctionEditText) r3).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g));
    L14:
        boolean r4 = !((ArrayList) com.ss.android.lark.widget.richtext.d.e(r2)).isEmpty();
        ArrayList r5 = new ArrayList(r8.size());
        ArrayList r6 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L26;
        Photo r7 = (Photo) r9.next();
        if (r7.isVideo() == false) goto L22;
        if (r4 == false) goto L22;
        r6.add(r7);
    L22:
        r5.add(r7);
        if (r7.isVideo() == false) goto L16;
        r4 = true;
        goto L16
    L26:
        if ((!r6.isEmpty()) == true) goto L28;
    L30:
        return r5;
    L28:
        if (r1.b() != r6.size()) goto L30;
        UDToast.show(n().l().getContext(), 2131890955);
        goto L30
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void w(boolean r2) {
        View r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIcon");
        r0 = null;
    L6:
        r0.setEnabled(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r3) {
        Intrinsics.checkNotNullParameter(r3, "iconHolder");
        r3.a.setActivated(this.d);
        View r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.g = r4;
    }

    public PhotoKBPlugin(boolean r2, com.ss.android.lark.keyboard.plugin.tool.photo.a r3) {
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.d = r2;
        this.e = true;
        this.f = r3;
        this.i = new CommonLoadingDialog();
        this.j = KeyboardPhotoModule.a().getFileUploadAuthorizatedDenyCode();
        this.k = KeyboardPhotoModule.a().getFileUploadAuthorizatedDenyCodeByFilePolicy();
        this.l = KeyboardPhotoModule.a().getUnifiedStorageLimitErrorCode();
        this.m = PhotoKBPlugin$mPluginClickListener$1.INSTANCE;
        this.n = InvRouter.UNKNOWN;
        this.p = true;
        this.q = new n(this);
        this.r = KeyboardMenuItemKey.Photo;
        this.s = new g(this);
        this.u = true;
    }

    public final void K(List<Photo> r10, boolean r11) {
        List<Photo> r0 = T(r10);
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Photo r7 = (Photo) r5;
        boolean r8 = r7.isVideo();
        if (r7.isVideo() == false) goto L11;
        r1.add(r7);
    L13:
        if (r4 == CollectionsKt.getLastIndex(r0)) goto L16;
        if (r8 == true) goto L16;
    L21:
        r4 = r6;
    L16:
        if ((!r2.isEmpty()) == false) goto L19;
        M(new ArrayList(r2), r11, r10);
        r2.clear();
    L19:
        if ((!r1.isEmpty()) == false) goto L21;
        P(new ArrayList(r1), r11);
        r1.clear();
        goto L21
    L11:
        r2.add(r7.getPath());
        goto L13
    }

    public void L(Image r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, LoadParams.ImageFormat.IMAGE);
        R();
        List<String> r0 = r5.getUrls();
        if (CollectionUtils.isNotEmpty(r0) == true) goto L5;
        return;
    L5:
        if (this.u == false) goto L11;
        com.ss.android.lark.widget.span.b.b.a r1 = new com.ss.android.lark.widget.span.b.b.a((String) ListProtector.get(r0, 0), r5.getWidth(), r5.getHeight());
        Object r2 = n().L().c();
        if ((r2 instanceof FunctionEditText) == false) goto L12;
        hob.f r3 = new hob.f(r1, r5.getToken(), r6, null);
        ((ImageEditor) ((FunctionEditText) r2).q(ImageEditor.c)).insert(r3);
        return;
    L12:
        return;
    }

    public final void P(List<Photo> r14, boolean r15) {
        if (CollectionUtils.isEmpty(r14) == false) goto L5;
        return;
    L5:
        Object r0 = n().L().c();
        ArrayList r1 = new ArrayList();
        if ((r0 instanceof FunctionEditText) == false) goto L8;
        RichText r2 = com.ss.android.lark.keyboard.edittext2.edittors.richText.d.j((com.ss.android.lark.keyboard.edittext2.edittors.richText.d) ((FunctionEditText) r0).q(com.ss.android.lark.keyboard.edittext2.edittors.richText.d.g));
    L9:
        r1.addAll(com.ss.android.lark.widget.richtext.d.e(r2));
        if (CollectionUtils.isNotEmpty(r1) == false) goto L13;
        UDToast.show(n().l().getContext(), 2131890426);
        return;
    L13:
        R();
        b r3 = this.v;
        if (r3 == null) goto L16;
        r3.a(r14);
    L16:
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r14.iterator();
    L18:
        if (r5.hasNext() == false) goto L20;
        Photo r6 = (Photo) r5.next();
        String r7 = CompressPathManager.generateCompressFilePath(r6.getPath(), Boolean.valueOf(r15));
        String r8 = r6.getPath();
        Intrinsics.checkNotNull(r7);
        VideoInfo r9 = new VideoInfo(r8, r7, r6.getMimeType(), r6.getSize(), r6.getDuration());
        this.f.a();
        r4.add(r9);
        goto L18
    L20:
        Intrinsics.checkNotNullParameter(r4, "videoInfos");
        Intrinsics.checkNotNullParameter(r14, "photos");
        this.i.show(n().l().getContext());
        g r16 = this.s;
        l r10 = new l(r4, this);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r4, "videoInfos");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r16.a.f.o(r4).observeOn(AndroidSchedulers.mainThread()).subscribeOn(LarkRxSchedulers.io()).subscribe(new com.ss.android.lark.keyboard.plugin.tool.photo.f(r10));
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r3 != 233) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r4, "data");
        LarkPhotoPickerView r0 = this.h;
        if (r0 == null) goto L11;
        r0.e(r3, -1, r4);
        return;
    L11:
        return;
    L5:
        if (r3 == 911) goto L7;
    }

    public void M(List<String> r5, boolean r6, List<Photo> r7) {
        Intrinsics.checkNotNullParameter(r5, "photoPaths");
        Intrinsics.checkNotNullParameter(r7, "photos");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r5.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        String r0 = (String) r9.next();
        com.ss.android.lark.image.uploader.entity.b.a r1 = new com.ss.android.lark.image.uploader.entity.b.a();
        r1.c(r0);
        r1.a(Biz.Messenger);
        r1.d(Scene.Chat);
        r1.d = 2;
        Intrinsics.checkNotNullParameter("ChatWindowActivity", "page");
        r1.e = "ChatWindowActivity";
        r1.g = r6;
        r8.add(r1.b());
        goto L4
    L6:
        long r10 = Environment.getDataDirectory().getFreeSpace();
        long r2 = ConfigManager.b();
        if (r10 >= r2) goto L9;
        Log.i("PhotoKBPlugin", "freeSpace is:" + r10 + ", diskFreeSizeLimit:" + r2);
        ThreadUtils.runOnUIThread(com.ss.android.lark.keyboard.plugin.tool.photo.e.a);
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return;
    L12:
        Activity r12 = n().l().getContext();
        this.i.show(r12);
        int r13 = ykb.a.b;
        ykb.a r14 = ykb.a.C0347a.a(r12);
        Intrinsics.checkNotNullParameter(r8, "imageList");
        ImageUploadTask r3 = r14.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "imageList");
        r3.b.addAll(r8);
        r14.a.g = new com.ss.android.lark.image.uploader.upload.d(this.e);
        r14.a(new d(this, r12));
        r14.c();
        return;
    L9:
        r11 = true;
        goto L10
    }

    public final void V(List<Photo> r12, List<String> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "photos");
        if (Q() == false) goto L5;
        List<Photo> r0 = T(r12);
    L6:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
        int r5 = 0;
    L8:
        if (r3.hasNext() == false) goto L45;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        Photo r8 = (Photo) r6;
        boolean r9 = r8.isVideo();
        if (r8.isVideo() == false) goto L15;
        r1.add(r8);
    L17:
        if (r5 == CollectionsKt.getLastIndex(r0)) goto L20;
        if (r9 == true) goto L20;
    L43:
        r5 = r7;
    L20:
        if ((!r2.isEmpty()) == false) goto L27;
        if (Q() == false) goto L24;
        M(new ArrayList(r2), r14, r12);
    L25:
        r2.clear();
        goto L27
    L24:
        this.f.e(new ArrayList(r2), r14, r12.size(), this.n);
    L27:
        if ((!r1.isEmpty()) == false) goto L43;
        if (Q() == true) goto L31;
    L33:
        Photo r10 = (Photo) ListProtector.get(r1, 0);
        int r11 = r12.size();
        if (r13 != null) goto L36;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == false) goto L41;
        ArrayList<File> r16 = new ArrayList();
        VFSFiles.b.getClass();
        r16.add(VFSFiles.b(true).i(r10.getPath()));
        this.f.h(r16);
    L42:
        r1.clear();
        goto L43
    L41:
        ArrayList r17 = new ArrayList();
        r10.setCompressPath(CompressPathManager.generateCompressFilePath(r10.getPath(), Boolean.valueOf(r14)));
        r17.add(r10);
        this.f.i(r17, r11);
        goto L42
    L36:
        if (r13.contains(r10.getPath()) != true) goto L38;
        r15 = true;
        goto L39
    L31:
        if (this.f.j() == false) goto L33;
        P(new ArrayList(r1), r14);
        goto L42
    L15:
        r2.add(r8.getPath());
        goto L17
    L45:
        if (Q() == true) goto L52;
        com.ss.android.lark.keyboard.event.k.a.a(n().e(), q.a.a);
        n().H().h();
        return;
    L52:
        return;
    L5:
        r0 = r12;
        goto L6
    }
}

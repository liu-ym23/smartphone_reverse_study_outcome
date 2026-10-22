package ia8;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.larus.bmhome.share.panel.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef<DialogFragment> b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;

        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        public final void f() {
        }

        public final void onDismiss() {
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public a(String r1, Ref.ObjectRef<DialogFragment> r2, File r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final boolean b(Context r7, DialogFragment r8, View r9, jr9.a r10) {
            Intrinsics.checkNotNullParameter(r10, "shareItemConfig");
            if (r7 != null) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(r10.b(), "save_image") == false) goto L23;
            ImageSave r11 = ImageSave.a;
            String r12 = this.a;
            Intrinsics.checkNotNull(r12);
            if (StringsKt.startsWith$default(r12, "file://", false, 2, null) != true) goto L10;
            String r13 = this.a;
            Intrinsics.checkNotNull(r13);
            String r14 = StringsKt.removePrefix(r13, "file://");
        L13:
            StringBuilder r15 = new StringBuilder();
            r15.append(Environment.DIRECTORY_DCIM);
            r15.append(File.separator);
            int r3 = j0.a;
            r15.append(j0.d(2131894310));
            String r16 = r15.toString();
            Function2 r4 = new g();
            r11.getClass();
            ImageSave.u(r7, r14, r16, r4);
            DialogFragment r17 = (DialogFragment) this.b.element;
            if (r17 != null) goto L36;
        L21:
            return true;
        L36:
            r17.dismiss();     // Catch: Exception -> L17
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r18 = DialogFragmentLancet.sLastShowStack;
            if (r18 == null) goto L21;
            com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L21
        L10:
            r14 = this.a;
            if (r14 != null) goto L13;
            r14 = "";
            goto L13
        L23:
            if (Intrinsics.areEqual(r10.b(), "more") == false) goto L33;
            int r19 = h.a;
            h.e(this.c, this.d);
            DialogFragment r20 = (DialogFragment) this.b.element;
            if (r20 != null) goto L34;
        L32:
            return true;
        L34:
            r20.dismiss();     // Catch: Exception -> L28
        L28:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r21 = DialogFragmentLancet.sLastShowStack;
            if (r21 == null) goto L32;
            com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L32
        L33:
            return false;
        }
    }

    static {
    }

    public static void a(PolarisFileWrapper r10) {
        long r0 = System.currentTimeMillis();     // Catch: Exception -> L12
        File[] r11 = r10.listFiles();     // Catch: Exception -> L12
        if (r11 == null) goto L21;
        int r2 = r11.length;     // Catch: Exception -> L12
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L22;
        File r4 = r11[r3];     // Catch: Exception -> L12
        if (r4.isFile() == false) goto L11;
        if ((r0 - r4.lastModified()) <= 604800000) goto L11;
        r4.delete();     // Catch: Exception -> L12
    L11:
        r3 = r3 + 1;
        goto L5
    L22:
        return;
    L21:
        return;
    L12:
        e = move-exception;
        FLogger.a.w("DoraShareUtils", "clear temp file failed: " + e.getMessage());
    }

    public static String b(String r1) {
        switch(r1.hashCode()) {
            case 96323: goto L67;
            case 96980: goto L63;
            case 97669: goto L59;
            case 101488: goto L56;
            case 102340: goto L53;
            case 105441: goto L50;
            case 106458: goto L47;
            case 108184: goto L44;
            case 108272: goto L41;
            case 108273: goto L38;
            case 108308: goto L35;
            case 110834: goto L31;
            case 111145: goto L28;
            case 115312: goto L24;
            case 117484: goto L21;
            case 117856: goto L18;
            case 3145576: goto L15;
            case 3268712: goto L12;
            case 3645337: goto L9;
            case 3645340: goto L6;
            default: goto L70;
        };
    L70:
        return "*/*";
    L6:
        if (r1.equals("webp") == false) goto L70;
    L61:
        return "image/*";
    L9:
        if (r1.equals("webm") == false) goto L70;
    L65:
        return "video/*";
    L12:
        if (r1.equals("jpeg") == true) goto L61;
    L15:
        if (r1.equals("flac") == false) goto L70;
    L69:
        return "audio/*";
    L18:
        if (r1.equals("wmv") == true) goto L65;
    L21:
        if (r1.equals("wav") == true) goto L69;
    L24:
        if (r1.equals("txt") == false) goto L70;
        return "text/plain";
    L28:
        if (r1.equals("png") == true) goto L61;
    L31:
        if (r1.equals("pdf") == false) goto L70;
        return "application/pdf";
    L35:
        if (r1.equals("mov") == true) goto L65;
    L38:
        if (r1.equals("mp4") == true) goto L65;
    L41:
        if (r1.equals("mp3") == true) goto L69;
    L44:
        if (r1.equals("mkv") == true) goto L65;
    L47:
        if (r1.equals("m4a") == true) goto L69;
    L50:
        if (r1.equals("jpg") == true) goto L61;
    L53:
        if (r1.equals("gif") == true) goto L61;
    L56:
        if (r1.equals("flv") == true) goto L65;
    L59:
        if (r1.equals("bmp") == true) goto L61;
    L63:
        if (r1.equals("avi") == true) goto L65;
    L67:
        if (r1.equals("aac") == true) goto L69;
        goto L69
    }

    public static void c(List r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "mediaFiles");
        if (r18.isEmpty() == false) goto L6;
        Application r0 = AppHost.a.getApplication();
        int r1 = j0.a;
        Toast.makeText(r0, j0.d(2131897066), 0).show();
        return;
    L6:
        Application r2 = AppHost.a.getApplication();
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2.getExternalFilesDir(null), Environment.DIRECTORY_DCIM);     // Catch: Exception -> L34
        if (r4.exists() == true) goto L10;
        r4.mkdirs();     // Catch: Exception -> L34
    L10:
        a(r4);     // Catch: Exception -> L34
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L34
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L34
        String r7 = "";
        Iterator r3 = r18.iterator();     // Catch: Exception -> L34
        boolean r9 = true;
    L12:
        if (r3.hasNext() == false) goto L24;
        String r10 = (String) r3.next();     // Catch: Exception -> L34
        PolarisFileWrapper r15 = new PolarisFileWrapper(StringsKt.removePrefix(r10, "file://"));     // Catch: Exception -> L34
        if (r15.exists() == false) goto L15;
        String r11 = b(FilesKt.getExtension(r15).toLowerCase());     // Catch: Exception -> L34
        if (r9 == false) goto L20;
        r7 = r11;
        r9 = false;
    L22:
        PolarisFileWrapper r12 = new PolarisFileWrapper(r4, r15.getName());     // Catch: Exception -> L34
        FilesKt.copyTo$default(r15, r12, true, 0, 4, null);     // Catch: Exception -> L34
        r5.add(r15);     // Catch: Exception -> L34
        r6.add(r12);     // Catch: Exception -> L34
        goto L12
    L20:
        if (Intrinsics.areEqual(r7, r11) == true) goto L22;
        r7 = "*/*";
        goto L22
    L15:
        FLogger.a.w("DoraShareUtils", "file not exist: " + r10);     // Catch: Exception -> L34
        goto L12
    L24:
        if (r6.isEmpty() == false) goto L28;
        Toast.makeText(r2, "no valid file", 0).show();     // Catch: Exception -> L34
        return;
    L28:
        if (r6.size() != 1) goto L32;
        if (r19 == false) goto L31;
        e((File) ListProtector.get(r6, 0), r7);     // Catch: Exception -> L34
        return;
    L31:
        f((File) ListProtector.get(r6, 0), r7);     // Catch: Exception -> L34
        return;
    L32:
        d(r6, r7);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        Toast.makeText(r2, "share failed: " + e.getMessage(), 0).show();
        FLogger.a.e("DoraShareUtils", "share failed", e);
    }

    public static void d(List r5, String r6) {
        Application r0 = AppHost.a.getApplication();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add(FileProvider.getUriForFile(r0, r0.getPackageName() + ".fileprovider", (File) r7.next()));
        goto L4
    L6:
        Intent r8 = new Intent("android.intent.action.SEND_MULTIPLE");
        r8.setType(r6);
        r8.putParcelableArrayListExtra("android.intent.extra.STREAM", new ArrayList(r1));
        r8.addFlags(1);
        Intent r9 = Intent.createChooser(r8, AppHost.a.getApplication().getString(2131902137));
        r9.addFlags(268435456);
        r0.startActivity(r9);
    }

    public static void e(File r4, String r5) {
        AppHost.Companion r0 = AppHost.a;
        Application r1 = r0.getApplication();
        Uri r6 = FileProvider.getUriForFile(r1, r1.getPackageName() + ".fileprovider", r4);
        Intent r2 = new Intent("android.intent.action.SEND");
        r2.setType(r5);
        r2.putExtra("android.intent.extra.STREAM", r6);
        r2.addFlags(1);
        Intent r7 = Intent.createChooser(r2, r0.getApplication().getString(2131902137));
        r7.addFlags(268435456);
        r1.startActivity(r7);
    }

    public static void f(File r32, String r33) {
        String r6 = r32.getAbsolutePath();
        Activity r1 = AppHost.a.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        Activity r29 = (FragmentActivity) r1;
    L6:
        if (r29 != null) goto L8;
        return;
    L8:
        if (r29.isFinishing() == false) goto L10;
        return;
    L10:
        if (r29.isDestroyed() == false) goto L12;
        return;
    L12:
        if (StringsKt.contains$default(r33, "video", false, 2, null) == false) goto L14;
        String r31 = r6;
        com.larus.bmhome.share.panel.b r30 = new com.larus.bmhome.share.panel.b(null, null, null, null, r6, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108847);
    L15:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Activity r8 = r29;
        r2.element = IShareService.a.g(ShareServiceDelegate.b, r8, ShareScene.IMAGE_VIEWER, r30, null, new a(r31, r2, r32, r33), null, false, 232);
        return;
    L14:
        r31 = r6;
        r30 = new com.larus.bmhome.share.panel.b(r31, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, true, null, null, false, false, null, false, null, null, 66977790);
        goto L15
    L5:
        r29 = null;
        goto L6
    }
}

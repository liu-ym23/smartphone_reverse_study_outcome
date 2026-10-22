package com.bytedance.android.annie.business.web;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/business/web/FixedUploadFileFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public final class FixedUploadFileFragment extends Fragment {
    public static final /* synthetic */ int i = 0;
    public Context d;
    public d e;
    public Function1<? super Uri[], Unit> f;
    public String g;
    public boolean h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ FixedUploadFileFragment b;

        public b(FragmentActivity r1, FixedUploadFileFragment r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r10) {
            com.bytedance.android.annie.util.c.b(this.a, 2131897336);
            FixedUploadFileFragment r11 = this.b;
            int r0 = FixedUploadFileFragment.i;
            r11.T90(null);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ FixedUploadFileFragment a;
        public final /* synthetic */ Intent b;
        public final /* synthetic */ FragmentActivity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Intent e;

        public c(FixedUploadFileFragment r1, Intent r10, FragmentActivity r11, String r12, Intent r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            if (r11 != (-2)) goto L5;
            FixedUploadFileFragment r12 = this.a;
            Intent r0 = this.b;
            int r1 = FixedUploadFileFragment.i;
            r12.W90(r0);
        L12:
            r10.dismiss();
            return;
        L5:
            if (r11 != (-1)) goto L12;
            FixedUploadFileFragment r13 = this.a;
            FragmentActivity r14 = this.c;
            String r15 = this.d;
            Intent r16 = this.e;
            int r17 = FixedUploadFileFragment.i;
            r13.getClass();
            if (com.bytedance.android.annie.bridge.method.permission.c.a(r14, r15) == false) goto L10;
            r13.W90(r16);
            goto L12
        L10:
            r13.e = new com.bytedance.android.annie.business.web.c(r13, r16, r14);
            r13.requestPermissions(new String[]{r15}, 1024);
            goto L12
        }
    }

    static {
    }

    public FixedUploadFileFragment() {
    }

    public final void T90(Uri[] r10) {
        Function1<? super Uri[], Unit> r0 = this.f;
        if (r0 == null) goto L5;
        r0.invoke(r10);
        this.f = null;
    L5:
        this.g = null;
        this.h = false;
    }

    public final void W90(Intent r10) {
        startActivityForResult(r10, 2048);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        com.bytedance.android.annie.util.c.b(r0, 2131897337);
    L9:
        this.h = true;
        T90(null);
        e.printStackTrace();
    }

    public final void onActivityResult(int r11, int r12, Intent r13) {
        if (r11 == 2048) goto L5;
        return;
    L5:
        if (r12 == 0) goto L7;
    L10:
        PolarisFileInputStreamWrapper r10 = null;
        if (r13 == null) goto L27;
        if (r12 != (-1)) goto L27;
        ClipData r14 = r13.getClipData();
        if (r14 == null) goto L24;
        ArrayList r15 = new ArrayList();
        int r16 = r14.getItemCount();
        int r17 = 0;
    L17:
        if (r17 >= r16) goto L19;
        r15.add(r14.getItemAt(r17).getUri());
        r17 = r17 + 1;
        goto L17
    L19:
        Object[] r18 = r15.toArray(new Uri[0]);
        if (r18 == null) goto L23;
        Uri[] r19 = (Uri[]) r18;
    L28:
        if (r19 != null) goto L71;
        if (r13 != null) goto L71;
        if (r12 != (-1)) goto L71;
        String r110 = this.g;
        if (r110 == null) goto L71;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110);
        if (r111.exists() == false) goto L71;
        r19 = new Uri[]{Uri.fromFile(r111)};
        Context r112 = this.d;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r112 = null;
    L38:
        String r0 = this.g;
        Intrinsics.checkNotNull(r0);
        String r113 = r111.getName();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r113);
        if (StringsKt.contains$default(r113, Environment.DIRECTORY_DCIM, false, 2, null) == false) goto L46;
        int r114 = StringsKt.indexOf$default(r113, Environment.DIRECTORY_DCIM, 0, false, 6, null);
        if (r113 == null) goto L44;
        String r115 = r113.substring(r114);
    L49:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r115);
        String r117 = r116.getName();
        File r118 = r116.getParentFile();
        if (r118 == null) goto L52;
        String r119 = r118.getPath();
    L53:
        if (r119 != null) goto L73;
        r119 = "";
    L73:
        Uri r120 = BdMediaFileSystem.createImageUri(r112, r117, "image/*", r119);     // Catch: Exception -> L57
    L58:
        if (r120 == null) goto L71;
        OutputStream r121 = ContentResolverWrapper.openOutputStream(r112.getContentResolver(), r120);     // Catch: Exception -> L62
    L63:
        if (r121 == null) goto L71;
        r10 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r0));     // Catch: Exception -> L67
    L68:
        if (r10 == null) goto L71;
        com.bytedance.android.annie.util.d.b(r10, r121);
    L62:
        r121 = null;
    L57:
        r120 = null;
        goto L58
    L52:
        r119 = null;
        goto L53
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L46:
        if (r1.isAbsolute() == true) goto L48;
        r115 = Environment.DIRECTORY_DCIM + File.separator + r113;
        goto L49
    L48:
        StringBuilder r122 = new StringBuilder();
        r122.append(Environment.DIRECTORY_DCIM);
        String r123 = File.separator;
        r122.append(r123);
        r122.append("Camera");
        r122.append(r123);
        r122.append(r1.getName());
        r115 = r122.toString();
    L71:
        T90(r19);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        Uri r20 = r13.getData();
        if (r20 == null) goto L27;
        r19 = new Uri[]{r20};
    L27:
        r19 = null;
        goto L28
    L7:
        if (this.h == false) goto L10;
        this.h = false;
    }

    public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        if (r10 == 1024) goto L5;
        return;
    L5:
        if (r12.length != 0) goto L7;
        boolean r13 = true;
    L9:
        if ((!r13) == true) goto L11;
    L15:
        d r14 = this.e;
        if (r14 == null) goto L22;
        r14.onPermissionDenied();
        return;
    L22:
        return;
    L11:
        if (r12[0] != 0) goto L15;
        d r15 = this.e;
        if (r15 == null) goto L20;
        r15.onPermissionGranted();
        return;
    L20:
        return;
    L7:
        r13 = false;
        goto L9
    }

    public final Intent S90(boolean r10, boolean r11, boolean r12, boolean r13) {
        Intent r0 = new Intent("android.intent.action.GET_CONTENT");
        r0.addCategory("android.intent.category.OPENABLE");
        ArrayList r1 = new ArrayList();
        if (r10 == false) goto L5;
        String r14 = "image/*";
        r1.add("image/*");
    L6:
        String r15 = "*/*";
        boolean r16 = true;
        if (r11 == true) goto L9;
    L17:
        if (r12 == true) goto L19;
    L26:
        r0.setType(r14);
        Object[] r17 = r1.toArray(new String[0]);
        if (r17 == null) goto L31;
        r0.putExtra("android.intent.extra.MIME_TYPES", (String[]) r17);
        r0.putExtra("android.intent.extra.ALLOW_MULTIPLE", r13);
        return r0;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L19:
        if (r14.length() == 0) goto L23;
        r16 = false;
    L23:
        if (r16 == false) goto L25;
        r15 = "audio/*";
    L25:
        r1.add("audio/*");
        r14 = r15;
        goto L26
    L9:
        if (r14.length() != 0) goto L11;
        boolean r18 = true;
    L13:
        if (r18 == false) goto L15;
        r14 = "video/*";
    L16:
        r1.add("video/*");
        goto L17
    L15:
        r14 = "*/*";
        goto L16
    L11:
        r18 = false;
        goto L13
    L5:
        r14 = "";
        goto L6
    }

    public final boolean U90(Function1<? super Uri[], Unit> r18, String[] r19, boolean r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "chooseFileCallback");
        this.f = r18;
        if (r19 == null) goto L59;
        Context r10 = null;
        if (r20 == false) goto L42;
        int r11 = r19.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L59;
        String r13 = r19[r12];
        if (StringsKt.startsWith$default(r13, "image", false, 2, null) == true) goto L10;
        if (StringsKt.startsWith$default(r13, "video", false, 2, null) == true) goto L35;
        if (StringsKt.startsWith$default(r13, "audio", false, 2, null) == true) goto L39;
        r12 = r12 + 1;
        goto L7
    L39:
        V90("android.permission.RECORD_AUDIO", 2131897342, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131897338, S90(false, false, true, r21));
        return true;
    L35:
        V90("android.permission.CAMERA", 2131897344, new Intent("android.media.action.VIDEO_CAPTURE"), 2131897340, S90(false, true, false, r21));
        return true;
    L10:
        Intent r14 = new Intent("android.media.action.IMAGE_CAPTURE");
        Context r15 = this.d;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r15 = null;
    L13:
        PolarisFileWrapper r16 = r15.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r16 != null) goto L19;
        Context r17 = this.d;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r17 = null;
    L18:
        r16 = new PolarisFileWrapper(r17.getFilesDir(), Environment.DIRECTORY_DCIM);
    L19:
        StringBuilder r110 = new StringBuilder();
        r110.append(r16.getAbsolutePath());
        String r22 = File.separator;
        r110.append(r22);
        r110.append("browser-photos");
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110.toString());
        r111.mkdirs();
        String r23 = r111.getAbsolutePath() + r22 + System.currentTimeMillis() + ".jpg";
        this.g = r23;
        Context r112 = this.d;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L23:
        PolarisFileWrapper r24 = new PolarisFileWrapper(r23);
        if (r10 != null) goto L26;
    L30:
        Uri r25 = Uri.fromFile(r24);
    L31:
        r14.putExtra("output", r25);
        V90("android.permission.CAMERA", 2131897343, r14, 2131897339, S90(true, false, false, r21));
        return true;
    L26:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        if (r10.getApplicationInfo().targetSdkVersion < 24) goto L30;
        r25 = FileProvider.getUriForFile(r10, r10.getPackageName() + ".fileprovider", r24);
        goto L31
    L22:
        r10 = r112;
        goto L23
    L42:
        int r113 = r19.length;
        int r114 = 0;
        boolean r115 = false;
        boolean r116 = false;
        boolean r117 = false;
    L43:
        if (r114 >= r113) goto L54;
        String r118 = r19[r114];
        if (StringsKt.startsWith$default(r118, "image", false, 2, null) == false) goto L48;
        r115 = true;
    L53:
        r114 = r114 + 1;
        goto L43
    L48:
        if (StringsKt.startsWith$default(r118, "video", false, 2, null) == false) goto L51;
        r116 = true;
        goto L53
    L51:
        if (StringsKt.startsWith$default(r118, "audio", false, 2, null) == false) goto L53;
        r117 = true;
        goto L53
    L54:
        if (r115 == true) goto L57;
        if (r116 == true) goto L57;
        if (r117 == false) goto L59;
    L57:
        W90(S90(r115, r116, r117, r21));
        return true;
    L59:
        W90(S90(true, true, true, r21));
        return true;
    }

    public final void V90(String r11, int r12, Intent r13, int r14, Intent r15) {
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L5;
        AlertDialog.Builder r16 = new AlertDialog.Builder(r10);
        r16.setTitle(2131897345);
        r16.setMessage(2131897341);
        c r17 = new c(this, r15, r10, r11, r13);
        r16.setPositiveButton(r12, r17);
        r16.setNegativeButton(r14, r17);
        r16.setOnCancelListener(new b(r10, this));
        AlertDialog r18 = r16.show();
    L6:
        if (r18 != null) goto L9;
        T90(null);
        return;
    L9:
        return;
    L5:
        r18 = null;
        goto L6
    }
}

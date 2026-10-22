package com.ss.android.lark.officewebview.quality.safe;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import com.ss.android.lark.officesdk.utils.di.c;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.n;
import com.ss.android.lark.officesdk.utils.di.o;
import com.ss.android.lark.officesdk.utils.di.r;
import com.ss.android.lark.officesdk.utils.di.s;
import com.ss.android.lark.officewebview.dependency.IDevicePermissionDependency;
import com.ss.android.lark.officewebview.quality.safe.permission.PermissionHostFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ntb.d;
import swb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FileChooseHandlerV2 {
    public static final /* synthetic */ int f = 0;
    public final Context a;
    public ValueCallback<Uri> b;
    public ValueCallback<Uri[]> c;
    public FragmentActivity d;
    public final b e;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.officewebview.quality.safe.permission.b.a {
        public final /* synthetic */ FileChooseHandlerV2 a;

        public b(FileChooseHandlerV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.officewebview.quality.safe.permission.b.a
        public final void a(int r2, int r3, Intent r4) {
            if (r2 != 11) goto L5;
            this.a.f(r3, r4);
            return;
        L5:
            if (r2 != 12) goto L11;
            this.a.f(r3, r4);
            return;
        }
    }

    static {
    }

    public static boolean h() {
        int r0 = g.a;
        boolean r1 = g.a.a("openplatform.web.input.img_video_mixed_opt_enable");
        if (r1 == true) goto L5;
        Intrinsics.checkNotNullParameter("openplatform.web.input.img_video_mixed_opt_enable", "key");
        r1 = g.a.a("openplatform.web.input.img_video_mixed_opt_enable");
    L5:
        j.e("FileChooseHandlerV2", "mixed opt enable: " + r1);
        return r1;
    }

    public FileChooseHandlerV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        DependencyContainer r3 = DependencyContainer.a;
        d r4 = (d) DependencyContainer.a(d.class, null);
        if (r4 == null) goto L5;
        r4.F();
    L5:
        this.e = new b(this);
    }

    public static boolean a(String r6) {
        if (StringsKt.contains$default(r6, "app_webview", false, 2, null) == false) goto L7;
        j.e("FileChooseHandlerV2", "contains app_webview");
        return true;
    L7:
        if (StringsKt.contains$default(r6, "databases", false, 2, null) == false) goto L11;
        j.e("FileChooseHandlerV2", "contains databases");
        return true;
    L11:
        if (StringsKt.contains$default(r6, "shared_prefs", false, 2, null) == false) goto L15;
        j.e("FileChooseHandlerV2", "contains shared_prefs");
        return true;
    L15:
        if (StringsKt.contains$default(r6, "files", false, 2, null) == false) goto L18;
        j.e("FileChooseHandlerV2", "contains files");
        return true;
    L18:
        return false;
    }

    public static Intent c(boolean r6) {
        Intent r0 = new Intent("android.intent.action.GET_CONTENT");
        r0.addCategory("android.intent.category.OPENABLE");
        r0.setType("*/*");
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.putExtra("android.intent.extra.ALLOW_MULTIPLE", r6);
        Intent r4 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.putExtra("android.intent.extra.ALLOW_MULTIPLE", r6);
        Intent r7 = b(r6, new Intent[]{null, r4});
        r7.putExtra("android.intent.extra.INTENT", r0);
        return r7;
    }

    public static Intent d(String r2) {
        Intent r0 = new Intent("android.intent.action.GET_CONTENT");
        r0.addCategory("android.intent.category.OPENABLE");
        r0.setType(r2);
        return r0;
    }

    public static FragmentActivity e(Context r2) {
        j.e("FileChooseHandlerV2", "findActivity context = " + r2);
        if ((r2 instanceof FragmentActivity) == false) goto L6;
        return (FragmentActivity) r2;
    L6:
        if ((r2 instanceof ContextWrapper) == true) goto L14;
        FragmentActivity r3 = (Activity) com.ss.android.lark.officewebview.util.b.a.get();
        if ((r3 instanceof FragmentActivity) == true) goto L15;
        return null;
    L15:
        return r3;
    L14:
        return e(((ContextWrapper) r2).getBaseContext());
    }

    private final void setResult(Uri[] r11) {
        int r0 = g.a;
        boolean r2 = true;
        if (g.a.a("open.platform.web.file.chooser.check") == false) goto L36;
        j.e("FileChooseHandlerV2", "open.platform.web.file.chooser.check is open");
        if (r11 == null) goto L36;
        int r4 = r11.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L36;
        Uri r6 = r11[r5];
        Context r7 = this.a;
        int r8 = r.a;
        PolarisFileWrapper r9 = r.a.a().A(r7, r6, false);
        if (r9 != null) goto L58;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == true) goto L27;
        r5 = r5 + 1;
        goto L7
    L27:
        int r12 = s.a;
        s.a.a(this.a, "无法分享，暂不支持分享此类内容。");
        ValueCallback<Uri> r13 = this.b;
        if (r13 == null) goto L30;
        r13.onReceiveValue(Uri.EMPTY);
    L30:
        ValueCallback<Uri[]> r14 = this.c;
        if (r14 == null) goto L33;
        r14.onReceiveValue(new Uri[0]);
    L33:
        this.c = null;
        this.b = null;
        return;
    L58:
        String r15 = r9.getCanonicalPath();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r7, "context");     // Catch: Exception -> L22
        if (Build.VERSION.SDK_INT < 24) goto L14;
        File r16 = r7.getDataDir();     // Catch: Exception -> L22
    L15:
        String r17 = r16.getCanonicalPath();     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L22
        if (StringsKt.startsWith$default(r15, r17, false, 2, null) == false) goto L24;
        j.b("FileChooseHandlerV2", "isApplicationInternalFile");     // Catch: Exception -> L22
        if (a(r15) == false) goto L20;
        r10 = true;
        goto L26
    L20:
        j.e("FileChooseHandlerV2", "allow visit---");     // Catch: Exception -> L22
    L24:
        j.e("FileChooseHandlerV2", "is not ApplicationInternalFile");
        goto L25
    L14:
        r16 = r7.getCacheDir().getParentFile();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        j.b("FileChooseHandlerV2", "An exception occurred while getCanonicalPath," + e.getMessage());
    L36:
        if (r11 != null) goto L38;
    L44:
        r2 = false;
    L45:
        if (r2 == false) goto L49;
        ValueCallback<Uri> r1 = this.b;
        if (r1 == null) goto L49;
        r1.onReceiveValue(r11[0]);
    L49:
        if (r11 == null) goto L53;
        ValueCallback<Uri[]> r3 = this.c;
        if (r3 == null) goto L56;
        r3.onReceiveValue(r11);
    L56:
        this.c = null;
        this.b = null;
        return;
    L53:
        ValueCallback<Uri[]> r18 = this.c;
        if (r18 == null) goto L56;
        r18.onReceiveValue(new Uri[0]);
        goto L56
    L38:
        if (r11.length != 0) goto L40;
        boolean r19 = true;
    L42:
        if ((!r19) != true) goto L44;
    L40:
        r19 = false;
        goto L42
    }

    public static Intent b(boolean r2, Intent... r3) {
        Intent r0 = new Intent("android.intent.action.CHOOSER");
        r0.putExtra("android.intent.extra.INITIAL_INTENTS", r3);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.putExtra("android.intent.extra.ALLOW_MULTIPLE", r2);
        r0.putExtra("android.intent.extra.TITLE", "\"选择要上传的文件\"");
        return r0;
    }

    private final void startActivity(Intent r5, int r6) {
        FragmentActivity r2 = e(this.a);     // Catch: ActivityNotFoundException -> L6
        j.e("FileChooseHandlerV2", "mContext type = " + this.a.getClass() + " , context = " + r2);     // Catch: ActivityNotFoundException -> L6
        if (r2 == null) goto L8;
        int r1 = PermissionHostFragment.f;     // Catch: ActivityNotFoundException -> L6
        PermissionHostFragment.U90(r2.getSupportFragmentManager()).startActivityForResult(r5, r6, this.e);     // Catch: ActivityNotFoundException -> L6
    L20:
        return;
    L8:
        j.e("FileChooseHandlerV2", "is not FragmentActivity so return");     // Catch: ActivityNotFoundException -> L6
    L6:
        e = move-exception;
        FragmentActivity r3 = e(this.a);     // Catch: ActivityNotFoundException -> L15
        if (r3 == null) goto L13;
        int r4 = PermissionHostFragment.f;     // Catch: ActivityNotFoundException -> L15
        PermissionHostFragment.U90(r3.getSupportFragmentManager()).startActivityForResult(c(false), r6, this.e);     // Catch: ActivityNotFoundException -> L15
    L17:
        return;
    L13:
        j.e("FileChooseHandlerV2", "second is not FragmentActivity so return");     // Catch: ActivityNotFoundException -> L15
    L15:
        j.c("FileChooseHandlerV2", "ActivityNotFoundException", e);
    }

    public final void f(int r12, Intent r13) {
        j.e("FileChooseHandlerV2", "onResult " + r12);
        int r0 = g.a;
        Intrinsics.checkNotNullParameter("openplatform.web.choose_file_fix_cancel_disable", "key");
        boolean r2 = true;
        String r3 = "";
        com.ss.android.lark.officesdk.di.core.b r4 = null;
        if ((!g.a.a("openplatform.web.choose_file_fix_cancel_disable")) == false) goto L32;
        StringBuilder r1 = new StringBuilder("get KEY_FOR_SEND: ");
        if (r13 == null) goto L12;
        int r5 = n.a;
        ntb.s r6 = n.a.a();
        if (r6 == null) goto L10;
        String r7 = r6.g0();
        if (r7 == null) goto L10;
    L11:
        Boolean r8 = Boolean.valueOf(r13.getBooleanExtra(r7, true));
    L13:
        r1.append(r8);
        r1.append(", KEY_FOR_SEND exist: ");
        if (r13 == null) goto L23;
        Bundle r9 = r13.getExtras();
        if (r9 == null) goto L23;
        int r10 = n.a;
        ntb.s r11 = n.a.a();
        if (r11 == null) goto L21;
        String r14 = r11.g0();
        if (r14 == null) goto L21;
    L22:
        Boolean r15 = Boolean.valueOf(r9.containsKey(r14));
    L24:
        r1.append(r15);
        j.e("FileChooseHandlerV2", r1.toString());
        if (r13 == null) goto L32;
        int r16 = n.a;
        ntb.s r17 = n.a.a();
        if (r17 == null) goto L30;
        String r18 = r17.g0();
        if (r18 == null) goto L30;
    L31:
        boolean r19 = r13.getBooleanExtra(r18, true);
    L33:
        boolean r20 = !r19;
        if (r12 == 0) goto L146;
        if (r20 == true) goto L146;
        ArrayList r21 = new ArrayList();
        if (r13 == null) goto L42;
        if (r12 != (-1)) goto L42;
        Uri r22 = r13.getData();
    L44:
        if (r13 != null) goto L47;
        j.e("FileChooseHandlerV2", "intentContainsDataIsNull,intent == null");
    L57:
        boolean r23 = false;
    L58:
        if (r23 == false) goto L112;
        if (r13 == null) goto L61;
        ClipData r110 = r13.getClipData();
    L62:
        if (r110 == null) goto L67;
        int r111 = r110.getItemCount();
        int r24 = 0;
    L64:
        if (r24 >= r111) goto L66;
        r21.add(r110.getItemAt(r24).getUri());
        r24 = r24 + 1;
        goto L64
    L66:
        j.e("FileChooseHandlerV2", "multiple clipData not null " + r110.getItemCount());
    L130:
        if (r22 == null) goto L132;
        r21.add(r22);
    L132:
        FragmentActivity r112 = this.d;
        if (r112 != null) goto L136;
        j.b("FileChooseHandlerV2", "onResult activity not found");
        setResult(null);
        return;
    L136:
        setResult((Uri[]) r21.toArray(new Uri[0]));
        StringBuilder r113 = new StringBuilder("checkReadStoragePermission :");
        int r25 = com.ss.android.lark.officesdk.utils.di.a.a;
        Intrinsics.checkNotNullParameter(r112, "context");
        DependencyContainer r26 = DependencyContainer.a;
        com.ss.android.lark.officesdk.di.core.b r27 = DependencyContainer.a(ntb.b.class, null);
        if ((r27 instanceof ntb.b) == false) goto L140;
        r4 = r27;
    L140:
        ntb.b r28 = (ntb.b) r4;
        if (r28 == null) goto L145;
        r113.append(r28.P(r112));
        j.e("FileChooseHandlerV2", r113.toString());
        return;
    L145:
        throw new IllegalStateException("AppPermissionDependency not injected");
    L67:
        ArrayList r114 = new ArrayList();
        if (r13 == null) goto L75;
        int r29 = n.a;
        ntb.s r30 = n.a.a();
        if (r30 == null) goto L73;
        String r31 = r30.C();
        if (r31 == null) goto L73;
    L74:
        ArrayList<String> r32 = r13.getStringArrayListExtra(r31);
    L76:
        if (r32 == null) goto L78;
        r114.addAll(r32);
    L78:
        if (r13 == null) goto L87;
        int r33 = n.a;
        ntb.s r34 = n.a.a();
        if (r34 == null) goto L83;
        String r35 = r34.M();
        if (r35 == null) goto L83;
    L85:
        if (r13.getBooleanExtra(r35, false) != true) goto L87;
    L88:
        if (r2 == false) goto L101;
        if (r13 == null) goto L97;
        int r36 = n.a;
        ntb.s r37 = n.a.a();
        if (r37 == null) goto L96;
        String r38 = r37.D();
        if (r38 == null) goto L96;
        r3 = r38;
    L96:
        ArrayList r115 = r13.getParcelableArrayListExtra(r3);
    L98:
        if (r115 == null) goto L101;
        r114.addAll(r115);
        goto L101
    L97:
        r115 = null;
    L101:
        if (e.a(r114) == false) goto L104;
        setResult(null);
        return;
    L104:
        Iterator r116 = r114.iterator();
    L106:
        if (r116.hasNext() == false) goto L130;
        if (r116.next() == null) goto L106;
        int r117 = n.a;
        ntb.s r118 = n.a.a();
        if (r118 == null) goto L106;
        r118.l();
    L83:
        r35 = "";
    L87:
        r2 = false;
    L73:
        r31 = "";
        goto L74
    L75:
        r32 = null;
        goto L76
    L61:
        r110 = null;
        goto L62
    L112:
        if (r22 != null) goto L130;
        if (r12 != (-1)) goto L130;
        if (TextUtils.isEmpty(null) == true) goto L130;
        int r119 = r.a;
        File r120 = r.a.b("");
        if (r120.exists() == false) goto L130;
        j.e("FileChooseHandlerV2", "broadcast scan_file");
        r22 = Uri.fromFile(r120);
        int r121 = com.ss.android.lark.officewebview.util.e.a;
        Intrinsics.checkNotNullParameter(IDevicePermissionDependency.MediaScannerAction.FILE_CHOOSE_V2, "action");
        DependencyContainer r122 = DependencyContainer.a;
        IDevicePermissionDependency r123 = (IDevicePermissionDependency) DependencyContainer.a(IDevicePermissionDependency.class, DependencyContextUniqueId.OfficeWebView);
        if (r123 == null) goto L125;
        String r124 = r123.m0();
        if (r124 == null) goto L125;
        r3 = r124;
    L125:
        if (r3.length() > 0) goto L128;
        r2 = false;
    L128:
        if (r2 == false) goto L130;
        this.a.sendBroadcast(new Intent(r3, r22));
        goto L130
    L47:
        if (r13.getClipData() == null) goto L49;
    L51:
        boolean r39 = false;
    L52:
        j.e("FileChooseHandlerV2", "intentContainsDataIsNull,isNullInAndroid14 =" + r39);
        if (r39 == true) goto L57;
        if (r22 != null) goto L57;
        j.e("FileChooseHandlerV2", "intentContainsDataIsNull,singleResult == null");
        r23 = true;
        goto L58
    L49:
        if (r13.getExtras() != null) goto L51;
        r39 = true;
    L42:
        r22 = null;
    L146:
        j.e("FileChooseHandlerV2", "error step 1");
        setResult(null);
        return;
    L30:
        r18 = "";
    L21:
        r14 = "";
    L23:
        r15 = null;
    L10:
        r7 = "";
        goto L11
    L12:
        r8 = null;
    L32:
        r19 = true;
        goto L33
    }

    public final void g(final ValueCallback<Uri> r34, final ValueCallback<Uri[]> r35, final String[] r36, final WebChromeClient.FileChooserParams r37, boolean r38) {
        String[] r4 = r36;
        if (h() == false) goto L15;
        j.e("FileChooseHandlerV2", "use new logic");
        int r0 = r4.length;
        int r11 = 0;
    L5:
        if (r11 >= r0) goto L20;
        String r12 = r4[r11];
        if (Intrinsics.areEqual(r12, "image/*") == true) goto L14;
        if (Intrinsics.areEqual(r12, "image/") == true) goto L14;
        if (StringsKt.startsWith$default(r12, "image/", false, 2, null) == true) goto L14;
        r11 = r11 + 1;
    L14:
        boolean r1 = true;
    L23:
        boolean r13 = ArraysKt.contains(r4, "video/*");
        boolean r14 = ArraysKt.contains(r4, "audio/*");
        this.d = e(this.a);
        if (r37 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        j.e("FileChooseHandlerV2", "multiple selected = " + r15);
        if (this.b == null) goto L32;
    L33:
        if (r38 == true) goto L36;
        j.e("FileChooseHandlerV2", "file picker operation in progress");
        return;
    L36:
        this.b = r34;
        this.c = r35;
        if (r35 == null) goto L39;
        int r2 = 12;
    L40:
        int r6 = r4.length;
        int r5 = 0;
        boolean r17 = false;
    L41:
        if (r5 >= r6) goto L46;
        if (Intrinsics.areEqual(r4[r5], "audio/*") == true) goto L45;
        r17 = true;
    L45:
        r5 = r5 + 1;
        goto L41
    L46:
        FragmentActivity r8 = this.d;
        if (r8 != null) goto L50;
        j.b("FileChooseHandlerV2", "openFileChooser activity not found");
        f(r2, null);
        return;
    L50:
        if (r17 == false) goto L101;
        int r7 = com.ss.android.lark.officewebview.util.e.a;
        IDevicePermissionDependency.CameraPermissionScene r9 = IDevicePermissionDependency.CameraPermissionScene.FILE_CHOOSE_V2;
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "scene");
        DependencyContainer r10 = DependencyContainer.a;
        IDevicePermissionDependency r16 = (IDevicePermissionDependency) DependencyContainer.a(IDevicePermissionDependency.class, DependencyContextUniqueId.OfficeWebView);
        if (r16 == null) goto L55;
        boolean r18 = r16.o0();
        int r19 = r2;
        String r30 = "image/*";
        String r29 = "video/*";
        String r28 = "audio/*";
    L83:
        if (r18 == true) goto L100;
        if (r38 == true) goto L100;
        int r3 = g.a;
        boolean r20 = g.a.a("openplatform.disable.image.camera.permission");
        j.e("FileChooseHandlerV2", "openplatform.disable.image.camera.permission---" + r20);
        if (r20 == true) goto L89;
        if (r1 == false) goto L89;
        boolean r21 = true;
    L90:
        if (r21 == true) goto L100;
        j.e("FileChooseHandlerV2", "checkCameraPermission---");
        int r22 = com.ss.android.lark.officesdk.utils.di.a.a;
        final int r23 = r19;
        Function1<Boolean, Unit> r24 = new FileChooseHandlerV2$openFileChooser$2(this, r34, r35, r36, r37, r23);
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r24, "callback");
        DependencyContainer r25 = DependencyContainer.a;
        com.ss.android.lark.officesdk.di.core.b r26 = DependencyContainer.a(ntb.b.class, null);
        if ((r26 instanceof ntb.b) == true) goto L94;
        r26 = null;
    L94:
        ntb.b r27 = (ntb.b) r26;
        if (r27 == null) goto L99;
        r27.n0(r8, r24);
        return;
    L99:
        throw new IllegalStateException("AppPermissionDependency not injected");
    L89:
        r21 = false;
    L100:
        int r31 = r19;
    L102:
        if (r37 != null) goto L104;
    L106:
        boolean r32 = false;
    L108:
        if (r32 == false) goto L115;
        if (r1 == false) goto L111;
        String r33 = "camera";
    L117:
        if (r33.length() <= 0) goto L119;
        boolean r110 = true;
    L121:
        if (r110 == false) goto L123;
        String r111 = r33;
    L124:
        j.e("FileChooseHandlerV2", "capture = " + r33 + " , mediaSource = " + r111);
        if (Intrinsics.areEqual(r33, "filesystem") == false) goto L135;
        int r39 = r4.length;
        int r40 = 0;
    L127:
        if (r40 >= r39) goto L135;
        int r112 = r39;
        String[] r113 = (String[]) new Regex("=").split(r4[r40], 0).toArray(new String[0]);
        if (r113.length != 2) goto L133;
        if (Intrinsics.areEqual("capture", r113[0]) == false) goto L133;
        r111 = r113[1];
    L133:
        r40 = r40 + 1;
        r4 = r36;
        r39 = r112;
    L135:
        if (r1 == false) goto L156;
        j.e("FileChooseHandlerV2", "mActivity = " + r8);
        int r41 = g.a;
        Intrinsics.checkNotNullParameter("webview.open.system.camera", "key");
        j.e("FileChooseHandlerV2", "useSysCamera = " + g.a.a("webview.open.system.camera"));
        if (Intrinsics.areEqual(r111, "camera") == false) goto L144;
        int r42 = n.a;
        Intrinsics.checkNotNullParameter(new o(), "params");
        ntb.s r43 = n.a.a();
        if (r43 == null) goto L141;
        r43.from();
    L141:
        j.e("FileChooseHandlerV2", "PhotoPicker dependency not registered, fallback to system camera");
        startActivity(null, r31);
        return;
    L144:
        if (h() == false) goto L146;
        int r44 = n.a;
        o r45 = new o();
    L147:
        Intrinsics.checkNotNullParameter(r45, "params");
        ntb.s r46 = n.a.a();
        if (r46 == null) goto L150;
        r46.from();
    L150:
        j.e("FileChooseHandlerV2", "PhotoPicker dependency not registered, fallback to system picker, multiple=" + r15);
        if (r15 == false) goto L153;
        Intent r47 = d(r30);
        Intrinsics.checkNotNullParameter(r47, "<this>");
        r47.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        startActivity(r47, r31);
        return;
    L153:
        Intent r48 = b(false, new Intent[]{null});
        r48.putExtra("android.intent.extra.INTENT", d(r30));
        startActivity(r48, r31);
        return;
    L146:
        int r49 = n.a;
        r45 = new o();
        goto L147
    L156:
        if (r13 == true) goto L158;
        if (r14 == true) goto L165;
        startActivity(c(r15), r31);
        return;
    L165:
        if (Intrinsics.areEqual(r111, "microphone") == false) goto L168;
        Intent r50 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        Intrinsics.checkNotNullParameter(r50, "<this>");
        r50.putExtra("android.intent.extra.ALLOW_MULTIPLE", r15);
        startActivity(r50, r31);
        return;
    L168:
        Intent r51 = new Intent("android.provider.MediaStore.RECORD_SOUND");
        Intrinsics.checkNotNullParameter(r51, "<this>");
        r51.putExtra("android.intent.extra.ALLOW_MULTIPLE", r15);
        Intent r52 = b(r15, new Intent[]{r51});
        r52.putExtra("android.intent.extra.INTENT", d(r28));
        startActivity(r52, r31);
        return;
    L158:
        if (Intrinsics.areEqual(r111, "camcorder") == false) goto L161;
        startActivity(null, r31);
        return;
    L161:
        Intent r53 = b(r15, new Intent[]{null});
        r53.putExtra("android.intent.extra.INTENT", d(r29));
        startActivity(r53, r31);
        return;
    L123:
        r111 = "filesystem";
        goto L124
    L119:
        r110 = false;
        goto L121
    L111:
        if (r13 == false) goto L113;
        r33 = "camcorder";
        goto L117
    L113:
        if (r14 == false) goto L115;
        r33 = "microphone";
    L115:
        r33 = "";
        goto L117
    L104:
        if (r37.isCaptureEnabled() != true) goto L106;
        r32 = true;
        goto L108
    L55:
        if (Build.VERSION.SDK_INT < 23) goto L81;
        ArrayList r54 = new ArrayList();
        r19 = r2;
        Object[] r55 = {"android.permission.CAMERA"};
        f06.b r56 = new f06.b("auto_cert_com_ss_android_lark_officewebview_util_DevicePermissionUtil$Companion_android_app_Activity_checkSelfPermission");
        r28 = "audio/*";
        r29 = "video/*";
        g06.a r114 = (g06.a) ApiHookConfig.b.get(102608);
        if (r114 == null) goto L59;
        f06.a[] r115 = r114.i;
    L60:
        int r116 = r115.length;
        r30 = "image/*";
        int r57 = 0;
    L62:
        if (r57 >= r116) goto L73;
        int r310 = r116;
        f06.a r117 = r115[r57];
        Object[] r311 = r55;
        f06.d r58 = r117.preInvoke(102608, "android/app/Activity", "checkSelfPermission", r8, r55, "int", r56);     // Catch: Exception -> L71
        f06.b r118 = r56;
        if (r58.a == true) goto L75;
        r54.add(r117);     // Catch: Exception -> L172
    L75:
        if (r58.a == false) goto L77;
        int r59 = ((Integer) r58.b).intValue();
    L78:
        if (r59 == 0) goto L82;
        r18 = false;
    L82:
        r18 = true;
        goto L83
    L77:
        r59 = r8.checkSelfPermission("android.permission.CAMERA");
    L72:
        r57 = r57 + 1;
        r56 = r118;
        r116 = r310;
        r55 = r311;
    L71:
        r118 = r56;
        goto L72
    L73:
        r58 = new f06.d(false, null);
        goto L75
    L59:
        r115 = ApiHookConfig.d;
        goto L60
    L81:
        r19 = r2;
        r30 = "image/*";
        r29 = "video/*";
        r28 = "audio/*";
        goto L82
    L101:
        r31 = r2;
        r30 = "image/*";
        r29 = "video/*";
        r28 = "audio/*";
        goto L102
    L39:
        r2 = 11;
        goto L40
    L32:
        if (this.c == null) goto L36;
    L26:
        if (r37.getMode() != 1) goto L28;
        r15 = true;
    L20:
        r1 = false;
    L22:
        j.e("FileChooseHandlerV2", "contains img: " + r1);
        goto L23
    L15:
        j.e("FileChooseHandlerV2", "use old logic");
        if (ArraysKt.contains(r4, "image/*") == false) goto L18;
    L21:
        r1 = true;
        goto L22
    L18:
        if (ArraysKt.contains(r4, "image/") == false) goto L20;
        goto L20
    }
}

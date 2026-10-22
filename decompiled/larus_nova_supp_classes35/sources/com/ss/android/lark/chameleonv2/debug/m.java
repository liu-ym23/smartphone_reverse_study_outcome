package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements DialogInterface.OnClickListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ f e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ Function0<Unit> g;

    public m(TextView r1, TextView r2, EditText r3, boolean r4, f r5, ChameleonDebugActivity r6, Function0 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r19, int r20) {
        CharSequence r0 = this.a.getText();
        if (r0 == null) goto L8;
        String r1 = r0.toString();
        if (r1 == null) goto L8;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L8;
    L9:
        CmlDebugSettingUtil.b("chameleon_app_name", r2);
        CharSequence r3 = this.b.getText();
        String r4 = BuildConfig.FLAVOR;
        if (r3 == null) goto L17;
        String r5 = r3.toString();
        if (r5 == null) goto L17;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L17;
        String r10 = r6;
    L18:
        CmlDebugSettingUtil.b("chameleon_specific_bizname", r10);
        Editable r7 = this.c.getText();
        if (r7 == null) goto L26;
        String r8 = r7.toString();
        if (r8 == null) goto L26;
        String r9 = StringsKt.trim(r8).toString();
        if (r9 == null) goto L26;
        String r11 = r9;
    L28:
        if (this.d == false) goto L30;
        CmlDebugSettingUtil.b("chameleon_specific_download_url_tos", r11);
        CmlDebugSettingUtil.b("chameleon_specific_download_url_scm", BuildConfig.FLAVOR);
    L31:
        boolean r12 = false;
        if (r11.length() != 0) goto L34;
        boolean r13 = true;
    L36:
        if (r13 == false) goto L40;
        f.a(this.e, this.f, "Download URL is empty!");
        return;
    L40:
        if (StringsKt.startsWith$default(r11, "http", false, 2, null) == false) goto L46;
        this.e.getClass();
        String r14 = f.b(r11);
        if (r14 == null) goto L45;
        r4 = r14;
    L45:
        CmlDebugSettingUtil.b("chameleon_specific_version", r4);
    L70:
        if (r11.length() != 0) goto L72;
        boolean r15 = true;
    L73:
        if (r15 == true) goto L95;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_D_CmlDebugManager", "Download URL ".concat(r11));
        CmlDebugSettingUtil.b("chameleon_specific_download_url", r11);
        f r16 = this.e;
        Context r17 = this.f;
        boolean r18 = this.d;
        r16.getClass();
        String r21 = StringsKt.substringAfterLast$default(r11, "/", null, 2, null);
        ChameleonConfig.Builder r22 = new ChameleonConfig.Builder();
        if (r10.length() != 0) goto L77;
        r12 = true;
    L77:
        if (r12 == false) goto L79;
        String r23 = "default_bizname";
    L80:
        ChameleonConfig.Builder r24 = r22.bizName(r23);
        ResConfig r25 = new ResConfig(null, null, null, 7, null);
        r25.setResVersion("default");
        r25.setOfflineZipName(r21);
        ChameleonConfig r110 = r24.resConfig(r25).build();
        String r26 = CmlDebugSettingUtil.a("chameleon_app_name", "doubao");
        int r27 = v0b.b.a;
        g r28 = new g(r16, r17, r110, r26, r10);
        Intrinsics.checkNotNullParameter(r11, "url");
        VFSFiles.b.getClass();     // Catch: IOException -> L90
        VFSPath r29 = VFSFiles.b(true).t(v0b.e.e(r110));     // Catch: IOException -> L90
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_D_Downloader", "download srcDirPath:" + r29.getAbsolutePath());     // Catch: IOException -> L90
        if (r110 == null) goto L87;
        ResConfig r30 = r110.getResConfig();     // Catch: IOException -> L90
        if (r30 == null) goto L87;
        String r31 = r30.getOfflineZipName();     // Catch: IOException -> L90
        if (r31 == null) goto L87;
    L88:
        VFSPath r32 = r29.subPath(r31);     // Catch: IOException -> L90
        v0b.e.b(r32);     // Catch: IOException -> L90
        VFSPath r33 = v0b.d.a;     // Catch: IOException -> L90
        v0b.d.b(r11, r32, new v0b.a(r28, r110), v0b.b.a(r18));     // Catch: IOException -> L90
    L92:
        Function0<Unit> r34 = this.g;
        if (r34 == null) goto L99;
        r34.invoke();
        return;
    L99:
        return;
    L87:
        r31 = "default.zip";
    L90:
        e = move-exception;
        r28.c(e);
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_D_Downloader", "file download err:" + e);
        goto L92
    L79:
        r23 = r10;
        goto L80
    L95:
        f.a(this.e, this.f, "Download URL is empty!");
        return;
    L72:
        r15 = false;
        goto L73
    L46:
        CmlDebugSettingUtil.b("chameleon_specific_version", r11);
        f r35 = this.e;
        boolean r111 = this.d;
        r35.getClass();
        if (r11.length() != 0) goto L49;
        boolean r36 = true;
    L50:
        if (r36 == false) goto L53;
    L63:
        String r37 = null;
    L65:
        if (r37 == null) goto L68;
        r4 = r37;
    L68:
        r11 = r4;
        goto L70
    L53:
        if (TextUtils.equals(CmlDebugSettingUtil.a("chameleon_app_name", "doubao"), "doubao") == false) goto L61;
        if (r111 == false) goto L56;
        String r38 = f.e.get(r10);
    L59:
        if (r38 == null) goto L63;
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;
        r37 = String.format(r38, Arrays.copyOf(new Object[]{r11}, 1));
        goto L65
    L56:
        r38 = f.d.get(r10);
        if (r38 != null) goto L59;
    L61:
        String r39 = f.c.get(r10);
        if (r39 == null) goto L63;
        String r113 = StringsKt.replace$default(r11, ".", "_", false, 4, null);
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        r37 = String.format(r39, Arrays.copyOf(new Object[]{r113}, 1));
        goto L65
    L49:
        r36 = false;
        goto L50
    L34:
        r13 = false;
        goto L36
    L30:
        CmlDebugSettingUtil.b("chameleon_specific_download_url_scm", r11);
        CmlDebugSettingUtil.b("chameleon_specific_download_url_tos", BuildConfig.FLAVOR);
    L26:
        r11 = BuildConfig.FLAVOR;
    L17:
        r10 = BuildConfig.FLAVOR;
    L8:
        r2 = "doubao";
        goto L9
    }
}

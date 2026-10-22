package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t19.s;
import zk8.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LocalFileCardVMDependencyImpl implements com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.b {
    public static final Set<String> b = null;
    public final i a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/viewmodel/LocalFileCardVMDependencyImpl$PreferredApp;", "", "<init>", "(Ljava/lang/String;I)V", "BROWSER", "FILE_MANAGER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreferredApp extends Enum<PreferredApp> {
        public static final PreferredApp BROWSER = null;
        public static final PreferredApp FILE_MANAGER = null;
        public static final /* synthetic */ PreferredApp[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreferredApp> getEntries() {
            return b;
        }

        static {
            PreferredApp r0 = new PreferredApp("BROWSER", 0);
            BROWSER = r0;
            PreferredApp r1 = new PreferredApp("FILE_MANAGER", 1);
            FILE_MANAGER = r1;
            PreferredApp[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PreferredApp[] values() {
            return (PreferredApp[]) a.clone();
        }

        public static PreferredApp valueOf(String r1) {
            return (PreferredApp) r27.a.a(PreferredApp.class, r1);
        }

        public PreferredApp(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreferredApp.values().length];
            r0[PreferredApp.BROWSER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreferredApp.FILE_MANAGER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = SetsKt.setOf(new String[]{"html", "htm"});
    }

    public LocalFileCardVMDependencyImpl() {
        this.a = new i();
    }

    @Override // com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.b
    public final vl8.g a(com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return n.a.c(r2.e);
    }

    @Override // com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.b
    public final void b(Context r17, com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r18) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "data");
        FlowFileProtectionService r3 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        int r4 = 0;
        if (r3 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        i.b r7 = null;
        if (r6 == false) goto L19;
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("action", "open_external");
        r1.put("entry", "local_file_card");
        r1.put("content_type", ShareType.FILE);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("flow_enterprise_file_egress_block", r1);
        String r2 = r3.A0();
        if (r2 != null) goto L13;
        return;
    L13:
        if ((!StringsKt.isBlank(r2)) == false) goto L15;
        String r8 = r2;
    L16:
        if (r8 == null) goto L142;
        s.j(s.a, r17, r8, null, false, 28);
        return;
    L142:
        return;
    L15:
        r8 = null;
        goto L16
    L19:
        String r9 = r18.e;
        ch8.a r10 = ch8.a.a;
        r10.getClass();
        ch8.b.b r11 = ch8.a.a(r9);
        if ((r11 instanceof ch8.b.b) == true) goto L22;
    L24:
        boolean r12 = false;
    L26:
        if (r12 == false) goto L29;
        FLogger.a.i("LocalFileCardVMDependencyImpl", "openFileCard failed, file does not exist, path=" + r18.e + ", fileName=" + r18.c);
        y.c(new c());
        return;
    L29:
        i r13 = this.a;
        String r14 = r18.e;
        String r15 = r18.c;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r17, "context");
        if (r14 != null) goto L32;
        r14 = "";
    L32:
        r10.getClass();
        ch8.b.a r16 = ch8.a.a(r14);
        if ((r16 instanceof ch8.b.a) == false) goto L36;
        r7 = i.b(r17, r16.a, r15);
    L77:
        if (r7 != null) goto L80;
        FLogger.a.i("LocalFileCardVMDependencyImpl", "openFileCard failed, unresolved path=" + r18.e + ", fileName=" + r18.c);
        y.c(new d(r17, 2131905676));
        return;
    L80:
        Iterator r19 = SequencesKt.map(SequencesKt.sequenceOf(new String[]{r18.d, r18.c, r18.e}), new e()).iterator();
    L82:
        if (r19.hasNext() == false) goto L86;
        if (b.contains((String) r19.next()) == false) goto L82;
        boolean r20 = true;
    L87:
        if (r20 == false) goto L89;
        PreferredApp r21 = PreferredApp.BROWSER;
    L90:
        PreferredApp r22 = r21;
        Iterator<T> r110 = r7.c.iterator();
    L92:
        if (r110.hasNext() == false) goto L124;
        String r111 = (String) r110.next();
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L112
        Intent r24 = new Intent("android.intent.action.VIEW");     // Catch: Throwable -> L112
        r24.addFlags(1);     // Catch: Throwable -> L112
        if ((r17 instanceof Activity) == true) goto L97;
        r24.addFlags(268435456);     // Catch: Throwable -> L112
    L97:
        r24.setClipData(ClipData.newUri(r17.getContentResolver(), r7.b, r7.a));     // Catch: Throwable -> L112
        r24.setDataAndType(r7.a, r111);     // Catch: Throwable -> L112
        List<ResolveInfo> r112 = r17.getPackageManager().queryIntentActivities(r24, r4);     // Catch: Throwable -> L112
        if (r112.isEmpty() == false) goto L100;
        boolean r25 = false;
    L121:
        if (r25 == true) goto L143;
        r4 = 0;
        goto L92
    L143:
        return;
    L100:
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L112
    L102:
        if (r113.hasNext() == false) goto L104;
        r17.grantUriPermission(((ResolveInfo) r113.next()).activityInfo.packageName, r7.a, 1);     // Catch: Throwable -> L112
        goto L102
    L104:
        ResolveInfo r26 = d(r17, r112, r22);     // Catch: Throwable -> L112
        if (r26 == null) goto L107;
        ActivityInfo r27 = r26.activityInfo;     // Catch: Throwable -> L112
        r24.setClassName(r27.packageName, r27.name);     // Catch: Throwable -> L112
        r17.startActivity(r24);     // Catch: Throwable -> L112
        r25 = true;
        goto L121
    L107:
        Intent r28 = Intent.createChooser(r24, r7.b);     // Catch: Throwable -> L112
        r28.addFlags(1);     // Catch: Throwable -> L112
        r28.setClipData(r24.getClipData());     // Catch: Throwable -> L112
        if ((r17 instanceof Activity) == true) goto L110;
        r28.addFlags(268435456);     // Catch: Throwable -> L112
    L110:
        r17.startActivity(r28);     // Catch: Throwable -> L112
        Object r29 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L112
    L114:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L117;
        FLogger.a.e("LocalFileCardVMDependencyImpl", "openLocalFile failed, uri=" + r7.a + ", fileName=" + r7.b + ", mimeType=" + r111, r30);
    L117:
        Boolean r31 = Boolean.FALSE;
        if (Result.isFailure-impl(r29) == false) goto L120;
        r29 = r31;
    L120:
        r25 = ((Boolean) r29).booleanValue();
    L112:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L114
    L124:
        y.c(new d(r17, 2131905676));
        return;
    L89:
        r21 = PreferredApp.FILE_MANAGER;
        goto L90
    L86:
        r20 = false;
        goto L87
    L36:
        if ((r16 instanceof ch8.b.b) == false) goto L75;
        ch8.b.b r33 = (ch8.b.b) r16;
        Uri r34 = i.c(r17, r33.a, ".omni_exports.fileprovider");
        if (r34 != null) goto L73;
        r34 = i.c(r17, r33.a, ".fileprovider");
        if (r34 != null) goto L73;
        File r35 = r33.a;
        if (r35.isFile() == true) goto L44;
        r34 = null;
        goto L73
    L44:
        Uri r114 = MediaStore.Files.getContentUri("external");
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L67
        Cursor r36 = i.a(r17.getContentResolver(), r114, new String[]{"_id"}, "_data=?", new String[]{r35.getAbsolutePath()});     // Catch: Throwable -> L67
        if (r36 == null) goto L64;
        Cursor r116 = r36;     // Catch: Throwable -> L67
        Cursor r37 = r116;     // Catch: Throwable -> L57
        if (r37.moveToFirst() == false) goto L53;
        int r38 = r37.getColumnIndex("_id");     // Catch: Throwable -> L57
        if (r38 < 0) goto L53;
        Uri r39 = ContentUris.withAppendedId(r114, r37.getLong(r38));     // Catch: Throwable -> L57
    L55:
        CloseableKt.closeFinally(r116, null);     // Catch: Throwable -> L67
    L65:
        Object r40 = Result.constructor-impl(r39);     // Catch: Throwable -> L67
    L70:
        if (Result.isFailure-impl(r40) == false) goto L72;
        r40 = null;
    L72:
        r34 = (Uri) r40;
        goto L73
    L53:
        r39 = null;
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L64:
        r39 = null;
    L67:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L73:
        if (r34 == null) goto L77;
        r7 = i.b(r17, r34, r15);
        goto L77
    L75:
        if (r16 == null) goto L77;
        throw new NoWhenBranchMatchedException();
    L22:
        if (r11.a.exists() == true) goto L24;
        r12 = true;
        goto L26
    L5:
        if (r3.I0() != true) goto L7;
        r6 = true;
        goto L8
    }

    public static ResolveInfo d(Context r5, List r6, PreferredApp r7) {
        Object r1 = null;
        if (ObricFeatureServiceDelegate.b.a() == true) goto L5;
    L16:
        int r8 = b.a[r7.ordinal()];
        if (r8 != 1) goto L19;
        String r9 = "android.intent.category.APP_BROWSER";
    L24:
        Intent r10 = Intent.makeMainSelectorActivity("android.intent.action.MAIN", r9);
        ResolveInfo r0 = r5.getPackageManager().resolveActivity(r10, 0);
        if (r0 == null) goto L29;
        ActivityInfo r2 = r0.activityInfo;
        if (r2 == null) goto L29;
        String r3 = r2.packageName;
    L30:
        List<ResolveInfo> r11 = r5.getPackageManager().queryIntentActivities(r10, 0);
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<T> r13 = r11.iterator();
    L32:
        if (r13.hasNext() == false) goto L34;
        r12.add(((ResolveInfo) r13.next()).activityInfo.packageName);
        goto L32
    L34:
        List r14 = r6;
        Iterator r15 = r14.iterator();
    L36:
        if (r15.hasNext() == false) goto L40;
        Object r4 = r15.next();
        if (Intrinsics.areEqual(((ResolveInfo) r4).activityInfo.packageName, r3) == false) goto L36;
    L41:
        ResolveInfo r16 = (ResolveInfo) r4;
        if (r16 != null) goto L61;
        Iterator r17 = r14.iterator();
    L45:
        if (r17.hasNext() == false) goto L50;
        Object r18 = r17.next();
        if (r12.contains(((ResolveInfo) r18).activityInfo.packageName) == false) goto L45;
        r1 = r18;
    L50:
        return (ResolveInfo) r1;
    L61:
        return r16;
    L40:
        r4 = null;
    L29:
        r3 = null;
        goto L30
    L19:
        if (r8 != 2) goto L22;
        r9 = "android.intent.category.APP_FILES";
        goto L24
    L22:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r7 != PreferredApp.FILE_MANAGER) goto L16;
        Iterator r19 = r6.iterator();
    L8:
        if (r19.hasNext() == false) goto L12;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((ResolveInfo) r20).activityInfo.packageName, "com.obric.filemanager") == false) goto L8;
    L13:
        ResolveInfo r21 = (ResolveInfo) r20;
        if (r21 == null) goto L16;
        return r21;
    L12:
        r20 = null;
        goto L13
    }

    @Override // com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.b
    public final void c(final Context r4, com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.a r5, vl8.d r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "onStateChanged");
        if (StringsKt.isBlank(r5.e) == false) goto L6;
        FLogger.a.i("LocalFileCardVMDependencyImpl", "playAudio failed, empty local path, fileName=" + r5.c);
        y.c(new d(r4, 2131901103));
        return;
    L6:
        String r0 = r5.e;
        ch8.a.a.getClass();
        ch8.b.b r1 = ch8.a.a(r0);
        if ((r1 instanceof ch8.b.b) == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        FLogger.a.i("LocalFileCardVMDependencyImpl", "playAudio failed, file does not exist, path=" + r5.e + ", fileName=" + r5.c);
        y.c(new c());
        return;
    L15:
        n.a.f(r4, r5.e, r6, new f(this, r4));
        return;
    L9:
        if (r1.a.exists() == true) goto L11;
        r2 = true;
        goto L12
    }
}

package com.obric.aikernel.res.installer;

import android.content.res.AssetManager;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.k;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.runtime.utils.d;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class AssetsScanner implements com.obric.aikernel.res.installer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f4985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4986b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public AssetsScanner(AssetManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "assertMgr");
        Intrinsics.checkNotNullParameter(r11, "assertsRootPath");
        this.f4985a = r10;
        this.f4986b = r11;
    }

    public static final /* synthetic */ AssetManager d(AssetsScanner r10) {
        return r10.f4985a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21, types: [T, java.lang.String] */
    private final boolean e(final PrmContext r14, final String r15, final String r16, final String r17, boolean r18) {
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        ?? r11 = this.f4986b + '/' + r15 + '/' + r16 + '/' + r17;
        r10.element = r11;
        String[] r12 = this.f4985a.list((String) r11);
        boolean r13 = true;
        if (r12 != null) goto L5;
    L11:
        boolean r19 = true;
    L13:
        if (r19 == false) goto L39;
        ?? r20 = this.f4986b + '/' + r15 + '@' + r16 + '@' + r17;
        r10.element = r20;
        String[] r21 = this.f4985a.list((String) r20);
        if (r21 != null) goto L17;
    L23:
        boolean r22 = true;
    L24:
        if (r22 == false) goto L39;
        if (Intrinsics.areEqual(r15, "model") == false) goto L38;
        ?? r23 = this.f4986b + '/' + r16 + '@' + r17;
        r10.element = r23;
        String[] r24 = this.f4985a.list((String) r23);
        if (r24 != null) goto L30;
    L36:
        if (r13 == false) goto L39;
        d.f5417a.c("PResM-AssertsScanner", "installTarget: do not find " + r15 + '@' + r16 + '@' + r17);
        goto L38
    L30:
        if (r24.length != 0) goto L32;
        boolean r25 = true;
    L33:
        if (r25 == true) goto L36;
        r13 = false;
        goto L36
    L32:
        r25 = false;
    L38:
        return false;
    L17:
        if (r21.length != 0) goto L19;
        boolean r26 = true;
    L20:
        if (r26 == true) goto L23;
        r22 = false;
        goto L24
    L19:
        r26 = false;
    L39:
        d.f5417a.c("PResM-AssertsScanner", "installTarget: start install " + r15 + '@' + r16 + '@' + r17);
        AssetManager r27 = this.f4985a;
        StringBuilder r28 = new StringBuilder();
        r28.append((String) r10.element);
        r28.append("/configuration.json");
        InputStream r29 = r27.open(r28.toString());
        com.google.gson.d r30 = new com.google.gson.d();     // Catch: Throwable -> L62
        Intrinsics.checkNotNullExpressionValue(r29, "it");     // Catch: Throwable -> L62
        final k r110 = (k) r30.i(new InputStreamReader(r29, Charsets.UTF_8), k.class);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r29, null);
        final Function2<String, String, Object> r111 = new AssetsScanner$installTarget$copyFiles$1(r15, this, r10, r16);
        int r31 = r15.hashCode();
        if (r31 == (-807062458)) goto L57;
        if (r31 == 107141) goto L53;
        if (r31 == 104069929) goto L49;
    L58:
        return false;
    L49:
        if (r15.equals("model") == false) goto L58;
        final Function0 r32 = new AssetsScanner$installTarget$builder$3(r14, r16, r17, r111, r110);
    L61:
        return PrmContext.install$default(r14, r15, r16, r17, r110, false, r18, new AssetsScanner$installTarget$1(r32), 16, null);
    L53:
        if (r15.equals("lib") == false) goto L58;
        r32 = new AssetsScanner$installTarget$builder$2(r14, r16, r17, r111, r110);
        goto L61
    L57:
        if (r15.equals("package") == false) goto L58;
        r32 = new AssetsScanner$installTarget$builder$1(r14, r16, r17, r110, r111);
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r29, th);
        throw th;
    L5:
        if (r12.length != 0) goto L7;
        boolean r33 = true;
    L8:
        if (r33 == true) goto L11;
        r19 = false;
        goto L13
    L7:
        r33 = false;
        goto L8
    }

    @Override // com.obric.aikernel.res.installer.a
    public void a(PrmContext r24) {
        Intrinsics.checkNotNullParameter(r24, "context");
        String r10 = this.f4986b + "/lib";
        String[] r11 = this.f4985a.list(r10);
        if (r11 == null) goto L25;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L25;
        String r14 = r11[r13];
        String[] r15 = this.f4985a.list(r10 + '/' + r14);
        if (r15 == null) goto L24;
        Intrinsics.checkNotNullExpressionValue(r15, "list(\"$libRoot/$name\")");
        int r16 = r15.length;
        int r17 = 0;
    L9:
        if (r17 >= r16) goto L24;
        String r18 = r15[r17];
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r14, ActivityLifecycle.NAME);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r18, "version");     // Catch: Throwable -> L17
        int r110 = r17;
        int r111 = r16;
        String[] r20 = r15;
        String r112 = r14;
        int r21 = r13;
        int r22 = r12;
        Object r23 = Result.m32constructorimpl(Boolean.valueOf(e(r24, "lib", r14, r18, true)));     // Catch: Throwable -> L15
    L20:
        Throwable r25 = Result.m35exceptionOrNullimpl(r23);
        if (r25 == null) goto L23;
        d.f5417a.f("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r25));
    L23:
        r17 = r110 + 1;
        r14 = r112;
        r16 = r111;
        r15 = r20;
        r13 = r21;
        r12 = r22;
    L15:
        th = th;
    L19:
        Result.Companion r26 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L17:
        th = th;
        r110 = r17;
        r111 = r16;
        r20 = r15;
        r112 = r14;
        r21 = r13;
        r22 = r12;
    L24:
        r13 = r13 + 1;
        r12 = r12;
    L25:
        String r27 = this.f4986b + "/package";
        String[] r113 = this.f4985a.list(r27);
        if (r113 == null) goto L48;
        int r28 = r113.length;
        int r29 = 0;
    L28:
        if (r29 >= r28) goto L48;
        String r30 = r113[r29];
        String[] r31 = this.f4985a.list(r27 + '/' + r30);
        if (r31 == null) goto L47;
        Intrinsics.checkNotNullExpressionValue(r31, "list(\"$packageRoot/$name\")");
        int r32 = r31.length;
        int r33 = 0;
    L32:
        if (r33 >= r32) goto L47;
        String r34 = r31[r33];
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r30, ActivityLifecycle.NAME);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r34, "version");     // Catch: Throwable -> L40
        int r115 = r33;
        int r116 = r32;
        String[] r210 = r31;
        String r117 = r30;
        int r211 = r29;
        int r212 = r28;
        Object r35 = Result.m32constructorimpl(Boolean.valueOf(e(r24, "package", r30, r34, true)));     // Catch: Throwable -> L38
    L43:
        Throwable r36 = Result.m35exceptionOrNullimpl(r35);
        if (r36 == null) goto L46;
        d.f5417a.f("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r36));
    L46:
        r33 = r115 + 1;
        r30 = r117;
        r32 = r116;
        r31 = r210;
        r29 = r211;
        r28 = r212;
    L38:
        th = th;
    L42:
        Result.Companion r37 = Result.Companion;
        r35 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L40:
        th = th;
        r115 = r33;
        r116 = r32;
        r210 = r31;
        r117 = r30;
        r211 = r29;
        r212 = r28;
    L47:
        r29 = r29 + 1;
        r28 = r28;
    L48:
        String[] r38 = this.f4985a.list(this.f4986b);
        if (r38 == null) goto L77;
        ArrayList r39 = new ArrayList();
        int r40 = r38.length;
        int r41 = 0;
    L52:
        if (r41 >= r40) goto L57;
        String r42 = r38[r41];
        Intrinsics.checkNotNullExpressionValue(r42, "it");
        if (StringsKt.contains$default(r42, "@", false, 2, null) == false) goto L56;
        r39.add(r42);
    L56:
        r41 = r41 + 1;
        goto L52
    L57:
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator r44 = r39.iterator();
    L59:
        if (r44.hasNext() == false) goto L61;
        String r45 = (String) r44.next();
        Intrinsics.checkNotNullExpressionValue(r45, "it");
        r43.add(StringsKt.split$default(r45, new char[]{'@'}, false, 0, 6, null));
        goto L59
    L61:
        Iterator r118 = r43.iterator();
    L63:
        if (r118.hasNext() == false) goto L110;
        List r46 = (List) r118.next();
        if (r46.size() == 2) goto L66;
        if (r46.size() != 3) goto L63;
        String r47 = (String) r46.get(0);
        String r48 = (String) r46.get(1);
        String r49 = (String) r46.get(2);
        String r50 = r47;
        String r51 = r48;
    L78:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L72
        Object r53 = Result.m32constructorimpl(Boolean.valueOf(e(r24, r50, r51, r49, true)));     // Catch: Throwable -> L72
    L74:
        Throwable r54 = Result.m35exceptionOrNullimpl(r53);
        if (r54 == null) goto L63;
        d.f5417a.f("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r54));
    L72:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r53 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L74
    L66:
        String r56 = (String) r46.get(0);
        r49 = (String) r46.get(1);
        r51 = r56;
        r50 = "model";
        goto L78
    L110:
        return;
    }

    @Override // com.obric.aikernel.res.installer.a
    public List<com.obric.aikernel.res.installer.a.b> b(PrmContext r10) {
        return com.obric.aikernel.res.installer.a.C0113a.c(this, r10);
    }

    @Override // com.obric.aikernel.res.installer.a
    public boolean c(PrmContext r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "version");
        return e(r10, r11, r12, r13, false);
    }

    @Override // com.obric.aikernel.res.installer.a
    public String tag() {
        return "PResM-AssertsScanner";
    }
}

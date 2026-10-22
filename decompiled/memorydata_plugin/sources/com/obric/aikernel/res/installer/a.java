package com.obric.aikernel.res.installer;

import android.content.res.AssetManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J0\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/installer/AssetsScanner;", "Lcom/obric/aikernel/res/installer/IInstaller;", "assertMgr", "Landroid/content/res/AssetManager;", "assertsRootPath", "", "(Landroid/content/res/AssetManager;Ljava/lang/String;)V", "install", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "type", ActivityLifecycle.NAME, "version", "installAll", "", "installTarget", "fastCheck", LocationMonitorConst.TAG, "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0258a f6043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f6044b;
    private final String c;

    /* JADX INFO: renamed from: com.obric.aikernel.res.installer.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/installer/AssetsScanner$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0258a {
        private C0258a() {
        }

        public /* synthetic */ C0258a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6043a = new C0258a(null);
    }

    public a(AssetManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "assertMgr");
        Intrinsics.checkNotNullParameter(r3, "assertsRootPath");
        this.f6044b = r2;
        this.c = r3;
    }

    public static final /* synthetic */ AssetManager a(a r0) {
        return r0.f6044b;
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v46, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.lang.String] */
    private final boolean a(final PrmContext r16, final String r17, final String r18, final String r19, boolean r20) {
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = this.c + '/' + r17 + '/' + r18 + '/' + r19;
        String[] r3 = this.f6044b.list((String) ZeusTransformUtils.preCheckCast(r2.element, String.class, "com.obric.memorydata.plugin"));
        boolean r5 = true;
        if (r3 != null) goto L5;
    L11:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L39;
        r2.element = this.c + '/' + r17 + '@' + r18 + '@' + r19;
        String[] r6 = this.f6044b.list((String) ZeusTransformUtils.preCheckCast(r2.element, String.class, "com.obric.memorydata.plugin"));
        if (r6 != null) goto L17;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L39;
        if (Intrinsics.areEqual(r17, "model") == false) goto L38;
        r2.element = this.c + '/' + r18 + '@' + r19;
        String[] r8 = this.f6044b.list((String) ZeusTransformUtils.preCheckCast(r2.element, String.class, "com.obric.memorydata.plugin"));
        if (r8 != null) goto L30;
    L36:
        if (r5 == false) goto L39;
        com.obric.aikernel.runtime.utils.d.f6216a.d("PResM-AssertsScanner", "installTarget: do not find " + r17 + '@' + r18 + '@' + r19);
        goto L38
    L30:
        if (r8.length != 0) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == true) goto L36;
        r5 = false;
        goto L36
    L32:
        r9 = false;
    L38:
        return false;
    L17:
        if (r6.length != 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == true) goto L23;
        r7 = false;
        goto L24
    L19:
        r10 = false;
    L39:
        com.obric.aikernel.runtime.utils.d.f6216a.e("PResM-AssertsScanner", "installTarget: start install " + r17 + '@' + r18 + '@' + r19);
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(this.f6044b.open(((String) ZeusTransformUtils.preCheckCast(r2.element, String.class, "com.obric.memorydata.plugin")) + "/configuration.json"), Closeable.class, "com.obric.memorydata.plugin");
        InputStream r12 = (InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        Gson r13 = new Gson();     // Catch: Throwable -> L62
        Intrinsics.checkNotNullExpressionValue(r12, "it");     // Catch: Throwable -> L62
        final JsonObject r14 = (JsonObject) ZeusTransformUtils.preCheckCast(r13.fromJson((Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r12, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin"), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r11, null);
        final Function2 r0 = (Function2) ZeusTransformUtils.preCheckCast(new AssetsScanner$installTarget$copyFiles$1(r17, this, r2, r18), Function2.class, "com.obric.memorydata.plugin");
        int r15 = r17.hashCode();
        if (r15 == (-807062458)) goto L57;
        if (r15 == 107141) goto L53;
        if (r15 == 104069929) goto L49;
    L58:
        return false;
    L49:
        if (r17.equals("model") == false) goto L58;
        Object r110 = new AssetsScanner$installTarget$builder$3(r16, r18, r19, r0, r14);
    L60:
        final Function0 r1 = (Function0) ZeusTransformUtils.preCheckCast(r110, Function0.class, "com.obric.memorydata.plugin");
        return PrmContext.install$default(r16, r17, r18, r19, r14, false, r20, (Function1) ZeusTransformUtils.preCheckCast(new AssetsScanner$installTarget$1(r1), Function1.class, "com.obric.memorydata.plugin"), 16, null);
    L53:
        if (r17.equals("lib") == false) goto L58;
        r110 = new AssetsScanner$installTarget$builder$2(r16, r18, r19, r0, r14);
        goto L60
    L57:
        if (r17.equals("package") == false) goto L58;
        r110 = new AssetsScanner$installTarget$builder$1(r16, r18, r19, r14, r0);
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L5:
        if (r3.length != 0) goto L7;
        boolean r21 = true;
    L8:
        if (r21 == true) goto L11;
        r4 = false;
        goto L13
    L7:
        r21 = false;
        goto L8
    }

    @Override // com.obric.aikernel.res.installer.d
    public String a() {
        return "PResM-AssertsScanner";
    }

    @Override // com.obric.aikernel.res.installer.d
    public void a(PrmContext r24) {
        Intrinsics.checkNotNullParameter(r24, "context");
        String r10 = this.c + "/lib";
        String[] r11 = this.f6044b.list(r10);
        char r14 = '/';
        int r6 = 0;
        if (r11 == null) goto L25;
        int r5 = r11.length;
        int r4 = 0;
    L5:
        if (r4 >= r5) goto L25;
        String r3 = r11[r4];
        String[] r2 = this.f6044b.list(r10 + r14 + r3);
        if (r2 == null) goto L24;
        Intrinsics.checkNotNullExpressionValue(r2, "list(\"$libRoot/$name\")");
        int r1 = r2.length;
        int r15 = r6;
    L9:
        if (r15 >= r1) goto L24;
        String r0 = r2[r15];
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r3, ActivityLifecycle.NAME);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r0, "version");     // Catch: Throwable -> L17
        int r18 = r1;
        String[] r19 = r2;
        String r20 = r3;
        int r17 = r4;
        int r21 = r5;
        int r9 = r6;
        Object r7 = Result.m1421constructorimpl(Boolean.valueOf(a(r24, "lib", r20, r0, true)));     // Catch: Throwable -> L15
    L20:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r8));
    L23:
        r15 = r15 + 1;
        r6 = r9;
        r4 = r17;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r5 = r21;
    L15:
        th = th;
    L19:
        Result.Companion r12 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        th = th;
        r18 = r1;
        r19 = r2;
        r20 = r3;
        r17 = r4;
        r21 = r5;
        r9 = r6;
    L24:
        r4 = r4 + 1;
        r6 = r6;
        r5 = r5;
        r14 = '/';
    L25:
        int r13 = r6;
        String r110 = this.c + "/package";
        String[] r111 = this.f6044b.list(r110);
        if (r111 == null) goto L48;
        int r22 = r111.length;
        int r23 = r13;
    L28:
        if (r23 >= r22) goto L48;
        String r25 = r111[r23];
        char r26 = '/';
        String[] r27 = this.f6044b.list(r110 + '/' + r25);
        if (r27 == null) goto L47;
        Intrinsics.checkNotNullExpressionValue(r27, "list(\"$packageRoot/$name\")");
        int r28 = r27.length;
    L32:
        if (r13 >= r28) goto L47;
        String r29 = r27[r13];
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L40
        a r113 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r25, ActivityLifecycle.NAME);     // Catch: Throwable -> L40
        Intrinsics.checkNotNullExpressionValue(r29, "version");     // Catch: Throwable -> L40
        int r114 = r28;
        String[] r115 = r27;
        char r210 = r26;
        String r116 = r25;
        int r211 = r23;
        int r212 = r22;
        Object r30 = Result.m1421constructorimpl(Boolean.valueOf(r113.a(r24, "package", r25, r29, true)));     // Catch: Throwable -> L38
    L43:
        Throwable r31 = Result.m1424exceptionOrNullimpl(r30);
        if (r31 == null) goto L46;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r31));
    L46:
        r13 = r13 + 1;
        r27 = r115;
        r25 = r116;
        r28 = r114;
        r26 = r210;
        r23 = r211;
        r22 = r212;
    L38:
        th = th;
    L42:
        Result.Companion r32 = Result.Companion;
        r30 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L40:
        th = th;
        r114 = r28;
        r115 = r27;
        r210 = r26;
        r116 = r25;
        r211 = r23;
        r212 = r22;
    L47:
        r23 = r23 + 1;
        r22 = r22;
        r13 = 0;
    L48:
        String[] r33 = this.f6044b.list(this.c);
        if (r33 == null) goto L77;
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r35 = r33.length;
        int r36 = 0;
    L52:
        if (r36 >= r35) goto L57;
        String r37 = r33[r36];
        Intrinsics.checkNotNullExpressionValue(r37, "it");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r37, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("@", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L56;
        r34.add(r37);
    L56:
        r36 = r36 + 1;
        goto L52
    L57:
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r38.iterator();
    L59:
        if (r40.hasNext() == false) goto L61;
        String r41 = (String) ZeusTransformUtils.preCheckCast(r40.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r41, "it");
        r39.add(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r41, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'@'}, false, 0, 6, null));
        goto L59
    L61:
        Iterator r117 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L63:
        if (r117.hasNext() == false) goto L110;
        List r42 = (List) ZeusTransformUtils.preCheckCast(r117.next(), List.class, "com.obric.memorydata.plugin");
        if (r42.size() == 2) goto L66;
        if (r42.size() != 3) goto L63;
        String r43 = (String) ZeusTransformUtils.preCheckCast(r42.get(0), String.class, "com.obric.memorydata.plugin");
        String r44 = (String) ZeusTransformUtils.preCheckCast(r42.get(1), String.class, "com.obric.memorydata.plugin");
        String r45 = (String) ZeusTransformUtils.preCheckCast(r42.get(2), String.class, "com.obric.memorydata.plugin");
        String r46 = r43;
        String r47 = r44;
    L80:
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L72
        Object r49 = Result.m1421constructorimpl(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).a(r24, r46, r47, r45, true)));     // Catch: Throwable -> L72
    L74:
        Throwable r50 = Result.m1424exceptionOrNullimpl(r49);
        if (r50 == null) goto L63;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PResM-AssertsScanner", ExceptionsKt.stackTraceToString(r50));
    L72:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r49 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L74
    L66:
        String r52 = (String) ZeusTransformUtils.preCheckCast(r42.get(0), String.class, "com.obric.memorydata.plugin");
        r45 = (String) ZeusTransformUtils.preCheckCast(r42.get(1), String.class, "com.obric.memorydata.plugin");
        r47 = r52;
        r46 = "model";
        goto L80
    L110:
        return;
    }

    @Override // com.obric.aikernel.res.installer.d
    public boolean a(PrmContext r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        return a(r8, r9, r10, r11, false);
    }

    @Override // com.obric.aikernel.res.installer.d
    public List<Object> b(PrmContext r1) {
        return d.a.b(this, r1);
    }
}

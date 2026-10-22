package com.obric.aiproactive.ui.artifact;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.FileProvider;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.api.AiProactiveArtifactResourceKind;
import com.obric.aiproactive.api.AiProactiveArtifactState;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.j;
import com.obric.aiproactive.api.m;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\fJ(\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0019J\"\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0011H\u0000¢\u0006\u0002\b J\u0012\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0016\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010%J \u0010'\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010*R\u000e\u0010+\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/ArtifactOpenRouter;", "", "<init>", "()V", "open", "", "context", "Landroid/content/Context;", "artifact", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "(Landroid/content/Context;Lcom/obric/aiproactive/api/AiProactiveArtifact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routesToDocumentPreview", "routesToDocumentPreview$ai_proactive_ui_obricRelease", "openExternal", "uri", "Landroid/net/Uri;", "mimeType", "", "openExternal$ai_proactive_ui_obricRelease", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareOriginal", "displayName", "shareOriginal$ai_proactive_ui_obricRelease", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveOpenUri", "resolveOpenUri$ai_proactive_ui_obricRelease", "resolveExportedFile", "locator", "resolveOwnedContentUri", "isOwnedContentUri", "isOwnedContentUri$ai_proactive_ui_obricRelease", "isOwnedContentLocator", "isOwnedContentLocator$ai_proactive_ui_obricRelease", "isOwnedAuthority", "authority", "resolveProviderAuthority", "showFailure", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showShareFailure", "loadString", "stringRes", "", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "EXPORT_SHARE_DIR", "CONTENT_SCHEME_PREFIX", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6545a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6546a = null;

        static {
            int[] r0 = new int[AiProactiveArtifactResourceKind.values().length];
            r0[AiProactiveArtifactResourceKind.EXPORTED_FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AiProactiveArtifactResourceKind.CONTENT_URI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AiProactiveArtifactResourceKind.HTTPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AiProactiveArtifactResourceKind.OBJECT_KEY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6546a = r0;
        }
    }

    static {
        f6545a = new b();
    }

    private b() {
    }

    private final Uri a(Context r6, String r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        File r0 = new File(r9.getFilesDir(), "export_share");
        File r1 = new File(r0, r7);
        String r2 = r0.getCanonicalPath() + File.separator;     // Catch: IOException -> L16
        String r3 = r1.getCanonicalPath();     // Catch: IOException -> L16
        Intrinsics.checkNotNull(r3);     // Catch: IOException -> L16
        boolean r4 = false;
        if (StringsKt.startsWith$default(r3, r2, false, 2, null) == false) goto L8;
        if (r1.isFile() == false) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L10;
    L11:
        if (r1 != null) goto L17;
        return null;
    L17:
        return FileProvider.getUriForFile(r9, a(r9), r1, r8);
    L21:
        return null;
    L10:
        r1 = null;
        goto L11
    }

    private final Object a(Context r6, int r7, Continuation<? super String> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ArtifactOpenRouter$loadString$1.class) == false) goto L7;
        ArtifactOpenRouter$loadString$1 r0 = (ArtifactOpenRouter$loadString$1) ZeusTransformUtils.preCheckCast(r10, ArtifactOpenRouter$loadString$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r5);
    L17:
        Intrinsics.checkNotNullExpressionValue(r5, "withContext(...)");
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new ArtifactOpenRouter$loadString$2(r9, r7, null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r5 = i.a(r12, r13, r0);
        if (r5 != r11) goto L17;
        return r11;
    L7:
        r0 = new ArtifactOpenRouter$loadString$1(this, r10);
        goto L8
    }

    private final Object a(Context r10, Continuation<? super Boolean> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ArtifactOpenRouter$showFailure$1.class) == false) goto L7;
        ArtifactOpenRouter$showFailure$1 r0 = (ArtifactOpenRouter$showFailure$1) ZeusTransformUtils.preCheckCast(r13, ArtifactOpenRouter$showFailure$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r9 = (com.obric.oui.toast.a.C0786a) ZeusTransformUtils.preCheckCast(r0.L$0, com.obric.oui.toast.a.C0786a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
        com.obric.oui.toast.a.C0786a r4 = r9;
        Context r5 = r15;
    L18:
        com.obric.oui.toast.a.C0786a.a(r4, r5, (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"), 0, 4, null);
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.obric.oui.toast.a.C0786a r16 = com.obric.oui.toast.a.f14807a;
        int r6 = ZeusTransformUtils.mapRes(R.string.proactive_artifact_open_failed, TypedValues.Custom.S_STRING, "proactive_artifact_open_failed");
        r0.L$0 = r16;
        r0.L$1 = r12;
        r0.label = 1;
        Object r17 = a(r12, r6, r0);
        if (r17 != r2) goto L17;
        return r2;
    L17:
        r5 = r12;
        r4 = r16;
        r14 = r17;
    L7:
        r0 = new ArtifactOpenRouter$showFailure$1(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object a(b r2, Context r3, int r4, Continuation r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(b r2, Context r3, Continuation r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final String a(Context r2) {
        if (Intrinsics.areEqual(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageName(), "com.larus.nova") == false) goto L5;
        return "com.larus.nova.zeus.memorydata.fileprovider";
    L5:
        return "com.obric.memorydata.fileprovider";
    }

    private final Uri b(String r1) {
        Uri r2 = Uri.parse(r1);
        if (a(r2) == true) goto L7;
        return null;
    L7:
        return r2;
    }

    private final Object b(Context r10, Continuation<? super Boolean> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ArtifactOpenRouter$showShareFailure$1.class) == false) goto L7;
        ArtifactOpenRouter$showShareFailure$1 r0 = (ArtifactOpenRouter$showShareFailure$1) ZeusTransformUtils.preCheckCast(r13, ArtifactOpenRouter$showShareFailure$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r9 = (com.obric.oui.toast.a.C0786a) ZeusTransformUtils.preCheckCast(r0.L$0, com.obric.oui.toast.a.C0786a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
        com.obric.oui.toast.a.C0786a r4 = r9;
        Context r5 = r15;
    L18:
        com.obric.oui.toast.a.C0786a.a(r4, r5, (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin"), 0, 4, null);
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.obric.oui.toast.a.C0786a r16 = com.obric.oui.toast.a.f14807a;
        int r6 = ZeusTransformUtils.mapRes(R.string.proactive_document_share_failed, TypedValues.Custom.S_STRING, "proactive_document_share_failed");
        r0.L$0 = r16;
        r0.L$1 = r12;
        r0.label = 1;
        Object r17 = a(r12, r6, r0);
        if (r17 != r2) goto L17;
        return r2;
    L17:
        r5 = r12;
        r4 = r16;
        r14 = r17;
    L7:
        r0 = new ArtifactOpenRouter$showShareFailure$1(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object b(b r2, Context r3, Continuation r4) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final boolean c(String r1) {
        if (Intrinsics.areEqual(r1, "com.larus.nova.zeus.memorydata.fileprovider") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "com.obric.memorydata.fileprovider") == true) goto L8;
        return false;
    }

    public final Uri a(Context r8, j r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r9, "artifact");
        m r0 = r9.f();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r3 = a.f6546a[r0.a().ordinal()];
        boolean r5 = false;
        if (r3 == 1) goto L30;
        if (r3 == 2) goto L42;
        if (r3 != 3) goto L11;
        Uri r7 = Uri.parse(r0.b());
        if (StringsKt.equals(r7.getScheme(), LocationInfoConst.HTTPS, true) == false) goto L26;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.getHost(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == true) goto L26;
        r5 = true;
        goto L26
    L20:
        if (StringsKt.isBlank(r11) == true) goto L23;
        r12 = false;
    L26:
        if (r5 == true) goto L41;
        return null;
    L41:
        return r7;
    L11:
        if (r3 != 4) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L42:
        return b(r0.b());
    L30:
        if (StringsKt.startsWith$default(r0.b(), "managed/", false, 2, null) == false) goto L37;
        IProactiveService r1 = (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L36;
        String r2 = r1.prepareArtifactOpenLocator(r9);
        if (r2 == null) goto L36;
    L39:
        return a(r10, r2, r9.d());
    L36:
        return null;
    L37:
        r2 = r0.b();
        goto L39
    }

    public final Object a(Context r11, Uri r12, String r13, String r14, Continuation<? super Boolean> r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, ArtifactOpenRouter$shareOriginal$1.class) == false) goto L7;
        ArtifactOpenRouter$shareOriginal$1 r0 = (ArtifactOpenRouter$shareOriginal$1) ZeusTransformUtils.preCheckCast(r17, ArtifactOpenRouter$shareOriginal$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r8 = true;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 == 5) goto L18;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r18);
    L51:
        r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r18, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L53:
        return Boxing.boxBoolean(r8);
    L19:
        Intent r10 = (Intent) ZeusTransformUtils.preCheckCast(r0.L$2, Intent.class, "com.obric.memorydata.plugin");
        r16 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        b r19 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L39:
        Intent r110 = Intent.createChooser(r10, (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r16, Activity.class) == true) goto L58;
        r110.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
    L58:
        ZeusTransformUtils.startActivity(r16, r110, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L45 ActivityNotFoundException -> L48
    L48:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 4;
        r18 = r19.b(r16, r0);
        if (r18 != r2) goto L51;
        return r2;
    L45:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 5;
        r18 = r19.b(r16, r0);
        if (r18 != r2) goto L51;
        return r2;
    L20:
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r112 = (com.obric.oui.toast.a.C0786a) ZeusTransformUtils.preCheckCast(r0.L$0, com.obric.oui.toast.a.C0786a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        com.obric.oui.toast.a.C0786a r4 = r112;
        Context r5 = r111;
    L33:
        com.obric.oui.toast.a.C0786a.a(r4, r5, (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin"), 0, 4, null);
        return Boxing.boxBoolean(false);
    L21:
        ResultKt.throwOnFailure(r18);
    L57:
        return r18;
    L22:
        ResultKt.throwOnFailure(r18);
        if (a(r12) == true) goto L25;
    L54:
        r0.label = 1;
        r18 = b(r16, r0);
        if (r18 != r2) goto L57;
        return r2;
    L25:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L54;
        Intent r113 = new Intent("android.intent.action.SEND");
        r113.setType(r14);
        r113.putExtra("android.intent.extra.STREAM", (Parcelable) ZeusTransformUtils.preCheckCast(r12, Parcelable.class, "com.obric.memorydata.plugin"));
        r113.addFlags(1);
        r113.setClipData(ClipData.newUri(r16.getContentResolver(), (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), r12));
        if (r113.resolveActivity(r16.getPackageManager()) != null) goto L35;
        com.obric.oui.toast.a.C0786a r114 = com.obric.oui.toast.a.f14807a;
        int r115 = ZeusTransformUtils.mapRes(R.string.proactive_document_share_no_handler, TypedValues.Custom.S_STRING, "proactive_document_share_no_handler");
        r0.L$0 = r114;
        r0.L$1 = r16;
        r0.label = 2;
        r18 = a(r16, r115, r0);
        if (r18 != r2) goto L32;
        return r2;
    L32:
        r5 = r16;
        r4 = r114;
        goto L33
    L35:
        int r116 = ZeusTransformUtils.mapRes(R.string.proactive_document_share_chooser, TypedValues.Custom.S_STRING, "proactive_document_share_chooser");
        r0.L$0 = this;
        r0.L$1 = r16;
        r0.L$2 = r113;
        r0.label = 3;
        Object r117 = a(r16, r116, r0);
        if (r117 != r2) goto L38;
        return r2;
    L38:
        r19 = this;
        r10 = r113;
        r18 = r117;
    L7:
        r0 = new ArtifactOpenRouter$shareOriginal$1(this, r17);
        goto L8
    }

    public final Object a(Context r11, Uri r12, String r13, Continuation<? super Boolean> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, ArtifactOpenRouter$openExternal$1.class) == false) goto L7;
        ArtifactOpenRouter$openExternal$1 r0 = (ArtifactOpenRouter$openExternal$1) ZeusTransformUtils.preCheckCast(r16, ArtifactOpenRouter$openExternal$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r8 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r17);
    L50:
        r8 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L52:
        return Boxing.boxBoolean(r8);
    L18:
        Intent r10 = (Intent) ZeusTransformUtils.preCheckCast(r0.L$2, Intent.class, "com.obric.memorydata.plugin");
        r15 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        b r18 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L34:
        Intent r19 = Intent.createChooser(r10, (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"));
        r19.addFlags(1);
        if (ZeusTransformUtils.instanceOf(r15, Activity.class) == true) goto L37;
        r19.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
    L37:
        b this = r18;
    L53:
        ZeusTransformUtils.startActivity(r15, r19, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L44 ActivityNotFoundException -> L47
    L47:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        r17 = this.a(r15, r0);
        if (r17 != r2) goto L50;
        return r2;
    L44:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 4;
        r17 = this.a(r15, r0);
        if (r17 != r2) goto L50;
        return r2;
    L19:
        Context r110 = (Context) ZeusTransformUtils.preCheckCast(r0.L$1, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r111 = (com.obric.oui.toast.a.C0786a) ZeusTransformUtils.preCheckCast(r0.L$0, com.obric.oui.toast.a.C0786a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
        com.obric.oui.toast.a.C0786a r4 = r111;
        Context r5 = r110;
    L26:
        com.obric.oui.toast.a.C0786a.a(r4, r5, (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin"), 0, 4, null);
        return Boxing.boxBoolean(false);
    L20:
        ResultKt.throwOnFailure(r17);
        r19 = new Intent("android.intent.action.VIEW");
        r19.setDataAndType(r12, r13);
        r19.addFlags(1);
        if (r19.resolveActivity(r15.getPackageManager()) != null) goto L29;
        com.obric.oui.toast.a.C0786a r112 = com.obric.oui.toast.a.f14807a;
        int r113 = ZeusTransformUtils.mapRes(R.string.proactive_artifact_no_handler, TypedValues.Custom.S_STRING, "proactive_artifact_no_handler");
        r0.L$0 = r112;
        r0.L$1 = r15;
        r0.label = 1;
        r17 = a(r15, r113, r0);
        if (r17 != r2) goto L25;
        return r2;
    L25:
        r5 = r15;
        r4 = r112;
        goto L26
    L29:
        if (StringsKt.equals(r12.getScheme(), Params.CONTENT, true) == false) goto L39;
        int r114 = ZeusTransformUtils.mapRes(R.string.proactive_artifact_open_chooser, TypedValues.Custom.S_STRING, "proactive_artifact_open_chooser");
        r0.L$0 = this;
        r0.L$1 = r15;
        r0.L$2 = r19;
        r0.label = 2;
        Object r115 = a(r15, r114, r0);
        if (r115 != r2) goto L33;
        return r2;
    L33:
        r18 = this;
        r10 = r19;
        r17 = r115;
        goto L34
    L39:
        if (ZeusTransformUtils.instanceOf(r15, Activity.class) == true) goto L53;
        r19.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
    L7:
        r0 = new ArtifactOpenRouter$openExternal$1(this, r16);
        goto L8
    }

    public final Object a(Context r18, j r19, Continuation<? super Boolean> r20) {
        b r0 = this;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ArtifactOpenRouter$open$1.class) == false) goto L7;
        ArtifactOpenRouter$open$1 r6 = (ArtifactOpenRouter$open$1) ZeusTransformUtils.preCheckCast(r5, ArtifactOpenRouter$open$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r9 = true;
        switch(r6.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r7);
    L54:
        return r7;
    L13:
        ResultKt.throwOnFailure(r7);
    L48:
        r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L50:
        return Boxing.boxBoolean(r9);
    L14:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(r6.L$1, Context.class, "com.obric.memorydata.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(r6.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: SecurityException -> L55 ActivityNotFoundException -> L56
    L45:
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 4;
        r7 = r2.a(r1, r6);
        if (r7 != r8) goto L48;
        return r8;
    L41:
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 5;
        r7 = r2.a(r1, r6);
        if (r7 != r8) goto L48;
        return r8;
    L17:
        ResultKt.throwOnFailure(r7);
    L32:
        return r7;
    L18:
        j r4 = (j) ZeusTransformUtils.preCheckCast(r6.L$2, j.class, "com.obric.memorydata.plugin");
        r3 = (Context) ZeusTransformUtils.preCheckCast(r6.L$1, Context.class, "com.obric.memorydata.plugin");
        b r10 = (b) ZeusTransformUtils.preCheckCast(r6.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        j r14 = r4;
        r0 = r10;
    L27:
        Uri r13 = (Uri) ZeusTransformUtils.preCheckCast(r7, Uri.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L33;
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 2;
        r7 = r0.a(r3, r6);
        if (r7 != r8) goto L32;
        return r8;
    L33:
        DocumentPreviewKind r15 = e.a(r14.e(), r14.d());
        if (r15 != null) goto L36;
    L51:
        String r11 = r14.e();
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 6;
        r7 = r0.a(r3, r13, r11, r6);
        if (r7 != r8) goto L54;
        return r8;
    L36:
        if (r0.a(r13) == false) goto L51;
        CoroutineContext r12 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new ArtifactOpenRouter$open$2(r3, r13, r14, r15, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        r6.L$0 = r0;     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        r6.L$1 = r3;     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        r6.L$2 = null;     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        r6.label = 3;     // Catch: SecurityException -> L40 ActivityNotFoundException -> L44
        if (i.a(r12, r16, r6) != r8) goto L50;
        return r8;
    L44:
        r2 = r0;
        r1 = r3;
    L40:
        r2 = r0;
        r1 = r3;
        goto L41
    L19:
        ResultKt.throwOnFailure(r7);
        if (r19.c() != AiProactiveArtifactState.READY) goto L22;
        CoroutineContext r17 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r21 = (Function2) ZeusTransformUtils.preCheckCast(new ArtifactOpenRouter$open$uri$1(r3, r19, null), Function2.class, "com.obric.memorydata.plugin");
        r6.L$0 = r0;
        r6.L$1 = r3;
        r6.L$2 = r19;
        r6.label = 1;
        r7 = i.a(r17, r21, r6);
        if (r7 != r8) goto L26;
        return r8;
    L26:
        r14 = r19;
        goto L27
    L22:
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r6 = new ArtifactOpenRouter$open$1(r0, r5);
        goto L8
    }

    public final boolean a(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        if (StringsKt.equals(r4.getScheme(), Params.CONTENT, true) == true) goto L7;
        return false;
    L7:
        return c(r4.getAuthority());
    }

    public final boolean a(j r4) {
        Intrinsics.checkNotNullParameter(r4, "artifact");
        if (r4.c() == AiProactiveArtifactState.READY) goto L6;
        return false;
    L6:
        if (e.a(r4.e(), r4.d()) != null) goto L8;
        return false;
    L8:
        m r5 = r4.f();
        if (r5 != null) goto L11;
        return false;
    L11:
        AiProactiveArtifactResourceKind r0 = r5.a();
        int r1 = a.f6546a[r0.ordinal()];
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L26;
        if (r1 != 3) goto L18;
        return false;
    L18:
        if (r1 != 4) goto L21;
        return false;
    L21:
        throw new NoWhenBranchMatchedException();
    L26:
        return a(r5.b());
    L24:
        return true;
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "locator");
        if (StringsKt.startsWith(r4, "content://", true) == true) goto L6;
        return false;
    L6:
        String r5 = r4.substring(10);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        return c(StringsKt.substringBefore$default(r5, '/', null, 2, null));
    }
}

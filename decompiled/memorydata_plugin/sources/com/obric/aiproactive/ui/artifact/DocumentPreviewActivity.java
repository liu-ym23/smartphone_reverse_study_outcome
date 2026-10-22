package com.obric.aiproactive.ui.artifact;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.crash.constants.Constants;
import com.bytedance.rpc.internal.RpcUtils;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aiproactive.ui.databinding.ActivityDocumentPreviewBinding;
import com.obric.aiproactive.ui.entry.BaseProactiveActivity;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.aiproactive.ui.util.j;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.h;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\tH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020\u000fH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivityDocumentPreviewBinding;", "sourceUri", "Landroid/net/Uri;", "sourceMimeType", "", "sourceDisplayName", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "configureWindow", "loadDocument", "uri", "previewKind", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewKind;", "readDocument", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult;", "showMarkdown", Params.CONTENT, "showHtml", "configureRestrictedWebView", "webView", "Landroid/webkit/WebView;", "documentUriExtra", "openSafeWebLink", "rawUrl", "blockedResource", "Landroid/webkit/WebResourceResponse;", "showError", "messageRes", "", "openInOtherApp", "shareOriginalDocument", "finish", "onDestroy", "Companion", "DocumentLoadResult", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DocumentPreviewActivity extends BaseProactiveActivity {
    public static final a Companion = null;
    private static final String EXTRA_DISPLAY_NAME = "artifact_document_display_name";
    private static final String EXTRA_MIME_TYPE = "artifact_document_mime_type";
    private static final String EXTRA_URI = "artifact_document_uri";
    private ActivityDocumentPreviewBinding binding;
    private String sourceDisplayName;
    private String sourceMimeType;
    private Uri sourceUri;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$Companion;", "", "<init>", "()V", "EXTRA_URI", "", "EXTRA_DISPLAY_NAME", "EXTRA_MIME_TYPE", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "displayName", "mimeType", "previewKind", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewKind;", "launch$ai_proactive_ui_obricRelease", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r2, Uri r3, String r4, String r5, DocumentPreviewKind r6) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r3, "uri");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            Intrinsics.checkNotNullParameter(r5, "mimeType");
            Intrinsics.checkNotNullParameter(r6, "previewKind");
            if (e.a(r5, r4) != r6) goto L5;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L13;
            Intent r8 = new Intent(r1, DocumentPreviewActivity.class);
            r8.putExtra(DocumentPreviewActivity.EXTRA_URI, (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.memorydata.plugin"));
            r8.putExtra(DocumentPreviewActivity.EXTRA_DISPLAY_NAME, r4);
            r8.putExtra(DocumentPreviewActivity.EXTRA_MIME_TYPE, r5);
            if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L10;
            r8.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L10:
            ZeusTransformUtils.startActivity(r1, r8, "com.obric.memorydata.plugin");
            return;
        L13:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r7 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult;", "", "Ready", "TooLarge", "Failed", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$Failed;", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$Ready;", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$TooLarge;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private interface b {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$Failed;", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f6537a = null;

            static {
                f6537a = new a();
            }

            private a() {
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
                return false;
            L9:
                a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
                return true;
            }

            public int hashCode() {
                return -898220620;
            }

            public String toString() {
                return "Failed";
            }
        }

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$Ready;", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult;", Params.CONTENT, "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0290b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f6538a;

            public C0290b(String r2) {
                Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
                this.f6538a = r2;
            }

            public final String a() {
                return this.f6538a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0290b.class) == true) goto L8;
                return false;
            L8:
                C0290b r6 = (C0290b) ZeusTransformUtils.preCheckCast(r5, C0290b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f6538a, r6.f6538a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f6538a.hashCode();
            }

            public String toString() {
                return "Ready(content=" + this.f6538a + ')';
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult$TooLarge;", "Lcom/obric/aiproactive/ui/artifact/DocumentPreviewActivity$DocumentLoadResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f6539a = null;

            static {
                f6539a = new c();
            }

            private c() {
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
                return false;
            L9:
                c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
                return true;
            }

            public int hashCode() {
                return -1589778946;
            }

            public String toString() {
                return "TooLarge";
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"com/obric/aiproactive/ui/artifact/DocumentPreviewActivity$configureRestrictedWebView$3", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", Ext.KEY_REQUEST, "Landroid/webkit/WebResourceRequest;", "url", "", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DocumentPreviewActivity f6540a;

        c(DocumentPreviewActivity r3) {
            this.f6540a = (DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, DocumentPreviewActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView r2, WebResourceRequest r3) {
            WebResourceRequest r4 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r3, WebResourceRequest.class, "com.obric.memorydata.plugin");
            return DocumentPreviewActivity.access$blockedResource(this.f6540a);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r2, WebResourceRequest r3) {
            WebResourceRequest r4 = (WebResourceRequest) ZeusTransformUtils.wrapperContextForParams(r3, WebResourceRequest.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L11;
            Uri r5 = r4.getUrl();
            if (r5 == null) goto L12;
            String r6 = r5.toString();
            if (r6 == null) goto L13;
            DocumentPreviewActivity.access$openSafeWebLink(this.f6540a, r6);
            return true;
        L13:
            return true;
        L12:
            return true;
        L11:
            return true;
        }

        @Override // android.webkit.WebViewClient
        @Deprecated(message = "Deprecated in Android WebView API")
        public boolean shouldOverrideUrlLoading(WebView r1, String r2) {
            if (r2 == null) goto L6;
            DocumentPreviewActivity.access$openSafeWebLink(this.f6540a, r2);
            return true;
        L6:
            return true;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$loadDocument$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$loadDocument$1", f = "DocumentPreviewActivity.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ DocumentPreviewKind $previewKind;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ DocumentPreviewActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$loadDocument$1$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6541a = null;

            static {
                int[] r0 = new int[DocumentPreviewKind.values().length];
                r0[DocumentPreviewKind.MARKDOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[DocumentPreviewKind.HTML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f6541a = r0;
            }
        }

        AnonymousClass1(DocumentPreviewActivity r3, DocumentPreviewKind r4, Uri r5, Continuation<? super AnonymousClass1> r6) {
            DocumentPreviewActivity r7 = (DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, DocumentPreviewActivity.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r7;
            this.$previewKind = r4;
            this.$uri = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$previewKind, this.$uri, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            b r9 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.memorydata.plugin");
            ActivityDocumentPreviewBinding r2 = DocumentPreviewActivity.access$getBinding$p(this.this$0);
            if (r2 != null) goto L16;
            return Unit.INSTANCE;
        L16:
            if (ZeusTransformUtils.instanceOf(r9, b.C0290b.class) == false) goto L26;
            DocumentPreviewKind r3 = this.$previewKind;
            int r4 = a.f6541a[r3.ordinal()];
            if (r4 != 1) goto L20;
            DocumentPreviewActivity.access$showMarkdown(this.this$0, r2, ((b.C0290b) ZeusTransformUtils.preCheckCast(r9, b.C0290b.class, "com.obric.memorydata.plugin")).a());
        L33:
            return Unit.INSTANCE;
        L20:
            if (r4 != 2) goto L23;
            DocumentPreviewActivity.access$showHtml(this.this$0, r2, ((b.C0290b) ZeusTransformUtils.preCheckCast(r9, b.C0290b.class, "com.obric.memorydata.plugin")).a());
            goto L33
        L23:
            throw new NoWhenBranchMatchedException();
        L26:
            if (Intrinsics.areEqual(r9, b.c.f6539a) == false) goto L30;
            DocumentPreviewActivity r7 = this.this$0;
            int r10 = R.string.proactive_document_preview_too_large;
            String r5 = "proactive_document_preview_too_large";
        L28:
            DocumentPreviewActivity.access$showError(r7, r2, ZeusTransformUtils.mapRes(r10, TypedValues.Custom.S_STRING, r5));
            goto L33
        L30:
            if (Intrinsics.areEqual(r9, b.a.f6537a) == false) goto L35;
            r7 = this.this$0;
            r10 = R.string.proactive_document_preview_failed;
            r5 = "proactive_document_preview_failed";
            goto L28
        L35:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new DocumentPreviewActivity$loadDocument$1$result$1(this.this$0, this.$uri, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = i.a(r11, r6, r12);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$openInOtherApp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$openInOtherApp$1", f = "DocumentPreviewActivity.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
    static final class C10451 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ DocumentPreviewActivity this$0;

        C10451(DocumentPreviewActivity r3, Uri r4, Continuation<? super C10451> r5) {
            DocumentPreviewActivity r6 = (DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, DocumentPreviewActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$uri = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10451(this.this$0, this.$uri, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10451) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10451.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            com.obric.aiproactive.ui.artifact.b r9 = com.obric.aiproactive.ui.artifact.b.f6545a;
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");
            Uri r3 = this.$uri;
            String r5 = DocumentPreviewActivity.access$getSourceMimeType$p(this.this$0);
            Continuation<? super Boolean> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r9.a(r2, r3, r5, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$shareOriginalDocument$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.artifact.DocumentPreviewActivity$shareOriginalDocument$1", f = "DocumentPreviewActivity.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
    static final class C10461 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ DocumentPreviewActivity this$0;

        C10461(DocumentPreviewActivity r3, Uri r4, Continuation<? super C10461> r5) {
            DocumentPreviewActivity r6 = (DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, DocumentPreviewActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$uri = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10461(this.this$0, this.$uri, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10461) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10461.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            com.obric.aiproactive.ui.artifact.b r2 = com.obric.aiproactive.ui.artifact.b.f6545a;
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin");
            Uri r3 = this.$uri;
            String r5 = DocumentPreviewActivity.access$getSourceDisplayName$p(this.this$0);
            String r6 = DocumentPreviewActivity.access$getSourceMimeType$p(this.this$0);
            Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r2.a(r10, r3, r5, r6, r7) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public DocumentPreviewActivity() {
        this.sourceMimeType = "";
        this.sourceDisplayName = "";
    }

    public static final /* synthetic */ WebResourceResponse access$blockedResource(DocumentPreviewActivity r2) {
        return ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).blockedResource();
    }

    public static final /* synthetic */ ActivityDocumentPreviewBinding access$getBinding$p(DocumentPreviewActivity r2) {
        return ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ String access$getSourceDisplayName$p(DocumentPreviewActivity r2) {
        return ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).sourceDisplayName;
    }

    public static final /* synthetic */ String access$getSourceMimeType$p(DocumentPreviewActivity r2) {
        return ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).sourceMimeType;
    }

    public static final /* synthetic */ void access$openSafeWebLink(DocumentPreviewActivity r2, String r3) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).openSafeWebLink(r3);
    }

    public static final /* synthetic */ b access$readDocument(DocumentPreviewActivity r2, Uri r3) {
        return ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).readDocument(r3);
    }

    public static final /* synthetic */ void access$showError(DocumentPreviewActivity r2, ActivityDocumentPreviewBinding r3, int r4) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).showError(r3, r4);
    }

    public static final /* synthetic */ void access$showHtml(DocumentPreviewActivity r2, ActivityDocumentPreviewBinding r3, String r4) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).showHtml(r3, r4);
    }

    public static final /* synthetic */ void access$showMarkdown(DocumentPreviewActivity r2, ActivityDocumentPreviewBinding r3, String r4) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).showMarkdown(r3, r4);
    }

    private final WebResourceResponse blockedResource() {
        return new WebResourceResponse("text/plain", RpcUtils.CHARSET_UTF8, (InputStream) ZeusTransformUtils.preCheckCast(new ByteArrayInputStream(new byte[0]), InputStream.class, "com.obric.memorydata.plugin"));
    }

    private final void configureRestrictedWebView(WebView r5) {
        r5.setBackgroundColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_1")));
        WebSettings r0 = r5.getSettings();
        r0.setJavaScriptEnabled(false);
        r0.setDomStorageEnabled(false);
        r0.setDatabaseEnabled(false);
        r0.setAllowFileAccess(false);
        r0.setAllowContentAccess(false);
        r0.setBlockNetworkLoads(true);
        r0.setBlockNetworkImage(true);
        r0.setMixedContentMode(1);
        r0.setSupportMultipleWindows(false);
        r0.setJavaScriptCanOpenWindowsAutomatically(false);
        r0.setCacheMode(2);
        r0.setBuiltInZoomControls(false);
        r0.setDisplayZoomControls(false);
        r0.setMediaPlaybackRequiresUserGesture(true);
        r0.setGeolocationEnabled(false);
        r5.setDownloadListener(new $$Lambda$DocumentPreviewActivity$JovpfBI5DlP7kLlItIODDmgWS4(this));
        r5.setWebViewClient((WebViewClient) ZeusTransformUtils.preCheckCast(new c(this), WebViewClient.class, "com.obric.memorydata.plugin"));
    }

    private static final void configureRestrictedWebView$lambda$8(DocumentPreviewActivity r6, String r7, String r8, String r9, String r10, long r11) {
        DocumentPreviewActivity r12 = (DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r6, DocumentPreviewActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r0 = com.obric.oui.toast.a.f14807a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.memorydata.plugin");
        String r2 = r12.getString(ZeusTransformUtils.mapRes(R.string.proactive_document_preview_failed, TypedValues.Custom.S_STRING, "proactive_document_preview_failed"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r0, r1, r2, 0, 4, null);
    }

    private final void configureWindow() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Configuration r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r1, "getConfiguration(...)");
        boolean r2 = !r0.b(r1);
        WindowInsetsControllerCompat r3 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r3.setAppearanceLightStatusBars(r2);
        r3.setAppearanceLightNavigationBars(r2);
    }

    private final Uri documentUriExtra() {
        int r0 = Build.VERSION.SDK_INT;
        Intent r4 = getIntent();
        if (r0 < 33) goto L5;
        Object r5 = r4.getParcelableExtra(EXTRA_URI, Uri.class);
    L7:
        return (Uri) ZeusTransformUtils.preCheckCast(r5, Uri.class, "com.obric.memorydata.plugin");
    L5:
        r5 = r4.getParcelableExtra(EXTRA_URI);
        goto L7
    }

    /* JADX INFO: renamed from: lambda$1MwzHCGth36Yujvl1W-a71mTBhk, reason: not valid java name */
    public static /* synthetic */ void m242lambda$1MwzHCGth36Yujvl1Wa71mTBhk(DocumentPreviewActivity r0, View r1) {
        onCreateChecked$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$3vywhzrIfiRdtrXDmfW7OteSRKw(DocumentPreviewActivity r0, View r1) {
        onCreateChecked$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JovpfBI5DlP7-kLlItIODDmgWS4, reason: not valid java name */
    public static /* synthetic */ void m243lambda$JovpfBI5DlP7kLlItIODDmgWS4(DocumentPreviewActivity r0, String r1, String r2, String r3, String r4, long r5) {
        configureRestrictedWebView$lambda$8(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$ixJOsZ6Rmp8W6QwXFRnDgdCQ9CY(DocumentPreviewActivity r0, View r1) {
        onCreateChecked$lambda$3$lambda$1(r0, r1);
    }

    private final void loadDocument(Uri r9, DocumentPreviewKind r10) {
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void onCreateChecked$lambda$3$lambda$1(DocumentPreviewActivity r1, View r2) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    private static final void onCreateChecked$lambda$3$lambda$2(DocumentPreviewActivity r1, View r2) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).shareOriginalDocument();
    }

    private static final void onCreateChecked$lambda$4(DocumentPreviewActivity r1, View r2) {
        ((DocumentPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, DocumentPreviewActivity.class, "com.obric.memorydata.plugin")).openInOtherApp();
    }

    private final void openInOtherApp() {
        Uri r0 = this.sourceUri;
        if (r0 != null) goto L5;
        return;
    L5:
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10451(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void openSafeWebLink(String r14) {
        String r5 = e.a(r14);
        if (r5 != null) goto L5;
        return;
    L5:
        Intent r6 = new Intent("android.intent.action.VIEW", Uri.parse(r5));
        if (r6.resolveActivity(getPackageManager()) != null) goto L13;
        return;
    L13:
        ZeusTransformUtils.startActivity(this, r6, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L10 ActivityNotFoundException -> L11
    L16:
        return;
    L11:
        com.obric.oui.toast.a.C0786a r7 = com.obric.oui.toast.a.f14807a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.proactive_artifact_open_failed, TypedValues.Custom.S_STRING, "proactive_artifact_open_failed"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r7, r4, r2, 0, 4, null);
        return;
    L10:
        com.obric.oui.toast.a.C0786a r8 = com.obric.oui.toast.a.f14807a;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r10 = getString(ZeusTransformUtils.mapRes(R.string.proactive_artifact_open_failed, TypedValues.Custom.S_STRING, "proactive_artifact_open_failed"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r8, r9, r10, 0, 4, null);
    }

    private final b readDocument(Uri r7) {
        ContentProviderClient r6 = getContentResolver().acquireUnstableContentProviderClient(r7);
        if (r6 == null) goto L5;
        ParcelFileDescriptor r8 = r6.openFile(r7, "r");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        if (r8 != null) goto L11;
        b r9 = (b) ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        r6.close();
        return r9;
    L11:
        InputStream r10 = (InputStream) ZeusTransformUtils.preCheckCast(new ParcelFileDescriptor.AutoCloseInputStream(r8), InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        if (ZeusTransformUtils.instanceOf(r10, BufferedInputStream.class) == false) goto L14;
        BufferedInputStream r11 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r10, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
    L15:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        BufferedInputStream r1 = (BufferedInputStream) ZeusTransformUtils.preCheckCast(r12, BufferedInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        String r2 = com.obric.aiproactive.ui.artifact.c.a(com.obric.aiproactive.ui.artifact.c.f6547a, (InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r12, null);     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        b r13 = (b) ZeusTransformUtils.preCheckCast(new b.C0290b(r2), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
    L34:
        r6.close();
        return r13;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
        throw th;     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
    L14:
        r11 = new BufferedInputStream(r10, 8192);     // Catch: Throwable -> L24 IOException -> L26 SecurityException -> L28 FileNotFoundException -> L29 RemoteException -> L30 DeadObjectException -> L31 DocumentTooLargeException -> L32
    L32:
        Object r14 = ZeusTransformUtils.preCheckCast(b.c.f6539a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L27:
        r13 = (b) r14;     // Catch: Throwable -> L24
    L29:
        r14 = ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L31:
        r14 = ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L28:
        r14 = ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L30:
        r14 = ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L26:
        r14 = ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        goto L27
    L5:
        return (b) ZeusTransformUtils.preCheckCast(b.a.f6537a, b.class, "com.obric.memorydata.plugin");
    L24:
        th = move-exception;
        r6.close();
        throw th;
    }

    private final void shareOriginalDocument() {
        Uri r0 = this.sourceUri;
        if (r0 != null) goto L5;
        return;
    L5:
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10461(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void showError(ActivityDocumentPreviewBinding r2, int r3) {
        r2.scrollMarkdown.setVisibility(8);
        r2.layoutHtml.setVisibility(8);
        r2.tvState.setText(r3);
        r2.tvState.setVisibility(0);
    }

    private final void showHtml(ActivityDocumentPreviewBinding r17, String r18) {
        String r12 = d.f6549a.a(r18, getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_1")), getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")), getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")), getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2")), getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6")));
        if (r12 != null) goto L6;
        showError(r17, ZeusTransformUtils.mapRes(R.string.proactive_document_preview_failed, TypedValues.Custom.S_STRING, "proactive_document_preview_failed"));
        return;
    L6:
        r17.tvState.setVisibility(8);
        r17.scrollMarkdown.setVisibility(8);
        r17.layoutHtml.setVisibility(0);
        WebView r2 = r17.webHtml;
        Intrinsics.checkNotNullExpressionValue(r2, "webHtml");
        configureRestrictedWebView(r2);
        r17.webHtml.loadDataWithBaseURL(null, r12, "text/html", RpcUtils.CHARSET_UTF8, null);
    }

    private final void showMarkdown(ActivityDocumentPreviewBinding r3, String r4) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        showError(r3, ZeusTransformUtils.mapRes(R.string.proactive_document_preview_failed, TypedValues.Custom.S_STRING, "proactive_document_preview_failed"));
        return;
    L6:
        r3.tvState.setVisibility(8);
        r3.layoutHtml.setVisibility(8);
        r3.scrollMarkdown.setVisibility(0);
        j r2 = j.f6886a;
        MarkdownTextView r5 = r3.tvMarkdown;
        Intrinsics.checkNotNullExpressionValue(r5, "tvMarkdown");
        r2.e((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin"), r4);
    }

    public void finish() {
        super.finish();
        h.f13009a.d((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r14) {
        Uri r15 = documentUriExtra();
        String r0 = getIntent().getStringExtra(EXTRA_DISPLAY_NAME);
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = getIntent().getStringExtra(EXTRA_MIME_TYPE);
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        DocumentPreviewKind r3 = e.a(r1, r0);
        if (r15 != null) goto L12;
    L20:
        finish();
        return;
    L12:
        if (com.obric.aiproactive.ui.artifact.b.f6545a.a(r15) == false) goto L20;
        if (r3 == null) goto L20;
        this.sourceUri = r15;
        this.sourceMimeType = r1;
        this.sourceDisplayName = r0;
        h.f13009a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        configureWindow();
        ActivityDocumentPreviewBinding r4 = ActivityDocumentPreviewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        setContentView((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        OFloatingTitleBar r5 = r4.titleBar;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L18;
        r6 = getString(ZeusTransformUtils.mapRes(R.string.proactive_document_preview_title, TypedValues.Custom.S_STRING, "proactive_document_preview_title"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
    L18:
        r5.setCenterTitle((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        OFloatingTitleBar.a(r5, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$DocumentPreviewActivity$ixJOsZ6Rmp8W6QwXFRnDgdCQ9CY(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_back, TypedValues.Custom.S_STRING, "proactive_back")), CharSequence.class, "com.obric.memorydata.plugin"));
        OFloatingTitleBar.b(r5, ZeusTransformUtils.mapRes(R.drawable.ic_proactive_document_share, "drawable", "ic_proactive_document_share"), 0, new $$Lambda$DocumentPreviewActivity$3vywhzrIfiRdtrXDmfW7OteSRKw(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_document_share, TypedValues.Custom.S_STRING, "proactive_document_share")), CharSequence.class, "com.obric.memorydata.plugin"));
        r4.btnOpenExternal.setOnClickListener(new $$Lambda$DocumentPreviewActivity$1MwzHCGth36Yujvl1Wa71mTBhk(this));
        loadDocument(r15, r3);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        ActivityDocumentPreviewBinding r0 = this.binding;
        if (r0 == null) goto L7;
        WebView r1 = r0.webHtml;
        if (r1 == null) goto L7;
        r1.stopLoading();
        r1.loadUrl("about:blank");
        r1.clearHistory();
        r1.removeAllViews();
        r1.destroy();
    L7:
        this.binding = null;
        super.onDestroy();
    }
}

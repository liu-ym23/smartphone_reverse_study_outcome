package com.ss.android.lark.chat.video;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u0003678B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010&\u001a\u00020\u001fH\u0003J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020\u001fH\u0016J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u001fH\u0002J\b\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u001fH\u0016J\b\u00105\u001a\u00020\u001fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/video/YoutubeVideoPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/chat/video/SharedElementListener;", "Lcom/ss/android/lark/chat/video/BackListener;", "<init>", "()V", "mCoverImage", "Lcom/ss/android/lark/image/entity/Image;", "mVid", BuildConfig.FLAVOR, "mWebView", "Landroid/webkit/WebView;", "mErrorContainer", "Landroid/view/ViewGroup;", "mLoading", "Landroid/view/View;", "mClose", "mCoverView", "Landroid/widget/ImageView;", "mListener", "Lcom/ss/android/lark/chat/video/OnFragmentInteractListener;", "mIsVideoStart", BuildConfig.FLAVOR, "mRootView", "isPortrait", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "baseUrl$delegate", "Lkotlin/Lazy;", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "playYoutubeVideo", "onViewCreated", "view", "onAttach", "context", "Landroid/content/Context;", "onDetach", "onSharedElementEnd", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "dealWithError", "pauseVideo", "onPause", "onDestroy", "YoutubeClient", "JSListener", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YoutubeVideoPreviewFragment extends Fragment implements p, com.ss.android.lark.chat.video.a {
    public static final /* synthetic */ int p = 0;
    public Image d;
    public String e;
    public WebView f;
    public ViewGroup g;
    public View h;
    public View i;
    public ImageView j;
    public g k;
    public boolean l;
    public View m;
    public boolean n;
    public final Lazy o;

    public static final class a {
    }

    public final class b {
        public final /* synthetic */ YoutubeVideoPreviewFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ YoutubeVideoPreviewFragment b;

            public a(String r1, YoutubeVideoPreviewFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                if (Intrinsics.areEqual("1", this.a) == false) goto L16;
                FragmentActivity r0 = this.b.getActivity();
                if (r0 == null) goto L9;
                Window r1 = r0.getWindow();
                if (r1 == null) goto L9;
                r1.addFlags(128);
            L9:
                ImageView r2 = this.b.j;
                if (r2 == null) goto L12;
                r2.setVisibility(8);
            L12:
                View r3 = this.b.h;
                if (r3 == null) goto L15;
                r3.setVisibility(8);
            L15:
                this.b.l = true;
                return;
            L16:
                FragmentActivity r4 = this.b.getActivity();
                if (r4 == null) goto L23;
                Window r5 = r4.getWindow();
                if (r5 == null) goto L24;
                r5.clearFlags(128);
                return;
            L24:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chat.video.YoutubeVideoPreviewFragment$b$b, reason: collision with other inner class name */
        public static final class RunnableC0115b implements Runnable {
            public final /* synthetic */ YoutubeVideoPreviewFragment a;

            public RunnableC0115b(YoutubeVideoPreviewFragment r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ImageView r0 = this.a.j;     // Catch: Throwable -> L9
                if (r0 == null) goto L5;
                r0.setVisibility(8);     // Catch: Throwable -> L9
            L5:
                View r1 = this.a.h;     // Catch: Throwable -> L9
                if (r1 == null) goto L12;
                r1.setVisibility(8);     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public b(YoutubeVideoPreviewFragment r1) {
            this.a = r1;
        }

        @JavascriptInterface
        public final void postEvent(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
            if (Intrinsics.areEqual(r2, "onStateChange") == false) goto L6;
            UICallbackExecutor.execute(new a(r3, this.a));
            return;
        L6:
            if (Intrinsics.areEqual(r2, "onError") == false) goto L10;
            UICallbackExecutor.execute(new RunnableC0115b(this.a));
            return;
        }
    }

    public final class c extends WebViewClient {
        public final /* synthetic */ YoutubeVideoPreviewFragment a;

        public c(YoutubeVideoPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r3, WebResourceRequest r4, WebResourceError r5) {
            super.onReceivedError(r3, r4, r5);
            if (r4 == null) goto L11;
            Uri r6 = r4.getUrl();
            if (r6 == null) goto L11;
            String r7 = r6.toString();
            if (r7 == null) goto L11;
            YoutubeVideoPreviewFragment r8 = this.a;
            int r0 = YoutubeVideoPreviewFragment.p;
            boolean r9 = StringsKt.contains$default(r7, (String) r8.o.getValue(), false, 2, null);
            boolean r10 = true;
            if (r9 != true) goto L11;
        L12:
            if (r10 == false) goto L14;
            return;
        L14:
            YoutubeVideoPreviewFragment r11 = this.a;
            if (r11.l == true) goto L23;
            ViewGroup r12 = r11.g;
            if (r12 == null) goto L19;
            r12.setVisibility(0);
        L19:
            View r13 = r11.h;
            if (r13 == null) goto L24;
            r13.setVisibility(8);
            return;
        L24:
            return;
        L23:
            return;
        L11:
            r10 = false;
            goto L12
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r1, int r2, String r3, String r4) {
            super.onReceivedError(r1, r2, r3, r4);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            YoutubeVideoPreviewFragment r5 = this.a;
            if (r5.l == true) goto L14;
            ViewGroup r6 = r5.g;
            if (r6 == null) goto L10;
            r6.setVisibility(0);
        L10:
            View r7 = r5.h;
            if (r7 == null) goto L15;
            r7.setVisibility(8);
            return;
        L15:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ YoutubeVideoPreviewFragment a;

        public d(YoutubeVideoPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            YoutubeVideoPreviewFragment r3 = this.a;
            int r0 = YoutubeVideoPreviewFragment.p;
            r3.S90();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ YoutubeVideoPreviewFragment a;

        public e(YoutubeVideoPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ImageView r3 = this.a.j;
            if (r3 == null) goto L5;
            r3.setVisibility(0);
        L5:
            g r4 = this.a.k;
            if (r4 == null) goto L8;
            r4.onClosed();
        L8:
            YoutubeVideoPreviewFragment r5 = this.a;
            if (r5.n == false) goto L13;
            FragmentActivity r6 = r5.getActivity();
            if (r6 == null) goto L17;
            r6.finishAfterTransition();
            return;
        L17:
            return;
        L13:
            FragmentActivity r7 = r5.getActivity();
            if (r7 == null) goto L19;
            r7.finish();
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.video.p
    public final void tD() {
    }

    @Override // com.ss.android.lark.chat.video.a
    public final boolean onBackPressed() {
        ImageView r0 = this.j;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
    L6:
        if (this.n == true) goto L12;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        r1.finish();
        return true;
    L13:
        return true;
    L12:
        return false;
    }

    public final void onDestroy() {
        WebView r0 = this.f;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.f = null;
        super.onDestroy();
    }

    public YoutubeVideoPreviewFragment() {
        this.n = true;
        this.o = LazyKt.lazy(new YoutubeVideoPreviewFragment$baseUrl$2(this));
    }

    public final void S90() {
        ChatCoreModule.a().getUrlPreviewDependency().b();
        if (BuildConfig.FLAVOR.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        WebView r4 = this.f;
        if (r4 == null) goto L11;
        r4.getSettings().setJavaScriptEnabled(true);
        r4.getSettings().setDomStorageEnabled(true);
        r4.getSettings().setMediaPlaybackRequiresUserGesture(false);
        r4.getSettings().setMixedContentMode(0);
        r4.addJavascriptInterface(new b(this), "playerListener");
        r4.setWebViewClient(new c(this));
        CookieManager.getInstance().setAcceptThirdPartyCookies(r4, true);
        String r5 = (String) this.o.getValue();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        r4.loadDataWithBaseURL(r5, String.format(Locale.US, BuildConfig.FLAVOR, Arrays.copyOf(new Object[]{this.e, 0}, 2)), "text/html", "UTF-8", null);
    L11:
        View r0 = this.h;
        if (r0 == null) goto L14;
        r0.setVisibility(0);
    L14:
        ViewGroup r3 = this.g;
        if (r3 == null) goto L18;
        r3.setVisibility(8);
        return;
    L18:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDetach() {
        super.onDetach();
        this.k = null;
    }

    public final void onPause() {
        super.onPause();
        WebView r0 = this.f;
        if (r0 == null) goto L6;
        r0.loadUrl("javascript:pauseVideo()");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        if ((r2 instanceof g) == false) goto L6;
        this.k = (g) r2;
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        boolean r0 = true;
        if (r2.orientation == 1) goto L6;
        r0 = false;
    L6:
        this.n = r0;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L6;
        this.d = r3.getSerializable("param_cover_image");
        this.e = r3.getString("param_vid");
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        g r4 = this.k;
        if (r4 == null) goto L6;
        r4.j();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131564253, r3, false);
        this.f = (WebView) r5.findViewById(2131382456);
        this.i = r5.findViewById(2131368310);
        this.h = r5.findViewById(2131379052);
        this.j = (ImageView) r5.findViewById(2131393415);
        this.g = (ViewGroup) r5.findViewById(2131371773);
        r5.setTransitionName("show_video_share_element");
        this.m = r5;
        S90();
        ViewGroup r6 = this.g;
        if (r6 == null) goto L5;
        r6.setOnClickListener(new d(this));
    L5:
        Image r7 = this.d;
        if (r7 == null) goto L8;
        ImageLoader.with(getContext()).load(new EncryptImage(r7)).error(2131231112).into(this.j);
    L8:
        View r8 = this.i;
        if (r8 == null) goto L11;
        r8.setOnClickListener(new e(this));
    L11:
        return r5;
    }
}

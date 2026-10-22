package com.larus.bmhome.video.fragment;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.save_share.VideoGenerateSaver;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 w*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0002wxB7\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eB\t\b\u0016¢\u0006\u0004\b\r\u0010\u000fJ\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010K\u001a\f0LR\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH&J\b\u0010T\u001a\u00020\u0018H&J\b\u0010U\u001a\u00020VH&J\b\u0010W\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020\nH\u0016J\b\u0010Y\u001a\u00020\u001bH\u0016J\b\u0010Z\u001a\u00020\u001bH\u0016J&\u0010[\u001a\u0004\u0018\u00010<2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0017J\u001a\u0010^\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020<2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010`\u001a\u00020\u001bH\u0016J\b\u0010a\u001a\u00020\u001bH\u0016J\b\u0010b\u001a\u00020\u001bH\u0016J\u000e\u0010c\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020RJ\b\u0010d\u001a\u00020\u001bH\u0004J\u0016\u0010e\u001a\u00020\u001b2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u001b0gH\u0002J\u001e\u0010h\u001a\u00020\u001b2\u0014\u0010i\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001b0jH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\b\u0010l\u001a\u00020\u001bH\u0002J\b\u0010m\u001a\u00020\u001bH\u0002J\u0012\u0010n\u001a\u00020\u001b2\b\u0010o\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010p\u001a\u00020\u001bH\u0004J\b\u0010q\u001a\u00020\u001bH\u0002J\b\u0010r\u001a\u00020\u001bH\u0016J\b\u0010s\u001a\u00020\u001bH\u0016J\b\u0010t\u001a\u00020\nH\u0016J\u0010\u0010u\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020\nH\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u001d\u0010&\u001a\u0004\u0018\u00010'8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00188DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010.\"\u0004\bI\u0010JR\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "enableUseSR", "", "enableUseSRDownLoad", "isReportEnterVideoDetailMob", "<init>", "(Lcom/larus/platform/model/video/VideoPlayData;Lcom/larus/bmhome/utils/VideoDetailEventParams;ZZZ)V", "()V", "getVideoPlayData", "()Lcom/larus/platform/model/video/VideoPlayData;", "getEventParam", "()Lcom/larus/bmhome/utils/VideoDetailEventParams;", "getEnableUseSRDownLoad", "()Z", "getMetaDataMap", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissFragment", "", "draging", "latestDragSeekTime", "", "downloading", "getDownloading", "setDownloading", "(Z)V", "isReportVideoPlayFail", "value", "isPlaying", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "logTag", "getLogTag", "()Ljava/lang/String;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "videoView", "Lcom/larus/common_ui/video/VideoPlayView;", "getVideoView", "()Lcom/larus/common_ui/video/VideoPlayView;", "setVideoView", "(Lcom/larus/common_ui/video/VideoPlayView;)V", "errorView", "Landroid/view/View;", "getErrorView", "()Landroid/view/View;", "setErrorView", "(Landroid/view/View;)V", "videoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "getVideoPlayControl", "()Lcom/larus/bmhome/video/view/IVideoPlayControl;", "setVideoPlayControl", "(Lcom/larus/bmhome/video/view/IVideoPlayControl;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "(Ljava/lang/String;)V", "initViews", "Lcom/larus/bmhome/video/fragment/BaseVideoDetailFragment$InitViewsResult;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "config", "Lcom/larus/bmhome/video/fragment/VideoDetailFgConfig;", "hasReportAiVideoPlay", "tag", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "getCurrentPageName", "autoLogEnterPage", "onShareClick", "onSelected", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onPause", "onDestroy", "initConfig", "dismissTitleShare", "startAfterDataReady", "onReady", "Lkotlin/Function0;", "requestVideoModel", "onNext", "Lkotlin/Function1;", "initRetryView", "initClickListener", "initVideoView", "download", "videoContent", "doShareAction", "initSeekbar", "onUserDragStarted", "onUserDragStopped", "isVideoMute", "reportAiVideoPlay", "isAutoPlay", "Companion", "InitViewsResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseVideoDetailFragment<T extends ViewBinding> extends TraceFragment implements g19.a {
    public static final /* synthetic */ int w = 0;
    public final nr9.g e;
    public final c4 f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public boolean j;
    public long k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final Lazy o;
    public T p;
    public VideoPlayView q;
    public View r;
    public qs8.a s;
    public String t;
    public a0 u;
    public boolean v;

    public static final class a {
    }

    public final class b {
        public final T a;
        public final VideoPlayView b;
        public final View c;
        public final qs8.a d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(ViewBinding r1, VideoPlayView r2, View r3, qs8.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public BaseVideoDetailFragment() {
        this(null, new c4(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383), false, false, 16);
        U90();     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("MusicPlayerDetailFragment", "fallback by dismiss failed");
    }

    public void FU(int r1) {
    }

    public void Oh() {
    }

    public boolean S90() {
        return !(this instanceof CreationDetailPromptVideoFragment);
    }

    public void U90() {
    }

    public void VT() {
    }

    public Object X90(Continuation<? super Map<String, String>> r1) {
        return null;
    }

    public abstract BaseVideoDetailFragment<T>.b Y90(LayoutInflater r1, ViewGroup r2);

    public boolean Z90() {
        return !(this instanceof AiGenVideoDetailFragment);
    }

    public void aa0() {
    }

    public void ba0() {
    }

    public abstract ShareScene da0();

    public boolean dc() {
        return false;
    }

    public String k() {
        return "video_detail";
    }

    public void o1() {
    }

    public abstract String tag();

    public final void V90() {
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(this);
        c4 r2 = this.f;
        wc9.e r3 = r2.e;
        BotModel r4 = r2.d;
        String r5 = r2.c;
        ChatControlTrace r6 = ChatControlTrace.b;
        r6.getClass();
        String r7 = r6.h(ChatControlTrace.y);
        c4 r8 = this.f;
        String r9 = r8.a;
        String r10 = r8.b;
        String r15 = r8.j;
        String r14 = r8.h;
        Boolean r13 = r8.k;
        Integer r12 = r8.i;
        Message r11 = r8.l;
        ICreationMetadataService.Companion r16 = ICreationMetadataService.a;
        if (r12 == null) goto L5;
        int r17 = r12.intValue();
    L6:
        UserCreationFromIM r18 = r16.I(r11, r14, String.valueOf(r17));
        if (r18 == null) goto L9;
        String r44 = r18.getCreationId();
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BaseVideoDetailFragment$doShareAction$1(this, r1, new com.larus.bmhome.share.panel.h(r3, r4, r5, "video_detail", r7, r9, r10, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r14, r12, r15, r13, null, null, null, null, null, null, r11, null, null, r44, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 1073741572, -4356, 1023), null), 3, null);
        return;
    L9:
        r44 = null;
        goto L10
    L5:
        r17 = 0;
        goto L6
    }

    public final void onPause() {
        a0 r0 = this.u;
        Function2<? super String, ? super IVideoController, Unit> r1 = r0.g;
        IVideoController.PlayType r2 = null;
        if (r1 == null) goto L9;
        nr9.g r3 = this.e;
        if (r3 == null) goto L7;
        String r4 = r3.a;
    L8:
        r1.invoke(r4, ps8.d.a.a(r0.c, r0.d, r0.e));
        goto L9
    L7:
        r4 = null;
    L9:
        super/*androidx.fragment.app.Fragment*/.onPause();
        IVideoController.PlayType r5 = IVideoController.PlayType.PLAY;
        ps8.d r6 = ps8.d.a;
        a0 r7 = this.u;
        IVideoController r8 = r6.a(r7.c, r7.d, r7.e);
        if (r8 == null) goto L13;
        r2 = r8.d();
    L13:
        if (r5 != r2) goto L15;
        boolean r9 = true;
    L16:
        this.n = r9;
        VideoPlayView r10 = this.q;
        if (r10 == null) goto L20;
        VideoPlayView.z(r10, 0, 2);
        return;
    L20:
        return;
    L15:
        r9 = false;
        goto L16
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        VideoPlayView r0 = this.q;
        if (r0 == null) goto L6;
        r0.N();
    L6:
        if (this.g == false) goto L11;
        VideoPlayView r1 = this.q;
        if (r1 == null) goto L12;
        r1.D();
        return;
    L12:
        return;
    }

    public void onResume() {
        super.onResume();
        if (this.n == false) goto L9;
        x19.a.a = true;
        VideoPlayView r1 = this.q;
        if (r1 == null) goto L7;
        VideoPlayView.H(r1, 0, 2);
    L7:
        this.n = false;
        ca0(true);
    L9:
        if (this.i == false) goto L19;
        nr9.g r0 = this.e;
        if (r0 == null) goto L13;
        String r2 = r0.a;
    L14:
        String r3 = r2;
        c4 r4 = this.f;
        String r5 = r4.b;
        String r6 = r4.a;
        String r7 = this.t;
        if (r7 != null) goto L17;
        r7 = r4.f;
    L17:
        a4.h(r3, r5, r6, r7, r4.c, r4.g, r4.j, r4.i, r4.h, null, 3584);
        return;
    L13:
        r2 = null;
        goto L14
    }

    public void u() {
        this.t = "slide";
    }

    public EditPanelType SQ() {
        return EditPanelType.NONE;
    }

    public void d70() {
        V90();
    }

    public void W90(nr9.g r22) {
        qs8.a r1 = this.s;
        if (r1 == null) goto L5;
        r1.I4(true);
    L5:
        VideoGenerateSaver r3 = VideoGenerateSaver.a;
        Context r4 = getContext();
        c4 r2 = this.f;
        com.larus.bmhome.video.save_share.a.C0044a.a(r3, r4, r22, new c4(r2.a, r2.b, r2.c, null, null, null, r2.g, r2.h, r2.i, r2.j, null, null, null, null, 15416), "detail_click", LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), false, this.h, null, null, null, false, new t(this), 1952);
    }

    public final void ca0(boolean r18) {
        if (this.u.h == true) goto L5;
    L8:
        nr9.g r1 = this.e;
        Boolean r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.a;
    L12:
        c4 r4 = this.f;
        String r5 = r4.b;
        String r6 = r4.a;
        Boolean r7 = Boolean.valueOf(r18);
        c4 r8 = this.f;
        String r9 = r8.c;
        String r10 = r8.g;
        String r11 = r8.j;
        Integer r12 = r8.i;
        String r13 = r8.h;
        String r14 = k();
        nr9.g r15 = this.e;
        if (r15 == null) goto L15;
        String r16 = r15.b;
    L16:
        Boolean r17 = Boolean.valueOf(a4.a(r16));
        Application r19 = AppHost.a.getApplication();
        VideoPlayView r110 = this.q;
        if (r110 == null) goto L19;
        r2 = Boolean.valueOf(r110.s);
    L19:
        a4.f(r3, r5, r6, r7, r9, r10, r11, r12, r13, r14, null, r17, Boolean.valueOf(a4.b(r19, r2)), 16763904);
        return;
    L15:
        r16 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L5:
        if (this.v == false) goto L7;
        return;
    L7:
        this.v = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [com.larus.bmhome.video.fragment.s] */
    public void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        final VideoPlayView r1 = this.q;
        if (r1 == null) goto L46;
        final ?? r14 = new s(r1, this);
        final nr9.g r15 = this.e;
        if (r15 == null) goto L13;
        char r2 = com.larus.utils.r.a;
        if (com.larus.utils.r.k(r15.h) == false) goto L9;
    L12:
        r14.invoke();
        goto L13
    L9:
        if (o0.d(r15.b) == true) goto L12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BaseVideoDetailFragment$requestVideoModel$1(this, new l(this, r15, r14), null), 2, null);
    L13:
        nr9.g r16 = this.e;
        if (r16 == null) goto L18;
        nr9.f r17 = r16.g;
        if (r17 == null) goto L18;
        String r3 = r17.a;
    L19:
        if (r16 == null) goto L23;
        nr9.f r18 = r16.g;
        if (r18 == null) goto L23;
        String r4 = r18.b;
    L24:
        if (r16 == null) goto L28;
        nr9.f r19 = r16.g;
        if (r19 == null) goto L28;
        String r5 = r19.c;
    L29:
        if (r16 == null) goto L33;
        nr9.f r110 = r16.g;
        if (r110 == null) goto L33;
        Integer r6 = r110.d;
    L34:
        if (r16 == null) goto L38;
        nr9.f r111 = r16.g;
        if (r111 == null) goto L38;
        Integer r7 = r111.e;
    L39:
        if (r16 == null) goto L43;
        nr9.f r112 = r16.g;
        if (r112 == null) goto L43;
        Bitmap r8 = r112.f;
    L44:
        VideoPlayView.p(r1, r3, r4, r5, r6, r7, r8, null, null, 192);
        return;
    L43:
        r8 = null;
    L38:
        r7 = null;
    L33:
        r6 = null;
    L28:
        r5 = null;
    L23:
        r4 = null;
    L18:
        r3 = null;
        goto L19
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        BaseVideoDetailFragment<T>.b r4 = Y90(r1, r2);
        this.p = r4.a;
        this.q = r4.b;
        View r5 = r4.c;
        this.r = r5;
        this.s = r4.d;
        if (r5 == null) goto L5;
        r5.setOnClickListener(new q(this));
    L5:
        VideoPlayView r6 = this.q;
        if (r6 == null) goto L8;
        r6.i(false);
        r6.w(new n(this));
        r6.d = new o(this);
        r6.setAfterClickCallBack(new w(this));
        r6.setDismissCallback(new p(this));
    L8:
        qs8.a r7 = this.s;
        if (r7 == null) goto L11;
        r7.z1(new k(this));
    L11:
        qs8.a r8 = this.s;
        if (r8 == null) goto L14;
        r8.d5(new m(this));
    L14:
        T r9 = this.p;
        if (r9 != null) goto L19;
        return null;
    L19:
        return r9.getRoot();
    }

    public BaseVideoDetailFragment(nr9.g r3, c4 r4, boolean r5, boolean r6, int r7) {
        boolean r1 = false;
        if ((r7 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r1 = true;
    L11:
        Intrinsics.checkNotNullParameter(r4, "eventParam");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r1;
        this.o = LazyKt.lazy(new r(this));
        this.u = a0.i;
    }
}

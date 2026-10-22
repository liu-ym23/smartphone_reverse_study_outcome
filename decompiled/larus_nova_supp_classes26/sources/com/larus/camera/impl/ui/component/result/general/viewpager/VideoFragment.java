package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.databinding.LarusItemPreviewVideoBinding;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.component.result.video.ResultVideoView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/VideoFragment;", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/BasePreviewFragment;", "<init>", "()V", "binding", "Lcom/larus/camera/impl/databinding/LarusItemPreviewVideoBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "subscribeInputStatus", "onResume", "dispatchEventToVideoView", "event", "Landroid/view/MotionEvent;", "onPause", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFragment extends BasePreviewFragment {
    public static final /* synthetic */ int i = 0;
    public LarusItemPreviewVideoBinding h;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ VideoFragment a;

        @Override // com.larus.camera.impl.ui.component.result.general.viewpager.e
        public final void F6() {
            FLogger.a.i(this.a.d, "[onPlayError]");
            if (this.a.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L6;
            qx8.a.b.g(-16002, "video_play_fail");
            return;
        }

        @Override // com.larus.camera.impl.ui.component.result.general.viewpager.e
        public final void a() {
            FLogger.a.i(this.a.d, "[onUserPause]");
            this.a.T90().clickVideoPlayOnResultPage("pause");
        }

        @Override // com.larus.camera.impl.ui.component.result.general.viewpager.e
        public final void c() {
            FLogger.a.i(this.a.d, "[onUserPlay]");
            this.a.T90().clickVideoPlayOnResultPage("play");
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.larus.camera.impl.ui.component.result.general.viewpager.e
        public final void onPlaySuccess() {
            FLogger r0 = FLogger.a;
            r0.i(this.a.d, "[onPlaySuccess]");
            LarusItemPreviewVideoBinding r1 = this.a.h;
            if (r1 == null) goto L8;
            ImageView r2 = r1.b;
            if (r2 == null) goto L8;
            r2.setVisibility(8);
        L8:
            if (this.a.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L16;
            qx8.a r3 = qx8.a.b;
            r3.getClass();
            r0.i("CameraMonitor", "[onRecordPreview]");
            gx8.b r4 = r3.a;
            CameraEvent r5 = CameraEvent.PREVIEW_RECORD;
            JSONObject r6 = new JSONObject();
            r6.putOpt("record_mode", qx8.a.i);
            r6.put("enable_audio", qx8.a.h ? 1 : 0);
            Unit r7 = Unit.INSTANCE;
            r4.a(r5, r6);
            r3.getClass();
            r0.i("CameraMonitor", "[onRecordSuccess] from: " + qx8.a.i + ", hasReportRecordResult: " + qx8.a.g + ", triggerRecord: " + qx8.a.f);
            if (qx8.a.f == true) goto L12;
            return;
        L12:
            if (qx8.a.g == true) goto L18;
            gx8.b r8 = r3.a;
            CameraEvent r9 = CameraEvent.RECORD_RESULT;
            JSONObject r10 = new JSONObject();
            r10.put("is_success", "1");
            r10.putOpt("record_mode", qx8.a.i);
            r10.put("enable_audio", qx8.a.h ? 1 : 0);
            r8.b(r9, r10);
            qx8.a.g = true;
            qx8.a.f = false;
            return;
        L18:
            return;
        }

        public b(VideoFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.camera.impl.ui.component.result.general.viewpager.e
        public final void b(boolean r5) {
            FLogger.a.i(this.a.d, "[onUserDrag] start:" + r5);
            this.a.T90().updateSeekbarDraggingState(r5);
            if (r5 == false) goto L6;
            this.a.T90().clickVideoPlayOnResultPage("drag_progress_bar");
            return;
        }
    }

    static {
    }

    public final void onDestroyView() {
        super.onDestroyView();
        LarusItemPreviewVideoBinding r0 = this.h;
        if (r0 == null) goto L8;
        ResultVideoView r1 = r0.c;
        if (r1 == null) goto L9;
        FLogger.a.i("ResultVideoView", "[stopVideo]");
        r1.a.f.N();
        r1.e = null;
        return;
    L9:
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onPause() {
        super.onPause();
        LarusItemPreviewVideoBinding r0 = this.h;
        if (r0 == null) goto L8;
        ResultVideoView r1 = r0.c;
        if (r1 == null) goto L9;
        FLogger.a.i("ResultVideoView", "[pauseVideo]");
        VideoPlayView.z(r1.a.f, 0, 3);
        return;
    L9:
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onResume() {
        super.onResume();
        T90().setIsPhotoEditable(false);
        LarusItemPreviewVideoBinding r0 = this.h;
        if (r0 == null) goto L8;
        ResultVideoView r1 = r0.c;
        if (r1 == null) goto L9;
        FLogger.a.i("ResultVideoView", "[startVideo]");
        r1.a.f.M();
        return;
    L9:
        return;
    }

    public VideoFragment() {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onViewCreated(View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, "view");
        super.onViewCreated(r24, r25);
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r0 = com.larus.camera.impl.utils.eventbus.c.a;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(this);
        final a1 r2 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r3 = new VideoFragment$subscribeInputStatus$$inlined$subscribe$1(r2);
        g1.a.getClass();
        h1 r4 = g1.a.b;
        boolean r5 = false;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r3, r1, r4, 0), new VideoFragment$subscribeInputStatus$$inlined$subscribe$2(null, this)), r1);
        LifecycleCoroutineScope r6 = LifecycleOwnerKt.getLifecycleScope(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new VideoFragment$subscribeInputStatus$$inlined$subscribe$3(r2), r6, r4, 0), new VideoFragment$subscribeInputStatus$$inlined$subscribe$4(null, this)), r6);
        Bitmap r14 = S90();
        if (r14 == null) goto L14;
        LarusItemPreviewVideoBinding r7 = this.h;
        if (r7 == null) goto L9;
        ImageView r8 = r7.b;
        if (r8 == null) goto L9;
        r8.setImageBitmap(r14);
    L9:
        LarusItemPreviewVideoBinding r9 = this.h;
        if (r9 == null) goto L14;
        ImageView r10 = r9.b;
        if (r10 == null) goto L14;
        r10.setVisibility(0);
    L14:
        LarusItemPreviewVideoBinding r11 = this.h;
        if (r11 == null) goto L74;
        ResultVideoView r12 = r11.c;
        if (r12 == null) goto L74;
        ResultDisplayParam r13 = this.e;
        if (r13 == null) goto L21;
        String r15 = r13.getPath();
    L22:
        ResultDisplayParam r16 = this.e;
        if (r16 == null) goto L25;
        String r17 = r16.getOutputKey();
    L26:
        b r18 = new b(this);
        Intrinsics.checkNotNullParameter(r18, "callback");
        FLogger r19 = FLogger.a;
        r19.i("ResultVideoView", "[setData] path:" + r15 + ", bitmap:" + r14);
        if (r15 != null) goto L29;
    L30:
        r5 = true;
    L31:
        if (r5 == true) goto L74;
        VideoPlayView r20 = r12.a.f;
        Lazy r21 = wx8.j.a;
        if (r17 != null) goto L36;
        r17 = r15;
    L36:
        Intrinsics.checkNotNullParameter(r17, "key");
        Lazy r22 = wx8.j.a;
        IVideoController r110 = (IVideoController) ((ConcurrentHashMap) r22.getValue()).get(r17);
        if (r110 != null) goto L39;
    L40:
        r110 = q3.b("", null, 6);
        if (r110 == null) goto L43;
        ((com.larus.video.impl.sdk.o) r110).I(true);
    L44:
        if (r110 == null) goto L46;
        ((ConcurrentHashMap) r22.getValue()).put(r17, r110);
    L46:
        StringBuilder r23 = new StringBuilder("key: ");
        r23.append(r17);
        r23.append(", engine: ");
        r23.append(r110);
        r23.append(", isReleased: ");
        if (r110 == null) goto L49;
        Boolean r26 = Boolean.valueOf(r110.isReleased());
    L50:
        r23.append(r26);
        r23.append("， engine impl:");
        if (r110 == null) goto L53;
        Integer r27 = Integer.valueOf(r110.hashCode());
    L54:
        r23.append(r27);
        r19.i("VideoPlayerEngineManager", r23.toString());
        VideoPlayView.e(r20, r110, null, r15, null, null, null, 58);
        if (r14 == null) goto L57;
        Integer r111 = Integer.valueOf(r14.getHeight());
    L58:
        if (r14 == null) goto L60;
        Integer r28 = Integer.valueOf(r14.getWidth());
    L61:
        VideoPlayView.p(r20, null, "", null, r111, r28, r14, null, null, 197);
        MediaMetadataRetriever r29 = new MediaMetadataRetriever();
        r29.setDataSource(r15);     // Catch: Throwable -> L66 Exception -> L68
        String r30 = ResultVideoView.R5(r29);     // Catch: Throwable -> L66 Exception -> L68
        if (r30 == null) goto L70;
        long r31 = Long.parseLong(r30);     // Catch: Throwable -> L66 Exception -> L68
    L71:
        r29.release();
        r12.d = r31;
        r12.e = r18;
        goto L74
    L70:
        r31 = 0;
    L68:
        e = move-exception;
        FLogger.a.e("ResultVideoView", "[getVideoDuration] error:" + e.getMessage());     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        r29.release();
        throw th;
    L60:
        r28 = null;
        goto L61
    L57:
        r111 = null;
        goto L58
    L53:
        r27 = null;
        goto L54
    L49:
        r26 = null;
        goto L50
    L43:
        r110 = null;
        goto L44
    L39:
        if (r110.isReleased() == false) goto L46;
    L29:
        if (r15.length() != 0) goto L31;
    L25:
        r17 = null;
        goto L26
    L21:
        r15 = null;
    L74:
        LarusItemPreviewVideoBinding r32 = this.h;
        if (r32 == null) goto L83;
        ResultVideoView r33 = r32.c;
        if (r33 == null) goto L84;
        r33.setUnifiedControlsEnabled(CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(T90(), null, 1, null));
        return;
    L84:
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562615, r3, false);
        int r6 = 2131382937;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r5, 2131382937);
        if (r7 == null) goto L9;
        r6 = 2131384457;
        ResultVideoView r0 = (ResultVideoView) ViewBindings.findChildViewById(r5, 2131384457);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.h = new LarusItemPreviewVideoBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}

package com.larus.voicecall.impl.component.picture;

import android.content.Context;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.animation.AlphaAnimation;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.OutputParam;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CameraTabConfig;
import com.larus.im.bean.bot.SceneModel;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeMobUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001yB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020KH\u0082@¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0082@¢\u0006\u0002\u0010QJ\u001e\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020I2\u0006\u0010O\u001a\u00020PH\u0082@¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020NH\u0016J\b\u0010V\u001a\u00020NH\u0016J\b\u0010W\u001a\u00020NH\u0016J\u001a\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020I2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u0018\u0010]\u001a\u00020Y2\u0006\u0010^\u001a\u00020_2\u0006\u0010Z\u001a\u00020IH\u0002J\u001a\u0010`\u001a\u00020N2\u0006\u0010a\u001a\u00020I2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002J\u001a\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020_H\u0016J\u001a\u0010g\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020_H\u0016J\b\u0010h\u001a\u00020NH\u0016J\b\u0010i\u001a\u00020NH\u0016J\b\u0010j\u001a\u00020NH\u0016J\b\u0010k\u001a\u00020NH\u0002J\b\u0010l\u001a\u00020_H\u0002J\u0010\u0010m\u001a\u00020N2\u0006\u0010n\u001a\u00020YH\u0016J\u0010\u0010o\u001a\u00020N2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020N2\u0006\u0010s\u001a\u00020tH\u0016J\u001c\u0010u\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020w0v2\u0006\u0010a\u001a\u00020IH\u0002J\u000e\u0010x\u001a\u00020N2\u0006\u0010a\u001a\u00020IR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010?8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006z"}, d2 = {"Lcom/larus/voicecall/impl/component/picture/RealtimePictureComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/picture/IRealtimePictureAbility;", "Lcom/larus/voicecall/impl/component/picture/IRealtimeAlbumAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "videoAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVideoAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "videoAbility$delegate", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "tarPos", NameKeys.UnloadStrategy_No_Strategy, "getTarPos", "()[I", "takePhotoAniViewCenterPos", "getTakePhotoAniViewCenterPos", "picTacker", "Lcom/larus/camera/api/IFlowCamera;", "getPicTacker", "()Lcom/larus/camera/api/IFlowCamera;", "processAlbumImage", "Lcom/larus/voicecall/impl/subtitle/bean/ImageProcessorWrapper;", LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareForAni", NameKeys.UnloadStrategy_No_Strategy, "outputParam", "Lcom/larus/camera/api/params/OutputParam;", "(Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startExecAni", "imageWrapper", "(Lcom/larus/voicecall/impl/subtitle/bean/ImageProcessorWrapper;Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onVContextReady", "onCreate", "execPhotoShrinkToHolderAni", NameKeys.UnloadStrategy_No_Strategy, "cameraResult", "bitmap", "Landroid/graphics/Bitmap;", "runAlphaAni", "reason", NameKeys.UnloadStrategy_No_Strategy, "execPhotoShrinkAni", "pic", "getTakePicMenuItem", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "menuItemId", NameKeys.UnloadStrategy_No_Strategy, "txt", "getAlbumMenuItem", "tryToCamera", "tryEnterTakePhoto", "tryToAlbum", "reportClickUploadEntrance", "getCurrentCallBackgroundMode", "goToCamera", "forceOpen", "onAlbumSelected", "item", "Lcom/larus/platform/model/album/AlbumSelectItem;", "onViewCreated", "view", "Landroid/view/View;", "generateMob", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "uploadImg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimePictureComponent extends RealtimeComponent implements b, com.larus.voicecall.impl.component.picture.a {
    public static final /* synthetic */ int B = 0;
    public IFlowCamera A;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public int[] y;
    public int[] z;

    public static final class a {
    }

    static {
    }

    public final IFlowCamera B3() {
        if (this.A != null) goto L10;
        final IFlowCamera r0 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r0.m(com.larus.ui.arch.component.internal.attach.a.b(this, this), new h(this, r0), new i(this));
    L8:
        this.A = r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return this.A;
    }

    public final com.larus.voicecall.impl.component.subtitle.a C3() {
        return (com.larus.voicecall.impl.component.subtitle.a) this.t.getValue();
    }

    public final int[] D3() {
        if (this.z != null) goto L19;
        int[] r1 = new int[2];
        g3a.a r2 = p3();
        if (r2 == null) goto L7;
        SimpleDraweeView r3 = r2.kj();
    L8:
        if (r3 == null) goto L10;
        r3.getLocationOnScreen(r1);
    L10:
        int r4 = 0;
        int r5 = r1[0];
        if (r3 == null) goto L13;
        int r6 = r3.getWidth() / 2;
    L14:
        r1[0] = r5 + r6;
        int r7 = r1[1];
        if (r3 == null) goto L17;
        r4 = r3.getHeight() / 2;
    L17:
        r1[1] = r7 + r4;
        this.z = r1;
        goto L19
    L13:
        r6 = 0;
        goto L14
    L7:
        r3 = null;
    L19:
        return this.z;
    }

    @Override // com.larus.voicecall.impl.component.picture.a
    public final void lJ() {
        if (z2.a.realtimeCallUseTwoLineStyle() == true) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.component.vlm.b r1 = (com.larus.voicecall.impl.component.vlm.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.vlm.b.class);
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), getContext().getResources().getString(2131900526), null, false, 28);
        FLogger.a.e("RealtimePictureComponent", "video call, not allow to select photo");
        return;
    L15:
        j3a.a r4 = z3();
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        j3a.a r6 = z3();
        if (r6 != null) goto L24;
    L26:
        boolean r7 = false;
    L27:
        Keva r8 = RealtimeCallDegradeManager.a;
        if (RealtimeCallDegradeManager.h("image_query", "shot_button", true) == false) goto L31;
        FLogger.a.e("RealtimePictureComponent", "tryToAlbum, degrade intercept click");
        return;
    L31:
        if (r5 == false) goto L35;
        if (r7 == false) goto L35;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), getContext().getResources().getString(2131900502), null, false, 28);
        FLogger.a.e("RealtimePictureComponent", "tryToAlbum, not allow to select photo in interview scene");
        return;
    L35:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r9 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r9 == null) goto L47;
        com.larus.voicecall.impl.component.bottom.b r10 = (com.larus.voicecall.impl.component.bottom.b) this.s.getValue();
        if (r10 == null) goto L44;
        VoiceCallBottomLayout r11 = r10.BT();
        if (r11 == null) goto L44;
        if (r11.u6(r9, r5, 2131900517) != true) goto L44;
        boolean r12 = true;
    L45:
        if (r12 == true) goto L47;
        return;
    L44:
        r12 = false;
    L47:
        com.larus.platform.service.o r13 = com.larus.platform.service.o.a;
        JSONObject r14 = new JSONObject();
        r14.put("if_call", 1);
        r14.put("call_id", ((RealtimeCallParam) this.p.getValue()).e);
        if (((h88.b) ((e3a.b) this.o.getValue())).t == false) goto L50;
        String r15 = "screen_share";
    L59:
        r14.put("call_background_mode", r15);
        RealtimeCallUtil.a.getClass();
        r14.put("is_subtitles_mode", RealtimeCallUtil.z ? 1 : 0);
        com.larus.voicecall.impl.scene.o r16 = RealtimeCallUtil.l;
        if (r16 == null) goto L65;
        SceneModel r17 = r16.a;
        if (r17 == null) goto L65;
        String r18 = r17.getKey();
        if (r18 == null) goto L65;
    L66:
        r14.put("call_scene", r18);
        Unit r19 = Unit.INSTANCE;
        r13.reportEvent("click_upload_entrance", r14);
        AlbumHelper r20 = (AlbumHelper) this.x.getValue();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r21 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        AlbumSettingConfig.a r22 = new AlbumSettingConfig.a();
        r22.f = "realtime_call";
        r22.c = false;
        AlbumSettingConfig r23 = r22.a();
        Function0 r24 = new j();
        Function0 r25 = new k();
        String r110 = ((h88.a) m3()).d;
        String r111 = ((h88.a) m3()).f;
        Integer r26 = Integer.valueOf(((h88.a) m3()).R);
        if (r26.intValue() != 0) goto L70;
        r2 = false;
    L70:
        if (r2 == true) goto L73;
        r26 = null;
    L73:
        if (r26 == null) goto L75;
        int r112 = r26.intValue();
    L76:
        AlbumHelper.f(r20, r21, r23, r24, r25, r110, r111, r112, ((h88.a) m3()).t, "realtime_call", null, null, null, 3584);
        return;
    L75:
        r112 = 0;
    L65:
        r18 = "other";
        goto L66
    L50:
        com.larus.voicecall.impl.component.vlm.b r27 = (com.larus.voicecall.impl.component.vlm.b) this.w.getValue();
        if (r27 != null) goto L53;
    L55:
        boolean r28 = false;
    L56:
        if (r28 == false) goto L58;
        r15 = "video_call";
        goto L59
    L58:
        r15 = LynxResourceModule.AUDIO_TYPE;
        goto L59
    L53:
        if (r27.D5() != true) goto L55;
        r28 = true;
        goto L56
    L24:
        if (r6.eZ() != true) goto L26;
        r7 = true;
        goto L27
    L18:
        if (r4.su() != true) goto L20;
        r5 = true;
        goto L21
    L8:
        if (r1.D5() != true) goto L10;
        r3 = true;
        goto L12
    }

    public final e3a.a m3() {
        return (e3a.a) this.n.getValue();
    }

    public final void onCreate() {
        com.larus.bmhome.upload.audio.g r0 = com.larus.bmhome.upload.audio.g.a;
        ((LinkedHashMap) com.larus.bmhome.upload.audio.g.b).clear();
    }

    public final g3a.a p3() {
        return (g3a.a) this.r.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, b.class);
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.picture.a.class);
        AlbumHelper r1 = (AlbumHelper) this.x.getValue();
        Intrinsics.checkNotNullParameter(this, "<this>");
        AlbumHelper.c(r1, com.larus.ui.arch.component.internal.attach.a.b(this, this), new f(this));
        return;
    }

    public final j3a.a z3() {
        return (j3a.a) this.u.getValue();
    }

    public RealtimePictureComponent() {
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new m(this));
        this.p = LazyKt.lazy(new n(this));
        this.q = LazyKt.lazy(new o(this));
        this.r = LazyKt.lazy(new p(this));
        this.s = LazyKt.lazy(new q(this));
        this.t = LazyKt.lazy(new r(this));
        this.u = LazyKt.lazy(new s(this));
        this.v = LazyKt.lazy(new t(this));
        this.w = LazyKt.lazy(new d(this));
        this.x = LazyKt.lazy(new l());
    }

    public final void A0() {
        m3();
        e3a.b r0 = (e3a.b) this.o.getValue();
        C3();
    }

    @Override // com.larus.voicecall.impl.component.picture.b
    public final void Jh() {
        com.larus.voicecall.impl.component.vlm.b r0 = (com.larus.voicecall.impl.component.vlm.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.vlm.b.class);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        j3a.a r3 = z3();
        if (r3 != null) goto L19;
    L21:
        boolean r4 = false;
    L22:
        j3a.a r5 = z3();
        if (r5 != null) goto L25;
    L27:
        Keva r6 = RealtimeCallDegradeManager.a;
        if (RealtimeCallDegradeManager.h("image_query", "shot_button", true) == false) goto L31;
        FLogger.a.e("RealtimePictureComponent", "tryToCamera, degrade intercept click");
        return;
    L31:
        if (r4 == false) goto L35;
        if (r1 == false) goto L35;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), getContext().getResources().getString(2131900502), null, false, 28);
        FLogger.a.e("RealtimePictureComponent", "tryToCamera, not allow to take photo in interview scene");
        return;
    L35:
        AO(r4);
        return;
    L25:
        if (r5.eZ() != true) goto L27;
        r1 = true;
        goto L27
    L19:
        if (r3.su() != true) goto L21;
        r4 = true;
        goto L22
    L11:
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L13;
        int r7 = 2131900527;
    L14:
        t19.s.j(t19.s.a, AppHost.a.getApplication(), getContext().getResources().getString(r7), null, false, 28);
        FLogger.a.e("RealtimePictureComponent", "video call, not allow to take photo");
        return;
    L13:
        r7 = 2131910983;
        goto L14
    L5:
        if (r0.D5() != true) goto L7;
        r2 = true;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.picture.b
    public final void kg() {
        Jh();
    }

    @Override // com.larus.voicecall.impl.component.picture.b
    public final void AO(boolean r42) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r2 == null) goto L14;
        com.larus.voicecall.impl.component.bottom.b r5 = (com.larus.voicecall.impl.component.bottom.b) this.s.getValue();
        if (r5 == null) goto L11;
        VoiceCallBottomLayout r6 = r5.BT();
        if (r6 == null) goto L11;
        int r7 = VoiceCallBottomLayout.D;
        if (r6.u6(r2, r42, 2131900503) != true) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        return;
    L11:
        r3 = false;
    L14:
        BotModel r4 = m3().H0;
        if (r4 == null) goto L19;
        Map r8 = r4.getCameraTabConfigMap();
        if (r8 == null) goto L19;
        CameraTabConfig r9 = (CameraTabConfig) r8.get("all_camera");
    L20:
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("TAKE_PHOTO_PAGE_ENTER_ANI", String.valueOf(2130772415)), TuplesKt.to("PHOTO_RESULT_SURE_PAGE_EXIT_ANI", String.valueOf(2130772393)), TuplesKt.to("TAKE_PHOTO_PAGE_EXIT_ANI", String.valueOf(2130772393))});
        Pair[] r10 = new Pair[4];
        JSONObject r11 = new JSONObject();
        r11.put("conversation_id", ((h88.a) m3()).f);
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r12 = RealtimeCallUtil.l;
        if (r12 == null) goto L26;
        SceneModel r13 = r12.a;
        if (r13 == null) goto L26;
        String r14 = r13.getKey();
        if (r14 == null) goto L26;
    L27:
        r11.put("call_scene", r14);
        r11.put("is_subtitles_mode", RealtimeCallUtil.z ? 1 : 0);
        r11.put("call_id", ((RealtimeCallParam) this.p.getValue()).e);
        r11.put("room_id", ((RealtimeCallParam) this.p.getValue()).d);
        r11.put("if_call", 1);
        r11.put("bot_id", ((h88.a) m3()).d);
        r11.put("demo", "demo");
        String r16 = ((RealtimeCallParam) this.p.getValue()).p.i;
        String r17 = NameKeys.UnloadStrategy_No_Strategy;
        if (r16 != null) goto L30;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L30:
        r11.put("call_enter_method", r16);
        if (((h88.a) m3()).k0 == false) goto L33;
        String r18 = "1";
    L34:
        r11.put("is_continuous_speak", r18);
        Unit r19 = Unit.INSTANCE;
        r10[0] = TuplesKt.to("general_params", r11.toString());
        r10[1] = TuplesKt.to("if_call", 1);
        r10[2] = TuplesKt.to("realtime_key", Long.valueOf(SystemClock.elapsedRealtime()));
        String r20 = ((RealtimeCallParam) this.p.getValue()).p.i;
        if (r20 == null) goto L38;
        r17 = r20;
    L38:
        r10[3] = TuplesKt.to("call_enter_method", r17);
        HashMap r110 = MapsKt.hashMapOf(r10);
        if (r9 == null) goto L41;
        String r111 = r9.getCameraNameUrl();
    L42:
        if (r9 == null) goto L44;
        String r112 = r9.getCameraName();
    L45:
        hx8.a r21 = new hx8.a("realtime_call", "CAPTURE_MODE_PHOTO", null, r110, r15, null, r111, r112, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073741604);
        IFlowCamera r22 = B3();
        if (r22 == null) goto L49;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r22.r(com.larus.ui.arch.component.internal.attach.a.b(this, this), r21, null);
        return;
    L49:
        return;
    L44:
        r112 = null;
        goto L45
    L41:
        r111 = null;
        goto L42
    L33:
        r18 = "0";
    L26:
        r14 = "other";
    L19:
        r9 = null;
        goto L20
    }

    public final void G3(x3a.a r18) {
        Intrinsics.checkNotNullParameter(r18, "pic");
        String r1 = r18.a.e;
        String r7 = r18.e;
        if (r1 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (StringsKt.isBlank(r1) == true) goto L97;
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L23
        r2.put("width", Integer.valueOf(r18.b));     // Catch: Throwable -> L23
        r2.put("height", Integer.valueOf(r18.c));     // Catch: Throwable -> L23
        r2.put("data_source", Integer.valueOf(r18.d));     // Catch: Throwable -> L23
        r2.put("key", r18.e);     // Catch: Throwable -> L23
        String r6 = r18.a.d;     // Catch: Throwable -> L23
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r6 != null) goto L17;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        r2.put("file_type", r6);     // Catch: Throwable -> L23
        r2.put("file_size", Long.valueOf(r18.a.c));     // Catch: Throwable -> L23
        String r9 = r18.a.b;     // Catch: Throwable -> L23
        if (r9 == null) goto L21;
        r8 = r9;
    L21:
        r2.put("file_name", r8);     // Catch: Throwable -> L23
    L25:
        LinkedHashMap r10 = r2;
        int r3 = RealtimeMobUtil.a;
        RealtimeMobUtil.Business r4 = RealtimeMobUtil.Business.realtime;
        List r5 = CollectionsKt.listOf(r7);
        Map r11 = MapsKt.toMap(r10);
        Intrinsics.checkNotNullParameter(r4, "business");
        Intrinsics.checkNotNullParameter(r5, "picKeyList");
        Intrinsics.checkNotNullParameter(r11, "extra");
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        JSONObject r13 = new JSONObject();
        r13.put("business", r4);
        r13.put("pic_key_list", r5);
        r13.put("pic_num", 1);
        Iterator r14 = r11.entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put((String) r15.getKey(), r15.getValue());
        goto L27
    L29:
        Unit r16 = Unit.INSTANCE;
        r12.reportEvent("upload_photo", r13);
        long r17 = SystemClock.elapsedRealtime();
        int r19 = com.larus.bmhome.upload.audio.m.a;
        Intrinsics.checkNotNullParameter(r1, "imagePath");
        FileInputStream r110 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r1));     // Catch: Throwable -> L48 Exception -> L51
    L91:
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();     // Catch: Throwable -> L44 Exception -> L46
    L78:
        byte[] r20 = new byte[1024];     // Catch: Exception -> L42 Throwable -> L66
        Ref.IntRef r112 = new Ref.IntRef();     // Catch: Exception -> L42 Throwable -> L66
    L34:
        int r113 = r110.read(r20);     // Catch: Exception -> L42 Throwable -> L66
        r112.element = r113;     // Catch: Exception -> L42 Throwable -> L66
        if (r113 == (-1)) goto L37;
        r111.write(r20, 0, r113);     // Catch: Exception -> L42 Throwable -> L66
        goto L34
    L37:
        byte[] r114 = r111.toByteArray();     // Catch: Exception -> L42 Throwable -> L66
        r110.close();     // Catch: Exception -> L40
        r111.close();     // Catch: Exception -> L40
    L64:
        com.larus.bmhome.upload.audio.b r21 = new com.larus.bmhome.upload.audio.b(r7, Long.valueOf(System.currentTimeMillis() / ((long) 1000)), Base64.encodeToString(r114, 0));
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getIO(), null, new RealtimePictureComponent$uploadImg$1(this, r21, r18, r17, r7, r10, null), 2, null);
        return;
    L40:
        e = move-exception;
        FLogger.a.e("LocalFileUtil", "getImageBytes err2. path=" + r1 + " err=" + e);
    L42:
        e = e;
    L54:
        FLogger.a.e("LocalFileUtil", "getImageBytes err1. path=" + r1 + " err=" + e);     // Catch: Throwable -> L66
        if (r110 != null) goto L84;
    L59:
        if (r111 == null) goto L63;
        r111.close();     // Catch: Exception -> L57
    L57:
        e = move-exception;
        FLogger.a.e("LocalFileUtil", "getImageBytes err2. path=" + r1 + " err=" + e);
    L63:
        r114 = null;
        goto L64
    L84:
        r110.close();     // Catch: Exception -> L57
    L66:
        th = move-exception;
        FileInputStream r115 = r110;
        Throwable r22 = th;
        ByteArrayOutputStream r116 = r111;
    L68:
        if (r115 != null) goto L80;
    L72:
        if (r116 == null) goto L95;
        r116.close();     // Catch: Exception -> L70
        throw r22;
    L70:
        e = move-exception;
        FLogger.a.e("LocalFileUtil", "getImageBytes err2. path=" + r1 + " err=" + e);
        throw r22;
    L95:
        throw r22;
    L80:
        r115.close();     // Catch: Exception -> L70
    L46:
        e = e;
    L53:
        r111 = null;
    L44:
        th = move-exception;
        r22 = th;
        r115 = r110;
    L50:
        r116 = null;
    L51:
        e = e;
        r110 = null;
    L48:
        th = move-exception;
        r22 = th;
        r115 = null;
    L23:
        th = move-exception;
        FLogger.a.e("RealtimePictureComponent", "generateMob err=" + th);
        r2 = new LinkedHashMap();
        goto L25
    L97:
        return;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.picture.a
    public final l0 ij(String r45) {
        Intrinsics.checkNotNullParameter(r45, "txt");
        if (z2.a.realtimeCallUseTwoLineStyle() == true) goto L5;
        return null;
    L5:
        RealtimeCallUtil r1 = RealtimeCallUtil.a;
        boolean r5 = ((h88.b) ((e3a.b) this.o.getValue())).d;
        r1.getClass();
        if (RealtimeCallUtil.e(r5) == false) goto L32;
        if (((h88.a) m3()).T == true) goto L32;
        com.larus.voicecall.impl.component.scene.a r2 = (com.larus.voicecall.impl.component.scene.a) this.v.getValue();
        boolean r18 = false;
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L25;
        j3a.a r4 = z3();
        if (r4 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L25;
        r18 = true;
        goto L25
    L20:
        if (r4.su() != true) goto L22;
        r6 = true;
    L25:
        boolean r7 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L28;
        Integer r43 = -1;
    L30:
        return new l0(7, 0, r45, null, null, null, null, null, null, false, false, null, 2131241790, null, false, r18, r43, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -200710, 127);
    L28:
        r43 = null;
        goto L30
    L13:
        if (r2.oY() != true) goto L15;
        r3 = true;
    L32:
        return null;
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        g3a.a r3 = p3();
        if (r3 == null) goto L8;
        RealtimeCallSubtitleLayout r4 = r3.ol();
        if (r4 == null) goto L9;
        r4.setSubtitleImgRetryCallback(new g(this));
        return;
    L9:
        return;
    }

    public final void E3(String r4, x3a.a r5) {
        FLogger.a.e("RealtimePictureComponent", "runAlphaAni reason=" + r4);
        g3a.a r6 = p3();
        if (r6 == null) goto L5;
        SimpleDraweeView r7 = r6.kj();
    L6:
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setAnimationListener(new w(r7, this, r5));
        r0.setDuration(300);
        g3a.a r8 = p3();
        if (r8 == null) goto L12;
        SimpleDraweeView r9 = r8.kj();
        if (r9 == null) goto L13;
        r9.startAnimation(r0);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.voicecall.impl.component.picture.b
    public final l0 KP(int r44, String r45) {
        Intrinsics.checkNotNullParameter(r45, "txt");
        RealtimeCallUtil r1 = RealtimeCallUtil.a;
        boolean r2 = ((h88.b) ((e3a.b) this.o.getValue())).d;
        r1.getClass();
        if (RealtimeCallUtil.e(r2) == true) goto L5;
        return null;
    L5:
        if (((h88.a) m3()).T == true) goto L29;
        com.larus.voicecall.impl.component.scene.a r3 = (com.larus.voicecall.impl.component.scene.a) this.v.getValue();
        boolean r18 = false;
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L21;
        j3a.a r5 = z3();
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == true) goto L21;
        r18 = true;
        goto L21
    L16:
        if (r5.su() != true) goto L18;
        r6 = true;
    L21:
        boolean r7 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L24;
        Integer r19 = -1;
    L26:
        return new l0(r44, 0, r45, null, null, null, null, null, null, false, false, null, 2131241717, null, false, r18, r19, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -200710, 127);
    L24:
        r19 = null;
        goto L26
    L9:
        if (r3.oY() != true) goto L11;
        r4 = true;
        goto L12
    L29:
        return null;
    }

    public static final Object h3(RealtimePictureComponent r6, x3a.a r7, OutputParam r8, Continuation r9) {
        r6.getClass();
        if ((r9 instanceof RealtimePictureComponent$startExecAni$1) == false) goto L7;
        RealtimePictureComponent$startExecAni$1 r0 = (RealtimePictureComponent$startExecAni$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (OutputParam) r0.L$1;
        r7 = (x3a.a) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        RealtimePictureComponent$startExecAni$2 r4 = new RealtimePictureComponent$startExecAni$2(r6, r7, r8, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r11, r4, r0) != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.label = 1;
        if (DelayKt.delay(600, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new RealtimePictureComponent$startExecAni$1(r6, r9);
        goto L8
    }
}

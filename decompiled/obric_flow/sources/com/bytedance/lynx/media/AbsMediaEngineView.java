package com.bytedance.lynx.media;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.lynx.media.e;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType;
import com.lynx.animax.i;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.b0;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.g;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ko.p;
import ko.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wn.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u0005:\u0001NJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0007¢\u0006\u0004\b$\u0010\nJ\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020%H\u0007¢\u0006\u0004\b*\u0010(J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0019H\u0007¢\u0006\u0004\b,\u0010\u001cJ\u0017\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0019H\u0007¢\u0006\u0004\b-\u0010\u001cJ\u0017\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\nJ\u0017\u00100\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0006H\u0007¢\u0006\u0004\b0\u0010\nJ\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0006H\u0007¢\u0006\u0004\b2\u0010\nJ\u0019\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b4\u0010\nJ\u0019\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b6\u0010\nJ\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0019H\u0007¢\u0006\u0004\b8\u0010\u001cJ\u0019\u0010:\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b:\u0010\u0016J\u0017\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020%H\u0007¢\u0006\u0004\b<\u0010(J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020%H\u0007¢\u0006\u0004\b>\u0010(J\u0019\u0010@\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b@\u0010\nJ\u001f\u0010D\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bF\u0010EJ\u001f\u0010G\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bG\u0010EJ\u001f\u0010H\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bH\u0010EJ\u001f\u0010I\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bI\u0010EJ\u001f\u0010J\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bJ\u0010EJ\u0017\u0010K\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bM\u0010L¨\u0006O"}, d2 = {"Lcom/bytedance/lynx/media/AbsMediaEngineView;", "Lcom/bytedance/lynx/media/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/g;", "", "", "vid", "", "setVid", "(Ljava/lang/String;)V", "domain", "setDomain", "token", "setToken", "playUrl", "setPlayUrl", "videoModel", "setVideoModel", "Lcom/lynx/react/bridge/ReadableMap;", "headers", "setHeaders", "(Lcom/lynx/react/bridge/ReadableMap;)V", "prop", "setForcePreparePlayAfterSurfaceAvailable", "", "rate", "setRate", "(I)V", "", "speed", "setSpeed", "(F)V", "volume", "setVolume", "playerType", "setPlayerType", "", "muted", "setMuted", "(Z)V", "loop", "setLoop", "initTime", "setInitTime", "setDeprecatedInitTime", "objectFit", "setObjectFit", "setDeprecatedObjectFit", "preloadKey", "setPreloadKey", "tag", "setVideoTag", "subTag", "setVideoSubTag", "value", "setCacheSize", "options", "setPlayerOption", "pauseOnHide", "setPauseOnHide", "autoPrepare", "setAutoPrepare", "resolution", "setResolution", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "play", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "pause", "stop", "seek", MessageIndication.STATUS_PREPARE, "getDuration", "requestFocus", "(Lcom/lynx/react/bridge/Callback;)V", "releaseFocus", "MediaSrcType", "x-element-media_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsMediaEngineView<T extends e> extends UISimpleView<T> implements g {
    public boolean A;
    public boolean B;
    public final Lazy C;
    public final a D;
    public LinkedHashMap E;
    public volatile boolean F;
    public MediaSrcType G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6787c;
    public String d;
    public String e;
    public String f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6794n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f6795o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6796p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap f6797q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ReadableMap f6798r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f6799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f6802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f6803x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile int f6804y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h f6805z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/lynx/media/AbsMediaEngineView$MediaSrcType;", "", "x-element-media_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum MediaSrcType extends Enum<MediaSrcType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MediaSrcType f6806a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final MediaSrcType f6807b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final MediaSrcType f6808c = null;
        public static final MediaSrcType d = null;
        public static final /* synthetic */ MediaSrcType[] e = null;

        static {
            MediaSrcType r5 = new MediaSrcType("VIDEO_MODEL", 0);
            f6806a = r5;
            MediaSrcType r10 = new MediaSrcType("VIDEO_ID", 1);
            f6807b = r10;
            MediaSrcType r11 = new MediaSrcType("PLAY_URL", 2);
            f6808c = r11;
            MediaSrcType r12 = new MediaSrcType("UNSUPPORTED", 3);
            d = r12;
            e = new MediaSrcType[]{r5, r10, r11, r12};
        }

        public MediaSrcType(String r5, int r10) {
            super(r5, r10);
        }

        public static MediaSrcType valueOf(String r5) {
            return (MediaSrcType) Enum.valueOf(MediaSrcType.class, r5);
        }

        public static MediaSrcType[] values() {
            return (MediaSrcType[]) e.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.lynx.media.a] */
    public AbsMediaEngineView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f6785a = "AbsMediaEngineView";
        this.f6786b = "";
        this.f6787c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.f6790j = "contain";
        this.f6791k = "x-media-engine";
        this.f6792l = "";
        this.f6794n = true;
        this.f6795o = "";
        this.s = "false";
        this.f6799t = 1.0f;
        this.f6800u = 1.0f;
        this.f6801v = 167;
        this.f6802w = "default";
        this.f6803x = "auto";
        this.C = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, AbsMediaEngineView$mResourceService$2.f6809a);
        this.D = new a(this);
        this.G = MediaSrcType.d;
    }

    public static Pair b(String r5) {
        if (StringsKt.P(r5, "@encode(") == true) goto L5;
        return null;
    L5:
        if (StringsKt.k(r5, ")") == false) goto L39;
        String r10 = StringsKt.B(StringsKt.A(r5, "@encode("), ")");
        int r11 = StringsKt.u(r10, ",");
        if (r11 == (-1)) goto L40;
        String r12 = r10.substring(0, r11);
        String r13 = StringsKt.trim(r10.substring(r11 + 1)).toString();
        int r14 = r13.hashCode();
        if (r14 == 102) goto L33;
        if (r14 == 105) goto L28;
        if (r14 == 108) goto L23;
        if (r14 == 90613) goto L18;
        return null;
    L18:
        if (r13.equals("[c]") == true) goto L21;
        return null;
    L21:
        return new Pair(r12, IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType.f6823a);
    L23:
        if (r13.equals("l") == true) goto L26;
        return null;
    L26:
        return new Pair(Long.valueOf(Long.parseLong(r12)), IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType.f6825c);
    L28:
        if (r13.equals("i") == true) goto L31;
        return null;
    L31:
        return new Pair(Integer.valueOf(Integer.parseInt(r12)), IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType.f6824b);
    L33:
        if (r13.equals("f") == true) goto L36;
        return null;
    L36:
        return new Pair(Float.valueOf(Float.parseFloat(r12)), IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType.d);
    L40:
        return null;
    L39:
        return null;
    }

    @Override // com.lynx.tasm.behavior.g
    public final void a() {
        if (this.f6793m == false) goto L6;
        ((e) this.mView).b(null);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(y0 r14) {
        TraceEvent.c("AbsMediaEngineView.afterPropsUpdated");
        super.afterPropsUpdated(r14);
        ReadableMapKeySetIterator r10 = null;
        if (this.B == false) goto L59;
        ((e) this.mView).d();
        LinkedHashMap r15 = new LinkedHashMap();
        if (this.e.length() <= 0) goto L8;
        r15.put("video_model", this.e);
        this.G = MediaSrcType.f6806a;
    L20:
        if (this.G != MediaSrcType.d) goto L23;
        i("error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("errorMsg", "unsupported src type"), TuplesKt.to("errorCode", -1)}));
        this.B = false;
        return;
    L23:
        r15.put("muted", Boolean.valueOf(this.g));
        r15.put("loop", Boolean.valueOf(this.f6788h));
        r15.put("inittime", Integer.valueOf(this.f6789i));
        r15.put("objectfit", this.f6790j);
        String r5 = this.f6791k;
        if (r5 == null) goto L26;
        r15.put("tag", r5);
    L26:
        String r11 = this.f6792l;
        if (r11 == null) goto L29;
        r15.put("sub_tag", r11);
    L29:
        r15.put("preload-key", this.f6795o);
        r15.put("cache-size", Integer.valueOf(this.f6796p));
        r15.put("auto_prepare", Boolean.valueOf(this.f6794n));
        r15.put("volume", Float.valueOf(this.f6799t));
        r15.put("speed", Float.valueOf(this.f6800u));
        ReadableMap r12 = this.f6798r;
        if (r12 == null) goto L32;
        r15.put("headers", r12);
    L32:
        LinkedHashMap r13 = new LinkedHashMap();
        String r16 = this.s;
        if (r16 == null) goto L35;
        r13.put("experimental-force-prepare-play-after-surface-available", r16);
    L35:
        r15.put("experimental-props", r13);
        r15.put("progress_update_interval", Integer.valueOf(this.f6801v));
        r15.put("player-type", this.f6802w);
        r15.put("resolution", this.f6803x);
        this.E = r15;
        if (getSkipRedirection() == false) goto L38;
    L58:
        this.F = true;
        j(null, null);
        this.B = false;
        i("redirect", new HashMap());
    L113:
        TraceEvent.a(0, "AbsMediaEngineView.afterPropsUpdated");
        return;
    L38:
        if (this.G != MediaSrcType.f6808c) goto L58;
        this.F = false;
        Object r17 = r15.get("play_url");
        if (r17 == null) goto L57;
        String r18 = (String) r17;
        if (this.A == true) goto L48;
        if (((ko.e) this.C.getValue()) != null) goto L46;
        LynxError r19 = new LynxError(32103, "AbsMediaEngineView can't get resource service.", "An error occurred while attempting to get ILynxResourceService. You can call LynxServiceCenter.register(ILynxResourceService::class.java, YourResourceServiceClass) to fix this. If you are unable to resolve this issue, you can seek help from the client RD.", "error");
        getLynxContext().b(r19);
    L54:
        this.B = false;
        return;
    L46:
        TraceEvent.c("AbsMediaEngineView.legacyAsyncFetchResource");
        p r20 = new p();
        this.f6804y = r18.hashCode();
        int r21 = this.f6804y;
        ko.e r22 = (ko.e) this.C.getValue();
        Intrinsics.checkNotNull(r22);
        r22.fetchResourceAsync(r18, r20, new c(r21, this));
        TraceEvent.a(0, "AbsMediaEngineView.legacyAsyncFetchResource");
        goto L54
    L48:
        if (this.f6805z != null) goto L50;
        LynxError r110 = new LynxError(30301, "AbsMediaEngineView can't get generic resource fetcher.", "An error occurred while attempting to get LynxGenericResourceFetcher. You can request Hybrid Container team to register such instance to fix this. If you are unable to resolve this issue, you can seek help from the client RD.", "error");
        getLynxContext().b(r110);
        goto L54
    L50:
        TraceEvent.c("AbsMediaEngineView.genericAsyncFetchResource");
        this.f6804y = r18.hashCode();
        int r23 = this.f6804y;
        h r24 = this.f6805z;
        if (r24 == null) goto L53;
        int r25 = 8;
        r24.g(new r(r25, r18, LynxResourceRequest$LynxResourceType.d), new b(r23, this));
    L53:
        TraceEvent.a(0, "AbsMediaEngineView.genericAsyncFetchResource");
        goto L54
    L57:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L8:
        if (this.f6786b.length() <= 0) goto L17;
        r15.put("video_id", this.f6786b);
        if (this.d.length() <= 0) goto L13;
        r15.put("domain", this.d);
    L13:
        if (this.f6787c.length() <= 0) goto L15;
        r15.put("token", this.f6787c);
    L15:
        this.G = MediaSrcType.f6807b;
        goto L20
    L17:
        if (this.f.length() <= 0) goto L20;
        r15.put("play_url", this.f);
        this.G = MediaSrcType.f6808c;
        goto L20
    L59:
        if (r14 == null) goto L63;
        ReadableMap r111 = r14.f10815a;
        if (r111 == null) goto L63;
        r10 = r111.keySetIterator();
    L63:
        if (r10 == null) goto L113;
        if (r10.hasNextKey() == false) goto L113;
        String r112 = r10.nextKey();
        if (r112 == null) goto L63;
        int r26 = r112.hashCode();
        if (r26 != (-1600030548)) goto L71;
        if (r112.equals("resolution") == false) goto L63;
        if (this.F == false) goto L109;
        ((e) this.mView).setResolution(this.f6803x);
        goto L63
    L109:
        LinkedHashMap r113 = this.E;
        if (r113 == null) goto L63;
        r113.put("resolution", this.f6803x);
        goto L63
    L71:
        if (r26 != 3327652) goto L73;
        if (r112.equals("loop") == false) goto L63;
        if (this.F == false) goto L100;
        ((e) this.mView).setLoop(this.f6788h);
        goto L63
    L100:
        LinkedHashMap r114 = this.E;
        if (r114 == null) goto L63;
        r114.put("loop", Boolean.valueOf(this.f6788h));
        goto L63
    L73:
        if (r26 != 104264043) goto L75;
        if (r112.equals("muted") == false) goto L63;
        if (this.F == false) goto L91;
        ((e) this.mView).setMuted(this.g);
        goto L63
    L91:
        LinkedHashMap r115 = this.E;
        if (r115 == null) goto L63;
        r115.put("muted", Boolean.valueOf(this.g));
        goto L63
    L75:
        if (r26 != 109641799) goto L63;
        if (r112.equals("speed") == false) goto L63;
        if (this.F == false) goto L82;
        ((e) this.mView).setSpeed(this.f6800u);
        goto L63
    L82:
        LinkedHashMap r116 = this.E;
        if (r116 == null) goto L63;
        r116.put("speed", Float.valueOf(this.f6800u));
        goto L63
    }

    @Override // com.lynx.tasm.behavior.g
    public final void c() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        e r5 = (e) this.mView;
        r5.getClass();
        LynxLog.b(2, "LynxMediaEngineBaseView", "trigger release");
        sf.a r10 = r5.f6820a;
        if (r10 == null) goto L11;
        uf.b r11 = ((sf.d) r10).f21895b;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.c() == false) goto L13;
        r11.f22339b.m();
        return;
    L13:
        return;
    }

    @f0
    public final void getDuration(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.F == true) goto L7;
        r10.invoke(new Object[]{7, "The url is not redirected! Please try again after redirecting."});
        return;
    L7:
        if (((e) this.mView).c() == true) goto L10;
        r10.invoke(new Object[]{7, "The player is not prepared! Please invoke prepare operation first"});
        return;
    L10:
        LynxLog.b(2, this.f6785a, getSign() + " invoke getDuration");
        e r11 = (e) this.mView;
        r11.getClass();
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke getDuration");
        sf.a r12 = r11.f6820a;
        if (r12 == null) goto L23;
        sf.d r13 = (sf.d) r12;
        int r14 = -1;
        if (r13.f21895b == null) goto L16;
        JavaOnlyMap r15 = new JavaOnlyMap();
        r15.put("errorCode", -1);
        r15.put("errorMsg", "player is not prepared");
        r10.invoke(new Object[]{7, r15});
        return;
    L16:
        JavaOnlyMap r16 = new JavaOnlyMap();
        uf.b r17 = r13.f21895b;
        if (r17 == null) goto L19;
        r14 = r17.getDuration();
    L19:
        r16.put("duration", Integer.valueOf(r14));
        r10.invoke(new Object[]{0, r16});
        uf.b r18 = r13.f21895b;
        if (r18 == null) goto L24;
        r18.getDuration();
        return;
    L24:
        return;
    }

    public final void i(String r5, HashMap r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "data");
        LynxContext r11 = getLynxContext();
        if (r11 == null) goto L13;
        com.lynx.tasm.r r12 = r11.g;
        if (r12 == null) goto L14;
        i r13 = new i(getSign(), r5);
        Iterator r14 = r10.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.a((String) r15.getKey(), r15.getValue());
        goto L8
    L10:
        r12.b(r13);
        return;
    L14:
        return;
    }

    public final void j(Function0 r5, Function0 r10) {
        if (r5 == null) goto L4;
        ((AbsMediaEngineView$onAsyncFetchResourceSuccess$1) r5).invoke();
    L4:
        LinkedHashMap r11 = this.E;
        if (r11 == null) goto L7;
        ((e) this.mView).setPlayParams(MapsKt.toMap(r11));
    L7:
        rf.b r12 = new rf.b(this);
        ((e) this.mView).setVideoEngineCallback(r12);
        ((e) this.mView).setVideoEngineInfoListener(r12);
        ((e) this.mView).setMediaVideoEngineCallback(r12);
        HashMap r13 = this.f6797q;
        if (r13 == null) goto L10;
        ((e) this.mView).setPlayOptions(r13);
    L10:
        if (r10 == null) goto L13;
        ((AbsMediaEngineView$onAsyncFetchResourceFailure$1) r10).invoke();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeRemoved() {
        super.onNodeRemoved();
        ((e) this.mView).b(null);
    }

    @f0
    public final void pause(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        LynxLog.b(2, this.f6785a, getSign() + " invoke pause");
        e r11 = (e) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        r11.b(new g8.g(r10, 5));
    }

    @f0
    public final void play(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.F == true) goto L7;
        r10.invoke(new Object[]{7, "The url is not redirected! Please try again after redirecting."});
        return;
    L7:
        if (((e) this.mView).c() == true) goto L10;
        r10.invoke(new Object[]{7, "The player is not prepared! Please invoke prepare operation first"});
        return;
    L10:
        LynxLog.b(2, this.f6785a, getSign() + " invoke play");
        e r11 = (e) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        g8.g r12 = new g8.g(r10, 5);
        sf.a r13 = r11.f6820a;
        if (r13 == null) goto L14;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke play");
        r13.b(r12);
        return;
    }

    @f0
    public final void prepare(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.F == true) goto L6;
        r10.invoke(new Object[]{7, "The url is not redirected! Please try again after redirecting."});
        return;
    L6:
        LynxLog.b(2, this.f6785a, getSign() + " invoke prepare");
        e r11 = (e) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        r11.f(new g8.g(r10, 5));
    }

    @f0
    public final void releaseFocus(Callback r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        LynxLog.b(2, this.f6785a, getSign() + " invoke releaseFocus");
        JavaOnlyMap r10 = new JavaOnlyMap();
        ((e) this.mView).a(this.D);
        r5.invoke(new Object[]{0, r10});
    }

    @f0
    public final void requestFocus(Callback r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        LynxLog.b(2, this.f6785a, getSign() + " invoke requestFocus");
        JavaOnlyMap r10 = new JavaOnlyMap();
        ((e) this.mView).e(this.D);
        r5.invoke(new Object[]{0, r10});
    }

    @f0
    public final void seek(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.F == true) goto L7;
        r10.invoke(new Object[]{7, "The url is not redirected! Please try again after redirecting."});
        return;
    L7:
        if (((e) this.mView).c() == true) goto L10;
        r10.invoke(new Object[]{7, "The player is not prepared! Please invoke prepare operation first"});
        return;
    L10:
        LynxLog.b(2, this.f6785a, getSign() + " invoke seek");
        r5.getLong("position");
        if (r5.hasKey("play") == false) goto L13;
        r5.getBoolean("play");
    L13:
        e r11 = (e) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        g8.g r12 = new g8.g(r10, 5);
        sf.a r13 = r11.f6820a;
        if (r13 == null) goto L17;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke seek");
        r13.c(r12);
        return;
    }

    @c0(name = "auto-prepare")
    public final void setAutoPrepare(boolean r5) {
        this.f6794n = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set autoPrepare " + r5);
    }

    @c0(name = "cache-size")
    public final void setCacheSize(int r5) {
        this.f6796p = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set CacheSize " + r5);
    }

    @c0(name = "inittime")
    public final void setDeprecatedInitTime(int r5) {
        this.f6789i = r5;
    }

    @c0(name = "objectfit")
    public final void setDeprecatedObjectFit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "objectFit");
        this.f6790j = r5;
    }

    @c0(name = "domain")
    public final void setDomain(String r5) {
        if (r5 == null) goto L5;
        this.B = !Intrinsics.areEqual(this.d, r5);
        this.d = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set domain " + r5);
        return;
    }

    @c0(name = "experimental-force-prepare-play-after-surface-available")
    public final void setForcePreparePlayAfterSurfaceAvailable(String r5) {
        this.s = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set force_prepare_play_after_surface_available prop");
    }

    @c0(name = "headers")
    public final void setHeaders(ReadableMap r5) {
        Intrinsics.checkNotNullParameter(r5, "headers");
        this.f6798r = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set headers");
    }

    @c0(name = "initial-time")
    public final void setInitTime(int r5) {
        this.f6789i = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set inittime " + r5);
    }

    @c0(name = "loop")
    public final void setLoop(boolean r5) {
        this.f6788h = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set loop " + r5);
    }

    @c0(name = "muted")
    public final void setMuted(boolean r5) {
        this.g = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set muted " + r5);
    }

    @c0(name = "object-fit")
    public final void setObjectFit(String r5) {
        Intrinsics.checkNotNullParameter(r5, "objectFit");
        this.f6790j = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set objectFit " + r5);
    }

    @c0(name = "pause-on-hide")
    public final void setPauseOnHide(boolean r5) {
        this.f6793m = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set pauseOnHide " + r5);
    }

    @c0(name = "play-url")
    public final void setPlayUrl(String r5) {
        if (r5 == null) goto L5;
        this.B = !Intrinsics.areEqual(this.f, r5);
        this.f = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set playUrl " + r5);
        return;
    }

    @c0(name = "player-option")
    public final void setPlayerOption(ReadableMap r10) {
        this.f6797q = new HashMap();
        if (r10 == null) goto L14;
        ReadableMapKeySetIterator r5 = r10.keySetIterator();
        if (r5 == null) goto L14;
    L7:
        if (r5.hasNextKey() == false) goto L14;
        String r11 = r5.nextKey();
        Pair r12 = b(r10.getString(r11));     // Catch: NumberFormatException -> L13
        if (r12 == null) goto L7;
        HashMap r13 = this.f6797q;     // Catch: NumberFormatException -> L13
        Intrinsics.checkNotNull(r13);     // Catch: NumberFormatException -> L13
        Pair r14 = (Pair) r13.put(Integer.valueOf(Integer.parseInt(r11)), r12);     // Catch: NumberFormatException -> L13
    L13:
        getLynxContext().b(new LynxError(990100, com.lynx.tasm.utils.g.d("Failed to parse the ", r11, " field in player-option during the attempt. "), "Please check if the types match.", "error"));
    L14:
        LynxLog.b(2, this.f6785a, getSign() + " set playerOptions");
    }

    @c0(name = "player-type")
    public final void setPlayerType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "playerType");
        if (r5.length() <= 0) goto L6;
        this.f6802w = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set playerType " + r5);
        return;
    }

    @c0(name = "preload-key")
    public final void setPreloadKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, "preloadKey");
        this.f6795o = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set preloadKey " + r5);
    }

    @c0(name = "rate")
    public final void setRate(int r5) {
        this.f6801v = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set rate " + r5);
    }

    @c0(name = "resolution")
    public final void setResolution(String r5) {
        if (r5 == null) goto L5;
        this.f6803x = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set resolution " + r5);
        return;
    }

    @c0(name = "speed")
    public final void setSpeed(float r5) {
        LynxLog.b(2, this.f6785a, getSign() + " set speed " + r5);
        this.f6800u = r5;
    }

    @c0(name = "token")
    public final void setToken(String r5) {
        if (r5 == null) goto L5;
        this.f6787c = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set token " + r5);
        return;
    }

    @c0(name = "vid")
    public final void setVid(String r5) {
        if (r5 == null) goto L5;
        this.B = !Intrinsics.areEqual(this.f6786b, r5);
        this.f6786b = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set vid " + r5);
        return;
    }

    @c0(name = "video-model")
    public final void setVideoModel(String r5) {
        if (r5 == null) goto L5;
        this.B = !Intrinsics.areEqual(this.e, r5);
        this.e = r5;
        LynxLog.b(2, this.f6785a, getSign() + " set media model " + r5);
        return;
    }

    @c0(name = "sub-tag")
    public final void setVideoSubTag(String r5) {
        this.f6792l = r5;
        StringBuilder r10 = new StringBuilder();
        r10.append(getSign());
        r10.append(" set subTag ");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        com.lynx.tasm.behavior.ui.utils.e.i(r10, r5, 2, this.f6785a);
    }

    @c0(name = "tag")
    public final void setVideoTag(String r5) {
        this.f6791k = r5;
        StringBuilder r10 = new StringBuilder();
        r10.append(getSign());
        r10.append(" set tag ");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        com.lynx.tasm.behavior.ui.utils.e.i(r10, r5, 2, this.f6785a);
    }

    @c0(name = "volume")
    public final void setVolume(float r5) {
        LynxLog.b(2, this.f6785a, getSign() + " set volume " + r5);
        if (r5 >= 0.0f) goto L5;
        return;
    L5:
        if (r5 >= 1.0f) goto L9;
        this.f6799t = r5;
        return;
    }

    @f0
    public final void stop(ReadableMap r5, Callback r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        LynxLog.b(2, this.f6785a, getSign() + " invoke stop");
        e r11 = (e) this.mView;
        Intrinsics.checkNotNullParameter(r10, "callback");
        r11.g(new g8.g(r10, 5));
    }

    public static final void c(int r5, AbsMediaEngineView r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r5 != (-2)) goto L5;
        e r11 = (e) r10.mView;
        if (r11 == null) goto L26;
        r11.b(null);
        return;
    L26:
        return;
    L5:
        if (r5 != (-1)) goto L7;
        e r12 = (e) r10.mView;
        if (r12 == null) goto L25;
        r12.g(null);
        return;
    L25:
        return;
    L7:
        if (r5 != 1) goto L27;
        e r13 = (e) r10.mView;
        if (r13 == null) goto L23;
        sf.a r14 = r13.f6820a;
        if (r14 == null) goto L24;
        LynxLog.b(2, "LynxMediaEngineBaseView", "invoke play");
        r14.b(null);
        return;
    L24:
        return;
    L23:
        return;
    }
}

package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.EventsListener;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002!\"J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0007J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0017H\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LynxLottieView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/d;", "", "status", "", "setPlay", "", "enable", "setAutoPlay", "", "speed", "setSpeed", "progress", "setProgress", "objectFit", "setObjectFit", "setKeepLastFrame", "json", "setJson", "loop", "setLoop", "", "setRepeat", "src", "setSrc", "rate", "setUpdateRate", "startFrame", "setStartFrame", "endFrame", "setEndFrame", "a", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxLottieView extends LynxUI<LottieAnimationView> implements com.airbnb.lottie.d {
    public boolean a;
    public boolean b;
    public boolean c;
    public Set<String> d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public long k;
    public String l;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r1);
    }

    public static final class b {
    }

    public static final class c implements a {
        public final /* synthetic */ LynxLottieView a;
        public final /* synthetic */ Ref.ObjectRef b;

        @Override // com.bytedance.android.live.lynx.ui.LynxLottieView.a
        public final void onFailed() {
            String r0 = this.a.l;
        }

        @Override // com.bytedance.android.live.lynx.ui.LynxLottieView.a
        public final void onSuccess(Bitmap r2) {
            Ref.ObjectRef r0 = this.b;
            if (r2 == null) goto L5;
            Bitmap r3 = Bitmap.createBitmap(r2);
        L6:
            r0.element = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }

        public c(LynxLottieView r1, Ref.ObjectRef r2, String r3) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void onDetach() {
        super.onDetach();
        ((LynxUI) this).mView.removeAllAnimatorListeners();
        ((LynxUI) this).mView.removeAllUpdateListeners();
        ((LynxUI) this).mView.cancelAnimation();
    }

    public final void onPropsUpdated() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onPropsUpdated();
        if (this.b == true) goto L5;
    L9:
        this.i = false;
        return;
    L5:
        if (this.c == true) goto L9;
        if (this.i == true) goto L9;
        ((LynxUI) this).mView.playAnimation();
        goto L9
    }

    public LynxLottieView(LynxContext r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = true;
        this.b = true;
        this.e = 6;
        this.g = -1;
        this.j = -1;
        this.k = -1;
    }

    public static final /* synthetic */ LottieAnimationView M(LynxLottieView r0) {
        return ((LynxUI) r0).mView;
    }

    public final void O(String r7) {
        int r0 = StringsKt.lastIndexOf$default(r7, '/', 0, false, 6, null);
        if (r0 <= 0) goto L6;
        this.l = r7.substring(0, r0);
        ((LynxUI) this).mView.setImageAssetDelegate(this);
        return;
    }

    public final View createView(Context r4) {
        LottieAnimationView r0 = new LottieAnimationView(r4);
        r0.useHardwareAcceleration(true);
        r0.enableMergePathsForKitKatAndAbove(true);
        r0.addAnimatorListener(new j(this));
        r0.addAnimatorUpdateListener(new k(this));
        Field r1 = LottieAnimationView.class.getDeclaredField("autoPlay");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        r1.set(r0, Boolean.TRUE);     // Catch: Exception -> L5
    L4:
        return r0;
    }

    public final Bitmap q(com.airbnb.lottie.h r10) {
        if (TextUtils.isEmpty(this.l) == true) goto L46;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        String r2 = "/" + r10.e + "/" + r10.d;
        String r3 = this.l;
        Intrinsics.checkNotNull(r3);
        if (StringsKt.startsWith$default(r3, "file:/", false, 2, null) == false) goto L15;
        StringBuilder r4 = new StringBuilder();
        String r5 = this.l;
        Intrinsics.checkNotNull(r5);
        String r6 = this.l;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.length();
        if (r5 == null) goto L14;
        r4.append(r5.substring(6, r7));
        r4.append(r2);
        String r8 = r4.toString();
        if (new PolarisFileWrapper(r8).exists() == false) goto L11;
        r0.element = BitmapFactory.decodeFile(r8);
    L28:
        Object r9 = r0.element;
        if (((Bitmap) r9) != null) goto L49;
        return null;
    L49:
        Bitmap r11 = (Bitmap) r9;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L42
        if (r11.getWidth() != r10.a) goto L36;
        Bitmap r12 = (Bitmap) r0.element;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L42
        if (r12.getHeight() != r10.b) goto L36;
        return (Bitmap) r0.element;
    L36:
        Bitmap r13 = (Bitmap) r0.element;     // Catch: Exception -> L42
        if (r13 == null) goto L39;
        Bitmap r14 = Bitmap.createScaledBitmap(r13, r10.a, r10.b, false);     // Catch: Exception -> L42
    L40:
        Bitmap r1 = (Bitmap) r0.element;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L42
        r1.recycle();     // Catch: Exception -> L42
        return r14;
    L39:
        r14 = null;
    L42:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        return null;
    L11:
        return null;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L15:
        String r15 = this.l;
        Intrinsics.checkNotNull(r15);
        if (StringsKt.startsWith$default(r15, "http://", false, 2, null) == true) goto L19;
        String r16 = this.l;
        Intrinsics.checkNotNull(r16);
        if (StringsKt.startsWith$default(r16, "https://", false, 2, null) == false) goto L28;
    L19:
        String r17 = Intrinsics.stringPlus(this.l, r2);
        c r18 = new c(this, r0, r17);
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r18, "callback");
        DataSource r19 = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r17, false))).build(), "tt-lottie");
        if (r19 != null) goto L22;
        r18.onFailed();
        goto L28
    L22:
        CountDownLatch r20 = new CountDownLatch(1);
        l r21 = new l(r18, r20, r19);
        r19.subscribe(r21, CallerThreadExecutor.getInstance());
    L27:
        r21.onFailure(null);
        goto L28
    L24:
        if (r20.await(3, TimeUnit.SECONDS) == true) goto L28;
        r21.onFailure(null);     // Catch: InterruptedException -> L27
        goto L28
    L46:
        return null;
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r1) {
        this.b = r1;
    }

    @LynxProp(defaultInt = -1, name = "endframe")
    public final void setEndFrame(int r3) {
        if (r3 >= 0) goto L4;
        ((LynxUI) this).mView.setMaxFrame(Integer.MAX_VALUE);
    L4:
        ((LynxUI) this).mView.setMaxFrame(r3);
    }

    public final void setEvents(Map<String, EventsListener> r1) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.setEvents(r1);
        if (r1 == null) goto L5;
        Set<String> r2 = r1.keySet();
    L6:
        this.d = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @LynxProp(name = "json")
    public final void setJson(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L19;
        ((LynxUI) this).mView.setAnimationFromJson(r5, null);
        if (this.c == false) goto L13;
    L16:
        ((LynxUI) this).mView.cancelAnimation();
    L17:
        this.c = false;
        this.b = true;
        return;
    L13:
        if (this.b == false) goto L16;
        ((LynxUI) this).mView.playAnimation();
        goto L17
    L19:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "keeplastframe")
    public final void setKeepLastFrame(boolean r1) {
        this.a = r1;
    }

    @LynxProp(defaultBoolean = BuildConfig.DEBUG, name = "loop")
    public final void setLoop(boolean r2) {
        if (r2 == false) goto L4;
        ((LynxUI) this).mView.setRepeatCount(-1);
        return;
    L4:
        ((LynxUI) this).mView.setRepeatCount(0);
    }

    @LynxProp(name = "objectfit")
    public final void setObjectFit(String r3) {
        Intrinsics.checkNotNullParameter(r3, "objectFit");
        int r0 = r3.hashCode();
        if (r0 == 94852023) goto L11;
        if (r0 == 951526612) goto L8;
    L13:
        ImageView.ScaleType r4 = ImageView.ScaleType.CENTER;
    L14:
        ((LynxUI) this).mView.setScaleType(r4);
        return;
    L8:
        if (r3.equals("contain") == false) goto L13;
        r4 = ImageView.ScaleType.FIT_CENTER;
        goto L14
    L11:
        if (r3.equals("cover") == false) goto L13;
        r4 = ImageView.ScaleType.CENTER_CROP;
        goto L14
    }

    @LynxProp(name = "playstatus")
    public final void setPlay(String r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        if (Intrinsics.areEqual("play", r3) == false) goto L6;
        ((LynxUI) this).mView.playAnimation();
        this.i = true;
        this.c = false;
        return;
    L6:
        if (Intrinsics.areEqual("pause", r3) == false) goto L10;
        ((LynxUI) this).mView.cancelAnimation();
        this.c = true;
        return;
    }

    @LynxProp(name = "progress")
    public final void setProgress(float r2) {
        ((LynxUI) this).mView.setProgress(r2);
    }

    @LynxProp(defaultInt = -1, name = "repetcount")
    public final void setRepeat(int r2) {
        if (r2 >= 0) goto L4;
        r2 = -1;
    L4:
        ((LynxUI) this).mView.setRepeatCount(r2);
    }

    @LynxProp(name = "speed")
    public final void setSpeed(float r2) {
        ((LynxUI) this).mView.setSpeed(r2);
    }

    @LynxProp(name = "src")
    public final void setSrc(String r10) {
        this.l = null;
        ((LynxUI) this).mView.setImageAssetDelegate(null);
        if (TextUtils.isEmpty(r10) == false) goto L46;
        return;
    L46:
        String r1 = d7a.a.b(getLynxContext(), r10, false);     // Catch: Exception -> L43
        if (r1 == null) goto L41;
        Uri r11 = UriProtector.parse(r1);     // Catch: Exception -> L43
        String r3 = r11.getScheme();     // Catch: Exception -> L43
        if (r3 != null) goto L12;
        return;
    L12:
        switch(r3.hashCode()) {
            case -1408207997: goto L30;
            case 3143036: goto L27;
            case 3213448: goto L21;
            case 93121264: goto L18;
            case 99617003: goto L15;
            default: goto L56;
        };
    L56:
        return;
    L15:
        if (r3.equals("https") == true) goto L23;
        return;
    L23:
        if (StringsKt.endsWith$default(r1, ".json", false, 2, null) == false) goto L25;
        O(r1);     // Catch: Exception -> L43
    L25:
        ((LynxUI) this).mView.setAnimationFromUrl(Uri.decode(r1));     // Catch: Exception -> L43
        return;
    L18:
        if (r3.equals("asset") == true) goto L31;
        return;
    L31:
        String r12 = r11.getPath();     // Catch: Exception -> L43
        if (r12 != null) goto L35;
        return;
    L35:
        if (StringsKt.startsWith$default(r12, "/", false, 2, null) != true) goto L37;
        r12 = r12.substring(1);     // Catch: Exception -> L43
    L37:
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L43
        if (StringsKt.endsWith$default(r12, ".json", false, 2, null) == false) goto L40;
        ((LynxUI) this).mView.setImageAssetsFolder(r12.substring(0, StringsKt.lastIndexOf$default(r12, '/', 0, false, 6, null)) + "/images/");     // Catch: Exception -> L43
    L40:
        ((LynxUI) this).mView.setAnimation(r12);     // Catch: Exception -> L43
        return;
    L21:
        if (r3.equals("http") == true) goto L23;
        return;
    L27:
        if (r3.equals("file") == false) goto L52;
        O(r1);     // Catch: Exception -> L43
        ((LynxUI) this).mView.setAnimation(new JsonReader(new PolarisFileReaderWrapper(r11.getPath())), r1);     // Catch: Exception -> L43
        return;
    L52:
        return;
    L30:
        if (r3.equals("assets") == true) goto L31;
        return;
    L41:
        ((LynxUI) this).mView.setAnimationFromUrl(r10);     // Catch: Exception -> L43
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        e.toString();
    }

    @LynxProp(defaultInt = 0, name = "startframe")
    public final void setStartFrame(int r2) {
        ((LynxUI) this).mView.setMinFrame(r2);
    }

    @LynxProp(defaultInt = 6, name = "rate")
    public final void setUpdateRate(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.e = r1;
    }

    @LynxProp(defaultBoolean = BuildConfig.DEBUG, name = "play")
    public final void setPlay(boolean r2) {
        if (r2 == false) goto L5;
        this.i = true;
        this.c = false;
        return;
    L5:
        ((LynxUI) this).mView.cancelAnimation();
        this.c = true;
    }

    public static final void N(LynxLottieView r8, String r9, int r10, int r11, int r12) {
        Set<String> r0 = r8.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r9) != true) goto L16;
        LynxContext r1 = r8.getLynxContext();
        if (r1 == null) goto L14;
        EventEmitter r2 = r1.getEventEmitter();
        if (r2 == null) goto L15;
        r2.sendCustomEvent(new m(r10, r11, r12, r8.getSign(), r9));
        return;
    L15:
        return;
    L14:
        return;
    }
}

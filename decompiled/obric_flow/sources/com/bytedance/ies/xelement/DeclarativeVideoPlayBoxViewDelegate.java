package com.bytedance.ies.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pe.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000fH&¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000fH&¢\u0006\u0004\b\u0019\u0010\u0012J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\nH&¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u001d\u0010!\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010\u0012J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b&\u0010\u0015J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020\nH&¢\u0006\u0004\b(\u0010\u000eJ\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000fH&¢\u0006\u0004\b*\u0010\u0012J\u0017\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u000fH&¢\u0006\u0004\b,\u0010\u0012J\u0017\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u000fH&¢\u0006\u0004\b.\u0010\u0012J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\fH&¢\u0006\u0004\b3\u00104J!\u00107\u001a\u00020\f2\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u000105H&¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\fH&¢\u0006\u0004\b9\u00104J\u001f\u0010<\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u000fH&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\fH&¢\u0006\u0004\b>\u00104J\u000f\u0010?\u001a\u00020\fH&¢\u0006\u0004\b?\u00104J\u0017\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\bA\u0010\u0015J\u0017\u0010C\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0015Jj\u0010L\u001a\u00020\f2Y\u0010K\u001aU\u0012\u0013\u0012\u00110\n¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0H¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110\u0000¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\f\u0018\u00010DH\u0016¢\u0006\u0004\bL\u0010MJ3\u0010Q\u001a\u00020\f2\"\u0010P\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0Nj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f`OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0019\u0010T\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\bT\u0010\u000eJ\u0017\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020\nH\u0017¢\u0006\u0004\bV\u0010\u000eJ\u0019\u0010Y\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0006H\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\fH\u0016¢\u0006\u0004\b]\u00104¨\u0006^"}, d2 = {"Lcom/bytedance/ies/xelement/DeclarativeVideoPlayBoxViewDelegate;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "src", "", "setSrc", "(Ljava/lang/String;)V", "", "muted", "setMuted", "(Z)V", "initTime", "setInitTime", "(I)V", "autoPlay", "setAutoPlay", "loop", "setLoop", "poster", "setPoster", "autoLifecycle", "setAutoLifecycle", "Lpe/a;", "", "loader", "setResourceLoader", "(Lpe/a;)V", "enablePlayListener", "setEnablePlayListener", "rate", "setRate", "objectFit", "setObjectFit", "singlePlayer", "setSinglePlayer", "deviceChangeAware", "setDeviceChangeAware", "preload", "setPreload", "", "volume", "setVolume", "(F)V", "onPropsUpdateOnce", "()V", "Lkotlin/Function0;", "playCB", "playReal", "(Lkotlin/jvm/functions/Function0;)V", "pause", "optInt", "optBoolean", "seek", "(IZ)V", "performZoom", "performZoomOut", "videoWidth", "setVideoWidth", "videoHeight", "setVideoHeight", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", "", "data", "viewBox", "reporter", "setStateChangeReporter", "(Lkotlin/jvm/functions/Function3;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "(Ljava/util/HashMap;)V", "tag", "setVideoTag", "performanceLog", "setPerformanceLog", "", "borderRadius", "setBorderRadius", "([F)V", "getDuration", "()I", "destroy", "x-element-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DeclarativeVideoPlayBoxViewDelegate extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache;

    @JvmOverloads
    public DeclarativeVideoPlayBoxViewDelegate(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r5 = null;
        int r11 = 0;
        this(r10, r5, r11, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playReal$default(DeclarativeVideoPlayBoxViewDelegate r5, Function0 r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        r5.playReal(r10);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playReal");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int r5) {
        Map<Integer, View> r10 = this._$_findViewCache;
        View r11 = r10.get(Integer.valueOf(r5));
        if (r11 != null) goto L10;
        View r12 = findViewById(r5);
        if (r12 == null) goto L8;
        r10.put(Integer.valueOf(r5), r12);
        return r12;
    L8:
        return null;
    L10:
        return r11;
    }

    public void destroy() {
    }

    public int getDuration() {
        return 0;
    }

    public abstract void onPropsUpdateOnce();

    public abstract void pause();

    public abstract void performZoom();

    public abstract void performZoomOut();

    public abstract void playReal(Function0<Unit> r5);

    public abstract void seek(int r5, boolean r10);

    public void setAutoLifecycle(boolean r5) {
    }

    public abstract void setAutoPlay(boolean r5);

    public void setBorderRadius(float[] r5) {
    }

    public abstract void setDeviceChangeAware(boolean r5);

    public void setEnablePlayListener(boolean r5) {
    }

    public abstract void setInitTime(int r5);

    public void setLogExtra(HashMap<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "logExtra");
    }

    public abstract void setLoop(boolean r5);

    public abstract void setMuted(boolean r5);

    public abstract void setObjectFit(String r5);

    @Deprecated(message = "use setLogExtra")
    public void setPerformanceLog(String r5) {
        Intrinsics.checkNotNullParameter(r5, "performanceLog");
    }

    public abstract void setPoster(String r5);

    public abstract void setPreload(boolean r5);

    public abstract void setRate(int r5);

    public void setResourceLoader(a r5) {
        Intrinsics.checkNotNullParameter(r5, "loader");
    }

    public abstract void setSinglePlayer(boolean r5);

    public abstract void setSrc(String r5);

    public void setStateChangeReporter(Function3<? super String, ? super Map<String, ? extends Object>, ? super DeclarativeVideoPlayBoxViewDelegate, Unit> r5) {
    }

    public void setVideoHeight(int r5) {
    }

    public void setVideoTag(String r5) {
    }

    public void setVideoWidth(int r5) {
    }

    public abstract void setVolume(float r5);

    @JvmOverloads
    public DeclarativeVideoPlayBoxViewDelegate(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r5 = 0;
        this(r10, r11, r5, 4, null);
    }

    @JvmOverloads
    public DeclarativeVideoPlayBoxViewDelegate(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this._$_findViewCache = new LinkedHashMap();
        super(r5, r10, r11);
    }

    public /* synthetic */ DeclarativeVideoPlayBoxViewDelegate(Context r5, AttributeSet r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r5, r10, r11);
    }
}

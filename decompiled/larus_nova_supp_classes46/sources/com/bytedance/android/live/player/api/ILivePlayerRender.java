package com.bytedance.android.live.player.api;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.android.livesdkapi.player.ISetSurfaceInterceptor;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.texturerender.VideoSurface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 =2\u00020\u0001:\u0001>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J-\u0010\n\u001a\u00020\u00042#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000bH&JE\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000bH&J-\u0010\u0014\u001a\u00020\u00042#\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000bH&JX\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00152D\u0010\u000f\u001a@\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u0017H&J\u0018\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cH&J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020 H&J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H&J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H&J\u001c\u0010*\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010)\u001a\u00020\u0006H&J\u001c\u0010+\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010)\u001a\u00020\u0006H&J\b\u0010,\u001a\u00020\u0015H&J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H'J \u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00152\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H&J\u0012\u00107\u001a\u00020\u00152\b\b\u0002\u00106\u001a\u00020\u0015H&J\u0012\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H&J\u0010\u0010;\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H&J\b\u0010<\u001a\u00020\u0004H&¨\u0006?"}, d2 = {"Lcom/bytedance/android/live/player/api/ILivePlayerRender;", "", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "view", "", "bindRenderView", "", "layout", "setImageLayout", "Landroid/graphics/Bitmap;", "getBitmap", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bitmap", "callback", "width", "height", "Landroid/graphics/Rect;", "srcRect", "saveFrame", "", "sync", "Lkotlin/Function2;", "", "", "extraInfo", "saveFrameV2", "Lkotlin/Pair;", "getBitmapV2", "Landroid/os/Bundle;", "bundle", "Lcom/ss/texturerender/VideoSurface$SaveFrameCallback;", "saveByteBuffer", "Landroid/view/Surface;", "surface", "setSurfaceDisplay", "Landroid/view/SurfaceHolder;", "surfaceHolder", "setDisplay", "extraSurface", "type", "setExtraSurface", "removeExtraSurface", "isRenderViewRealVisible", "topOffset", "bottomOffset", "clipRenderViewVertical", "enable", "Landroid/graphics/RectF;", "region", "", "bgColor", "updateRoiSr", "realtime", "roiSrUsed", "Lcom/bytedance/android/livesdkapi/player/ISetSurfaceInterceptor;", "interceptor", "setSetSurfaceInterceptor", "forceDrawOnceWhenSwitchSurface", "trySetRenderViewVideoSize", "Companion", "a", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerRender {
    public static final a Companion = null;
    public static final int IMAGE_LAYOUT_ASPECT_FILL = 2;
    public static final int IMAGE_LAYOUT_ASPECT_FIT = 0;
    public static final int IMAGE_LAYOUT_FROM_LEFT_UP = 3;
    public static final int IMAGE_LAYOUT_TO_FILL = 1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    void bindRenderView(IRenderView r1);

    void clipRenderViewVertical(int r1, int r2);

    boolean forceDrawOnceWhenSwitchSurface(boolean r1);

    Bitmap getBitmap();

    void getBitmap(int r1, int r2, Rect r3, Function1<? super Bitmap, Unit> r4);

    void getBitmap(Function1<? super Bitmap, Unit> r1);

    Pair<Bitmap, Integer> getBitmapV2();

    boolean isRenderViewRealVisible();

    void removeExtraSurface(Surface r1, int r2);

    boolean roiSrUsed(boolean r1);

    void saveByteBuffer(Bundle r1, VideoSurface.SaveFrameCallback r2);

    void saveFrame(Function1<? super Bitmap, Unit> r1);

    void saveFrameV2(boolean r1, Function2<? super Map<String, ? extends Object>, ? super Bitmap, Unit> r2);

    void setDisplay(SurfaceHolder r1);

    void setExtraSurface(Surface r1, int r2);

    void setImageLayout(int r1);

    void setSetSurfaceInterceptor(ISetSurfaceInterceptor r1);

    void setSurfaceDisplay(Surface r1);

    void trySetRenderViewVideoSize();

    int updateRoiSr(boolean r1, RectF r2, long r3);
}

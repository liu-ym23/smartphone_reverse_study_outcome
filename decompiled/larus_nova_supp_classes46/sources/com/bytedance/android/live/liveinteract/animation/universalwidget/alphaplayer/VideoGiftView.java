package com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import zc0.b;
import zc0.c;
import zc0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class VideoGiftView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public PlayerController a;
    public zc0.a b;
    public Path c;

    public class a implements AlphaPlayerAction {
        public final /* synthetic */ VideoGiftView a;

        public final void a() {
        }

        public final void c(int r1, int r2, DataSource.ScaleType r3) {
        }

        public final void b() {
            zc0.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.onEnd();
            return;
        }

        public a(VideoGiftView r1) {
            this.a = r1;
        }
    }

    public int getDuration() {
        PlayerController r0 = this.a;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getDuration();
    }

    public Path getClipPath() {
        return this.c;
    }

    public VideoGiftView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final void b(String r6) {
        if (this.a != null) goto L5;
        return;
    L5:
        String r0 = File.separator;
        if (r6.endsWith(r0) == false) goto L8;
        String r1 = r6.concat("config.json");
    L9:
        ?? r2 = new PolarisFileWrapper(r1).exists();
        com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a r3 = null;
        ?? r4 = 0;
        r4 = 0;
        if (r2 != 0) goto L85;
    L51:
        r1 = null;
        r2 = r2;
    L52:
        if (r1 != null) goto L54;
        return;
    L54:
        if (r1.isEmpty() == true) goto L90;
        r3 = (com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a) GsonProtectorUtils.fromJson(com.bytedance.android.live.liveinteract.animation.universalwidget.utils.a.b, r1, com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a.class);     // Catch: JsonSyntaxException -> L58
    L59:
        if (r3 != null) goto L61;
        return;
    L61:
        DataSource r5 = new DataSource();
        if (r3.portrait == null) goto L65;
        DataSource.DataInfo r7 = new DataSource.DataInfo(r6 + File.separator + r3.portrait.path);
        r7.d(r3.portrait.align);
        com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a.C0015a r8 = r3.portrait;
        r7.j = r8.version;
        r7.c = r8.totalFrame;
        r7.f = r8.videoWidth;
        r7.g = r8.videoHeight;
        r7.h = r8.actualWidth;
        r7.i = r8.actualHeight;
        r7.b(r8.alphaFrame);
        r7.c(r3.portrait.rgbFrame);
        com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a.C0015a r9 = r3.portrait;
        r7.k = r9.masks;
        r7.l = r9.a();
        r5.c(r7);
    L65:
        if (r3.landscape == null) goto L69;
        DataSource.DataInfo r10 = new DataSource.DataInfo(r6 + File.separator + r3.landscape.path);
        r10.d(r3.landscape.align);
        com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a.C0015a r11 = r3.landscape;
        r10.j = r11.version;
        r10.c = r11.totalFrame;
        r10.f = r11.videoWidth;
        r10.g = r11.videoHeight;
        r10.h = r11.actualWidth;
        r10.i = r11.actualHeight;
        r10.b(r11.alphaFrame);
        r10.c(r3.landscape.rgbFrame);
        com.bytedance.android.live.liveinteract.animation.universalwidget.alphaplayer.a.C0015a r12 = r3.landscape;
        r10.k = r12.masks;
        r10.l = r12.a();
        r5.b(r10);
        if (r3.portrait != null) goto L69;
        r5.c(r10);
    L69:
        r5.d = false;
        r5.g = false;
        PlayerController r13 = this.a;
        r13.h = new a(this);
        if ((r13 instanceof PlayerController) == false) goto L72;
        IPlayerController.FirstGLFrameListener r14 = new d();
        r13.getClass();
        r13.m.setFirstGLFrameListener(r14);
    L72:
        this.a.f(r5, true);
        return;
    L90:
        return;
    L85:
        r2 = new PolarisFileInputStreamWrapper(r1);     // Catch: Throwable -> L25 IOException -> L27
    L87:
        InputStreamReader r15 = new InputStreamReader(r2, "UTF-8");     // Catch: Throwable -> L21 IOException -> L23
        char[] r16 = new char[r2.available()];     // Catch: IOException -> L19 Throwable -> L40
        r15.read(r16);     // Catch: IOException -> L17 Throwable -> L40
        r15.close();     // Catch: IOException -> L17 Throwable -> L40
        r2.close();     // Catch: IOException -> L17 Throwable -> L40
        r15.close();     // Catch: IOException -> L32
    L35:
        r2.close();     // Catch: IOException -> L32
    L38:
        if (r16 == null) goto L51;
        r1 = new String(r16);
        r2 = r2;
    L17:
        IOException e = e;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L40
        if (r15 == null) goto L34;
        r15.close();     // Catch: IOException -> L32
    L34:
        if (r2 == 0) goto L38;
    L19:
        e = move-exception;
        e = e;
        r16 = null;
        goto L29
    L23:
        e = move-exception;
        e = e;
        r15 = null;
        r16 = null;
    L21:
        th = th;
    L42:
        if (r4 != 0) goto L83;
    L46:
        if (r2 == 0) goto L50;
        r2.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
    L50:
        throw th;
    L83:
        r4.close();     // Catch: IOException -> L44
    L27:
        e = move-exception;
        e = e;
        r15 = null;
        r2 = 0;
        r16 = null;
    L25:
        th = th;
        r2 = 0;
    L40:
        th = th;
        r4 = r1;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L8:
        r1 = r6 + r0 + "config.json";
        goto L9
    }

    @Override // android.view.View
    public final void draw(Canvas r3) {
        Path r0 = this.c;
        if (r0 == null) goto L6;
        if (r3 == null) goto L6;
        r3.clipPath(r0, Region.Op.DIFFERENCE);
    L6:
        super.draw(r3);
    }

    public void setClipPath(Path r1) {
        this.c = r1;
        invalidate();
    }

    public void setPlayCallback(zc0.a r1) {
        this.b = r1;
    }

    public VideoGiftView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public VideoGiftView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public final void a(final Context r2, LifecycleOwner r3, boolean r4, AlphaPlayerAction r5, IMonitor r6) {
        if (this.a == null) goto L5;
        return;
    L5:
        Configuration r0 = new Configuration();
        r0.a = r2;
        r0.b = r3;
        r0.e = true;
        r0.c = r4 ? 1 : 0;
        r0.f = true;
        this.a = new PlayerController(r0, new ad0.a(r2));     // Catch: Exception -> L8
    L10:
        PlayerController r7 = this.a;
        r7.h = r5;
        r7.g = r6;
        r7.b(new b(), 300);
        this.a.o(new c(r2));
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        this.a = new PlayerController(r0, new DefaultSystemPlayer());
        goto L10
    }
}

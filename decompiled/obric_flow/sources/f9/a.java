package f9;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bytedance.ai.model.widgets.l;
import com.bytedance.apm.j;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.b0;
import com.bytedance.sdk.xbridge.cn.utils.g;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import com.obric.oui.image.OImageShape;
import g8.e;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kj.b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import l9.r;
import l9.t;
import org.json.JSONObject;
import org.threeten.bp.MonthDay;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.d;
import org.threeten.bp.temporal.i;
import sr.c;
import z.f;
import z.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements h, b, mi.b, g, m8.a, r, i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile UUID f16884b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f16885c = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16886a;

    public /* synthetic */ a(int r5) {
        this.f16886a = r5;
    }

    public static synchronized String h(Context r5) {
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(f16885c) == false) goto L11;
        new a(r5);     // Catch: Throwable -> L9
        UUID r10 = f16884b;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        f16885c = r10.toString();     // Catch: Throwable -> L9
    L11:
        String r11 = f16885c;     // Catch: Throwable -> L9
        monitor-exit(a.class);
        return r11;
    }

    public static void i(Throwable r5) {
        if (j.f3887a == true) goto L14;
        JSONObject r10 = j.f3888b;
        if (r10 != null) goto L7;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L14;
        return;
    L7:
        if (r10.optString(LynxMonitorService.KEY_CHANNEL) == null) goto L10;
        r11 = r10.optString(LynxMonitorService.KEY_CHANNEL).contains("local");
    L14:
        throw new RuntimeException(r5);
    }

    public static c j(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        if (r11 != null) goto L8;
        c r13 = new c();     // Catch: Throwable -> L6
    L31:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L6
    L35:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L40;
        Log.w("OImageStyleHelper", "Failed to parse OImage attrs, fallback to defaults", r15);
        r14 = new c();
    L40:
        return (c) r14;
    L8:
        TypedArray r16 = r10.obtainStyledAttributes(r11, R$styleable.OImage, r12, 0);     // Catch: Throwable -> L6
        int r17 = r16.getInt(R$styleable.OImage_oui_imageShape, OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L23
        OImageShape.Companion.getClass();     // Catch: Throwable -> L23
        OImageShape[] r18 = OImageShape.values();     // Catch: Throwable -> L23
        int r19 = r18.length;     // Catch: Throwable -> L23
        int r20 = 0;
    L10:
        Integer r21 = null;
        if (r20 >= r19) goto L16;
        OImageShape r22 = r18[r20];     // Catch: Throwable -> L23
        if (r22.getAttrValue() == r17) goto L17;
        r20 = r20 + 1;     // Catch: Throwable -> L23
    L17:
        if (r22 != null) goto L19;
        Log.w("OImageStyleHelper", "Unknown oui_imageShape value=" + r17 + ", fallback to STANDARD");     // Catch: Throwable -> L23
        OImageShape r23 = OImageShape.STANDARD;     // Catch: Throwable -> L23
    L20:
        boolean r24 = r16.getBoolean(R$styleable.OImage_oui_imageStrokeEnabled, true);     // Catch: Throwable -> L23
        if (r16.hasValue(R$styleable.OImage_oui_imageBackgroundColor) == false) goto L26;
        r21 = Integer.valueOf(r16.getColor(R$styleable.OImage_oui_imageBackgroundColor, 0));     // Catch: Throwable -> L23
    L26:
        if (r16.hasValue(R$styleable.OImage_oui_imageStrokeColor) == false) goto L28;
        int r110 = r16.getColor(R$styleable.OImage_oui_imageStrokeColor, ContextCompat.getColor(r10, R$color.oui_line_1));     // Catch: Throwable -> L23
    L29:
        c r25 = new c(r23, r24, r21, Integer.valueOf(r110), r16.getBoolean(R$styleable.OImage_oui_clipToMask, false));     // Catch: Throwable -> L23
        r16.recycle();     // Catch: Throwable -> L6
        r13 = r25;
        goto L31
    L28:
        r110 = ContextCompat.getColor(r10, R$color.oui_line_1);     // Catch: Throwable -> L23
        goto L29
    L19:
        r23 = r22;
        goto L20
    L16:
        r22 = null;
    L23:
        th = move-exception;
        r16.recycle();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L35
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.g
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        ConcurrentHashMap r10 = tl.b.f22138a;
        tl.b.c("BDXBridge", r5.toString());
    }

    @Override // m8.a
    public void b(WsChannelMsg r5) {
        if (r5 == null) goto L9;
        int r10 = r5.f4011j;
        if (e.f17066a.get(Integer.valueOf(r10)) != null) goto L8;
        return;
    L8:
        throw new ClassCastException();
    }

    @Override // l9.r
    public boolean c(Object r5, Runnable r10) {
        t r11 = (t) r5;
        if (r10 != null) goto L12;
        if (r11 == null) goto L11;
        Message r12 = r11.f19592a;
        if (r12 == null) goto L11;
        if (r12.getCallback() == null) goto L11;
        return false;
    L11:
        return true;
    L12:
        if (r11 == null) goto L18;
        Message r13 = r11.f19592a;
        if (r13 == null) goto L18;
        if (r10.equals(r13.getCallback()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(d r5) {
        switch(this.f16886a) {
            case 14: goto L10;
            default: goto L4;
        };
    L4:
        ChronoField r10 = ChronoField.OFFSET_SECONDS;
        if (r5.isSupported(r10) == true) goto L11;
        return null;
    L11:
        return ZoneOffset.ofTotalSeconds(r5.get(r10));
    L10:
        return MonthDay.from(r5);
    }

    @Override // m8.a
    public void e(b0 r5) {
        if (e.f17066a.get(Integer.valueOf(r5.f7246b)) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // z.h
    public EncodeStrategy f(f r5) {
        return EncodeStrategy.SOURCE;
    }

    @Override // z.a
    public boolean g(Object r5, File r10, f r11) {
        q0.b.b(((GifDrawable) ((d0) r5).get()).a(), r10);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (Log.isLoggable("GifEncoder", 5) == false) goto L9;
        Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
    L9:
        return false;
    }

    public a(Context r5) {
        this.f16886a = 0;
        if (f16884b == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (f16884b != null) goto L29;
        com.bytedance.ies.argus.bean.b r10 = com.bytedance.ies.argus.bean.b.a();     // Catch: Throwable -> L19
        r10.getClass();     // Catch: Throwable -> L19
        String r11 = null;
        String r12 = cl.a.D(((File) r10.e).getAbsolutePath());     // Catch: Throwable -> L12
    L14:
        if (TextUtils.isEmpty(r12) == true) goto L40;
        f16884b = UUID.fromString(r12);     // Catch: Throwable -> L17
    L17:
        f16884b = UUID.randomUUID();     // Catch: Throwable -> L19
        goto L29
    L40:
        r11 = Settings.Secure.getString(r5.getContentResolver(), "android_id");     // Catch: Throwable -> L34
    L47:
        if (r11 == null) goto L24;
        f16884b = UUID.nameUUIDFromBytes(r11.getBytes("utf8"));     // Catch: Throwable -> L26
    L46:
    L27:
        com.bytedance.ies.argus.bean.b r13 = com.bytedance.ies.argus.bean.b.a();     // Catch: Throwable -> L19
        String r14 = String.valueOf(f16884b);     // Catch: Throwable -> L19
        r13.getClass();     // Catch: Throwable -> L19
        cl.a.u(r14, (File) r13.e, false);     // Catch: Throwable -> L35
        goto L29
    L24:
        f16884b = UUID.randomUUID();     // Catch: Throwable -> L26
    L26:
        f16884b = UUID.randomUUID();     // Catch: Throwable -> L19
    L12:
        r12 = null;
    L29:
        monitor-exit(a.class);     // Catch: Throwable -> L19
    }

    @Override // mi.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Log.i(r5, r10);
    }

    @Override // m8.a
    public void a(int r5, ConnectionState r10) {
        if (e.f17066a.get(Integer.valueOf(r5)) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    public a(l r5) {
        this.f16886a = 2;
    }
}

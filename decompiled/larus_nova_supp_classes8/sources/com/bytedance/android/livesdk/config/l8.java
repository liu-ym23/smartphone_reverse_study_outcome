package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/config/l8;", "", "", "scaleType", "I", "f", "()I", "k", "(I)V", "Lcom/bytedance/android/livesdk/config/y1;", "contentFrame", "Lcom/bytedance/android/livesdk/config/y1;", "c", "()Lcom/bytedance/android/livesdk/config/y1;", "setContentFrame", "(Lcom/bytedance/android/livesdk/config/y1;)V", "Lcom/bytedance/android/livesdk/config/k8;", "bigAlignModeConfig", "Lcom/bytedance/android/livesdk/config/k8;", "a", "()Lcom/bytedance/android/livesdk/config/k8;", "setBigAlignModeConfig", "(Lcom/bytedance/android/livesdk/config/k8;)V", "smallAlignModeConfig", "g", "setSmallAlignModeConfig", "topMargin", "h", "l", "bottomMargin", "b", "i", "leftMargin", "d", "setLeftMargin", "rightMargin", "e", "j", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l8 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("big")
    private k8 bigAlignModeConfig;

    @SerializedName("bottom_margin")
    private int bottomMargin;

    @SerializedName("content_frame")
    private y1 contentFrame;

    @SerializedName("left_margin")
    private int leftMargin;

    @SerializedName("right_margin")
    private int rightMargin;

    @SerializedName("scale_type")
    private int scaleType;

    @SerializedName("small")
    private k8 smallAlignModeConfig;

    @SerializedName("top_margin")
    private int topMargin;

    public static final class a {
        public static HashMap a() {
            HashMap r0 = new HashMap();
            l8 r1 = new l8();
            RenderViewScaleType r2 = RenderViewScaleType.WIDTH_ALIGN;
            r1.k(r2.getValue());
            r1.c().f();
            r1.l(140);
            k8 r4 = r1.a();
            AlignModeType r5 = AlignModeType.TOP_ALIGN;
            r4.b(r5.getValue());
            r1.g().b(r5.getValue());
            y1 r6 = r1.c();
            wu r7 = wu.a;
            r6.h(r7.getValue().floatValue());
            r0.put(11, r1);
            l8 r3 = new l8();
            r3.k(r2.getValue());
            r3.c().f();
            r3.l(140);
            r3.a().b(r5.getValue());
            r3.g().b(r5.getValue());
            r3.c().h(r7.getValue().floatValue());
            r0.put(16, r3);
            l8 r8 = new l8();
            r8.k(r2.getValue());
            r8.c().f();
            r8.l(140);
            r8.a().b(r5.getValue());
            r8.g().b(r5.getValue());
            r8.c().h(r7.getValue().floatValue());
            r0.put(9, r8);
            l8 r9 = new l8();
            RenderViewScaleType r10 = RenderViewScaleType.HEIGHT_ALIGN;
            r9.k(r10.getValue());
            r9.c().e(0.7375f);
            r9.l(123);
            r9.i();
            k8 r11 = r9.a();
            AlignModeType r12 = AlignModeType.RIGHT_ALIGN;
            r11.b(r12.getValue());
            k8 r13 = r9.g();
            AlignModeType r14 = AlignModeType.HORIZONTAL_CENTER_ALIGN;
            r13.b(r14.getValue());
            r9.c().h(0.2625f);
            r9.c().f();
            r9.j();
            r0.put(10, r9);
            l8 r15 = new l8();
            r15.k(r10.getValue());
            r15.c().e(1.0f);
            r15.a().b(r12.getValue());
            r15.g().b(r12.getValue());
            r15.c().f();
            r15.c().g();
            r15.j();
            r0.put(8, r15);
            l8 r16 = new l8();
            r16.k(r10.getValue());
            r16.c().e(0.7375f);
            r16.l(123);
            r16.i();
            r16.a().b(r12.getValue());
            r16.g().b(r14.getValue());
            r16.c().h(0.2625f);
            r16.c().f();
            r16.j();
            r0.put(12, r16);
            l8 r17 = new l8();
            r17.k(r2.getValue());
            r17.c().f();
            r17.l(140);
            r17.a().b(r5.getValue());
            r17.g().b(r5.getValue());
            r17.c().h(r7.getValue().floatValue());
            r0.put(13, r17);
            l8 r18 = new l8();
            r18.k(r10.getValue());
            r18.c().e(1.0f);
            r18.a().b(r12.getValue());
            r18.g().b(r12.getValue());
            r18.c().f();
            r18.c().g();
            r18.j();
            r0.put(15, r18);
            l8 r19 = new l8();
            r19.k(r2.getValue());
            r19.c().f();
            r19.l(140);
            r19.a().b(r5.getValue());
            r19.g().b(r5.getValue());
            r19.c().h(r7.getValue().floatValue());
            r0.put(17, r19);
            r0.put(31, r19);
            r0.put(32, r19);
            r0.put(33, r19);
            r0.put(39, r19);
            l8 r20 = new l8();
            r20.k(r2.getValue());
            r20.c().f();
            r20.l(128);
            r20.a().b(r5.getValue());
            r20.g().b(r5.getValue());
            r20.c().h(0.18035f);
            r0.put(3, r20);
            return r0;
        }
    }

    static {
    }

    public final void j() {
        this.rightMargin = 0;
    }

    public final void i() {
        this.bottomMargin = 48;
    }

    public l8() {
        this.contentFrame = new y1();
        this.bigAlignModeConfig = new k8();
        this.smallAlignModeConfig = new k8();
    }

    public final k8 a() {
        return this.bigAlignModeConfig;
    }

    public final int b() {
        return this.bottomMargin;
    }

    public final y1 c() {
        return this.contentFrame;
    }

    public final int d() {
        return this.leftMargin;
    }

    public final int e() {
        return this.rightMargin;
    }

    public final int f() {
        return this.scaleType;
    }

    public final k8 g() {
        return this.smallAlignModeConfig;
    }

    public final int h() {
        return this.topMargin;
    }

    public final void k(int r1) {
        this.scaleType = r1;
    }

    public final void l(int r1) {
        this.topMargin = r1;
    }
}

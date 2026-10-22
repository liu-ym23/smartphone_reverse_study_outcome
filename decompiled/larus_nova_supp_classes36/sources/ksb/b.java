package ksb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.fonts.Font;
import android.os.Build;
import android.util.LruCache;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.rcanvas.OpCode;
import com.ss.android.lark.movable.utils.c;
import com.ss.android.lark.movable.utils.e;
import com.ss.android.lark.vfs.VFSFiles;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends View {
    public static final LruCache<String, byte[]> f = null;
    public boolean a;
    public final com.ss.android.lark.movable.rcanvas.a b;
    public byte[] c;
    public MovableDocumentInfo d;
    public final int e;

    public static final class a {
    }

    static {
        f = new LruCache(3);
    }

    public final int getCanvasSh() {
        return this.e;
    }

    public final boolean getEnableDrawGlyphs() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = true;
        this.b = new com.ss.android.lark.movable.rcanvas.a(r2);
        this.c = new byte[0];
        this.e = hashCode();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r24) {
        Intrinsics.checkNotNullParameter(r24, "canvas");
        ViewParent r2 = getParent();
        if ((r2 instanceof MovableView) == false) goto L5;
        MovableView r3 = (MovableView) r2;
    L7:
        if (r3 == null) goto L9;
        Point r4 = e.b(r3);
    L10:
        r24.save();
        int r5 = com.ss.android.lark.movable.utils.b.g(getMeasuredWidth(), getContext());
        MovableDocumentInfo r6 = this.d;
        if (r6 == null) goto L25;
        Log.d("RCanvas", "canvasSh: " + this.e + ", onDraw: curMeasuredWidth: " + r5 + ", docWidth: " + r6.getWidth());
        if (r5 <= 0) goto L25;
        if (r6.getWidth() != r5) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L25;
        if (this.a == false) goto L25;
        int r8 = UInt.constructor-impl(r5);
        String r9 = UInt.toString-impl(r6.getDocumentVersion-pVg5ArA()) + '_' + UInt.toString-impl(r6.getDocumentId-pVg5ArA()) + '_' + UInt.toString-impl(r8);
        LruCache<String, byte[]> r10 = f;
        byte[] r11 = r10.get(r9);
        if (r11 != null) goto L24;
        r11 = Lark_markdown_renderKt.ffiRequestRenderStreamWithWidth-zly0blg(r6.getDocumentVersion-pVg5ArA(), r6.getDocumentId-pVg5ArA(), r8);
        r10.put(r9, r11);
    L24:
        Log.d("RCanvas", "canvasSh: " + this.e + ", onDraw: syncTextBlob size: " + r11.length + ", textBlob size: " + this.c.length);
        this.c = r11;
        goto L25
    L17:
        r7 = false;
    L25:
        Log.d("RCanvas", "canvasSh: " + this.e + ", onDraw: offset: " + r4 + ", dataSize: " + this.c.length);
        r24.translate(-((float) r4.x), -((float) r4.y));
        byte[] r12 = this.c;
        if (r12.length != 0) goto L28;
        boolean r13 = true;
    L30:
        if ((!r13) == false) goto L140;
        com.ss.android.lark.movable.rcanvas.a r14 = this.b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r24, "canvas");
        if (r12.length != 0) goto L34;
        boolean r0 = true;
    L35:
        if (r0 == true) goto L140;
        ByteBuffer r15 = ByteBuffer.wrap(r12);
        Intrinsics.checkNotNullParameter(r15, "buf");
        r15.order(ByteOrder.LITTLE_ENDIAN);
        if (r15.getInt() != 1295139888) goto L140;
    L41:
        if (r15.remaining() < 4) goto L140;
        OpCode.a r1 = OpCode.Companion;
        int r16 = r15.getShort() & 65535;
        r1.getClass();
        OpCode[] r17 = OpCode.values();
        int r18 = r17.length;
        int r19 = 0;
    L43:
        if (r19 >= r18) goto L51;
        OpCode r20 = r17[r19];
        if (r20.getV() != r16) goto L47;
        boolean r21 = true;
    L48:
        if (r21 == true) goto L52;
        r19 = r19 + 1;
    L52:
        if (r20 == null) goto L140;
        int r22 = r15.getShort() & 65535;
        if (r15.remaining() < r22) goto L140;
        byte[] r23 = new byte[r22];
        r15.get(r23);
        ByteBuffer r25 = ByteBuffer.wrap(r23).order(ByteOrder.LITTLE_ENDIAN);
        Intrinsics.checkNotNull(r25);
        ksb.a r26 = new ksb.a(r25);
        switch(com.ss.android.lark.movable.rcanvas.a.b.a[r20.ordinal()]) {
            case 1: goto L139;
            case 2: goto L138;
            case 3: goto L137;
            case 4: goto L136;
            case 5: goto L112;
            case 6: goto L99;
            case 7: goto L98;
            case 8: goto L97;
            case 9: goto L96;
            case 10: goto L95;
            case 11: goto L94;
            case 12: goto L87;
            case 13: goto L80;
            case 14: goto L79;
            case 15: goto L78;
            case 16: goto L77;
            case 17: goto L76;
            case 18: goto L75;
            case 19: goto L74;
            case 20: goto L69;
            case 21: goto L68;
            case 22: goto L63;
            case 23: goto L62;
            case 24: goto L61;
            case 25: goto L60;
            default: goto L59;
        };
    L59:
        throw new NoWhenBranchMatchedException();
    L61:
        byte[] r27 = new byte[r26.b()];
        r26.a.get(r27);
        r14.b.setColor(r14.c(new String(r27, Charsets.UTF_8)));
        goto L41
    L62:
        float r28 = r26.a();
        float r29 = r26.a();
        float r30 = r26.a();
        float r31 = r26.a();
        float r32 = r26.a();
        float r33 = r26.a();
        Matrix r34 = new Matrix();
        r34.setValues(new float[]{r28, r30, r14.b(r32), r29, r31, r14.b(r33), 0.0f, 0.0f, 1.0f});
        r24.concat(r34);
        goto L41
    L63:
        Path r35 = r14.d;
        if ((r26.a.get() & 255) != 1) goto L66;
        Path.FillType r36 = Path.FillType.EVEN_ODD;
    L67:
        r35.setFillType(r36);
        r24.clipPath(r14.d);
        goto L41
    L66:
        r36 = Path.FillType.WINDING;
        goto L67
    L68:
        r24.drawPath(r14.d, r14.c);
        goto L41
    L69:
        Path r37 = r14.d;
        if ((r26.a.get() & 255) != 1) goto L72;
        Path.FillType r38 = Path.FillType.EVEN_ODD;
    L73:
        r37.setFillType(r38);
        r24.drawPath(r14.d, r14.b);
        goto L41
    L72:
        r38 = Path.FillType.WINDING;
        goto L73
    L74:
        r14.d.close();
        goto L41
    L75:
        r14.d.cubicTo(r14.b(r26.a()), r14.b(r26.a()), r14.b(r26.a()), r14.b(r26.a()), r14.b(r26.a()), r14.b(r26.a()));
        goto L41
    L76:
        r14.d.lineTo(r14.b(r26.a()), r14.b(r26.a()));
        goto L41
    L77:
        r14.d.moveTo(r14.b(r26.a()), r14.b(r26.a()));
        goto L41
    L78:
        r14.d = new Path();
        goto L41
    L79:
        r14.c.setStrokeMiter(r26.a());
        goto L41
    L80:
        Paint r39 = r14.c;
        int r40 = r26.a.get() & 255;
        if (r40 == 1) goto L85;
        if (r40 == 2) goto L84;
        Paint.Cap r41 = Paint.Cap.BUTT;
    L86:
        r39.setStrokeCap(r41);
        goto L41
    L84:
        r41 = Paint.Cap.SQUARE;
        goto L86
    L85:
        r41 = Paint.Cap.ROUND;
        goto L86
    L87:
        Paint r42 = r14.c;
        int r43 = r26.a.get() & 255;
        if (r43 == 1) goto L92;
        if (r43 == 2) goto L91;
        Paint.Join r44 = Paint.Join.MITER;
    L93:
        r42.setStrokeJoin(r44);
        goto L41
    L91:
        r44 = Paint.Join.BEVEL;
        goto L93
    L92:
        r44 = Paint.Join.ROUND;
        goto L93
    L94:
        r14.c.setStrokeWidth(r14.b(r26.a()));
        goto L41
    L95:
        r24.translate(r14.b(r26.a()), r14.b(r26.a()));
        goto L41
    L96:
        r24.restore();
        goto L41
    L97:
        r24.save();
        goto L41
    L98:
        byte[] r45 = new byte[r26.b()];
        r26.a.get(r45);
        String r46 = new String(r45, Charsets.UTF_8);
        float r47 = r14.b(r26.a());
        float r48 = r14.b(r26.a());
        Paint r49 = r14.b;
        r49.setStyle(Paint.Style.FILL);
        r49.setFakeBoldText(r14.g);
        r49.setSubpixelText(true);
        r49.setTextSize(r14.e);
        Unit r50 = Unit.INSTANCE;
        r24.drawText(r46, r47, r48, r49);
        goto L41
    L99:
        int r51 = r26.a.getInt();
        int[] r52 = new int[r51];
        int r53 = 0;
    L100:
        if (r53 >= r51) goto L102;
        r52[r53] = r26.b();
        r53 = r53 + 1;
        goto L100
    L102:
        float[] r54 = new float[r51 * 2];
        int r55 = 0;
        int r56 = 0;
    L103:
        if (r55 >= r51) goto L106;
        int r57 = r56 + 1;
        r54[r56] = r14.b(r26.a());
        r54[r57] = r14.b(r26.a());
        r55 = r55 + 1;
        r56 = r57 + 1;
        goto L103
    L106:
        if (Build.VERSION.SDK_INT >= 31) goto L107;
        Log.e("CanvasApplier", "drawGlyphs not support");
        goto L41
    L107:
        Font r58 = r14.f;
        if (r58 == null) goto L41;
        Paint r59 = r14.b;
        r59.setStyle(Paint.Style.FILL);
        r59.setFakeBoldText(r14.g);
        r59.setSubpixelText(true);
        r59.setTextSize(r14.e);
        Unit r60 = Unit.INSTANCE;
        r24.drawGlyphs(r52, 0, r54, 0, r51, r58, r59);
        goto L41
    L112:
        byte[] r61 = new byte[r26.b()];
        r26.a.get(r61);
        String r62 = new String(r61, Charsets.UTF_8);
        float r63 = r26.a();
        if ((r26.a.get() & 255) != 1) goto L115;
        boolean r64 = true;
    L116:
        r14.g = r64;
        r14.e = com.ss.android.lark.movable.utils.b.d(r63, r14.a);
        if (Build.VERSION.SDK_INT < 29) goto L134;
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r62, "fontName");
        Font r65 = (Font) ((LinkedHashMap) c.d).get(r62);
        if (r65 != null) goto L135;
        c.a r66 = (c.a) ((LinkedHashMap) c.c).get(r62);
        if (r66 == null) goto L134;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L125
        Object r68 = Result.constructor-impl(new Font.Builder(VFSFiles.b.i(r66.a)).setTtcIndex(r66.b).build());     // Catch: Throwable -> L125
    L128:
        if (Result.isSuccess-impl(r68) == false) goto L131;
        c.d.put(r62, (Font) r68);
        Log.i(c.b, "getFont, id: " + r62 + ", path: " + r66.a + ", ttcIndex: " + r66.b);
    L131:
        if (Result.isFailure-impl(r68) == false) goto L133;
        r68 = null;
    L133:
        r65 = (Font) r68;
    L125:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
    L135:
        r14.f = r65;
    L134:
        r65 = null;
        goto L135
    L115:
        r64 = false;
        goto L116
    L136:
        float r70 = r14.b(r26.a());
        float r71 = r14.b(r26.a());
        r24.drawRect(r70, r71, r70 + r14.b(r26.a()), r71 + r14.b(r26.a()), r14.c);
        goto L41
    L137:
        r14.c.setColor(com.ss.android.lark.movable.rcanvas.a.a(r26.a(), r26.a(), r26.a(), r26.a()));
        goto L41
    L138:
        float r72 = r14.b(r26.a());
        float r73 = r14.b(r26.a());
        r24.drawRect(r72, r73, r72 + r14.b(r26.a()), r73 + r14.b(r26.a()), r14.b);
        goto L41
    L139:
        r14.b.setColor(com.ss.android.lark.movable.rcanvas.a.a(r26.a(), r26.a(), r26.a(), r26.a()));
        goto L41
    L60:
        byte[] r74 = new byte[r26.b()];
        r26.a.get(r74);
        r14.c.setColor(r14.c(new String(r74, Charsets.UTF_8)));
        goto L41
    L47:
        r21 = false;
        goto L48
    L51:
        r20 = null;
        goto L52
    L34:
        r0 = false;
    L140:
        r24.restore();
        return;
    L28:
        r13 = false;
        goto L30
    L9:
        r4 = new Point(0, 0);
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final void setEnableDrawGlyphs(boolean r1) {
        this.a = r1;
    }

    public final void a(byte[] r3, MovableDocumentInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Log.d("RCanvas", "canvasSh: " + this.e + ", triggerRender called, data size: " + r3.length);
        this.c = r3;
        this.d = r4;
        invalidate();
    }
}

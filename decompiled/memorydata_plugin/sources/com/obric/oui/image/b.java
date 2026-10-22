package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JD\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig;", "", "shape", "Lcom/obric/oui/image/OImageShape;", "strokeEnabled", "", "backgroundColor", "", "strokeColor", "clipToMask", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Ljava/lang/Integer;Z)V", "getBackgroundColor", "()Ljava/lang/Integer;", "setBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClipToMask", "()Z", "setClipToMask", "(Z)V", "getShape", "()Lcom/obric/oui/image/OImageShape;", "getStrokeColor", "setStrokeColor", "getStrokeEnabled", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/obric/oui/image/OImageShape;ZLjava/lang/Integer;Ljava/lang/Integer;Z)Lcom/obric/oui/image/OImageStyleConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OImageShape f13892b;
    private final boolean c;
    private Integer d;
    private Integer e;
    private boolean f;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/image/OImageStyleConfig$Companion;", "", "()V", "TAG", "", "fromAttributes", "Lcom/obric/oui/image/OImageStyleConfig;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ b a(a r1, Context r2, AttributeSet r3, int r4, int r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = 0;
        L9:
            return r1.a(r8, r9, r4, r5);
        }

        public final b a(Context r16, AttributeSet r17, int r18, int r19) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L22
            a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            if (r5 != null) goto L6;
            b r0 = new b(null, false, null, null, false, 31, null);     // Catch: Throwable -> L22
        L18:
            Object r1 = Result.m1421constructorimpl(r0);     // Catch: Throwable -> L22
        L24:
            Throwable r2 = Result.m1424exceptionOrNullimpl(r1);
            if (r2 == null) goto L29;
            Log.w("OImageStyleHelper", "Failed to parse OImage attrs, fallback to defaults", r2);
            r1 = new b(null, false, null, null, false, 31, null);
        L29:
            return (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
        L6:
            TypedArray r8 = r3.obtainStyledAttributes(r5, R.styleable.OImage, r18, r19);     // Catch: Throwable -> L22
            int r9 = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageShape, "styleable", "OImage_oui_imageShape"), OImageShape.STANDARD.getAttrValue());     // Catch: Throwable -> L19
            OImageShape r10 = OImageShape.Companion.a(r9);     // Catch: Throwable -> L19
            boolean r11 = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeEnabled, "styleable", "OImage_oui_imageStrokeEnabled"), true);     // Catch: Throwable -> L19
            if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageBackgroundColor, "styleable", "OImage_oui_imageBackgroundColor")) == false) goto L10;
            Integer r4 = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageBackgroundColor, "styleable", "OImage_oui_imageBackgroundColor"), 0));     // Catch: Throwable -> L19
        L11:
            Integer r12 = r4;
            if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeColor, "styleable", "OImage_oui_imageStrokeColor")) == false) goto L15;
            int r13 = r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_imageStrokeColor, "styleable", "OImage_oui_imageStrokeColor"), ContextCompat.getColor(r3, ZeusTransformUtils.mapRes(R.color.oui_line_1, TypedValues.Custom.S_COLOR, "oui_line_1")));     // Catch: Throwable -> L19
        L16:
            b r14 = new b(r10, r11, r12, Integer.valueOf(r13), r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OImage_oui_clipToMask, "styleable", "OImage_oui_clipToMask"), false));     // Catch: Throwable -> L19
            r8.recycle();     // Catch: Throwable -> L22
            r0 = r14;
            goto L18
        L15:
            r13 = ContextCompat.getColor(r3, ZeusTransformUtils.mapRes(R.color.oui_line_1, TypedValues.Custom.S_COLOR, "oui_line_1"));     // Catch: Throwable -> L19
            goto L16
        L10:
            r4 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r8.recycle();     // Catch: Throwable -> L22
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L24
        }
    }

    static {
        f13891a = new a(null);
    }

    public b() {
        this(null, false, null, null, false, 31, null);
    }

    public b(OImageShape r2, boolean r3, Integer r4, Integer r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "shape");
        this.f13892b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ b(OImageShape r4, boolean r5, Integer r6, Integer r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = OImageShape.STANDARD;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = true;
    L8:
        boolean r11 = r5;
        Integer r0 = null;
        if ((r9 & 4) == 0) goto L11;
        Integer r1 = null;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = false;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final OImageShape a() {
        return this.f13892b;
    }

    public final void a(Integer r1) {
        this.d = r1;
    }

    public final void a(boolean r1) {
        this.f = r1;
    }

    public final void b(Integer r1) {
        this.e = r1;
    }

    public final boolean b() {
        return this.c;
    }

    public final Integer c() {
        return this.d;
    }

    public final Integer d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f13892b == r6.f13892b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = this.f13892b.hashCode() * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.d;
        int r6 = 0;
        if (r5 != null) goto L8;
        int r7 = 0;
    L9:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.e;
        if (r9 == null) goto L13;
        r6 = r9.hashCode();
    L13:
        int r10 = (r8 + r6) * 31;
        boolean r11 = this.f;
        if (r11 == true) goto L18;
        r2 = r11;
    L18:
        return r10 + r2;
    L8:
        r7 = r5.hashCode();
        goto L9
    }

    public String toString() {
        return "OImageStyleConfig(shape=" + this.f13892b + ", strokeEnabled=" + this.c + ", backgroundColor=" + this.d + ", strokeColor=" + this.e + ", clipToMask=" + this.f + ')';
    }
}

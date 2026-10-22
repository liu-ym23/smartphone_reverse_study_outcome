package com.obric.livecard.api.entity;

import android.content.Context;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B/\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fR(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R,\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/obric/livecard/api/entity/ColorToken;", "", "blend", "Lcom/obric/livecard/api/entity/ColorHex;", "fluid", "(Lcom/obric/livecard/api/entity/ColorHex;Lcom/obric/livecard/api/entity/ColorHex;)V", "blendRes", "", "fluidRes", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/ref/WeakReference;)V", EventBody.KEY_VALUE, "getBlend", "()Lcom/obric/livecard/api/entity/ColorHex;", "setBlend", "(Lcom/obric/livecard/api/entity/ColorHex;)V", "getBlendRes", "()Ljava/lang/Integer;", "setBlendRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "getFluid", "setFluid", "getFluidRes", "setFluidRes", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ColorToken {
    private ColorHex blend;
    private transient Integer blendRes;
    private WeakReference<Context> context;
    private ColorHex fluid;
    private transient Integer fluidRes;

    public ColorToken() {
        this(null, null, null, 7, null);
    }

    public ColorToken(ColorHex r7, ColorHex r8) {
        this(null, null, null, 7, null);
        setBlend(r7);
        setFluid(r8);
    }

    public ColorToken(Integer r4, Integer r5, WeakReference<Context> r6) {
        this.context = r6;
        this.blendRes = r4;
        this.fluidRes = r5;
        ColorHex r0 = null;
        if (r4 == null) goto L5;
        ColorHex r7 = ColorTokenValueResolver.INSTANCE.resolve(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue(), this.context);
    L6:
        this.blend = r7;
        if (r5 == null) goto L9;
        r0 = ColorTokenValueResolver.INSTANCE.resolve(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue(), this.context);
    L9:
        this.fluid = r0;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public /* synthetic */ ColorToken(Integer r2, Integer r3, WeakReference r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final ColorHex getBlend() {
        return this.blend;
    }

    public final Integer getBlendRes() {
        return this.blendRes;
    }

    public final WeakReference<Context> getContext() {
        return this.context;
    }

    public final ColorHex getFluid() {
        return this.fluid;
    }

    public final Integer getFluidRes() {
        return this.fluidRes;
    }

    public final void setBlend(ColorHex r1) {
        if (r1 == null) goto L4;
        r1.check();
    L4:
        this.blend = r1;
    }

    public final void setBlendRes(Integer r3) {
        this.blendRes = r3;
        if (r3 == null) goto L5;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        ColorHex r5 = ColorTokenValueResolver.INSTANCE.resolve(r4, this.context);
    L6:
        setBlend(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setContext(WeakReference<Context> r1) {
        this.context = r1;
    }

    public final void setFluid(ColorHex r1) {
        if (r1 == null) goto L4;
        r1.check();
    L4:
        this.fluid = r1;
    }

    public final void setFluidRes(Integer r3) {
        this.fluidRes = r3;
        if (r3 == null) goto L5;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        ColorHex r5 = ColorTokenValueResolver.INSTANCE.resolve(r4, this.context);
    L6:
        setFluid(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}

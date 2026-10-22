package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR,\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/obric/livecard/api/entity/ColorToken;", "", "blendRes", "", "fluidRes", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "<set-?>", "Lcom/obric/livecard/api/entity/ColorHex;", "blend", "getBlend", "()Lcom/obric/livecard/api/entity/ColorHex;", "value", "getBlendRes", "()Ljava/lang/Integer;", "setBlendRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "fluid", "getFluid", "getFluidRes", "setFluidRes", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ColorToken {
    private ColorHex blend;
    private transient Integer blendRes;
    private ColorHex fluid;
    private transient Integer fluidRes;

    public ColorToken() {
        Integer r0 = null;
        this(r0, r0, 3, r0);
    }

    public final ColorHex getBlend() {
        return this.blend;
    }

    public final Integer getBlendRes() {
        return this.blendRes;
    }

    public final ColorHex getFluid() {
        return this.fluid;
    }

    public final Integer getFluidRes() {
        return this.fluidRes;
    }

    public final void setBlendRes(Integer r2) {
        this.blendRes = r2;
        if (r2 == null) goto L5;
        ColorHex r3 = ColorTokenValueResolver.INSTANCE.resolve(r2.intValue());
    L6:
        this.blend = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setFluidRes(Integer r2) {
        this.fluidRes = r2;
        if (r2 == null) goto L5;
        ColorHex r3 = ColorTokenValueResolver.INSTANCE.resolve(r2.intValue());
    L6:
        this.fluid = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public ColorToken(Integer r3, Integer r4) {
        this.blendRes = r3;
        this.fluidRes = r4;
        ColorHex r0 = null;
        if (r3 == null) goto L5;
        ColorHex r5 = ColorTokenValueResolver.INSTANCE.resolve(r3.intValue());
    L6:
        this.blend = r5;
        if (r4 == null) goto L9;
        r0 = ColorTokenValueResolver.INSTANCE.resolve(r4.intValue());
    L9:
        this.fluid = r0;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public /* synthetic */ ColorToken(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}

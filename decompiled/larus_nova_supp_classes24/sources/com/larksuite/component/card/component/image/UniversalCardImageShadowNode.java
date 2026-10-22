package com.larksuite.component.card.component.image;

import com.google.gson.Gson;
import com.larksuite.component.card.component.g;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DeviceUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichTextElement;
import idb.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larksuite/component/card/component/image/UniversalCardImageShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "originWidth", "", "Ljava/lang/Integer;", "originHeight", "imageId", "", "hasValidAttachmentImages", "", "initMeasureFunction", "", "onLayout", "left", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "enableInvalidImageFix", "setContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "filterInvalidImages", "imageContent", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "getJsonAttachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "imageContentProps", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardImageShadowNode extends ShadowNode implements h {
    public Integer v;
    public Integer w;
    public String x;
    public boolean y;

    public static final class a {
    }

    static {
    }

    public UniversalCardImageShadowNode() {
        this.v = 0;
        this.w = 0;
        this.y = true;
        i(this);
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r7) {
        Intrinsics.checkNotNullParameter(r7, "props");
        TraceEvent.beginSection("UniversalCardImageShadowNode.setContent");
        RichTextElement.ImageProperty r2 = null;
        Gson r3 = g.a;     // Catch: Throwable -> L5
        com.larksuite.component.card.component.image.a r8 = (com.larksuite.component.card.component.image.a) g.c(r7, com.larksuite.component.card.component.image.a.class);     // Catch: Throwable -> L5
    L7:
        if (r8 != null) goto L10;
        Log.e("MsgCardImageShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.v = r8.h();
        this.w = r8.g();
        String r0 = r8.e();
        this.x = r0;
        LynxContext r4 = ((ShadowNode) this).m;
        boolean r5 = true;
        if (r4 == null) goto L34;
        if (r0 == null) goto L34;
        Object r6 = r4.getSharedData("card_share_data");
        if ((r6 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L16;
        com.larksuite.component.card.cardcontainer.c r9 = (com.larksuite.component.card.cardcontainer.c) r6;
    L17:
        if (r9 != null) goto L20;
    L24:
        CardAttachment r10 = null;
    L26:
        if (r10 == null) goto L30;
        HashMap<String, RichTextElement.ImageProperty> r11 = r10.getImages();
        if (r11 == null) goto L30;
        r2 = r11.get(r0);
    L30:
        if (r2 != null) goto L33;
        r5 = false;
    L33:
        this.y = r5;
    L35:
        TraceEvent.endSection("UniversalCardImageShadowNode.setContent");
        return;
    L20:
        if (r8.m() == false) goto L25;
        CardContent r12 = r9.b.getTranslateContent();
        if (r12 == null) goto L24;
        r10 = r12.getAttachment();
        goto L26
    L25:
        r10 = r9.b.getCardContent().getAttachment();
        goto L26
    L16:
        r9 = null;
    L34:
        this.y = true;
    L5:
        th = move-exception;
        Log.e("MsgCardImageShadowNode", "props from lynx transform failed", th);
        r8 = null;
        goto L7
    }

    public final void f(int r1, int r2) {
        TraceEvent.beginSection("UniversalCardImageShadowNode.onLayout");
        ((LayoutNode) this).e = false;
        TraceEvent.endSection("UniversalCardImageShadowNode.onLayout");
    }

    public final long c(LayoutNode r4, float r5, MeasureMode r6, float r7, MeasureMode r8) {
        TraceEvent.beginSection("UniversalCardImageShadowNode.measure");
        Integer r0 = this.v;
        if (r0 == null) goto L20;
        int r1 = r0.intValue();
        Integer r2 = this.w;
        if (r2 == null) goto L20;
        int r3 = r2.intValue();
        MeasureMode r9 = MeasureMode.UNDEFINED;
        if (r6 != r9) goto L11;
        if (r8 != r9) goto L11;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.b(r1, r3);
    L11:
        if (r6 == r9) goto L15;
        if (r8 != r9) goto L15;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a(r5, r5 / (r1 / r3));
    L15:
        if (r6 != r9) goto L18;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a((r1 / r3) * r7, r7);
    L18:
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a(r5, r7);
    L20:
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        if ((!f.a().isCurrentEnable("openplatform.universalcard.invalid_image_fix.disable")) == false) goto L25;
        if (this.y == true) goto L25;
    L34:
        return i.a(r5, r7);
    L25:
        if (k.b(this.x) == false) goto L34;
        MeasureMode r10 = MeasureMode.UNDEFINED;
        if (r8 != r10) goto L29;
        r7 = 32767.0f;
    L29:
        if (r6 != r10) goto L32;
        r5 = DeviceUtils.getScreenWidth(LarkContext.getApplication());
    L32:
        return i.a(r5, r7);
    }
}

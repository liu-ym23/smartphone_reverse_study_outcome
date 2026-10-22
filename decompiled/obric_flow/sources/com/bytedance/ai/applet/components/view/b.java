package com.bytedance.ai.applet.components.view;

import com.bytedance.android.lola.LolaCanvas;
import com.bytedance.ies.xelement.LynxBounceView;
import com.bytedance.ies.xelement.LynxImpressionView;
import com.bytedance.ies.xelement.LynxNestedScrollView;
import com.bytedance.ies.xelement.LynxScrollView;
import com.bytedance.ies.xelement.banner.LynxSwiperItemView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.input.AutoHeightInputShadowNode;
import com.bytedance.ies.xelement.input.LynxInputView;
import com.bytedance.ies.xelement.input.LynxInputViewLegacy;
import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.bytedance.ies.xelement.overlay.LynxOverlayViewProxy;
import com.bytedance.ies.xelement.text.inlineimage.LynxInlineImageShadowNode;
import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextUI;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.LynxViewPager;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.lynx.media.LynxAudioEngineView;
import com.bytedance.lynx.media.LynxVideoEngineUI;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.ui.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ int e;

    public /* synthetic */ b(String r5, boolean r10, boolean r11, boolean r12, int r13) {
        this.e = r13;
        super(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI c(b0 r5) {
        switch(this.e) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L34;
            case 13: goto L32;
            case 14: goto L30;
            case 15: goto L28;
            case 16: goto L26;
            case 17: goto L24;
            case 18: goto L22;
            case 19: goto L5;
            case 20: goto L5;
            case 21: goto L5;
            case 22: goto L20;
            case 23: goto L18;
            case 24: goto L16;
            case 25: goto L14;
            case 26: goto L12;
            case 27: goto L10;
            case 28: goto L8;
            case 29: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNull(r5);
        return new LynxTabbarItem(r5, null);
    L8:
        Intrinsics.checkNotNull(r5);
        return new LynxTabBarView(r5, null);
    L10:
        Intrinsics.checkNotNull(r5);
        return new UISvg(r5, null);
    L12:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new UIView(r5, null);
    L14:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new XSwiperUI(r5, null);
    L16:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxSwiperItemView(r5, null);
    L18:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxSwiperView(r5);
    L20:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxTextUI(r5, null);
    L22:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxImpressionView(r5, null);
    L24:
        Intrinsics.checkNotNull(r5);
        return new LynxBounceView(r5);
    L26:
        Intrinsics.checkNotNull(r5);
        return new LolaCanvas(r5);
    L28:
        Intrinsics.checkNotNull(r5);
        return new LynxViewpagerItem(r5);
    L30:
        Intrinsics.checkNotNull(r5);
        return new LynxViewPager(r5, null);
    L32:
        Intrinsics.checkNotNull(r5);
        return new LynxNestedScrollView(r5, null);
    L34:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxScrollView(r5, null);
    L36:
        Intrinsics.checkNotNullParameter(r5, "context");
        return LynxAnimaX.inst().createUI(r5);
    L38:
        Intrinsics.checkNotNullParameter(r5, "context");
        return LynxAnimaX.inst().createUI(r5);
    L5:
        return super.c(r5);
    }

    @Override // com.lynx.tasm.behavior.a
    public ShadowNode d() {
        switch(this.e) {
            case 3: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            default: goto L5;
        };
    L5:
        return super.d();
    L7:
        return new LynxTextShadowNode();
    L9:
        return new LynxInlineImageShadowNode();
    L11:
        return new LynxInlineTextShadowNode();
    L13:
        return new LynxInlineTruncationShadowNode();
    L15:
        return new LynxInlineTextShadowNode();
    L17:
        return new LynxInlineTruncationShadowNode();
    L19:
        return new LynxInlineImageShadowNode();
    L21:
        return new LynxTextShadowNode();
    L23:
        return new AutoHeightInputShadowNode();
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI e(b0 r5, z r10) {
        switch(this.e) {
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L10;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L9;
            case 11: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxAudioEngineView(r5, r10);
    L10:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxTextUI(r5, r10);
    L18:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxInputViewLegacy(r5, r10);
    L5:
        return super.e(r5, r10);
    L9:
        return new LynxVideoEngineUI(r5, r10);
    L13:
        return new LynxOverlayViewProxy(r5, r10);
    L15:
        return new LynxInputView(r5, r10);
    L17:
        return new LynxTextAreaView(r5, r10);
    }
}

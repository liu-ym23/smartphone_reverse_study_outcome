package com.ivy.ivykit.plugin.impl.render;

import com.bytedance.ies.xelement.input.AutoHeightInputShadowNode;
import com.bytedance.ies.xelement.input.LynxInputView;
import com.bytedance.ies.xelement.input.LynxTextAreaView;
import com.bytedance.ies.xelement.overlay.LynxOverlayViewProxy;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.viewpager.LynxViewPagerNG;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.shadow.text.RawTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.canvas.LynxHeliumCanvas;
import com.lynx.tasm.behavior.ui.frame.UIFrame;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.UIListItem;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIBounceView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.swiper.SwiperShadowNode;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.FrescoInlineImageShadowNode;
import com.lynx.tasm.ui.image.UIFilterImage;
import com.lynx.tasm.ui.image.UIImage;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ int e;

    public /* synthetic */ a(String r5, boolean r10, boolean r11, boolean r12, int r13) {
        this.e = r13;
        super(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.behavior.a
    public com.lynx.tasm.a a() {
        switch(this.e) {
            case 25: goto L7;
            default: goto L5;
        };
    L5:
        return super.a();
    L7:
        return new com.bytedance.frameworks.baselib.network.http.cronet.b(9);
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxFlattenUI b(b0 r5, z r10) {
        switch(this.e) {
            case 16: goto L13;
            case 17: goto L11;
            case 23: goto L9;
            case 25: goto L7;
            default: goto L5;
        };
    L5:
        return super.b(r5, r10);
    L7:
        return new FlattenUIImage(r5, r10);
    L9:
        return new LynxFlattenUI(r5, r10);
    L11:
        return new FlattenUIText(r5, r10);
    L13:
        return new LynxFlattenUI(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI c(b0 r5) {
        switch(this.e) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L8;
            case 28: goto L6;
            default: goto L5;
        };
    L6:
        LynxUIScrollView r10 = new LynxUIScrollView(r5, null);
        r10.f10612a = 0;
        r10.f10613b = 0;
        r10.f10614c = new int[]{0, 0};
        r10.d = 0;
        r10.e = 0;
        r10.f = false;
        r10.g = false;
        r10.f10615h = new ArrayList();
        return r10;
    L8:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxOverlayViewProxy(r5, null);
    L12:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxInputView(r5);
    L14:
        Intrinsics.checkNotNull(r5);
        return new LynxViewpagerItem(r5);
    L16:
        Intrinsics.checkNotNull(r5);
        return new LynxViewPagerNG(r5, null);
    L18:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxInputView(r5);
    L20:
        Intrinsics.checkNotNullParameter(r5, "context");
        return LynxAnimaX.inst().createUI(r5);
    L22:
        Intrinsics.checkNotNull(r5);
        return new LynxMapView(r5);
    L24:
        Intrinsics.checkNotNull(r5);
        return new LynxMapView(r5);
    L26:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxTextAreaView(r5, null);
    L28:
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxTextAreaView(r5, null);
    L30:
        Intrinsics.checkNotNull(r5);
        return new LynxTabbarItem(r5, null);
    L32:
        Intrinsics.checkNotNull(r5);
        return new LynxTabBarView(r5, null);
    L5:
        return super.c(r5);
    L11:
        return new LynxHeliumCanvas(r5);
    }

    @Override // com.lynx.tasm.behavior.a
    public ShadowNode d() {
        switch(this.e) {
            case 3: goto L21;
            case 17: goto L19;
            case 18: goto L17;
            case 19: goto L15;
            case 20: goto L13;
            case 25: goto L11;
            case 27: goto L9;
            case 29: goto L7;
            default: goto L5;
        };
    L5:
        return super.d();
    L7:
        return new SwiperShadowNode();
    L9:
        return new FrescoInlineImageShadowNode();
    L11:
        return new AutoSizeImage();
    L13:
        return new InlineTruncationShadowNode();
    L15:
        return new InlineTextShadowNode();
    L17:
        return new RawTextShadowNode();
    L19:
        return new TextShadowNode();
    L21:
        return new AutoHeightInputShadowNode();
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI e(b0 r5, z r10) {
        switch(this.e) {
            case 13: goto L29;
            case 14: goto L27;
            case 15: goto L25;
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L5;
            case 19: goto L5;
            case 20: goto L5;
            case 21: goto L19;
            case 22: goto L16;
            case 23: goto L15;
            case 24: goto L13;
            case 25: goto L11;
            case 26: goto L9;
            case 27: goto L5;
            case 28: goto L5;
            case 29: goto L7;
            default: goto L5;
        };
    L16:
        UIBounceView r11 = new UIBounceView(r5, r10);
        r11.f10635a = 0;
        return r11;
    L5:
        return super.e(r5, r10);
    L7:
        return new XSwiperUI(r5, r10);
    L9:
        return new UIFilterImage(r5, r10);
    L11:
        return new UIImage(r5, r10);
    L13:
        return new UIList(r5, r10);
    L15:
        return new UIComponent(r5, r10);
    L19:
        return new UIScrollView(r5, r10);
    L21:
        return new UIText(r5, r10);
    L23:
        return new UIView(r5, r10);
    L25:
        return new UIFrame(r5, r10);
    L27:
        return new UIListContainer(r5, r10);
    L29:
        return new UIListItem(r5, r10);
    }
}

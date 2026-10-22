package lm;

import com.bytedance.ies.xelement.LynxBounceView;
import com.bytedance.ies.xelement.LynxNestedScrollView;
import com.bytedance.ies.xelement.LynxScrollView;
import com.bytedance.ies.xelement.banner.LynxSwiperItemView;
import com.bytedance.ies.xelement.banner.LynxSwiperView;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.LynxViewPager;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldHeader;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlot;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldSlotDrag;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.bytedance.ies.xelement.viewpager.childitem.LynxTabbarItem;
import com.bytedance.ies.xelement.viewpager.childitem.LynxViewpagerItem;
import com.bytedance.ies.xelement.viewpager.foldview.LynxFoldViewNG;
import com.bytedance.ies.xelement.viewpager.viewpager.LynxViewPagerNG;
import com.bytedance.lynx.map.ng.LynxMapMarker;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.lynx.component.svg.UISvg;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.xelement.input.LynxUIInputNG;
import com.lynx.xelement.input.LynxUIInputNGShadowNode;
import com.lynx.xelement.input.LynxUITextAreaNG;
import com.lynx.xelement.input.LynxUITextAreaNGShadowNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ int e;

    public /* synthetic */ a(String r5, boolean r10, boolean r11, boolean r12, int r13) {
        this.e = r13;
        super(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI c(b0 r5) {
        switch(this.e) {
            case 6: goto L9;
            case 12: goto L7;
            default: goto L5;
        };
    L5:
        return super.c(r5);
    L7:
        return new LynxBounceView(r5);
    L9:
        return new LynxSwiperView(r5);
    }

    @Override // com.lynx.tasm.behavior.a
    public ShadowNode d() {
        switch(this.e) {
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return super.d();
    L7:
        return new LynxUIInputNGShadowNode();
    L9:
        return new LynxUITextAreaNGShadowNode();
    }

    @Override // com.lynx.tasm.behavior.a
    public LynxUI e(b0 r5, z r10) {
        switch(this.e) {
            case 0: goto L61;
            case 1: goto L59;
            case 2: goto L57;
            case 3: goto L55;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L5;
            case 7: goto L49;
            case 8: goto L47;
            case 9: goto L45;
            case 10: goto L43;
            case 11: goto L41;
            case 12: goto L5;
            case 13: goto L39;
            case 14: goto L37;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L31;
            case 18: goto L29;
            case 19: goto L27;
            case 20: goto L25;
            case 21: goto L22;
            case 22: goto L21;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L15;
            case 26: goto L13;
            case 27: goto L11;
            case 28: goto L8;
            case 29: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxFoldSlot(r5, r10);
    L8:
        LynxFoldViewNG r11 = new LynxFoldViewNG(r5, r10);
        r11.d = true;
        return r11;
    L22:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxFoldSlotDrag(r5, r10);
    L50:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxUIInputNG(r5, r10);
    L52:
        Intrinsics.checkNotNullParameter(r5, "context");
        return new LynxUITextAreaNG(r5, r10);
    L5:
        return super.e(r5, r10);
    L11:
        return new LynxViewpagerItem(r5, r10);
    L13:
        return new LynxViewpagerItem(r5, r10);
    L15:
        return new LynxTabBarView(r5, r10);
    L17:
        return new LynxTabBarView(r5, r10);
    L19:
        return new LynxViewpagerItem(r5, r10);
    L21:
        return new LynxViewPagerNG(r5, r10);
    L25:
        return new LynxTabbarItem(r5, r10);
    L27:
        return new LynxTabbarItem(r5, r10);
    L29:
        return new LynxFoldHeader(r5, r10);
    L31:
        return new LynxFoldHeader(r5, r10);
    L33:
        return new LynxFoldHeader(r5, r10);
    L35:
        return new LynxViewPager(r5, r10);
    L37:
        return new LynxViewPager(r5, r10);
    L39:
        return new LynxFoldToolbar(r5, r10);
    L41:
        return new LynxScrollView(r5, r10);
    L43:
        return new LynxNestedScrollView(r5, r10);
    L45:
        return new LynxNestedScrollView(r5, r10);
    L47:
        return new LynxSwiperItemView(r5, r10);
    L49:
        return new LynxSwiperItemView(r5, r10);
    L55:
        return new LynxMapView(r5, r10);
    L57:
        return new LynxMapMarker(r5, r10);
    L59:
        return new UISvg(r5, r10);
    L61:
        return new UISvg(r5, r10);
    }
}

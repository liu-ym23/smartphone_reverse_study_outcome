package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.xelement.viewpager.Pager;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 F2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001GB\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010B\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bC\u0010DB\u0013\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010EJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bH\u0016J/\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0007J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nH\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0016J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0016J\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0015J \u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\nH\u0016R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00109¨\u0006H"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/LynxUIViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/a;", NameKeys.UnloadStrategy_No_Strategy, "positionOffset", NameKeys.UnloadStrategy_No_Strategy, "recognizeGestureWhenScroll", NameKeys.UnloadStrategy_No_Strategy, "index", NameKeys.UnloadStrategy_No_Strategy, "dragged", "sendTabWillChangeEvent", "Landroid/content/Context;", "context", "createView", "onNodeReload", "initListener", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem;", "child", "addPagerChildItem", NameKeys.UnloadStrategy_No_Strategy, "format", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "args", "handleFormatStr", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "enable", "setPageChangeAnimation", "setForceCanScroll", "setSinglePageTouch", "isAlwaysOverScroll", "setAndroidAlwaysOverscroll", "isDistinguish", "setDistinguishSwipeTap", "selectIndex", "setInitialSelect", "setEnableScroll", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "overflow", "setOverflow", "setDragGesture", "initViewPagerChangeListener", "onNodeReady", "offset", "sendOffsetChangeEvent", "tag", "scene", "sendTabChangeEvent", "selectIndexIsSet", "isScrollContainer", "mDragged", "Z", "mLastOffset", "F", "mDistinguishTapSwap", "mSinglePageTouch", "mIndexSelectedWhileIdle", "I", "mInitialSelectIndex", "mDraggingDetectedByDraggingAndActionUp", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "Companion", "a", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIViewPager extends BaseLynxViewPager<CustomViewPager, com.lynx.xelement.viewpager.viewpager.a> {
    public static final String BIND_ON_WILL_CHANGED = "willchange";
    public static final a Companion = null;
    public static final int INVALID_VIEW_PAGER_INDEX = -1;
    private boolean mDistinguishTapSwap;
    private boolean mDragged;
    private boolean mDraggingDetectedByDraggingAndActionUp;
    private int mIndexSelectedWhileIdle;
    private int mInitialSelectIndex;
    private float mLastOffset;
    private boolean mSinglePageTouch;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements CustomViewPager.a {
        public final /* synthetic */ LynxUIViewPager a;

        public b(LynxUIViewPager r1) {
            this.a = r1;
        }

        @Override // com.lynx.xelement.viewpager.viewpager.CustomViewPager.a
        public final void onTouch(MotionEvent r4) {
            if (r4 == null) goto L4;
            Integer r5 = Integer.valueOf(r4.getActionMasked());
        L6:
            if (r5 != null) goto L9;
        L14:
            if (r5 != null) goto L17;
            return;
        L17:
            if (r5.intValue() == 3) goto L19;
            return;
        L19:
            if (LynxUIViewPager.access$getMDraggingDetectedByDraggingAndActionUp$p(this.a) == false) goto L21;
            LynxUIViewPager r6 = this.a;
            LynxUIViewPager.access$sendTabWillChangeEvent(r6, r6.getMPager().getMViewPager().getCurrentItem(), true);
        L21:
            LynxUIViewPager.access$setMDraggingDetectedByDraggingAndActionUp$p(this.a, false);
            return;
        L9:
            if (r5.intValue() != 1) goto L14;
            if (LynxUIViewPager.access$getMDraggingDetectedByDraggingAndActionUp$p(this.a) == false) goto L13;
            LynxUIViewPager r7 = this.a;
            LynxUIViewPager.access$sendTabWillChangeEvent(r7, r7.getMPager().getMViewPager().getCurrentItem(), true);
        L13:
            LynxUIViewPager.access$setMDraggingDetectedByDraggingAndActionUp$p(this.a, false);
            return;
        L4:
            r5 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void initViewPagerChangeListener() {
        getMPager().getMViewPager().addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mFirstRender == false) goto L13;
        int r0 = this.mInitialSelectIndex;
        if (r0 == (-1)) goto L13;
        if (r0 < 0) goto L13;
        PagerAdapter r2 = getMPager().getMViewPager().getAdapter();
        if (r2 == null) goto L10;
        int r3 = r2.getCount();
    L11:
        if (r0 >= r3) goto L13;
        getMPager().setCurrentSelectIndex(this.mInitialSelectIndex);
        this.mIndexSelectedWhileIdle = getMPager().getMViewPager().getCurrentItem();
        goto L13
    L10:
        r3 = 0;
    L13:
        this.mFirstRender = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReload() {
        super.onNodeReload();
        getMPager().a.setCurrentItem(0, false);
    }

    public LynxUIViewPager(LynxContext r2) {
        this(r2, null);
    }

    public static final /* synthetic */ boolean access$getMDraggingDetectedByDraggingAndActionUp$p(LynxUIViewPager r0) {
        return r0.mDraggingDetectedByDraggingAndActionUp;
    }

    public static final /* synthetic */ int access$getMIndexSelectedWhileIdle$p(LynxUIViewPager r0) {
        return r0.mIndexSelectedWhileIdle;
    }

    public static final /* synthetic */ boolean access$getMSinglePageTouch$p(LynxUIViewPager r0) {
        return r0.mSinglePageTouch;
    }

    private final void recognizeGestureWhenScroll(float r2) {
        if (this.mDistinguishTapSwap == true) goto L5;
        return;
    L5:
        if (this.mLastOffset != r2) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        recognizeGesturere();
        this.mLastOffset = r2;
        return;
    L12:
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager, com.lynx.tasm.behavior.ui.LynxUI
    public com.lynx.xelement.viewpager.viewpager.a createView(Context r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        setMPager(new com.lynx.xelement.viewpager.viewpager.a(r2));
        initListener(r2);
        return getMPager();
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void initListener(Context r2) {
        super.initListener(r2);
        getMPager().getMViewPager().setMTouchHandler(new b(this));
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void selectIndexIsSet(int r2) {
        if (this.mIndexSelectedWhileIdle == r2) goto L6;
        this.mIndexSelectedWhileIdle = r2;
        sendTabChangeEvent(NameKeys.UnloadStrategy_No_Strategy, r2, NameKeys.UnloadStrategy_No_Strategy);
        return;
    }

    public final void sendOffsetChangeEvent(String r6) {
        Intrinsics.checkNotNullParameter(r6, "offset");
        EventEmitter r1 = getLynxContext().getEventEmitter();
        m7a.a r2 = new m7a.a(getSign(), BaseLynxViewPager.BIND_OFFSET_CHANGE);
        r2.a("offset", r6);
        r1.sendCustomEvent(r2);
    }

    @LynxProp(defaultBoolean = false, name = "android-always-overscroll")
    public final void setAndroidAlwaysOverscroll(boolean r2) {
        getMPager().setViewPagerOverScrollMode(r2);
    }

    @LynxProp(defaultBoolean = true, name = "android-distinguish-swipe-tap")
    public final void setDistinguishSwipeTap(boolean r1) {
        this.mDistinguishTapSwap = r1;
    }

    @LynxProp(name = "enable-scroll")
    public final void setEnableScroll(boolean r2) {
        getMPager().setAllowHorizontalGesture(r2);
    }

    @LynxProp(name = "android-force-can-scroll")
    public final void setForceCanScroll(boolean r2) {
        getMPager().setForceCanScroll(r2);
    }

    @LynxProp(name = "initial-select-index")
    public final void setInitialSelect(int r1) {
        this.mInitialSelectIndex = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setOverflow(int r2) {
        super.setOverflow(r2);
        boolean r0 = true;
        if (r2 == 1) goto L6;
        r0 = false;
    L6:
        getMPager().setClipChildren(r0);
        ((CustomViewPager) getMPager().getMViewPager()).setClipChildren(r0);
    }

    @LynxProp(name = "page-change-animation")
    public final void setPageChangeAnimation(boolean r2) {
        getMPager().setPagerChangeAnimation(r2);
    }

    @LynxProp(name = "single-page-touch")
    public final void setSinglePageTouch(boolean r1) {
        this.mSinglePageTouch = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager, com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ Pager createView(Context r1) {
        return createView(r1);
    }

    public LynxUIViewPager(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mDistinguishTapSwap = true;
        this.mInitialSelectIndex = -1;
    }

    public static final /* synthetic */ void access$recognizeGestureWhenScroll(LynxUIViewPager r0, float r1) {
        r0.recognizeGestureWhenScroll(r1);
    }

    public static final /* synthetic */ void access$setMDragged$p(LynxUIViewPager r0, boolean r1) {
        r0.mDragged = r1;
    }

    public static final /* synthetic */ void access$setMDraggingDetectedByDraggingAndActionUp$p(LynxUIViewPager r0, boolean r1) {
        r0.mDraggingDetectedByDraggingAndActionUp = r1;
    }

    public static final /* synthetic */ void access$setMIndexSelectedWhileIdle$p(LynxUIViewPager r0, int r1) {
        r0.mIndexSelectedWhileIdle = r1;
    }

    private final void sendTabWillChangeEvent(int r5, boolean r6) {
        EventEmitter r0 = getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(getSign(), BIND_ON_WILL_CHANGED);
        r1.a("isDragged", Boolean.valueOf(r6));
        r1.a("index", Integer.valueOf(r5));
        r0.sendCustomEvent(r1);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void addPagerChildItem(LynxViewpagerItem r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "child");
        com.lynx.xelement.viewpager.viewpager.a r1 = getMPager();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "child");
        r1.setMChanged(true);
        if (r4 >= 0) goto L5;
    L8:
        r1.getMPendingChildren().add(r3);
        return;
    L5:
        if (r4 > r1.getMPendingChildren().size()) goto L8;
        ListProtector.add(r1.getMPendingChildren(), r4, r3);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public String handleFormatStr(String r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r6, "args");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(Locale.ENGLISH, r5, Arrays.copyOf(new Object[]{r6}, 1));
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    @LynxUIMethod
    public void selectTab(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("success", Boolean.FALSE);
        if (r10.hasKey("index") == false) goto L25;
        int r1 = r10.getInt("index");
        if (r1 < 0) goto L22;
        PagerAdapter r3 = getMPager().getMViewPager().getAdapter();
        if (r3 == null) goto L9;
        int r4 = r3.getCount();
    L10:
        if (r1 >= r4) goto L22;
        sendTabWillChangeEvent(r1, false);
        if (r10.hasKey("smooth") == false) goto L18;
        boolean r12 = r10.getBoolean("smooth", true);
        getMPager().a.setCurrentItem(r1, r12);
        if (r12 == false) goto L16;
    L19:
        r0.put("success", Boolean.TRUE);
        if (r11 == null) goto L29;
        r11.invoke(new Object[]{0, r0});
        return;
    L29:
        return;
    L16:
        if (this.mIndexSelectedWhileIdle == getMPager().getMViewPager().getCurrentItem()) goto L19;
        int r13 = getMPager().getMViewPager().getCurrentItem();
        this.mIndexSelectedWhileIdle = r13;
        sendTabChangeEvent(NameKeys.UnloadStrategy_No_Strategy, r13, NameKeys.UnloadStrategy_No_Strategy);
        goto L19
    L18:
        getMPager().a.setCurrentItem(r1, true);
        goto L19
    L9:
        r4 = 0;
    L22:
        r0.put("msg", "index out of bounds");
        if (r11 == null) goto L31;
        r11.invoke(new Object[]{4, r0});
        return;
    L31:
        return;
    L25:
        r0.put("msg", "no index key");
        if (r11 == null) goto L33;
        r11.invoke(new Object[]{4, r0});
        return;
    }

    @LynxUIMethod
    public final void setDragGesture(ReadableMap r4, Callback r5) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.PARAMS_KEY);
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("success", Boolean.FALSE);
        if (r4.hasKey("canDrag") == false) goto L5;
        setAllowHorizontalGesture(r4.getBoolean("canDrag"));
    L5:
        if (r5 == null) goto L8;
        r5.invoke(new Object[]{0, r0});
        return;
    }

    public static final /* synthetic */ void access$sendTabWillChangeEvent(LynxUIViewPager r0, int r1, boolean r2) {
        r0.sendTabWillChangeEvent(r1, r2);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void sendTabChangeEvent(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r5, "scene");
        EventEmitter r6 = getLynxContext().getEventEmitter();
        m7a.a r7 = new m7a.a(getSign(), BaseLynxViewPager.BIND_ON_CHANGED);
        r7.a("isDragged", Boolean.valueOf(this.mDragged));
        r7.a("index", Integer.valueOf(r4));
        r6.sendCustomEvent(r7);
    }
}

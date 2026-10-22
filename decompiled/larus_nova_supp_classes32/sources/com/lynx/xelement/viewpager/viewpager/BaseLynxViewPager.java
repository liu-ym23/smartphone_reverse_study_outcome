package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.xelement.viewpager.Pager;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.lynx.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 V*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006:\u0001WB\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010R\u0012\b\u00103\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bS\u0010TB\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010R¢\u0006\u0004\bS\u0010UJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001b\u0010\f\u001a\u0004\u0018\u00018\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\nH$¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J/\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH&J\b\u0010\u001b\u001a\u00020\u0007H&J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u001e\u0010&\u001a\u00020\u00072\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000fH\u0007J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020'H\u0007J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0017H\u0007J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020'H\u0007J\u001c\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u0002022\n\b\u0002\u00105\u001a\u0004\u0018\u000104H'J\u0010\u00108\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0017H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\"\u0010:\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\"\u0010C\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bI\u0010;\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\"\u0010L\u001a\u00028\u00018\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006X"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/BaseCustomViewPager;", "K", "Lcom/lynx/xelement/viewpager/Pager;", "T", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/r0;", NameKeys.UnloadStrategy_No_Strategy, "initGestureListener", "initPagerListener", "Landroid/content/Context;", "context", "createView", "(Landroid/content/Context;)Lcom/lynx/xelement/viewpager/Pager;", "initListener", NameKeys.UnloadStrategy_No_Strategy, "format", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "args", "handleFormatStr", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "tag", NameKeys.UnloadStrategy_No_Strategy, "index", "scene", "sendTabChangeEvent", "initViewPagerChangeListener", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem;", "child", "addPagerChildItem", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "insertChild", "removeChild", "layoutChildren", NameKeys.UnloadStrategy_No_Strategy, "Lcom/lynx/tasm/event/EventsListener;", "events", "setEvents", NameKeys.UnloadStrategy_No_Strategy, "needCustomLayout", "onPatchFinish", "color", "setBackground", "enable", "setAllowHorizontalGesture", "selectIndex", "setSelect", "keepItemView", "setKeepItemView", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "direction", "setLynxDirection", "selectIndexIsSet", "mEnableChangeEvent", "Z", "getMEnableChangeEvent", "()Z", "setMEnableChangeEvent", "(Z)V", "mEnableOffsetChangeEvent", "getMEnableOffsetChangeEvent", "setMEnableOffsetChangeEvent", "mCurrentOffset", "Ljava/lang/String;", "getMCurrentOffset", "()Ljava/lang/String;", "setMCurrentOffset", "(Ljava/lang/String;)V", "mIsKeepItemView", "getMIsKeepItemView", "setMIsKeepItemView", "mPager", "Lcom/lynx/xelement/viewpager/Pager;", "getMPager", "()Lcom/lynx/xelement/viewpager/Pager;", "setMPager", "(Lcom/lynx/xelement/viewpager/Pager;)V", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "Companion", "a", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseLynxViewPager<K extends BaseCustomViewPager, T extends Pager<K>> extends UISimpleView<T> implements r0 {
    public static final String BIND_OFFSET_CHANGE = "offsetchange";
    public static final String BIND_ON_CHANGED = "change";
    public static final a Companion = null;
    public static final String TAG = "LynxViewPager";
    private String mCurrentOffset;
    private boolean mEnableChangeEvent;
    private boolean mEnableOffsetChangeEvent;
    private boolean mIsKeepItemView;
    protected T mPager;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Pager.b {
        @Override // com.lynx.xelement.viewpager.Pager.b
        public final void a() {
        }

        public b(BaseLynxViewPager<K, T> r1) {
        }
    }

    static {
        Companion = new a();
    }

    public abstract void addPagerChildItem(LynxViewpagerItem r1, int r2);

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public abstract T createView(Context r1);

    public abstract void initViewPagerChangeListener();

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean needCustomLayout() {
        return true;
    }

    public void selectIndexIsSet(int r1) {
    }

    @LynxUIMethod
    public abstract void selectTab(ReadableMap r1, Callback r2);

    public abstract void sendTabChangeEvent(String r1, int r2, String r3);

    public T getMPager() {
        T r0 = this.mPager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mPager");
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void layoutChildren() {
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L20;
        LynxBaseUI r2 = (LynxBaseUI) ListProtector.get(this.mChildren, r1);
        if (this.mIsKeepItemView == true) goto L12;
        if ((r2 instanceof LynxUI) == false) goto L12;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r2).getView()) == true) goto L12;
    L19:
        r1 = r1 + 1;
    L12:
        if (needCustomLayout() == true) goto L17;
        if ((r2 instanceof LynxUI) == false) goto L19;
        r2.layout();
        goto L19
    L17:
        if ((r2 instanceof UIGroup) == false) goto L19;
        ((UIGroup) r2).layoutChildren();
        goto L19
    }

    private final void initGestureListener() {
        getMPager().getMViewPager().setMInterceptTouchEventListener(new b(this));
    }

    @Override // com.lynx.tasm.behavior.r0
    public void onPatchFinish() {
        if (getMPager().getMChanged() == false) goto L15;
        Pager r0 = getMPager();
        if (r0.h == false) goto L13;
        r0.h = false;
        ((ArrayList) r0.b).clear();
        ((ArrayList) r0.b).addAll(r0.c);
        r0.f.notifyDataSetChanged();
        PagerAdapter r2 = r0.a.getAdapter();
        if (r2 == null) goto L9;
        int r3 = r2.getCount();
    L10:
        if (r3 == 0) goto L13;
        r0.a.setCurrentItem(RangesKt.coerceIn(r0.e, 0, r3 - 1), false);
        goto L13
    L9:
        r3 = 0;
    L13:
        selectIndexIsSet(getMPager().getMViewPager().getCurrentItem());
        return;
    }

    private final void initPagerListener() {
        initViewPagerChangeListener();
    }

    public final String getMCurrentOffset() {
        return this.mCurrentOffset;
    }

    public final boolean getMEnableChangeEvent() {
        return this.mEnableChangeEvent;
    }

    public final boolean getMEnableOffsetChangeEvent() {
        return this.mEnableOffsetChangeEvent;
    }

    public final boolean getMIsKeepItemView() {
        return this.mIsKeepItemView;
    }

    public BaseLynxViewPager(LynxContext r2) {
        this(r2, null);
    }

    public void initListener(Context r1) {
        initGestureListener();
        initPagerListener();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void removeChild(LynxBaseUI r4) {
        Intrinsics.checkNotNullParameter(r4, "child");
        if ((r4 instanceof LynxUI) == false) goto L9;
        this.mChildren.remove(r4);
        ((LynxUI) r4).setParent(null);
        if ((r4 instanceof LynxViewpagerItem) == false) goto L7;
        Pager r1 = getMPager();
        LynxViewpagerItem r5 = (LynxViewpagerItem) r4;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "child");
        r1.h = true;
        ((ArrayList) r1.c).remove(r5);
        return;
    L7:
        LLog.e(TAG, "viewpager child is illegal, please check behaviors");
        return;
    }

    @LynxProp(name = "allow-horizontal-gesture")
    public final void setAllowHorizontalGesture(boolean r2) {
        getMPager().setAllowHorizontalGesture(r2);
    }

    @LynxProp(name = "background")
    public final void setBackground(String r4) {
        Intrinsics.checkNotNullParameter(r4, "color");
        Pager r0 = getMPager();
        int r1 = s8a.a.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.length() > 7) goto L5;
        int r5 = ColorProtector.parseColor(r4);
    L6:
        r0.setBackgroundColor(r5);
        return;
    L5:
        int r6 = ColorProtector.parseColor(r4);
        int r2 = r6 >>> 8;
        r5 = (r6 << 24) | r2;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r1) {
        super.setEvents(r1);
        if (r1 == null) goto L6;
        this.mEnableChangeEvent = true;
        return;
    }

    @LynxProp(name = "keep-item-view")
    public final void setKeepItemView(boolean r2) {
        this.mIsKeepItemView = r2;
        getMPager().setKeepItemView(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setLynxDirection(int r2) {
        super.setLynxDirection(r2);
        getMPager().setLynxDirection(r2);
    }

    public final void setMCurrentOffset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mCurrentOffset = r2;
    }

    public final void setMEnableChangeEvent(boolean r1) {
        this.mEnableChangeEvent = r1;
    }

    public final void setMEnableOffsetChangeEvent(boolean r1) {
        this.mEnableOffsetChangeEvent = r1;
    }

    public final void setMIsKeepItemView(boolean r1) {
        this.mIsKeepItemView = r1;
    }

    public void setMPager(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mPager = r2;
    }

    @LynxProp(name = "select-index")
    public final void setSelect(int r2) {
        if (getMPager().getMViewPager().getCurrentItem() != r2) goto L5;
        return;
    L5:
        if (r2 < 0) goto L12;
        PagerAdapter r0 = getMPager().getMViewPager().getAdapter();
        if (r0 == null) goto L9;
        int r1 = r0.getCount();
    L10:
        if (r2 >= r1) goto L12;
        getMPager().setCurrentSelectIndex(r2);
        goto L12
    L9:
        r1 = 0;
    L12:
        getMPager().setSelectedIndex(r2);
    }

    public BaseLynxViewPager(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mEnableOffsetChangeEvent = true;
        this.mCurrentOffset = NameKeys.UnloadStrategy_No_Strategy;
    }

    public String handleFormatStr(String r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "format");
        Intrinsics.checkNotNullParameter(r5, "args");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return String.format(r4, Arrays.copyOf(new Object[]{r5}, 1));
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void insertChild(LynxBaseUI r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if ((r2 instanceof LynxUI) == false) goto L9;
        ListProtector.add(this.mChildren, r3, r2);
        ((LynxUI) r2).setParent(this);
        if ((r2 instanceof LynxViewpagerItem) == false) goto L7;
        addPagerChildItem((LynxViewpagerItem) r2, r3);
        return;
    L7:
        LLog.e(TAG, "viewpager child is illegal, please check behaviors");
        return;
    }

    public static /* synthetic */ void selectTab$default(BaseLynxViewPager r0, ReadableMap r1, Callback r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.selectTab(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectTab");
    }
}

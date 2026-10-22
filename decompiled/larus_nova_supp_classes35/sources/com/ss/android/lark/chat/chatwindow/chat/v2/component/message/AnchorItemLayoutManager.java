package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001\u0014\u0018\u0000 ;2\u00020\u0001:\u00039:;B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0082\bJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u001e\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J \u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0016J\u001a\u00103\u001a\u00020\u00172\u0006\u00100\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u00010\u001bH\u0002J(\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J,\u00107\u001a\u00020\u0017*\u00020\u00122\u0006\u00106\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\f\u00108\u001a\u00020\u0017*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager;", "Lcom/larksuite/framework/ui/StableLinearLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "orientation", BuildConfig.FLAVOR, "reverseLayout", BuildConfig.FLAVOR, "isChildRectangleOnScreen", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;IZZ)V", "anchorPositionProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$IAnchorPositionProvider;", "anchorBlankSpace", "anchorOffset", "measureState", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$MeasureStateOnScroll;", "offsetDecoration", "com/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$offsetDecoration$1", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/AnchorItemLayoutManager$offsetDecoration$1;", "onLayoutChildren", BuildConfig.FLAVOR, "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "computeTimeCostAndLog", "tag", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, "Lkotlin/Function0;", "setAnchorOffset", "getAnchorOffset", "setAnchorPositionProvider", "provider", "getAnchorBlankSpace", "findAnchorViewPosition", "children", BuildConfig.FLAVOR, "Landroid/view/View;", "findLastViewPosition", "computeAnchorSpaceIfNeed", "binSearchViewInScreen", "targetPosition", "views", "measureChildWithMargins", "child", "widthUsed", "heightUsed", "forceUpdateItemDecoration", "rvState", "scrollVerticallyBy", "dy", "setScrollState", "reset", "MeasureStateOnScroll", "IAnchorPositionProvider", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchorItemLayoutManager extends StableLinearLayoutManager {
    public static final Lazy<Method> d = null;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(AnchorItemLayoutManager$Companion$method$2.INSTANCE);
    }

    public final void onLayoutChildren(RecyclerView.Recycler r3, RecyclerView.State r4) {
        long r0 = System.currentTimeMillis();
        super.onLayoutChildren(r3, r4);
        Log.d("AnchorItemLayoutManager", "first onLayoutChildren:, cost " + (System.currentTimeMillis() - r0) + " millis");
        throw null;
    }

    public final void measureChildWithMargins(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.measureChildWithMargins(r2, r3, r4);
        throw null;
    }

    public final int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        throw null;
    }
}

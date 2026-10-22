package com.obric.oui.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.common.util.h;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r*\u0001B\u0018\u0000 \u0098\u00012\u00020\u0001:\u0006\u0098\u0001\u0099\u0001\u009a\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002J\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020oH\u0002J\u0018\u0010r\u001a\u00020o2\u0006\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0016H\u0002J\u0018\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0002J\n\u0010x\u001a\u0004\u0018\u00010yH\u0002J\b\u0010z\u001a\u00020\u0007H\u0002J\u0010\u0010{\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010|\u001a\u00020\u0007H\u0002J\u0012\u0010}\u001a\u00020o2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010~\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0014\u0010\u007f\u001a\u00020o2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0014J\u001b\u0010\u0082\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0086\u0001\u001a\u00020oH\u0002J\t\u0010\u0087\u0001\u001a\u00020oH\u0002J\u0019\u0010\u000f\u001a\u00020o2\u0006\u0010\u000b\u001a\u00020\u00072\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0016J%\u0010\u0089\u0001\u001a\u00020o2\u0016\u0010\u008a\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u008c\u00010\u008b\u0001\"\u00030\u008c\u0001¢\u0006\u0003\u0010\u008d\u0001J\u001a\u0010\u0089\u0001\u001a\u00020o2\u0011\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008e\u0001J#\u0010\u0089\u0001\u001a\u00020o2\u0011\u0010\u008a\u0001\u001a\f\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0007J,\u0010\u0090\u0001\u001a\u00020o2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u008e\u00012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0017\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0016J\u0010\u0010\u0094\u0001\u001a\u00020o2\u0007\u0010\u0095\u0001\u001a\u00020\u0012J\t\u0010\u0096\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0097\u0001\u001a\u00020oH\u0002R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\u0011\u0010(\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b)\u0010\u000eR\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0010R\u000e\u00104\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR$\u0010D\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R$\u0010G\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u000e\u0010J\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010K\u001a\u0002002\u0006\u0010 \u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001fR$\u0010S\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010\u0010R\u000e\u0010V\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010W\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\\\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010]\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010\u0010R$\u0010`\u001a\u0002002\u0006\u0010 \u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010M\"\u0004\bb\u0010OR\u000e\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0014\"\u0004\bi\u0010jR\u000e\u0010k\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009b\u0001"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/obric/oui/picker/reels/views/WheelView$WheelAdapter;", "index", "currentIndex", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentItem", "", "getCurrentItem", "()Ljava/lang/CharSequence;", "hasSettledSinceDrag", "", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "setHighlightConorRadiusPx", "horizontalPaddingPx", "cyclic", "isCyclic", "()Z", "setCyclic", "(Z)V", EventBody.KEY_VALUE, "itemCount", "getItemCount", "setItemCount", "itemHeight", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "itemSize", "getItemSize", "lastCenterIndex", "lastChangedDataIndex", "lastHapticIndex", "layoutManager", "Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "maxTextWidth", "", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "normalTextSizePx", "onWheelChangedListener", "Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/OnWheelChangedListener;)V", "pendingInitialIndex", "pendingInitialScrollPosition", "pendingVerifyCenterAdapterPosition", "programmaticScrolling", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "scrollListener", "com/obric/oui/picker/reels/views/WheelView$scrollListener$1", "Lcom/obric/oui/picker/reels/views/WheelView$scrollListener$1;", "selectedItemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "selectedTextSizePx", "selectedTextSizePxProp", "getSelectedTextSizePxProp", "()F", "setSelectedTextSizePxProp", "(F)V", "showDivider", "getShowDivider", "setShowDivider", "startIndex", "getStartIndex", "setStartIndex", "suppressNextSnapOnce", "tagGap", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "textColor", "getTextColor", "setTextColor", "textSizePx", "getTextSizePx", "setTextSizePx", "tvTag", "Landroid/widget/TextView;", "userScrolling", "visibleRowCount", "wheelTagText", "getWheelTagText", "setWheelTagText", "(Ljava/lang/CharSequence;)V", "wheelTextSizePx", "adapterToDataIndex", "adapterPos", "animateMove", "", "delta", "applyPendingInitialSelection", "centerToPosition", "position", "animate", "dataToAdapterPosition", "dataIndex", "dataSize", "findCenterChild", "Landroid/view/View;", "findNearestCenterIndex", "getItem", "halfRows", "initAttrs", "isValidDataIndex", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "recyclerCenterY", "refreshDimensionCache", "scheduleInitialSelectionIfNeeded", "animated", "setEntries", "entries", "", "", "([Ljava/lang/String;)V", "", "selectedIndex", "setItems", "items", "(Ljava/util/List;Ljava/lang/Integer;)V", "setSelectedIndex", "setTagText", LocationMonitorConst.TAG, "snapToNearestCenter", "updateRecyclerPaddingForCenter", "Companion", "WheelAdapter", "WheelVH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14296a = null;
    private Integer A;
    private int B;
    private int C;
    private com.obric.oui.picker.reels.views.a D;
    private final d E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerView f14297b;
    private final TextView c;
    private final com.obric.oui.picker.reels.views.d d;
    private final b e;
    private int f;
    private float g;
    private int h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    private CharSequence z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$Companion;", "", "()V", "REPEAT", "", "TAG_TEXT_SIZE", "", "VISIBLE_ROW_COUNT", "WHEEL_TEXT_SIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$WheelAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/oui/picker/reels/views/WheelView$WheelVH;", "(Lcom/obric/oui/picker/reels/views/WheelView;)V", "items", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "data", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f14298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<CharSequence> f14299b;

        public b(WheelView r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14298a = r2;
            this.f14299b = new ArrayList();
        }

        private static final void a(c r0, WheelView r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "$holder");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            int r3 = r0.n();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.a(r1, r3);
            if (WheelView.b(r1, r4) == false) goto L9;
            r1.b(r4, true);
            return;
        L9:
            return;
        }

        private static final void b(c r0, WheelView r1, View r2) {
            Intrinsics.checkNotNullParameter(r0, "$holder");
            Intrinsics.checkNotNullParameter(r1, "this$0");
            int r3 = r0.n();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.a(r1, r3);
            if (WheelView.b(r1, r4) == false) goto L9;
            r1.b(r4, true);
            return;
        L9:
            return;
        }

        public static /* synthetic */ void lambda$B34hneccLVD4DI17Cr_ZXS8_n_I(c r0, WheelView r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$BSN5KVJCwxO8VZfirmCK_90oi0A(c r0, WheelView r1, View r2) {
            b(r0, r1, r2);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
        }

        public final ArrayList<CharSequence> a() {
            return this.f14299b;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public /* synthetic */ void a(RecyclerView.v r3, int r4) {
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), r4);
        }

        public void a(final c r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "holder");
            int r7 = WheelView.a(this.f14298a, r6);
            if (this.f14298a.a() == false) goto L7;
            r5.a().setAlpha(1.0f);
            r5.a().setTextSize(0, WheelView.a(this.f14298a));
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f14299b.get(r7), CharSequence.class, "com.obric.memorydata.plugin"));
            View r8 = r5.c;
            final WheelView r4 = this.f14298a;
            View.OnClickListener r0 = new $$Lambda$WheelView$b$B34hneccLVD4DI17Cr_ZXS8_n_I(r5, r4);
        L5:
            r8.setOnClickListener(r0);
            return;
        L7:
            if (WheelView.b(this.f14298a, r7) == false) goto L9;
            r5.a().setAlpha(1.0f);
            r5.a().setTextSize(0, WheelView.a(this.f14298a));
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f14299b.get(r7), CharSequence.class, "com.obric.memorydata.plugin"));
            r8 = r5.c;
            final WheelView r9 = this.f14298a;
            r0 = new $$Lambda$WheelView$b$BSN5KVJCwxO8VZfirmCK_90oi0A(r5, r9);
            goto L5
        L9:
            r5.a().setAlpha(0.0f);
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
            r5.c.setOnClickListener(null);
        }

        public final void a(List<? extends CharSequence> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "data");
            this.f14299b.clear();
            this.f14299b.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
            h();
        }

        public c b(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            TextView r6 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            WheelView r3 = this.f14298a;
            r6.setId(R.id.text1);
            r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, WheelView.c(r3)), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
            r6.setGravity(17);
            r6.setTextSize(0, WheelView.a(r3));
            r6.setIncludeFontPadding(false);
            return new c((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int d() {
            int r0 = this.f14299b.size();
            if (r0 != 0) goto L7;
            return 0;
        L7:
            if (this.f14298a.a() == false) goto L10;
            return r0 * 1000;
        L10:
            return r0 + (WheelView.b(this.f14298a) * 2);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView$WheelVH;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f14300a;

        public c(View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r3);
            View r4 = r3.findViewById(R.id.text1);
            Intrinsics.checkNotNullExpressionValue(r4, "itemView.findViewById(android.R.id.text1)");
            this.f14300a = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin");
        }

        public final TextView a() {
            return this.f14300a;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/obric/oui/picker/reels/views/WheelView$scrollListener$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f14301a;

        d(WheelView r1) {
            this.f14301a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "rv");
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L6;
            WheelView.a(this.f14301a, true);
            WheelView.b(this.f14301a, false);
            WheelView.c(this.f14301a, false);
            int r8 = WheelView.d(this.f14301a);
            if (r8 == (-1)) goto L40;
            int r9 = WheelView.a(this.f14301a, r8);
            if (WheelView.b(this.f14301a, r9) == false) goto L41;
            WheelView.c(this.f14301a, r8);
            WheelView.d(this.f14301a, r9);
            return;
        L41:
            return;
        L40:
            return;
        L6:
            if (r7 != 2) goto L47;
            WheelView.b(this.f14301a, true);
            return;
        L47:
            return;
        L14:
            WheelView.a(this.f14301a, false);
            WheelView.c(this.f14301a, false);
            int r10 = WheelView.j(this.f14301a);
            if (r10 == (-1)) goto L24;
            WheelView.e(this.f14301a, -1);
            int r2 = WheelView.d(this.f14301a);
            if (r2 == (-1)) goto L24;
            int r3 = WheelView.a(this.f14301a, r2);
            int r4 = WheelView.a(this.f14301a, r10);
            if (WheelView.b(this.f14301a, r4) == false) goto L24;
            if (r3 == r4) goto L24;
            WheelView.a(this.f14301a, r10, true);
            return;
        L24:
            if (WheelView.k(this.f14301a) == false) goto L26;
            WheelView.d(this.f14301a, false);
            boolean r11 = false;
        L28:
            if (WheelView.m(this.f14301a) == false) goto L43;
            if (r11 == true) goto L44;
            WheelView.b(this.f14301a, false);
            int r12 = WheelView.d(this.f14301a);
            if (r12 == (-1)) goto L45;
            int r13 = WheelView.a(this.f14301a, r12);
            if (WheelView.b(this.f14301a, r13) == false) goto L46;
            WheelView.f(this.f14301a, r12);
            com.obric.oui.picker.reels.views.a r5 = this.f14301a.getOnWheelChangedListener();
            if (r5 == null) goto L48;
            r5.a(r13);
            return;
        L48:
            return;
        L46:
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L26:
            r11 = WheelView.l(this.f14301a);
            goto L28
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "rv");
            int r6 = WheelView.d(this.f14301a);
            if (r6 != (-1)) goto L5;
            return;
        L5:
            if (r3.getScrollState() != 0) goto L7;
            return;
        L7:
            if (WheelView.e(this.f14301a) == true) goto L9;
            return;
        L9:
            if (WheelView.f(this.f14301a) == true) goto L33;
            int r7 = WheelView.a(this.f14301a, r6);
            if (WheelView.b(this.f14301a, r7) == true) goto L13;
            return;
        L13:
            if (r6 == WheelView.g(this.f14301a)) goto L35;
            WheelView.c(this.f14301a, r6);
            com.obric.oui.a.a.f13272a.a((View) ZeusTransformUtils.preCheckCast(this.f14301a, View.class, "com.obric.memorydata.plugin"), 3);
            int r8 = WheelView.h(this.f14301a);
            if (r7 == WheelView.h(this.f14301a)) goto L36;
            boolean r9 = false;
            if (r8 >= 0) goto L19;
        L21:
            if (r9 == true) goto L24;
            r8 = r7;
        L24:
            com.obric.oui.picker.reels.views.a r10 = this.f14301a.getOnWheelChangedListener();
            if (r10 == null) goto L28;
            r10.a(r8, r7);
        L28:
            WheelView.d(this.f14301a, r7);
            return;
        L19:
            if (r8 >= WheelView.i(this.f14301a).a().size()) goto L21;
            r9 = true;
            goto L21
        L36:
            return;
        L35:
            return;
        }
    }

    static {
        f14296a = new a(null);
    }

    public WheelView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public WheelView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public WheelView(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r9);
        com.obric.oui.picker.reels.views.d r12 = new com.obric.oui.picker.reels.views.d(r10);
        this.d = r12;
        b r0 = new b(this);
        this.e = r0;
        this.f = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 50.0f);
        this.h = 5;
        this.i = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f);
        this.j = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f);
        this.k = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f);
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.s = -1;
        this.t = -1;
        this.x = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        this.B = ContextCompat.getColor(r10, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg"));
        this.C = ContextCompat.getColor(r10, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        d r2 = new d(this);
        this.E = r2;
        b();
        FrameLayout.inflate(r10, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.layout.o_wheel_view, "layout", "o_wheel_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setTagGap(Integer.valueOf(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2)));
        View r13 = findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.recycler, OaidModel.KEY_ID, "recycler"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.recycler)");
        RecyclerView r14 = (RecyclerView) ZeusTransformUtils.preCheckCast(r13, RecyclerView.class, "com.obric.memorydata.plugin");
        this.f14297b = r14;
        View r3 = findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tag, OaidModel.KEY_ID, "tv_tag"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_tag)");
        this.c = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin");
        r14.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r12, RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r12.a(e());
        r14.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r0, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r14.setClipToPadding(false);
        r14.setOverScrollMode(0);
        r14.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(r2, RecyclerView.m.class, "com.obric.memorydata.plugin"));
        r14.getViewTreeObserver().addOnGlobalLayoutListener(new $$Lambda$WheelView$2iQWdkFhKMGc5_TdHTJlvLAZtA(this));
        a(r11);
    }

    public /* synthetic */ WheelView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ float a(WheelView r0) {
        return r0.i;
    }

    private final int a(int r3, int r4) {
        int r5 = RangesKt.coerceIn(r3, 0, r4 - 1);
        if (this.y == false) goto L6;
        return ((r4 * 1000) / 2) + r5;
    L6:
        return r5 + e();
    }

    public static final /* synthetic */ int a(WheelView r0, int r1) {
        return r0.b(r1);
    }

    private static final void a(int r1, int r2, Ref.IntRef r3, Ref.IntRef r4, int r5) {
        boolean r0 = false;
        if (r5 < 0) goto L6;
        if (r5 >= r1) goto L6;
        r0 = true;
    L6:
        if (r0 == false) goto L11;
        int r6 = Math.abs(r5 - r2);
        if (r6 >= r3.element) goto L12;
        r4.element = r5;
        r3.element = r6;
        return;
    L12:
        return;
    }

    private final void a(AttributeSet r19) {
        TypedArray r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.OWheelView);
        Intrinsics.checkNotNullExpressionValue(r1, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r3 = r1.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelCyclic, "styleable", "OWheelView_oui_wheelCyclic"), false);
        int r6 = r1.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelStartIndex, "styleable", "OWheelView_oui_wheelStartIndex"), 0);
        int r7 = r1.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelItemCount, "styleable", "OWheelView_oui_wheelItemCount"), 5);
        int r8 = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelItemHeight, "styleable", "OWheelView_oui_wheelItemHeight"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 50));
        int r9 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelTextSize, "styleable", "OWheelView_oui_wheelTextSize"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f));
        int r10 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelTextSize, "styleable", "OWheelView_oui_wheelTextSize"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 14.0f));
        int r5 = r1.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelTextColor, "styleable", "OWheelView_oui_wheelTextColor"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
        int r11 = r1.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelSelectedTextColor, "styleable", "OWheelView_oui_wheelSelectedTextColor"), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg")));
        int r12 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelSelectedTextSize, "styleable", "OWheelView_oui_wheelSelectedTextSize"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f));
        CharSequence[] r4 = r1.getTextArray(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OWheelView_oui_wheelEntries, "styleable", "OWheelView_oui_wheelEntries"));
        if (r4 != null) goto L5;
        List r2 = null;
    L9:
        r1.recycle();
        setCyclic(r3);
        this.r = r6;
        this.h = r7;
        this.f = r8;
        float r13 = r9;
        this.j = r13;
        float r14 = r12;
        this.k = r14;
        this.i = RangesKt.coerceAtLeast(r14, r13);
        setSelectedTextColor(r11);
        this.c.setTextSize(0, r10);
        this.c.setTextColor(r5);
        if (r2 == null) goto L12;
        a(this, r2, null, 2, null);
        return;
    L12:
        c();
        return;
    L5:
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r4.length), Collection.class, "com.obric.memorydata.plugin");
        int r16 = r4.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        r15.add(r4[r17].toString());
        r17 = r17 + 1;
        r4 = r4;
        goto L6
    L8:
        r2 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        goto L9
    }

    public static final /* synthetic */ void a(WheelView r0, int r1, boolean r2) {
        r0.c(r1, r2);
    }

    static /* synthetic */ void a(WheelView r1, List r2, Integer r3, int r4, Object r5) {
        List<? extends CharSequence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.a(r6, r3);
    }

    public static final /* synthetic */ void a(WheelView r0, boolean r1) {
        r0.p = r1;
    }

    private final void a(List<? extends CharSequence> r8, Integer r9) {
        List<? extends CharSequence> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.t = -1;
        if (r9 != null) goto L5;
        Integer r11 = null;
    L10:
        if (r11 == null) goto L13;
        this.r = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue();
    L13:
        boolean r2 = !Intrinsics.areEqual(this.e.a(), r10);
        if (r2 == false) goto L16;
        this.f14297b.stopScroll();
        this.e.a(r10);
    L16:
        TextView r3 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.setTextSize(22.0f);
        TextPaint r4 = r3.getPaint();
        this.g = 0.0f;
        Iterator<? extends CharSequence> r5 = r10.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        float r6 = r4.measureText(((CharSequence) ZeusTransformUtils.preCheckCast(r5.next(), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r6 <= this.g) goto L18;
        this.g = r6;
        goto L18
    L22:
        ViewGroup.LayoutParams r7 = this.c.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L29;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        int r13 = (int) (this.g / 2.0f);
        Integer r14 = this.A;
        if (r14 != null) goto L27;
        int r15 = 0;
    L28:
        r12.setMarginStart(r13 + (r15 * 2));
        this.c.setLayoutParams(r7);
        goto L29
    L27:
        r15 = r14.intValue();
    L29:
        if (r11 != null) goto L31;
    L37:
        post(new $$Lambda$WheelView$VS3Xi1CyPKGWLO94txn69VTpgHo(this));
        return;
    L31:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L37;
        if (r2 == false) goto L36;
        this.s = a(r11.intValue(), r10.size());
        if (this.f14297b.getChildCount() <= 0) goto L37;
        d();
        goto L37
    L36:
        b(r11.intValue(), false);
        goto L37
    L5:
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r10.isEmpty() == true) goto L9;
        r16 = RangesKt.coerceIn(r16, 0, r10.size() - 1);
    L9:
        r11 = Integer.valueOf(r16);
        goto L10
    }

    private final int b(int r3) {
        int r0 = this.e.a().size();
        if (r0 != 0) goto L7;
        return -1;
    L7:
        if (this.y == false) goto L12;
        int r4 = r3 % r0;
        if (r4 < 0) goto L14;
        return r4;
    L14:
        return r4 + r0;
    L12:
        return r3 - e();
    }

    public static final /* synthetic */ int b(WheelView r0) {
        return r0.e();
    }

    private final void b() {
        this.l = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 28);
    }

    public static final /* synthetic */ void b(WheelView r0, boolean r1) {
        r0.v = r1;
    }

    public static final /* synthetic */ boolean b(WheelView r0, int r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ int c(WheelView r0) {
        return r0.f;
    }

    private final void c() {
        int r0 = this.e.a().size();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceIn(this.r, 0, r0 - 1);
        if (this.y == false) goto L8;
        int r2 = ((r0 * 1000) / 2) + r1;
    L9:
        this.s = r2;
        if (this.f14297b.getChildCount() <= 0) goto L13;
        d();
        return;
    L13:
        return;
    L8:
        r2 = e() + r1;
        goto L9
    }

    private final void c(final int r2, boolean r3) {
        this.f14297b.stopScroll();
        this.q = true;
        if (r3 == false) goto L7;
        this.t = r2;
        int r4 = this.d.b(r2);
        if (r4 == 0) goto L9;
        d(r4);
        return;
    L9:
        return;
    L7:
        this.f14297b.scrollToPosition(r2);
        post(new $$Lambda$WheelView$2I22mrBRIgz_DpqLe52_X208eSs(this, r2));
    }

    public static final /* synthetic */ void c(WheelView r0, int r1) {
        r0.m = r1;
    }

    public static final /* synthetic */ void c(WheelView r0, boolean r1) {
        r0.q = r1;
    }

    private final boolean c(int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= this.e.a().size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static final /* synthetic */ int d(WheelView r0) {
        return r0.i();
    }

    private final void d() {
        int r0 = this.s;
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.e.a().size() != 0) goto L9;
        return;
    L9:
        if (this.f14297b.getChildCount() != 0) goto L11;
        return;
    L11:
        this.s = -1;
        c(r0, false);
    }

    private final void d(int r5) {
        if (r5 == 0) goto L5;
        this.q = true;
        g r0 = new g(0.61f);
        this.f14297b.smoothScrollBy(0, r5, (Interpolator) ZeusTransformUtils.preCheckCast(r0, Interpolator.class, "com.obric.memorydata.plugin"), 400);
        return;
    }

    public static final /* synthetic */ void d(WheelView r0, int r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void d(WheelView r0, boolean r1) {
        r0.u = r1;
    }

    private final int e() {
        return RangesKt.coerceAtLeast((this.h + 2) / 2, 1);
    }

    public static final /* synthetic */ void e(WheelView r0, int r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ boolean e(WheelView r0) {
        return r0.p;
    }

    public static final /* synthetic */ void f(WheelView r0, int r1) {
        r0.n = r1;
    }

    private final boolean f() {
        this.f14297b.stopScroll();
        int r0 = this.d.g();
        if (r0 == 0) goto L6;
        this.u = true;
        d(r0);
        return true;
    L6:
        return false;
    }

    public static final /* synthetic */ boolean f(WheelView r0) {
        return r0.q;
    }

    public static final /* synthetic */ int g(WheelView r0) {
        return r0.m;
    }

    private final void g() {
        if (this.f14297b.getHeight() > 0) goto L5;
        return;
    L5:
        RecyclerView r0 = this.f14297b;
        r0.setPadding(r0.getPaddingLeft(), 0, this.f14297b.getPaddingRight(), 0);
    }

    private static final void g(WheelView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        View r0 = r2.d.c(r3);
        if (r0 == null) goto L7;
        int r4 = ((r0.getTop() + r0.getBottom()) / 2) - r2.j();
        if (r4 == 0) goto L9;
        r2.f14297b.scrollBy(0, r4);
        r2.u = true;
        return;
    L9:
        return;
    L7:
        r2.s = r3;
    }

    public static final /* synthetic */ int h(WheelView r0) {
        return r0.o;
    }

    private final View h() {
        int r0 = j();
        int r1 = this.f14297b.getChildCount();
        View r2 = null;
        float r3 = Float.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L11;
        r4 = r4 + 1;
        View r5 = this.f14297b.getChildAt(r4);
        if (r5 == null) goto L3;
        float r6 = Math.abs(((r5.getTop() + r5.getBottom()) / 2.0f) - r0);
        if (r6 >= r3) goto L3;
        r2 = r5;
        r3 = r6;
        goto L3
    L11:
        return r2;
    }

    private final int i() {
        int r0 = this.d.h();
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        View r1 = h();
        if (r1 != null) goto L9;
        return -1;
    L9:
        return this.f14297b.getChildAdapterPosition(r1);
    }

    public static final /* synthetic */ b i(WheelView r0) {
        return r0.e;
    }

    private final int j() {
        return ((this.f14297b.getPaddingTop() + this.f14297b.getHeight()) - this.f14297b.getPaddingBottom()) / 2;
    }

    public static final /* synthetic */ int j(WheelView r0) {
        return r0.t;
    }

    public static final /* synthetic */ boolean k(WheelView r0) {
        return r0.u;
    }

    public static final /* synthetic */ boolean l(WheelView r0) {
        return r0.f();
    }

    public static /* synthetic */ void lambda$2I22mrBRIgz_DpqLe52_X208eSs(WheelView r0, int r1) {
        g(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$2iQWdkFhKMGc-5_TdHTJlvLAZtA, reason: not valid java name */
    public static /* synthetic */ void m1334lambda$2iQWdkFhKMGc5_TdHTJlvLAZtA(WheelView r0) {
        n(r0);
    }

    public static /* synthetic */ void lambda$VS3Xi1CyPKGWLO94txn69VTpgHo(WheelView r0) {
        m1335setItems$lambda6(r0);
    }

    public static final /* synthetic */ boolean m(WheelView r0) {
        return r0.v;
    }

    private static final void n(WheelView r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.g();
        r1.d();
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m1335setItems$lambda6(WheelView r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.requestLayout();
        r2.g();
        if (r2.s == (-1)) goto L5;
        r2.d();
        return;
    L5:
        r2.c();
    }

    public final CharSequence a(int r3) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull((List) ZeusTransformUtils.preCheckCast(this.e.a(), List.class, "com.obric.memorydata.plugin"), r3), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final void a(int r4, boolean r5) {
        int r0 = getCurrentIndex();
        int r6 = b(r4, r5);
        int r1 = this.e.a().size();
        if (r1 <= 0) goto L18;
        int r7 = RangesKt.coerceIn(r4, 0, r1 - 1);
        if (r0 == r7) goto L19;
        com.obric.oui.picker.reels.views.a r2 = this.D;
        if (r2 == null) goto L10;
        r2.a(r0, r7);
    L10:
        com.obric.oui.picker.reels.views.a r3 = this.D;
        if (r3 == null) goto L14;
        r3.a(r7);
    L14:
        this.o = r7;
        if (r6 == (-1)) goto L20;
        this.n = r6;
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void a(List<String> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        List<? extends CharSequence> r8 = null;
    L10:
        if (r8 != null) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        a(r8, Integer.valueOf(r6));
        return;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r0.add((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        r8 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        goto L10
    }

    public final boolean a() {
        return this.y;
    }

    public final int b(int r7, boolean r8) {
        this.s = -1;
        this.t = -1;
        int r1 = this.e.a().size();
        if (r1 != 0) goto L6;
        this.r = r7;
        return -1;
    L6:
        int r9 = RangesKt.coerceIn(r7, 0, r1 - 1);
        this.r = r9;
        if (this.y == false) goto L13;
        int r2 = i();
        if (this.f14297b.getChildCount() <= 0) goto L12;
        if (r2 == (-1)) goto L12;
        int r0 = this.e.d();
        int r3 = (r2 - (r2 % r1)) + r9;
        Ref.IntRef r10 = new Ref.IntRef();
        r10.element = r3;
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = Math.abs(r3 - r2);
        a(r0, r2, r4, r10, r3 - r1);
        a(r0, r2, r4, r10, r3 + r1);
        int r11 = r10.element;
    L14:
        c(r11, r8);
        return r11;
    L12:
        r11 = r9 + ((r1 * 1000) / 2);
        goto L14
    L13:
        r11 = r9 + e();
        goto L14
    }

    public final int getCurrentIndex() {
        int r0 = i();
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = b(r0);
        if (c(r1) == true) goto L8;
        return 0;
    L8:
        return r1;
    }

    public final CharSequence getCurrentItem() {
        return a(getCurrentIndex());
    }

    public final int getHighlightConorRadiusPx() {
        return this.x;
    }

    public final int getItemCount() {
        return this.h;
    }

    public final int getItemHeightPx() {
        return this.f;
    }

    public final int getItemSize() {
        return this.e.a().size();
    }

    public final int getNormalTextColor() {
        return this.C;
    }

    public final com.obric.oui.picker.reels.views.a getOnWheelChangedListener() {
        return this.D;
    }

    public final int getSelectedItemHeightPx() {
        return this.f;
    }

    public final int getSelectedTextColor() {
        return this.B;
    }

    public final float getSelectedTextSizePxProp() {
        return this.k;
    }

    public final boolean getShowDivider() {
        return this.w;
    }

    public final int getStartIndex() {
        return this.r;
    }

    public final Integer getTagGap() {
        return this.A;
    }

    public final int getTextColor() {
        return this.C;
    }

    public final float getTextSizePx() {
        return this.j;
    }

    public final CharSequence getWheelTagText() {
        return this.z;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        View.MeasureSpec.makeMeasureSpec((((int) (((this.f / ((float) Math.tan(0.5235988f))) * 2.0f) + this.f)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r2 = Math.max((int) (this.g + this.l), getMinimumWidth());
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 1073741824) goto L7;
        r7 = r2;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), r6);
        return;
    L6:
        r7 = Math.min(r2, r7);
        goto L7
    }

    public final void setCurrentIndex(int r2) {
        a(r2, false);
    }

    public final void setCyclic(boolean r2) {
        this.y = r2;
        this.d.a(r2);
        com.obric.oui.picker.reels.views.d r0 = this.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.a(r3);
        requestLayout();
        return;
    L5:
        r3 = e();
        goto L6
    }

    public final void setEntries(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        List r8 = null;
    L10:
        if (r8 != null) goto L12;
        r8 = CollectionsKt.emptyList();
    L12:
        a(this, r8, null, 2, null);
        return;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r2.add((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        r8 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        goto L10
    }

    public final void setEntries(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "entries");
        a(this, ArraysKt.toList(r3), null, 2, null);
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.x = r1;
    }

    public final void setItemCount(int r2) {
        this.h = r2;
        com.obric.oui.picker.reels.views.d r3 = this.d;
        if (this.y == false) goto L5;
        int r0 = 0;
    L6:
        r3.a(r0);
        requestLayout();
        return;
    L5:
        r0 = e();
        goto L6
    }

    public final void setItemHeightPx(int r1) {
        this.f = r1;
        this.e.h();
        requestLayout();
    }

    public final void setNormalTextColor(int r2) {
        this.C = r2;
        this.d.f(r2);
        this.f14297b.requestLayout();
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.a r3) {
        this.D = (com.obric.oui.picker.reels.views.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.views.a.class, "com.obric.memorydata.plugin");
    }

    public final void setSelectedItemHeightPx(int r1) {
        this.f = r1;
        this.e.h();
        requestLayout();
    }

    public final void setSelectedTextColor(int r2) {
        this.B = r2;
        this.d.d(r2);
        this.f14297b.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r2) {
        this.k = r2;
        this.i = Math.max(this.j, r2);
        this.e.h();
        requestLayout();
    }

    public final void setShowDivider(boolean r1) {
        this.w = r1;
    }

    public final void setStartIndex(int r3) {
        this.r = r3;
        if (this.e.a().size() <= 0) goto L6;
        b(RangesKt.coerceIn(r3, 0, this.e.a().size() - 1), false);
        return;
    }

    public final void setTagGap(Integer r1) {
        this.A = r1;
        requestLayout();
    }

    public final void setTagText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        this.z = r4;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        this.c.setVisibility(8);
        return;
    L11:
        this.c.setVisibility(0);
        this.c.setText(this.z);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public final void setTextColor(int r1) {
        setNormalTextColor(r1);
    }

    public final void setTextSizePx(float r2) {
        this.j = r2;
        this.i = Math.max(r2, this.k);
        this.e.h();
        requestLayout();
    }

    public final void setWheelTagText(CharSequence r3) {
        this.z = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }
}

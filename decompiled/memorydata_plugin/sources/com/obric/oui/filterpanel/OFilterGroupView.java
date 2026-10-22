package com.obric.oui.filterpanel;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.filter.OFilter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0004>?@AB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010(\u001a\u00020\nJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020&2\u0006\u0010-\u001a\u00020 J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0013J\u000e\u00100\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u00104\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020\nJ\u0018\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\n2\b\b\u0002\u00108\u001a\u00020\u000fJ\u000e\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\nJ\u0010\u0010;\u001a\u00020&2\b\u0010<\u001a\u0004\u0018\u00010\rJ\u0006\u0010=\u001a\u00020&R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "columnCount", "", "curFiltersList", "", "", "enableClickWhenSelected", "", "filterStyle", "filtersList", "", "Lcom/obric/oui/filter/OFilter;", "gridLayout", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "lessFiltersList", "maxSelectCount", "moreFiltersList", "onFilterClickedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "onFilterDataChangeListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "onFilterSelectedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "showingMore", "tvShowMore", "Landroid/widget/TextView;", "tvTitle", "addFilterItems", "", "items", "getMaxSelectCount", "getSelectedFilters", "getSelectedIndexes", "getTitle", "registerFilterClickedListener", "listener", "registerFilterDataChangeListener", "registerFilterSelectedListener", "select", "filter", "index", "setEnableClickWhenSelected", "setFilterItems", "initRowCount", "setFilterStyle", "style", "isAlwaysLight", "setMaxSelectCount", CommonConsts.COUNT_TYPE, "setTitle", "title", "unSelectAll", "Config", "OnFilterClickedListener", "OnFilterDataChangeListener", "OnFilterSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterGroupView extends ConstraintLayout {
    private final String TAG;
    private int columnCount;
    private List<? extends CharSequence> curFiltersList;
    private boolean enableClickWhenSelected;
    private int filterStyle;
    private final List<OFilter> filtersList;
    private final GridLayout gridLayout;
    private final List<CharSequence> lessFiltersList;
    private int maxSelectCount;
    private final List<CharSequence> moreFiltersList;
    private b onFilterClickedListener;
    private c onFilterDataChangeListener;
    private d onFilterSelectedListener;
    private boolean showingMore;
    private final TextView tvShowMore;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003Jz\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0005J\u0014\u0010 \u001a\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006C"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "", "title", "", "filterStyle", "", "maxSelectCount", "columnCount", "defaultSelectIndex", "filterItems", "", "onFilterSelectListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "initRowCount", "enableClickWhenSelected", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/List;Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;IZ)V", "getColumnCount", "()I", "setColumnCount", "(I)V", "getDefaultSelectIndex", "()Ljava/lang/Integer;", "setDefaultSelectIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEnableClickWhenSelected", "()Z", "setEnableClickWhenSelected", "(Z)V", "getFilterItems", "()Ljava/util/List;", "setFilterItems", "(Ljava/util/List;)V", "getFilterStyle", "setFilterStyle", "getInitRowCount", "setInitRowCount", "getMaxSelectCount", "setMaxSelectCount", "getOnFilterSelectListener", "()Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "setOnFilterSelectListener", "(Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/util/List;Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;IZ)Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "equals", "other", "hashCode", CommonConsts.COUNT_TYPE, "items", "style", "listener", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f13846b;
        private Integer c;
        private int d;
        private Integer e;
        private List<String> f;
        private d g;
        private int h;
        private boolean i;

        public a() {
            this(null, null, null, 0, null, null, null, 0, false, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public a(String r3, Integer r4, Integer r5, int r6, Integer r7, List<String> r8, d r9, int r10, boolean r11) {
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.memorydata.plugin");
            this.f13845a = r3;
            this.f13846b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r12;
            this.g = r13;
            this.h = r10;
            this.i = r11;
        }

        public /* synthetic */ a(String r11, Integer r12, Integer r13, int r14, Integer r15, List r16, d r17, int r18, boolean r19, int r20, DefaultConstructorMarker r21) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
            d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.memorydata.plugin");
            d r4 = null;
            if ((r20 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Integer r5 = null;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Integer r6 = null;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r7 = 3;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r8 = null;
        L23:
            if ((r20 & 32) == 0) goto L26;
            r1 = null;
        L26:
            if ((r20 & 64) != 0) goto L30;
            r4 = r2;
        L30:
            if ((r20 & 128) == 0) goto L32;
            int r9 = Integer.MAX_VALUE;
        L34:
            if ((r20 & 256) == 0) goto L36;
            boolean r0 = true;
        L37:
            this(r3, r5, r6, r7, r8, r1, r4, r9, r0);
            return;
        L36:
            r0 = r19;
            goto L37
        L32:
            r9 = r18;
            goto L34
        L21:
            r8 = r15;
            goto L23
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }

        public final String a() {
            return this.f13845a;
        }

        public final Integer b() {
            return this.f13846b;
        }

        public final Integer c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final Integer e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13845a, r6.f13845a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13846b, r6.f13846b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final List<String> f() {
            return this.f;
        }

        public final int g() {
            return this.h;
        }

        public final boolean h() {
            return this.i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        public int hashCode() {
            String r0 = this.f13845a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.f13846b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.d)) * 31;
            Integer r10 = this.e;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            List<String> r13 = this.f;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            d r16 = this.g;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            int r17 = (((r15 + r1) * 31) + Integer.hashCode(this.h)) * 31;
            boolean r18 = this.i;
            ?? r19 = r18;
            if (r18 == false) goto L30;
            r19 = 1;
        L30:
            return r17 + r19;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Config(title=" + this.f13845a + ", filterStyle=" + this.f13846b + ", maxSelectCount=" + this.c + ", columnCount=" + this.d + ", defaultSelectIndex=" + this.e + ", filterItems=" + this.f + ", onFilterSelectListener=" + this.g + ", initRowCount=" + this.h + ", enableClickWhenSelected=" + this.i + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "", "onFilterClicked", "", "filter", "Lcom/obric/oui/filter/OFilter;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(OFilter r1);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "", "onDataChange", "", "items", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(List<? extends CharSequence> r1);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "", "onFilterSelected", "", "filter", "Lcom/obric/oui/filter/OFilter;", "onFilterUnselected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a(OFilter r1);

        void b(OFilter r1);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/filterpanel/OFilterGroupView$addFilterItems$1$1", "Lcom/obric/oui/filter/OFilter$OnFilterSelectChangeListener;", "onFilterSelectedChange", "", "filter", "Lcom/obric/oui/filter/OFilter;", BuildConfig.FLAVOR, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements OFilter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFilterGroupView f13847a;

        e(OFilterGroupView r1) {
            this.f13847a = r1;
        }

        @Override // com.obric.oui.filter.OFilter.b
        public void a(OFilter r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "filter");
            d r1 = OFilterGroupView.access$getOnFilterSelectedListener$p(this.f13847a);
            if (r3 == false) goto L7;
            if (r1 == null) goto L12;
            r1.a(r2);
            return;
        L12:
            return;
        L7:
            if (r1 == null) goto L13;
            r1.b(r2);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterGroupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OFilterGroupView(Context r5, AttributeSet r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8);
        this.TAG = "OFilterPanelView";
        this.maxSelectCount = 1;
        this.columnCount = 3;
        this.lessFiltersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.moreFiltersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.filtersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.enableClickWhenSelected = true;
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_layout_filter_group_view, "layout", "o_layout_filter_group_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_show_more, OaidModel.KEY_ID, "tv_show_more")), TextView.class, "com.obric.memorydata.plugin");
        this.tvShowMore = r10;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.grid_layout, OaidModel.KEY_ID, "grid_layout"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.grid_layout)");
        this.gridLayout = (GridLayout) ZeusTransformUtils.preCheckCast(r0, GridLayout.class, "com.obric.memorydata.plugin");
        r10.setOnClickListener(new $$Lambda$OFilterGroupView$aeWq4a7NdxVN2l4VD0dDHvTeFo(this, r7));
    }

    public /* synthetic */ OFilterGroupView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1291_init_$lambda0(OFilterGroupView r4, Context r5, View r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$context");
        r4.gridLayout.removeAllViews();
        if (r4.showingMore == false) goto L9;
        TextView r8 = r4.tvShowMore;
        if (r8 == null) goto L8;
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_show_more, TypedValues.Custom.S_STRING, "oui_show_more")), CharSequence.class, "com.obric.memorydata.plugin"));
    L8:
        r4.addFilterItems(r4.lessFiltersList, r4.columnCount);
        boolean r9 = false;
    L14:
        r4.showingMore = r9;
        return;
    L9:
        TextView r10 = r4.tvShowMore;
        if (r10 == null) goto L13;
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_show_less, TypedValues.Custom.S_STRING, "oui_show_less")), CharSequence.class, "com.obric.memorydata.plugin"));
    L13:
        r4.addFilterItems(r4.moreFiltersList, r4.columnCount);
        r9 = true;
        goto L14
    }

    public static final /* synthetic */ d access$getOnFilterSelectedListener$p(OFilterGroupView r0) {
        return r0.onFilterSelectedListener;
    }

    private final void addFilterItems(List<? extends CharSequence> r22, int r23) {
        List<? extends CharSequence> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        this.filtersList.clear();
        this.curFiltersList = r1;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        GridLayout.LayoutParams r9 = new GridLayout.LayoutParams();
        r9.height = -2;
        r9.width = 0;
        r9.rightMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        r9.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 5);
        r9.setGravity(17);
        int r10 = r5 % r23;
        int r11 = r5 / r23;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        r9.columnSpec = GridLayout.spec(r10, 1.0f);
        r9.rowSpec = GridLayout.spec(r11, 1.0f);
    L12:
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r15, "context");
        final OFilter r12 = new OFilter(r15, null, 0, true, 6, null);
        r12.setText(r8);
        r12.setStyle(this.filterStyle, true);
        r12.setSelectChangeListener((OFilter.b) ZeusTransformUtils.preCheckCast(new e(this), OFilter.b.class, "com.obric.memorydata.plugin"));
        r12.setOnClickListener(new $$Lambda$OFilterGroupView$Pk_iy4cmMZ89IHEc2Ov4kEgWjq0(this, r12));
        this.filtersList.add(r12);
        getGridLayout().addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r5 = r7;
        goto L4
    L11:
        r9.columnSpec = GridLayout.spec(r10);
        r9.rowSpec = GridLayout.spec(r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r13, "context");
        r9.width = (h.a(r13) - (h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 5) * 2)) / 3;
        goto L12
    L13:
        c r0 = this.onFilterDataChangeListener;
        if (r0 == null) goto L21;
        r0.a(r1);
        return;
    }

    static /* synthetic */ void addFilterItems$default(OFilterGroupView r1, List r2, int r3, int r4, Object r5) {
        List<? extends CharSequence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 3;
    L5:
        r1.addFilterItems(r6, r3);
    }

    /* JADX INFO: renamed from: addFilterItems$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1292addFilterItems$lambda2$lambda1(OFilterGroupView r2, OFilter r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$oFilter");
        if (r4.isSelected() == true) goto L5;
    L9:
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.filter.OFilter");
        r2.select((OFilter) ZeusTransformUtils.preCheckCast(r4, OFilter.class, "com.obric.memorydata.plugin"));
    L10:
        b r5 = r2.onFilterClickedListener;
        if (r5 == null) goto L15;
        r5.a(r3);
        return;
    L15:
        return;
    L5:
        if (r2.maxSelectCount == 1) goto L7;
    L8:
        r3.setSelected(false);
        goto L10
    L7:
        if (r2.enableClickWhenSelected == false) goto L9;
        goto L8
    }

    public static /* synthetic */ void lambda$Pk_iy4cmMZ89IHEc2Ov4kEgWjq0(OFilterGroupView r0, OFilter r1, View r2) {
        m1292addFilterItems$lambda2$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$aeWq4a7NdxVN2l4VD0d-DHvTeFo, reason: not valid java name */
    public static /* synthetic */ void m1293lambda$aeWq4a7NdxVN2l4VD0dDHvTeFo(OFilterGroupView r0, Context r1, View r2) {
        m1291_init_$lambda0(r0, r1, r2);
    }

    public static /* synthetic */ void setFilterItems$default(OFilterGroupView r1, List r2, int r3, int r4, int r5, Object r6) {
        List<? extends CharSequence> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 3;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = Integer.MAX_VALUE;
    L8:
        r1.setFilterItems(r7, r3, r4);
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterGroupView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final GridLayout getGridLayout() {
        return this.gridLayout;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final List<OFilter> getSelectedFilters() {
        List<OFilter> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        OFilter r1 = (OFilter) ZeusTransformUtils.preCheckCast(r4.next(), OFilter.class, "com.obric.memorydata.plugin");
        if (r1.isSelected() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final List<Integer> getSelectedIndexes() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r3 = r6.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OFilter) ZeusTransformUtils.preCheckCast(r3, OFilter.class, "com.obric.memorydata.plugin")).isSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r4;
        goto L4
    L12:
        return r0;
    }

    public final TextView getTitle() {
        return this.tvTitle;
    }

    public final void registerFilterClickedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onFilterClickedListener = r4;
    }

    public final void registerFilterDataChangeListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onFilterDataChangeListener = r4;
        List<? extends CharSequence> r2 = this.curFiltersList;
        if (r2 == null) goto L7;
        r4.a(r2);
        return;
    }

    public final void registerFilterSelectedListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onFilterSelectedListener = r4;
    }

    public final void select(OFilter r6) {
        Intrinsics.checkNotNullParameter(r6, "filter");
        if (r6.isSelected() == false) goto L5;
        return;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L8;
    L10:
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        if (((OFilter) ZeusTransformUtils.preCheckCast(r1.next(), OFilter.class, "com.obric.memorydata.plugin")).isSelected() == false) goto L12;
        r3 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwCountOverflow();
    L19:
        if (r3 < this.maxSelectCount) goto L21;
        unSelectAll();
    L21:
        r6.setSelected(true);
        return;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean select(int r4) {
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
    L10:
        return false;
    L12:
        ((OFilter) ZeusTransformUtils.preCheckCast(this.filtersList.get(r4), OFilter.class, "com.obric.memorydata.plugin")).setSelected(true);     // Catch: IndexOutOfBoundsException -> L11
        goto L10
    L5:
        if (r4 >= this.filtersList.size()) goto L7;
        r2 = true;
        goto L8
    }

    public final void setEnableClickWhenSelected(boolean r1) {
        this.enableClickWhenSelected = r1;
    }

    public final void setFilterItems(List<? extends CharSequence> r5, int r6, int r7) {
        List<? extends CharSequence> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "items");
        this.columnCount = r6;
        this.gridLayout.setAlignmentMode(0);
        this.gridLayout.setColumnCount(r6);
        this.gridLayout.setRowCount(((r8.size() + r6) - 1) / r6);
        if ((((r8.size() - 1) / r6) + 1) <= r7) goto L8;
        this.moreFiltersList.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        List<? extends CharSequence> r9 = r8.subList(0, r7 * r6);
        this.lessFiltersList.addAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin"));
        addFilterItems(r9, r6);
        TextView r4 = this.tvShowMore;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        return;
    L11:
        return;
    L8:
        addFilterItems(r8, r6);
    }

    public final void setFilterStyle(int r4, boolean r5) {
        this.filterStyle = r4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OFilter) ZeusTransformUtils.preCheckCast(r3.next(), OFilter.class, "com.obric.memorydata.plugin")).setStyle(r4, r5);
        goto L4
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.tvTitle.setText(r4);
    }

    public final void unSelectAll() {
        Log.d(this.TAG, "unSelectAll() called");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OFilter r0 = (OFilter) ZeusTransformUtils.preCheckCast(r3.next(), OFilter.class, "com.obric.memorydata.plugin");
        if (r0.isSelected() == false) goto L4;
        r0.setSelected(false);
        goto L4
    }
}

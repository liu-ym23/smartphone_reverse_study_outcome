package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.interaction.IObricMessagePopupService;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\tH\u0002J\"\u0010\u0017\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\tH\u0002J\u0018\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010 \u001a\u00020\rH\u0002J\u001e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aH\u0002J\u001e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u001e\u0010)\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\r2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0002J\u0018\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\rH\u0002J\u0018\u00106\u001a\u00020\u00142\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020/H\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0010\u00108\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0012\u00109\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\rH\u0002¨\u0006?"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricMessagePopupServiceImpl;", "Lcom/obric/assistant/common/spi/interaction/IObricMessagePopupService;", "<init>", "()V", "filterMessageMenuItemsIfNeeded", "", "context", "Landroid/content/Context;", "menuItems", "", "prepareFollowClickMenuBeforeShow", "", "anchor", "Landroid/view/View;", "menuView", "markNextDropdownRewriteIfNeeded", "popupWindow", "Landroid/widget/PopupWindow;", "filterBalloonMenuViewForWindowOrientation", "orientation", "", "filterBalloonMenuViewByText", "unsupportedTextResIds", "filterMenuItems", "unsupportedItems", "getMutableSubMenuItems", "", "menu", "", "normalizeMenuDividers", "findCommonMenus", "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "root", "collectCommonMenus", "view", WindowEvent.Params.RESULT, "removeMatchedRows", "commonMenu", "unsupportedTexts", "", "", "childContainsText", "targetTexts", "normalizeCommonMenuDirectChildDividers", "normalizeCommonMenuRowsAfterFilter", "collectEffectiveDirectRows", "resolveMenuRowPosition", "Lcom/obric/assistant/interaction/impl/window/ObricMessagePopupServiceImpl$MenuRowPosition;", "index", "rowCount", "normalizeMenuRowBackground", "row", "position", "hasStandardVerticalMenuContent", "resolveMenuRowBackgroundRes", "hasEffectiveMenuRow", "isEffectiveMenuRow", "isObviousDivider", "hasVisibleNonBlankTextView", "resolveKnownHeight", "dividerMaxHeightPx", "Companion", "MenuRowPosition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessagePopupServiceImpl implements IObricMessagePopupService {
    private static final Companion Companion = null;
    public static final int DIVIDER_MAX_HEIGHT_DP = 16;
    public static final String TAG = "ObricMessagePopupServiceImpl";
    private static final List<Integer> commonUnsupportedStructuredItemTextResIds = null;
    private static final List<Integer> landscapeUnsupportedBalloonItemTextResIds = null;
    private static final List<Integer> landscapeUnsupportedStructuredItemTextResIds = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricMessagePopupServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "DIVIDER_MAX_HEIGHT_DP", "", "commonUnsupportedStructuredItemTextResIds", "", "getCommonUnsupportedStructuredItemTextResIds", "()Ljava/util/List;", "landscapeUnsupportedStructuredItemTextResIds", "getLandscapeUnsupportedStructuredItemTextResIds", "landscapeUnsupportedBalloonItemTextResIds", "getLandscapeUnsupportedBalloonItemTextResIds", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final List<Integer> getCommonUnsupportedStructuredItemTextResIds() {
            return ObricMessagePopupServiceImpl.access$getCommonUnsupportedStructuredItemTextResIds$cp();
        }

        public final List<Integer> getLandscapeUnsupportedBalloonItemTextResIds() {
            return ObricMessagePopupServiceImpl.access$getLandscapeUnsupportedBalloonItemTextResIds$cp();
        }

        public final List<Integer> getLandscapeUnsupportedStructuredItemTextResIds() {
            return ObricMessagePopupServiceImpl.access$getLandscapeUnsupportedStructuredItemTextResIds$cp();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricMessagePopupServiceImpl$MenuRowPosition;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "FIRST", "MIDDLE", "LAST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MenuRowPosition extends Enum<MenuRowPosition> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ MenuRowPosition[] $VALUES = null;
        public static final MenuRowPosition FIRST = null;
        public static final MenuRowPosition LAST = null;
        public static final MenuRowPosition MIDDLE = null;
        public static final MenuRowPosition SINGLE = null;

        private static final /* synthetic */ MenuRowPosition[] $values() {
            return new MenuRowPosition[]{SINGLE, FIRST, MIDDLE, LAST};
        }

        public static EnumEntries<MenuRowPosition> getEntries() {
            return $ENTRIES;
        }

        static {
            SINGLE = new MenuRowPosition("SINGLE", 0);
            FIRST = new MenuRowPosition("FIRST", 1);
            MIDDLE = new MenuRowPosition("MIDDLE", 2);
            LAST = new MenuRowPosition("LAST", 3);
            MenuRowPosition[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static MenuRowPosition[] values() {
            return (MenuRowPosition[]) $VALUES.clone();
        }

        public static MenuRowPosition valueOf(String r1) {
            return (MenuRowPosition) a.a(MenuRowPosition.class, r1);
        }

        private MenuRowPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[MenuRowPosition.values().length];
            r0[MenuRowPosition.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MenuRowPosition.FIRST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MenuRowPosition.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MenuRowPosition.LAST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ObricMessagePopupServiceImpl() {
    }

    static {
        Companion = new Companion(null);
        List<Integer> r0 = CollectionsKt.listOf(new Integer[]{2131900868, 2131907411, 2131905586, 2131900233, 2131905659, 2131906512});
        commonUnsupportedStructuredItemTextResIds = r0;
        landscapeUnsupportedStructuredItemTextResIds = CollectionsKt.plus(r0, CollectionsKt.listOf(new Integer[]{2131907405, 2131907403, 2131909371, 2131907182}));
        landscapeUnsupportedBalloonItemTextResIds = CollectionsKt.listOf(new Integer[]{2131907182, 2131906512});
    }

    public static final /* synthetic */ List access$getCommonUnsupportedStructuredItemTextResIds$cp() {
        return commonUnsupportedStructuredItemTextResIds;
    }

    public static final /* synthetic */ List access$getLandscapeUnsupportedBalloonItemTextResIds$cp() {
        return landscapeUnsupportedBalloonItemTextResIds;
    }

    public static final /* synthetic */ List access$getLandscapeUnsupportedStructuredItemTextResIds$cp() {
        return landscapeUnsupportedStructuredItemTextResIds;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ObricMessagePopupServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private final List<View> collectEffectiveDirectRows(CommonMenu r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        View r3 = r6.getChildAt(r2);
        if (r3 == null) goto L14;
        if (r3.getVisibility() != 0) goto L14;
        if (isObviousDivider(r3) == true) goto L14;
        if (isEffectiveMenuRow(r3) == false) goto L14;
        r0.add(r3);
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        return r0;
    }

    private final int dividerMaxHeightPx(View r2) {
        return RangesKt.coerceAtLeast((int) (16 * INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ObricMessagePopupServiceImpl_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources()).density), 1);
    }

    private final List<CommonMenu> findCommonMenus(View r2) {
        ArrayList r0 = new ArrayList();
        collectCommonMenus(r2, r0);
        return r0;
    }

    private final List<?> getMutableSubMenuItems(Object r6) {
        if ((r6 instanceof com.larus.bmhome.view.screenmenu.l0) == false) goto L5;
        com.larus.bmhome.view.screenmenu.l0 r7 = (com.larus.bmhome.view.screenmenu.l0) r6;
    L6:
        if (r7 == null) goto L8;
        Object r8 = r7.l;
    L10:
        if (TypeIntrinsics.isMutableList(r8) == false) goto L12;
        List<?> r9 = (List) r8;
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        List<?> r0 = r9;
        boolean r3 = false;
        if ((r0 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r1 = r0.iterator();
    L22:
        if (r1.hasNext() == false) goto L26;
        if ((!(r1.next() instanceof ot8.a)) == false) goto L22;
        r3 = true;
    L26:
        if (r3 == false) goto L28;
        return null;
    L28:
        return r9;
    L18:
        if (r0.isEmpty() == false) goto L20;
    L12:
        r9 = null;
        goto L13
    L8:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    private final boolean hasEffectiveMenuRow(CommonMenu r6) {
        int r0 = r6.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        View r3 = r6.getChildAt(r2);
        if (r3 == null) goto L15;
        if (r3.getVisibility() != 0) goto L15;
        if (isObviousDivider(r3) == true) goto L15;
        if (isEffectiveMenuRow(r3) == false) goto L15;
        return true;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return false;
    }

    private final boolean hasStandardVerticalMenuContent(View r2) {
        if (r2.findViewById(2131379929) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean hasVisibleNonBlankTextView(View r6) {
        if ((r6 instanceof TextView) == false) goto L10;
        TextView r0 = (TextView) r6;
        if (r0.getVisibility() != 0) goto L10;
        if ((!StringsKt.isBlank(r0.getText().toString())) == false) goto L10;
        return true;
    L10:
        if ((r6 instanceof ViewGroup) == false) goto L12;
        ViewGroup r7 = (ViewGroup) r6;
    L14:
        if (r7 != null) goto L16;
        return false;
    L16:
        int r2 = r7.getChildCount();
        int r3 = 0;
    L17:
        if (r3 >= r2) goto L25;
        View r4 = r7.getChildAt(r3);
        if (r4 == null) goto L24;
        if (hasVisibleNonBlankTextView(r4) == false) goto L24;
        return true;
    L24:
        r3 = r3 + 1;
        goto L17
    L25:
        return false;
    L12:
        r7 = null;
        goto L14
    }

    private final boolean isEffectiveMenuRow(View r2) {
        if (hasVisibleNonBlankTextView(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2.hasOnClickListeners() == true) goto L10;
        if (r2.isClickable() == true) goto L10;
        return false;
    }

    private final boolean isObviousDivider(View r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (hasVisibleNonBlankTextView(r5) == false) goto L11;
        return false;
    L11:
        if (r5.hasOnClickListeners() == false) goto L13;
        return false;
    L13:
        if (r5.isClickable() == true) goto L28;
        String r1 = r5.getClass().getName();
        Intrinsics.checkNotNull(r1);
        if (StringsKt.contains(r1, "Divider", true) == false) goto L18;
        return true;
    L18:
        int r2 = resolveKnownHeight(r5);
        if (1 <= r2) goto L21;
        return false;
    L21:
        if (r2 > dividerMaxHeightPx(r5)) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    private final void normalizeCommonMenuDirectChildDividers(CommonMenu r7) {
    L3:
        if (r7.getChildCount() <= 0) goto L7;
        if (isObviousDivider(r7.getChildAt(0)) == false) goto L7;
        r7.removeViewAt(0);
    L7:
        int r0 = 0;
        boolean r2 = false;
    L8:
        boolean r4 = true;
        if (r0 >= r7.getChildCount()) goto L23;
        View r3 = r7.getChildAt(r0);
        boolean r5 = isObviousDivider(r3);
        if (r5 == false) goto L14;
        if (r2 == false) goto L14;
        r7.removeViewAt(r0);
    L14:
        if (r3 != null) goto L16;
    L18:
        r4 = false;
    L19:
        if (r4 == false) goto L21;
        r2 = r5;
    L21:
        r0 = r0 + 1;
        goto L8
    L16:
        if (r3.getVisibility() != 0) goto L18;
    L23:
        if (r7.getChildCount() <= 0) goto L27;
        if (isObviousDivider(r7.getChildAt(r7.getChildCount() - 1)) == false) goto L39;
        r7.removeViewAt(r7.getChildCount() - 1);
        goto L23
    L39:
        return;
    }

    private final void normalizeCommonMenuRowsAfterFilter(CommonMenu r7) {
        List<View> r0 = collectEffectiveDirectRows(r7);
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        r7.setClipToOutline(true);
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        normalizeMenuRowBackground((View) r3, resolveMenuRowPosition(r2, r0.size()));
        r2 = r4;
        goto L7
    L12:
        r7.requestLayout();
        r7.invalidate();
    }

    private final void normalizeMenuDividers(List<?> r4) {
    L2:
        boolean r1 = false;
        if ((CollectionsKt.firstOrNull(r4) instanceof com.larus.bmhome.view.screenmenu.i0) == false) goto L5;
        ListProtector.remove(r4, 0);
        goto L2
    L5:
        ListIterator<?> r0 = r4.listIterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        boolean r2 = r0.next() instanceof com.larus.bmhome.view.screenmenu.i0;
        if (r2 == false) goto L12;
        if (r1 == false) goto L12;
        r0.remove();
    L12:
        r1 = r2;
    L14:
        if ((CollectionsKt.lastOrNull(r4) instanceof com.larus.bmhome.view.screenmenu.i0) == false) goto L16;
        ListProtector.remove(r4, CollectionsKt.getLastIndex(r4));
        goto L14
    }

    private final int resolveKnownHeight(View r2) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L5;
        int r1 = r0.height;
    L6:
        if (r1 <= 0) goto L9;
        return r1;
    L9:
        if (r2.getHeight() <= 0) goto L13;
        return r2.getHeight();
    L13:
        return r2.getMeasuredHeight();
    L5:
        r1 = 0;
        goto L6
    }

    private final boolean childContainsText(View r6, Set<String> r7) {
        if ((r6 instanceof TextView) == false) goto L8;
        if (r7.contains(((TextView) r6).getText().toString()) == false) goto L8;
        return true;
    L8:
        if ((r6 instanceof ViewGroup) == false) goto L10;
        ViewGroup r8 = (ViewGroup) r6;
    L12:
        if (r8 != null) goto L14;
        return false;
    L14:
        int r2 = r8.getChildCount();
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L23;
        View r4 = r8.getChildAt(r3);
        if (r4 == null) goto L22;
        if (childContainsText(r4, r7) == false) goto L22;
        return true;
    L22:
        r3 = r3 + 1;
        goto L15
    L23:
        return false;
    L10:
        r8 = null;
        goto L12
    }

    private final void collectCommonMenus(View r4, List<CommonMenu> r5) {
        if ((r4 instanceof CommonMenu) == false) goto L7;
        r5.add(r4);
        return;
    L7:
        if ((r4 instanceof ViewGroup) == false) goto L9;
        ViewGroup r6 = (ViewGroup) r4;
    L10:
        if (r6 != null) goto L12;
        return;
    L12:
        int r0 = r6.getChildCount();
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L18;
        View r2 = r6.getChildAt(r1);
        if (r2 == null) goto L17;
        collectCommonMenus(r2, r5);
    L17:
        r1 = r1 + 1;
        goto L13
    L18:
        return;
    L9:
        r6 = null;
        goto L10
    }

    private final void filterMenuItems(List<?> r4, List<Integer> r5) {
        if (TypeIntrinsics.isMutableList(r4) == true) goto L6;
        r4 = null;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        ListIterator<?> r0 = r4.listIterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        Object r1 = r0.next();
        if ((r1 instanceof com.larus.bmhome.view.screenmenu.l0) == false) goto L10;
        if (r5.contains(Integer.valueOf(((com.larus.bmhome.view.screenmenu.l0) r1).b)) == false) goto L10;
        r0.remove();
        goto L10
    L16:
        Iterator<T> r2 = r4.iterator();
    L18:
        if (r2.hasNext() == false) goto L22;
        List<?> r3 = getMutableSubMenuItems(r2.next());
        if (r3 == null) goto L18;
        filterMenuItems(r3, r5);
        goto L18
    L22:
        normalizeMenuDividers(r4);
    }

    private final void normalizeMenuRowBackground(View r2, MenuRowPosition r3) {
        if (hasStandardVerticalMenuContent(r2) == true) goto L5;
        return;
    L5:
        r2.setBackground(r2.getContext().getDrawable(resolveMenuRowBackgroundRes(r2, r3)));
    }

    private final void removeMatchedRows(CommonMenu r3, Set<String> r4) {
        int r0 = r3.getChildCount();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L12;
        View r1 = r3.getChildAt(r0);
        if (r1 == null) goto L3;
        if (childContainsText(r1, r4) == false) goto L3;
        r3.removeViewAt(r0);
        goto L3
    }

    private final int resolveMenuRowBackgroundRes(View r2, MenuRowPosition r3) {
        Context r4 = r2.getContext();
        int r5 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 != 4) goto L12;
        return v19.c.b(2130970618, r4, 2131238849);
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return v19.c.b(2130970621, r4, 2131238859);
    L19:
        return v19.c.b(2130970615, r4, 2131238839);
    L16:
        return v19.c.b(2130970624, r4, 2131238869);
    }

    private final MenuRowPosition resolveMenuRowPosition(int r2, int r3) {
        if (r3 <= 1) goto L12;
        if (r2 != 0) goto L8;
        return MenuRowPosition.FIRST;
    L8:
        if (r2 != (r3 - 1)) goto L11;
        return MenuRowPosition.LAST;
    L11:
        return MenuRowPosition.MIDDLE;
    L12:
        return MenuRowPosition.SINGLE;
    }

    public void filterMessageMenuItemsIfNeeded(Context r2, List<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "menuItems");
        if (IWindowContextKt.isWindowContext(r2) == true) goto L6;
        return;
    L6:
        if (WindowHost.INSTANCE.getCurrentWindowOrientation$impl_mainlandRelease() == 2) goto L8;
        return;
    L8:
        boolean r4 = !r3.isEmpty();
        filterMenuItems(r3, landscapeUnsupportedStructuredItemTextResIds);
        if (r4 == true) goto L11;
        return;
    L11:
        if (r3.isEmpty() == false) goto L15;
        FLogger.a.i(TAG, "message menu is empty after landscape filter");
        LandscapeRestrictionGuard.INSTANCE.getPortraitToastReporter$impl_mainlandRelease().invoke("message_menu_empty");
        return;
    }

    public void markNextDropdownRewriteIfNeeded(View r1, PopupWindow r2) {
        if (r1 == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (IWindowContextKt.isWindowContext(r1.getContext()) == true) goto L8;
        return;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.markNextDropdownRewrite(r2);
        return;
    }

    public boolean prepareFollowClickMenuBeforeShow(View r3, View r4) {
        if (r3 == null) goto L19;
        if (r4 == null) goto L19;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (IWindowContextKt.isWindowContext(r3.getContext()) == true) goto L9;
        return true;
    L9:
        Object r5 = Result.constructor-impl(Boolean.valueOf(filterBalloonMenuViewForWindowOrientation(r3.getContext(), r4, WindowHost.INSTANCE.getCurrentWindowOrientation$impl_mainlandRelease())));     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L18;
        FLogger.a.w(TAG, "filter Balloon menu view failed", r6);
        r5 = Boolean.TRUE;
    L18:
        return ((Boolean) r5).booleanValue();
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        return true;
    }

    private final boolean filterBalloonMenuViewByText(Context r4, View r5, List<Integer> r6) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r6.isEmpty() == false) goto L8;
        return true;
    L8:
        List<CommonMenu> r7 = findCommonMenus(r5);
        if (r7.isEmpty() == false) goto L11;
        return true;
    L11:
        List<Integer> r8 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r1.add(r4.getText(((Number) r9.next()).intValue()).toString());
        goto L13
    L15:
        Set<String> r10 = CollectionsKt.toSet(r1);
        Iterator<T> r11 = r7.iterator();
        boolean r12 = false;
    L17:
        if (r11.hasNext() == false) goto L21;
        CommonMenu r2 = (CommonMenu) r11.next();
        removeMatchedRows(r2, r10);
        normalizeCommonMenuDirectChildDividers(r2);
        normalizeCommonMenuRowsAfterFilter(r2);
        if (hasEffectiveMenuRow(r2) == false) goto L17;
        r12 = true;
        goto L17
    L21:
        return r12;
    }

    private final boolean filterBalloonMenuViewForWindowOrientation(Context r2, View r3, int r4) {
        if (r4 == 2) goto L7;
        return true;
    L7:
        return filterBalloonMenuViewByText(r2, r3, landscapeUnsupportedBalloonItemTextResIds);
    }
}

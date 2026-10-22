package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = null;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = null;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object r4, String r5) {
            this.mRealOwner = r4;
            Class<?> r6 = r4.getClass();
            this.mMethod = r6.getMethod(r5, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r0 = new InflateException("Couldn't resolve menu item onClick handler " + r5 + " in class " + r6.getName());
            r0.initCause(e);
            throw r0;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r6) {
            MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.memorydata.plugin");
        L9:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L6;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r7});     // Catch: Exception -> L9
            return true;
        L6:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.mMethod.invoke(this.mRealOwner, new Object[]{r7}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }
    }

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList;
        private PorterDuff.Mode itemIconTintMode;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;
        final /* synthetic */ SupportMenuInflater this$0;

        public MenuState(SupportMenuInflater r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r5;
            resetGroup();
        }

        private char getShortcut(String r1) {
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.charAt(0);
        }

        private <T> T newInstance(String r2, Class<?>[] r3, Object[] r4) {
            Constructor<?> r1 = Class.forName(r2, false, this.this$0.mContext.getClassLoader()).getConstructor(r3);     // Catch: Exception -> L5
            r1.setAccessible(true);     // Catch: Exception -> L5
            return (T) r1.newInstance(r4);
        L5:
            e = move-exception;
            Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + r2, e);
            return null;
        }

        private void setItem(MenuItem r7) {
            MenuItem r8 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r7, MenuItem.class, "com.obric.memorydata.plugin");
            MenuItem r0 = r8.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r3 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r2 = true;
        L6:
            r0.setCheckable(r2).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r1 = this.itemShowAsAction;
            if (r1 < 0) goto L10;
            r8.setShowAsAction(r1);
        L10:
            if (this.itemListenerMethodName == null) goto L17;
            if (this.this$0.mContext.isRestricted() == true) goto L15;
            r8.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.itemCheckable >= 2) goto L19;
        L24:
            String r4 = this.itemActionViewClassName;
            if (r4 == null) goto L27;
            r8.setActionView((View) ZeusTransformUtils.preCheckCast(newInstance(r4, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments), View.class, "com.obric.memorydata.plugin"));
            r3 = true;
        L27:
            int r5 = this.itemActionViewLayout;
            if (r5 <= 0) goto L32;
            if (r3 == true) goto L31;
            r8.setActionView(r5);
            goto L32
        L31:
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            ActionProvider r6 = this.itemActionProvider;
            if (r6 == null) goto L35;
            MenuItemCompat.setActionProvider(r8, r6);
        L35:
            MenuItemCompat.setContentDescription(r8, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r8, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r8, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r8, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r9 = this.itemIconTintMode;
            if (r9 == null) goto L38;
            MenuItemCompat.setIconTintMode(r8, r9);
        L38:
            ColorStateList r10 = this.itemIconTintList;
            if (r10 == null) goto L42;
            MenuItemCompat.setIconTintList(r8, r10);
            return;
        L42:
            return;
        L19:
            if (ZeusTransformUtils.instanceOf(r8, MenuItemImpl.class) == false) goto L22;
            ((MenuItemImpl) ZeusTransformUtils.preCheckCast(r8, MenuItemImpl.class, "com.obric.memorydata.plugin")).setExclusiveCheckable(true);
            goto L24
        L22:
            if (ZeusTransformUtils.instanceOf(r8, MenuItemWrapperICS.class) == false) goto L24;
            ((MenuItemWrapperICS) ZeusTransformUtils.preCheckCast(r8, MenuItemWrapperICS.class, "com.obric.memorydata.plugin")).setExclusiveCheckable(true);
            goto L24
        L5:
            r2 = false;
            goto L6
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r0 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r0.getItem());
            return r0;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet r5) {
            AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
            TypedArray r7 = this.this$0.mContext.obtainStyledAttributes(r6, R.styleable.MenuGroup);
            this.groupId = r7.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_id, "styleable", "MenuGroup_android_id"), 0);
            this.groupCategory = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_menuCategory, "styleable", "MenuGroup_android_menuCategory"), 0);
            this.groupOrder = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_orderInCategory, "styleable", "MenuGroup_android_orderInCategory"), 0);
            this.groupCheckable = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_checkableBehavior, "styleable", "MenuGroup_android_checkableBehavior"), 0);
            this.groupVisible = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_visible, "styleable", "MenuGroup_android_visible"), true);
            this.groupEnabled = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuGroup_android_enabled, "styleable", "MenuGroup_android_enabled"), true);
            r7.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readItem(AttributeSet r9) {
            TintTypedArray r10 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.MenuItem);
            this.itemId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_id, "styleable", "MenuItem_android_id"), 0);
            this.itemCategoryOrder = (r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_menuCategory, "styleable", "MenuItem_android_menuCategory"), this.groupCategory) & (-65536)) | (r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_orderInCategory, "styleable", "MenuItem_android_orderInCategory"), this.groupOrder) & 65535);
            this.itemTitle = r10.getText(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_title, "styleable", "MenuItem_android_title"));
            this.itemTitleCondensed = r10.getText(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_titleCondensed, "styleable", "MenuItem_android_titleCondensed"));
            this.itemIconResId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_icon, "styleable", "MenuItem_android_icon"), 0);
            this.itemAlphabeticShortcut = getShortcut(r10.getString(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_alphabeticShortcut, "styleable", "MenuItem_android_alphabeticShortcut")));
            this.itemAlphabeticModifiers = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_alphabeticModifiers, "styleable", "MenuItem_alphabeticModifiers"), 4096);
            this.itemNumericShortcut = getShortcut(r10.getString(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_numericShortcut, "styleable", "MenuItem_android_numericShortcut")));
            this.itemNumericModifiers = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_numericModifiers, "styleable", "MenuItem_numericModifiers"), 4096);
            if (r10.hasValue(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checkable, "styleable", "MenuItem_android_checkable")) == false) goto L5;
            int r0 = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checkable, "styleable", "MenuItem_android_checkable"), false);
        L6:
            this.itemCheckable = r0;
            this.itemChecked = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_checked, "styleable", "MenuItem_android_checked"), false);
            this.itemVisible = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_visible, "styleable", "MenuItem_android_visible"), this.groupVisible);
            this.itemEnabled = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_enabled, "styleable", "MenuItem_android_enabled"), this.groupEnabled);
            this.itemShowAsAction = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_showAsAction, "styleable", "MenuItem_showAsAction"), -1);
            this.itemListenerMethodName = r10.getString(ZeusTransformUtils.mapRes(R.styleable.MenuItem_android_onClick, "styleable", "MenuItem_android_onClick"));
            this.itemActionViewLayout = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionLayout, "styleable", "MenuItem_actionLayout"), 0);
            this.itemActionViewClassName = r10.getString(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionViewClass, "styleable", "MenuItem_actionViewClass"));
            String r1 = r10.getString(ZeusTransformUtils.mapRes(R.styleable.MenuItem_actionProviderClass, "styleable", "MenuItem_actionProviderClass"));
            this.itemActionProviderClassName = r1;
            if (r1 == null) goto L9;
            boolean r5 = true;
        L11:
            if (r5 == true) goto L13;
        L17:
            if (r5 == false) goto L19;
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.itemActionProvider = null;
        L20:
            this.itemContentDescription = r10.getText(ZeusTransformUtils.mapRes(R.styleable.MenuItem_contentDescription, "styleable", "MenuItem_contentDescription"));
            this.itemTooltipText = r10.getText(ZeusTransformUtils.mapRes(R.styleable.MenuItem_tooltipText, "styleable", "MenuItem_tooltipText"));
            if (r10.hasValue(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTintMode, "styleable", "MenuItem_iconTintMode")) == false) goto L23;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r10.getInt(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTintMode, "styleable", "MenuItem_iconTintMode"), -1), this.itemIconTintMode);
        L25:
            if (r10.hasValue(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTint, "styleable", "MenuItem_iconTint")) == false) goto L27;
            this.itemIconTintList = r10.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.MenuItem_iconTint, "styleable", "MenuItem_iconTint"));
        L28:
            r10.recycle();
            this.itemAdded = false;
            return;
        L27:
            this.itemIconTintList = null;
            goto L28
        L23:
            this.itemIconTintMode = null;
            goto L25
        L13:
            if (this.itemActionViewLayout != 0) goto L17;
            if (this.itemActionViewClassName != null) goto L17;
            this.itemActionProvider = (ActionProvider) ZeusTransformUtils.preCheckCast(newInstance(r1, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments), ActionProvider.class, "com.obric.memorydata.plugin");
            goto L20
        L9:
            r5 = false;
            goto L11
        L5:
            r0 = this.groupCheckable;
            goto L6
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }
    }

    static {
        Class<?>[] r0 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r0;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r0;
    }

    public SupportMenuInflater(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r4);
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        Object[] r0 = {r4};
        this.mActionViewConstructorArguments = r0;
        this.mActionProviderConstructorArguments = r0;
    }

    private Object findRealOwner(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L6;
        return r3;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == true) goto L8;
        return r3;
    L8:
        return findRealOwner((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) {
        XmlPullParser r16 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r13, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        MenuState r0 = new MenuState(this, (Menu) ZeusTransformUtils.wrapperContextForParams(r15, Menu.class, "com.obric.memorydata.plugin"));
        int r18 = r16.getEventType();
    L4:
        if (r18 == 2) goto L5;
        r18 = r16.next();
        if (r18 != 1) goto L4;
    L12:
        String r8 = null;
        boolean r6 = false;
        boolean r7 = false;
    L13:
        if (r6 == true) goto L56;
        if (r18 == 1) goto L55;
        if (r18 != 2) goto L18;
        if (r7 == true) goto L53;
        String r19 = r16.getName();
        if (r19.equals(XML_GROUP) == false) goto L47;
        r0.readGroup(r17);
        goto L53
    L47:
        if (r19.equals(XML_ITEM) == false) goto L50;
        r0.readItem(r17);
        goto L53
    L50:
        if (r19.equals(XML_MENU) == false) goto L52;
        parseMenu(r16, r17, r0.addSubMenuItem());
        goto L53
    L52:
        r8 = r19;
        r7 = true;
    L53:
        r18 = r16.next();
        goto L13
    L18:
        if (r18 != 3) goto L53;
        String r110 = r16.getName();
        if (r7 == false) goto L26;
        if (r110.equals(r8) == false) goto L26;
        r8 = null;
        r7 = false;
    L26:
        if (r110.equals(XML_GROUP) == false) goto L29;
        r0.resetGroup();
        goto L53
    L29:
        if (r110.equals(XML_ITEM) == false) goto L39;
        if (r0.hasAddedItem() == true) goto L53;
        if (r0.itemActionProvider != null) goto L35;
    L37:
        r0.addItem();
        goto L53
    L35:
        if (r0.itemActionProvider.hasSubMenu() == false) goto L37;
        r0.addSubMenuItem();
        goto L53
    L39:
        if (r110.equals(XML_MENU) == false) goto L53;
        r6 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r111 = r16.getName();
        if (r111.equals(XML_MENU) == false) goto L9;
        r18 = r16.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got " + r111);
    }

    Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    @Override // android.view.MenuInflater
    public void inflate(int r5, Menu r6) {
        Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r6, Menu.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, SupportMenu.class) == true) goto L6;
        super.inflate(r5, r7);
        return;
    L6:
        XmlResourceParser r1 = null;
        r1 = ZeusTransformUtils.getResources(this.mContext, "com.obric.memorydata.plugin").getLayout(r5);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        parseMenu(r1, Xml.asAttributeSet(r1), r7);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        if (r1 == null) goto L24;
        r1.close();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        if (r1 == null) goto L21;
        r1.close();
    L21:
        throw th;
    L16:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }
}

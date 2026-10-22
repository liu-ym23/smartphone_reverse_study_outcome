package androidx.appcompat.view;

import ai.j0;
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
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object r5, String r10) {
            this.mRealOwner = r5;
            Class<?> r11 = r5.getClass();
            this.mMethod = r11.getMethod(r10, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            StringBuilder r12 = j0.x("Couldn't resolve menu item onClick handler ", r10, " in class ");
            r12.append(r11.getName());
            InflateException r13 = new InflateException(r12.toString());
            r13.initCause(e);
            throw r13;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r5) {
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L5;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r5});     // Catch: Exception -> L6
            return true;
        L5:
            return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{r5})).booleanValue();
        }
    }

    public class MenuState {
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

        public MenuState(SupportMenuInflater r5, Menu r10) {
            this.this$0 = r5;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r10;
            resetGroup();
        }

        private char getShortcut(String r5) {
            if (r5 != null) goto L6;
            return 0;
        L6:
            return r5.charAt(0);
        }

        private <T> T newInstance(String r5, Class<?>[] r10, Object[] r11) {
            Constructor<?> r12 = Class.forName(r5, false, this.this$0.mContext.getClassLoader()).getConstructor(r10);     // Catch: Exception -> L4
            r12.setAccessible(true);     // Catch: Exception -> L4
            return (T) r12.newInstance(r11);
        L4:
            e = move-exception;
            Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + r5, e);
            return null;
        }

        private void setItem(MenuItem r10) {
            MenuItem r5 = r10.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r11 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r12 = true;
        L6:
            r5.setCheckable(r12).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r13 = this.itemShowAsAction;
            if (r13 < 0) goto L10;
            r10.setShowAsAction(r13);
        L10:
            if (this.itemListenerMethodName == null) goto L17;
            if (this.this$0.mContext.isRestricted() == true) goto L15;
            r10.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
            goto L17
        L15:
            throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
        L17:
            if (this.itemCheckable >= 2) goto L19;
        L24:
            String r14 = this.itemActionViewClassName;
            if (r14 == null) goto L27;
            r10.setActionView((View) newInstance(r14, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            r11 = true;
        L27:
            int r15 = this.itemActionViewLayout;
            if (r15 <= 0) goto L32;
            if (r11 == true) goto L31;
            r10.setActionView(r15);
            goto L32
        L31:
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            ActionProvider r16 = this.itemActionProvider;
            if (r16 == null) goto L35;
            MenuItemCompat.setActionProvider(r10, r16);
        L35:
            MenuItemCompat.setContentDescription(r10, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r10, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r10, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r10, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r17 = this.itemIconTintMode;
            if (r17 == null) goto L38;
            MenuItemCompat.setIconTintMode(r10, r17);
        L38:
            ColorStateList r18 = this.itemIconTintList;
            if (r18 == null) goto L42;
            MenuItemCompat.setIconTintList(r10, r18);
            return;
        L42:
            return;
        L19:
            if ((r10 instanceof MenuItemImpl) == false) goto L22;
            ((MenuItemImpl) r10).setExclusiveCheckable(true);
            goto L24
        L22:
            if ((r10 instanceof MenuItemWrapperICS) == false) goto L24;
            ((MenuItemWrapperICS) r10).setExclusiveCheckable(true);
            goto L24
        L5:
            r12 = false;
            goto L6
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r5 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r5.getItem());
            return r5;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet r5) {
            TypedArray r10 = this.this$0.mContext.obtainStyledAttributes(r5, R.styleable.MenuGroup);
            this.groupId = r10.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = r10.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = r10.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = r10.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = r10.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = r10.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            r10.recycle();
        }

        public void readItem(AttributeSet r10) {
            TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, r10, R.styleable.MenuItem);
            this.itemId = r11.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (r11.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & SupportMenu.CATEGORY_MASK) | (r11.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 65535);
            this.itemTitle = r11.getText(R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = r11.getText(R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = r11.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(r11.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = r11.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(r11.getString(R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = r11.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (r11.hasValue(R.styleable.MenuItem_android_checkable) == false) goto L5;
            this.itemCheckable = r11.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
        L6:
            this.itemChecked = r11.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.itemVisible = r11.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = r11.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = r11.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = r11.getString(R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = r11.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = r11.getString(R.styleable.MenuItem_actionViewClass);
            String r5 = r11.getString(R.styleable.MenuItem_actionProviderClass);
            this.itemActionProviderClassName = r5;
            if (r5 == null) goto L9;
            boolean r12 = true;
        L11:
            if (r12 == true) goto L13;
        L17:
            if (r12 == false) goto L19;
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.itemActionProvider = null;
        L20:
            this.itemContentDescription = r11.getText(R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = r11.getText(R.styleable.MenuItem_tooltipText);
            if (r11.hasValue(R.styleable.MenuItem_iconTintMode) == false) goto L23;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r11.getInt(R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
        L25:
            if (r11.hasValue(R.styleable.MenuItem_iconTint) == false) goto L27;
            this.itemIconTintList = r11.getColorStateList(R.styleable.MenuItem_iconTint);
        L28:
            r11.recycle();
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
            this.itemActionProvider = (ActionProvider) newInstance(r5, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
            goto L20
        L9:
            r12 = false;
            goto L11
        L5:
            this.itemCheckable = this.groupCheckable;
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
        Class<?>[] r5 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r5;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r5;
    }

    public SupportMenuInflater(Context r5) {
        super(r5);
        this.mContext = r5;
        Object[] r10 = {r5};
        this.mActionViewConstructorArguments = r10;
        this.mActionProviderConstructorArguments = r10;
    }

    private Object findRealOwner(Object r5) {
        if ((r5 instanceof Activity) == false) goto L6;
        return r5;
    L6:
        if ((r5 instanceof ContextWrapper) == true) goto L8;
        return r5;
    L8:
        return findRealOwner(((ContextWrapper) r5).getBaseContext());
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) throws XmlPullParserException, IOException {
        MenuState r5 = new MenuState(this, r15);
        int r16 = r13.getEventType();
    L4:
        if (r16 == 2) goto L5;
        r16 = r13.next();
        if (r16 != 1) goto L4;
    L12:
        boolean r10 = false;
        boolean r11 = false;
        String r12 = null;
    L13:
        if (r10 == true) goto L56;
        if (r16 == 1) goto L55;
        if (r16 != 2) goto L18;
        if (r11 == true) goto L53;
        String r17 = r13.getName();
        if (r17.equals(XML_GROUP) == false) goto L47;
        r5.readGroup(r14);
        goto L53
    L47:
        if (r17.equals(XML_ITEM) == false) goto L50;
        r5.readItem(r14);
        goto L53
    L50:
        if (r17.equals(XML_MENU) == false) goto L52;
        parseMenu(r13, r14, r5.addSubMenuItem());
        goto L53
    L52:
        r12 = r17;
        r11 = true;
    L53:
        r16 = r13.next();
        goto L13
    L18:
        if (r16 != 3) goto L53;
        String r18 = r13.getName();
        if (r11 == false) goto L26;
        if (r18.equals(r12) == false) goto L26;
        r11 = false;
        r12 = null;
    L26:
        if (r18.equals(XML_GROUP) == false) goto L29;
        r5.resetGroup();
        goto L53
    L29:
        if (r18.equals(XML_ITEM) == false) goto L39;
        if (r5.hasAddedItem() == true) goto L53;
        ActionProvider r19 = r5.itemActionProvider;
        if (r19 != null) goto L35;
    L37:
        r5.addItem();
        goto L53
    L35:
        if (r19.hasSubMenu() == false) goto L37;
        r5.addSubMenuItem();
        goto L53
    L39:
        if (r18.equals(XML_MENU) == false) goto L53;
        r10 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r110 = r13.getName();
        if (r110.equals(XML_MENU) == false) goto L9;
        r16 = r13.next();
        goto L12
    L9:
        throw new RuntimeException("Expecting menu, got ".concat(r110));
    }

    public Object getRealOwner() {
        if (this.mRealOwner != null) goto L6;
        this.mRealOwner = findRealOwner(this.mContext);
    L6:
        return this.mRealOwner;
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int r5, Menu r10) {
        if ((r10 instanceof SupportMenu) == true) goto L6;
        super.inflate(r5, r10);
        return;
    L6:
        XmlResourceParser r11 = null;
        r11 = this.mContext.getResources().getLayout(r5);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        parseMenu(r11, Xml.asAttributeSet(r11), r10);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L15
        if (r11 == null) goto L26;
        r11.close();
        return;
    L26:
        return;
    L11:
        th = move-exception;
        if (r11 == null) goto L23;
        r11.close();
    L23:
        throw th;
    L13:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        throw new InflateException("Error inflating menu XML", e);     // Catch: Throwable -> L11
    }
}

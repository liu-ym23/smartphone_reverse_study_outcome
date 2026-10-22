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

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = null;
        private Method mMethod;
        private Object mRealOwner;

        static {
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object r10, String r11) {
            this.mRealOwner = r10;
            Class<?> r12 = r10.getClass();
            this.mMethod = r12.getMethod(r11, PARAM_TYPES);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            InflateException r13 = new InflateException("Couldn't resolve menu item onClick handler " + r11 + " in class " + r12.getName());
            r13.initCause(e);
            throw r13;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
        L8:
            e = move-exception;
            throw new RuntimeException(e);
        L3:
            if (this.mMethod.getReturnType() == Boolean.TYPE) goto L5;
            this.mMethod.invoke(this.mRealOwner, new Object[]{r10});     // Catch: Exception -> L8
            return true;
        L5:
            return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{r10})).booleanValue();
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

        public MenuState(SupportMenuInflater r10, Menu r11) {
            this.this$0 = r10;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = r11;
            resetGroup();
        }

        private char getShortcut(String r10) {
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.charAt(0);
        }

        private <T> T newInstance(String r10, Class<?>[] r11, Object[] r12) {
            Constructor<?> r13 = Class.forName(r10, false, this.this$0.mContext.getClassLoader()).getConstructor(r11);     // Catch: Exception -> L5
            r13.setAccessible(true);     // Catch: Exception -> L5
            return (T) r13.newInstance(r12);
        L5:
            e = move-exception;
            Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + r10, e);
            return null;
        }

        private void setItem(MenuItem r10) {
            MenuItem r11 = r10.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
            boolean r12 = false;
            if (this.itemCheckable < 1) goto L5;
            boolean r13 = true;
        L6:
            r11.setCheckable(r13).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int r14 = this.itemShowAsAction;
            if (r14 < 0) goto L10;
            r10.setShowAsAction(r14);
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
            String r15 = this.itemActionViewClassName;
            if (r15 == null) goto L27;
            r10.setActionView((View) newInstance(r15, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            r12 = true;
        L27:
            int r16 = this.itemActionViewLayout;
            if (r16 <= 0) goto L32;
            if (r12 == true) goto L31;
            r10.setActionView(r16);
            goto L32
        L31:
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
        L32:
            ActionProvider r17 = this.itemActionProvider;
            if (r17 == null) goto L35;
            MenuItemCompat.setActionProvider(r10, r17);
        L35:
            MenuItemCompat.setContentDescription(r10, this.itemContentDescription);
            MenuItemCompat.setTooltipText(r10, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(r10, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(r10, this.itemNumericShortcut, this.itemNumericModifiers);
            PorterDuff.Mode r18 = this.itemIconTintMode;
            if (r18 == null) goto L38;
            MenuItemCompat.setIconTintMode(r10, r18);
        L38:
            ColorStateList r19 = this.itemIconTintList;
            if (r19 == null) goto L42;
            MenuItemCompat.setIconTintList(r10, r19);
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
            r13 = false;
            goto L6
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu r10 = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(r10.getItem());
            return r10;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet r10) {
            TypedArray r11 = this.this$0.mContext.obtainStyledAttributes(r10, R.styleable.MenuGroup);
            this.groupId = r11.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = r11.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = r11.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = r11.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = r11.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = r11.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            r11.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readItem(AttributeSet r10) {
            TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, r10, R.styleable.MenuItem);
            this.itemId = r11.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (r11.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & (-65536)) | (r11.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & SupportMenu.USER_MASK);
            this.itemTitle = r11.getText(R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = r11.getText(R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = r11.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(r11.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = r11.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(r11.getString(R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = r11.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            int r12 = R.styleable.MenuItem_android_checkable;
            if (r11.hasValue(r12) == false) goto L5;
            int r13 = r11.getBoolean(r12, false);
        L6:
            this.itemCheckable = r13;
            this.itemChecked = r11.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.itemVisible = r11.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = r11.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = r11.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = r11.getString(R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = r11.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = r11.getString(R.styleable.MenuItem_actionViewClass);
            String r14 = r11.getString(R.styleable.MenuItem_actionProviderClass);
            this.itemActionProviderClassName = r14;
            if (r14 == null) goto L9;
            boolean r15 = true;
        L11:
            if (r15 == true) goto L13;
        L17:
            if (r15 == false) goto L19;
            Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        L19:
            this.itemActionProvider = null;
        L20:
            this.itemContentDescription = r11.getText(R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = r11.getText(R.styleable.MenuItem_tooltipText);
            int r16 = R.styleable.MenuItem_iconTintMode;
            if (r11.hasValue(r16) == false) goto L23;
            this.itemIconTintMode = DrawableUtils.parseTintMode(r11.getInt(r16, -1), this.itemIconTintMode);
        L24:
            int r17 = R.styleable.MenuItem_iconTint;
            if (r11.hasValue(r17) == false) goto L27;
            this.itemIconTintList = r11.getColorStateList(r17);
        L28:
            r11.recycle();
            this.itemAdded = false;
            return;
        L27:
            this.itemIconTintList = null;
            goto L28
        L23:
            this.itemIconTintMode = null;
            goto L24
        L13:
            if (this.itemActionViewLayout != 0) goto L17;
            if (this.itemActionViewClassName != null) goto L17;
            this.itemActionProvider = (ActionProvider) newInstance(r14, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
            goto L20
        L9:
            r15 = false;
            goto L11
        L5:
            r13 = this.groupCheckable;
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
        Class<?>[] r10 = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r10;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r10;
    }

    public SupportMenuInflater(Context r10) {
        super(r10);
        this.mContext = r10;
        Object[] r11 = {r10};
        this.mActionViewConstructorArguments = r11;
        this.mActionProviderConstructorArguments = r11;
    }

    private Object findRealOwner(Object r10) {
        if ((r10 instanceof Activity) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof ContextWrapper) == true) goto L8;
        return r10;
    L8:
        return findRealOwner(((ContextWrapper) r10).getBaseContext());
    }

    private void parseMenu(XmlPullParser r13, AttributeSet r14, Menu r15) {
        MenuState r10 = new MenuState(this, r15);
        int r16 = r13.getEventType();
    L4:
        if (r16 == 2) goto L5;
        r16 = r13.next();
        if (r16 != 1) goto L4;
    L12:
        String r11 = null;
        boolean r12 = false;
        boolean r17 = false;
    L13:
        if (r12 == true) goto L56;
        if (r16 == 1) goto L55;
        if (r16 != 2) goto L18;
        if (r17 == true) goto L53;
        String r18 = r13.getName();
        if (r18.equals(XML_GROUP) == false) goto L47;
        r10.readGroup(r14);
        goto L53
    L47:
        if (r18.equals(XML_ITEM) == false) goto L50;
        r10.readItem(r14);
        goto L53
    L50:
        if (r18.equals(XML_MENU) == false) goto L52;
        parseMenu(r13, r14, r10.addSubMenuItem());
        goto L53
    L52:
        r11 = r18;
        r17 = true;
    L53:
        r16 = r13.next();
        goto L13
    L18:
        if (r16 != 3) goto L53;
        String r19 = r13.getName();
        if (r17 == false) goto L26;
        if (r19.equals(r11) == false) goto L26;
        r11 = null;
        r17 = false;
    L26:
        if (r19.equals(XML_GROUP) == false) goto L29;
        r10.resetGroup();
        goto L53
    L29:
        if (r19.equals(XML_ITEM) == false) goto L39;
        if (r10.hasAddedItem() == true) goto L53;
        ActionProvider r110 = r10.itemActionProvider;
        if (r110 != null) goto L35;
    L37:
        r10.addItem();
        goto L53
    L35:
        if (r110.hasSubMenu() == false) goto L37;
        r10.addSubMenuItem();
        goto L53
    L39:
        if (r19.equals(XML_MENU) == false) goto L53;
        r12 = true;
        goto L53
    L55:
        throw new RuntimeException("Unexpected end of document");
    L56:
        return;
    L5:
        String r111 = r13.getName();
        if (r111.equals(XML_MENU) == false) goto L9;
        r16 = r13.next();
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
    public void inflate(@LayoutRes int r10, Menu r11) {
        if ((r11 instanceof SupportMenu) == true) goto L6;
        super.inflate(r10, r11);
        return;
    L6:
        XmlResourceParser r12 = null;
        r12 = this.mContext.getResources().getLayout(r10);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        parseMenu(r12, Xml.asAttributeSet(r12), r11);     // Catch: Throwable -> L11 IOException -> L13 XmlPullParserException -> L16
        if (r12 == null) goto L24;
        r12.close();
        return;
    L24:
        return;
    L11:
        th = move-exception;
        if (r12 == null) goto L21;
        r12.close();
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
